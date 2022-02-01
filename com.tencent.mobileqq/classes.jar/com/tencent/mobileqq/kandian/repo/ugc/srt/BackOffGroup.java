package com.tencent.mobileqq.kandian.repo.ugc.srt;

import java.util.Deque;
import java.util.LinkedList;

public class BackOffGroup
{
  public int a;
  public String a;
  public Deque<FreshInfo> a = new LinkedList();
  public int b;
  public int c = 0;
  private final int d = 50;
  
  public boolean a(FreshInfo paramFreshInfo)
  {
    if (this.a.size() >= 50) {
      this.a.poll();
    }
    return this.a.offer(paramFreshInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.srt.BackOffGroup
 * JD-Core Version:    0.7.0.1
 */