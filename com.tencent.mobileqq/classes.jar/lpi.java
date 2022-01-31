import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ChannelTopCookie;
import java.util.Iterator;
import java.util.List;

public class lpi
  implements Runnable
{
  public lpi(ArticleInfoModule paramArticleInfoModule, List paramList) {}
  
  public void run()
  {
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0))
    {
      Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        ChannelTopCookie localChannelTopCookie = (ChannelTopCookie)localIterator.next();
        this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(localChannelTopCookie);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpi
 * JD-Core Version:    0.7.0.1
 */