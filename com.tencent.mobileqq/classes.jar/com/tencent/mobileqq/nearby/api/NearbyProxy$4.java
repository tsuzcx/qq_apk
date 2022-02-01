package com.tencent.mobileqq.nearby.api;

import android.graphics.Bitmap;
import com.tencent.mobileqq.avatar.listener.DecodeTaskCompletionListener;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;

class NearbyProxy$4
  implements DecodeTaskCompletionListener
{
  NearbyProxy$4(NearbyProxy paramNearbyProxy) {}
  
  public void onDecodeTaskCompleted(int paramInt1, int paramInt2, String paramString, Bitmap paramBitmap)
  {
    synchronized (this.a.i)
    {
      if (this.a.i.contains(paramString))
      {
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("onDecodeTaskCompleted: reqUin=");
          localStringBuilder.append(paramString);
          localStringBuilder.append(", avatar=");
          localStringBuilder.append(paramBitmap);
          QLog.d("NearbyProxy", 2, localStringBuilder.toString());
        }
        this.a.i.remove(paramString);
        NearbyProxy.a(this.a, 4161, new Object[] { Integer.valueOf(paramInt2), paramString, paramBitmap });
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.api.NearbyProxy.4
 * JD-Core Version:    0.7.0.1
 */