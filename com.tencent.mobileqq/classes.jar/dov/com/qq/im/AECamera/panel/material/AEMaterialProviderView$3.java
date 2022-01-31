package dov.com.qq.im.AECamera.panel.material;

import bgya;
import bgzy;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AEMaterialProviderView$3
  implements Runnable
{
  AEMaterialProviderView$3(AEMaterialProviderView paramAEMaterialProviderView, int paramInt, bgya parambgya) {}
  
  public void run()
  {
    AEGridView localAEGridView = (AEGridView)AEMaterialProviderView.a(this.this$0).a.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localAEGridView != null) {
      ((bgzy)localAEGridView.getAdapter()).a(this.jdField_a_of_type_Bgya);
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("AEMaterialProviderView", 2, "gridView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.panel.material.AEMaterialProviderView.3
 * JD-Core Version:    0.7.0.1
 */