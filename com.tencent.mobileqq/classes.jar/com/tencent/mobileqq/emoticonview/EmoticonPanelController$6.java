package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;
import com.tencent.mobileqq.model.QueryTask.Query;

class EmoticonPanelController$6
  implements QueryTask.Query<String, Integer>
{
  EmoticonPanelController$6(EmoticonPanelController paramEmoticonPanelController, int paramInt) {}
  
  public Integer query(String paramString)
  {
    this.this$0.syncInitPanelDataList(this.this$0.hasBigEmotion);
    int i = this.val$indexFinal;
    if (!TextUtils.isEmpty(paramString)) {
      i = EmoticonPanelController.access$200(this.this$0, paramString);
    }
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPanelController.6
 * JD-Core Version:    0.7.0.1
 */