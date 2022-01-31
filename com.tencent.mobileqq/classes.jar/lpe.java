import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import com.tencent.mobileqq.persistence.EntityManager;
import java.util.List;

public class lpe
  implements Runnable
{
  public lpe(ArticleInfoModule paramArticleInfoModule) {}
  
  public void run()
  {
    List localList = this.a.a.a(ChannelTopCookie.class, true, null, null, null, null, null, null);
    this.a.a(localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpe
 * JD-Core Version:    0.7.0.1
 */