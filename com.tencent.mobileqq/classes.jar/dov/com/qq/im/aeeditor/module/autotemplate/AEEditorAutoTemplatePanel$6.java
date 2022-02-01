package dov.com.qq.im.aeeditor.module.autotemplate;

import android.app.Activity;
import androidx.annotation.RequiresApi;

class AEEditorAutoTemplatePanel$6
  implements Runnable
{
  AEEditorAutoTemplatePanel$6(AEEditorAutoTemplatePanel paramAEEditorAutoTemplatePanel) {}
  
  @RequiresApi(api=17)
  public void run()
  {
    Activity localActivity = (Activity)this.this$0.getContext();
    if ((!localActivity.isDestroyed()) && (!localActivity.isFinishing())) {
      AEEditorAutoTemplatePanel.a(this.this$0);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.autotemplate.AEEditorAutoTemplatePanel.6
 * JD-Core Version:    0.7.0.1
 */