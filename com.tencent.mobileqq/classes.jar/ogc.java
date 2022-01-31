import com.tencent.biz.qqstory.takevideo.EditVideoPoi;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.ArrayList;

public class ogc
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  public ogc(EditVideoPoi paramEditVideoPoi) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.a != null) && (this.jdField_a_of_type_Int == this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.a.size() - 1)) {
      this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoPoi.e();
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1 - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogc
 * JD-Core Version:    0.7.0.1
 */