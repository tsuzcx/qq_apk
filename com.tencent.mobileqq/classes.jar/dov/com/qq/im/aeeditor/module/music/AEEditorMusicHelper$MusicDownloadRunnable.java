package dov.com.qq.im.aeeditor.module.music;

import android.support.annotation.NonNull;
import com.tencent.common.app.AppInterface;
import mqq.util.WeakReference;

public class AEEditorMusicHelper$MusicDownloadRunnable
  implements Runnable
{
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private AEEditorMusicAdapter.AEEditorMusicInfo jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<AEEditorMusicHelper.MusicDownloadCallback> jdField_a_of_type_MqqUtilWeakReference;
  private String b;
  
  public AEEditorMusicHelper$MusicDownloadRunnable(@NonNull AppInterface paramAppInterface, @NonNull AEEditorMusicAdapter.AEEditorMusicInfo paramAEEditorMusicInfo, @NonNull String paramString1, @NonNull String paramString2, @NonNull AEEditorMusicHelper.MusicDownloadCallback paramMusicDownloadCallback)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo = paramAEEditorMusicInfo;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramMusicDownloadCallback);
  }
  
  public void run()
  {
    AEEditorMusicHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_DovComQqImAeeditorModuleMusicAEEditorMusicAdapter$AEEditorMusicInfo, this.jdField_a_of_type_JavaLangString, this.b, (AEEditorMusicHelper.MusicDownloadCallback)this.jdField_a_of_type_MqqUtilWeakReference.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.MusicDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */