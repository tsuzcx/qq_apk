package dov.com.qq.im.aeeditor.module.autotemplate;

import android.support.v7.widget.RecyclerView;
import camera.XEFFECT_MATERIALS_GENERAL_DATASTRUCT.MetaCategory;
import java.util.ArrayList;
import java.util.List;

class AEEditorAutoTemplatePanel$1
  implements AEAutoTemplateCategoryAdapter.OnItemClickListener
{
  AEEditorAutoTemplatePanel$1(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  public void a(int paramInt)
  {
    MetaCategory localMetaCategory = (MetaCategory)AEEditorAutoTemplatePanel.a(this.a).a().get(paramInt);
    if (paramInt == 0)
    {
      AEEditorAutoTemplatePanel.a(this.a, true);
      AEEditorAutoTemplatePanel.a(this.a, AEEditorAutoTemplatePanel.a(this.a), 0);
    }
    while (localMetaCategory.materials.size() == 0) {
      return;
    }
    AEEditorAutoTemplatePanel.a(this.a, true);
    AEEditorAutoTemplatePanel localAEEditorAutoTemplatePanel = this.a;
    RecyclerView localRecyclerView = AEEditorAutoTemplatePanel.a(this.a);
    if (paramInt == -1) {}
    for (paramInt = 0;; paramInt = this.a.a(localMetaCategory.id, AEEditorAutoTemplatePanel.a(this.a).a()))
    {
      AEEditorAutoTemplatePanel.a(localAEEditorAutoTemplatePanel, localRecyclerView, paramInt);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.1
 * JD-Core Version:    0.7.0.1
 */