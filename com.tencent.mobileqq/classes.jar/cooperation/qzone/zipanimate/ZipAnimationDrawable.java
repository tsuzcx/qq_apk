package cooperation.qzone.zipanimate;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.Lifecycle.Event;
import android.arch.lifecycle.LifecycleOwner;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.util.QZLog;
import cooperation.qzone.zipanimate.life.PageLifeCycle;
import cooperation.qzone.zipanimate.life.PageLiveCycleProxy;

public class ZipAnimationDrawable
  extends Drawable
  implements Animatable, PageLifeCycle
{
  static final int MSG_LOAD_NEXT_FRAME = 1000;
  private static final String TAG = "zip_drawable";
  private ZipAnimationDrawable.ZipAnimationState mAnimationState;
  private boolean mIsPagePause = false;
  private boolean mIsShowFirstFrame = false;
  private Lifecycle mLifecycle;
  ZipAnimationDrawable.OnAnimationListener mListener;
  private boolean mRepeatAnimation = false;
  private volatile boolean mRunning;
  private float mScale = 1.0F;
  private boolean mShowLastFrameWhenStop = false;
  long startTime;
  Handler uiHandler = new ZipAnimationDrawable.2(this, Looper.getMainLooper());
  
  public ZipAnimationDrawable()
  {
    this.mAnimationState = new ZipAnimationDrawable.ZipAnimationState(this, null);
  }
  
  public ZipAnimationDrawable(ZipAnimationDrawable.ZipAnimationState paramZipAnimationState)
  {
    this.mAnimationState = paramZipAnimationState;
  }
  
  public ZipAnimationDrawable(String paramString, int paramInt)
  {
    this.mAnimationState = new ZipAnimationDrawable.ZipAnimationState(this, null);
    setAnimationRes(paramString, paramInt);
  }
  
  public void bindLifeCycle(Lifecycle paramLifecycle) {}
  
  @Deprecated
  public void clearFirstFrame()
  {
    this.mAnimationState.animationResLoader.release();
  }
  
  public void draw(Canvas paramCanvas)
  {
    if ((!this.mRunning) && (!this.mShowLastFrameWhenStop) && (!this.mIsShowFirstFrame)) {}
    Drawable localDrawable;
    do
    {
      do
      {
        return;
      } while (!this.mAnimationState.aniResLoaded);
      localDrawable = this.mAnimationState.animationResLoader.getCurrentDrawable();
    } while (localDrawable == null);
    localDrawable.setBounds(getBounds());
    localDrawable.draw(paramCanvas);
  }
  
  public String getAnimationResZipUrl()
  {
    return this.mAnimationState.aniResUrl;
  }
  
  public int getDuration()
  {
    return this.mAnimationState.getAnimationDuration();
  }
  
  public int getIntrinsicHeight()
  {
    Drawable localDrawable;
    if (this.mAnimationState.animationResLoader != null)
    {
      localDrawable = this.mAnimationState.animationResLoader.getCurrentDrawable();
      if (localDrawable != null) {}
    }
    else
    {
      return -1;
    }
    return (int)(localDrawable.getIntrinsicHeight() * this.mScale);
  }
  
  public int getIntrinsicWidth()
  {
    Drawable localDrawable;
    if (this.mAnimationState.animationResLoader != null)
    {
      localDrawable = this.mAnimationState.animationResLoader.getCurrentDrawable();
      if (localDrawable != null) {}
    }
    else
    {
      return -1;
    }
    return (int)(localDrawable.getIntrinsicWidth() * this.mScale);
  }
  
  public int getNumberOfFrames()
  {
    return this.mAnimationState.getChildCount();
  }
  
  public int getOpacity()
  {
    return 0;
  }
  
  public boolean hasDownloadComplete()
  {
    return (this.mAnimationState != null) && (this.mAnimationState.aniResLoaded);
  }
  
  public boolean isOneShot()
  {
    return ZipAnimationDrawable.ZipAnimationState.access$200(this.mAnimationState);
  }
  
  public boolean isRunning()
  {
    return this.mRunning;
  }
  
  public boolean isZipDrawableShow()
  {
    if ((this.mAnimationState == null) || (this.mAnimationState.animationResLoader == null)) {}
    while (this.mAnimationState.animationResLoader.getCurrentDrawable() == null) {
      return false;
    }
    return true;
  }
  
  public void loadAndShowFirstFrame()
  {
    this.mIsShowFirstFrame = true;
    this.mAnimationState.animationResLoader.setDrawableLoadedListener(new ZipAnimationDrawable.1(this));
  }
  
  protected void onBoundsChange(Rect paramRect)
  {
    this.mAnimationState.onBoundsChange(paramRect);
    super.onBoundsChange(paramRect);
  }
  
  public void onLifecycleChanged(LifecycleOwner paramLifecycleOwner, Lifecycle.Event paramEvent) {}
  
  public void onPageCreate(LifecycleOwner paramLifecycleOwner) {}
  
  public void onPageDestroy(LifecycleOwner paramLifecycleOwner)
  {
    QLog.i("zip_drawable", 1, "onPageDestroy");
    stop();
    release();
  }
  
  public void onPagePause(LifecycleOwner paramLifecycleOwner)
  {
    QLog.i("zip_drawable", 1, "onPagePause");
    this.mIsPagePause = true;
    stop();
  }
  
  public void onPageResume(LifecycleOwner paramLifecycleOwner)
  {
    QLog.i("zip_drawable", 1, "onPageResume");
    this.mIsPagePause = false;
    restartAnimation();
  }
  
  public void onPageStart(LifecycleOwner paramLifecycleOwner) {}
  
  public void onPageStop(LifecycleOwner paramLifecycleOwner)
  {
    QLog.i("zip_drawable", 1, "onPageStop");
    stop();
  }
  
  public void preLoadFrame(int paramInt)
  {
    if ((this.mAnimationState != null) && (this.mAnimationState.animationResLoader != null)) {
      this.mAnimationState.animationResLoader.loadFrame(paramInt, null);
    }
  }
  
  public void release()
  {
    if ((this.mAnimationState != null) && (this.mAnimationState.animationResLoader != null)) {
      this.mAnimationState.animationResLoader.release();
    }
  }
  
  public void restartAnimation()
  {
    QLog.e("zip_drawable", 1, "restartAnimation " + hashCode());
    if (this.mIsPagePause) {
      QLog.e("zip_drawable", 1, "restartAnimation stop , page is pause" + hashCode());
    }
    do
    {
      return;
      this.mRunning = true;
    } while (!this.mAnimationState.aniResLoaded);
    PageLiveCycleProxy.addPageLifeCycle(this);
    this.mAnimationState.animationResLoader.loadFrame(0, null);
    this.mRunning = true;
    this.startTime = SystemClock.uptimeMillis();
    this.uiHandler.removeMessages(1000);
    this.uiHandler.sendEmptyMessageDelayed(1000, 1000 / this.mAnimationState.frameRate);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setAnimationListener(ZipAnimationDrawable.OnAnimationListener paramOnAnimationListener)
  {
    this.mListener = paramOnAnimationListener;
  }
  
  public void setAnimationRes(String paramString, int paramInt)
  {
    this.mAnimationState.setAnimationRes(paramString, paramInt);
  }
  
  public void setColorFilter(ColorFilter paramColorFilter) {}
  
  public void setDrawableLoadedListener(ZipFrameLoadedListener paramZipFrameLoadedListener)
  {
    if (this.mAnimationState.animationResLoader != null) {
      this.mAnimationState.animationResLoader.setDrawableLoadedListener(paramZipFrameLoadedListener);
    }
  }
  
  public void setIsShowFirstFrame(boolean paramBoolean)
  {
    this.mIsShowFirstFrame = paramBoolean;
  }
  
  public void setOneShot(boolean paramBoolean)
  {
    ZipAnimationDrawable.ZipAnimationState.access$202(this.mAnimationState, paramBoolean);
  }
  
  public void setPreloadNum(int paramInt)
  {
    if ((this.mAnimationState != null) && (this.mAnimationState.animationResLoader != null)) {
      this.mAnimationState.animationResLoader.setPreloadNum(paramInt);
    }
  }
  
  public void setRepeatAnimation(boolean paramBoolean)
  {
    this.mRepeatAnimation = paramBoolean;
  }
  
  public void setScale(float paramFloat)
  {
    this.mScale = paramFloat;
    if (this.mAnimationState.animationResLoader != null) {
      this.mAnimationState.animationResLoader.setScale(this.mScale);
    }
  }
  
  public void setShowLastFrameWhenStop(boolean paramBoolean)
  {
    this.mShowLastFrameWhenStop = paramBoolean;
  }
  
  public boolean setVisible(boolean paramBoolean1, boolean paramBoolean2)
  {
    int i;
    if (isVisible() != paramBoolean1)
    {
      i = 1;
      if (i != 0)
      {
        if (!paramBoolean1) {
          break label48;
        }
        if (this.mRunning) {
          this.uiHandler.sendEmptyMessage(1000);
        }
      }
    }
    for (;;)
    {
      return super.setVisible(paramBoolean1, paramBoolean2);
      i = 0;
      break;
      label48:
      this.uiHandler.removeMessages(1000);
    }
  }
  
  public void setZipFirstFrameLoadedListener(ZipFirstFrameLoadedListener paramZipFirstFrameLoadedListener)
  {
    if (this.mAnimationState.animationResLoader != null) {
      this.mAnimationState.animationResLoader.setZipFirstFrameLoadedListener(paramZipFirstFrameLoadedListener);
    }
  }
  
  public void showFirstFrame()
  {
    this.mAnimationState.animationResLoader.selectFrame(0);
  }
  
  public void start()
  {
    QLog.e("zip_drawable", 1, "start " + hashCode());
    if (this.mIsPagePause) {
      QLog.e("zip_drawable", 1, "start stop , page is pause" + hashCode());
    }
    do
    {
      return;
      this.mRunning = true;
    } while (!this.mAnimationState.aniResLoaded);
    restartAnimation();
  }
  
  public void stop()
  {
    if (QZLog.isColorLevel()) {
      QZLog.i("zip_drawable", 2, "stop " + hashCode());
    }
    this.uiHandler.removeMessages(1000);
    this.mRunning = false;
  }
  
  public void unscheduleSelf(Runnable paramRunnable)
  {
    this.mRunning = false;
    super.unscheduleSelf(paramRunnable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */