package com.tencent.mobileqq.onlinestatus.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.tencent.mobileqq.app.face.IFaceDecoder;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.mobileqq.utils.BaseImageUtil;

class OlympicStatusRankView$3
  implements DecodeTaskCompletionListener
{
  OlympicStatusRankView$3(OlympicStatusRankView paramOlympicStatusRankView, IFaceDecoder paramIFaceDecoder) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    if (paramBitmap != null) {
      OlympicStatusRankView.a(this.b).setImageBitmap(BaseImageUtil.c(paramBitmap, paramBitmap.getWidth(), paramBitmap.getHeight()));
    }
    this.a.setDecodeTaskCompletionListener(null);
    this.a.destory();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.view.OlympicStatusRankView.3
 * JD-Core Version:    0.7.0.1
 */