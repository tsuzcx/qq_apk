package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.msg.api.IMessageHandler;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.Logger;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUploadInfo;
import com.tencent.mobileqq.shortvideo.api.IShortVideoUploadProcessor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.LogTag;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class ShortVideoUploadProcessor
  extends BaseShortVideoUploadProcessor
  implements IShortVideoUploadProcessor
{
  public static final String TAG = "ShortVideoUploadProcessor";
  BaseQQAppInterface app = (BaseQQAppInterface)this.app;
  Boolean isBDHExistBeforeVideoUpload = Boolean.valueOf(false);
  public boolean isBDHSuccess = false;
  public boolean isFromFavorite;
  private volatile boolean mIsCacheDiff = false;
  boolean mIsSecondTransfered = false;
  boolean mNeedSyncStory = false;
  StepInfo mPreUpStepTrans = new StepInfo();
  int mReportBusiType = -1;
  private byte[] mSessionKey;
  private byte[] mSigSession;
  int mSwitch = 1;
  protected int mThumbFileHeight;
  protected String mThumbFilePath;
  protected long mThumbFileSize;
  protected int mThumbFileWidth;
  int mVideoAttr = 0;
  int mVideoKandianType = 0;
  MediaMessageObserver messageObserver = new ShortVideoUploadProcessor.4(this);
  protected int videoTime;
  
  public ShortVideoUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo))) {
      this.mReportBusiType = ((MessageForShortVideo)this.mUiRequest.mRec).busiType;
    } else {
      this.mReportBusiType = 0;
    }
    if (!this.mUiRequest.mIsPresend)
    {
      paramBaseTransFileController = this.mUiRequest.mLocalPath;
      paramTransferRequest = paramBaseTransFileController.split("QQ_&_MoblieQQ_&_QQ");
      if (4 != paramTransferRequest.length)
      {
        if (QLog.isColorLevel())
        {
          paramTransferRequest = new StringBuilder();
          paramTransferRequest.append("path was not set correctlly------path = ");
          paramTransferRequest.append(paramBaseTransFileController);
          QLog.d("ShortVideoUploadProcessor", 2, paramTransferRequest.toString());
        }
        paramTransferRequest = this.mProcessorReport;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("path =");
        localStringBuilder.append(paramBaseTransFileController);
        paramTransferRequest.setError(9304, localStringBuilder.toString(), null, null);
        onError();
        this.mIsCancel = true;
        return;
      }
      this.mUiRequest.mLocalPath = paramTransferRequest[0];
      this.mThumbFilePath = paramTransferRequest[1];
      this.videoTime = Integer.parseInt(paramTransferRequest[2]);
      if (QLog.isColorLevel())
      {
        paramBaseTransFileController = new StringBuilder();
        paramBaseTransFileController.append("Init params videoTime : ");
        paramBaseTransFileController.append(this.videoTime);
        QLog.d("ShortVideoUploadProcessor", 2, paramBaseTransFileController.toString());
      }
      this.thumbFileMd5 = HexUtil.hexStr2Bytes(paramTransferRequest[3]);
    }
  }
  
  private int getFormat(String paramString)
  {
    if ("avi".equals(paramString)) {
      return 2;
    }
    if ("mp4".equals(paramString)) {
      return 3;
    }
    if ("wmv".equals(paramString)) {
      return 4;
    }
    if ("mkv".equals(paramString)) {
      return 5;
    }
    if ("rmvb".equals(paramString)) {
      return 6;
    }
    if ("rm".equals(paramString)) {
      return 7;
    }
    if ("afs".equals(paramString)) {
      return 8;
    }
    if ("mov".equals(paramString)) {
      return 9;
    }
    if ("mod".equals(paramString)) {
      return 10;
    }
    if ("ts".equals(paramString)) {
      return 1;
    }
    if ("mts".equals(paramString)) {
      return 11;
    }
    return -1;
  }
  
  private void handleHotVideoRichText(videoFile.ResvAttr paramResvAttr, MessageForShortVideo paramMessageForShortVideo, im_msg_body.VideoFile paramVideoFile)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "constructRichText MessageForHotVideo ");
    }
    paramResvAttr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoIconUrl));
    paramResvAttr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoTitle));
    paramResvAttr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoUrl));
    paramResvAttr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoSubIconUrl));
    paramResvAttr.uint32_special_video_type.set(paramMessageForShortVideo.specialVideoType);
    if (this.mUuid != null) {
      paramVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mUuid));
    } else if (paramMessageForShortVideo.uuid != null) {
      paramVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.uuid));
    }
    if ((this.mMd5Str != null) && (this.mMd5Str.length() > 0))
    {
      paramVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.mMd5Str)));
      if ((paramMessageForShortVideo.md5 == null) || (paramMessageForShortVideo.md5.length() == 0)) {
        paramMessageForShortVideo.md5 = this.mMd5Str;
      }
    }
    else if (paramMessageForShortVideo.md5 != null)
    {
      paramVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(paramMessageForShortVideo.md5)));
    }
    setThumbInfoForHotVideo(paramMessageForShortVideo);
    if ((paramMessageForShortVideo.videoFileName == null) || (paramMessageForShortVideo.videoFileName.length() == 0))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      if (this.mMd5Str == null) {
        paramResvAttr = "HotVideo";
      } else {
        paramResvAttr = this.mMd5Str;
      }
      localStringBuilder.append(paramResvAttr);
      localStringBuilder.append(".mp4");
      paramMessageForShortVideo.videoFileName = localStringBuilder.toString();
    }
    paramVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.videoFileName));
  }
  
  private void setThumbInfoForHotVideo(MessageForShortVideo paramMessageForShortVideo)
  {
    if ((this.mThumbFileSize == 0L) && (paramMessageForShortVideo.thumbFileSize != 0)) {
      this.mThumbFileSize = paramMessageForShortVideo.thumbFileSize;
    }
    if ((this.mFileSize == 0L) && (paramMessageForShortVideo.videoFileSize != 0)) {
      this.mFileSize = (paramMessageForShortVideo.videoFileSize + this.mThumbFileSize);
    }
    if ((this.mThumbFileWidth == 0) && (paramMessageForShortVideo.thumbWidth != 0)) {
      this.mThumbFileWidth = paramMessageForShortVideo.thumbWidth;
    }
    if ((this.mThumbFileHeight == 0) && (paramMessageForShortVideo.thumbHeight != 0)) {
      this.mThumbFileHeight = paramMessageForShortVideo.thumbHeight;
    }
  }
  
  private void setVideoSource(MessageForShortVideo paramMessageForShortVideo, videoFile.ResvAttr paramResvAttr)
  {
    int i;
    if (this.isFromFavorite)
    {
      i = 7;
      paramMessageForShortVideo = "favorite";
    }
    else if (paramMessageForShortVideo.busiType == 0)
    {
      paramMessageForShortVideo = "gallery";
      i = 2;
    }
    else if (paramMessageForShortVideo.busiType == 1)
    {
      paramMessageForShortVideo = "aio camera";
      i = 1;
    }
    else
    {
      i = 6;
      paramMessageForShortVideo = "unknown";
    }
    paramResvAttr.uint32_source.set(2);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, new Object[] { "videoSource report: ", Integer.valueOf(i), ", from ", paramMessageForShortVideo });
    }
  }
  
  public byte[] buildExtendInfo(RichProto.RichProtoReq.ShortVideoUpReq paramShortVideoUpReq)
  {
    PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
    localPttShortVideoUploadReq.setHasFlag(true);
    localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(paramShortVideoUpReq.selfUin));
    localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(paramShortVideoUpReq.peerUin));
    localPttShortVideoUploadReq.uint32_chat_type.set(paramShortVideoUpReq.chatType);
    localPttShortVideoUploadReq.uint32_client_type.set(paramShortVideoUpReq.clientType);
    if (paramShortVideoUpReq.troopUin != null) {
      localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(paramShortVideoUpReq.troopUin));
    } else {
      localPttShortVideoUploadReq.uint64_group_code.set(0L);
    }
    localPttShortVideoUploadReq.uint32_agent_type.set(paramShortVideoUpReq.agentType);
    localPttShortVideoUploadReq.uint32_business_type.set(paramShortVideoUpReq.busiType);
    localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
    PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
    localPttShortVideoFileInfo.str_file_name.set(paramShortVideoUpReq.fileName);
    localPttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(paramShortVideoUpReq.md5));
    localPttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(paramShortVideoUpReq.thumbFileMd5));
    localPttShortVideoFileInfo.uint64_file_size.set(paramShortVideoUpReq.fileSize);
    localPttShortVideoFileInfo.uint32_file_res_length.set(paramShortVideoUpReq.fileResLength);
    localPttShortVideoFileInfo.uint32_file_res_width.set(paramShortVideoUpReq.fileResWidth);
    localPttShortVideoFileInfo.uint32_file_format.set(paramShortVideoUpReq.format);
    localPttShortVideoFileInfo.uint32_file_time.set(paramShortVideoUpReq.fileTime);
    localPttShortVideoFileInfo.uint64_thumb_file_size.set(paramShortVideoUpReq.thumbFileSize);
    localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(localPttShortVideoFileInfo);
    return localPttShortVideoUploadReq.toByteArray();
  }
  
  /* Error */
  public boolean buildThumbInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 181	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:thumbFileMd5	[B
    //   4: ifnonnull +195 -> 199
    //   7: new 495	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 159	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFilePath	Ljava/lang/String;
    //   15: invokespecial 497	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: lconst_0
    //   24: invokestatic 503	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   27: putfield 181	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:thumbFileMd5	[B
    //   30: aload_2
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 181	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:thumbFileMd5	[B
    //   36: ifnonnull +79 -> 115
    //   39: aload_2
    //   40: astore_1
    //   41: aload_0
    //   42: getfield 143	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mProcessorReport	Lcom/tencent/mobileqq/transfile/report/ProcessorReport;
    //   45: astore_3
    //   46: aload_2
    //   47: astore_1
    //   48: new 124	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 125	java/lang/StringBuilder:<init>	()V
    //   55: astore 4
    //   57: aload_2
    //   58: astore_1
    //   59: aload 4
    //   61: ldc_w 505
    //   64: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   67: pop
    //   68: aload_2
    //   69: astore_1
    //   70: aload 4
    //   72: aload_0
    //   73: getfield 159	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFilePath	Ljava/lang/String;
    //   76: invokevirtual 131	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_2
    //   81: astore_1
    //   82: aload_3
    //   83: sipush 9041
    //   86: aload 4
    //   88: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   91: aconst_null
    //   92: aconst_null
    //   93: invokevirtual 151	com/tencent/mobileqq/transfile/report/ProcessorReport:setError	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/StepInfo;)V
    //   96: aload_2
    //   97: astore_1
    //   98: aload_0
    //   99: invokevirtual 154	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:onError	()V
    //   102: aload_2
    //   103: invokevirtual 508	java/io/FileInputStream:close	()V
    //   106: iconst_0
    //   107: ireturn
    //   108: astore_1
    //   109: aload_1
    //   110: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   113: iconst_0
    //   114: ireturn
    //   115: aload_2
    //   116: invokevirtual 508	java/io/FileInputStream:close	()V
    //   119: goto +80 -> 199
    //   122: astore_1
    //   123: aload_1
    //   124: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   127: goto +72 -> 199
    //   130: astore_3
    //   131: goto +12 -> 143
    //   134: astore_2
    //   135: aconst_null
    //   136: astore_1
    //   137: goto +44 -> 181
    //   140: astore_3
    //   141: aconst_null
    //   142: astore_2
    //   143: aload_2
    //   144: astore_1
    //   145: aload_0
    //   146: aconst_null
    //   147: putfield 181	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:thumbFileMd5	[B
    //   150: aload_2
    //   151: astore_1
    //   152: aload_0
    //   153: aload_3
    //   154: invokevirtual 515	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:analysisIOProblem	(Ljava/io/IOException;)V
    //   157: aload_2
    //   158: astore_1
    //   159: aload_0
    //   160: invokevirtual 154	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:onError	()V
    //   163: aload_2
    //   164: ifnull +14 -> 178
    //   167: aload_2
    //   168: invokevirtual 508	java/io/FileInputStream:close	()V
    //   171: iconst_0
    //   172: ireturn
    //   173: astore_1
    //   174: aload_1
    //   175: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   178: iconst_0
    //   179: ireturn
    //   180: astore_2
    //   181: aload_1
    //   182: ifnull +15 -> 197
    //   185: aload_1
    //   186: invokevirtual 508	java/io/FileInputStream:close	()V
    //   189: goto +8 -> 197
    //   192: astore_1
    //   193: aload_1
    //   194: invokevirtual 511	java/io/IOException:printStackTrace	()V
    //   197: aload_2
    //   198: athrow
    //   199: aload_0
    //   200: getfield 519	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbRaf	Ljava/io/RandomAccessFile;
    //   203: ifnonnull +62 -> 265
    //   206: aload_0
    //   207: new 521	java/io/RandomAccessFile
    //   210: dup
    //   211: aload_0
    //   212: getfield 159	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFilePath	Ljava/lang/String;
    //   215: ldc_w 523
    //   218: invokespecial 526	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: putfield 519	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbRaf	Ljava/io/RandomAccessFile;
    //   224: goto +13 -> 237
    //   227: astore_1
    //   228: aload_1
    //   229: invokevirtual 527	java/io/FileNotFoundException:printStackTrace	()V
    //   232: aload_0
    //   233: aconst_null
    //   234: putfield 519	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbRaf	Ljava/io/RandomAccessFile;
    //   237: aload_0
    //   238: getfield 519	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbRaf	Ljava/io/RandomAccessFile;
    //   241: ifnonnull +24 -> 265
    //   244: aload_0
    //   245: getfield 143	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mProcessorReport	Lcom/tencent/mobileqq/transfile/report/ProcessorReport;
    //   248: sipush 9303
    //   251: ldc_w 529
    //   254: aconst_null
    //   255: aconst_null
    //   256: invokevirtual 151	com/tencent/mobileqq/transfile/report/ProcessorReport:setError	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/StepInfo;)V
    //   259: aload_0
    //   260: invokevirtual 154	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:onError	()V
    //   263: iconst_0
    //   264: ireturn
    //   265: aload_0
    //   266: new 531	java/io/File
    //   269: dup
    //   270: aload_0
    //   271: getfield 159	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFilePath	Ljava/lang/String;
    //   274: invokespecial 532	java/io/File:<init>	(Ljava/lang/String;)V
    //   277: invokevirtual 535	java/io/File:length	()J
    //   280: putfield 308	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFileSize	J
    //   283: aload_0
    //   284: aload_0
    //   285: getfield 159	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFilePath	Ljava/lang/String;
    //   288: invokevirtual 538	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:getThumbFileSize	(Ljava/lang/String;)V
    //   291: iconst_1
    //   292: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	293	0	this	ShortVideoUploadProcessor
    //   20	78	1	localFileInputStream1	java.io.FileInputStream
    //   108	2	1	localIOException1	java.io.IOException
    //   122	2	1	localIOException2	java.io.IOException
    //   136	23	1	localObject1	Object
    //   173	13	1	localIOException3	java.io.IOException
    //   192	2	1	localIOException4	java.io.IOException
    //   227	2	1	localFileNotFoundException	FileNotFoundException
    //   18	98	2	localFileInputStream2	java.io.FileInputStream
    //   134	1	2	localObject2	Object
    //   142	26	2	localObject3	Object
    //   180	18	2	localObject4	Object
    //   45	38	3	localProcessorReport	ProcessorReport
    //   130	1	3	localIOException5	java.io.IOException
    //   140	14	3	localIOException6	java.io.IOException
    //   55	32	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   102	106	108	java/io/IOException
    //   115	119	122	java/io/IOException
    //   21	30	130	java/io/IOException
    //   32	39	130	java/io/IOException
    //   41	46	130	java/io/IOException
    //   48	57	130	java/io/IOException
    //   59	68	130	java/io/IOException
    //   70	80	130	java/io/IOException
    //   82	96	130	java/io/IOException
    //   98	102	130	java/io/IOException
    //   7	19	134	finally
    //   7	19	140	java/io/IOException
    //   167	171	173	java/io/IOException
    //   21	30	180	finally
    //   32	39	180	finally
    //   41	46	180	finally
    //   48	57	180	finally
    //   59	68	180	finally
    //   70	80	180	finally
    //   82	96	180	finally
    //   98	102	180	finally
    //   145	150	180	finally
    //   152	157	180	finally
    //   159	163	180	finally
    //   185	189	192	java/io/IOException
    //   206	224	227	java/io/FileNotFoundException
  }
  
  public boolean buildVideoMd5()
  {
    if (!TextUtils.isEmpty(this.mUiRequest.mMd5))
    {
      this.mLocalMd5 = HexUtil.hexStr2Bytes(this.mUiRequest.mMd5);
      FileMsg localFileMsg = this.file;
      String str = this.mUiRequest.mMd5;
      localFileMsg.fileMd5 = str;
      this.mMd5Str = str;
    }
    if ((this.mLocalMd5 == null) && (!getMd5()))
    {
      onError();
      return false;
    }
    if (!FileUtils.fileExistsAndNotEmpty(this.mUiRequest.mLocalPath))
    {
      this.mProcessorReport.setError(9042, "video file not exists", null, null);
      onError();
      return false;
    }
    if (this.mRaf == null)
    {
      try
      {
        this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        localFileNotFoundException.printStackTrace();
        this.mRaf = null;
      }
      if (this.mRaf == null)
      {
        this.mProcessorReport.setError(9303, "read video file error", null, null);
        onError();
        return false;
      }
    }
    return true;
  }
  
  public int checkParam()
  {
    if ((this.mUiRequest != null) && (this.mUiRequest.mRec != null) && (((MessageForShortVideo)this.mUiRequest.mRec).busiType == 0)) {
      this.mIsShortVideoSend = true;
    }
    return 0;
  }
  
  im_msg_body.RichText constructRichText()
  {
    for (;;)
    {
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        im_msg_body.VideoFile localVideoFile = new im_msg_body.VideoFile();
        localVideoFile.setHasFlag(true);
        if (this.mResid != null) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
        }
        Object localObject1;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("mResid uuid=");
          ((StringBuilder)localObject1).append(this.mResid);
          QLog.d("ShortVideoUploadProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        if ((this.mUiRequest.mRec instanceof MessageForShortVideo))
        {
          localObject1 = (MessageForShortVideo)this.mUiRequest.mRec;
          if (localObject1 != null)
          {
            localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
            localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
            localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
            localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
            localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
            localVideoFile.uint32_sub_busi_type.set(((MessageForShortVideo)localObject1).subBusiType);
            videoFile.ResvAttr localResvAttr = new videoFile.ResvAttr();
            localResvAttr.uint32_msg_tail_type.set(((MessageForShortVideo)localObject1).msgTailType);
            if ((localObject1 != null) && (((MessageForShortVideo)localObject1).checkIsHotVideo()))
            {
              handleHotVideoRichText(localResvAttr, (MessageForShortVideo)localObject1, localVideoFile);
            }
            else
            {
              if (((MessageForShortVideo)localObject1).checkIsDanceVideo()) {
                localResvAttr.uint32_special_video_type.set(((MessageForShortVideo)localObject1).specialVideoType);
              }
              localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mUiRequest.mLocalPath));
              localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.mUiRequest.mMd5)));
            }
            PBBytesField localPBBytesField = localResvAttr.bytes_camera_templateid;
            localObject3 = ((MessageForShortVideo)localObject1).templateId;
            String str = "";
            if (localObject3 == null) {
              break label629;
            }
            localObject3 = ((MessageForShortVideo)localObject1).templateId;
            localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            localPBBytesField = localResvAttr.bytes_camera_templateName;
            localObject3 = str;
            if (((MessageForShortVideo)localObject1).templateName != null) {
              localObject3 = ((MessageForShortVideo)localObject1).templateName;
            }
            localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            localResvAttr.uint32_long_video_kandian_type.set(this.mVideoKandianType);
            setVideoSource((MessageForShortVideo)localObject1, localResvAttr);
            localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
            localVideoFile.uint32_video_attr.set(this.mVideoAttr);
          }
          localVideoFile.uint32_file_format.set(2);
          localVideoFile.uint32_file_size.set((int)(this.mFileSize - this.mThumbFileSize));
          localVideoFile.uint32_file_time.set(this.videoTime);
          localVideoFile.uint32_thumb_width.set(this.mThumbFileWidth);
          localVideoFile.uint32_thumb_height.set(this.mThumbFileHeight);
          localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.thumbFileMd5));
          localVideoFile.uint32_thumb_file_size.set((int)this.mThumbFileSize);
          localVideoFile.uint32_from_chat_type.set(-1);
          localVideoFile.uint32_to_chat_type.set(-1);
          localObject3 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject3).setHasFlag(true);
          ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.a(2131713969)));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
          localRichText.elems.add((MessageMicro)localObject1);
          localRichText.elems.add((MessageMicro)localObject3);
          return localRichText;
        }
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      Object localObject2 = null;
      continue;
      label629:
      Object localObject3 = "";
    }
  }
  
  public void doOnSendFailed(int paramInt, HashMap<String, String> paramHashMap, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<BDH_LOG> Transaction End : Failed. New : SendTotalCost:");
      localStringBuilder.append(l - paramLong);
      localStringBuilder.append("ms");
      QLog.d("ShortVideoUploadProcessor", 2, localStringBuilder.toString());
    }
    addBDHReportInfo(paramHashMap);
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      this.mIsCacheDiff = true;
    }
    this.mProcessorReport.setError(paramInt, "OnFailed.", "", this.mProcessorReport.mStepTrans);
    if (this.mSwitch == 3)
    {
      paramHashMap = this.mPreUpStepTrans;
      if (paramHashMap != null)
      {
        paramHashMap.logFinishTime();
        this.mPreUpStepTrans.result = 0;
      }
    }
    onError();
  }
  
  public void doOnSendSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, String paramString, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    try
    {
      paramArrayOfByte = (PttShortVideo.PttShortVideoUploadResp)new PttShortVideo.PttShortVideoUploadResp().mergeFrom(paramArrayOfByte);
      if (paramArrayOfByte.str_fileid.has())
      {
        paramArrayOfByte = paramArrayOfByte.str_fileid.get();
        if (paramArrayOfByte.length() > 0)
        {
          this.mResid = paramArrayOfByte;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "set uuid from BDH ");
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUploadProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
      }
    }
    if (QLog.isColorLevel())
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("<BDH_LOG> Transaction End : Success. New : SendTotalCost:");
      paramArrayOfByte.append(l - paramLong);
      paramArrayOfByte.append("ms ,fileSize:");
      paramArrayOfByte.append(this.file.fileSize);
      paramArrayOfByte.append(" transInfo:");
      paramArrayOfByte.append((String)paramHashMap.get("rep_bdhTrans"));
      QLog.d("ShortVideoUploadProcessor", 2, paramArrayOfByte.toString());
    }
    addBDHReportInfo(paramHashMap);
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      this.mIsCacheDiff = true;
    }
    this.mProcessorReport.mStepTrans.logFinishTime();
    this.mProcessorReport.mStepTrans.result = 1;
    this.mTransferedSize = this.mFileSize;
    this.isBDHSuccess = true;
    sendMessageToUpdate(1007);
    sendMsg(false);
    this.file.closeInputStream();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
    }
    FileUtils.deleteFile(paramString);
    paramString = (String)paramHashMap.get("ip");
    paramHashMap = (String)paramHashMap.get("port");
    String str = this.mFileName;
    if (this.mResid == null) {
      paramArrayOfByte = this.mUuid;
    } else {
      paramArrayOfByte = this.mResid;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(this.mReportBusiType);
    localStringBuilder.append("");
    reportForServerMonitor("actRichMediaNetMonitor_videoUp", true, 0, paramString, paramHashMap, str, paramArrayOfByte, localStringBuilder.toString());
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.mProcessorReport.errCode))) {
      return;
    }
    if ((!this.mProcessorReport.mIsOldDbRec) && ((!paramBoolean) || ((this.mProcessorReport.mReportedFlag & 0x2) <= 0)))
    {
      if ((!paramBoolean) && ((this.mProcessorReport.mReportedFlag & 0x1) > 0)) {
        return;
      }
      Object localObject1 = this.mProcessorReport;
      int j = this.mProcessorReport.mReportedFlag;
      int i;
      if (paramBoolean) {
        i = 2;
      } else {
        i = 1;
      }
      ((ProcessorReport)localObject1).mReportedFlag = (j | i);
      if ((this.mUiRequest.mUinType == 1) || (this.mUiRequest.mUinType == 3000)) {
        this.mProcessorReport.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      }
      this.mProcessorReport.mEndTime = System.currentTimeMillis();
      long l = (System.nanoTime() - this.mProcessorReport.mStartTime) / 1000000L;
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepUrl.getReportInfo(1));
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepTrans.getReportInfo(2));
      ((StringBuilder)localObject1).append(";");
      ((StringBuilder)localObject1).append(this.mProcessorReport.mStepMsg.getReportInfo(3));
      localObject1 = ((StringBuilder)localObject1).toString();
      this.mProcessorReport.mReportInfo.put("param_step", localObject1);
      localObject1 = this.mProcessorReport.mReportInfo;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mReportBusiType);
      ((StringBuilder)localObject2).append("");
      ((HashMap)localObject1).put("param_busiType", ((StringBuilder)localObject2).toString());
      localObject2 = this.mProcessorReport.mReportInfo;
      if (this.mResid == null) {
        localObject1 = this.mUuid;
      } else {
        localObject1 = this.mResid;
      }
      ((HashMap)localObject2).put("param_uuid", localObject1);
      this.mProcessorReport.mReportInfo.put("param_toUin", this.mUiRequest.mPeerUin);
      this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      this.mProcessorReport.mReportInfo.put("param_thumbSize", String.valueOf(this.mThumbFileSize));
      localObject1 = this.mProcessorReport.mReportInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mIsSecondTransfered);
      ((StringBuilder)localObject2).append("");
      ((HashMap)localObject1).put("param_isSecondTrans", ((StringBuilder)localObject2).toString());
      if (this.mUiRequest.mBusiType == 0) {
        this.mProcessorReport.mReportInfo.put("param_BDHExistBeforeVideoUpload", String.valueOf(this.isBDHExistBeforeVideoUpload));
      }
      if (this.mSwitch != 3) {
        this.mProcessorReport.mReportInfo.put("param_videoDuration", String.valueOf(this.videoTime));
      }
      this.mProcessorReport.mReportInfo.put("param_fileMd5", this.mUiRequest.mMd5);
      this.mProcessorReport.mReportInfo.put("param_BDH_Cache_Diff", String.valueOf(this.mIsCacheDiff));
      if (paramBoolean)
      {
        this.mProcessorReport.reportForIpv6(true, l, true, getReportTAG());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
      }
      else
      {
        if (this.mProcessorReport.errCode != -9527) {
          this.mProcessorReport.mReportInfo.remove("param_rspHeader");
        }
        this.mProcessorReport.mReportInfo.put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        this.mProcessorReport.mReportInfo.put("param_errorDesc", this.mProcessorReport.errDesc);
        this.mProcessorReport.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
        this.mProcessorReport.reportForIpv6(false, l, true, getReportTAG());
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l, this.mFileSize, this.mProcessorReport.mReportInfo, "");
      }
      setReportFlag();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "AutoMonitor_fragment MineFragment onAttach");
      }
      reportMoovInfo();
      reportTemp(paramBoolean, l);
    }
  }
  
  void doSendMsg(im_msg_body.RichText paramRichText, ShortVideoUploadInfo paramShortVideoUploadInfo, boolean paramBoolean)
  {
    if (this.mUiRequest.mUpCallBack != null) {
      paramShortVideoUploadInfo = this.mUiRequest.mUpCallBack.a(paramRichText);
    } else if (this.mUiRequest.mRec != null) {
      paramShortVideoUploadInfo = this.mUiRequest.mRec;
    } else {
      paramShortVideoUploadInfo = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class)).getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    }
    if ((paramShortVideoUploadInfo != null) && ((paramShortVideoUploadInfo instanceof MessageForShortVideo)))
    {
      localObject = (MessageForShortVideo)paramShortVideoUploadInfo;
      ((MessageForShortVideo)localObject).richText = paramRichText;
      if (QLog.isColorLevel())
      {
        paramRichText = new StringBuilder();
        paramRichText.append("sendMsg() start, subBusiType = ");
        paramRichText.append(((MessageForShortVideo)localObject).subBusiType);
        QLog.d("ShortVideoUploadProcessor", 2, paramRichText.toString());
      }
      if ((this.mUiRequest.mBusiType == 1010) && (this.mUiRequest.mUpCallBack != null))
      {
        onSuccess();
        return;
      }
      if ((paramShortVideoUploadInfo instanceof MessageForBlessPTV))
      {
        ((MessageForBlessPTV)paramShortVideoUploadInfo).uuid = this.mResid;
        ((IMessageHandler)this.app.getRuntimeService(IMessageHandler.class, "")).notifyUI(this.app, 999, true, paramShortVideoUploadInfo.frienduin);
        Logger.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI bless ptv data send finished");
        return;
      }
      if (!isAppValid())
      {
        this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepMsg);
        onError();
        return;
      }
      long l = this.mUiRequest.mUniseq;
      paramRichText = new StringBuilder();
      paramRichText.append("sendMsg() []. mr = ");
      paramRichText.append(paramShortVideoUploadInfo.toString());
      LogTag.a(String.valueOf(l), "message", paramRichText.toString());
      ((IOrderMediaMsgService)this.app.getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg(paramShortVideoUploadInfo, this.messageObserver);
      return;
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Mr_");
    if (paramShortVideoUploadInfo == null)
    {
      paramRichText = "null";
    }
    else
    {
      paramRichText = new StringBuilder();
      paramRichText.append("");
      paramRichText.append(paramShortVideoUploadInfo.msgtype);
      paramRichText = paramRichText.toString();
    }
    ((StringBuilder)localObject).append(paramRichText);
    paramRichText = ((StringBuilder)localObject).toString();
    this.mProcessorReport.setError(9368, "msgtypeError", paramRichText, this.mProcessorReport.mStepMsg);
    onError();
  }
  
  public void doStart()
  {
    if (!buildVideoMd5()) {
      return;
    }
    if ((((MessageForShortVideo)this.mUiRequest.mRec).busiType == 1) && (VideoUpConfigInfo.sSwitch == 2)) {
      this.mSwitch = 2;
    }
    if (!buildThumbInfo()) {
      return;
    }
    if (!handleBDHKey()) {
      return;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("<BDH_LOG>mSwitch : ");
    localStringBuilder.append(this.mSwitch);
    QLog.d("ShortVideoUploadProcessor", 1, localStringBuilder.toString());
    if (this.mSwitch != 2)
    {
      sendRequest();
      return;
    }
    this.mChannelStatus = 1;
    sendFileByBDH();
  }
  
  public void getBDHSessionInfo()
  {
    try
    {
      int i;
      if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session() != null)
      {
        i = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session().length;
        this.mSigSession = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session(), 0, this.mSigSession, 0, i);
      }
      if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey() != null)
      {
        i = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey().length;
        this.mSessionKey = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getSessionKey(), 0, this.mSessionKey, 0, i);
      }
      return;
    }
    finally {}
  }
  
  public IMessageFacade getMessageFacade()
  {
    return (IMessageFacade)this.app.getRuntimeService(IMessageFacade.class);
  }
  
  protected String getReportTAG()
  {
    if ((this.mUiRequest.mUinType != 1) && (this.mUiRequest.mUinType != 3000))
    {
      if (this.mChannelStatus == 1) {
        return "actShortVideoUploadBDH";
      }
      return "actShortVideoUpload";
    }
    if (this.mChannelStatus == 1) {
      return "actShortVideoDiscussgroupUploadBDH";
    }
    return "actShortVideoDiscussgroupUpload";
  }
  
  protected void getThumbFileSize(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.mThumbFileWidth = localOptions.outWidth;
    this.mThumbFileHeight = localOptions.outHeight;
  }
  
  public boolean handleBDHKey()
  {
    getBDHSessionInfo();
    byte[] arrayOfByte = this.mSigSession;
    if ((arrayOfByte != null) && (arrayOfByte.length != 0))
    {
      arrayOfByte = this.mSessionKey;
      if ((arrayOfByte != null) && (arrayOfByte.length != 0)) {}
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoUploadProcessor", 2, "sessionKey or sigSession is null ! ");
      }
      HwServlet.getConfig(this.app, this.mUiRequest.mSelfUin);
    }
    return true;
  }
  
  public void handleHotVideo()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "start() isHotVideo");
    }
    if ((this.mUiRequest.mExtraObj == null) || ((this.mUiRequest.mExtraObj instanceof ShortVideoForwardInfo)))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)this.mUiRequest.mRec;
      if ((localMessageForShortVideo.md5 != null) && (localMessageForShortVideo.md5.length() > 0)) {
        this.mMd5Str = localMessageForShortVideo.md5;
      }
      if ((localMessageForShortVideo.uuid != null) && (localMessageForShortVideo.uuid.length() > 0)) {
        this.mUuid = localMessageForShortVideo.uuid;
      }
      if ((localMessageForShortVideo.thumbMD5 != null) && (localMessageForShortVideo.thumbMD5.length() > 0)) {
        this.thumbFileMd5 = HexUtil.hexStr2Bytes(localMessageForShortVideo.thumbMD5);
      }
    }
    sendMessageToUpdate(1001);
    sendMsg(false);
  }
  
  void inter_retry()
  {
    if (this.mIsCancel) {
      return;
    }
    if ((this.mChannelStatus == 1) && (this.mTrans != null))
    {
      if (this.mTrans.isSuccess.get())
      {
        if (QLog.isColorLevel()) {
          QLog.i("ShortVideoUploadProcessor", 2, "inter_retry resume sendMsg!");
        }
        sendMsg(false);
        return;
      }
      this.app.getHwEngine().resumeTransactionTask(this.mTrans);
      return;
    }
    if ((this.mResid != null) && (this.mTransferedSize >= this.mFileSize))
    {
      sendMsg(false);
      return;
    }
    start();
  }
  
  public boolean isBDHSuccess()
  {
    return this.isBDHSuccess;
  }
  
  RichProto.RichProtoReq.ShortVideoUpReq makeShortVideoUpReq()
  {
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = new RichProto.RichProtoReq.ShortVideoUpReq();
    localShortVideoUpReq.seq = ((int)this.mUiRequest.mUniseq);
    localShortVideoUpReq.selfUin = this.mUiRequest.mSelfUin;
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForBlessPTV)))
    {
      localObject = (MessageForBlessPTV)this.mUiRequest.mRec;
      if (((MessageForBlessPTV)localObject).uinList != null) {
        str = (String)((MessageForBlessPTV)localObject).uinList.get(0);
      } else {
        str = "0";
      }
      localShortVideoUpReq.peerUin = str;
      localShortVideoUpReq.subBusiType = 1;
      if (((MessageForBlessPTV)localObject).uinList != null) {
        i = ((MessageForBlessPTV)localObject).uinList.size();
      } else {
        i = 1;
      }
      localShortVideoUpReq.userCnt = i;
    }
    else if ((this.mUiRequest.mRec != null) && (((MessageForShortVideo)this.mUiRequest.mRec).checkIsHotVideo()))
    {
      localShortVideoUpReq.peerUin = this.mUiRequest.mPeerUin;
      localShortVideoUpReq.subBusiType = 0;
      localShortVideoUpReq.userCnt = 1;
    }
    else
    {
      localShortVideoUpReq.peerUin = this.mUiRequest.mPeerUin;
      localShortVideoUpReq.subBusiType = 0;
      localShortVideoUpReq.userCnt = 1;
    }
    localShortVideoUpReq.uinType = this.mUiRequest.mUinType;
    localShortVideoUpReq.agentType = 0;
    if ((localShortVideoUpReq.uinType != 0) && (1008 != localShortVideoUpReq.uinType)) {
      localShortVideoUpReq.troopUin = this.mUiRequest.mPeerUin;
    } else {
      localShortVideoUpReq.troopUin = null;
    }
    if (localShortVideoUpReq.uinType == 0) {
      localShortVideoUpReq.chatType = 0;
    } else if (1 == localShortVideoUpReq.uinType) {
      localShortVideoUpReq.chatType = 1;
    } else if (3000 == localShortVideoUpReq.uinType) {
      localShortVideoUpReq.chatType = 2;
    } else {
      localShortVideoUpReq.chatType = 3;
    }
    localShortVideoUpReq.clientType = 2;
    Object localObject = new File(this.mUiRequest.mLocalPath);
    String str = ((File)localObject).getName();
    localShortVideoUpReq.fileName = str;
    localShortVideoUpReq.fileSize = ((File)localObject).length();
    localShortVideoUpReq.md5 = this.mLocalMd5;
    localShortVideoUpReq.thumbFileMd5 = this.thumbFileMd5;
    localShortVideoUpReq.fileResWidth = this.mThumbFileWidth;
    localShortVideoUpReq.fileResLength = this.mThumbFileHeight;
    localShortVideoUpReq.fileTime = this.videoTime;
    localShortVideoUpReq.thumbFileSize = this.mThumbFileSize;
    localObject = this.file;
    long l = localShortVideoUpReq.fileSize + this.mThumbFileSize;
    this.mFileSize = l;
    ((FileMsg)localObject).fileSize = l;
    int i = getFormat(str.substring(str.lastIndexOf(".") + 1));
    localShortVideoUpReq.format = i;
    this.mProcessorReport.mReportInfo.put("param_fileFormat", String.valueOf(i));
    this.mProcessorReport.mReportInfo.put("param_picResLength", String.valueOf(this.mThumbFileHeight));
    this.mProcessorReport.mReportInfo.put("param_picResWidth", String.valueOf(this.mThumbFileWidth));
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo))) {
      localShortVideoUpReq.busiType = ((MessageForShortVideo)this.mUiRequest.mRec).busiType;
    } else {
      localShortVideoUpReq.busiType = 0;
    }
    this.mReportBusiType = localShortVideoUpReq.busiType;
    return localShortVideoUpReq;
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoUpResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        StringBuilder localStringBuilder;
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onBusiProtoResp()------response.result = ");
          localStringBuilder.append(paramRichProtoReq.result);
          QLog.d("ShortVideoUploadProcessor", 2, localStringBuilder.toString());
        }
        this.mResid = paramRichProtoReq.fileId;
        if (paramRichProtoReq.result == 0)
        {
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onBusiProtoResp()------response.isExist = ");
            localStringBuilder.append(paramRichProtoReq.isExist);
            QLog.d("ShortVideoUploadProcessor", 2, localStringBuilder.toString());
          }
          this.mVideoAttr = paramRichProtoReq.videoAttr;
          this.mVideoKandianType = paramRichProtoReq.videoKandianType;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onBusiProtoResp()------response.videoAttr = ");
            localStringBuilder.append(paramRichProtoReq.videoAttr);
            localStringBuilder.append(", response.videoKandianType = ");
            localStringBuilder.append(paramRichProtoReq.videoKandianType);
            QLog.d("ShortVideoUploadProcessor", 2, localStringBuilder.toString());
          }
          if (paramRichProtoReq.isExist)
          {
            this.mIsSecondTransfered = true;
            sendMessageToUpdate(1007);
            sendMsg(true);
          }
          else
          {
            this.mStartOffset = paramRichProtoReq.startOffset;
            log("<BDH_LOG> onBusiProtoResp() send by bdh");
            this.mChannelStatus = 1;
            sendFileByBDH();
          }
        }
        else
        {
          onError();
        }
        i += 1;
      }
    }
  }
  
  void onError()
  {
    super.onError();
    Object localObject;
    if ((this.mSwitch == 3) && (this.mMd5Str != null) && (this.mMd5Str.length() > 0))
    {
      if (this.mUiRequest.mRec != null) {
        localObject = this.mUiRequest.mRec;
      } else {
        localObject = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class)).getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      }
      if ((localObject != null) && ((localObject instanceof MessageForShortVideo))) {
        ((MessageForShortVideo)localObject).md5 = this.mMd5Str;
      }
    }
    sendMessageToUpdate(1005);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onError()---- errCode:");
      ((StringBuilder)localObject).append(this.mProcessorReport.errCode);
      QLog.d("ShortVideoUploadProcessor", 2, ((StringBuilder)localObject).toString());
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onError()---- errDesc:");
      ((StringBuilder)localObject).append(this.mProcessorReport.errDesc);
      QLog.d("ShortVideoUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      localObject = new UpCallBack.SendResult();
      ((UpCallBack.SendResult)localObject).jdField_a_of_type_Int = -1;
      ((UpCallBack.SendResult)localObject).b = this.mProcessorReport.errCode;
      ((UpCallBack.SendResult)localObject).jdField_a_of_type_JavaLangString = this.mProcessorReport.errDesc;
      this.mUiRequest.mUpCallBack.b((UpCallBack.SendResult)localObject);
    }
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForBlessPTV)))
    {
      ((IMessageHandler)this.app.getRuntimeService(IMessageHandler.class, "")).notifyUI(this.app, 999, false, this.mUiRequest.mRec.frienduin);
      Logger.a("ShortVideoUploadProcessor", "onError", "notifyUI bless ptv send error");
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = (this.mFileSize - this.mThumbFileSize);
      localSendResult.jdField_d_of_type_JavaLangString = this.mMd5Str;
      Object localObject;
      if (this.mResid == null) {
        localObject = this.mUuid;
      } else {
        localObject = this.mResid;
      }
      localSendResult.jdField_c_of_type_JavaLangString = ((String)localObject);
      localSendResult.jdField_c_of_type_Long = this.mThumbFileSize;
      localSendResult.jdField_c_of_type_Int = this.mVideoAttr;
      localSendResult.jdField_d_of_type_Int = this.mVideoKandianType;
      this.mUiRequest.mUpCallBack.b(localSendResult);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("onSuccess uuid = ");
        ((StringBuilder)localObject).append(localSendResult.jdField_c_of_type_JavaLangString);
        QLog.d("ShortVideoUploadProcessor", 2, ((StringBuilder)localObject).toString());
      }
    }
    else
    {
      updateMessageDataBaseContent(true);
    }
    sendMessageToUpdate(1003);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "onSuccess().");
    }
  }
  
  public void pause()
  {
    if (!this.mIsPause)
    {
      this.mIsPause = true;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("pause", "");
      }
      sendMessageToUpdate(1004);
      Object localObject;
      if ((this.mUiRequest.mBusiType == 1010) && (this.mUiRequest.mUpCallBack != null))
      {
        localObject = new UpCallBack.SendResult();
        ((UpCallBack.SendResult)localObject).jdField_a_of_type_Int = -1;
        ((UpCallBack.SendResult)localObject).b = 9037;
        ((UpCallBack.SendResult)localObject).jdField_a_of_type_JavaLangString = "cancel";
        this.mUiRequest.mUpCallBack.b((UpCallBack.SendResult)localObject);
      }
      if (this.mRichProtoReq != null)
      {
        RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
        this.mRichProtoReq = null;
      }
      int i = this.mChannelStatus;
      if (i != 0)
      {
        if (i != 1) {
          return;
        }
        if (this.mTrans != null)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("<BDH_LOG> pause() pause BDH channel, transation id=");
          ((StringBuilder)localObject).append(this.mTrans.getTransationId());
          log(((StringBuilder)localObject).toString());
          this.app.getHwEngine().stopTransactionTask(this.mTrans);
          return;
        }
        log("<BDH_LOG> pause() pause BDH channel, but trans == null");
        return;
      }
      log("<BDH_LOG> pause() BUT current status is INIT");
    }
  }
  
  protected void reportMoovInfo()
  {
    if (((MessageForShortVideo)this.mUiRequest.mRec).busiType == 0) {
      ThreadManager.post(new ShortVideoUploadProcessor.5(this, this.mUiRequest.mLocalPath), 5, null, true);
    }
  }
  
  protected void reportTemp(boolean paramBoolean, long paramLong)
  {
    if ((this.mTrans != null) && (this.mChannelStatus == 1))
    {
      Object localObject = this.app;
      if ((localObject != null) && (((BaseQQAppInterface)localObject).getHwEngine() != null) && (this.app.getHwEngine().getCurrentConfig().segNum > 32L))
      {
        localObject = new HashMap();
        ((HashMap)localObject).put("segNum", String.valueOf(this.app.getHwEngine().getCurrentConfig().segNum));
        ((HashMap)localObject).put("param_FailCode", String.valueOf(this.mProcessorReport.errCode));
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "tempVideoUploadBDH", paramBoolean, paramLong, this.mFileSize, (HashMap)localObject, "");
      }
    }
  }
  
  void resetStatictisInfo()
  {
    this.file.stepSig.reset();
    this.file.stepUrl.reset();
    this.file.stepTrans.reset();
    this.file.stepNotify.reset();
    ProcessorReport localProcessorReport = this.mProcessorReport;
    FileMsg localFileMsg = this.file;
    long l = System.nanoTime();
    localFileMsg.startTime = l;
    localProcessorReport.mStartTime = l;
    this.file.endTime = 0L;
  }
  
  public int resume()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resume()  + mIsPause : ");
      localStringBuilder.append(this.mIsPause);
      QLog.d("ShortVideoUploadProcessor", 2, localStringBuilder.toString());
    }
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      sendMessageToUpdate(1002);
      this.mServerRollbackCount = 0;
      this.mTryCount = 0;
      this.mReqUrlCount = 0;
      this.mProcessorReport.errCode = 0;
      this.mProcessorReport.errDesc = "";
      resetStatictisInfo();
      sendMessageToUpdate(1001);
      this.mController.mHandler.post(new ShortVideoUploadProcessor.1(this));
    }
    return 0;
  }
  
  public void sendFileByBDH()
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<BDH_LOG> sendFileByBDH Start.   this:");
      ((StringBuilder)localObject).append(this);
      QLog.d("ShortVideoUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    this.mProcessorReport.mStepTrans.logStartTime();
    if (this.mTrans != null) {
      return;
    }
    long l = SystemClock.uptimeMillis();
    Object localObject = combineThumbAndVideo();
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = makeShortVideoUpReq();
    byte[] arrayOfByte = buildExtendInfo(localShortVideoUpReq);
    ShortVideoUploadProcessor.2 local2 = new ShortVideoUploadProcessor.2(this, (String)localObject, l);
    int i;
    if (localShortVideoUpReq.busiType == 0) {
      i = 25;
    } else {
      i = 12;
    }
    this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i, (String)localObject, (int)this.mStartOffset, this.mLocalMd5, local2, arrayOfByte, true);
    localObject = new ShortVideoUploadProcessor.3(this);
    this.mTrans.cbForReport = ((ITransCallbackForReport)localObject);
    int j = this.app.getHwEngine().submitTransactionTask(this.mTrans);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<BDH_LOG>sendFileByBDH Transaction submit RetCode:");
      ((StringBuilder)localObject).append(j);
      ((StringBuilder)localObject).append(" T_ID:");
      ((StringBuilder)localObject).append(this.mTrans.getTransationId());
      ((StringBuilder)localObject).append(" UniSeq:");
      ((StringBuilder)localObject).append(this.mUiRequest.mUniseq);
      ((StringBuilder)localObject).append(" MD5:");
      ((StringBuilder)localObject).append(this.mMd5Str);
      ((StringBuilder)localObject).append(" uuid:");
      ((StringBuilder)localObject).append(this.mUuid);
      ((StringBuilder)localObject).append(" Path:");
      ((StringBuilder)localObject).append(this.mTrans.filePath);
      ((StringBuilder)localObject).append(" Cmd:");
      ((StringBuilder)localObject).append(i);
      QLog.d("ShortVideoUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (j != 0)
    {
      this.mProcessorReport.setError(j, "sendFileByBDH SubmitError.", "", this.mProcessorReport.mStepTrans);
      onError();
    }
  }
  
  protected void sendMessageToUpdate(int paramInt)
  {
    super.sendMessageToUpdate(paramInt);
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("sendMessageToUpdate------state = ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(", str= ");
      localStringBuilder.append(SVUtils.b(paramInt));
      QLog.d("ShortVideoUploadProcessor", 2, localStringBuilder.toString());
    }
    if ((this.mIsPause) && (1004 != paramInt)) {
      return;
    }
    SVBusiUtil.a(this.app, this.file, this.mUiRequest);
  }
  
  void sendMsg(boolean paramBoolean)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start.");
    }
    if (!canDoNextStep())
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "do not send message, due to mIsCancel=true || mIsPause=true.");
      }
      return;
    }
    Object localObject1;
    if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof ShortVideoUploadInfo)))
    {
      localObject2 = (ShortVideoUploadInfo)this.mUiRequest.mExtraObj;
      this.mNeedSyncStory = ((ShortVideoUploadInfo)localObject2).h;
      localObject1 = localObject2;
      if (QLog.isColorLevel())
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("sendMsg() start, mNeedSyncStory = ");
        ((StringBuilder)localObject1).append(this.mNeedSyncStory);
        QLog.d("ShortVideoUploadProcessor", 2, ((StringBuilder)localObject1).toString());
        localObject1 = localObject2;
      }
    }
    else
    {
      localObject1 = null;
    }
    if (localObject1 != null)
    {
      if (QLog.isColorLevel())
      {
        localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("sendMsg() start, isHotVideo = ");
        ((StringBuilder)localObject2).append(((ShortVideoUploadInfo)localObject1).jdField_f_of_type_Boolean);
        QLog.d("ShortVideoUploadProcessor", 2, ((StringBuilder)localObject2).toString());
      }
      if (((ShortVideoUploadInfo)localObject1).jdField_f_of_type_Boolean)
      {
        this.mUuid = ((ShortVideoUploadInfo)localObject1).jdField_a_of_type_JavaLangString;
        this.mMd5Str = ((ShortVideoUploadInfo)localObject1).jdField_e_of_type_JavaLangString;
        this.mLocalMd5 = HexUtil.hexStr2Bytes(((ShortVideoUploadInfo)localObject1).jdField_e_of_type_JavaLangString);
        this.mFileSize = (((ShortVideoUploadInfo)localObject1).jdField_e_of_type_Int + ((ShortVideoUploadInfo)localObject1).b);
        this.videoTime = ((ShortVideoUploadInfo)localObject1).jdField_f_of_type_Int;
        this.mThumbFileSize = ((ShortVideoUploadInfo)localObject1).b;
        this.thumbFileMd5 = HexUtil.hexStr2Bytes(((ShortVideoUploadInfo)localObject1).g);
        this.mThumbFileHeight = ((ShortVideoUploadInfo)localObject1).jdField_d_of_type_Int;
        this.mThumbFileWidth = ((ShortVideoUploadInfo)localObject1).jdField_c_of_type_Int;
      }
    }
    if (!this.needSendMsg) {
      return;
    }
    LogTag.a(String.valueOf(this.mUiRequest.mUniseq), "message", "sendMsg() start.");
    this.mProcessorReport.mStepMsg.logStartTime();
    Object localObject2 = constructRichText();
    if (localObject2 == null)
    {
      this.mProcessorReport.setError(9368, "constructpberror", null, this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    doSendMsg((im_msg_body.RichText)localObject2, (ShortVideoUploadInfo)localObject1, paramBoolean);
  }
  
  void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("sendGetUrlReq()----busiReq.seq : ");
      ((StringBuilder)localObject).append(this.mUiRequest.mUniseq);
      QLog.d("ShortVideoUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = makeShortVideoUpReq();
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "short_video_up";
    localRichProtoReq.reqs.add(localObject);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    if (((RichProto.RichProtoReq.ShortVideoUpReq)localObject).fileSize == 0L)
    {
      this.mProcessorReport.setError(9303, "video filesize is 0", null, null);
      onError();
      return;
    }
    if (this.mThumbFileSize == 0L)
    {
      this.mProcessorReport.setError(9303, "thumbfile filesize is 0", null, null);
      onError();
      return;
    }
    if ((((RichProto.RichProtoReq.ShortVideoUpReq)localObject).busiType == 0) && (this.app.getHwEngine().mConnManager.getCurrentConnNum() > 0)) {
      this.isBDHExistBeforeVideoUpload = Boolean.valueOf(true);
    }
    logRichMediaEvent("requestStart", localRichProtoReq.toString());
    if (!canDoNextStep()) {
      return;
    }
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  public void start()
  {
    if (this.mIsCancel) {
      return;
    }
    if ((((MessageForShortVideo)this.mUiRequest.mRec).busiType == 0) && (((MessageForShortVideo)this.mUiRequest.mRec).isPause))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "video send pause!");
      }
      pause();
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "start()");
    }
    super.start();
    if (((MessageForShortVideo)this.mUiRequest.mRec).checkIsHotVideo())
    {
      handleHotVideo();
      return;
    }
    if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof ShortVideoUploadInfo))) {
      this.isFromFavorite = ((ShortVideoUploadInfo)this.mUiRequest.mExtraObj).j;
    }
    sendMessageToUpdate(1001);
    this.file.closeInputStream();
    doStart();
  }
  
  public void updateMessageDataBaseContent(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.mUiRequest.mRec != null)
    {
      localMessageRecord = this.mUiRequest.mRec;
    }
    else
    {
      localMessageRecord = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class)).getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
    }
    if (localMessageRecord == null)
    {
      logRichMediaEvent("updateDb", "msg null");
      return;
    }
    if ((localMessageRecord instanceof MessageForShortVideo))
    {
      MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
      localMessageForShortVideo.videoFileSize = ((int)(this.mFileSize - this.mThumbFileSize));
      String str;
      if (this.mResid == null) {
        str = this.mUuid;
      } else {
        str = this.mResid;
      }
      localMessageForShortVideo.uuid = str;
      localMessageForShortVideo.md5 = this.mMd5Str;
      localMessageForShortVideo.videoAttr = this.mVideoAttr;
      localMessageForShortVideo.videoKandianType = this.mVideoKandianType;
      localMessageForShortVideo.serial();
      getMessageFacade().updateMsgContentByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */