import android.content.Context;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

class squ
  implements srh
{
  squ(sqr paramsqr) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    ArticleInfo localArticleInfo = paramProteusItemData.b;
    FastWebArticleInfo localFastWebArticleInfo = paramProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo;
    String str = paramViewBase.getEventAttachedData();
    sry.b(localArticleInfo, localFastWebArticleInfo, paramProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    sry.a(localArticleInfo, localFastWebArticleInfo, paramProteusItemData.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewProteusBeanTemplateBean, paramViewBase);
    if (!TextUtils.isEmpty(str)) {
      ozs.d(paramContext, str);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     squ
 * JD-Core Version:    0.7.0.1
 */