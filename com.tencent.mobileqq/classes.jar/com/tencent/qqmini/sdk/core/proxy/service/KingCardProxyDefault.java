package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import com.tencent.qqmini.sdk.R.string;
import com.tencent.qqmini.sdk.annotation.ProxyService;
import com.tencent.qqmini.sdk.core.utils.WnsConfig;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.proxy.KingCardProxy;

@ProxyService(proxy=KingCardProxy.class)
public class KingCardProxyDefault
  implements KingCardProxy
{
  public static final String KINGCARD_GUIDE_DARK_LOTTIE = WnsConfig.getConfig("qqminiapp", "kingcardGuideDarkLottie", "https://d3g.qq.com/sngapp/app/update/20191105162320_6114/kingCardDark.zip");
  public static final String KINGCARD_GUIDE_ICON;
  public static final String KINGCARD_GUIDE_LOTTIE = WnsConfig.getConfig("qqminiapp", "kingcardGuideLottie", "https://d3g.qq.com/sngapp/app/update/20191105163020_3367/kingCard.zip");
  public static final String KINGCARD_GUIDE_TEXT = WnsConfig.getConfig("qqminiapp", "kingcardGuideText", "");
  
  static
  {
    KINGCARD_GUIDE_ICON = WnsConfig.getConfig("qqminiapp", "kingcardGuideIcon", "");
  }
  
  public ImageView getCapsuleButtonMoreView(Context paramContext)
  {
    return null;
  }
  
  protected String getKingCardText(Context paramContext)
  {
    if (!TextUtils.isEmpty(KINGCARD_GUIDE_TEXT)) {
      return KINGCARD_GUIDE_TEXT;
    }
    return paramContext.getResources().getString(R.string.mini_sdk_kingcard_tip);
  }
  
  public boolean showKingCardTips(IMiniAppContext paramIMiniAppContext, ImageView paramImageView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.KingCardProxyDefault
 * JD-Core Version:    0.7.0.1
 */