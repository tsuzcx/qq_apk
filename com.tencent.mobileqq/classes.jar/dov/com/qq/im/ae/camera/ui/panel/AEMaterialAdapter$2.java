package dov.com.qq.im.ae.camera.ui.panel;

import android.app.Activity;
import android.content.Intent;
import bktf;
import bktm;
import bkvr;
import bkvu;
import blfg;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;

public class AEMaterialAdapter$2
  implements Runnable
{
  public AEMaterialAdapter$2(bktf parambktf, int paramInt, bkvu parambkvu, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1;
    Object localObject2;
    if ((((bkvu)this.this$0.a.get(this.jdField_a_of_type_Int)).a.equals(this.jdField_a_of_type_Bkvu.a)) && (this.jdField_a_of_type_Boolean))
    {
      localObject1 = ((Activity)bktf.a(this.this$0)).getIntent();
      ((Intent)localObject1).putExtra("widgetinfo", "camera^" + this.jdField_a_of_type_Bkvu.a);
      localObject2 = this.jdField_a_of_type_Bkvu.i;
      blfg.b("AEMaterialAdapter", "onDownloadFinish---塞拍同款名 takeSameName=" + (String)localObject2);
      ((Intent)localObject1).putExtra("key_camera_material_name", (String)localObject2);
      if (bktf.a(this.this$0) != null)
      {
        localObject1 = bktf.a(this.this$0);
        localObject2 = this.jdField_a_of_type_Bkvu;
        if (bktf.a(this.this$0)) {
          break label215;
        }
      }
    }
    label215:
    for (boolean bool = true;; bool = false)
    {
      ((bkvr)localObject1).a((bkvu)localObject2, bool);
      QLog.d("AEMaterialAdapter", 4, "### [material panel] download finish, select material " + this.jdField_a_of_type_Bkvu.a);
      bktf.a(this.this$0).a(this.jdField_a_of_type_Bkvu);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */