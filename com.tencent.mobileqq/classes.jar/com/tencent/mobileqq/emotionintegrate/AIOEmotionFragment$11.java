package com.tencent.mobileqq.emotionintegrate;

import com.tencent.qphone.base.util.QLog;
import java.util.List;

class AIOEmotionFragment$11
  implements Runnable
{
  AIOEmotionFragment$11(AIOEmotionFragment paramAIOEmotionFragment, List paramList, EmoticonPreviewData paramEmoticonPreviewData) {}
  
  public void run()
  {
    this.this$0.h.a(this.a);
    this.this$0.h.notifyDataSetChanged();
    EmoticonPreviewData localEmoticonPreviewData = this.b;
    boolean bool = false;
    int i;
    if (localEmoticonPreviewData != null) {
      i = this.this$0.h.a(this.b);
    } else {
      i = 0;
    }
    this.this$0.g.setSelection(i);
    if (QLog.isColorLevel())
    {
      if (this.b == null) {
        bool = true;
      }
      QLog.d("AIOEmotionFragment", 2, new Object[] { "mGallery setSelection pos:", Integer.valueOf(i), " dataIsNull:", Boolean.valueOf(bool) });
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emotionintegrate.AIOEmotionFragment.11
 * JD-Core Version:    0.7.0.1
 */