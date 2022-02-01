package com.tencent.mobileqq.fts.query;

public class QueryFactory
{
  public static IQuery a(int paramInt)
  {
    if (paramInt == 0) {
      return new MsgQuery();
    }
    if (paramInt == 1) {
      return new TroopQuery();
    }
    return new QueryFactory.1();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.fts.query.QueryFactory
 * JD-Core Version:    0.7.0.1
 */