package dov.com.qq.im.aeeditor.module.edit;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterBean;
import dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

class AEEditorCommonEditFragment$4
  implements Observer<List<AEEditorFilterBean>>
{
  AEEditorCommonEditFragment$4(AEEditorCommonEditFragment paramAEEditorCommonEditFragment) {}
  
  public void a(@Nullable List<AEEditorFilterBean> paramList)
  {
    AEQLog.b(AEEditorCommonEditFragment.c(), "mFiltersObserver-onChanged");
    paramList = new LinkedList(paramList);
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      AEEditorFilterBean localAEEditorFilterBean = (AEEditorFilterBean)localIterator.next();
      if (this.a.b())
      {
        if ((localAEEditorFilterBean.getEditorEffectItem().getDisableForImage() == 1) || (AEEditorCommonEditFragment.jdField_a_of_type_Int < localAEEditorFilterBean.getEditorEffectItem().getImageShowLevel())) {
          localIterator.remove();
        }
      }
      else if ((localAEEditorFilterBean.getEditorEffectItem().getDisableForVideo() == 1) || (AEEditorCommonEditFragment.jdField_a_of_type_Int < localAEEditorFilterBean.getEditorEffectItem().getVideoShowLevel())) {
        localIterator.remove();
      }
    }
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.setFiltersData(paramList);
    AEEditorResourceManager.a().d();
    AEEditorResourceManager.a(this.a.getActivity().getApplicationContext());
    this.a.n();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.4
 * JD-Core Version:    0.7.0.1
 */