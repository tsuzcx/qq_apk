package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emoticonview.EmoticonUtils;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.capture.CaptureContext;
import java.util.Timer;
import tencent.im.msg.im_msg_body.RichText;

public class FavEmoSingleSend
  extends AsyncStep
  implements UpCallBack
{
  private FavEmoRoamingHandler jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingHandler;
  private CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  private FavroamingDBManager jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager;
  private FavroamingManager jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager;
  private TransferRequest jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer;
  public boolean a;
  private boolean b;
  
  public FavEmoSingleSend(CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
    a();
  }
  
  public int a()
  {
    QLog.d("FavEmoSingleSend", 1, new Object[] { "doStep, isResend: ", Boolean.valueOf(this.b), " ", this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData });
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager.b(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData, this);
    if (this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest == null)
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
  
  public void a()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)CaptureContext.a();
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingManager = ((FavroamingManager)localQQAppInterface.getManager(QQManagerFactory.FAV_ROAMING_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager = ((FavroamingDBManager)localQQAppInterface.getManager(QQManagerFactory.FAVROAMING_DB_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingHandler = ((FavEmoRoamingHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.FAVEMO_ROAMING_HANDLER));
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    if (paramString == "isUpdate") {}
    for (boolean bool = true;; bool = false)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData.RomaingType = paramString;
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.b(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData);
      this.jdField_a_of_type_ComTencentMobileqqEmosmFavroamingFavroamingDBManager.a();
      this.jdField_a_of_type_ComTencentMobileqqAppFavEmoRoamingHandler.notifyUI(2, true, Integer.valueOf(paramInt1));
      FavEmoSendControl.a(this.jdField_a_of_type_Boolean, paramInt2, paramInt3);
      return;
    }
  }
  
  public void b(UpCallBack.SendResult arg1)
  {
    int j = 7;
    if (QLog.isColorLevel()) {
      QLog.d("FavEmoSingleSend", 2, new Object[] { "uploadCameraEmoList, ", ??? });
    }
    if (???.a == 0)
    {
      QLog.e("FavEmoSingleSend", 1, "uploadCameraEmoList success");
      a("isUpdate", 0, 0, 0);
      EmoticonUtils.reportFavAddEmotionEvent(null, 3, ???.d, null);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend
 * JD-Core Version:    0.7.0.1
 */