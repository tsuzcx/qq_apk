import android.view.ViewGroup;
import android.widget.ListView;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.FaceListPage;
import com.tencent.biz.qqstory.takevideo.doodle.ui.face.adapter.BaseFaceListAdapter;

public class oke
  implements Runnable
{
  public oke(FaceListPage paramFaceListPage) {}
  
  public void run()
  {
    FaceListPage.a(this.a).setVisibility(4);
    FaceListPage.b(this.a).setVisibility(4);
    FaceListPage.a(this.a).setVisibility(0);
    FaceListPage.a(this.a).notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oke
 * JD-Core Version:    0.7.0.1
 */