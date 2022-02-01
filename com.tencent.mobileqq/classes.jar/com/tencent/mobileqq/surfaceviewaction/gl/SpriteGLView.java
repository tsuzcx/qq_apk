package com.tencent.mobileqq.surfaceviewaction.gl;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import bcqw;
import bcrc;
import bcsb;
import bcsg;
import bcsh;
import bcsi;
import bcsj;
import bcsk;
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SpriteGLView
  extends FrameLayout
  implements bcrc<bcsg>
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  protected View a;
  private bcsj jdField_a_of_type_Bcsj;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final LinkedList<Integer> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private final List<bcqw> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  public boolean a;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private List<Runnable> jdField_b_of_type_JavaUtilList = new LinkedList();
  public boolean b;
  public int c;
  private List<Runnable> c;
  public volatile boolean c;
  
  public SpriteGLView(Context paramContext)
  {
    super(paramContext);
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    a();
  }
  
  public SpriteGLView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  public SpriteGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_c_of_type_JavaUtilList = new ArrayList();
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SpriteGLView, 0, 0);
    try
    {
      this.jdField_a_of_type_Int = paramContext.getInt(0, 0);
      paramContext.recycle();
      a();
      return;
    }
    finally
    {
      paramContext.recycle();
    }
  }
  
  private void a()
  {
    Object localObject;
    if (this.jdField_a_of_type_Int == 0)
    {
      localObject = new GLSurfaceView(getContext());
      this.jdField_a_of_type_AndroidViewView = ((View)localObject);
      addView((View)localObject, -1, -1);
      ((GLSurfaceView)localObject).setEGLContextClientVersion(2);
      ((GLSurfaceView)localObject).getHolder().setFormat(-3);
      ((GLSurfaceView)localObject).setEGLConfigChooser(8, 8, 8, 8, 16, 0);
      ((GLSurfaceView)localObject).setRenderer(new bcsk(this, null));
      ((GLSurfaceView)localObject).setZOrderOnTop(true);
    }
    for (;;)
    {
      setFocusableInTouchMode(true);
      return;
      localObject = a(getContext());
      this.jdField_a_of_type_AndroidViewView = ((View)localObject);
      addView((View)localObject, -1, -1);
      ((GLTextureView)localObject).setRenderer(new bcsk(this, null));
    }
  }
  
  protected GLTextureView a(Context paramContext)
  {
    return new GLTextureView(paramContext);
  }
  
  public List<bcqw> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    int i = 0;
    for (;;)
    {
      synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
      {
        if (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
        {
          if (paramInt != ((Integer)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).intValue()) {
            break label78;
          }
          if (i > 0)
          {
            this.jdField_a_of_type_JavaUtilLinkedList.remove(i);
            GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
          }
          return;
        }
      }
      i = -1;
      continue;
      label78:
      i += 1;
    }
  }
  
  public void a(int paramInt, bcsg parambcsg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(parambcsg)) {
        this.jdField_a_of_type_JavaUtilList.add(paramInt, parambcsg);
      }
      return;
    }
  }
  
  public void a(bcsb parambcsb)
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof GLTextureView)) {
      ((GLTextureView)this.jdField_a_of_type_AndroidViewView).a(parambcsb);
    }
  }
  
  public void a(bcsg parambcsg)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(parambcsg)) {
        this.jdField_a_of_type_JavaUtilList.add(parambcsg);
      }
      return;
    }
  }
  
  public void a(bcsi parambcsi)
  {
    a(parambcsi);
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_JavaUtilList.add(paramRunnable);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  public void b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(Integer.valueOf(paramInt));
      return;
    }
  }
  
  public void b(bcsb parambcsb)
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof GLTextureView)) {
      ((GLTextureView)this.jdField_a_of_type_AndroidViewView).b(parambcsb);
    }
  }
  
  public void b(bcsg parambcsg)
  {
    if (parambcsg.a()) {
      parambcsg.a();
    }
    this.jdField_a_of_type_JavaUtilList.remove(parambcsg);
  }
  
  public void b(Runnable paramRunnable)
  {
    synchronized (this.jdField_a_of_type_JavaLangObject)
    {
      this.jdField_b_of_type_JavaUtilList.add(paramRunnable);
      return;
    }
  }
  
  public int c()
  {
    if (this.jdField_a_of_type_Bcsj != null) {
      return this.jdField_a_of_type_Bcsj.a();
    }
    return (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void k()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.jdField_c_of_type_JavaUtilList.clear();
      return;
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "pause");
    }
    Object[] arrayOfObject = this.jdField_a_of_type_JavaUtilList.toArray();
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if ((localObject instanceof bcsg)) {
        ((bcsg)localObject).b();
      }
      i += 1;
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "resume");
    }
    Object[] arrayOfObject = this.jdField_a_of_type_JavaUtilList.toArray();
    int j = arrayOfObject.length;
    int i = 0;
    while (i < j)
    {
      Object localObject = arrayOfObject[i];
      if ((localObject instanceof bcsg)) {
        ((bcsg)localObject).c();
      }
      i += 1;
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "stopDraw");
    }
    SpriteGLView.1 local1 = new SpriteGLView.1(this);
    if ((this.jdField_a_of_type_AndroidViewView instanceof GLSurfaceView))
    {
      ((GLSurfaceView)this.jdField_a_of_type_AndroidViewView).onPause();
      ((GLSurfaceView)this.jdField_a_of_type_AndroidViewView).queueEvent(local1);
    }
    while (!(this.jdField_a_of_type_AndroidViewView instanceof GLTextureView)) {
      return;
    }
    ((GLTextureView)this.jdField_a_of_type_AndroidViewView).a(local1);
  }
  
  public void o()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((bcsg)localIterator.next()).ay_();
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object[] arrayOfObject = this.jdField_a_of_type_JavaUtilList.toArray();
    int i = arrayOfObject.length - 1;
    while (i >= 0)
    {
      if (((arrayOfObject[i] instanceof bcsh)) && (((bcsh)arrayOfObject[i]).a(paramMotionEvent, getWidth(), getHeight()))) {
        return true;
      }
      i -= 1;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void p()
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      int[] arrayOfInt = new int[this.jdField_a_of_type_JavaUtilLinkedList.size()];
      int i = 0;
      while (!this.jdField_a_of_type_JavaUtilLinkedList.isEmpty())
      {
        arrayOfInt[i] = ((Integer)this.jdField_a_of_type_JavaUtilLinkedList.remove(0)).intValue();
        i += 1;
      }
      GLES20.glDeleteTextures(arrayOfInt.length, arrayOfInt, 0);
      return;
    }
  }
  
  public void setFps(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof GLTextureView)) {
      ((GLTextureView)this.jdField_a_of_type_AndroidViewView).setFps(paramInt);
    }
  }
  
  public void setRetainBitmap(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setVideoTimeGetter(bcsj parambcsj)
  {
    this.jdField_a_of_type_Bcsj = parambcsj;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView
 * JD-Core Version:    0.7.0.1
 */