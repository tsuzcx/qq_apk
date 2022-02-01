package com.tencent.mobileqq.qqlive.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView.IVideoSurfaceCallback;
import com.tencent.mobileqq.qqlive.api.room.ITPPlayerVideoView.IVideoViewCallback;
import com.tencent.qphone.base.util.QLog;
import com.tencent.thumbplayer.utils.TPThreadUtil;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;

@SuppressLint({"ObsoleteSdkInt"})
public class TPPlayerVideoView
  extends FrameLayout
  implements ITPPlayerVideoView
{
  private Context a;
  private ITPViewBase b;
  private ITPViewBase c = null;
  private int d = 0;
  private boolean e = false;
  private boolean f = false;
  private ViewGroup g = null;
  private int h = 0;
  private List<ITPPlayerVideoView.IVideoViewCallback> i;
  private List<ITPPlayerVideoView.IVideoSurfaceCallback> j;
  private Object k;
  private boolean l = false;
  private boolean m = false;
  private boolean n = false;
  private int o = 0;
  private int p = 0;
  private boolean q = false;
  private ITPViewBase.ViewCreateCallBack r = new TPPlayerVideoView.1(this);
  
  public TPPlayerVideoView(@NonNull Context paramContext)
  {
    super(paramContext);
    this.a = paramContext;
    this.i = new ArrayList();
    this.d = new Random().nextInt();
    setBackgroundColor(-16777216);
    c();
  }
  
  private void a(Object paramObject)
  {
    Object localObject1 = this.i;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoView.IVideoViewCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoView.IVideoViewCallback)localObject2).onSurfaceCreated(paramObject);
        }
      }
    }
    localObject1 = this.j;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoView.IVideoSurfaceCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoView.IVideoSurfaceCallback)localObject2).onSurfaceCreated(paramObject);
        }
      }
    }
  }
  
  private void b(Object paramObject)
  {
    Object localObject1 = this.i;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoView.IVideoViewCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoView.IVideoViewCallback)localObject2).onSurfaceDestroy(paramObject);
        }
      }
    }
    localObject1 = this.j;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoView.IVideoSurfaceCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoView.IVideoSurfaceCallback)localObject2).onSurfaceDestroy(paramObject);
        }
      }
    }
  }
  
  private void c()
  {
    FrameLayout.LayoutParams localLayoutParams = new FrameLayout.LayoutParams(-2, -2);
    localLayoutParams.gravity = 17;
    this.b = TPViewFactory.a(this.a, this.f, this.m, this.n);
    this.b.setViewCallBack(this.r);
    addView((View)this.b, localLayoutParams);
  }
  
  private void c(Object paramObject)
  {
    Object localObject1 = this.i;
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoView.IVideoViewCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoView.IVideoViewCallback)localObject2).onSurfaceChanged(paramObject);
        }
      }
    }
    localObject1 = this.j;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (ITPPlayerVideoView.IVideoSurfaceCallback)((Iterator)localObject1).next();
        if (localObject2 != null) {
          ((ITPPlayerVideoView.IVideoSurfaceCallback)localObject2).onSurfaceChanged(paramObject);
        }
      }
    }
  }
  
  public void a(ITPPlayerVideoView.IVideoViewCallback paramIVideoViewCallback)
  {
    if (paramIVideoViewCallback == null) {
      return;
    }
    if (this.i == null) {
      this.i = new CopyOnWriteArrayList();
    }
    if (!this.i.contains(paramIVideoViewCallback)) {
      this.i.add(paramIVideoViewCallback);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (Looper.myLooper() != Looper.getMainLooper())
    {
      TPThreadUtil.postRunnableOnMainThreadFront(new TPPlayerVideoView.6(this, paramBoolean));
      return;
    }
    if ((this.l) && (this.e) && (paramBoolean))
    {
      localObject = new FrameLayout.LayoutParams(-1, -1);
      ((FrameLayout.LayoutParams)localObject).gravity = 17;
      this.l = false;
      this.k = null;
      this.b.setViewCallBack(null);
      ITPViewBase localITPViewBase1 = TPViewFactory.a(this.a, this.f, this.m, this.n);
      localITPViewBase1.setViewCallBack(this.r);
      View localView = (View)localITPViewBase1;
      localView.setVisibility(0);
      localITPViewBase1.setOpaqueInfo(true);
      localITPViewBase1.setXYAxis(this.h);
      this.b.setOpaqueInfo(false);
      if (this.q)
      {
        removeView((View)this.b);
        this.c = null;
      }
      else
      {
        ITPViewBase localITPViewBase2 = this.c;
        if (localITPViewBase2 != null) {
          removeView((View)localITPViewBase2);
        }
        this.c = this.b;
      }
      addView(localView, (ViewGroup.LayoutParams)localObject);
      this.b = localITPViewBase1;
    }
    if (paramBoolean) {
      this.e = false;
    }
    Object localObject = this.g;
    if (localObject != null) {
      ((ViewGroup)localObject).removeAllViews();
    }
  }
  
  public boolean a()
  {
    return this.l;
  }
  
  public void addSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback paramIVideoSurfaceCallback)
  {
    if (paramIVideoSurfaceCallback == null) {
      return;
    }
    if (this.j == null) {
      this.j = new CopyOnWriteArrayList();
    }
    if (!this.j.contains(paramIVideoSurfaceCallback)) {
      this.j.add(paramIVideoSurfaceCallback);
    }
  }
  
  public void b()
  {
    this.e = true;
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      if (this.q)
      {
        this.c = null;
      }
      else
      {
        ITPViewBase localITPViewBase = this.c;
        if (localITPViewBase != null) {
          removeView((View)localITPViewBase);
        }
        this.c = null;
      }
      this.b.setOpaqueInfo(true);
      ((View)this.b).requestFocus();
    }
    else
    {
      TPThreadUtil.postRunnableOnMainThreadFront(new TPPlayerVideoView.2(this));
    }
    this.b.setRadio(0, 0);
  }
  
  public void b(ITPPlayerVideoView.IVideoViewCallback paramIVideoViewCallback)
  {
    List localList = this.i;
    if ((localList != null) && (paramIVideoViewCallback != null)) {
      localList.remove(paramIVideoViewCallback);
    }
  }
  
  public void blackScreen(boolean paramBoolean)
  {
    Object localObject = this.b;
    if ((localObject instanceof View))
    {
      localObject = (View)localObject;
      int i1;
      if (paramBoolean) {
        i1 = 4;
      } else {
        i1 = 0;
      }
      ((View)localObject).setVisibility(i1);
    }
  }
  
  public View getCurrentDisplayView()
  {
    return this;
  }
  
  public Rect getDisplayViewRect()
  {
    Rect localRect = new Rect();
    ITPViewBase localITPViewBase = this.b;
    if ((localITPViewBase instanceof View)) {
      ((View)localITPViewBase).getGlobalVisibleRect(localRect);
    }
    return localRect;
  }
  
  public ViewGroup getMidLayout()
  {
    return this.g;
  }
  
  public Object getRenderObject()
  {
    if (this.l) {
      return this.k;
    }
    return null;
  }
  
  public String getSerialNO()
  {
    return String.valueOf(this.d);
  }
  
  public int getViewRenderMode()
  {
    return this.h;
  }
  
  public Surface getViewSurface()
  {
    try
    {
      b();
      Object localObject = getRenderObject();
      if ((localObject instanceof SurfaceHolder)) {
        return ((SurfaceHolder)localObject).getSurface();
      }
      if (((localObject instanceof SurfaceTexture)) && (Build.VERSION.SDK_INT > 14)) {
        return new Surface((SurfaceTexture)localObject);
      }
      if ((localObject instanceof Surface))
      {
        localObject = (Surface)localObject;
        return localObject;
      }
    }
    catch (Exception localException)
    {
      QLog.e("TPPlayer[TPPlayerVideoView]", 1, "getViewSurface error", localException);
    }
    return null;
  }
  
  public void release()
  {
    removeAllViews();
    this.a = null;
  }
  
  public void removeSurfaceCallback(ITPPlayerVideoView.IVideoSurfaceCallback paramIVideoSurfaceCallback)
  {
    List localList = this.j;
    if ((localList != null) && (paramIVideoSurfaceCallback != null)) {
      localList.remove(paramIVideoSurfaceCallback);
    }
  }
  
  public boolean setDegree(int paramInt)
  {
    boolean bool = this.b.a(paramInt);
    TPThreadUtil.postRunnableOnMainThread(new TPPlayerVideoView.7(this));
    return bool;
  }
  
  public void setFixedSize(int paramInt1, int paramInt2)
  {
    if (paramInt1 > 0)
    {
      if (paramInt2 <= 0) {
        return;
      }
      this.b.setVideoWidthAndHeight(paramInt1, paramInt2);
      if (Looper.getMainLooper() == Looper.myLooper())
      {
        ((View)this.b).requestLayout();
        return;
      }
      TPThreadUtil.postRunnableOnMainThread(new TPPlayerVideoView.3(this));
    }
  }
  
  public void setMidLayout(View paramView)
  {
    if (paramView != null)
    {
      if ((paramView instanceof ViewStub))
      {
        this.g = ((ViewGroup)((ViewStub)paramView).inflate());
        return;
      }
      if ((paramView instanceof ViewGroup)) {
        this.g = ((ViewGroup)paramView);
      }
    }
  }
  
  public void setRadio(int paramInt1, int paramInt2)
  {
    ITPViewBase localITPViewBase = this.b;
    if (localITPViewBase != null) {
      localITPViewBase.setRadio(paramInt1, paramInt2);
    }
  }
  
  public void setRenderGravity(int paramInt)
  {
    Object localObject = this.b;
    if (localObject != null)
    {
      localObject = (FrameLayout.LayoutParams)((View)localObject).getLayoutParams();
      ((FrameLayout.LayoutParams)localObject).gravity = paramInt;
      setLayoutParams((ViewGroup.LayoutParams)localObject);
    }
  }
  
  public void setScaleParam(float paramFloat)
  {
    this.b.setScaleParam(paramFloat);
  }
  
  public void setXYAxis(int paramInt)
  {
    try
    {
      this.b.setXYAxis(paramInt);
      this.h = paramInt;
      TPThreadUtil.postRunnableOnMainThread(new TPPlayerVideoView.5(this));
      return;
    }
    catch (Exception localException)
    {
      QLog.e("TPPlayer[TPPlayerVideoView]", 1, "setXYAis error", localException);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.view.TPPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */