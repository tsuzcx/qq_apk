package com.tencent.open.agent.entity;

import com.tencent.open.model.VirtualInfo;

public class VirtualAccountInfo
{
  public String a;
  public String b;
  public long c;
  public boolean d = false;
  
  public VirtualAccountInfo(VirtualInfo paramVirtualInfo)
  {
    this.a = paramVirtualInfo.c;
    this.b = paramVirtualInfo.b;
    this.c = paramVirtualInfo.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.open.agent.entity.VirtualAccountInfo
 * JD-Core Version:    0.7.0.1
 */