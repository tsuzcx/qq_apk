package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.callback.anchor.IQQLiveAnchorRoomStream;
import com.tencent.mobileqq.qqlive.trtc.video.source.screen.IRTCScreenCaptureEventListener;

class QQLiveAnchorHelperTRTC$4
  implements IRTCScreenCaptureEventListener
{
  QQLiveAnchorHelperTRTC$4(QQLiveAnchorHelperTRTC paramQQLiveAnchorHelperTRTC) {}
  
  public void a()
  {
    IQQLiveAnchorRoomStream localIQQLiveAnchorRoomStream = QQLiveAnchorHelperTRTC.b(this.a);
    if (localIQQLiveAnchorRoomStream != null) {
      localIQQLiveAnchorRoomStream.m();
    }
  }
  
  public void a(int paramInt) {}
  
  public void a(int paramInt, String paramString, Bundle paramBundle)
  {
    paramBundle = QQLiveAnchorHelperTRTC.b(this.a);
    if (paramBundle != null) {
      paramBundle.a(paramInt, paramString);
    }
  }
  
  public void b(int paramInt) {}
  
  public void c(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperTRTC.4
 * JD-Core Version:    0.7.0.1
 */