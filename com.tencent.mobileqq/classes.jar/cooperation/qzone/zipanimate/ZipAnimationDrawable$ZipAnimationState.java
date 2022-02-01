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
  private boolean mOneShot = false;
  
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
    ZipDrawableLoader localZipDrawableLoader = this.animationResLoader;
    if (localZipDrawableLoader == null) {
      return 0;
    }
    return localZipDrawableLoader.getFrameCount();
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
    Object localObject = this.aniResUrl;
    if ((localObject != null) && (!((String)localObject).equals(paramString))) {
      this.aniResLoaded = false;
    }
    localObject = this.animationResLoader;
    if (localObject == null) {
      this.animationResLoader = new ZipDrawableLoader(BaseApplicationImpl.getApplication());
    } else if (!this.aniResLoaded) {
      ((ZipDrawableLoader)localObject).release();
    }
    if (this.animationResLoaderListener == null) {
      this.animationResLoaderListener = new ZipAnimationDrawable.ZipAnimationState.1(this);
    }
    this.animationResLoader.setZipLoadedListener(this.animationResLoaderListener);
    if (this.aniResLoaded)
    {
      localObject = this.aniResUrl;
      if ((localObject != null) && (((String)localObject).equals(paramString))) {}
    }
    else if (URLUtil.isNetworkUrl(paramString))
    {
      this.animationResLoader.setDrawableData(paramString, -1, true);
    }
    else
    {
      this.animationResLoader.loadLocalZipData(paramString, true);
    }
    if (paramInt > 0) {
      this.frameRate = paramInt;
    }
    this.aniResUrl = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipAnimationDrawable.ZipAnimationState
 * JD-Core Version:    0.7.0.1
 */