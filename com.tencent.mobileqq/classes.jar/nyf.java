import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nyf
  implements DialogInterface.OnClickListener
{
  public nyf(StoryListPresenter paramStoryListPresenter) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    StoryReportor.a("home_page", "guide_known", 0, 0, new String[0]);
    paramDialogInterface.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyf
 * JD-Core Version:    0.7.0.1
 */