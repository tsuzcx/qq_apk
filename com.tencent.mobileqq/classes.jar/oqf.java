import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.view.StoryImageDialog;

public class oqf
  implements View.OnClickListener
{
  public oqf(StoryImageDialog paramStoryImageDialog) {}
  
  public void onClick(View paramView)
  {
    StoryReportor.a("home_page", "guide_close", 0, 0, new String[0]);
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqf
 * JD-Core Version:    0.7.0.1
 */