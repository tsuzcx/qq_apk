package dov.com.qq.im.aeeditor.module.autotemplate;

import android.arch.lifecycle.MutableLiveData;

class AEEditorAutoTemplatePanel$3
  implements AEAutoTemplateAdapter.DownLoadPackageListener
{
  AEEditorAutoTemplatePanel$3(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  public void a(int paramInt, AEEditorAutoTemplateBean paramAEEditorAutoTemplateBean) {}
  
  public void a(AEEditorAutoTemplateBean paramAEEditorAutoTemplateBean)
  {
    AEEditorAutoTemplatePanel.a(this.a).postValue(new AEAutoTemplateRet(0L, paramAEEditorAutoTemplateBean));
  }
  
  public void a(boolean paramBoolean, AEEditorAutoTemplateBean paramAEEditorAutoTemplateBean)
  {
    if (paramBoolean)
    {
      AEEditorAutoTemplatePanel.a(this.a).postValue(new AEAutoTemplateRet(2L, paramAEEditorAutoTemplateBean));
      return;
    }
    AEEditorAutoTemplatePanel.a(this.a).postValue(new AEAutoTemplateRet(3L, paramAEEditorAutoTemplateBean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.3
 * JD-Core Version:    0.7.0.1
 */