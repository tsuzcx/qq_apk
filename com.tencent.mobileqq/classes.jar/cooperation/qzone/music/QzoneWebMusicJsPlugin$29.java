package cooperation.qzone.music;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import cooperation.qzone.LocalMultiProcConfig;

class QzoneWebMusicJsPlugin$29
  implements DialogInterface.OnClickListener
{
  QzoneWebMusicJsPlugin$29(QzoneWebMusicJsPlugin paramQzoneWebMusicJsPlugin, QzoneWebMusicJsPlugin.onUserConfirmListener paramonUserConfirmListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    LocalMultiProcConfig.putBool("qzbg_music_mobinet_tips", true);
    QzoneWebMusicJsPlugin.onUserConfirmListener localonUserConfirmListener = this.val$listener;
    if (localonUserConfirmListener != null) {
      localonUserConfirmListener.onConfirm();
    }
    paramDialogInterface.dismiss();
    this.this$0.isFlowWarningVisible = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes20.jar
 * Qualified Name:     cooperation.qzone.music.QzoneWebMusicJsPlugin.29
 * JD-Core Version:    0.7.0.1
 */