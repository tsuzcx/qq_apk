package cooperation.qzone.music;

import android.annotation.TargetApi;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.BaseApplication;

class QzoneWebMusicJsPlugin$22
  implements DialogInterface.OnClickListener
{
  QzoneWebMusicJsPlugin$22(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, int paramInt1, int paramInt2, int paramInt3) {}
  
  @TargetApi(9)
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = BaseApplication.getContext().getSharedPreferences("share", 0);
    if (Build.VERSION.SDK_INT >= 9) {
      paramDialogInterface.edit().putBoolean("qzone_bg_music_auto_play_warn_flag", false).apply();
    } else {
      paramDialogInterface.edit().putBoolean("qzone_bg_music_auto_play_warn_flag", false).commit();
    }
    QzoneWebMusicJsPlugin.access$400(this.this$0, this.val$_randomType, this.val$_autoType, this.val$_loopPlay);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.22
 * JD-Core Version:    0.7.0.1
 */