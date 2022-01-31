package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.app.EmoticonHandler;
import com.tencent.mobileqq.data.EmoticonResp;
import java.lang.ref.WeakReference;

public class EmojiManager$SyncFetchEmoticonKeyObserver
{
  public WeakReference a;
  
  public EmojiManager$SyncFetchEmoticonKeyObserver(EmojiManager paramEmojiManager, EmoticonHandler paramEmoticonHandler)
  {
    this.a = new WeakReference(paramEmoticonHandler);
  }
  
  public void a(boolean paramBoolean, int paramInt, EmoticonResp paramEmoticonResp) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmojiManager.SyncFetchEmoticonKeyObserver
 * JD-Core Version:    0.7.0.1
 */