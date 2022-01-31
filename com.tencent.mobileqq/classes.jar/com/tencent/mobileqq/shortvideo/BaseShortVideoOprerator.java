package com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import aweh;
import awei;
import awen;
import awey;
import awfy;
import awfz;
import axso;
import ayyf;
import ayyh;
import ayyt;
import ayyx;
import ayyz;
import ayzo;
import azaa;
import azae;
import azah;
import batw;
import baub;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements aweh, awfy, ayyh, ayyt
{
  static int d = 3;
  protected Handler a;
  public ayzo a;
  protected azah a;
  public QQAppInterface a;
  public MessageRecord a;
  public String f;
  public String g;
  
  public BaseShortVideoOprerator() {}
  
  public BaseShortVideoOprerator(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (this.jdField_a_of_type_AndroidOsHandler == null) {
      this.jdField_a_of_type_AndroidOsHandler = new ayyf(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, ayzo paramayzo)
  {
    ThreadManager.post(new BaseShortVideoOprerator.2(paramQQAppInterface, paramayzo), 8, null, false);
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
    azaa localazaa = new azaa();
    localazaa.jdField_a_of_type_Ayzo = this.jdField_a_of_type_Ayzo;
    localazaa.jdField_a_of_type_Awey = paramawey;
    localazaa.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localazaa);
    if (paramawey != null)
    {
      awen.b(this.g, this.f, paramawey.jdField_a_of_type_JavaLangString, paramawey.jdField_b_of_type_JavaLangString);
      return;
    }
    awen.b(this.g, this.f, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, azaa paramazaa)
  {
    azaa localazaa = paramazaa;
    if (paramazaa == null) {
      localazaa = new azaa();
    }
    localazaa.jdField_a_of_type_Int = 0;
    localazaa.jdField_a_of_type_Ayzo = this.jdField_a_of_type_Ayzo;
    a(paramInt, 0, localazaa);
    awen.a(this.g, this.f, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    azaa localazaa = new azaa();
    localazaa.jdField_a_of_type_Int = 0;
    localazaa.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localazaa);
  }
  
  public void a(Message paramMessage)
  {
    awen.a(this.g, this.f, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Azah == null) {}
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
        paramMessage = (azaa)paramMessage.obj;
        this.jdField_a_of_type_Azah.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (azaa)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Azah.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (azaa)paramMessage.obj;
    this.jdField_a_of_type_Azah.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Azah.a(i, paramMessage);
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
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Ayzo);
    awen.a(this.g, this.f, "onDownload", "result:" + paramawei.jdField_a_of_type_Int);
    Object localObject = new azaa();
    ((azaa)localObject).jdField_a_of_type_Int = paramawei.jdField_a_of_type_Int;
    ((azaa)localObject).jdField_a_of_type_JavaLangObject = paramawei;
    if (paramawei.jdField_a_of_type_Int == 0)
    {
      a(0, (azaa)localObject);
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
  
  public void a(ayyx paramayyx)
  {
    awen.a(this.g, this.f, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramayyx))
    {
      b(paramayyx);
      return;
    }
    awei localawei = new awei();
    localawei.jdField_a_of_type_Int = -1;
    localawei.jdField_a_of_type_Awey = paramayyx.jdField_a_of_type_Awey;
    a(localawei);
  }
  
  public void a(ayyz paramayyz)
  {
    awen.a(this.g, this.f, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramayyz)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, paramayyz));
    }
    while (paramayyz == null) {
      return;
    }
    a(3, paramayyz.jdField_a_of_type_Awey);
  }
  
  public void a(azae paramazae)
  {
    awen.a(this.g, this.f, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramazae)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, paramazae));
    }
    while (paramazae == null) {
      return;
    }
    a(2, paramazae.jdField_a_of_type_Awey);
  }
  
  public void a(azah paramazah)
  {
    this.jdField_a_of_type_Azah = paramazah;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    ((axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326)).a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(MessageRecord paramMessageRecord, long paramLong)
  {
    if (paramMessageRecord == null) {
      return;
    }
    axso localaxso = (axso)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(326);
    localaxso.a(paramMessageRecord.frienduin, paramLong, paramMessageRecord.uniseq);
    localaxso.a(paramMessageRecord, ((MessageForShortVideo)paramMessageRecord).videoFileName);
  }
  
  public void a(ArrayList<ayyz> paramArrayList)
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
  
  boolean a(ayyx paramayyx)
  {
    if (paramayyx != null)
    {
      awen.a(this.g, this.f, "checkShortVideoDownloadInfo", "info:" + paramayyx);
      return paramayyx.a();
    }
    awen.b(this.g, this.f, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(ayyz paramayyz)
  {
    if (paramayyz != null)
    {
      awen.a(this.g, this.f, "checkShortVideoForwardInfo", "info:" + paramayyz);
      return paramayyz.a();
    }
    awen.b(this.g, this.f, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(azae paramazae)
  {
    if (paramazae != null)
    {
      awen.a(this.g, this.f, "checkShortVideoUploadInfo", "info:" + paramazae);
      return paramazae.a();
    }
    awen.b(this.g, this.f, "checkShortVideoUploadInfo", "info == null");
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
      localObject = new azaa();
      ((azaa)localObject).jdField_a_of_type_Int = 0;
      ((azaa)localObject).jdField_a_of_type_JavaLangObject = paramawfz;
      a(2, (azaa)localObject);
      return;
    }
    Object localObject = new awey();
    ((awey)localObject).jdField_b_of_type_JavaLangString = paramawfz.jdField_a_of_type_JavaLangString;
    a(2, (awey)localObject);
  }
  
  void b(ayyx paramayyx)
  {
    long l = System.currentTimeMillis();
    paramayyx.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    baub localbaub = new baub();
    localbaub.jdField_b_of_type_JavaLangString = paramayyx.jdField_b_of_type_JavaLangString;
    localbaub.jdField_c_of_type_JavaLangString = paramayyx.jdField_c_of_type_JavaLangString;
    localbaub.d = paramayyx.d;
    localbaub.jdField_a_of_type_Int = paramayyx.jdField_b_of_type_Int;
    localbaub.jdField_a_of_type_Long = paramayyx.jdField_a_of_type_Long;
    localbaub.jdField_a_of_type_Boolean = false;
    localbaub.jdField_e_of_type_Int = paramayyx.jdField_a_of_type_Int;
    localbaub.jdField_g_of_type_Int = paramayyx.f;
    localbaub.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramayyx.jdField_g_of_type_Int);
    localbaub.jdField_g_of_type_Boolean = paramayyx.jdField_a_of_type_Boolean;
    if ((paramayyx.jdField_e_of_type_Int == 1001) || (paramayyx.jdField_e_of_type_Int == 1003) || (paramayyx.jdField_e_of_type_Int == 1005) || (paramayyx.jdField_e_of_type_Int == 1002) || (paramayyx.jdField_e_of_type_Int == 1004) || (paramayyx.jdField_e_of_type_Int == 1006)) {
      localbaub.f = paramayyx.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Azah != null) {
      localbaub.jdField_a_of_type_Aweh = this;
    }
    switch (paramayyx.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Ayzo != null) && (this.jdField_a_of_type_Ayzo.a != null)) {
        localbaub.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Ayzo.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + paramayyx.jdField_e_of_type_Int + "downloadvideo MD5==" + paramayyx.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbaub);
      awen.a(this.g, this.f, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      awen.a(this.g, this.f, "doDownloadShortVideo.start", "TransferRequest: " + localbaub.toString());
      return;
      localbaub.jdField_b_of_type_Int = 7;
      localbaub.i = (paramayyx.i + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_e_of_type_Int);
      continue;
      localbaub.jdField_b_of_type_Int = 16;
      localbaub.i = (paramayyx.i + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_e_of_type_Int);
      continue;
      localbaub.jdField_b_of_type_Int = 18;
      localbaub.i = (paramayyx.i + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_e_of_type_Int);
      continue;
      localbaub.jdField_b_of_type_Int = 6;
      localbaub.i = (paramayyx.h + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_c_of_type_Int);
      continue;
      localbaub.jdField_b_of_type_Int = 9;
      localbaub.i = (paramayyx.h + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_c_of_type_Int);
      continue;
      localbaub.jdField_b_of_type_Int = 17;
      localbaub.i = (paramayyx.h + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + paramayyx.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */