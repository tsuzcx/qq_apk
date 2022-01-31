import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.storyHome.qqstorylist.presenter.StoryListPresenter;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.widget.GuideInfoDialog;
import com.tencent.biz.qqstory.support.report.StoryReportor;

public class nyh
  implements View.OnClickListener
{
  public nyh(StoryListPresenter paramStoryListPresenter, GuideInfoDialog paramGuideInfoDialog) {}
  
  public void onClick(View paramView)
  {
    StoryReportor.a("home_page", "guide_close", 0, 0, new String[0]);
    this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewWidgetGuideInfoDialog.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyh
 * JD-Core Version:    0.7.0.1
 */