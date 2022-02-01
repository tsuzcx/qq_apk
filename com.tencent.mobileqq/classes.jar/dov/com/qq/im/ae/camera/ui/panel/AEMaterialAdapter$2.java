package dov.com.qq.im.ae.camera.ui.panel;

import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import dov.com.qq.im.ae.data.AEMaterialManager;
import dov.com.qq.im.ae.data.AEMaterialMetaData;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.ArrayList;

class AEMaterialAdapter$2
  implements Runnable
{
  AEMaterialAdapter$2(AEMaterialAdapter paramAEMaterialAdapter, int paramInt, AEMaterialMetaData paramAEMaterialMetaData, boolean paramBoolean) {}
  
  public void run()
  {
    Object localObject1 = (AEMaterialMetaData)this.this$0.jdField_a_of_type_JavaUtilArrayList.get(this.jdField_a_of_type_Int);
    Object localObject2 = AEMaterialAdapter.a(this.this$0).a();
    if ((!TextUtils.isEmpty(this.this$0.jdField_a_of_type_JavaLangString)) && (this.this$0.jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString)) && (((String)localObject2).equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString)) && (localObject1 != null) && (((AEMaterialMetaData)localObject1).jdField_a_of_type_JavaLangString.equals(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString)) && (this.jdField_a_of_type_Boolean))
    {
      if (!AEMaterialManager.jdField_a_of_type_Boolean) {
        break label125;
      }
      AEQLog.b("AEMaterialAdapter", "onDownloadFinish but is capturing, just refresh UI");
      this.this$0.notifyDataSetChanged();
    }
    label125:
    do
    {
      return;
      if (!AEMaterialManager.b)
      {
        AEQLog.b("AEMaterialAdapter", "onDownloadFinish but is not resume, just refresh UI");
        this.this$0.notifyDataSetChanged();
        return;
      }
    } while (AEMaterialAdapter.a(this.this$0) == null);
    localObject1 = AEMaterialAdapter.a(this.this$0);
    localObject2 = this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData;
    if (!AEMaterialAdapter.a(this.this$0)) {}
    for (boolean bool = true;; bool = false)
    {
      ((AEMaterialManager)localObject1).a((AEMaterialMetaData)localObject2, bool);
      QLog.d("AEMaterialAdapter", 4, "### [material panel] download finish, select material " + this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData.jdField_a_of_type_JavaLangString);
      AEMaterialAdapter.a(this.this$0).a(this.jdField_a_of_type_DovComQqImAeDataAEMaterialMetaData);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.ae.camera.ui.panel.AEMaterialAdapter.2
 * JD-Core Version:    0.7.0.1
 */