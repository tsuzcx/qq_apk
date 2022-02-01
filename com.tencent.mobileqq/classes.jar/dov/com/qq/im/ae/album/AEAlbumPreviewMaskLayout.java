package dov.com.qq.im.ae.album;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import boge;
import bpam;

public class AEAlbumPreviewMaskLayout
  extends FrameLayout
{
  private boge a;
  
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
      bpam.a("AEAlbumPreviewMaskLayout", "[onTouchEvent], action=ACTION_DOWN");
    }
    return true;
  }
  
  public void setOnTouchCallback(@Nullable boge paramboge)
  {
    this.a = paramboge;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.album.AEAlbumPreviewMaskLayout
 * JD-Core Version:    0.7.0.1
 */