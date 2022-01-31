package dov.com.tencent.mobileqq.shortvideo;

import ajrm;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import atpa;
import atpb;
import atpg;
import atpr;
import atqq;
import atqr;
import axvo;
import axvt;
import bjhz;
import bjiv;
import bjix;
import bjiy;
import bjjc;
import bjjd;
import bjjg;
import bjjk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements atpa, atqq, bjiv
{
  static int a;
  protected Handler a;
  public bjjc a;
  protected bjjk a;
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
      this.jdField_a_of_type_AndroidOsHandler = new bjhz(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bjjc parambjjc)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(), 8, null, false);
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return this.jdField_a_of_type_ComTencentMobileqqDataMessageRecord;
  }
  
  public void a(int paramInt1, int paramInt2, Object paramObject)
  {
    Message localMessage = new Message();
    localMessage.what = paramInt1;
    localMessage.arg1 = paramInt2;
    localMessage.obj = paramObject;
    this.jdField_a_of_type_AndroidOsHandler.sendMessage(localMessage);
  }
  
  protected void a(int paramInt, atpr paramatpr)
  {
    bjjd localbjjd = new bjjd();
    localbjjd.jdField_a_of_type_Bjjc = this.jdField_a_of_type_Bjjc;
    localbjjd.jdField_a_of_type_Atpr = paramatpr;
    localbjjd.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbjjd);
    if (paramatpr != null)
    {
      atpg.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramatpr.jdField_a_of_type_JavaLangString, paramatpr.jdField_b_of_type_JavaLangString);
      return;
    }
    atpg.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, bjjd parambjjd)
  {
    bjjd localbjjd = parambjjd;
    if (parambjjd == null) {
      localbjjd = new bjjd();
    }
    localbjjd.jdField_a_of_type_Int = 0;
    localbjjd.jdField_a_of_type_Bjjc = this.jdField_a_of_type_Bjjc;
    a(paramInt, 0, localbjjd);
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bjjd localbjjd = new bjjd();
    localbjjd.jdField_a_of_type_Int = 0;
    localbjjd.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbjjd);
  }
  
  public void a(Message paramMessage)
  {
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Bjjk == null) {}
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
        paramMessage = (bjjd)paramMessage.obj;
        this.jdField_a_of_type_Bjjk.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (bjjd)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Bjjk.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (bjjd)paramMessage.obj;
    this.jdField_a_of_type_Bjjk.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Bjjk.a(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = (bjjd)paramMessage.obj;
      this.jdField_a_of_type_Bjjk.a(paramMessage.jdField_a_of_type_ArrayOfJavaLangString, paramMessage.jdField_a_of_type_JavaLangString);
      return;
      paramMessage = null;
    }
  }
  
  public void a(atpb paramatpb)
  {
    if (paramatpb == null)
    {
      paramatpb = new atpr();
      paramatpb.jdField_b_of_type_JavaLangString = "result == null";
      paramatpb.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramatpb);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bjjc);
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramatpb.jdField_a_of_type_Int);
    Object localObject = new bjjd();
    ((bjjd)localObject).jdField_a_of_type_Int = paramatpb.jdField_a_of_type_Int;
    ((bjjd)localObject).jdField_a_of_type_JavaLangObject = paramatpb;
    if (paramatpb.jdField_a_of_type_Int == 0)
    {
      a(0, (bjjd)localObject);
      return;
    }
    if (paramatpb.jdField_a_of_type_Atpr == null)
    {
      localObject = new atpr();
      ((atpr)localObject).jdField_b_of_type_JavaLangString = (paramatpb.jdField_b_of_type_Int + "_" + paramatpb.jdField_a_of_type_JavaLangString);
      ((atpr)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (atpr)localObject);
      return;
    }
    a(0, paramatpb.jdField_a_of_type_Atpr);
  }
  
  public void a(bjix parambjix)
  {
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambjix))
    {
      b(parambjix);
      return;
    }
    atpb localatpb = new atpb();
    localatpb.jdField_a_of_type_Int = -1;
    localatpb.jdField_a_of_type_Atpr = parambjix.jdField_a_of_type_Atpr;
    a(localatpb);
  }
  
  public void a(bjiy parambjiy)
  {
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambjiy)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambjiy));
    }
    while (parambjiy == null) {
      return;
    }
    a(3, parambjiy.jdField_a_of_type_Atpr);
  }
  
  public void a(bjjg parambjjg)
  {
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambjjg)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambjjg));
    }
    while (parambjjg == null) {
      return;
    }
    a(2, parambjjg.jdField_a_of_type_Atpr);
  }
  
  public void a(bjjk parambjjk)
  {
    this.jdField_a_of_type_Bjjk = parambjjk;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((ajrm)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "addMsg", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public void a(ArrayList<bjiy> paramArrayList)
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
  
  boolean a(bjix parambjix)
  {
    if (parambjix != null)
    {
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info:" + parambjix);
      return parambjix.a();
    }
    atpg.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(bjiy parambjiy)
  {
    if (parambjiy != null)
    {
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info:" + parambjiy);
      return parambjiy.a();
    }
    atpg.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(bjjg parambjjg)
  {
    if (parambjjg != null)
    {
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info:" + parambjjg);
      return parambjjg.a();
    }
    atpg.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void b(atqr paramatqr)
  {
    if (paramatqr == null)
    {
      a(2, null);
      return;
    }
    if (paramatqr.jdField_a_of_type_Int == 0)
    {
      a(paramatqr);
      localObject = new bjjd();
      ((bjjd)localObject).jdField_a_of_type_Int = 0;
      ((bjjd)localObject).jdField_a_of_type_JavaLangObject = paramatqr;
      a(2, (bjjd)localObject);
      return;
    }
    Object localObject = new atpr();
    ((atpr)localObject).jdField_b_of_type_JavaLangString = paramatqr.jdField_a_of_type_JavaLangString;
    a(2, (atpr)localObject);
  }
  
  void b(bjix parambjix)
  {
    long l = System.currentTimeMillis();
    parambjix.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    axvt localaxvt = new axvt();
    localaxvt.jdField_b_of_type_JavaLangString = parambjix.jdField_b_of_type_JavaLangString;
    localaxvt.jdField_c_of_type_JavaLangString = parambjix.jdField_c_of_type_JavaLangString;
    localaxvt.d = parambjix.d;
    localaxvt.jdField_a_of_type_Int = parambjix.jdField_b_of_type_Int;
    localaxvt.jdField_a_of_type_Long = parambjix.jdField_a_of_type_Long;
    localaxvt.jdField_a_of_type_Boolean = false;
    localaxvt.jdField_e_of_type_Int = parambjix.jdField_a_of_type_Int;
    localaxvt.jdField_g_of_type_Int = parambjix.f;
    localaxvt.jdField_a_of_type_JavaLangObject = Integer.valueOf(parambjix.jdField_g_of_type_Int);
    localaxvt.jdField_g_of_type_Boolean = parambjix.jdField_a_of_type_Boolean;
    if ((parambjix.jdField_e_of_type_Int == 1001) || (parambjix.jdField_e_of_type_Int == 1003) || (parambjix.jdField_e_of_type_Int == 1005) || (parambjix.jdField_e_of_type_Int == 1002) || (parambjix.jdField_e_of_type_Int == 1004) || (parambjix.jdField_e_of_type_Int == 1006)) {
      localaxvt.f = parambjix.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bjjk != null) {
      localaxvt.jdField_a_of_type_Atpa = this;
    }
    switch (parambjix.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bjjc != null) && (this.jdField_a_of_type_Bjjc.a != null)) {
        localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Bjjc.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambjix.jdField_e_of_type_Int + "downloadvideo MD5==" + parambjix.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      atpg.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo.start", "TransferRequest: " + localaxvt.toString());
      return;
      localaxvt.jdField_b_of_type_Int = 7;
      localaxvt.i = (parambjix.i + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_e_of_type_Int);
      continue;
      localaxvt.jdField_b_of_type_Int = 16;
      localaxvt.i = (parambjix.i + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_e_of_type_Int);
      continue;
      localaxvt.jdField_b_of_type_Int = 18;
      localaxvt.i = (parambjix.i + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_e_of_type_Int);
      continue;
      localaxvt.jdField_b_of_type_Int = 6;
      localaxvt.i = (parambjix.h + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_c_of_type_Int);
      continue;
      localaxvt.jdField_b_of_type_Int = 9;
      localaxvt.i = (parambjix.h + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_c_of_type_Int);
      continue;
      localaxvt.jdField_b_of_type_Int = 17;
      localaxvt.i = (parambjix.h + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambjix.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */