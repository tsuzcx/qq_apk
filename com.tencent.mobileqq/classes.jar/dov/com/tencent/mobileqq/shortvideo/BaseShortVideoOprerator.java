package dov.com.tencent.mobileqq.shortvideo;

import alxl;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import aweh;
import awei;
import awen;
import awey;
import awfy;
import awfz;
import batw;
import baub;
import bnkl;
import bnlh;
import bnlj;
import bnlk;
import bnlo;
import bnlp;
import bnls;
import bnlw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements aweh, awfy, bnlh
{
  static int a;
  protected Handler a;
  public bnlo a;
  protected bnlw a;
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
      this.jdField_a_of_type_AndroidOsHandler = new bnkl(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bnlo parambnlo)
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
  
  protected void a(int paramInt, awey paramawey)
  {
    bnlp localbnlp = new bnlp();
    localbnlp.jdField_a_of_type_Bnlo = this.jdField_a_of_type_Bnlo;
    localbnlp.jdField_a_of_type_Awey = paramawey;
    localbnlp.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbnlp);
    if (paramawey != null)
    {
      awen.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramawey.jdField_a_of_type_JavaLangString, paramawey.jdField_b_of_type_JavaLangString);
      return;
    }
    awen.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, bnlp parambnlp)
  {
    bnlp localbnlp = parambnlp;
    if (parambnlp == null) {
      localbnlp = new bnlp();
    }
    localbnlp.jdField_a_of_type_Int = 0;
    localbnlp.jdField_a_of_type_Bnlo = this.jdField_a_of_type_Bnlo;
    a(paramInt, 0, localbnlp);
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bnlp localbnlp = new bnlp();
    localbnlp.jdField_a_of_type_Int = 0;
    localbnlp.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbnlp);
  }
  
  public void a(Message paramMessage)
  {
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Bnlw == null) {}
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
        paramMessage = (bnlp)paramMessage.obj;
        this.jdField_a_of_type_Bnlw.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (bnlp)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Bnlw.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (bnlp)paramMessage.obj;
    this.jdField_a_of_type_Bnlw.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Bnlw.a(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = (bnlp)paramMessage.obj;
      this.jdField_a_of_type_Bnlw.a(paramMessage.jdField_a_of_type_ArrayOfJavaLangString, paramMessage.jdField_a_of_type_JavaLangString);
      return;
      paramMessage = null;
    }
  }
  
  public void a(awei paramawei)
  {
    if (paramawei == null)
    {
      paramawei = new awey();
      paramawei.jdField_b_of_type_JavaLangString = "result == null";
      paramawei.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramawei);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bnlo);
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramawei.jdField_a_of_type_Int);
    Object localObject = new bnlp();
    ((bnlp)localObject).jdField_a_of_type_Int = paramawei.jdField_a_of_type_Int;
    ((bnlp)localObject).jdField_a_of_type_JavaLangObject = paramawei;
    if (paramawei.jdField_a_of_type_Int == 0)
    {
      a(0, (bnlp)localObject);
      return;
    }
    if (paramawei.jdField_a_of_type_Awey == null)
    {
      localObject = new awey();
      ((awey)localObject).jdField_b_of_type_JavaLangString = (paramawei.jdField_b_of_type_Int + "_" + paramawei.jdField_a_of_type_JavaLangString);
      ((awey)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (awey)localObject);
      return;
    }
    a(0, paramawei.jdField_a_of_type_Awey);
  }
  
  public void a(bnlj parambnlj)
  {
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambnlj))
    {
      b(parambnlj);
      return;
    }
    awei localawei = new awei();
    localawei.jdField_a_of_type_Int = -1;
    localawei.jdField_a_of_type_Awey = parambnlj.jdField_a_of_type_Awey;
    a(localawei);
  }
  
  public void a(bnlk parambnlk)
  {
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambnlk)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambnlk));
    }
    while (parambnlk == null) {
      return;
    }
    a(3, parambnlk.jdField_a_of_type_Awey);
  }
  
  public void a(bnls parambnls)
  {
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambnls)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambnls));
    }
    while (parambnls == null) {
      return;
    }
    a(2, parambnls.jdField_a_of_type_Awey);
  }
  
  public void a(bnlw parambnlw)
  {
    this.jdField_a_of_type_Bnlw = parambnlw;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((alxl)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "addMsg", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public void a(ArrayList<bnlk> paramArrayList)
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
  
  boolean a(bnlj parambnlj)
  {
    if (parambnlj != null)
    {
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info:" + parambnlj);
      return parambnlj.a();
    }
    awen.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(bnlk parambnlk)
  {
    if (parambnlk != null)
    {
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info:" + parambnlk);
      return parambnlk.a();
    }
    awen.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(bnls parambnls)
  {
    if (parambnls != null)
    {
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info:" + parambnls);
      return parambnls.a();
    }
    awen.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void b(awfz paramawfz)
  {
    if (paramawfz == null)
    {
      a(2, null);
      return;
    }
    if (paramawfz.jdField_a_of_type_Int == 0)
    {
      a(paramawfz);
      localObject = new bnlp();
      ((bnlp)localObject).jdField_a_of_type_Int = 0;
      ((bnlp)localObject).jdField_a_of_type_JavaLangObject = paramawfz;
      a(2, (bnlp)localObject);
      return;
    }
    Object localObject = new awey();
    ((awey)localObject).jdField_b_of_type_JavaLangString = paramawfz.jdField_a_of_type_JavaLangString;
    a(2, (awey)localObject);
  }
  
  void b(bnlj parambnlj)
  {
    long l = System.currentTimeMillis();
    parambnlj.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    baub localbaub = new baub();
    localbaub.jdField_b_of_type_JavaLangString = parambnlj.jdField_b_of_type_JavaLangString;
    localbaub.jdField_c_of_type_JavaLangString = parambnlj.jdField_c_of_type_JavaLangString;
    localbaub.d = parambnlj.d;
    localbaub.jdField_a_of_type_Int = parambnlj.jdField_b_of_type_Int;
    localbaub.jdField_a_of_type_Long = parambnlj.jdField_a_of_type_Long;
    localbaub.jdField_a_of_type_Boolean = false;
    localbaub.jdField_e_of_type_Int = parambnlj.jdField_a_of_type_Int;
    localbaub.jdField_g_of_type_Int = parambnlj.f;
    localbaub.jdField_a_of_type_JavaLangObject = Integer.valueOf(parambnlj.jdField_g_of_type_Int);
    localbaub.jdField_g_of_type_Boolean = parambnlj.jdField_a_of_type_Boolean;
    if ((parambnlj.jdField_e_of_type_Int == 1001) || (parambnlj.jdField_e_of_type_Int == 1003) || (parambnlj.jdField_e_of_type_Int == 1005) || (parambnlj.jdField_e_of_type_Int == 1002) || (parambnlj.jdField_e_of_type_Int == 1004) || (parambnlj.jdField_e_of_type_Int == 1006)) {
      localbaub.f = parambnlj.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bnlw != null) {
      localbaub.jdField_a_of_type_Aweh = this;
    }
    switch (parambnlj.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bnlo != null) && (this.jdField_a_of_type_Bnlo.a != null)) {
        localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Bnlo.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambnlj.jdField_e_of_type_Int + "downloadvideo MD5==" + parambnlj.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      awen.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo.start", "TransferRequest: " + localbaub.toString());
      return;
      localbaub.jdField_b_of_type_Int = 7;
      localbaub.i = (parambnlj.i + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_e_of_type_Int);
      continue;
      localbaub.jdField_b_of_type_Int = 16;
      localbaub.i = (parambnlj.i + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_e_of_type_Int);
      continue;
      localbaub.jdField_b_of_type_Int = 18;
      localbaub.i = (parambnlj.i + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_e_of_type_Int);
      continue;
      localbaub.jdField_b_of_type_Int = 6;
      localbaub.i = (parambnlj.h + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_c_of_type_Int);
      continue;
      localbaub.jdField_b_of_type_Int = 9;
      localbaub.i = (parambnlj.h + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_c_of_type_Int);
      continue;
      localbaub.jdField_b_of_type_Int = 17;
      localbaub.i = (parambnlj.h + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambnlj.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */