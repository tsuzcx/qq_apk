package com.tencent.mobileqq.friends.intimate;

import android.graphics.Bitmap;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.widget.ThemeImageView;

final class IntimatePlayTogetherMiniGameCardView$2
  implements DecodeTaskCompletionListener
{
  IntimatePlayTogetherMiniGameCardView$2(IFaceDecoder paramIFaceDecoder, ThemeImageView paramThemeImageView) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppFaceIFaceDecoder.destory();
    if ((TextUtils.isEmpty(paramString)) || (paramBitmap == null) || (paramBitmap.isRecycled())) {
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new IntimatePlayTogetherMiniGameCardView.2.1(this, paramBitmap));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.friends.intimate.IntimatePlayTogetherMiniGameCardView.2
 * JD-Core Version:    0.7.0.1
 */