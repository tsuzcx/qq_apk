package dov.com.qq.im.aeeditor.module.edit;

import android.widget.ImageView;
import blfg;
import bljv;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.tavcut.session.TAVCutVideoSession;
import com.tencent.weseevideo.model.data.MusicData;
import dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;

class AEEditorVideoEditFragment$12
  implements Runnable
{
  AEEditorVideoEditFragment$12(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, bljv parambljv, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    boolean bool = false;
    if ((AEEditorVideoEditFragment.a(this.this$0) != null) && (!AEEditorVideoEditFragment.a(this.this$0).a()) && (!this.jdField_a_of_type_Bljv.a()) && (AEEditorVideoEditFragment.a(this.this$0).a().equals(this.jdField_a_of_type_Bljv.a()))) {}
    for (int i = 1; !this.jdField_a_of_type_Boolean; i = 0)
    {
      AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_Bljv, this.jdField_a_of_type_Boolean);
      if (i != 0)
      {
        if (AEEditorVideoEditFragment.a(this.this$0) != null) {
          AEEditorVideoEditFragment.a(this.this$0).setBackgroundMusicChecked(false);
        }
        QQToast.a(BaseApplicationImpl.getApplication(), 2131689797, 0).a();
      }
      blfg.d(AEEditorVideoEditFragment.e(), "[onDownloadFinished], download music failed, editorMusicInfo=" + this.jdField_a_of_type_Bljv);
      return;
    }
    if (i != 0)
    {
      if (AEEditorVideoEditFragment.a(this.this$0) == null)
      {
        blfg.b(AEEditorVideoEditFragment.e(), "[onDownloadFinished], avCutVideoSession=null");
        return;
      }
      AEEditorVideoEditFragment.a(this.this$0, AEEditorMusicHelper.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bljv.a()));
      TAVCutVideoSession localTAVCutVideoSession = AEEditorVideoEditFragment.a(this.this$0);
      MusicData localMusicData = AEEditorVideoEditFragment.a(this.this$0);
      if (AEEditorVideoEditFragment.a(this.this$0)) {}
      for (float f = 1.0F;; f = 0.0F)
      {
        if (!this.this$0.jdField_a_of_type_Boolean) {
          bool = true;
        }
        localTAVCutVideoSession.setBgmMusic(localMusicData, f, 1.0F, bool);
        if ((!this.this$0.jdField_a_of_type_Boolean) && (AEEditorVideoEditFragment.a(this.this$0) != null) && (AEEditorVideoEditFragment.a(this.this$0).getVisibility() == 0)) {
          AEEditorVideoEditFragment.a(this.this$0, true);
        }
        AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_Bljv, this.jdField_a_of_type_Boolean);
        return;
      }
    }
    AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_Bljv, this.jdField_a_of_type_Boolean);
    blfg.b(AEEditorVideoEditFragment.e(), "[onDownloadFinished], currentMusic invalid OR editorMusicInfo invalid OR mid not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.12
 * JD-Core Version:    0.7.0.1
 */