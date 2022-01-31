import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.biz.qqstory.app.QQStoryContext;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;

public class svo
  implements View.OnClickListener
{
  public svo(MsgTabStoryNodeView paramMsgTabStoryNodeView, Context paramContext) {}
  
  public void onClick(View paramView)
  {
    if (this.jdField_a_of_type_ComTencentBizQqstoryMsgTabNodeViewMsgTabStoryNodeView.a.isShown()) {}
    for (int i = 1;; i = 0)
    {
      urp.a("msg_tab", "clk_all", 0, i, new String[0]);
      paramView = bade.a(QQStoryContext.a(), this.jdField_a_of_type_AndroidContentContext, "qqstory://qstory/open?from=msgTab");
      vkw.a(paramView);
      if (paramView != null) {
        paramView.c();
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     svo
 * JD-Core Version:    0.7.0.1
 */