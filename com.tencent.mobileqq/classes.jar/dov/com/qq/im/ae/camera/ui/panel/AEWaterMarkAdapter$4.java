package dov.com.qq.im.ae.camera.ui.panel;

import android.text.TextUtils;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;

class AEWaterMarkAdapter$4
  implements Runnable
{
  AEWaterMarkAdapter$4(AEWaterMarkAdapter paramAEWaterMarkAdapter, int paramInt, AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean) {}
  
  public void run()
  {
    AEMaterialMetaData localAEMaterialMetaData = (AEMaterialMetaData)this.this$0.a.get(this.jdField_a_of_type_Int);
    String str = AEWaterMarkAdapter.a(this.this$0).a();
    if ((!TextUtils.isEmpty(AEWaterMarkAdapter.a(this.this$0))) && (AEWaterMarkAdapter.a(this.this$0).equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.a)) && (str.equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.a)) && (localAEMaterialMetaData != null) && (localAEMaterialMetaData.a.equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.a)) && (this.jdField_a_of_type_Boolean))
    {
      if (AEMaterialManager.jdField_a_of_type_Boolean)
      {
        AEQLog.b("AEWaterMarkAdapter", "onDownloadFinish but is capturing, just refresh UI");
        this.this$0.notifyDataSetChanged();
      }
      do
      {
        return;
        if (!AEMaterialManager.b)
        {
          AEQLog.b("AEWaterMarkAdapter", "onDownloadFinish but is not resume, just refresh UI");
          this.this$0.notifyDataSetChanged();
          return;
        }
        AEWaterMarkAdapter.a(this.this$0).b(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData, true);
      } while (AEWaterMarkAdapter.a(this.this$0) == null);
      AEQLog.a("AEWaterMarkAdapter", "### [material panel] download finish, select material " + this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.a);
      AEWaterMarkAdapter.a(this.this$0).a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData);
      this.this$0.a(this.jdField_a_of_type_Int);
      return;
    }
    this.this$0.notifyItemChanged(this.jdField_a_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEWaterMarkAdapter.4
 * JD-Core Version:    0.7.0.1
 */