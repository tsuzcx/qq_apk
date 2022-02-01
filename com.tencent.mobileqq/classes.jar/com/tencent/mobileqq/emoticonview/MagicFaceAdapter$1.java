package com.tencent.mobileqq.emoticonview;

import java.util.List;

class MagicFaceAdapter$1
  implements EmotionPanelDataBuilder.EmotionPanelDataCallback
{
  MagicFaceAdapter$1(MagicFaceAdapter paramMagicFaceAdapter) {}
  
  public void callbackInMainThread(List<EmotionPanelData> paramList)
  {
    if (paramList != null)
    {
      this.this$0.setData(paramList);
      this.this$0.notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.MagicFaceAdapter.1
 * JD-Core Version:    0.7.0.1
 */