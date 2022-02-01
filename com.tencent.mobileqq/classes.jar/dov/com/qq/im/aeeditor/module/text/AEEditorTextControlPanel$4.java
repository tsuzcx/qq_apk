package dov.com.qq.im.aeeditor.module.text;

import android.support.v7.widget.RecyclerView;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.ViewUtils;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.view.AEEditorQcircleBubbleView;
import mqq.os.MqqHandler;

class AEEditorTextControlPanel$4
  implements Runnable
{
  public void run()
  {
    if ((AEEditorTextControlPanel.a(this.this$0) == null) || (AEEditorTextControlPanel.a(this.this$0) == null) || (this.this$0.getVisibility() == 8) || (this.this$0.getVisibility() == 4)) {
      AEQLog.d("AEEditorTextControlPanel", "showKuolieBubble mRecyclerView == null || mTextStickerAdapter == null");
    }
    while ((AEEditorTextControlPanel.a(this.this$0).a(0) == null) || (!AEEditorTextControlPanel.a(this.this$0).a(0).id.equals("qiukuolie"))) {
      return;
    }
    AEEditorTextControlPanel.a(this.this$0, new AEEditorQcircleBubbleView(this.this$0.getContext()));
    AEEditorTextControlPanel.a(this.this$0).b(1);
    AEEditorTextControlPanel.a(this.this$0).c(2131693606);
    AEEditorTextControlPanel.a(this.this$0).a(AEEditorTextControlPanel.a(this.this$0).getChildAt(0), 1, 3, ViewUtils.a(15.0F), 0);
    ThreadManager.getUIHandler().postDelayed(AEEditorTextControlPanel.a(this.this$0), 4000L);
    AEEditorTextControlPanel.a(this.this$0).setOnDismissListener(new AEEditorTextControlPanel.4.1(this));
    AECameraPrefsUtil.a().a("key_kuolie_sitck_bubble_panel", false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.text.AEEditorTextControlPanel.4
 * JD-Core Version:    0.7.0.1
 */