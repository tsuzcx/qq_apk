package cooperation.vip.qqbanner;

import android.text.TextUtils;
import android.widget.TextView;
import bnwi;
import bnwj;
import cooperation.qzone.util.QZLog;

class QbossADBannerCountDownManager$2$1
  implements Runnable
{
  QbossADBannerCountDownManager$2$1(QbossADBannerCountDownManager.2 param2) {}
  
  public void run()
  {
    if ((bnwj.c(this.a.this$0) == null) || (TextUtils.isEmpty(bnwj.c(this.a.this$0).getText()))) {}
    Object localObject;
    do
    {
      return;
      if (QZLog.isColorLevel()) {
        QZLog.i("QbossADBannerManager", 2, "count down text = " + bnwj.c(this.a.this$0).getText());
      }
      localObject = bnwj.c(this.a.this$0).getText().toString().split(":");
      if ((localObject != null) && (localObject.length == 2)) {
        break;
      }
      bnwj.b(this.a.this$0);
    } while (!QZLog.isColorLevel());
    QZLog.i("QbossADBannerManager", 2, "stopTimer split error text = " + bnwj.c(this.a.this$0).getText());
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
        bnwj localbnwj;
        localException.printStackTrace();
        return;
      }
      localbnwj = this.a.this$0;
      if (bnwj.a(this.a.this$0) != null)
      {
        localObject = bnwj.a(this.a.this$0).j;
        bnwj.a(localbnwj, (String)localObject);
        bnwj.b(this.a.this$0);
        return;
      }
      String str = "";
      continue;
      label305:
      do
      {
        bnwj.a(this.a.this$0, bnwj.a(this.a.this$0, j, i));
        return;
        if (j < 0) {
          break;
        }
      } while (i >= 0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.vip.qqbanner.QbossADBannerCountDownManager.2.1
 * JD-Core Version:    0.7.0.1
 */