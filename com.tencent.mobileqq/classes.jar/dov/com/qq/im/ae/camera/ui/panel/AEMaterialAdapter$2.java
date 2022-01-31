package dov.com.qq.im.ae.camera.ui.panel;

import binu;
import biob;
import biqk;
import biqn;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEMaterialAdapter$2
  implements Runnable
{
  public AEMaterialAdapter$2(binu parambinu, int paramInt, biqn parambiqn, boolean paramBoolean) {}
  
  public void run()
  {
    biqk localbiqk;
    biqn localbiqn;
    if ((((biqn)this.this$0.a.get(this.jdField_a_of_type_Int)).a.equals(this.jdField_a_of_type_Biqn.a)) && (this.jdField_a_of_type_Boolean) && (binu.a(this.this$0) != null))
    {
      localbiqk = binu.a(this.this$0);
      localbiqn = this.jdField_a_of_type_Biqn;
      if (binu.a(this.this$0)) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      localbiqk.a(localbiqn, bool);
      QLog.d("AEMaterialAdapter", 4, "### [material panel] download finish, select material " + this.jdField_a_of_type_Biqn.a);
      binu.a(this.this$0).a(this.jdField_a_of_type_Biqn);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */