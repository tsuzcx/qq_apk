package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import aumy;
import aumz;
import aune;
import aunp;
import auoo;
import auop;
import awan;
import axcz;
import axdb;
import axdn;
import axdr;
import axdt;
import axeg;
import axes;
import axew;
import axez;
import ayvv;
import aywa;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements aumy, auoo, axdb, axdn
{
  static int d = 3;
  protected Handler a;
  public axeg a;
  protected axez a;
  public QQAppInterface a;
  public MessageRecord a;
  public String f;
  public String g;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new axcz(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, axeg paramaxeg)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(paramQQAppInterface, paramaxeg), 8, null, false);
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
    axes localaxes = new axes();
    localaxes.jdField_a_of_type_Axeg = this.jdField_a_of_type_Axeg;
    localaxes.jdField_a_of_type_Aunp = paramaunp;
    localaxes.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localaxes);
    if (paramaunp != null)
    {
      aune.b(this.g, this.f, paramaunp.jdField_a_of_type_JavaLangString, paramaunp.jdField_b_of_type_JavaLangString);
      return;
    }
    aune.b(this.g, this.f, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, axes paramaxes)
  {
    axes localaxes = paramaxes;
    if (paramaxes == null) {
      localaxes = new axes();
    }
    localaxes.jdField_a_of_type_Int = 0;
    localaxes.jdField_a_of_type_Axeg = this.jdField_a_of_type_Axeg;
    a(paramInt, 0, localaxes);
    aune.a(this.g, this.f, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    axes localaxes = new axes();
    localaxes.jdField_a_of_type_Int = 0;
    localaxes.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localaxes);
  }
  
  public void a(Message paramMessage)
  {
    aune.a(this.g, this.f, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Axez == null) {}
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
        paramMessage = (axes)paramMessage.obj;
        this.jdField_a_of_type_Axez.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (axes)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Axez.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (axes)paramMessage.obj;
    this.jdField_a_of_type_Axez.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Axez.a(i, paramMessage);
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
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Axeg);
    aune.a(this.g, this.f, "onDownload", "result:" + paramaumz.jdField_a_of_type_Int);
    Object localObject = new axes();
    ((axes)localObject).jdField_a_of_type_Int = paramaumz.jdField_a_of_type_Int;
    ((axes)localObject).jdField_a_of_type_JavaLangObject = paramaumz;
    if (paramaumz.jdField_a_of_type_Int == 0)
    {
      a(0, (axes)localObject);
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
  
  public void a(axdr paramaxdr)
  {
    aune.a(this.g, this.f, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramaxdr))
    {
      b(paramaxdr);
      return;
    }
    aumz localaumz = new aumz();
    localaumz.jdField_a_of_type_Int = -1;
    localaumz.jdField_a_of_type_Aunp = paramaxdr.jdField_a_of_type_Aunp;
    a(localaumz);
  }
  
  public void a(axdt paramaxdt)
  {
    aune.a(this.g, this.f, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramaxdt)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, paramaxdt));
    }
    while (paramaxdt == null) {
      return;
    }
    a(3, paramaxdt.jdField_a_of_type_Aunp);
  }
  
  public void a(axew paramaxew)
  {
    aune.a(this.g, this.f, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramaxew)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, paramaxew));
    }
    while (paramaxew == null) {
      return;
    }
    a(2, paramaxew.jdField_a_of_type_Aunp);
  }
  
  public void a(axez paramaxez)
  {
    this.jdField_a_of_type_Axez = paramaxez;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((awan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    awan localawan = (awan)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localawan.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localawan.a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(ArrayList<axdt> paramArrayList)
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
  
  boolean a(axdr paramaxdr)
  {
    if (paramaxdr != null)
    {
      aune.a(this.g, this.f, "checkShortVideoDownloadInfo", "info:" + paramaxdr);
      return paramaxdr.a();
    }
    aune.b(this.g, this.f, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(axdt paramaxdt)
  {
    if (paramaxdt != null)
    {
      aune.a(this.g, this.f, "checkShortVideoForwardInfo", "info:" + paramaxdt);
      return paramaxdt.a();
    }
    aune.b(this.g, this.f, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(axew paramaxew)
  {
    if (paramaxew != null)
    {
      aune.a(this.g, this.f, "checkShortVideoUploadInfo", "info:" + paramaxew);
      return paramaxew.a();
    }
    aune.b(this.g, this.f, "checkShortVideoUploadInfo", "info == null");
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
      localObject = new axes();
      ((axes)localObject).jdField_a_of_type_Int = 0;
      ((axes)localObject).jdField_a_of_type_JavaLangObject = paramauop;
      a(2, (axes)localObject);
      return;
    }
    Object localObject = new aunp();
    ((aunp)localObject).jdField_b_of_type_JavaLangString = paramauop.jdField_a_of_type_JavaLangString;
    a(2, (aunp)localObject);
  }
  
  void b(axdr paramaxdr)
  {
    long l = System.currentTimeMillis();
    paramaxdr.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    aywa localaywa = new aywa();
    localaywa.jdField_b_of_type_JavaLangString = paramaxdr.jdField_b_of_type_JavaLangString;
    localaywa.jdField_c_of_type_JavaLangString = paramaxdr.jdField_c_of_type_JavaLangString;
    localaywa.d = paramaxdr.d;
    localaywa.jdField_a_of_type_Int = paramaxdr.jdField_b_of_type_Int;
    localaywa.jdField_a_of_type_Long = paramaxdr.jdField_a_of_type_Long;
    localaywa.jdField_a_of_type_Boolean = false;
    localaywa.jdField_e_of_type_Int = paramaxdr.jdField_a_of_type_Int;
    localaywa.jdField_g_of_type_Int = paramaxdr.f;
    localaywa.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramaxdr.jdField_g_of_type_Int);
    localaywa.jdField_g_of_type_Boolean = paramaxdr.jdField_a_of_type_Boolean;
    if ((paramaxdr.jdField_e_of_type_Int == 1001) || (paramaxdr.jdField_e_of_type_Int == 1003) || (paramaxdr.jdField_e_of_type_Int == 1005) || (paramaxdr.jdField_e_of_type_Int == 1002) || (paramaxdr.jdField_e_of_type_Int == 1004) || (paramaxdr.jdField_e_of_type_Int == 1006)) {
      localaywa.f = paramaxdr.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Axez != null) {
      localaywa.jdField_a_of_type_Aumy = this;
    }
    switch (paramaxdr.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Axeg != null) && (this.jdField_a_of_type_Axeg.a != null)) {
        localaywa.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Axeg.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + paramaxdr.jdField_e_of_type_Int + "downloadvideo MD5==" + paramaxdr.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywa);
      aune.a(this.g, this.f, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      aune.a(this.g, this.f, "doDownloadShortVideo.start", "TransferRequest: " + localaywa.toString());
      return;
      localaywa.jdField_b_of_type_Int = 7;
      localaywa.i = (paramaxdr.i + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_e_of_type_Int);
      continue;
      localaywa.jdField_b_of_type_Int = 16;
      localaywa.i = (paramaxdr.i + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_e_of_type_Int);
      continue;
      localaywa.jdField_b_of_type_Int = 18;
      localaywa.i = (paramaxdr.i + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_e_of_type_Int);
      continue;
      localaywa.jdField_b_of_type_Int = 6;
      localaywa.i = (paramaxdr.h + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_c_of_type_Int);
      continue;
      localaywa.jdField_b_of_type_Int = 9;
      localaywa.i = (paramaxdr.h + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_c_of_type_Int);
      continue;
      localaywa.jdField_b_of_type_Int = 17;
      localaywa.i = (paramaxdr.h + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramaxdr.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */