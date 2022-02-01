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
  
  public Intent a(long paramLong, int paramInt)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      return localIAIOImageProvider.b(paramLong, paramInt);
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
      localIAIOImageProvider.e(paramLong);
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
  
  public int b(long paramLong, int paramInt)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      return localIAIOImageProvider.a(paramLong, paramInt);
    }
    return 0;
  }
  
  public void b(long paramLong)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.g(paramLong);
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
  
  public Intent c(long paramLong, int paramInt1, int paramInt2)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      return localIAIOImageProvider.c(paramLong, paramInt1, paramInt2);
    }
    return null;
  }
  
  public void c(long paramLong)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.f(paramLong);
    }
  }
  
  public void c(long paramLong, int paramInt)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.c(paramLong, paramInt);
    }
  }
  
  public void c(String paramString) {}
  
  public boolean c()
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      return localIAIOImageProvider.asBinder().pingBinder();
    }
    return false;
  }
  
  public void d(long paramLong)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.h(paramLong);
    }
  }
  
  public void d(String paramString) {}
  
  public boolean e(long paramLong)
  {
    return true;
  }
  
  public void f(long paramLong)
  {
    IAIOImageProvider localIAIOImageProvider = this.a;
    if (localIAIOImageProvider != null) {
      localIAIOImageProvider.c(paramLong);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.PeakProcessProvider
 * JD-Core Version:    0.7.0.1
 */