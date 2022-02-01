package cooperation.vip.qqbanner.manager;

import android.text.TextUtils;
import android.widget.TextView;
import cooperation.qzone.util.QZLog;
import cooperation.vip.qqbanner.data.CountDownData;
import cooperation.vip.qqbanner.info.VasADBannerCountDownInfo;

class VasADBannerCountDownManager$2$1
  implements Runnable
{
  VasADBannerCountDownManager$2$1(VasADBannerCountDownManager.2 param2) {}
  
  public void run()
  {
    Object localObject;
    int j;
    int i;
    if (VasADBannerCountDownManager.c(this.a.this$0) != null)
    {
      if (TextUtils.isEmpty(VasADBannerCountDownManager.c(this.a.this$0).getText())) {
        return;
      }
      if (QZLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("count down text = ");
        ((StringBuilder)localObject).append(VasADBannerCountDownManager.c(this.a.this$0).getText());
        QZLog.i("VasADBannerManager", 2, ((StringBuilder)localObject).toString());
      }
      localObject = VasADBannerCountDownManager.c(this.a.this$0).getText().toString().split(":");
      if ((localObject != null) && (localObject.length == 2))
      {
        try
        {
          int k = Integer.valueOf(localObject[0]).intValue();
          int m = Integer.valueOf(localObject[1]).intValue() - 1;
          j = m;
          i = k;
          if (m < 0)
          {
            j = 59;
            i = k - 1;
          }
          String str = "";
          localObject = str;
          if (VasADBannerCountDownManager.a(this.a.this$0) == null) {
            break label348;
          }
          localObject = str;
          if (VasADBannerCountDownManager.a(this.a.this$0).a() == null) {
            break label348;
          }
          localObject = VasADBannerCountDownManager.a(this.a.this$0).a().f;
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
          return;
        }
        VasADBannerCountDownManager.a(this.a.this$0, VasADBannerCountDownManager.a(this.a.this$0, i, j));
        return;
      }
    }
    for (;;)
    {
      VasADBannerCountDownManager.a(this.a.this$0, (String)localObject);
      VasADBannerCountDownManager.b(this.a.this$0);
      return;
      VasADBannerCountDownManager.b(this.a.this$0);
      if (QZLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("stopTimer split error text = ");
        localStringBuilder.append(VasADBannerCountDownManager.c(this.a.this$0).getText());
        QZLog.i("VasADBannerManager", 2, localStringBuilder.toString());
      }
      return;
      label348:
      if (i >= 0) {
        if (j >= 0) {
          break;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.manager.VasADBannerCountDownManager.2.1
 * JD-Core Version:    0.7.0.1
 */