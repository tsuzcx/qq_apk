package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import bglq;
import com.tencent.qqmini.sdk.core.proxy.KingCardProxy;
import com.tencent.qqmini.sdk.launcher.shell.IMiniRuntime;

public class KingCardProxyDefault
  implements KingCardProxy
{
  public static final String KINGCARD_GUIDE_DARK_LOTTIE = bglq.a("qqminiapp", "kingcardGuideDarkLottie", "https://d3g.qq.com/sngapp/app/update/20191105162320_6114/kingCardDark.zip");
  public static final String KINGCARD_GUIDE_ICON;
  public static final String KINGCARD_GUIDE_LOTTIE = bglq.a("qqminiapp", "kingcardGuideLottie", "https://d3g.qq.com/sngapp/app/update/20191105163020_3367/kingCard.zip");
  public static final String KINGCARD_GUIDE_TEXT = bglq.a("qqminiapp", "kingcardGuideText", "");
  
  static
  {
    KINGCARD_GUIDE_ICON = bglq.a("qqminiapp", "kingcardGuideIcon", "");
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
    return paramContext.getResources().getString(2131694345);
  }
  
  public boolean showKingCardTips(IMiniRuntime paramIMiniRuntime, ImageView paramImageView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.KingCardProxyDefault
 * JD-Core Version:    0.7.0.1
 */