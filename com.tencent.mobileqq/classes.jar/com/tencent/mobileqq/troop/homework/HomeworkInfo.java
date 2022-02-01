package com.tencent.mobileqq.troop.homework;

import java.util.List;

public class HomeworkInfo
{
  public long a;
  public long b;
  public String c;
  public String d;
  public String e;
  public boolean f;
  public String g;
  public int h;
  public long i;
  public List<Long> j;
  public long k;
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("HomeworkInfo{content='");
    localStringBuilder.append(this.d);
    localStringBuilder.append('\'');
    localStringBuilder.append(", group_id=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", uin=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", title='");
    localStringBuilder.append(this.c);
    localStringBuilder.append('\'');
    localStringBuilder.append(", date='");
    localStringBuilder.append(this.e);
    localStringBuilder.append('\'');
    localStringBuilder.append(", need_feedback=");
    localStringBuilder.append(this.f);
    localStringBuilder.append(", course_name=");
    localStringBuilder.append(this.g);
    localStringBuilder.append(", syncgids=");
    localStringBuilder.append(this.j);
    localStringBuilder.append(", hw_id=");
    localStringBuilder.append(this.k);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.HomeworkInfo
 * JD-Core Version:    0.7.0.1
 */