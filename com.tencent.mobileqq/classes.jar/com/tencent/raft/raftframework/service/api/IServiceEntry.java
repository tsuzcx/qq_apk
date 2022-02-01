package com.tencent.raft.raftframework.service.api;

public abstract interface IServiceEntry
{
  public abstract ServiceWrapper createService();
  
  public abstract String getKey();
  
  public abstract int getPriority();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.raft.raftframework.service.api.IServiceEntry
 * JD-Core Version:    0.7.0.1
 */