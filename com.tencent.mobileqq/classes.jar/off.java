import com.tencent.biz.qqstory.storyHome.qqstorylist.view.segment.FeedSegment;
import com.tencent.mobileqq.msf.sdk.handler.INetInfoHandler;

public class off
  implements INetInfoHandler
{
  public off(FeedSegment paramFeedSegment) {}
  
  public void onNetMobile2None()
  {
    FeedSegment.b(this.a, FeedSegment.a(3));
  }
  
  public void onNetMobile2Wifi(String paramString)
  {
    FeedSegment.b(this.a, FeedSegment.a(1));
  }
  
  public void onNetNone2Mobile(String paramString)
  {
    FeedSegment.b(this.a, FeedSegment.a(2));
  }
  
  public void onNetNone2Wifi(String paramString)
  {
    FeedSegment.b(this.a, FeedSegment.a(1));
  }
  
  public void onNetWifi2Mobile(String paramString)
  {
    FeedSegment.b(this.a, FeedSegment.a(2));
  }
  
  public void onNetWifi2None()
  {
    FeedSegment.b(this.a, FeedSegment.a(3));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     off
 * JD-Core Version:    0.7.0.1
 */