import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qqstory.base.videoupload.StoryVideoUploadManager;
import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.troop.memories.TroopStoryItemInfo;

class olw
  implements View.OnClickListener
{
  olw(olv paramolv, TroopStoryItemInfo paramTroopStoryItemInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = ((StoryManager)SuperManager.a(5)).a(this.jdField_a_of_type_ComTencentBizQqstoryTroopMemoriesTroopStoryItemInfo.storyId);
    if (paramView != null) {
      ((StoryVideoUploadManager)SuperManager.a().b(3)).a(paramView);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     olw
 * JD-Core Version:    0.7.0.1
 */