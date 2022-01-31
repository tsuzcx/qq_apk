package dov.com.qq.im.giftext;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.ImageView;

public class DrawableImageView
  extends ImageView
{
  public DrawableImageView(Context paramContext)
  {
    super(paramContext);
  }
  
  public DrawableImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public DrawableImageView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void invalidateDrawable(@NonNull Drawable paramDrawable)
  {
    if (Build.VERSION.SDK_INT < 23) {
      setSelected(true);
    }
    super.invalidateDrawable(paramDrawable);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.giftext.DrawableImageView
 * JD-Core Version:    0.7.0.1
 */