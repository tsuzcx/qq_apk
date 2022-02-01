package com.tencent.mobileqq.transfile;

import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.util.Log;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.transaction.Transaction;
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
import com.tencent.mobileqq.richmedia.dc.DCShortVideo;
import com.tencent.mobileqq.richmedia.ordersend.OrderMediaMsgManager;
import com.tencent.mobileqq.shortvideo.ShortVideoBusiManager;
import com.tencent.mobileqq.shortvideo.ShortVideoForwardInfo;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.api.impl.TransFileControllerImpl;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoForwardReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoForwardResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.RMServMonitorReport;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.BaseConstants;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import dov.com.qq.im.editipc.PeakIpcController;
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
{
  public static final String SEPERATOR = "QQ_&_MoblieQQ_&_QQ";
  public static final String TAG = "ShortVideoForwardProcessor";
  QQAppInterface app = (QQAppInterface)this.app;
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
  MessageObserver messageObserver = new ShortVideoForwardProcessor.4(this);
  MessageForShortVideo msg = null;
  protected int videoTime;
  
  public ShortVideoForwardProcessor(TransFileControllerImpl paramTransFileControllerImpl, TransferRequest paramTransferRequest)
  {
    super(paramTransFileControllerImpl, paramTransferRequest);
    if ((this.mUiRequest != null) && (this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo)))
    {
      this.mReportBusiType = ((MessageForShortVideo)this.mUiRequest.mRec).busiType;
      this.isStoryVideo = ((MessageForShortVideo)this.mUiRequest.mRec).isStoryVideo;
      if (this.isStoryVideo) {
        this.msg = ((MessageForShortVideo)this.mUiRequest.mRec);
      }
    }
    String[] arrayOfString;
    for (;;)
    {
      paramTransFileControllerImpl = paramTransferRequest.mLocalPath;
      arrayOfString = paramTransFileControllerImpl.split("QQ_&_MoblieQQ_&_QQ");
      if (4 == arrayOfString.length) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "path was not set correctlly------path = " + paramTransFileControllerImpl);
      }
      setError(9304, "path =" + paramTransFileControllerImpl);
      onError();
      this.mIsCancel = true;
      return;
      this.mReportBusiType = 0;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "init ShortVideoForwardProcessor=> " + Arrays.toString(arrayOfString));
    }
    paramTransferRequest.mLocalPath = arrayOfString[0];
    this.mThumbFilePath = arrayOfString[1];
    this.videoTime = Integer.parseInt(arrayOfString[2]);
    this.thumbFileMd5 = HexUtil.hexStr2Bytes(arrayOfString[3]);
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
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoForwardProcessor", 2, "constructRichText(): mResid uuid=" + this.mResid);
        }
        if ((this.mUiRequest.mRec instanceof MessageForShortVideo))
        {
          Object localObject1 = (MessageForShortVideo)this.mUiRequest.mRec;
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
            localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((videoFile.ResvAttr)localObject3).toByteArray()));
            localVideoFile.uint32_video_attr.set(this.mVideoAttr);
            localObject3 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject3).setHasFlag(true);
            ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(HardCodeUtil.a(2131714008)));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
            localObject3 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
            localRichText.elems.add((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            return localRichText;
          }
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "videoSource report : 4 , from forward");
          }
          ((videoFile.ResvAttr)localObject3).uint32_source.set(4);
          continue;
        }
        Object localObject2 = null;
      }
      catch (Exception localException)
      {
        logRichMediaEvent("Construct richtext", "Construct richtext error");
        localException.printStackTrace();
        return null;
      }
    }
  }
  
  private void resetStatictisInfo()
  {
    this.file.stepSig.reset();
    this.file.stepUrl.reset();
    this.file.stepTrans.reset();
    this.file.stepNotify.reset();
    FileMsg localFileMsg = this.file;
    long l = System.nanoTime();
    localFileMsg.startTime = l;
    this.mStartTime = l;
    this.file.endTime = 0L;
  }
  
  private void setExtendAttrs(MessageForShortVideo paramMessageForShortVideo, videoFile.ResvAttr paramResvAttr)
  {
    if ((paramMessageForShortVideo != null) && (paramMessageForShortVideo.CheckIsHotVideo()))
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
    Object localObject;
    if (paramMessageForShortVideo != null)
    {
      paramResvAttr.uint32_msg_tail_type.set(paramMessageForShortVideo.msgTailType);
      if (paramMessageForShortVideo.CheckIsDanceVideo()) {
        paramResvAttr.uint32_special_video_type.set(paramMessageForShortVideo.specialVideoType);
      }
      PBBytesField localPBBytesField = paramResvAttr.bytes_camera_templateid;
      if (paramMessageForShortVideo.templateId == null) {
        break label258;
      }
      localObject = paramMessageForShortVideo.templateId;
      localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject));
      localObject = paramResvAttr.bytes_camera_templateName;
      if (paramMessageForShortVideo.templateName == null) {
        break label265;
      }
    }
    label258:
    label265:
    for (paramMessageForShortVideo = paramMessageForShortVideo.templateName;; paramMessageForShortVideo = "")
    {
      ((PBBytesField)localObject).set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo));
      paramResvAttr.uint32_long_video_kandian_type.set(this.mVideoKandianType);
      return;
      localObject = "";
      break;
    }
  }
  
  public byte[] buildExtendInfo(RichProto.RichProtoReq.ShortVideoForwardReq paramShortVideoForwardReq)
  {
    PttShortVideo.PttShortVideoUploadReq localPttShortVideoUploadReq = new PttShortVideo.PttShortVideoUploadReq();
    localPttShortVideoUploadReq.setHasFlag(true);
    localPttShortVideoUploadReq.uint64_fromuin.set(Long.parseLong(this.app.getCurrentAccountUin()));
    localPttShortVideoUploadReq.uint64_touin.set(Long.parseLong(paramShortVideoForwardReq.peerUin));
    localPttShortVideoUploadReq.uint32_chat_type.set(paramShortVideoForwardReq.toChatType);
    localPttShortVideoUploadReq.uint32_client_type.set(paramShortVideoForwardReq.clientType);
    PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo;
    PBStringField localPBStringField;
    if (paramShortVideoForwardReq.troopUin != null)
    {
      localPttShortVideoUploadReq.uint64_group_code.set(Long.parseLong(paramShortVideoForwardReq.troopUin));
      localPttShortVideoUploadReq.uint32_agent_type.set(paramShortVideoForwardReq.agentType);
      localPttShortVideoUploadReq.uint32_business_type.set(paramShortVideoForwardReq.toBusiType);
      localPttShortVideoUploadReq.uint32_flag_support_large_size.set(1);
      localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
      localPBStringField = localPttShortVideoFileInfo.str_file_name;
      if (paramShortVideoForwardReq.fileName != null) {
        break label277;
      }
    }
    label277:
    for (String str = "";; str = paramShortVideoForwardReq.fileName)
    {
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
      localPttShortVideoUploadReq.uint64_group_code.set(0L);
      break;
    }
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
    //   1: astore_3
    //   2: iconst_0
    //   3: istore_2
    //   4: new 610	android/media/MediaPlayer
    //   7: dup
    //   8: invokespecial 611	android/media/MediaPlayer:<init>	()V
    //   11: astore 5
    //   13: new 613	java/io/FileInputStream
    //   16: dup
    //   17: aload_0
    //   18: getfield 74	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   21: getfield 89	com/tencent/mobileqq/transfile/TransferRequest:mLocalPath	Ljava/lang/String;
    //   24: invokespecial 615	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 5
    //   31: aload 4
    //   33: invokevirtual 619	java/io/FileInputStream:getFD	()Ljava/io/FileDescriptor;
    //   36: invokevirtual 623	android/media/MediaPlayer:setDataSource	(Ljava/io/FileDescriptor;)V
    //   39: aload 5
    //   41: invokevirtual 626	android/media/MediaPlayer:prepare	()V
    //   44: aload 5
    //   46: ifnull +8 -> 54
    //   49: aload 5
    //   51: invokevirtual 629	android/media/MediaPlayer:release	()V
    //   54: iload_2
    //   55: istore_1
    //   56: aload 4
    //   58: ifnull +10 -> 68
    //   61: aload 4
    //   63: invokevirtual 632	java/io/FileInputStream:close	()V
    //   66: iload_2
    //   67: istore_1
    //   68: iload_1
    //   69: ireturn
    //   70: astore 4
    //   72: aconst_null
    //   73: astore 4
    //   75: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +12 -> 90
    //   81: ldc 11
    //   83: iconst_2
    //   84: ldc_w 634
    //   87: invokestatic 637	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;)V
    //   90: iconst_1
    //   91: istore_1
    //   92: aload_3
    //   93: ifnull +7 -> 100
    //   96: aload_3
    //   97: invokevirtual 629	android/media/MediaPlayer:release	()V
    //   100: aload 4
    //   102: ifnull -34 -> 68
    //   105: aload 4
    //   107: invokevirtual 632	java/io/FileInputStream:close	()V
    //   110: iconst_1
    //   111: ireturn
    //   112: astore_3
    //   113: iconst_1
    //   114: ireturn
    //   115: astore_3
    //   116: aconst_null
    //   117: astore 4
    //   119: aconst_null
    //   120: astore 5
    //   122: aload 5
    //   124: ifnull +8 -> 132
    //   127: aload 5
    //   129: invokevirtual 629	android/media/MediaPlayer:release	()V
    //   132: aload 4
    //   134: ifnull +8 -> 142
    //   137: aload 4
    //   139: invokevirtual 632	java/io/FileInputStream:close	()V
    //   142: aload_3
    //   143: athrow
    //   144: astore 4
    //   146: goto -4 -> 142
    //   149: astore_3
    //   150: aconst_null
    //   151: astore 4
    //   153: goto -31 -> 122
    //   156: astore_3
    //   157: goto -35 -> 122
    //   160: astore 6
    //   162: aload_3
    //   163: astore 5
    //   165: aload 6
    //   167: astore_3
    //   168: goto -46 -> 122
    //   171: astore_3
    //   172: aconst_null
    //   173: astore 4
    //   175: aload 5
    //   177: astore_3
    //   178: goto -103 -> 75
    //   181: astore_3
    //   182: aload 5
    //   184: astore_3
    //   185: goto -110 -> 75
    //   188: astore_3
    //   189: iconst_0
    //   190: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	this	ShortVideoForwardProcessor
    //   55	37	1	bool1	boolean
    //   3	64	2	bool2	boolean
    //   1	96	3	localObject1	Object
    //   112	1	3	localException1	Exception
    //   115	28	3	localObject2	Object
    //   149	1	3	localObject3	Object
    //   156	7	3	localObject4	Object
    //   167	1	3	localObject5	Object
    //   171	1	3	localException2	Exception
    //   177	1	3	localObject6	Object
    //   181	1	3	localException3	Exception
    //   184	1	3	localObject7	Object
    //   188	1	3	localException4	Exception
    //   27	35	4	localFileInputStream	java.io.FileInputStream
    //   70	1	4	localException5	Exception
    //   73	65	4	localObject8	Object
    //   144	1	4	localException6	Exception
    //   151	23	4	localObject9	Object
    //   11	172	5	localObject10	Object
    //   160	6	6	localObject11	Object
    // Exception table:
    //   from	to	target	type
    //   4	13	70	java/lang/Exception
    //   96	100	112	java/lang/Exception
    //   105	110	112	java/lang/Exception
    //   4	13	115	finally
    //   127	132	144	java/lang/Exception
    //   137	142	144	java/lang/Exception
    //   13	29	149	finally
    //   29	44	156	finally
    //   75	90	160	finally
    //   13	29	171	java/lang/Exception
    //   29	44	181	java/lang/Exception
    //   49	54	188	java/lang/Exception
    //   61	66	188	java/lang/Exception
  }
  
  public boolean checkVideoFile()
  {
    if ((this.mUiRequest.mLocalPath != null) && (this.mUiRequest.mLocalPath.length() > 0))
    {
      if ((this.mVideoMd5Local == null) || (this.mVideoMd5Local.length == 0)) {
        this.mVideoMd5Local = HexUtil.hexStr2Bytes(FileUtils.c(this.mUiRequest.mLocalPath));
      }
      File localFile = new File(this.mUiRequest.mLocalPath);
      if ((localFile.exists()) && (localFile.length() > 0L))
      {
        this.mVideoFileSize = localFile.length();
        this.mVideoFileName = localFile.getName();
        return true;
      }
      setError(9042, "onBusiProtoResp=> video file not exists");
      onError();
      return false;
    }
    setError(9302, "onBusiProtoResp=> video file path null");
    onError();
    return false;
  }
  
  public void doOnSendFailed(int paramInt, HashMap<String, String> paramHashMap, long paramLong)
  {
    long l = SystemClock.uptimeMillis();
    Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l - paramLong) + "ms");
    }
    addBDHReportInfo(paramHashMap);
    setError(paramInt, "OnFailed.", "", this.mStepTrans);
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
      Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
      Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
      Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
      Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l - paramLong) + "ms ,fileSize:" + this.file.fileSize + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
      }
      addBDHReportInfo(paramHashMap);
      this.mStepTrans.logFinishTime();
      this.mStepTrans.result = 1;
      this.mTransferedSize = this.mFileSize;
      this.isUploadSuccess = true;
      sendMsg(false);
      this.file.closeInputStream();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      FileUtils.e(paramString);
      reportForServerMonitor(true, 0, (String)paramHashMap.get("ip"), (String)paramHashMap.get("port"));
      return;
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoForwardProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
        }
      }
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.noReportByErrorCode(this.errCode))) {}
    while ((this.mIsOldDbRec) || ((paramBoolean) && ((this.mReportedFlag & 0x2) > 0)) || ((!paramBoolean) && ((this.mReportedFlag & 0x1) > 0))) {
      return;
    }
    int j = this.mReportedFlag;
    int i;
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.mReportedFlag = (i | j);
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      str = this.mStepUrl.getReportInfo(1) + ";" + this.mStepTrans.getReportInfo(2) + ";" + this.mStepMsg.getReportInfo(3);
      this.mReportInfo.put("param_step", str);
      HashMap localHashMap = this.mReportInfo;
      if (this.mResid != null) {
        break label498;
      }
      str = this.mUuid;
      label176:
      localHashMap.put("param_uuid", str);
      this.mReportInfo.put("param_toUin", this.mUiRequest.mPeerUin);
      this.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      if (this.mIpList.size() > 0) {
        this.mReportInfo.put("param_iplist", this.mIpList.toString());
      }
      this.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      this.mReportInfo.put("param_busiType", this.mReportBusiType + "");
      this.mReportInfo.put("param_fileMd5", HexUtil.bytes2HexStr(this.mLocalMd5));
      this.mReportInfo.put("param_thumbSize", String.valueOf(this.mThumbFileSize));
      this.mReportInfo.put("param_videoDuration", String.valueOf(this.videoTime));
      this.mReportInfo.put("param_isSecondTrans", this.mIsSecondTransfered + "");
      if (!paramBoolean) {
        break label507;
      }
      reportForIpv6(true, l);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l, this.mFileSize, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      Log.i("AutoMonitor", "ShortVideoForward, cost=" + (this.mStepTrans.finishTime - this.mStepTrans.startTime) / 1000000L + ", getReportTAG = " + getReportTAG());
      return;
      i = 1;
      break;
      label498:
      str = this.mResid;
      break label176;
      label507:
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      this.mReportInfo.put("param_uinType", String.valueOf(this.mUiRequest.mUinType));
      reportForIpv6(false, l);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), false, l, this.mFileSize, this.mReportInfo, "");
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
      if (QLog.isColorLevel()) {
        QLog.i("ShortVideoForwardProcessor", 2, "check ShortVideo before forward:" + this.mUiRequest.mLocalPath);
      }
      if ((checkVideoBroken()) && (ShortVideoUtils.needBlockBrokenVideo()))
      {
        setError(9305, "onBusiProtoResp=> video file can not play");
        onError();
        paramShortVideoForwardResp = new HashMap();
        paramShortVideoForwardResp.put(BaseConstants.RDM_NoChangeFailCode, "");
        paramShortVideoForwardResp.put("filePath", this.mUiRequest.mLocalPath);
        paramShortVideoForwardResp.put("uuid", this.mUuid);
        paramShortVideoForwardResp.put("md5", this.mUiRequest.mMd5);
        StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "actForwardVideoBroken", true, 0L, 0L, paramShortVideoForwardResp, "");
      }
    }
    while (!checkVideoFile()) {
      return;
    }
    if ((this.mThumbFilePath != null) && (this.mThumbFilePath.length() > 0))
    {
      if ((this.mThumbMd5Local == null) || (this.mThumbMd5Local.length == 0)) {
        this.mThumbMd5Local = HexUtil.hexStr2Bytes(FileUtils.c(this.mThumbFilePath));
      }
      localObject = new File(this.mThumbFilePath);
      if ((((File)localObject).exists()) && (((File)localObject).length() > 0L))
      {
        this.mThumbFileSize = ((File)localObject).length();
        getThumbFileSize(this.mThumbFilePath);
        this.mFileSize = (this.mVideoFileSize + this.mThumbFileSize);
        if ((this.mLocalMd5 != null) && (this.mLocalMd5.length > 0) && (this.mVideoMd5Local != null) && (this.mVideoMd5Local.length > 0) && (this.thumbFileMd5 != null) && (this.thumbFileMd5.length > 0) && (this.mThumbMd5Local != null) && (this.mThumbMd5Local.length > 0) && ((!Arrays.equals(this.mLocalMd5, this.mVideoMd5Local)) || (!Arrays.equals(this.thumbFileMd5, this.mThumbMd5Local))))
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "md5 diffrent : resend request !   mLocalMd5 : " + HexUtil.bytes2HexStr(this.mLocalMd5) + " mVideoMd5_local : " + HexUtil.bytes2HexStr(this.mVideoMd5Local) + " thumbFileMd5 : " + HexUtil.bytes2HexStr(this.thumbFileMd5) + " mThumbMd5_local : " + HexUtil.bytes2HexStr(this.mThumbMd5Local));
          }
          this.mLocalMd5 = this.mVideoMd5Local;
          this.thumbFileMd5 = this.mThumbMd5Local;
          sendRequest();
        }
      }
      else
      {
        setError(9042, "onBusiProtoResp=> thumb file not exists");
        onError();
      }
    }
    else
    {
      setError(9302, "onBusiProtoResp=> mThumbFilePath is null");
      onError();
      return;
    }
    Object localObject = this.file;
    long l = this.mVideoFileSize + this.mThumbFileSize;
    this.mFileSize = l;
    ((FileMsg)localObject).fileSize = l;
    this.mStartOffset = paramShortVideoForwardResp.startOffset;
    this.mChannelStatus = 1;
    sendFileByBDH();
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
  
  public void logRichMediaEvent(String paramString1, String paramString2)
  {
    if (this.file == null) {
      TransFileUtil.printRichMediaError("ShortVideoForwardProcessor", "logRichMediaEvent", "file is null !");
    }
    while (this.mUiRequest == null) {
      return;
    }
    RichMediaUtil.logForFw("T", TransFileUtil.getUinDesc(this.mUiRequest.mUinType), RichMediaUtil.getFileTypeDesc(this.file.fileType), String.valueOf(this.file.uniseq), paramString1, paramString2, null);
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
      localObject = (ShortVideoForwardInfo)this.mUiRequest.mExtraObj;
      localShortVideoForwardReq.fromChatType = ((ShortVideoForwardInfo)localObject).jdField_c_of_type_Int;
      localShortVideoForwardReq.toChatType = ((ShortVideoForwardInfo)localObject).jdField_d_of_type_Int;
      localShortVideoForwardReq.fromBusiType = ((ShortVideoForwardInfo)localObject).jdField_e_of_type_Int;
      localShortVideoForwardReq.toBusiType = ((ShortVideoForwardInfo)localObject).f;
      this.mReportBusiType = localShortVideoForwardReq.fromBusiType;
      int i = ((ShortVideoForwardInfo)localObject).j;
      this.videoTime = i;
      localShortVideoForwardReq.fileTime = i;
      localShortVideoForwardReq.uuid = ((ShortVideoForwardInfo)localObject).jdField_a_of_type_JavaLangString;
      localShortVideoForwardReq.fileName = ((ShortVideoForwardInfo)localObject).k;
      localShortVideoForwardReq.format = ((ShortVideoForwardInfo)localObject).jdField_l_of_type_Int;
      localShortVideoForwardReq.fromUin = ((ShortVideoForwardInfo)localObject).jdField_l_of_type_JavaLangString;
      this.mReportInfo.put("param_fileFormat", String.valueOf(localShortVideoForwardReq.format));
      this.mReportInfo.put("param_picResLength", String.valueOf(this.mThumbFileHeight));
      this.mReportInfo.put("param_picResWidth", String.valueOf(this.mThumbFileWidth));
      this.mReportInfo.put("param_fromChatType", String.valueOf(localShortVideoForwardReq.fromChatType));
      this.mReportInfo.put("param_toChatType", String.valueOf(localShortVideoForwardReq.toChatType));
      this.mReportInfo.put("param_fromBusiType", String.valueOf(localShortVideoForwardReq.fromBusiType));
      this.mReportInfo.put("param_toBusiType", String.valueOf(localShortVideoForwardReq.toBusiType));
      if ((this.mVideoFileName != null) && (this.mVideoFileName.length() > 0)) {
        localShortVideoForwardReq.fileName = this.mVideoFileName;
      }
      localShortVideoForwardReq.fileSize = this.mVideoFileSize;
      localShortVideoForwardReq.thumbFileSize = this.mThumbFileSize;
      localShortVideoForwardReq.fileResWidth = this.mThumbFileWidth;
      localShortVideoForwardReq.fileResLength = this.mThumbFileHeight;
      if (localShortVideoForwardReq.fileName != null) {
        break label424;
      }
    }
    label424:
    for (Object localObject = "";; localObject = localShortVideoForwardReq.fileName)
    {
      localShortVideoForwardReq.fileName = ((String)localObject);
      localShortVideoForwardReq.md5 = this.mLocalMd5;
      localShortVideoForwardReq.thumbFileMd5 = this.thumbFileMd5;
      return localShortVideoForwardReq;
      logRichMediaEvent("sendRequest", "Error => mUiRequest.mExtraObj not ShortVideoForwardInfo");
      return null;
    }
  }
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoForwardResp)paramRichProtoResp.resps.get(i);
        logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        this.mResid = paramRichProtoReq.fileId;
        if (paramRichProtoReq.result == 0)
        {
          this.mVideoAttr = paramRichProtoReq.videoAttr;
          this.mVideoKandianType = paramRichProtoReq.videoKandianType;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoForwardProcessor", 2, "onBusiProtoResp()------response.videoAttr = " + paramRichProtoReq.videoAttr + ", response.videoKandianType = " + paramRichProtoReq.videoKandianType);
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
          for (;;)
          {
            i += 1;
            break;
            handleNotExist(paramRichProtoReq);
          }
        }
        if (-5100026 == this.errCode) {
          setError(-5100026, "安全打击mUiRequest.mMd5:" + this.mUiRequest.mMd5);
        }
        for (;;)
        {
          onError();
          break;
          setError(9045, HardCodeUtil.a(2131714034));
        }
      }
    }
  }
  
  void onError()
  {
    super.onError();
    if (-5100026 == this.errCode) {
      sendMessageToUpdate(5001);
    }
    for (;;)
    {
      if (this.mUiRequest.mUpCallBack != null)
      {
        UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
        localSendResult.jdField_a_of_type_Int = -1;
        localSendResult.b = this.errCode;
        localSendResult.jdField_a_of_type_JavaLangString = this.errDesc;
        this.mUiRequest.mUpCallBack.b(localSendResult);
      }
      return;
      if (9042 == this.errCode) {
        sendMessageToUpdate(5002);
      } else {
        sendMessageToUpdate(1005);
      }
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    String str;
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.jdField_a_of_type_Int = 0;
      localSendResult.jdField_a_of_type_Long = this.mVideoFileSize;
      localSendResult.jdField_d_of_type_JavaLangString = this.mMd5Str;
      if (this.mResid == null)
      {
        str = this.mUuid;
        localSendResult.jdField_c_of_type_JavaLangString = str;
        localSendResult.jdField_c_of_type_Long = this.mThumbFileSize;
        localSendResult.jdField_c_of_type_Int = this.mVideoAttr;
        localSendResult.jdField_d_of_type_Int = this.mVideoKandianType;
        this.mUiRequest.mUpCallBack.b(localSendResult);
      }
    }
    for (;;)
    {
      sendMessageToUpdate(1003);
      return;
      str = this.mResid;
      break;
      updateMessageDataBaseContent(true);
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
      if (this.mRichProtoReq != null)
      {
        RichProtoProc.cancelRichProtoReq(this.mRichProtoReq);
        this.mRichProtoReq = null;
      }
    }
    switch (this.mChannelStatus)
    {
    default: 
      return;
    case 0: 
      log("<BDH_LOG> pause() BUT current status is INIT");
      return;
    }
    if (this.mTrans != null)
    {
      log("<BDH_LOG> pause() pause BDH channel, transation id=" + this.mTrans.getTransationId());
      this.app.getHwEngine().stopTransactionTask(this.mTrans);
      return;
    }
    log("<BDH_LOG> pause() pause BDH channel, but trans == null");
  }
  
  protected void reportForServerMonitor(boolean paramBoolean, int paramInt, String paramString1, String paramString2)
  {
    this.mRSMReporter.mBusiType = (this.mReportBusiType + "");
    this.mRSMReporter.mMD5 = this.mFileName;
    RMServMonitorReport localRMServMonitorReport = this.mRSMReporter;
    if (this.mResid == null) {}
    for (String str = this.mUuid;; str = this.mResid)
    {
      localRMServMonitorReport.mUUID = str;
      this.mRSMReporter.mServerIp = paramString1;
      this.mRSMReporter.mServerPort = paramString2;
      this.mRSMReporter.mFailCode = String.valueOf(paramInt);
      this.mRSMReporter.mFileSize = this.mFileSize;
      doReportForServerMonitor("actRichMediaNetMonitor_videoUp", paramBoolean);
      return;
    }
  }
  
  public int resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "resume()  + mIsPause : " + this.mIsPause);
    }
    if (this.mIsPause)
    {
      this.mIsPause = false;
      this.mIsCancel = false;
      sendMessageToUpdate(1002);
      this.mServerRollbackCount = 0;
      this.mTryCount = 0;
      this.mReqUrlCount = 0;
      this.errCode = 0;
      this.errDesc = "";
      this.sscmObject.a();
      resetStatictisInfo();
      this.mController.mHandler.post(new ShortVideoForwardProcessor.1(this));
    }
    return 0;
  }
  
  public void sendFileByBDH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.mStepTrans.logStartTime();
    if (this.mTrans != null) {
      return;
    }
    if (this.mRaf == null) {
      try
      {
        this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
        if (this.mRaf == null)
        {
          setError(9303, "read video file error");
          onError();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException1)
      {
        for (;;)
        {
          localFileNotFoundException1.printStackTrace();
          this.mRaf = null;
        }
      }
    }
    if (this.mThumbRaf == null) {
      try
      {
        this.mThumbRaf = new RandomAccessFile(this.mThumbFilePath, "r");
        if (this.mThumbRaf == null)
        {
          setError(9303, "read thumb file error");
          onError();
          return;
        }
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          localFileNotFoundException2.printStackTrace();
          this.mThumbRaf = null;
        }
      }
    }
    long l = SystemClock.uptimeMillis();
    Object localObject = combineThumbAndVideo();
    RichProto.RichProtoReq.ShortVideoForwardReq localShortVideoForwardReq = makeShortVideoForwardReq();
    if (localShortVideoForwardReq == null)
    {
      setError(9302, "makeShortVideoForwardReq failed");
      onError();
      return;
    }
    byte[] arrayOfByte = buildExtendInfo(localShortVideoForwardReq);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG> sendFileByBDH . ,shortVideoReq.md5 :" + HexUtil.bytes2HexStr(localShortVideoForwardReq.md5) + ",shortVideoReq.thumbFileMd5 = " + HexUtil.bytes2HexStr(localShortVideoForwardReq.thumbFileMd5) + ",mLocalMd5 = " + HexUtil.bytes2HexStr(this.mLocalMd5));
    }
    ShortVideoForwardProcessor.2 local2 = new ShortVideoForwardProcessor.2(this, (String)localObject, l);
    if (localShortVideoForwardReq.fromBusiType == 0) {}
    for (int i = 25;; i = 12)
    {
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i, (String)localObject, (int)this.mStartOffset, this.mLocalMd5, local2, arrayOfByte, true);
      localObject = new ShortVideoForwardProcessor.3(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject);
      i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoForwardProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 12);
      }
      if (i == 0) {
        break;
      }
      setError(i, "sendFileByBDH SubmitError.", "", this.mStepTrans);
      onError();
      return;
    }
  }
  
  protected void sendMessageToUpdate(int paramInt)
  {
    super.sendMessageToUpdate(paramInt);
    if (this.isStoryVideo) {
      PeakIpcController.a(this.msg, paramInt, getProgress());
    }
    if ((this.mIsPause) && (1004 != paramInt)) {
      return;
    }
    ShortVideoBusiManager.a(this.app, this.file, this.mUiRequest);
  }
  
  void sendMsg(boolean paramBoolean)
  {
    int k = 2002;
    int i = 0;
    if (!canDoNextStep()) {
      log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.mChannelStatus);
    }
    Object localObject1;
    label238:
    do
    {
      do
      {
        return;
      } while (!this.needSendMsg);
      this.mStepMsg.logStartTime();
      localObject2 = constructRichText();
      if (localObject2 == null)
      {
        setError(9368, "constructpberror", null, this.mStepMsg);
        onError();
        return;
      }
      if (this.mUiRequest.mUpCallBack != null)
      {
        localObject1 = this.mUiRequest.mUpCallBack.a((im_msg_body.RichText)localObject2);
        if ((localObject1 != null) && ((localObject1 instanceof MessageForShortVideo))) {
          break label267;
        }
        localObject2 = new StringBuilder().append("Mr_");
        if (localObject1 != null) {
          break label238;
        }
      }
      for (localObject1 = "null";; localObject1 = "" + ((MessageRecord)localObject1).msgtype)
      {
        setError(9368, "msgtypeError", (String)localObject1, this.mStepMsg);
        onError();
        return;
        if (this.mUiRequest.mRec != null)
        {
          localObject1 = this.mUiRequest.mRec;
          break;
        }
        localObject1 = this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
        break;
      }
      ((MessageForShortVideo)localObject1).richText = ((im_msg_body.RichText)localObject2);
      if (!isAppValid())
      {
        setError(9366, "illegal app", null, this.mStepMsg);
        onError();
        return;
      }
      if ((this.mUiRequest.mBusiType == 1010) && (this.mUiRequest.mUpCallBack != null))
      {
        super.onSuccess();
        localObject2 = new UpCallBack.SendResult();
        ((UpCallBack.SendResult)localObject2).jdField_a_of_type_Int = 0;
        ((UpCallBack.SendResult)localObject2).jdField_a_of_type_Long = this.mVideoFileSize;
        ((UpCallBack.SendResult)localObject2).jdField_d_of_type_JavaLangString = this.mMd5Str;
        if (this.mResid == null) {}
        for (localObject1 = this.mUuid;; localObject1 = this.mResid)
        {
          ((UpCallBack.SendResult)localObject2).jdField_c_of_type_JavaLangString = ((String)localObject1);
          ((UpCallBack.SendResult)localObject2).jdField_c_of_type_Long = this.mThumbFileSize;
          ((UpCallBack.SendResult)localObject2).jdField_c_of_type_Int = this.mVideoAttr;
          ((UpCallBack.SendResult)localObject2).jdField_d_of_type_Int = this.mVideoKandianType;
          this.mUiRequest.mUpCallBack.a((UpCallBack.SendResult)localObject2);
          this.mUiRequest.mUpCallBack.b((UpCallBack.SendResult)localObject2);
          return;
        }
      }
      ((OrderMediaMsgManager)this.app.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a((MessageRecord)localObject1, this.messageObserver);
    } while ((this.mUiRequest.mExtraObj == null) || (!(this.mUiRequest.mExtraObj instanceof ShortVideoForwardInfo)));
    label267:
    Object localObject2 = (ShortVideoForwardInfo)this.mUiRequest.mExtraObj;
    DCShortVideo localDCShortVideo = new DCShortVideo(BaseApplication.getContext());
    int j;
    switch (((ShortVideoForwardInfo)localObject2).jdField_c_of_type_Int)
    {
    default: 
      i = 5;
    case 0: 
      j = k;
      switch (((ShortVideoForwardInfo)localObject2).f)
      {
      default: 
        j = k;
      }
      break;
    }
    for (;;)
    {
      localDCShortVideo.a(this.app, ((ShortVideoForwardInfo)localObject2).jdField_h_of_type_JavaLangString, j, ((MessageRecord)localObject1).istroop, ((MessageRecord)localObject1).frienduin, true, paramBoolean, i, ((ShortVideoForwardInfo)localObject2).jdField_m_of_type_JavaLangString, ((ShortVideoForwardInfo)localObject2).j, ((ShortVideoForwardInfo)localObject2).jdField_e_of_type_JavaLangString);
      return;
      i = 1;
      break;
      i = 3000;
      break;
      i = 5;
      break;
      j = 2001;
      continue;
      j = 2003;
    }
  }
  
  void sendRequest()
  {
    this.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoForwardProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.mUiRequest.mUniseq);
    }
    RichProto.RichProtoReq.ShortVideoForwardReq localShortVideoForwardReq = makeShortVideoForwardReq();
    if (localShortVideoForwardReq == null) {}
    do
    {
      return;
      localRichProtoReq.callback = this;
      localRichProtoReq.protoKey = "short_video_fw";
      localRichProtoReq.reqs.add(localShortVideoForwardReq);
      localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
      if (!isAppValid())
      {
        setError(9366, "illegal app", null, this.mStepUrl);
        onError();
        return;
      }
      logRichMediaEvent("requestStart", localRichProtoReq.toString());
    } while (!canDoNextStep());
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  /* Error */
  public void start()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 132	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mIsCancel	Z
    //   4: ifeq +4 -> 8
    //   7: return
    //   8: invokestatic 101	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   11: ifeq +12 -> 23
    //   14: ldc 11
    //   16: iconst_2
    //   17: ldc_w 1555
    //   20: invokestatic 120	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   23: aload_0
    //   24: invokespecial 1556	com/tencent/mobileqq/transfile/BaseShortVideoUploadProcessor:start	()V
    //   27: aload_0
    //   28: sipush 1001
    //   31: invokevirtual 1190	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:sendMessageToUpdate	(I)V
    //   34: aload_0
    //   35: getfield 381	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   38: invokevirtual 759	com/tencent/mobileqq/transfile/FileMsg:closeInputStream	()V
    //   41: aload_0
    //   42: getfield 74	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   45: getfield 986	com/tencent/mobileqq/transfile/TransferRequest:mMd5	Ljava/lang/String;
    //   48: invokestatic 1562	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   51: ifne +40 -> 91
    //   54: aload_0
    //   55: aload_0
    //   56: getfield 74	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   59: getfield 986	com/tencent/mobileqq/transfile/TransferRequest:mMd5	Ljava/lang/String;
    //   62: invokestatic 155	com/qq/taf/jce/HexUtil:hexStr2Bytes	(Ljava/lang/String;)[B
    //   65: putfield 176	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mLocalMd5	[B
    //   68: aload_0
    //   69: getfield 381	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:file	Lcom/tencent/mobileqq/transfile/FileMsg;
    //   72: astore_1
    //   73: aload_0
    //   74: getfield 74	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   77: getfield 986	com/tencent/mobileqq/transfile/TransferRequest:mMd5	Ljava/lang/String;
    //   80: astore_2
    //   81: aload_1
    //   82: aload_2
    //   83: putfield 1565	com/tencent/mobileqq/transfile/FileMsg:fileMd5	Ljava/lang/String;
    //   86: aload_0
    //   87: aload_2
    //   88: putfield 1223	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mMd5Str	Ljava/lang/String;
    //   91: aload_0
    //   92: getfield 74	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   95: getfield 1093	com/tencent/mobileqq/transfile/TransferRequest:mExtraObj	Ljava/lang/Object;
    //   98: ifnull +105 -> 203
    //   101: aload_0
    //   102: getfield 74	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   105: getfield 1093	com/tencent/mobileqq/transfile/TransferRequest:mExtraObj	Ljava/lang/Object;
    //   108: instanceof 1095
    //   111: ifeq +92 -> 203
    //   114: aload_0
    //   115: getfield 74	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   118: getfield 1093	com/tencent/mobileqq/transfile/TransferRequest:mExtraObj	Ljava/lang/Object;
    //   121: checkcast 1095	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo
    //   124: astore_1
    //   125: aload_0
    //   126: aload_1
    //   127: getfield 1567	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:i	I
    //   130: i2l
    //   131: putfield 289	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mVideoFileSize	J
    //   134: aload_0
    //   135: aload_1
    //   136: getfield 1569	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:jdField_m_of_type_Int	I
    //   139: i2l
    //   140: putfield 284	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileSize	J
    //   143: aload_0
    //   144: aload_1
    //   145: getfield 1572	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:g	I
    //   148: putfield 294	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileWidth	I
    //   151: aload_0
    //   152: aload_1
    //   153: getfield 1574	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:jdField_h_of_type_Int	I
    //   156: putfield 299	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileHeight	I
    //   159: aload_0
    //   160: aload_1
    //   161: getfield 1576	com/tencent/mobileqq/shortvideo/ShortVideoForwardInfo:jdField_d_of_type_Boolean	Z
    //   164: putfield 310	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mIsFromMsgTabCamera	Z
    //   167: aload_0
    //   168: getfield 176	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mLocalMd5	[B
    //   171: ifnull +20 -> 191
    //   174: aload_0
    //   175: getfield 176	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mLocalMd5	[B
    //   178: arraylength
    //   179: ifeq +12 -> 191
    //   182: aload_0
    //   183: getfield 289	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mVideoFileSize	J
    //   186: lconst_0
    //   187: lcmp
    //   188: ifgt +79 -> 267
    //   191: aload_0
    //   192: invokevirtual 1579	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:getMd5	()Z
    //   195: ifne +33 -> 228
    //   198: aload_0
    //   199: invokevirtual 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:onError	()V
    //   202: return
    //   203: aload_0
    //   204: ldc_w 1580
    //   207: ldc_w 1143
    //   210: invokevirtual 373	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:logRichMediaEvent	(Ljava/lang/String;Ljava/lang/String;)V
    //   213: aload_0
    //   214: sipush 9302
    //   217: ldc_w 1582
    //   220: invokevirtual 126	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:setError	(ILjava/lang/String;)V
    //   223: aload_0
    //   224: invokevirtual 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:onError	()V
    //   227: return
    //   228: aload_0
    //   229: aload_0
    //   230: getfield 176	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mLocalMd5	[B
    //   233: putfield 640	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mVideoMd5Local	[B
    //   236: new 648	java/io/File
    //   239: dup
    //   240: aload_0
    //   241: getfield 74	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mUiRequest	Lcom/tencent/mobileqq/transfile/TransferRequest;
    //   244: getfield 89	com/tencent/mobileqq/transfile/TransferRequest:mLocalPath	Ljava/lang/String;
    //   247: invokespecial 649	java/io/File:<init>	(Ljava/lang/String;)V
    //   250: astore_1
    //   251: aload_0
    //   252: aload_1
    //   253: invokevirtual 654	java/io/File:length	()J
    //   256: putfield 289	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mVideoFileSize	J
    //   259: aload_0
    //   260: aload_1
    //   261: invokevirtual 657	java/io/File:getName	()Ljava/lang/String;
    //   264: putfield 301	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mVideoFileName	Ljava/lang/String;
    //   267: aload_0
    //   268: getfield 158	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   271: ifnull +34 -> 305
    //   274: aload_0
    //   275: getfield 158	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   278: arraylength
    //   279: ifeq +26 -> 305
    //   282: aload_0
    //   283: getfield 284	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileSize	J
    //   286: lconst_0
    //   287: lcmp
    //   288: ifle +17 -> 305
    //   291: aload_0
    //   292: getfield 294	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileWidth	I
    //   295: ifle +10 -> 305
    //   298: aload_0
    //   299: getfield 299	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileHeight	I
    //   302: ifgt +132 -> 434
    //   305: new 613	java/io/FileInputStream
    //   308: dup
    //   309: aload_0
    //   310: getfield 141	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFilePath	Ljava/lang/String;
    //   313: invokespecial 615	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   316: astore_2
    //   317: aload_2
    //   318: astore_1
    //   319: aload_0
    //   320: aload_2
    //   321: lconst_0
    //   322: invokestatic 1588	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   325: putfield 158	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   328: aload_2
    //   329: astore_1
    //   330: aload_0
    //   331: getfield 158	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   334: ifnonnull +56 -> 390
    //   337: aload_2
    //   338: astore_1
    //   339: aload_0
    //   340: sipush 9041
    //   343: new 103	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 106	java/lang/StringBuilder:<init>	()V
    //   350: ldc_w 1590
    //   353: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   356: aload_0
    //   357: getfield 141	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFilePath	Ljava/lang/String;
    //   360: invokevirtual 112	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   363: invokevirtual 116	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   366: invokevirtual 126	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:setError	(ILjava/lang/String;)V
    //   369: aload_2
    //   370: astore_1
    //   371: aload_0
    //   372: invokevirtual 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:onError	()V
    //   375: aload_2
    //   376: ifnull -369 -> 7
    //   379: aload_2
    //   380: invokevirtual 632	java/io/FileInputStream:close	()V
    //   383: return
    //   384: astore_1
    //   385: aload_1
    //   386: invokevirtual 1591	java/io/IOException:printStackTrace	()V
    //   389: return
    //   390: aload_2
    //   391: astore_1
    //   392: aload_0
    //   393: aload_0
    //   394: getfield 158	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   397: putfield 992	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbMd5Local	[B
    //   400: aload_2
    //   401: ifnull +7 -> 408
    //   404: aload_2
    //   405: invokevirtual 632	java/io/FileInputStream:close	()V
    //   408: aload_0
    //   409: new 648	java/io/File
    //   412: dup
    //   413: aload_0
    //   414: getfield 141	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFilePath	Ljava/lang/String;
    //   417: invokespecial 649	java/io/File:<init>	(Ljava/lang/String;)V
    //   420: invokevirtual 654	java/io/File:length	()J
    //   423: putfield 284	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFileSize	J
    //   426: aload_0
    //   427: aload_0
    //   428: getfield 141	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:mThumbFilePath	Ljava/lang/String;
    //   431: invokevirtual 994	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:getThumbFileSize	(Ljava/lang/String;)V
    //   434: aload_0
    //   435: invokevirtual 1009	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:sendRequest	()V
    //   438: return
    //   439: astore_1
    //   440: aload_1
    //   441: invokevirtual 1591	java/io/IOException:printStackTrace	()V
    //   444: goto -36 -> 408
    //   447: astore_3
    //   448: aconst_null
    //   449: astore_2
    //   450: aload_2
    //   451: astore_1
    //   452: aload_0
    //   453: aconst_null
    //   454: putfield 158	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:thumbFileMd5	[B
    //   457: aload_2
    //   458: astore_1
    //   459: aload_0
    //   460: aload_3
    //   461: invokevirtual 1595	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:analysisIOProblem	(Ljava/io/IOException;)V
    //   464: aload_2
    //   465: astore_1
    //   466: aload_0
    //   467: invokevirtual 129	com/tencent/mobileqq/transfile/ShortVideoForwardProcessor:onError	()V
    //   470: aload_2
    //   471: ifnull -464 -> 7
    //   474: aload_2
    //   475: invokevirtual 632	java/io/FileInputStream:close	()V
    //   478: return
    //   479: astore_1
    //   480: aload_1
    //   481: invokevirtual 1591	java/io/IOException:printStackTrace	()V
    //   484: return
    //   485: astore_2
    //   486: aconst_null
    //   487: astore_1
    //   488: aload_1
    //   489: ifnull +7 -> 496
    //   492: aload_1
    //   493: invokevirtual 632	java/io/FileInputStream:close	()V
    //   496: aload_2
    //   497: athrow
    //   498: astore_1
    //   499: aload_1
    //   500: invokevirtual 1591	java/io/IOException:printStackTrace	()V
    //   503: goto -7 -> 496
    //   506: astore_2
    //   507: goto -19 -> 488
    //   510: astore_3
    //   511: goto -61 -> 450
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	514	0	this	ShortVideoForwardProcessor
    //   72	299	1	localObject1	Object
    //   384	2	1	localIOException1	java.io.IOException
    //   391	1	1	localObject2	Object
    //   439	2	1	localIOException2	java.io.IOException
    //   451	15	1	localObject3	Object
    //   479	2	1	localIOException3	java.io.IOException
    //   487	6	1	localObject4	Object
    //   498	2	1	localIOException4	java.io.IOException
    //   80	395	2	localObject5	Object
    //   485	12	2	localObject6	Object
    //   506	1	2	localObject7	Object
    //   447	14	3	localIOException5	java.io.IOException
    //   510	1	3	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   379	383	384	java/io/IOException
    //   404	408	439	java/io/IOException
    //   305	317	447	java/io/IOException
    //   474	478	479	java/io/IOException
    //   305	317	485	finally
    //   492	496	498	java/io/IOException
    //   319	328	506	finally
    //   330	337	506	finally
    //   339	369	506	finally
    //   371	375	506	finally
    //   392	400	506	finally
    //   452	457	506	finally
    //   459	464	506	finally
    //   466	470	506	finally
    //   319	328	510	java/io/IOException
    //   330	337	510	java/io/IOException
    //   339	369	510	java/io/IOException
    //   371	375	510	java/io/IOException
    //   392	400	510	java/io/IOException
  }
  
  public void updateMessageDataBaseContent(boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.mUiRequest.mRec != null)
    {
      localMessageRecord = this.mUiRequest.mRec;
      if (localMessageRecord != null) {
        break label78;
      }
      logRichMediaEvent("updateDb", "msg null");
    }
    label78:
    while (!(localMessageRecord instanceof MessageForShortVideo))
    {
      return;
      localMessageRecord = this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
      break;
    }
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
    localMessageForShortVideo.videoFileSize = ((int)this.mFileSize);
    if (this.mResid == null) {}
    for (String str = this.mUuid;; str = this.mResid)
    {
      localMessageForShortVideo.uuid = str;
      localMessageForShortVideo.md5 = this.mMd5Str;
      localMessageForShortVideo.videoAttr = this.mVideoAttr;
      localMessageForShortVideo.videoKandianType = this.mVideoKandianType;
      localMessageForShortVideo.serial();
      this.app.getMessageFacade().a(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoForwardProcessor
 * JD-Core Version:    0.7.0.1
 */