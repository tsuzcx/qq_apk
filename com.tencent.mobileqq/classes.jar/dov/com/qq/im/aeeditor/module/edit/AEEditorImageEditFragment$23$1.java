package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

class AEEditorImageEditFragment$23$1
  implements Runnable
{
  AEEditorImageEditFragment$23$1(AEEditorImageEditFragment.23 param23, Collection paramCollection) {}
  
  public void run()
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment$23.a.b();
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilCollection);
    if (((List)localObject).size() > 0) {}
    for (localObject = (String)((List)localObject).get(0);; localObject = "unknown")
    {
      QQToast.a(this.jdField_a_of_type_DovComQqImAeeditorModuleEditAEEditorImageEditFragment$23.a.getActivity(), "导出失败: error code = " + (String)localObject, 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.23.1
 * JD-Core Version:    0.7.0.1
 */