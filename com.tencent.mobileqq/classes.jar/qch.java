import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.struct.ArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.BaseArticleInfo;
import com.tencent.biz.pubaccount.readinjoy.struct.UrlJumpInfo;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class qch
  implements qdy
{
  private String a(String paramString, int paramInt)
  {
    if (paramString.length() <= paramInt) {
      return paramString;
    }
    return paramString.substring(0, paramInt) + "...";
  }
  
  private void a(ArticleInfo paramArticleInfo, int paramInt, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("click_area", Integer.valueOf(paramInt));
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("jump_report_info", paramString1);
    }
    if ((paramInt == 2) && (!TextUtils.isEmpty(paramString2))) {
      localHashMap.put("click_rowkey", paramString2);
    }
    if (rbp.a().a(paramArticleInfo, false, rbp.jdField_a_of_type_Int)) {
      localHashMap.put("jump_src", Integer.valueOf(rbt.a(paramArticleInfo)));
    }
    pgw.a(paramArticleInfo, "0X8007625", "0X8007625", (int)paramArticleInfo.mChannelID, localHashMap);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, BaseArticleInfo paramBaseArticleInfo)
  {
    paramInt = 0;
    if ((paramBaseArticleInfo == null) || (paramBaseArticleInfo.multiVideoColumnInfo == null) || (paramBaseArticleInfo.multiVideoColumnInfo.jdField_a_of_type_JavaUtilList.size() == 0) || (paramBaseArticleInfo.multiVideoColumnInfo.jdField_a_of_type_JavaUtilList.get(0) == null)) {
      return new JSONObject();
    }
    Object localObject1 = BaseApplicationImpl.getContext();
    if (localObject1 != null) {}
    for (localObject1 = ((Context)localObject1).getResources().getString(2131717416);; localObject1 = "")
    {
      JSONObject localJSONObject = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      paramBaseArticleInfo = paramBaseArticleInfo.multiVideoColumnInfo;
      Object localObject2;
      if (paramBaseArticleInfo.jdField_a_of_type_Boolean)
      {
        localJSONObject.put("style_ID", "ReadInJoy_multi_video_subscribed_card_cell");
        paramInt = 0;
        if (paramInt < paramBaseArticleInfo.jdField_a_of_type_JavaUtilList.size())
        {
          localObject2 = new JSONObject();
          ((JSONObject)localObject2).put("style_ID", "ReadInJoy_multi_video_subscribed_video_cell");
          rfo localrfo = (rfo)paramBaseArticleInfo.jdField_a_of_type_JavaUtilList.get(paramInt);
          ((JSONObject)localObject2).put("video_jump_url", localrfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject2).put("video_cover_url", localrfo.c);
          ((JSONObject)localObject2).put("video_title_text", localrfo.jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject2).put("rowkey", localrfo.jdField_a_of_type_JavaLangString);
          String str1 = bkwm.b(localrfo.jdField_a_of_type_Int);
          String str2 = bkwm.c(localrfo.jdField_b_of_type_Int);
          if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localrfo.jdField_a_of_type_Int > 0)) {
            ((JSONObject)localObject2).put("video_info_text", String.format((String)localObject1, new Object[] { str1, str2 }));
          }
          for (;;)
          {
            localJSONArray.put(paramInt, localObject2);
            paramInt += 1;
            break;
            ((JSONObject)localObject2).put("video_info_text", str2);
          }
        }
      }
      else
      {
        localJSONObject.put("style_ID", "ReadInJoy_multi_video_subscribe_card_cell");
        localJSONObject.put("bottom_color", paramBaseArticleInfo.f);
        localJSONObject.put("topic_desc_text", paramBaseArticleInfo.d);
        localJSONObject.put("bg_cover_img_url", paramBaseArticleInfo.e);
        while (paramInt < paramBaseArticleInfo.jdField_a_of_type_JavaUtilList.size())
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("style_ID", "ReadInJoy_multi_video_subscribe_video_cell");
          localObject2 = (rfo)paramBaseArticleInfo.jdField_a_of_type_JavaUtilList.get(paramInt);
          ((JSONObject)localObject1).put("video_jump_url", ((rfo)localObject2).jdField_a_of_type_ComTencentBizPubaccountReadinjoyStructUrlJumpInfo.jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject1).put("video_cover_url", ((rfo)localObject2).c);
          ((JSONObject)localObject1).put("video_title_text", ((rfo)localObject2).jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject1).put("rowkey", ((rfo)localObject2).jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject1).put("video_duration_text", bkwm.c(((rfo)localObject2).jdField_b_of_type_Int));
          localJSONArray.put(paramInt, localObject1);
          paramInt += 1;
        }
      }
      localJSONObject.put("column_data", localJSONArray);
      localJSONObject.put("topic_title_text", paramBaseArticleInfo.jdField_a_of_type_JavaLangString);
      localJSONObject.put("from_text", a(paramBaseArticleInfo.g, 20));
      localJSONObject.put("from_icon_url", paramBaseArticleInfo.h);
      localJSONObject.put("title_icon_url", paramBaseArticleInfo.c);
      QLog.d("multiVideoColumnInfo", 1, localJSONObject.toString());
      return localJSONObject;
    }
  }
  
  public void a(int paramInt1, Container paramContainer, pvc parampvc, int paramInt2)
  {
    ArticleInfo localArticleInfo = parampvc.a();
    if ((localArticleInfo == null) || (localArticleInfo.multiVideoColumnInfo == null)) {
      return;
    }
    ViewBase localViewBase = paramContainer.getVirtualView();
    if (localArticleInfo.multiVideoColumnInfo.jdField_b_of_type_Int > 0) {
      if (localArticleInfo.multiVideoColumnInfo.jdField_b_of_type_Int <= 99) {
        break label167;
      }
    }
    label167:
    for (Object localObject = "99+";; localObject = Integer.toString(localArticleInfo.multiVideoColumnInfo.jdField_b_of_type_Int))
    {
      localObject = String.format(paramContainer.getContext().getResources().getString(2131717417), new Object[] { localObject });
      TextBase localTextBase = (TextBase)localViewBase.findViewBaseByName("id_topic_bubble");
      if (localTextBase != null)
      {
        localTextBase.setVisibility(0);
        localTextBase.setText((CharSequence)localObject);
      }
      localObject = (qki)localViewBase.findViewBaseByName("id_column_list");
      ((qki)localObject).a(parampvc);
      ((qki)localObject).a(new qci(this, localArticleInfo, paramContainer));
      ((qki)localObject).a(new qcj(this, localArticleInfo, paramContainer));
      return;
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, pvc parampvc, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {}
    String str;
    do
    {
      do
      {
        return false;
        str = paramViewBase.getClickEvnet();
      } while ((TextUtils.isEmpty(str)) || (!str.startsWith("multi_video_column_")));
      parampvc = parampvc.a();
      if ("multi_video_column_card_click".equals(str))
      {
        paramViewBase.setOnClickListener(new qck(this, parampvc, paramContainer));
        return true;
      }
    } while (!"multi_video_column_tail_click".equals(str));
    paramViewBase.setOnClickListener(new qcl(this, parampvc, paramContainer));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     qch
 * JD-Core Version:    0.7.0.1
 */