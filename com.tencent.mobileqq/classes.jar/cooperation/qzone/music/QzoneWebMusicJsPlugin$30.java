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
    paramDialogInterface = this.this$0;
    paramDialogInterface.isFlowWarningVisible = false;
    QzoneWebMusicJsPlugin.access$300(paramDialogInterface, "cancel");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.30
 * JD-Core Version:    0.7.0.1
 */