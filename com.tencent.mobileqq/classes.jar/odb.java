import com.tencent.biz.qqstory.model.CommentManager;
import com.tencent.biz.qqstory.model.LikeManager;
import com.tencent.biz.qqstory.model.SuperManager;
import com.tencent.biz.qqstory.storyHome.model.FeedItem;
import com.tencent.biz.qqstory.storyHome.model.FeedManager;
import com.tencent.biz.qqstory.support.logging.SLog;
import java.util.ArrayList;

public final class odb
  implements Runnable
{
  public odb(String paramString) {}
  
  public void run()
  {
    Object localObject = (LikeManager)SuperManager.a(15);
    ((LikeManager)localObject).a(new ArrayList(0), this.a, false, true);
    ((LikeManager)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (CommentManager)SuperManager.a(17);
    ((CommentManager)localObject).a(new ArrayList(0), this.a, false, true);
    ((CommentManager)localObject).a(new ArrayList(0), this.a, true, true);
    localObject = (FeedManager)SuperManager.a(11);
    FeedItem localFeedItem = ((FeedManager)localObject).a(this.a);
    localFeedItem.reset();
    ((FeedManager)localObject).a(localFeedItem);
    SLog.a("Q.qqstory.home.data.FeedManager", "clear all feed interactive data %s", this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     odb
 * JD-Core Version:    0.7.0.1
 */