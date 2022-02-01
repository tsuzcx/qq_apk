package com.tencent.mobileqq.emoticonview;

import java.util.List;

class FavoriteEmotionAdapter$3
  implements EmotionPanelDataBuilder.EmotionPanelDataCallback
{
  FavoriteEmotionAdapter$3(FavoriteEmotionAdapter paramFavoriteEmotionAdapter) {}
  
  public void callbackInMainThread(List<EmotionPanelData> paramList)
  {
    if (paramList != null)
    {
      this.this$0.setData(paramList);
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.FavoriteEmotionAdapter.3
 * JD-Core Version:    0.7.0.1
 */