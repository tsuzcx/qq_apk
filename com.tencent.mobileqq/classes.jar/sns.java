import android.view.View;
import com.tencent.biz.qqstory.storyHome.detail.view.StoryDetailActivity;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;

class sns
  extends soe
{
  sns(snr paramsnr) {}
  
  public void onClick(View paramView)
  {
    int i;
    if ((!this.a.jdField_a_of_type_Boolean) && (this.a.jdField_a_of_type_AndroidAppActivity != null))
    {
      paramView = (snf)this.a.a();
      if (snr.a(this.a) != 11) {
        break label138;
      }
      i = 211;
    }
    for (;;)
    {
      StoryDetailActivity.a(this.a.jdField_a_of_type_AndroidAppActivity, this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId, i, 0);
      i = urp.b(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem);
      urp.a("home_page", "clk_like_more", urp.a(this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem), 0, new String[] { String.valueOf(i), urp.a(paramView.a), "", this.a.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.feedId });
      return;
      label138:
      if (snr.a(this.a) == 12) {
        i = 222;
      } else {
        i = 210;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     sns
 * JD-Core Version:    0.7.0.1
 */