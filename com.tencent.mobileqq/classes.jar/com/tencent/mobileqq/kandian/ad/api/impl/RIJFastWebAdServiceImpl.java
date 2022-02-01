package com.tencent.mobileqq.kandian.ad.api.impl;

import android.app.Activity;
import android.content.Context;
import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.biz.pubaccount.readinjoy.struct.AdvertisementInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RecommendAdData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.item.WebFastProteusViewAdCreator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebAdtUtil;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.JumpAdUtils;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.ViewBase.IBuilder;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdBar;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.CommonAdFloatingBarUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.GamesComponentAdDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.common_ad_bar.uidelegate.IUIDelegate;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerBigPicItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.data.ProteusBannerVideoItemData;
import com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusAdInnerCreator;
import com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerBigPicCreator;
import com.tencent.biz.pubaccount.readinjoyAd.ad.item.WebFastProteusViewAdBannerVideoCreator;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.FastWeqAdUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyAdInnerUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.utils.ReadInJoyTelePhoneUtils;
import com.tencent.biz.pubaccount.readinjoyAd.ad.view.ReadInJoyArticleBottomVideoView.Builder;
import com.tencent.mobileqq.kandian.ad.api.IRIJFastWebAdService;
import com.tencent.mobileqq.kandian.biz.fastweb.ResponseCallback;
import com.tencent.mobileqq.kandian.biz.fastweb.data.AdData;
import com.tencent.mobileqq.kandian.biz.pts.ItemCreator;
import com.tencent.mobileqq.kandian.repo.feeds.entity.BaseData;
import java.util.List;
import org.json.JSONObject;

