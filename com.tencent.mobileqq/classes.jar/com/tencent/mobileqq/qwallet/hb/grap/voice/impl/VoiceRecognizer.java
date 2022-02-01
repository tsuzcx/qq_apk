package com.tencent.mobileqq.qwallet.hb.grap.voice.impl;

import android.text.TextUtils;
import com.qwallet.temp.IGrammarNativeTemp;
import com.qwallet.temp.IQWalletTemp;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.qwallet.preload.IPreloadModule;
import com.tencent.mobileqq.qwallet.preload.IPreloadResource;
import com.tencent.mobileqq.qwallet.preload.IPreloadService;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.List;
import mqq.app.AppRuntime;

public class VoiceRecognizer
{
  private static volatile VoiceRecognizer a;
  private IGrammarNativeTemp b = ((IQWalletTemp)QRoute.api(IQWalletTemp.class)).newGrammarNativeTemp();
  private int c = -1;
  
  public static VoiceRecognizer a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new VoiceRecognizer();
        }
      }
      finally {}
    }
    return a;
  }
  
  public int a(byte[] paramArrayOfByte, int paramInt)
  {
    if (this.c == 1) {
      try
      {
        int i = this.b.a(paramArrayOfByte, paramInt);
        if (i < 0) {
          return -1;
        }
        paramInt = i;
        if (i != 1) {
          return paramInt;
        }
        this.c = 0;
        return 1;
      }
      catch (Throwable paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
        return -1;
      }
    } else {
      paramInt = 0;
    }
    return paramInt;
  }
  
  public boolean a(String paramString)
  {
    try
    {
      paramString = paramString.getBytes("GBK");
      int i = this.b.a(paramString);
      return i == 0;
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
    return false;
  }
  
  public boolean a(AppRuntime paramAppRuntime)
  {
    for (;;)
    {
      try
      {
        Object localObject;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("init is call");
          ((StringBuilder)localObject).append(this.c);
          QLog.d("VoiceRecognizer", 2, ((StringBuilder)localObject).toString());
        }
        i = this.c;
        if (i != -1) {
          return true;
        }
        if (paramAppRuntime == null) {
          return false;
        }
        IPreloadService localIPreloadService = (IPreloadService)paramAppRuntime.getRuntimeService(IPreloadService.class, "");
        paramAppRuntime = localIPreloadService.getUnzipFolderPathByResId("2018011001");
        String str = localIPreloadService.getUnzipFolderPathByResId("2018011002");
        if ((!TextUtils.isEmpty(paramAppRuntime)) && (!TextUtils.isEmpty(str)))
        {
          localObject = new File(paramAppRuntime, "libwxvoiceembed.so");
          File localFile = new File(str, "libwxvoiceembed.bin");
          paramAppRuntime = (AppRuntime)localObject;
          if (!((File)localObject).exists()) {
            break label241;
          }
          paramAppRuntime = (AppRuntime)localObject;
          if (!localFile.exists()) {
            break label241;
          }
          i = 1;
          paramAppRuntime = (AppRuntime)localObject;
          if (i == 0)
          {
            localIPreloadService.downloadModule("2017112200");
            return false;
          }
          try
          {
            System.load(paramAppRuntime.getAbsolutePath());
            i = this.b.a(str.getBytes(), "libwxvoiceembed.bin".getBytes(), null);
            if (i < 0) {
              return false;
            }
            this.c = 0;
            return true;
          }
          catch (Throwable paramAppRuntime)
          {
            paramAppRuntime.printStackTrace();
            return false;
          }
        }
        paramAppRuntime = null;
      }
      finally {}
      label241:
      int i = 0;
    }
  }
  
  public String b(AppRuntime paramAppRuntime)
  {
    localStringBuilder = new StringBuilder();
    try
    {
      paramAppRuntime = ((IPreloadService)paramAppRuntime.getRuntimeService(IPreloadService.class, "")).getModuleByMID("2017112200");
      if (paramAppRuntime != null)
      {
        paramAppRuntime = paramAppRuntime.getResApiList();
        if (paramAppRuntime != null)
        {
          int i = 0;
          while (i < paramAppRuntime.size())
          {
            IPreloadResource localIPreloadResource = (IPreloadResource)paramAppRuntime.get(i);
            if (i != 0) {
              localStringBuilder.append("&");
            }
            localStringBuilder.append(localIPreloadResource.getResId());
            i += 1;
          }
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable paramAppRuntime)
    {
      paramAppRuntime.printStackTrace();
    }
  }
  
  public boolean b()
  {
    if (this.c == 0)
    {
      this.c = 1;
      try
      {
        int i = this.b.a();
        if (i < 0) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public boolean c()
  {
    if (this.c == 1)
    {
      this.c = 0;
      try
      {
        int i = this.b.b();
        if (i < 0) {
          return false;
        }
      }
      catch (Throwable localThrowable)
      {
        localThrowable.printStackTrace();
        return false;
      }
    }
    return true;
  }
  
  public float d()
  {
    try
    {
      float f = this.b.c();
      return f;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
    return 1.0F;
  }
  
  public boolean e()
  {
    try
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("destroy is call");
        localStringBuilder.append(this.c);
        QLog.d("VoiceRecognizer", 2, localStringBuilder.toString());
      }
      int i = this.c;
      if (i != -1) {
        try
        {
          if (this.b.d() == 0)
          {
            this.c = -1;
            return true;
          }
        }
        catch (Exception localException)
        {
          localException.printStackTrace();
        }
      }
      return false;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.grap.voice.impl.VoiceRecognizer
 * JD-Core Version:    0.7.0.1
 */