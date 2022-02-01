package com.tencent.rtmp;

import com.tencent.trtc.TRTCCloud.BGMNotify;
import java.lang.ref.WeakReference;

class WXLivePusher$3
  implements TRTCCloud.BGMNotify
{
  WXLivePusher$3(WXLivePusher paramWXLivePusher) {}
  
  public void onBGMComplete(int paramInt)
  {
    if (WXLivePusher.access$100(this.this$0) != null)
    {
      TXLivePusher.OnBGMNotify localOnBGMNotify = (TXLivePusher.OnBGMNotify)WXLivePusher.access$100(this.this$0).get();
      if (localOnBGMNotify != null) {
        localOnBGMNotify.onBGMComplete(paramInt);
      }
    }
  }
  
  public void onBGMProgress(long paramLong1, long paramLong2)
  {
    if (WXLivePusher.access$100(this.this$0) != null)
    {
      TXLivePusher.OnBGMNotify localOnBGMNotify = (TXLivePusher.OnBGMNotify)WXLivePusher.access$100(this.this$0).get();
      if (localOnBGMNotify != null) {
        localOnBGMNotify.onBGMProgress(paramLong1, paramLong2);
      }
    }
  }
  
  public void onBGMStart(int paramInt)
  {
    if (WXLivePusher.access$100(this.this$0) != null)
    {
      TXLivePusher.OnBGMNotify localOnBGMNotify = (TXLivePusher.OnBGMNotify)WXLivePusher.access$100(this.this$0).get();
      if (localOnBGMNotify != null) {
        localOnBGMNotify.onBGMStart();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.rtmp.WXLivePusher.3
 * JD-Core Version:    0.7.0.1
 */