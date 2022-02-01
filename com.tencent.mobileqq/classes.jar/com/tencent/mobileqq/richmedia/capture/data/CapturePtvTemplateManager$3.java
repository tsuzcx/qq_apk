package com.tencent.mobileqq.richmedia.capture.data;

import android.content.Intent;
import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class CapturePtvTemplateManager$3
  implements INetEngineListener
{
  CapturePtvTemplateManager$3(CapturePtvTemplateManager paramCapturePtvTemplateManager, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("CapturePtvTemplateManager_PTV", 2, "onResp resultcode: " + paramNetResp.mHttpCode + " threadid=" + Thread.currentThread().getId());
    }
    File localFile = new File(CapturePtvTemplateManager.jdField_a_of_type_JavaIoFile, "temp_ptv_template_zip");
    if (!localFile.exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
      }
      NewFlowCameraReporter.a(0);
      return;
    }
    Object localObject = "";
    try
    {
      paramNetResp = FileUtils.c(localFile.getPath());
      if ((TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString)) || (!this.jdField_a_of_type_JavaLangString.equalsIgnoreCase(paramNetResp))) {}
    }
    catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
    {
      for (;;)
      {
        try
        {
          ZipUtils.unZipFile(localFile, this.b);
          paramNetResp = new File(this.c);
          if (!paramNetResp.exists()) {
            break label330;
          }
          paramNetResp = CapturePtvTemplateManager.a(paramNetResp);
          localObject = CapturePtvTemplateManager.a(null, paramNetResp, this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCaptureRedDotConfig);
          if ((localObject != null) && (!((List)localObject).isEmpty())) {
            break;
          }
          CapturePtvTemplateManager.a(paramNetResp, "ptv_template_new.cfg");
          if (QLog.isColorLevel()) {
            QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip null == infos || infos.isEmpty()");
          }
          NewFlowCameraReporter.a(-4);
          return;
          localUnsatisfiedLinkError = localUnsatisfiedLinkError;
          paramNetResp = (NetResp)localObject;
          if (!QLog.isColorLevel()) {
            continue;
          }
          localUnsatisfiedLinkError.printStackTrace();
          paramNetResp = (NetResp)localObject;
        }
        catch (Exception paramNetResp)
        {
          NewFlowCameraReporter.a(-3);
          SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0);
          if (!QLog.isColorLevel()) {
            continue;
          }
          paramNetResp.printStackTrace();
          continue;
        }
        NewFlowCameraReporter.a(-2);
      }
      CapturePtvTemplateManager.a(paramNetResp, "ptv_template_new.cfg");
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataCapturePtvTemplateManager.c(false);
      if (QLog.isColorLevel()) {
        QLog.d("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip finsh configContent=" + paramNetResp);
      }
      NewFlowCameraReporter.a(1);
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp().sendBroadcast(new Intent("action_brocassreceiver_for_ptv"));
      return;
    }
    label330:
    if (QLog.isColorLevel()) {
      QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
    }
    SharedPreUtils.g(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApp(), 0);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.3
 * JD-Core Version:    0.7.0.1
 */