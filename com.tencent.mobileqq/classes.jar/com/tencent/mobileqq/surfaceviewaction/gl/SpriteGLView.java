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
import com.tencent.mobileqq.R.styleable;
import com.tencent.mobileqq.surfaceviewaction.BaseNode;
import com.tencent.mobileqq.surfaceviewaction.ISpriteView;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SpriteGLView
  extends FrameLayout
  implements ISpriteView<Node>
{
  private int jdField_a_of_type_Int = 0;
  private long jdField_a_of_type_Long;
  protected View a;
  private SpriteGLView.IVideoTimeGetter jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView$IVideoTimeGetter;
  private final Object jdField_a_of_type_JavaLangObject = new Object();
  private final LinkedList<Integer> jdField_a_of_type_JavaUtilLinkedList = new LinkedList();
  private final List<BaseNode> jdField_a_of_type_JavaUtilList = Collections.synchronizedList(new ArrayList());
  public boolean a;
  private final Object jdField_b_of_type_JavaLangObject = new Object();
  private List<Runnable> jdField_b_of_type_JavaUtilList = new LinkedList();
  public boolean b;
  int jdField_c_of_type_Int;
  private List<Runnable> jdField_c_of_type_JavaUtilList = new ArrayList();
  public volatile boolean c;
  
  public SpriteGLView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    a();
  }
  
  public SpriteGLView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
    this.jdField_a_of_type_Int = paramInt;
    a();
  }
  
  public SpriteGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_Boolean = false;
    this.jdField_b_of_type_Boolean = false;
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
      ((GLSurfaceView)localObject).setRenderer(new SpriteGLView.SimpleRenderer(this, null));
      ((GLSurfaceView)localObject).setZOrderOnTop(true);
    }
    else
    {
      localObject = a(getContext());
      this.jdField_a_of_type_AndroidViewView = ((View)localObject);
      addView((View)localObject, -1, -1);
      ((GLTextureView)localObject).setRenderer(new SpriteGLView.SimpleRenderer(this, null));
    }
    setFocusableInTouchMode(true);
  }
  
  protected GLTextureView a(Context paramContext)
  {
    return new GLTextureView(paramContext);
  }
  
  public List<BaseNode> a()
  {
    return this.jdField_a_of_type_JavaUtilList;
  }
  
  public void a(int paramInt)
  {
    LinkedList localLinkedList = this.jdField_a_of_type_JavaUtilLinkedList;
    int k = -1;
    int i = 0;
    for (;;)
    {
      int j = k;
      try
      {
        if (i < this.jdField_a_of_type_JavaUtilLinkedList.size())
        {
          if (paramInt != ((Integer)this.jdField_a_of_type_JavaUtilLinkedList.get(i)).intValue()) {
            break label94;
          }
          j = i;
        }
        if (j > 0)
        {
          this.jdField_a_of_type_JavaUtilLinkedList.remove(j);
          GLES20.glDeleteTextures(1, new int[] { paramInt }, 0);
        }
        return;
      }
      finally
      {
        for (;;)
        {
          throw localObject;
        }
        label94:
        i += 1;
      }
    }
  }
  
  public void a(int paramInt, Node paramNode)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramNode)) {
        this.jdField_a_of_type_JavaUtilList.add(paramInt, paramNode);
      }
      return;
    }
  }
  
  public void a(GLTextureView.OnSurfaceChangedListener paramOnSurfaceChangedListener)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView instanceof GLTextureView)) {
      ((GLTextureView)localView).a(paramOnSurfaceChangedListener);
    }
  }
  
  public void a(Node paramNode)
  {
    synchronized (this.jdField_a_of_type_JavaUtilList)
    {
      if (!this.jdField_a_of_type_JavaUtilList.contains(paramNode)) {
        this.jdField_a_of_type_JavaUtilList.add(paramNode);
      }
      return;
    }
  }
  
  public void a(Sprite paramSprite)
  {
    a(paramSprite);
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
  
  void b(int paramInt)
  {
    synchronized (this.jdField_a_of_type_JavaUtilLinkedList)
    {
      this.jdField_a_of_type_JavaUtilLinkedList.add(Integer.valueOf(paramInt));
      return;
    }
  }
  
  public void b(GLTextureView.OnSurfaceChangedListener paramOnSurfaceChangedListener)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView instanceof GLTextureView)) {
      ((GLTextureView)localView).b(paramOnSurfaceChangedListener);
    }
  }
  
  public void b(Node paramNode)
  {
    if (paramNode.a()) {
      paramNode.a();
    }
    this.jdField_a_of_type_JavaUtilList.remove(paramNode);
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
    SpriteGLView.IVideoTimeGetter localIVideoTimeGetter = this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView$IVideoTimeGetter;
    if (localIVideoTimeGetter != null) {
      return localIVideoTimeGetter.a();
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
      if ((localObject instanceof Node)) {
        ((Node)localObject).b();
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
      if ((localObject instanceof Node)) {
        ((Node)localObject).c();
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
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView instanceof GLSurfaceView))
    {
      ((GLSurfaceView)localView).onPause();
      ((GLSurfaceView)this.jdField_a_of_type_AndroidViewView).queueEvent(local1);
      return;
    }
    if ((localView instanceof GLTextureView)) {
      ((GLTextureView)localView).a(local1);
    }
  }
  
  public void o()
  {
    Iterator localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
    while (localIterator.hasNext()) {
      ((Node)localIterator.next()).aP_();
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
      if (((arrayOfObject[i] instanceof Node.Clickable)) && (((Node.Clickable)arrayOfObject[i]).a(paramMotionEvent, getWidth(), getHeight()))) {
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
    for (;;)
    {
      throw localObject;
    }
  }
  
  public void setFps(int paramInt)
  {
    View localView = this.jdField_a_of_type_AndroidViewView;
    if ((localView instanceof GLTextureView)) {
      ((GLTextureView)localView).setFps(paramInt);
    }
  }
  
  public void setRetainBitmap(boolean paramBoolean)
  {
    this.jdField_c_of_type_Boolean = paramBoolean;
  }
  
  public void setVideoTimeGetter(SpriteGLView.IVideoTimeGetter paramIVideoTimeGetter)
  {
    this.jdField_a_of_type_ComTencentMobileqqSurfaceviewactionGlSpriteGLView$IVideoTimeGetter = paramIVideoTimeGetter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView
 * JD-Core Version:    0.7.0.1
 */