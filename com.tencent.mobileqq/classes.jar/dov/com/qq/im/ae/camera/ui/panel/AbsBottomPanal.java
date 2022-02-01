package dov.com.qq.im.ae.camera.ui.panel;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public abstract class AbsBottomPanal
  extends FrameLayout
{
  protected boolean a = false;
  
  public AbsBottomPanal(Context paramContext)
  {
    super(paramContext);
  }
  
  public AbsBottomPanal(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbsBottomPanal(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public abstract void a(boolean paramBoolean);
  
  public abstract boolean b();
  
  public void d()
  {
    a(true);
  }
  
  public void setClosedByTouch(boolean paramBoolean)
  {
    this.a = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AbsBottomPanal
 * JD-Core Version:    0.7.0.1
 */