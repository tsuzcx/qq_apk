package dov.com.qq.im.aeeditor.module.edit;

import com.tencent.tavcut.bean.TextEditorData;
import dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel;

class AEEditorCommonEditFragment$7$1
  implements Runnable
{
  AEEditorCommonEditFragment$7$1(AEEditorCommonEditFragment.7 param7) {}
  
  public void run()
  {
    try
    {
      this.a.a.i();
      this.a.a.a(2131377173);
      TextEditorData localTextEditorData = new TextEditorData();
      localTextEditorData.setItemID(this.a.a.c);
      if (this.a.a.a != null) {
        this.a.a.a.a(localTextEditorData);
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorCommonEditFragment.7.1
 * JD-Core Version:    0.7.0.1
 */