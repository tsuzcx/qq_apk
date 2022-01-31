import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import java.util.List;

public class loy
  implements Runnable
{
  public loy(ArticleInfoModule paramArticleInfoModule, List paramList, int paramInt1, int paramInt2, long paramLong, boolean paramBoolean) {}
  
  public void run()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {}
    for (List localList = ArticleInfoModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule, this.jdField_a_of_type_Int, this.b, this.jdField_a_of_type_Long, this.jdField_a_of_type_Boolean); this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a == null; localList = this.jdField_a_of_type_JavaUtilList) {
      return;
    }
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.a.post(new loz(this, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     loy
 * JD-Core Version:    0.7.0.1
 */