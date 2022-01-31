package com.tencent.qqmini.sdk.core.proxy.service;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.widget.ImageView;
import bema;
import besz;
import com.tencent.qqmini.sdk.core.proxy.KingCardProxy;

public class KingCardProxyDefault
  implements KingCardProxy
{
  public static final String KINGCARD_GUIDE_DARK_LOTTIE = bema.a("qqminiapp", "kingcardGuideDarkLottie", "https://d3g.qq.com/sngapp/app/update/20191105162320_6114/kingCardDark.zip");
  public static final String KINGCARD_GUIDE_ICON;
  public static final String KINGCARD_GUIDE_LOTTIE = bema.a("qqminiapp", "kingcardGuideLottie", "https://d3g.qq.com/sngapp/app/update/20191105163020_3367/kingCard.zip");
  public static final String KINGCARD_GUIDE_TEXT = bema.a("qqminiapp", "kingcardGuideText", "");
  
  static
  {
    KINGCARD_GUIDE_ICON = bema.a("qqminiapp", "kingcardGuideIcon", "");
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
    return paramContext.getResources().getString(2131694224);
  }
  
  public boolean showKingCardTips(besz parambesz, ImageView paramImageView)
  {
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.KingCardProxyDefault
 * JD-Core Version:    0.7.0.1
 */