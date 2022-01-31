package com.tencent.qqmini.sdk.core.proxy;

import android.content.Context;
import android.widget.ImageView;
import com.tencent.qqmini.sdk.launcher.shell.IMiniRuntime;

public abstract interface KingCardProxy
{
  public abstract ImageView getCapsuleButtonMoreView(Context paramContext);
  
  public abstract boolean showKingCardTips(IMiniRuntime paramIMiniRuntime, ImageView paramImageView);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.KingCardProxy
 * JD-Core Version:    0.7.0.1
 */