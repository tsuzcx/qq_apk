package com.tencent.mobileqq.guild.chatpie.helper;

import android.content.Context;
import android.content.res.Resources;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;

public class GuildLiveReplyHelper
  extends GuildReplyHelper
{
  public GuildLiveReplyHelper(GuildChatContext paramGuildChatContext)
  {
    super(paramGuildChatContext);
  }
  
  private void e()
  {
    Resources localResources = this.b.getContext().getResources();
    this.c.setTextColor(localResources.getColor(2131166244));
    this.b.setTextColor(localResources.getColor(2131166245));
  }
  
  public void a(String paramString)
  {
    super.a(paramString);
    e();
  }
  
  protected void d()
  {
    super.d();
    ((View)this.b.getParent()).setBackgroundResource(2130840931);
    e();
    this.d.setImageDrawable(null);
    this.d.setBackgroundResource(2130840941);
  }
  
  @NonNull
  public String getTag()
  {
    return "GuildLiveReplyHelper";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.helper.GuildLiveReplyHelper
 * JD-Core Version:    0.7.0.1
 */