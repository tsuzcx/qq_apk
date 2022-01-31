package dov.com.qq.im.ae.camera.ui.panel;

import biol;
import bios;
import birb;
import bire;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEMaterialAdapter$2
  implements Runnable
{
  public AEMaterialAdapter$2(biol parambiol, int paramInt, bire parambire, boolean paramBoolean) {}
  
  public void run()
  {
    birb localbirb;
    bire localbire;
    if ((((bire)this.this$0.a.get(this.jdField_a_of_type_Int)).a.equals(this.jdField_a_of_type_Bire.a)) && (this.jdField_a_of_type_Boolean) && (biol.a(this.this$0) != null))
    {
      localbirb = biol.a(this.this$0);
      localbire = this.jdField_a_of_type_Bire;
      if (biol.a(this.this$0)) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      localbirb.a(localbire, bool);
      QLog.d("AEMaterialAdapter", 4, "### [material panel] download finish, select material " + this.jdField_a_of_type_Bire.a);
      biol.a(this.this$0).a(this.jdField_a_of_type_Bire);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */