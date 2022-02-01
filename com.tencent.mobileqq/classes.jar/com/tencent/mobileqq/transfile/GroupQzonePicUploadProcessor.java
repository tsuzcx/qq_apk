package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.photo.PhotoSendParams;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForPic;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.transfile.chatpic.PicUploadFileSizeLimit;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoReq.PicUpReq;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.GroupPicUpResp;
import com.tencent.mobileqq.transfile.protohandler.RichProto.RichProtoResp.RespCommon;
import com.tencent.mobileqq.transfile.protohandler.RichProtoProc;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;

public class GroupQzonePicUploadProcessor
  extends GroupPicUploadProcessor
{
  public GroupQzonePicUploadProcessor(TransFileController paramTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramTransFileController, paramTransferRequest);
  }
  
  protected int doCheckParam()
  {
    logRichMediaEvent("uiParam", this.mUiRequest.toString());
    switch (this.mUiRequest.mUinType)
    {
    }
    for (this.mIsGroup = false;; this.mIsGroup = true)
    {
      localObject = getTransferRequest();
      if ((localObject == null) || (!((TransferRequest)localObject).mIsFastForward)) {
        break;
      }
      if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicUpExtraInfo))) {
        this.mIsRawPic = ((TransferRequest.PicUpExtraInfo)this.mUiRequest.mExtraObj).mIsRaw;
      }
      return 0;
    }
    if (TextUtils.isEmpty(this.mUiRequest.mMd5))
    {
      setError(9042, getExpStackString(new Exception("qzonePic md5 null!")));
      onError();
      return -1;
    }
    if ((this.mUiRequest.photoSendParams == null) || (TextUtils.isEmpty(this.mUiRequest.photoSendParams.rawDownloadUrl)) || (TextUtils.isEmpty(this.mUiRequest.photoSendParams.rawMd5)))
    {
      setError(9302, getExpStackString(new Exception("qzonePic param_check error!")));
      onError();
      return -1;
    }
    Object localObject = this.file;
    long l = this.mUiRequest.photoSendParams.fileSize;
    ((FileMsg)localObject).fileSize = l;
    this.mFileSize = l;
    if (this.mFileSize <= 0L)
    {
      setError(9071, getExpStackString(new Exception("qzonePic file size 0 ")));
      onError();
      return -1;
    }
    if (this.mFileSize >= PicUploadFileSizeLimit.getLimitC2C())
    {
      setError(9063, getExpStackString(new Exception("qzonePic file size TooBig! ")));
      onError();
      return -1;
    }
    if ((this.mUiRequest.mExtraObj != null) && ((this.mUiRequest.mExtraObj instanceof TransferRequest.PicUpExtraInfo))) {
      this.mIsRawPic = ((TransferRequest.PicUpExtraInfo)this.mUiRequest.mExtraObj).mIsRaw;
    }
    return 0;
  }
  
  protected void doReport(boolean paramBoolean)
  {
    super.doReport(paramBoolean);
    HashMap localHashMap = new HashMap();
    if (!paramBoolean)
    {
      localHashMap.put("param_FailCode", String.valueOf(this.errCode));
      localHashMap.put("fail_url", this.mUiRequest.photoSendParams.rawDownloadUrl);
    }
    StatisticCollector.getInstance(BaseApplicationImpl.getContext()).collectPerformance(null, "actGroupSendQzonePicInfo", paramBoolean, (System.nanoTime() - this.mStartTime) / 1000000L, 0L, localHashMap, "");
  }
  
  protected void doStart(boolean paramBoolean)
  {
    if (!paramBoolean) {
      sendMessageToUpdate(1001);
    }
    sendMessageToUpdate(1000);
    this.file.closeInputStream();
    sendMessageToUpdate(1001);
    TransferRequest localTransferRequest = getTransferRequest();
    if ((localTransferRequest != null) && (localTransferRequest.mIsFastForward))
    {
      this.mWidth = localTransferRequest.mFastForwardWidth;
      this.mHeight = localTransferRequest.mFastForwardHeight;
      this.mFileSize = localTransferRequest.mFastForwardFileSize;
      this.mLocalMd5 = com.tencent.mobileqq.utils.HexUtil.hexStr2Bytes(localTransferRequest.mMd5);
      this.mFileName = localTransferRequest.mMd5;
      this.mMd5Str = this.mFileName;
      this.file.fileMd5 = this.mFileName;
      this.mFileName = (this.mFileName + "." + this.mExtName);
      this.app.getHwEngine().preConnect();
      sendRequest();
      return;
    }
    if (this.mUiRequest.photoSendParams != null)
    {
      this.mWidth = this.mUiRequest.photoSendParams.rawWidth;
      this.mHeight = this.mUiRequest.photoSendParams.rawHeight;
      this.mLocalMd5 = com.tencent.mobileqq.utils.HexUtil.hexStr2Bytes(this.mUiRequest.photoSendParams.rawMd5);
      this.mFileName = com.qq.taf.jce.HexUtil.bytes2HexStr(this.mLocalMd5);
      this.mMd5Str = this.mFileName;
      this.file.fileMd5 = this.mFileName;
      this.mExtName = "jpg";
      this.mFileName = (this.mFileName + "." + this.mExtName);
    }
    this.app.getHwEngine().preConnect();
    sendRequest();
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
        this.mSendByQuickHttp = paramRichProtoReq.isSendByQuickHttp;
        if (QLog.isColorLevel()) {
          QLog.e("http_sideway", 2, "GroupPttDownProcessor.onBusiProtoResp:isSendByQuickHttp=" + this.mSendByQuickHttp);
        }
        copyRespCommon(this.mStepUrl, paramRichProtoReq);
        if ((paramRichProtoReq instanceof RichProto.RichProtoResp.GroupPicUpResp))
        {
          paramRichProtoReq = (RichProto.RichProtoResp.GroupPicUpResp)paramRichProtoReq;
          if (paramRichProtoReq.result != 0) {
            break label275;
          }
          if (paramRichProtoReq.isExist)
          {
            if (QLog.isColorLevel()) {
              QLog.d("GroupPicUploadProcessor", 2, "<BDH_LOG> onBusiProtoResp() picUpResp GroupPicUpResp.isExist, mFileID:" + paramRichProtoReq.groupFileID + ", mFileSize:" + this.file.fileSize);
            }
            this.mIsPicSecondTransfered = true;
            this.file.transferedSize = this.file.fileSize;
            this.mFileID = paramRichProtoReq.groupFileID;
            this.mIpList = paramRichProtoReq.mIpList;
            sendMsg();
          }
        }
        else
        {
          i += 1;
          continue;
        }
        log("<BDH_LOG> onBusiProtoResp() picUpResp exist : " + paramRichProtoReq.isExist + " ,select HTTP channel");
        this.mChannelStatus = 2;
        onError();
      }
    }
    return;
    label275:
    log("<BDH_LOG> onBusiProtoResp() picUpResp error : " + paramRichProtoReq.result + " ,select HTTP channel");
    this.mChannelStatus = 2;
    onError();
  }
  
  protected void sendRequest()
  {
    this.mStepUrl.logStartTime();
    RichProto.RichProtoReq localRichProtoReq = new RichProto.RichProtoReq();
    RichProto.RichProtoReq.PicUpReq localPicUpReq = new RichProto.RichProtoReq.PicUpReq();
    localPicUpReq.fileName = this.mFileName;
    localPicUpReq.fileSize = this.mFileSize;
    localPicUpReq.md5 = this.mLocalMd5;
    localPicUpReq.width = this.mWidth;
    localPicUpReq.height = this.mHeight;
    localPicUpReq.isRaw = this.mIsRawPic;
    localPicUpReq.busiType = this.mUiRequest.mBusiType;
    localPicUpReq.typeHotPic = 3;
    localPicUpReq.transferUrl = this.mUiRequest.photoSendParams.rawDownloadUrl;
    MessageRecord localMessageRecord = this.mUiRequest.mRec;
    if (MessageForPic.class.isInstance(localMessageRecord))
    {
      localPicUpReq.picType = ((MessageForPic)localMessageRecord).imageType;
      this.mPicType = ((MessageForPic)localMessageRecord).imageType;
    }
    localPicUpReq.selfUin = this.mUiRequest.mSelfUin;
    localPicUpReq.peerUin = this.mUiRequest.mPeerUin;
    localPicUpReq.secondUin = this.mUiRequest.mSecondId;
    localPicUpReq.uinType = this.mUiRequest.mUinType;
    localRichProtoReq.callback = this;
    localRichProtoReq.protoKey = "grp_pic_up";
    localRichProtoReq.reqs.add(localPicUpReq);
    localRichProtoReq.protoReqMgr = this.app.getProtoReqManager();
    if (!isAppValid())
    {
      setError(9366, "illegal app", null, this.mStepUrl);
      onError();
    }
    do
    {
      return;
      if (QLog.isColorLevel()) {
        logRichMediaEvent("requestStart", localRichProtoReq.toString());
      }
    } while (!canDoNextStep());
    this.mRichProtoReq = localRichProtoReq;
    RichProtoProc.procRichProtoReq(localRichProtoReq);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.GroupQzonePicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */