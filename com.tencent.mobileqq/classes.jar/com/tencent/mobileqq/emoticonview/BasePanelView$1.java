package com.tencent.mobileqq.emoticonview;

import android.text.TextUtils;

class BasePanelView$1
  implements QueryTask.Query<String, Integer>
{
  BasePanelView$1(BasePanelView paramBasePanelView, int paramInt) {}
  
  public Integer query(String paramString)
  {
    BasePanelView.access$000(this.this$0).syncInitPanelDataList(this.this$0.hasBigEmotion);
    int i = this.val$indexFinal;
    if (!TextUtils.isEmpty(paramString)) {
      i = BasePanelView.access$000(this.this$0).findTabIndexByEpId(paramString);
    }
    return Integer.valueOf(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.BasePanelView.1
 * JD-Core Version:    0.7.0.1
 */