package com.tencent.mobileqq.guild.live.fragment.base.module.chatbar;

import android.content.Context;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.live.fragment.base.QQGuildLiveModuleBaseFragment;
import com.tencent.mobileqq.guild.live.fragment.base.control.IGuildLiveChatBarControl;
import com.tencent.mobileqq.guild.live.fragment.base.control.QQGuildLiveModuleControl;

public abstract class QQGuildLiveBaseChatBarFragment
  extends QQGuildLiveModuleBaseFragment
  implements IGuildLiveChatBarControl
{
  public void e() {}
  
  public void onAttach(@NonNull Context paramContext)
  {
    super.onAttach(paramContext);
    if (this.c != null) {
      this.c.a(this);
    }
  }
  
  public void onDetach()
  {
    super.onDetach();
    if (this.c != null) {
      this.c.a(null);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.fragment.base.module.chatbar.QQGuildLiveBaseChatBarFragment
 * JD-Core Version:    0.7.0.1
 */