package dov.com.qq.im.aeeditor.module.filter;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import mqq.os.MqqHandler;

class AEEditorFilterControlPanel$5
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEEditorFilterControlPanel$5(AEEditorFilterControlPanel paramAEEditorFilterControlPanel, AEEditorFilterBean paramAEEditorFilterBean, int paramInt) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.setProgress(paramInt);
    ThreadManager.getUIHandler().post(new AEEditorFilterControlPanel.5.2(this));
  }
  
  public void a(boolean paramBoolean)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel.post(new AEEditorFilterControlPanel.5.1(this, paramBoolean));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.5
 * JD-Core Version:    0.7.0.1
 */