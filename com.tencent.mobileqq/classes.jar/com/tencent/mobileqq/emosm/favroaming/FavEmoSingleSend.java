package com.tencent.mobileqq.emosm.favroaming;

import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.FavEmoRoamingHandler;
import com.tencent.mobileqq.data.CustomEmotionData;
import com.tencent.mobileqq.data.MessageRecord;
import com.tencent.mobileqq.emosm.IFavEmoRoamingHandler;
import com.tencent.mobileqq.emosm.api.IFavroamingDBManagerService;
import com.tencent.mobileqq.emosm.api.IFavroamingManagerService;
import com.tencent.mobileqq.emosm.control.EmoAsyncStep;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.pic.UpCallBack;
import com.tencent.mobileqq.pic.UpCallBack.SendResult;
import com.tencent.mobileqq.transfile.TransferRequest;
import com.tencent.qphone.base.util.QLog;
import java.util.Timer;
import mqq.app.MobileQQ;
import tencent.im.msg.im_msg_body.RichText;

public class FavEmoSingleSend
  extends EmoAsyncStep
  implements UpCallBack
{
  private CustomEmotionData jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
  private IFavEmoRoamingHandler jdField_a_of_type_ComTencentMobileqqEmosmIFavEmoRoamingHandler;
  private IFavroamingDBManagerService jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService;
  private IFavroamingManagerService jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingManagerService;
  private TransferRequest jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer;
  public boolean a;
  private boolean b;
  
  public FavEmoSingleSend(CustomEmotionData paramCustomEmotionData, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData = paramCustomEmotionData;
    b();
  }
  
  protected int a()
  {
    QLog.d("FavEmoSingleSend", 1, new Object[] { "doStep, isResend: ", Boolean.valueOf(this.b), " ", this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData });
    this.jdField_a_of_type_ComTencentMobileqqTransfileTransferRequest = this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingManagerService.syncUpload(this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData, this);
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
      }
    }
    catch (Exception localException)
    {
      label135:
      break label135;
    }
    this.jdField_a_of_type_JavaUtilTimer.cancel();
    return 7;
    throw localObject2;
  }
  
  public MessageRecord a(im_msg_body.RichText paramRichText)
  {
    return null;
  }
  
  public void a(UpCallBack.SendResult paramSendResult) {}
  
  public void a(String paramString, int paramInt1, int paramInt2, int paramInt3)
  {
    boolean bool;
    if (paramString == "isUpdate") {
      bool = true;
    } else {
      bool = false;
    }
    this.jdField_a_of_type_Boolean = bool;
    CustomEmotionData localCustomEmotionData = this.jdField_a_of_type_ComTencentMobileqqDataCustomEmotionData;
    localCustomEmotionData.RomaingType = paramString;
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService.updateCustomEmotion(localCustomEmotionData);
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService.trimCache();
    this.jdField_a_of_type_ComTencentMobileqqEmosmIFavEmoRoamingHandler.notifyUI(2, true, Integer.valueOf(paramInt1));
    FavEmoSendControlConstant.a(this.jdField_a_of_type_Boolean, paramInt2, paramInt3);
  }
  
  public void b()
  {
    BaseQQAppInterface localBaseQQAppInterface = (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingManagerService = ((IFavroamingManagerService)localBaseQQAppInterface.getRuntimeService(IFavroamingManagerService.class));
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiIFavroamingDBManagerService = ((IFavroamingDBManagerService)localBaseQQAppInterface.getRuntimeService(IFavroamingDBManagerService.class));
    this.jdField_a_of_type_ComTencentMobileqqEmosmIFavEmoRoamingHandler = ((IFavEmoRoamingHandler)localBaseQQAppInterface.getBusinessHandler(FavEmoRoamingHandler.a));
  }
  
  public void b(UpCallBack.SendResult arg1)
  {
    boolean bool = QLog.isColorLevel();
    int j = 0;
    if (bool) {
      QLog.d("FavEmoSingleSend", 2, new Object[] { "uploadCameraEmoList, ", ??? });
    }
    if (???.a == 0)
    {
      QLog.e("FavEmoSingleSend", 1, "uploadCameraEmoList success");
      a("isUpdate", 0, 0, 0);
      EmoticonOperateReport.reportFavAddEmotionEvent(null, 3, ???.d, null);
    }
    else if (-1 == ???.a)
    {
      QLog.e("FavEmoSingleSend", 1, new Object[] { "uploadCameraEmoList fail,  ret:", Integer.valueOf(???.b) });
      int i = 5;
      if (400010 == ???.b)
      {
        i = 6;
        j = 7;
      }
      else if (400011 == ???.b)
      {
        j = 8;
        i = 7;
      }
      a("failed", j, i, ???.b);
    }
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.favroaming.FavEmoSingleSend
 * JD-Core Version:    0.7.0.1
 */