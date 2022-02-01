package dov.com.qq.im.aeeditor.module.edit;

import android.widget.ImageView;
import bmbx;
import bmlo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.weseevideo.model.data.MusicData;
import dov.com.qq.im.aeeditor.module.controlpanel.VideoControlPanel;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;

class AEEditorVideoEditFragment$15
  implements Runnable
{
  AEEditorVideoEditFragment$15(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, bmlo parambmlo, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    boolean bool2 = false;
    if ((AEEditorVideoEditFragment.a(this.this$0) != null) && (!AEEditorVideoEditFragment.a(this.this$0).a()) && (!this.jdField_a_of_type_Bmlo.a()) && (AEEditorVideoEditFragment.a(this.this$0).a().equals(this.jdField_a_of_type_Bmlo.a()))) {}
    for (int i = 1; !this.jdField_a_of_type_Boolean; i = 0)
    {
      AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_Bmlo, this.jdField_a_of_type_Boolean);
      if (i != 0)
      {
        if (AEEditorVideoEditFragment.a(this.this$0) != null) {
          AEEditorVideoEditFragment.a(this.this$0).f();
        }
        QQToast.a(BaseApplicationImpl.getApplication(), 2131689704, 0).a();
      }
      bmbx.d(AEEditorVideoEditFragment.f(), "[onDownloadFinished], download music failed, editorMusicInfo=" + this.jdField_a_of_type_Bmlo);
      return;
    }
    if (i != 0)
    {
      if (this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null)
      {
        bmbx.b(AEEditorVideoEditFragment.f(), "[onDownloadFinished], avCutVideoSession=null");
        return;
      }
      AEEditorVideoEditFragment.a(this.this$0, AEEditorMusicHelper.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_Bmlo.a(), this.jdField_a_of_type_Bmlo.b()));
      Object localObject = this.this$0;
      MusicData localMusicData = AEEditorVideoEditFragment.a(this.this$0);
      float f1 = AEEditorVideoEditFragment.a(this.this$0);
      float f2 = AEEditorVideoEditFragment.b(this.this$0);
      if (!this.this$0.jdField_a_of_type_Boolean) {}
      for (boolean bool1 = true;; bool1 = false)
      {
        ((AEEditorVideoEditFragment)localObject).a(localMusicData, f1, f2, bool1);
        if ((!this.this$0.jdField_a_of_type_Boolean) && (AEEditorVideoEditFragment.a(this.this$0) != null) && (AEEditorVideoEditFragment.a(this.this$0).getVisibility() == 0)) {
          AEEditorVideoEditFragment.a(this.this$0, true);
        }
        AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_Bmlo, this.jdField_a_of_type_Boolean);
        localObject = AEEditorVideoEditFragment.a(this.this$0);
        bool1 = bool2;
        if (AEEditorVideoEditFragment.a(this.this$0) != null) {
          bool1 = true;
        }
        ((VideoControlPanel)localObject).setBgmPlayed(true, bool1);
        return;
      }
    }
    AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_Bmlo, this.jdField_a_of_type_Boolean);
    bmbx.b(AEEditorVideoEditFragment.f(), "[onDownloadFinished], currentMusic invalid OR editorMusicInfo invalid OR mid not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.15
 * JD-Core Version:    0.7.0.1
 */