import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.FeedIdListCache;
import com.tencent.biz.qqstory.storyHome.model.FeedListPageLoaderBase.RequestFeedObserver;
import com.tribe.async.async.ThreadOffFunction;
import com.tribe.async.reactive.Stream;

public class nyl
  implements Runnable
{
  public nyl(FeedListPageLoaderBase paramFeedListPageLoaderBase) {}
  
  public void run()
  {
    if (FeedListPageLoaderBase.a(this.a) != null) {
      FeedListPageLoaderBase.a(this.a).cancel();
    }
    FeedListPageLoaderBase.a(this.a, Stream.of(Integer.valueOf(this.a.a.a)).map(new ThreadOffFunction(2)).map(this.a.a(this.a.a)).map(this.a.a()));
    FeedListPageLoaderBase.a(this.a).subscribe(new FeedListPageLoaderBase.RequestFeedObserver(this.a));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     nyl
 * JD-Core Version:    0.7.0.1
 */