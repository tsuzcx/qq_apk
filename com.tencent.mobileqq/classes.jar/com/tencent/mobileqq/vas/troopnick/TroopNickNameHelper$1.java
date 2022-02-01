package com.tencent.mobileqq.vas.troopnick;

import android.graphics.Rect;
import android.widget.TextView;

final class TroopNickNameHelper$1
  implements TroopNickResDrawable.UpdateDrawablePadding
{
  TroopNickNameHelper$1(TextView paramTextView) {}
  
  public void a(Rect paramRect)
  {
    TextView localTextView = this.a;
    if (localTextView != null) {
      localTextView.setPadding(paramRect.left, paramRect.top, paramRect.right, paramRect.bottom);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopnick.TroopNickNameHelper.1
 * JD-Core Version:    0.7.0.1
 */