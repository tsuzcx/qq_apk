package com.tencent.mobileqq.transfile.proto;

import com.tencent.mobileqq.transfile.api.impl.ProtoReqManagerImpl.ProtoReq;
import mqq.app.NewIntent;

public abstract interface IProtoReqStrategy
{
  public abstract void updateIntent(NewIntent paramNewIntent);
  
  public abstract void updateReq(ProtoReqManagerImpl.ProtoReq paramProtoReq);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.transfile.proto.IProtoReqStrategy
 * JD-Core Version:    0.7.0.1
 */