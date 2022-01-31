import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.PoiMapActivity.PoiItemAdapter;
import com.tencent.biz.PoiMapActivity.PoiTab;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;

public class kju
  implements AbsListView.OnScrollListener
{
  public kju(PoiMapActivity.PoiTab paramPoiTab, PoiMapActivity paramPoiMapActivity) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiItemAdapter.b))
    {
      this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.b(false);
      if (!PoiMapActivity.b(this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity)) {
        this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity.a("share_locate", "turn_page", this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity.f, this.jdField_a_of_type_ComTencentBizPoiMapActivity$PoiTab.jdField_a_of_type_ComTencentBizPoiMapActivity.e, "", "");
      }
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     kju
 * JD-Core Version:    0.7.0.1
 */