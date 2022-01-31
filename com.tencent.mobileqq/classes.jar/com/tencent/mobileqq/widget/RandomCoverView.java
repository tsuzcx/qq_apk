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
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import android.widget.ImageView.ScaleType;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLDrawable.URLDrawableOptions;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.util.ProfileCardUtil;
import com.tencent.qphone.base.util.QLog;

public class RandomCoverView
  extends FrameLayout
{
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
    a();
  }
  
  public RandomCoverView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  public RandomCoverView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_ComTencentImageURLImageView = new URLImageView(getContext());
    this.jdField_a_of_type_AndroidViewView = new View(getContext());
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(getResources().getColor(2131492886));
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-1, -1);
    super.addView(this.jdField_a_of_type_ComTencentImageURLImageView, localLayoutParams);
    super.addView(this.jdField_a_of_type_AndroidViewView, localLayoutParams);
    this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
  }
  
  public View a()
  {
    return this.jdField_a_of_type_AndroidViewView;
  }
  
  public URLImageView a()
  {
    return this.jdField_a_of_type_ComTencentImageURLImageView;
  }
  
  public void a(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, boolean paramBoolean1, boolean paramBoolean2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_JavaLangString = paramString1;
    if (TextUtils.isEmpty(paramString2))
    {
      setDefaultCoverBg();
      if ((!paramQQAppInterface.getCurrentAccountUin().equals(this.jdField_a_of_type_JavaLangString)) || ((!TextUtils.isEmpty(paramString2)) && (!paramBoolean1))) {
        break label141;
      }
      if (this.jdField_a_of_type_AndroidGraphicsPaint == null)
      {
        float f = DisplayUtil.a(getContext(), 14.0F);
        this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
        this.jdField_a_of_type_AndroidGraphicsPaint.setAntiAlias(true);
        this.jdField_a_of_type_AndroidGraphicsPaint.setColor(Color.parseColor("#4CFFFFFF"));
        this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f);
      }
      this.jdField_b_of_type_JavaLangString = getResources().getString(2131436747);
    }
    label141:
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
          this.jdField_a_of_type_ComTencentImageURLImageView.setScaleType(ImageView.ScaleType.FIT_XY);
          ((URLDrawable)localObject).setAlpha(234);
          this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject);
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("Q.profilecard.", 2, "updateCover " + paramString);
          return;
          localDrawable = getResources().getDrawable(2130843018);
          ((URLDrawable.URLDrawableOptions)localObject).mLoadingDrawable = localDrawable;
        }
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
  
  public void a(String paramString, boolean paramBoolean)
  {
    if (!TextUtils.isEmpty(paramString)) {
      try
      {
        Object localObject1 = URLDrawable.URLDrawableOptions.obtain();
        if (this.jdField_a_of_type_ComTencentImageURLDrawable != null) {
          ((URLDrawable.URLDrawableOptions)localObject1).mLoadingDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;
        }
        Object localObject2;
        for (((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = this.jdField_a_of_type_ComTencentImageURLDrawable;; ((URLDrawable.URLDrawableOptions)localObject1).mFailedDrawable = ((Drawable)localObject2))
        {
          localObject2 = (Activity)getContext();
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestHeight = ProfileCardUtil.d((Activity)localObject2);
          ((URLDrawable.URLDrawableOptions)localObject1).mRequestWidth = ProfileCardUtil.c((Activity)localObject2);
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
          localObject2 = getResources().getDrawable(2130843018);
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
    Object localObject2 = null;
    try
    {
      localObject1 = getResources().getDrawable(2130843018);
      this.jdField_a_of_type_ComTencentImageURLImageView.setImageDrawable((Drawable)localObject1);
      return;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      for (;;)
      {
        Object localObject1 = localObject2;
        if (QLog.isColorLevel())
        {
          QLog.i("Q.qzonecover.", 2, localOutOfMemoryError.toString());
          localObject1 = localObject2;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.widget.RandomCoverView
 * JD-Core Version:    0.7.0.1
 */