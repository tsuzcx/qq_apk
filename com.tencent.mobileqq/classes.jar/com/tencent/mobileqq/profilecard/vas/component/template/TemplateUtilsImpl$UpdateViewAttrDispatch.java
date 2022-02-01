package com.tencent.mobileqq.profilecard.vas.component.template;

import android.content.res.ColorStateList;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.os.Build.VERSION;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.mobileqq.profile.view.ShimmerLinearLayout;
import com.tencent.widget.ListView;
import com.tencent.widget.SingleLineTextView;

class TemplateUtilsImpl$UpdateViewAttrDispatch
{
  private void setViewPaddings(View paramView, Drawable paramDrawable)
  {
    paramDrawable = paramDrawable.getConstantState().newDrawable();
    Object localObject = new Rect();
    paramDrawable.getPadding((Rect)localObject);
    int i = paramView.getPaddingTop();
    int j = ((Rect)localObject).top;
    int k = paramView.getPaddingLeft();
    int m = ((Rect)localObject).left;
    int n = paramView.getPaddingRight();
    int i1 = ((Rect)localObject).right;
    int i2 = paramView.getPaddingBottom();
    int i3 = ((Rect)localObject).bottom;
    localObject = paramView.findViewById(2131374296);
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramView.setBackground(paramDrawable);
      if (localObject != null) {
        ((View)localObject).setBackground(paramDrawable);
      }
    }
    else
    {
      paramView.setBackgroundDrawable(paramDrawable);
      if (localObject != null) {
        ((View)localObject).setBackgroundDrawable(paramDrawable);
      }
    }
    paramView.setPadding(k + m, i + j, n + i1, i2 + i3);
  }
  
  void dispatchApngDrawable(String paramString, View paramView, Object paramObject)
  {
    if (!paramString.equals("apngDrawable")) {
      return;
    }
    if ((paramObject instanceof Drawable)) {
      ((ImageView)paramView).setImageDrawable((Drawable)paramObject);
    }
  }
  
  void dispatchBackground(String paramString, View paramView, Object paramObject)
  {
    if (!paramString.equals("background")) {
      return;
    }
    if ((paramObject instanceof Drawable))
    {
      setViewPaddings(paramView, (Drawable)paramObject);
      return;
    }
    if ((paramObject instanceof String))
    {
      paramString = (String)paramObject;
      if (paramString.startsWith("#")) {
        paramView.setBackgroundColor(Color.parseColor(paramString));
      }
    }
  }
  
  void dispatchColor(String paramString, View paramView, Object paramObject)
  {
    if (!paramString.equals("color")) {
      return;
    }
    if ((paramView instanceof TextView))
    {
      paramString = (TextView)paramView;
      if ((paramObject instanceof ColorStateList))
      {
        paramString.setTextColor((ColorStateList)paramObject);
      }
      else if ((paramObject instanceof String))
      {
        String str = (String)paramObject;
        if (str.startsWith("#")) {
          paramString.setTextColor(Color.parseColor(str));
        }
      }
    }
    if ((paramView instanceof SingleLineTextView))
    {
      paramString = (SingleLineTextView)paramView;
      if ((paramObject instanceof ColorStateList))
      {
        paramString.setTextColor((ColorStateList)paramObject);
        return;
      }
      if ((paramObject instanceof String))
      {
        paramView = (String)paramObject;
        if (paramView.startsWith("#")) {
          paramString.setTextColor(Color.parseColor(paramView));
        }
      }
    }
  }
  
  void dispatchContentBackground(String paramString, View paramView, Object paramObject)
  {
    if (!paramString.equals("contentBackground")) {
      return;
    }
    boolean bool = paramObject instanceof Drawable;
    if (bool)
    {
      paramString = (ListView)paramView;
      if (bool) {
        paramString.setContentBackground(((Drawable)paramObject).getConstantState().newDrawable());
      }
    }
  }
  
  void dispatchDrawableleft(String paramString, View paramView, Object paramObject)
  {
    if (!paramString.equals("drawableleft")) {
      return;
    }
    boolean bool = paramObject instanceof Drawable;
    if (bool)
    {
      paramString = (TextView)paramView;
      if (bool) {
        paramString.setCompoundDrawablesWithIntrinsicBounds(((Drawable)paramObject).getConstantState().newDrawable(), null, null, null);
      }
    }
  }
  
  void dispatchDrawableright(String paramString, View paramView, Object paramObject)
  {
    if (!paramString.equals("drawableright")) {
      return;
    }
    boolean bool = paramObject instanceof Drawable;
    if (bool)
    {
      paramString = (TextView)paramView;
      if (bool) {
        paramString.setCompoundDrawablesWithIntrinsicBounds(null, null, ((Drawable)paramObject).getConstantState().newDrawable(), null);
      }
    }
  }
  
  void dispatchShimmerMask(String paramString, View paramView, Object paramObject)
  {
    if (!paramString.equals("shimmer_mask")) {
      return;
    }
    if ((paramObject instanceof BitmapDrawable))
    {
      paramString = (BitmapDrawable)paramObject;
      ((ShimmerLinearLayout)paramView).setMask(paramString.getBitmap(), 1, 2000, 1000);
    }
  }
  
  void dispatchSrc(String paramString, View paramView, Object paramObject)
  {
    if (!paramString.equals("src")) {
      return;
    }
    boolean bool = paramObject instanceof Drawable;
    if (bool)
    {
      paramString = (ImageView)paramView;
      if (bool) {
        paramString.setImageDrawable(((Drawable)paramObject).getConstantState().newDrawable());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.vas.component.template.TemplateUtilsImpl.UpdateViewAttrDispatch
 * JD-Core Version:    0.7.0.1
 */