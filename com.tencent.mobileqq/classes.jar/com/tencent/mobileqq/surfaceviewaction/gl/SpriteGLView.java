package com.tencent.mobileqq.surfaceviewaction.gl;

import ahxe;
import ahxg;
import ahxh;
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
import com.tencent.mobileqq.R.styleable;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class SpriteGLView
  extends FrameLayout
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  private View jdField_a_of_type_AndroidViewView;
  private SpriteGLView.IVideoTimeGetter jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView$IVideoTimeGetter;
  private Object jdField_a_of_type_JavaLangObject = new Object();
  private LinkedList jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private List jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  public boolean a;
  private Object jdField_b_of_type_JavaLangObject = new Object();
  private List jdField_b_of_type_JavaUtilList = new LinkedList();
  public boolean b;
  public int c;
  private List c = new ArrayList();
  
  public SpriteGLView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public SpriteGLView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  public SpriteGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
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
      ((GLSurfaceView)localObject).setRenderer(new ahxh(this, null));
      ((GLSurfaceView)localObject).setZOrderOnTop(true);
    }
    for (;;)
    {
      setFocusableInTouchMode(true);
      return;
      localObject = new GLTextureView(getContext());
      this.jdField_a_of_type_AndroidViewView = ((View)localObject);
      addView((View)localObject, -1, -1);
      ((GLTextureView)localObject).setRenderer(new ahxh(this, null));
    }
  }
  
  public List a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  void a(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(Integer.valueOf(paramInt));
      return;
    }
  }
  
  public void a(int paramInt, Node paramNode)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (this.jdField_a_of_type_JavaUtilList.get(i) == paramNode) {
        return;
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramInt, paramNode);
  }
  
  public void a(GLTextureView.OnSurfaceChangedListener paramOnSurfaceChangedListener)
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof GLTextureView)) {
      ((GLTextureView)this.jdField_a_of_type_AndroidViewView).a(paramOnSurfaceChangedListener);
    }
  }
  
  public void a(Node paramNode)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (this.jdField_a_of_type_JavaUtilList.get(i) == paramNode) {
        return;
      }
      i += 1;
    }
    this.jdField_a_of_type_JavaUtilList.add(paramNode);
  }
  
  public void a(Sprite paramSprite)
  {
    a(paramSprite);
  }
  
  public void a(Runnable paramRunnable)
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.c.add(paramRunnable);
      return;
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_JavaUtilList.isEmpty();
  }
  
  public void b(GLTextureView.OnSurfaceChangedListener paramOnSurfaceChangedListener)
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof GLTextureView)) {
      ((GLTextureView)this.jdField_a_of_type_AndroidViewView).b(paramOnSurfaceChangedListener);
    }
  }
  
  public void b(Node paramNode)
  {
    if (paramNode.b) {
      paramNode.b();
    }
    int i = 0;
    for (;;)
    {
      if (i < this.jdField_a_of_type_JavaUtilList.size())
      {
        if (this.jdField_a_of_type_JavaUtilList.get(i) == paramNode) {
          this.jdField_a_of_type_JavaUtilList.remove(i);
        }
      }
      else {
        return;
      }
      i += 1;
    }
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
    if (this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView$IVideoTimeGetter != null) {
      return this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView$IVideoTimeGetter.a();
    }
    return (int)(System.currentTimeMillis() - this.jdField_a_of_type_Long);
  }
  
  public void k()
  {
    synchronized (this.jdField_b_of_type_JavaLangObject)
    {
      this.c.clear();
      return;
    }
  }
  
  public void l()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "pause");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((Node)this.jdField_a_of_type_JavaUtilList.get(i)).d();
      i += 1;
    }
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "resume");
    }
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      ((Node)this.jdField_a_of_type_JavaUtilList.get(i)).e();
      i += 1;
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "stopDraw");
    }
    ahxg localahxg = new ahxg(this);
    if ((this.jdField_a_of_type_AndroidViewView instanceof GLSurfaceView))
    {
      ((GLSurfaceView)this.jdField_a_of_type_AndroidViewView).onPause();
      ((GLSurfaceView)this.jdField_a_of_type_AndroidViewView).queueEvent(localahxg);
    }
    while (!(this.jdField_a_of_type_AndroidViewView instanceof GLTextureView)) {
      return;
    }
    ((GLTextureView)this.jdField_a_of_type_AndroidViewView).a(localahxg);
  }
  
  public void o()
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
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = 0;
    while (i < this.jdField_a_of_type_JavaUtilList.size())
    {
      if (((this.jdField_a_of_type_JavaUtilList.get(i) instanceof ahxe)) && (((ahxe)this.jdField_a_of_type_JavaUtilList.get(i)).a(paramMotionEvent, getWidth(), getHeight()))) {
        return true;
      }
      i += 1;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setFps(int paramInt)
  {
    if ((this.jdField_a_of_type_AndroidViewView instanceof GLTextureView)) {
      ((GLTextureView)this.jdField_a_of_type_AndroidViewView).setFps(paramInt);
    }
  }
  
  public void setVideoTimeGetter(SpriteGLView.IVideoTimeGetter paramIVideoTimeGetter)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView$IVideoTimeGetter = paramIVideoTimeGetter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView
 * JD-Core Version:    0.7.0.1
 */