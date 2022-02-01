package com.tencent.mobileqq.emoticonview;

import android.widget.ListAdapter;
import java.util.List;

public abstract interface IEmotionHotPicSearchAdapter
  extends ListAdapter
{
  public abstract int getWidthPixels();
  
  public abstract void setCurrentListView(EmotionPanelListView paramEmotionPanelListView);
  
  public abstract void setData(List<EmotionPanelData> paramList);
  
  public abstract void setWidthPixels(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.IEmotionHotPicSearchAdapter
 * JD-Core Version:    0.7.0.1
 */