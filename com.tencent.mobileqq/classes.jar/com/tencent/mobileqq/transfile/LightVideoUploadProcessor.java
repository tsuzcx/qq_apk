package com.tencent.mobileqq.transfile;

import amtj;
import amwl;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import android.os.Handler;
import android.os.SystemClock;
import ayeo;
import ayep;
import bahm;
import baid;
import baie;
import barq;
import bbxa;
import bbxb;
import com.qq.taf.jce.HexUtil;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForLightVideo;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.PicInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoReqExtInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.ShortVideoSureReqInfo;
import com.tencent.mobileqq.highway.protocol.Bdh_extinfo.VideoInfo;
import com.tencent.mobileqq.highway.segment.RequestAck;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.highway.utils.VideoUpConfigInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.MessageMicro;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.ShortVideoUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.ShortVideoUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.Cryptor;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pttcenterservice.PttShortVideo.PttShortVideoFileInfo;
import pttcenterservice.PttShortVideo.PttShortVideoUploadReq;
import tencent.im.msg.hummer.resv.videoFile.ResvAttr;
import tencent.im.msg.hummer.resv1.TextMsgExtPb.ResvAttr;
import tencent.im.msg.hummer.servtype.hummer_commelem.MsgElemInfo_servtype27;
import tencent.im.msg.im_msg_body.CommonElem;
import tencent.im.msg.im_msg_body.Elem;
import tencent.im.msg.im_msg_body.RichText;
import tencent.im.msg.im_msg_body.Text;
import tencent.im.msg.im_msg_body.VideoFile;

