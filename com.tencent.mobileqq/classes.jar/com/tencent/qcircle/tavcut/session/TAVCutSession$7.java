package com.tencent.qcircle.tavcut.session;

import android.util.SparseArray;
import com.tencent.qcircle.tavcut.bean.TextEditorData;

class TAVCutSession$7
  implements Runnable
{
  TAVCutSession$7(TAVCutSession paramTAVCutSession, TextEditorData paramTextEditorData) {}
  
  public void run()
  {
    int i = 0;
    while (i < this.this$0.stickerControllers.size())
    {
      int j = this.this$0.stickerControllers.keyAt(i);
      this.this$0.runOnMainThread(new TAVCutSession.7.1(this, j), true);
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.qcircle.tavcut.session.TAVCutSession.7
 * JD-Core Version:    0.7.0.1
 */