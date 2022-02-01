package com.tencent.mobileqq.transfile;

import android.os.SystemClock;
import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.guild.message.api.IGuildMessageUtilsApi;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransCallbackForReport;
import com.tencent.mobileqq.highway.protocol.CSDataHighwayHead.PicInfoExt;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.qqguildsdk.api.IGPSService;
import com.tencent.mobileqq.qqguildsdk.data.IGProChannelInfo;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.transfile.api.IProtoReqManager;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GuildPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.mobileqq.transfile.report.ProcessorReport;
import com.tencent.mobileqq.utils.HexUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.List;
import tencent.im.msg.hummer.resv3.CustomFaceExtPb.ResvAttr;
import tencent.im.msg.im_msg_body.CustomFace;
import tencent.im.msg.im_msg_body.RichText;

public class GuildPicUploadProcessor
  extends GroupPicUploadProcessor
{
  private static final String TAG = "GuildPicUploadProcessor";
  String mChannelId = "";
  byte[] mDownLoadIndex;
  String mGuildId = "";
  
  public GuildPicUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.mChannelId = paramTransferRequest.mPeerUin;
    paramTransferRequest = ((IGPSService)this.app.getRuntimeService(IGPSService.class, "")).getChannelInfo(paramTransferRequest.mPeerUin);
    if (paramTransferRequest != null)
    {
      paramBaseTransFileController = this.mUiRequest;
      paramTransferRequest = paramTransferRequest.getGuildId();
      paramBaseTransFileController.mSecondId = paramTransferRequest;
      this.mGuildId = paramTransferRequest;
    }
  }
  
  @NonNull
  protected CustomFaceExtPb.ResvAttr constructResvAttr(MessageForPic paramMessageForPic)
  {
    CustomFaceExtPb.ResvAttr localResvAttr = super.constructResvAttr(paramMessageForPic);
    Object localObject = this.mDownLoadIndex;
    if ((localObject != null) && (localObject.length > 0))
    {
      localResvAttr.bytes_download_index.set(ByteStringMicro.copyFrom(this.mDownLoadIndex));
      return localResvAttr;
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("constructResvAttr: mDownLoadIndex = null, uin = ");
    ((StringBuilder)localObject).append(paramMessageForPic.selfuin);
    QLog.i("GuildPicUploadProcessor", 2, ((StringBuilder)localObject).toString());
    return localResvAttr;
  }
  
  protected void fillMessageRecord(im_msg_body.RichText paramRichText, MessageRecord paramMessageRecord)
  {
    super.fillMessageRecord(paramRichText, paramMessageRecord);
    ((IGuildMessageUtilsApi)QRoute.api(IGuildMessageUtilsApi.class)).saveGuildIdToMR(paramMessageRecord, this.mGuildId);
  }
  
  protected im_msg_body.CustomFace getCustomFace(MessageRecord paramMessageRecord)
  {
    im_msg_body.CustomFace localCustomFace = super.getCustomFace(paramMessageRecord);
    if ((paramMessageRecord instanceof MessageForPic))
    {
      PBUInt32Field localPBUInt32Field = localCustomFace.uint32_thumb_height;
      paramMessageRecord = (MessageForPic)paramMessageRecord;
      localPBUInt32Field.set(paramMessageRecord.thumbHeight);
      localCustomFace.uint32_thumb_width.set(paramMessageRecord.thumbWidth);
    }
    return localCustomFace;
  }
  
  protected UpCallBack.SendResult getSendResult()
  {
    UpCallBack.SendResult localSendResult = super.getSendResult();
    localSendResult.o = this.mDownLoadIndex;
    return localSendResult;
  }
  
  protected byte[] makeExtendInfo()
  {
    CSDataHighwayHead.PicInfoExt localPicInfoExt = new CSDataHighwayHead.PicInfoExt();
    try
    {
      localPicInfoExt.uint64_qqmeet_channel_id.set(Long.parseLong(this.mChannelId));
      localPicInfoExt.uint64_qqmeet_guild_id.set(Long.parseLong(this.mGuildId));
    }
    catch (Exception localException)
    {
      label39:
      StringBuilder localStringBuilder;
      break label39;
    }
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("makeExtendInfo errormChannelId:");
      localStringBuilder.append(this.mChannelId);
      localStringBuilder.append("mGuildId:");
      localStringBuilder.append(this.mGuildId);
      QLog.d("GuildPicUploadProcessor", 2, localStringBuilder.toString());
    }
    return localPicInfoExt.toByteArray();
  }
  
  protected void onGroupBusiProtoResp(RichProto.RichProtoReq paramRichProtoReq, RichProto.RichProtoResp paramRichProtoResp)
  {
    this.mRichProtoReq = null;
    if (paramRichProtoResp != null)
    {
      int i = 0;
      while (i < paramRichProtoResp.resps.size())
      {
        paramRichProtoReq = (RichProto.RichProtoResp.RespCommon)paramRichProtoResp.resps.get(i);
        if (QLog.isColorLevel()) {
          logRichMediaEvent("procUrl", paramRichProtoReq.toString());
        }
        this.mProcessorReport.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=");
          localStringBuilder.append(this.mProcessorReport.mSendByQuickHttp);
          QLog.e("http_sideway", 2, localStringBuilder.toString());
        }
        this.mProcessorReport.copyRespCommon(this.mProcessorReport.mStepUrl, paramRichProtoReq);
        if ((paramRichProtoReq instanceof RichProto.RichProtoResp.GuildPicUpResp))
        {
          paramRichProtoReq = (RichProto.RichProtoResp.GuildPicUpResp)paramRichProtoReq;
          if (paramRichProtoReq.result == 0)
          {
            this.mDownLoadIndex = paramRichProtoReq.mDownLoadIndex;
            reportQuickSend(paramRichProtoReq.isExist);
            if (paramRichProtoReq.isExist)
            {
              if (QLog.isColorLevel()) {
                QLog.d("GuildPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp GroupPicUpResp.isExist.");
              }
              this.mIsPicSecondTransfered = true;
              this.file.transferedSize = this.file.fileSize;
              this.mFileID = paramRichProtoReq.groupFileID;
              this.mIpList = paramRichProtoReq.mIpList;
              sendMsg();
            }
            else
            {
              sendMessageToUpdate(1002);
              if (!checkContinueSend()) {
                return;
              }
              this.mFileID = paramRichProtoReq.groupFileID;
              this.mUkey = paramRichProtoReq.mUkey;
              this.mIpList = paramRichProtoReq.mIpList;
              this.mTransferedSize = paramRichProtoReq.transferedSize;
              this.mBlockSize = paramRichProtoReq.blockSize;
              this.mStartOffset = paramRichProtoReq.startOffset;
              this.mChannelStatus = 1;
              if (QLog.isColorLevel()) {
                QLog.d("GuildPicUploadProcessor", 2, "<BDH_LOG> About to submit Transaction , from onBusiProtoResp.");
              }
              sendFileBDH();
            }
          }
          else
          {
            paramRichProtoResp = new StringBuilder();
            paramRichProtoResp.append("<BDH_LOG> onBusiProtoResp() error : ");
            paramRichProtoResp.append(paramRichProtoReq.result);
            paramRichProtoResp.append(" ,select HTTP channel");
            log(paramRichProtoResp.toString());
            this.mChannelStatus = 2;
            onError();
            return;
          }
        }
        i += 1;
      }
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    if (this.mUiRequest.mUpCallBack != null)
    {
      UpCallBack.SendResult localSendResult = new UpCallBack.SendResult();
      localSendResult.e = this.mFileSize;
      localSendResult.g = this.mMd5Str;
      localSendResult.f = this.mFileName;
      localSendResult.d = this.mUiRequest.mLocalPath;
      localSendResult.h = this.mFileID;
      localSendResult.n = this.mDownLoadIndex;
      if (this.mUiRequest.isShareImageByServer) {
        localSendResult.l = getImageInfo();
      }
      this.mUiRequest.mUpCallBack.b(localSendResult);
    }
    else
    {
      updateMessageDataBaseContent(true);
    }
    sendMessageToUpdate(1003);
  }
  
  public void sendFileBDH()
  {
    if (this.startTime == -1L) {
      this.startTime = SystemClock.uptimeMillis();
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<BDH_LOG> Transaction submit:sendFile:");
      ((StringBuilder)localObject).append(this.mTrans);
      ((StringBuilder)localObject).append("  this:");
      ((StringBuilder)localObject).append(this);
      QLog.d("GuildPicUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (this.mTrans != null) {
      return;
    }
    this.mProcessorReport.mStepTrans.logStartTime();
    Object localObject = HexUtil.hexStr2Bytes(this.mUkey);
    GuildPicUploadProcessor.1 local1 = new GuildPicUploadProcessor.1(this);
    this.mTrans = new Transaction(this.app.getCurrentAccountUin(), 83, this.mUiRequest.mLocalPath, (int)this.mStartOffset, (byte[])localObject, this.mLocalMd5, local1, makeExtendInfo());
    localObject = new GuildPicUploadProcessor.2(this);
    this.mTrans.cbForReport = ((ITransCallbackForReport)localObject);
    int i = this.app.getHwEngine().submitTransactionTask(this.mTrans);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("<BDH_LOG> Transaction submit RetCode:");
      ((StringBuilder)localObject).append(i);
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
      ((StringBuilder)localObject).append(2);
      QLog.d("GuildPicUploadProcessor", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 0)
    {
      setError(i, "SubmitError.", "", this.mProcessorReport.mStepTrans);
      onError();
    }
  }
  
  protected void sendRequest()
  {
    this.mProcessorReport.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.fileName = this.mFileName;
    localPicUpReq.fileSize = this.mFileSize;
    localPicUpReq.md5 = this.mLocalMd5;
    localPicUpReq.width = this.mWidth;
    localPicUpReq.height = this.mHeight;
    localPicUpReq.isRaw = this.mIsRawPic;
    localPicUpReq.busiType = this.mUiRequest.mBusiType;
    changeRequest(localPicUpReq);
    Object localObject = this.mUiRequest.mRec;
    if (MessageForPic.class.isInstance(localObject))
    {
      localObject = (MessageForPic)localObject;
      localPicUpReq.picType = ((MessageForPic)localObject).imageType;
      this.mPicType = ((MessageForPic)localObject).imageType;
    }
    localPicUpReq.selfUin = this.mUiRequest.mSelfUin;
    localPicUpReq.peerUin = this.mUiRequest.mPeerUin;
    localPicUpReq.secondUin = this.mUiRequest.mSecondId;
    localPicUpReq.uinType = this.mUiRequest.mUinType;
    if (this.mUiRequest.mUinType == 1026)
    {
      localPicUpReq.uinType = 1;
      if (QLog.isColorLevel()) {
        QLog.i("GuildPicUploadProcessor", 2, "sendRequest, UIN_TYPE_HOTCHAT_TOPIC");
      }
    }
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "gld_pic_up";
    localRichProtoReq.reqs.add(localPicUpReq);
    localRichProtoReq.protoReqMgr = ((IProtoReqManager)this.app.getRuntimeService(IProtoReqManager.class, ""));
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mProcessorReport.mStepUrl);
      onError();
      return;
    }
    if (QLog.isColorLevel()) {
      logRichMediaEvent("requestStart", localRichProtoReq.toString());
    }
    if (!canDoNextStep()) {
      return;
    }
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GuildPicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */