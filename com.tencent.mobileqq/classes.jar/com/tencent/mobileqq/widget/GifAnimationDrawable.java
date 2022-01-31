package com.tencent.mobileqq.widget;

import android.content.Context;
import android.graphics.Bitmap;
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
import bdfz;
import bepx;
import bepy;
import bepz;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class GifAnimationDrawable
  extends Drawable
  implements Animatable
{
  private static Set<SoftReference<Bitmap>> jdField_b_of_type_JavaUtilSet = Collections.synchronizedSet(new HashSet());
  private int jdField_a_of_type_Int = -1;
  private long jdField_a_of_type_Long = 34L;
  protected Context a;
  private Paint jdField_a_of_type_AndroidGraphicsPaint = new Paint(1);
  private bepy jdField_a_of_type_Bepy;
  private bepz jdField_a_of_type_Bepz;
  private final String jdField_a_of_type_JavaLangString = "FastAnimationDrawable@" + Integer.toHexString(hashCode());
  private ArrayList<String> jdField_a_of_type_JavaUtilArrayList;
  private Set<SoftReference<Bitmap>> jdField_a_of_type_JavaUtilSet;
  protected volatile boolean a;
  private long jdField_b_of_type_Long;
  private ArrayList<bepx> jdField_b_of_type_JavaUtilArrayList = new ArrayList();
  protected boolean b;
  protected boolean c;
  protected boolean d;
  
  public GifAnimationDrawable(Context paramContext, ArrayList<String> paramArrayList, long paramLong)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_Boolean = false;
    this.jdField_a_of_type_Bepz = new bepz(this);
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaUtilSet = jdField_b_of_type_JavaUtilSet;
    this.jdField_a_of_type_JavaUtilArrayList = paramArrayList;
  }
  
  private void a(bepy parambepy)
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "frameReady() called next=" + parambepy);
    }
    this.d = false;
    if ((this.jdField_a_of_type_Bepy != null) && (bdfz.a("android.resource://main_tab_animation_" + (String)this.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Bepy.jdField_a_of_type_Int)) == null)) {
      this.jdField_a_of_type_JavaUtilSet.add(new SoftReference(this.jdField_a_of_type_Bepy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap()));
    }
    this.jdField_a_of_type_Bepy = parambepy;
    if (!isRunning())
    {
      if (QLog.isColorLevel()) {
        QLog.d(this.jdField_a_of_type_JavaLangString, 2, "frameReady() isRunning = false");
      }
      return;
    }
    invalidateSelf();
    b(parambepy);
    if ((this.jdField_a_of_type_Int == this.jdField_a_of_type_JavaUtilArrayList.size() - 1) && (this.c))
    {
      this.jdField_a_of_type_Bepz.postDelayed(new GifAnimationDrawable.1(this), this.jdField_a_of_type_Long);
      return;
    }
    a();
  }
  
  private void b()
  {
    if (QLog.isColorLevel()) {
      QLog.d(this.jdField_a_of_type_JavaLangString, 2, "reset");
    }
    this.jdField_a_of_type_Boolean = true;
  }
  
  private void b(bepy parambepy)
  {
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bepx)localIterator.next()).a(parambepy.jdField_a_of_type_Int);
    }
  }
  
  private void c()
  {
    Log.i(this.jdField_a_of_type_JavaLangString, "dispatchAnimationStart: ");
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bepx)localIterator.next()).a(this);
    }
  }
  
  private void d()
  {
    Log.i(this.jdField_a_of_type_JavaLangString, "dispatchAnimationEnd: ");
    Iterator localIterator = this.jdField_b_of_type_JavaUtilArrayList.iterator();
    while (localIterator.hasNext()) {
      ((bepx)localIterator.next()).b(this);
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
    ThreadManagerV2.postImmediately(new GifAnimationDrawable.Decoder(this, new bepy(this.jdField_a_of_type_Int, l1, null)), null, false);
  }
  
  public void a(boolean paramBoolean)
  {
    this.c = paramBoolean;
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
      if (this.jdField_a_of_type_Bepy != null)
      {
        if (this.jdField_b_of_type_Boolean)
        {
          this.jdField_b_of_type_Boolean = false;
          c();
        }
        this.jdField_a_of_type_Bepy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setBounds(getBounds());
        if (QLog.isColorLevel())
        {
          Bitmap localBitmap = this.jdField_a_of_type_Bepy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.getBitmap();
          if (localBitmap != null) {
            QLog.d(this.jdField_a_of_type_JavaLangString, 2, "draw() called with: w=" + localBitmap.getWidth() + ", h=" + localBitmap.getHeight());
          }
        }
        else
        {
          this.jdField_a_of_type_Bepy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.setFilterBitmap(true);
          this.jdField_a_of_type_Bepy.jdField_a_of_type_AndroidGraphicsDrawableBitmapDrawable.draw(paramCanvas);
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
 * Qualified Name:     com.tencent.mobileqq.widget.GifAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */