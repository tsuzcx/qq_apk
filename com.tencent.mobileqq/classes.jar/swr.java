import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.storyHome.memory.model.VideoCollectionItem;
import com.tribe.async.dispatch.Dispatcher;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class swr
  implements slx<szh, tbf>
{
  public void a(String paramString)
  {
    paramString = new szh(paramString);
    slv.a().a(paramString, this);
  }
  
  public void a(@NonNull szh paramszh, @Nullable tbf paramtbf, @NonNull ErrorMessage paramErrorMessage)
  {
    urk.c("Q.qqstory.player:DeleteStoryVideoHandler", "delete story video return:" + paramErrorMessage);
    paramtbf = (sqd)sqg.a(5);
    spl localspl = new spl(paramErrorMessage, paramszh.a, false);
    StoryVideoItem localStoryVideoItem = paramtbf.a(paramszh.a);
    if (localStoryVideoItem != null)
    {
      localspl.b = localStoryVideoItem.mOwnerUid;
      localspl.a = localStoryVideoItem.mVideoIndex;
      if (localspl.a == 0L) {
        localspl.a = localStoryVideoItem.mCreateTime;
      }
    }
    if (paramErrorMessage.isFail())
    {
      sgi.a().dispatch(localspl);
      return;
    }
    b(paramszh.a);
    paramtbf.a(paramszh.a);
    sgi.a().dispatch(localspl);
  }
  
  protected void b(String paramString)
  {
    long l = System.currentTimeMillis();
    swt localswt = new swt(0);
    spt localspt = (spt)sqg.a(19);
    Object localObject = ((sqd)sqg.a(5)).a(paramString);
    if (localObject == null) {
      return;
    }
    localObject = localspt.a(((StoryVideoItem)localObject).mOwnerUid, null, 2147483647L);
    if ((localObject == null) || (((List)localObject).size() == 0))
    {
      sgi.a().dispatch(localswt);
      return;
    }
    Collections.sort((List)localObject, new uhi());
    Iterator localIterator = ((List)localObject).iterator();
    localObject = null;
    VideoCollectionItem localVideoCollectionItem;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localVideoCollectionItem = (VideoCollectionItem)localIterator.next();
        if (localVideoCollectionItem.collectionType == 0) {
          localObject = localVideoCollectionItem;
        } else {
          if (!localVideoCollectionItem.videoVidList.contains(paramString)) {
            break;
          }
        }
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0)
      {
        sgi.a().dispatch(localswt);
        return;
      }
      if (localObject != null)
      {
        ((VideoCollectionItem)localObject).collectionCount -= 1;
        if (((VideoCollectionItem)localObject).collectionCount <= 0)
        {
          localspt.a((VideoCollectionItem)localObject);
          localswt.a.add(new sws(1, (VideoCollectionItem)localObject));
        }
      }
      else
      {
        localVideoCollectionItem.collectionCount -= 1;
        localVideoCollectionItem.videoVidList.remove(paramString);
        localVideoCollectionItem.collectionVideoUIItemList.remove(new uhj(paramString, null));
        if (localVideoCollectionItem.collectionCount > 0) {
          break label373;
        }
        localspt.a(localVideoCollectionItem);
        localswt.a.add(new sws(1, localVideoCollectionItem));
      }
      for (;;)
      {
        urk.d("Q.qqstory.player:DeleteStoryVideoHandler", String.format("Spend time = %d , %s", new Object[] { Long.valueOf(System.currentTimeMillis() - l), localswt }));
        sgi.a().dispatch(localswt);
        return;
        localspt.a((VideoCollectionItem)localObject);
        localswt.a.add(new sws(2, (VideoCollectionItem)localObject));
        break;
        label373:
        localspt.a(localVideoCollectionItem);
        localswt.a.add(new sws(2, localVideoCollectionItem));
      }
      break;
      localVideoCollectionItem = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     swr
 * JD-Core Version:    0.7.0.1
 */