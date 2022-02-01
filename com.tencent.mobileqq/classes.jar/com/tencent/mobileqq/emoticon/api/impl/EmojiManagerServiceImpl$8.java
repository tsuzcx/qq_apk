package com.tencent.mobileqq.emoticon.api.impl;

import com.tencent.mobileqq.app.FavEmoRoamingObserver;
import com.tencent.mobileqq.data.CustomEmotionData;
import java.util.List;

class EmojiManagerServiceImpl$8
  extends FavEmoRoamingObserver
{
  EmojiManagerServiceImpl$8(EmojiManagerServiceImpl paramEmojiManagerServiceImpl, Object paramObject) {}
  
  protected void onUploadReq(List<CustomEmotionData> arg1)
  {
    synchronized (this.a)
    {
      this.a.notify();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.api.impl.EmojiManagerServiceImpl.8
 * JD-Core Version:    0.7.0.1
 */