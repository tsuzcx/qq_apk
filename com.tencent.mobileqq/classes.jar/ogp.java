import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.storyHome.square.SquarePresenter;
import com.tencent.biz.qqstory.storyHome.square.SquarePresenter.ISquareView;
import com.tencent.biz.qqstory.storyHome.square.model.SquareFeedData;
import java.util.List;

public class ogp
  implements Runnable
{
  public ogp(SquarePresenter paramSquarePresenter, SquareFeedData paramSquareFeedData) {}
  
  public void run()
  {
    if (SquarePresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareSquarePresenter) == null) {
      return;
    }
    if (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData.errorInfo.isSuccess())
    {
      if (!this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData.jdField_c_of_type_Boolean) {
        break label81;
      }
      SquarePresenter.b(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareSquarePresenter, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData.jdField_c_of_type_JavaUtilList);
      SquarePresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareSquarePresenter, this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData.b);
    }
    for (;;)
    {
      SquarePresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareSquarePresenter).a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData);
      return;
      label81:
      SquarePresenter.a(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareSquarePresenter).addAll(this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeSquareModelSquareFeedData.b);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ogp
 * JD-Core Version:    0.7.0.1
 */