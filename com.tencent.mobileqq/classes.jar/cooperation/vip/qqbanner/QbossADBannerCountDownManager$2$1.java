package cooperation.vip.qqbanner;

import android.text.TextUtils;
import android.widget.TextView;
import biae;
import biaf;
import cooperation.qzone.util.QZLog;

class QbossADBannerCountDownManager$2$1
  implements Runnable
{
  QbossADBannerCountDownManager$2$1(QbossADBannerCountDownManager.2 param2) {}
  
  public void run()
  {
    if ((biaf.c(this.a.this$0) == null) || (TextUtils.isEmpty(biaf.c(this.a.this$0).getText()))) {}
    Object localObject;
    do
    {
      return;
      if (QZLog.isColorLevel()) {
        QZLog.i("QbossADBannerManager", 2, "count down text = " + biaf.c(this.a.this$0).getText());
      }
      localObject = biaf.c(this.a.this$0).getText().toString().split(":");
      if ((localObject != null) && (localObject.length == 2)) {
        break;
      }
      biaf.b(this.a.this$0);
    } while (!QZLog.isColorLevel());
    QZLog.i("QbossADBannerManager", 2, "stopTimer split error text = " + biaf.c(this.a.this$0).getText());
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
        biaf localbiaf;
        localException.printStackTrace();
        return;
      }
      localbiaf = this.a.this$0;
      if (biaf.a(this.a.this$0) != null)
      {
        localObject = biaf.a(this.a.this$0).h;
        biaf.a(localbiaf, (String)localObject);
        biaf.b(this.a.this$0);
        return;
      }
      String str = "";
      continue;
      label305:
      do
      {
        biaf.a(this.a.this$0, biaf.a(this.a.this$0, j, i));
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