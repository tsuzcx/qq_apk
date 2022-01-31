import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class lsz
  implements Runnable
{
  lsz(lsy paramlsy) {}
  
  public void run()
  {
    ReadInJoyLogicEngine.a().a((int)OnTopicRecommendHeaderFollowClickListener.a(this.a.a).businessId, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsz
 * JD-Core Version:    0.7.0.1
 */