package com.tencent.mobileqq.kandian.ad.api.impl;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.activity.aio.AIOUtils;
import com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService;
import com.tencent.mobileqq.kandian.base.image.PublicDrawableUtil;
import com.tencent.mobileqq.urldrawable.URLDrawableDecodeHandler;

public class RIJAdUIServiceImpl
  implements IRIJAdUIService
{
  public int[] builderDecoderParams(int paramInt1, int paramInt2, int paramInt3)
  {
    return URLDrawableDecodeHandler.b(paramInt1, paramInt2, paramInt3);
  }
  
  public int dp2px(float paramFloat, Resources paramResources)
  {
    return AIOUtils.b(paramFloat, paramResources);
  }
  
  public DownloadParams.DecodeHandler getRoundCornerDecoder()
  {
    return URLDrawableDecodeHandler.i;
  }
  
  public float px2dp(int paramInt, Resources paramResources)
  {
    return AIOUtils.a(paramInt, paramResources);
  }
  
  public GradientDrawable setGradientDrawable(View paramView, float paramFloat, int paramInt)
  {
    return PublicDrawableUtil.a(paramView, paramFloat, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.impl.RIJAdUIServiceImpl
 * JD-Core Version:    0.7.0.1
 */