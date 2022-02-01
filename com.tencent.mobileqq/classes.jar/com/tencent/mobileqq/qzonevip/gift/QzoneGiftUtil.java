package com.tencent.mobileqq.qzonevip.gift;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.network.DownloaderFactory;
import com.tencent.component.network.downloader.Downloader;
import com.tencent.image.Utils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;
import java.io.File;

public class QzoneGiftUtil
{
  public static String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return ((IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class)).getBasePath("qzone_aio_gift", String.valueOf(paramString.hashCode()));
  }
  
  public static String a(String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString1)) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplicationImpl.getApplication().getCacheDir());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    localStringBuilder.append(File.separator);
    localStringBuilder.append(Utils.Crc64String(paramString1));
    localStringBuilder.append(paramString1.substring(paramString1.lastIndexOf(".")));
    return localStringBuilder.toString();
  }
  
  public static void a(QzoneGiftUtil.GiftLoadListener paramGiftLoadListener, String paramString1, String paramString2, String paramString3)
  {
    if ((!TextUtils.isEmpty(paramString2)) && (!TextUtils.isEmpty(paramString3)))
    {
      int i;
      if (TextUtils.isEmpty(paramString1)) {
        i = 2;
      } else {
        i = 3;
      }
      ThreadManagerV2.executeOnFileThread(new QzoneGiftUtil.1(paramGiftLoadListener, i, paramString1, paramString2, paramString3));
      return;
    }
    paramGiftLoadListener = new StringBuilder();
    paramGiftLoadListener.append("downloadGiftZip fail with url = null  boxZipUrl = ");
    paramGiftLoadListener.append(paramString1);
    paramGiftLoadListener.append(" giftZipUrl = ");
    paramGiftLoadListener.append(paramString2);
    paramGiftLoadListener.append(" giftUrl = ");
    paramGiftLoadListener.append(paramString3);
    QLog.e("QzoneGiftUtil", 1, paramGiftLoadListener.toString());
  }
  
  public static void a(String paramString1, String paramString2, QzoneZipCacheHelperCallBack paramQzoneZipCacheHelperCallBack)
  {
    QLog.i("QzoneGiftUtil", 1, "downloadGiftPhoto");
    Downloader localDownloader = DownloaderFactory.getInstance(BaseApplicationImpl.getContext()).getCommonDownloader();
    if (localDownloader != null) {
      localDownloader.download(paramString1, a(paramString1, paramString2), false, new QzoneGiftUtil.2(paramQzoneZipCacheHelperCallBack));
    }
  }
  
  private static boolean b(String paramString1, String paramString2)
  {
    return FileUtil.b(a(paramString1, paramString2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil
 * JD-Core Version:    0.7.0.1
 */