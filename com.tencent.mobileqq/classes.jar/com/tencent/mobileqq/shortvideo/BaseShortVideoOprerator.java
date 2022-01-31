package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import atpa;
import atpb;
import atpg;
import atpr;
import atqq;
import atqr;
import avau;
import awdr;
import awdt;
import awef;
import awej;
import awel;
import awey;
import awfk;
import awfo;
import awfr;
import axvo;
import axvt;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements atpa, atqq, awdt, awef
{
  static int d = 3;
  protected Handler a;
  public awey a;
  protected awfr a;
  public QQAppInterface a;
  public MessageRecord a;
  public String f;
  public String g;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new awdr(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, awey paramawey)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(paramQQAppInterface, paramawey), 8, null, false);
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
    awfk localawfk = new awfk();
    localawfk.jdField_a_of_type_Awey = this.jdField_a_of_type_Awey;
    localawfk.jdField_a_of_type_Atpr = paramatpr;
    localawfk.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localawfk);
    if (paramatpr != null)
    {
      atpg.b(this.g, this.f, paramatpr.jdField_a_of_type_JavaLangString, paramatpr.jdField_b_of_type_JavaLangString);
      return;
    }
    atpg.b(this.g, this.f, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, awfk paramawfk)
  {
    awfk localawfk = paramawfk;
    if (paramawfk == null) {
      localawfk = new awfk();
    }
    localawfk.jdField_a_of_type_Int = 0;
    localawfk.jdField_a_of_type_Awey = this.jdField_a_of_type_Awey;
    a(paramInt, 0, localawfk);
    atpg.a(this.g, this.f, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    awfk localawfk = new awfk();
    localawfk.jdField_a_of_type_Int = 0;
    localawfk.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localawfk);
  }
  
  public void a(Message paramMessage)
  {
    atpg.a(this.g, this.f, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Awfr == null) {}
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
        paramMessage = (awfk)paramMessage.obj;
        this.jdField_a_of_type_Awfr.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (awfk)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Awfr.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (awfk)paramMessage.obj;
    this.jdField_a_of_type_Awfr.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Awfr.a(i, paramMessage);
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
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Awey);
    atpg.a(this.g, this.f, "onDownload", "result:" + paramatpb.jdField_a_of_type_Int);
    Object localObject = new awfk();
    ((awfk)localObject).jdField_a_of_type_Int = paramatpb.jdField_a_of_type_Int;
    ((awfk)localObject).jdField_a_of_type_JavaLangObject = paramatpb;
    if (paramatpb.jdField_a_of_type_Int == 0)
    {
      a(0, (awfk)localObject);
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
  
  public void a(awej paramawej)
  {
    atpg.a(this.g, this.f, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramawej))
    {
      b(paramawej);
      return;
    }
    atpb localatpb = new atpb();
    localatpb.jdField_a_of_type_Int = -1;
    localatpb.jdField_a_of_type_Atpr = paramawej.jdField_a_of_type_Atpr;
    a(localatpb);
  }
  
  public void a(awel paramawel)
  {
    atpg.a(this.g, this.f, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramawel)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, paramawel));
    }
    while (paramawel == null) {
      return;
    }
    a(3, paramawel.jdField_a_of_type_Atpr);
  }
  
  public void a(awfo paramawfo)
  {
    atpg.a(this.g, this.f, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramawfo)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, paramawfo));
    }
    while (paramawfo == null) {
      return;
    }
    a(2, paramawfo.jdField_a_of_type_Atpr);
  }
  
  public void a(awfr paramawfr)
  {
    this.jdField_a_of_type_Awfr = paramawfr;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    avau localavau = (avau)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localavau.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localavau.a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(ArrayList<awel> paramArrayList)
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
  
  boolean a(awej paramawej)
  {
    if (paramawej != null)
    {
      atpg.a(this.g, this.f, "checkShortVideoDownloadInfo", "info:" + paramawej);
      return paramawej.a();
    }
    atpg.b(this.g, this.f, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(awel paramawel)
  {
    if (paramawel != null)
    {
      atpg.a(this.g, this.f, "checkShortVideoForwardInfo", "info:" + paramawel);
      return paramawel.a();
    }
    atpg.b(this.g, this.f, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(awfo paramawfo)
  {
    if (paramawfo != null)
    {
      atpg.a(this.g, this.f, "checkShortVideoUploadInfo", "info:" + paramawfo);
      return paramawfo.a();
    }
    atpg.b(this.g, this.f, "checkShortVideoUploadInfo", "info == null");
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
      localObject = new awfk();
      ((awfk)localObject).jdField_a_of_type_Int = 0;
      ((awfk)localObject).jdField_a_of_type_JavaLangObject = paramatqr;
      a(2, (awfk)localObject);
      return;
    }
    Object localObject = new atpr();
    ((atpr)localObject).jdField_b_of_type_JavaLangString = paramatqr.jdField_a_of_type_JavaLangString;
    a(2, (atpr)localObject);
  }
  
  void b(awej paramawej)
  {
    long l = System.currentTimeMillis();
    paramawej.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    axvt localaxvt = new axvt();
    localaxvt.jdField_b_of_type_JavaLangString = paramawej.jdField_b_of_type_JavaLangString;
    localaxvt.jdField_c_of_type_JavaLangString = paramawej.jdField_c_of_type_JavaLangString;
    localaxvt.d = paramawej.d;
    localaxvt.jdField_a_of_type_Int = paramawej.jdField_b_of_type_Int;
    localaxvt.jdField_a_of_type_Long = paramawej.jdField_a_of_type_Long;
    localaxvt.jdField_a_of_type_Boolean = false;
    localaxvt.jdField_e_of_type_Int = paramawej.jdField_a_of_type_Int;
    localaxvt.jdField_g_of_type_Int = paramawej.f;
    localaxvt.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramawej.jdField_g_of_type_Int);
    localaxvt.jdField_g_of_type_Boolean = paramawej.jdField_a_of_type_Boolean;
    if ((paramawej.jdField_e_of_type_Int == 1001) || (paramawej.jdField_e_of_type_Int == 1003) || (paramawej.jdField_e_of_type_Int == 1005) || (paramawej.jdField_e_of_type_Int == 1002) || (paramawej.jdField_e_of_type_Int == 1004) || (paramawej.jdField_e_of_type_Int == 1006)) {
      localaxvt.f = paramawej.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Awfr != null) {
      localaxvt.jdField_a_of_type_Atpa = this;
    }
    switch (paramawej.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Awey != null) && (this.jdField_a_of_type_Awey.a != null)) {
        localaxvt.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Awey.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + paramawej.jdField_e_of_type_Int + "downloadvideo MD5==" + paramawej.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaxvt);
      atpg.a(this.g, this.f, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      atpg.a(this.g, this.f, "doDownloadShortVideo.start", "TransferRequest: " + localaxvt.toString());
      return;
      localaxvt.jdField_b_of_type_Int = 7;
      localaxvt.i = (paramawej.i + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_e_of_type_Int);
      continue;
      localaxvt.jdField_b_of_type_Int = 16;
      localaxvt.i = (paramawej.i + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_e_of_type_Int);
      continue;
      localaxvt.jdField_b_of_type_Int = 18;
      localaxvt.i = (paramawej.i + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_e_of_type_Int);
      continue;
      localaxvt.jdField_b_of_type_Int = 6;
      localaxvt.i = (paramawej.h + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_c_of_type_Int);
      continue;
      localaxvt.jdField_b_of_type_Int = 9;
      localaxvt.i = (paramawej.h + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_c_of_type_Int);
      continue;
      localaxvt.jdField_b_of_type_Int = 17;
      localaxvt.i = (paramawej.h + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramawej.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */