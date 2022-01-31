import android.support.annotation.NonNull;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;

final class shg
  extends psx
{
  shg(int paramInt1, int paramInt2, int paramInt3, String paramString, ArticleInfo paramArticleInfo)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  public void onClick(@NonNull View paramView)
  {
    ors.a(paramView.getContext(), this.jdField_a_of_type_JavaLangString, null);
    if ((this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) && (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.isPGCShortContent()))
    {
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.click_area = 11;
      this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.click_jump_target = pqd.a(this.jdField_a_of_type_JavaLangString, "-1");
      ors.b(paramView.getContext(), this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     shg
 * JD-Core Version:    0.7.0.1
 */