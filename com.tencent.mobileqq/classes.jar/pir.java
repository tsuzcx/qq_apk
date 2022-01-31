import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.OnClickListener;
import com.tencent.qphone.base.util.QLog;

public class pir
  implements ViewBase.OnClickListener
{
  private Context jdField_a_of_type_AndroidContentContext;
  private ArticleInfo jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
  
  public pir(Context paramContext, ArticleInfo paramArticleInfo)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramArticleInfo;
  }
  
  public void onClick(ViewBase paramViewBase)
  {
    paramViewBase = bhvh.a("kd_topic_recommend_card_jump_url");
    if ((paramViewBase instanceof String)) {}
    for (paramViewBase = (String)paramViewBase;; paramViewBase = "")
    {
      if (QLog.isColorLevel()) {
        QLog.d("OnJumpWrapperClickListener", 2, new Object[] { "jumpUrl = ", paramViewBase });
      }
      if (!TextUtils.isEmpty(paramViewBase))
      {
        if (this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo != null) {
          rap.a(this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, (int)this.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo.mChannelID);
        }
        onk.a(this.jdField_a_of_type_AndroidContentContext, paramViewBase);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pir
 * JD-Core Version:    0.7.0.1
 */