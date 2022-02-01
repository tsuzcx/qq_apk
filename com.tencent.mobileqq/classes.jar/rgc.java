import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentComment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rgc
  implements View.OnClickListener
{
  public rgc(ComponentComment paramComponentComment, String paramString, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    pkh.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment.getContext(), this.jdField_a_of_type_JavaLangString);
    qkw.a(1, pqw.b(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     rgc
 * JD-Core Version:    0.7.0.1
 */