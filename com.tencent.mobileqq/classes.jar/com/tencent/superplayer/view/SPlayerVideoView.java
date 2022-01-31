package com.tencent.superplayer.view;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.os.Build.VERSION;
import android.os.Looper;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.FrameLayout.LayoutParams;
import com.tencent.superplayer.utils.SPlayerLogUtil;
import com.tencent.superplayer.utils.SPlayerThreadUtil;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

public class SPlayerVideoView
  extends FrameLayout
  implements ISPlayerVideoView
{
  private static final String TAG = SPlayerVideoView.class.getSimpleName();
  private ISPlayerViewBase.viewCreateCallBack mBlockCallback = new SPlayerVideoView.1(this);
  private Context mContext;
  private AtomicBoolean mDetachingView;
  private ISPlayerViewBase mDisPlayView = null;
  private int mHeight = 0;
  private boolean mIsSupportTextureView = true;
  private boolean mIsSurfaceReady = false;
  private int mSerialNO = 0;
  private SurfaceTexture mStoredSurfaceTexture;
  private Object mSurfaceOrHolder;
  private int mType = 0;
  private List<ISPlayerVideoView.IVideoViewCallBack> mVideoViewCallBackList;
  private ISPlayerViewBase.viewCreateCallBack mViewCallBack = new SPlayerVideoView.2(this);
  private int mWidth = 0;
  
  public SPlayerVideoView(Context paramContext, boolean paramBoolean)
  {
    super(paramContext.getApplicationContext());
    this.mContext = paramContext.getApplicationContext();
    this.mIsSupportTextureView = paramBoolean;
    this.mDetachingView = new AtomicBoolean(false);
    this.mSerialNO = new Random().nextInt();
    if (Build.VERSION.SDK_INT < 14) {
      this.mIsSupportTextureView = false;
    }
    initViewAfterV4();
  }
  
  private void callOnSurfaceChanged(Object paramObject, int paramInt1, int paramInt2)
  {
    if (this.mVideoViewCallBackList != null)
    {
      Iterator localIterator = this.mVideoViewCallBackList.iterator();
      while (localIterator.hasNext())
      {
        ISPlayerVideoView.IVideoViewCallBack localIVideoViewCallBack = (ISPlayerVideoView.IVideoViewCallBack)localIterator.next();
        if (localIVideoViewCallBack != null) {
          localIVideoViewCallBack.onSurfaceChanged(paramObject);
        }
      }
    }
  }
  
  private void callOnSurfaceCreate(Object paramObject)
  {
    if (this.mVideoViewCallBackList != null)
    {
      Iterator localIterator = this.mVideoViewCallBackList.iterator();
      while (localIterator.hasNext())
      {
        ISPlayerVideoView.IVideoViewCallBack localIVideoViewCallBack = (ISPlayerVideoView.IVideoViewCallBack)localIterator.next();
        if (localIVideoViewCallBack != null) {
          localIVideoViewCallBack.onSurfaceCreated(paramObject);
        }
      }
    }
  }
  
  private void callOnSurfaceDestroy(Object paramObject)
  {
    if (this.mVideoViewCallBackList != null)
    {
      Iterator localIterator = this.mVideoViewCallBackList.iterator();
      while (localIterator.hasNext())
      {
        ISPlayerVideoView.IVideoViewCallBack localIVideoViewCallBack = (ISPlayerVideoView.IVideoViewCallBack)localIterator.next();
        if (localIVideoViewCallBack != null) {
          localIVideoViewCallBack.onSurfaceDestroy(paramObject);
        }
      }
    }
  }
  
  private void initViewAfterV4()
  {
    FrameLayout.LayoutParams localLayoutParams1 = new FrameLayout.LayoutParams(-1, -1);
    FrameLayout.LayoutParams localLayoutParams2 = new FrameLayout.LayoutParams(-1, -1);
    localLayoutParams2.gravity = 17;
    setLayoutParams(localLayoutParams1);
    this.mDisPlayView = SPlayerViewFactory.createPlayView(this.mContext, this.mIsSupportTextureView);
    this.mDisPlayView.setViewCallBack(this.mViewCallBack);
    addView((View)this.mDisPlayView, localLayoutParams2);
  }
  
  public void addViewCallBack(ISPlayerVideoView.IVideoViewCallBack paramIVideoViewCallBack)
  {
    if (paramIVideoViewCallBack == null) {}
    do
    {
      return;
      if (this.mVideoViewCallBackList == null) {
        this.mVideoViewCallBackList = new CopyOnWriteArrayList();
      }
    } while (this.mVideoViewCallBackList.contains(paramIVideoViewCallBack));
    this.mVideoViewCallBackList.add(paramIVideoViewCallBack);
  }
  
  public boolean disableViewCallback()
  {
    if (this.mDisPlayView == null) {
      return false;
    }
    if (!this.mIsSurfaceReady)
    {
      SPlayerLogUtil.i(TAG, "detach from old parent view , but view not ready");
      return false;
    }
    if (this.mDetachingView.get())
    {
      SPlayerLogUtil.i(TAG, "detach from old parent view , but is detaching");
      return true;
    }
    if (!(this.mDisPlayView instanceof SPlayerTextureView))
    {
      SPlayerLogUtil.i(TAG, "detach from old parent view , but not texture view");
      return false;
    }
    SPlayerLogUtil.i(TAG, "detach from old parent view");
    this.mDetachingView.set(true);
    this.mDisPlayView.setViewCallBack(this.mBlockCallback);
    return true;
  }
  
  public boolean enableViewCallback()
  {
    SPlayerLogUtil.i(TAG, "attach to new parent view");
    if ((this.mDisPlayView != null) && ((this.mDisPlayView instanceof SPlayerTextureView)) && (this.mStoredSurfaceTexture != null) && (((SPlayerTextureView)this.mDisPlayView).getSurfaceTexture() != this.mStoredSurfaceTexture) && (Build.VERSION.SDK_INT >= 16)) {
      ((SPlayerTextureView)this.mDisPlayView).setSurfaceTexture(this.mStoredSurfaceTexture);
    }
    if (this.mDisPlayView != null) {
      this.mDisPlayView.setViewCallBack(this.mViewCallBack);
    }
    this.mDetachingView.set(false);
    return true;
  }
  
  public String getSerialNO()
  {
    return String.valueOf(this.mSerialNO);
  }
  
  public Surface getSurface()
  {
    if ((this.mIsSurfaceReady) && (this.mSurfaceOrHolder != null))
    {
      if ((this.mSurfaceOrHolder instanceof Surface)) {
        return (Surface)this.mSurfaceOrHolder;
      }
      if ((this.mSurfaceOrHolder instanceof SurfaceHolder)) {
        return ((SurfaceHolder)this.mSurfaceOrHolder).getSurface();
      }
      if ((this.mSurfaceOrHolder instanceof SurfaceTexture)) {
        return new Surface((SurfaceTexture)this.mSurfaceOrHolder);
      }
    }
    return null;
  }
  
  public boolean isSurfaceReady()
  {
    return this.mIsSurfaceReady;
  }
  
  public void removeViewCallBack(ISPlayerVideoView.IVideoViewCallBack paramIVideoViewCallBack)
  {
    if ((this.mVideoViewCallBackList != null) && (paramIVideoViewCallBack != null) && (this.mVideoViewCallBackList.contains(paramIVideoViewCallBack))) {
      this.mVideoViewCallBackList.remove(paramIVideoViewCallBack);
    }
  }
  
  public void setFixedSize(int paramInt1, int paramInt2)
  {
    SPlayerLogUtil.i(TAG, "setFixedSize, vW: " + paramInt1 + ", vH: " + paramInt2 + ", NO: " + this.mSerialNO);
    if ((paramInt1 <= 0) || (paramInt2 <= 0)) {
      return;
    }
    this.mDisPlayView.setVideoWidthAndHeight(paramInt1, paramInt2);
    if (Looper.getMainLooper() == Looper.myLooper())
    {
      ((View)this.mDisPlayView).requestLayout();
      return;
    }
    SPlayerThreadUtil.postRunnableOnMainThread(new SPlayerVideoView.3(this));
  }
  
  public void setScaleParam(float paramFloat)
  {
    this.mDisPlayView.setScaleParam(paramFloat);
  }
  
  public void setXYaxis(int paramInt)
  {
    try
    {
      this.mDisPlayView.setXYaxis(paramInt);
      this.mType = paramInt;
      SPlayerThreadUtil.postRunnableOnMainThread(new SPlayerVideoView.4(this));
      return;
    }
    catch (Exception localException)
    {
      SPlayerLogUtil.e(TAG, localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.superplayer.view.SPlayerVideoView
 * JD-Core Version:    0.7.0.1
 */