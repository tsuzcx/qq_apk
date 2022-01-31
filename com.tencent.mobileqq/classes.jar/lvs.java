import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngine;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentHeaderTopicRecommend;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

class lvs
  implements Runnable
{
  lvs(lvr paramlvr) {}
  
  public void run()
  {
    ReadInJoyLogicEngine.a().a((int)ComponentHeaderTopicRecommend.a(this.a.a).businessId, 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lvs
 * JD-Core Version:    0.7.0.1
 */