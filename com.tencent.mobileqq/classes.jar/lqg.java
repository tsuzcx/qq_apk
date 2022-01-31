import com.tencent.biz.pubaccount.readinjoy.model.ArticleReadInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleReadInfo;
import java.util.Iterator;
import java.util.List;

public class lqg
  implements Runnable
{
  public lqg(ArticleReadInfoModule paramArticleReadInfoModule, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ArticleReadInfo localArticleReadInfo = (ArticleReadInfo)localIterator.next();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleReadInfoModule.a(localArticleReadInfo);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqg
 * JD-Core Version:    0.7.0.1
 */