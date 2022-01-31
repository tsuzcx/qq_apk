import com.tencent.biz.qqstory.model.StoryManager;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;

public class ngs
  implements Runnable
{
  public ngs(StoryManager paramStoryManager, String paramString) {}
  
  public void run()
  {
    StoryVideoItem localStoryVideoItem = this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(this.jdField_a_of_type_JavaLangString);
    if (localStoryVideoItem != null)
    {
      localStoryVideoItem.mHadRead = 1;
      this.jdField_a_of_type_ComTencentBizQqstoryModelStoryManager.a(this.jdField_a_of_type_JavaLangString, localStoryVideoItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ngs
 * JD-Core Version:    0.7.0.1
 */