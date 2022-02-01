package com.tencent.mobileqq.multicard;

import android.graphics.Bitmap;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;

class MultiCardRecommendFragment$2
  implements DecodeTaskCompletionListener
{
  MultiCardRecommendFragment$2(MultiCardRecommendFragment paramMultiCardRecommendFragment) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (MultiCardRecommendFragment.a(this.a) != null) {
      MultiCardRecommendFragment.a(this.a).notifyDataSetChanged();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardRecommendFragment.2
 * JD-Core Version:    0.7.0.1
 */