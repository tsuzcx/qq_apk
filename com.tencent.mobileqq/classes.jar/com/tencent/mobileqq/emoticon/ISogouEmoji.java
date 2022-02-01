package com.tencent.mobileqq.emoticon;

import java.util.List;

public abstract interface ISogouEmoji
{
  public abstract void onDestroy();
  
  public abstract void pullMultipleEmojiKey(List<String> paramList);
  
  public abstract void trySend(int paramInt, String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.ISogouEmoji
 * JD-Core Version:    0.7.0.1
 */