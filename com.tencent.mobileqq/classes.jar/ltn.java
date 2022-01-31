import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class ltn
  implements Runnable
{
  public ltn(ArticleReadInfoModule paramArticleReadInfoModule) {}
  
  public void run()
  {
    List localList = this.a.a.a(ArticleReadInfo.class, true, null, null, null, null, null, null);
    ArticleReadInfoModule.a(this.a, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     ltn
 * JD-Core Version:    0.7.0.1
 */