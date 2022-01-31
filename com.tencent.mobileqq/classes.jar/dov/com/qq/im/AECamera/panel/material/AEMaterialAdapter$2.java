package dov.com.qq.im.AECamera.panel.material;

import bgxx;
import bgya;
import bgzy;
import bhaf;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEMaterialAdapter$2
  implements Runnable
{
  public AEMaterialAdapter$2(bgzy parambgzy, int paramInt, bgya parambgya, boolean paramBoolean) {}
  
  public void run()
  {
    bgxx localbgxx;
    bgya localbgya;
    if ((((bgya)this.this$0.a.get(this.jdField_a_of_type_Int)).a.equals(this.jdField_a_of_type_Bgya.a)) && (this.jdField_a_of_type_Boolean) && (bgzy.a(this.this$0) != null))
    {
      localbgxx = bgzy.a(this.this$0);
      localbgya = this.jdField_a_of_type_Bgya;
      if (bgzy.a(this.this$0)) {
        break label129;
      }
    }
    label129:
    for (boolean bool = true;; bool = false)
    {
      localbgxx.a(localbgya, bool);
      QLog.d("AEMaterialAdapter", 4, "### [material panel] download finish, select material " + this.jdField_a_of_type_Bgya.a);
      bgzy.a(this.this$0).a(this.jdField_a_of_type_Bgya);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.AECamera.panel.material.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */