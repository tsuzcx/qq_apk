package com.tencent.mobileqq.qqguildsdk.data;

import com.tencent.gprosdk.GProClientInfo;
import com.tencent.mobileqq.qqguildsdk.util.GProConvert;
import org.jetbrains.annotations.NotNull;

public class ClientInfo
  implements IClientInfo
{
  private final GProClientInfo a;
  
  public ClientInfo(GProClientInfo paramGProClientInfo)
  {
    this.a = paramGProClientInfo;
  }
  
  public String a()
  {
    return GProConvert.a(this.a.getClientId());
  }
  
  public String b()
  {
    return this.a.getClientName();
  }
  
  public IGProIdentityInstructionInfo c()
  {
    return new GProIdentityInstructionInfo(this.a.getIdentityInstruction());
  }
  
  @NotNull
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ClientIdInfo{clientInfo=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqguildsdk.data.ClientInfo
 * JD-Core Version:    0.7.0.1
 */