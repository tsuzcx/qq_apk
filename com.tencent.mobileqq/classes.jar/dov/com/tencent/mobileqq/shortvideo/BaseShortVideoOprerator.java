package dov.com.tencent.mobileqq.shortvideo;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import anuk;
import ayxc;
import ayxd;
import ayxi;
import ayxt;
import ayyt;
import ayyu;
import bdzi;
import bdzn;
import bqfr;
import bqgj;
import bqgl;
import bqgm;
import bqgq;
import bqgr;
import bqgs;
import bqgw;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements ayxc, ayyt, bqgj
{
  static int a;
  protected Handler a;
  public bqgq a;
  protected bqgw a;
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
      this.jdField_a_of_type_AndroidOsHandler = new bqfr(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, bqgq parambqgq)
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
  
  protected void a(int paramInt, ayxt paramayxt)
  {
    bqgr localbqgr = new bqgr();
    localbqgr.jdField_a_of_type_Bqgq = this.jdField_a_of_type_Bqgq;
    localbqgr.jdField_a_of_type_Ayxt = paramayxt;
    localbqgr.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localbqgr);
    if (paramayxt != null)
    {
      ayxi.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramayxt.jdField_a_of_type_JavaLangString, paramayxt.jdField_b_of_type_JavaLangString);
      return;
    }
    ayxi.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, bqgr parambqgr)
  {
    bqgr localbqgr = parambqgr;
    if (parambqgr == null) {
      localbqgr = new bqgr();
    }
    localbqgr.jdField_a_of_type_Int = 0;
    localbqgr.jdField_a_of_type_Bqgq = this.jdField_a_of_type_Bqgq;
    a(paramInt, 0, localbqgr);
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    bqgr localbqgr = new bqgr();
    localbqgr.jdField_a_of_type_Int = 0;
    localbqgr.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localbqgr);
  }
  
  public void a(Message paramMessage)
  {
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Bqgw == null) {}
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
        paramMessage = (bqgr)paramMessage.obj;
        this.jdField_a_of_type_Bqgw.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (bqgr)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Bqgw.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (bqgr)paramMessage.obj;
    this.jdField_a_of_type_Bqgw.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Bqgw.a(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = (bqgr)paramMessage.obj;
      this.jdField_a_of_type_Bqgw.a(paramMessage.jdField_a_of_type_ArrayOfJavaLangString, paramMessage.jdField_a_of_type_JavaLangString);
      return;
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
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Bqgq);
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramayxd.jdField_a_of_type_Int);
    Object localObject = new bqgr();
    ((bqgr)localObject).jdField_a_of_type_Int = paramayxd.jdField_a_of_type_Int;
    ((bqgr)localObject).jdField_a_of_type_JavaLangObject = paramayxd;
    if (paramayxd.jdField_a_of_type_Int == 0)
    {
      a(0, (bqgr)localObject);
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
  
  public void a(bqgl parambqgl)
  {
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambqgl))
    {
      b(parambqgl);
      return;
    }
    ayxd localayxd = new ayxd();
    localayxd.jdField_a_of_type_Int = -1;
    localayxd.jdField_a_of_type_Ayxt = parambqgl.jdField_a_of_type_Ayxt;
    a(localayxd);
  }
  
  public void a(bqgm parambqgm)
  {
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambqgm)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, parambqgm));
    }
    while (parambqgm == null) {
      return;
    }
    a(3, parambqgm.jdField_a_of_type_Ayxt);
  }
  
  public void a(bqgs parambqgs)
  {
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambqgs)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, parambqgs));
    }
    while (parambqgs == null) {
      return;
    }
    a(2, parambqgs.jdField_a_of_type_Ayxt);
  }
  
  public void a(bqgw parambqgw)
  {
    this.jdField_a_of_type_Bqgw = parambqgw;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((anuk)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "addMsg", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public void a(ArrayList<bqgm> paramArrayList)
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
  
  boolean a(bqgl parambqgl)
  {
    if (parambqgl != null)
    {
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info:" + parambqgl);
      return parambqgl.a();
    }
    ayxi.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(bqgm parambqgm)
  {
    if (parambqgm != null)
    {
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info:" + parambqgm);
      return parambqgm.a();
    }
    ayxi.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(bqgs parambqgs)
  {
    if (parambqgs != null)
    {
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info:" + parambqgs);
      return parambqgs.a();
    }
    ayxi.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info == null");
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
      localObject = new bqgr();
      ((bqgr)localObject).jdField_a_of_type_Int = 0;
      ((bqgr)localObject).jdField_a_of_type_JavaLangObject = paramayyu;
      a(2, (bqgr)localObject);
      return;
    }
    Object localObject = new ayxt();
    ((ayxt)localObject).jdField_b_of_type_JavaLangString = paramayyu.jdField_a_of_type_JavaLangString;
    a(2, (ayxt)localObject);
  }
  
  void b(bqgl parambqgl)
  {
    long l = System.currentTimeMillis();
    parambqgl.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    bdzn localbdzn = new bdzn();
    localbdzn.jdField_b_of_type_JavaLangString = parambqgl.jdField_b_of_type_JavaLangString;
    localbdzn.jdField_c_of_type_JavaLangString = parambqgl.jdField_c_of_type_JavaLangString;
    localbdzn.d = parambqgl.d;
    localbdzn.jdField_a_of_type_Int = parambqgl.jdField_b_of_type_Int;
    localbdzn.jdField_a_of_type_Long = parambqgl.jdField_a_of_type_Long;
    localbdzn.jdField_a_of_type_Boolean = false;
    localbdzn.jdField_e_of_type_Int = parambqgl.jdField_a_of_type_Int;
    localbdzn.jdField_g_of_type_Int = parambqgl.f;
    localbdzn.jdField_a_of_type_JavaLangObject = Integer.valueOf(parambqgl.jdField_g_of_type_Int);
    localbdzn.jdField_g_of_type_Boolean = parambqgl.jdField_a_of_type_Boolean;
    if ((parambqgl.jdField_e_of_type_Int == 1001) || (parambqgl.jdField_e_of_type_Int == 1003) || (parambqgl.jdField_e_of_type_Int == 1005) || (parambqgl.jdField_e_of_type_Int == 1002) || (parambqgl.jdField_e_of_type_Int == 1004) || (parambqgl.jdField_e_of_type_Int == 1006)) {
      localbdzn.f = parambqgl.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Bqgw != null) {
      localbdzn.jdField_a_of_type_Ayxc = this;
    }
    switch (parambqgl.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Bqgq != null) && (this.jdField_a_of_type_Bqgq.a != null)) {
        localbdzn.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Bqgq.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambqgl.jdField_e_of_type_Int + "downloadvideo MD5==" + parambqgl.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localbdzn);
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      ayxi.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo.start", "TransferRequest: " + localbdzn.toString());
      return;
      localbdzn.jdField_b_of_type_Int = 7;
      localbdzn.i = (parambqgl.i + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_e_of_type_Int);
      continue;
      localbdzn.jdField_b_of_type_Int = 16;
      localbdzn.i = (parambqgl.i + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_e_of_type_Int);
      continue;
      localbdzn.jdField_b_of_type_Int = 18;
      localbdzn.i = (parambqgl.i + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_e_of_type_Int);
      continue;
      localbdzn.jdField_b_of_type_Int = 6;
      localbdzn.i = (parambqgl.h + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_c_of_type_Int);
      continue;
      localbdzn.jdField_b_of_type_Int = 9;
      localbdzn.i = (parambqgl.h + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_c_of_type_Int);
      continue;
      localbdzn.jdField_b_of_type_Int = 17;
      localbdzn.i = (parambqgl.h + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambqgl.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */