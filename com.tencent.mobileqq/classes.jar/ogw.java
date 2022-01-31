import com.tencent.biz.qqstory.takevideo.EditVideoTag;
import com.tencent.biz.qqstory.takevideo.tag.EditVideoTagPresenter;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import java.util.List;

public class ogw
  implements AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = 0;
  
  public ogw(EditVideoTag paramEditVideoTag) {}
  
  public void a(AbsListView paramAbsListView, int paramInt)
  {
    if ((paramInt == 0) && (this.jdField_a_of_type_Int == EditVideoTag.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag, EditVideoTag.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag)).a().size()) && (!EditVideoTag.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag, EditVideoTag.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag)).a()))
    {
      paramAbsListView = EditVideoTag.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag);
      EditVideoTag.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag, EditVideoTag.a(this.jdField_a_of_type_ComTencentBizQqstoryTakevideoEditVideoTag)).b(paramAbsListView);
    }
  }
  
  public void a(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3)
  {
    this.jdField_a_of_type_Int = (paramInt1 + paramInt2 - 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogw
 * JD-Core Version:    0.7.0.1
 */