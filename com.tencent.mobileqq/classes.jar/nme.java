import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo;
import com.tencent.biz.qqstory.playmode.util.BatchGetVideoInfo.VideoLocalCacheFilter;

public class nme
  implements BatchGetVideoInfo.VideoLocalCacheFilter
{
  public nme(BatchGetVideoInfo paramBatchGetVideoInfo) {}
  
  public boolean a(@NonNull StoryVideoItem paramStoryVideoItem)
  {
    return (!StoryVideoItem.isPlayable(paramStoryVideoItem.mVid, true)) || (TextUtils.isEmpty(paramStoryVideoItem.mOwnerUid)) || (paramStoryVideoItem.mVideoIndex == 0L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nme
 * JD-Core Version:    0.7.0.1
 */