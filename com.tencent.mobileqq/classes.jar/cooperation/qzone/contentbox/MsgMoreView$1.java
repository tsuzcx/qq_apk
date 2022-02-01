package cooperation.qzone.contentbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qzone.contentbox.model.MsgOnClickListener;

class MsgMoreView$1
  implements View.OnClickListener
{
  MsgMoreView$1(MsgMoreView paramMsgMoreView) {}
  
  public void onClick(View paramView)
  {
    if (MsgMoreView.access$000(this.this$0) != null) {
      MsgMoreView.access$000(this.this$0).onClick(MsgMoreView.access$100(this.this$0), paramView, 5);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgMoreView.1
 * JD-Core Version:    0.7.0.1
 */