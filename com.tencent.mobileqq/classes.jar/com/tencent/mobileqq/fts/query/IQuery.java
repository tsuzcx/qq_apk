package com.tencent.mobileqq.fts.query;

import java.util.List;

public abstract interface IQuery
{
  public abstract <T> List<T> a(QueryArgs paramQueryArgs);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.fts.query.IQuery
 * JD-Core Version:    0.7.0.1
 */