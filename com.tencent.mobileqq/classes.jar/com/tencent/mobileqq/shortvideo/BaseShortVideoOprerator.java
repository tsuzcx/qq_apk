package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import auna;
import aunb;
import aung;
import aunr;
import auoq;
import auor;
import awap;
import axdb;
import axdd;
import axdp;
import axdt;
import axdv;
import axei;
import axeu;
import axey;
import axfb;
import ayvx;
import aywc;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements auna, auoq, axdd, axdp
{
  static int d = 3;
  protected Handler a;
  public axei a;
  protected axfb a;
  public QQAppInterface a;
  public MessageRecord a;
  public String f;
  public String g;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new axdb(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, axei paramaxei)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(paramQQAppInterface, paramaxei), 8, null, false);
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
  
  protected void a(int paramInt, aunr paramaunr)
  {
    axeu localaxeu = new axeu();
    localaxeu.jdField_a_of_type_Axei = this.jdField_a_of_type_Axei;
    localaxeu.jdField_a_of_type_Aunr = paramaunr;
    localaxeu.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localaxeu);
    if (paramaunr != null)
    {
      aung.b(this.g, this.f, paramaunr.jdField_a_of_type_JavaLangString, paramaunr.jdField_b_of_type_JavaLangString);
      return;
    }
    aung.b(this.g, this.f, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, axeu paramaxeu)
  {
    axeu localaxeu = paramaxeu;
    if (paramaxeu == null) {
      localaxeu = new axeu();
    }
    localaxeu.jdField_a_of_type_Int = 0;
    localaxeu.jdField_a_of_type_Axei = this.jdField_a_of_type_Axei;
    a(paramInt, 0, localaxeu);
    aung.a(this.g, this.f, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    axeu localaxeu = new axeu();
    localaxeu.jdField_a_of_type_Int = 0;
    localaxeu.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localaxeu);
  }
  
  public void a(Message paramMessage)
  {
    aung.a(this.g, this.f, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Axfb == null) {}
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
        paramMessage = (axeu)paramMessage.obj;
        this.jdField_a_of_type_Axfb.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (axeu)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Axfb.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (axeu)paramMessage.obj;
    this.jdField_a_of_type_Axfb.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Axfb.a(i, paramMessage);
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
  
  public void a(aunb paramaunb)
  {
    if (paramaunb == null)
    {
      paramaunb = new aunr();
      paramaunb.jdField_b_of_type_JavaLangString = "result == null";
      paramaunb.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramaunb);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Axei);
    aung.a(this.g, this.f, "onDownload", "result:" + paramaunb.jdField_a_of_type_Int);
    Object localObject = new axeu();
    ((axeu)localObject).jdField_a_of_type_Int = paramaunb.jdField_a_of_type_Int;
    ((axeu)localObject).jdField_a_of_type_JavaLangObject = paramaunb;
    if (paramaunb.jdField_a_of_type_Int == 0)
    {
      a(0, (axeu)localObject);
      return;
    }
    if (paramaunb.jdField_a_of_type_Aunr == null)
    {
      localObject = new aunr();
      ((aunr)localObject).jdField_b_of_type_JavaLangString = (paramaunb.jdField_b_of_type_Int + "_" + paramaunb.jdField_a_of_type_JavaLangString);
      ((aunr)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (aunr)localObject);
      return;
    }
    a(0, paramaunb.jdField_a_of_type_Aunr);
  }
  
  public void a(axdt paramaxdt)
  {
    aung.a(this.g, this.f, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramaxdt))
    {
      b(paramaxdt);
      return;
    }
    aunb localaunb = new aunb();
    localaunb.jdField_a_of_type_Int = -1;
    localaunb.jdField_a_of_type_Aunr = paramaxdt.jdField_a_of_type_Aunr;
    a(localaunb);
  }
  
  public void a(axdv paramaxdv)
  {
    aung.a(this.g, this.f, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramaxdv)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, paramaxdv));
    }
    while (paramaxdv == null) {
      return;
    }
    a(3, paramaxdv.jdField_a_of_type_Aunr);
  }
  
  public void a(axey paramaxey)
  {
    aung.a(this.g, this.f, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramaxey)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, paramaxey));
    }
    while (paramaxey == null) {
      return;
    }
    a(2, paramaxey.jdField_a_of_type_Aunr);
  }
  
  public void a(axfb paramaxfb)
  {
    this.jdField_a_of_type_Axfb = paramaxfb;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    awap localawap = (awap)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localawap.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localawap.a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(ArrayList<axdv> paramArrayList)
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
  
  boolean a(axdt paramaxdt)
  {
    if (paramaxdt != null)
    {
      aung.a(this.g, this.f, "checkShortVideoDownloadInfo", "info:" + paramaxdt);
      return paramaxdt.a();
    }
    aung.b(this.g, this.f, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(axdv paramaxdv)
  {
    if (paramaxdv != null)
    {
      aung.a(this.g, this.f, "checkShortVideoForwardInfo", "info:" + paramaxdv);
      return paramaxdv.a();
    }
    aung.b(this.g, this.f, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(axey paramaxey)
  {
    if (paramaxey != null)
    {
      aung.a(this.g, this.f, "checkShortVideoUploadInfo", "info:" + paramaxey);
      return paramaxey.a();
    }
    aung.b(this.g, this.f, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void b(auor paramauor)
  {
    if (paramauor == null)
    {
      a(2, null);
      return;
    }
    if (paramauor.jdField_a_of_type_Int == 0)
    {
      a(paramauor);
      localObject = new axeu();
      ((axeu)localObject).jdField_a_of_type_Int = 0;
      ((axeu)localObject).jdField_a_of_type_JavaLangObject = paramauor;
      a(2, (axeu)localObject);
      return;
    }
    Object localObject = new aunr();
    ((aunr)localObject).jdField_b_of_type_JavaLangString = paramauor.jdField_a_of_type_JavaLangString;
    a(2, (aunr)localObject);
  }
  
  void b(axdt paramaxdt)
  {
    long l = System.currentTimeMillis();
    paramaxdt.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    aywc localaywc = new aywc();
    localaywc.jdField_b_of_type_JavaLangString = paramaxdt.jdField_b_of_type_JavaLangString;
    localaywc.jdField_c_of_type_JavaLangString = paramaxdt.jdField_c_of_type_JavaLangString;
    localaywc.d = paramaxdt.d;
    localaywc.jdField_a_of_type_Int = paramaxdt.jdField_b_of_type_Int;
    localaywc.jdField_a_of_type_Long = paramaxdt.jdField_a_of_type_Long;
    localaywc.jdField_a_of_type_Boolean = false;
    localaywc.jdField_e_of_type_Int = paramaxdt.jdField_a_of_type_Int;
    localaywc.jdField_g_of_type_Int = paramaxdt.f;
    localaywc.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramaxdt.jdField_g_of_type_Int);
    localaywc.jdField_g_of_type_Boolean = paramaxdt.jdField_a_of_type_Boolean;
    if ((paramaxdt.jdField_e_of_type_Int == 1001) || (paramaxdt.jdField_e_of_type_Int == 1003) || (paramaxdt.jdField_e_of_type_Int == 1005) || (paramaxdt.jdField_e_of_type_Int == 1002) || (paramaxdt.jdField_e_of_type_Int == 1004) || (paramaxdt.jdField_e_of_type_Int == 1006)) {
      localaywc.f = paramaxdt.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Axfb != null) {
      localaywc.jdField_a_of_type_Auna = this;
    }
    switch (paramaxdt.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Axei != null) && (this.jdField_a_of_type_Axei.a != null)) {
        localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Axei.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + paramaxdt.jdField_e_of_type_Int + "downloadvideo MD5==" + paramaxdt.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
      aung.a(this.g, this.f, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      aung.a(this.g, this.f, "doDownloadShortVideo.start", "TransferRequest: " + localaywc.toString());
      return;
      localaywc.jdField_b_of_type_Int = 7;
      localaywc.i = (paramaxdt.i + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_e_of_type_Int);
      continue;
      localaywc.jdField_b_of_type_Int = 16;
      localaywc.i = (paramaxdt.i + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_e_of_type_Int);
      continue;
      localaywc.jdField_b_of_type_Int = 18;
      localaywc.i = (paramaxdt.i + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_e_of_type_Int);
      continue;
      localaywc.jdField_b_of_type_Int = 6;
      localaywc.i = (paramaxdt.h + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_c_of_type_Int);
      continue;
      localaywc.jdField_b_of_type_Int = 9;
      localaywc.i = (paramaxdt.h + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_c_of_type_Int);
      continue;
      localaywc.jdField_b_of_type_Int = 17;
      localaywc.i = (paramaxdt.h + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramaxdt.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */