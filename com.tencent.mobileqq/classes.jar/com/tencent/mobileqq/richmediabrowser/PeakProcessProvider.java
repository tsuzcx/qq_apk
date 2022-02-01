package com.tencent.mobileqq.richmediabrowser;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import com.tencent.mobileqq.activity.aio.photo.IAIOImageProvider;
import com.tencent.mobileqq.data.MessageForShortVideo;
import com.tencent.mobileqq.data.MessageRecord;

public class PeakProcessProvider
  implements IAIOBrowserProvider
{
  public IAIOImageProvider a;
  
  public int a(long paramLong, int paramInt)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      return localIAIOImageProvider.a(paramLong, paramInt);
    }
    return 0;
  }
  
  public Intent a(long paramLong, int paramInt)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      return localIAIOImageProvider.a(paramLong, paramInt);
    }
    return null;
  }
  
  public Intent a(long paramLong, int paramInt1, int paramInt2)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      return localIAIOImageProvider.a(paramLong, paramInt1, paramInt2);
    }
    return null;
  }
  
  public void a(int paramInt)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.a(paramInt);
    }
  }
  
  public void a(int paramInt, boolean paramBoolean, String paramString1, String paramString2, String paramString3, String paramString4)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.a(paramInt, paramBoolean, paramString1, paramString2, paramString3, paramString4);
    }
  }
  
  public void a(long paramLong)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.c(paramLong);
    }
  }
  
  public void a(long paramLong, int paramInt)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.a(paramLong, paramInt);
    }
  }
  
  public void a(long paramLong, int paramInt1, int paramInt2)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.a(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void a(long paramLong, int paramInt, Bundle paramBundle)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.a(paramLong, paramInt, paramBundle);
    }
  }
  
  public void a(IAIOImageProvider paramIAIOImageProvider)
  {
    this.a = paramIAIOImageProvider;
  }
  
  public void a(MessageRecord paramMessageRecord)
  {
    if ((paramMessageRecord instanceof MessageForShortVideo))
    {
      IAIOImageProvider localIAIOImageProvider = this.a;
      if (localIAIOImageProvider != null) {
        localIAIOImageProvider.a((MessageForShortVideo)paramMessageRecord);
      }
    }
  }
  
  public void a(String paramString) {}
  
  public void a(String paramString, int paramInt)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.a(paramString, paramInt);
    }
  }
  
  public boolean a()
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      return localIAIOImageProvider.asBinder().pingBinder();
    }
    return false;
  }
  
  public boolean a(long paramLong)
  {
    return true;
  }
  
  public void b(long paramLong)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.e(paramLong);
    }
  }
  
  public void b(long paramLong, int paramInt1, int paramInt2)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.b(paramLong, paramInt1, paramInt2);
    }
  }
  
  public void b(String paramString) {}
  
  public void c(long paramLong)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.d(paramLong);
    }
  }
  
  public void c(String paramString) {}
  
  public void d(long paramLong)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.f(paramLong);
    }
  }
  
  public void d(String paramString) {}
  
  public void e(long paramLong)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.a(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.PeakProcessProvider
 * JD-Core Version:    0.7.0.1
 */