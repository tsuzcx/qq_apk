package com.tencent.mobileqq.qqlive.anchor.room.helper;

import android.os.Bundle;
import com.tencent.mobileqq.qqlive.trtc.room.ITRTCRoomListener;
import com.tencent.qphone.base.util.QLog;

class QQLiveAnchorHelperTRTC$2
  implements ITRTCRoomListener
{
  QQLiveAnchorHelperTRTC$2(QQLiveAnchorHelperTRTC paramQQLiveAnchorHelperTRTC) {}
  
  public void a() {}
  
  public void a(int paramInt) {}
  
  public void a(int paramInt1, int paramInt2, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("onEvent, eventId:");
      paramBundle.append(paramInt1);
      paramBundle.append(", errorCode:");
      paramBundle.append(paramInt2);
      paramBundle.append(", message:");
      paramBundle.append(paramString);
      QLog.d("QQLiveAnchor_TRTC", 1, paramBundle.toString());
    }
  }
  
  public void a(int paramInt, String paramString) {}
  
  public void a(long paramLong, String paramString) {}
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt) {}
  
  public void b(int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.anchor.room.helper.QQLiveAnchorHelperTRTC.2
 * JD-Core Version:    0.7.0.1
 */