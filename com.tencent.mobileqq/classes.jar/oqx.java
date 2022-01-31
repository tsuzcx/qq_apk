import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.view.widget.LeftTabBarView;

public class oqx
  implements View.OnClickListener
{
  public oqx(LeftTabBarView paramLeftTabBarView, int paramInt) {}
  
  public void onClick(View paramView)
  {
    long l = System.currentTimeMillis();
    if (l - LeftTabBarView.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView) < 500L) {
      return;
    }
    LeftTabBarView.a(this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView, l);
    this.jdField_a_of_type_ComTencentBizQqstoryViewWidgetLeftTabBarView.setSelectedTab(this.jdField_a_of_type_Int, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oqx
 * JD-Core Version:    0.7.0.1
 */