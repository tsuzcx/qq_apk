package dov.com.qq.im.aeeditor.module.edit;

import blin;
import com.tencent.mobileqq.widget.QQToast;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class AEEditorImageEditFragment$7$1
  implements Runnable
{
  public AEEditorImageEditFragment$7$1(blin paramblin, Collection paramCollection) {}
  
  public void run()
  {
    this.jdField_a_of_type_Blin.a.b();
    Object localObject = new ArrayList(this.jdField_a_of_type_JavaUtilCollection);
    if (((List)localObject).size() > 0) {}
    for (localObject = (String)((List)localObject).get(0);; localObject = "unknown")
    {
      QQToast.a(this.jdField_a_of_type_Blin.a.getActivity(), "导出失败: error code = " + (String)localObject, 0).a();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorImageEditFragment.7.1
 * JD-Core Version:    0.7.0.1
 */