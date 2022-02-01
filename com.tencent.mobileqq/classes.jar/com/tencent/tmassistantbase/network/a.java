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
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(">>sendRequest enter requestJce = ");
    localStringBuilder.append(paramJceStruct);
    ab.c("BaseNetEngine", localStringBuilder.toString());
    if (paramJceStruct == null)
    {
      a(0, -1, null, null);
      return -1;
    }
    paramJceStruct = ProtocolPackage.buildRequest(paramJceStruct);
    if ((paramJceStruct != null) && (paramJceStruct.head != null))
    {
      int i = paramJceStruct.head.requestId;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(">>sendRequest ret = ");
      localStringBuilder.append(i);
      ab.c("BaseNetEngine", localStringBuilder.toString());
      paramJceStruct = ProtocolPackage.buildPostData(paramJceStruct);
      if (this.a.sendRequest(paramJceStruct))
      {
        paramJceStruct = new StringBuilder();
        paramJceStruct.append(">>sendRequest success ret = ");
        paramJceStruct.append(i);
        ab.c("BaseNetEngine", paramJceStruct.toString());
        return i;
      }
      return -1;
    }
    ab.c("BaseNetEngine", ">>sendRequest sendRequest == null || sendRequest.head == null");
    a(0, -2, null, null);
    return -1;
  }
  
  public abstract void a(int paramInt1, int paramInt2, JceStruct paramJceStruct1, JceStruct paramJceStruct2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.tmassistantbase.network.a
 * JD-Core Version:    0.7.0.1
 */