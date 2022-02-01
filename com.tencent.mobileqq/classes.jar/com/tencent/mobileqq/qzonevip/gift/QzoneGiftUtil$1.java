package com.tencent.mobileqq.qzonevip.gift;

import android.text.TextUtils;
import com.tencent.TMG.utils.QLog;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qzonehub.api.utils.IQzoneZipCacheHelper;
import cooperation.qzone.webviewplugin.QzoneZipCacheHelperCallBack;

final class QzoneGiftUtil$1
  implements Runnable
{
  private volatile int f;
  private volatile int g;
  
  QzoneGiftUtil$1(QzoneGiftUtil.GiftLoadListener paramGiftLoadListener, int paramInt, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    this.f = 0;
    this.g = 0;
    Object localObject = new QzoneGiftUtil.1.1(this);
    if (!TextUtils.isEmpty(this.c))
    {
      localIQzoneZipCacheHelper = (IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class);
      str = this.c;
      if (localIQzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, str, "qzone_aio_gift", String.valueOf(str.hashCode()), -1, (QzoneZipCacheHelperCallBack)localObject)) {
        this.f += 1;
      }
    }
    IQzoneZipCacheHelper localIQzoneZipCacheHelper = (IQzoneZipCacheHelper)QRoute.api(IQzoneZipCacheHelper.class);
    String str = this.d;
    boolean bool1 = localIQzoneZipCacheHelper.checkAndDownLoadFileIfNeeded(null, str, "qzone_aio_gift", String.valueOf(str.hashCode()), -1, (QzoneZipCacheHelperCallBack)localObject);
    if (bool1) {
      this.f += 1;
    }
    boolean bool2 = QzoneGiftUtil.b(this.e, "qzone_aio_gift");
    if (bool2) {
      this.f += 1;
    } else {
      QzoneGiftUtil.a(this.e, "qzone_aio_gift", (QzoneZipCacheHelperCallBack)localObject);
    }
    if (this.a != null) {
      if (this.f == this.b) {
        this.a.b();
      } else {
        this.a.d();
      }
    }
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(" isGiftZipFileExist = ");
    ((StringBuilder)localObject).append(bool1);
    ((StringBuilder)localObject).append(" isGiftExist = ");
    ((StringBuilder)localObject).append(bool2);
    ((StringBuilder)localObject).append(" mLoadSuccessTimes = ");
    ((StringBuilder)localObject).append(this.f);
    ((StringBuilder)localObject).append(" mLoadFailTimes = ");
    ((StringBuilder)localObject).append(this.g);
    QLog.i("QzoneGiftUtil", 1, ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qzonevip.gift.QzoneGiftUtil.1
 * JD-Core Version:    0.7.0.1
 */