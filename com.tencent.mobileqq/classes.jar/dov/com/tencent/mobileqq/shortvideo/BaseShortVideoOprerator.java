package dov.com.tencent.mobileqq.shortvideo;

import anaj;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import aycx;
import aycy;
import ayde;
import aydp;
import ayeo;
import ayep;
import boat;
import bobf;
import bobh;
import bobi;
import bobn;
import bobo;
import bobp;
import bobt;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.transfile.TransFileController;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements aycx, ayeo, bobf
{
  static int a;
  protected Handler a;
  public bobn a;
  protected bobt a;
  public QQAppInterface a;
  public MessageRecord a;
  public String a;
  public String b;
  
  static
  {
    jdField_a_of_type_Int = 3;
  }
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new boat(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bobn parambobn)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(), 8, null, false);
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
    bobo localbobo = new bobo();
    localbobo.jdField_a_of_type_Bobn = this.jdField_a_of_type_Bobn;
    localbobo.jdField_a_of_type_Aydp = paramaydp;
    localbobo.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbobo);
    if (paramaydp != null)
    {
      ayde.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramaydp.jdField_a_of_type_JavaLangString, paramaydp.jdField_b_of_type_JavaLangString);
      return;
    }
    ayde.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, bobo parambobo)
  {
    bobo localbobo = parambobo;
    if (parambobo == null) {
      localbobo = new bobo();
    }
    localbobo.jdField_a_of_type_Int = 0;
    localbobo.jdField_a_of_type_Bobn = this.jdField_a_of_type_Bobn;
    a(paramInt, 0, localbobo);
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bobo localbobo = new bobo();
    localbobo.jdField_a_of_type_Int = 0;
    localbobo.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbobo);
  }
  
  public void a(Message paramMessage)
  {
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Bobt == null) {}
    int i;
    do
    {
      return;
      i = paramMessage.arg1;
      switch (paramMessage.what)
      {
      case 4: 
      default: 
        return;
      case 0: 
        paramMessage = (bobo)paramMessage.obj;
        this.jdField_a_of_type_Bobt.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (bobo)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Bobt.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (bobo)paramMessage.obj;
    this.jdField_a_of_type_Bobt.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Bobt.a(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = (bobo)paramMessage.obj;
      this.jdField_a_of_type_Bobt.a(paramMessage.jdField_a_of_type_ArrayOfJavaLangString, paramMessage.jdField_a_of_type_JavaLangString);
      return;
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
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bobn);
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramaycy.jdField_a_of_type_Int);
    Object localObject = new bobo();
    ((bobo)localObject).jdField_a_of_type_Int = paramaycy.jdField_a_of_type_Int;
    ((bobo)localObject).jdField_a_of_type_JavaLangObject = paramaycy;
    if (paramaycy.jdField_a_of_type_Int == 0)
    {
      a(0, (bobo)localObject);
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
  
  public void a(bobh parambobh)
  {
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambobh))
    {
      b(parambobh);
      return;
    }
    aycy localaycy = new aycy();
    localaycy.jdField_a_of_type_Int = -1;
    localaycy.jdField_a_of_type_Aydp = parambobh.jdField_a_of_type_Aydp;
    a(localaycy);
  }
  
  public void a(bobi parambobi)
  {
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambobi)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambobi));
    }
    while (parambobi == null) {
      return;
    }
    a(3, parambobi.jdField_a_of_type_Aydp);
  }
  
  public void a(bobp parambobp)
  {
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambobp)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambobp));
    }
    while (parambobp == null) {
      return;
    }
    a(2, parambobp.jdField_a_of_type_Aydp);
  }
  
  public void a(bobt parambobt)
  {
    this.jdField_a_of_type_Bobt = parambobt;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((anaj)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getBusinessHandler(13)).a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getMessageFacade().addMessage(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "addMsg", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public void a(ArrayList<bobi> paramArrayList)
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
  
  boolean a(bobh parambobh)
  {
    if (parambobh != null)
    {
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info:" + parambobh);
      return parambobh.a();
    }
    ayde.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(bobi parambobi)
  {
    if (parambobi != null)
    {
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info:" + parambobi);
      return parambobi.a();
    }
    ayde.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(bobp parambobp)
  {
    if (parambobp != null)
    {
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info:" + parambobp);
      return parambobp.a();
    }
    ayde.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public MessageRecord attachRichText2Msg(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  void b(bobh parambobh)
  {
    long l = System.currentTimeMillis();
    parambobh.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    TransferRequest localTransferRequest = new TransferRequest();
    localTransferRequest.mSelfUin = parambobh.jdField_b_of_type_JavaLangString;
    localTransferRequest.mPeerUin = parambobh.jdField_c_of_type_JavaLangString;
    localTransferRequest.mSecondId = parambobh.d;
    localTransferRequest.mUinType = parambobh.jdField_b_of_type_Int;
    localTransferRequest.mUniseq = parambobh.jdField_a_of_type_Long;
    localTransferRequest.mIsUp = false;
    localTransferRequest.mBusiType = parambobh.jdField_a_of_type_Int;
    localTransferRequest.mDownMode = parambobh.f;
    localTransferRequest.mExtraObj = Integer.valueOf(parambobh.g);
    localTransferRequest.mIsOnlyGetUrl = parambobh.jdField_a_of_type_Boolean;
    if ((parambobh.jdField_e_of_type_Int == 1001) || (parambobh.jdField_e_of_type_Int == 1003) || (parambobh.jdField_e_of_type_Int == 1005) || (parambobh.jdField_e_of_type_Int == 1002) || (parambobh.jdField_e_of_type_Int == 1004) || (parambobh.jdField_e_of_type_Int == 1006)) {
      localTransferRequest.mMd5 = parambobh.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bobt != null) {
      localTransferRequest.mDownCallBack = this;
    }
    switch (parambobh.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bobn != null) && (this.jdField_a_of_type_Bobn.a != null)) {
        localTransferRequest.mRec = this.jdField_a_of_type_Bobn.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambobh.jdField_e_of_type_Int + "downloadvideo MD5==" + parambobh.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getTransFileController().transferAsync(localTransferRequest);
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      ayde.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo.start", "TransferRequest: " + localTransferRequest.toString());
      return;
      localTransferRequest.mFileType = 7;
      localTransferRequest.mLocalPath = (parambobh.i + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 16;
      localTransferRequest.mLocalPath = (parambobh.i + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 18;
      localTransferRequest.mLocalPath = (parambobh.i + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_e_of_type_Int);
      continue;
      localTransferRequest.mFileType = 6;
      localTransferRequest.mLocalPath = (parambobh.h + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_c_of_type_Int);
      continue;
      localTransferRequest.mFileType = 9;
      localTransferRequest.mLocalPath = (parambobh.h + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_c_of_type_Int);
      continue;
      localTransferRequest.mFileType = 17;
      localTransferRequest.mLocalPath = (parambobh.h + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambobh.jdField_c_of_type_Int);
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
      localObject = new bobo();
      ((bobo)localObject).jdField_a_of_type_Int = 0;
      ((bobo)localObject).jdField_a_of_type_JavaLangObject = paramayep;
      a(2, (bobo)localObject);
      return;
    }
    Object localObject = new aydp();
    ((aydp)localObject).jdField_b_of_type_JavaLangString = paramayep.jdField_a_of_type_JavaLangString;
    a(2, (aydp)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */