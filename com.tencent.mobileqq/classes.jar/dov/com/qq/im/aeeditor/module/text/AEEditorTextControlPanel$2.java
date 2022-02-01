package dov.com.qq.im.aeeditor.module.text;

import bmbx;
import bmnb;

class AEEditorTextControlPanel$2
  implements Runnable
{
  AEEditorTextControlPanel$2(AEEditorTextControlPanel paramAEEditorTextControlPanel) {}
  
  public void run()
  {
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
          bmbx.d("AEEditorTextControlPanel", "[updateItem] IllegalMonitorStateException");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.2
 * JD-Core Version:    0.7.0.1
 */