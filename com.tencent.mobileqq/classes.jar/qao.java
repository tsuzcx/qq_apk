import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qao
  implements View.OnClickListener
{
  qao(qam paramqam, long paramLong, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    String str = pgc.g + bgku.encodeToString(String.valueOf(this.jdField_a_of_type_Long).getBytes(), 2);
    pha.a(qam.a(this.jdField_a_of_type_Qam), str);
    qam.a(1, pha.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qao
 * JD-Core Version:    0.7.0.1
 */