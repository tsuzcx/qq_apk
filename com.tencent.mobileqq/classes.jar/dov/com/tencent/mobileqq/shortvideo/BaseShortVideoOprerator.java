package dov.com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import aogu;
import azpp;
import azpq;
import azpw;
import azqh;
import azrg;
import azrh;
import beyb;
import beyg;
import brhc;
import brhu;
import brhw;
import brhx;
import bric;
import brid;
import brie;
import brii;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements azpp, azrg, brhu
{
  static int a;
  protected Handler a;
  public bric a;
  protected brii a;
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
      this.jdField_a_of_type_AndroidOsHandler = new brhc(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bric parambric)
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
  
  protected void a(int paramInt, azqh paramazqh)
  {
    brid localbrid = new brid();
    localbrid.jdField_a_of_type_Bric = this.jdField_a_of_type_Bric;
    localbrid.jdField_a_of_type_Azqh = paramazqh;
    localbrid.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbrid);
    if (paramazqh != null)
    {
      azpw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramazqh.jdField_a_of_type_JavaLangString, paramazqh.jdField_b_of_type_JavaLangString);
      return;
    }
    azpw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, brid parambrid)
  {
    brid localbrid = parambrid;
    if (parambrid == null) {
      localbrid = new brid();
    }
    localbrid.jdField_a_of_type_Int = 0;
    localbrid.jdField_a_of_type_Bric = this.jdField_a_of_type_Bric;
    a(paramInt, 0, localbrid);
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    brid localbrid = new brid();
    localbrid.jdField_a_of_type_Int = 0;
    localbrid.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbrid);
  }
  
  public void a(Message paramMessage)
  {
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Brii == null) {}
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
        paramMessage = (brid)paramMessage.obj;
        this.jdField_a_of_type_Brii.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (brid)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Brii.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (brid)paramMessage.obj;
    this.jdField_a_of_type_Brii.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Brii.a(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = (brid)paramMessage.obj;
      this.jdField_a_of_type_Brii.a(paramMessage.jdField_a_of_type_ArrayOfJavaLangString, paramMessage.jdField_a_of_type_JavaLangString);
      return;
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
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bric);
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramazpq.jdField_a_of_type_Int);
    Object localObject = new brid();
    ((brid)localObject).jdField_a_of_type_Int = paramazpq.jdField_a_of_type_Int;
    ((brid)localObject).jdField_a_of_type_JavaLangObject = paramazpq;
    if (paramazpq.jdField_a_of_type_Int == 0)
    {
      a(0, (brid)localObject);
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
  
  public void a(brhw parambrhw)
  {
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambrhw))
    {
      b(parambrhw);
      return;
    }
    azpq localazpq = new azpq();
    localazpq.jdField_a_of_type_Int = -1;
    localazpq.jdField_a_of_type_Azqh = parambrhw.jdField_a_of_type_Azqh;
    a(localazpq);
  }
  
  public void a(brhx parambrhx)
  {
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambrhx)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambrhx));
    }
    while (parambrhx == null) {
      return;
    }
    a(3, parambrhx.jdField_a_of_type_Azqh);
  }
  
  public void a(brie parambrie)
  {
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambrie)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambrie));
    }
    while (parambrie == null) {
      return;
    }
    a(2, parambrie.jdField_a_of_type_Azqh);
  }
  
  public void a(brii parambrii)
  {
    this.jdField_a_of_type_Brii = parambrii;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((aogu)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "addMsg", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public void a(ArrayList<brhx> paramArrayList)
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
  
  boolean a(brhw parambrhw)
  {
    if (parambrhw != null)
    {
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info:" + parambrhw);
      return parambrhw.a();
    }
    azpw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(brhx parambrhx)
  {
    if (parambrhx != null)
    {
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info:" + parambrhx);
      return parambrhx.a();
    }
    azpw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(brie parambrie)
  {
    if (parambrie != null)
    {
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info:" + parambrie);
      return parambrie.a();
    }
    azpw.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info == null");
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
      localObject = new brid();
      ((brid)localObject).jdField_a_of_type_Int = 0;
      ((brid)localObject).jdField_a_of_type_JavaLangObject = paramazrh;
      a(2, (brid)localObject);
      return;
    }
    Object localObject = new azqh();
    ((azqh)localObject).jdField_b_of_type_JavaLangString = paramazrh.jdField_a_of_type_JavaLangString;
    a(2, (azqh)localObject);
  }
  
  void b(brhw parambrhw)
  {
    long l = System.currentTimeMillis();
    parambrhw.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    beyg localbeyg = new beyg();
    localbeyg.jdField_b_of_type_JavaLangString = parambrhw.jdField_b_of_type_JavaLangString;
    localbeyg.jdField_c_of_type_JavaLangString = parambrhw.jdField_c_of_type_JavaLangString;
    localbeyg.d = parambrhw.d;
    localbeyg.jdField_a_of_type_Int = parambrhw.jdField_b_of_type_Int;
    localbeyg.jdField_a_of_type_Long = parambrhw.jdField_a_of_type_Long;
    localbeyg.jdField_a_of_type_Boolean = false;
    localbeyg.jdField_e_of_type_Int = parambrhw.jdField_a_of_type_Int;
    localbeyg.g = parambrhw.f;
    localbeyg.jdField_a_of_type_JavaLangObject = Integer.valueOf(parambrhw.g);
    localbeyg.h = parambrhw.jdField_a_of_type_Boolean;
    if ((parambrhw.jdField_e_of_type_Int == 1001) || (parambrhw.jdField_e_of_type_Int == 1003) || (parambrhw.jdField_e_of_type_Int == 1005) || (parambrhw.jdField_e_of_type_Int == 1002) || (parambrhw.jdField_e_of_type_Int == 1004) || (parambrhw.jdField_e_of_type_Int == 1006)) {
      localbeyg.f = parambrhw.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Brii != null) {
      localbeyg.jdField_a_of_type_Azpp = this;
    }
    switch (parambrhw.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bric != null) && (this.jdField_a_of_type_Bric.a != null)) {
        localbeyg.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Bric.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambrhw.jdField_e_of_type_Int + "downloadvideo MD5==" + parambrhw.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbeyg);
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      azpw.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo.start", "TransferRequest: " + localbeyg.toString());
      return;
      localbeyg.jdField_b_of_type_Int = 7;
      localbeyg.i = (parambrhw.i + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_e_of_type_Int);
      continue;
      localbeyg.jdField_b_of_type_Int = 16;
      localbeyg.i = (parambrhw.i + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_e_of_type_Int);
      continue;
      localbeyg.jdField_b_of_type_Int = 18;
      localbeyg.i = (parambrhw.i + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_e_of_type_Int);
      continue;
      localbeyg.jdField_b_of_type_Int = 6;
      localbeyg.i = (parambrhw.h + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_c_of_type_Int);
      continue;
      localbeyg.jdField_b_of_type_Int = 9;
      localbeyg.i = (parambrhw.h + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_c_of_type_Int);
      continue;
      localbeyg.jdField_b_of_type_Int = 17;
      localbeyg.i = (parambrhw.h + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambrhw.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */