import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyConstants;
import com.tencent.biz.pubaccount.readinjoy.common.ReadInJoyUtils;
import com.tencent.biz.pubaccount.readinjoy.presenter.ReadInJoyHeaderPresenter;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.utils.Base64Util;

public class lvu
  implements View.OnClickListener
{
  public lvu(ReadInJoyHeaderPresenter paramReadInJoyHeaderPresenter, String paramString, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    paramView = ReadInJoyConstants.f + Base64Util.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 2);
    ReadInJoyUtils.a(ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter), paramView);
    ReadInJoyHeaderPresenter.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyPresenterReadInJoyHeaderPresenter, ReadInJoyUtils.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     lvu
 * JD-Core Version:    0.7.0.1
 */