package dov.com.qq.im.capture;

import android.annotation.TargetApi;
import android.view.View;
import dov.com.qq.im.capture.view.ProviderView.ProviderViewListener;
import dov.com.tencent.biz.qqstory.takevideo.doodle.ui.doodle.DoodleLayout.DoodleEventListener;

public abstract class AbsQIMCaptureController
  implements ProviderView.ProviderViewListener, DoodleLayout.DoodleEventListener
{
  public int a;
  public View a;
  
  public abstract void a();
  
  @TargetApi(11)
  public abstract void a(int paramInt, boolean paramBoolean);
  
  public abstract void a(boolean paramBoolean, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.AbsQIMCaptureController
 * JD-Core Version:    0.7.0.1
 */