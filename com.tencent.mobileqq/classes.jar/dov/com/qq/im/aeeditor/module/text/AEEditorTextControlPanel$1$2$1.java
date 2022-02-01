package dov.com.qq.im.aeeditor.module.text;

import bmbx;
import bmmm;
import bmnb;

public class AEEditorTextControlPanel$1$2$1
  implements Runnable
{
  public AEEditorTextControlPanel$1$2$1(bmmm parambmmm) {}
  
  public void run()
  {
    synchronized (AEEditorTextControlPanel.a(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$1.this$0))
    {
      try
      {
        bmbx.d("AEEditorTextControlPanel", "[createImageAndUpdate]notifyAll");
        AEEditorTextControlPanel.a(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$1.this$0).notifyItemChanged(this.a.jdField_a_of_type_Int);
        return;
      }
      catch (IllegalMonitorStateException localIllegalMonitorStateException)
      {
        for (;;)
        {
          bmbx.d("AEEditorTextControlPanel", "[createImageAndUpdate]IllegalMonitorStateException");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.1.2.1
 * JD-Core Version:    0.7.0.1
 */