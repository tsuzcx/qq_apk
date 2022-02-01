package com.tencent.mobileqq.qqexpand.network;

import androidx.annotation.Nullable;
import com.tencent.qphone.base.util.QLog;

public class ExpandResponse$ExpandDirectConnectSSOResponse
  extends ExpandResponse
{
  public ExpandResponse$ExpandDirectConnectSSOResponse(int paramInt, String paramString)
  {
    super(paramInt, paramString);
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    if (this.a == 1000)
    {
      this.c = paramArrayOfByte;
      return;
    }
    paramArrayOfByte = new StringBuilder();
    paramArrayOfByte.append("cmd error=");
    paramArrayOfByte.append(this.a);
    paramArrayOfByte.append(" msg=");
    paramArrayOfByte.append(this.b);
    QLog.w("expand.cmd.ExpandDirectConnectSSOResponse", 1, paramArrayOfByte.toString());
  }
  
  @Nullable
  public byte[] a()
  {
    return this.c;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.network.ExpandResponse.ExpandDirectConnectSSOResponse
 * JD-Core Version:    0.7.0.1
 */