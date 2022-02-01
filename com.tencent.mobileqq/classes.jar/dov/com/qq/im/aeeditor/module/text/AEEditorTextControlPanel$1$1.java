package dov.com.qq.im.aeeditor.module.text;

import bpam;
import bpkf;

class AEEditorTextControlPanel$1$1
  implements Runnable
{
  AEEditorTextControlPanel$1$1(AEEditorTextControlPanel.1 param1, int paramInt) {}
  
  public void run()
  {
    synchronized (AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$1.this$0))
    {
      try
      {
        bpam.d("AEEditorTextControlPanel", "[createImageAndUpdate] notifyAll File exist");
        AEEditorTextControlPanel.a(this.jdField_a_of_type_DovComQqImAeeditorModuleTextAEEditorTextControlPanel$1.this$0).notifyItemChanged(this.jdField_a_of_type_Int);
        return;
      }
      catch (IllegalMonitorStateException localIllegalMonitorStateException)
      {
        for (;;)
        {
          bpam.d("AEEditorTextControlPanel", "[createImageAndUpdate]IllegalMonitorStateException File exist");
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.1.1
 * JD-Core Version:    0.7.0.1
 */