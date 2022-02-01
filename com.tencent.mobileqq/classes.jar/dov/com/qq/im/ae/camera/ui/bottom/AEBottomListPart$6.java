package dov.com.qq.im.ae.camera.ui.bottom;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.view.AECameraCancelableProgressDialog;
import java.util.concurrent.CountDownLatch;

class AEBottomListPart$6
  implements View.OnClickListener
{
  AEBottomListPart$6(AEBottomListPart paramAEBottomListPart) {}
  
  public void onClick(View paramView)
  {
    AEBottomListPart.a(this.a, true);
    AEBottomListPart.a(this.a).countDown();
    this.a.a.c();
    AEBottomListPart.a(this.a).cancel();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.bottom.AEBottomListPart.6
 * JD-Core Version:    0.7.0.1
 */