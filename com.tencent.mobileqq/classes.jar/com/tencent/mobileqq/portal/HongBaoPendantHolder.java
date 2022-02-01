package com.tencent.mobileqq.portal;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import com.tencent.mobileqq.utils.ValueAnimation;
import com.tencent.qphone.base.util.QLog;

public class HongBaoPendantHolder
  extends BaseAnimHolder
{
  public int a;
  public long a;
  public Context a;
  RectF jdField_a_of_type_AndroidGraphicsRectF = new RectF();
  public View a;
  private Interpolator jdField_a_of_type_AndroidViewAnimationInterpolator;
  BaseAnimHolder jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  ImageSwitchAnim jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
  ImageSwitchAnimView jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = null;
  public SaQianView a;
  public boolean a;
  public int b;
  public long b;
  RectF jdField_b_of_type_AndroidGraphicsRectF = new RectF();
  BaseAnimHolder jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  int jdField_c_of_type_Int;
  BaseAnimHolder jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder;
  int d;
  public int e = 2;
  public int f = 0;
  public int g = 0;
  public int h = 0;
  public int i = 0;
  private int o = 0;
  
  public HongBaoPendantHolder(View paramView)
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Int = 2;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_b_of_type_Long = 1L;
    this.jdField_a_of_type_AndroidViewView = paramView;
    this.jdField_a_of_type_AndroidContentContext = paramView.getContext();
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView = new SaQianView(paramView.getContext(), 0, 0, paramView);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramView.getWidth(), paramView.getHeight(), 0, 0);
    this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnimView = new ImageSwitchAnimView(this.jdField_a_of_type_AndroidContentContext);
  }
  
  public RectF a(int paramInt)
  {
    float f1 = this.l / 4;
    RectF localRectF = this.jdField_a_of_type_AndroidGraphicsRectF;
    float f2 = this.j;
    float f3 = this.k;
    float f4 = this.g;
    float f5 = paramInt;
    localRectF.set(f2 - f1, f3 - f1 + f4 - f5, this.j + this.l + f1, this.k + this.m + f1 + this.g - f5);
    return this.jdField_a_of_type_AndroidGraphicsRectF;
  }
  
  public void a()
  {
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    float f2 = (float)(AnimationUtils.currentAnimationTimeMillis() - this.jdField_a_of_type_Long);
    float f1 = 1.0F;
    f2 = f2 * 1.0F / (float)this.jdField_b_of_type_Long;
    Interpolator localInterpolator = this.jdField_a_of_type_AndroidViewAnimationInterpolator;
    if (localInterpolator != null)
    {
      float f3 = localInterpolator.getInterpolation(f2);
      if (f3 <= 1.0F) {
        f1 = f3;
      }
    }
    else
    {
      f1 = f2;
    }
    int j = this.i;
    a((int)(j + (this.h - j) * f1));
    if (f2 > 0.99D)
    {
      j = this.e;
      if (j != 1)
      {
        if (j != 3)
        {
          e();
          return;
        }
        this.e = 2;
        return;
      }
      this.e = 3;
      c();
    }
  }
  
  public void a(int paramInt)
  {
    float f1 = paramInt;
    int j = this.d;
    f1 = f1 * 1.0F / j;
    float f2 = this.jdField_c_of_type_Int - j;
    this.k = paramInt;
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).m = ((int)(f2 * f1) + paramInt);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
    if (localObject != null) {
      ((ImageSwitchAnim)localObject).d = paramInt;
    }
    localObject = this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).k = (paramInt + this.m + this.o);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView != null)
    {
      paramInt = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298317);
      this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramInt + this.j + this.l / 2, this.k);
    }
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, int paramInt4, View paramView)
  {
    super.a(paramInt1, paramInt2, paramInt3, paramInt4, paramView);
    this.jdField_a_of_type_Int = paramInt2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
    paramInt2 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298322);
    this.jdField_c_of_type_Int = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298321));
    paramInt3 = this.l / 2;
    paramInt4 = paramInt2 / 2;
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845438);
    this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramInt1 + paramInt3 - paramInt4, 0, paramInt2, this.jdField_c_of_type_Int, paramView);
  }
  
  public void a(int paramInt, long paramLong)
  {
    int j = this.jdField_a_of_type_Int;
    this.i = j;
    this.h = (j + paramInt);
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new DecelerateInterpolator();
    this.e = 1;
    a(paramLong);
  }
  
  public void a(long paramLong)
  {
    this.jdField_b_of_type_Long = paramLong;
    this.jdField_a_of_type_Long = AnimationUtils.currentAnimationTimeMillis();
    this.jdField_a_of_type_Boolean = true;
  }
  
  public void a(Bitmap paramBitmap)
  {
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("updatePendantLogo ,pendantLogoBitmap = ");
      ((StringBuilder)localObject).append(paramBitmap);
      ((StringBuilder)localObject).append(",switchAnim = ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim);
      QLog.d("HongBaoPendantHolder", 2, ((StringBuilder)localObject).toString());
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
    if (localObject != null) {
      ((ImageSwitchAnim)localObject).b(paramBitmap);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean)
    {
      this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
      int j = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298301);
      int k = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298298);
      int n = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298299);
      int m = this.jdField_a_of_type_AndroidViewView.getWidth() - n - j;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("init close Btn, mParentView.getWidth() = ");
        localStringBuilder.append(this.jdField_a_of_type_AndroidViewView.getWidth());
        localStringBuilder.append("closeBtnRightMargin = ");
        localStringBuilder.append(n);
        localStringBuilder.append("closeBtnWidth = ");
        localStringBuilder.append(j);
        localStringBuilder.append("closeBtnLeft = ");
        localStringBuilder.append(m);
        QLog.d("HongBaoPendantHolder", 2, localStringBuilder.toString());
      }
      n = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298300);
      this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845408);
      this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(m, n, j, k, this.jdField_a_of_type_AndroidViewView);
    }
    else
    {
      this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder = null;
    }
    a();
  }
  
  public void a(boolean paramBoolean, Bitmap paramBitmap)
  {
    Object localObject;
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("switchLogo ");
      ((StringBuilder)localObject).append(paramBitmap);
      QLog.d("HongBaoPendantHolder", 2, ((StringBuilder)localObject).toString());
    }
    try
    {
      int j = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298302);
      if (this.jdField_a_of_type_AndroidGraphicsDrawableDrawable == null) {
        this.jdField_a_of_type_AndroidGraphicsDrawableDrawable = new BitmapDrawable(this.jdField_a_of_type_AndroidContentContext.getResources(), BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130845272).copy(Bitmap.Config.ARGB_8888, true));
      }
      int k = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298319);
      int n = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298314);
      int m = (int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298318);
      n = this.jdField_a_of_type_AndroidViewView.getWidth() - k - n;
      this.d = m;
      localObject = paramBitmap;
      Bitmap localBitmap;
      if (paramBitmap == null) {
        try
        {
          if (this.jdField_b_of_type_Int == 1)
          {
            localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130845455);
            paramBitmap = (Bitmap)localObject;
          }
          else
          {
            localObject = BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130845273);
            paramBitmap = (Bitmap)localObject;
          }
          localObject = paramBitmap;
        }
        catch (OutOfMemoryError localOutOfMemoryError)
        {
          localOutOfMemoryError.printStackTrace();
          localBitmap = paramBitmap;
        }
      }
      float f1;
      float f4;
      float f2;
      float f3;
      float f5;
      if (this.jdField_b_of_type_Int == 1)
      {
        f1 = this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298305);
        f4 = localBitmap.getHeight() * f1 / localBitmap.getWidth();
        f2 = j - f4 - this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298309);
        f3 = this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298308);
        f5 = f1;
      }
      else
      {
        f1 = this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298304);
        f2 = j - f1 - this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298307);
        f3 = (k - f1) / 2.0F;
        f5 = f1;
        f4 = f1;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim = new ImageSwitchAnim(this.jdField_a_of_type_AndroidContentContext, k, j, n, m, (int)f3, (int)f2, (int)f5, (int)f4);
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.i = ((int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298316));
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.j = ((int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298315));
        try
        {
          this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.c(BitmapFactory.decodeResource(this.jdField_a_of_type_AndroidContentContext.getResources(), 2130845274));
        }
        catch (OutOfMemoryError paramBitmap)
        {
          paramBitmap.printStackTrace();
        }
      }
      paramBitmap = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
      paramBitmap.e = ((int)f3);
      paramBitmap.f = ((int)f2);
      paramBitmap.g = ((int)f5);
      paramBitmap.h = ((int)f4);
      if (this.jdField_b_of_type_Int == 1)
      {
        paramBitmap.k = ((int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298312));
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.l = ((int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298310));
      }
      else
      {
        paramBitmap.k = ((int)this.jdField_a_of_type_AndroidViewView.getResources().getDimension(2131298313));
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.l = 0;
      }
      if (this.jdField_b_of_type_Int == 3)
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.a(localBitmap);
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.a();
      }
      else
      {
        this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim.b(localBitmap);
      }
      a(n, m, k, j, this.jdField_a_of_type_AndroidViewView);
      if (paramBoolean)
      {
        this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder = null;
      }
      else
      {
        this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder = new BaseAnimHolder();
        this.o = ((int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298297));
        int i1 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298296);
        int i2 = (int)this.jdField_a_of_type_AndroidContentContext.getResources().getDimension(2131298295);
        k /= 2;
        int i3 = i1 / 2;
        int i4 = this.o;
        this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.jdField_a_of_type_AndroidGraphicsDrawableDrawable = this.jdField_a_of_type_AndroidContentContext.getResources().getDrawable(2130845266);
        this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(n + k - i3, m + j + i4, i1, i2, this.jdField_a_of_type_AndroidViewView);
      }
      a();
      return;
    }
    catch (OutOfMemoryError paramBitmap)
    {
      paramBitmap.printStackTrace();
    }
  }
  
  public boolean a(Canvas paramCanvas)
  {
    boolean bool3 = super.b();
    a();
    paramCanvas.save();
    paramCanvas.translate(0.0F, this.g);
    if ((this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.n != 0))
    {
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.n = this.n;
      this.jdField_a_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    super.c(paramCanvas);
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder;
    if (localObject != null) {
      ((BaseAnimHolder)localObject).a(paramCanvas);
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
    boolean bool2 = false;
    boolean bool1;
    if (localObject != null) {
      bool1 = ((ImageSwitchAnim)localObject).a(paramCanvas);
    } else {
      bool1 = false;
    }
    if ((this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder != null) && (this.n != 0))
    {
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.n = this.n;
      this.jdField_b_of_type_ComTencentMobileqqPortalBaseAnimHolder.a(paramCanvas);
    }
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.a(paramCanvas);
    paramCanvas.restore();
    if ((this.jdField_a_of_type_Boolean) || (bool3) || (bool1)) {
      bool2 = true;
    }
    return bool2;
  }
  
  public RectF b(int paramInt)
  {
    Object localObject = this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder;
    if (localObject != null)
    {
      float f1 = ((BaseAnimHolder)localObject).l;
      this.jdField_b_of_type_AndroidGraphicsRectF.set(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j - f1, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k - f1 + this.g, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.l + f1, this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k + this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.m + f1 + this.g);
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getCloseBtnTouchRect debug click event, span = ");
        ((StringBuilder)localObject).append(f1);
        ((StringBuilder)localObject).append(", closeBtnHolder.x = ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.j);
        ((StringBuilder)localObject).append(", closeBtnHolder.y = ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.k);
        ((StringBuilder)localObject).append(", closeBtnHolder.width = ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.l);
        ((StringBuilder)localObject).append(", closeBtnHolder.height = ");
        ((StringBuilder)localObject).append(this.jdField_c_of_type_ComTencentMobileqqPortalBaseAnimHolder.m);
        ((StringBuilder)localObject).append(", offsetY = ");
        ((StringBuilder)localObject).append(this.g);
        ((StringBuilder)localObject).append(", listViewScrollY = ");
        ((StringBuilder)localObject).append(paramInt);
        ((StringBuilder)localObject).append(", closeBtnTouchRect = ");
        ((StringBuilder)localObject).append(this.jdField_b_of_type_AndroidGraphicsRectF);
        QLog.d("HongBaoPendantHolder", 2, ((StringBuilder)localObject).toString());
      }
      return this.jdField_b_of_type_AndroidGraphicsRectF;
    }
    return null;
  }
  
  public void b()
  {
    super.b();
    e();
    this.jdField_b_of_type_Float = 1.0F;
    this.jdField_a_of_type_Float = 1.0F;
    ImageSwitchAnim localImageSwitchAnim = this.jdField_a_of_type_ComTencentMobileqqPortalImageSwitchAnim;
    if (localImageSwitchAnim != null)
    {
      localImageSwitchAnim.jdField_b_of_type_Float = 1.0F;
      localImageSwitchAnim.jdField_a_of_type_Float = 1.0F;
    }
  }
  
  public void c()
  {
    this.i = this.k;
    this.h = this.jdField_a_of_type_Int;
    this.e = 3;
    this.jdField_a_of_type_AndroidViewAnimationInterpolator = new BounceInterpolatorX();
    a(1500L);
  }
  
  public void d()
  {
    ValueAnimation localValueAnimation = new ValueAnimation(Float.valueOf(1.0F), Float.valueOf(1.07F), new HongBaoPendantHolder.1(this));
    localValueAnimation.setDuration(500L);
    localValueAnimation.setRepeatCount(-1);
    localValueAnimation.setRepeatMode(2);
    a(localValueAnimation);
    this.jdField_a_of_type_ComTencentMobileqqPortalSaQianView.b();
  }
  
  public void e()
  {
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Long = -1L;
    this.jdField_b_of_type_Long = 1L;
    this.e = 2;
    a(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.portal.HongBaoPendantHolder
 * JD-Core Version:    0.7.0.1
 */