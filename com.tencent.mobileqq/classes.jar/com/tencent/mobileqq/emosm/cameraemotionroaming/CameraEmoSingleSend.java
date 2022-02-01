package com.tencent.mobileqq.emosm.cameraemotionroaming;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.common.app.business.BaseQQAppInterface;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.ICameraEmoRoamingHandler;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService;
import com.tencent.mobileqq.emosm.api.ICameraEmoRoamingManagerService.ICameraEmoAddCallBack;
import com.tencent.mobileqq.emosm.api.ICameraEmotionRoamingDBManagerService;
import com.tencent.mobileqq.emosm.control.EmoAsyncStep;
import com.tencent.mobileqq.emoticon.EmoticonOperateReport;
import com.tencent.mobileqq.emoticonview.api.IEmosmService;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;
import mqq.app.MobileQQ;

public class CameraEmoSingleSend
  extends EmoAsyncStep
{
  private ICameraEmoRoamingHandler jdField_a_of_type_ComTencentMobileqqAppICameraEmoRoamingHandler;
  private CameraEmotionData jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData;
  private ICameraEmoRoamingManagerService jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmoRoamingManagerService;
  private ICameraEmotionRoamingDBManagerService jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer;
  public boolean a;
  private boolean b;
  private boolean c;
  
  public CameraEmoSingleSend(CameraEmotionData paramCameraEmotionData, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData = paramCameraEmotionData;
    b();
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData;
    if (paramBoolean) {
      ??? = "normal";
    } else {
      ??? = "failed";
    }
    ((CameraEmotionData)localObject2).RomaingType = ((String)???);
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService.updateCustomEmotion(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
    this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService.trimCache();
    this.jdField_a_of_type_ComTencentMobileqqAppICameraEmoRoamingHandler.notifyUI(5, paramBoolean, Integer.valueOf(14));
    localObject2 = new HashMap();
    if (paramBoolean) {
      ??? = "1";
    } else {
      ??? = "0";
    }
    ((HashMap)localObject2).put("sucFlag", ???);
    ((HashMap)localObject2).put("retCode", String.valueOf(paramInt));
    a().collectPerformance(null, "CamEmoUpload", paramBoolean, 0L, 0L, (HashMap)localObject2, null);
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_a_of_type_JavaLangObject.notify();
      return;
    }
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    if (this.c)
    {
      QLog.d("CameraEmoSingleSend", 1, new Object[] { "upload return, timer canceled, emoPath:", this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath });
      return;
    }
    if (paramBoolean)
    {
      String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      CameraEmotionData localCameraEmotionData = this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData;
      localCameraEmotionData.emoPath = paramString;
      localCameraEmotionData.md5 = str;
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService.updateCustomEmotion(localCameraEmotionData);
      paramString = new CameraEmoSingleSend.3(this);
      if (!a())
      {
        QLog.d("CameraEmoSingleSend", 1, "uploadCameraEmo, net not support");
        paramString.a(12, this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmoRoamingManagerService.uploadCameraEmo(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, paramString);
      return;
    }
    a(false, 14);
  }
  
  protected int a()
  {
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new CameraEmoSingleSend.1(this), 90000L);
    boolean bool1;
    if (this.b)
    {
      boolean bool2;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath != null) && (new File(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath).exists())) {
        bool2 = true;
      } else {
        bool2 = false;
      }
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath != null) && (new File(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath).exists())) {
        bool1 = true;
      } else {
        bool1 = false;
      }
      QLog.d("CameraEmoSingleSend", 1, new Object[] { "resend, hasOriginalFile:", Boolean.valueOf(bool2), " hasMergedFile:", Boolean.valueOf(bool1) });
      if ((!bool2) && (!bool1))
      {
        QLog.d("CameraEmoSingleSend", 1, new Object[] { "resend, emoOriginalPath:", this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath, " emoPath:", this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath, " emoId:", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoId) });
        ??? = this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData;
        ((CameraEmotionData)???).RomaingType = "failed";
        this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService.updateCustomEmotion((CameraEmotionData)???);
        this.jdField_a_of_type_ComTencentMobileqqAppICameraEmoRoamingHandler.notifyUI(4, true, null);
        return 7;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService.updateCustomEmotion(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
    }
    else
    {
      bool1 = false;
    }
    if ((this.b) && (bool1))
    {
      a(true, this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath);
    }
    else if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath))
    {
      if (new File(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath).exists())
      {
        a(true, this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath);
      }
      else
      {
        QLog.d("CameraEmoSingleSend", 1, new Object[] { "GIF save AIO fail, emoPath not exist, emoPath:", this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath });
        return 7;
      }
    }
    else
    {
      long l = System.currentTimeMillis();
      ??? = a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath);
      CameraEmoSingleSend.2 local2 = new CameraEmoSingleSend.2(this, ???, l);
      ((IEmosmService)QRoute.api(IEmosmService.class)).startGIFCreator(???, local2);
    }
    if ((!this.c) && (!this.jdField_a_of_type_Boolean)) {}
    try
    {
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.wait(120000L);
      }
    }
    catch (Exception localException)
    {
      label458:
      break label458;
    }
    this.jdField_a_of_type_JavaUtilTimer.cancel();
    return 7;
    throw localObject2;
    QLog.d("CameraEmoSingleSend", 1, new Object[] { "upload no need wait, timer canceled, emoPath:", this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath });
    return 7;
  }
  
  public BaseQQAppInterface a()
  {
    return (BaseQQAppInterface)MobileQQ.sMobileQQ.waitAppRuntime(null);
  }
  
  public StatisticCollector a()
  {
    return StatisticCollector.getInstance(BaseApplication.getContext());
  }
  
  public Object a(String paramString)
  {
    return ((IEmosmService)QRoute.api(IEmosmService.class)).getGIFCreator(paramString);
  }
  
  public void a(String paramString, int paramInt)
  {
    EmoticonOperateReport.reportEmoticonOperateMonitorAddStatus(paramString, paramInt);
  }
  
  public boolean a()
  {
    return NetworkUtil.isNetSupport(BaseApplication.getContext());
  }
  
  public void b()
  {
    BaseQQAppInterface localBaseQQAppInterface = a();
    if (localBaseQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmotionRoamingDBManagerService = ((ICameraEmotionRoamingDBManagerService)localBaseQQAppInterface.getRuntimeService(ICameraEmotionRoamingDBManagerService.class));
      this.jdField_a_of_type_ComTencentMobileqqAppICameraEmoRoamingHandler = ((ICameraEmoRoamingHandler)localBaseQQAppInterface.getBusinessHandler(CameraEmoRoamingHandler.a));
      this.jdField_a_of_type_ComTencentMobileqqEmosmApiICameraEmoRoamingManagerService = ((ICameraEmoRoamingManagerService)localBaseQQAppInterface.getRuntimeService(ICameraEmoRoamingManagerService.class));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend
 * JD-Core Version:    0.7.0.1
 */