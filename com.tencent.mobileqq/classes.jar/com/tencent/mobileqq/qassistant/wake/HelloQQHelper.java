package com.tencent.mobileqq.qassistant.wake;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Looper;
import com.tencent.mobileqq.qassistant.core.AssistantUtils;
import com.tencent.mobileqq.qassistant.core.LoadManager;
import com.tencent.mobileqq.qassistant.wake.aicore.AIModelParam;
import com.tencent.mobileqq.qassistant.wake.aicore.QQWakeAIEngine;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.MobileQQ;

public class HelloQQHelper
{
  public static final List<String> a = new ArrayList(Arrays.asList(new String[] { "helloqq_big.bin", "helloqq_big.txt", "helloqq_small.bin", "helloqq_small.txt", "libHelloQQ.so" }));
  public static volatile AtomicBoolean b = new AtomicBoolean(false);
  private static String h = "";
  private long c = 0L;
  private int d = -2;
  private QQWakeAIEngine e;
  private AIModelParam f;
  private HelloQQHelper.Callback g;
  
  HelloQQHelper()
  {
    if (c())
    {
      this.d = g();
      Object localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(LoadManager.a("wake", a()));
      ((StringBuilder)localObject1).append("/");
      localObject1 = ((StringBuilder)localObject1).toString();
      this.f = new AIModelParam();
      this.f.a = this.d;
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("helloqq_big.txt");
      localObject2 = ((StringBuilder)localObject2).toString();
      this.f.f = AssistantUtils.e((String)localObject2);
      localObject2 = this.f;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("helloqq_big.bin");
      ((AIModelParam)localObject2).g = localStringBuilder.toString();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append((String)localObject1);
      ((StringBuilder)localObject2).append("helloqq_small.txt");
      localObject2 = ((StringBuilder)localObject2).toString();
      this.f.d = AssistantUtils.e((String)localObject2);
      localObject2 = this.f;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append((String)localObject1);
      localStringBuilder.append("helloqq_small.bin");
      ((AIModelParam)localObject2).e = localStringBuilder.toString();
      this.f.h = b();
      localObject1 = this.f;
      ((AIModelParam)localObject1).i = 0.9F;
      this.e = new QQWakeAIEngine((AIModelParam)localObject1);
      this.e.a(new HelloQQHelper.1(this));
    }
  }
  
  public static String a()
  {
    if ("".equals(h))
    {
      h = MobileQQ.sMobileQQ.getSharedPreferences("qq_assistant_sp_key", 0).getString("resModel32", "helloqq5");
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getModelDirName 32bit:");
      localStringBuilder.append(h);
      AssistantUtils.a("HelloQQWake", localStringBuilder.toString());
    }
    return h;
  }
  
  public static String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(LoadManager.a("wake", a()));
    localStringBuilder.append("/");
    localStringBuilder.append("kernal_path/");
    return localStringBuilder.toString();
  }
  
  public static boolean c()
  {
    return LoadManager.a(LoadManager.a("wake", a()), a);
  }
  
  public void a(Looper paramLooper)
  {
    if (this.e != null)
    {
      AssistantUtils.a("HelloQQWake", "HelloQQHelper initEngine");
      this.e.a(paramLooper);
    }
  }
  
  void a(HelloQQHelper.Callback paramCallback)
  {
    this.g = paramCallback;
  }
  
  public void a(ArrayList<byte[]> paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext()) {
      a((byte[])paramArrayList.next());
    }
  }
  
  void a(byte[] paramArrayOfByte)
  {
    if ((this.e != null) && (paramArrayOfByte != null) && (paramArrayOfByte.length == 3200))
    {
      int i = paramArrayOfByte.length / 2;
      short[] arrayOfShort = new short[i];
      ByteBuffer.wrap(paramArrayOfByte).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get(arrayOfShort);
      paramArrayOfByte = this.e;
      if (paramArrayOfByte != null) {
        paramArrayOfByte.a(arrayOfShort, i);
      }
    }
  }
  
  public void d()
  {
    this.g = null;
    if (this.e != null)
    {
      AssistantUtils.a("HelloQQWake", "release()");
      this.e.b();
    }
  }
  
  public boolean e()
  {
    return (this.d > 0) && (QQWakeAIEngine.b != 0L);
  }
  
  public void f()
  {
    QQWakeAIEngine localQQWakeAIEngine = this.e;
    if (localQQWakeAIEngine != null) {
      localQQWakeAIEngine.c();
    }
  }
  
  int g()
  {
    if (this.d == -2)
    {
      SharedPreferences localSharedPreferences = MobileQQ.sMobileQQ.getSharedPreferences("qq_assistant_sp_key", 0);
      this.d = localSharedPreferences.getInt("RunType", 1);
      if (this.d == -2)
      {
        this.d = 1;
        localSharedPreferences.edit().putInt("RunType", this.d).apply();
      }
    }
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qassistant.wake.HelloQQHelper
 * JD-Core Version:    0.7.0.1
 */