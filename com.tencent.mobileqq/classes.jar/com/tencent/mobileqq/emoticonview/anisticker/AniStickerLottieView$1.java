package com.tencent.mobileqq.emoticonview.anisticker;

import java.lang.ref.WeakReference;
import java.util.ArrayList;

final class AniStickerLottieView$1
  extends ArrayList<WeakReference<AniStickerLottieView>>
{
  AniStickerLottieView$1(int paramInt)
  {
    super(paramInt);
  }
  
  private void ensureCapacity()
  {
    int i = size();
    if (i > 30) {
      removeRange(0, i - 30 - 1);
    }
  }
  
  public boolean add(WeakReference<AniStickerLottieView> paramWeakReference)
  {
    boolean bool = super.add(paramWeakReference);
    ensureCapacity();
    return bool;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.anisticker.AniStickerLottieView.1
 * JD-Core Version:    0.7.0.1
 */