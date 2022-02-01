package dov.com.qq.im.aeeditor.module.text;

import dov.com.qq.im.ae.util.AEQLog;

class AEEditorTextControlPanel$1$2$1
  implements Runnable
{
  AEEditorTextControlPanel$1$2$1(AEEditorTextControlPanel.1.2 param2) {}
  
  public void run()
  {
    synchronized (AEEditorTextControlPanel.a(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$1.this$0))
    {
      try
      {
        AEQLog.d("AEEditorTextControlPanel", "[createImageAndUpdate]notifyAll");
        AEEditorTextControlPanel.a(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$1.this$0).notifyItemChanged(this.a.jdField_a_of_type_Int);
        return;
      }
      catch (IllegalMonitorStateException localIllegalMonitorStateException)
      {
        for (;;)
        {
          AEQLog.d("AEEditorTextControlPanel", "[createImageAndUpdate]IllegalMonitorStateException");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.1.2.1
 * JD-Core Version:    0.7.0.1
 */