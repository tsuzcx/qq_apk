package dov.com.tencent.mobileqq.shortvideo;

import akfv;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import auna;
import aunb;
import aung;
import aunr;
import auoq;
import auor;
import ayvx;
import aywc;
import bkzb;
import bkzx;
import bkzz;
import blaa;
import blae;
import blaf;
import blai;
import blam;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.message.QQMessageFacade;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import mqq.os.MqqHandler;
import tencent.im.msg.im_msg_body.RichText;

public abstract class BaseShortVideoOprerator
  implements auna, auoq, bkzx
{
  static int a;
  protected Handler a;
  public blae a;
  protected blam a;
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
      this.jdField_a_of_type_AndroidOsHandler = new bkzb(this, Looper.getMainLooper());
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, blae paramblae)
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
  
  protected void a(int paramInt, aunr paramaunr)
  {
    blaf localblaf = new blaf();
    localblaf.jdField_a_of_type_Blae = this.jdField_a_of_type_Blae;
    localblaf.jdField_a_of_type_Aunr = paramaunr;
    localblaf.jdField_a_of_type_Int = -1;
    a(paramInt, -1, localblaf);
    if (paramaunr != null)
    {
      aung.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, paramaunr.jdField_a_of_type_JavaLangString, paramaunr.jdField_b_of_type_JavaLangString);
      return;
    }
    aung.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleError", "unkown err,err == null");
  }
  
  protected void a(int paramInt, blaf paramblaf)
  {
    blaf localblaf = paramblaf;
    if (paramblaf == null) {
      localblaf = new blaf();
    }
    localblaf.jdField_a_of_type_Int = 0;
    localblaf.jdField_a_of_type_Blae = this.jdField_a_of_type_Blae;
    a(paramInt, 0, localblaf);
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "handleSuccess", "what:" + paramInt);
  }
  
  public void a(int paramInt, boolean paramBoolean)
  {
    blaf localblaf = new blaf();
    localblaf.jdField_a_of_type_Int = 0;
    localblaf.jdField_a_of_type_JavaLangObject = Integer.valueOf(paramInt);
    a(1, 0, localblaf);
  }
  
  public void a(Message paramMessage)
  {
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "dispatchMessage", "what:" + paramMessage.what + ",result:" + paramMessage.arg1 + ",obj:" + paramMessage.obj);
    if (this.jdField_a_of_type_Blam == null) {}
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
        paramMessage = (blaf)paramMessage.obj;
        this.jdField_a_of_type_Blam.a(i, paramMessage);
        return;
      case 1: 
        paramMessage = (blaf)paramMessage.obj;
      }
    } while (!(paramMessage.jdField_a_of_type_JavaLangObject instanceof Integer));
    this.jdField_a_of_type_Blam.a(((Integer)paramMessage.jdField_a_of_type_JavaLangObject).intValue());
    return;
    paramMessage = (blaf)paramMessage.obj;
    this.jdField_a_of_type_Blam.b(i, paramMessage);
    return;
    if (paramMessage.obj != null) {}
    for (;;)
    {
      try
      {
        paramMessage = (ArrayList)paramMessage.obj;
        this.jdField_a_of_type_Blam.a(i, paramMessage);
        return;
      }
      catch (ClassCastException paramMessage)
      {
        paramMessage = null;
        continue;
      }
      paramMessage = (blaf)paramMessage.obj;
      this.jdField_a_of_type_Blam.a(paramMessage.jdField_a_of_type_ArrayOfJavaLangString, paramMessage.jdField_a_of_type_JavaLangString);
      return;
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
    a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.jdField_a_of_type_Blae);
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "onDownload", "result:" + paramaunb.jdField_a_of_type_Int);
    Object localObject = new blaf();
    ((blaf)localObject).jdField_a_of_type_Int = paramaunb.jdField_a_of_type_Int;
    ((blaf)localObject).jdField_a_of_type_JavaLangObject = paramaunb;
    if (paramaunb.jdField_a_of_type_Int == 0)
    {
      a(0, (blaf)localObject);
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
  
  public void a(bkzz parambkzz)
  {
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "downloadShortVideo", "start " + Thread.currentThread().getId());
    if (a(parambkzz))
    {
      b(parambkzz);
      return;
    }
    aunb localaunb = new aunb();
    localaunb.jdField_a_of_type_Int = -1;
    localaunb.jdField_a_of_type_Aunr = parambkzz.jdField_a_of_type_Aunr;
    a(localaunb);
  }
  
  public void a(blaa paramblaa)
  {
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "forwardShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramblaa)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.ForwardShortVideoTask(this, paramblaa));
    }
    while (paramblaa == null) {
      return;
    }
    a(3, paramblaa.jdField_a_of_type_Aunr);
  }
  
  public void a(blai paramblai)
  {
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "sendShortVideo", "start " + Thread.currentThread().getId());
    if (a(paramblai)) {
      ThreadManager.getSubThreadHandler().post(new BaseShortVideoOprerator.SendShortVideoTask(this, paramblai));
    }
    while (paramblai == null) {
      return;
    }
    a(2, paramblai.jdField_a_of_type_Aunr);
  }
  
  public void a(blam paramblam)
  {
    this.jdField_a_of_type_Blam = paramblam;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if (paramMessageRecord == null) {
      return;
    }
    long l = System.currentTimeMillis();
    ((akfv)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(13)).a(paramMessageRecord);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(paramMessageRecord, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin());
    aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "addMsg", "cost:" + (System.currentTimeMillis() - l));
  }
  
  public void a(ArrayList<blaa> paramArrayList)
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
  
  boolean a(bkzz parambkzz)
  {
    if (parambkzz != null)
    {
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info:" + parambkzz);
      return parambkzz.a();
    }
    aung.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoDownloadInfo", "info == null");
    return false;
  }
  
  boolean a(blaa paramblaa)
  {
    if (paramblaa != null)
    {
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info:" + paramblaa);
      return paramblaa.a();
    }
    aung.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoForwardInfo", "info == null");
    return false;
  }
  
  boolean a(blai paramblai)
  {
    if (paramblai != null)
    {
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info:" + paramblai);
      return paramblai.a();
    }
    aung.b(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "checkShortVideoUploadInfo", "info == null");
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
      localObject = new blaf();
      ((blaf)localObject).jdField_a_of_type_Int = 0;
      ((blaf)localObject).jdField_a_of_type_JavaLangObject = paramauor;
      a(2, (blaf)localObject);
      return;
    }
    Object localObject = new aunr();
    ((aunr)localObject).jdField_b_of_type_JavaLangString = paramauor.jdField_a_of_type_JavaLangString;
    a(2, (aunr)localObject);
  }
  
  void b(bkzz parambkzz)
  {
    long l = System.currentTimeMillis();
    parambkzz.jdField_b_of_type_JavaLangString = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getCurrentAccountUin();
    aywc localaywc = new aywc();
    localaywc.jdField_b_of_type_JavaLangString = parambkzz.jdField_b_of_type_JavaLangString;
    localaywc.jdField_c_of_type_JavaLangString = parambkzz.jdField_c_of_type_JavaLangString;
    localaywc.d = parambkzz.d;
    localaywc.jdField_a_of_type_Int = parambkzz.jdField_b_of_type_Int;
    localaywc.jdField_a_of_type_Long = parambkzz.jdField_a_of_type_Long;
    localaywc.jdField_a_of_type_Boolean = false;
    localaywc.jdField_e_of_type_Int = parambkzz.jdField_a_of_type_Int;
    localaywc.jdField_g_of_type_Int = parambkzz.f;
    localaywc.jdField_a_of_type_JavaLangObject = Integer.valueOf(parambkzz.jdField_g_of_type_Int);
    localaywc.jdField_g_of_type_Boolean = parambkzz.jdField_a_of_type_Boolean;
    if ((parambkzz.jdField_e_of_type_Int == 1001) || (parambkzz.jdField_e_of_type_Int == 1003) || (parambkzz.jdField_e_of_type_Int == 1005) || (parambkzz.jdField_e_of_type_Int == 1002) || (parambkzz.jdField_e_of_type_Int == 1004) || (parambkzz.jdField_e_of_type_Int == 1006)) {
      localaywc.f = parambkzz.jdField_e_of_type_JavaLangString;
    }
    if (this.jdField_a_of_type_Blam != null) {
      localaywc.jdField_a_of_type_Auna = this;
    }
    switch (parambkzz.jdField_e_of_type_Int)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Blae != null) && (this.jdField_a_of_type_Blae.a != null)) {
        localaywc.jdField_a_of_type_ComTencentMobileqqDataMessageRecord = this.jdField_a_of_type_Blae.a;
      }
      if (QLog.isColorLevel()) {
        QLog.d("ShortVideoItemBuilder", 2, " startDownloadVideo downloadvideo fileType==" + parambkzz.jdField_e_of_type_Int + "downloadvideo MD5==" + parambkzz.jdField_e_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a(localaywc);
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo", "cost:" + (System.currentTimeMillis() - l));
      aung.a(this.jdField_b_of_type_JavaLangString, this.jdField_a_of_type_JavaLangString, "doDownloadShortVideo.start", "TransferRequest: " + localaywc.toString());
      return;
      localaywc.jdField_b_of_type_Int = 7;
      localaywc.i = (parambkzz.i + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_e_of_type_Int);
      continue;
      localaywc.jdField_b_of_type_Int = 16;
      localaywc.i = (parambkzz.i + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_e_of_type_Int);
      continue;
      localaywc.jdField_b_of_type_Int = 18;
      localaywc.i = (parambkzz.i + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_e_of_type_Int);
      continue;
      localaywc.jdField_b_of_type_Int = 6;
      localaywc.i = (parambkzz.h + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_c_of_type_Int);
      continue;
      localaywc.jdField_b_of_type_Int = 9;
      localaywc.i = (parambkzz.h + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_c_of_type_Int);
      continue;
      localaywc.jdField_b_of_type_Int = 17;
      localaywc.i = (parambkzz.h + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_a_of_type_JavaLangString + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_e_of_type_Int + "QQ_&_MoblieQQ_&_QQ" + parambkzz.jdField_c_of_type_Int);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.mobileqq.shortvideo.BaseShortVideoOprerator
 * JD-Core Version:    0.7.0.1
 */