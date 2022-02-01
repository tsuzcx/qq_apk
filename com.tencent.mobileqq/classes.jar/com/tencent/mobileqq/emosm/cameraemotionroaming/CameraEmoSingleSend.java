package com.tencent.mobileqq.emosm.cameraemotionroaming;

import android.text.TextUtils;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.CameraEmoRoamingHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.model.EmoticonManager;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.gif.video.GIFCreator;
import dov.com.qq.im.capture.CaptureContext;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;

public class CameraEmoSingleSend
  extends AsyncStep
{
  private CameraEmoRoamingHandler jdField_a_of_type_ComTencentMobileqqAppCameraEmoRoamingHandler;
  private CameraEmotionData jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData;
  private CameraEmoRoamingManager jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoRoamingManager;
  private CameraEmotionRoamingDBManager jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmotionRoamingDBManager;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer;
  public boolean a;
  private boolean b;
  private boolean c;
  
  public CameraEmoSingleSend(CameraEmotionData paramCameraEmotionData, boolean paramBoolean)
  {
    this.b = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData = paramCameraEmotionData;
    a();
  }
  
  private void a(boolean paramBoolean, int paramInt)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData;
    if (paramBoolean) {
      ??? = "normal";
    }
    for (;;)
    {
      ((CameraEmotionData)localObject2).RomaingType = ((String)???);
      this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmotionRoamingDBManager.b(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
      this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmotionRoamingDBManager.a();
      this.jdField_a_of_type_ComTencentMobileqqAppCameraEmoRoamingHandler.a(5, paramBoolean, 14);
      localObject2 = new HashMap();
      if (paramBoolean)
      {
        ??? = "1";
        ((HashMap)localObject2).put("sucFlag", ???);
        ((HashMap)localObject2).put("retCode", String.valueOf(paramInt));
        a().collectPerformance(null, "CamEmoUpload", paramBoolean, 0L, 0L, (HashMap)localObject2, null);
      }
      synchronized (this.jdField_a_of_type_JavaLangObject)
      {
        this.jdField_a_of_type_JavaLangObject.notify();
        return;
        ??? = "failed";
        continue;
        ??? = "0";
      }
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
      this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath = paramString;
      this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.md5 = str;
      this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmotionRoamingDBManager.b(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
      paramString = new CameraEmoSingleSend.3(this);
      if (!a())
      {
        QLog.d("CameraEmoSingleSend", 1, "uploadCameraEmo, net not support");
        paramString.a(12, this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
        return;
      }
      this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoRoamingManager.a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, paramString);
      return;
    }
    a(false, 14);
  }
  
  public int a()
  {
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new CameraEmoSingleSend.1(this), 90000L);
    boolean bool1;
    if (this.b)
    {
      boolean bool2;
      if ((this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath != null) && (new File(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath).exists()))
      {
        bool2 = true;
        if ((this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath == null) || (!new File(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath).exists())) {
          break label239;
        }
      }
      label239:
      for (bool1 = true;; bool1 = false)
      {
        QLog.d("CameraEmoSingleSend", 1, new Object[] { "resend, hasOriginalFile:", Boolean.valueOf(bool2), " hasMergedFile:", Boolean.valueOf(bool1) });
        if ((bool2) || (bool1)) {
          break label244;
        }
        QLog.d("CameraEmoSingleSend", 1, new Object[] { "resend, emoOriginalPath:", this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath, " emoPath:", this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath, " emoId:", Integer.valueOf(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoId) });
        this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.RomaingType = "failed";
        this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmotionRoamingDBManager.b(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
        this.jdField_a_of_type_ComTencentMobileqqAppCameraEmoRoamingHandler.notifyUI(4, true, null);
        return 7;
        bool2 = false;
        break;
      }
      label244:
      this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmotionRoamingDBManager.b(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
    }
    for (;;)
    {
      if ((this.b) && (bool1)) {
        a(true, this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath);
      }
      for (;;)
      {
        if ((!this.c) && (!this.jdField_a_of_type_Boolean)) {}
        try
        {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_JavaLangObject.wait(120000L);
            label311:
            this.jdField_a_of_type_JavaUtilTimer.cancel();
            return 7;
            if (!TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath))
            {
              if (new File(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath).exists())
              {
                a(true, this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath);
                continue;
              }
              QLog.d("CameraEmoSingleSend", 1, new Object[] { "GIF save AIO fail, emoPath not exist, emoPath:", this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath });
              return 7;
            }
            long l = System.currentTimeMillis();
            ??? = a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath);
            ((GIFCreator)???).a(new CameraEmoSingleSend.2(this, (GIFCreator)???, l));
          }
          QLog.d("CameraEmoSingleSend", 1, new Object[] { "upload no need wait, timer canceled, emoPath:", this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath });
          return 7;
        }
        catch (Exception localException)
        {
          break label311;
        }
      }
      bool1 = false;
    }
  }
  
  public QQAppInterface a()
  {
    return (QQAppInterface)CaptureContext.a();
  }
  
  public StatisticCollector a()
  {
    return StatisticCollector.getInstance(BaseApplication.getContext());
  }
  
  public GIFCreator a(String paramString)
  {
    return new GIFCreator(paramString);
  }
  
  public void a()
  {
    QQAppInterface localQQAppInterface = a();
    if (localQQAppInterface != null)
    {
      this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmotionRoamingDBManager = ((CameraEmotionRoamingDBManager)localQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_DB_MANAGER));
      this.jdField_a_of_type_ComTencentMobileqqAppCameraEmoRoamingHandler = ((CameraEmoRoamingHandler)localQQAppInterface.getBusinessHandler(BusinessHandlerFactory.CAMERA_EMOTICON_HANDLER));
      this.jdField_a_of_type_ComTencentMobileqqEmosmCameraemotionroamingCameraEmoRoamingManager = ((CameraEmoRoamingManager)localQQAppInterface.getManager(QQManagerFactory.CAMERA_EMOTION_MANAGER));
    }
  }
  
  public void a(String paramString, int paramInt)
  {
    EmoticonManager.c(paramString, paramInt);
  }
  
  public boolean a()
  {
    return NetworkUtil.d(BaseApplication.getContext());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend
 * JD-Core Version:    0.7.0.1
 */