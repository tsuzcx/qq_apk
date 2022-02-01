package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProIdentityInstruction;
import org.jetbrains.annotations.NotNull;

public class GProIdentityInstructionInfo
  implements IGProIdentityInstructionInfo
{
  private final GProIdentityInstruction a;
  
  public GProIdentityInstructionInfo(GProIdentityInstruction paramGProIdentityInstruction)
  {
    this.a = paramGProIdentityInstruction;
  }
  
  public String a()
  {
    return this.a.getInstructionText();
  }
  
  public String b()
  {
    return this.a.getNoteText();
  }
  
  public String c()
  {
    return this.a.getTextChannelPreviewImg();
  }
  
  public String d()
  {
    return this.a.getMemberListPreviewImg();
  }
  
  public String e()
  {
    return this.a.getSampleIdentityDesc();
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("GProIdentityInstructionInfo{identityInstruction=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.GProIdentityInstructionInfo
 * JD-Core Version:    0.7.0.1
 */