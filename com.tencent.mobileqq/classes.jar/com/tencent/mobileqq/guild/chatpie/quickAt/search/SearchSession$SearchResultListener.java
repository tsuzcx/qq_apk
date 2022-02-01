package com.tencent.mobileqq.guild.chatpie.quickAt.search;

import com.tencent.mobileqq.qqguildsdk.data.IGProUserInfo;
import java.util.List;

public abstract interface SearchSession$SearchResultListener
{
  public abstract void a(String paramString1, String paramString2);
  
  public abstract void a(String paramString, List<IGProUserInfo> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.search.SearchSession.SearchResultListener
 * JD-Core Version:    0.7.0.1
 */