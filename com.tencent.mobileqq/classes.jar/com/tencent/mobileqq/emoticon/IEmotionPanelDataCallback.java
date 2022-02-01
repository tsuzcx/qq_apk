package com.tencent.mobileqq.emoticon;

import java.util.List;

public abstract interface IEmotionPanelDataCallback<T>
{
  public abstract void callbackInMainThread(List<T> paramList);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.IEmotionPanelDataCallback
 * JD-Core Version:    0.7.0.1
 */