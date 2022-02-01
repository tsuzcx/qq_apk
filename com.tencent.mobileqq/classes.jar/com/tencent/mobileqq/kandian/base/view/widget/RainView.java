package com.tencent.mobileqq.kandian.base.view.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.mobileqq.surfaceviewaction.action.Action;
import com.tencent.mobileqq.surfaceviewaction.action.DelayAction;
import com.tencent.mobileqq.surfaceviewaction.action.MoveToAction;
import com.tencent.mobileqq.surfaceviewaction.gl.Node;
import com.tencent.mobileqq.surfaceviewaction.gl.Sprite;
import com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView;
import com.tencent.mobileqq.surfaceviewaction.gl.Texture;
import com.tencent.mobileqq.util.DisplayUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class RainView
  extends SpriteGLView
  implements Runnable
{
  private static int jdField_a_of_type_Int = 4000;
  private static int jdField_b_of_type_Int = 200;
  private static int d = 100;
  private static int e = 3;
  private static int f = 6;
  private Context jdField_a_of_type_AndroidContentContext;
  private RainView.AnimationEndListener jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView$AnimationEndListener;
  private Texture jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture;
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private AtomicInteger jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger;
  private int g;
  private int h;
  private int i;
  private int j = 0;
  private int k;
  
  public RainView(Context paramContext)
  {
    super(paramContext, 1);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  }
  
  private int a(int paramInt)
  {
    int m = new Random().nextInt(5);
    double d1;
    double d2;
    double d3;
    if (m != 0)
    {
      if (m != 1)
      {
        if (m != 2)
        {
          if (m != 3) {
            return paramInt;
          }
          d1 = paramInt;
          d2 = this.k;
          d3 = Math.tan(0.349065850398866D);
          Double.isNaN(d2);
          Double.isNaN(d1);
          d1 += d2 * d3;
        }
        else
        {
          d1 = paramInt;
          d2 = this.k;
          d3 = Math.tan(0.174532925199433D);
          Double.isNaN(d2);
          Double.isNaN(d1);
          d1 += d2 * d3;
          break label195;
        }
      }
      else
      {
        d1 = paramInt;
        d2 = this.k;
        d3 = Math.tan(0.349065850398866D);
        Double.isNaN(d2);
        Double.isNaN(d1);
        d1 -= d2 * d3;
      }
      return (int)d1;
    }
    else
    {
      d1 = paramInt;
      d2 = this.k;
      d3 = Math.tan(0.174532925199433D);
      Double.isNaN(d2);
      Double.isNaN(d1);
      d1 -= d2 * d3;
    }
    label195:
    return (int)d1;
  }
  
  private Bitmap a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString))
    {
      if (!new File(paramString).exists()) {
        return null;
      }
      Object localObject = new BitmapFactory.Options();
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = true;
      ImageUtil.a(paramString, (BitmapFactory.Options)localObject);
      int i2 = ((BitmapFactory.Options)localObject).outHeight;
      int m = ((BitmapFactory.Options)localObject).outWidth;
      int n = DisplayUtil.a(getContext(), 80.0F);
      int i1 = DisplayUtil.a(getContext(), 80.0F);
      if ((i2 <= n) && (m <= i1))
      {
        n = 1;
      }
      else
      {
        i2 /= 2;
        int i3 = m / 2;
        m = 2;
        while ((i2 / m >= n) && (i3 / m >= i1)) {
          m *= 2;
        }
        n = m;
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("inSampleSize = ");
          localStringBuilder.append(m);
          QLog.d("SpriteGLView", 2, localStringBuilder.toString());
          n = m;
        }
      }
      ((BitmapFactory.Options)localObject).inPreferredConfig = Bitmap.Config.RGB_565;
      ((BitmapFactory.Options)localObject).inSampleSize = n;
      ((BitmapFactory.Options)localObject).inTargetDensity = this.jdField_a_of_type_AndroidContentContext.getResources().getDisplayMetrics().densityDpi;
      ((BitmapFactory.Options)localObject).inDensity = 320;
      ((BitmapFactory.Options)localObject).inScaled = true;
      ((BitmapFactory.Options)localObject).inJustDecodeBounds = false;
      try
      {
        paramString = ImageUtil.a(paramString, (BitmapFactory.Options)localObject);
        if (paramString != null) {
          return paramString;
        }
        QLog.e("SpriteGLView", 1, "getPngDrawable bitmap = null");
        return null;
      }
      catch (OutOfMemoryError paramString)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("getPngDrawable oom = ");
        ((StringBuilder)localObject).append(paramString);
        QLog.e("SpriteGLView", 1, ((StringBuilder)localObject).toString());
      }
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    int m = this.jdField_b_of_type_JavaUtilConcurrentAtomicAtomicInteger.incrementAndGet();
    if (m == 1)
    {
      paramString = a(paramString);
      if (paramString != null) {
        this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture = new Texture(this, paramString);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null)
      {
        this.g = (paramInt1 / e);
        this.h = paramInt2;
        this.i = (DisplayUtil.a(getContext(), 20.0F) + paramInt3);
        this.k = (paramInt3 - paramInt2);
        this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
        b(this);
      }
    }
    else if ((m > 1) && (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture != null))
    {
      b(this);
    }
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("rain animation run initCount = ");
      paramString.append(m);
      paramString.append(" mTexture = ");
      paramString.append(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture);
      QLog.d("SpriteGLView", 2, paramString.toString());
    }
  }
  
  public void run()
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("rain animation run mLoopNum = ");
      ((StringBuilder)localObject1).append(this.j);
      QLog.d("SpriteGLView", 2, ((StringBuilder)localObject1).toString());
    }
    if (this.j >= f)
    {
      this.j = 0;
      return;
    }
    int m = 0;
    while (m < e)
    {
      localObject1 = new Sprite(this);
      ((Sprite)localObject1).a(this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlTexture);
      ((Sprite)localObject1).e = ((new Random().nextInt(2) * 2 + 8) / 10.0F);
      int n = this.h;
      int i1 = new Random().nextInt(DisplayUtil.a(getContext(), d));
      int i2 = this.i;
      int i3 = this.g * m + new Random().nextInt(this.g + 1);
      float f1 = i3;
      float f2 = n - i1;
      ((Sprite)localObject1).a(f1, f2);
      Object localObject2 = new MoveToAction(jdField_a_of_type_Int, f1, f2, a(i3), i2);
      ((Sprite)localObject1).a(new Action[] { localObject2 });
      ((MoveToAction)localObject2).a(new RainView.1(this, (Sprite)localObject1));
      if (m == 0)
      {
        localObject2 = new DelayAction(jdField_b_of_type_Int);
        ((Sprite)localObject1).a(new Action[] { localObject2 });
        ((DelayAction)localObject2).a(new RainView.2(this));
      }
      a((Node)localObject1);
      m += 1;
    }
    this.j += 1;
  }
  
  public void setAnimationEndListener(RainView.AnimationEndListener paramAnimationEndListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqKandianBaseViewWidgetRainView$AnimationEndListener = paramAnimationEndListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.view.widget.RainView
 * JD-Core Version:    0.7.0.1
 */