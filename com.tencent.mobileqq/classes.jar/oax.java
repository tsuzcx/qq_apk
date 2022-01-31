import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.storyHome.discover.view.StoryDiscoverActivity;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class oax
  implements DialogInterface.OnClickListener
{
  public oax(StoryDiscoverActivity paramStoryDiscoverActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return;
    case 0: 
      StoryReportor.a("content_flow", "cancel_hot", 0, 0, new String[0]);
      return;
    }
    this.a.a(false, true, null);
    StoryReportor.a("content_flow", "sure_hot", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oax
 * JD-Core Version:    0.7.0.1
 */