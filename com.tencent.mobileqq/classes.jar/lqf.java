import com.tencent.biz.pubaccount.readinjoy.model.ArticleInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.DislikeResult;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class lqf
  implements Runnable
{
  public lqf(ArticleInfoModule paramArticleInfoModule, int paramInt, List paramList) {}
  
  public void run()
  {
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.jdField_a_of_type_JavaUtilList = this.jdField_a_of_type_JavaUtilList;
    Object localObject;
    if (this.jdField_a_of_type_JavaUtilList != null)
    {
      localObject = this.jdField_a_of_type_JavaUtilList.iterator();
      while (((Iterator)localObject).hasNext())
      {
        DislikeResult localDislikeResult = (DislikeResult)((Iterator)localObject).next();
        if (localDislikeResult.jdField_a_of_type_Int != 0) {
          QLog.e("ArticleInfoModule", 2, "dislike fail ,articleID : " + localDislikeResult.jdField_a_of_type_Long + ", failCode : " + localDislikeResult.jdField_a_of_type_Int + ",fialMessage : " + localDislikeResult.jdField_a_of_type_JavaLangString);
        }
      }
    }
    if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelArticleInfoModule.jdField_a_of_type_Int == 0)
    {
      localObject = new StringBuilder().append("dislike upload successful ! count : ");
      if (this.jdField_a_of_type_JavaUtilList == null) {
        break label175;
      }
    }
    label175:
    for (int i = this.jdField_a_of_type_JavaUtilList.size();; i = 0)
    {
      QLog.d("ArticleInfoModule", 2, i);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lqf
 * JD-Core Version:    0.7.0.1
 */