import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class psy
  implements View.OnClickListener
{
  psy(psx parampsx, String paramString, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    ozs.a(psx.a(this.jdField_a_of_type_Psx), this.jdField_a_of_type_JavaLangString);
    psx.a(1, ozs.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psy
 * JD-Core Version:    0.7.0.1
 */