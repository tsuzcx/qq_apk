package cooperation.qzone.contentbox.model;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class MsgNewGuideCardView$2
  implements View.OnClickListener
{
  MsgNewGuideCardView$2(MsgNewGuideCardView paramMsgNewGuideCardView, MsgOnClickListener paramMsgOnClickListener) {}
  
  public void onClick(View paramView)
  {
    this.val$listener.onClick(MsgNewGuideCardView.access$000(this.this$0), MsgNewGuideCardView.access$200(this.this$0), 7);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.contentbox.model.MsgNewGuideCardView.2
 * JD-Core Version:    0.7.0.1
 */