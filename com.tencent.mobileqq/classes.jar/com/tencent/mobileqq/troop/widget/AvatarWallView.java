package com.tencent.mobileqq.troop.widget;

import ajrw;
import android.content.Context;
import android.graphics.Bitmap;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.MeasureSpec;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.ListAdapter;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemLongClickListener;
import com.tencent.widget.GridView;

public class AvatarWallView
  extends GridView
  implements AdapterView.OnItemLongClickListener
{
  public int a;
  protected WindowManager.LayoutParams a;
  protected WindowManager a;
  Animation.AnimationListener a;
  protected ImageView a;
  public AvatarWallAdapter a;
  protected boolean a;
  protected int b;
  protected boolean b;
  protected int c;
  protected boolean c;
  protected int d;
  public boolean d;
  protected int e;
  public boolean e;
  protected int f = 4;
  public int g = 1;
  public int h = 38;
  protected int i;
  int j;
  int k;
  public int l = -1;
  int m;
  int n = -1;
  public int o = 0;
  
  public AvatarWallView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AvatarWallView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 16842868);
  }
  
  public AvatarWallView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Int = -1;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener = new ajrw(this);
    setOnItemLongClickListener(this);
    setChildrenDrawingOrderEnabled(true);
  }
  
  private void b()
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c(false);
  }
  
  private void c(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.c(true);
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.notifyDataSetChanged();
  }
  
  public Animation a(float paramFloat1, float paramFloat2)
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(1, 0.0F, 1, paramFloat1, 1, 0.0F, 1, paramFloat2);
    localTranslateAnimation.setFillAfter(true);
    localTranslateAnimation.setDuration(300L);
    return localTranslateAnimation;
  }
  
  protected void a()
  {
    if (this.i != this.m)
    {
      if ((!this.jdField_e_of_type_Boolean) || (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_a_of_type_Boolean)) {
        break label74;
      }
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.d();
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Int != -1))
      {
        this.jdField_b_of_type_Boolean = true;
        this.jdField_a_of_type_AndroidViewWindowManager.removeView(this.jdField_a_of_type_AndroidWidgetImageView);
        this.jdField_a_of_type_AndroidWidgetImageView = null;
      }
      return;
      label74:
      this.jdField_d_of_type_Boolean = true;
    }
  }
  
  protected void a(int paramInt1, int paramInt2)
  {
    if (!this.jdField_e_of_type_Boolean) {}
    do
    {
      return;
      paramInt1 = pointToPosition(paramInt1, paramInt2);
    } while ((paramInt1 >= this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_b_of_type_Int - this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_d_of_type_Int) || (paramInt1 == this.m) || (paramInt1 == -1));
    if (this.jdField_e_of_type_Boolean) {
      this.jdField_e_of_type_Boolean = false;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.getCount();
    this.l = paramInt1;
    int i3 = this.l - this.m;
    int i4 = Math.abs(i3);
    this.o = i4;
    this.n = this.m;
    int i1 = 0;
    if (i1 < i4)
    {
      label144:
      int i2;
      View localView;
      if (i3 > 0) {
        if (this.n / this.f == (this.n + 1) / this.f)
        {
          paramInt1 = 0;
          paramInt2 = -1;
          this.n += 1;
          i2 = paramInt2;
          paramInt2 = paramInt1;
          localView = getChildAt(this.n);
          if (localView != null) {
            break label248;
          }
        }
      }
      for (;;)
      {
        i1 += 1;
        break;
        paramInt2 = this.f - 1;
        paramInt1 = -1;
        break label144;
        if (this.n / this.f == (this.n - 1) / this.f)
        {
          paramInt2 = 0;
          paramInt1 = 1;
        }
        for (;;)
        {
          this.n -= 1;
          i2 = paramInt1;
          break;
          paramInt1 = 1 - this.f;
          paramInt2 = 1;
        }
        label248:
        Animation localAnimation = a(i2, paramInt2);
        localAnimation.setAnimationListener(this.jdField_a_of_type_AndroidViewAnimationAnimation$AnimationListener);
        localView.startAnimation(localAnimation);
      }
    }
    this.m = this.l;
  }
  
  protected void a(Bitmap paramBitmap)
  {
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams = new WindowManager.LayoutParams();
    this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.gravity = 51;
    int i1 = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a();
    int i2 = Math.max(paramBitmap.getHeight(), paramBitmap.getWidth());
    if (i1 > i2) {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = i1;
    }
    for (this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = i1;; this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.width = i2)
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.format = 1;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = this.jdField_d_of_type_Int;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = this.jdField_e_of_type_Int;
      ImageView localImageView = new ImageView(getContext());
      localImageView.setImageBitmap(paramBitmap);
      localImageView.setBackgroundResource(2130840514);
      this.jdField_a_of_type_AndroidViewWindowManager = ((WindowManager)getContext().getSystemService("window"));
      this.jdField_a_of_type_AndroidViewWindowManager.addView(localImageView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
      this.jdField_a_of_type_AndroidWidgetImageView = localImageView;
      this.o = 0;
      return;
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.height = i2;
    }
  }
  
  public boolean a(AdapterView paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    if (!this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_c_of_type_Boolean) {}
    boolean bool;
    do
    {
      return false;
      bool = this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.a(paramInt);
    } while ((paramInt >= this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter.jdField_b_of_type_Int) || (bool));
    this.m = paramInt;
    this.jdField_a_of_type_Int = paramInt;
    this.i = paramInt;
    paramAdapterView = new int[2];
    this.jdField_b_of_type_Boolean = false;
    paramView.getLocationOnScreen(paramAdapterView);
    this.jdField_d_of_type_Int = (paramAdapterView[0] + this.g);
    this.jdField_e_of_type_Int = (paramAdapterView[1] - this.h + this.g);
    this.jdField_b_of_type_Int = (this.jdField_d_of_type_Int - this.j);
    this.jdField_c_of_type_Int = (this.jdField_e_of_type_Int - this.k);
    paramView.destroyDrawingCache();
    paramView.setDrawingCacheEnabled(true);
    a(Bitmap.createBitmap(paramView.getDrawingCache(true)));
    b();
    paramView.setVisibility(4);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_e_of_type_Boolean = true;
    return true;
  }
  
  protected void b(int paramInt1, int paramInt2)
  {
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (!this.jdField_b_of_type_Boolean))
    {
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.x = (this.jdField_b_of_type_Int + paramInt1);
      this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams.y = (this.jdField_c_of_type_Int + paramInt2);
      this.jdField_a_of_type_AndroidViewWindowManager.updateViewLayout(this.jdField_a_of_type_AndroidWidgetImageView, this.jdField_a_of_type_AndroidViewWindowManager$LayoutParams);
    }
  }
  
  public int c()
  {
    return this.f;
  }
  
  protected int getChildDrawingOrder(int paramInt1, int paramInt2)
  {
    ListAdapter localListAdapter = a();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (localListAdapter != null)
    {
      localObject1 = localObject2;
      if ((a().getItem(paramInt1 - 1) instanceof AvatarWallAdapter.AvatarInfo)) {
        localObject1 = (AvatarWallAdapter.AvatarInfo)a().getItem(paramInt1 - 1);
      }
    }
    int i1;
    if (localObject1 != null) {
      if ((((AvatarWallAdapter.AvatarInfo)localObject1).d != null) && (((AvatarWallAdapter.AvatarInfo)localObject1).d.equals("PLUS"))) {
        i1 = paramInt1 - 1;
      }
    }
    while (i1 > 4) {
      if (paramInt2 == paramInt1 - 1)
      {
        return 3;
        i1 = paramInt1;
        continue;
        i1 = paramInt1;
      }
      else
      {
        if (paramInt2 == paramInt1 - 2) {
          return 4;
        }
        if (paramInt2 == 4) {
          return paramInt1 - 2;
        }
        if (paramInt2 == 3) {
          return paramInt1 - 1;
        }
      }
    }
    return super.getChildDrawingOrder(paramInt1, paramInt2);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter == null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopWidgetAvatarWallAdapter = ((AvatarWallAdapter)a());
    }
    this.j = ((int)paramMotionEvent.getRawX());
    this.k = ((int)paramMotionEvent.getRawY());
    return super.onInterceptTouchEvent(paramMotionEvent);
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, View.MeasureSpec.makeMeasureSpec(536870911, -2147483648));
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i1;
    int i2;
    if ((this.jdField_a_of_type_AndroidWidgetImageView != null) && (this.jdField_a_of_type_Int != -1))
    {
      i1 = (int)paramMotionEvent.getRawX();
      i2 = (int)paramMotionEvent.getRawY();
      switch (paramMotionEvent.getAction())
      {
      }
    }
    for (;;)
    {
      return super.onTouchEvent(paramMotionEvent);
      b(i1, i2);
      a((int)paramMotionEvent.getX(), (int)paramMotionEvent.getY());
      continue;
      a();
      c(i1, i2);
    }
  }
  
  public void setNumColumns(int paramInt)
  {
    this.f = paramInt;
    super.setNumColumns(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\b.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.AvatarWallView
 * JD-Core Version:    0.7.0.1
 */