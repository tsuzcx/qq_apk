package cooperation.qzone.zipanimate;

import android.graphics.drawable.Drawable;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract interface ZipDrawableLoaderInterface
{
  public abstract int getCurFrameNum();
  
  public abstract Drawable getCurrentDrawable();
  
  public abstract int getFrameCount();
  
  public abstract CopyOnWriteArrayList<AnimationFrame> getFrames();
  
  public abstract void loadFrame(int paramInt, ZipFrameLoadedListener paramZipFrameLoadedListener);
  
  public abstract boolean nextFrame();
  
  public abstract void release();
  
  public abstract void setDrawableData(String paramString, int paramInt, boolean paramBoolean);
  
  public abstract void setDrawableData(String paramString1, String paramString2, String paramString3, int paramInt, boolean paramBoolean);
  
  public abstract void setFrame(int paramInt);
  
  public abstract void setPreloadNum(int paramInt);
  
  public abstract void setRecycleFlag(boolean paramBoolean);
  
  public abstract void setSize(int paramInt1, int paramInt2);
  
  public abstract void setZipLoadedListener(ZipLoadedListener paramZipLoadedListener);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     cooperation.qzone.zipanimate.ZipDrawableLoaderInterface
 * JD-Core Version:    0.7.0.1
 */