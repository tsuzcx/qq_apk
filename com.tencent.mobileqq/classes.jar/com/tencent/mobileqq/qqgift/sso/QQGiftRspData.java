package com.tencent.mobileqq.qqgift.sso;

import com.google.protobuf.nano.InvalidProtocolBufferNanoException;
import com.tencent.gift.qlive_proxy_svr.nano.ProxyRsp;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;

public class QQGiftRspData
{
  private int a;
  private FromServiceMsg b;
  private int c;
  private String d;
  private byte[] e;
  private int f;
  private int g;
  private int h;
  private String i;
  private String j;
  private long k;
  
  public QQGiftRspData(int paramInt, FromServiceMsg paramFromServiceMsg, String paramString, long paramLong)
  {
    this.a = paramInt;
    this.b = paramFromServiceMsg;
    this.j = paramString;
    this.k = paramLong;
  }
  
  public QQGiftRspData(int paramInt, FromServiceMsg paramFromServiceMsg, byte[] paramArrayOfByte, String paramString, long paramLong)
  {
    this.a = paramInt;
    this.b = paramFromServiceMsg;
    this.j = paramString;
    this.k = paramLong;
    try
    {
      paramFromServiceMsg = ProxyRsp.a(paramArrayOfByte);
      this.c = paramFromServiceMsg.a;
      this.d = paramFromServiceMsg.b;
      this.e = paramFromServiceMsg.c;
      this.f = paramFromServiceMsg.d;
      this.g = paramFromServiceMsg.e;
      this.h = paramFromServiceMsg.f;
      this.i = paramFromServiceMsg.g;
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
    return this.e;
  }
  
  public FromServiceMsg b()
  {
    return this.b;
  }
  
  public int c()
  {
    return this.h;
  }
  
  public int d()
  {
    return this.c;
  }
  
  public String e()
  {
    return this.i;
  }
  
  public long f()
  {
    return this.k;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqgift.sso.QQGiftRspData
 * JD-Core Version:    0.7.0.1
 */