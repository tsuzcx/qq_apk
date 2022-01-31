import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyFooterPresenter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.utils.Base64Util;

public class lsi
  implements View.OnClickListener
{
  public lsi(ReadInJoyFooterPresenter paramReadInJoyFooterPresenter, long paramLong, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = ReadInJoyConstants.f + Base64Util.encodeToString(String.valueOf(this.jdField_a_of_type_Long).getBytes(), 2);
    ReadInJoyUtils.a(ReadInJoyFooterPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyFooterPresenter), paramView);
    ReadInJoyFooterPresenter.a(1, ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lsi
 * JD-Core Version:    0.7.0.1
 */