package dov.com.qq.im.aeeditor.module.edit;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.Observer;
import android.support.annotation.Nullable;
import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel;

class AEEditorVideoEditFragment$3
  implements Observer<Boolean>
{
  AEEditorVideoEditFragment$3(AEEditorVideoEditFragment paramAEEditorVideoEditFragment) {}
  
  public void a(@Nullable Boolean paramBoolean)
  {
    if ((paramBoolean != null) && (paramBoolean.booleanValue()))
    {
      AEEditorVideoEditFragment.a(this.a).b().postValue(Boolean.valueOf(false));
      ThreadManager.excute(new AEEditorVideoEditFragment.3.1(this), 16, null, true);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.3
 * JD-Core Version:    0.7.0.1
 */