package com.tencent.vas.update.callback.listener;

import com.tencent.vas.update.entity.UpdateListenerParams;

public abstract interface IUpdateListener
{
  public abstract void onLoadFail(UpdateListenerParams paramUpdateListenerParams);
  
  public abstract void onLoadSuccess(UpdateListenerParams paramUpdateListenerParams);
  
  public abstract void onProgress(UpdateListenerParams paramUpdateListenerParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.vas.update.callback.listener.IUpdateListener
 * JD-Core Version:    0.7.0.1
 */