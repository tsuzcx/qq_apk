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
  private int a = 0;
  private final LinkedList<Integer> b = new LinkedList();
  private final List<BaseNode> c = Collections.synchronizedList(new ArrayList());
  private List<Runnable> d = new LinkedList();
  private final Object e = new Object();
  private List<Runnable> f = new ArrayList();
  private final Object g = new Object();
  private SpriteGLView.IVideoTimeGetter h;
  private long i;
  protected View t;
  public boolean u = false;
  public boolean v = false;
  int w;
  public volatile boolean x;
  
  public SpriteGLView(Context paramContext)
  {
    super(paramContext);
    a();
  }
  
  public SpriteGLView(Context paramContext, int paramInt)
  {
    super(paramContext);
    this.a = paramInt;
    a();
  }
  
  public SpriteGLView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.obtainStyledAttributes(paramAttributeSet, R.styleable.SpriteGLView, 0, 0);
    try
    {
      this.a = paramContext.getInt(0, 0);
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
    if (this.a == 0)
    {
      localObject = new GLSurfaceView(getContext());
      this.t = ((View)localObject);
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
      this.t = ((View)localObject);
      addView((View)localObject, -1, -1);
      ((GLTextureView)localObject).setRenderer(new SpriteGLView.SimpleRenderer(this, null));
    }
    setFocusableInTouchMode(true);
  }
  
  protected GLTextureView a(Context paramContext)
  {
    return new GLTextureView(paramContext);
  }
  
  public void a(int paramInt)
  {
    LinkedList localLinkedList = this.b;
    int m = -1;
    int j = 0;
    for (;;)
    {
      int k = m;
      try
      {
        if (j < this.b.size())
        {
          if (paramInt != ((Integer)this.b.get(j)).intValue()) {
            break label94;
          }
          k = j;
        }
        if (k > 0)
        {
          this.b.remove(k);
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
        j += 1;
      }
    }
  }
  
  public void a(int paramInt, Node paramNode)
  {
    synchronized (this.c)
    {
      if (!this.c.contains(paramNode)) {
        this.c.add(paramInt, paramNode);
      }
      return;
    }
  }
  
  public void a(GLTextureView.OnSurfaceChangedListener paramOnSurfaceChangedListener)
  {
    View localView = this.t;
    if ((localView instanceof GLTextureView)) {
      ((GLTextureView)localView).a(paramOnSurfaceChangedListener);
    }
  }
  
  public void a(Node paramNode)
  {
    synchronized (this.c)
    {
      if (!this.c.contains(paramNode)) {
        this.c.add(paramNode);
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
    synchronized (this.g)
    {
      this.f.add(paramRunnable);
      return;
    }
  }
  
  void b(int paramInt)
  {
    synchronized (this.b)
    {
      this.b.add(Integer.valueOf(paramInt));
      return;
    }
  }
  
  public void b(GLTextureView.OnSurfaceChangedListener paramOnSurfaceChangedListener)
  {
    View localView = this.t;
    if ((localView instanceof GLTextureView)) {
      ((GLTextureView)localView).b(paramOnSurfaceChangedListener);
    }
  }
  
  public void b(Node paramNode)
  {
    if (paramNode.ds_()) {
      paramNode.f();
    }
    this.c.remove(paramNode);
  }
  
  public void b(Runnable paramRunnable)
  {
    synchronized (this.e)
    {
      this.d.add(paramRunnable);
      return;
    }
  }
  
  public int getCurrentVideoTime()
  {
    SpriteGLView.IVideoTimeGetter localIVideoTimeGetter = this.h;
    if (localIVideoTimeGetter != null) {
      return localIVideoTimeGetter.c();
    }
    return (int)(System.currentTimeMillis() - this.i);
  }
  
  public List<BaseNode> getNodeList()
  {
    return this.c;
  }
  
  public void k()
  {
    synchronized (this.g)
    {
      this.f.clear();
      return;
    }
  }
  
  public boolean l()
  {
    return this.c.isEmpty();
  }
  
  public void m()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "pause");
    }
    Object[] arrayOfObject = this.c.toArray();
    int k = arrayOfObject.length;
    int j = 0;
    while (j < k)
    {
      Object localObject = arrayOfObject[j];
      if ((localObject instanceof Node)) {
        ((Node)localObject).g();
      }
      j += 1;
    }
  }
  
  public void n()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "resume");
    }
    Object[] arrayOfObject = this.c.toArray();
    int k = arrayOfObject.length;
    int j = 0;
    while (j < k)
    {
      Object localObject = arrayOfObject[j];
      if ((localObject instanceof Node)) {
        ((Node)localObject).h();
      }
      j += 1;
    }
  }
  
  public void o()
  {
    if (QLog.isColorLevel()) {
      QLog.d("SpriteGLView", 2, "stopDraw");
    }
    SpriteGLView.1 local1 = new SpriteGLView.1(this);
    View localView = this.t;
    if ((localView instanceof GLSurfaceView))
    {
      ((GLSurfaceView)localView).onPause();
      ((GLSurfaceView)this.t).queueEvent(local1);
      return;
    }
    if ((localView instanceof GLTextureView)) {
      ((GLTextureView)localView).a(local1);
    }
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    super.onSizeChanged(paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    Object[] arrayOfObject = this.c.toArray();
    int j = arrayOfObject.length - 1;
    while (j >= 0)
    {
      if (((arrayOfObject[j] instanceof Node.Clickable)) && (((Node.Clickable)arrayOfObject[j]).a(paramMotionEvent, getWidth(), getHeight()))) {
        return true;
      }
      j -= 1;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void p()
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((Node)localIterator.next()).k();
    }
  }
  
  public void q()
  {
    synchronized (this.b)
    {
      int[] arrayOfInt = new int[this.b.size()];
      int j = 0;
      while (!this.b.isEmpty())
      {
        arrayOfInt[j] = ((Integer)this.b.remove(0)).intValue();
        j += 1;
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
    View localView = this.t;
    if ((localView instanceof GLTextureView)) {
      ((GLTextureView)localView).setFps(paramInt);
    }
  }
  
  public void setRetainBitmap(boolean paramBoolean)
  {
    this.x = paramBoolean;
  }
  
  public void setVideoTimeGetter(SpriteGLView.IVideoTimeGetter paramIVideoTimeGetter)
  {
    this.h = paramIVideoTimeGetter;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.surfaceviewaction.gl.SpriteGLView
 * JD-Core Version:    0.7.0.1
 */