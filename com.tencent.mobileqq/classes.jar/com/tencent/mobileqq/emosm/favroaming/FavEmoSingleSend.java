package com.tencent.mobileqq.emosm.favroaming;

import ajwa;
import ansq;
import ansr;
import anss;
import auoo;
import auop;
import aywa;
import bizu;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import tencent.im.msg.im_msg_body.RichText;

public class FavEmoSingleSend
  extends AsyncStep
  implements auoo
{
  private ajwa jdField_a_of_type_Ajwa;
  private ansr jdField_a_of_type_Ansr;
  private anss jdField_a_of_type_Anss;
  private aywa jdField_a_of_type_Aywa;
  private CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer;
  public boolean a;
  private boolean b;
  
  public FavEmoSingleSend(CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
    paramCustomEmotionData = (QQAppInterface)bizu.a();
    this.jdField_a_of_type_Anss = ((anss)paramCustomEmotionData.getManager(103));
    this.jdField_a_of_type_Ansr = ((ansr)paramCustomEmotionData.getManager(149));
    this.jdField_a_of_type_Ajwa = ((ajwa)paramCustomEmotionData.a(72));
  }
  
  public int a()
  {
    QLog.d("FavEmoSingleSend", 1, new Object[] { "doStep, isResend: ", Boolean.valueOf(this.b), " ", this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData });
    this.jdField_a_of_type_Aywa = this.jdField_a_of_type_Anss.b(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData, this);
    if (this.jdField_a_of_type_Aywa == null)
    {
      QLog.d("FavEmoSingleSend", 1, "doStep, network not support");
      a("failed", 0, 3, 0);
      return 7;
    }
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new FavEmoSingleSend.1(this), 30000L);
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.wait(40000L);
        label126:
        this.jdField_a_of_type_JavaUtilTimer.cancel();
        return 7;
      }
    }
    catch (Exception localException)
    {
      break label126;
    }
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(auop paramauop) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString == "isUpdate") {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.RomaingType = paramString;
      this.jdField_a_of_type_Ansr.b(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      this.jdField_a_of_type_Ansr.a();
      this.jdField_a_of_type_Ajwa.notifyUI(2, true, Integer.valueOf(paramInt1));
      ansq.a(this.jdField_a_of_type_Boolean, paramInt2, paramInt3);
      return;
    }
  }
  
  public void b(auop arg1)
  {
    int j = 7;
    if (QLog.isColorLevel()) {
      QLog.d("FavEmoSingleSend", 2, new Object[] { "uploadCameraEmoList, ", ??? });
    }
    if (???.a == 0)
    {
      QLog.e("FavEmoSingleSend", 1, "uploadCameraEmoList success");
      a("isUpdate", 0, 0, 0);
    }
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notify();
        return;
        if (-1 != ???.a) {
          continue;
        }
        QLog.e("FavEmoSingleSend", 1, new Object[] { "uploadCameraEmoList fail,  ret:", Integer.valueOf(???.b) });
        int i = 5;
        if (400010 == ???.b)
        {
          i = 6;
          a("failed", j, i, ???.b);
          continue;
        }
        if (400011 == ???.b)
        {
          j = 8;
          i = 7;
        }
      }
      j = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend
 * JD-Core Version:    0.7.0.1
 */