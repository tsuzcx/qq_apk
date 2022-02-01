package dov.com.qq.im.aeeditor.module.edit.multi;

import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.player.IPlayer.PlayerListener;
import com.tencent.tav.player.IPlayer.PlayerStatus;
import com.tencent.tavcut.player.MoviePlayer;
import dov.com.qq.im.aeeditor.util.TimeUtils;

class AEEditorMultiCutEditFragment$7
  implements IPlayer.PlayerListener
{
  AEEditorMultiCutEditFragment$7(AEEditorMultiCutEditFragment paramAEEditorMultiCutEditFragment) {}
  
  public void onPositionChanged(CMTime paramCMTime)
  {
    Object localObject = AEEditorMultiCutEditFragment.a(this.a).getDuration();
    localObject = TimeUtils.a(paramCMTime.getTimeUs() / 1000L) + "/" + TimeUtils.a(((CMTime)localObject).getTimeUs() / 1000L);
    AEEditorMultiCutEditFragment.a(this.a).setText((CharSequence)localObject);
    AEEditorMultiCutEditFragment.b(this.a, paramCMTime.getTimeUs());
  }
  
  public void onStatusChanged(IPlayer.PlayerStatus paramPlayerStatus)
  {
    if ((paramPlayerStatus == IPlayer.PlayerStatus.PLAYING) || (paramPlayerStatus == IPlayer.PlayerStatus.REPLAY))
    {
      AEEditorMultiCutEditFragment.a(this.a).setSelected(true);
      return;
    }
    AEEditorMultiCutEditFragment.a(this.a).setSelected(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     dov.com.qq.im.aeeditor.module.edit.multi.AEEditorMultiCutEditFragment.7
 * JD-Core Version:    0.7.0.1
 */