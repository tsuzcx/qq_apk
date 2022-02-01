package com.tencent.mobileqq.richmedia.capture.data;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.activity.richmedia.NewFlowCameraReporter;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.SharedPreUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;

class CapturePtvTemplateManager$3
  implements INetEngineListener
{
  CapturePtvTemplateManager$3(CapturePtvTemplateManager paramCapturePtvTemplateManager, String paramString1, String paramString2, QQAppInterface paramQQAppInterface, String paramString3) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("onResp resultcode: ");
      ((StringBuilder)localObject).append(paramNetResp.mHttpCode);
      ((StringBuilder)localObject).append(" threadid=");
      ((StringBuilder)localObject).append(Thread.currentThread().getId());
      QLog.i("CapturePtvTemplateManager_PTV", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = new File(CapturePtvTemplateManager.d, "temp_ptv_template_zip");
    if (!((File)localObject).exists())
    {
      if (QLog.isColorLevel()) {
        QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
      }
      NewFlowCameraReporter.a(0);
      return;
    }
    try
    {
      paramNetResp = FileUtils.calcMd5(((File)localObject).getPath());
    }
    catch (UnsatisfiedLinkError paramNetResp)
    {
      if (QLog.isColorLevel()) {
        paramNetResp.printStackTrace();
      }
      paramNetResp = "";
    }
    if ((!TextUtils.isEmpty(this.a)) && (this.a.equalsIgnoreCase(paramNetResp)))
    {
      try
      {
        ZipUtils.unZipFile((File)localObject, this.b);
      }
      catch (Exception paramNetResp)
      {
        NewFlowCameraReporter.a(-3);
        SharedPreUtils.g(this.c.getApp(), 0);
        if (!QLog.isColorLevel()) {
          break label189;
        }
      }
      paramNetResp.printStackTrace();
    }
    else
    {
      NewFlowCameraReporter.a(-2);
    }
    label189:
    paramNetResp = new File(this.d);
    if (paramNetResp.exists())
    {
      paramNetResp = CapturePtvTemplateManager.a(paramNetResp);
      localObject = CapturePtvTemplateManager.a(null, paramNetResp, this.e.k);
      if ((localObject != null) && (!((List)localObject).isEmpty()))
      {
        CapturePtvTemplateManager.b(paramNetResp, "ptv_template_new.cfg");
        this.e.c(false);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("parseFilterConfigZip finsh configContent=");
          ((StringBuilder)localObject).append(paramNetResp);
          QLog.d("CapturePtvTemplateManager_PTV", 2, ((StringBuilder)localObject).toString());
        }
        NewFlowCameraReporter.a(1);
        return;
      }
      CapturePtvTemplateManager.b(paramNetResp, "ptv_template_new.cfg");
      if (QLog.isColorLevel()) {
        QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip null == infos || infos.isEmpty()");
      }
      NewFlowCameraReporter.a(-4);
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.w("CapturePtvTemplateManager_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
    }
    SharedPreUtils.g(this.c.getApp(), 0);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager.3
 * JD-Core Version:    0.7.0.1
 */