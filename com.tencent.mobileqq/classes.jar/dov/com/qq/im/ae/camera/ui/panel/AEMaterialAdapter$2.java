package dov.com.qq.im.ae.camera.ui.panel;

import android.text.TextUtils;
import bnfq;
import bnfv;
import bnkb;
import bnke;
import bnrh;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEMaterialAdapter$2
  implements Runnable
{
  public AEMaterialAdapter$2(bnfq parambnfq, int paramInt, bnke parambnke, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = (bnke)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    Object localObject2 = bnfq.a(this.this$0).a();
    if ((!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)) && (this.this$0.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString)) && (((String)localObject2).equals(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString)) && (localObject1 != null) && (((bnke)localObject1).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean))
    {
      if (!bnkb.jdField_a_of_type_Boolean) {
        break label125;
      }
      bnrh.b("AEMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
      this.this$0.notifyDataSetChanged();
    }
    label125:
    do
    {
      return;
      if (!bnkb.b)
      {
        bnrh.b("AEMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
    } while (bnfq.a(this.this$0) == null);
    localObject1 = bnfq.a(this.this$0);
    localObject2 = this.jdField_a_of_type_Bnke;
    if (!bnfq.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((bnkb)localObject1).a((bnke)localObject2, bool);
      QLog.d("AEMaterialAdapter", 4, "### [material panel] download finish, select material " + this.jdField_a_of_type_Bnke.jdField_a_of_type_JavaLangString);
      bnfq.a(this.this$0).a(this.jdField_a_of_type_Bnke);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */