package dov.com.qq.im.aeeditor.module.filter;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.manage.AEEditorEffectGroupListBean.AEEditorEffectItem;
import dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import mqq.os.MqqHandler;

class AEEditorFilterControlPanel$2
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEEditorFilterControlPanel$2(AEEditorFilterControlPanel paramAEEditorFilterControlPanel, AEEditorFilterBean paramAEEditorFilterBean, int paramInt, String paramString) {}
  
  public void a(int paramInt)
  {
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.setProgress(paramInt);
    ThreadManager.getUIHandler().post(new AEEditorFilterControlPanel.2.1(this));
  }
  
  public void a(boolean paramBoolean)
  {
    if ((this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.getEditorEffectItem().getPreDownload() != 0) || (this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.type == AEEditorFilterBean.FilterID.NETWORK)) {
      AEEditorFilterControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel);
    }
    if (AEEditorFilterControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel) == this.jdField_a_of_type_Int)
    {
      if (paramBoolean) {
        AEEditorFilterControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterControlPanel, this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Int, this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean);
      }
    }
    else {
      return;
    }
    this.jdField_a_of_type_DovComQqImAeeditorModuleFilterAEEditorFilterBean.setProgress(-1);
    AEQLog.d(AEEditorFilterControlPanel.a(), "download res failed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.filter.AEEditorFilterControlPanel.2
 * JD-Core Version:    0.7.0.1
 */