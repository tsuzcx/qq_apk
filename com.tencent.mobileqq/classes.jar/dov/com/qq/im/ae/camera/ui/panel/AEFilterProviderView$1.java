package dov.com.qq.im.ae.camera.ui.panel;

import android.support.v7.widget.RecyclerView;
import com.tencent.qphone.base.util.QLog;

class AEFilterProviderView$1
  implements Runnable
{
  AEFilterProviderView$1(AEFilterProviderView paramAEFilterProviderView, int paramInt) {}
  
  public void run()
  {
    if (AEFilterProviderView.a(this.this$0) != null) {
      AEFilterProviderView.a(this.this$0).smoothScrollToPosition(this.a);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("AEFilterProviderView", 2, "gridView is null ");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEFilterProviderView.1
 * JD-Core Version:    0.7.0.1
 */