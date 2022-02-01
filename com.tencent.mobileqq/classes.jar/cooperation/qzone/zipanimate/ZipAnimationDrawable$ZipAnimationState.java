package cooperation.qzone.zipanimate;

import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Drawable.ConstantState;
import android.webkit.URLUtil;
import com.tencent.common.app.BaseApplicationImpl;

final class ZipAnimationDrawable$ZipAnimationState
  extends Drawable.ConstantState
{
  boolean aniResLoaded;
  String aniResUrl;
  ZipDrawableLoader animationResLoader;
  ZipLoadedListener animationResLoaderListener;
  int frameRate = 30;
  private boolean mOneShot;
  
  private ZipAnimationDrawable$ZipAnimationState(ZipAnimationDrawable paramZipAnimationDrawable) {}
  
  public int getAnimationDuration()
  {
    return getChildCount() * 1000 / this.frameRate;
  }
  
  public int getChangingConfigurations()
  {
    return 0;
  }
  
  public int getChildCount()
  {
    if (this.animationResLoader == null) {
      return 0;
    }
    return this.animationResLoader.getFrameCount();
  }
  
  public void loadAndShowFirstFrame() {}
  
  public Drawable newDrawable()
  {
    return new ZipAnimationDrawable(this);
  }
  
  public Drawable newDrawable(Resources paramResources)
  {
    return new ZipAnimationDrawable(this);
  }
  
  public void onBoundsChange(Rect paramRect)
  {
    this.animationResLoader.onBoundsChange(paramRect);
  }
  
  public void setAnimationRes(String paramString, int paramInt)
  {
    if ((this.aniResUrl != null) && (!this.aniResUrl.equals(paramString))) {
      this.aniResLoaded = false;
    }
    if (this.animationResLoader == null)
    {
      this.animationResLoader = new ZipDrawableLoader(BaseApplicationImpl.getApplication());
      if (this.animationResLoaderListener == null) {
        this.animationResLoaderListener = new ZipAnimationDrawable.ZipAnimationState.1(this);
      }
      this.animationResLoader.setZipLoadedListener(this.animationResLoaderListener);
      if ((!this.aniResLoaded) || (this.aniResUrl == null) || (!this.aniResUrl.equals(paramString)))
      {
        if (!URLUtil.isNetworkUrl(paramString)) {
          break label148;
        }
        this.animationResLoader.setDrawableData(paramString, -1, true);
      }
    }
    for (;;)
    {
      if (paramInt > 0) {
        this.frameRate = paramInt;
      }
      this.aniResUrl = paramString;
      return;
      if (this.aniResLoaded) {
        break;
      }
      this.animationResLoader.release();
      break;
      label148:
      this.animationResLoader.loadLocalZipData(paramString, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable.ZipAnimationState
 * JD-Core Version:    0.7.0.1
 */