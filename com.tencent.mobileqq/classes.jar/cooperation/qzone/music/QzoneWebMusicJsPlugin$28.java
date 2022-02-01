package cooperation.qzone.music;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class QzoneWebMusicJsPlugin$28
  implements DialogInterface.OnClickListener
{
  QzoneWebMusicJsPlugin$28(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.stopPlay();
    QzoneWebMusicJsPlugin.access$300(this.this$0, "cancel");
    paramDialogInterface.dismiss();
    QzoneWebMusicJsPlugin.access$902(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.28
 * JD-Core Version:    0.7.0.1
 */