package com.tencent.mobileqq.kandian.biz.pts.item;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Build.VERSION;
import android.util.DisplayMetrics;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.utils.Utils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeTextImp;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ProteusItemDataBuilder;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.feeds.RIJFeedsType;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AnswerDetailInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.SocializeFeedsInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.WendaInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public class QuestionAnswerCardProteusItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    ProteusItemDataBuilder localProteusItemDataBuilder = new ProteusItemDataBuilder();
    String str1 = "ReadInjoy_QA_NoImage_cell";
    if ((paramAbsBaseArticleInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a.a != null))
    {
      String str2;
      if ((paramAbsBaseArticleInfo.mSocialFeedInfo.a.c != null) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a.c.size() > 0) && (paramAbsBaseArticleInfo.mSocialFeedInfo.a.a.b == 1))
      {
        str2 = ((String)paramAbsBaseArticleInfo.mSocialFeedInfo.a.c.get(0)).trim();
        str1 = "ReadInjoy_QA_Image_cell";
      }
      else
      {
        str2 = "";
      }
      try
      {
        localProteusItemDataBuilder.a(str1).d(paramAbsBaseArticleInfo, str2).j(paramAbsBaseArticleInfo).r(paramAbsBaseArticleInfo);
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
    else
    {
      try
      {
        localProteusItemDataBuilder.a("ReadInjoy_QA_NoImage_cell");
      }
      catch (JSONException paramAbsBaseArticleInfo)
      {
        paramAbsBaseArticleInfo.printStackTrace();
      }
    }
    return localProteusItemDataBuilder.a();
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    Object localObject = paramContainer.getVirtualView();
    if ((localObject != null) && (paramIReadInJoyModel != null))
    {
      if (paramIReadInJoyModel.a() == null) {
        return;
      }
      localObject = ((ViewBase)localObject).findViewBaseByName("id_summary");
      if ((localObject != null) && (((ViewBase)localObject).getNativeView() != null) && ((((ViewBase)localObject).getNativeView() instanceof NativeTextImp)))
      {
        NativeTextImp localNativeTextImp = (NativeTextImp)((ViewBase)localObject).getNativeView();
        if (localNativeTextImp != null)
        {
          boolean bool = ReadInJoyLogicEngine.a().a(paramIReadInJoyModel.a().mArticleID);
          localNativeTextImp.setTextSize(2, 15.0F);
          if (bool) {
            localObject = "#999999";
          } else {
            localObject = "#4c4c4c";
          }
          localNativeTextImp.setTextColor(Color.parseColor((String)localObject));
          paramContainer = paramContainer.getContext().getResources().getDisplayMetrics();
          paramInt2 = 3;
          paramInt1 = paramInt2;
          if (paramContainer.widthPixels <= 720)
          {
            paramInt1 = paramInt2;
            if (!RIJFeedsType.r(paramIReadInJoyModel.a())) {
              paramInt1 = 2;
            }
          }
          localNativeTextImp.setMaxLines(paramInt1);
          localNativeTextImp.setLineSpacing(Utils.rp2px(2.0D), 1.0F);
          if (Build.VERSION.SDK_INT >= 21) {
            localNativeTextImp.setLetterSpacing(0.02F);
          }
        }
      }
    }
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.QuestionAnswerCardProteusItem
 * JD-Core Version:    0.7.0.1
 */