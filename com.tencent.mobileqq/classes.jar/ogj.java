import com.tencent.biz.qqstory.takevideo.EditVideoPoiSearch;
import com.tencent.biz.qqstory.takevideo.EditVideoUi;
import com.tencent.util.InputMethodUtil;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

public class ogj
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  public ogj(EditVideoPoiSearch paramEditVideoPoiSearch) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if (paramInt == 1) {
      InputMethodUtil.b(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.a().a());
    }
    while ((paramInt != 0) || (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.a == null) || (this.jdField_a_of_type_Int < this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch.a.size())) {
      return;
    }
    EditVideoPoiSearch.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoiSearch);
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogj
 * JD-Core Version:    0.7.0.1
 */