package cooperation.vip.qqbanner;

import android.text.TextUtils;
import android.widget.TextView;
import bkca;
import bkcb;
import cooperation.qzone.util.QZLog;

class QbossADBannerCountDownManager$2$1
  implements Runnable
{
  QbossADBannerCountDownManager$2$1(QbossADBannerCountDownManager.2 param2) {}
  
  public void run()
  {
    if ((bkcb.c(this.a.this$0) == null) || (TextUtils.isEmpty(bkcb.c(this.a.this$0).getText()))) {}
    Object localObject;
    do
    {
      return;
      if (QZLog.isColorLevel()) {
        QZLog.i("QbossADBannerManager", 2, "count down text = " + bkcb.c(this.a.this$0).getText());
      }
      localObject = bkcb.c(this.a.this$0).getText().toString().split(":");
      if ((localObject != null) && (localObject.length == 2)) {
        break;
      }
      bkcb.b(this.a.this$0);
    } while (!QZLog.isColorLevel());
    QZLog.i("QbossADBannerManager", 2, "stopTimer split error text = " + bkcb.c(this.a.this$0).getText());
    return;
    for (;;)
    {
      int i;
      int j;
      try
      {
        int k = Integer.valueOf(localObject[0]).intValue();
        int m = Integer.valueOf(localObject[1]).intValue() - 1;
        i = m;
        j = k;
        if (m >= 0) {
          break label305;
        }
        i = 59;
        j = k - 1;
      }
      catch (Exception localException)
      {
        bkcb localbkcb;
        localException.printStackTrace();
        return;
      }
      localbkcb = this.a.this$0;
      if (bkcb.a(this.a.this$0) != null)
      {
        localObject = bkcb.a(this.a.this$0).h;
        bkcb.a(localbkcb, (String)localObject);
        bkcb.b(this.a.this$0);
        return;
      }
      String str = "";
      continue;
      label305:
      do
      {
        bkcb.a(this.a.this$0, bkcb.a(this.a.this$0, j, i));
        return;
        if (j < 0) {
          break;
        }
      } while (i >= 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADBannerCountDownManager.2.1
 * JD-Core Version:    0.7.0.1
 */