package dov.com.qq.im.ae.camera.ui.panel;

import bnmn;
import bnmu;
import bnpc;
import bnpf;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEMaterialAdapter$2
  implements Runnable
{
  public AEMaterialAdapter$2(bnmn parambnmn, int paramInt, bnpf parambnpf, boolean paramBoolean) {}
  
  public void run()
  {
    bnpc localbnpc;
    bnpf localbnpf;
    if ((((bnpf)this.this$0.a.get(this.jdField_a_of_type_Int)).a.equals(this.jdField_a_of_type_Bnpf.a)) && (this.jdField_a_of_type_Boolean) && (bnmn.a(this.this$0) != null))
    {
      localbnpc = bnmn.a(this.this$0);
      localbnpf = this.jdField_a_of_type_Bnpf;
      if (bnmn.a(this.this$0)) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      localbnpc.a(localbnpf, bool);
      QLog.d("AEMaterialAdapter", 4, "### [material panel] download finish, select material " + this.jdField_a_of_type_Bnpf.a);
      bnmn.a(this.this$0).a(this.jdField_a_of_type_Bnpf);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */