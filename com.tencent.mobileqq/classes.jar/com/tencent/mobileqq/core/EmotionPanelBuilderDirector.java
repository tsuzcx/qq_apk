package com.tencent.mobileqq.core;

import com.tencent.mobileqq.emoticon.IEmotionPanelBuilder;
import com.tencent.mobileqq.emoticonview.BaseEmotionAdapter;
import com.tencent.qphone.base.util.QLog;

public class EmotionPanelBuilderDirector
{
  public long a = 0L;
  public long b = 0L;
  public long c = 0L;
  public long d = 0L;
  
  public BaseEmotionAdapter a(IEmotionPanelBuilder paramIEmotionPanelBuilder)
  {
    if (paramIEmotionPanelBuilder != null)
    {
      long l2 = System.currentTimeMillis();
      paramIEmotionPanelBuilder.buildParams();
      long l1 = System.currentTimeMillis();
      this.a = (l1 - l2);
      paramIEmotionPanelBuilder.buildView();
      l2 = System.currentTimeMillis();
      this.b = (l2 - l1);
      paramIEmotionPanelBuilder.buildData();
      l1 = System.currentTimeMillis();
      this.c = (l1 - l2);
      paramIEmotionPanelBuilder = paramIEmotionPanelBuilder.buildComplete();
      this.d = (System.currentTimeMillis() - l1);
      if (QLog.isColorLevel()) {
        QLog.d("EmotionPanelBuilderDirector", 2, "buildParamsTime = " + this.a + ", buildViewTime = " + this.b + ", buildDataTime = " + this.c + ", buildCompleteTime = " + this.d);
      }
      return paramIEmotionPanelBuilder;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.core.EmotionPanelBuilderDirector
 * JD-Core Version:    0.7.0.1
 */