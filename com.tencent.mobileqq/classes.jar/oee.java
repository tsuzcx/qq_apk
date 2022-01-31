import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.IMyStoryListView;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class oee
  implements DialogInterface.OnClickListener
{
  public oee(StoryListPresenter paramStoryListPresenter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.a(false, true, 12, null);
    StoryReportor.a("home_page", "guide_open", 0, 0, new String[0]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oee
 * JD-Core Version:    0.7.0.1
 */