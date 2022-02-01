package com.tencent.mobileqq.data;

import java.util.List;

public class ApolloSlaveInfo
{
  public int isCaptured;
  public List<Long> slaveList;
  public int slaveTotal;
  public long uin;
  
  public String toString()
  {
    StringBuffer localStringBuffer = new StringBuffer();
    localStringBuffer.append("uin,").append(this.uin).append(",slaveList:").append(this.slaveList).append(",slaveTotal:").append(this.slaveTotal).append(",isCaptured:").append(this.isCaptured);
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.data.ApolloSlaveInfo
 * JD-Core Version:    0.7.0.1
 */