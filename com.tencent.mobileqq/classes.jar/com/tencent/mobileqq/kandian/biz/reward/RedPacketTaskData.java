package com.tencent.mobileqq.kandian.biz.reward;

import android.support.annotation.NonNull;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.persistence.unique;

public class RedPacketTaskData
  extends Entity
{
  public static final String TABLE_NAME = "RedPacketTaskData";
  public long insertTime = 0L;
  @unique
  @NonNull
  public String rowKey = "";
  
  @NonNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("{rowKey:");
    localStringBuilder.append(this.rowKey);
    localStringBuilder.append(", insertTime: ");
    localStringBuilder.append(this.insertTime);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.reward.RedPacketTaskData
 * JD-Core Version:    0.7.0.1
 */