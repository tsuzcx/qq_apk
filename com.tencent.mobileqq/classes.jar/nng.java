import android.support.annotation.NonNull;
import com.tencent.biz.qqstory.model.DeleteStoryVideoEvent;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.model.BasePagePlayingListSync;
import com.tencent.biz.qqstory.support.logging.SLog;
import com.tribe.async.dispatch.QQUIEventReceiver;
import java.util.Iterator;
import java.util.List;

public class nng
  extends QQUIEventReceiver
{
  public nng(@NonNull BasePagePlayingListSync paramBasePagePlayingListSync)
  {
    super(paramBasePagePlayingListSync);
  }
  
  public void a(@NonNull BasePagePlayingListSync paramBasePagePlayingListSync, @NonNull DeleteStoryVideoEvent paramDeleteStoryVideoEvent)
  {
    Iterator localIterator = paramBasePagePlayingListSync.a.iterator();
    int i = 0;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        StoryVideoItem localStoryVideoItem = (StoryVideoItem)localIterator.next();
        if (paramDeleteStoryVideoEvent.a.equals(localStoryVideoItem.mVid))
        {
          paramBasePagePlayingListSync.a.remove(i);
          SLog.a("Q.qqstory.player.DefaultPlayerVideoListSynchronizer", "remove vid:%s", localStoryVideoItem.mVid);
        }
      }
      else
      {
        return;
      }
      i += 1;
    }
  }
  
  public Class acceptEventClass()
  {
    return DeleteStoryVideoEvent.class;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nng
 * JD-Core Version:    0.7.0.1
 */