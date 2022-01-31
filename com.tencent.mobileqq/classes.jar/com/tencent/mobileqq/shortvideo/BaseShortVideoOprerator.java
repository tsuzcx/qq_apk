package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import awiq;
import awir;
import awiw;
import awjh;
import awkh;
import awki;
import axwx;
import azco;
import azcq;
import azdc;
import azdg;
import azdi;
import azdx;
import azej;
import azen;
import azeq;
import bayf;
import bayk;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements awiq, awkh, azcq, azdc
{
  static int d = 3;
  protected Handler a;
  public azdx a;
  protected azeq a;
  public QQAppInterface a;
  public MessageRecord a;
  public String f;
  public String g;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new azco(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, azdx paramazdx)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(paramQQAppInterface, paramazdx), 8, null, false);
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
    azej localazej = new azej();
    localazej.jdField_a_of_type_Azdx = this.jdField_a_of_type_Azdx;
    localazej.jdField_a_of_type_Awjh = paramawjh;
    localazej.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localazej);
    if (paramawjh != null)
    {
      awiw.b(this.g, this.f, paramawjh.jdField_a_of_type_JavaLangString, paramawjh.jdField_b_of_type_JavaLangString);
      return;
    }
    awiw.b(this.g, this.f, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, azej paramazej)
  {
    azej localazej = paramazej;
    if (paramazej == null) {
      localazej = new azej();
    }
    localazej.jdField_a_of_type_Int = 0;
    localazej.jdField_a_of_type_Azdx = this.jdField_a_of_type_Azdx;
    a(paramInt, 0, localazej);
    awiw.a(this.g, this.f, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    azej localazej = new azej();
    localazej.jdField_a_of_type_Int = 0;
    localazej.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localazej);
  }
  
  public void a(Message paramMessage)
  {
    awiw.a(this.g, this.f, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Azeq == null) {}
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
        paramMessage = (azej)paramMessage.obj;
        this.jdField_a_of_type_Azeq.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (azej)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Azeq.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (azej)paramMessage.obj;
    this.jdField_a_of_type_Azeq.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Azeq.a(i, paramMessage);
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
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Azdx);
    awiw.a(this.g, this.f, "onDownload", "result:" + paramawir.jdField_a_of_type_Int);
    Object localObject = new azej();
    ((azej)localObject).jdField_a_of_type_Int = paramawir.jdField_a_of_type_Int;
    ((azej)localObject).jdField_a_of_type_JavaLangObject = paramawir;
    if (paramawir.jdField_a_of_type_Int == 0)
    {
      a(0, (azej)localObject);
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
  
  public void a(azdg paramazdg)
  {
    awiw.a(this.g, this.f, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramazdg))
    {
      b(paramazdg);
      return;
    }
    awir localawir = new awir();
    localawir.jdField_a_of_type_Int = -1;
    localawir.jdField_a_of_type_Awjh = paramazdg.jdField_a_of_type_Awjh;
    a(localawir);
  }
  
  public void a(azdi paramazdi)
  {
    awiw.a(this.g, this.f, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramazdi)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, paramazdi));
    }
    while (paramazdi == null) {
      return;
    }
    a(3, paramazdi.jdField_a_of_type_Awjh);
  }
  
  public void a(azen paramazen)
  {
    awiw.a(this.g, this.f, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramazen)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, paramazen));
    }
    while (paramazen == null) {
      return;
    }
    a(2, paramazen.jdField_a_of_type_Awjh);
  }
  
  public void a(azeq paramazeq)
  {
    this.jdField_a_of_type_Azeq = paramazeq;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    axwx localaxwx = (axwx)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localaxwx.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localaxwx.a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(ArrayList<azdi> paramArrayList)
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
  
  boolean a(azdg paramazdg)
  {
    if (paramazdg != null)
    {
      awiw.a(this.g, this.f, "checkShortVideoDownloadInfo", "info:" + paramazdg);
      return paramazdg.a();
    }
    awiw.b(this.g, this.f, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(azdi paramazdi)
  {
    if (paramazdi != null)
    {
      awiw.a(this.g, this.f, "checkShortVideoForwardInfo", "info:" + paramazdi);
      return paramazdi.a();
    }
    awiw.b(this.g, this.f, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(azen paramazen)
  {
    if (paramazen != null)
    {
      awiw.a(this.g, this.f, "checkShortVideoUploadInfo", "info:" + paramazen);
      return paramazen.a();
    }
    awiw.b(this.g, this.f, "checkShortVideoUploadInfo", "info == null");
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
      localObject = new azej();
      ((azej)localObject).jdField_a_of_type_Int = 0;
      ((azej)localObject).jdField_a_of_type_JavaLangObject = paramawki;
      a(2, (azej)localObject);
      return;
    }
    Object localObject = new awjh();
    ((awjh)localObject).jdField_b_of_type_JavaLangString = paramawki.jdField_a_of_type_JavaLangString;
    a(2, (awjh)localObject);
  }
  
  void b(azdg paramazdg)
  {
    long l = System.currentTimeMillis();
    paramazdg.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    bayk localbayk = new bayk();
    localbayk.jdField_b_of_type_JavaLangString = paramazdg.jdField_b_of_type_JavaLangString;
    localbayk.jdField_c_of_type_JavaLangString = paramazdg.jdField_c_of_type_JavaLangString;
    localbayk.d = paramazdg.d;
    localbayk.jdField_a_of_type_Int = paramazdg.jdField_b_of_type_Int;
    localbayk.jdField_a_of_type_Long = paramazdg.jdField_a_of_type_Long;
    localbayk.jdField_a_of_type_Boolean = false;
    localbayk.jdField_e_of_type_Int = paramazdg.jdField_a_of_type_Int;
    localbayk.jdField_g_of_type_Int = paramazdg.f;
    localbayk.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramazdg.jdField_g_of_type_Int);
    localbayk.jdField_g_of_type_Boolean = paramazdg.jdField_a_of_type_Boolean;
    if ((paramazdg.jdField_e_of_type_Int == 1001) || (paramazdg.jdField_e_of_type_Int == 1003) || (paramazdg.jdField_e_of_type_Int == 1005) || (paramazdg.jdField_e_of_type_Int == 1002) || (paramazdg.jdField_e_of_type_Int == 1004) || (paramazdg.jdField_e_of_type_Int == 1006)) {
      localbayk.f = paramazdg.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Azeq != null) {
      localbayk.jdField_a_of_type_Awiq = this;
    }
    switch (paramazdg.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Azdx != null) && (this.jdField_a_of_type_Azdx.a != null)) {
        localbayk.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Azdx.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + paramazdg.jdField_e_of_type_Int + "downloadvideo MD5==" + paramazdg.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbayk);
      awiw.a(this.g, this.f, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      awiw.a(this.g, this.f, "doDownloadShortVideo.start", "TransferRequest: " + localbayk.toString());
      return;
      localbayk.jdField_b_of_type_Int = 7;
      localbayk.i = (paramazdg.i + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_e_of_type_Int);
      continue;
      localbayk.jdField_b_of_type_Int = 16;
      localbayk.i = (paramazdg.i + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_e_of_type_Int);
      continue;
      localbayk.jdField_b_of_type_Int = 18;
      localbayk.i = (paramazdg.i + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_e_of_type_Int);
      continue;
      localbayk.jdField_b_of_type_Int = 6;
      localbayk.i = (paramazdg.h + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_c_of_type_Int);
      continue;
      localbayk.jdField_b_of_type_Int = 9;
      localbayk.i = (paramazdg.h + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_c_of_type_Int);
      continue;
      localbayk.jdField_b_of_type_Int = 17;
      localbayk.i = (paramazdg.h + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramazdg.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */