package com.tencent.mobileqq.guild.main;

import com.tencent.mobileqq.guild.main.data.QQGuildChannelApp;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelGuide;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelLive;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelText;
import com.tencent.mobileqq.guild.main.data.QQGuildChannelVoice;
import com.tencent.mobileqq.guild.main.item.QQGuildAddChannelBuilder;
import com.tencent.mobileqq.guild.main.item.QQGuildAppChannelBuilder;
import com.tencent.mobileqq.guild.main.item.QQGuildChannelGuideBuilder;
import com.tencent.mobileqq.guild.main.item.QQGuildChannelItemBuilder;
import com.tencent.mobileqq.guild.main.item.QQGuildChannelTextBuilder;
import com.tencent.mobileqq.guild.main.item.QQGuildEmptyPlaceHolderBuilder;
import com.tencent.mobileqq.guild.main.item.QQGuildLiveChannelBuilder;
import com.tencent.mobileqq.guild.main.item.QQGuildVoiceChannelBuilder;

public class QQGuildChannelItemBuilderFactory
{
  private IChannelListControl a;
  
  public QQGuildChannelItemBuilderFactory(IChannelListControl paramIChannelListControl)
  {
    this.a = paramIChannelListControl;
  }
  
  public int a()
  {
    return 7;
  }
  
  public QQGuildChannelItemBuilder a(Object paramObject)
  {
    switch (b(paramObject))
    {
    default: 
      paramObject = new QQGuildChannelGuideBuilder();
      break;
    case 6: 
      paramObject = new QQGuildEmptyPlaceHolderBuilder();
      break;
    case 5: 
      paramObject = new QQGuildAppChannelBuilder();
      break;
    case 4: 
      paramObject = new QQGuildLiveChannelBuilder();
      break;
    case 3: 
      paramObject = new QQGuildVoiceChannelBuilder();
      break;
    case 2: 
      paramObject = new QQGuildAddChannelBuilder();
      break;
    case 1: 
      paramObject = new QQGuildChannelTextBuilder();
    }
    paramObject.a(this.a);
    return paramObject;
  }
  
  public int b(Object paramObject)
  {
    if ((paramObject instanceof QQGuildChannelText)) {
      return 1;
    }
    if ((paramObject instanceof QQGuildChannelVoice)) {
      return 3;
    }
    if ((paramObject instanceof QQGuildChannelLive)) {
      return 4;
    }
    if (((paramObject instanceof QQGuildChannelGuide)) && (((QQGuildChannelGuide)paramObject).d() == -1)) {
      return 2;
    }
    if ((paramObject instanceof QQGuildChannelApp)) {
      return 5;
    }
    if ((paramObject instanceof QQGuildEmptyPlaceHolderBuilder)) {
      return 6;
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.main.QQGuildChannelItemBuilderFactory
 * JD-Core Version:    0.7.0.1
 */