public class RIJFastWebAdServiceImpl
  implements IRIJFastWebAdService
{
  public void addBottomAd(List<BaseData> paramList1, List<BaseData> paramList2)
  {
    FastWebAdtUtil.a(paramList1, paramList2);
  }
  
  public void addHotRecommend(List<BaseData> paramList1, List<BaseData> paramList2, BaseData paramBaseData)
  {
    if ((paramList1 != null) && (paramList2 != null))
    {
      if (!(paramBaseData instanceof RecommendAdData)) {
        return;
      }
      int i = 0;
      int j = 0;
      int k = 0;
      while (i < paramList1.size())
      {
        if (((BaseData)paramList1.get(i)).aW == 1) {
          k = i;
        }
        if (((BaseData)paramList1.get(i)).aW == 2) {
          j = i;
        }
        i += 1;
      }
      i = j - k;
      if (i > 4)
      {
        ((RecommendAdData)paramBaseData).a = 5;
        paramList2.add(paramBaseData);
        return;
      }
      if ((i >= 1) && (i <= 4))
      {
        paramList1 = (RecommendAdData)paramBaseData;
        paramList1.a = (j + 1);
        paramList1.b = true;
        paramList2.add(paramBaseData);
      }
    }
  }
  
  public void addInnerAd(List<BaseData> paramList1, List<BaseData> paramList2)
  {
    FastWebAdtUtil.b(paramList1, paramList2);
  }
  
  public void cancelDisLikeAdPopWindow() {}
  
  public void fixInnerAndBottmAd(List<BaseData> paramList)
  {
    FastWebAdtUtil.a(paramList);
  }
  
  public void getAdData(String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean, String paramString5, String paramString6, String paramString7, int paramInt1, long paramLong, ResponseCallback paramResponseCallback, int paramInt2)
  {
    FastWebAdtUtil.a(paramString1, paramString2, paramString3, paramString4, paramBoolean, paramString5, paramString6, paramString7, paramInt1, paramLong, paramResponseCallback, paramInt2);
  }
  
  public int getHotArticleRecommendGap()
  {
    return 4;
  }
  
  public ViewBase.IBuilder getReadInJoyArticleBottomVideoViewBuilder()
  {
    return new ReadInJoyArticleBottomVideoView.Builder();
  }
  
  public JSONObject getTelephoneSubmitInfo(int paramInt1, int paramInt2, String paramString, AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyTelePhoneUtils.a(paramInt1, paramInt2, paramString, paramAdvertisementInfo);
  }
  
  public Object[] getWebFastProteusAdCreators()
  {
    return new ItemCreator[] { new WebFastProteusAdInnerCreator(), new WebFastProteusViewAdCreator(), new WebFastProteusViewAdBannerBigPicCreator(), new WebFastProteusViewAdBannerVideoCreator() };
  }
  
  public boolean instanceofProteusBannerVideoItemData(Object paramObject)
  {
    return paramObject instanceof ProteusBannerVideoItemData;
  }
  
  public boolean isAutomaticGlide()
  {
    String str = Aladdin.getConfig(509).getString("automatic_glide_enable", "1");
    return (str == null) || (!str.equals("0"));
  }
  
  public boolean isBottomAd(Object paramObject)
  {
    return ((paramObject instanceof ProteusBannerBigPicItemData)) || ((paramObject instanceof ProteusBannerVideoItemData));
  }
  
  public boolean isGameComponentAndGetGiftType(AdData paramAdData)
  {
    return FastWeqAdUtils.c(paramAdData);
  }
  
  public boolean isGameComponentType(AdvertisementInfo paramAdvertisementInfo)
  {
    return FastWeqAdUtils.a(paramAdvertisementInfo);
  }
  
  public boolean isInnerSoftAd(AdData paramAdData)
  {
    return FastWeqAdUtils.i(paramAdData);
  }
  
  public boolean isTelephoneType(AdvertisementInfo paramAdvertisementInfo)
  {
    return ReadInJoyTelePhoneUtils.a(paramAdvertisementInfo);
  }
  
  public void jumpAd(Activity paramActivity, AdData paramAdData)
  {
    JumpAdUtils.a(paramActivity, paramAdData);
  }
  
  public String processTextLength(String paramString, int paramInt)
  {
    return ReadInJoyAdInnerUtils.a(paramString, paramInt);
  }
  
  public void removeBottomAd(List<BaseData> paramList)
  {
    FastWebAdtUtil.b(paramList);
  }
  
  public void removeInnerAd(List<BaseData> paramList)
  {
    FastWebAdtUtil.c(paramList);
  }
  
  public void requestTelephoneInfoAndCall(Context paramContext, AdvertisementInfo paramAdvertisementInfo)
  {
    ReadInJoyTelePhoneUtils.a(paramContext, paramAdvertisementInfo);
  }
  
  public void resetRecommendAdData(BaseData paramBaseData, int paramInt)
  {
    if ((paramBaseData instanceof RecommendAdData)) {
      ((RecommendAdData)paramBaseData).a(paramInt);
    }
  }
  
  public void setBannerVideoDataShowingGuide(Object paramObject, boolean paramBoolean)
  {
    ((ProteusBannerVideoItemData)paramObject).a = paramBoolean;
  }
  
  public void setCommonBarData(Activity paramActivity, CommonAdBar paramCommonAdBar, List paramList)
  {
    CommonAdFloatingBarUtils.a(paramActivity, paramCommonAdBar, paramList);
  }
  
  public void updateSoftAdBar(CommonAdBar paramCommonAdBar, boolean paramBoolean1, int paramInt1, int paramInt2, int paramInt3, boolean paramBoolean2)
  {
    if ((paramCommonAdBar != null) && (paramCommonAdBar.getUIDelegate() != null))
    {
      IUIDelegate localIUIDelegate = paramCommonAdBar.getUIDelegate();
      boolean bool2 = localIUIDelegate.e;
      if (CommonAdFloatingBarUtils.a(localIUIDelegate))
      {
        boolean bool1;
        if ((localIUIDelegate instanceof GamesComponentAdDelegate)) {
          bool1 = ((GamesComponentAdDelegate)localIUIDelegate).f();
        } else {
          bool1 = false;
        }
        if ((localIUIDelegate.a == 2) && (CommonAdFloatingBarUtils.a(paramInt1, paramInt2, paramInt3, bool1, paramBoolean1, bool2)))
        {
          paramCommonAdBar.setVisibility(0);
          localIUIDelegate.e();
          return;
        }
        if ((localIUIDelegate.a == 1) && (CommonAdFloatingBarUtils.a(paramBoolean1, paramBoolean2, bool2)) && (localIUIDelegate.g != null) && (localIUIDelegate.g.aF == 1))
        {
          paramCommonAdBar.setVisibility(0);
          localIUIDelegate.e();
          return;
        }
        paramCommonAdBar.setVisibility(8);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJFastWebAdServiceImpl
 * JD-Core Version:    0.7.0.1
 */