package com.tencent.mobileqq.guild.setting;

import java.io.Serializable;

public class QQGuildMemberFragment$OperateMemberResult
  implements Serializable
{
  private final int mOpcode;
  private final String mTargetTinyId;
  
  public QQGuildMemberFragment$OperateMemberResult(int paramInt, String paramString)
  {
    this.mOpcode = paramInt;
    this.mTargetTinyId = paramString;
  }
  
  public int getOpcode()
  {
    return this.mOpcode;
  }
  
  public String getTargetTinyId()
  {
    return this.mTargetTinyId;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.setting.QQGuildMemberFragment.OperateMemberResult
 * JD-Core Version:    0.7.0.1
 */