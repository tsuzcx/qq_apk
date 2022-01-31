import android.view.View;
import com.tencent.biz.ui.IPullRefreshHeader;
import com.tencent.biz.ui.RefreshView;
import com.tencent.widget.ListView;
import com.tencent.widget.OverScrollViewListener;

public class oyh
  implements OverScrollViewListener
{
  public oyh(RefreshView paramRefreshView) {}
  
  public void a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int == 2)
    {
      this.a.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.W_();
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.c(0L);
  }
  
  public boolean a(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int != 2)
    {
      RefreshView.a(this.a, false);
      this.a.b(RefreshView.a(this.a));
      this.a.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.a(0L);
      this.a.jdField_a_of_type_Int = 2;
      RefreshView.a(this.a);
    }
    return false;
  }
  
  public void b(int paramInt, View paramView, ListView paramListView)
  {
    if (this.a.jdField_a_of_type_Int != 2) {
      this.a.jdField_a_of_type_ComTencentBizUiIPullRefreshHeader.b(0L);
    }
  }
  
  public void c(int paramInt, View paramView, ListView paramListView)
  {
    this.a.b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     oyh
 * JD-Core Version:    0.7.0.1
 */