import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class psz
  implements View.OnClickListener
{
  psz(psx parampsx, long paramLong, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    String str = oyu.g + bhkv.encodeToString(String.valueOf(this.jdField_a_of_type_Long).getBytes(), 2);
    ozs.a(psx.a(this.jdField_a_of_type_Psx), str);
    psx.a(1, ozs.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     psz
 * JD-Core Version:    0.7.0.1
 */