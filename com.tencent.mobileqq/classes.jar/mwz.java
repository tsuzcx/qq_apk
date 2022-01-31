import com.tencent.biz.PoiMapActivity;
import com.tencent.widget.AbsListView;

class mwz
  implements bfos
{
  mwz(mwx parammwx, PoiMapActivity paramPoiMapActivity) {}
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (paramAbsListView.getLastVisiblePosition() == paramAbsListView.getCount() - 1) && (this.jdField_a_of_type_Mwx.jdField_a_of_type_Mwu.b))
    {
      this.jdField_a_of_type_Mwx.b(false);
      if (!PoiMapActivity.b(this.jdField_a_of_type_Mwx.jdField_a_of_type_ComTencentBizPoiMapActivity)) {
        this.jdField_a_of_type_Mwx.jdField_a_of_type_ComTencentBizPoiMapActivity.a("share_locate", "turn_page", this.jdField_a_of_type_Mwx.jdField_a_of_type_ComTencentBizPoiMapActivity.f, this.jdField_a_of_type_Mwx.jdField_a_of_type_ComTencentBizPoiMapActivity.e, "", "");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mwz
 * JD-Core Version:    0.7.0.1
 */