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
    paramContext = this.context.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.TAVStickerView, paramInt, 0);
    if (paramContext != null)
    {
      this.assetPath = paramContext.getString(R.styleable.TAVStickerView_stickerAssetPath);
      this.path = paramContext.getString(R.styleable.TAVStickerView_stickerPath);
      this.repeatCount = paramContext.getInt(R.styleable.TAVStickerView_repeatCount, 0);
      this.isAutoPlay = paramContext.getBoolean(R.styleable.TAVStickerView_autoPlay, false);
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
    }
    for (;;)
    {
      this.pagView.setRepeatCount(this.repeatCount);
      if (this.isAutoPlay) {
        this.pagView.play();
      }
      return;
      if (!TextUtils.isEmpty(this.path)) {
        setStickerPath(this.path);
      }
    }
  }
  
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if ((paramAnimatorListener != null) && (this.pagView != null)) {
      this.pagView.addListener(paramAnimatorListener);
    }
  }
  
  public long duration()
  {
    if (this.pagView != null) {
      return this.pagView.duration() / 1000L;
    }
    return 0L;
  }
  
  public boolean flush()
  {
    if (this.pagView != null) {
      return this.pagView.flush();
    }
    return false;
  }
  
  public boolean flush(boolean paramBoolean)
  {
    if (this.pagView != null) {
      return this.pagView.flush(paramBoolean);
    }
    return false;
  }
  
  public PAGFile getPagFile()
  {
    if (this.pagView != null) {
      return this.pagView.getFile();
    }
    return null;
  }
  
  public double getProgress()
  {
    if (this.pagView != null) {
      this.pagView.getProgress();
    }
    return 0.0D;
  }
  
  public boolean isPlaying()
  {
    if (this.pagView != null) {
      return this.pagView.isPlaying();
    }
    return false;
  }
  
  public float maxFrameRate()
  {
    if (this.pagView != null) {
      this.pagView.maxFrameRate();
    }
    return 0.0F;
  }
  
  public void play(int paramInt)
  {
    if (this.pagView != null)
    {
      this.pagView.setRepeatCount(paramInt);
      this.pagView.play();
    }
  }
  
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if ((paramAnimatorListener != null) && (this.pagView != null)) {
      this.pagView.removeListener(paramAnimatorListener);
    }
  }
  
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    if (this.pagView != null) {
      this.pagView.replaceImage(paramInt, paramPAGImage);
    }
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    if (this.pagView != null) {
      this.pagView.setMaxFrameRate(paramFloat);
    }
  }
  
  public void setProgress(double paramDouble)
  {
    if (this.pagView != null) {
      this.pagView.setProgress(paramDouble);
    }
  }
  
  public void setRepeatCount(int paramInt)
  {
    if (this.pagView != null) {
      this.pagView.setRepeatCount(paramInt);
    }
  }
  
  public void setStickerAssetPath(String paramString)
  {
    paramString = TAVPAGFileManager.getInstance().getPAGFileFromAsset(this.context, paramString);
    if ((paramString != null) && (this.pagView != null)) {
      this.pagView.setFile(paramString);
    }
  }
  
  public void setStickerPath(String paramString)
  {
    paramString = TAVPAGFileManager.getInstance().getPAGFileFromPath(paramString);
    if ((paramString != null) && (this.pagView != null)) {
      this.pagView.setFile(paramString);
    }
  }
  
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    if (this.pagView != null) {
      this.pagView.setTextData(paramInt, paramPAGText);
    }
  }
  
  public void stop()
  {
    if (this.pagView != null) {
      this.pagView.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerView
 * JD-Core Version:    0.7.0.1
 */