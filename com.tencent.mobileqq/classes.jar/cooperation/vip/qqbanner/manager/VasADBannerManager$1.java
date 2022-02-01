package cooperation.vip.qqbanner.manager;

import android.view.View;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableListener;
import com.tencent.mobileqq.startup.step.SetSplash;
import com.tencent.qphone.base.util.QLog;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;

class VasADBannerManager$1
  implements URLDrawable.URLDrawableListener
{
  VasADBannerManager$1(VasADBannerManager paramVasADBannerManager, VasADBannerConfigInfo paramVasADBannerConfigInfo) {}
  
  public void onLoadCanceled(URLDrawable paramURLDrawable) {}
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    QLog.i("VasADBannerManager", 1, "showVasADBanner urlDrawable load failed.");
    if (paramThrowable != null) {
      paramThrowable.getMessage();
    }
    try
    {
      this.b.c();
      return;
    }
    catch (Exception paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.e("VasADBannerManager", 1, "onLoadFailed Exception");
    }
  }
  
  public void onLoadProgressed(URLDrawable paramURLDrawable, int paramInt) {}
  
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    QLog.i("VasADBannerManager", 1, "showVasADBanner urlDrawable load success");
    try
    {
      if ((this.b.b != null) && (this.b.d != null) && (paramURLDrawable != null))
      {
        this.b.b.setVisibility(0);
        VasADBannerManager.a(this.b, this.a);
        this.b.a(this.a);
        SetSplash.a(this.b.b);
        return;
      }
      if (this.b.b != null)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("showVasADBanner and Animation failed, mUrlImageView :");
        localStringBuilder.append(this.b.d);
        localStringBuilder.append("urlDrawable :");
        localStringBuilder.append(paramURLDrawable);
        QLog.w("VasADBannerManager", 1, localStringBuilder.toString());
        this.b.b.setVisibility(8);
        return;
      }
    }
    catch (Exception paramURLDrawable)
    {
      paramURLDrawable.printStackTrace();
      QLog.e("VasADBannerManager", 1, "onLoadSuccessed Exception");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerManager.1
 * JD-Core Version:    0.7.0.1
 */