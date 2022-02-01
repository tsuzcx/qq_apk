package dov.com.qq.im.ae.camera.ui.panel;

import bnrh;
import com.tencent.mobileqq.widget.QQViewPager;

class AEMaterialProviderView$2
  implements Runnable
{
  AEMaterialProviderView$2(AEMaterialProviderView paramAEMaterialProviderView, int paramInt) {}
  
  public void run()
  {
    bnrh.b("AEMaterialProviderView", "select category: " + this.a);
    AEMaterialProviderView.a(this.this$0).setCurrentItem(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView.2
 * JD-Core Version:    0.7.0.1
 */