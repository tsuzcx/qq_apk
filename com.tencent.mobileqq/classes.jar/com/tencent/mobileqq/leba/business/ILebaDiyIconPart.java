package com.tencent.mobileqq.leba.business;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;
import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;

@QAPI(process={""})
public abstract interface ILebaDiyIconPart
  extends QRouteApi
{
  public abstract boolean addPersonalBackgroundToIcon(Context paramContext, View paramView, int paramInt);
  
  public abstract boolean addPersonalBackgroundToIcon(ImageView paramImageView, Drawable paramDrawable, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.leba.business.ILebaDiyIconPart
 * JD-Core Version:    0.7.0.1
 */