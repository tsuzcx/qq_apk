package dov.com.qq.im.aeeditor.module.autotemplate;

import android.app.Activity;
import androidx.annotation.RequiresApi;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;

class AEEditorAutoTemplatePanel$7
  implements Runnable
{
  AEEditorAutoTemplatePanel$7(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  @RequiresApi(api=17)
  public void run()
  {
    Activity localActivity = (Activity)this.this$0.getContext();
    if ((!localActivity.isDestroyed()) && (!localActivity.isFinishing()) && (AEEditorAutoTemplatePanel.a(this.this$0) != null))
    {
      AEEditorAutoTemplatePanel.a(this.this$0).a(true);
      QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(2131689773), 1).a();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.7
 * JD-Core Version:    0.7.0.1
 */