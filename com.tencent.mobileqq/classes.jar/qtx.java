import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.rebuild.cmp.ComponentComment;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class qtx
  implements View.OnClickListener
{
  public qtx(ComponentComment paramComponentComment, String paramString, ArticleInfo paramArticleInfo) {}
  
  public void onClick(View paramView)
  {
    pay.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyRebuildCmpComponentComment.getContext(), this.jdField_a_of_type_JavaLangString);
    pyr.a(1, pay.d(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo));
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qtx
 * JD-Core Version:    0.7.0.1
 */