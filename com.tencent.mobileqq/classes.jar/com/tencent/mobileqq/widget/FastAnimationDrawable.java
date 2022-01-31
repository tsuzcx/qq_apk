package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.SystemClock;
import android.support.annotation.NonNull;
import android.util.Log;
import babe;
import bbiq;
import bbir;
import bbis;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class FastAnimationDrawable
  extends Drawable
  implements Animatable
{
  private static Set<SoftReference<Bitmap>> jdField_b_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private int jdField_a_of_type_Int;
  private long jdField_a_of_type_Long;
  protected Context a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private bbir jdField_a_of_type_Bbir;
  private bbis jdField_a_of_type_Bbis;
  private final String jdField_a_of_type_JavaLangString;
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private Set<SoftReference<Bitmap>> jdField_a_of_type_JavaUtilSet;
  protected volatile boolean a;
  private long jdField_b_of_type_Long;
  private ArrayList<bbiq> jdField_b_of_type_JavaUtilArrayList;
  protected boolean b;
  protected boolean c;
  protected boolean d;
  private boolean e;
  
  private void a(bbir parambbir)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "frameReady() called next=" + parambbir);
    }
    this.d = false;
    if ((this.jdField_a_of_type_Bbir != null) && (babe.a("android.resource://main_tab_animation_" + (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Bbir.jdField_a_of_type_Int)) == null)) {
      this.jdField_a_of_type_JavaUtilSet.add(new SoftReference(this.jdField_a_of_type_Bbir.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap()));
    }
    this.jdField_a_of_type_Bbir = parambbir;
    if (!isRunning())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "frameReady() isRunning = false");
      }
      return;
    }
    invalidateSelf();
    b(parambbir);
    if ((this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (this.c))
    {
      this.jdField_a_of_type_Bbis.postDelayed(new FastAnimationDrawable.1(this), this.jdField_a_of_type_Long);
      return;
    }
    a();
  }
  
  private static int b(Bitmap.Config paramConfig)
  {
    int j = 2;
    int i;
    if (paramConfig == Bitmap.Config.ARGB_8888) {
      i = 4;
    }
    do
    {
      do
      {
        return i;
        i = j;
      } while (paramConfig == Bitmap.Config.RGB_565);
      i = j;
    } while (paramConfig == Bitmap.Config.ARGB_4444);
    if (paramConfig == Bitmap.Config.ALPHA_8) {
      return 1;
    }
    return 1;
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "reset");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(bbir parambbir)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bbiq)localIterator.next()).a(parambbir.jdField_a_of_type_Int);
    }
  }
  
  private void c()
  {
    Log.i(this.jdField_a_of_type_JavaLangString, "dispatchAnimationStart: ");
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bbiq)localIterator.next()).a(this);
    }
  }
  
  private void d()
  {
    Log.i(this.jdField_a_of_type_JavaLangString, "dispatchAnimationEnd: ");
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bbiq)localIterator.next()).b(this);
    }
  }
  
  protected void a()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "loadNextFrame() called");
    }
    if ((!isRunning()) || (this.d)) {
      return;
    }
    this.d = true;
    this.jdField_a_of_type_Int += 1;
    this.jdField_a_of_type_Int %= this.jdField_a_of_type_JavaUtilArrayList.size();
    long l2 = SystemClock.uptimeMillis();
    long l1 = l2;
    if (!this.jdField_b_of_type_Boolean) {
      l1 = l2 + this.jdField_a_of_type_Long;
    }
    ThreadManagerV2.postImmediately(new FastAnimationDrawable.Decoder(this, new bbir(this.jdField_a_of_type_Int, l1, null)), null, false);
  }
  
  public void draw(@NonNull Canvas paramCanvas)
  {
    long l1 = 0L;
    long l2 = SystemClock.uptimeMillis();
    long l3 = this.jdField_b_of_type_Long;
    if (this.jdField_b_of_type_Long == 0L) {}
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "draw() called diff=[" + l1 + "]");
      }
      if (this.jdField_a_of_type_Bbir != null)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          c();
        }
        this.jdField_a_of_type_Bbir.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(getBounds());
        if (QLog.isColorLevel())
        {
          Bitmap localBitmap = this.jdField_a_of_type_Bbir.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap();
          if (localBitmap != null) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "draw() called with: w=" + localBitmap.getWidth() + ", h=" + localBitmap.getHeight());
          }
        }
        else
        {
          this.jdField_a_of_type_Bbir.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setFilterBitmap(true);
          this.jdField_a_of_type_Bbir.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.draw(paramCanvas);
          this.jdField_a_of_type_AndroidGraphicsPaint.setColor(-16711936);
          this.jdField_a_of_type_AndroidGraphicsPaint.setStyle(Paint.Style.STROKE);
          this.jdField_a_of_type_AndroidGraphicsPaint.setStrokeWidth(1.0F);
        }
      }
      for (;;)
      {
        this.jdField_b_of_type_Long = SystemClock.uptimeMillis();
        return;
        QLog.e(this.jdField_a_of_type_JavaLangString, 2, "draw() called with: null bitmap");
        break;
        if (QLog.isColorLevel()) {
          QLog.d(this.jdField_a_of_type_JavaLangString, 2, "draw() called null bitmap");
        }
      }
      l1 = l2 - l3;
    }
  }
  
  public int getIntrinsicHeight()
  {
    return getBounds().height();
  }
  
  public int getIntrinsicWidth()
  {
    return getBounds().width();
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean isRunning()
  {
    return this.jdField_a_of_type_Boolean;
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    boolean bool = super.setVisible(paramBoolean1, paramBoolean2);
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "setVisible changed:" + bool + " visible:" + paramBoolean1 + " restart:" + paramBoolean2);
    }
    if (paramBoolean1) {
      if (bool)
      {
        start();
        if (!paramBoolean2) {
          break label83;
        }
        b();
      }
    }
    label83:
    while (!bool)
    {
      return bool;
      start();
      return bool;
    }
    stop();
    return bool;
  }
  
  public void start()
  {
    if (!this.jdField_a_of_type_Boolean)
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "start");
      }
      this.jdField_a_of_type_Boolean = true;
      this.jdField_b_of_type_Boolean = true;
      a();
    }
  }
  
  public void stop()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "stop() called");
    }
    if (isRunning()) {
      this.jdField_a_of_type_Boolean = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.widget.FastAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */