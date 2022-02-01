package dov.com.qq.im.aeeditor.module.edit;

import android.content.Context;
import android.os.Parcelable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.SavedState;
import android.util.AttributeSet;
import android.view.MotionEvent;

public class AEEditorImageViewPager
  extends ViewPager
{
  private boolean a = true;
  private boolean b = true;
  
  public AEEditorImageViewPager(Context paramContext)
  {
    super(paramContext);
  }
  
  public AEEditorImageViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.b = true;
    }
    if (this.a) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public Parcelable onSaveInstanceState()
  {
    return new ViewPager.SavedState(super.onSaveInstanceState());
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (paramMotionEvent.getAction() == 0) {
      this.b = true;
    }
    if ((this.a) && (this.b)) {
      if (paramMotionEvent.getAction() == 1) {
        this.b = false;
      }
    }
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Exception paramMotionEvent) {}
    this.b = false;
    return false;
    return false;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageViewPager
 * JD-Core Version:    0.7.0.1
 */