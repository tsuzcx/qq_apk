package dov.com.qq.im.aeeditor.module.edit;

import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import android.widget.FrameLayout;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import dov.com.qq.im.aeeditor.module.autotemplate.AEAutoTemplateRet;
import dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateBean;
import dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplateLoadingView;
import dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel;
import java.util.concurrent.CopyOnWriteArrayList;

class AEEditorVideoEditFragment$2
  implements Observer<AEAutoTemplateRet>
{
  AEEditorVideoEditFragment$2(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void a(@Nullable AEAutoTemplateRet paramAEAutoTemplateRet)
  {
    AEEditorAutoTemplateBean localAEEditorAutoTemplateBean = null;
    Object localObject = null;
    if (paramAEAutoTemplateRet == null) {}
    do
    {
      return;
      AEEditorVideoEditFragment localAEEditorVideoEditFragment;
      switch ((int)paramAEAutoTemplateRet.a())
      {
      case 1: 
      default: 
        return;
      case 0: 
        AEEditorVideoEditFragment.a(this.a).add(paramAEAutoTemplateRet.a().id);
        AEEditorVideoEditFragment.b(this.a).remove(paramAEAutoTemplateRet.a().id);
        this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView = new AEEditorAutoTemplateLoadingView(this.a.jdField_a_of_type_AndroidContentContext);
        this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView.setLoadingListener(new AEEditorVideoEditFragment.2.1(this, paramAEAutoTemplateRet));
        this.a.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView);
        return;
      case 2: 
        if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView != null) {
          AEEditorVideoEditFragment.a(this.a).postDelayed(new AEEditorVideoEditFragment.2.2(this, paramAEAutoTemplateRet), 1500L);
        }
        for (;;)
        {
          AEEditorVideoEditFragment.a(this.a).remove(paramAEAutoTemplateRet.a().id);
          return;
          if (!AEEditorVideoEditFragment.a(this.a).contains(paramAEAutoTemplateRet.a().id))
          {
            AEEditorVideoEditFragment.b(this.a).remove(paramAEAutoTemplateRet.a().id);
            localAEEditorAutoTemplateBean = paramAEAutoTemplateRet.a();
            localAEEditorVideoEditFragment = this.a;
            if (localAEEditorAutoTemplateBean != null) {
              localObject = localAEEditorAutoTemplateBean.packagePath;
            }
            localAEEditorVideoEditFragment.a(localAEEditorAutoTemplateBean, (String)localObject);
            this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView = new AEEditorAutoTemplateLoadingView(this.a.jdField_a_of_type_AndroidContentContext);
            this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView.b();
            this.a.jdField_a_of_type_AndroidWidgetFrameLayout.addView(this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView);
            this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView.postDelayed(new AEEditorVideoEditFragment.2.3(this), 500L);
          }
        }
      case 3: 
        QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(2131689773), 1).a();
        if (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView != null)
        {
          this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView.a();
          this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView = null;
        }
        AEEditorVideoEditFragment.a(this.a).remove(paramAEAutoTemplateRet.a().id);
        return;
      case 4: 
        if (AEEditorVideoEditFragment.b(this.a).contains(paramAEAutoTemplateRet.a().id)) {
          break label485;
        }
        localObject = paramAEAutoTemplateRet.a();
        localAEEditorVideoEditFragment = this.a;
        paramAEAutoTemplateRet = localAEEditorAutoTemplateBean;
        if (localObject != null) {
          paramAEAutoTemplateRet = ((AEEditorAutoTemplateBean)localObject).packagePath;
        }
        localAEEditorVideoEditFragment.a((AEEditorAutoTemplateBean)localObject, paramAEAutoTemplateRet);
      }
    } while (this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView == null);
    this.a.jdField_a_of_type_DovComQqImAeeditorModuleAutotemplateAEEditorAutoTemplateLoadingView.postDelayed(new AEEditorVideoEditFragment.2.4(this), 500L);
    return;
    label485:
    AEEditorVideoEditFragment.b(this.a).remove(paramAEAutoTemplateRet.a().id);
    return;
    this.a.a(null, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.2
 * JD-Core Version:    0.7.0.1
 */