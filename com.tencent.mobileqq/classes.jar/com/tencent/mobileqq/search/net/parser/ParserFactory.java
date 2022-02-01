package com.tencent.mobileqq.search.net.parser;

public class ParserFactory
{
  public static INetSearchResultParser a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 80000003: 
      return new ArticleParser();
    case 80000002: 
      return new PublicAcntParser();
    case 80000001: 
      return new TroopParser();
    }
    return new ContactParser();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.ParserFactory
 * JD-Core Version:    0.7.0.1
 */