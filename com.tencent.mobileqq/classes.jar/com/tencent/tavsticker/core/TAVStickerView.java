package com.tencent.tavsticker.core;

import android.animation.Animator.AnimatorListener;
import android.content.Context;
import android.content.res.Resources.Theme;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.tencent.tavsticker.R.styleable;
import org.libpag.PAGFile;
import org.libpag.PAGImage;
import org.libpag.PAGText;
import org.libpag.PAGView;

public class TAVStickerView
  extends FrameLayout
{
  private String assetPath = "";
  private Context context = null;
  private boolean isAutoPlay = false;
  private PAGView pagView = null;
  private String path = "";
  private int repeatCount = 0;
  
  public TAVStickerView(Context paramContext)
  {
    this(paramContext, null);
  }
  
  public TAVStickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public TAVStickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.context = paramContext;
    paramContext = this.context.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.N, paramInt, 0);
    if (paramContext != null)
    {
      this.assetPath = paramContext.getString(R.styleable.Q);
      this.path = paramContext.getString(R.styleable.R);
      this.repeatCount = paramContext.getInt(R.styleable.P, 0);
      this.isAutoPlay = paramContext.getBoolean(R.styleable.O, false);
      paramContext.recycle();
    }
    init();
  }
  
  private void init()
  {
    if (this.pagView == null)
    {
      this.pagView = new PAGView(this.context);
      addView(this.pagView);
    }
    if (!TextUtils.isEmpty(this.assetPath)) {
      setStickerAssetPath(this.assetPath);
    } else if (!TextUtils.isEmpty(this.path)) {
      setStickerPath(this.path);
    }
    this.pagView.setRepeatCount(this.repeatCount);
    if (this.isAutoPlay) {
      this.pagView.play();
    }
  }
  
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if (paramAnimatorListener != null)
    {
      PAGView localPAGView = this.pagView;
      if (localPAGView != null) {
        localPAGView.addListener(paramAnimatorListener);
      }
    }
  }
  
  public long duration()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.duration() / 1000L;
    }
    return 0L;
  }
  
  public boolean flush()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.flush();
    }
    return false;
  }
  
  public boolean flush(boolean paramBoolean)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.flush(paramBoolean);
    }
    return false;
  }
  
  public PAGFile getPagFile()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.getFile();
    }
    return null;
  }
  
  public double getProgress()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.getProgress();
    }
    return 0.0D;
  }
  
  public boolean isPlaying()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      return localPAGView.isPlaying();
    }
    return false;
  }
  
  public float maxFrameRate()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.maxFrameRate();
    }
    return 0.0F;
  }
  
  public void play(int paramInt)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null)
    {
      localPAGView.setRepeatCount(paramInt);
      this.pagView.play();
    }
  }
  
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if (paramAnimatorListener != null)
    {
      PAGView localPAGView = this.pagView;
      if (localPAGView != null) {
        localPAGView.removeListener(paramAnimatorListener);
      }
    }
  }
  
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.replaceImage(paramInt, paramPAGImage);
    }
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.setMaxFrameRate(paramFloat);
    }
  }
  
  public void setProgress(double paramDouble)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.setProgress(paramDouble);
    }
  }
  
  public void setRepeatCount(int paramInt)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.setRepeatCount(paramInt);
    }
  }
  
  public void setStickerAssetPath(String paramString)
  {
    paramString = TAVPAGFileManager.getInstance().getPAGFileFromAsset(this.context, paramString);
    if (paramString != null)
    {
      PAGView localPAGView = this.pagView;
      if (localPAGView != null) {
        localPAGView.setFile(paramString);
      }
    }
  }
  
  public void setStickerPath(String paramString)
  {
    paramString = TAVPAGFileManager.getInstance().getPAGFileFromPath(paramString);
    if (paramString != null)
    {
      PAGView localPAGView = this.pagView;
      if (localPAGView != null) {
        localPAGView.setFile(paramString);
      }
    }
  }
  
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.setTextData(paramInt, paramPAGText);
    }
  }
  
  public void stop()
  {
    PAGView localPAGView = this.pagView;
    if (localPAGView != null) {
      localPAGView.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerView
 * JD-Core Version:    0.7.0.1
 */