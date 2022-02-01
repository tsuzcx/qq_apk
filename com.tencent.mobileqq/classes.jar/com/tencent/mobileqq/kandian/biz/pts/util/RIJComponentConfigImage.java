package com.tencent.mobileqq.kandian.biz.pts.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.Pair;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.base.view.widget.KandianUrlImageView;
import com.tencent.mobileqq.kandian.base.view.widget.ZImageView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper.VideoPackSetting;
import com.tencent.mobileqq.kandian.biz.video.feeds.entity.VideoPlayParam;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.repo.aladdin.RIJKanDianFeedsCardStyleAladdinConfig;
import com.tencent.mobileqq.kandian.repo.common.FreeNetFlowInfoModule;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.DeviceInfoUtil;
import com.tencent.mobileqq.utils.NetworkUtil;
import java.net.URL;
import java.util.List;
import mqq.app.AppRuntime;

public class RIJComponentConfigImage
{
  private static Drawable a = new ColorDrawable(Color.parseColor("#E9E9E9"));
  
  public static float a(Context paramContext, VideoPlayParam paramVideoPlayParam)
  {
    int j = 28;
    if (paramVideoPlayParam != null)
    {
      i = j;
      if (paramVideoPlayParam.o != 0) {
        break label81;
      }
      i = j;
      if (paramVideoPlayParam.p != 0) {
        break label81;
      }
      i = j;
      if (paramVideoPlayParam.q != 0) {
        break label81;
      }
      if (paramVideoPlayParam.r != 0)
      {
        i = j;
        break label81;
      }
      if ((paramVideoPlayParam.a != null) && (paramVideoPlayParam.a.mChannelID == 56L) && (RIJKanDianFeedsCardStyleAladdinConfig.a()))
      {
        i = j;
        break label81;
      }
    }
    int i = 12;
    label81:
    if ((paramVideoPlayParam != null) && (paramVideoPlayParam.b) && (paramVideoPlayParam.l > 0)) {
      return paramVideoPlayParam.l;
    }
    return DeviceInfoUtil.b(paramContext) - DisplayUtil.a(paramContext, i);
  }
  
  public static Pair<Integer, Integer> a(int paramInt1, int paramInt2)
  {
    Resources localResources = BaseApplicationImpl.getApplication().getResources();
    int i = AIOUtils.b(1.5F, localResources);
    if (paramInt2 == 56) {
      i = AIOUtils.b(3.0F, localResources);
    }
    ReadInJoyHelper.VideoPackSetting localVideoPackSetting = ReadInJoyHelper.a(BaseApplicationImpl.getApplication().getRuntime());
    float f1 = 0.7511F;
    float f2 = 0.7487F;
    if (localVideoPackSetting != null)
    {
      f1 = localVideoPackSetting.a;
      f2 = localVideoPackSetting.jdField_b_of_type_Float;
      paramInt2 = AIOUtils.b(localVideoPackSetting.jdField_b_of_type_Int, localResources);
    }
    else
    {
      paramInt2 = 0;
    }
    if (paramInt1 != 1)
    {
      if (paramInt1 != 2)
      {
        paramInt1 = paramInt2;
        if (paramInt2 == 0) {
          paramInt1 = (int)((localResources.getDisplayMetrics().widthPixels - AIOUtils.b(6, localResources) - i * 2) / 2.1F);
        }
        f1 = paramInt1 / f2;
      }
      else
      {
        paramInt1 = (int)((localResources.getDisplayMetrics().widthPixels - AIOUtils.b(12, localResources) - i) * 0.5F);
        f1 = paramInt1 / f1;
      }
    }
    else
    {
      paramInt1 = localResources.getDisplayMetrics().widthPixels - AIOUtils.b(12, localResources);
      f1 = (localResources.getDisplayMetrics().widthPixels - AIOUtils.b(6, localResources) - i * 2) / 2.5F * 1.3356F;
    }
    return new Pair(Integer.valueOf(paramInt1), Integer.valueOf((int)f1));
  }
  
  public static void a(ViewBase paramViewBase, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    if (paramAbsBaseArticleInfo == null) {
      return;
    }
    FreeNetFlowInfoModule localFreeNetFlowInfoModule = ReadInJoyLogicEngine.a().a();
    if ((localFreeNetFlowInfoModule != null) && (localFreeNetFlowInfoModule.b()))
    {
      a(false, paramViewBase, null);
      paramAbsBaseArticleInfo.isShowFreeNetFlow = false;
      return;
    }
    if (paramAbsBaseArticleInfo.isShowFreeNetFlow)
    {
      a(true, paramViewBase, localFreeNetFlowInfoModule);
      return;
    }
    if ((localFreeNetFlowInfoModule != null) && (localFreeNetFlowInfoModule.a()))
    {
      a(true, paramViewBase, localFreeNetFlowInfoModule);
      paramAbsBaseArticleInfo.isShowFreeNetFlow = true;
      localFreeNetFlowInfoModule.a(true);
      return;
    }
    a(false, paramViewBase, null);
  }
  
  public static void a(List<KandianUrlImageView> paramList, List<URL> paramList1, Context paramContext)
  {
    int m = paramList.size();
    if (m == paramList1.size())
    {
      int j = 0;
      int k = 0;
      boolean bool;
      if (paramContext != null) {
        bool = SettingCloneUtil.readValue(paramContext, BaseApplicationImpl.getApplication().getRuntime().getAccount(), null, "qqsetting_kandian_download_pic_flag", false);
      } else {
        bool = false;
      }
      int i = j;
      if (bool)
      {
        i = k;
        if (NetworkUtil.isWifiConnected(paramContext)) {
          i = j;
        } else {
          while (i < m)
          {
            ((KandianUrlImageView)paramList.get(i)).setImageDrawable(a);
            i += 1;
          }
        }
      }
      while (i < m)
      {
        ((KandianUrlImageView)paramList.get(i)).setImagePlaceHolder(a).setImage((URL)paramList1.get(i));
        i += 1;
      }
      return;
    }
    paramList = new IllegalArgumentException("imageViewListSize != urlListSize");
    for (;;)
    {
      throw paramList;
    }
  }
  
  public static void a(boolean paramBoolean, ViewBase paramViewBase, FreeNetFlowInfoModule paramFreeNetFlowInfoModule)
  {
    if (paramViewBase == null) {
      return;
    }
    ViewBase localViewBase1 = paramViewBase.findViewBaseByName("id_large_video_activity_wrapper");
    ViewBase localViewBase2 = paramViewBase.findViewBaseByName("id_large_video_activity_img");
    paramViewBase = (NativeText)paramViewBase.findViewBaseByName("id_large_video_activity_label");
    if ((localViewBase1 != null) && (paramViewBase != null))
    {
      if (localViewBase2 == null) {
        return;
      }
      if ((paramBoolean) && (paramFreeNetFlowInfoModule != null))
      {
        localViewBase1.setVisibility(0);
        localViewBase2.setVisibility(0);
        paramViewBase.setVisibility(0);
        paramViewBase.setText(paramFreeNetFlowInfoModule.a());
        PTSRijReport.a("0X8009660");
        return;
      }
      localViewBase1.setVisibility(8);
      localViewBase2.setVisibility(8);
      paramViewBase.setVisibility(8);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage
 * JD-Core Version:    0.7.0.1
 */