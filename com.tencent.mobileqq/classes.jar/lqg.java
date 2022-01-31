import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.persistence.EntityManager;

public class lqg
  implements Runnable
{
  public lqg(ArticleInfoModule paramArticleInfoModule, int paramInt) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a.b("DELETE FROM " + ArticleInfo.class.getSimpleName() + " WHERE mChannelID = " + this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqg
 * JD-Core Version:    0.7.0.1
 */