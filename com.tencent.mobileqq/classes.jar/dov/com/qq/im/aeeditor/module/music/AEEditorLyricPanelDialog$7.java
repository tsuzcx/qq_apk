package dov.com.qq.im.aeeditor.module.music;

import com.tencent.mobileqq.app.ThreadManager;
import dov.com.qq.im.ae.util.AECameraPrefsUtil;
import dov.com.qq.im.aeeditor.view.AEEditorQcircleBubbleView;
import mqq.os.MqqHandler;

class AEEditorLyricPanelDialog$7
  implements Runnable
{
  AEEditorLyricPanelDialog$7(AEEditorLyricPanelDialog paramAEEditorLyricPanelDialog) {}
  
  public void run()
  {
    AEEditorLyricPanelDialog.a(this.this$0, new AEEditorQcircleBubbleView(this.this$0.getContext()));
    AEEditorLyricPanelDialog.a(this.this$0).c(2131689749);
    AEEditorLyricPanelDialog.a(this.this$0).b(1);
    AEEditorLyricPanelDialog.a(this.this$0).a(AEEditorLyricPanelDialog.a(this.this$0), 1, 0);
    ThreadManager.getUIHandler().postDelayed(AEEditorLyricPanelDialog.a(this.this$0), 3000L);
    AEEditorLyricPanelDialog.a(this.this$0).setOnDismissListener(new AEEditorLyricPanelDialog.7.1(this));
    AECameraPrefsUtil.a().a("SP_KEY_FIRST_ENTER_MUSIC_TAB", false, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorLyricPanelDialog.7
 * JD-Core Version:    0.7.0.1
 */