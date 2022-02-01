package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.SignatureManager;
import com.tencent.mobileqq.vas.SignatureTemplateConfig;
import com.tencent.mobileqq.vas.VasMonitorHandler;
import com.tencent.mobileqq.vas.util.VasMonitorDT;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.qqsharpP.QQSharpPUtil;
import com.tencent.sharpP.SharpPUtil;
import java.io.File;
import java.io.OutputStream;
import java.net.URL;
import mqq.app.AppRuntime;
import org.apache.http.Header;

public class SignatureTemplateDownloader
  extends AbsDownloader
{
  public static final String HEADER_FILENAME = "img_filename";
  public static final String HEADER_UIN = "my_uin";
  public static final String PROTOCAL_SIGNATURE_COVER = "sig_cover";
  public static final String PROTOCAL_SIGNATURE_ZIP = "sig_zip";
  private static final String TAG = "SignatureTemplateDownloader";
  
  private static String getSigTplUri(int paramInt, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://gxh.vip.qq.com/xydata/");
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public File downLoadImg(AppRuntime paramAppRuntime, String paramString1, String paramString2, boolean paramBoolean)
  {
    String str = getSigTplUri(Integer.parseInt(paramString1), paramString2);
    Object localObject = new File(SignatureTemplateConfig.a(paramString1, paramString2));
    paramString2 = new DownloadTask(str, (File)localObject);
    paramString2.E = paramBoolean;
    if (paramAppRuntime != null) {
      if (DownloaderFactory.a(paramString2, paramAppRuntime) == 0)
      {
        if ((((File)localObject).exists()) && (!SignatureManager.c(((File)localObject).getAbsolutePath())))
        {
          ((File)localObject).delete();
        }
        else
        {
          if (SharpPUtil.isSharpPFile((File)localObject)) {
            return QQSharpPUtil.a((File)localObject);
          }
          return localObject;
        }
      }
      else
      {
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("");
        paramAppRuntime.append(paramString2.c);
        paramAppRuntime = paramAppRuntime.toString();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("error code = ");
        ((StringBuilder)localObject).append(paramString2.c);
        ((StringBuilder)localObject).append(" errorMsg = ");
        ((StringBuilder)localObject).append(paramString2.d);
        ((StringBuilder)localObject).append("url = ");
        ((StringBuilder)localObject).append(str);
        VasMonitorHandler.a(null, "individual_v2_signature_download_fail", paramAppRuntime, ((StringBuilder)localObject).toString(), null, 0.0F);
        paramAppRuntime = new StringBuilder();
        paramAppRuntime.append("tlpId:");
        paramAppRuntime.append(paramString1);
        paramAppRuntime.append(" errCode:");
        paramAppRuntime.append(paramString2.c);
        paramAppRuntime.append(" errMsg:");
        paramAppRuntime.append(paramString2.d);
        VasMonitorDT.a("individual_v2_signature_download_fail", paramAppRuntime.toString());
      }
    }
    return new File(AppConstants.SDCARD_PATH);
  }
  
  public File downloadImage(OutputStream paramOutputStream, DownloadParams paramDownloadParams, URLDrawableHandler paramURLDrawableHandler)
  {
    paramURLDrawableHandler = paramDownloadParams.url.getFile();
    paramOutputStream = paramURLDrawableHandler;
    if (paramURLDrawableHandler.startsWith(File.separator)) {
      paramOutputStream = paramURLDrawableHandler.substring(1);
    }
    String str = paramDownloadParams.url.getHost();
    Object localObject = paramDownloadParams.getHeader("my_uin");
    paramURLDrawableHandler = null;
    if (localObject != null) {
      paramURLDrawableHandler = ((Header)localObject).getValue();
    }
    paramURLDrawableHandler = BaseApplicationImpl.sApplication.getAppRuntime(paramURLDrawableHandler);
    localObject = new File(SignatureTemplateConfig.a(paramOutputStream, str));
    if (((File)localObject).exists()) {
      return localObject;
    }
    if (paramDownloadParams.useSharpPImage)
    {
      localObject = new File(QQSharpPUtil.b((File)localObject));
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return downLoadImg(paramURLDrawableHandler, paramOutputStream, str, paramDownloadParams.useSharpPImage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.SignatureTemplateDownloader
 * JD-Core Version:    0.7.0.1
 */