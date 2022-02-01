package com.tencent.mobileqq.transfile;

import android.text.TextUtils;
import bhoh;
import bhpd;
import bhpe;
import bhyo;
import bhyq;
import bkwb;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.DownloadParams;
import com.tencent.image.URLDrawableHandler;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.SignatureManager;
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
    paramString2 = new File(bhoh.a(paramString1, paramString2));
    bhyo localbhyo = new bhyo(str, paramString2);
    localbhyo.k = paramBoolean;
    if (paramAppRuntime != null)
    {
      if (bhyq.a(localbhyo, paramAppRuntime) != 0) {
        break label102;
      }
      if ((!paramString2.exists()) || (SignatureManager.a(paramString2.getAbsolutePath()))) {
        break label88;
      }
      paramString2.delete();
    }
    for (;;)
    {
      return new File(AppConstants.SDCARD_PATH);
      label88:
      if (SharpPUtil.isSharpPFile(paramString2)) {
        return bkwb.a(paramString2);
      }
      return paramString2;
      label102:
      bhpe.a(null, "individual_v2_signature_download_fail", "" + localbhyo.a, "error code = " + localbhyo.a + " errorMsg = " + localbhyo.b + "url = " + str, null, 0.0F);
      bhpd.a("individual_v2_signature_download_fail", "tlpId:" + paramString1 + " errCode:" + localbhyo.a + " errMsg:" + localbhyo.b);
    }
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
    localObject = new File(bhoh.a(paramOutputStream, str));
    if (((File)localObject).exists()) {
      return localObject;
    }
    if (paramDownloadParams.useSharpPImage)
    {
      localObject = new File(bkwb.a((File)localObject));
      if (((File)localObject).exists()) {
        return localObject;
      }
    }
    return downLoadImg(paramURLDrawableHandler, paramOutputStream, str, paramDownloadParams.useSharpPImage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.SignatureTemplateDownloader
 * JD-Core Version:    0.7.0.1
 */