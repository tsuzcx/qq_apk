import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class pyj
  implements View.OnClickListener
{
  pyj(pyi parampyi, ppu paramppu, Context paramContext, int paramInt) {}
  
  public void onClick(View paramView)
  {
    pzv.a(this.jdField_a_of_type_Ppu.a(), this.jdField_a_of_type_AndroidContentContext);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Ppu.a();
    String str1 = String.valueOf(ozs.a(this.jdField_a_of_type_Ppu.a(), this.jdField_a_of_type_Int));
    String str2 = ozs.a(localArticleInfo.mAlgorithmID, ozs.a(localArticleInfo), 70, 0, 0, bhnv.h(this.jdField_a_of_type_AndroidContentContext), str1, null, localArticleInfo.innerUniqueID, null, localArticleInfo);
    ocd.a(null, str1, "0X8009355", "0X8009355", 0, 0, localArticleInfo.mFeedId + "", String.valueOf(localArticleInfo.businessId), String.valueOf(localArticleInfo.mAlgorithmID), str2, false);
    ubg.a(localArticleInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pyj
 * JD-Core Version:    0.7.0.1
 */