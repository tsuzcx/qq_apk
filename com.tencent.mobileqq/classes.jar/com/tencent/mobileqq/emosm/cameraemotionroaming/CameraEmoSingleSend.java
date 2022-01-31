package com.tencent.mobileqq.emosm.cameraemotionroaming;

import alks;
import android.text.TextUtils;
import apjf;
import apji;
import apjk;
import apjl;
import apjm;
import azmz;
import bdee;
import blah;
import bllv;
import com.qq.taf.jce.HexUtil;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.data.CameraEmotionData;
import com.tencent.mobileqq.mqsafeedit.MD5;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.HashMap;
import java.util.Timer;

public class CameraEmoSingleSend
  extends AsyncStep
{
  private alks jdField_a_of_type_Alks;
  private apjf jdField_a_of_type_Apjf;
  private apjm jdField_a_of_type_Apjm;
  private CameraEmotionData jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private Timer jdField_a_of_type_JavaUtilTimer;
  private boolean jdField_a_of_type_Boolean;
  private boolean b;
  
  public CameraEmoSingleSend(CameraEmotionData paramCameraEmotionData, boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData = paramCameraEmotionData;
    b();
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
      this.jdField_a_of_type_Apjm.b(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
      this.jdField_a_of_type_Apjm.a();
      this.jdField_a_of_type_Alks.a(5, paramBoolean, 14);
      localObject2 = new HashMap();
      if (paramBoolean)
      {
        ??? = "1";
        ((HashMap)localObject2).put("sucFlag", ???);
        ((HashMap)localObject2).put("retCode", String.valueOf(paramInt));
        azmz.a(BaseApplication.getContext()).a(null, "CamEmoUpload", paramBoolean, 0L, 0L, (HashMap)localObject2, null);
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
    if (this.b)
    {
      QLog.d("CameraEmoSingleSend", 1, new Object[] { "upload return, timer canceled, emoPath:", this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath });
      return;
    }
    if (paramBoolean)
    {
      String str = HexUtil.bytes2HexStr(MD5.getFileMd5(paramString));
      this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath = paramString;
      this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.md5 = str;
      this.jdField_a_of_type_Apjm.b(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
      paramString = new apjl(this);
      if (!bdee.d(BaseApplication.getContext()))
      {
        QLog.d("CameraEmoSingleSend", 1, "uploadCameraEmo, net not support");
        paramString.a(12, this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
        return;
      }
      this.jdField_a_of_type_Apjf.a(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData, paramString);
      return;
    }
    a(false, 14);
  }
  
  public int a()
  {
    this.jdField_a_of_type_JavaUtilTimer = new Timer();
    this.jdField_a_of_type_JavaUtilTimer.schedule(new CameraEmoSingleSend.1(this), 90000L);
    boolean bool1;
    if (this.jdField_a_of_type_Boolean)
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
        this.jdField_a_of_type_Apjm.b(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
        this.jdField_a_of_type_Alks.notifyUI(4, true, null);
        return 7;
        bool2 = false;
        break;
      }
      label244:
      this.jdField_a_of_type_Apjm.b(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData);
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_Boolean) && (bool1)) {
        a(true, this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath);
      }
      for (;;)
      {
        if (!this.b) {}
        try
        {
          synchronized (this.jdField_a_of_type_JavaLangObject)
          {
            this.jdField_a_of_type_JavaLangObject.wait(120000L);
            label304:
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
            ??? = new blah(this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoOriginalPath);
            ((blah)???).a(new apjk(this, (blah)???, l));
          }
          QLog.d("CameraEmoSingleSend", 1, new Object[] { "upload no need wait, timer canceled, emoPath:", this.jdField_a_of_type_ComTencentMobileqqDataCameraEmotionData.emoPath });
          return 7;
        }
        catch (Exception localException)
        {
          break label304;
        }
      }
      bool1 = false;
    }
  }
  
  public void b()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)bllv.a();
    this.jdField_a_of_type_Apjm = ((apjm)localQQAppInterface.getManager(333));
    this.jdField_a_of_type_Alks = ((alks)localQQAppInterface.a(160));
    this.jdField_a_of_type_Apjf = ((apjf)localQQAppInterface.getManager(334));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.cameraemotionroaming.CameraEmoSingleSend
 * JD-Core Version:    0.7.0.1
 */