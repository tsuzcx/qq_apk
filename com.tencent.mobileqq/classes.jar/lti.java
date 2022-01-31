import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyLogicEngineEventDispatcher;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import java.util.List;

public class lti
  implements Runnable
{
  public lti(ArticleInfoModule paramArticleInfoModule, boolean paramBoolean, int paramInt, List paramList) {}
  
  public void run()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a(this.jdField_a_of_type_Int, this.jdField_a_of_type_JavaUtilList);
    List localList = ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, this.jdField_a_of_type_JavaUtilList);
    ReadInJoyLogicEngineEventDispatcher.a().c(this.jdField_a_of_type_Int, localList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lti
 * JD-Core Version:    0.7.0.1
 */