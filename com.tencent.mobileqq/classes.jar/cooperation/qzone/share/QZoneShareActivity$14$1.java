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
    if (this.this$1.this$0.viewTextCount == null) {
      return;
    }
    if (this.val$exceedCount > 0)
    {
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131909880));
      ((StringBuilder)localObject).append(this.val$exceedCount);
      ((StringBuilder)localObject).append(HardCodeUtil.a(2131909892));
      localObject = ((StringBuilder)localObject).toString();
      int i = this.this$1.this$0.getResources().getColor(2131167720);
      this.this$1.this$0.viewTextCount.setTextColor(i);
      this.this$1.this$0.viewTextCount.setText((CharSequence)localObject);
      if (this.this$1.this$0.viewTextCount.getVisibility() != 0) {
        this.this$1.this$0.viewTextCount.setVisibility(0);
      }
      if (this.this$1.this$0.showMaxLen)
      {
        QQToast.makeText(this.this$1.this$0, 2131915206, 0).show();
        this.this$1.this$0.showMaxLen = false;
      }
    }
    else if (this.this$1.this$0.viewTextCount.getVisibility() != 8)
    {
      this.this$1.this$0.viewTextCount.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.share.QZoneShareActivity.14.1
 * JD-Core Version:    0.7.0.1
 */