package com.tencent.mobileqq.model;

import com.tencent.commonsdk.cache.QQConcurrentHashMap;
import com.tencent.mobileqq.data.EmotionKeyword;
import java.util.concurrent.CopyOnWriteArrayList;

class EmoticonManager$1
  extends QQConcurrentHashMap<String, CopyOnWriteArrayList<EmotionKeyword>>
{
  EmoticonManager$1(EmoticonManager paramEmoticonManager, int paramInt1, int paramInt2, int paramInt3)
  {
    super(paramInt1, paramInt2, paramInt3);
  }
  
  protected int sizeOf(String paramString, CopyOnWriteArrayList<EmotionKeyword> paramCopyOnWriteArrayList)
  {
    return super.sizeOf(paramString, paramCopyOnWriteArrayList) * paramCopyOnWriteArrayList.size();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.model.EmoticonManager.1
 * JD-Core Version:    0.7.0.1
 */