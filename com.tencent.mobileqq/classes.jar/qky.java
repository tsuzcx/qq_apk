import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qky
  implements View.OnClickListener
{
  qky(qkw paramqkw, long paramLong, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    String str = pjj.g + bhcu.encodeToString(String.valueOf(this.jdField_a_of_type_Long).getBytes(), 2);
    pkh.a(qkw.a(this.jdField_a_of_type_Qkw), str);
    qkw.a(1, pqw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qky
 * JD-Core Version:    0.7.0.1
 */