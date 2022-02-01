import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qfy
  implements View.OnClickListener
{
  qfy(qfx paramqfx, pxk parampxk, Context paramContext, int paramInt) {}
  
  public void onClick(View paramView)
  {
    qhk.a(this.jdField_a_of_type_Pxk.a(), this.jdField_a_of_type_AndroidContentContext);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Pxk.a();
    String str1 = String.valueOf(pha.a(this.jdField_a_of_type_Pxk.a(), this.jdField_a_of_type_Int));
    String str2 = pha.a(localArticleInfo.mAlgorithmID, pha.a(localArticleInfo), 70, 0, 0, bgnt.h(this.jdField_a_of_type_AndroidContentContext), str1, null, localArticleInfo.innerUniqueID, null, localArticleInfo);
    oat.a(null, str1, "0X8009355", "0X8009355", 0, 0, localArticleInfo.mFeedId + "", String.valueOf(localArticleInfo.businessId), String.valueOf(localArticleInfo.mAlgorithmID), str2, false);
    ube.a(localArticleInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qfy
 * JD-Core Version:    0.7.0.1
 */