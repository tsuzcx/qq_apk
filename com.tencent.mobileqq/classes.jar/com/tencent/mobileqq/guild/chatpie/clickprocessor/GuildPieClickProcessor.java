package com.tencent.mobileqq.guild.chatpie.clickprocessor;

import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnLongClickListener;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class GuildPieClickProcessor
  implements View.OnClickListener, View.OnLongClickListener
{
  protected InputBarBtnClickCallback a;
  private GuildChatContext b;
  private List<GuildPieClickProcessor.IGuildPieOnClickCallBack> c = new ArrayList();
  private List<GuildPieClickProcessor.IGuildPieOnLongClickCallBack> d = new ArrayList();
  
  private void b()
  {
    c();
  }
  
  private void c()
  {
    a(a());
  }
  
  private void d() {}
  
  public InputBarBtnClickCallback a()
  {
    if (this.a == null) {
      this.a = new InputBarBtnClickCallback();
    }
    return this.a;
  }
  
  public void a(GuildChatContext paramGuildChatContext)
  {
    this.b = paramGuildChatContext;
    b();
    d();
  }
  
  public void a(GuildPieClickProcessor.IGuildPieOnClickCallBack paramIGuildPieOnClickCallBack)
  {
    this.c.add(paramIGuildPieOnClickCallBack);
  }
  
  public void onClick(View paramView)
  {
    Iterator localIterator = this.c.iterator();
    while (localIterator.hasNext()) {
      ((GuildPieClickProcessor.IGuildPieOnClickCallBack)localIterator.next()).a(paramView, this.b);
    }
  }
  
  public boolean onLongClick(View paramView)
  {
    Iterator localIterator = this.d.iterator();
    boolean bool1 = false;
    while (localIterator.hasNext())
    {
      boolean bool2 = ((GuildPieClickProcessor.IGuildPieOnLongClickCallBack)localIterator.next()).a(paramView, this.b);
      bool1 = bool2;
      if (bool2) {
        bool1 = bool2;
      }
    }
    return bool1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.clickprocessor.GuildPieClickProcessor
 * JD-Core Version:    0.7.0.1
 */