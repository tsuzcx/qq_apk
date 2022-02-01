package cooperation.qzone.share;

import android.content.res.Resources;
import android.widget.TextView;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.widget.QQToast;

class QZoneShareActivity$14$1
  implements Runnable
{
  QZoneShareActivity$14$1(QZoneShareActivity.14 param14, int paramInt) {}
  
  public void run()
  {
    if (this.this$1.this$0.viewTextCount == null) {}
    do
    {
      do
      {
        return;
        if (this.val$exceedCount <= 0) {
          break;
        }
        String str = HardCodeUtil.a(2131712305) + this.val$exceedCount + HardCodeUtil.a(2131712317);
        int i = this.this$1.this$0.getResources().getColor(2131166784);
        this.this$1.this$0.viewTextCount.setTextColor(i);
        this.this$1.this$0.viewTextCount.setText(str);
        if (this.this$1.this$0.viewTextCount.getVisibility() != 0) {
          this.this$1.this$0.viewTextCount.setVisibility(0);
        }
      } while (!this.this$1.this$0.showMaxLen);
      QQToast.a(this.this$1.this$0, 2131718072, 0).a();
      this.this$1.this$0.showMaxLen = false;
      return;
    } while (this.this$1.this$0.viewTextCount.getVisibility() == 8);
    this.this$1.this$0.viewTextCount.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.14.1
 * JD-Core Version:    0.7.0.1
 */