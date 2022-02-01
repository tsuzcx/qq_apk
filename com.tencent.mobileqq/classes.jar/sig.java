import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup;
import com.tencent.biz.pubaccount.readinjoy.view.ReadInJoyListViewGroup.35.1;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import java.util.HashMap;
import mqq.os.MqqHandler;
import pb.unite.search.RequestSearchWord.Rcmd;

public class sig
  implements aokh
{
  public sig(ReadInJoyListViewGroup paramReadInJoyListViewGroup, ArticleInfo paramArticleInfo, int paramInt1, int paramInt2) {}
  
  public void a(PBRepeatMessageField<RequestSearchWord.Rcmd> paramPBRepeatMessageField, PBStringField paramPBStringField)
  {
    if ((paramPBRepeatMessageField == null) || (paramPBRepeatMessageField.size() <= 0)) {
      return;
    }
    if (ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).containsKey(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRefreshTime)) {
      ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).put(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRefreshTime, Integer.valueOf(this.jdField_a_of_type_Int + 1));
    }
    for (;;)
    {
      bhsi.a("search_word_prefix_show_times", bhsi.b("search_word_prefix_show_times") + 1L);
      ThreadManager.getUIHandler().post(new ReadInJoyListViewGroup.35.1(this, paramPBRepeatMessageField, paramPBStringField));
      return;
      ReadInJoyListViewGroup.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewReadInJoyListViewGroup).put(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mRefreshTime, Integer.valueOf(1));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     sig
 * JD-Core Version:    0.7.0.1
 */