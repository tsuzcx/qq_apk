import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.child.MsgTabPlayMode.StoryVideoPublishStatusReceiver;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.VideoLocalCacheFilter;

public class njv
  implements BatchGetVideoInfo.VideoLocalCacheFilter
{
  public njv(MsgTabPlayMode.StoryVideoPublishStatusReceiver paramStoryVideoPublishStatusReceiver) {}
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return paramStoryVideoItem.mVideoIndex <= 0L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     njv
 * JD-Core Version:    0.7.0.1
 */