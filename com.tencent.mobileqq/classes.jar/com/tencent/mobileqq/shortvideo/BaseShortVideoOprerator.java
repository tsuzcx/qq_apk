package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import ayxc;
import ayxd;
import ayxi;
import ayxt;
import ayyt;
import ayyu;
import bauy;
import bcdn;
import bcdp;
import bceb;
import bcef;
import bceh;
import bcev;
import bcfj;
import bcfn;
import bcfq;
import bdzi;
import bdzn;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements ayxc, ayyt, bcdp, bceb
{
  static int d = 3;
  protected Handler a;
  public bcev a;
  protected bcfq a;
  public QQAppInterface a;
  public MessageRecord a;
  public String f;
  public String g;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new bcdn(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bcev parambcev)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(paramQQAppInterface, parambcev), 8, null, false);
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
  
  protected void a(int paramInt, ayxt paramayxt)
  {
    bcfj localbcfj = new bcfj();
    localbcfj.jdField_a_of_type_Bcev = this.jdField_a_of_type_Bcev;
    localbcfj.jdField_a_of_type_Ayxt = paramayxt;
    localbcfj.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbcfj);
    if (paramayxt != null)
    {
      ayxi.b(this.g, this.f, paramayxt.jdField_a_of_type_JavaLangString, paramayxt.jdField_b_of_type_JavaLangString);
      return;
    }
    ayxi.b(this.g, this.f, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, bcfj parambcfj)
  {
    bcfj localbcfj = parambcfj;
    if (parambcfj == null) {
      localbcfj = new bcfj();
    }
    localbcfj.jdField_a_of_type_Int = 0;
    localbcfj.jdField_a_of_type_Bcev = this.jdField_a_of_type_Bcev;
    a(paramInt, 0, localbcfj);
    ayxi.a(this.g, this.f, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bcfj localbcfj = new bcfj();
    localbcfj.jdField_a_of_type_Int = 0;
    localbcfj.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbcfj);
  }
  
  public void a(Message paramMessage)
  {
    ayxi.a(this.g, this.f, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Bcfq == null) {}
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
        paramMessage = (bcfj)paramMessage.obj;
        this.jdField_a_of_type_Bcfq.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (bcfj)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Bcfq.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (bcfj)paramMessage.obj;
    this.jdField_a_of_type_Bcfq.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Bcfq.a(i, paramMessage);
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
  
  public void a(ayxd paramayxd)
  {
    if (paramayxd == null)
    {
      paramayxd = new ayxt();
      paramayxd.jdField_b_of_type_JavaLangString = "result == null";
      paramayxd.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramayxd);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcev);
    ayxi.a(this.g, this.f, "onDownload", "result:" + paramayxd.jdField_a_of_type_Int);
    Object localObject = new bcfj();
    ((bcfj)localObject).jdField_a_of_type_Int = paramayxd.jdField_a_of_type_Int;
    ((bcfj)localObject).jdField_a_of_type_JavaLangObject = paramayxd;
    if (paramayxd.jdField_a_of_type_Int == 0)
    {
      a(0, (bcfj)localObject);
      return;
    }
    if (paramayxd.jdField_a_of_type_Ayxt == null)
    {
      localObject = new ayxt();
      ((ayxt)localObject).jdField_b_of_type_JavaLangString = (paramayxd.jdField_b_of_type_Int + "_" + paramayxd.jdField_a_of_type_JavaLangString);
      ((ayxt)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (ayxt)localObject);
      return;
    }
    a(0, paramayxd.jdField_a_of_type_Ayxt);
  }
  
  public void a(bcef parambcef)
  {
    ayxi.a(this.g, this.f, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambcef))
    {
      b(parambcef);
      return;
    }
    ayxd localayxd = new ayxd();
    localayxd.jdField_a_of_type_Int = -1;
    localayxd.jdField_a_of_type_Ayxt = parambcef.jdField_a_of_type_Ayxt;
    a(localayxd);
  }
  
  public void a(bceh parambceh)
  {
    ayxi.a(this.g, this.f, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambceh)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambceh));
    }
    while (parambceh == null) {
      return;
    }
    a(3, parambceh.jdField_a_of_type_Ayxt);
  }
  
  public void a(bcfn parambcfn)
  {
    ayxi.a(this.g, this.f, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambcfn)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambcfn));
    }
    while (parambcfn == null) {
      return;
    }
    a(2, parambcfn.jdField_a_of_type_Ayxt);
  }
  
  public void a(bcfq parambcfq)
  {
    this.jdField_a_of_type_Bcfq = parambcfq;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((bauy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    bauy localbauy = (bauy)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localbauy.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localbauy.a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(ArrayList<bceh> paramArrayList)
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
  
  boolean a(bcef parambcef)
  {
    if (parambcef != null)
    {
      ayxi.a(this.g, this.f, "checkShortVideoDownloadInfo", "info:" + parambcef);
      return parambcef.a();
    }
    ayxi.b(this.g, this.f, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(bceh parambceh)
  {
    if (parambceh != null)
    {
      ayxi.a(this.g, this.f, "checkShortVideoForwardInfo", "info:" + parambceh);
      return parambceh.a();
    }
    ayxi.b(this.g, this.f, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(bcfn parambcfn)
  {
    if (parambcfn != null)
    {
      ayxi.a(this.g, this.f, "checkShortVideoUploadInfo", "info:" + parambcfn);
      return parambcfn.a();
    }
    ayxi.b(this.g, this.f, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void b(ayyu paramayyu)
  {
    if (paramayyu == null)
    {
      a(2, null);
      return;
    }
    if (paramayyu.jdField_a_of_type_Int == 0)
    {
      a(paramayyu);
      localObject = new bcfj();
      ((bcfj)localObject).jdField_a_of_type_Int = 0;
      ((bcfj)localObject).jdField_a_of_type_JavaLangObject = paramayyu;
      a(2, (bcfj)localObject);
      return;
    }
    Object localObject = new ayxt();
    ((ayxt)localObject).jdField_b_of_type_JavaLangString = paramayyu.jdField_a_of_type_JavaLangString;
    a(2, (ayxt)localObject);
  }
  
  void b(bcef parambcef)
  {
    long l = System.currentTimeMillis();
    parambcef.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_b_of_type_JavaLangString = parambcef.jdField_b_of_type_JavaLangString;
    localbdzn.jdField_c_of_type_JavaLangString = parambcef.jdField_c_of_type_JavaLangString;
    localbdzn.d = parambcef.d;
    localbdzn.jdField_a_of_type_Int = parambcef.jdField_b_of_type_Int;
    localbdzn.jdField_a_of_type_Long = parambcef.jdField_a_of_type_Long;
    localbdzn.jdField_a_of_type_Boolean = false;
    localbdzn.jdField_e_of_type_Int = parambcef.jdField_a_of_type_Int;
    localbdzn.jdField_g_of_type_Int = parambcef.f;
    localbdzn.jdField_a_of_type_JavaLangObject = Integer.valueOf(parambcef.jdField_g_of_type_Int);
    localbdzn.jdField_g_of_type_Boolean = parambcef.jdField_a_of_type_Boolean;
    if ((parambcef.jdField_e_of_type_Int == 1001) || (parambcef.jdField_e_of_type_Int == 1003) || (parambcef.jdField_e_of_type_Int == 1005) || (parambcef.jdField_e_of_type_Int == 1002) || (parambcef.jdField_e_of_type_Int == 1004) || (parambcef.jdField_e_of_type_Int == 1006)) {
      localbdzn.f = parambcef.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bcfq != null) {
      localbdzn.jdField_a_of_type_Ayxc = this;
    }
    switch (parambcef.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bcev != null) && (this.jdField_a_of_type_Bcev.a != null)) {
        localbdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Bcev.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambcef.jdField_e_of_type_Int + "downloadvideo MD5==" + parambcef.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbdzn);
      ayxi.a(this.g, this.f, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      ayxi.a(this.g, this.f, "doDownloadShortVideo.start", "TransferRequest: " + localbdzn.toString());
      return;
      localbdzn.jdField_b_of_type_Int = 7;
      localbdzn.i = (parambcef.i + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_e_of_type_Int);
      continue;
      localbdzn.jdField_b_of_type_Int = 16;
      localbdzn.i = (parambcef.i + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_e_of_type_Int);
      continue;
      localbdzn.jdField_b_of_type_Int = 18;
      localbdzn.i = (parambcef.i + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_e_of_type_Int);
      continue;
      localbdzn.jdField_b_of_type_Int = 6;
      localbdzn.i = (parambcef.h + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_c_of_type_Int);
      continue;
      localbdzn.jdField_b_of_type_Int = 9;
      localbdzn.i = (parambcef.h + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_c_of_type_Int);
      continue;
      localbdzn.jdField_b_of_type_Int = 17;
      localbdzn.i = (parambcef.h + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambcef.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */