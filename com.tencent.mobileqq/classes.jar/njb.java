import android.os.Vibrator;
import com.tencent.biz.qqstory.msgTabNode.view.MsgTabStoryNodeListManager;

public class njb
  implements Runnable
{
  public njb(MsgTabStoryNodeListManager paramMsgTabStoryNodeListManager) {}
  
  public void run()
  {
    MsgTabStoryNodeListManager.a(this.a).vibrate(20L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njb
 * JD-Core Version:    0.7.0.1
 */