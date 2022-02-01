package cooperation.qzone.zipanimate;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.Drawable;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.Lifecycle.Event;
import androidx.lifecycle.LifecycleOwner;
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
  OnAnimationListener mListener;
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
    if ((!this.mRunning) && (!this.mShowLastFrameWhenStop) && (!this.mIsShowFirstFrame)) {
      return;
    }
    if (!this.mAnimationState.aniResLoaded) {
      return;
    }
    Drawable localDrawable = this.mAnimationState.animationResLoader.getCurrentDrawable();
    if (localDrawable == null) {
      return;
    }
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
    Object localObject = this.mAnimationState.animationResLoader;
    int i = -1;
    if (localObject != null)
    {
      localObject = this.mAnimationState.animationResLoader.getCurrentDrawable();
      if (localObject == null) {
        return -1;
      }
      i = (int)(((Drawable)localObject).getIntrinsicHeight() * this.mScale);
    }
    return i;
  }
  
  public int getIntrinsicWidth()
  {
    Object localObject = this.mAnimationState.animationResLoader;
    int i = -1;
    if (localObject != null)
    {
      localObject = this.mAnimationState.animationResLoader.getCurrentDrawable();
      if (localObject == null) {
        return -1;
      }
      i = (int)(((Drawable)localObject).getIntrinsicWidth() * this.mScale);
    }
    return i;
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
    ZipAnimationDrawable.ZipAnimationState localZipAnimationState = this.mAnimationState;
    return (localZipAnimationState != null) && (localZipAnimationState.aniResLoaded);
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
    ZipAnimationDrawable.ZipAnimationState localZipAnimationState = this.mAnimationState;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localZipAnimationState != null)
    {
      if (localZipAnimationState.animationResLoader == null) {
        return false;
      }
      bool1 = bool2;
      if (this.mAnimationState.animationResLoader.getCurrentDrawable() != null) {
        bool1 = true;
      }
    }
    return bool1;
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
    ZipAnimationDrawable.ZipAnimationState localZipAnimationState = this.mAnimationState;
    if ((localZipAnimationState != null) && (localZipAnimationState.animationResLoader != null)) {
      this.mAnimationState.animationResLoader.loadFrame(paramInt, null);
    }
  }
  
  public void release()
  {
    ZipAnimationDrawable.ZipAnimationState localZipAnimationState = this.mAnimationState;
    if ((localZipAnimationState != null) && (localZipAnimationState.animationResLoader != null)) {
      this.mAnimationState.animationResLoader.release();
    }
  }
  
  public void restartAnimation()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("restartAnimation ");
    localStringBuilder.append(hashCode());
    QLog.e("zip_drawable", 1, localStringBuilder.toString());
    if (this.mIsPagePause)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("restartAnimation stop , page is pause");
      localStringBuilder.append(hashCode());
      QLog.e("zip_drawable", 1, localStringBuilder.toString());
      return;
    }
    this.mRunning = true;
    if (!this.mAnimationState.aniResLoaded) {
      return;
    }
    PageLiveCycleProxy.addPageLifeCycle(this);
    this.mAnimationState.animationResLoader.loadFrame(0, null);
    this.mRunning = true;
    this.startTime = SystemClock.uptimeMillis();
    this.uiHandler.removeMessages(1000);
    this.uiHandler.sendEmptyMessageDelayed(1000, 1000 / this.mAnimationState.frameRate);
  }
  
  public void setAlpha(int paramInt) {}
  
  public void setAnimationListener(OnAnimationListener paramOnAnimationListener)
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
    ZipAnimationDrawable.ZipAnimationState localZipAnimationState = this.mAnimationState;
    if ((localZipAnimationState != null) && (localZipAnimationState.animationResLoader != null)) {
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
    if (isVisible() != paramBoolean1) {
      i = 1;
    } else {
      i = 0;
    }
    if (i != 0) {
      if (paramBoolean1)
      {
        if (this.mRunning) {
          this.uiHandler.sendEmptyMessage(1000);
        }
      }
      else {
        this.uiHandler.removeMessages(1000);
      }
    }
    return super.setVisible(paramBoolean1, paramBoolean2);
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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("start ");
    localStringBuilder.append(hashCode());
    QLog.e("zip_drawable", 1, localStringBuilder.toString());
    if (this.mIsPagePause)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("start stop , page is pause");
      localStringBuilder.append(hashCode());
      QLog.e("zip_drawable", 1, localStringBuilder.toString());
      return;
    }
    this.mRunning = true;
    if (!this.mAnimationState.aniResLoaded) {
      return;
    }
    restartAnimation();
  }
  
  public void stop()
  {
    if (QZLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("stop ");
      localStringBuilder.append(hashCode());
      QZLog.i("zip_drawable", 2, localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable
 * JD-Core Version:    0.7.0.1
 */