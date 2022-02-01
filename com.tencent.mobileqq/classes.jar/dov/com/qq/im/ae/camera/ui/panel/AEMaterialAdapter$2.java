package dov.com.qq.im.ae.camera.ui.panel;

import android.text.TextUtils;
import blsh;
import blsm;
import bluy;
import blvb;
import bmbx;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEMaterialAdapter$2
  implements Runnable
{
  public AEMaterialAdapter$2(blsh paramblsh, int paramInt, blvb paramblvb, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = (blvb)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    Object localObject2 = blsh.a(this.this$0).a();
    if ((!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)) && (this.this$0.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString)) && (((String)localObject2).equals(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString)) && (localObject1 != null) && (((blvb)localObject1).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean))
    {
      if (!bluy.jdField_a_of_type_Boolean) {
        break label125;
      }
      bmbx.b("AEMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
      this.this$0.notifyDataSetChanged();
    }
    label125:
    do
    {
      return;
      if (!bluy.b)
      {
        bmbx.b("AEMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
    } while (blsh.a(this.this$0) == null);
    localObject1 = blsh.a(this.this$0);
    localObject2 = this.jdField_a_of_type_Blvb;
    if (!blsh.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((bluy)localObject1).a((blvb)localObject2, bool);
      QLog.d("AEMaterialAdapter", 4, "### [material panel] download finish, select material " + this.jdField_a_of_type_Blvb.jdField_a_of_type_JavaLangString);
      blsh.a(this.this$0).a(this.jdField_a_of_type_Blvb);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */