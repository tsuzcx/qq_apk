import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class pgg
  implements phs
{
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    Object localObject = paramArticleInfo.mNewPolymericInfo;
    HashMap localHashMap = new HashMap();
    localObject = (qbr)((qbq)localObject).jdField_a_of_type_JavaUtilList.get(paramInt);
    localHashMap.put("rowkey", ((qbr)localObject).jdField_g_of_type_JavaLangString);
    if (!TextUtils.isEmpty(((qbr)localObject).k)) {
      localHashMap.put("jump_report_info", ((qbr)localObject).k);
    }
    rap.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
  }
  
  private void a(ArticleInfo paramArticleInfo, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramArticleInfo.mReportCommonData)) {
      localHashMap.put("jump_report_info", paramString);
    }
    rap.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.mNewPolymericInfo == null)) {
      return new JSONObject();
    }
    JSONObject localJSONObject1 = new JSONObject();
    JSONArray localJSONArray = new JSONArray();
    qbq localqbq = paramBaseArticleInfo.mNewPolymericInfo;
    localJSONObject1.put("style_ID", "ReadInJoy_video_set_card");
    localJSONObject1.put("common_header_text", localqbq.jdField_b_of_type_JavaLangString);
    localJSONObject1.put("topic_header_big_icon_url", localqbq.jdField_a_of_type_JavaLangString);
    localJSONObject1.put("topic_header_small_icon_url", localqbq.e);
    localJSONObject1.put("topic_header_desc_text", localqbq.jdField_c_of_type_JavaLangString);
    String str2;
    String str1;
    label175:
    label177:
    qbr localqbr;
    switch (localqbq.jdField_b_of_type_Int)
    {
    default: 
      localJSONObject1.put("empty_header_visibility", "1");
      switch (localqbq.jdField_c_of_type_Int)
      {
      default: 
        str2 = "195";
        str1 = "148";
        paramInt = 0;
        if (paramInt >= localqbq.jdField_a_of_type_JavaUtilList.size()) {
          break label398;
        }
        localqbr = (qbr)localqbq.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (localqbr != null) {}
        break;
      }
      break;
    }
    for (;;)
    {
      paramInt += 1;
      break label177;
      localJSONObject1.put("common_header_visibility", "1");
      break;
      localJSONObject1.put("topic_header_visibility", "1");
      break;
      str2 = "260";
      str1 = "146";
      break label175;
      str2 = "315";
      str1 = "236";
      break label175;
      JSONObject localJSONObject2 = new JSONObject();
      localJSONObject2.put("style_ID", "ReadInJoy_video_set_card_collection_cell");
      localJSONObject2.put("videoWidth", str1);
      localJSONObject2.put("videoHeight", str2);
      localJSONObject2.put("video_cover_url", localqbr.jdField_c_of_type_JavaLangString);
      localJSONObject2.put("video_title_text", localqbr.jdField_a_of_type_JavaLangString);
      localJSONObject2.put("play_count_text", localqbr.j);
      localJSONObject2.put("comment_count_text", localqbr.jdField_g_of_type_Int + "评论");
      localJSONObject2.put("rowkey", localqbr.jdField_g_of_type_JavaLangString);
      localJSONArray.put(paramInt, localJSONObject2);
    }
    label398:
    if (paramBaseArticleInfo.mNewPolymericInfo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
      localJSONObject1.put("canEdgeDrag", "0");
    }
    for (;;)
    {
      localJSONObject1.put("video_datas", localJSONArray);
      localJSONObject1.put("card_jump_report_info", "");
      QLog.d("NewPolymericMultiVideoProteusItem", 1, localJSONObject1.toString());
      return localJSONObject1;
      localJSONObject1.put("canEdgeDrag", "1");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pax parampax, int paramInt2)
  {
    ArticleInfo localArticleInfo = parampax.a();
    if (localArticleInfo == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramContainer.getVirtualView();
      pnr localpnr = (pnr)((ViewBase)localObject).findViewBaseByName("id_proteus_collection_view");
      localpnr.a(parampax);
      localpnr.a(new pgh(this, localArticleInfo, paramContainer));
      localpnr.a(new pgi(this, localArticleInfo, parampax));
      parampax = paramContainer.getLayoutParams();
      localObject = ((ViewBase)localObject).getComLayoutParams();
    } while ((parampax == null) || (localObject == null));
    parampax.width = ((Layout.Params)localObject).mLayoutWidth;
    parampax.height = ((Layout.Params)localObject).mLayoutHeight;
    paramContainer.setLayoutParams(parampax);
  }
  
  public boolean a(int paramInt, Container paramContainer, pax parampax, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    String str;
    do
    {
      do
      {
        return false;
        str = paramViewBase.getClickEvnet();
      } while (TextUtils.isEmpty(str));
      parampax = parampax.a();
    } while (!"cmd_video_set_card_click".equals(str));
    paramViewBase.setOnClickListener(new pgj(this, parampax, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     pgg
 * JD-Core Version:    0.7.0.1
 */