import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.support.report.StoryReportor;
import com.tencent.biz.qqstory.takevideo.TakeVideoButtonMainPart.OnTakeVideoButtonClickListener;

public class nts
  implements TakeVideoButtonMainPart.OnTakeVideoButtonClickListener
{
  public nts(QQStoryMainController paramQQStoryMainController) {}
  
  public void a()
  {
    StoryReportor.a("video_shoot", "clk_shoot", 0, 0, new String[0]);
    this.a.a(false, true, 1, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nts
 * JD-Core Version:    0.7.0.1
 */