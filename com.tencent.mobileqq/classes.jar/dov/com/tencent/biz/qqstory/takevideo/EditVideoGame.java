package dov.com.tencent.biz.qqstory.takevideo;

import android.support.annotation.NonNull;
import bjxl;
import bjxn;
import bkld;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.model.CommentLikeFeedItem;
import com.tencent.mobileqq.app.ThreadManagerV2;
import tcw;
import tcz;
import uvx;

public class EditVideoGame
  extends bjxl
{
  private StoryVideoItem jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem;
  private CommentLikeFeedItem jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem;
  private EditVideoGame.GameResultItem jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGame$GameResultItem;
  
  private boolean b()
  {
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGame$GameResultItem = ((EditVideoGame.GameResultItem)this.jdField_a_of_type_Bjxn.a.a("story_game_result"));
    return this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGame$GameResultItem != null;
  }
  
  private void d()
  {
    if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem == null) || (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mDenyComment == 1))
    {
      this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem = ((CommentLikeFeedItem)((uvx)tcz.a(11)).a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGame$GameResultItem.c));
      if ((this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem != null) && (this.jdField_a_of_type_ComTencentBizQqstoryStoryHomeModelCommentLikeFeedItem.mDenyComment != 1)) {}
    }
    do
    {
      do
      {
        return;
      } while (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null);
      this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem = ((tcw)tcz.a(5)).a(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoEditVideoGame$GameResultItem.d);
    } while (this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem != null);
  }
  
  public void a()
  {
    super.a();
    if (!b()) {
      return;
    }
    ThreadManagerV2.excute(new EditVideoGame.1(this), 32, null, true);
  }
  
  public void a(int paramInt, @NonNull bkld parambkld) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.tencent.biz.qqstory.takevideo.EditVideoGame
 * JD-Core Version:    0.7.0.1
 */