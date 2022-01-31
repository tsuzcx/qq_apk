package com.tencent.mobileqq.hotchat.anim;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup.LayoutParams;
import android.view.animation.Animation;
import android.widget.ImageView.ScaleType;
import android.widget.RelativeLayout;
import android.widget.RelativeLayout.LayoutParams;
import aqyh;
import aqyj;
import aqyl;
import aqym;
import aqyn;
import auwu;
import bbql;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.image.URLImageView;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.hotchat.ui.PayLikeFloatViewBuilder.AnimationView;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class HeartLayout
  extends RelativeLayout
  implements aqyl
{
  public static final int[] a;
  public static Bitmap[] a;
  public static int c;
  public float a;
  public int a;
  public Rect a;
  public aqyh a;
  public aqym a;
  public Random a;
  public AtomicInteger a;
  public boolean a;
  public float b;
  public int b;
  public boolean b;
  public float c;
  public boolean c;
  
  static
  {
    jdField_a_of_type_ArrayOfInt = new int[] { Color.parseColor("#c797ff"), Color.parseColor("#80b9f4"), Color.parseColor("#67d0d7"), Color.parseColor("#67d78e"), Color.parseColor("#b5e255"), Color.parseColor("#f2c64f"), Color.parseColor("#f6a455"), Color.parseColor("#ff96b9"), Color.parseColor("#ff6a6a") };
  }
  
  public HeartLayout(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    a();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    a();
  }
  
  public HeartLayout(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
    a();
  }
  
  private void a(float paramFloat1, float paramFloat2)
  {
    if (this.jdField_a_of_type_AndroidGraphicsRect == null) {
      if (this.jdField_a_of_type_Aqym != null) {
        this.jdField_a_of_type_Aqym.a(this, paramFloat1, paramFloat2);
      }
    }
    while ((paramFloat1 < this.jdField_a_of_type_AndroidGraphicsRect.left) || (paramFloat1 > this.jdField_a_of_type_AndroidGraphicsRect.right) || (paramFloat2 < this.jdField_a_of_type_AndroidGraphicsRect.top) || (paramFloat2 > this.jdField_a_of_type_AndroidGraphicsRect.bottom) || (this.jdField_a_of_type_Aqym == null)) {
      return;
    }
    this.jdField_a_of_type_Aqym.a(this, paramFloat1, paramFloat2);
  }
  
  public aqyj a()
  {
    if (this.jdField_a_of_type_Aqyh != null) {
      return this.jdField_a_of_type_Aqyh.a();
    }
    return null;
  }
  
  public void a()
  {
    if (Build.VERSION.SDK_INT < 11)
    {
      this.jdField_a_of_type_Boolean = false;
      return;
    }
    this.jdField_c_of_type_Float = (ViewConfiguration.get(getContext()).getScaledTouchSlop() * 5);
    this.jdField_a_of_type_JavaUtilRandom = new Random(System.currentTimeMillis());
    this.jdField_a_of_type_Aqyh = new aqyh(this);
    this.jdField_a_of_type_Aqyh.a(this);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    a(null, paramBitmap, paramFloat1, paramFloat2, -1L, 0);
  }
  
  public void a(Bitmap paramBitmap, QQAppInterface paramQQAppInterface, aqyn paramaqyn, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    a(null, paramBitmap, paramQQAppInterface, paramaqyn, paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  public void a(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_Aqym != null) {
      this.jdField_a_of_type_Aqym.a(paramAnimation);
    }
  }
  
  public void a(auwu paramauwu, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    a(paramauwu, paramBitmap, paramFloat1, paramFloat2, -1L, 0);
  }
  
  public void a(auwu paramauwu, Bitmap paramBitmap, float paramFloat1, float paramFloat2, long paramLong, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Aqyh == null) || (paramBitmap == null)) {
      return;
    }
    String str = null;
    Bundle localBundle = null;
    Object localObject2 = localBundle;
    Object localObject1 = str;
    if (paramauwu != null)
    {
      if (paramBitmap == paramauwu.c)
      {
        localObject1 = paramauwu.g;
        localObject2 = paramauwu.c;
      }
    }
    else
    {
      paramauwu = new URLImageView(getContext());
      if (localObject1 == null) {
        break label255;
      }
      str = "praise?seed=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);
      localBundle = new Bundle();
      localBundle.getBoolean("key_use_cache", false);
      localObject1 = bbql.a(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject1, str, (Drawable)localObject2, new int[] { 14, 9, 15 }, "-praise-", localBundle);
      if (localObject1 == null) {
        break label239;
      }
      paramauwu.setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      paramauwu.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_a_of_type_Aqyh.a(paramauwu, paramFloat1, paramFloat2, this, paramLong, paramInt);
      return;
      localObject2 = localBundle;
      localObject1 = str;
      if (paramBitmap != paramauwu.b) {
        break;
      }
      localObject1 = paramauwu.f;
      localObject2 = paramauwu.b;
      break;
      label239:
      QLog.e("HeartLayout", 1, "addHeartWithDrawable apng.so load fail.");
      paramauwu.setImageBitmap(paramBitmap);
      continue;
      label255:
      paramauwu.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(auwu paramauwu, Bitmap paramBitmap, QQAppInterface paramQQAppInterface, aqyn paramaqyn, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Aqyh == null)) {
      return;
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    paramQQAppInterface = new PayLikeFloatViewBuilder.AnimationView(getContext(), paramQQAppInterface, paramaqyn);
    URLImageView localURLImageView = new URLImageView(getContext());
    paramaqyn = new RelativeLayout.LayoutParams(-2, -2);
    paramaqyn.addRule(13);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    localRelativeLayout.addView(localURLImageView, paramaqyn);
    localRelativeLayout.addView(paramQQAppInterface, (ViewGroup.LayoutParams)localObject1);
    localObject1 = null;
    Object localObject2 = null;
    paramaqyn = localObject2;
    paramQQAppInterface = (QQAppInterface)localObject1;
    if (paramauwu != null)
    {
      if (paramBitmap == paramauwu.c)
      {
        paramQQAppInterface = paramauwu.g;
        paramaqyn = paramauwu.c;
      }
    }
    else
    {
      if (paramQQAppInterface == null) {
        break label333;
      }
      paramauwu = "praise?seed=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      paramaqyn = new BitmapDrawable(getResources(), paramaqyn);
      localObject1 = new Bundle();
      ((Bundle)localObject1).getBoolean("key_use_cache", false);
      paramauwu = bbql.a(BaseApplicationImpl.sApplication.getRuntime(), paramQQAppInterface, paramauwu, paramaqyn, new int[] { 14, 9, 15 }, "-praise-", (Bundle)localObject1);
      if (paramauwu == null) {
        break label316;
      }
      localURLImageView.setImageDrawable(paramauwu);
    }
    for (;;)
    {
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_a_of_type_Aqyh.a(localRelativeLayout, paramFloat1, paramFloat2, paramInt1, paramInt2, this, -1L, 0);
      return;
      paramaqyn = localObject2;
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (paramBitmap != paramauwu.b) {
        break;
      }
      paramQQAppInterface = paramauwu.f;
      paramaqyn = paramauwu.b;
      break;
      label316:
      QLog.e("HeartLayout", 1, "addHeartWithDrawable apng.so load fail.");
      localURLImageView.setImageBitmap(paramBitmap);
      continue;
      label333:
      localURLImageView.setImageBitmap(paramBitmap);
    }
  }
  
  public void b(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_Aqym != null) {
      this.jdField_a_of_type_Aqym.b(paramAnimation);
    }
  }
  
  public void clearAnimation()
  {
    super.clearAnimation();
    if (!this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = 0;
    while (i < super.getChildCount())
    {
      super.getChildAt(i).clearAnimation();
      i += 1;
    }
    super.removeAllViews();
  }
  
  protected void onMeasure(int paramInt1, int paramInt2)
  {
    super.onMeasure(paramInt1, paramInt2);
    this.jdField_a_of_type_Int = super.getMeasuredWidth();
    this.jdField_b_of_type_Int = super.getMeasuredHeight();
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool2 = false;
    boolean bool1;
    if (!this.jdField_c_of_type_Boolean) {
      bool1 = super.onTouchEvent(paramMotionEvent);
    }
    do
    {
      do
      {
        return bool1;
        bool1 = bool2;
      } while (!this.jdField_a_of_type_Boolean);
      bool1 = bool2;
    } while (!super.isEnabled());
    switch (paramMotionEvent.getAction())
    {
    }
    for (;;)
    {
      return true;
      this.jdField_a_of_type_Float = paramMotionEvent.getX();
      this.jdField_b_of_type_Float = paramMotionEvent.getY();
      this.jdField_b_of_type_Boolean = true;
      continue;
      if (this.jdField_b_of_type_Boolean)
      {
        this.jdField_b_of_type_Boolean = false;
        float f1 = paramMotionEvent.getX();
        float f2 = paramMotionEvent.getY();
        double d = Math.pow(f1 - this.jdField_a_of_type_Float, 2.0D);
        if ((float)Math.sqrt(Math.pow(f2 - this.jdField_b_of_type_Float, 2.0D) + d) <= this.jdField_c_of_type_Float) {
          a(paramMotionEvent.getX(), paramMotionEvent.getY());
        }
      }
    }
  }
  
  public void setCanDoAnim(boolean paramBoolean)
  {
    this.jdField_a_of_type_Boolean = paramBoolean;
    if (Build.VERSION.SDK_INT < 11) {
      this.jdField_a_of_type_Boolean = false;
    }
    if (!this.jdField_a_of_type_Boolean)
    {
      int i = super.getChildCount() - 1;
      if (i >= 0)
      {
        View localView = getChildAt(i);
        if (localView == null) {}
        for (;;)
        {
          i -= 1;
          break;
          Boolean localBoolean = (Boolean)localView.getTag(2131373012);
          if ((localBoolean != null) && (localBoolean.booleanValue()))
          {
            localView.clearAnimation();
            super.removeView(localView);
          }
        }
      }
    }
  }
  
  public void setHeartListener(aqym paramaqym)
  {
    this.jdField_a_of_type_Aqym = paramaqym;
  }
  
  public void setListenTouchEvent(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setSpecialHeart(int paramInt, Set<String> paramSet)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      if (paramInt >= 0) {
        jdField_c_of_type_Int = paramInt;
      }
    } while ((paramSet == null) || (paramSet.size() <= 0));
    jdField_a_of_type_ArrayOfAndroidGraphicsBitmap = new Bitmap[paramSet.size()];
    paramSet = paramSet.iterator();
    paramInt = 0;
    while (paramSet.hasNext())
    {
      String str = (String)paramSet.next();
      if (!TextUtils.isEmpty(str)) {}
      try
      {
        jdField_a_of_type_ArrayOfAndroidGraphicsBitmap[paramInt] = BitmapFactory.decodeFile(str);
        label85:
        paramInt += 1;
      }
      catch (OutOfMemoryError localOutOfMemoryError)
      {
        break label85;
      }
    }
  }
  
  public void setValidRect(Rect paramRect)
  {
    this.jdField_a_of_type_AndroidGraphicsRect = paramRect;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.hotchat.anim.HeartLayout
 * JD-Core Version:    0.7.0.1
 */