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
  private String mAssetPath = "";
  private boolean mAutoPlay = false;
  private Context mContext = null;
  private PAGView mPagView = null;
  private String mPath = "";
  private int mRepeatCount = 0;
  
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
    this.mContext = paramContext;
    paramContext = this.mContext.getTheme().obtainStyledAttributes(paramAttributeSet, R.styleable.TAVStickerView, paramInt, 0);
    if (paramContext != null)
    {
      this.mAssetPath = paramContext.getString(R.styleable.TAVStickerView_stickerAssetPath);
      this.mPath = paramContext.getString(R.styleable.TAVStickerView_stickerPath);
      this.mRepeatCount = paramContext.getInt(R.styleable.TAVStickerView_repeatCount, 0);
      this.mAutoPlay = paramContext.getBoolean(R.styleable.TAVStickerView_autoPlay, false);
      paramContext.recycle();
    }
    init();
  }
  
  private void init()
  {
    if (this.mPagView == null)
    {
      this.mPagView = new PAGView(this.mContext);
      addView(this.mPagView);
    }
    if (!TextUtils.isEmpty(this.mAssetPath)) {
      setStickerAssetPath(this.mAssetPath);
    }
    for (;;)
    {
      this.mPagView.setRepeatCount(this.mRepeatCount);
      if (this.mAutoPlay) {
        this.mPagView.play();
      }
      return;
      if (!TextUtils.isEmpty(this.mPath)) {
        setStickerPath(this.mPath);
      }
    }
  }
  
  public void addListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if ((paramAnimatorListener != null) && (this.mPagView != null)) {
      this.mPagView.addListener(paramAnimatorListener);
    }
  }
  
  public long duration()
  {
    if (this.mPagView != null) {
      return this.mPagView.duration() / 1000L;
    }
    return 0L;
  }
  
  public boolean flush()
  {
    if (this.mPagView != null) {
      return this.mPagView.flush();
    }
    return false;
  }
  
  public boolean flush(boolean paramBoolean)
  {
    if (this.mPagView != null) {
      return this.mPagView.flush(paramBoolean);
    }
    return false;
  }
  
  public PAGFile getPagFile()
  {
    if (this.mPagView != null) {
      return this.mPagView.getFile();
    }
    return null;
  }
  
  public double getProgress()
  {
    if (this.mPagView != null) {
      this.mPagView.getProgress();
    }
    return 0.0D;
  }
  
  public boolean isPlaying()
  {
    if (this.mPagView != null) {
      return this.mPagView.isPlaying();
    }
    return false;
  }
  
  public float maxFrameRate()
  {
    if (this.mPagView != null) {
      this.mPagView.maxFrameRate();
    }
    return 0.0F;
  }
  
  public void play(int paramInt)
  {
    if (this.mPagView != null)
    {
      this.mPagView.setRepeatCount(paramInt);
      this.mPagView.play();
    }
  }
  
  public void removeListener(Animator.AnimatorListener paramAnimatorListener)
  {
    if ((paramAnimatorListener != null) && (this.mPagView != null)) {
      this.mPagView.removeListener(paramAnimatorListener);
    }
  }
  
  public void replaceImage(int paramInt, PAGImage paramPAGImage)
  {
    if (this.mPagView != null) {
      this.mPagView.replaceImage(paramInt, paramPAGImage);
    }
  }
  
  public void setMaxFrameRate(float paramFloat)
  {
    if (this.mPagView != null) {
      this.mPagView.setMaxFrameRate(paramFloat);
    }
  }
  
  public void setProgress(double paramDouble)
  {
    if (this.mPagView != null) {
      this.mPagView.setProgress(paramDouble);
    }
  }
  
  public void setRepeatCount(int paramInt)
  {
    if (this.mPagView != null) {
      this.mPagView.setRepeatCount(paramInt);
    }
  }
  
  public void setStickerAssetPath(String paramString)
  {
    paramString = TAVPAGFileManager.getInstance().getPAGFileFromAsset(this.mContext, paramString);
    if ((paramString != null) && (this.mPagView != null)) {
      this.mPagView.setFile(paramString);
    }
  }
  
  public void setStickerPath(String paramString)
  {
    paramString = TAVPAGFileManager.getInstance().getPAGFileFromPath(paramString);
    if ((paramString != null) && (this.mPagView != null)) {
      this.mPagView.setFile(paramString);
    }
  }
  
  public void setTextData(int paramInt, PAGText paramPAGText)
  {
    if (this.mPagView != null) {
      this.mPagView.setTextData(paramInt, paramPAGText);
    }
  }
  
  public void stop()
  {
    if (this.mPagView != null) {
      this.mPagView.stop();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.tavsticker.core.TAVStickerView
 * JD-Core Version:    0.7.0.1
 */