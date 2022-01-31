import android.view.View;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class tal
  extends tax
{
  tal(tak paramtak) {}
  
  public void onClick(View paramView)
  {
    int i;
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_AndroidAppActivity != null))
    {
      paramView = (szy)this.a.a();
      if (tak.a(this.a) != 11) {
        break label138;
      }
      i = 211;
    }
    for (;;)
    {
      StoryDetailActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
      i = vei.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      vei.a("home_page", "clk_like_more", vei.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), vei.a(paramView.a), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      label138:
      if (tak.a(this.a) == 12) {
        i = 222;
      } else {
        i = 210;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tal
 * JD-Core Version:    0.7.0.1
 */