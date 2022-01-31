import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.util.QLog;

public class lpg
  implements Runnable
{
  public lpg(ArticleInfoModule paramArticleInfoModule, ArticleInfo paramArticleInfo) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo)) {
      QLog.d("ArticleInfoModule", 2, "delete article fail ! title : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mTitle + " , articleID : " + this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mArticleID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lpg
 * JD-Core Version:    0.7.0.1
 */