package cooperation.qzone.contentbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import cooperation.qzone.contentbox.model.MQBottomCell;
import cooperation.qzone.contentbox.model.MQMsg;

class MsgNewLargeCardView$2
  implements View.OnClickListener
{
  MsgNewLargeCardView$2(MsgNewLargeCardView paramMsgNewLargeCardView, MQMsg paramMQMsg) {}
  
  public void onClick(View paramView)
  {
    paramView = JumpParser.a(MsgNewLargeCardView.access$100(this.this$0), paramView.getContext(), this.val$message.bottomCell.jumpUrl);
    if (paramView != null) {
      paramView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgNewLargeCardView.2
 * JD-Core Version:    0.7.0.1
 */