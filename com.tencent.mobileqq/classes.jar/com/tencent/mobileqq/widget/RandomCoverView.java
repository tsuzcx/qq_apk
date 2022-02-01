package com.tencent.mobileqq.widget;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.shortvideo.util.ScreenUtil;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.mobileqq.vas.theme.api.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class RandomCoverView
  extends FrameLayout
{
  protected QQAppInterface a;
  protected String b;
  protected Paint c = null;
  protected String d = null;
  protected boolean e = true;
  protected URLDrawable f = null;
  protected boolean g = false;
  protected int h = 0;
  private URLImageView i = null;
  private View j = null;
  
  public RandomCoverView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public RandomCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  public RandomCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    a();
  }
  
  private void a()
  {
    this.i = new URLImageView(getContext());
    this.j = new View(getContext());
    try
    {
      int k;
      if (ThemeUtil.isInNightMode(this.a)) {
        k = -1308622848;
      } else {
        k = getResources().getColor(2131165800);
      }
      this.j.setBackgroundColor(k);
    }
    catch (Throwable localThrowable)
    {
      label64:
      FrameLayout.LayoutParams localLayoutParams;
      break label64;
    }
    localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    super.addView(this.i, localLayoutParams);
    super.addView(this.j, localLayoutParams);
    this.i.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public void a(int paramInt)
  {
    if (paramInt == this.h) {
      return;
    }
    this.h = paramInt;
    if (this.h == 1)
    {
      localLayoutParams = getLayoutParams();
      if (localLayoutParams != null)
      {
        paramInt = getResources().getDimensionPixelSize(2131299920);
        int k = ImmersiveUtils.getStatusBarHeight(getContext());
        int m = getResources().getDimensionPixelSize(2131298268);
        localLayoutParams.width = -1;
        localLayoutParams.height = (m + paramInt + k);
        setLayoutParams(localLayoutParams);
      }
      this.j.setBackgroundColor(getResources().getColor(2131168381));
      this.i.setVisibility(8);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = -1;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131298277);
      setLayoutParams(localLayoutParams);
    }
    this.j.setBackgroundColor(getResources().getColor(2131165800));
    this.i.setVisibility(0);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.a = paramQQAppInterface;
    this.b = paramString1;
    a(paramInt);
    if (TextUtils.isEmpty(paramString2)) {
      setDefaultCoverBg();
    } else {
      a(paramString2, paramBoolean1);
    }
    if ((paramQQAppInterface.getCurrentAccountUin().equals(this.b)) && ((TextUtils.isEmpty(paramString2)) || (paramBoolean1)))
    {
      if (this.c == null)
      {
        float f1 = DisplayUtil.a(getContext(), 14.0F);
        this.c = new Paint();
        this.c.setAntiAlias(true);
        this.c.setColor(Color.parseColor("#4CFFFFFF"));
        this.c.setTextSize(f1);
      }
      this.d = getResources().getString(2131892749);
      this.e = true;
    }
    else
    {
      this.e = false;
    }
    this.g = paramBoolean2;
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        if (this.f != null)
        {
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.f.getCurrDrawable();
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.f.getCurrDrawable();
        }
        else
        {
          Drawable localDrawable = getResources().getDrawable(2130847393);
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
          ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable;
        }
        ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
        ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = ScreenUtil.getInstantScreenWidth(getContext());
        localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
        this.f = ((URLDrawable)localObject);
        this.i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.i.setImageDrawable((Drawable)localObject);
        this.j.setVisibility(0);
        this.j.setBackgroundColor(getResources().getColor(2131165804));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateCover ");
          ((StringBuilder)localObject).append(paramString);
          QLog.i("Q.profilecard.", 2, ((StringBuilder)localObject).toString());
          return;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.", 2, paramString.toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, paramString.toString());
        }
      }
    }
  }
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        if (this.f != null)
        {
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.f.getCurrDrawable();
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.f.getCurrDrawable();
        }
        else
        {
          localObject2 = getResources().getDrawable(2130847393);
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2);
        }
        Object localObject2 = (Activity)getContext();
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ProfileCardUtil.d((Activity)localObject2);
        ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ProfileCardUtil.c((Activity)localObject2);
        localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
        this.f = ((URLDrawable)localObject1);
        this.i.setScaleType(ImageView.ScaleType.CENTER_CROP);
        this.i.setImageDrawable((Drawable)localObject1);
        this.e = paramBoolean;
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("updateCover ");
          ((StringBuilder)localObject1).append(paramString);
          ((StringBuilder)localObject1).append(" isDef:");
          ((StringBuilder)localObject1).append(paramBoolean);
          QLog.i("Q.profilecard.", 2, ((StringBuilder)localObject1).toString());
          return;
        }
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel())
        {
          QLog.i("Q.profilecard.", 2, paramString.toString());
          return;
        }
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("Q.profilecard.", 1, "updateCover OutOfMemoryError happened.", paramString);
      }
    }
  }
  
  public View getCoverMask()
  {
    return this.j;
  }
  
  public int getCoverMode()
  {
    return this.h;
  }
  
  public URLImageView getCoverView()
  {
    return this.i;
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.c != null) && (!TextUtils.isEmpty(this.d)) && (getHeight() != 0) && (getWidth() != 0) && (this.e) && (this.g))
    {
      float f1 = this.c.measureText(this.d);
      int k = getHeight() / 2;
      int m = (getWidth() - (int)f1) / 2;
      paramCanvas.drawText(this.d, m, k, this.c);
    }
  }
  
  public void setDefaultCoverBg()
  {
    this.j.setVisibility(8);
    this.i.setImageDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RandomCoverView
 * JD-Core Version:    0.7.0.1
 */