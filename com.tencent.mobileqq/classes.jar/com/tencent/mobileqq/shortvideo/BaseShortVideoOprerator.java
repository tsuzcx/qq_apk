package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import azpp;
import azpq;
import azpw;
import azqh;
import azrg;
import azrh;
import bbnr;
import bcwf;
import bcwh;
import bcwt;
import bcwx;
import bcwz;
import bcxn;
import bcyb;
import bcyf;
import bcyi;
import beyb;
import beyg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements azpp, azrg, bcwh, bcwt
{
  static int d = 3;
  protected Handler a;
  public bcxn a;
  protected bcyi a;
  public QQAppInterface a;
  public MessageRecord a;
  public String f;
  public String g;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new bcwf(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bcxn parambcxn)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(paramQQAppInterface, parambcxn), 8, null, false);
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
  
  protected void a(int paramInt, azqh paramazqh)
  {
    bcyb localbcyb = new bcyb();
    localbcyb.jdField_a_of_type_Bcxn = this.jdField_a_of_type_Bcxn;
    localbcyb.jdField_a_of_type_Azqh = paramazqh;
    localbcyb.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbcyb);
    if (paramazqh != null)
    {
      azpw.b(this.g, this.f, paramazqh.jdField_a_of_type_JavaLangString, paramazqh.jdField_b_of_type_JavaLangString);
      return;
    }
    azpw.b(this.g, this.f, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, bcyb parambcyb)
  {
    bcyb localbcyb = parambcyb;
    if (parambcyb == null) {
      localbcyb = new bcyb();
    }
    localbcyb.jdField_a_of_type_Int = 0;
    localbcyb.jdField_a_of_type_Bcxn = this.jdField_a_of_type_Bcxn;
    a(paramInt, 0, localbcyb);
    azpw.a(this.g, this.f, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bcyb localbcyb = new bcyb();
    localbcyb.jdField_a_of_type_Int = 0;
    localbcyb.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbcyb);
  }
  
  public void a(Message paramMessage)
  {
    azpw.a(this.g, this.f, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Bcyi == null) {}
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
        paramMessage = (bcyb)paramMessage.obj;
        this.jdField_a_of_type_Bcyi.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (bcyb)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Bcyi.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (bcyb)paramMessage.obj;
    this.jdField_a_of_type_Bcyi.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Bcyi.a(i, paramMessage);
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
  
  public void a(azpq paramazpq)
  {
    if (paramazpq == null)
    {
      paramazpq = new azqh();
      paramazpq.jdField_b_of_type_JavaLangString = "result == null";
      paramazpq.jdField_a_of_type_JavaLangString = "onDownload";
      a(0, paramazpq);
      return;
    }
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bcxn);
    azpw.a(this.g, this.f, "onDownload", "result:" + paramazpq.jdField_a_of_type_Int);
    Object localObject = new bcyb();
    ((bcyb)localObject).jdField_a_of_type_Int = paramazpq.jdField_a_of_type_Int;
    ((bcyb)localObject).jdField_a_of_type_JavaLangObject = paramazpq;
    if (paramazpq.jdField_a_of_type_Int == 0)
    {
      a(0, (bcyb)localObject);
      return;
    }
    if (paramazpq.jdField_a_of_type_Azqh == null)
    {
      localObject = new azqh();
      ((azqh)localObject).jdField_b_of_type_JavaLangString = (paramazpq.jdField_b_of_type_Int + "_" + paramazpq.jdField_a_of_type_JavaLangString);
      ((azqh)localObject).jdField_a_of_type_JavaLangString = "onDownload";
      a(0, (azqh)localObject);
      return;
    }
    a(0, paramazpq.jdField_a_of_type_Azqh);
  }
  
  public void a(bcwx parambcwx)
  {
    azpw.a(this.g, this.f, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambcwx))
    {
      b(parambcwx);
      return;
    }
    azpq localazpq = new azpq();
    localazpq.jdField_a_of_type_Int = -1;
    localazpq.jdField_a_of_type_Azqh = parambcwx.jdField_a_of_type_Azqh;
    a(localazpq);
  }
  
  public void a(bcwz parambcwz)
  {
    azpw.a(this.g, this.f, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambcwz)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambcwz));
    }
    while (parambcwz == null) {
      return;
    }
    a(3, parambcwz.jdField_a_of_type_Azqh);
  }
  
  public void a(bcyf parambcyf)
  {
    azpw.a(this.g, this.f, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambcyf)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambcyf));
    }
    while (parambcyf == null) {
      return;
    }
    a(2, parambcyf.jdField_a_of_type_Azqh);
  }
  
  public void a(bcyi parambcyi)
  {
    this.jdField_a_of_type_Bcyi = parambcyi;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    bbnr localbbnr = (bbnr)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localbbnr.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localbbnr.a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(ArrayList<bcwz> paramArrayList)
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
  
  boolean a(bcwx parambcwx)
  {
    if (parambcwx != null)
    {
      azpw.a(this.g, this.f, "checkShortVideoDownloadInfo", "info:" + parambcwx);
      return parambcwx.a();
    }
    azpw.b(this.g, this.f, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(bcwz parambcwz)
  {
    if (parambcwz != null)
    {
      azpw.a(this.g, this.f, "checkShortVideoForwardInfo", "info:" + parambcwz);
      return parambcwz.a();
    }
    azpw.b(this.g, this.f, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(bcyf parambcyf)
  {
    if (parambcyf != null)
    {
      azpw.a(this.g, this.f, "checkShortVideoUploadInfo", "info:" + parambcyf);
      return parambcyf.a();
    }
    azpw.b(this.g, this.f, "checkShortVideoUploadInfo", "info == null");
    return false;
  }
  
  public void b(azrh paramazrh)
  {
    if (paramazrh == null)
    {
      a(2, null);
      return;
    }
    if (paramazrh.jdField_a_of_type_Int == 0)
    {
      a(paramazrh);
      localObject = new bcyb();
      ((bcyb)localObject).jdField_a_of_type_Int = 0;
      ((bcyb)localObject).jdField_a_of_type_JavaLangObject = paramazrh;
      a(2, (bcyb)localObject);
      return;
    }
    Object localObject = new azqh();
    ((azqh)localObject).jdField_b_of_type_JavaLangString = paramazrh.jdField_a_of_type_JavaLangString;
    a(2, (azqh)localObject);
  }
  
  void b(bcwx parambcwx)
  {
    long l = System.currentTimeMillis();
    parambcwx.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    beyg localbeyg = new beyg();
    localbeyg.jdField_b_of_type_JavaLangString = parambcwx.jdField_b_of_type_JavaLangString;
    localbeyg.jdField_c_of_type_JavaLangString = parambcwx.jdField_c_of_type_JavaLangString;
    localbeyg.d = parambcwx.d;
    localbeyg.jdField_a_of_type_Int = parambcwx.jdField_b_of_type_Int;
    localbeyg.jdField_a_of_type_Long = parambcwx.jdField_a_of_type_Long;
    localbeyg.jdField_a_of_type_Boolean = false;
    localbeyg.jdField_e_of_type_Int = parambcwx.jdField_a_of_type_Int;
    localbeyg.g = parambcwx.f;
    localbeyg.jdField_a_of_type_JavaLangObject = Integer.valueOf(parambcwx.g);
    localbeyg.h = parambcwx.jdField_a_of_type_Boolean;
    if ((parambcwx.jdField_e_of_type_Int == 1001) || (parambcwx.jdField_e_of_type_Int == 1003) || (parambcwx.jdField_e_of_type_Int == 1005) || (parambcwx.jdField_e_of_type_Int == 1002) || (parambcwx.jdField_e_of_type_Int == 1004) || (parambcwx.jdField_e_of_type_Int == 1006)) {
      localbeyg.f = parambcwx.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bcyi != null) {
      localbeyg.jdField_a_of_type_Azpp = this;
    }
    switch (parambcwx.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bcxn != null) && (this.jdField_a_of_type_Bcxn.a != null)) {
        localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Bcxn.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambcwx.jdField_e_of_type_Int + "downloadvideo MD5==" + parambcwx.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbeyg);
      azpw.a(this.g, this.f, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      azpw.a(this.g, this.f, "doDownloadShortVideo.start", "TransferRequest: " + localbeyg.toString());
      return;
      localbeyg.jdField_b_of_type_Int = 7;
      localbeyg.i = (parambcwx.i + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_e_of_type_Int);
      continue;
      localbeyg.jdField_b_of_type_Int = 16;
      localbeyg.i = (parambcwx.i + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_e_of_type_Int);
      continue;
      localbeyg.jdField_b_of_type_Int = 18;
      localbeyg.i = (parambcwx.i + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_e_of_type_Int);
      continue;
      localbeyg.jdField_b_of_type_Int = 6;
      localbeyg.i = (parambcwx.h + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_c_of_type_Int);
      continue;
      localbeyg.jdField_b_of_type_Int = 9;
      localbeyg.i = (parambcwx.h + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_c_of_type_Int);
      continue;
      localbeyg.jdField_b_of_type_Int = 17;
      localbeyg.i = (parambcwx.h + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambcwx.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */