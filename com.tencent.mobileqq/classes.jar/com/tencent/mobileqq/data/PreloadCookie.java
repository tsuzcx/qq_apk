package com.tencent.mobileqq.data;

import awge;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;

@uniqueConstraints(clause=ConflictClause.IGNORE, columnNames="host,cookieKey")
public class PreloadCookie
  extends awge
{
  public String cookieKey;
  public long hitCount;
  public String host;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.PreloadCookie
 * JD-Core Version:    0.7.0.1
 */