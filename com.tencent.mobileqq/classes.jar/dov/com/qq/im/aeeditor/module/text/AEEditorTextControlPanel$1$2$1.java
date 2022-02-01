package dov.com.qq.im.aeeditor.module.text;

import bnzb;
import bohv;
import boik;

public class AEEditorTextControlPanel$1$2$1
  implements Runnable
{
  public AEEditorTextControlPanel$1$2$1(bohv parambohv) {}
  
  public void run()
  {
    synchronized (AEEditorTextControlPanel.a(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$1.this$0))
    {
      try
      {
        bnzb.d("AEEditorTextControlPanel", "[createImageAndUpdate]notifyAll");
        AEEditorTextControlPanel.a(this.a.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$1.this$0).notifyItemChanged(this.a.jdField_a_of_type_Int);
        return;
      }
      catch (IllegalMonitorStateException localIllegalMonitorStateException)
      {
        for (;;)
        {
          bnzb.d("AEEditorTextControlPanel", "[createImageAndUpdate]IllegalMonitorStateException");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.1.2.1
 * JD-Core Version:    0.7.0.1
 */