import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qlh
  implements View.OnClickListener
{
  qlh(qle paramqle, String paramString, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    String str = pjj.g + bhcu.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 2);
    pkh.a(qle.a(this.jdField_a_of_type_Qle), str);
    qle.a(this.jdField_a_of_type_Qle, pqw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qlh
 * JD-Core Version:    0.7.0.1
 */