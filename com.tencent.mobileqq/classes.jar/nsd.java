import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.qqstory.comment.StoryInputBarView;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController;
import com.tencent.biz.qqstory.storyHome.QQStoryMainController.QQStoryMainView;
import com.tencent.biz.qqstory.storyHome.StoryHomePushYellowBarHandler;

public class nsd
  implements Runnable
{
  public nsd(QQStoryMainController paramQQStoryMainController) {}
  
  public void run()
  {
    if (QQStoryMainController.a(this.a)) {
      return;
    }
    this.a.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView = this.a.a();
    this.a.jdField_a_of_type_ComTencentBizQqstoryCommentStoryInputBarView.setInputViewHideListener(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView);
    this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeStoryHomePushYellowBarHandler.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, this.a.a(), this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQqstorylistViewMystoryListView);
    QQStoryMainController.a(this.a, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$QQStoryMainView.a());
    QQStoryMainController.a(this.a, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeQQStoryMainController$QQStoryMainView.a());
    QQStoryMainController.a(this.a).setVisibility(8);
    QQStoryMainController.a(this.a).setVisibility(8);
    QQStoryMainController.a(this.a.jdField_a_of_type_AndroidAppActivity, "mainHallConfig", QQStoryMainController.a(this.a), QQStoryMainController.a(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nsd
 * JD-Core Version:    0.7.0.1
 */