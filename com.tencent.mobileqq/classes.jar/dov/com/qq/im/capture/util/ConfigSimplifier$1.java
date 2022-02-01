package dov.com.qq.im.capture.util;

import android.text.TextUtils;
import com.tencent.biz.common.util.ZipUtils;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;
import java.io.File;
import java.io.IOException;

class ConfigSimplifier$1
  implements INetEngineListener
{
  ConfigSimplifier$1(ConfigSimplifier paramConfigSimplifier, String paramString1, String paramString2, ConfigSimplifier.ZipConfig paramZipConfig, String paramString3, String paramString4, ConfigSimplifier.ConfigDownloadCallback paramConfigDownloadCallback) {}
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("ConfigSimplifier_PTV", 2, "onResp resultcode: " + paramNetResp.mHttpCode + " threadid=" + Thread.currentThread().getId());
    }
    File localFile = new File(this.jdField_a_of_type_JavaLangString, this.b);
    if (!localFile.exists()) {
      if (QLog.isColorLevel()) {
        QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !zipfile.exists()");
      }
    }
    label249:
    do
    {
      for (;;)
      {
        return;
        paramNetResp = "";
        try
        {
          String str = FileUtils.c(localFile.getPath());
          paramNetResp = str;
          if ((TextUtils.isEmpty(this.jdField_a_of_type_DovComQqImCaptureUtilConfigSimplifier$ZipConfig.c)) || (!this.jdField_a_of_type_DovComQqImCaptureUtilConfigSimplifier$ZipConfig.c.equalsIgnoreCase(paramNetResp))) {}
        }
        catch (UnsatisfiedLinkError localUnsatisfiedLinkError)
        {
          for (;;)
          {
            try
            {
              ZipUtils.unZipFile(localFile, this.c);
              paramNetResp = new File(this.d);
              if (!paramNetResp.exists()) {
                break label249;
              }
              paramNetResp = QIMPtvTemplateManager.a(paramNetResp);
              if ((this.jdField_a_of_type_DovComQqImCaptureUtilConfigSimplifier$ConfigDownloadCallback == null) || (paramNetResp == null)) {
                break;
              }
              this.jdField_a_of_type_DovComQqImCaptureUtilConfigSimplifier$ConfigDownloadCallback.a(paramNetResp);
              return;
              localUnsatisfiedLinkError = localUnsatisfiedLinkError;
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", localUnsatisfiedLinkError);
            }
            catch (IOException paramNetResp)
            {
              QLog.e("ConfigSimplifier_PTV", 1, "onResp error, ", paramNetResp);
              continue;
            }
            if (QLog.isColorLevel()) {
              QLog.e("ConfigSimplifier_PTV", 2, new Object[] { "parseFilterConfigZip error, md5:", this.jdField_a_of_type_DovComQqImCaptureUtilConfigSimplifier$ZipConfig.c, " ", paramNetResp });
            }
          }
        }
      }
    } while (!QLog.isColorLevel());
    QLog.w("ConfigSimplifier_PTV", 2, "parseFilterConfigZip !jsonFile.exists()");
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.util.ConfigSimplifier.1
 * JD-Core Version:    0.7.0.1
 */