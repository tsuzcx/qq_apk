package com.tencent.mobileqq.kandian.ad.api;

import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.view.View;
import com.tencent.image.DownloadParams.DecodeHandler;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={"all"})
public abstract interface IRIJAdUIService
  extends QRouteApi
{
  public abstract int[] builderDecoderParams(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int dp2px(float paramFloat, Resources paramResources);
  
  public abstract DownloadParams.DecodeHandler getRoundCornerDecoder();
  
  public abstract float px2dp(int paramInt, Resources paramResources);
  
  public abstract GradientDrawable setGradientDrawable(View paramView, float paramFloat, @ColorInt int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.ad.api.IRIJAdUIService
 * JD-Core Version:    0.7.0.1
 */