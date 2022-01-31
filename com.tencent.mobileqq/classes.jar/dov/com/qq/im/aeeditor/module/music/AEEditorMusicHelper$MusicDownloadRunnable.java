package dov.com.qq.im.aeeditor.module.music;

import android.support.annotation.NonNull;
import bloh;
import bloo;
import com.tencent.common.app.AppInterface;
import mqq.util.WeakReference;

public class AEEditorMusicHelper$MusicDownloadRunnable
  implements Runnable
{
  private bloh jdField_a_of_type_Bloh;
  private AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  private String jdField_a_of_type_JavaLangString;
  private WeakReference<bloo> jdField_a_of_type_MqqUtilWeakReference;
  private String b;
  
  public AEEditorMusicHelper$MusicDownloadRunnable(@NonNull AppInterface paramAppInterface, @NonNull bloh parambloh, @NonNull String paramString1, @NonNull String paramString2, @NonNull bloo parambloo)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_Bloh = parambloh;
    this.jdField_a_of_type_JavaLangString = paramString1;
    this.b = paramString2;
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(parambloo);
  }
  
  public void run()
  {
    AEEditorMusicHelper.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_Bloh, this.jdField_a_of_type_JavaLangString, this.b, (bloo)this.jdField_a_of_type_MqqUtilWeakReference.get());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.music.AEEditorMusicHelper.MusicDownloadRunnable
 * JD-Core Version:    0.7.0.1
 */