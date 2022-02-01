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
    String str = SuperPlayerWrapper.access$100(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inner listener called : onCaptureVideoFailed, id:");
    localStringBuilder.append(this.mId);
    localStringBuilder.append(" errorCode:");
    localStringBuilder.append(paramInt);
    LogUtil.i(str, localStringBuilder.toString());
    SuperPlayerWrapper.access$800(this.this$0).onCaptureImageFailed(this.this$0, this.mId, paramInt);
  }
  
  public void onCaptureVideoSuccess(Bitmap paramBitmap)
  {
    String str = SuperPlayerWrapper.access$100(this.this$0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("inner listener called : onCaptureVideoSuccess id:");
    localStringBuilder.append(this.mId);
    LogUtil.i(str, localStringBuilder.toString());
    SuperPlayerWrapper.access$800(this.this$0).onCaptureImageSucceed(this.this$0, this.mId, paramBitmap.getWidth(), paramBitmap.getHeight(), paramBitmap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.superplayer.player.SuperPlayerWrapper.WrapperIdCaptureListener
 * JD-Core Version:    0.7.0.1
 */