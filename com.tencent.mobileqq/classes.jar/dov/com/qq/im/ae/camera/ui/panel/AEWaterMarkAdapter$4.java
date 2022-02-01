package dov.com.qq.im.ae.camera.ui.panel;

import android.text.TextUtils;
import bnge;
import bngl;
import bnkb;
import bnke;
import bnrh;
import java.util.ArrayList;

public class AEWaterMarkAdapter$4
  implements Runnable
{
  public AEWaterMarkAdapter$4(bnge parambnge, int paramInt, bnke parambnke, boolean paramBoolean) {}
  
  public void run()
  {
    bnke localbnke = (bnke)this.this$0.a.get(this.jdField_a_of_type_Int);
    String str = bnge.a(this.this$0).a();
    if ((!TextUtils.isEmpty(bnge.a(this.this$0))) && (bnge.a(this.this$0).equals(this.jdField_a_of_type_Bnke.a)) && (str.equals(this.jdField_a_of_type_Bnke.a)) && (localbnke != null) && (localbnke.a.equals(this.jdField_a_of_type_Bnke.a)) && (this.jdField_a_of_type_Boolean))
    {
      if (bnkb.jdField_a_of_type_Boolean)
      {
        bnrh.b("AEWaterMarkAdapter", "onDownloadFinish but is capturing, just refresh UI");
        this.this$0.notifyDataSetChanged();
      }
      do
      {
        return;
        if (!bnkb.b)
        {
          bnrh.b("AEWaterMarkAdapter", "onDownloadFinish but is not resume, just refresh UI");
          this.this$0.notifyDataSetChanged();
          return;
        }
        bnge.a(this.this$0).b(this.jdField_a_of_type_Bnke, true);
      } while (bnge.a(this.this$0) == null);
      bnrh.a("AEWaterMarkAdapter", "### [material panel] download finish, select material " + this.jdField_a_of_type_Bnke.a);
      bnge.a(this.this$0).a(this.jdField_a_of_type_Bnke);
      this.this$0.a(this.jdField_a_of_type_Int);
      return;
    }
    this.this$0.notifyItemChanged(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.4
 * JD-Core Version:    0.7.0.1
 */