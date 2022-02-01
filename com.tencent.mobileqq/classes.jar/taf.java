import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.tencent.biz.pubaccount.readinjoy.model.ReadInJoyUserInfoModule;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadInJoyUserInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.AuthorData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ProteusItemData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

class taf
  implements tal
{
  taf(szv paramszv) {}
  
  public void a(ViewBase paramViewBase, Context paramContext, ProteusItemData paramProteusItemData)
  {
    if ((paramProteusItemData instanceof AuthorData))
    {
      paramContext = (AuthorData)paramProteusItemData;
      if (!TextUtils.isEmpty(paramContext.jdField_a_of_type_JavaLangString)) {
        break label23;
      }
    }
    label23:
    while (paramContext.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo == null) {
      return;
    }
    ArticleInfo localArticleInfo = paramContext.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    pha.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo = localArticleInfo;
    paramProteusItemData = ((AuthorData)paramProteusItemData).c;
    paramViewBase = pgc.k + bgku.encodeToString(String.valueOf(paramProteusItemData).getBytes(), 2);
    paramProteusItemData = ReadInJoyUserInfoModule.a(Long.parseLong(paramProteusItemData), null);
    if ((paramProteusItemData != null) && (paramProteusItemData.isLiving()))
    {
      pha.a(this.a.a.getContext(), paramProteusItemData.getLiveUrl());
      paramProteusItemData = this.a.a.getContext();
      int i = (int)localArticleInfo.mChannelID;
      if ((paramContext.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo != null) && (paramContext.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c())) {
        paramViewBase = "2";
      }
      for (;;)
      {
        paramViewBase = pha.a(paramProteusItemData, localArticleInfo, i, paramViewBase);
        try
        {
          paramViewBase.put("live_circle_from_page", 1);
          tcc.a(paramContext.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800B17E", paramViewBase.toString());
          return;
          paramViewBase = "1";
        }
        catch (JSONException paramProteusItemData)
        {
          for (;;)
          {
            QLog.e("WebProteusViewCreator", 2, paramProteusItemData.getMessage());
          }
        }
      }
    }
    pha.a(this.a.a.getContext(), paramViewBase);
    paramProteusItemData = this.a.a.getContext();
    localArticleInfo = paramContext.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo;
    if (paramContext.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebUtilFastWebArticleInfo.c()) {}
    for (paramViewBase = "2";; paramViewBase = "1")
    {
      paramViewBase = pha.a(paramProteusItemData, localArticleInfo, 0, paramViewBase);
      tcc.a(paramContext.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructArticleInfo, "0X800898A", paramViewBase.toString());
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     taf
 * JD-Core Version:    0.7.0.1
 */