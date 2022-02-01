package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.support.annotation.NonNull;
import java.util.HashSet;
import java.util.Set;

public class ReadUnRead
{
  public long a;
  public int b = -1;
  public Set<String> c = new HashSet();
  public Set<String> d = new HashSet();
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("time:");
    localStringBuilder.append(this.a);
    localStringBuilder.append("effectTime:");
    localStringBuilder.append(this.b);
    localStringBuilder.append("  ");
    localStringBuilder.append(this.c);
    localStringBuilder.append("  ");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.ReadUnRead
 * JD-Core Version:    0.7.0.1
 */