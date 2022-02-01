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

public class pws
  implements pye
{
  private void a(ArticleInfo paramArticleInfo, int paramInt)
  {
    Object localObject = paramArticleInfo.mNewPolymericInfo;
    HashMap localHashMap = new HashMap();
    localObject = (qwp)((qwo)localObject).jdField_a_of_type_JavaUtilList.get(paramInt);
    localHashMap.put("rowkey", ((qwp)localObject).jdField_g_of_type_JavaLangString);
    if (!TextUtils.isEmpty(((qwp)localObject).k)) {
      localHashMap.put("jump_report_info", ((qwp)localObject).k);
    }
    sel.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
  }
  
  private void a(ArticleInfo paramArticleInfo, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramArticleInfo.mReportCommonData)) {
      localHashMap.put("jump_report_info", paramString);
    }
    sel.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
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
    qwo localqwo = paramBaseArticleInfo.mNewPolymericInfo;
    localJSONObject1.put("style_ID", "ReadInJoy_video_set_card");
    localJSONObject1.put("common_header_text", localqwo.jdField_b_of_type_JavaLangString);
    localJSONObject1.put("topic_header_big_icon_url", localqwo.jdField_a_of_type_JavaLangString);
    localJSONObject1.put("topic_header_small_icon_url", localqwo.e);
    localJSONObject1.put("topic_header_desc_text", localqwo.jdField_c_of_type_JavaLangString);
    String str2;
    String str1;
    label175:
    label177:
    qwp localqwp;
    switch (localqwo.jdField_b_of_type_Int)
    {
    default: 
      localJSONObject1.put("empty_header_visibility", "1");
      switch (localqwo.jdField_c_of_type_Int)
      {
      default: 
        str2 = "195";
        str1 = "148";
        paramInt = 0;
        if (paramInt >= localqwo.jdField_a_of_type_JavaUtilList.size()) {
          break label398;
        }
        localqwp = (qwp)localqwo.jdField_a_of_type_JavaUtilList.get(paramInt);
        if (localqwp != null) {}
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
      localJSONObject2.put("video_cover_url", localqwp.jdField_c_of_type_JavaLangString);
      localJSONObject2.put("video_title_text", localqwp.jdField_a_of_type_JavaLangString);
      localJSONObject2.put("play_count_text", localqwp.j);
      localJSONObject2.put("comment_count_text", localqwp.jdField_g_of_type_Int + "评论");
      localJSONObject2.put("rowkey", localqwp.jdField_g_of_type_JavaLangString);
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
  
  public void a(int paramInt1, Container paramContainer, ppu paramppu, int paramInt2)
  {
    ArticleInfo localArticleInfo = paramppu.a();
    if (localArticleInfo == null) {}
    Object localObject;
    do
    {
      return;
      localObject = paramContainer.getVirtualView();
      qek localqek = (qek)((ViewBase)localObject).findViewBaseByName("id_proteus_collection_view");
      localqek.a(paramppu);
      localqek.a(new pwt(this, localArticleInfo, paramContainer));
      localqek.a(new pwu(this, localArticleInfo, paramppu));
      paramppu = paramContainer.getLayoutParams();
      localObject = ((ViewBase)localObject).getComLayoutParams();
    } while ((paramppu == null) || (localObject == null));
    paramppu.width = ((Layout.Params)localObject).mLayoutWidth;
    paramppu.height = ((Layout.Params)localObject).mLayoutHeight;
    paramContainer.setLayoutParams(paramppu);
  }
  
  public boolean a(int paramInt, Container paramContainer, ppu paramppu, ViewBase paramViewBase)
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
      paramppu = paramppu.a();
    } while (!"cmd_video_set_card_click".equals(str));
    paramViewBase.setOnClickListener(new pwv(this, paramppu, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     pws
 * JD-Core Version:    0.7.0.1
 */