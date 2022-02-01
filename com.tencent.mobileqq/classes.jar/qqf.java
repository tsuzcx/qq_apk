import android.content.Context;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class qqf
  implements View.OnClickListener
{
  qqf(qqe paramqqe, qfw paramqfw, Context paramContext, int paramInt) {}
  
  public void onClick(View paramView)
  {
    qrs.a(this.jdField_a_of_type_Qfw.a(), this.jdField_a_of_type_AndroidContentContext);
    ArticleInfo localArticleInfo = this.jdField_a_of_type_Qfw.a();
    String str1 = String.valueOf(ppe.a(this.jdField_a_of_type_Qfw.a(), this.jdField_a_of_type_Int));
    String str2 = pqf.a(localArticleInfo.mAlgorithmID, pqw.a(localArticleInfo), 70, 0, 0, NetworkUtil.isWifiConnected(this.jdField_a_of_type_AndroidContentContext), str1, null, localArticleInfo.innerUniqueID, null, localArticleInfo);
    olh.a(null, str1, "0X8009355", "0X8009355", 0, 0, localArticleInfo.mFeedId + "", String.valueOf(localArticleInfo.businessId), String.valueOf(localArticleInfo.mAlgorithmID), str2, false);
    uvs.a(localArticleInfo);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qqf
 * JD-Core Version:    0.7.0.1
 */