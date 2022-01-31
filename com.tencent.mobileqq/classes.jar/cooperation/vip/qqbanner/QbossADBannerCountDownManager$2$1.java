package cooperation.vip.qqbanner;

import android.text.TextUtils;
import android.widget.TextView;
import bhzn;
import bhzo;
import cooperation.qzone.util.QZLog;

class QbossADBannerCountDownManager$2$1
  implements Runnable
{
  QbossADBannerCountDownManager$2$1(QbossADBannerCountDownManager.2 param2) {}
  
  public void run()
  {
    if ((bhzo.c(this.a.this$0) == null) || (TextUtils.isEmpty(bhzo.c(this.a.this$0).getText()))) {}
    Object localObject;
    do
    {
      return;
      if (QZLog.isColorLevel()) {
        QZLog.i("QbossADBannerManager", 2, "count down text = " + bhzo.c(this.a.this$0).getText());
      }
      localObject = bhzo.c(this.a.this$0).getText().toString().split(":");
      if ((localObject != null) && (localObject.length == 2)) {
        break;
      }
      bhzo.b(this.a.this$0);
    } while (!QZLog.isColorLevel());
    QZLog.i("QbossADBannerManager", 2, "stopTimer split error text = " + bhzo.c(this.a.this$0).getText());
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
        bhzo localbhzo;
        localException.printStackTrace();
        return;
      }
      localbhzo = this.a.this$0;
      if (bhzo.a(this.a.this$0) != null)
      {
        localObject = bhzo.a(this.a.this$0).h;
        bhzo.a(localbhzo, (String)localObject);
        bhzo.b(this.a.this$0);
        return;
      }
      String str = "";
      continue;
      label305:
      do
      {
        bhzo.a(this.a.this$0, bhzo.a(this.a.this$0, j, i));
        return;
        if (j < 0) {
          break;
        }
      } while (i >= 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADBannerCountDownManager.2.1
 * JD-Core Version:    0.7.0.1
 */