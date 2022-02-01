package com.tencent.mobileqq.wink.editor.clipping;

import android.widget.ImageView;
import androidx.annotation.Nullable;
import androidx.lifecycle.MutableLiveData;
import com.tencent.tavcut.render.player.IPlayer;
import com.tencent.tavcut.render.player.IPlayer.PlayerListener;
import com.tencent.tavcut.render.player.IPlayer.PlayerStatus;
import org.jetbrains.annotations.NotNull;

class WinkEditorClippingFragment$1
  implements IPlayer.PlayerListener
{
  WinkEditorClippingFragment$1(WinkEditorClippingFragment paramWinkEditorClippingFragment) {}
  
  public void a(long paramLong1, long paramLong2)
  {
    WinkEditorClippingFragment.b(this.a).e().postValue(Long.valueOf(paramLong1));
  }
  
  public void a(@Nullable IPlayer.PlayerStatus paramPlayerStatus, @NotNull IPlayer paramIPlayer)
  {
    if (paramPlayerStatus == IPlayer.PlayerStatus.PLAYING) {
      WinkEditorClippingFragment.a(this.a).setImageResource(2130848874);
    } else if (paramPlayerStatus == IPlayer.PlayerStatus.PAUSED) {
      WinkEditorClippingFragment.a(this.a).setImageResource(2130848875);
    }
    WinkEditorClippingFragment.b(this.a).f().postValue(paramPlayerStatus);
  }
  
  public void a(@NotNull IPlayer paramIPlayer) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mobileqq.wink.editor.clipping.WinkEditorClippingFragment.1
 * JD-Core Version:    0.7.0.1
 */