public class LightVideoUploadProcessor
  extends BaseShortVideoUploadProcessor
{
  public static final int LIGHT_VIDEO_SUB_BUSINESS_TYPE = 3;
  public static final String REPORT_LIGHT_VIDEO_COMPLETE_SEND = "LightVideoSendComplete";
  public static final String REPORT_LIGHT_VIDEO_SEND = "LightVideoSend";
  public static final String REPORT_PARAM_SEGMENT_ERROR_CODE = "segment_error_code";
  public static final String REPORT_PARAM_UPLOAD_SEGMENT_FAIL_FLAG = "upload_segment_fail_flag";
  public static final String REPORT_PARAM_UPLOAD_SUC_FLAG = "upload_suc_flag";
  public static final String REPORT_PARAM_UPLOAD_TYPE = "upload_type";
  public static final int SEND_LIMIT = 3;
  public static final String TAG = "LightVideoUploadProcessor";
  public static final int UPLOAD_COMPLETE_FILE = 2;
  public static final int UPLOAD_ENCODE_SEGMNT_ERROR_COMPLETE_FILE = 4;
  public static final int UPLOAD_SLICE = 0;
  public static final int UPLOAD_SLICE_FAIL_COMPLETE_FILE = 1;
  public static boolean mIsPreSendAckToBDHServer;
  QQAppInterface app = (QQAppInterface)this.app;
  private volatile int mCacheIp;
  baid mCombineInfo;
  private Handler mHandler;
  String mLocalFilePath;
  int mLocalVideoTime;
  private MessageForLightVideo mMessage;
  amwl mMessageObserver = new LightVideoUploadProcessor.1(this);
  ArrayList<baid> mReadyToSendInfos = new ArrayList();
  RequestAck mRequestAck;
  boolean mSendFileSliceFailed = false;
  Map<Integer, baid> mSendingInfos = new HashMap();
  long mSessionId;
  protected int mThumbFileHeight;
  private byte[] mThumbFileMd5;
  private String mThumbFilePath;
  private long mThumbFileSize;
  protected int mThumbFileWidth;
  Bdh_extinfo.PicInfo mThumbInfo;
  protected RandomAccessFile mThumbRaf;
  List<Transaction> mTransactions = new ArrayList();
  int mUploadType = -1;
  Map<Integer, Bdh_extinfo.VideoInfo> mVideoInfos = new HashMap();
  private baie mVideoSend;
  private long mVideoTime;
  
  public LightVideoUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    paramBaseTransFileController = paramTransferRequest.extraObject;
    if ((paramBaseTransFileController != null) && ((paramBaseTransFileController instanceof baie))) {
      this.mVideoSend = ((baie)paramTransferRequest.extraObject);
    }
    if ((this.mController != null) && (this.mController.mHandler != null)) {
      this.mHandler = this.mController.mHandler;
    }
    this.mMessage = ((MessageForLightVideo)paramTransferRequest.mRec);
    mIsPreSendAckToBDHServer = VideoUpConfigInfo.sIsPreSendSignal;
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
          QLog.d("LightVideoUploadProcessor", 2, "constructRichText ,mResid uuid=" + this.mResid + " mLocalVideoTime:" + this.mLocalVideoTime + " mVideoTime:" + this.mVideoTime);
        }
        if (!(this.mUiRequest.mRec instanceof MessageForLightVideo)) {
          break label657;
        }
        Object localObject1 = (MessageForLightVideo)this.mUiRequest.mRec;
        Object localObject3;
        if (localObject1 != null)
        {
          localVideoFile.bytes_source.set(ByteStringMicro.copyFromUtf8(((MessageForLightVideo)localObject1).fileSource));
          localVideoFile.uint32_busi_type.set(((MessageForLightVideo)localObject1).busiType);
          localVideoFile.bool_support_progressive.set(((MessageForLightVideo)localObject1).supportProgressive);
          localVideoFile.uint32_file_width.set(((MessageForLightVideo)localObject1).fileWidth);
          localVideoFile.uint32_file_height.set(((MessageForLightVideo)localObject1).fileHeight);
          localVideoFile.uint32_sub_busi_type.set(((MessageForLightVideo)localObject1).subBusiType);
          localObject3 = new videoFile.ResvAttr();
          ((videoFile.ResvAttr)localObject3).uint32_msg_tail_type.set(((MessageForLightVideo)localObject1).msgTailType);
          localVideoFile.bytes_file_name.set(ByteStringMicro.copyFromUtf8(this.mUiRequest.mLocalPath));
          localVideoFile.bytes_file_md5.set(ByteStringMicro.copyFrom(HexUtil.hexStr2Bytes(this.mUiRequest.mMd5)));
          localVideoFile.bytes_pb_reserve.set(ByteStringMicro.copyFrom(((videoFile.ResvAttr)localObject3).toByteArray()));
          localVideoFile.uint32_video_attr.set(0);
        }
        localVideoFile.uint32_file_format.set(2);
        localVideoFile.uint32_file_size.set((int)(this.mFileSize - this.mThumbFileSize));
        if (this.mLocalVideoTime == 0)
        {
          if ((this.mVideoSend != null) && (this.mVideoSend.jdField_b_of_type_Int != 0))
          {
            localVideoFile.uint32_file_time.set(this.mVideoSend.jdField_b_of_type_Int / 1000);
            localVideoFile.uint32_thumb_width.set(this.mThumbFileWidth);
            localVideoFile.uint32_thumb_height.set(this.mThumbFileHeight);
            localVideoFile.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(this.mThumbFileMd5));
            localVideoFile.uint32_thumb_file_size.set((int)this.mThumbFileSize);
            localVideoFile.uint32_from_chat_type.set(-1);
            localVideoFile.uint32_to_chat_type.set(-1);
            localObject3 = new im_msg_body.Text();
            ((im_msg_body.Text)localObject3).setHasFlag(true);
            localObject1 = amtj.a(2131705182);
            ((im_msg_body.Text)localObject3).str.set(ByteStringMicro.copyFromUtf8(BaseApplication.getContext().getString(2131691170)));
            Object localObject4 = new TextMsgExtPb.ResvAttr();
            ((TextMsgExtPb.ResvAttr)localObject4).wording.set(ByteStringMicro.copyFromUtf8((String)localObject1));
            ((im_msg_body.Text)localObject3).bytes_pb_reserve.set(ByteStringMicro.copyFrom(((TextMsgExtPb.ResvAttr)localObject4).toByteArray()));
            localObject1 = new im_msg_body.Elem();
            ((im_msg_body.Elem)localObject1).text.set((MessageMicro)localObject3);
            localObject3 = new im_msg_body.Elem();
            localObject4 = new im_msg_body.CommonElem();
            ((im_msg_body.CommonElem)localObject4).uint32_service_type.set(27);
            ((im_msg_body.CommonElem)localObject4).uint32_business_type.set(1);
            hummer_commelem.MsgElemInfo_servtype27 localMsgElemInfo_servtype27 = new hummer_commelem.MsgElemInfo_servtype27();
            localMsgElemInfo_servtype27.video_file.set(localVideoFile);
            ((im_msg_body.CommonElem)localObject4).bytes_pb_elem.set(ByteStringMicro.copyFrom(localMsgElemInfo_servtype27.toByteArray()));
            ((im_msg_body.Elem)localObject3).common_elem.set((MessageMicro)localObject4);
            localRichText.elems.add((MessageMicro)localObject1);
            localRichText.elems.add((MessageMicro)localObject3);
            return localRichText;
          }
          localVideoFile.uint32_file_time.set((int)this.mVideoTime);
          continue;
        }
        localVideoFile.uint32_file_time.set(this.mLocalVideoTime);
      }
      catch (Exception localException)
      {
        if (QLog.isColorLevel()) {
          QLog.e("LightVideoUploadProcessor", 2, "Construct richtext error", localException);
        }
        localException.printStackTrace();
        return null;
      }
      continue;
      label657:
      Object localObject2 = null;
    }
  }
  
  private boolean initRandomRaf()
  {
    if ((this.mThumbRaf != null) && (this.mRaf != null)) {}
    for (;;)
    {
      return true;
      if (this.mThumbRaf == null) {
        try
        {
          this.mThumbRaf = new RandomAccessFile(this.mThumbFilePath, "r");
          if (this.mThumbRaf == null) {
            return false;
          }
        }
        catch (FileNotFoundException localFileNotFoundException1)
        {
          for (;;)
          {
            localFileNotFoundException1.printStackTrace();
            this.mThumbRaf = null;
          }
        }
      }
      if (this.mRaf != null) {
        continue;
      }
      try
      {
        this.mRaf = new RandomAccessFile(this.mLocalFilePath, "r");
        if (this.mRaf != null) {
          continue;
        }
        return false;
      }
      catch (FileNotFoundException localFileNotFoundException2)
      {
        for (;;)
        {
          localFileNotFoundException2.printStackTrace();
          this.mRaf = null;
        }
      }
    }
  }
  
  private RichProto.RichProtoReq.ShortVideoUpReq makeShortVideoUpReq()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "makeShortVideoUpReq");
    }
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = new RichProto.RichProtoReq.ShortVideoUpReq();
    localShortVideoUpReq.seq = ((int)this.mUiRequest.mUniseq);
    localShortVideoUpReq.selfUin = this.mUiRequest.mSelfUin;
    localShortVideoUpReq.peerUin = this.mUiRequest.mPeerUin;
    localShortVideoUpReq.uinType = this.mUiRequest.mUinType;
    localShortVideoUpReq.agentType = 0;
    if ((localShortVideoUpReq.uinType == 0) || (1008 == localShortVideoUpReq.uinType))
    {
      localShortVideoUpReq.troopUin = null;
      if (localShortVideoUpReq.uinType != 0) {
        break label255;
      }
      localShortVideoUpReq.chatType = 0;
    }
    for (;;)
    {
      localShortVideoUpReq.clientType = 2;
      Object localObject = new File(this.mLocalFilePath);
      localShortVideoUpReq.fileName = ((File)localObject).getName();
      localShortVideoUpReq.fileSize = ((File)localObject).length();
      localShortVideoUpReq.md5 = this.mLocalMd5;
      localShortVideoUpReq.thumbFileMd5 = this.mThumbFileMd5;
      localShortVideoUpReq.fileResWidth = this.mThumbFileWidth;
      localShortVideoUpReq.fileResLength = this.mThumbFileHeight;
      localShortVideoUpReq.fileTime = this.mLocalVideoTime;
      localShortVideoUpReq.thumbFileSize = this.mThumbFileSize;
      localObject = this.file;
      long l = localShortVideoUpReq.fileSize + this.mThumbFileSize;
      this.mFileSize = l;
      ((FileMsg)localObject).fileSize = l;
      localShortVideoUpReq.format = 3;
      localShortVideoUpReq.subBusiType = 3;
      localShortVideoUpReq.busiType = this.mMessage.busiType;
      return localShortVideoUpReq;
      localShortVideoUpReq.troopUin = this.mUiRequest.mPeerUin;
      break;
      label255:
      if (1 == localShortVideoUpReq.uinType) {
        localShortVideoUpReq.chatType = 1;
      } else if (3000 == localShortVideoUpReq.uinType) {
        localShortVideoUpReq.chatType = 2;
      } else {
        localShortVideoUpReq.chatType = 3;
      }
    }
  }
  
  private void sendFileByBDH()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendFileByBDH");
    }
    long l = SystemClock.uptimeMillis();
    if (!initRandomRaf())
    {
      setError(9303, "read  file error");
      onError();
      return;
    }
    String str = combineThumbAndVideo();
    Object localObject1 = makeShortVideoUpReq();
    Object localObject2 = new PttShortVideo.PttShortVideoUploadReq();
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).setHasFlag(true);
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_fromuin.set(Long.parseLong(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).selfUin));
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_touin.set(Long.parseLong(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).peerUin));
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_chat_type.set(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).chatType);
    ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_client_type.set(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).clientType);
    if (((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).troopUin != null) {
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_group_code.set(Long.parseLong(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).troopUin));
    }
    for (;;)
    {
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_agent_type.set(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).agentType);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_business_type.set(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).busiType);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_flag_support_large_size.set(1);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint32_sub_business_type.set(3);
      PttShortVideo.PttShortVideoFileInfo localPttShortVideoFileInfo = new PttShortVideo.PttShortVideoFileInfo();
      localPttShortVideoFileInfo.str_file_name.set(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).fileName);
      localPttShortVideoFileInfo.bytes_file_md5.set(ByteStringMicro.copyFrom(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).md5));
      localPttShortVideoFileInfo.bytes_thumb_file_md5.set(ByteStringMicro.copyFrom(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).thumbFileMd5));
      localPttShortVideoFileInfo.uint64_file_size.set(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).fileSize);
      localPttShortVideoFileInfo.uint32_file_res_length.set(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).fileResLength);
      localPttShortVideoFileInfo.uint32_file_res_width.set(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).fileResWidth);
      localPttShortVideoFileInfo.uint32_file_format.set(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).format);
      localPttShortVideoFileInfo.uint32_file_time.set(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).fileTime);
      localPttShortVideoFileInfo.uint64_thumb_file_size.set(((RichProto.RichProtoReq.ShortVideoUpReq)localObject1).thumbFileSize);
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).msg_PttShortVideoFileInfo.set(localPttShortVideoFileInfo);
      localObject1 = ((PttShortVideo.PttShortVideoUploadReq)localObject2).toByteArray();
      localObject1 = new Cryptor().encrypt((byte[])localObject1, this.mSessionKey);
      localObject2 = new LightVideoUploadProcessor.3(this, str, l);
      this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 12, str, (int)this.mStartOffset, this.mSigSession, this.mLocalMd5, (ITransactionCallback)localObject2, (byte[])localObject1);
      int i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendFileByBDH Transaction submit RetCode:" + i + " T_ID:" + this.mTrans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD5:" + this.mMd5Str + " uuid:" + this.mUuid + " Path:" + this.mTrans.filePath + " Cmd:" + 12);
      }
      if (i == 0) {
        break;
      }
      setError(i, "sendFileByBDH SubmitError.", "", this.mStepTrans);
      onError();
      return;
      ((PttShortVideo.PttShortVideoUploadReq)localObject2).uint64_group_code.set(0L);
    }
  }
  
  public void addToSendQuene(baid parambaid)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "addToSendQuene, info:" + parambaid + " mSendingInfos:" + this.mSendingInfos.size() + " mReadyToSendInfos:" + this.mReadyToSendInfos.size() + " mUploadType" + this.mUploadType);
    }
    if (parambaid.c())
    {
      this.mCombineInfo = parambaid;
      checkNeedSendCompleteFile();
    }
    while (this.mUploadType != 0) {
      return;
    }
    FileMsg localFileMsg = this.file;
    localFileMsg.fileSize += parambaid.jdField_a_of_type_Long;
    this.mFileSize += parambaid.jdField_a_of_type_Long;
    this.mReadyToSendInfos.add(parambaid);
    sendSlice();
  }
  
  public int cancel()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "cancel");
    }
    Iterator localIterator = this.mTransactions.iterator();
    while (localIterator.hasNext()) {
      ((Transaction)localIterator.next()).cancelTransaction();
    }
    if (this.mTrans != null) {
      this.mTrans.cancelTransaction();
    }
    if (this.mRequestAck != null)
    {
      this.app.getHwEngine().cancelAckRequest(this.mRequestAck);
      this.mRequestAck = null;
    }
    this.mVideoSend = null;
    return super.cancel();
  }
  
  public void checkNeedSendCompleteFile()
  {
    int j = 1;
    if (QLog.isColorLevel()) {
      QLog.d("VideoSend", 2, "checkNeedSendCompleteFile check, mUploadType:" + this.mUploadType + " mSendFileSliceFailed:" + this.mSendFileSliceFailed + " mCombineInfo:" + this.mCombineInfo);
    }
    int i;
    if (this.mUploadType == 0) {
      if (this.mSendFileSliceFailed)
      {
        this.mUploadType = 1;
        i = j;
      }
    }
    for (;;)
    {
      if ((i != 0) && (this.mCombineInfo != null))
      {
        this.mUiRequest.mLocalPath = this.mCombineInfo.jdField_a_of_type_JavaLangString;
        this.mUiRequest.mMd5 = this.mCombineInfo.jdField_b_of_type_JavaLangString;
        this.mUiRequest.mIsPresend = false;
        this.mLocalFilePath = this.mCombineInfo.jdField_a_of_type_JavaLangString;
        this.mLocalMd5 = HexUtil.hexStr2Bytes(this.mCombineInfo.jdField_b_of_type_JavaLangString);
        FileMsg localFileMsg = this.file;
        String str = this.mCombineInfo.jdField_b_of_type_JavaLangString;
        localFileMsg.fileMd5 = str;
        this.mMd5Str = str;
        this.mFileSize = this.mCombineInfo.jdField_a_of_type_Long;
        this.mLocalVideoTime = (this.mCombineInfo.e / 1000);
        sendCompleteFile();
      }
      return;
      if ((this.mCombineInfo != null) && (!this.mCombineInfo.jdField_a_of_type_Boolean))
      {
        this.mUploadType = 4;
        i = j;
        continue;
        i = j;
        if (this.mUploadType != 2)
        {
          i = j;
          if (this.mUploadType == 1) {}
        }
      }
      else
      {
        i = 0;
      }
    }
  }
  
  protected void doReport(boolean paramBoolean)
  {
    long l;
    if ((this.mVideoSend != null) && (this.mVideoSend.jdField_b_of_type_Long != 0L))
    {
      l = System.currentTimeMillis() - this.mVideoSend.jdField_b_of_type_Long;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "doReport, timeCost:" + l + " mFileSize:" + this.mFileSize + " mUploadType:" + this.mUploadType + " errorCode:" + this.errCode);
      }
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      if (!paramBoolean) {
        break label194;
      }
      this.mReportInfo.put("upload_suc_flag", "1");
    }
    while ((this.mUploadType == 0) || (this.mUploadType == 1))
    {
      if (this.mUploadType == 1) {
        this.mReportInfo.put("upload_segment_fail_flag", "1");
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "LightVideoSend", paramBoolean, l, this.mFileSize, this.mReportInfo, null);
      return;
      label194:
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
    }
    this.mReportInfo.put("upload_type", String.valueOf(this.mUploadType));
    StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "LightVideoSendComplete", paramBoolean, l, this.mFileSize, this.mReportInfo, null);
  }
  
  protected void finalize()
  {
    super.finalize();
    if (this.mThumbRaf != null) {}
    try
    {
      this.mThumbRaf.close();
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
      return;
    }
    finally
    {
      this.mThumbRaf = null;
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
        paramRichProtoReq = (RichProto.RichProtoResp.ShortVideoUpResp)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        if (QLog.isColorLevel()) {
          QLog.d("LightVideoUploadProcessor", 2, "onBusiProtoResp()------response.result = " + paramRichProtoReq.result);
        }
        this.mResid = paramRichProtoReq.fileId;
        if (paramRichProtoReq.result == 0)
        {
          if (QLog.isColorLevel()) {
            QLog.d("LightVideoUploadProcessor", 2, "onBusiProtoResp()------response.isExist = " + paramRichProtoReq.isExist);
          }
          if (paramRichProtoReq.isExist)
          {
            sendMessageToUpdate(1007);
            sendMsg(true);
          }
        }
        for (;;)
        {
          i += 1;
          break;
          if (checkBDHSessionValid())
          {
            sendFileByBDH();
          }
          else
          {
            onError();
            continue;
            setError(paramRichProtoReq.result, "onBusiProtoResp error");
            onError();
          }
        }
      }
    }
  }
  
  void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "onError");
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      ayep localayep = new ayep();
      localayep.jdField_a_of_type_Int = -1;
      localayep.jdField_b_of_type_Int = this.errCode;
      localayep.jdField_a_of_type_JavaLangString = this.errDesc;
      this.mUiRequest.mUpCallBack.onSend(localayep);
    }
  }
  
  void onSendFileSliceFailed(int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "onSendFileSliceFailed, mSendFileSliceFailed:" + this.mSendFileSliceFailed + " mUploadType:" + this.mUploadType + " errCode:" + paramInt);
    }
    this.mSendFileSliceFailed = true;
    this.mReportInfo.put("segment_error_code", String.valueOf(paramInt));
    Iterator localIterator = this.mTransactions.iterator();
    while (localIterator.hasNext()) {
      ((Transaction)localIterator.next()).cancelTransaction();
    }
    if (this.mUploadType == 0) {
      checkNeedSendCompleteFile();
    }
  }
  
  public void onSendSliceFinish(baid parambaid)
  {
    this.mHandler.post(new LightVideoUploadProcessor.5(this, parambaid));
  }
  
  void onSuccess()
  {
    this.errCode = 0;
    super.onSuccess();
    ayep localayep = new ayep();
    localayep.jdField_a_of_type_Int = 0;
    localayep.jdField_a_of_type_Long = (this.mFileSize - this.mThumbFileSize);
    localayep.d = this.mMd5Str;
    if (this.mResid == null) {}
    for (String str = this.mUuid;; str = this.mResid)
    {
      localayep.jdField_c_of_type_JavaLangString = str;
      localayep.jdField_c_of_type_Long = this.mThumbFileSize;
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "onSuccess uuid = " + localayep.jdField_c_of_type_JavaLangString);
      }
      if (this.mUiRequest.mUpCallBack == null) {
        break;
      }
      this.mUiRequest.mUpCallBack.onSend(localayep);
      this.mHandler.post(new LightVideoUploadProcessor.2(this));
      return;
    }
    this.mMessage.uuid = localayep.jdField_c_of_type_JavaLangString;
    this.mMessage.md5 = localayep.d;
    sendMessageToUpdate(1003);
  }
  
  public void sendAckToBDHServer()
  {
    int j = 0;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendAckToBDHServer");
    }
    long l1 = this.mSessionId;
    Bdh_extinfo.PicInfo localPicInfo = this.mThumbInfo;
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i <= this.mVideoInfos.size())
    {
      localObject = (Bdh_extinfo.VideoInfo)this.mVideoInfos.get(Integer.valueOf(i));
      if (localObject != null) {
        localArrayList.add(localObject);
      }
      i += 1;
    }
    Object localObject = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint32_cmd.set(3);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint64_session_id.set(l1);
    Bdh_extinfo.ShortVideoSureReqInfo localShortVideoSureReqInfo;
    long l2;
    if (mIsPreSendAckToBDHServer)
    {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(true);
      localShortVideoSureReqInfo = new Bdh_extinfo.ShortVideoSureReqInfo();
      l1 = Long.parseLong(this.mUiRequest.mSelfUin);
      l2 = Long.parseLong(this.mUiRequest.mPeerUin);
      localShortVideoSureReqInfo.uint64_fromuin.set(l1);
      localShortVideoSureReqInfo.uint64_touin.set(l2);
      if ((this.mUiRequest.mUinType != 0) && (1008 != this.mUiRequest.mUinType)) {
        break label328;
      }
      localShortVideoSureReqInfo.uint64_group_code.set(0L);
      label217:
      if (this.mUiRequest.mUinType != 0) {
        break label341;
      }
      i = j;
    }
    for (;;)
    {
      j = ((MessageForLightVideo)this.mUiRequest.mRec).busiType;
      localShortVideoSureReqInfo.uint32_chat_type.set(i);
      localShortVideoSureReqInfo.uint32_business_type.set(j);
      localShortVideoSureReqInfo.uint32_sub_business_type.set(3);
      localShortVideoSureReqInfo.uint32_client_type.set(2);
      localShortVideoSureReqInfo.msg_thumbinfo.set(localPicInfo);
      localShortVideoSureReqInfo.rpt_msg_merge_videoinfo.set(localArrayList);
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_shortvideo_sure_req.set(localShortVideoSureReqInfo);
      submitAck((Bdh_extinfo.ShortVideoReqExtInfo)localObject);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(false);
      break;
      label328:
      localShortVideoSureReqInfo.uint64_group_code.set(l2);
      break label217;
      label341:
      if (1 == this.mUiRequest.mUinType) {
        i = 1;
      } else if (3000 == this.mUiRequest.mUinType) {
        i = 2;
      } else {
        i = 3;
      }
    }
  }
  
  void sendAudioSliceByBDH(baid parambaid)
  {
    String str = parambaid.jdField_a_of_type_JavaLangString;
    int i = (int)new File(str).length();
    byte[] arrayOfByte1 = this.mThumbFileMd5;
    byte[] arrayOfByte2 = HexUtil.hexStr2Bytes(parambaid.jdField_b_of_type_JavaLangString);
    int j = parambaid.d;
    int k = parambaid.jdField_b_of_type_Int;
    int m = parambaid.jdField_a_of_type_Int;
    int n = parambaid.e;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendVideoSegByBDH  filePath:" + str + " index :" + j + " md5:" + HexUtil.bytes2HexStr(arrayOfByte2) + "fileSize:" + i);
    }
    Object localObject1 = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint32_cmd.set(2);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint64_session_id.set(this.mSessionId);
    if (mIsPreSendAckToBDHServer) {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Object localObject2 = new Bdh_extinfo.VideoInfo();
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_size.set(i);
      ((Bdh_extinfo.VideoInfo)localObject2).bytes_bin_md5.set(ByteStringMicro.copyFrom(arrayOfByte2));
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_format.set(2);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_len.set(k);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_width.set(m);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_time.set(n);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_idx.set(j);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_is_audio.set(1);
      this.mVideoInfos.put(Integer.valueOf(j), localObject2);
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_videoinfo.set((MessageMicro)localObject2);
      if (this.mThumbInfo != null) {
        ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_thumbinfo.set(this.mThumbInfo);
      }
      localObject1 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).toByteArray(), this.mSessionKey);
      localObject2 = new LightVideoUploadProcessor.FileSlice(this);
      ((LightVideoUploadProcessor.FileSlice)localObject2).path = str;
      ((LightVideoUploadProcessor.FileSlice)localObject2).ticket = this.mSigSession;
      ((LightVideoUploadProcessor.FileSlice)localObject2).thumbMD5 = arrayOfByte1;
      ((LightVideoUploadProcessor.FileSlice)localObject2).extendInfo = ((byte[])localObject1);
      ((LightVideoUploadProcessor.FileSlice)localObject2).index = j;
      ((LightVideoUploadProcessor.FileSlice)localObject2).fileMD5 = arrayOfByte2;
      ((LightVideoUploadProcessor.FileSlice)localObject2).sendInfo = parambaid;
      ((LightVideoUploadProcessor.FileSlice)localObject2).fileSize = i;
      sendFileSliceByBDH((LightVideoUploadProcessor.FileSlice)localObject2);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  public void sendCompleteFile()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG> sendCompleteFile Start.   this:" + this);
    }
    if (!checkBDHSessionValid()) {
      initBDHSession();
    }
    if (!checkBDHSessionValid())
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "session is null, sendRequest ");
      }
      sendRequest();
      return;
    }
    sendFileByBDH();
  }
  
  /* Error */
  void sendFileSliceByBDH(LightVideoUploadProcessor.FileSlice paramFileSlice)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_1
    //   3: getfield 1128	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$FileSlice:path	Ljava/lang/String;
    //   6: astore 5
    //   8: aload_1
    //   9: getfield 1131	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$FileSlice:ticket	[B
    //   12: astore 6
    //   14: aload_1
    //   15: getfield 1134	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$FileSlice:thumbMD5	[B
    //   18: astore 7
    //   20: aload_1
    //   21: getfield 1137	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$FileSlice:extendInfo	[B
    //   24: astore 8
    //   26: aload_1
    //   27: getfield 1140	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$FileSlice:index	I
    //   30: istore_2
    //   31: aload_1
    //   32: getfield 1143	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$FileSlice:fileMD5	[B
    //   35: astore 9
    //   37: aload_1
    //   38: getfield 1146	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$FileSlice:sendInfo	Lbaid;
    //   41: astore 9
    //   43: aload_1
    //   44: getfield 1147	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$FileSlice:fileSize	J
    //   47: lstore_3
    //   48: new 1163	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$TransactionListener
    //   51: dup
    //   52: aload_0
    //   53: invokespecial 1164	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$TransactionListener:<init>	(Lcom/tencent/mobileqq/transfile/LightVideoUploadProcessor;)V
    //   56: astore_1
    //   57: new 691	com/tencent/mobileqq/highway/transaction/Transaction
    //   60: dup
    //   61: aload_0
    //   62: getfield 121	com/tencent/mobileqq/transfile/LightVideoUploadProcessor:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   65: invokevirtual 694	com/tencent/mobileqq/app/QQAppInterface:getCurrentAccountUin	()Ljava/lang/String;
    //   68: bipush 16
    //   70: aload 5
    //   72: iconst_0
    //   73: aload 6
    //   75: aload 7
    //   77: aload_1
    //   78: aload 8
    //   80: invokespecial 703	com/tencent/mobileqq/highway/transaction/Transaction:<init>	(Ljava/lang/String;ILjava/lang/String;I[B[BLcom/tencent/mobileqq/highway/api/ITransactionCallback;[B)V
    //   83: astore 5
    //   85: aload_0
    //   86: getfield 168	com/tencent/mobileqq/transfile/LightVideoUploadProcessor:mCacheIp	I
    //   89: ifeq +12 -> 101
    //   92: aload 5
    //   94: aload_0
    //   95: getfield 168	com/tencent/mobileqq/transfile/LightVideoUploadProcessor:mCacheIp	I
    //   98: putfield 1167	com/tencent/mobileqq/highway/transaction/Transaction:cacheIp	I
    //   101: aload_1
    //   102: aload 5
    //   104: putfield 1170	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$TransactionListener:trans	Lcom/tencent/mobileqq/highway/transaction/Transaction;
    //   107: aload_1
    //   108: iload_2
    //   109: putfield 1171	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$TransactionListener:index	I
    //   112: aload_1
    //   113: aload 9
    //   115: putfield 1172	com/tencent/mobileqq/transfile/LightVideoUploadProcessor$TransactionListener:sendInfo	Lbaid;
    //   118: aload_0
    //   119: getfield 121	com/tencent/mobileqq/transfile/LightVideoUploadProcessor:app	Lcom/tencent/mobileqq/app/QQAppInterface;
    //   122: invokevirtual 711	com/tencent/mobileqq/app/QQAppInterface:getHwEngine	()Lcom/tencent/mobileqq/highway/HwEngine;
    //   125: aload 5
    //   127: invokevirtual 717	com/tencent/mobileqq/highway/HwEngine:submitTransactionTask	(Lcom/tencent/mobileqq/highway/transaction/Transaction;)I
    //   130: istore_2
    //   131: iload_2
    //   132: ifeq +11 -> 143
    //   135: aload_0
    //   136: iload_2
    //   137: invokevirtual 1174	com/tencent/mobileqq/transfile/LightVideoUploadProcessor:onSendFileSliceFailed	(I)V
    //   140: aload_0
    //   141: monitorexit
    //   142: return
    //   143: aload_0
    //   144: getfield 96	com/tencent/mobileqq/transfile/LightVideoUploadProcessor:mTransactions	Ljava/util/List;
    //   147: aload 5
    //   149: invokeinterface 1029 2 0
    //   154: pop
    //   155: goto -15 -> 140
    //   158: astore_1
    //   159: aload_0
    //   160: monitorexit
    //   161: aload_1
    //   162: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	163	0	this	LightVideoUploadProcessor
    //   0	163	1	paramFileSlice	LightVideoUploadProcessor.FileSlice
    //   30	107	2	i	int
    //   47	1	3	l	long
    //   6	142	5	localObject1	Object
    //   12	62	6	arrayOfByte1	byte[]
    //   18	58	7	arrayOfByte2	byte[]
    //   24	55	8	arrayOfByte3	byte[]
    //   35	79	9	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   2	101	158	finally
    //   101	131	158	finally
    //   135	140	158	finally
    //   143	155	158	finally
  }
  
  public void sendMessageToUpdate(int paramInt)
  {
    super.sendMessageToUpdate(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendMessageToUpdate,state = " + paramInt);
    }
    this.mMessage.videoFileStatus = paramInt;
    this.mMessage.serial();
    this.app.getMessageFacade().updateMsgContentByUniseq(this.mMessage.frienduin, this.mMessage.istroop, this.mMessage.uniseq, this.mMessage.msgData);
  }
  
  public void sendMsg(boolean paramBoolean)
  {
    if (this.mVideoSend != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "confirm send:" + this.mVideoSend.b());
      }
      if (!this.mVideoSend.b()) {
        return;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendMsg() start.");
    }
    im_msg_body.RichText localRichText = constructRichText();
    if (localRichText == null)
    {
      setError(9368, "constructpberror", null, this.mStepMsg);
      onError();
      return;
    }
    this.mMessage.richText = localRichText;
    ((bahm)this.app.getManager(326)).a(this.mMessage, this.mMessageObserver);
  }
  
  protected void sendProgressMessage()
  {
    super.sendProgressMessage();
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendProgressMessage,progress;" + this.mProgress + " transferedSize:" + this.file.transferedSize + " fileSize:" + this.file.fileSize);
    }
  }
  
  public void sendRequest()
  {
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "sendRequest");
    }
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.ShortVideoUpReq localShortVideoUpReq = makeShortVideoUpReq();
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "short_video_up";
    localRichProtoReq.reqs.add(localShortVideoUpReq);
    localRichProtoReq.protoReqMgr = this.app.getProtoReqManager();
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
  
  public void sendSlice()
  {
    if (this.mSendingInfos.size() >= 3) {}
    label144:
    for (;;)
    {
      return;
      for (;;)
      {
        if ((this.mSendingInfos.size() >= 3) || (this.mReadyToSendInfos.size() <= 0)) {
          break label144;
        }
        baid localbaid = (baid)this.mReadyToSendInfos.remove(0);
        if (localbaid == null) {
          break;
        }
        if (QLog.isColorLevel()) {
          QLog.d("VideoSend", 2, "sendSlice, info:" + localbaid + " mSendingInfos:" + this.mSendingInfos.size() + " mReadyToSendInfos:" + this.mReadyToSendInfos.size());
        }
        this.mSendingInfos.put(Integer.valueOf(localbaid.d), localbaid);
        submitSlice(localbaid);
      }
    }
  }
  
  void sendVideoSliceByBDH(baid parambaid)
  {
    String str = parambaid.jdField_a_of_type_JavaLangString;
    int i = (int)new File(str).length();
    byte[] arrayOfByte1 = this.mThumbFileMd5;
    byte[] arrayOfByte2 = HexUtil.hexStr2Bytes(parambaid.jdField_b_of_type_JavaLangString);
    int j = parambaid.d;
    int k = parambaid.jdField_b_of_type_Int;
    int m = parambaid.jdField_a_of_type_Int;
    int n = parambaid.e;
    long l = parambaid.jdField_b_of_type_Long;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendVideoSegByBDH  filePath:" + str + " index :" + j + " md5:" + HexUtil.bytes2HexStr(arrayOfByte2) + " fileSize:" + i);
    }
    Object localObject1 = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint32_cmd.set(2);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).uint64_session_id.set(this.mSessionId);
    if (mIsPreSendAckToBDHServer) {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Object localObject2 = new Bdh_extinfo.VideoInfo();
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_idx.set(j);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_size.set(i);
      ((Bdh_extinfo.VideoInfo)localObject2).bytes_bin_md5.set(ByteStringMicro.copyFrom(arrayOfByte2));
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_format.set(2);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_len.set(k);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_res_width.set(m);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_time.set(n);
      ((Bdh_extinfo.VideoInfo)localObject2).uint64_starttime.set(l);
      ((Bdh_extinfo.VideoInfo)localObject2).uint32_is_audio.set(0);
      this.mVideoInfos.put(Integer.valueOf(j), localObject2);
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_videoinfo.set((MessageMicro)localObject2);
      if (this.mThumbInfo != null) {
        ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).msg_thumbinfo.set(this.mThumbInfo);
      }
      localObject1 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).toByteArray(), this.mSessionKey);
      localObject2 = new LightVideoUploadProcessor.FileSlice(this);
      ((LightVideoUploadProcessor.FileSlice)localObject2).path = str;
      ((LightVideoUploadProcessor.FileSlice)localObject2).ticket = this.mSigSession;
      ((LightVideoUploadProcessor.FileSlice)localObject2).thumbMD5 = arrayOfByte1;
      ((LightVideoUploadProcessor.FileSlice)localObject2).extendInfo = ((byte[])localObject1);
      ((LightVideoUploadProcessor.FileSlice)localObject2).index = j;
      ((LightVideoUploadProcessor.FileSlice)localObject2).fileMD5 = arrayOfByte2;
      ((LightVideoUploadProcessor.FileSlice)localObject2).sendInfo = parambaid;
      ((LightVideoUploadProcessor.FileSlice)localObject2).fileSize = i;
      sendFileSliceByBDH((LightVideoUploadProcessor.FileSlice)localObject2);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject1).bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  void sendVideoThumbByBDH(baid parambaid)
  {
    String str = parambaid.jdField_a_of_type_JavaLangString;
    int i = (int)this.mThumbFileSize;
    byte[] arrayOfByte1 = this.mSigSession;
    byte[] arrayOfByte3 = this.mSessionKey;
    byte[] arrayOfByte2 = this.mThumbFileMd5;
    long l = this.mSessionId;
    if (QLog.isColorLevel()) {
      QLog.d("LightVideoUploadProcessor", 2, "<BDH_LOG>sendVideoThumbByBDH  filePath:" + str + " index :" + parambaid.d + " md5:" + HexUtil.bytes2HexStr(arrayOfByte2) + " fileSize:" + i);
    }
    Object localObject = new Bdh_extinfo.ShortVideoReqExtInfo();
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint32_cmd.set(1);
    ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).uint64_session_id.set(l);
    if (mIsPreSendAckToBDHServer) {
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(true);
    }
    for (;;)
    {
      Bdh_extinfo.PicInfo localPicInfo = new Bdh_extinfo.PicInfo();
      localPicInfo.uint32_idx.set(0);
      localPicInfo.uint32_size.set(i);
      localPicInfo.uint32_type.set(1);
      localPicInfo.bytes_bin_md5.set(ByteStringMicro.copyFrom(arrayOfByte2));
      this.mThumbInfo = localPicInfo;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).msg_thumbinfo.set(localPicInfo);
      arrayOfByte3 = new Cryptor().encrypt(((Bdh_extinfo.ShortVideoReqExtInfo)localObject).toByteArray(), arrayOfByte3);
      localObject = new LightVideoUploadProcessor.FileSlice(this);
      ((LightVideoUploadProcessor.FileSlice)localObject).path = str;
      ((LightVideoUploadProcessor.FileSlice)localObject).ticket = arrayOfByte1;
      ((LightVideoUploadProcessor.FileSlice)localObject).thumbMD5 = arrayOfByte2;
      ((LightVideoUploadProcessor.FileSlice)localObject).extendInfo = arrayOfByte3;
      ((LightVideoUploadProcessor.FileSlice)localObject).index = 0;
      ((LightVideoUploadProcessor.FileSlice)localObject).fileMD5 = arrayOfByte2;
      ((LightVideoUploadProcessor.FileSlice)localObject).sendInfo = parambaid;
      ((LightVideoUploadProcessor.FileSlice)localObject).fileSize = i;
      sendFileSliceByBDH((LightVideoUploadProcessor.FileSlice)localObject);
      return;
      ((Bdh_extinfo.ShortVideoReqExtInfo)localObject).bool_is_merge_cmd_before_data.set(false);
    }
  }
  
  public void start()
  {
    super.start();
    this.mThumbFilePath = this.mUiRequest.mThumbPath;
    this.mSessionId = this.mUiRequest.mUniseq;
    if (this.mUiRequest.mThumbMd5 == null) {
      this.mThumbFileMd5 = HexUtil.hexStr2Bytes(barq.a(this.mThumbFilePath));
    }
    this.mThumbFileMd5 = HexUtil.hexStr2Bytes(this.mUiRequest.mThumbMd5);
    Object localObject;
    if ((this.mMessage.thumbFileSize == 0) || (this.mMessage.thumbWidth == 0) || (this.mMessage.thumbHeight == 0))
    {
      localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      BitmapFactory.decodeFile(this.mThumbFilePath);
      this.mMessage.thumbWidth = ((BitmapFactory.Options)localObject).outWidth;
      this.mMessage.thumbHeight = ((BitmapFactory.Options)localObject).outHeight;
      this.mMessage.thumbFileSize = ((int)new File(this.mThumbFilePath).length());
    }
    this.mThumbFileSize = this.mMessage.thumbFileSize;
    this.mThumbFileWidth = this.mMessage.thumbWidth;
    this.mThumbFileHeight = this.mMessage.thumbHeight;
    initBDHSession();
    if (checkBDHSessionValid()) {
      if (this.mVideoSend != null) {
        if (this.mUiRequest.mIsPresend)
        {
          this.mUploadType = 0;
          this.mVideoSend.a(this);
          label234:
          sendMessageToUpdate(1001);
        }
      }
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("LightVideoUploadProcessor", 2, "start, mUploadType = " + this.mUploadType);
      }
      return;
      this.mUploadType = 2;
      break;
      this.mUploadType = 2;
      this.mLocalFilePath = this.mUiRequest.mLocalPath;
      if (this.mUiRequest.mMd5 == null) {
        this.mUiRequest.mMd5 = barq.a(this.mLocalFilePath);
      }
      localObject = this.file;
      String str = this.mUiRequest.mMd5;
      ((FileMsg)localObject).fileMd5 = str;
      this.mMd5Str = str;
      this.mLocalMd5 = HexUtil.hexStr2Bytes(this.mUiRequest.mMd5);
      if ((this.mMessage.videoFileSize == 0) || (this.mMessage.videoFileTime == 0))
      {
        localObject = new bbxb();
        bbxa.a(this.mLocalFilePath, (bbxb)localObject);
        int i = localObject.a[3];
        this.mMessage.videoFileSize = ((int)new File(this.mLocalFilePath).length());
        this.mMessage.videoFileTime = (i / 1000);
      }
      this.mFileSize = this.mMessage.videoFileSize;
      this.mLocalVideoTime = this.mMessage.videoFileTime;
      sendRequest();
      break label234;
      HwServlet.getConfig(this.app, this.mUiRequest.mSelfUin);
      this.mUploadType = 2;
      this.mVideoSend.a(this);
    }
  }
  
  public void submitAck(Bdh_extinfo.ShortVideoReqExtInfo paramShortVideoReqExtInfo)
  {
    paramShortVideoReqExtInfo = new Cryptor().encrypt(paramShortVideoReqExtInfo.toByteArray(), this.mSessionKey);
    LightVideoUploadProcessor.4 local4 = new LightVideoUploadProcessor.4(this);
    paramShortVideoReqExtInfo = new RequestAck(this.mUiRequest.mSelfUin, 16, this.mSigSession, 30000L, local4, paramShortVideoReqExtInfo, this.mThumbFileMd5, this.mCacheIp);
    this.app.getHwEngine().SubmitAckRequest(paramShortVideoReqExtInfo);
    this.mRequestAck = paramShortVideoReqExtInfo;
  }
  
  public void submitSlice(baid parambaid)
  {
    if (parambaid.a())
    {
      sendVideoThumbByBDH(parambaid);
      return;
    }
    if (parambaid.b())
    {
      sendAudioSliceByBDH(parambaid);
      return;
    }
    sendVideoSliceByBDH(parambaid);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.LightVideoUploadProcessor
 * JD-Core Version:    0.7.0.1
 */