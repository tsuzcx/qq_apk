package cooperation.qzone.music;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class QzoneWebMusicJsPlugin$30
  implements DialogInterface.OnClickListener
{
  QzoneWebMusicJsPlugin$30(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    this.this$0.isFlowWarningVisible = false;
    QzoneWebMusicJsPlugin.access$300(this.this$0, "cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.30
 * JD-Core Version:    0.7.0.1
 */