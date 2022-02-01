import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qax
  implements View.OnClickListener
{
  qax(qau paramqau, String paramString, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    String str = pgc.g + bgku.encodeToString(this.jdField_a_of_type_JavaLangString.getBytes(), 2);
    pha.a(qau.a(this.jdField_a_of_type_Qau), str);
    qau.a(this.jdField_a_of_type_Qau, pha.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qax
 * JD-Core Version:    0.7.0.1
 */