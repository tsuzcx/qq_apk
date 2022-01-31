import android.view.View;
import com.tencent.biz.qqstory.storyHome.qqstorylist.view.MystoryListView;

public class nzz
  implements Runnable
{
  public nzz(MystoryListView paramMystoryListView) {}
  
  public void run()
  {
    MystoryListView.a(this.a).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nzz
 * JD-Core Version:    0.7.0.1
 */