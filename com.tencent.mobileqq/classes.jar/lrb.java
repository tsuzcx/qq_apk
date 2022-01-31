import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.model.FastWebModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import java.util.HashMap;
import java.util.List;

public class lrb
  implements Runnable
{
  public lrb(FastWebModule paramFastWebModule, List paramList) {}
  
  public void run()
  {
    int i = 0;
    if (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ArticleInfo localArticleInfo = (ArticleInfo)this.jdField_a_of_type_JavaUtilList.get(i);
      if (ReadInJoyUtils.a(localArticleInfo)) {}
      for (;;)
      {
        i += 1;
        break;
        lrd locallrd = (lrd)FastWebModule.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule).get(localArticleInfo.mChannelID + "_" + localArticleInfo.mArticleID);
        if ((locallrd == null) || (locallrd.a())) {
          this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyModelFastWebModule.a(localArticleInfo.mArticleContentUrl, localArticleInfo.innerUniqueID, localArticleInfo.mSubscribeID, 3, null);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lrb
 * JD-Core Version:    0.7.0.1
 */