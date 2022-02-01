package com.tencent.mobileqq.widget.share;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import bjuk;

class ShareActionSheetV2$ActionSheetItemAdapter$IconFactory
{
  private final Drawable mIconBg;
  private final Drawable mIconMaskForPressedState;
  
  ShareActionSheetV2$ActionSheetItemAdapter$IconFactory(Context paramContext)
  {
    paramContext = paramContext.getResources();
    int i = 2130837561;
    if (bjuk.a()) {
      i = 2130837560;
    }
    this.mIconBg = paramContext.getDrawable(i);
    this.mIconMaskForPressedState = paramContext.getDrawable(2130837565);
  }
  
  private Drawable makeDisableDrawable(Drawable paramDrawable)
  {
    paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
    paramDrawable.setColorFilter(2147483647, PorterDuff.Mode.MULTIPLY);
    return paramDrawable;
  }
  
  private Drawable makePressedDrawable(Drawable paramDrawable)
  {
    return new LayerDrawable(new Drawable[] { paramDrawable, this.mIconMaskForPressedState });
  }
  
  Drawable addBackground(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    paramDrawable = new LayerDrawable(new Drawable[] { this.mIconBg, paramDrawable });
    paramDrawable.setLayerInset(1, paramInt1, paramInt2, paramInt1, paramInt2);
    return paramDrawable;
  }
  
  StateListDrawable makePressedStateListDrawable(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
    localStateListDrawable.addState(new int[0], paramDrawable1);
    return localStateListDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.ActionSheetItemAdapter.IconFactory
 * JD-Core Version:    0.7.0.1
 */