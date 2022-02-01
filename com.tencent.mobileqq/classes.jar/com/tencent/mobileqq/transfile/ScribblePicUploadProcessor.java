package com.tencent.mobileqq.transfile;

import amwl;
import android.os.SystemClock;
import android.text.TextUtils;
import ayeo;
import ayep;
import bjyw;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;

public class ScribblePicUploadProcessor
  extends BaseUploadProcessor
{
  public static final int SCRIBBLE_COMMAND_ID = 41;
  public static final String TAG = "ScribblePicUploadProcessor";
  QQAppInterface mApp = (QQAppInterface)this.app;
  private byte[] mLocalMd52;
  private String mPicUrl = "";
  private byte[] mSessionKey;
  amwl messageObserver = new ScribblePicUploadProcessor.2(this);
  private Transaction trans;
  
  public ScribblePicUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.file.processor = this;
    this.file.bdhExtendInfo = paramTransferRequest.mExtentionInfo;
  }
  
  private void getBDHsessionkey()
  {
    try
    {
      if (SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session() != null)
      {
        int i = SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session().length;
        this.mSessionKey = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.mUiRequest.mSelfUin).getHttpconn_sig_session(), 0, this.mSessionKey, 0, i);
      }
      if (this.mSessionKey == null) {
        HwServlet.getConfig(this.app, this.mUiRequest.mSelfUin);
      }
      return;
    }
    finally {}
  }
  
  private void sendMsg()
  {
    if (!canDoNextStep())
    {
      log("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.mChannelStatus);
      return;
    }
    MessageForScribble localMessageForScribble = (MessageForScribble)this.mUiRequest.mRec;
    if (localMessageForScribble != null)
    {
      localMessageForScribble.combineFileUrl = this.mPicUrl;
      if (QLog.isColorLevel())
      {
        QLog.d("ScribblePicUploadProcessor", 2, "mPicUrl: " + this.mPicUrl);
        QLog.d("ScribblePicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
      }
      this.mStepMsg.logStartTime();
      this.mApp.getMessageFacade().sendMessage(localMessageForScribble, this.messageObserver);
      QLog.i("SCRIBBLEMSG", 2, "!!!sendMessage uniseq:" + localMessageForScribble.uniseq);
      return;
    }
    setError(-1, "MessageForScribble IS NULL", "", this.mStepTrans);
    onError();
  }
  
  private void updateMsg(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble != null)
    {
      paramMessageForScribble.prewrite();
      this.mApp.getMessageFacade().updateMsgContentByUniseq(paramMessageForScribble.frienduin, paramMessageForScribble.istroop, paramMessageForScribble.uniseq, paramMessageForScribble.msgData);
    }
  }
  
  public void cancelTask()
  {
    if (this.trans != null) {
      this.app.getHwEngine().cancelTransactionTask(this.trans);
    }
  }
  
  public int checkParam()
  {
    String str = this.mUiRequest.mLocalPath;
    if (TextUtils.isEmpty(str))
    {
      setError(9302, getExpStackString(new Exception("filePath null")));
      onError();
      return -1;
    }
    File localFile = new File(str);
    if (!localFile.exists())
    {
      setError(9042, getExpStackString(new Exception("sendFile not exist " + str)));
      onError();
      return -1;
    }
    if (!localFile.canRead())
    {
      setError(9070, getExpStackString(new Exception("sendFile not readable " + this.file.filePath)));
      onError();
      return -1;
    }
    long l = localFile.length();
    this.file.fileSize = l;
    this.mFileSize = l;
    if (l <= 0L)
    {
      setError(9071, getExpStackString(new Exception("file size 0 " + str)));
      onError();
      return -1;
    }
    return super.checkParam();
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
      HashMap localHashMap = this.mReportInfo;
      if (this.mSessionKey != null) {
        break label156;
      }
      str = "null";
      label105:
      localHashMap.put("param_sessionKey", str);
      if (!paramBoolean) {
        break label168;
      }
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "scribble_upload", true, l, this.mFileSize, this.mReportInfo, "");
    }
    for (;;)
    {
      setReportFlag();
      return;
      i = 1;
      break;
      label156:
      str = PkgTools.toHexStr(this.mSessionKey);
      break label105;
      label168:
      if (this.errCode != -9527) {
        this.mReportInfo.remove("param_rspHeader");
      }
      this.mReportInfo.put("param_FailCode", String.valueOf(this.errCode));
      this.mReportInfo.put("param_errorDesc", this.errDesc);
      this.mReportInfo.put("param_picSize", String.valueOf(this.mFileSize));
      StatisticCollector.getInstance(BaseApplication.getContext()).collectPerformance(null, "scribble_upload", false, l, this.mFileSize, this.mReportInfo, "");
    }
  }
  
  protected long getBlockSize(long paramLong)
  {
    paramLong = this.mFileSize - paramLong;
    if (!this.mSSCMSpanned) {}
    for (paramLong = Math.min(paramLong, this.sscmObject.a(BaseApplication.getContext(), this.mFileSize, this.mTransferedSize, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  byte[] getStreamData(int paramInt1, int paramInt2)
  {
    return super.getStreamData(paramInt1, paramInt2);
  }
  
  protected void log(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, paramString);
    }
  }
  
  void onError()
  {
    super.onError();
    sendMessageToUpdate(1005);
    Object localObject = (MessageForScribble)this.mUiRequest.mRec;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileUploadStatus = 2;
    }
    updateMsg((MessageForScribble)localObject);
    QLog.e("ScribblePicUploadProcessor", 2, "onError()---- errCode: " + this.errCode + ", errDesc:" + this.errDesc);
    if (this.mUiRequest.mUpCallBack != null)
    {
      localObject = new ayep();
      ((ayep)localObject).jdField_a_of_type_Int = -1;
      ((ayep)localObject).b = this.errCode;
      ((ayep)localObject).jdField_a_of_type_JavaLangString = this.errDesc;
      this.mUiRequest.mUpCallBack.onSend((ayep)localObject);
    }
  }
  
  void onSuccess()
  {
    super.onSuccess();
    sendMessageToUpdate(1003);
    Object localObject = (MessageForScribble)this.mUiRequest.mRec;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileUploadStatus = 1;
    }
    updateMsg((MessageForScribble)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "onSuccess().");
    }
    if (this.mUiRequest.mUpCallBack != null)
    {
      localObject = new ayep();
      ((ayep)localObject).jdField_a_of_type_Int = 0;
      this.mUiRequest.mUpCallBack.onSend((ayep)localObject);
    }
  }
  
  protected void reportDataFlow(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.app.countFlow(true, 1, this.file.fileType, this.mUiRequest.mUinType, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.app.countFlow(true, 1, this.file.fileType, this.mUiRequest.mUinType, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.app.countFlow(true, 0, this.file.fileType, this.mUiRequest.mUinType, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.app.countFlow(true, 0, this.file.fileType, this.mUiRequest.mUinType, paramLong4);
    }
  }
  
  public int resume()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "ScribblePicUploadProcessor.resume()");
    }
    cancelTask();
    sendFile();
    return 0;
  }
  
  public void sendFile()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
    }
    this.mStepTrans.logStartTime();
    Object localObject = new ScribblePicUploadProcessor.1(this, SystemClock.uptimeMillis());
    this.file.commandId = 41;
    this.trans = new Transaction(this.app.getCurrentAccountUin(), this.file.commandId, this.mUiRequest.mLocalPath, (int)this.mStartOffset, this.mSessionKey, this.mLocalMd5, (ITransactionCallback)localObject, this.file.bdhExtendInfo);
    int i = this.app.getHwEngine().submitTransactionTask(this.trans);
    localObject = HexUtil.bytes2HexStr(this.mLocalMd5);
    String str = HexUtil.bytes2HexStr(this.mLocalMd52);
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.trans.getTransationId() + " UniSeq:" + this.mUiRequest.mUniseq + " MD51:" + (String)localObject + " MD52:" + str + " uuid:" + this.mUuid + " Path:" + this.trans.filePath + " Cmd:" + this.file.commandId);
    }
    if (i != 0)
    {
      setError(i, "SubmitError.", "", this.mStepTrans);
      onError();
    }
  }
  
  public void start()
  {
    this.mPicUrl = "";
    super.start();
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "ScriblePicUploadProcessor.start()");
    }
    getBDHsessionkey();
    MessageForScribble localMessageForScribble = (MessageForScribble)this.mUiRequest.mRec;
    if (this.mLocalMd5 == null)
    {
      this.mLocalMd52 = HexUtil.hexStr2Bytes(localMessageForScribble.combineFileMd5);
      if (!getMd5())
      {
        onError();
        return;
      }
      localMessageForScribble.combineFileMd5 = HexUtil.bytes2HexStr(this.mLocalMd5);
    }
    if (this.mSessionKey != null)
    {
      sendFile();
      return;
    }
    QLog.e("ScribblePicUploadProcessor", 2, "ScribblePicUploadProcessor get null BDHsession key.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ScribblePicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */