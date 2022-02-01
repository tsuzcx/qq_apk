package com.tencent.raft.raftframework.service.api;

import android.text.TextUtils;
import com.tencent.raft.raftframework.constant.RAFTConstants.Scope;

public class ServiceWrapper
{
  public RAFTConstants.Scope scope = RAFTConstants.Scope.PROTOTYPE;
  public Object service;
  
  public ServiceWrapper(Object paramObject, String paramString)
  {
    this.service = paramObject;
    if (!TextUtils.isEmpty(paramString)) {
      this.scope = RAFTConstants.Scope.parse(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.raft.raftframework.service.api.ServiceWrapper
 * JD-Core Version:    0.7.0.1
 */