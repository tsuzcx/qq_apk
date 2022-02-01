package com.tencent.mobileqq.utils;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;

public class ShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory
{
  protected Drawable mIconBg;
  protected Drawable mIconMaskForPressedState;
  
  protected ShareActionSheetBuilder$ActionSheetItemAdapter$IconFactory(Context paramContext)
  {
    paramContext = paramContext.getResources();
    this.mIconBg = paramContext.getDrawable(2130837561);
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
 * Qualified Name:     com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemAdapter.IconFactory
 * JD-Core Version:    0.7.0.1
 */