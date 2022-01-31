package dov.com.tencent.mobileqq.shortvideo;

import akfw;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import aumy;
import aumz;
import aune;
import aunp;
import auoo;
import auop;
import ayvv;
import aywa;
import bkyk;
import bkzg;
import bkzi;
import bkzj;
import bkzn;
import bkzo;
import bkzr;
import bkzv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements aumy, auoo, bkzg
{
  static int a;
  protected Handler a;
  public bkzn a;
  protected bkzv a;
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
      this.jdField_a_of_type_AndroidOsHandler = new bkyk(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bkzn parambkzn)
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
  
  protected void a(int paramInt, aunp paramaunp)
  {
    bkzo localbkzo = new bkzo();
    localbkzo.jdField_a_of_type_Bkzn = this.jdField_a_of_type_Bkzn;
    localbkzo.jdField_a_of_type_Aunp = paramaunp;
    localbkzo.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbkzo);
    if (paramaunp != null)
    {
      aune.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramaunp.jdField_a_of_type_JavaLangString, paramaunp.jdField_b_of_type_JavaLangString);
      return;
    }
    aune.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, bkzo parambkzo)
  {
    bkzo localbkzo = parambkzo;
    if (parambkzo == null) {
      localbkzo = new bkzo();
    }
    localbkzo.jdField_a_of_type_Int = 0;
    localbkzo.jdField_a_of_type_Bkzn = this.jdField_a_of_type_Bkzn;
    a(paramInt, 0, localbkzo);
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bkzo localbkzo = new bkzo();
    localbkzo.jdField_a_of_type_Int = 0;
    localbkzo.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbkzo);
  }
  
  public void a(Message paramMessage)
  {
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Bkzv == null) {}
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
        paramMessage = (bkzo)paramMessage.obj;
        this.jdField_a_of_type_Bkzv.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (bkzo)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Bkzv.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (bkzo)paramMessage.obj;
    this.jdField_a_of_type_Bkzv.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Bkzv.a(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = (bkzo)paramMessage.obj;
      this.jdField_a_of_type_Bkzv.a(paramMessage.jdField_a_of_type_ArrayOfJavaLangString, paramMessage.jdField_a_of_type_JavaLangString);
      return;
      paramMessage = null;
    }
  }
  
  public void a(aumz paramaumz)
  {
    if (paramaumz == null)
    {
      paramaumz = new aunp();
      paramaumz.jdField_b_of_type_JavaLangString = "result == null";
      paramaumz.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramaumz);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bkzn);
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramaumz.jdField_a_of_type_Int);
    Object localObject = new bkzo();
    ((bkzo)localObject).jdField_a_of_type_Int = paramaumz.jdField_a_of_type_Int;
    ((bkzo)localObject).jdField_a_of_type_JavaLangObject = paramaumz;
    if (paramaumz.jdField_a_of_type_Int == 0)
    {
      a(0, (bkzo)localObject);
      return;
    }
    if (paramaumz.jdField_a_of_type_Aunp == null)
    {
      localObject = new aunp();
      ((aunp)localObject).jdField_b_of_type_JavaLangString = (paramaumz.jdField_b_of_type_Int + "_" + paramaumz.jdField_a_of_type_JavaLangString);
      ((aunp)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (aunp)localObject);
      return;
    }
    a(0, paramaumz.jdField_a_of_type_Aunp);
  }
  
  public void a(bkzi parambkzi)
  {
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambkzi))
    {
      b(parambkzi);
      return;
    }
    aumz localaumz = new aumz();
    localaumz.jdField_a_of_type_Int = -1;
    localaumz.jdField_a_of_type_Aunp = parambkzi.jdField_a_of_type_Aunp;
    a(localaumz);
  }
  
  public void a(bkzj parambkzj)
  {
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambkzj)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambkzj));
    }
    while (parambkzj == null) {
      return;
    }
    a(3, parambkzj.jdField_a_of_type_Aunp);
  }
  
  public void a(bkzr parambkzr)
  {
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambkzr)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambkzr));
    }
    while (parambkzr == null) {
      return;
    }
    a(2, parambkzr.jdField_a_of_type_Aunp);
  }
  
  public void a(bkzv parambkzv)
  {
    this.jdField_a_of_type_Bkzv = parambkzv;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((akfw)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "addMsg", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public void a(ArrayList<bkzj> paramArrayList)
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
  
  boolean a(bkzi parambkzi)
  {
    if (parambkzi != null)
    {
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info:" + parambkzi);
      return parambkzi.a();
    }
    aune.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(bkzj parambkzj)
  {
    if (parambkzj != null)
    {
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info:" + parambkzj);
      return parambkzj.a();
    }
    aune.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(bkzr parambkzr)
  {
    if (parambkzr != null)
    {
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info:" + parambkzr);
      return parambkzr.a();
    }
    aune.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void b(auop paramauop)
  {
    if (paramauop == null)
    {
      a(2, null);
      return;
    }
    if (paramauop.jdField_a_of_type_Int == 0)
    {
      a(paramauop);
      localObject = new bkzo();
      ((bkzo)localObject).jdField_a_of_type_Int = 0;
      ((bkzo)localObject).jdField_a_of_type_JavaLangObject = paramauop;
      a(2, (bkzo)localObject);
      return;
    }
    Object localObject = new aunp();
    ((aunp)localObject).jdField_b_of_type_JavaLangString = paramauop.jdField_a_of_type_JavaLangString;
    a(2, (aunp)localObject);
  }
  
  void b(bkzi parambkzi)
  {
    long l = System.currentTimeMillis();
    parambkzi.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    aywa localaywa = new aywa();
    localaywa.jdField_b_of_type_JavaLangString = parambkzi.jdField_b_of_type_JavaLangString;
    localaywa.jdField_c_of_type_JavaLangString = parambkzi.jdField_c_of_type_JavaLangString;
    localaywa.d = parambkzi.d;
    localaywa.jdField_a_of_type_Int = parambkzi.jdField_b_of_type_Int;
    localaywa.jdField_a_of_type_Long = parambkzi.jdField_a_of_type_Long;
    localaywa.jdField_a_of_type_Boolean = false;
    localaywa.jdField_e_of_type_Int = parambkzi.jdField_a_of_type_Int;
    localaywa.jdField_g_of_type_Int = parambkzi.f;
    localaywa.jdField_a_of_type_JavaLangObject = Integer.valueOf(parambkzi.jdField_g_of_type_Int);
    localaywa.jdField_g_of_type_Boolean = parambkzi.jdField_a_of_type_Boolean;
    if ((parambkzi.jdField_e_of_type_Int == 1001) || (parambkzi.jdField_e_of_type_Int == 1003) || (parambkzi.jdField_e_of_type_Int == 1005) || (parambkzi.jdField_e_of_type_Int == 1002) || (parambkzi.jdField_e_of_type_Int == 1004) || (parambkzi.jdField_e_of_type_Int == 1006)) {
      localaywa.f = parambkzi.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bkzv != null) {
      localaywa.jdField_a_of_type_Aumy = this;
    }
    switch (parambkzi.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bkzn != null) && (this.jdField_a_of_type_Bkzn.a != null)) {
        localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Bkzn.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambkzi.jdField_e_of_type_Int + "downloadvideo MD5==" + parambkzi.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywa);
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      aune.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo.start", "TransferRequest: " + localaywa.toString());
      return;
      localaywa.jdField_b_of_type_Int = 7;
      localaywa.i = (parambkzi.i + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_e_of_type_Int);
      continue;
      localaywa.jdField_b_of_type_Int = 16;
      localaywa.i = (parambkzi.i + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_e_of_type_Int);
      continue;
      localaywa.jdField_b_of_type_Int = 18;
      localaywa.i = (parambkzi.i + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_e_of_type_Int);
      continue;
      localaywa.jdField_b_of_type_Int = 6;
      localaywa.i = (parambkzi.h + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_c_of_type_Int);
      continue;
      localaywa.jdField_b_of_type_Int = 9;
      localaywa.i = (parambkzi.h + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_c_of_type_Int);
      continue;
      localaywa.jdField_b_of_type_Int = 17;
      localaywa.i = (parambkzi.h + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambkzi.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */