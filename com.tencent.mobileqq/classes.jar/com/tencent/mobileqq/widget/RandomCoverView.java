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
import bhgr;
import bhhz;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.immersive.ImmersiveUtils;

public class RandomCoverView
  extends FrameLayout
{
  protected int a;
  protected Paint a;
  private View jdField_a_of_type_AndroidViewView;
  protected URLDrawable a;
  private URLImageView jdField_a_of_type_ComTencentImageURLImageView;
  protected QQAppInterface a;
  protected String a;
  protected boolean a;
  protected String b;
  protected boolean b;
  
  public RandomCoverView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    a();
  }
  
  public RandomCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    a();
  }
  
  public RandomCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Int = 0;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    for (;;)
    {
      try
      {
        if (!ThemeUtil.isInNightMode(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface)) {
          continue;
        }
        i = -1308622848;
        this.jdField_a_of_type_AndroidViewView.setBackgroundColor(i);
      }
      catch (Throwable localThrowable)
      {
        int i;
        FrameLayout.LayoutParams localLayoutParams;
        continue;
      }
      localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
      super.addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
      super.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
      this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
      return;
      i = getResources().getColor(2131165489);
    }
  }
  
  public int a()
  {
    return this.jdField_a_of_type_Int;
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentImageURLImageView;
  }
  
  public void a(int paramInt)
  {
    if (paramInt == this.jdField_a_of_type_Int) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int == 1)
    {
      localLayoutParams = getLayoutParams();
      if (localLayoutParams != null)
      {
        paramInt = getResources().getDimensionPixelSize(2131299011);
        int i = ImmersiveUtils.getStatusBarHeight(getContext());
        int j = getResources().getDimensionPixelSize(2131297490);
        localLayoutParams.width = -1;
        localLayoutParams.height = (paramInt + j + i);
        setLayoutParams(localLayoutParams);
      }
      this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131167252));
      this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(8);
      return;
    }
    ViewGroup.LayoutParams localLayoutParams = getLayoutParams();
    if (localLayoutParams != null)
    {
      localLayoutParams.width = -1;
      localLayoutParams.height = getResources().getDimensionPixelSize(2131297499);
      setLayoutParams(localLayoutParams);
    }
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131165489));
    this.jdField_a_of_type_ComTencentImageURLImageView.setVisibility(0);
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, int paramInt, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    a(paramInt);
    if (TextUtils.isEmpty(paramString2))
    {
      setDefaultCoverBg();
      if ((!paramQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString)) || ((!TextUtils.isEmpty(paramString2)) && (!paramBoolean1))) {
        break label149;
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        float f = bhgr.a(getContext(), 14.0F);
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#4CFFFFFF"));
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f);
      }
      this.jdField_b_of_type_JavaLangString = getResources().getString(2131694478);
    }
    label149:
    for (this.jdField_a_of_type_Boolean = true;; this.jdField_a_of_type_Boolean = false)
    {
      this.jdField_b_of_type_Boolean = paramBoolean2;
      return;
      a(paramString2, paramBoolean1);
      break;
    }
  }
  
  public void a(String paramString, int paramInt1, int paramInt2)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject = URLDrawable.URLDrawableOptions.obtain();
        if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
        }
        Drawable localDrawable;
        for (((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();; ((URLDrawable.URLDrawableOptions)localObject).mFailedDrawable = localDrawable)
        {
          ((URLDrawable.URLDrawableOptions)localObject).mRequestHeight = paramInt2;
          ((URLDrawable.URLDrawableOptions)localObject).mRequestWidth = paramInt1;
          localObject = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject);
          this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject);
          this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          this.jdField_a_of_type_AndroidViewView.setVisibility(0);
          this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131165493));
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.profilecard.", 2, "updateCover " + paramString);
          return;
          localDrawable = getResources().getDrawable(2130845745);
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        }
        return;
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
        if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();
        }
        Object localObject2;
        for (((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable.getCurrDrawable();; ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2))
        {
          localObject2 = (Activity)getContext();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = bhhz.d((Activity)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = bhhz.c((Activity)localObject2);
          localObject1 = URLDrawable.getDrawable(paramString, (URLDrawable.URLDrawableOptions)localObject1);
          this.jdField_a_of_type_ComTencentImageURLDrawable = ((URLDrawable)localObject1);
          this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
          this.jdField_a_of_type_Boolean = paramBoolean;
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.profilecard.", 2, "updateCover " + paramString + " isDef:" + paramBoolean);
          return;
          localObject2 = getResources().getDrawable(2130845745);
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = ((Drawable)localObject2);
        }
        return;
      }
      catch (OutOfMemoryError paramString)
      {
        QLog.e("Q.profilecard.", 1, "updateCover OutOfMemoryError happened.", paramString);
        return;
      }
      catch (Exception paramString)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.profilecard.", 2, paramString.toString());
        }
      }
    }
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    if ((this.jdField_a_of_type_AndroidGraphicsPaint != null) && (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) && (getHeight() != 0) && (getWidth() != 0) && (this.jdField_a_of_type_Boolean) && (this.jdField_b_of_type_Boolean))
    {
      float f = this.jdField_a_of_type_AndroidGraphicsPaint.measureText(this.jdField_b_of_type_JavaLangString);
      int i = getHeight() / 2;
      int j = (getWidth() - (int)f) / 2;
      paramCanvas.drawText(this.jdField_b_of_type_JavaLangString, j, i, this.jdField_a_of_type_AndroidGraphicsPaint);
    }
  }
  
  public void setDefaultCoverBg()
  {
    this.jdField_a_of_type_AndroidViewView.setVisibility(8);
    this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RandomCoverView
 * JD-Core Version:    0.7.0.1
 */