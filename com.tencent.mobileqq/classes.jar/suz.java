import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;

class suz
  implements svf
{
  suz(sup paramsup) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if ((paramProteusItemData instanceof AuthorData))
    {
      paramViewBase = (AuthorData)paramProteusItemData;
      if (!TextUtils.isEmpty(paramViewBase.jdField_a_of_type_JavaLangString)) {
        break label23;
      }
    }
    label23:
    while (paramViewBase.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    paramContext = paramViewBase.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    pay.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = paramContext;
    paramProteusItemData = ((AuthorData)paramProteusItemData).c;
    svv.a(this.a.a.getContext(), paramContext, paramProteusItemData, paramViewBase.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     suz
 * JD-Core Version:    0.7.0.1
 */