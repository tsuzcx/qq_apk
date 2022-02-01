package cooperation.ilive.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.vas.config.business.qvip.QVipSDKProcessor;
import com.tencent.mobileqq.webprocess.PreloadService;
import com.tencent.qphone.base.util.QLog;
import cooperation.ilive.config.IliveManagerCfgBean;
import cooperation.ilive.config.IliveManagerConfProcessor;
import cooperation.ilive.lite.IliveLiteHelper;

final class IlivePreloadHelper$1
  implements Runnable
{
  IlivePreloadHelper$1(int paramInt, Context paramContext) {}
  
  public void run()
  {
    Object localObject = IliveManagerConfProcessor.a();
    if ((localObject != null) && (((IliveManagerCfgBean)localObject).d()))
    {
      IliveLiteHelper.a().b();
      return;
    }
    if (!QVipSDKProcessor.e().d()) {
      return;
    }
    if ((this.a == 1) && (!IlivePreloadHelper.c()))
    {
      QLog.e("IlivePreloadHelper", 1, "preloadLiveShopping checkDrawerSwitchEnable = false");
      return;
    }
    IlivePreloadHelper.d();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("ilive start preloadLiveShopping , source = ");
    ((StringBuilder)localObject).append(this.a);
    QLog.e("IlivePreloadHelper", 1, ((StringBuilder)localObject).toString());
    PreloadService.b(-1);
    localObject = new Intent(this.b, PreloadWebService.class);
    ((Intent)localObject).putExtra("isPreloadLiveShopping", true);
    ((Intent)localObject).putExtra("source", this.a);
    try
    {
      this.b.startService((Intent)localObject);
      return;
    }
    catch (Throwable localThrowable)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("preDownloadIfNecessary=>");
        localStringBuilder.append(localThrowable.getMessage());
        QLog.e("IlivePreloadHelper", 2, localStringBuilder.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.ilive.util.IlivePreloadHelper.1
 * JD-Core Version:    0.7.0.1
 */