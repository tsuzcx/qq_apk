package dov.com.qq.im.aeeditor.module.autotemplate;

import android.widget.ImageView;

class AEEditorAutoTemplatePanel$5
  implements AEAutoTemplateAdapter.OnItemClickListener
{
  AEEditorAutoTemplatePanel$5(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  public void a(int paramInt, AEEditorAutoTemplateBean paramAEEditorAutoTemplateBean)
  {
    if ((AEEditorAutoTemplatePanel.a(this.a) != null) && (!paramAEEditorAutoTemplateBean.id.isEmpty())) {
      AEEditorAutoTemplatePanel.a(this.a).a(paramInt, paramAEEditorAutoTemplateBean);
    }
    if (AEEditorAutoTemplatePanel.a(this.a) != null) {
      AEEditorAutoTemplatePanel.a(this.a).setImageResource(2130837910);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.5
 * JD-Core Version:    0.7.0.1
 */