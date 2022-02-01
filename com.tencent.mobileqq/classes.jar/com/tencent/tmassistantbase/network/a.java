package com.tencent.tmassistantbase.network;

import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistant.common.ProtocolPackage;
import com.tencent.tmassistant.common.jce.ReqHead;
import com.tencent.tmassistant.common.jce.Request;
import com.tencent.tmassistantbase.util.ab;

public abstract class a
{
  private PostHttpRequest a;
  private Class<? extends JceStruct> b;
  private Class<? extends JceStruct> c;
  
  public a(Class<? extends JceStruct> paramClass1, Class<? extends JceStruct> paramClass2)
  {
    this.b = paramClass1;
    this.c = paramClass2;
    this.a = new b(this);
  }
  
  protected int a(JceStruct paramJceStruct)
  {
    ab.c("BaseNetEngine", ">>sendRequest enter requestJce = " + paramJceStruct);
    if (paramJceStruct == null) {
      a(0, -1, null, null);
    }
    int i;
    do
    {
      return -1;
      paramJceStruct = ProtocolPackage.buildRequest(paramJceStruct);
      if ((paramJceStruct == null) || (paramJceStruct.head == null))
      {
        ab.c("BaseNetEngine", ">>sendRequest sendRequest == null || sendRequest.head == null");
        a(0, -2, null, null);
        return -1;
      }
      i = paramJceStruct.head.requestId;
      ab.c("BaseNetEngine", ">>sendRequest ret = " + i);
      paramJceStruct = ProtocolPackage.buildPostData(paramJceStruct);
    } while (!this.a.sendRequest(paramJceStruct));
    ab.c("BaseNetEngine", ">>sendRequest success ret = " + i);
    return i;
  }
  
  public abstract void a(int paramInt1, int paramInt2, JceStruct paramJceStruct1, JceStruct paramJceStruct2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.a
 * JD-Core Version:    0.7.0.1
 */