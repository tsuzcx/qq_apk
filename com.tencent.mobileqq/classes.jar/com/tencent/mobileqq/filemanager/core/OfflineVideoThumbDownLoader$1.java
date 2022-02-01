package com.tencent.mobileqq.filemanager.core;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.api.IFMConfig;
import com.tencent.mobileqq.filemanager.app.FMObserver;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

class OfflineVideoThumbDownLoader$1
  extends FMObserver
{
  OfflineVideoThumbDownLoader$1(OfflineVideoThumbDownLoader paramOfflineVideoThumbDownLoader) {}
  
  protected void a(boolean paramBoolean, int paramInt1, String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, int paramInt2, String paramString6, long paramLong, Bundle paramBundle)
  {
    paramString1 = new StringBuilder();
    paramString1.append("[downloadThumb]  ID[");
    paramString1.append(paramLong);
    paramString1.append("] OnGetOfflineVideoThumbInfo, bSuccess[");
    paramString1.append(paramBoolean);
    paramString1.append(" retCode:");
    paramString1.append(paramInt1);
    paramString1.append(" downloadIp:");
    paramString1.append(paramString4);
    paramString1.append(" downloadDomain:");
    paramString1.append(paramString5);
    paramString1.append(" port:");
    paramString1.append(paramInt2);
    paramString1.append(" url:");
    paramString1.append(paramString6);
    QLog.i("OfflineVideoThumbDownLoader<FileAssistant>", 1, paramString1.toString());
    paramString1 = this.a;
    short s = 0;
    OfflineVideoThumbDownLoader.VideoSession localVideoSession = OfflineVideoThumbDownLoader.a(paramString1, paramLong, false);
    if (localVideoSession == null)
    {
      paramString1 = new StringBuilder();
      paramString1.append("[downloadThumb]  ID[");
      paramString1.append(paramLong);
      paramString1.append("] OnGetOfflineVideoThumbInfo no this session");
      QLog.e("OfflineVideoThumbDownLoader<FileAssistant>", 2, paramString1.toString());
      this.a.a(paramLong, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    if (!paramBoolean)
    {
      this.a.a.getFileManagerNotifyCenter().a(false, 50, new Object[] { localVideoSession.b });
      this.a.a(paramLong);
      this.a.a(paramLong, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    if ((paramString6 != null) && (paramString6.length() > 0))
    {
      paramString1 = new StringBuilder();
      paramString1.append("[downloadThumb]  ID[");
      paramString1.append(paramLong);
      paramString1.append("] OnGetOfflineVideoThumbInfo url=null");
      QLog.w("OfflineVideoThumbDownLoader<FileAssistant>", 2, paramString1.toString());
      this.a.a.getFileManagerNotifyCenter().a(false, 50, new Object[] { localVideoSession.b });
      this.a.a(paramLong);
      this.a.a(paramLong, false, null, 0, null, null, paramString2, false, null, (short)0, null);
      return;
    }
    if ((paramString4 != null) && (paramString4.length() > 0)) {
      paramString1 = paramString4;
    } else if ((paramString5 != null) && (paramString5.length() > 0)) {
      paramString1 = paramString5;
    } else {
      paramString1 = null;
    }
    if ((paramString1 != null) && (paramString1.length() >= 0))
    {
      if ((paramString3 == null) || (paramString3.length() < 0))
      {
        paramString4 = new StringBuilder();
        paramString4.append("[downloadThumb]  ID[");
        paramString4.append(paramLong);
        paramString4.append("] OnGetOfflineVideoThumbInfo downloadKey invaild");
        QLog.w("OfflineVideoThumbDownLoader<FileAssistant>", 2, paramString4.toString());
      }
      paramString4 = new StringBuilder();
      paramString4.append("/ftn_video_pic/rkey=");
      paramString4.append(paramString3);
      paramString4.append("&filetype=");
      paramString4.append(localVideoSession.d);
      paramString4.append("&size=");
      paramString4.append(this.a.a(localVideoSession.c));
      paramString4.append("&");
      paramString5 = paramString4.toString();
      if ((((IFMConfig)QRoute.api(IFMConfig.class)).isEnableHttpsThumb4C2C(this.a.a)) && (paramBundle != null))
      {
        paramString3 = paramBundle.getString("strHttpsDomain");
        if (!TextUtils.isEmpty(paramString3))
        {
          s = paramBundle.getShort("httpsPort", (short)0);
          if (s == 0)
          {
            paramBoolean = true;
            s = 443;
            break label644;
          }
          paramBoolean = true;
          break label644;
        }
      }
      paramString3 = null;
      paramBoolean = false;
      label644:
      if (paramBundle != null) {
        paramString4 = paramBundle.getString("IPv6Dns");
      } else {
        paramString4 = "";
      }
      this.a.a(paramLong, true, paramString1, paramInt2, paramString5, null, paramString2, paramBoolean, paramString3, s, paramString4);
      return;
    }
    this.a.a.getFileManagerNotifyCenter().a(false, 50, new Object[] { localVideoSession.b });
    this.a.a(paramLong);
    this.a.a(paramLong, false, null, 0, null, null, paramString2, false, null, (short)0, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.OfflineVideoThumbDownLoader.1
 * JD-Core Version:    0.7.0.1
 */