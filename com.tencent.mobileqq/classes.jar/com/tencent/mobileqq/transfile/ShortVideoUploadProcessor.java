package com.tencent.mobileqq.transfile;

import amtj;
import amwl;
import anba;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.SystemClock;
import android.text.TextUtils;
import ayde;
import ayeo;
import ayep;
import badr;
import bahm;
import bbqf;
import bbqj;
import bbrp;
import bbwb;
import bcel;
import bfwl;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.activity.photo.LocalMediaInfo;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForBlessPTV;
import com.tencent.mobileqq.data.MessageForDanceMachine;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.config.HwNetSegConf;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.conn.ConnManager;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.PTVUpConfigInfo;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.shortvideo.ShortVideoUtils;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.utils.FileUtils;
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
{
  static final int CMD_ACK = 3;
  static final int CMD_THUMB = 1;
  static final int CMD_VIDEO_SEG = 2;
  public static final String SEPERATOR = "QQ_&_MoblieQQ_&_QQ";
  public static final int SWITCH_DEFAULT = 1;
  public static final int SWITCH_PRE_UPLOAD = 3;
  public static final int SWITCH_REQ_AVOID = 2;
  public static final String TAG = "ShortVideoUploadProcessor";
  static final int VIDEO_PREUPLOAD_COMMAND_ID = 16;
  QQAppInterface app = (QQAppInterface)this.app;
  Boolean isBDHExistBeforeVideoUpload = Boolean.valueOf(false);
  public boolean isBDHSuccess;
  public boolean isFromFavorite;
  private volatile boolean mIsCacheDiff;
  boolean mIsSecondTransfered = false;
  private boolean mNeedSyncStory;
  BaseTransProcessor.StepInfo mPreUpStepTrans = new BaseTransProcessor.StepInfo();
  int mReportBusiType = -1;
  private byte[] mSessionKey;
  protected anba mShortVideoTransManager;
  private byte[] mSigSession;
  private int mSwitch = 1;
  protected int mThumbFileHeight;
  protected String mThumbFilePath;
  protected long mThumbFileSize;
  protected int mThumbFileWidth;
  private int mVideoAttr;
  private int mVideoKandianType;
  amwl messageObserver = new ShortVideoUploadProcessor.6(this);
  protected int videoTime;
  
  public ShortVideoUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForShortVideo))) {}
    for (this.mReportBusiType = ((MessageForShortVideo)this.mUiRequest.mRec).busiType;; this.mReportBusiType = 0)
    {
      if (!this.mUiRequest.mIsPresend)
      {
        paramTransFileController = this.mUiRequest.mLocalPath;
        paramTransferRequest = paramTransFileController.split("QQ_&_MoblieQQ_&_QQ");
        if (4 == paramTransferRequest.length) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "path was not set correctlly------path = " + paramTransFileController);
        }
        setError(9304, "path =" + paramTransFileController);
        onError();
        this.mIsCancel = true;
      }
      return;
    }
    this.mUiRequest.mLocalPath = paramTransferRequest[0];
    this.mThumbFilePath = paramTransferRequest[1];
    this.videoTime = Integer.parseInt(paramTransferRequest[2]);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "Init params videoTime : " + this.videoTime);
    }
    this.thumbFileMd5 = HexUtil.hexStr2Bytes(paramTransferRequest[3]);
  }
  
  private void checkRedbagVideoRealStat()
  {
    if (this.mUiRequest.mRec != null) {}
    for (MessageRecord localMessageRecord = this.mUiRequest.mRec;; localMessageRecord = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq))
    {
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForShortVideo)) && (((MessageForShortVideo)localMessageRecord).redBagType == LocalMediaInfo.REDBAG_TYPE_GET)) {
        bbwb.a(this.app);
      }
      return;
    }
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
        if (this.mResid != null) {
          localVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mResid));
        }
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "mResid uuid=" + this.mResid);
        }
        if (!(this.mUiRequest.mRec instanceof MessageForShortVideo)) {
          break label613;
        }
        Object localObject1 = (MessageForShortVideo)this.mUiRequest.mRec;
        videoFile.ResvAttr localResvAttr;
        if (localObject1 != null)
        {
          localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForShortVideo)localObject1).fileSource));
          localVideoFile.uint32_busi_type.set(((MessageForShortVideo)localObject1).busiType);
          localVideoFile.bool_support_progressive.set(((MessageForShortVideo)localObject1).supportProgressive);
          localVideoFile.uint32_file_width.set(((MessageForShortVideo)localObject1).fileWidth);
          localVideoFile.uint32_file_height.set(((MessageForShortVideo)localObject1).fileHeight);
          localVideoFile.uint32_sub_busi_type.set(((MessageForShortVideo)localObject1).subBusiType);
          localResvAttr = new videoFile.ResvAttr();
          localResvAttr.uint32_msg_tail_type.set(((MessageForShortVideo)localObject1).msgTailType);
          if ((localObject1 != null) && (((MessageForShortVideo)localObject1).CheckIsHotVideo()))
          {
            handleHotVideoRichText(localResvAttr, (MessageForShortVideo)localObject1, localVideoFile);
            PBBytesField localPBBytesField = localResvAttr.bytes_camera_templateid;
            if (((MessageForShortVideo)localObject1).templateId == null) {
              break label599;
            }
            localObject3 = ((MessageForShortVideo)localObject1).templateId;
            localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            localPBBytesField = localResvAttr.bytes_camera_templateName;
            if (((MessageForShortVideo)localObject1).templateName == null) {
              break label606;
            }
            localObject3 = ((MessageForShortVideo)localObject1).templateName;
            localPBBytesField.set(ByteStringMicro.copyFromUtf8((String)localObject3));
            localResvAttr.uint32_long_video_kandian_type.set(this.mVideoKandianType);
            setVideoSource((MessageForShortVideo)localObject1, localResvAttr);
            localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(localResvAttr.toByteArray()));
            localVideoFile.uint32_video_attr.set(this.mVideoAttr);
          }
        }
        else
        {
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
          ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(amtj.a(2131713195)));
          localObject1 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
          localObject3 = new im_msg_body.Elem();
          ((im_msg_body.Elem)localObject3).video_file.set(localVideoFile);
          localRichText.elems.add((MessageMicro)localObject1);
          localRichText.elems.add((MessageMicro)localObject3);
          return localRichText;
        }
        if (((MessageForShortVideo)localObject1).CheckIsDanceVideo()) {
          localResvAttr.uint32_special_video_type.set(((MessageForShortVideo)localObject1).specialVideoType);
        }
        localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mUiRequest.mLocalPath));
        localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.mUiRequest.mMd5)));
        continue;
        localObject3 = "";
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("ShortVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      label599:
      continue;
      label606:
      Object localObject3 = "";
      continue;
      label613:
      Object localObject2 = null;
    }
  }
  
  private void doDCReport(bbrp parambbrp, MessageRecord paramMessageRecord, boolean paramBoolean)
  {
    badr localbadr;
    int i;
    if (parambbrp != null)
    {
      localbadr = new badr(BaseApplication.getContext());
      i = 2002;
      switch (((MessageForShortVideo)paramMessageRecord).busiType)
      {
      }
    }
    for (;;)
    {
      if ((parambbrp.jdField_i_of_type_JavaLangString == null) || (parambbrp.jdField_i_of_type_JavaLangString.length() <= 0)) {
        parambbrp.jdField_i_of_type_JavaLangString = parambbrp.h;
      }
      localbadr.a(this.app, parambbrp.jdField_i_of_type_JavaLangString, i, paramMessageRecord.istroop, paramMessageRecord.frienduin, false, paramBoolean, -1, null, parambbrp.f, parambbrp.jdField_e_of_type_JavaLangString);
      return;
      i = 2002;
      continue;
      i = 2001;
      continue;
      i = 2003;
    }
  }
  
  private void doSendMsg(im_msg_body.RichText paramRichText, bbrp parambbrp, boolean paramBoolean)
  {
    MessageRecord localMessageRecord;
    if (this.mUiRequest.mUpCallBack != null)
    {
      localMessageRecord = this.mUiRequest.mUpCallBack.attachRichText2Msg(paramRichText);
      if ((localMessageRecord != null) && ((localMessageRecord instanceof MessageForShortVideo))) {
        break label174;
      }
      parambbrp = new StringBuilder().append("Mr_");
      if (localMessageRecord != null) {
        break label146;
      }
    }
    label146:
    for (paramRichText = "null";; paramRichText = "" + localMessageRecord.msgtype)
    {
      setError(9368, "msgtypeError", paramRichText, this.mStepMsg);
      onError();
      return;
      if (this.mUiRequest.mRec != null)
      {
        localMessageRecord = this.mUiRequest.mRec;
        break;
      }
      localMessageRecord = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      break;
    }
    label174:
    ((MessageForShortVideo)localMessageRecord).richText = paramRichText;
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, subBusiType = " + ((MessageForShortVideo)localMessageRecord).subBusiType);
    }
    if ((this.mUiRequest.mBusiType == 1010) && (this.mUiRequest.mUpCallBack != null))
    {
      onSuccess();
      return;
    }
    if ((localMessageRecord instanceof MessageForBlessPTV))
    {
      ((MessageForBlessPTV)localMessageRecord).uuid = this.mResid;
      this.app.getMsgHandler().notifyUI(999, true, localMessageRecord.frienduin);
      ayde.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI bless ptv data send finished");
      return;
    }
    if ((localMessageRecord instanceof MessageForDanceMachine))
    {
      ((MessageForDanceMachine)localMessageRecord).uuid = this.mResid;
      this.app.getMsgHandler().notifyUI(8034, true, localMessageRecord);
      ayde.a("ShortVideoUploadProcessor", "updataMessageDataBaseContent", "notifyUI dance machine data send finished");
      return;
    }
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepMsg);
      onError();
      return;
    }
    bfwl.a(String.valueOf(this.mUiRequest.mUniseq), "message", "sendMsg() []. mr = " + localMessageRecord.toString());
    ((bahm)this.app.getManager(326)).a(localMessageRecord, this.messageObserver);
    doDCReport(parambbrp, localMessageRecord, paramBoolean);
  }
  
  private int getFormat(String paramString)
  {
    int i = -1;
    if ("avi".equals(paramString)) {
      i = 2;
    }
    do
    {
      return i;
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
    } while (!"mts".equals(paramString));
    return 11;
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
    label162:
    StringBuilder localStringBuilder;
    if (this.mUuid != null)
    {
      paramVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(this.mUuid));
      if ((this.mMd5Str == null) || (this.mMd5Str.length() <= 0)) {
        break label262;
      }
      paramVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.mMd5Str)));
      if ((paramMessageForShortVideo.md5 == null) || (paramMessageForShortVideo.md5.length() == 0)) {
        paramMessageForShortVideo.md5 = this.mMd5Str;
      }
      setThumbInfoForHotVideo(paramMessageForShortVideo);
      if ((paramMessageForShortVideo.videoFileName == null) || (paramMessageForShortVideo.videoFileName.length() == 0))
      {
        localStringBuilder = new StringBuilder();
        if (this.mMd5Str != null) {
          break label289;
        }
      }
    }
    label262:
    label289:
    for (paramResvAttr = "HotVideo";; paramResvAttr = this.mMd5Str)
    {
      paramMessageForShortVideo.videoFileName = (paramResvAttr + ".mp4");
      paramVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.videoFileName));
      return;
      if (paramMessageForShortVideo.uuid == null) {
        break;
      }
      paramVideoFile.bytes_file_uuid.set(ByteStringMicro.copyFromUtf8(paramMessageForShortVideo.uuid));
      break;
      if (paramMessageForShortVideo.md5 == null) {
        break label162;
      }
      paramVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(paramMessageForShortVideo.md5)));
      break label162;
    }
  }
  
  private RichProto.RichProtoReq.ShortVideoUpReq makeShortVideoUpReq()
  {
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = new RichProto.RichProtoReq.ShortVideoUpReq();
    localShortVideoUpReq.seq = ((int)this.mUiRequest.mUniseq);
    localShortVideoUpReq.selfUin = this.mUiRequest.mSelfUin;
    String str;
    int i;
    if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForBlessPTV)))
    {
      Object localObject = (MessageForBlessPTV)this.mUiRequest.mRec;
      if (((MessageForBlessPTV)localObject).uinList != null)
      {
        str = (String)((MessageForBlessPTV)localObject).uinList.get(0);
        localShortVideoUpReq.peerUin = str;
        localShortVideoUpReq.subBusiType = 1;
        if (((MessageForBlessPTV)localObject).uinList == null) {
          break label450;
        }
        i = ((MessageForBlessPTV)localObject).uinList.size();
        label121:
        localShortVideoUpReq.userCnt = i;
        label127:
        localShortVideoUpReq.uinType = this.mUiRequest.mUinType;
        localShortVideoUpReq.agentType = 0;
        if ((localShortVideoUpReq.uinType != 0) && (1008 != localShortVideoUpReq.uinType)) {
          break label535;
        }
        localShortVideoUpReq.troopUin = null;
        label170:
        if (localShortVideoUpReq.uinType != 0) {
          break label550;
        }
        localShortVideoUpReq.chatType = 0;
        label184:
        localShortVideoUpReq.clientType = 2;
        localObject = new File(this.mUiRequest.mLocalPath);
        str = ((File)localObject).getName();
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
        i = getFormat(str.substring(str.lastIndexOf(".") + 1));
        localShortVideoUpReq.format = i;
        this.mReportInfo.put("param_fileFormat", String.valueOf(i));
        this.mReportInfo.put("param_picResLength", String.valueOf(this.mThumbFileHeight));
        this.mReportInfo.put("param_picResWidth", String.valueOf(this.mThumbFileWidth));
        if ((this.mUiRequest.mRec == null) || (!(this.mUiRequest.mRec instanceof MessageForShortVideo))) {
          break label597;
        }
      }
    }
    label450:
    label597:
    for (localShortVideoUpReq.busiType = ((MessageForShortVideo)this.mUiRequest.mRec).busiType;; localShortVideoUpReq.busiType = 0)
    {
      this.mReportBusiType = localShortVideoUpReq.busiType;
      return localShortVideoUpReq;
      str = "0";
      break;
      i = 1;
      break label121;
      if ((this.mUiRequest.mRec != null) && (((MessageForShortVideo)this.mUiRequest.mRec).CheckIsHotVideo()))
      {
        localShortVideoUpReq.peerUin = this.mUiRequest.mPeerUin;
        localShortVideoUpReq.subBusiType = 0;
        localShortVideoUpReq.userCnt = 1;
        break label127;
      }
      localShortVideoUpReq.peerUin = this.mUiRequest.mPeerUin;
      localShortVideoUpReq.subBusiType = 0;
      localShortVideoUpReq.userCnt = 1;
      break label127;
      localShortVideoUpReq.troopUin = this.mUiRequest.mPeerUin;
      break label170;
      if (1 == localShortVideoUpReq.uinType)
      {
        localShortVideoUpReq.chatType = 1;
        break label184;
      }
      if (3000 == localShortVideoUpReq.uinType)
      {
        localShortVideoUpReq.chatType = 2;
        break label184;
      }
      localShortVideoUpReq.chatType = 3;
      break label184;
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
    int i = 6;
    String str = "unknown";
    if (this.isFromFavorite)
    {
      i = 7;
      str = "favorite";
    }
    for (;;)
    {
      paramResvAttr.uint32_source.set(2);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, new Object[] { "videoSource report: ", Integer.valueOf(i), ", from ", str });
      }
      return;
      if (paramMessageForShortVideo.busiType == 0)
      {
        str = "gallery";
        i = 2;
      }
      else if (paramMessageForShortVideo.busiType == 1)
      {
        str = "aio camera";
        i = 1;
      }
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
    }
    for (;;)
    {
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
      localPttShortVideoUploadReq.uint64_group_code.set(0L);
    }
  }
  
  /* Error */
  public boolean buildThumbInfo()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 178	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:thumbFileMd5	[B
    //   4: ifnonnull +98 -> 102
    //   7: new 939	java/io/FileInputStream
    //   10: dup
    //   11: aload_0
    //   12: getfield 156	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFilePath	Ljava/lang/String;
    //   15: invokespecial 940	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   18: astore_2
    //   19: aload_2
    //   20: astore_1
    //   21: aload_0
    //   22: aload_2
    //   23: lconst_0
    //   24: invokestatic 946	com/tencent/qphone/base/util/MD5:toMD5Byte	(Ljava/io/InputStream;J)[B
    //   27: putfield 178	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:thumbFileMd5	[B
    //   30: aload_2
    //   31: astore_1
    //   32: aload_0
    //   33: getfield 178	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:thumbFileMd5	[B
    //   36: ifnonnull +58 -> 94
    //   39: aload_2
    //   40: astore_1
    //   41: aload_0
    //   42: sipush 9041
    //   45: new 127	java/lang/StringBuilder
    //   48: dup
    //   49: invokespecial 128	java/lang/StringBuilder:<init>	()V
    //   52: ldc_w 948
    //   55: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: aload_0
    //   59: getfield 156	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFilePath	Ljava/lang/String;
    //   62: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   65: invokevirtual 138	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   68: invokevirtual 148	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:setError	(ILjava/lang/String;)V
    //   71: aload_2
    //   72: astore_1
    //   73: aload_0
    //   74: invokevirtual 151	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:onError	()V
    //   77: aload_2
    //   78: ifnull +7 -> 85
    //   81: aload_2
    //   82: invokevirtual 951	java/io/FileInputStream:close	()V
    //   85: iconst_0
    //   86: ireturn
    //   87: astore_1
    //   88: aload_1
    //   89: invokevirtual 952	java/io/IOException:printStackTrace	()V
    //   92: iconst_0
    //   93: ireturn
    //   94: aload_2
    //   95: ifnull +7 -> 102
    //   98: aload_2
    //   99: invokevirtual 951	java/io/FileInputStream:close	()V
    //   102: aload_0
    //   103: getfield 956	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbRaf	Ljava/io/RandomAccessFile;
    //   106: ifnonnull +126 -> 232
    //   109: aload_0
    //   110: new 958	java/io/RandomAccessFile
    //   113: dup
    //   114: aload_0
    //   115: getfield 156	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFilePath	Ljava/lang/String;
    //   118: ldc_w 960
    //   121: invokespecial 963	java/io/RandomAccessFile:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   124: putfield 956	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbRaf	Ljava/io/RandomAccessFile;
    //   127: aload_0
    //   128: getfield 956	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbRaf	Ljava/io/RandomAccessFile;
    //   131: ifnonnull +101 -> 232
    //   134: aload_0
    //   135: sipush 9303
    //   138: ldc_w 965
    //   141: invokevirtual 148	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:setError	(ILjava/lang/String;)V
    //   144: aload_0
    //   145: invokevirtual 151	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:onError	()V
    //   148: iconst_0
    //   149: ireturn
    //   150: astore_1
    //   151: aload_1
    //   152: invokevirtual 952	java/io/IOException:printStackTrace	()V
    //   155: goto -53 -> 102
    //   158: astore_3
    //   159: aconst_null
    //   160: astore_2
    //   161: aload_2
    //   162: astore_1
    //   163: aload_0
    //   164: aconst_null
    //   165: putfield 178	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:thumbFileMd5	[B
    //   168: aload_2
    //   169: astore_1
    //   170: aload_0
    //   171: aload_3
    //   172: invokevirtual 969	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:analysisIOProblem	(Ljava/io/IOException;)V
    //   175: aload_2
    //   176: astore_1
    //   177: aload_0
    //   178: invokevirtual 151	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:onError	()V
    //   181: aload_2
    //   182: ifnull -97 -> 85
    //   185: aload_2
    //   186: invokevirtual 951	java/io/FileInputStream:close	()V
    //   189: iconst_0
    //   190: ireturn
    //   191: astore_1
    //   192: aload_1
    //   193: invokevirtual 952	java/io/IOException:printStackTrace	()V
    //   196: iconst_0
    //   197: ireturn
    //   198: astore_2
    //   199: aconst_null
    //   200: astore_1
    //   201: aload_1
    //   202: ifnull +7 -> 209
    //   205: aload_1
    //   206: invokevirtual 951	java/io/FileInputStream:close	()V
    //   209: aload_2
    //   210: athrow
    //   211: astore_1
    //   212: aload_1
    //   213: invokevirtual 952	java/io/IOException:printStackTrace	()V
    //   216: goto -7 -> 209
    //   219: astore_1
    //   220: aload_1
    //   221: invokevirtual 970	java/io/FileNotFoundException:printStackTrace	()V
    //   224: aload_0
    //   225: aconst_null
    //   226: putfield 956	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbRaf	Ljava/io/RandomAccessFile;
    //   229: goto -102 -> 127
    //   232: aload_0
    //   233: new 710	java/io/File
    //   236: dup
    //   237: aload_0
    //   238: getfield 156	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFilePath	Ljava/lang/String;
    //   241: invokespecial 713	java/io/File:<init>	(Ljava/lang/String;)V
    //   244: invokevirtual 722	java/io/File:length	()J
    //   247: putfield 356	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFileSize	J
    //   250: aload_0
    //   251: aload_0
    //   252: getfield 156	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:mThumbFilePath	Ljava/lang/String;
    //   255: invokevirtual 973	com/tencent/mobileqq/transfile/ShortVideoUploadProcessor:getThumbFileSize	(Ljava/lang/String;)V
    //   258: iconst_1
    //   259: ireturn
    //   260: astore_2
    //   261: goto -60 -> 201
    //   264: astore_3
    //   265: goto -104 -> 161
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	268	0	this	ShortVideoUploadProcessor
    //   20	53	1	localFileInputStream1	java.io.FileInputStream
    //   87	2	1	localIOException1	java.io.IOException
    //   150	2	1	localIOException2	java.io.IOException
    //   162	15	1	localFileInputStream2	java.io.FileInputStream
    //   191	2	1	localIOException3	java.io.IOException
    //   200	6	1	localObject1	Object
    //   211	2	1	localIOException4	java.io.IOException
    //   219	2	1	localFileNotFoundException	FileNotFoundException
    //   18	168	2	localFileInputStream3	java.io.FileInputStream
    //   198	12	2	localObject2	Object
    //   260	1	2	localObject3	Object
    //   158	14	3	localIOException5	java.io.IOException
    //   264	1	3	localIOException6	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   81	85	87	java/io/IOException
    //   98	102	150	java/io/IOException
    //   7	19	158	java/io/IOException
    //   185	189	191	java/io/IOException
    //   7	19	198	finally
    //   205	209	211	java/io/IOException
    //   109	127	219	java/io/FileNotFoundException
    //   21	30	260	finally
    //   32	39	260	finally
    //   41	71	260	finally
    //   73	77	260	finally
    //   163	168	260	finally
    //   170	175	260	finally
    //   177	181	260	finally
    //   21	30	264	java/io/IOException
    //   32	39	264	java/io/IOException
    //   41	71	264	java/io/IOException
    //   73	77	264	java/io/IOException
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
      setError(9042, "video file not exists");
      onError();
      return false;
    }
    if (this.mRaf == null) {
      try
      {
        this.mRaf = new RandomAccessFile(this.mUiRequest.mLocalPath, "r");
        if (this.mRaf == null)
        {
          setError(9303, "read video file error");
          onError();
          return false;
        }
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        for (;;)
        {
          localFileNotFoundException.printStackTrace();
          this.mRaf = null;
        }
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
  
  public void doOnSendFailed(int paramInt, HashMap<String, String> paramHashMap, long paramLong)
  {
    long l1 = SystemClock.uptimeMillis();
    long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
    long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
    long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
    long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction End : Failed. New : SendTotalCost:" + (l1 - paramLong) + "ms");
    }
    addBDHReportInfo(paramHashMap);
    if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
      this.mIsCacheDiff = true;
    }
    ThreadManager.post(new ShortVideoUploadProcessor.3(this, l2, l3, l4, l5), 5, null, true);
    setError(paramInt, "OnFailed.", "", this.mStepTrans);
    if ((this.mSwitch == 3) && (this.mPreUpStepTrans != null))
    {
      this.mPreUpStepTrans.logFinishTime();
      this.mPreUpStepTrans.result = 0;
    }
    if (!QLog.isColorLevel()) {}
    for (;;)
    {
      onError();
      return;
      bcel.a("Upload_Video_Error", String.valueOf(paramInt));
    }
  }
  
  public void doOnSendSuccess(byte[] paramArrayOfByte, HashMap<String, String> paramHashMap, String paramString, long paramLong)
  {
    long l1 = SystemClock.uptimeMillis();
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
      long l2 = Long.valueOf((String)paramHashMap.get("upFlow_WiFi")).longValue();
      long l3 = Long.valueOf((String)paramHashMap.get("dwFlow_WiFi")).longValue();
      long l4 = Long.valueOf((String)paramHashMap.get("upFlow_Xg")).longValue();
      long l5 = Long.valueOf((String)paramHashMap.get("dwFlow_Xg")).longValue();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction End : Success. New : SendTotalCost:" + (l1 - paramLong) + "ms ,fileSize:" + this.file.fileSize + " transInfo:" + (String)paramHashMap.get("rep_bdhTrans"));
      }
      addBDHReportInfo(paramHashMap);
      if (((String)paramHashMap.get("param_BDH_Cache_Diff")).equals(String.valueOf(true))) {
        this.mIsCacheDiff = true;
      }
      this.mStepTrans.logFinishTime();
      this.mStepTrans.result = 1;
      this.mTransferedSize = this.mFileSize;
      this.isBDHSuccess = true;
      sendMessageToUpdate(1007);
      sendMsg(false);
      ThreadManager.post(new ShortVideoUploadProcessor.2(this, l2, l3, l4, l5), 5, null, true);
      this.file.closeInputStream();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> Transaction Success,delete combined file");
      }
      FileUtils.deleteFile(paramString);
      paramString = (String)paramHashMap.get("ip");
      paramHashMap = (String)paramHashMap.get("port");
      String str = this.mFileName;
      if (this.mResid == null)
      {
        paramArrayOfByte = this.mUuid;
        reportForServerMonitor("actRichMediaNetMonitor_videoUp", true, 0, paramString, paramHashMap, str, paramArrayOfByte, this.mReportBusiType + "");
        return;
      }
    }
    catch (Exception paramArrayOfByte)
    {
      for (;;)
      {
        paramArrayOfByte.printStackTrace();
        if (QLog.isColorLevel())
        {
          QLog.e("ShortVideoUploadProcessor", 2, "get uuid from BDH error", paramArrayOfByte);
          continue;
          paramArrayOfByte = this.mResid;
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
      if ((this.mUiRequest.mUinType == 1) || (this.mUiRequest.mUinType == 3000)) {
        this.mReportInfo.put("param_grpUin", this.mUiRequest.mPeerUin);
      }
      this.mEndTime = System.currentTimeMillis();
      l = (System.nanoTime() - this.mStartTime) / 1000000L;
      str = this.mStepUrl.getReportInfo(1) + ";" + this.mStepTrans.getReportInfo(2) + ";" + this.mStepMsg.getReportInfo(3);
      this.mReportInfo.put("param_step", str);
      this.mReportInfo.put("param_busiType", this.mReportBusiType + "");
      HashMap localHashMap = this.mReportInfo;
      if (this.mResid != null) {
        break label516;
      }
      str = this.mUuid;
      label252:
      localHashMap.put("param_uuid", str);
      this.mReportInfo.put("param_toUin", this.mUiRequest.mPeerUin);
      this.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      this.mReportInfo.put("param_thumbSize", String.valueOf(this.mThumbFileSize));
      this.mReportInfo.put("param_isSecondTrans", this.mIsSecondTransfered + "");
      if (this.mUiRequest.mBusiType == 0) {
        this.mReportInfo.put("param_BDHExistBeforeVideoUpload", String.valueOf(this.isBDHExistBeforeVideoUpload));
      }
      if (this.mSwitch != 3) {
        this.mReportInfo.put("param_videoDuration", String.valueOf(this.videoTime));
      }
      this.mReportInfo.put("param_fileMd5", this.mUiRequest.mMd5);
      this.mReportInfo.put("param_BDH_Cache_Diff", String.valueOf(this.mIsCacheDiff));
      if (!paramBoolean) {
        break label525;
      }
      reportForIpv6(true, l);
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, getReportTAG(), true, l, this.mFileSize, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "AutoMonitor_fragment MineFragment onAttach");
      }
      reportMoovInfo();
      reportTemp(paramBoolean, l);
      return;
      i = 1;
      break;
      label516:
      str = this.mResid;
      break label252;
      label525:
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
  
  public void doStart()
  {
    if (this.mUiRequest.mIsPresend)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "is Presend ");
      }
      this.mSwitch = 3;
      this.mThumbFilePath = this.mUiRequest.mThumbPath;
      this.thumbFileMd5 = HexUtil.hexStr2Bytes(this.mUiRequest.mThumbMd5);
      if (buildThumbInfo()) {
        break label159;
      }
    }
    label157:
    label159:
    while (!handleBDHKey())
    {
      do
      {
        return;
      } while (!buildVideoMd5());
      if (((MessageForShortVideo)this.mUiRequest.mRec).busiType == 1) {
        if (VideoUpConfigInfo.sSwitch != 2) {}
      }
      for (this.mSwitch = 2;; this.mSwitch = 2) {
        do
        {
          if (ShortVideoPresendStats.lOldCompressCost <= 0L) {
            break label157;
          }
          this.mReportInfo.put("param_cost_c_comp", String.valueOf(ShortVideoPresendStats.lOldCompressCost));
          break;
        } while ((((MessageForShortVideo)this.mUiRequest.mRec).busiType != 2) || (PTVUpConfigInfo.sSwitch != 2));
      }
      break;
    }
    QLog.d("ShortVideoUploadProcessor", 1, "<BDH_LOG>mSwitch : " + this.mSwitch);
    switch (this.mSwitch)
    {
    default: 
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
  
  protected String getReportTAG()
  {
    if ((this.mUiRequest.mUinType == 1) || (this.mUiRequest.mUinType == 3000))
    {
      if (this.mChannelStatus == 1) {
        return "actShortVideoDiscussgroupUploadBDH";
      }
      return "actShortVideoDiscussgroupUpload";
    }
    if (this.mChannelStatus == 1) {
      return "actShortVideoUploadBDH";
    }
    return "actShortVideoUpload";
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
    if ((this.mSigSession == null) || (this.mSigSession.length == 0) || (this.mSessionKey == null) || (this.mSessionKey.length == 0))
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
    if ((this.mUiRequest.mExtraObj == null) || ((this.mUiRequest.mExtraObj instanceof bbqj)))
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
  
  public void onBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      if (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoUpResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.result);
        }
        this.mResid = paramRichProtoReq.fileId;
        if (paramRichProtoReq.result == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + paramRichProtoReq.isExist);
          }
          this.mVideoAttr = paramRichProtoReq.videoAttr;
          this.mVideoKandianType = paramRichProtoReq.videoKandianType;
          if (QLog.isColorLevel()) {
            QLog.d("ShortVideoUploadProcessor", 2, "onBusiProtoResp()------response.videoAttr = " + paramRichProtoReq.videoAttr + ", response.videoKandianType = " + paramRichProtoReq.videoKandianType);
          }
          if (paramRichProtoReq.isExist)
          {
            this.mIsSecondTransfered = true;
            sendMessageToUpdate(1007);
            sendMsg(true);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          this.mStartOffset = paramRichProtoReq.startOffset;
          log("<BDH_LOG> onBusiProtoResp() send by bdh");
          this.mChannelStatus = 1;
          sendFileByBDH();
          continue;
          onError();
        }
      }
    }
  }
  
  void onError()
  {
    super.onError();
    if ((this.mSwitch == 3) && (this.mMd5Str != null) && (this.mMd5Str.length() > 0)) {
      if (this.mUiRequest.mRec == null) {
        break label320;
      }
    }
    label320:
    for (Object localObject = this.mUiRequest.mRec;; localObject = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq))
    {
      if ((localObject != null) && ((localObject instanceof MessageForShortVideo))) {
        ((MessageForShortVideo)localObject).md5 = this.mMd5Str;
      }
      sendMessageToUpdate(1005);
      if (QLog.isColorLevel())
      {
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errCode:" + this.errCode);
        QLog.d("ShortVideoUploadProcessor", 2, "onError()---- errDesc:" + this.errDesc);
      }
      if (this.mUiRequest.mUpCallBack != null)
      {
        localObject = new ayep();
        ((ayep)localObject).jdField_a_of_type_Int = -1;
        ((ayep)localObject).b = this.errCode;
        ((ayep)localObject).jdField_a_of_type_JavaLangString = this.errDesc;
        this.mUiRequest.mUpCallBack.onSend((ayep)localObject);
      }
      if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForBlessPTV)))
      {
        this.app.getMsgHandler().notifyUI(999, false, this.mUiRequest.mRec.frienduin);
        ayde.a("ShortVideoUploadProcessor", "onError", "notifyUI bless ptv send error");
      }
      if ((this.mUiRequest.mRec != null) && ((this.mUiRequest.mRec instanceof MessageForDanceMachine)))
      {
        ((MessageForDanceMachine)this.mUiRequest.mRec).errorCode = 1;
        this.app.getMsgHandler().notifyUI(8034, false, this.mUiRequest.mRec);
        ayde.a("ShortVideoUploadProcessor", "onError", "notifyUI dance machine send error");
      }
      return;
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.mShortVideoTransManager != null) {
      this.mShortVideoTransManager.a(this.mUiRequest.mMd5 + this.mUiRequest.mPeerUin + this.mUiRequest.mUniseq);
    }
    String str;
    if (this.mUiRequest.mUpCallBack != null)
    {
      ayep localayep = new ayep();
      localayep.jdField_a_of_type_Int = 0;
      localayep.jdField_a_of_type_Long = (this.mFileSize - this.mThumbFileSize);
      localayep.jdField_d_of_type_JavaLangString = this.mMd5Str;
      if (this.mResid == null)
      {
        str = this.mUuid;
        localayep.jdField_c_of_type_JavaLangString = str;
        localayep.jdField_c_of_type_Long = this.mThumbFileSize;
        localayep.jdField_c_of_type_Int = this.mVideoAttr;
        localayep.jdField_d_of_type_Int = this.mVideoKandianType;
        this.mUiRequest.mUpCallBack.onSend(localayep);
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "onSuccess uuid = " + localayep.jdField_c_of_type_JavaLangString);
        }
      }
    }
    for (;;)
    {
      sendMessageToUpdate(1003);
      if (this.mUiRequest.mBusiType == 2) {
        checkRedbagVideoRealStat();
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "onSuccess().");
      }
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
      if ((this.mUiRequest.mBusiType == 1010) && (this.mUiRequest.mUpCallBack != null))
      {
        ayep localayep = new ayep();
        localayep.jdField_a_of_type_Int = -1;
        localayep.b = 9037;
        localayep.jdField_a_of_type_JavaLangString = "cancel";
        this.mUiRequest.mUpCallBack.onSend(localayep);
      }
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
  
  protected void reportMoovInfo()
  {
    if (((MessageForShortVideo)this.mUiRequest.mRec).busiType == 0) {
      ThreadManager.post(new ShortVideoUploadProcessor.7(this, this.mUiRequest.mLocalPath), 5, null, true);
    }
  }
  
  protected void reportTemp(boolean paramBoolean, long paramLong)
  {
    if ((this.mTrans != null) && (this.mChannelStatus == 1) && (this.app != null) && (this.app.getHwEngine() != null) && (this.app.getHwEngine().getCurrentConfig().segNum > 32L))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("segNum", String.valueOf(this.app.getHwEngine().getCurrentConfig().segNum));
      localHashMap.put("param_FailCode", String.valueOf(this.errCode));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "tempVideoUploadBDH", paramBoolean, paramLong, this.mFileSize, localHashMap, "");
    }
  }
  
  public int resume()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "resume()  + mIsPause : " + this.mIsPause);
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
      resetStatictisInfo();
      sendMessageToUpdate(1001);
      this.mController.mHandler.post(new ShortVideoUploadProcessor.1(this));
    }
    return 0;
  }
  
  public void sendFileByBDH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG> sendFileByBDH Start.   this:" + this);
    }
    this.mStepTrans.logStartTime();
    if (this.mTrans != null) {}
    int j;
    do
    {
      return;
      long l = SystemClock.uptimeMillis();
      Object localObject = combineThumbAndVideo();
      RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = makeShortVideoUpReq();
      byte[] arrayOfByte = buildExtendInfo(localShortVideoUpReq);
      ShortVideoUploadProcessor.4 local4 = new ShortVideoUploadProcessor.4(this, (String)localObject, l);
      int i = 12;
      if (localShortVideoUpReq.busiType == 0) {
        i = 25;
      }
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), i, (String)localObject, (int)this.mStartOffset, this.mLocalMd5, local4, arrayOfByte, true);
      localObject = new ShortVideoUploadProcessor.5(this);
      this.mTrans.cbForReport = ((ITransCallbackForReport)localObject);
      j = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + j + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + i);
      }
    } while (j == 0);
    setError(j, "sendFileByBDH SubmitError.", "", this.mStepTrans);
    onError();
  }
  
  protected void sendMessageToUpdate(int paramInt)
  {
    super.sendMessageToUpdate(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendMessageToUpdate------state = " + paramInt + ", str= " + ShortVideoUtils.getFileStatusStr(paramInt));
    }
    if ((this.mIsPause) && (1004 != paramInt)) {
      return;
    }
    bbqf.a(this.app, this.file, this.mUiRequest);
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
    Object localObject2;
    if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof bbrp)))
    {
      localObject2 = (bbrp)this.mUiRequest.mExtraObj;
      this.mNeedSyncStory = ((bbrp)localObject2).jdField_g_of_type_Boolean;
      localObject1 = localObject2;
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, mNeedSyncStory = " + this.mNeedSyncStory);
      }
    }
    for (Object localObject1 = localObject2;; localObject1 = null)
    {
      if (localObject1 != null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("ShortVideoUploadProcessor", 2, "sendMsg() start, isHotVideo = " + localObject1.jdField_e_of_type_Boolean);
        }
        if (localObject1.jdField_e_of_type_Boolean)
        {
          this.mUuid = localObject1.jdField_a_of_type_JavaLangString;
          this.mMd5Str = localObject1.jdField_e_of_type_JavaLangString;
          this.mLocalMd5 = HexUtil.hexStr2Bytes(localObject1.jdField_e_of_type_JavaLangString);
          this.mFileSize = (localObject1.jdField_e_of_type_Int + localObject1.b);
          this.videoTime = localObject1.f;
          this.mThumbFileSize = localObject1.b;
          this.thumbFileMd5 = HexUtil.hexStr2Bytes(localObject1.jdField_g_of_type_JavaLangString);
          this.mThumbFileHeight = localObject1.jdField_d_of_type_Int;
          this.mThumbFileWidth = localObject1.jdField_c_of_type_Int;
        }
      }
      if (!this.needSendMsg) {
        break;
      }
      bfwl.a(String.valueOf(this.mUiRequest.mUniseq), "message", "sendMsg() start.");
      this.mStepMsg.logStartTime();
      localObject2 = constructRichText();
      if (localObject2 == null)
      {
        setError(9368, "constructpberror", null, this.mStepMsg);
        onError();
        return;
      }
      doSendMsg((im_msg_body.RichText)localObject2, localObject1, paramBoolean);
      return;
    }
  }
  
  void sendRequest()
  {
    this.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    if (QLog.isColorLevel()) {
      QLog.d("ShortVideoUploadProcessor", 2, "sendGetUrlReq()----busiReq.seq : " + this.mUiRequest.mUniseq);
    }
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = makeShortVideoUpReq();
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "short_video_up";
    localRichProtoReq.reqs.add(localShortVideoUpReq);
    localRichProtoReq.protoReqMgr = this.app.getProtoReqManager();
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    do
    {
      return;
      if (localShortVideoUpReq.fileSize == 0L)
      {
        setError(9303, "video filesize is 0");
        onError();
        return;
      }
      if (this.mThumbFileSize == 0L)
      {
        setError(9303, "thumbfile filesize is 0");
        onError();
        return;
      }
      if ((localShortVideoUpReq.busiType == 0) && (this.app.getHwEngine().mConnManager.getCurrentConnNum() > 0)) {
        this.isBDHExistBeforeVideoUpload = Boolean.valueOf(true);
      }
      logRichMediaEvent("requestStart", localRichProtoReq.toString());
    } while (!canDoNextStep());
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
    if (((MessageForShortVideo)this.mUiRequest.mRec).CheckIsHotVideo())
    {
      handleHotVideo();
      return;
    }
    if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof bbrp))) {
      this.isFromFavorite = ((bbrp)this.mUiRequest.mExtraObj).jdField_i_of_type_Boolean;
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
      if (localMessageRecord != null) {
        break label78;
      }
      logRichMediaEvent("updateDb", "msg null");
    }
    label78:
    while (!(localMessageRecord instanceof MessageForShortVideo))
    {
      return;
      localMessageRecord = this.app.getMessageFacade().getMsgItemByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, this.mUiRequest.mUniseq);
      logRichMediaEvent("updateDb", "findmsgbyMsgId,need fix");
      break;
    }
    MessageForShortVideo localMessageForShortVideo = (MessageForShortVideo)localMessageRecord;
    localMessageForShortVideo.videoFileSize = ((int)(this.mFileSize - this.mThumbFileSize));
    if (this.mResid == null) {}
    for (String str = this.mUuid;; str = this.mResid)
    {
      localMessageForShortVideo.uuid = str;
      localMessageForShortVideo.md5 = this.mMd5Str;
      localMessageForShortVideo.videoAttr = this.mVideoAttr;
      localMessageForShortVideo.videoKandianType = this.mVideoKandianType;
      localMessageForShortVideo.serial();
      this.app.getMessageFacade().updateMsgContentByUniseq(this.mUiRequest.mPeerUin, this.mUiRequest.mUinType, localMessageRecord.uniseq, localMessageForShortVideo.msgData);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ShortVideoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */