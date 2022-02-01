package dov.com.qq.im.aeeditor.module.edit;

import android.widget.ImageView;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.weseevideo.model.data.MusicData;
import dov.com.qq.im.ae.util.AEQLog;
import dov.com.qq.im.aeeditor.module.controlpanel.AEEditorMusicControlPanel;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicAdapter.AEEditorMusicInfo;
import dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper;

class AEEditorVideoEditFragment$23
  implements Runnable
{
  AEEditorVideoEditFragment$23(AEEditorVideoEditFragment paramAEEditorVideoEditFragment, AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    boolean bool = false;
    if ((this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo != null) && (!this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a()) && (!this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a()) && (this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a().equals(this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a()))) {}
    for (int i = 1; !this.jdField_a_of_type_Boolean; i = 0)
    {
      AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, this.jdField_a_of_type_Boolean);
      if (i != 0)
      {
        if (AEEditorVideoEditFragment.a(this.this$0) != null) {
          AEEditorVideoEditFragment.a(this.this$0).d();
        }
        QQToast.a(BaseApplicationImpl.getApplication(), 2131689733, 0).a();
      }
      AEQLog.d(AEEditorVideoEditFragment.g(), "[onDownloadFinished], download music failed, editorMusicInfo=" + this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
      return;
    }
    if (i != 0)
    {
      if (this.this$0.jdField_a_of_type_ComTencentTavcutSessionTAVCutVideoSession == null)
      {
        AEQLog.b(AEEditorVideoEditFragment.g(), "[onDownloadFinished], avCutVideoSession=null");
        return;
      }
      this.this$0.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData = AEEditorMusicHelper.a(this.jdField_a_of_type_JavaLangString, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.a(), this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo.b());
      AEEditorVideoEditFragment localAEEditorVideoEditFragment = this.this$0;
      MusicData localMusicData = this.this$0.jdField_a_of_type_ComTencentWeseevideoModelDataMusicData;
      float f1 = this.this$0.jdField_a_of_type_Float;
      float f2 = this.this$0.b;
      if (!this.this$0.jdField_a_of_type_Boolean) {
        bool = true;
      }
      localAEEditorVideoEditFragment.a(localMusicData, f1, f2, bool);
      if ((!this.this$0.jdField_a_of_type_Boolean) && (AEEditorVideoEditFragment.a(this.this$0) != null) && (AEEditorVideoEditFragment.a(this.this$0).getVisibility() == 0)) {
        AEEditorVideoEditFragment.a(this.this$0, true);
      }
      AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, this.jdField_a_of_type_Boolean);
      AEEditorVideoEditFragment.a(this.this$0).setBgmPlayed(true, this.this$0.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo);
      return;
    }
    AEEditorVideoEditFragment.a(this.this$0, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, this.jdField_a_of_type_Boolean);
    AEQLog.b(AEEditorVideoEditFragment.g(), "[onDownloadFinished], currentMusic invalid OR editorMusicInfo invalid OR mid not match");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.AEEditorVideoEditFragment.23
 * JD-Core Version:    0.7.0.1
 */