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
import aqyj;
import aqyl;
import aqyn;
import aqyo;
import aqyp;
import auww;
import bbqz;
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
  implements aqyn
{
  public static final int[] a;
  public static Bitmap[] a;
  public static int c;
  public float a;
  public int a;
  public Rect a;
  public aqyj a;
  public aqyo a;
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
      if (this.jdField_a_of_type_Aqyo != null) {
        this.jdField_a_of_type_Aqyo.a(this, paramFloat1, paramFloat2);
      }
    }
    while ((paramFloat1 < this.jdField_a_of_type_AndroidGraphicsRect.left) || (paramFloat1 > this.jdField_a_of_type_AndroidGraphicsRect.right) || (paramFloat2 < this.jdField_a_of_type_AndroidGraphicsRect.top) || (paramFloat2 > this.jdField_a_of_type_AndroidGraphicsRect.bottom) || (this.jdField_a_of_type_Aqyo == null)) {
      return;
    }
    this.jdField_a_of_type_Aqyo.a(this, paramFloat1, paramFloat2);
  }
  
  public aqyl a()
  {
    if (this.jdField_a_of_type_Aqyj != null) {
      return this.jdField_a_of_type_Aqyj.a();
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
    this.jdField_a_of_type_Aqyj = new aqyj(this);
    this.jdField_a_of_type_Aqyj.a(this);
  }
  
  public void a(Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    a(null, paramBitmap, paramFloat1, paramFloat2, -1L, 0);
  }
  
  public void a(Bitmap paramBitmap, QQAppInterface paramQQAppInterface, aqyp paramaqyp, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    a(null, paramBitmap, paramQQAppInterface, paramaqyp, paramFloat1, paramFloat2, paramInt1, paramInt2);
  }
  
  public void a(Animation paramAnimation)
  {
    if (this.jdField_a_of_type_Aqyo != null) {
      this.jdField_a_of_type_Aqyo.a(paramAnimation);
    }
  }
  
  public void a(auww paramauww, Bitmap paramBitmap, float paramFloat1, float paramFloat2)
  {
    a(paramauww, paramBitmap, paramFloat1, paramFloat2, -1L, 0);
  }
  
  public void a(auww paramauww, Bitmap paramBitmap, float paramFloat1, float paramFloat2, long paramLong, int paramInt)
  {
    if (!this.jdField_a_of_type_Boolean) {}
    while ((this.jdField_a_of_type_Aqyj == null) || (paramBitmap == null)) {
      return;
    }
    String str = null;
    Bundle localBundle = null;
    Object localObject2 = localBundle;
    Object localObject1 = str;
    if (paramauww != null)
    {
      if (paramBitmap == paramauww.c)
      {
        localObject1 = paramauww.g;
        localObject2 = paramauww.c;
      }
    }
    else
    {
      paramauww = new URLImageView(getContext());
      if (localObject1 == null) {
        break label255;
      }
      str = "praise?seed=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      localObject2 = new BitmapDrawable(getResources(), (Bitmap)localObject2);
      localBundle = new Bundle();
      localBundle.getBoolean("key_use_cache", false);
      localObject1 = bbqz.a(BaseApplicationImpl.sApplication.getRuntime(), (String)localObject1, str, (Drawable)localObject2, new int[] { 14, 9, 15 }, "-praise-", localBundle);
      if (localObject1 == null) {
        break label239;
      }
      paramauww.setImageDrawable((Drawable)localObject1);
    }
    for (;;)
    {
      paramauww.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_a_of_type_Aqyj.a(paramauww, paramFloat1, paramFloat2, this, paramLong, paramInt);
      return;
      localObject2 = localBundle;
      localObject1 = str;
      if (paramBitmap != paramauww.b) {
        break;
      }
      localObject1 = paramauww.f;
      localObject2 = paramauww.b;
      break;
      label239:
      QLog.e("HeartLayout", 1, "addHeartWithDrawable apng.so load fail.");
      paramauww.setImageBitmap(paramBitmap);
      continue;
      label255:
      paramauww.setImageBitmap(paramBitmap);
    }
  }
  
  public void a(auww paramauww, Bitmap paramBitmap, QQAppInterface paramQQAppInterface, aqyp paramaqyp, float paramFloat1, float paramFloat2, int paramInt1, int paramInt2)
  {
    if ((!this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_Aqyj == null)) {
      return;
    }
    RelativeLayout localRelativeLayout = new RelativeLayout(getContext());
    paramQQAppInterface = new PayLikeFloatViewBuilder.AnimationView(getContext(), paramQQAppInterface, paramaqyp);
    URLImageView localURLImageView = new URLImageView(getContext());
    paramaqyp = new RelativeLayout.LayoutParams(-2, -2);
    paramaqyp.addRule(13);
    Object localObject1 = new RelativeLayout.LayoutParams(-1, -1);
    ((RelativeLayout.LayoutParams)localObject1).addRule(13);
    localRelativeLayout.addView(localURLImageView, paramaqyp);
    localRelativeLayout.addView(paramQQAppInterface, (ViewGroup.LayoutParams)localObject1);
    localObject1 = null;
    Object localObject2 = null;
    paramaqyp = localObject2;
    paramQQAppInterface = (QQAppInterface)localObject1;
    if (paramauww != null)
    {
      if (paramBitmap == paramauww.c)
      {
        paramQQAppInterface = paramauww.g;
        paramaqyp = paramauww.c;
      }
    }
    else
    {
      if (paramQQAppInterface == null) {
        break label333;
      }
      paramauww = "praise?seed=" + this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement();
      paramaqyp = new BitmapDrawable(getResources(), paramaqyp);
      localObject1 = new Bundle();
      ((Bundle)localObject1).getBoolean("key_use_cache", false);
      paramauww = bbqz.a(BaseApplicationImpl.sApplication.getRuntime(), paramQQAppInterface, paramauww, paramaqyp, new int[] { 14, 9, 15 }, "-praise-", (Bundle)localObject1);
      if (paramauww == null) {
        break label316;
      }
      localURLImageView.setImageDrawable(paramauww);
    }
    for (;;)
    {
      localURLImageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
      this.jdField_a_of_type_Aqyj.a(localRelativeLayout, paramFloat1, paramFloat2, paramInt1, paramInt2, this, -1L, 0);
      return;
      paramaqyp = localObject2;
      paramQQAppInterface = (QQAppInterface)localObject1;
      if (paramBitmap != paramauww.b) {
        break;
      }
      paramQQAppInterface = paramauww.f;
      paramaqyp = paramauww.b;
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
    if (this.jdField_a_of_type_Aqyo != null) {
      this.jdField_a_of_type_Aqyo.b(paramAnimation);
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
          Boolean localBoolean = (Boolean)localView.getTag(2131373014);
          if ((localBoolean != null) && (localBoolean.booleanValue()))
          {
            localView.clearAnimation();
            super.removeView(localView);
          }
        }
      }
    }
  }
  
  public void setHeartListener(aqyo paramaqyo)
  {
    this.jdField_a_of_type_Aqyo = paramaqyo;
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