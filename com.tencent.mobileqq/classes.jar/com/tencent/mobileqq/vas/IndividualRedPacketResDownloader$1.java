package com.tencent.mobileqq.vas;

import android.text.TextUtils;
import com.tencent.mobileqq.vas.updatesystem.callback.CallBacker;
import com.tencent.qphone.base.util.QLog;

class IndividualRedPacketResDownloader$1
  extends CallBacker
{
  IndividualRedPacketResDownloader$1(IndividualRedPacketResDownloader paramIndividualRedPacketResDownloader) {}
  
  public void callback(long paramLong, String paramString1, String paramString2, String paramString3, int paramInt1, int paramInt2)
  {
    if (16L == paramLong)
    {
      if (TextUtils.isEmpty(paramString1)) {
        return;
      }
      StringBuilder localStringBuilder;
      Object localObject;
      if ((QLog.isColorLevel()) || (paramInt1 != 0))
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("callBacker, from:");
        localStringBuilder.append(paramString3);
        localStringBuilder.append(",httpCode=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(",errorCode:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", scid:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", cfgScid:");
        localStringBuilder.append(paramString2);
        if (paramInt1 != 0) {
          localObject = ", Error ";
        } else {
          localObject = ", ok ";
        }
        localStringBuilder.append((String)localObject);
        QLog.d("IndividualRedPacketResDownloader", 2, localStringBuilder.toString());
      }
      try
      {
        boolean bool = IndividualRedPacketResDownloader.a(this.a, paramString1, paramInt1);
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("callBacker, from:");
          ((StringBuilder)localObject).append(paramString3);
          ((StringBuilder)localObject).append(",httpCode=");
          ((StringBuilder)localObject).append(paramInt2);
          ((StringBuilder)localObject).append(",errorCode:");
          ((StringBuilder)localObject).append(paramInt1);
          ((StringBuilder)localObject).append(", scid:");
          ((StringBuilder)localObject).append(paramString1);
          ((StringBuilder)localObject).append(", cfgScid:");
          ((StringBuilder)localObject).append(paramString2);
          ((StringBuilder)localObject).append(", downloadOK=");
          ((StringBuilder)localObject).append(bool);
          QLog.d("IndividualRedPacketResDownloader", 2, ((StringBuilder)localObject).toString());
        }
        if ((!TextUtils.isEmpty(paramString3)) && (paramString3.startsWith("silent_download.redbag")))
        {
          this.a.a();
          return;
        }
      }
      catch (Exception localException)
      {
        localStringBuilder = new StringBuilder();
        localStringBuilder.append("callBacker, from:");
        localStringBuilder.append(paramString3);
        localStringBuilder.append(",httpCode=");
        localStringBuilder.append(paramInt2);
        localStringBuilder.append(",errorCode:");
        localStringBuilder.append(paramInt1);
        localStringBuilder.append(", scid:");
        localStringBuilder.append(paramString1);
        localStringBuilder.append(", cfgScid:");
        localStringBuilder.append(paramString2);
        QLog.d("IndividualRedPacketResDownloader", 2, localStringBuilder.toString(), localException);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.IndividualRedPacketResDownloader.1
 * JD-Core Version:    0.7.0.1
 */