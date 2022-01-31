package dov.com.tencent.mobileqq.shortvideo;

import amca;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import awiq;
import awir;
import awiw;
import awjh;
import awkh;
import awki;
import bayf;
import bayk;
import bnox;
import bnpt;
import bnpv;
import bnpw;
import bnqa;
import bnqb;
import bnqe;
import bnqi;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements awiq, awkh, bnpt
{
  static int a;
  protected Handler a;
  public bnqa a;
  protected bnqi a;
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
      this.jdField_a_of_type_AndroidOsHandler = new bnox(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bnqa parambnqa)
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
  
  protected void a(int paramInt, awjh paramawjh)
  {
    bnqb localbnqb = new bnqb();
    localbnqb.jdField_a_of_type_Bnqa = this.jdField_a_of_type_Bnqa;
    localbnqb.jdField_a_of_type_Awjh = paramawjh;
    localbnqb.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbnqb);
    if (paramawjh != null)
    {
      awiw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramawjh.jdField_a_of_type_JavaLangString, paramawjh.jdField_b_of_type_JavaLangString);
      return;
    }
    awiw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, bnqb parambnqb)
  {
    bnqb localbnqb = parambnqb;
    if (parambnqb == null) {
      localbnqb = new bnqb();
    }
    localbnqb.jdField_a_of_type_Int = 0;
    localbnqb.jdField_a_of_type_Bnqa = this.jdField_a_of_type_Bnqa;
    a(paramInt, 0, localbnqb);
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bnqb localbnqb = new bnqb();
    localbnqb.jdField_a_of_type_Int = 0;
    localbnqb.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbnqb);
  }
  
  public void a(Message paramMessage)
  {
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Bnqi == null) {}
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
        paramMessage = (bnqb)paramMessage.obj;
        this.jdField_a_of_type_Bnqi.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (bnqb)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Bnqi.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (bnqb)paramMessage.obj;
    this.jdField_a_of_type_Bnqi.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Bnqi.a(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = (bnqb)paramMessage.obj;
      this.jdField_a_of_type_Bnqi.a(paramMessage.jdField_a_of_type_ArrayOfJavaLangString, paramMessage.jdField_a_of_type_JavaLangString);
      return;
      paramMessage = null;
    }
  }
  
  public void a(awir paramawir)
  {
    if (paramawir == null)
    {
      paramawir = new awjh();
      paramawir.jdField_b_of_type_JavaLangString = "result == null";
      paramawir.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramawir);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bnqa);
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramawir.jdField_a_of_type_Int);
    Object localObject = new bnqb();
    ((bnqb)localObject).jdField_a_of_type_Int = paramawir.jdField_a_of_type_Int;
    ((bnqb)localObject).jdField_a_of_type_JavaLangObject = paramawir;
    if (paramawir.jdField_a_of_type_Int == 0)
    {
      a(0, (bnqb)localObject);
      return;
    }
    if (paramawir.jdField_a_of_type_Awjh == null)
    {
      localObject = new awjh();
      ((awjh)localObject).jdField_b_of_type_JavaLangString = (paramawir.jdField_b_of_type_Int + "_" + paramawir.jdField_a_of_type_JavaLangString);
      ((awjh)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (awjh)localObject);
      return;
    }
    a(0, paramawir.jdField_a_of_type_Awjh);
  }
  
  public void a(bnpv parambnpv)
  {
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambnpv))
    {
      b(parambnpv);
      return;
    }
    awir localawir = new awir();
    localawir.jdField_a_of_type_Int = -1;
    localawir.jdField_a_of_type_Awjh = parambnpv.jdField_a_of_type_Awjh;
    a(localawir);
  }
  
  public void a(bnpw parambnpw)
  {
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambnpw)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambnpw));
    }
    while (parambnpw == null) {
      return;
    }
    a(3, parambnpw.jdField_a_of_type_Awjh);
  }
  
  public void a(bnqe parambnqe)
  {
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambnqe)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambnqe));
    }
    while (parambnqe == null) {
      return;
    }
    a(2, parambnqe.jdField_a_of_type_Awjh);
  }
  
  public void a(bnqi parambnqi)
  {
    this.jdField_a_of_type_Bnqi = parambnqi;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((amca)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "addMsg", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public void a(ArrayList<bnpw> paramArrayList)
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
  
  boolean a(bnpv parambnpv)
  {
    if (parambnpv != null)
    {
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info:" + parambnpv);
      return parambnpv.a();
    }
    awiw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(bnpw parambnpw)
  {
    if (parambnpw != null)
    {
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info:" + parambnpw);
      return parambnpw.a();
    }
    awiw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(bnqe parambnqe)
  {
    if (parambnqe != null)
    {
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info:" + parambnqe);
      return parambnqe.a();
    }
    awiw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void b(awki paramawki)
  {
    if (paramawki == null)
    {
      a(2, null);
      return;
    }
    if (paramawki.jdField_a_of_type_Int == 0)
    {
      a(paramawki);
      localObject = new bnqb();
      ((bnqb)localObject).jdField_a_of_type_Int = 0;
      ((bnqb)localObject).jdField_a_of_type_JavaLangObject = paramawki;
      a(2, (bnqb)localObject);
      return;
    }
    Object localObject = new awjh();
    ((awjh)localObject).jdField_b_of_type_JavaLangString = paramawki.jdField_a_of_type_JavaLangString;
    a(2, (awjh)localObject);
  }
  
  void b(bnpv parambnpv)
  {
    long l = System.currentTimeMillis();
    parambnpv.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    bayk localbayk = new bayk();
    localbayk.jdField_b_of_type_JavaLangString = parambnpv.jdField_b_of_type_JavaLangString;
    localbayk.jdField_c_of_type_JavaLangString = parambnpv.jdField_c_of_type_JavaLangString;
    localbayk.d = parambnpv.d;
    localbayk.jdField_a_of_type_Int = parambnpv.jdField_b_of_type_Int;
    localbayk.jdField_a_of_type_Long = parambnpv.jdField_a_of_type_Long;
    localbayk.jdField_a_of_type_Boolean = false;
    localbayk.jdField_e_of_type_Int = parambnpv.jdField_a_of_type_Int;
    localbayk.jdField_g_of_type_Int = parambnpv.f;
    localbayk.jdField_a_of_type_JavaLangObject = Integer.valueOf(parambnpv.jdField_g_of_type_Int);
    localbayk.jdField_g_of_type_Boolean = parambnpv.jdField_a_of_type_Boolean;
    if ((parambnpv.jdField_e_of_type_Int == 1001) || (parambnpv.jdField_e_of_type_Int == 1003) || (parambnpv.jdField_e_of_type_Int == 1005) || (parambnpv.jdField_e_of_type_Int == 1002) || (parambnpv.jdField_e_of_type_Int == 1004) || (parambnpv.jdField_e_of_type_Int == 1006)) {
      localbayk.f = parambnpv.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bnqi != null) {
      localbayk.jdField_a_of_type_Awiq = this;
    }
    switch (parambnpv.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bnqa != null) && (this.jdField_a_of_type_Bnqa.a != null)) {
        localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Bnqa.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambnpv.jdField_e_of_type_Int + "downloadvideo MD5==" + parambnpv.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbayk);
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      awiw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo.start", "TransferRequest: " + localbayk.toString());
      return;
      localbayk.jdField_b_of_type_Int = 7;
      localbayk.i = (parambnpv.i + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_e_of_type_Int);
      continue;
      localbayk.jdField_b_of_type_Int = 16;
      localbayk.i = (parambnpv.i + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_e_of_type_Int);
      continue;
      localbayk.jdField_b_of_type_Int = 18;
      localbayk.i = (parambnpv.i + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_e_of_type_Int);
      continue;
      localbayk.jdField_b_of_type_Int = 6;
      localbayk.i = (parambnpv.h + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_c_of_type_Int);
      continue;
      localbayk.jdField_b_of_type_Int = 9;
      localbayk.i = (parambnpv.h + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_c_of_type_Int);
      continue;
      localbayk.jdField_b_of_type_Int = 17;
      localbayk.i = (parambnpv.h + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambnpv.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */