package dov.com.qq.im.ae.camera.ui.panel;

import android.text.TextUtils;
import booa;
import boof;
import boqr;
import boqu;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEMaterialAdapter$2
  implements Runnable
{
  public AEMaterialAdapter$2(booa parambooa, int paramInt, boqu paramboqu, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = (boqu)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    Object localObject2 = booa.a(this.this$0).a();
    if ((!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)) && (this.this$0.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString)) && (((String)localObject2).equals(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString)) && (localObject1 != null) && (((boqu)localObject1).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean) && (booa.a(this.this$0) != null))
    {
      localObject1 = booa.a(this.this$0);
      localObject2 = this.jdField_a_of_type_Boqu;
      if (booa.a(this.this$0)) {
        break label193;
      }
    }
    label193:
    for (boolean bool = true;; bool = false)
    {
      ((boqr)localObject1).a((boqu)localObject2, bool);
      QLog.d("AEMaterialAdapter", 4, "### [material panel] download finish, select material " + this.jdField_a_of_type_Boqu.jdField_a_of_type_JavaLangString);
      booa.a(this.this$0).a(this.jdField_a_of_type_Boqu);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */