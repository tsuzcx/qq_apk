import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.storyHome.messagenotify.StoryMessageListActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nwm
  implements DialogInterface.OnClickListener
{
  public nwm(StoryMessageListActivity paramStoryMessageListActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.d();
    paramDialogInterface.dismiss();
    StoryReportor.a(this.a.a(), "clk_sure", 0, 0, new String[] { "2", "", "", "" });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nwm
 * JD-Core Version:    0.7.0.1
 */