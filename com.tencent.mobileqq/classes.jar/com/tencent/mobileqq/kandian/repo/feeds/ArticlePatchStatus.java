package com.tencent.mobileqq.kandian.repo.feeds;

import com.tencent.mobileqq.persistence.notColumn;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

public class ArticlePatchStatus
{
  @notColumn
  public AtomicInteger a = new AtomicInteger(0);
  @notColumn
  public AtomicBoolean b = new AtomicBoolean(false);
  @notColumn
  public AtomicInteger c = new AtomicInteger(0);
  @notColumn
  public AtomicBoolean d = new AtomicBoolean(false);
  @notColumn
  public AtomicBoolean e = new AtomicBoolean(false);
  @notColumn
  public AtomicBoolean f = new AtomicBoolean(false);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.ArticlePatchStatus
 * JD-Core Version:    0.7.0.1
 */