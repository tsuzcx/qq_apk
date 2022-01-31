package com.tencent.mobileqq.transfile;

import aiqv;
import aiqw;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.MessageObserver;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageForScribble;
import com.tencent.mobileqq.highway.HwEngine;
import com.tencent.mobileqq.highway.api.ITransactionCallback;
import com.tencent.mobileqq.highway.config.HwServlet;
import com.tencent.mobileqq.highway.openup.SessionInfo;
import com.tencent.mobileqq.highway.transaction.Transaction;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.httputils.PkgTools;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.wstt.SSCM.SSCM;
import java.io.File;
import java.util.HashMap;

public class ScribblePicUploadProcessor
  extends BaseUploadProcessor
{
  MessageObserver jdField_a_of_type_ComTencentMobileqqAppMessageObserver = new aiqw(this);
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = (QQAppInterface)this.jdField_a_of_type_ComTencentCommonAppAppInterface;
  private Transaction jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction;
  private String jdField_a_of_type_JavaLangString = "";
  private byte[] b;
  private byte[] c;
  
  public ScribblePicUploadProcessor(BaseTransFileController paramBaseTransFileController, TransferRequest paramTransferRequest)
  {
    super(paramBaseTransFileController, paramTransferRequest);
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ComTencentMobileqqTransfileBaseTransProcessor = this;
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte = paramTransferRequest.jdField_a_of_type_ArrayOfByte;
  }
  
  private void a(MessageForScribble paramMessageForScribble)
  {
    if (paramMessageForScribble != null)
    {
      paramMessageForScribble.prewrite();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageForScribble.frienduin, paramMessageForScribble.istroop, paramMessageForScribble.uniseq, paramMessageForScribble.msgData);
    }
  }
  
  private void q()
  {
    try
    {
      if (SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b).getHttpconn_sig_session() != null)
      {
        int i = SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b).getHttpconn_sig_session().length;
        this.jdField_b_of_type_ArrayOfByte = new byte[i];
        System.arraycopy(SessionInfo.getInstance(this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b).getHttpconn_sig_session(), 0, this.jdField_b_of_type_ArrayOfByte, 0, i);
      }
      if (this.jdField_b_of_type_ArrayOfByte == null) {
        HwServlet.getConfig(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.b);
      }
      return;
    }
    finally {}
  }
  
  private void r()
  {
    if (!d())
    {
      d("<BDH_LOG> sendMsg() do not send message, due to mIsCancel=true || mIsPause=true, current channel = " + this.v);
      return;
    }
    MessageForScribble localMessageForScribble = (MessageForScribble)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localMessageForScribble != null)
    {
      localMessageForScribble.combineFileUrl = this.jdField_a_of_type_JavaLangString;
      if (QLog.isColorLevel())
      {
        QLog.d("ScribblePicUploadProcessor", 2, "mPicUrl: " + this.jdField_a_of_type_JavaLangString);
        QLog.d("ScribblePicUploadProcessor", 2, "TestPicSend finish upload,currentTime = " + System.currentTimeMillis() + ",processor = " + this);
      }
      this.jdField_c_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().b(localMessageForScribble, this.jdField_a_of_type_ComTencentMobileqqAppMessageObserver);
      QLog.i("SCRIBBLEMSG", 2, "!!!sendMessage uniseq:" + localMessageForScribble.uniseq);
      return;
    }
    a(-1, "MessageForScribble IS NULL", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
    d();
  }
  
  protected long a(long paramLong)
  {
    paramLong = this.q - paramLong;
    if (!this.d) {}
    for (paramLong = Math.min(paramLong, this.jdField_a_of_type_ComTencentWsttSSCMSSCM.a(BaseApplication.getContext(), this.q, this.s, -1));; paramLong = Math.min(paramLong, 14600L)) {
      return Math.min(paramLong, 131072L);
    }
  }
  
  public void a(long paramLong1, long paramLong2, long paramLong3, long paramLong4)
  {
    if (paramLong1 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong1);
    }
    if (paramLong2 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 1, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong2);
    }
    if (paramLong3 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong3);
    }
    if (paramLong4 != 0L) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.countFlow(true, 0, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.b, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Int, paramLong4);
    }
  }
  
  protected void a(boolean paramBoolean)
  {
    if ((!paramBoolean) && (RichMediaStrategy.b(this.jdField_j_of_type_Int))) {}
    while ((this.i) || ((paramBoolean) && ((this.m & 0x2) > 0)) || ((!paramBoolean) && ((this.m & 0x1) > 0))) {
      return;
    }
    int j = this.m;
    int i;
    long l;
    String str;
    if (paramBoolean)
    {
      i = 2;
      this.m = (i | j);
      this.l = System.currentTimeMillis();
      l = (System.nanoTime() - this.k) / 1000000L;
      HashMap localHashMap = this.jdField_a_of_type_JavaUtilHashMap;
      if (this.jdField_b_of_type_ArrayOfByte != null) {
        break label156;
      }
      str = "null";
      label105:
      localHashMap.put("param_sessionKey", str);
      if (!paramBoolean) {
        break label168;
      }
      StatisticCollector.a(BaseApplication.getContext()).a(null, "scribble_upload", true, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
    for (;;)
    {
      l();
      return;
      i = 1;
      break;
      label156:
      str = PkgTools.a(this.jdField_b_of_type_ArrayOfByte);
      break label105;
      label168:
      if (this.jdField_j_of_type_Int != -9527) {
        this.jdField_a_of_type_JavaUtilHashMap.remove("param_rspHeader");
      }
      this.jdField_a_of_type_JavaUtilHashMap.put("param_FailCode", String.valueOf(this.jdField_j_of_type_Int));
      this.jdField_a_of_type_JavaUtilHashMap.put("param_errorDesc", this.jdField_j_of_type_JavaLangString);
      this.jdField_a_of_type_JavaUtilHashMap.put("param_picSize", String.valueOf(this.q));
      StatisticCollector.a(BaseApplication.getContext()).a(null, "scribble_upload", false, l, this.q, this.jdField_a_of_type_JavaUtilHashMap, "");
    }
  }
  
  byte[] a(int paramInt1, int paramInt2)
  {
    return super.a(paramInt1, paramInt2);
  }
  
  public void an_()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "NearbyPeoplePhotoUploadProcessor.sendFile()");
    }
    this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo.a();
    Object localObject = new aiqv(this, SystemClock.uptimeMillis());
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Int = 41;
    this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction = new Transaction(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin(), this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Int, this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i, (int)this.r, this.jdField_b_of_type_ArrayOfByte, this.jdField_a_of_type_ArrayOfByte, (ITransactionCallback)localObject, this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_ArrayOfByte);
    int i = this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().submitTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    localObject = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
    String str = HexUtil.bytes2HexStr(this.jdField_c_of_type_ArrayOfByte);
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "<BDH_LOG> Transaction submit RetCode:" + i + " T_ID:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.getTransationId() + " UniSeq:" + this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_Long + " MD51:" + (String)localObject + " MD52:" + str + " uuid:" + this.g + " Path:" + this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction.filePath + " Cmd:" + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_Int);
    }
    if (i != 0)
    {
      a(i, "SubmitError.", "", this.jdField_b_of_type_ComTencentMobileqqTransfileBaseTransProcessor$StepInfo);
      d();
    }
  }
  
  public void ap_()
  {
    this.jdField_a_of_type_JavaLangString = "";
    super.ap_();
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "ScriblePicUploadProcessor.start()");
    }
    q();
    MessageForScribble localMessageForScribble = (MessageForScribble)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (this.jdField_a_of_type_ArrayOfByte == null)
    {
      this.jdField_c_of_type_ArrayOfByte = HexUtil.hexStr2Bytes(localMessageForScribble.combineFileMd5);
      if (!e())
      {
        d();
        return;
      }
      localMessageForScribble.combineFileMd5 = HexUtil.bytes2HexStr(this.jdField_a_of_type_ArrayOfByte);
    }
    if (this.jdField_b_of_type_ArrayOfByte != null)
    {
      an_();
      return;
    }
    QLog.e("ScribblePicUploadProcessor", 2, "ScribblePicUploadProcessor get null BDHsession key.");
  }
  
  public int b()
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "ScribblePicUploadProcessor.resume()");
    }
    f();
    an_();
    return 0;
  }
  
  public int c()
  {
    String str = this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.i;
    if (TextUtils.isEmpty(str))
    {
      b(9302, a(new Exception("filePath null")));
      d();
      return -1;
    }
    File localFile = new File(str);
    if (!localFile.exists())
    {
      b(9042, a(new Exception("sendFile not exist " + str)));
      d();
      return -1;
    }
    if (!localFile.canRead())
    {
      b(9070, a(new Exception("sendFile not readable " + this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_c_of_type_JavaLangString)));
      d();
      return -1;
    }
    long l = localFile.length();
    this.jdField_a_of_type_ComTencentMobileqqTransfileFileMsg.jdField_a_of_type_Long = l;
    this.q = l;
    if (l <= 0L)
    {
      b(9071, a(new Exception("file size 0 " + str)));
      d();
      return -1;
    }
    return super.c();
  }
  
  public void d()
  {
    super.d();
    d(1005);
    Object localObject = (MessageForScribble)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileUploadStatus = 2;
    }
    a((MessageForScribble)localObject);
    QLog.e("ScribblePicUploadProcessor", 2, "onError()---- errCode: " + this.jdField_j_of_type_Int + ", errDesc:" + this.jdField_j_of_type_JavaLangString);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject = new UpCallBack.SendResult();
      ((UpCallBack.SendResult)localObject).jdField_a_of_type_Int = -1;
      ((UpCallBack.SendResult)localObject).b = this.jdField_j_of_type_Int;
      ((UpCallBack.SendResult)localObject).jdField_a_of_type_JavaLangString = this.jdField_j_of_type_JavaLangString;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b((UpCallBack.SendResult)localObject);
    }
  }
  
  public void d(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, paramString);
    }
  }
  
  public void e()
  {
    super.e();
    d(1003);
    Object localObject = (MessageForScribble)this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
    if (localObject != null) {
      ((MessageForScribble)localObject).fileUploadStatus = 1;
    }
    a((MessageForScribble)localObject);
    if (QLog.isColorLevel()) {
      QLog.i("ScribblePicUploadProcessor", 2, "onSuccess().");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack != null)
    {
      localObject = new UpCallBack.SendResult();
      ((UpCallBack.SendResult)localObject).jdField_a_of_type_Int = 0;
      this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest.jdField_a_of_type_ComTencentMobileqqPicUpCallBack.b((UpCallBack.SendResult)localObject);
    }
  }
  
  public void f()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction != null) {
      this.jdField_a_of_type_ComTencentCommonAppAppInterface.getHwEngine().cancelTransactionTask(this.jdField_a_of_type_ComTencentMobileqqHighwayTransactionTransaction);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\aaa.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.ScribblePicUploadProcessor
 * JD-Core Version:    0.7.0.1
 */