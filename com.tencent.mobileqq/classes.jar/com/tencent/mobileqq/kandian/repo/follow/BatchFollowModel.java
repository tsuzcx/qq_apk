package com.tencent.mobileqq.kandian.repo.follow;

public class BatchFollowModel
{
  public long a;
  public int b;
  public boolean c;
  
  public BatchFollowModel(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, false);
  }
  
  public BatchFollowModel(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.a = paramLong;
    this.b = paramInt;
    this.c = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BatchFollowModel{followUin=");
    localStringBuilder.append(this.a);
    localStringBuilder.append(", accountType=");
    localStringBuilder.append(this.b);
    localStringBuilder.append(", isFollowed=");
    localStringBuilder.append(this.c);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.BatchFollowModel
 * JD-Core Version:    0.7.0.1
 */