package com.tencent.mobileqq.guild.chatpie;

import android.view.LayoutInflater;
import com.tencent.mobileqq.activity.aio.core.AIOContext;

public class GuildLiveListUI
  extends GuildListUI
{
  public GuildLiveListUI(AIOContext paramAIOContext)
  {
    super(paramAIOContext);
  }
  
  public void a(boolean paramBoolean)
  {
    if ((paramBoolean) && (this.e == null)) {
      this.e = LayoutInflater.from(this.b.b()).inflate(2131625054, null);
    }
    super.a(paramBoolean);
  }
  
  public void b(boolean paramBoolean)
  {
    if (this.d == null) {
      this.d = LayoutInflater.from(this.b.b()).inflate(2131625054, null);
    }
    super.b(paramBoolean);
  }
  
  public GuildLiveChannelPieAdapter y()
  {
    return (GuildLiveChannelPieAdapter)this.f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.GuildLiveListUI
 * JD-Core Version:    0.7.0.1
 */