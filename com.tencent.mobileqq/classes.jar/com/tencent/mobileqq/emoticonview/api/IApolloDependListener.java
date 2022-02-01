package com.tencent.mobileqq.emoticonview.api;

public abstract interface IApolloDependListener
{
  public abstract void apolloCmEmojiDtReport(int paramInt);
  
  public abstract void onEmoticonNewIconShown(int paramInt);
  
  public abstract boolean shouldShowNewIcon(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.api.IApolloDependListener
 * JD-Core Version:    0.7.0.1
 */