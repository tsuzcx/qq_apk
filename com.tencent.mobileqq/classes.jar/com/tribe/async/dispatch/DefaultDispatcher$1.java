package com.tribe.async.dispatch;

class DefaultDispatcher$1
  extends ThreadLocal<DefaultDispatcher.PostingThreadState>
{
  DefaultDispatcher$1(DefaultDispatcher paramDefaultDispatcher) {}
  
  protected DefaultDispatcher.PostingThreadState initialValue()
  {
    return new DefaultDispatcher.PostingThreadState();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tribe.async.dispatch.DefaultDispatcher.1
 * JD-Core Version:    0.7.0.1
 */