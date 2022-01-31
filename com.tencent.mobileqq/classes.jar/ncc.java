import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import java.util.Comparator;

class ncc
  implements Comparator
{
  ncc(ncb paramncb) {}
  
  public int a(StoryVideoItem paramStoryVideoItem1, StoryVideoItem paramStoryVideoItem2)
  {
    if (paramStoryVideoItem1.mCreateTime > paramStoryVideoItem2.mCreateTime) {
      return 1;
    }
    if (paramStoryVideoItem1.mCreateTime < paramStoryVideoItem2.mCreateTime) {
      return -1;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ncc
 * JD-Core Version:    0.7.0.1
 */