package dov.com.tencent.mobileqq.richmedia.capture.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.RelativeLayout;
import dov.com.qq.im.ae.view.AECircleCaptureStyle;

public abstract class AbsAECaptureButton
  extends RelativeLayout
  implements IAECaptureButton, ISimpleLifecycle
{
  public AbsAECaptureButton(Context paramContext)
  {
    super(paramContext);
  }
  
  public AbsAECaptureButton(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public AbsAECaptureButton(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, AECircleCaptureStyle paramAECircleCaptureStyle) {}
  
  public void b(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.richmedia.capture.view.AbsAECaptureButton
 * JD-Core Version:    0.7.0.1
 */