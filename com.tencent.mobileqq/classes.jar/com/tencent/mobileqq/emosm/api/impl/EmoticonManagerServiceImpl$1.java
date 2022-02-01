package com.tencent.mobileqq.emosm.api.impl;

import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.data.EmotionKeyword;
import java.util.concurrent.CopyOnWriteArrayList;

class EmoticonManagerServiceImpl$1
  extends QQConcurrentHashMap<String, CopyOnWriteArrayList<EmotionKeyword>>
{
  EmoticonManagerServiceImpl$1(EmoticonManagerServiceImpl paramEmoticonManagerServiceImpl, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected int sizeOf(String paramString, CopyOnWriteArrayList<EmotionKeyword> paramCopyOnWriteArrayList)
  {
    return super.sizeOf(paramString, paramCopyOnWriteArrayList) * paramCopyOnWriteArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emosm.api.impl.EmoticonManagerServiceImpl.1
 * JD-Core Version:    0.7.0.1
 */