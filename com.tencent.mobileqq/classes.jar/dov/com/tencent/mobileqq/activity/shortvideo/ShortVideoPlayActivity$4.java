package dov.com.tencent.mobileqq.activity.shortvideo;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.qqlive.mediaplayer.api.TVK_IMediaPlayer;

class ShortVideoPlayActivity$4
  implements DialogInterface.OnClickListener
{
  ShortVideoPlayActivity$4(ShortVideoPlayActivity paramShortVideoPlayActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.a.a != null) {
      this.a.a.pauseDownload();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     dov.com.tencent.mobileqq.activity.shortvideo.ShortVideoPlayActivity.4
 * JD-Core Version:    0.7.0.1
 */