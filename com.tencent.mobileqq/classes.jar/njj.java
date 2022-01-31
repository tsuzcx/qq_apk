import android.widget.TextView;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeView;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tencent.biz.qqstory.utils.RedPointUtils;

public class njj
  implements Runnable
{
  public njj(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void run()
  {
    int i = RedPointUtils.a(49);
    String str = this.a.a.a.getText().toString();
    SLog.a(MsgTabStoryNodeListManager.a(), "redpoint update, update count = %s->%d", str, Integer.valueOf(i));
    this.a.a.a(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njj
 * JD-Core Version:    0.7.0.1
 */