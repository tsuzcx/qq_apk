import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.proteus.listeners.OnTopicRecommendHeaderFollowClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class lso
  implements Runnable
{
  lso(lsn paramlsn) {}
  
  public void run()
  {
    ReadInJoyLogicEngine.a().a((int)OnTopicRecommendHeaderFollowClickListener.a(this.a.a).businessId, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lso
 * JD-Core Version:    0.7.0.1
 */