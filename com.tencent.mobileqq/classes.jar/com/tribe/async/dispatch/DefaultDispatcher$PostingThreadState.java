package com.tribe.async.dispatch;

import java.util.ArrayList;
import java.util.List;

final class DefaultDispatcher$PostingThreadState
{
  boolean canceled;
  final List<PendingPost> eventQueue = new ArrayList();
  boolean isMainThread;
  boolean isPosting;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tribe.async.dispatch.DefaultDispatcher.PostingThreadState
 * JD-Core Version:    0.7.0.1
 */