package dov.com.qq.im.aeeditor;

import com.tencent.tavcut.TAVCut.Callback;
import dov.com.qq.im.ae.util.AEQLog;
import java.util.List;

class AEEditorActivity$1
  implements TAVCut.Callback
{
  AEEditorActivity$1(AEEditorActivity paramAEEditorActivity) {}
  
  public void onDone(int paramInt)
  {
    AEQLog.b("AEEditorActivity", "TAVCut init ret code = " + paramInt);
    if (paramInt != 0) {
      AEEditorActivity.a(this.a).add(new AEEditorActivity.InitResult(-9));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.AEEditorActivity.1
 * JD-Core Version:    0.7.0.1
 */