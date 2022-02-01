package cooperation.ilive.util;

import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.PreloadWebService;
import com.tencent.mobileqq.config.business.qvip.QVipSDKConfig;
import com.tencent.mobileqq.config.business.qvip.QVipSDKProcessor;
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
    if ((localObject != null) && (((IliveManagerCfgBean)localObject).b())) {
      IliveLiteHelper.a().a();
    }
    do
    {
      do
      {
        return;
      } while (!QVipSDKProcessor.c().d());
      if ((this.jdField_a_of_type_Int == 1) && (!IlivePreloadHelper.a()))
      {
        QLog.e("IlivePreloadHelper", 1, "preloadLiveShopping checkDrawerSwitchEnable = false");
        return;
      }
      IlivePreloadHelper.b();
      QLog.e("IlivePreloadHelper", 1, "ilive start preloadLiveShopping , source = " + this.jdField_a_of_type_Int);
      PreloadService.b(-1);
      localObject = new Intent(this.jdField_a_of_type_AndroidContentContext, PreloadWebService.class);
      ((Intent)localObject).putExtra("isPreloadLiveShopping", true);
      ((Intent)localObject).putExtra("source", this.jdField_a_of_type_Int);
      try
      {
        this.jdField_a_of_type_AndroidContentContext.startService((Intent)localObject);
        return;
      }
      catch (Throwable localThrowable) {}
    } while (!QLog.isColorLevel());
    QLog.e("IlivePreloadHelper", 2, "preDownloadIfNecessary=>" + localThrowable.getMessage());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.ilive.util.IlivePreloadHelper.1
 * JD-Core Version:    0.7.0.1
 */