package cooperation.vip.qqbanner.manager;

import android.widget.TextView;
import cooperation.vip.qqbanner.data.CountDownData;
import cooperation.vip.qqbanner.info.VasADBannerConfigInfo;
import cooperation.vip.qqbanner.info.VasADBannerCountDownInfo;

class VasADBannerCountDownManager$1
  implements Runnable
{
  VasADBannerCountDownManager$1(VasADBannerCountDownManager paramVasADBannerCountDownManager, VasADBannerConfigInfo paramVasADBannerConfigInfo) {}
  
  public void run()
  {
    Object localObject = this.a;
    if (localObject == null) {
      return;
    }
    if (!(localObject instanceof VasADBannerCountDownInfo)) {
      return;
    }
    VasADBannerCountDownManager.a(this.this$0, (VasADBannerCountDownInfo)localObject);
    localObject = VasADBannerCountDownManager.a(this.this$0).f();
    if (localObject == null) {
      return;
    }
    VasADBannerCountDownManager.b(this.this$0).setText(this.this$0.b(((CountDownData)localObject).d));
    VasADBannerCountDownManager.c(this.this$0).setText(this.this$0.b(((CountDownData)localObject).e));
    VasADBannerCountDownManager.b(this.this$0).setTextColor(this.this$0.a(((CountDownData)localObject).f));
    VasADBannerCountDownManager.c(this.this$0).setTextColor(this.this$0.a(((CountDownData)localObject).f));
    VasADBannerCountDownManager localVasADBannerCountDownManager = this.this$0;
    VasADBannerCountDownManager.a(localVasADBannerCountDownManager, VasADBannerCountDownManager.d(localVasADBannerCountDownManager));
    VasADBannerCountDownManager.e(this.this$0).setBackgroundDrawable(VasADBannerCountDownManager.b(this.this$0, ((CountDownData)localObject).g));
    VasADBannerCountDownManager.e(this.this$0).setTextColor(this.this$0.a(((CountDownData)localObject).h));
    if (((CountDownData)localObject).a == 1) {
      VasADBannerCountDownManager.f(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerCountDownManager.1
 * JD-Core Version:    0.7.0.1
 */