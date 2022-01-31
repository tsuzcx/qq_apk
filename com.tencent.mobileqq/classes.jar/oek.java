import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.qqstory.model.lbs.LbsManager.POIListRequestSession;
import com.tencent.biz.qqstory.takevideo.EditVideoPoi;
import com.tencent.mobileqq.activity.Contacts.OverScrollViewTag;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.PullRefreshHeader;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class oek
  implements OverScrollViewListener
{
  public oek(EditVideoPoi paramEditVideoPoi) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.c(l);
      return;
    }
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    paramListView = (PullRefreshHeader)paramView;
    long l;
    if (this.a.jdField_a_of_type_Long == 0L)
    {
      l = System.currentTimeMillis();
      paramListView.a(l);
      if (!NetworkUtil.g(this.a.a())) {
        break label118;
      }
      if (this.a.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession != null) {
        this.a.jdField_a_of_type_ComTencentBizQqstoryModelLbsLbsManager$POIListRequestSession.a();
      }
      this.a.e();
      new Handler(Looper.getMainLooper()).postDelayed(new oel(this), 300L);
    }
    for (;;)
    {
      ((Contacts.OverScrollViewTag)paramView.getTag()).a = true;
      return true;
      l = this.a.jdField_a_of_type_Long;
      break;
      label118:
      new Handler(Looper.getMainLooper()).postDelayed(new oem(this), 300L);
    }
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    paramView = (PullRefreshHeader)paramView;
    if (this.a.jdField_a_of_type_Long == 0L) {}
    for (long l = System.currentTimeMillis();; l = this.a.jdField_a_of_type_Long)
    {
      paramView.b(l);
      return;
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oek
 * JD-Core Version:    0.7.0.1
 */