package com.tencent.superplayer.player;

import android.graphics.Bitmap;
import com.tencent.superplayer.utils.LogUtil;
import com.tencent.thumbplayer.api.TPCaptureCallBack;

class SuperPlayerWrapper$WrapperIdCaptureListener
  implements TPCaptureCallBack
{
  private int mId;
  
  public SuperPlayerWrapper$WrapperIdCaptureListener(SuperPlayerWrapper paramSuperPlayerWrapper, int paramInt)
  {
    this.mId = paramInt;
  }
  
  public void onCaptureVideoFailed(int paramInt)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onCaptureVideoFailed, id:" + this.mId + " errorCode:" + paramInt);
    SuperPlayerWrapper.access$500(this.this$0).onCaptureImageFailed(this.this$0, this.mId, paramInt);
  }
  
  public void onCaptureVideoSuccess(Bitmap paramBitmap)
  {
    LogUtil.i(SuperPlayerWrapper.access$100(this.this$0), "inner listener called : onCaptureVideoSuccess id:" + this.mId);
    SuperPlayerWrapper.access$500(this.this$0).onCaptureImageSucceed(this.this$0, this.mId, paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper.WrapperIdCaptureListener
 * JD-Core Version:    0.7.0.1
 */