package dov.com.tencent.mobileqq.activity.richmedia;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.open.base.ToastUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class QzoneRightButton$1
  implements View.OnClickListener
{
  QzoneRightButton$1(QzoneRightButton paramQzoneRightButton) {}
  
  public void onClick(View paramView)
  {
    if (!QzoneRightButton.a(this.a).e) {
      QzoneRightButton.a(this.a);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (QzoneRightButton.a(this.a).o)
      {
        ToastUtil.a().a(2131718019);
        QzoneRightButton.a(this.a).o = false;
        QzoneRightButton.a(this.a).setSelected(false);
        QzoneRightButton.a(this.a).l = false;
        QzoneRightButton.a(this.a).c(3008);
      }
      else
      {
        ToastUtil.a().a(2131718021);
        QzoneRightButton.a(this.a).o = true;
        QzoneRightButton.a(this.a).setSelected(true);
        QzoneRightButton.a(this.a).l = true;
        QzoneRightButton.a(this.a).c(3007);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.richmedia.QzoneRightButton.1
 * JD-Core Version:    0.7.0.1
 */