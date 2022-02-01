package com.tencent.raft.raftframework.service;

import com.tencent.raft.raftframework.IServiceProvider;

public abstract interface IRAServiceManager
{
  public abstract void destroy();
  
  public abstract <T> T getService(Class<T> paramClass, IServiceProvider paramIServiceProvider);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.raftframework.service.IRAServiceManager
 * JD-Core Version:    0.7.0.1
 */