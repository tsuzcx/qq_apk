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
    localObject = VasADBannerCountDownManager.a(this.this$0).a();
    if (localObject == null) {
      return;
    }
    VasADBannerCountDownManager.a(this.this$0).setText(this.this$0.a(((CountDownData)localObject).jdField_a_of_type_JavaLangString));
    VasADBannerCountDownManager.b(this.this$0).setText(this.this$0.a(((CountDownData)localObject).b));
    VasADBannerCountDownManager.a(this.this$0).setTextColor(this.this$0.a(((CountDownData)localObject).c));
    VasADBannerCountDownManager.b(this.this$0).setTextColor(this.this$0.a(((CountDownData)localObject).c));
    VasADBannerCountDownManager localVasADBannerCountDownManager = this.this$0;
    VasADBannerCountDownManager.a(localVasADBannerCountDownManager, VasADBannerCountDownManager.a(localVasADBannerCountDownManager));
    VasADBannerCountDownManager.c(this.this$0).setBackgroundDrawable(VasADBannerCountDownManager.a(this.this$0, ((CountDownData)localObject).d));
    VasADBannerCountDownManager.c(this.this$0).setTextColor(this.this$0.a(((CountDownData)localObject).e));
    if (((CountDownData)localObject).jdField_a_of_type_Int == 1) {
      VasADBannerCountDownManager.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerCountDownManager.1
 * JD-Core Version:    0.7.0.1
 */