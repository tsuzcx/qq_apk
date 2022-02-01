package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MediaMessageObserver;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.qipc.QIPCServerHelper;
import com.tencent.mobileqq.richmedia.ordersend.IOrderMediaMsgService;
import com.tencent.mobileqq.shortvideo.SVBusiUtil;
import com.tencent.mobileqq.shortvideo.SVUtils;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.api.IShortVideoForwardProcessor;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoForwardReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoForwardResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import eipc.EIPCResult;
import eipc.EIPCServer;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import pttcenterservice.PttShortVideo.PttShortVideoUploadResp;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class ShortVideoForwardProcessor
  extends BaseShortVideoUploadProcessor
  implements IShortVideoForwardProcessor
{
  public static final String SEPERATOR = "QQ_&_MoblieQQ_&_QQ";
  public static final String TAG = "ShortVideoForwardProcessor";
  BaseQQAppInterface app = (BaseQQAppInterface)this.app;
  boolean isStoryVideo = false;
  public boolean isUploadSuccess = false;
  public boolean mIsFromMsgTabCamera;
  boolean mIsSecondTransfered = false;
  int mReportBusiType = -1;
  protected int mThumbFileHeight;
  protected String mThumbFilePath;
  protected long mThumbFileSize;
  protected int mThumbFileWidth;
  byte[] mThumbMd5Local;
  int mVideoAttr = 0;
  String mVideoFileName;
  long mVideoFileSize;
  int mVideoKandianType = 0;
  byte[] mVideoMd5Local;
  MediaMessageObserver messageObserver = new ShortVideoForwardProcessor.4(this);
  MessageForShortVideo msg = null;
  protected int videoTime;
  
  public ShortVideoForwardProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    if ((this.mUiRequest != null) && (this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo)))
    {
      this.mReportBusiType = ((MessageForShortVideo)this.mUiRequest.mRec).busiType;
      this.isStoryVideo = ((MessageForShortVideo)this.mUiRequest.mRec).isStoryVideo;
      if (this.isStoryVideo) {
        this.msg = ((MessageForShortVideo)this.mUiRequest.mRec);
      }
    }
    else
    {
      this.mReportBusiType = 0;
    }
    paramBaseTransFileController = paramTransferRequest.mLocalPath;
    Object localObject = paramBaseTransFileController.split("QQ_&_MoblieQQ_&_QQ");
    if (4 != localObject.length)
    {
      if (QLog.isColorLevel())
      {
        paramTransferRequest = new StringBuilder();
        paramTransferRequest.append("path was not set correctlly------path = ");
        paramTransferRequest.append(paramBaseTransFileController);
        QLog.d("ShortVideoForwardProcessor", 2, paramTransferRequest.toString());
      }
      paramTransferRequest = this.mProcessorReport;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("path =");
      ((StringBuilder)localObject).append(paramBaseTransFileController);
      paramTransferRequest.setError(9304, ((StringBuilder)localObject).toString(), null, null);
      onError();
      this.mIsCancel = true;
      return;
    }
    if (QLog.isColorLevel())
    {
      paramBaseTransFileController = new StringBuilder();
      paramBaseTransFileController.append("init ShortVideoForwardProcessor=> ");
      paramBaseTransFileController.append(Arrays.toString((Object[])localObject));
      QLog.d("ShortVideoForwardProcessor", 2, paramBaseTransFileController.toString());
    }
    paramTransferRequest.mLocalPath = localObject[0];
    this.mThumbFilePath = localObject[1];
    this.videoTime = Integer.parseInt(localObject[2]);
    this.thumbFileMd5 = HexUtil.hexStr2Bytes(localObject[3]);
  }
  
  private im_msg_body.RichText constructRichText()
  {
    for (;;)
    {
      try
      {
        im_msg_body.RichText localRichText = new im_msg_body.RichText();
        im_msg_body.VideoFile localVideoFile = new im_msg_body.VideoFile();
        localVideoFile.setHasFlag(true);
        if ((this.mLocalMd5 != null) && (this.mLocalMd5.length > 0)) {
          localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(this.mLocalMd5));
        }
        if ((this.mResid != null) && (this.mResid.length() > 0)) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
        }
        boolean bool = QLog.isColorLevel();
        Object localObject1;
        if (bool)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("constructRichText(): mResid uuid=");
          ((StringBuilder)localObject1).append(this.mResid);
          QLog.d("ShortVideoForwardProcessor", 2, ((StringBuilder)localObject1).toString());
        }
        if ((this.mUiRequest.mRec instanceof MessageForShortVideo))
        {
          localObject1 = (MessageForShortVideo)this.mUiRequest.mRec;
          if (localObject1 != null)
          {
            localVideoFile.uint32_file_format.set(((MessageForShortVideo)localObject1).videoFileFormat);
            localVideoFile.uint32_file_time.set(((MessageForShortVideo)localObject1).videoFileTime);
            if ((((MessageForShortVideo)localObject1).videoFileName != null) && (((MessageForShortVideo)localObject1).videoFileName.length() > 0)) {
              localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).videoFileName));
            }
            if ((((MessageForShortVideo)localObject1).fileSource != null) && (((MessageForShortVideo)localObject1).fileSource.length() > 0)) {
              localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
            }
            localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
            localVideoFile.uint32_from_chat_type.set(((MessageForShortVideo)localObject1).fromChatType);
            localVideoFile.uint32_to_chat_type.set(((MessageForShortVideo)localObject1).toChatType);
            localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
            localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
            localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
          }
          if ((this.thumbFileMd5 != null) && (this.thumbFileMd5.length > 0)) {
            localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.thumbFileMd5));
          }
          localVideoFile.uint32_thumb_file_size.set((int)this.mThumbFileSize);
          localVideoFile.uint32_file_size.set((int)this.mVideoFileSize);
          localVideoFile.uint32_thumb_width.set(this.mThumbFileWidth);
          localVideoFile.uint32_thumb_height.set(this.mThumbFileHeight);
          if ((this.mVideoFileName != null) && (this.mVideoFileName.length() > 0)) {
            localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mVideoFileName));
          }
          Object localObject3 = new videoFile.ResvAttr();
          setExtendAttrs((MessageForShortVideo)localObject1, (videoFile.ResvAttr)localObject3);
          if (this.mIsFromMsgTabCamera)
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoForwardProcessor", 2, "videoSource report : 3 , from msg tab camera");
            }
            ((videoFile.ResvAttr)localObject3).uint32_source.set(3);
          }
          else
          {
            if (QLog.isColorLevel()) {
              QLog.d("ShortVideoForwardProcessor", 2, "videoSource report : 4 , from forward");
            }
            ((videoFile.ResvAttr)localObject3).uint32_source.set(4);
          }
          localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((videoFile.ResvAttr)localObject3).toByteArray()));
          localVideoFile.uint32_video_attr.set(this.mVideoAttr);
          localObject3 = new im_msg_body.Text();
          ((im_msg_body.Text)localObject3).setHasFlag(true);
          ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.a(2131911470)));
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
        logRichMediaEvent("Construct richtext", "Construct richtext error");
        localException.printStackTrace();
        return null;
      }
      Object localObject2 = null;
    }
  }
  
  private void resetStatictisInfo()
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
  
  private void setExtendAttrs(MessageForShortVideo paramMessageForShortVideo, videoFile.ResvAttr paramResvAttr)
  {
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.checkIsHotVideo()))
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "constructRichText MessageForHotVideo ");
      }
      if ((paramMessageForShortVideo.hotVideoIconUrl != null) && (paramMessageForShortVideo.hotVideoIconUrl.length() > 0)) {
        paramResvAttr.bytes_hotvideo_icon.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoIconUrl));
      }
      if ((paramMessageForShortVideo.hotVideoTitle != null) && (paramMessageForShortVideo.hotVideoTitle.length() > 0)) {
        paramResvAttr.bytes_hotvideo_title.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoTitle));
      }
      if ((paramMessageForShortVideo.hotVideoUrl != null) && (paramMessageForShortVideo.hotVideoUrl.length() > 0)) {
        paramResvAttr.bytes_hotvideo_url.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoUrl));
      }
      if ((paramMessageForShortVideo.hotVideoSubIconUrl != null) && (paramMessageForShortVideo.hotVideoSubIconUrl.length() > 0)) {
        paramResvAttr.bytes_hotvideo_icon_sub.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.hotVideoSubIconUrl));
      }
      paramResvAttr.uint32_special_video_type.set(paramMessageForShortVideo.specialVideoType);
    }
    if (paramMessageForShortVideo != null)
    {
      paramResvAttr.uint32_msg_tail_type.set(paramMessageForShortVideo.msgTailType);
      if (paramMessageForShortVideo.checkIsDanceVideo()) {
        paramResvAttr.uint32_special_video_type.set(paramMessageForShortVideo.specialVideoType);
      }
      PBBytesField localPBBytesField = paramResvAttr.bytes_camera_templateid;
      Object localObject = paramMessageForShortVideo.templateId;
      String str = "";
      if (localObject != null) {
        localObject = paramMessageForShortVideo.templateId;
      } else {
        localObject = "";
      }
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localPBBytesField = paramResvAttr.bytes_camera_templateName;
      localObject = str;
      if (paramMessageForShortVideo.templateName != null) {
        localObject = paramMessageForShortVideo.templateName;
      }
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
    }
    paramResvAttr.uint32_long_video_kandian_type.set(this.mVideoKandianType);
  }
  
  public byte[] buildExtendInfo(RichProto.RichProtoReq.ShortVideoForwardReq paramShortVideoForwardReq)
  {
    PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
    localPttShortVideoUploadReq.setHasFlag(true);
    localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(paramShortVideoForwardReq.peerUin));
    localPttShortVideoUploadReq.uint32_chat_type.set(paramShortVideoForwardReq.toChatType);
    localPttShortVideoUploadReq.uint32_client_type.set(paramShortVideoForwardReq.clientType);
    if (paramShortVideoForwardReq.troopUin != null) {
      localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(paramShortVideoForwardReq.troopUin));
    } else {
      localPttShortVideoUploadReq.uint64_group_code.set(0L);
    }
    localPttShortVideoUploadReq.uint32_agent_type.set(paramShortVideoForwardReq.agentType);
    localPttShortVideoUploadReq.uint32_business_type.set(paramShortVideoForwardReq.toBusiType);
    localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
    PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
    PBStringField localPBStringField = localPttShortVideoFileInfo.str_file_name;
    String str;
    if (paramShortVideoForwardReq.fileName == null) {
      str = "";
    } else {
      str = paramShortVideoForwardReq.fileName;
    }
    localPBStringField.set(str);
    localPttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(paramShortVideoForwardReq.md5));
    localPttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(paramShortVideoForwardReq.thumbFileMd5));
    localPttShortVideoFileInfo.uint64_file_size.set(paramShortVideoForwardReq.fileSize);
    localPttShortVideoFileInfo.uint32_file_res_length.set(paramShortVideoForwardReq.fileResLength);
    localPttShortVideoFileInfo.uint32_file_res_width.set(paramShortVideoForwardReq.fileResWidth);
    localPttShortVideoFileInfo.uint32_file_format.set(paramShortVideoForwardReq.format);
    localPttShortVideoFileInfo.uint32_file_time.set(paramShortVideoForwardReq.fileTime);
    localPttShortVideoFileInfo.uint64_thumb_file_size.set(paramShortVideoForwardReq.thumbFileSize);
    localPttShortVideoUploadReq.msg_PttShortVideoFileInfo.set(localPttShortVideoFileInfo);
    return localPttShortVideoUploadReq.toByteArray();
  }
  
  public int checkParam()
  {
    if ((this.mUiRequest != null) && (this.mUiRequest.mRec != null) && (((MessageForShortVideo)this.mUiRequest.mRec).busiType == 0)) {
      this.mIsShortVideoSend = true;
    }
    return 0;
  }
  
  /* Error */
  public boolean checkVideoBroken()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_2
    //   2: aconst_null
    //   3: astore_3
    //   4: new 617	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer
    //   7: dup
    //   8: invokespecial 618	com/tencent/qqlive/module/videoreport/dtreport/audio/playback/ReportMediaPlayer:<init>	()V
    //   11: astore_1
    //   12: new 620	java/io/FileInputStream
    //   15: dup
    //   16: aload_0
    //   17: getfield 75	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   20: getfield 90	com/tencent/mobileqq/transfile/TransferRequest:mLocalPath	Ljava/lang/String;
    //   23: invokespecial 622	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   26: astore_3
    //   27: aload_1
    //   28: aload_3
    //   29: invokevirtual 626	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   32: invokevirtual 632	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   35: aload_1
    //   36: invokevirtual 635	android/media/MediaPlayer:prepare	()V
    //   39: aload_1
    //   40: invokevirtual 638	android/media/MediaPlayer:release	()V
    //   43: aload_3
    //   44: invokevirtual 641	java/io/FileInputStream:close	()V
    //   47: iconst_0
    //   48: ireturn
    //   49: astore_2
    //   50: goto +70 -> 120
    //   53: astore_2
    //   54: aconst_null
    //   55: astore_3
    //   56: goto +64 -> 120
    //   59: aconst_null
    //   60: astore_2
    //   61: goto +19 -> 80
    //   64: astore 4
    //   66: aconst_null
    //   67: astore_3
    //   68: aload_2
    //   69: astore_1
    //   70: aload 4
    //   72: astore_2
    //   73: goto +47 -> 120
    //   76: aconst_null
    //   77: astore_2
    //   78: aload_3
    //   79: astore_1
    //   80: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   83: ifeq +12 -> 95
    //   86: ldc 13
    //   88: iconst_2
    //   89: ldc_w 643
    //   92: invokestatic 646	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   95: aload_1
    //   96: ifnull +7 -> 103
    //   99: aload_1
    //   100: invokevirtual 638	android/media/MediaPlayer:release	()V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 641	java/io/FileInputStream:close	()V
    //   111: iconst_1
    //   112: ireturn
    //   113: astore 4
    //   115: aload_2
    //   116: astore_3
    //   117: aload 4
    //   119: astore_2
    //   120: aload_1
    //   121: ifnull +7 -> 128
    //   124: aload_1
    //   125: invokevirtual 638	android/media/MediaPlayer:release	()V
    //   128: aload_3
    //   129: ifnull +7 -> 136
    //   132: aload_3
    //   133: invokevirtual 641	java/io/FileInputStream:close	()V
    //   136: aload_2
    //   137: athrow
    //   138: astore_1
    //   139: goto -63 -> 76
    //   142: astore_2
    //   143: goto -84 -> 59
    //   146: astore_2
    //   147: aload_3
    //   148: astore_2
    //   149: goto -88 -> 61
    //   152: astore_1
    //   153: goto -106 -> 47
    //   156: astore_1
    //   157: goto -46 -> 111
    //   160: astore_1
    //   161: goto -25 -> 136
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	164	0	this	ShortVideoForwardProcessor
    //   11	114	1	localObject1	Object
    //   138	1	1	localException1	Exception
    //   152	1	1	localException2	Exception
    //   156	1	1	localException3	Exception
    //   160	1	1	localException4	Exception
    //   1	1	2	localObject2	Object
    //   49	1	2	localObject3	Object
    //   53	1	2	localObject4	Object
    //   60	77	2	localObject5	Object
    //   142	1	2	localException5	Exception
    //   146	1	2	localException6	Exception
    //   148	1	2	localObject6	Object
    //   3	145	3	localObject7	Object
    //   64	7	4	localObject8	Object
    //   113	5	4	localObject9	Object
    // Exception table:
    //   from	to	target	type
    //   27	39	49	finally
    //   12	27	53	finally
    //   4	12	64	finally
    //   80	95	113	finally
    //   4	12	138	java/lang/Exception
    //   12	27	142	java/lang/Exception
    //   27	39	146	java/lang/Exception
    //   39	47	152	java/lang/Exception
    //   99	103	156	java/lang/Exception
    //   107	111	156	java/lang/Exception
    //   124	128	160	java/lang/Exception
    //   132	136	160	java/lang/Exception
  }
  
  public boolean checkVideoFile()
  {
    if ((this.mUiRequest.mLocalPath != null) && (this.mUiRequest.mLocalPath.length() > 0))
    {
      Object localObject = this.mVideoMd5Local;
      if ((localObject == null) || (localObject.length == 0)) {
        this.mVideoMd5Local = HexUtil.hexStr2Bytes(FileUtils.calcMd5(this.mUiRequest.mLocalPath));
      }
      localObject = new File(this.mUiRequest.mLocalPath);
      if ((((File)localObject).exists()) && (((File)localObject).length() > 0L))
      {
        this.mVideoFileSize = ((File)localObject).length();
        this.mVideoFileName = ((File)localObject).getName();
        return true;
      }
      this.mProcessorReport.setError(9042, "onBusiProtoResp=> video file not exists", null, null);
      onError();
      return false;
    }
    this.mProcessorReport.setError(9302, "onBusiProtoResp=> video file path null", null, null);
    onError();
    return false;
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
      QLog.d("ShortVideoForwardProcessor", 2, localStringBuilder.toString());
    }
    addBDHReportInfo(paramHashMap);
    this.mProcessorReport.setError(paramInt, "OnFailed.", "", this.mProcessorReport.mStepTrans);
    onError();
  }
  
  public void doOnSendSucess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, String paramString, long paramLong)
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
            QLog.d("ShortVideoForwardProcessor", 2, "set uuid from BDH ");
          }
        }
      }
    }
    catch (Exception paramArrayOfByte)
    {
      paramArrayOfByte.printStackTrace();
      if (QLog.isColorLevel()) {
        QLog.e("ShortVideoForwardProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
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
      QLog.d("ShortVideoForwardProcessor", 2, paramArrayOfByte.toString());
    }
    addBDHReportInfo(paramHashMap);
    this.mProcessorReport.mStepTrans.logFinishTime();
    this.mProcessorReport.mStepTrans.result = 1;
    this.mTransferedSize = this.mFileSize;
    this.isUploadSuccess = true;
    sendMsg(false);
    this.file.closeInputStream();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
    }
    FileUtils.deleteFile(paramString);
    reportForServerMonitor(true, 0, (String)paramHashMap.get("ip"), (String)paramHashMap.get("port"));
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
      Object localObject2 = this.mProcessorReport.mReportInfo;
      if (this.mResid == null) {
        localObject1 = this.mUuid;
      } else {
        localObject1 = this.mResid;
      }
      ((HashMap)localObject2).put("param_uuid", localObject1);
      this.mProcessorReport.mReportInfo.put("param_toUin", this.mUiRequest.mPeerUin);
      this.mProcessorReport.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      if (this.mIpList.size() > 0) {
        this.mProcessorReport.mReportInfo.put("param_iplist", this.mIpList.toString());
      }
      this.mProcessorReport.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      localObject1 = this.mProcessorReport.mReportInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mReportBusiType);
      ((StringBuilder)localObject2).append("");
      ((HashMap)localObject1).put("param_busiType", ((StringBuilder)localObject2).toString());
      this.mProcessorReport.mReportInfo.put("param_fileMd5", HexUtil.bytes2HexStr(this.mLocalMd5));
      this.mProcessorReport.mReportInfo.put("param_thumbSize", String.valueOf(this.mThumbFileSize));
      this.mProcessorReport.mReportInfo.put("param_videoDuration", String.valueOf(this.videoTime));
      localObject1 = this.mProcessorReport.mReportInfo;
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(this.mIsSecondTransfered);
      ((StringBuilder)localObject2).append("");
      ((HashMap)localObject1).put("param_isSecondTrans", ((StringBuilder)localObject2).toString());
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
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("ShortVideoForward, cost=");
      ((StringBuilder)localObject1).append((this.mProcessorReport.mStepTrans.finishTime - this.mProcessorReport.mStepTrans.startTime) / 1000000L);
      ((StringBuilder)localObject1).append(", getReportTAG = ");
      ((StringBuilder)localObject1).append(getReportTAG());
      Log.i("AutoMonitor", ((StringBuilder)localObject1).toString());
    }
  }
  
  protected String getReportTAG()
  {
    if (this.mChannelStatus == 1) {
      return "actShortVideoForwardBDH";
    }
    return "actShortVideoForward";
  }
  
  protected void getThumbFileSize(String paramString)
  {
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    this.mThumbFileWidth = localOptions.outWidth;
    this.mThumbFileHeight = localOptions.outHeight;
  }
  
  public void handleNotExist(RichProto.RichProtoResp.ShortVideoForwardResp paramShortVideoForwardResp)
  {
    if (this.mReportBusiType == 0)
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("check ShortVideo before forward:");
        ((StringBuilder)localObject).append(this.mUiRequest.mLocalPath);
        QLog.i("ShortVideoForwardProcessor", 2, ((StringBuilder)localObject).toString());
      }
      if ((checkVideoBroken()) && (SVUtils.d()))
      {
        this.mProcessorReport.setError(9305, "onBusiProtoResp=> video file can not play", null, null);
        onError();
        paramShortVideoForwardResp = new HashMap();
        paramShortVideoForwardResp.put(BaseConstants.RDM_NoChangeFailCode, "");
        paramShortVideoForwardResp.put("filePath", this.mUiRequest.mLocalPath);
        paramShortVideoForwardResp.put("uuid", this.mUuid);
        paramShortVideoForwardResp.put("md5", this.mUiRequest.mMd5);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actForwardVideoBroken", true, 0L, 0L, paramShortVideoForwardResp, "");
        return;
      }
    }
    if (!checkVideoFile()) {
      return;
    }
    Object localObject = this.mThumbFilePath;
    if ((localObject != null) && (((String)localObject).length() > 0))
    {
      localObject = this.mThumbMd5Local;
      if ((localObject == null) || (localObject.length == 0)) {
        this.mThumbMd5Local = HexUtil.hexStr2Bytes(FileUtils.calcMd5(this.mThumbFilePath));
      }
      localObject = new File(this.mThumbFilePath);
      if ((((File)localObject).exists()) && (((File)localObject).length() > 0L))
      {
        this.mThumbFileSize = ((File)localObject).length();
        getThumbFileSize(this.mThumbFilePath);
        this.mFileSize = (this.mVideoFileSize + this.mThumbFileSize);
        if ((this.mLocalMd5 != null) && (this.mLocalMd5.length > 0))
        {
          localObject = this.mVideoMd5Local;
          if ((localObject != null) && (localObject.length > 0) && (this.thumbFileMd5 != null) && (this.thumbFileMd5.length > 0))
          {
            localObject = this.mThumbMd5Local;
            if ((localObject != null) && (localObject.length > 0) && ((!Arrays.equals(this.mLocalMd5, this.mVideoMd5Local)) || (!Arrays.equals(this.thumbFileMd5, this.mThumbMd5Local))))
            {
              if (QLog.isColorLevel())
              {
                paramShortVideoForwardResp = new StringBuilder();
                paramShortVideoForwardResp.append("md5 diffrent : resend request !   mLocalMd5 : ");
                paramShortVideoForwardResp.append(HexUtil.bytes2HexStr(this.mLocalMd5));
                paramShortVideoForwardResp.append(" mVideoMd5_local : ");
                paramShortVideoForwardResp.append(HexUtil.bytes2HexStr(this.mVideoMd5Local));
                paramShortVideoForwardResp.append(" thumbFileMd5 : ");
                paramShortVideoForwardResp.append(HexUtil.bytes2HexStr(this.thumbFileMd5));
                paramShortVideoForwardResp.append(" mThumbMd5_local : ");
                paramShortVideoForwardResp.append(HexUtil.bytes2HexStr(this.mThumbMd5Local));
                QLog.d("ShortVideoForwardProcessor", 2, paramShortVideoForwardResp.toString());
              }
              this.mLocalMd5 = this.mVideoMd5Local;
              this.thumbFileMd5 = this.mThumbMd5Local;
              sendRequest();
              return;
            }
          }
        }
        localObject = this.file;
        long l = this.mVideoFileSize + this.mThumbFileSize;
        this.mFileSize = l;
        ((FileMsg)localObject).fileSize = l;
        this.mStartOffset = paramShortVideoForwardResp.startOffset;
        this.mChannelStatus = 1;
        sendFileByBDH();
        return;
      }
      this.mProcessorReport.setError(9042, "onBusiProtoResp=> thumb file not exists", null, null);
      onError();
      return;
    }
    this.mProcessorReport.setError(9302, "onBusiProtoResp=> mThumbFilePath is null", null, null);
    onError();
  }
  
  void inter_retry()
  {
    if (this.mIsCancel) {
      return;
    }
    if (this.mResid != null)
    {
      if (this.mTransferedSize >= this.mFileSize)
      {
        sendMsg(false);
        return;
      }
      if ((this.mChannelStatus == 1) && (this.mTrans != null))
      {
        this.app.getHwEngine().resumeTransactionTask(this.mTrans);
        return;
      }
      start();
      return;
    }
    start();
  }
  
  public boolean isUpLoadSuccess()
  {
    return this.isUploadSuccess;
  }
  
  public void logRichMediaEvent(String paramString1, String paramString2)
  {
    if (this.file == null)
    {
      TransFileUtil.printRichMediaError("ShortVideoForwardProcessor", "logRichMediaEvent", "file is null !");
      return;
    }
    if (this.mUiRequest != null) {
      RichMediaUtil.logForFw("T", TransFileUtil.getUinDesc(this.mUiRequest.mUinType), RichMediaUtil.getFileTypeDesc(this.file.fileType), String.valueOf(this.file.uniseq), paramString1, paramString2, null);
    }
  }
  
  RichProto.RichProtoReq.ShortVideoForwardReq makeShortVideoForwardReq()
  {
    RichProto.RichProtoReq.ShortVideoForwardReq localShortVideoForwardReq = new RichProto.RichProtoReq.ShortVideoForwardReq();
    localShortVideoForwardReq.seq = ((int)this.mUiRequest.mUniseq);
    localShortVideoForwardReq.selfUin = this.mUiRequest.mSelfUin;
    localShortVideoForwardReq.peerUin = this.mUiRequest.mPeerUin;
    localShortVideoForwardReq.uinType = this.mUiRequest.mUinType;
    localShortVideoForwardReq.agentType = 0;
    localShortVideoForwardReq.troopUin = this.mUiRequest.mPeerUin;
    localShortVideoForwardReq.clientType = 2;
    if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof ShortVideoForwardInfo)))
    {
      Object localObject = (ShortVideoForwardInfo)this.mUiRequest.mExtraObj;
      localShortVideoForwardReq.fromChatType = ((ShortVideoForwardInfo)localObject).l;
      localShortVideoForwardReq.toChatType = ((ShortVideoForwardInfo)localObject).m;
      localShortVideoForwardReq.fromBusiType = ((ShortVideoForwardInfo)localObject).n;
      localShortVideoForwardReq.toBusiType = ((ShortVideoForwardInfo)localObject).o;
      this.mReportBusiType = localShortVideoForwardReq.fromBusiType;
      int i = ((ShortVideoForwardInfo)localObject).u;
      this.videoTime = i;
      localShortVideoForwardReq.fileTime = i;
      localShortVideoForwardReq.uuid = ((ShortVideoForwardInfo)localObject).a;
      localShortVideoForwardReq.fileName = ((ShortVideoForwardInfo)localObject).y;
      localShortVideoForwardReq.format = ((ShortVideoForwardInfo)localObject).z;
      localShortVideoForwardReq.fromUin = ((ShortVideoForwardInfo)localObject).B;
      this.mProcessorReport.mReportInfo.put("param_fileFormat", String.valueOf(localShortVideoForwardReq.format));
      this.mProcessorReport.mReportInfo.put("param_picResLength", String.valueOf(this.mThumbFileHeight));
      this.mProcessorReport.mReportInfo.put("param_picResWidth", String.valueOf(this.mThumbFileWidth));
      this.mProcessorReport.mReportInfo.put("param_fromChatType", String.valueOf(localShortVideoForwardReq.fromChatType));
      this.mProcessorReport.mReportInfo.put("param_toChatType", String.valueOf(localShortVideoForwardReq.toChatType));
      this.mProcessorReport.mReportInfo.put("param_fromBusiType", String.valueOf(localShortVideoForwardReq.fromBusiType));
      this.mProcessorReport.mReportInfo.put("param_toBusiType", String.valueOf(localShortVideoForwardReq.toBusiType));
      localObject = this.mVideoFileName;
      if ((localObject != null) && (((String)localObject).length() > 0)) {
        localShortVideoForwardReq.fileName = this.mVideoFileName;
      }
      localShortVideoForwardReq.fileSize = this.mVideoFileSize;
      localShortVideoForwardReq.thumbFileSize = this.mThumbFileSize;
      localShortVideoForwardReq.fileResWidth = this.mThumbFileWidth;
      localShortVideoForwardReq.fileResLength = this.mThumbFileHeight;
      if (localShortVideoForwardReq.fileName == null) {
        localObject = "";
      } else {
        localObject = localShortVideoForwardReq.fileName;
      }
      localShortVideoForwardReq.fileName = ((String)localObject);
      localShortVideoForwardReq.md5 = this.mLocalMd5;
      localShortVideoForwardReq.thumbFileMd5 = this.thumbFileMd5;
      return localShortVideoForwardReq;
    }
    logRichMediaEvent("sendRequest", "Error => mUiRequest.mExtraObj not ShortVideoForwardInfo");
    return null;
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoForwardResp)paramRichProtoResp.resps.get(i);
        logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        this.mResid = paramRichProtoReq.fileId;
        StringBuilder localStringBuilder;
        if (paramRichProtoReq.result == 0)
        {
          this.mVideoAttr = paramRichProtoReq.videoAttr;
          this.mVideoKandianType = paramRichProtoReq.videoKandianType;
          if (QLog.isColorLevel())
          {
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("onBusiProtoResp()------response.videoAttr = ");
            localStringBuilder.append(paramRichProtoReq.videoAttr);
            localStringBuilder.append(", response.videoKandianType = ");
            localStringBuilder.append(paramRichProtoReq.videoKandianType);
            QLog.d("ShortVideoForwardProcessor", 2, localStringBuilder.toString());
          }
          if (paramRichProtoReq.isExist)
          {
            if (QLog.isColorLevel()) {
              QLog.i("ShortVideoForwardProcessor", 2, "ShortVideo exist on server.");
            }
            this.mIsSecondTransfered = true;
            sendMessageToUpdate(1007);
            sendMsg(true);
          }
          else
          {
            handleNotExist(paramRichProtoReq);
          }
        }
        else
        {
          if (-5100026 == this.mProcessorReport.errCode)
          {
            paramRichProtoReq = this.mProcessorReport;
            localStringBuilder = new StringBuilder();
            localStringBuilder.append("安全打击mUiRequest.mMd5:");
            localStringBuilder.append(this.mUiRequest.mMd5);
            paramRichProtoReq.setError(-5100026, localStringBuilder.toString(), null, null);
          }
          else
          {
            this.mProcessorReport.setError(9045, HardCodeUtil.a(2131911496), null, null);
          }
          onError();
        }
        i += 1;
      }
    }
  }
  
  void onError()
  {
    super.onError();
    if (-5100026 == this.mProcessorReport.errCode) {
      sendMessageToUpdate(5001);
    } else if (9042 == this.mProcessorReport.errCode) {
      sendMessageToUpdate(5002);
    } else {
      sendMessageToUpdate(1005);
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.a = -1;
      localSendResult.b = this.mProcessorReport.errCode;
      localSendResult.c = this.mProcessorReport.errDesc;
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.a = 0;
      localSendResult.e = this.mVideoFileSize;
      localSendResult.g = this.mMd5Str;
      String str;
      if (this.mResid == null) {
        str = this.mUuid;
      } else {
        str = this.mResid;
      }
      localSendResult.f = str;
      localSendResult.i = this.mThumbFileSize;
      localSendResult.j = this.mVideoAttr;
      localSendResult.k = this.mVideoKandianType;
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    else
    {
      updateMessageDataBaseContent(true);
    }
    sendMessageToUpdate(1003);
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
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("<BDH_LOG> pause() pause BDH channel, transation id=");
          localStringBuilder.append(this.mTrans.getTransationId());
          log(localStringBuilder.toString());
          this.app.getHwEngine().stopTransactionTask(this.mTrans);
          return;
        }
        log("<BDH_LOG> pause() pause BDH channel, but trans == null");
        return;
      }
      log("<BDH_LOG> pause() BUT current status is INIT");
    }
  }
  
  protected void reportForServerMonitor(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    Object localObject1 = this.mRSMReporter;
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(this.mReportBusiType);
    ((StringBuilder)localObject2).append("");
    ((RMServMonitorReport)localObject1).mBusiType = ((StringBuilder)localObject2).toString();
    this.mRSMReporter.mMD5 = this.mFileName;
    localObject2 = this.mRSMReporter;
    if (this.mResid == null) {
      localObject1 = this.mUuid;
    } else {
      localObject1 = this.mResid;
    }
    ((RMServMonitorReport)localObject2).mUUID = ((String)localObject1);
    this.mRSMReporter.mServerIp = paramString1;
    this.mRSMReporter.mServerPort = paramString2;
    this.mRSMReporter.mFailCode = String.valueOf(paramInt);
    this.mRSMReporter.mFileSize = this.mFileSize;
    this.mRSMReporter.doReportForServerMonitor("actRichMediaNetMonitor_videoUp", paramBoolean, this.mProcessorReport.reason, this.mProcessorReport.errDesc, this.mUiRequest.mUinType, this.mUiRequest.mPeerUin, true, this.mProcessorReport.mStepTrans);
  }
  
  public int resume()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("resume()  + mIsPause : ");
      localStringBuilder.append(this.mIsPause);
      QLog.d("ShortVideoForwardProcessor", 2, localStringBuilder.toString());
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
      this.sscmObject.a();
      resetStatictisInfo();
      this.mController.mHandler.post(new ShortVideoForwardProcessor.1(this));
    }
    return 0;
  }
  
  public void sendFileByBDH()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("<BDH_LOG> sendFileByBDH Start.   this:");
      localStringBuilder.append(this);
      QLog.d("ShortVideoForwardProcessor", 2, localStringBuilder.toString());
    }
    this.mProcessorReport.mStepTrans.logStartTime();
    if (this.mTrans != null) {
      return;
    }
    if (this.mRaf == null)
    {
      try
      {
        this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        localFileNotFoundException1.printStackTrace();
        this.mRaf = null;
      }
      if (this.mRaf == null)
      {
        this.mProcessorReport.setError(9303, "read video file error", null, null);
        onError();
        return;
      }
    }
    if (this.mThumbRaf == null)
    {
      try
      {
        this.mThumbRaf = new RandomAccessFile(this.mThumbFilePath, "r");
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        localFileNotFoundException2.printStackTrace();
        this.mThumbRaf = null;
      }
      if (this.mThumbRaf == null)
      {
        this.mProcessorReport.setError(9303, "read thumb file error", null, null);
        onError();
        return;
      }
    }
    long l = SystemClock.uptimeMillis();
    Object localObject1 = combineThumbAndVideo();
    RichProto.RichProtoReq.ShortVideoForwardReq localShortVideoForwardReq = makeShortVideoForwardReq();
    if (localShortVideoForwardReq == null)
    {
      this.mProcessorReport.setError(9302, "makeShortVideoForwardReq failed", null, null);
      onError();
      return;
    }
    byte[] arrayOfByte = buildExtendInfo(localShortVideoForwardReq);
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("<BDH_LOG> sendFileByBDH . ,shortVideoReq.md5 :");
      ((StringBuilder)localObject2).append(HexUtil.bytes2HexStr(localShortVideoForwardReq.md5));
      ((StringBuilder)localObject2).append(",shortVideoReq.thumbFileMd5 = ");
      ((StringBuilder)localObject2).append(HexUtil.bytes2HexStr(localShortVideoForwardReq.thumbFileMd5));
      ((StringBuilder)localObject2).append(",mLocalMd5 = ");
      ((StringBuilder)localObject2).append(HexUtil.bytes2HexStr(this.mLocalMd5));
      QLog.d("ShortVideoForwardProcessor", 2, ((StringBuilder)localObject2).toString());
    }
    Object localObject2 = new ShortVideoForwardProcessor.2(this, (String)localObject1, l);
    if (localShortVideoForwardReq.fromBusiType == 0) {
      i = 25;
    } else {
      i = 12;
    }
    this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i, (String)localObject1, (int)this.mStartOffset, this.mLocalMd5, (ITransactionCallback)localObject2, arrayOfByte, true);
    localObject1 = new ShortVideoForwardProcessor.3(this);
    this.mTrans.cbForReport = ((ITransCallbackForReport)localObject1);
    int i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<BDH_LOG>sendFileByBDH Transaction submit RetCode:");
      ((StringBuilder)localObject1).append(i);
      ((StringBuilder)localObject1).append(" T_ID:");
      ((StringBuilder)localObject1).append(this.mTrans.getTransationId());
      ((StringBuilder)localObject1).append(" UniSeq:");
      ((StringBuilder)localObject1).append(this.mUiRequest.mUniseq);
      ((StringBuilder)localObject1).append(" MD5:");
      ((StringBuilder)localObject1).append(this.mMd5Str);
      ((StringBuilder)localObject1).append(" uuid:");
      ((StringBuilder)localObject1).append(this.mUuid);
      ((StringBuilder)localObject1).append(" Path:");
      ((StringBuilder)localObject1).append(this.mTrans.filePath);
      ((StringBuilder)localObject1).append(" Cmd:");
      ((StringBuilder)localObject1).append(12);
      QLog.d("ShortVideoForwardProcessor", 2, ((StringBuilder)localObject1).toString());
    }
    if (i != 0)
    {
      this.mProcessorReport.setError(i, "sendFileByBDH SubmitError.", "", this.mProcessorReport.mStepTrans);
      onError();
    }
  }
  
  protected void sendMessageToUpdate(int paramInt)
  {
    super.sendMessageToUpdate(paramInt);
    if (this.isStoryVideo) {
      updateVideoAndPicStatus(this.msg, paramInt, getProgress());
    }
    if ((this.mIsPause) && (1004 != paramInt)) {
      return;
    }
    SVBusiUtil.a(this.app, this.file, this.mUiRequest);
  }
  
  void sendMsg(boolean paramBoolean)
  {
    if (!canDoNextStep())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = ");
      ((StringBuilder)localObject1).append(this.mChannelStatus);
      log(((StringBuilder)localObject1).toString());
      return;
    }
    if (!this.needSendMsg) {
      return;
    }
    this.mProcessorReport.mStepMsg.logStartTime();
    Object localObject2 = constructRichText();
    if (localObject2 == null)
    {
      this.mProcessorReport.setError(9368, "constructpberror", null, this.mProcessorReport.mStepMsg);
      onError();
      return;
    }
    if (this.mUiRequest.mUpCallBack != null) {
      localObject1 = this.mUiRequest.mUpCallBack.a((im_msg_body.RichText)localObject2);
    } else if (this.mUiRequest.mRec != null) {
      localObject1 = this.mUiRequest.mRec;
    } else {
      localObject1 = ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class)).getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
    }
    if ((localObject1 != null) && ((localObject1 instanceof MessageForShortVideo)))
    {
      ((MessageForShortVideo)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (!isAppValid())
      {
        this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepMsg);
        onError();
        return;
      }
      if ((this.mUiRequest.mBusiType == 1010) && (this.mUiRequest.mUpCallBack != null))
      {
        super.onSuccess();
        localObject2 = new UpCallBack.SendResult();
        ((UpCallBack.SendResult)localObject2).a = 0;
        ((UpCallBack.SendResult)localObject2).e = this.mVideoFileSize;
        ((UpCallBack.SendResult)localObject2).g = this.mMd5Str;
        if (this.mResid == null) {
          localObject1 = this.mUuid;
        } else {
          localObject1 = this.mResid;
        }
        ((UpCallBack.SendResult)localObject2).f = ((String)localObject1);
        ((UpCallBack.SendResult)localObject2).i = this.mThumbFileSize;
        ((UpCallBack.SendResult)localObject2).j = this.mVideoAttr;
        ((UpCallBack.SendResult)localObject2).k = this.mVideoKandianType;
        this.mUiRequest.mUpCallBack.a((UpCallBack.SendResult)localObject2);
        this.mUiRequest.mUpCallBack.b((UpCallBack.SendResult)localObject2);
        return;
      }
      ((IOrderMediaMsgService)this.app.getRuntimeService(IOrderMediaMsgService.class)).sendOrderMsg((MessageRecord)localObject1, this.messageObserver);
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("Mr_");
    if (localObject1 == null)
    {
      localObject1 = "null";
    }
    else
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("");
      localStringBuilder.append(((MessageRecord)localObject1).msgtype);
      localObject1 = localStringBuilder.toString();
    }
    ((StringBuilder)localObject2).append((String)localObject1);
    Object localObject1 = ((StringBuilder)localObject2).toString();
    this.mProcessorReport.setError(9368, "msgtypeError", (String)localObject1, this.mProcessorReport.mStepMsg);
    onError();
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
      QLog.d("ShortVideoForwardProcessor", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = makeShortVideoForwardReq();
    if (localObject == null) {
      return;
    }
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "short_video_fw";
    localRichProtoReq.reqs.add(localObject);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      this.mProcessorReport.setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    logRichMediaEvent("requestStart", localRichProtoReq.toString());
    if (!canDoNextStep()) {
      return;
    }
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 139	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mIsCancel	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 102	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc 13
    //   16: iconst_2
    //   17: ldc_w 1532
    //   20: invokestatic 121	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 1533	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:start	()V
    //   27: aload_0
    //   28: sipush 1001
    //   31: invokevirtual 1187	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:sendMessageToUpdate	(I)V
    //   34: aload_0
    //   35: getfield 388	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   38: invokevirtual 756	com/tencent/mobileqq/transfile/FileMsg:closeInputStream	()V
    //   41: aload_0
    //   42: getfield 75	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   45: getfield 978	com/tencent/mobileqq/transfile/TransferRequest:mMd5	Ljava/lang/String;
    //   48: invokestatic 1539	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +40 -> 91
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 75	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   59: getfield 978	com/tencent/mobileqq/transfile/TransferRequest:mMd5	Ljava/lang/String;
    //   62: invokestatic 162	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   65: putfield 183	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mLocalMd5	[B
    //   68: aload_0
    //   69: getfield 388	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 75	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   77: getfield 978	com/tencent/mobileqq/transfile/TransferRequest:mMd5	Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: aload_2
    //   83: putfield 1542	com/tencent/mobileqq/transfile/FileMsg:fileMd5	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: putfield 1222	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mMd5Str	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 75	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   95: getfield 1086	com/tencent/mobileqq/transfile/TransferRequest:mExtraObj	Ljava/lang/Object;
    //   98: ifnull +408 -> 506
    //   101: aload_0
    //   102: getfield 75	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   105: getfield 1086	com/tencent/mobileqq/transfile/TransferRequest:mExtraObj	Ljava/lang/Object;
    //   108: instanceof 1088
    //   111: ifeq +395 -> 506
    //   114: aload_0
    //   115: getfield 75	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   118: getfield 1086	com/tencent/mobileqq/transfile/TransferRequest:mExtraObj	Ljava/lang/Object;
    //   121: checkcast 1088	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo
    //   124: astore_1
    //   125: aload_0
    //   126: aload_1
    //   127: getfield 1545	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:t	I
    //   130: i2l
    //   131: putfield 296	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mVideoFileSize	J
    //   134: aload_0
    //   135: aload_1
    //   136: getfield 1548	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:A	I
    //   139: i2l
    //   140: putfield 291	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileSize	J
    //   143: aload_0
    //   144: aload_1
    //   145: getfield 1550	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:r	I
    //   148: putfield 301	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileWidth	I
    //   151: aload_0
    //   152: aload_1
    //   153: getfield 1553	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:s	I
    //   156: putfield 306	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileHeight	I
    //   159: aload_0
    //   160: aload_1
    //   161: getfield 1556	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:R	Z
    //   164: putfield 317	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mIsFromMsgTabCamera	Z
    //   167: aload_0
    //   168: getfield 183	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mLocalMd5	[B
    //   171: ifnull +20 -> 191
    //   174: aload_0
    //   175: getfield 183	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mLocalMd5	[B
    //   178: arraylength
    //   179: ifeq +12 -> 191
    //   182: aload_0
    //   183: getfield 296	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mVideoFileSize	J
    //   186: lconst_0
    //   187: lcmp
    //   188: ifgt +54 -> 242
    //   191: aload_0
    //   192: invokevirtual 1559	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:getMd5	()Z
    //   195: ifne +8 -> 203
    //   198: aload_0
    //   199: invokevirtual 136	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:onError	()V
    //   202: return
    //   203: aload_0
    //   204: aload_0
    //   205: getfield 183	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mLocalMd5	[B
    //   208: putfield 649	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mVideoMd5Local	[B
    //   211: new 657	java/io/File
    //   214: dup
    //   215: aload_0
    //   216: getfield 75	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   219: getfield 90	com/tencent/mobileqq/transfile/TransferRequest:mLocalPath	Ljava/lang/String;
    //   222: invokespecial 658	java/io/File:<init>	(Ljava/lang/String;)V
    //   225: astore_1
    //   226: aload_0
    //   227: aload_1
    //   228: invokevirtual 663	java/io/File:length	()J
    //   231: putfield 296	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mVideoFileSize	J
    //   234: aload_0
    //   235: aload_1
    //   236: invokevirtual 666	java/io/File:getName	()Ljava/lang/String;
    //   239: putfield 308	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mVideoFileName	Ljava/lang/String;
    //   242: aload_0
    //   243: getfield 165	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   246: ifnull +34 -> 280
    //   249: aload_0
    //   250: getfield 165	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   253: arraylength
    //   254: ifeq +26 -> 280
    //   257: aload_0
    //   258: getfield 291	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileSize	J
    //   261: lconst_0
    //   262: lcmp
    //   263: ifle +17 -> 280
    //   266: aload_0
    //   267: getfield 301	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileWidth	I
    //   270: ifle +10 -> 280
    //   273: aload_0
    //   274: getfield 306	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileHeight	I
    //   277: ifgt +157 -> 434
    //   280: new 620	java/io/FileInputStream
    //   283: dup
    //   284: aload_0
    //   285: getfield 148	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFilePath	Ljava/lang/String;
    //   288: invokespecial 622	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   291: astore_2
    //   292: aload_2
    //   293: astore_1
    //   294: aload_0
    //   295: aload_2
    //   296: lconst_0
    //   297: invokestatic 1565	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   300: putfield 165	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   303: aload_2
    //   304: astore_1
    //   305: aload_0
    //   306: getfield 165	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   309: ifnonnull +77 -> 386
    //   312: aload_2
    //   313: astore_1
    //   314: aload_0
    //   315: getfield 125	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mProcessorReport	Lcom/tencent/mobileqq/transfile/report/ProcessorReport;
    //   318: astore_3
    //   319: aload_2
    //   320: astore_1
    //   321: new 104	java/lang/StringBuilder
    //   324: dup
    //   325: invokespecial 107	java/lang/StringBuilder:<init>	()V
    //   328: astore 4
    //   330: aload_2
    //   331: astore_1
    //   332: aload 4
    //   334: ldc_w 1567
    //   337: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload_2
    //   342: astore_1
    //   343: aload 4
    //   345: aload_0
    //   346: getfield 148	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFilePath	Ljava/lang/String;
    //   349: invokevirtual 113	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload_2
    //   354: astore_1
    //   355: aload_3
    //   356: sipush 9041
    //   359: aload 4
    //   361: invokevirtual 117	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   364: aconst_null
    //   365: aconst_null
    //   366: invokevirtual 133	com/tencent/mobileqq/transfile/report/ProcessorReport:setError	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/StepInfo;)V
    //   369: aload_2
    //   370: astore_1
    //   371: aload_0
    //   372: invokevirtual 136	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:onError	()V
    //   375: aload_2
    //   376: invokevirtual 641	java/io/FileInputStream:close	()V
    //   379: return
    //   380: astore_1
    //   381: aload_1
    //   382: invokevirtual 1568	java/io/IOException:printStackTrace	()V
    //   385: return
    //   386: aload_2
    //   387: astore_1
    //   388: aload_0
    //   389: aload_0
    //   390: getfield 165	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   393: putfield 984	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbMd5Local	[B
    //   396: aload_2
    //   397: invokevirtual 641	java/io/FileInputStream:close	()V
    //   400: goto +8 -> 408
    //   403: astore_1
    //   404: aload_1
    //   405: invokevirtual 1568	java/io/IOException:printStackTrace	()V
    //   408: aload_0
    //   409: new 657	java/io/File
    //   412: dup
    //   413: aload_0
    //   414: getfield 148	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFilePath	Ljava/lang/String;
    //   417: invokespecial 658	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: invokevirtual 663	java/io/File:length	()J
    //   423: putfield 291	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileSize	J
    //   426: aload_0
    //   427: aload_0
    //   428: getfield 148	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFilePath	Ljava/lang/String;
    //   431: invokevirtual 986	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:getThumbFileSize	(Ljava/lang/String;)V
    //   434: aload_0
    //   435: invokevirtual 1001	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:sendRequest	()V
    //   438: return
    //   439: astore_3
    //   440: goto +12 -> 452
    //   443: astore_2
    //   444: aconst_null
    //   445: astore_1
    //   446: goto +42 -> 488
    //   449: astore_3
    //   450: aconst_null
    //   451: astore_2
    //   452: aload_2
    //   453: astore_1
    //   454: aload_0
    //   455: aconst_null
    //   456: putfield 165	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   459: aload_2
    //   460: astore_1
    //   461: aload_0
    //   462: aload_3
    //   463: invokevirtual 1572	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:analysisIOProblem	(Ljava/io/IOException;)V
    //   466: aload_2
    //   467: astore_1
    //   468: aload_0
    //   469: invokevirtual 136	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:onError	()V
    //   472: aload_2
    //   473: ifnull +13 -> 486
    //   476: aload_2
    //   477: invokevirtual 641	java/io/FileInputStream:close	()V
    //   480: return
    //   481: astore_1
    //   482: aload_1
    //   483: invokevirtual 1568	java/io/IOException:printStackTrace	()V
    //   486: return
    //   487: astore_2
    //   488: aload_1
    //   489: ifnull +15 -> 504
    //   492: aload_1
    //   493: invokevirtual 641	java/io/FileInputStream:close	()V
    //   496: goto +8 -> 504
    //   499: astore_1
    //   500: aload_1
    //   501: invokevirtual 1568	java/io/IOException:printStackTrace	()V
    //   504: aload_2
    //   505: athrow
    //   506: aload_0
    //   507: ldc_w 1573
    //   510: ldc_w 1140
    //   513: invokevirtual 380	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   516: aload_0
    //   517: getfield 125	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mProcessorReport	Lcom/tencent/mobileqq/transfile/report/ProcessorReport;
    //   520: sipush 9302
    //   523: ldc_w 1575
    //   526: aconst_null
    //   527: aconst_null
    //   528: invokevirtual 133	com/tencent/mobileqq/transfile/report/ProcessorReport:setError	(ILjava/lang/String;Ljava/lang/String;Lcom/tencent/mobileqq/transfile/StepInfo;)V
    //   531: aload_0
    //   532: invokevirtual 136	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:onError	()V
    //   535: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	536	0	this	ShortVideoForwardProcessor
    //   72	299	1	localObject1	Object
    //   380	2	1	localIOException1	java.io.IOException
    //   387	1	1	localObject2	Object
    //   403	2	1	localIOException2	java.io.IOException
    //   445	23	1	localObject3	Object
    //   481	12	1	localIOException3	java.io.IOException
    //   499	2	1	localIOException4	java.io.IOException
    //   80	317	2	localObject4	Object
    //   443	1	2	localObject5	Object
    //   451	26	2	localObject6	Object
    //   487	18	2	localObject7	Object
    //   318	38	3	localProcessorReport	ProcessorReport
    //   439	1	3	localIOException5	java.io.IOException
    //   449	14	3	localIOException6	java.io.IOException
    //   328	32	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   375	379	380	java/io/IOException
    //   396	400	403	java/io/IOException
    //   294	303	439	java/io/IOException
    //   305	312	439	java/io/IOException
    //   314	319	439	java/io/IOException
    //   321	330	439	java/io/IOException
    //   332	341	439	java/io/IOException
    //   343	353	439	java/io/IOException
    //   355	369	439	java/io/IOException
    //   371	375	439	java/io/IOException
    //   388	396	439	java/io/IOException
    //   280	292	443	finally
    //   280	292	449	java/io/IOException
    //   476	480	481	java/io/IOException
    //   294	303	487	finally
    //   305	312	487	finally
    //   314	319	487	finally
    //   321	330	487	finally
    //   332	341	487	finally
    //   343	353	487	finally
    //   355	369	487	finally
    //   371	375	487	finally
    //   388	396	487	finally
    //   454	459	487	finally
    //   461	466	487	finally
    //   468	472	487	finally
    //   492	496	499	java/io/IOException
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
      localMessageForShortVideo.videoFileSize = ((int)this.mFileSize);
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
      ((IMessageFacade)this.app.getRuntimeService(IMessageFacade.class)).updateMsgContentByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
    }
  }
  
  public void updateVideoAndPicStatus(MessageRecord paramMessageRecord, int paramInt1, int paramInt2)
  {
    Bundle localBundle = new Bundle();
    localBundle.putInt("key_status", paramInt1);
    localBundle.putInt("key_progress", paramInt2);
    localBundle.putLong("key_uinsequence", paramMessageRecord.uniseq);
    localBundle.putString("uin", paramMessageRecord.frienduin);
    localBundle.putInt("uintype", paramMessageRecord.istroop);
    if ((paramMessageRecord instanceof MessageForShortVideo)) {
      localBundle.putString("key_file_md5", ((MessageForShortVideo)paramMessageRecord).md5);
    } else if ((paramMessageRecord instanceof MessageForPic)) {
      localBundle.putString("key_file_md5", ((MessageForPic)paramMessageRecord).md5);
    }
    paramMessageRecord = QIPCServerHelper.getInstance().getServer().callClient("com.tencent.mobileqq:peak", 1, "PeakIpcModuleClient", "action_update_status", localBundle);
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (paramMessageRecord != null)
    {
      bool1 = bool2;
      if (paramMessageRecord.data != null) {
        bool1 = paramMessageRecord.data.getBoolean("key_result");
      }
    }
    if (QLog.isColorLevel())
    {
      paramMessageRecord = new StringBuilder();
      paramMessageRecord.append("client result:");
      paramMessageRecord.append(bool1);
      QLog.i("ShortVideoForwardProcessor", 2, paramMessageRecord.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoForwardProcessor
 * JD-Core Version:    0.7.0.1
 */