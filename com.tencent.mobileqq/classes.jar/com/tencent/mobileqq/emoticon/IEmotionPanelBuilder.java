package com.tencent.mobileqq.emoticon;

import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;

public abstract interface IEmotionPanelBuilder
{
  public abstract BaseEmotionAdapter buildComplete();
  
  public abstract void buildData();
  
  public abstract void buildParams();
  
  public abstract void buildView();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticon.IEmotionPanelBuilder
 * JD-Core Version:    0.7.0.1
 */