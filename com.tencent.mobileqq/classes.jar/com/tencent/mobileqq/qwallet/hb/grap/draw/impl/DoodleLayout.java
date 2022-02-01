package com.tencent.mobileqq.qwallet.hb.grap.draw.impl;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.support.v4.util.MQLruCache;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import com.tencent.mobileqq.activity.aio.doodle.DoodleItem;
import com.tencent.mobileqq.activity.aio.doodle.DoodleResHelper;
import com.tencent.mobileqq.app.GlobalImageCache;
import com.tencent.mobileqq.qqpay.ui.R.color;
import com.tencent.mobileqq.qqpay.ui.R.drawable;
import com.tencent.mobileqq.qqpay.ui.R.string;
import com.tencent.mobileqq.scribble.ResCallback;
import com.tencent.mobileqq.scribble.ResInfo;
import com.tencent.mobileqq.util.BitmapManager;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.widget.PhotoProgressDrawable;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class DoodleLayout
  extends RelativeLayout
  implements ResCallback
{
  private int jdField_a_of_type_Int = 0;
  private ImageView jdField_a_of_type_AndroidWidgetImageView;
  private DoodleLayout.DoodleLayoutListener jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleLayout$DoodleLayoutListener;
  private DoodleView jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView;
  private QQToast jdField_a_of_type_ComTencentMobileqqWidgetQQToast;
  private ImageView b;
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    b();
  }
  
  public DoodleLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    b();
  }
  
  private Drawable a(int paramInt1, int paramInt2)
  {
    PhotoProgressDrawable localPhotoProgressDrawable = new PhotoProgressDrawable(a(), 0, false);
    localPhotoProgressDrawable.setBounds(new Rect(0, 0, paramInt1, paramInt2));
    return localPhotoProgressDrawable;
  }
  
  private boolean a(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      localObject = this.b;
      if (localObject != null) {
        ((ImageView)localObject).setVisibility(8);
      }
      return false;
    }
    int i = DisplayUtil.a(getContext(), 50.0F);
    int j = DisplayUtil.a(getContext(), 37.0F);
    if (this.b == null)
    {
      this.b = new ImageView(getContext());
      localObject = new RelativeLayout.LayoutParams(i, j);
      ((RelativeLayout.LayoutParams)localObject).addRule(13, -1);
      this.b.setLayoutParams((ViewGroup.LayoutParams)localObject);
      this.b.setImageDrawable(a(i, j));
      addView(this.b);
    }
    Object localObject = this.b;
    if (localObject != null) {
      ((ImageView)localObject).setVisibility(0);
    }
    return true;
  }
  
  private void b()
  {
    RelativeLayout.LayoutParams localLayoutParams;
    if (this.jdField_a_of_type_AndroidWidgetImageView == null)
    {
      this.jdField_a_of_type_AndroidWidgetImageView = new ImageView(getContext());
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_AndroidWidgetImageView.setLayoutParams(localLayoutParams);
      addView(this.jdField_a_of_type_AndroidWidgetImageView);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView = new DoodleView(getContext(), null);
      localLayoutParams = new RelativeLayout.LayoutParams(-1, -1);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView.setLayoutParams(localLayoutParams);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView.setBackgroundColor(getResources().getColor(R.color.k));
      addView(this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView);
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView.a(new DoodleLayout.1(this));
    }
    setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    setBackgroundColor(-1);
    a(true, false);
  }
  
  public int a(boolean paramBoolean1, boolean paramBoolean2)
  {
    DoodleView localDoodleView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView;
    int i = 1;
    if (localDoodleView != null)
    {
      int k = localDoodleView.a(paramBoolean2);
      if (this.jdField_a_of_type_Int <= 0) {
        i = 0;
      }
      int j = k;
      if (paramBoolean1) {
        j = k + i;
      }
      return j;
    }
    if (!paramBoolean1) {
      return 0;
    }
    if (this.jdField_a_of_type_Int > 0) {
      return 1;
    }
    return 0;
  }
  
  protected Bitmap a()
  {
    Bitmap localBitmap1;
    if (GlobalImageCache.a != null) {
      localBitmap1 = (Bitmap)GlobalImageCache.a.get("aio_doodle_progress_list");
    } else {
      localBitmap1 = null;
    }
    Bitmap localBitmap2 = localBitmap1;
    if (localBitmap1 == null)
    {
      localBitmap1 = BitmapManager.a(MobileQQ.getContext().getResources(), R.drawable.c);
      localBitmap2 = localBitmap1;
      if (localBitmap1 != null)
      {
        localBitmap2 = localBitmap1;
        if (GlobalImageCache.a != null)
        {
          GlobalImageCache.a.put("aio_doodle_progress_list", localBitmap1, (byte)0);
          localBitmap2 = localBitmap1;
        }
      }
    }
    return localBitmap2;
  }
  
  public DoodleItem a()
  {
    DoodleView localDoodleView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView;
    if (localDoodleView == null) {
      return null;
    }
    return localDoodleView.a(false);
  }
  
  public void a()
  {
    DoodleView localDoodleView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView;
    if ((localDoodleView != null) && (localDoodleView.a(false) > 0)) {
      this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView.a();
    }
  }
  
  public void a(View paramView, int paramInt1, ResInfo paramResInfo, int paramInt2)
  {
    if ((paramInt1 == 2) && (paramResInfo != null))
    {
      if (paramResInfo.b != this.jdField_a_of_type_Int) {
        return;
      }
      if (1 == paramInt2)
      {
        this.jdField_a_of_type_Int = -1;
        setTemplateID(paramResInfo.b);
        return;
      }
      if ((2 == paramInt2) || (3 == paramInt2))
      {
        a(false);
        if (this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast == null) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast = QQToast.a(getContext(), getResources().getString(R.string.jdField_a_of_type_Int), 0);
        }
        if (!this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.d()) {
          this.jdField_a_of_type_ComTencentMobileqqWidgetQQToast.a();
        }
      }
    }
  }
  
  public void a(boolean paramBoolean1, boolean paramBoolean2)
  {
    DoodleView localDoodleView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView;
    if (localDoodleView != null) {
      localDoodleView.a(paramBoolean2);
    }
    if (paramBoolean1)
    {
      this.jdField_a_of_type_Int = 0;
      setTemplateVisible(Boolean.valueOf(false));
    }
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction() & 0xFF;
    if (i == 0) {
      getParent().requestDisallowInterceptTouchEvent(true);
    } else if ((i == 1) || (i == 3)) {
      getParent().requestDisallowInterceptTouchEvent(false);
    }
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  public void setColor(int paramInt)
  {
    DoodleView localDoodleView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView;
    if (localDoodleView != null) {
      localDoodleView.setLineColor(paramInt);
    }
  }
  
  public void setDoodleLayoutListener(DoodleLayout.DoodleLayoutListener paramDoodleLayoutListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleLayout$DoodleLayoutListener = paramDoodleLayoutListener;
  }
  
  public void setTemplateID(int paramInt)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("setTemplateID:");
      ((StringBuilder)localObject).append(paramInt);
      QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
    }
    if (this.jdField_a_of_type_Int == paramInt) {
      return;
    }
    this.jdField_a_of_type_Int = paramInt;
    if (this.jdField_a_of_type_Int > 0)
    {
      localObject = DoodleResHelper.a().a(3, this.jdField_a_of_type_Int);
      ImageView localImageView;
      if (localObject != null)
      {
        localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localImageView != null)
        {
          localImageView.setImageBitmap((Bitmap)localObject);
          setTemplateVisible(Boolean.valueOf(true));
          a(false);
          return;
        }
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("load bitmap failed:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
      }
      if (!DoodleResHelper.a().b(3, this.jdField_a_of_type_Int))
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("file not exist, start download:");
          ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
          QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
        }
        a(true);
        setTemplateVisible(Boolean.valueOf(false));
        DoodleResHelper.a().b(1, paramInt, this, this);
        return;
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("try use drawable:");
        ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
        QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
      }
      localObject = DoodleResHelper.a().a(3, this.jdField_a_of_type_Int, false);
      if (localObject != null)
      {
        localImageView = this.jdField_a_of_type_AndroidWidgetImageView;
        if (localImageView != null)
        {
          localImageView.setImageDrawable((Drawable)localObject);
          setTemplateVisible(Boolean.valueOf(true));
          a(false);
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("use drawable succ:");
            ((StringBuilder)localObject).append(this.jdField_a_of_type_Int);
            QLog.d("DoodleLayout", 2, ((StringBuilder)localObject).toString());
          }
        }
      }
    }
    else
    {
      setTemplateVisible(Boolean.valueOf(false));
      a(false);
    }
  }
  
  public void setTemplateVisible(Boolean paramBoolean)
  {
    if (this.jdField_a_of_type_AndroidWidgetImageView != null)
    {
      if (paramBoolean.booleanValue())
      {
        this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
        return;
      }
      this.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
    }
  }
  
  public void setTexture(int paramInt)
  {
    DoodleView localDoodleView = this.jdField_a_of_type_ComTencentMobileqqQwalletHbGrapDrawImplDoodleView;
    if (localDoodleView != null) {
      localDoodleView.setLineTexture(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.draw.impl.DoodleLayout
 * JD-Core Version:    0.7.0.1
 */