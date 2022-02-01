package com.tencent.mobileqq.guild.live.viewmodel;

import android.text.TextUtils;
import com.tencent.image.URLDrawable;
import com.tencent.mobileqq.guild.live.livemanager.model.QQGuildLiveGiftMsgModel;
import com.tencent.mobileqq.guild.util.livedata.BetterLiveData;
import com.tencent.mobileqq.qqgift.callback.IQQGiftPanelResDownloadCallback;
import com.tencent.mobileqq.qqgift.updatasystem.QQGiftPanelResource;
import com.tencent.qphone.base.util.QLog;
import mqq.util.WeakReference;

class QQGuildLiveRoomVmData$WeakResCallback
  implements IQQGiftPanelResDownloadCallback
{
  private final WeakReference<BetterLiveData<Boolean>> a;
  private final WeakReference<QQGuildLiveGiftMsgModel> b;
  
  public QQGuildLiveRoomVmData$WeakResCallback(WeakReference<BetterLiveData<Boolean>> paramWeakReference, WeakReference<QQGuildLiveGiftMsgModel> paramWeakReference1)
  {
    this.a = paramWeakReference;
    this.b = paramWeakReference1;
  }
  
  public URLDrawable a(String paramString)
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getDrawable url:");
        localStringBuilder.append(paramString);
        QLog.d("QGL.QQGuildLiveRoomVmData", 2, localStringBuilder.toString());
      }
      if (b(paramString)) {
        return URLDrawable.getDrawable(paramString, null);
      }
      paramString = URLDrawable.getFileDrawable(paramString, null);
      return paramString;
    }
    catch (Throwable paramString) {}
    return null;
  }
  
  public void a(int paramInt1, int paramInt2, int paramInt3, String paramString)
  {
    paramString = new StringBuilder();
    paramString.append("onLoadFail id:");
    paramString.append(paramInt1);
    paramString.append(" errorCode:");
    paramString.append(paramInt2);
    QLog.e("QGL.QQGuildLiveRoomVmData", 1, paramString.toString());
    if (this.a.get() != null) {
      ((BetterLiveData)this.a.get()).setValue(Boolean.valueOf(false));
    }
  }
  
  public void a(int paramInt1, long paramLong1, long paramLong2, int paramInt2) {}
  
  public void a(int paramInt, QQGiftPanelResource paramQQGiftPanelResource)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("onLoadSuccess id:");
    localStringBuilder.append(paramInt);
    localStringBuilder.append(" thumbPath:");
    localStringBuilder.append(paramQQGiftPanelResource.b);
    QLog.i("QGL.QQGuildLiveRoomVmData", 1, localStringBuilder.toString());
    if (this.b.get() != null)
    {
      ((QQGuildLiveGiftMsgModel)this.b.get()).b(a(paramQQGiftPanelResource.b));
      QLog.i("QGL.QQGuildLiveRoomVmData", 1, "onLoadSuccess set gift drawable.");
    }
    if (this.a.get() != null) {
      ((BetterLiveData)this.a.get()).setValue(Boolean.valueOf(true));
    }
  }
  
  public boolean b(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && ((paramString.startsWith("https://")) || (paramString.startsWith("http://")));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.guild.live.viewmodel.QQGuildLiveRoomVmData.WeakResCallback
 * JD-Core Version:    0.7.0.1
 */