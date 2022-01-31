package dov.com.qq.im.ae.camera.ui.panel;

import bktf;
import bkvu;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

class AEMaterialProviderView$3
  implements Runnable
{
  AEMaterialProviderView$3(AEMaterialProviderView paramAEMaterialProviderView, int paramInt, bkvu parambkvu) {}
  
  public void run()
  {
    AEGridView localAEGridView = (AEGridView)AEMaterialProviderView.a(this.this$0).a.get(Integer.valueOf(this.jdField_a_of_type_Int));
    if (localAEGridView != null)
    {
      localbktf = (bktf)localAEGridView.getAdapter();
      localAEGridView.a(this.jdField_a_of_type_Bkvu.b);
      localbktf.a(this.jdField_a_of_type_Bkvu);
    }
    while (!QLog.isColorLevel())
    {
      bktf localbktf;
      return;
    }
    QLog.d("AEMaterialProviderView", 2, "gridView is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialProviderView.3
 * JD-Core Version:    0.7.0.1
 */