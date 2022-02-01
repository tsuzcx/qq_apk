package dov.com.qq.im.aeeditor.module.clip.video;

import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import dov.com.qq.im.ae.util.AEQLog;

class AEEditorVideoClipFragment$1
  implements IPlayer.PlayerListener
{
  AEEditorVideoClipFragment$1(AEEditorVideoClipFragment paramAEEditorVideoClipFragment) {}
  
  public void onPositionChanged(CMTime paramCMTime) {}
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    AEQLog.b(AEEditorVideoClipFragment.b(), "play status changed, current status = " + paramPlayerStatus);
    if (AEEditorVideoClipFragment.a(this.a) != null) {
      AEEditorVideoClipFragment.a(this.a).setPlayStatus(paramPlayerStatus);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.clip.video.AEEditorVideoClipFragment.1
 * JD-Core Version:    0.7.0.1
 */