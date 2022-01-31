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
    if (this.a) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void setScrollable(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageViewPager
 * JD-Core Version:    0.7.0.1
 */