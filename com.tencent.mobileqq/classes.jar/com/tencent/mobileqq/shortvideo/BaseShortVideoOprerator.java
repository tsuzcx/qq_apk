package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import azjj;
import azjk;
import azjq;
import azkb;
import azla;
import azlb;
import bbob;
import bcwj;
import bcwm;
import bcwy;
import bcxb;
import bcxd;
import bcxr;
import bcyf;
import bcyj;
import bcyl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
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
  implements azjj, azla, bcwm, bcwy
{
  static int d = 3;
  protected Handler a;
  public bcxr a;
  protected bcyl a;
  public QQAppInterface a;
  public MessageRecord a;
  public String f;
  public String g;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new bcwj(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bcxr parambcxr)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(paramQQAppInterface, parambcxr), 8, null, false);
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, azkb paramazkb)
  {
    bcyf localbcyf = new bcyf();
    localbcyf.jdField_a_of_type_Bcxr = this.jdField_a_of_type_Bcxr;
    localbcyf.jdField_a_of_type_Azkb = paramazkb;
    localbcyf.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbcyf);
    if (paramazkb != null)
    {
      azjq.b(this.g, this.f, paramazkb.jdField_a_of_type_JavaLangString, paramazkb.jdField_b_of_type_JavaLangString);
      return;
    }
    azjq.b(this.g, this.f, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, bcyf parambcyf)
  {
    bcyf localbcyf = parambcyf;
    if (parambcyf == null) {
      localbcyf = new bcyf();
    }
    localbcyf.jdField_a_of_type_Int = 0;
    localbcyf.jdField_a_of_type_Bcxr = this.jdField_a_of_type_Bcxr;
    a(paramInt, 0, localbcyf);
    azjq.a(this.g, this.f, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bcyf localbcyf = new bcyf();
    localbcyf.jdField_a_of_type_Int = 0;
    localbcyf.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbcyf);
  }
  
  public void a(Message paramMessage)
  {
    azjq.a(this.g, this.f, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Bcyl == null) {}
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
        paramMessage = (bcyf)paramMessage.obj;
        this.jdField_a_of_type_Bcyl.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (bcyf)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Bcyl.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (bcyf)paramMessage.obj;
    this.jdField_a_of_type_Bcyl.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Bcyl.a(i, paramMessage);
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
  
  public void a(azjk paramazjk)
  {
    if (paramazjk == null)
    {
      paramazjk = new azkb();
      paramazjk.jdField_b_of_type_JavaLangString = "result == null";
      paramazjk.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramazjk);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcxr);
    azjq.a(this.g, this.f, "onDownload", "result:" + paramazjk.jdField_a_of_type_Int);
    Object localObject = new bcyf();
    ((bcyf)localObject).jdField_a_of_type_Int = paramazjk.jdField_a_of_type_Int;
    ((bcyf)localObject).jdField_a_of_type_JavaLangObject = paramazjk;
    if (paramazjk.jdField_a_of_type_Int == 0)
    {
      a(0, (bcyf)localObject);
      return;
    }
    if (paramazjk.jdField_a_of_type_Azkb == null)
    {
      localObject = new azkb();
      ((azkb)localObject).jdField_b_of_type_JavaLangString = (paramazjk.jdField_b_of_type_Int + "_" + paramazjk.jdField_a_of_type_JavaLangString);
      ((azkb)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (azkb)localObject);
      return;
    }
    a(0, paramazjk.jdField_a_of_type_Azkb);
  }
  
  public void a(bcxb parambcxb)
  {
    azjq.a(this.g, this.f, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambcxb))
    {
      b(parambcxb);
      return;
    }
    azjk localazjk = new azjk();
    localazjk.jdField_a_of_type_Int = -1;
    localazjk.jdField_a_of_type_Azkb = parambcxb.jdField_a_of_type_Azkb;
    a(localazjk);
  }
  
  public void a(bcxd parambcxd)
  {
    azjq.a(this.g, this.f, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambcxd)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambcxd));
    }
    while (parambcxd == null) {
      return;
    }
    a(3, parambcxd.jdField_a_of_type_Azkb);
  }
  
  public void a(bcyj parambcyj)
  {
    azjq.a(this.g, this.f, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambcyj)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambcyj));
    }
    while (parambcyj == null) {
      return;
    }
    a(2, parambcyj.jdField_a_of_type_Azkb);
  }
  
  public void a(bcyl parambcyl)
  {
    this.jdField_a_of_type_Bcyl = parambcyl;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER)).a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    bbob localbbob = (bbob)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(QQManagerFactory.MEDIA_MSG_ORDER_SEND_MANAGER);
    localbbob.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localbbob.a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(ArrayList<bcxd> paramArrayList)
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
  
  boolean a(bcxb parambcxb)
  {
    if (parambcxb != null)
    {
      azjq.a(this.g, this.f, "checkShortVideoDownloadInfo", "info:" + parambcxb);
      return parambcxb.a();
    }
    azjq.b(this.g, this.f, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(bcxd parambcxd)
  {
    if (parambcxd != null)
    {
      azjq.a(this.g, this.f, "checkShortVideoForwardInfo", "info:" + parambcxd);
      return parambcxd.a();
    }
    azjq.b(this.g, this.f, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(bcyj parambcyj)
  {
    if (parambcyj != null)
    {
      azjq.a(this.g, this.f, "checkShortVideoUploadInfo", "info:" + parambcyj);
      return parambcyj.a();
    }
    azjq.b(this.g, this.f, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  void b(bcxb parambcxb)
  {
    long l = System.currentTimeMillis();
    parambcxb.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = parambcxb.jdField_b_of_type_JavaLangString;
    localTransferRequest.mPeerUin = parambcxb.jdField_c_of_type_JavaLangString;
    localTransferRequest.mSecondId = parambcxb.d;
    localTransferRequest.mUinType = parambcxb.jdField_b_of_type_Int;
    localTransferRequest.mUniseq = parambcxb.jdField_a_of_type_Long;
    localTransferRequest.mIsUp = false;
    localTransferRequest.mBusiType = parambcxb.jdField_a_of_type_Int;
    localTransferRequest.mDownMode = parambcxb.f;
    localTransferRequest.mExtraObj = Integer.valueOf(parambcxb.g);
    localTransferRequest.mIsOnlyGetUrl = parambcxb.jdField_a_of_type_Boolean;
    if ((parambcxb.jdField_e_of_type_Int == 1001) || (parambcxb.jdField_e_of_type_Int == 1003) || (parambcxb.jdField_e_of_type_Int == 1005) || (parambcxb.jdField_e_of_type_Int == 1002) || (parambcxb.jdField_e_of_type_Int == 1004) || (parambcxb.jdField_e_of_type_Int == 1006)) {
      localTransferRequest.mMd5 = parambcxb.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bcyl != null) {
      localTransferRequest.mDownCallBack = this;
    }
    switch (parambcxb.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bcxr != null) && (this.jdField_a_of_type_Bcxr.a != null)) {
        localTransferRequest.mRec = this.jdField_a_of_type_Bcxr.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambcxb.jdField_e_of_type_Int + "downloadvideo MD5==" + parambcxb.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
      azjq.a(this.g, this.f, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      azjq.a(this.g, this.f, "doDownloadShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
      return;
      localTransferRequest.mFileType = 7;
      localTransferRequest.mLocalPath = (parambcxb.i + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 16;
      localTransferRequest.mLocalPath = (parambcxb.i + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 18;
      localTransferRequest.mLocalPath = (parambcxb.i + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 6;
      localTransferRequest.mLocalPath = (parambcxb.h + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_c_of_type_Int);
      continue;
      localTransferRequest.mFileType = 9;
      localTransferRequest.mLocalPath = (parambcxb.h + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_c_of_type_Int);
      continue;
      localTransferRequest.mFileType = 17;
      localTransferRequest.mLocalPath = (parambcxb.h + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambcxb.jdField_c_of_type_Int);
    }
  }
  
  public void onSend(azlb paramazlb)
  {
    if (paramazlb == null)
    {
      a(2, null);
      return;
    }
    if (paramazlb.jdField_a_of_type_Int == 0)
    {
      updateMsg(paramazlb);
      localObject = new bcyf();
      ((bcyf)localObject).jdField_a_of_type_Int = 0;
      ((bcyf)localObject).jdField_a_of_type_JavaLangObject = paramazlb;
      a(2, (bcyf)localObject);
      return;
    }
    Object localObject = new azkb();
    ((azkb)localObject).jdField_b_of_type_JavaLangString = paramazlb.jdField_a_of_type_JavaLangString;
    a(2, (azkb)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */