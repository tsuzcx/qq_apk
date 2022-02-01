package dov.com.qq.im.aeeditor.module.autotemplate;

import android.os.Handler;
import android.os.Looper;
import dov.com.qq.im.aeeditor.manage.AEEditorResourceDownloader.ResDownLoadListener;
import dov.com.qq.im.aeeditor.module.filter.AEEditorResourceManager;

class AEAutoTemplateAdapter$2$1
  implements AEEditorResourceDownloader.ResDownLoadListener
{
  AEAutoTemplateAdapter$2$1(AEAutoTemplateAdapter.2 param2) {}
  
  public void a(int paramInt)
  {
    if (AEAutoTemplateAdapter.a(this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter) != null) {
      AEAutoTemplateAdapter.a(this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter).a(paramInt, this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean);
    }
  }
  
  public void a(boolean paramBoolean)
  {
    if (paramBoolean) {
      this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean.packagePath = AEEditorResourceManager.a().a(AEEditorAutoTemplateBean.convert2DownloadBean(this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean));
    }
    for (;;)
    {
      if (AEAutoTemplateAdapter.a(this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter) != null) {
        AEAutoTemplateAdapter.a(this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter).a(paramBoolean, this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateBean);
      }
      return;
      AEAutoTemplateAdapter.a(this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEAutoTemplateAdapter, -1);
      new Handler(Looper.getMainLooper()).post(new AEAutoTemplateAdapter.2.1.1(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */