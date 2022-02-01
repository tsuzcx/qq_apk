package com.tencent.mobileqq.wink.preview;

import android.widget.SeekBar;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.render.player.IPlayer.PlayerListener;
import com.tencent.tavcut.render.player.IPlayer.PlayerStatus;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

class WinkPreviewFragment$3
  implements IPlayer.PlayerListener
{
  WinkPreviewFragment$3(WinkPreviewFragment paramWinkPreviewFragment) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    SeekBar localSeekBar = WinkPreviewFragment.a(this.a);
    double d1 = paramLong1;
    double d2 = paramLong2;
    Double.isNaN(d1);
    Double.isNaN(d2);
    localSeekBar.setProgress((int)(d1 / d2 * 1000.0D));
  }
  
  public void a(@Nullable IPlayer.PlayerStatus paramPlayerStatus, @NotNull IPlayer paramIPlayer) {}
  
  public void a(@NotNull IPlayer paramIPlayer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.preview.WinkPreviewFragment.3
 * JD-Core Version:    0.7.0.1
 */