package com.tencent.mobileqq.emotionintegrate;

import com.tencent.mobileqq.app.ThreadManager;
import java.util.List;

public abstract class EmotionDataSource
{
  public abstract List<EmoticonPreviewData> a(boolean paramBoolean);
  
  public void a(EmotionDataSource.DataLoadListener paramDataLoadListener, EmoticonPreviewData paramEmoticonPreviewData, boolean paramBoolean)
  {
    ThreadManager.excute(new EmotionDataSource.1(this, paramBoolean, paramDataLoadListener, paramEmoticonPreviewData), 64, null, true);
  }
  
  public abstract boolean a();
  
  public abstract int b();
  
  public abstract void c();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.EmotionDataSource
 * JD-Core Version:    0.7.0.1
 */