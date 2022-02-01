package com.tencent.viola.ui.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.ClipDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.LayerDrawable;
import android.os.Build.VERSION;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.SeekBar;
import com.tencent.viola.ui.component.VSeekBar;
import com.tencent.viola.ui.dom.style.FlexConvertUtils;
import com.tencent.viola.utils.ViolaLogUtils;
import java.lang.ref.WeakReference;
import java.lang.reflect.Field;

@SuppressLint({"AppCompatCustomView"})
public class VSeekBarView
  extends SeekBar
  implements IVView<VSeekBar>
{
  public static final String DEFAULT_BACKGROUND_COLOR = "#66ffffff";
  public static final String DEFAULT_CYCLE_THUMB_COLOR = "#ffffff";
  public static final String DEFAULT_PROGRESS_COLOR = "#ffffff";
  private GradientDrawable backgroundDrawable;
  private GradientDrawable cycleThumbDrawable;
  private Drawable[] drawables;
  private boolean enableSeek = true;
  private LayerDrawable layerDrawable;
  private WeakReference<VSeekBar> mWeakReference;
  private GradientDrawable progressDrawable;
  
  public VSeekBarView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  private void init()
  {
    this.drawables = new Drawable[2];
    this.backgroundDrawable = new GradientDrawable();
    this.backgroundDrawable.setShape(0);
    setBackgroundColor(Color.parseColor("#66ffffff"));
    this.drawables[0] = this.backgroundDrawable;
    this.progressDrawable = new GradientDrawable();
    this.progressDrawable.setShape(0);
    setProgressColor(Color.parseColor("#ffffff"));
    ClipDrawable localClipDrawable = new ClipDrawable(this.progressDrawable, 3, 1);
    this.drawables[1] = localClipDrawable;
    setSeekBarHeight(FlexConvertUtils.dip2px(3));
    setProgressDrawable(this.layerDrawable);
    this.cycleThumbDrawable = new GradientDrawable();
    this.cycleThumbDrawable.setShape(1);
    this.cycleThumbDrawable.setColor(Color.parseColor("#ffffff"));
    setThumbSize(FlexConvertUtils.dip2px(15));
    setThumb(this.cycleThumbDrawable);
  }
  
  public void bindComponent(VSeekBar paramVSeekBar)
  {
    this.mWeakReference = new WeakReference(paramVSeekBar);
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    int i = paramMotionEvent.getAction();
    if (i != 0)
    {
      if ((i == 1) && (getParent() != null)) {
        getParent().requestDisallowInterceptTouchEvent(false);
      }
    }
    else if (getParent() != null) {
      getParent().requestDisallowInterceptTouchEvent(true);
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public VSeekBar getComponent()
  {
    return (VSeekBar)this.mWeakReference.get();
  }
  
  public void invalidateProgressDrawable()
  {
    setProgressDrawable(this.layerDrawable);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (!this.enableSeek) {
      return true;
    }
    return super.onTouchEvent(paramMotionEvent);
  }
  
  public void setBackgroundColor(int paramInt)
  {
    this.backgroundDrawable.setColor(paramInt);
  }
  
  public void setCycleThumbColor(int paramInt)
  {
    if (paramInt == 0)
    {
      setThumb(null);
      return;
    }
    this.cycleThumbDrawable = new GradientDrawable();
    this.cycleThumbDrawable.setColor(paramInt);
    if (getComponent() != null) {
      paramInt = getComponent().getThumbSize();
    } else {
      paramInt = 0;
    }
    setThumbSize(paramInt);
    setThumb(this.cycleThumbDrawable);
  }
  
  public void setEnableSeek(boolean paramBoolean)
  {
    this.enableSeek = paramBoolean;
  }
  
  public void setProgressColor(int paramInt)
  {
    this.progressDrawable.setColor(paramInt);
  }
  
  public void setSeekBarHeight(int paramInt)
  {
    this.layerDrawable = new LayerDrawable(this.drawables);
    this.layerDrawable.setId(0, 16908288);
    this.layerDrawable.setId(1, 16908301);
    if (Build.VERSION.SDK_INT >= 23)
    {
      this.layerDrawable.setLayerHeight(0, paramInt);
      this.layerDrawable.setLayerHeight(1, paramInt);
      this.layerDrawable.setLayerGravity(0, 16);
      this.layerDrawable.setLayerGravity(1, 16);
      return;
    }
    try
    {
      Field localField = getClass().getSuperclass().getSuperclass().getSuperclass().getDeclaredField("mMaxHeight");
      localField.setAccessible(true);
      localField.set(this, Integer.valueOf(paramInt));
      return;
    }
    catch (Exception localException)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[setSeekBarHeight]: ");
      localStringBuilder.append(localException.getMessage());
      ViolaLogUtils.e("VSeekBarView", localStringBuilder.toString());
    }
  }
  
  public void setThumbSize(int paramInt)
  {
    this.cycleThumbDrawable.setSize(paramInt, paramInt);
    this.cycleThumbDrawable.setCornerRadius(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.viola.ui.view.VSeekBarView
 * JD-Core Version:    0.7.0.1
 */