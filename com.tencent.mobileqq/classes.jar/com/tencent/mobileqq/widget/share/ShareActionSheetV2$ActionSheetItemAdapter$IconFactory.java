package com.tencent.mobileqq.widget.share;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff.Mode;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.graphics.drawable.LayerDrawable;
import android.graphics.drawable.StateListDrawable;
import com.tencent.mobileqq.utils.QQTheme;

class ShareActionSheetV2$ActionSheetItemAdapter$IconFactory
{
  private final Drawable a;
  private final Drawable b;
  private ShareActionSheetV2.ActionSheetItemAdapter c;
  
  ShareActionSheetV2$ActionSheetItemAdapter$IconFactory(Context paramContext, ShareActionSheetV2.ActionSheetItemAdapter paramActionSheetItemAdapter)
  {
    this.c = paramActionSheetItemAdapter;
    paramContext = paramContext.getResources();
    int i;
    if ((!QQTheme.isNowThemeIsNight()) && (!a())) {
      i = 2130837656;
    } else {
      i = 2130837655;
    }
    this.a = paramContext.getDrawable(i);
    this.b = paramContext.getDrawable(2130837660);
  }
  
  private Drawable a(Drawable paramDrawable)
  {
    return new LayerDrawable(new Drawable[] { paramDrawable, this.b });
  }
  
  private boolean a()
  {
    ShareActionSheetV2.ActionSheetItemAdapter localActionSheetItemAdapter = this.c;
    return (localActionSheetItemAdapter != null) && (ShareActionSheetV2.ActionSheetItemAdapter.a(localActionSheetItemAdapter));
  }
  
  private Drawable b(Drawable paramDrawable)
  {
    paramDrawable = paramDrawable.getConstantState().newDrawable().mutate();
    paramDrawable.setColorFilter(2147483647, PorterDuff.Mode.MULTIPLY);
    return paramDrawable;
  }
  
  Drawable a(Drawable paramDrawable, int paramInt1, int paramInt2)
  {
    paramDrawable = new LayerDrawable(new Drawable[] { this.a, paramDrawable });
    paramDrawable.setLayerInset(1, paramInt1, paramInt2, paramInt1, paramInt2);
    return paramDrawable;
  }
  
  StateListDrawable a(Drawable paramDrawable1, Drawable paramDrawable2)
  {
    StateListDrawable localStateListDrawable = new StateListDrawable();
    localStateListDrawable.addState(new int[] { 16842919 }, paramDrawable2);
    localStateListDrawable.addState(new int[0], paramDrawable1);
    return localStateListDrawable;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.share.ShareActionSheetV2.ActionSheetItemAdapter.IconFactory
 * JD-Core Version:    0.7.0.1
 */