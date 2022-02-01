package dov.com.qq.im.aeeditor.module.text;

import dov.com.qq.im.ae.util.AEQLog;

class AEEditorTextControlPanel$6
  implements Runnable
{
  AEEditorTextControlPanel$6(AEEditorTextControlPanel paramAEEditorTextControlPanel) {}
  
  public void run()
  {
    if (AEEditorTextControlPanel.a(this.this$0) != null) {
      synchronized (AEEditorTextControlPanel.a(this.this$0))
      {
        try
        {
          AEEditorTextControlPanel.a(this.this$0).notifyDataSetChanged();
          return;
        }
        catch (IllegalMonitorStateException localIllegalMonitorStateException)
        {
          for (;;)
          {
            AEQLog.d("AEEditorTextControlPanel", "[updateItem] IllegalMonitorStateException");
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.6
 * JD-Core Version:    0.7.0.1
 */