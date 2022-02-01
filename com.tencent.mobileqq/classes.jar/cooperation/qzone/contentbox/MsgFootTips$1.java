package cooperation.qzone.contentbox;

import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MsgFootTips$1
  implements View.OnClickListener
{
  MsgFootTips$1(MsgFootTips paramMsgFootTips) {}
  
  public void onClick(View paramView)
  {
    if (MsgFootTips.access$000(this.this$0) == 2) {
      MsgFootTips.access$100(this.this$0).sendEmptyMessage(2);
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (MsgFootTips.access$000(this.this$0) == 5) {
        if (this.this$0.isLoadMoreUpHeader) {
          MsgFootTips.access$100(this.this$0).sendEmptyMessage(-10001);
        } else {
          MsgFootTips.access$100(this.this$0).sendEmptyMessage(-10000);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgFootTips.1
 * JD-Core Version:    0.7.0.1
 */