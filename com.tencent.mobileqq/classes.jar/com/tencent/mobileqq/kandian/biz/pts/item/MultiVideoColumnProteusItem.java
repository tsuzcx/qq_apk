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
    if (ReadInJoySrtHandler.a().a(paramAbsBaseArticleInfo, false, ReadInJoySrtHandler.a)) {
      localHashMap.put("jump_src", Integer.valueOf(UGRuleManager.g(paramAbsBaseArticleInfo)));
    }
    RIJFrameworkReportManager.a(paramAbsBaseArticleInfo, "0X8007625", "0X8007625", (int)paramAbsBaseArticleInfo.mChannelID, localHashMap);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.multiVideoColumnInfo != null) && (paramAbsBaseArticleInfo.multiVideoColumnInfo.p.size() != 0))
    {
      Object localObject1 = paramAbsBaseArticleInfo.multiVideoColumnInfo.p;
      paramInt = 0;
      if (((List)localObject1).get(0) != null)
      {
        localObject1 = BaseApplicationImpl.getContext();
        if (localObject1 != null) {
          localObject1 = ((Context)localObject1).getResources().getString(2131915430);
        } else {
          localObject1 = "";
        }
        JSONObject localJSONObject = new JSONObject();
        JSONArray localJSONArray = new JSONArray();
        paramAbsBaseArticleInfo = paramAbsBaseArticleInfo.multiVideoColumnInfo;
        Object localObject2;
        if (paramAbsBaseArticleInfo.j)
        {
          localJSONObject.put("style_ID", "ReadInJoy_multi_video_subscribed_card_cell");
          paramInt = 0;
          while (paramInt < paramAbsBaseArticleInfo.p.size())
          {
            localObject2 = new JSONObject();
            ((JSONObject)localObject2).put("style_ID", "ReadInJoy_multi_video_subscribed_video_cell");
            SubVideoInfo localSubVideoInfo = (SubVideoInfo)paramAbsBaseArticleInfo.p.get(paramInt);
            ((JSONObject)localObject2).put("video_jump_url", localSubVideoInfo.e.b);
            ((JSONObject)localObject2).put("video_cover_url", localSubVideoInfo.d);
            ((JSONObject)localObject2).put("video_title_text", localSubVideoInfo.c);
            ((JSONObject)localObject2).put("rowkey", localSubVideoInfo.b);
            String str1 = ReadInJoyHelper.d(localSubVideoInfo.f);
            String str2 = ReadInJoyHelper.f(localSubVideoInfo.g);
            if ((!TextUtils.isEmpty((CharSequence)localObject1)) && (localSubVideoInfo.f > 0)) {
              ((JSONObject)localObject2).put("video_info_text", String.format((String)localObject1, new Object[] { str1, str2 }));
            } else {
              ((JSONObject)localObject2).put("video_info_text", str2);
            }
            localJSONArray.put(paramInt, localObject2);
            paramInt += 1;
          }
        }
        localJSONObject.put("style_ID", "ReadInJoy_multi_video_subscribe_card_cell");
        localJSONObject.put("bottom_color", paramAbsBaseArticleInfo.l);
        localJSONObject.put("topic_desc_text", paramAbsBaseArticleInfo.e);
        localJSONObject.put("bg_cover_img_url", paramAbsBaseArticleInfo.k);
        while (paramInt < paramAbsBaseArticleInfo.p.size())
        {
          localObject1 = new JSONObject();
          ((JSONObject)localObject1).put("style_ID", "ReadInJoy_multi_video_subscribe_video_cell");
          localObject2 = (SubVideoInfo)paramAbsBaseArticleInfo.p.get(paramInt);
          ((JSONObject)localObject1).put("video_jump_url", ((SubVideoInfo)localObject2).e.b);
          ((JSONObject)localObject1).put("video_cover_url", ((SubVideoInfo)localObject2).d);
          ((JSONObject)localObject1).put("video_title_text", ((SubVideoInfo)localObject2).c);
          ((JSONObject)localObject1).put("rowkey", ((SubVideoInfo)localObject2).b);
          ((JSONObject)localObject1).put("video_duration_text", ReadInJoyHelper.f(((SubVideoInfo)localObject2).g));
          localJSONArray.put(paramInt, localObject1);
          paramInt += 1;
        }
        localJSONObject.put("column_data", localJSONArray);
        localJSONObject.put("topic_title_text", paramAbsBaseArticleInfo.b);
        localJSONObject.put("from_text", a(paramAbsBaseArticleInfo.m, 20));
        localJSONObject.put("from_icon_url", paramAbsBaseArticleInfo.n);
        localJSONObject.put("title_icon_url", paramAbsBaseArticleInfo.d);
        QLog.d("multiVideoColumnInfo", 1, localJSONObject.toString());
        return localJSONObject;
      }
    }
    return new JSONObject();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.k();
    if (localAbsBaseArticleInfo != null)
    {
      if (localAbsBaseArticleInfo.multiVideoColumnInfo == null) {
        return;
      }
      ViewBase localViewBase = paramContainer.getVirtualView();
      if (localAbsBaseArticleInfo.multiVideoColumnInfo.f > 0)
      {
        if (localAbsBaseArticleInfo.multiVideoColumnInfo.f > 99) {
          localObject = "99+";
        } else {
          localObject = Integer.toString(localAbsBaseArticleInfo.multiVideoColumnInfo.f);
        }
        localObject = String.format(paramContainer.getContext().getResources().getString(2131915431), new Object[] { localObject });
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
      paramIReadInJoyModel = paramIReadInJoyModel.k();
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.MultiVideoColumnProteusItem
 * JD-Core Version:    0.7.0.1
 */