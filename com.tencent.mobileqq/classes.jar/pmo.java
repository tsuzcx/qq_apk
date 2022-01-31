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

public class pmo
  implements poa
{
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    Object localObject = paramArticleInfo.mNewPolymericInfo;
    HashMap localHashMap = new HashMap();
    localObject = (qlk)((qlj)localObject).jdField_a_of_type_JavaUtilList.get(paramInt);
    localHashMap.put("rowkey", ((qlk)localObject).jdField_g_of_type_JavaLangString);
    if (!TextUtils.isEmpty(((qlk)localObject).k)) {
      localHashMap.put("jump_report_info", ((qlk)localObject).k);
    }
    rqj.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
  }
  
  private void a(ArticleInfo paramArticleInfo, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramArticleInfo.mReportCommonData)) {
      localHashMap.put("jump_report_info", paramString);
    }
    rqj.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
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
    qlj localqlj = paramBaseArticleInfo.mNewPolymericInfo;
    localJSONObject1.put("style_ID", "ReadInJoy_video_set_card");
    localJSONObject1.put("common_header_text", localqlj.jdField_b_of_type_JavaLangString);
    localJSONObject1.put("topic_header_big_icon_url", localqlj.jdField_a_of_type_JavaLangString);
    localJSONObject1.put("topic_header_small_icon_url", localqlj.e);
    localJSONObject1.put("topic_header_desc_text", localqlj.jdField_c_of_type_JavaLangString);
    String str2;
    String str1;
    label175:
    label177:
    qlk localqlk;
    switch (localqlj.jdField_b_of_type_Int)
    {
    default: 
      localJSONObject1.put("empty_header_visibility", "1");
      switch (localqlj.jdField_c_of_type_Int)
      {
      default: 
        str2 = "195";
        str1 = "148";
        paramInt = 0;
        if (paramInt >= localqlj.jdField_a_of_type_JavaUtilList.size()) {
          break label398;
        }
        localqlk = (qlk)localqlj.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (localqlk != null) {}
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
      localJSONObject2.put("video_cover_url", localqlk.jdField_c_of_type_JavaLangString);
      localJSONObject2.put("video_title_text", localqlk.jdField_a_of_type_JavaLangString);
      localJSONObject2.put("play_count_text", localqlk.j);
      localJSONObject2.put("comment_count_text", localqlk.jdField_g_of_type_Int + "评论");
      localJSONObject2.put("rowkey", localqlk.jdField_g_of_type_JavaLangString);
      localJSONArray.put(paramInt, localJSONObject2);
    }
    label398:
    if (paramBaseArticleInfo.mNewPolymericInfo.jdField_b_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo == null) {
      localJSONObject1.put("canScroll", "0");
    }
    for (;;)
    {
      localJSONObject1.put("video_data", localJSONArray);
      localJSONObject1.put("card_jump_report_info", "");
      QLog.d("NewPolymericMultiVideoProteusItem", 1, localJSONObject1.toString());
      return localJSONObject1;
      localJSONObject1.put("canScroll", "1");
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pgd parampgd, int paramInt2)
  {
    ArticleInfo localArticleInfo = parampgd.a();
    if (localArticleInfo == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramContainer.getVirtualView();
      ptw localptw = (ptw)((ViewBase)localObject).findViewBaseByName("id_proteus_collection_view");
      localptw.a(parampgd);
      localptw.a(new pmp(this, localArticleInfo, paramContainer));
      localptw.a(new pmq(this, localArticleInfo, parampgd));
      parampgd = paramContainer.getLayoutParams();
      localObject = ((ViewBase)localObject).getComLayoutParams();
    } while ((parampgd == null) || (localObject == null));
    parampgd.width = ((Layout.Params)localObject).mLayoutWidth;
    parampgd.height = ((Layout.Params)localObject).mLayoutHeight;
    paramContainer.setLayoutParams(parampgd);
  }
  
  public boolean a(int paramInt, Container paramContainer, pgd parampgd, ViewBase paramViewBase)
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
      parampgd = parampgd.a();
    } while (!"cmd_video_set_card_click".equals(str));
    paramViewBase.setOnClickListener(new pmr(this, parampgd, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     pmo
 * JD-Core Version:    0.7.0.1
 */