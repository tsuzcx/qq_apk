package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.TextBase;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.UrlJumpInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.ReadInJoySrtHandler;
import com.tencent.mobileqq.kandian.repo.ugc.srtutils.UGRuleManager;
import com.tencent.mobileqq.kandian.repo.video.entity.MultiVideoColumnInfo;
import com.tencent.mobileqq.kandian.repo.video.entity.SubVideoInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class MultiVideoColumnProteusItem
  implements ProteusItem
{
  private String a(String paramString, int paramInt)
  {
    if (paramString.length() <= paramInt) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString.substring(0, paramInt));
    localStringBuilder.append("...");
    return localStringBuilder.toString();
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt, String paramString1, String paramString2)
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("click_area", Integer.valueOf(paramInt));
    if (!TextUtils.isEmpty(paramString1)) {
      localHashMap.put("jump_report_info", paramString1);
    }
    if ((paramInt == 2) && (!TextUtils.isEmpty(paramString2))) {
      localHashMap.put("click_rowkey", paramString2);
    }
    if (ReadInJoySrtHandler.a().a(paramAbsBaseArticleInfo, false, ReadInJoySrtHandler.jdField_a_of_type_Int)) {
      localHashMap.put("jump_src", Integer.valueOf(UGRuleManager.a(paramAbsBaseArticleInfo)));
    }
    RIJFrameworkReportManager.a(paramAbsBaseArticleInfo, "0X8007625", "0X8007625", (int)paramAbsBaseArticleInfo.mChannelID, localHashMap);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.multiVideoColumnInfo != null) && (paramAbsBaseArticleInfo.multiVideoColumnInfo.jdField_a_of_type_JavaUtilList.size() != 0))
    {
      Object localObject1 = paramAbsBaseArticleInfo.multiVideoColumnInfo.jdField_a_of_type_JavaUtilList;
      paramInt = 0;
      if (((List)localObject1).get(0) != null)
      {
        localObject1 = BaseApplicationImpl.getContext();
        if (localObject1 != null) {
          localObject1 = ((Context)localObject1).getResources().getString(2131717950);
        } else {
          localObject1 = "";
        }
        JSONObject localJSONObject = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.multiVideoColumnInfo;
        Object localObject2;
        if (paramAbsBaseArticleInfo.jdField_a_of_type_Boolean)
        {
          localJSONObject.put("style_ID", "ReadInJoy_multi_video_subscribed_card_cell");
          paramInt = 0;
          while (paramInt < paramAbsBaseArticleInfo.jdField_a_of_type_JavaUtilList.size())
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("style_ID", "ReadInJoy_multi_video_subscribed_video_cell");
            SubVideoInfo localSubVideoInfo = (SubVideoInfo)paramAbsBaseArticleInfo.jdField_a_of_type_JavaUtilList.get(paramInt);
            ((JSONObject)localObject2).put("video_jump_url", localSubVideoInfo.jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_JavaLangString);
            ((JSONObject)localObject2).put("video_cover_url", localSubVideoInfo.c);
            ((JSONObject)localObject2).put("video_title_text", localSubVideoInfo.jdField_b_of_type_JavaLangString);
            ((JSONObject)localObject2).put("rowkey", localSubVideoInfo.jdField_a_of_type_JavaLangString);
            String str1 = ReadInJoyHelper.b(localSubVideoInfo.jdField_a_of_type_Int);
            String str2 = ReadInJoyHelper.d(localSubVideoInfo.jdField_b_of_type_Int);
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localSubVideoInfo.jdField_a_of_type_Int > 0)) {
              ((JSONObject)localObject2).put("video_info_text", String.format((String)localObject1, new Object[] { str1, str2 }));
            } else {
              ((JSONObject)localObject2).put("video_info_text", str2);
            }
            localJSONArray.put(paramInt, localObject2);
            paramInt += 1;
          }
        }
        localJSONObject.put("style_ID", "ReadInJoy_multi_video_subscribe_card_cell");
        localJSONObject.put("bottom_color", paramAbsBaseArticleInfo.f);
        localJSONObject.put("topic_desc_text", paramAbsBaseArticleInfo.d);
        localJSONObject.put("bg_cover_img_url", paramAbsBaseArticleInfo.e);
        while (paramInt < paramAbsBaseArticleInfo.jdField_a_of_type_JavaUtilList.size())
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("style_ID", "ReadInJoy_multi_video_subscribe_video_cell");
          localObject2 = (SubVideoInfo)paramAbsBaseArticleInfo.jdField_a_of_type_JavaUtilList.get(paramInt);
          ((JSONObject)localObject1).put("video_jump_url", ((SubVideoInfo)localObject2).jdField_a_of_type_ComTencentMobileqqKandianRepoFeedsEntityUrlJumpInfo.jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject1).put("video_cover_url", ((SubVideoInfo)localObject2).c);
          ((JSONObject)localObject1).put("video_title_text", ((SubVideoInfo)localObject2).jdField_b_of_type_JavaLangString);
          ((JSONObject)localObject1).put("rowkey", ((SubVideoInfo)localObject2).jdField_a_of_type_JavaLangString);
          ((JSONObject)localObject1).put("video_duration_text", ReadInJoyHelper.d(((SubVideoInfo)localObject2).jdField_b_of_type_Int));
          localJSONArray.put(paramInt, localObject1);
          paramInt += 1;
        }
        localJSONObject.put("column_data", localJSONArray);
        localJSONObject.put("topic_title_text", paramAbsBaseArticleInfo.jdField_a_of_type_JavaLangString);
        localJSONObject.put("from_text", a(paramAbsBaseArticleInfo.g, 20));
        localJSONObject.put("from_icon_url", paramAbsBaseArticleInfo.h);
        localJSONObject.put("title_icon_url", paramAbsBaseArticleInfo.c);
        QLog.d("multiVideoColumnInfo", 1, localJSONObject.toString());
        return localJSONObject;
      }
    }
    return new JSONObject();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.a();
    if (localAbsBaseArticleInfo != null)
    {
      if (localAbsBaseArticleInfo.multiVideoColumnInfo == null) {
        return;
      }
      ViewBase localViewBase = paramContainer.getVirtualView();
      if (localAbsBaseArticleInfo.multiVideoColumnInfo.jdField_b_of_type_Int > 0)
      {
        if (localAbsBaseArticleInfo.multiVideoColumnInfo.jdField_b_of_type_Int > 99) {
          localObject = "99+";
        } else {
          localObject = Integer.toString(localAbsBaseArticleInfo.multiVideoColumnInfo.jdField_b_of_type_Int);
        }
        localObject = String.format(paramContainer.getContext().getResources().getString(2131717951), new Object[] { localObject });
        TextBase localTextBase = (TextBase)localViewBase.findViewBaseByName("id_topic_bubble");
        if (localTextBase != null)
        {
          localTextBase.setVisibility(0);
          localTextBase.setText((CharSequence)localObject);
        }
      }
      Object localObject = (RvPolymericContainer)localViewBase.findViewBaseByName("id_column_list");
      ((RvPolymericContainer)localObject).a(paramIReadInJoyModel);
      ((RvPolymericContainer)localObject).a(new MultiVideoColumnProteusItem.1(this, localAbsBaseArticleInfo, paramContainer));
      ((RvPolymericContainer)localObject).a(new MultiVideoColumnProteusItem.2(this, localAbsBaseArticleInfo, paramContainer));
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    if (paramViewBase == null) {
      return false;
    }
    String str = paramViewBase.getClickEvnet();
    if ((!TextUtils.isEmpty(str)) && (str.startsWith("multi_video_column_")))
    {
      paramIReadInJoyModel = paramIReadInJoyModel.a();
      if ("multi_video_column_card_click".equals(str))
      {
        paramViewBase.setOnClickListener(new MultiVideoColumnProteusItem.3(this, paramIReadInJoyModel, paramContainer));
        return true;
      }
      if ("multi_video_column_tail_click".equals(str))
      {
        paramViewBase.setOnClickListener(new MultiVideoColumnProteusItem.4(this, paramIReadInJoyModel, paramContainer));
        return true;
      }
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.MultiVideoColumnProteusItem
 * JD-Core Version:    0.7.0.1
 */