package com.tencent.mobileqq.kandian.biz.pts.item;

import android.text.TextUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.Layout.Params;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.view.polymeric.RvPolymericContainer;
import com.tencent.mobileqq.kandian.glue.report.RIJFrameworkReportManager;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.NewPolymericInfo.PackArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONObject;

public class NewPolymericMultiVideoProteusItem
  implements ProteusItem
{
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, int paramInt)
  {
    Object localObject = paramAbsBaseArticleInfo.mNewPolymericInfo;
    HashMap localHashMap = new HashMap();
    localObject = (NewPolymericInfo.PackArticleInfo)((NewPolymericInfo)localObject).p.get(paramInt);
    localHashMap.put("rowkey", ((NewPolymericInfo.PackArticleInfo)localObject).l);
    if (!TextUtils.isEmpty(((NewPolymericInfo.PackArticleInfo)localObject).y)) {
      localHashMap.put("jump_report_info", ((NewPolymericInfo.PackArticleInfo)localObject).y);
    }
    RIJFrameworkReportManager.a(paramAbsBaseArticleInfo, "0X8007625", "0X8007625", (int)paramAbsBaseArticleInfo.mChannelID, localHashMap);
  }
  
  private void a(AbsBaseArticleInfo paramAbsBaseArticleInfo, String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!TextUtils.isEmpty(paramAbsBaseArticleInfo.mReportCommonData)) {
      localHashMap.put("jump_report_info", paramString);
    }
    RIJFrameworkReportManager.a(paramAbsBaseArticleInfo, "0X8007625", "0X8007625", (int)paramAbsBaseArticleInfo.mChannelID, localHashMap);
  }
  
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mNewPolymericInfo != null))
    {
      JSONObject localJSONObject1 = new JSONObject();
      JSONArray localJSONArray = new JSONArray();
      NewPolymericInfo localNewPolymericInfo = paramAbsBaseArticleInfo.mNewPolymericInfo;
      localJSONObject1.put("style_ID", "ReadInJoy_video_set_card");
      localJSONObject1.put("common_header_text", localNewPolymericInfo.f);
      localJSONObject1.put("topic_header_big_icon_url", localNewPolymericInfo.e);
      localJSONObject1.put("topic_header_small_icon_url", localNewPolymericInfo.i);
      localJSONObject1.put("topic_header_desc_text", localNewPolymericInfo.g);
      paramInt = localNewPolymericInfo.j;
      if (paramInt != 2)
      {
        if (paramInt != 3) {
          localJSONObject1.put("empty_header_visibility", "1");
        } else {
          localJSONObject1.put("topic_header_visibility", "1");
        }
      }
      else {
        localJSONObject1.put("common_header_visibility", "1");
      }
      paramInt = localNewPolymericInfo.k;
      String str1;
      String str2;
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          str1 = "195";
          str2 = "148";
        }
        else
        {
          str1 = "315";
          str2 = "236";
        }
      }
      else
      {
        str1 = "260";
        str2 = "146";
      }
      paramInt = 0;
      while (paramInt < localNewPolymericInfo.p.size())
      {
        NewPolymericInfo.PackArticleInfo localPackArticleInfo = (NewPolymericInfo.PackArticleInfo)localNewPolymericInfo.p.get(paramInt);
        if (localPackArticleInfo != null)
        {
          JSONObject localJSONObject2 = new JSONObject();
          localJSONObject2.put("style_ID", "ReadInJoy_video_set_card_collection_cell");
          localJSONObject2.put("videoWidth", str2);
          localJSONObject2.put("videoHeight", str1);
          localJSONObject2.put("video_cover_url", localPackArticleInfo.d);
          localJSONObject2.put("video_title_text", localPackArticleInfo.b);
          localJSONObject2.put("play_count_text", localPackArticleInfo.w);
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append(localPackArticleInfo.x);
          localStringBuilder.append("评论");
          localJSONObject2.put("comment_count_text", localStringBuilder.toString());
          localJSONObject2.put("rowkey", localPackArticleInfo.l);
          localJSONArray.put(paramInt, localJSONObject2);
        }
        paramInt += 1;
      }
      if (paramAbsBaseArticleInfo.mNewPolymericInfo.m == null) {
        localJSONObject1.put("canScroll", "0");
      } else {
        localJSONObject1.put("canScroll", "1");
      }
      localJSONObject1.put("video_data", localJSONArray);
      localJSONObject1.put("card_jump_report_info", "");
      QLog.d("NewPolymericMultiVideoProteusItem", 1, localJSONObject1.toString());
      return localJSONObject1;
    }
    return new JSONObject();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    AbsBaseArticleInfo localAbsBaseArticleInfo = paramIReadInJoyModel.k();
    if (localAbsBaseArticleInfo == null) {
      return;
    }
    Object localObject = paramContainer.getVirtualView();
    RvPolymericContainer localRvPolymericContainer = (RvPolymericContainer)((ViewBase)localObject).findViewBaseByName("id_proteus_collection_view");
    localRvPolymericContainer.a(paramIReadInJoyModel);
    localRvPolymericContainer.a(new NewPolymericMultiVideoProteusItem.1(this, localAbsBaseArticleInfo, paramContainer));
    localRvPolymericContainer.a(new NewPolymericMultiVideoProteusItem.2(this, localAbsBaseArticleInfo, paramIReadInJoyModel));
    paramIReadInJoyModel = paramContainer.getLayoutParams();
    localObject = ((ViewBase)localObject).getComLayoutParams();
    if ((paramIReadInJoyModel != null) && (localObject != null))
    {
      paramIReadInJoyModel.width = ((Layout.Params)localObject).mLayoutWidth;
      paramIReadInJoyModel.height = ((Layout.Params)localObject).mLayoutHeight;
      paramContainer.setLayoutParams(paramIReadInJoyModel);
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    boolean bool2 = false;
    if (paramViewBase == null) {
      return false;
    }
    String str = paramViewBase.getClickEvnet();
    boolean bool1 = bool2;
    if (!TextUtils.isEmpty(str))
    {
      paramIReadInJoyModel = paramIReadInJoyModel.k();
      bool1 = bool2;
      if ("cmd_video_set_card_click".equals(str))
      {
        paramViewBase.setOnClickListener(new NewPolymericMultiVideoProteusItem.3(this, paramIReadInJoyModel, paramContainer));
        bool1 = true;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.NewPolymericMultiVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */