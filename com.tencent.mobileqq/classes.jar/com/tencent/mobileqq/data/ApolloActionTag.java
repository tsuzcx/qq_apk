package com.tencent.mobileqq.data;

import com.tencent.mobileqq.persistence.Entity;

public class ApolloActionTag
  extends Entity
{
  public int actionId;
  public int packageId;
  public String tagName;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer("ApolloTagAction{");
    localStringBuffer.append(", tagName=").append(this.tagName);
    localStringBuffer.append(", packageId=").append(this.packageId);
    localStringBuffer.append(", actionId=").append(this.actionId);
    localStringBuffer.append('}');
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloActionTag
 * JD-Core Version:    0.7.0.1
 */