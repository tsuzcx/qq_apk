import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.troop.model.TroopStorySingleVideoSynchronizer;
import java.util.Collections;

public class osl
  implements Runnable
{
  public osl(TroopStorySingleVideoSynchronizer paramTroopStorySingleVideoSynchronizer, StoryVideoItem paramStoryVideoItem) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizQqstoryTroopModelTroopStorySingleVideoSynchronizer.a(Collections.singletonList(this.jdField_a_of_type_ComTencentBizQqstoryModelItemStoryVideoItem), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     osl
 * JD-Core Version:    0.7.0.1
 */