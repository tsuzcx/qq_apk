package com.tencent.mobileqq.guild.chatpie.quickAt.search;

public class SearchException
  extends Exception
{
  public SearchContext context;
  public String errMsg;
  public int result;
  
  public SearchException(int paramInt, String paramString, SearchContext paramSearchContext)
  {
    super(localStringBuilder.toString());
    this.result = paramInt;
    this.errMsg = paramString;
    this.context = paramSearchContext;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.guild.chatpie.quickAt.search.SearchException
 * JD-Core Version:    0.7.0.1
 */