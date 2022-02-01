package com.tencent.mobileqq.kandian.biz.pts.item;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.bean.TemplateBean;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.common.StringCommon;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.container.Container;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.view.text.NativeText;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.kandian.biz.playfeeds.MultiVideoHelper;
import com.tencent.mobileqq.kandian.biz.playfeeds.VideoFeedsHelper;
import com.tencent.mobileqq.kandian.biz.pts.ProteusItem;
import com.tencent.mobileqq.kandian.biz.pts.data.ReadInJoyLargeVideoCell;
import com.tencent.mobileqq.kandian.biz.pts.util.AccountShowUtils;
import com.tencent.mobileqq.kandian.biz.pts.util.RIJComponentConfigImage;
import com.tencent.mobileqq.kandian.repo.feeds.entity.AbsBaseArticleInfo;
import com.tencent.mobileqq.kandian.repo.feeds.entity.api.IReadInJoyModel;
import com.tencent.mobileqq.vip.CUKingCardUtils;
import cooperation.qzone.util.NetworkState;
import org.json.JSONObject;

public class BigImageVideoProteusItem
  implements ProteusItem
{
  public TemplateBean a(int paramInt, JSONObject paramJSONObject)
  {
    return null;
  }
  
  public JSONObject a(int paramInt, AbsBaseArticleInfo paramAbsBaseArticleInfo)
  {
    return ReadInJoyLargeVideoCell.a(paramAbsBaseArticleInfo);
  }
  
  public void a(int paramInt1, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, int paramInt2)
  {
    ViewBase localViewBase = paramContainer.getVirtualView();
    boolean bool = NetworkState.isWifiConn();
    Object localObject2 = null;
    Object localObject1;
    if ((!bool) && (Aladdin.getConfig(299).getIntegerFromString("rij_main_feeds_tips_off", 0) != 1))
    {
      localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(8);
      }
      localObject1 = localViewBase.findViewBaseByName("id_video_bg");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(0);
      }
      NativeText localNativeText = (NativeText)localViewBase.findViewBaseByName("id_video_paly_text");
      if (localNativeText != null)
      {
        String str = HardCodeUtil.a(2131899330);
        if (CUKingCardUtils.a() == 1)
        {
          localObject1 = HardCodeUtil.a(2131899331);
        }
        else
        {
          localObject1 = str;
          if (paramIReadInJoyModel != null)
          {
            localObject1 = str;
            if (paramIReadInJoyModel.k().mXGFileSize > 0L)
            {
              localObject1 = new StringBuilder();
              ((StringBuilder)localObject1).append(VideoFeedsHelper.c(paramIReadInJoyModel.k().mXGFileSize));
              ((StringBuilder)localObject1).append(HardCodeUtil.a(2131899329));
              localObject1 = ((StringBuilder)localObject1).toString();
            }
          }
        }
        localNativeText.setText((CharSequence)localObject1);
      }
      if (paramIReadInJoyModel != null) {
        localObject1 = paramIReadInJoyModel.k();
      } else {
        localObject1 = null;
      }
      RIJComponentConfigImage.a(localViewBase, (AbsBaseArticleInfo)localObject1);
    }
    else
    {
      localObject1 = localViewBase.findViewBaseByName("id_large_video_icon");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(0);
      }
      localObject1 = localViewBase.findViewBaseByName("id_video_bg");
      if (localObject1 != null) {
        ((ViewBase)localObject1).setVisibility(8);
      }
      RIJComponentConfigImage.a(false, localViewBase, null);
    }
    if (paramIReadInJoyModel != null)
    {
      localObject1 = paramIReadInJoyModel.k();
      if ((localObject1 != null) && (((AbsBaseArticleInfo)localObject1).isAccountShown)) {
        AccountShowUtils.a(paramContainer, paramIReadInJoyModel);
      }
    }
    paramContainer = localObject2;
    if (paramIReadInJoyModel != null) {
      paramContainer = paramIReadInJoyModel.k();
    }
    MultiVideoHelper.a(paramContainer, BaseActivity.sTopActivity);
  }
  
  public boolean a(int paramInt, Container paramContainer, IReadInJoyModel paramIReadInJoyModel, ViewBase paramViewBase)
  {
    paramContainer = paramIReadInJoyModel.k();
    if (StringCommon.getStrIdFromString(paramViewBase.getClickEvnet()) != 1133) {
      return false;
    }
    paramViewBase.setOnClickListener(new BigImageVideoProteusItem.1(this, paramContainer, paramIReadInJoyModel, paramViewBase));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.item.BigImageVideoProteusItem
 * JD-Core Version:    0.7.0.1
 */