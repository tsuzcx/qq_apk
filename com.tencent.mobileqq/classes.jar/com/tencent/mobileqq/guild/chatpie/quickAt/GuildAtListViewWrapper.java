package com.tencent.mobileqq.guild.chatpie.quickAt;

import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.guild.chatpie.GuildChatContext;
import com.tencent.widget.XListView;

public class GuildAtListViewWrapper
{
  public XListView a;
  public QQAppInterface b;
  public Context c;
  public GuildAtListAdapter d;
  final GuildAtAllCountCache e;
  
  public GuildAtListViewWrapper(QQAppInterface paramQQAppInterface, Context paramContext, GuildChatContext paramGuildChatContext, XListView paramXListView, GuildAtAllCountCache paramGuildAtAllCountCache)
  {
    this.b = paramQQAppInterface;
    this.c = paramContext;
    this.a = paramXListView;
    this.e = paramGuildAtAllCountCache;
    this.d = new GuildAtListAdapter(this, paramGuildChatContext);
    this.a.setAdapter(this.d);
  }
  
  public void a()
  {
    this.a.post(new -..Lambda.GuildAtListViewWrapper.f3cwx117RKI7VHfe-9dcrmEhb9c(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.GuildAtListViewWrapper
 * JD-Core Version:    0.7.0.1
 */