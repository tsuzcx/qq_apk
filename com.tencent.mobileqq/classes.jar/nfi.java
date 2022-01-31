import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.widget.calloutpopupwindow.CalloutPopupWindow;

public class nfi
  implements View.OnClickListener
{
  public nfi(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void onClick(View paramView)
  {
    this.a.a.dismiss();
    StoryReportor.a("msg_tab", "clk_tips", 0, 0, new String[] { "1", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nfi
 * JD-Core Version:    0.7.0.1
 */