package cooperation.qzone.contentbox;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.utils.JumpAction;
import com.tencent.mobileqq.utils.JumpParser;
import cooperation.qzone.contentbox.model.MQBottomCell;

class MsgMoreViewV2$1
  implements View.OnClickListener
{
  MsgMoreViewV2$1(MsgMoreViewV2 paramMsgMoreViewV2, MQBottomCell paramMQBottomCell) {}
  
  public void onClick(View paramView)
  {
    paramView = JumpParser.a(MsgMoreViewV2.access$000(this.this$0), MsgMoreViewV2.access$100(this.this$0), this.val$bottomCell.jumpUrl);
    if (paramView != null) {
      paramView.a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.contentbox.MsgMoreViewV2.1
 * JD-Core Version:    0.7.0.1
 */