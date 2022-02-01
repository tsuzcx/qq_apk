package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import aycx;
import aycy;
import ayde;
import aydp;
import ayeo;
import ayep;
import bahm;
import bbpp;
import bbps;
import bbqe;
import bbqh;
import bbqj;
import bbqx;
import bbrl;
import bbrp;
import bbrr;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements aycx, ayeo, bbps, bbqe
{
  static int d = 3;
  protected Handler a;
  public bbqx a;
  protected bbrr a;
  public QQAppInterface a;
  public MessageRecord a;
  public String f;
  public String g;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new bbpp(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bbqx parambbqx)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(paramQQAppInterface, parambbqx), 8, null, false);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, aydp paramaydp)
  {
    bbrl localbbrl = new bbrl();
    localbbrl.jdField_a_of_type_Bbqx = this.jdField_a_of_type_Bbqx;
    localbbrl.jdField_a_of_type_Aydp = paramaydp;
    localbbrl.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbbrl);
    if (paramaydp != null)
    {
      ayde.b(this.g, this.f, paramaydp.jdField_a_of_type_JavaLangString, paramaydp.jdField_b_of_type_JavaLangString);
      return;
    }
    ayde.b(this.g, this.f, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, bbrl parambbrl)
  {
    bbrl localbbrl = parambbrl;
    if (parambbrl == null) {
      localbbrl = new bbrl();
    }
    localbbrl.jdField_a_of_type_Int = 0;
    localbbrl.jdField_a_of_type_Bbqx = this.jdField_a_of_type_Bbqx;
    a(paramInt, 0, localbbrl);
    ayde.a(this.g, this.f, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bbrl localbbrl = new bbrl();
    localbbrl.jdField_a_of_type_Int = 0;
    localbbrl.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbbrl);
  }
  
  public void a(Message paramMessage)
  {
    ayde.a(this.g, this.f, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Bbrr == null) {}
    int i;
    do
    {
      return;
      i = paramMessage.arg1;
      switch (paramMessage.what)
      {
      default: 
        return;
      case 0: 
        paramMessage = (bbrl)paramMessage.obj;
        this.jdField_a_of_type_Bbrr.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (bbrl)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Bbrr.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (bbrl)paramMessage.obj;
    this.jdField_a_of_type_Bbrr.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Bbrr.a(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = null;
    }
  }
  
  public void a(aycy paramaycy)
  {
    if (paramaycy == null)
    {
      paramaycy = new aydp();
      paramaycy.jdField_b_of_type_JavaLangString = "result == null";
      paramaycy.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramaycy);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bbqx);
    ayde.a(this.g, this.f, "onDownload", "result:" + paramaycy.jdField_a_of_type_Int);
    Object localObject = new bbrl();
    ((bbrl)localObject).jdField_a_of_type_Int = paramaycy.jdField_a_of_type_Int;
    ((bbrl)localObject).jdField_a_of_type_JavaLangObject = paramaycy;
    if (paramaycy.jdField_a_of_type_Int == 0)
    {
      a(0, (bbrl)localObject);
      return;
    }
    if (paramaycy.jdField_a_of_type_Aydp == null)
    {
      localObject = new aydp();
      ((aydp)localObject).jdField_b_of_type_JavaLangString = (paramaycy.jdField_b_of_type_Int + "_" + paramaycy.jdField_a_of_type_JavaLangString);
      ((aydp)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (aydp)localObject);
      return;
    }
    a(0, paramaycy.jdField_a_of_type_Aydp);
  }
  
  public void a(bbqh parambbqh)
  {
    ayde.a(this.g, this.f, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambbqh))
    {
      b(parambbqh);
      return;
    }
    aycy localaycy = new aycy();
    localaycy.jdField_a_of_type_Int = -1;
    localaycy.jdField_a_of_type_Aydp = parambbqh.jdField_a_of_type_Aydp;
    a(localaycy);
  }
  
  public void a(bbqj parambbqj)
  {
    ayde.a(this.g, this.f, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambbqj)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambbqj));
    }
    while (parambbqj == null) {
      return;
    }
    a(3, parambbqj.jdField_a_of_type_Aydp);
  }
  
  public void a(bbrp parambbrp)
  {
    ayde.a(this.g, this.f, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambbrp)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambbrp));
    }
    while (parambbrp == null) {
      return;
    }
    a(2, parambbrp.jdField_a_of_type_Aydp);
  }
  
  public void a(bbrr parambbrr)
  {
    this.jdField_a_of_type_Bbrr = parambbrr;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((bahm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    bahm localbahm = (bahm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localbahm.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localbahm.a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(ArrayList<bbqj> paramArrayList)
  {
    if (QLog.isColorLevel()) {
      QLog.d("BaseShortVideoOprerator", 2, "multiForwardShortVideo start:" + Thread.currentThread().getId());
    }
    if ((paramArrayList == null) || (paramArrayList.size() <= 0))
    {
      if (QLog.isColorLevel()) {
        QLog.e("MultiMsg_TAG", 2, "[uploadForwardMultiMsgPics] error, infoList is null");
      }
      a(3, -1, null);
      return;
    }
    ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.MultiForwardShortVideoTask(this, paramArrayList));
  }
  
  boolean a(bbqh parambbqh)
  {
    if (parambbqh != null)
    {
      ayde.a(this.g, this.f, "checkShortVideoDownloadInfo", "info:" + parambbqh);
      return parambbqh.a();
    }
    ayde.b(this.g, this.f, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(bbqj parambbqj)
  {
    if (parambbqj != null)
    {
      ayde.a(this.g, this.f, "checkShortVideoForwardInfo", "info:" + parambbqj);
      return parambbqj.a();
    }
    ayde.b(this.g, this.f, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(bbrp parambbrp)
  {
    if (parambbrp != null)
    {
      ayde.a(this.g, this.f, "checkShortVideoUploadInfo", "info:" + parambbrp);
      return parambbrp.a();
    }
    ayde.b(this.g, this.f, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  void b(bbqh parambbqh)
  {
    long l = System.currentTimeMillis();
    parambbqh.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = parambbqh.jdField_b_of_type_JavaLangString;
    localTransferRequest.mPeerUin = parambbqh.jdField_c_of_type_JavaLangString;
    localTransferRequest.mSecondId = parambbqh.d;
    localTransferRequest.mUinType = parambbqh.jdField_b_of_type_Int;
    localTransferRequest.mUniseq = parambbqh.jdField_a_of_type_Long;
    localTransferRequest.mIsUp = false;
    localTransferRequest.mBusiType = parambbqh.jdField_a_of_type_Int;
    localTransferRequest.mDownMode = parambbqh.f;
    localTransferRequest.mExtraObj = Integer.valueOf(parambbqh.g);
    localTransferRequest.mIsOnlyGetUrl = parambbqh.jdField_a_of_type_Boolean;
    if ((parambbqh.jdField_e_of_type_Int == 1001) || (parambbqh.jdField_e_of_type_Int == 1003) || (parambbqh.jdField_e_of_type_Int == 1005) || (parambbqh.jdField_e_of_type_Int == 1002) || (parambbqh.jdField_e_of_type_Int == 1004) || (parambbqh.jdField_e_of_type_Int == 1006)) {
      localTransferRequest.mMd5 = parambbqh.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bbrr != null) {
      localTransferRequest.mDownCallBack = this;
    }
    switch (parambbqh.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bbqx != null) && (this.jdField_a_of_type_Bbqx.a != null)) {
        localTransferRequest.mRec = this.jdField_a_of_type_Bbqx.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambbqh.jdField_e_of_type_Int + "downloadvideo MD5==" + parambbqh.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
      ayde.a(this.g, this.f, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      ayde.a(this.g, this.f, "doDownloadShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
      return;
      localTransferRequest.mFileType = 7;
      localTransferRequest.mLocalPath = (parambbqh.i + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 16;
      localTransferRequest.mLocalPath = (parambbqh.i + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 18;
      localTransferRequest.mLocalPath = (parambbqh.i + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 6;
      localTransferRequest.mLocalPath = (parambbqh.h + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_c_of_type_Int);
      continue;
      localTransferRequest.mFileType = 9;
      localTransferRequest.mLocalPath = (parambbqh.h + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_c_of_type_Int);
      continue;
      localTransferRequest.mFileType = 17;
      localTransferRequest.mLocalPath = (parambbqh.h + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambbqh.jdField_c_of_type_Int);
    }
  }
  
  public void onSend(ayep paramayep)
  {
    if (paramayep == null)
    {
      a(2, null);
      return;
    }
    if (paramayep.jdField_a_of_type_Int == 0)
    {
      updateMsg(paramayep);
      localObject = new bbrl();
      ((bbrl)localObject).jdField_a_of_type_Int = 0;
      ((bbrl)localObject).jdField_a_of_type_JavaLangObject = paramayep;
      a(2, (bbrl)localObject);
      return;
    }
    Object localObject = new aydp();
    ((aydp)localObject).jdField_b_of_type_JavaLangString = paramayep.jdField_a_of_type_JavaLangString;
    a(2, (aydp)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */