package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.emoticonview.AbsEmoticonPanelLifecycleObserver;

public class EmotionInjectionInfo
{
  public int columnNum;
  public IEmotionPanelBuilder emotionPanelBuilder;
  public IEmotionTabCreateListener emotionTabListener;
  public int emotionType;
  public int iconResId;
  public AbsEmoticonPanelLifecycleObserver lifecycleObserver;
  
  public EmotionInjectionInfo(int paramInt1, int paramInt2, int paramInt3, IEmotionPanelBuilder paramIEmotionPanelBuilder)
  {
    this.emotionType = paramInt1;
    this.columnNum = paramInt2;
    this.iconResId = paramInt3;
    this.emotionPanelBuilder = paramIEmotionPanelBuilder;
  }
  
  public void setEmotionPanelLifecycleObserver(AbsEmoticonPanelLifecycleObserver paramAbsEmoticonPanelLifecycleObserver)
  {
    this.lifecycleObserver = paramAbsEmoticonPanelLifecycleObserver;
  }
  
  public void setEmotionTabCreateListener(IEmotionTabCreateListener paramIEmotionTabCreateListener)
  {
    this.emotionTabListener = paramIEmotionTabCreateListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.EmotionInjectionInfo
 * JD-Core Version:    0.7.0.1
 */