package com.tencent.mobileqq.kandian.repo.follow;

public class BatchFollowModel
{
  public int a;
  public long a;
  public boolean a;
  
  public BatchFollowModel(long paramLong, int paramInt)
  {
    this(paramLong, paramInt, false);
  }
  
  public BatchFollowModel(long paramLong, int paramInt, boolean paramBoolean)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt;
    this.jdField_a_of_type_Boolean = paramBoolean;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("BatchFollowModel{followUin=");
    localStringBuilder.append(this.jdField_a_of_type_Long);
    localStringBuilder.append(", accountType=");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", isFollowed=");
    localStringBuilder.append(this.jdField_a_of_type_Boolean);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.follow.BatchFollowModel
 * JD-Core Version:    0.7.0.1
 */