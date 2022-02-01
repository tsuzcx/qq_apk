package com.tencent.mobileqq.qqlive.sso;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.trpcprotocol.qlive.qlive_proxy_svr.qlive_proxy_svr.nano.ProxyRsp;

public class QQLiveRspData
{
  private FromServiceMsg a;
  private int b;
  private String c;
  private byte[] d;
  private int e;
  private int f;
  private int g;
  private String h;
  private String i;
  private String j;
  
  public QQLiveRspData(FromServiceMsg paramFromServiceMsg, String paramString1, String paramString2)
  {
    this.a = paramFromServiceMsg;
    this.i = paramString1;
    this.j = paramString2;
  }
  
  public QQLiveRspData(FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, String paramString1, String paramString2)
  {
    this.a = paramFromServiceMsg;
    this.i = paramString1;
    this.j = paramString2;
    try
    {
      paramFromServiceMsg = ProxyRsp.a(paramArrayOfByte);
      this.b = paramFromServiceMsg.a;
      this.c = paramFromServiceMsg.b;
      this.d = paramFromServiceMsg.c;
      this.e = paramFromServiceMsg.d;
      this.f = paramFromServiceMsg.e;
      this.g = paramFromServiceMsg.f;
      this.h = paramFromServiceMsg.g;
      if (QLog.isColorLevel())
      {
        paramArrayOfByte = new StringBuilder();
        paramArrayOfByte.append("QQLiveRspData ProxyRsp:");
        paramArrayOfByte.append(paramFromServiceMsg);
        QLog.d("QQLiveRspData", 2, paramArrayOfByte.toString());
        return;
      }
    }
    catch (InvalidProtocolBufferNanoException paramFromServiceMsg)
    {
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("QQLiveRspData throw exception:");
      paramArrayOfByte.append(paramFromServiceMsg.getMessage());
      QLog.e("QQLiveRspData", 1, paramArrayOfByte.toString());
    }
  }
  
  public byte[] a()
  {
    return this.d;
  }
  
  public FromServiceMsg b()
  {
    return this.a;
  }
  
  public int c()
  {
    return this.g;
  }
  
  public int d()
  {
    return this.b;
  }
  
  public String e()
  {
    return this.h;
  }
  
  public String f()
  {
    return this.c;
  }
  
  public String g()
  {
    return this.i;
  }
  
  public String h()
  {
    return this.j;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.sso.QQLiveRspData
 * JD-Core Version:    0.7.0.1
 */