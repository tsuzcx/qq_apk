import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class lwb
  implements Runnable
{
  lwb(lwa paramlwa) {}
  
  public void run()
  {
    ReadInJoyLogicEngine.a().a((int)OnTopicRecommendHeaderFollowClickListener.a(this.a.a).businessId, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lwb
 * JD-Core Version:    0.7.0.1
 */