package com.tencent.raft.raftframework.declare;

public abstract interface IRADeclareManager
{
  public abstract void destroy();
  
  public abstract String getDeclareConstant(String paramString);
  
  public abstract Object getDeclareService(String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.raft.raftframework.declare.IRADeclareManager
 * JD-Core Version:    0.7.0.1
 */