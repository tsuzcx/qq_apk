package com.tencent.plato.sdk.utils.watcher;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.widget.ImageView.ScaleType;
import cn.gavinliu.android.lib.shapedimageview.ShapedImageView;

public class WatchImageView
  extends ShapedImageView
  implements WatchInterface
{
  private final WatchImpl mWatcher;
  
  public WatchImageView(Context paramContext)
  {
    super(paramContext);
    setScaleType(ImageView.ScaleType.CENTER_CROP);
    this.mWatcher = new WatchImpl(this);
  }
  
  public void initWatcher(String paramString, WatchListener paramWatchListener)
  {
    this.mWatcher.init(paramString, paramWatchListener);
    this.mWatcher.onStart();
  }
  
  protected void onDraw(Canvas paramCanvas)
  {
    super.onDraw(paramCanvas);
    this.mWatcher.onDraw(paramCanvas);
  }
  
  public void setImageDrawable(Drawable paramDrawable)
  {
    if (paramDrawable == Drawables.sErrorDrawable) {
      this.mWatcher.onFailure();
    }
    for (;;)
    {
      super.setImageDrawable(paramDrawable);
      return;
      this.mWatcher.onSuccess();
    }
  }
  
  public void setImageURI(Uri paramUri)
  {
    throw new UnsupportedOperationException();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.plato.sdk.utils.watcher.WatchImageView
 * JD-Core Version:    0.7.0.1
 */