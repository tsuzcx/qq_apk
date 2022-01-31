import android.view.View;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;

public class oeo
  implements Runnable
{
  public oeo(MystoryListView paramMystoryListView) {}
  
  public void run()
  {
    MystoryListView.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oeo
 * JD-Core Version:    0.7.0.1
 */