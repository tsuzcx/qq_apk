package com.tencent.mobileqq.kandian.repo.ugc.srt;

import java.util.Deque;
import java.util.LinkedList;

public class BackOffGroup
{
  public String a;
  public int b;
  public int c;
  public int d = 0;
  public Deque<FreshInfo> e = new LinkedList();
  private final int f = 50;
  
  public boolean a(FreshInfo paramFreshInfo)
  {
    if (this.e.size() >= 50) {
      this.e.poll();
    }
    return this.e.offer(paramFreshInfo);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.ugc.srt.BackOffGroup
 * JD-Core Version:    0.7.0.1
 */