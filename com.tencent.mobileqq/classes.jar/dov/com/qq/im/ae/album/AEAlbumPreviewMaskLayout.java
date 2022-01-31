package dov.com.qq.im.ae.album;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import bklv;
import blfg;

public class AEAlbumPreviewMaskLayout
  extends FrameLayout
{
  private bklv a;
  
  public AEAlbumPreviewMaskLayout(@NonNull Context paramContext)
  {
    this(paramContext, null);
  }
  
  public AEAlbumPreviewMaskLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    this(paramContext, paramAttributeSet, 0);
  }
  
  public AEAlbumPreviewMaskLayout(@NonNull Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0)
    {
      if (this.a != null) {
        this.a.a();
      }
      blfg.a("AEAlbumPreviewMaskLayout", "[onTouchEvent], action=ACTION_DOWN");
    }
    return true;
  }
  
  public void setOnTouchCallback(@Nullable bklv parambklv)
  {
    this.a = parambklv;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout
 * JD-Core Version:    0.7.0.1
 */