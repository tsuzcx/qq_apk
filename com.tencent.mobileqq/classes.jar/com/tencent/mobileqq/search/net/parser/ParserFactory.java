package com.tencent.mobileqq.search.net.parser;

public class ParserFactory
{
  public static INetSearchResultParser a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return null;
    case 80000000: 
      return new ContactParser();
    case 80000001: 
      return new TroopParser();
    case 80000002: 
      return new PublicAcntParser();
    }
    return new ArticleParser();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.search.net.parser.ParserFactory
 * JD-Core Version:    0.7.0.1
 */