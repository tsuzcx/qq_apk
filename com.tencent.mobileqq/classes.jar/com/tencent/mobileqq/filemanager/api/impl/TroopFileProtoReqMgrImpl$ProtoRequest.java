package com.tencent.mobileqq.filemanager.api.impl;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.filemanager.api.ITroopFileProtoReq;

public class TroopFileProtoReqMgrImpl$ProtoRequest
  implements ITroopFileProtoReq
{
  static long a;
  public String b;
  public byte[] c;
  public int d = 480000;
  public int e = 9;
  public int f = 3;
  public int g = 25;
  public int h = 450000;
  public boolean i = true;
  public boolean j = true;
  public int k = 1;
  public ProtoUtils.TroopProtocolObserver l;
  public Bundle m;
  TroopFileProtoReqMgrImpl.ProtoResponse n;
  long o;
  
  public TroopFileProtoReqMgrImpl$ProtoRequest()
  {
    long l1 = a + 1L;
    a = l1;
    this.o = l1;
  }
  
  public void a(Bundle paramBundle)
  {
    this.m = paramBundle;
  }
  
  public void a(ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver)
  {
    this.l = paramTroopProtocolObserver;
  }
  
  public void a(String paramString)
  {
    this.b = paramString;
  }
  
  public void a(byte[] paramArrayOfByte)
  {
    this.c = paramArrayOfByte;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.api.impl.TroopFileProtoReqMgrImpl.ProtoRequest
 * JD-Core Version:    0.7.0.1
 */