import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pti
  implements View.OnClickListener
{
  pti(ptf paramptf, String paramString, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    String str = oyu.g + bhkv.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 2);
    ozs.a(ptf.a(this.jdField_a_of_type_Ptf), str);
    ptf.a(this.jdField_a_of_type_Ptf, ozs.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pti
 * JD-Core Version:    0.7.0.1
 */