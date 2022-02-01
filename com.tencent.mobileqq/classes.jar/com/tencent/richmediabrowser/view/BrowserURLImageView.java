package com.tencent.richmediabrowser.view;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import com.tencent.image.URLDrawable;
import com.tencent.image.URLImageView;

public class BrowserURLImageView
  extends URLImageView
{
  public boolean ignoreLayout = false;
  public URLDrawable mDecoding;
  
  public BrowserURLImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public BrowserURLImageView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void destory()
  {
    setDecodingDrawble(null);
    setImageDrawable(null);
  }
  
  public void onLoadFialed(URLDrawable paramURLDrawable, Throwable paramThrowable)
  {
    if (paramURLDrawable == this.mDecoding)
    {
      setImageDrawable(this.mDecoding);
      return;
    }
    super.onLoadFialed(paramURLDrawable, paramThrowable);
  }
  
  @TargetApi(11)
  public void onLoadSuccessed(URLDrawable paramURLDrawable)
  {
    if (paramURLDrawable == this.mDecoding)
    {
      Drawable localDrawable = getDrawable();
      if ((localDrawable != null) && (localDrawable.getIntrinsicWidth() == paramURLDrawable.getIntrinsicWidth()) && (localDrawable.getIntrinsicHeight() == paramURLDrawable.getIntrinsicHeight()))
      {
        this.ignoreLayout = true;
        setImageDrawable(this.mDecoding);
        this.ignoreLayout = false;
        return;
      }
      setImageDrawable(this.mDecoding);
      return;
    }
    super.onLoadSuccessed(paramURLDrawable);
  }
  
  public void requestLayout()
  {
    if (!this.ignoreLayout) {
      super.requestLayout();
    }
  }
  
  public void setDecodingDrawble(URLDrawable paramURLDrawable)
  {
    if (this.mDecoding != null) {
      this.mDecoding.setURLDrawableListener(null);
    }
    paramURLDrawable.setURLDrawableListener(this);
    this.mDecoding = paramURLDrawable;
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    super.setImageDrawable(paramDrawable);
    if (this.mDecoding != null)
    {
      this.mDecoding.setURLDrawableListener(null);
      this.mDecoding = null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.richmediabrowser.view.BrowserURLImageView
 * JD-Core Version:    0.7.0.1
 */