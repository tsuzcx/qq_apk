package com.tencent.qqperf.opt.clearmemory;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqperf.MagnifierSDK;
import com.tencent.qqperf.monitor.base.IAPMModuleCelling;
import java.util.Random;
import mqq.app.MobileQQ;

public class MemoryConfigs
{
  public String a = "";
  public float b = 0.0F;
  public boolean c = false;
  public int d = 15;
  public long e = 900000L;
  public float f = 1.1F;
  public float g = 1.1F;
  public ClearMemoryConfig h;
  public boolean i = false;
  public boolean j = false;
  public boolean k = true;
  public boolean l = true;
  public float m = -1.0F;
  public long n = -1L;
  private String o = "key_heap_level_AB_ramdom";
  
  public MemoryConfigs()
  {
    Object localObject = MagnifierSDK.b().d().b();
    this.h = new ClearMemoryConfig("-1");
    this.h.b = true;
    a();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if (((String)localObject).equals("0")) {
        return;
      }
      localObject = ((String)localObject).split("_");
      if (localObject.length > 1) {
        localObject = localObject[(((com.tencent.mobileqq.dpc.api.IDPCApi)com.tencent.mobileqq.qroute.QRoute.api(com.tencent.mobileqq.dpc.api.IDPCApi.class)).getAbRamdom() % localObject.length)];
      } else {
        localObject = localObject[0];
      }
      try
      {
        localObject = ((String)localObject).split("\\|");
        if (localObject.length < 7) {
          return;
        }
        arrayOfString = localObject[1].split(";");
        if (arrayOfString[0].equals("1"))
        {
          this.c = true;
          this.d = Integer.parseInt(arrayOfString[1]);
          if (this.d > 50) {
            this.d = 50;
          }
          if (this.d < 1) {
            this.d = 1;
          }
        }
        this.a = localObject[2];
      }
      catch (Exception localException1)
      {
        String[] arrayOfString;
        label292:
        if (QLog.isColorLevel()) {
          QLog.d("Q.Memory.MemoryConfigs", 2, "parseDpc err", localException1);
        }
      }
    }
    try
    {
      this.b = Float.valueOf(localObject[4]).floatValue();
      if (this.b <= 1.0F) {
        break label297;
      }
      this.b = 1.0F;
    }
    catch (Exception localException2)
    {
      break label292;
    }
    this.b = 0.0F;
    try
    {
      label297:
      this.f = Float.parseFloat(localObject[6]);
    }
    catch (Exception localException3)
    {
      label311:
      break label311;
    }
    this.f = 0.001F;
    if (localObject.length >= 9) {
      a((String[])localObject);
    }
    if (localObject.length >= 10) {
      if ("1".equalsIgnoreCase(localObject[9])) {
        this.l = true;
      } else {
        this.l = false;
      }
    }
    if (localObject.length >= 11)
    {
      arrayOfString = localObject[10].split(";");
      if (arrayOfString.length >= 2)
      {
        this.m = Float.parseFloat(arrayOfString[0]);
        this.n = Long.parseLong(arrayOfString[1]);
      }
    }
    b((String[])localObject);
    return;
  }
  
  private void a()
  {
    Object localObject = MobileQQ.getContext().getSharedPreferences("MemoryManagerMemoryStat", 4);
    if (((SharedPreferences)localObject).getInt(this.o, -1) == -1)
    {
      int i1 = new Random().nextInt(1000);
      localObject = ((SharedPreferences)localObject).edit();
      ((SharedPreferences.Editor)localObject).putInt(this.o, i1);
      if (Build.VERSION.SDK_INT < 9) {
        ((SharedPreferences.Editor)localObject).commit();
      } else {
        ((SharedPreferences.Editor)localObject).apply();
      }
    }
    boolean bool;
    if (0.001F >= Math.random()) {
      bool = true;
    } else {
      bool = false;
    }
    this.j = bool;
  }
  
  private void a(String[] paramArrayOfString)
  {
    try
    {
      paramArrayOfString = paramArrayOfString[8].split(";");
      if (paramArrayOfString.length >= 5)
      {
        if (this.h == null) {
          this.h = new ClearMemoryConfig(this.a);
        } else {
          this.h.a = this.a;
        }
        if (paramArrayOfString[0].equals("1")) {
          this.h.b = true;
        } else if (paramArrayOfString[0].equals("0")) {
          this.h.b = false;
        } else if (MobileQQ.sProcessId == 1) {
          this.h.b = true;
        } else if (paramArrayOfString[0].equals("3")) {
          this.h.b = true;
        } else if (paramArrayOfString[0].equals("4")) {
          this.h.b = false;
        } else {
          this.h.b = true;
        }
        this.h.d = Integer.parseInt(paramArrayOfString[1]);
        Object localObject = paramArrayOfString[2].split(",");
        if (localObject.length >= 4)
        {
          localObject = new ClearMemoryConfig.MemoryLevelInfo(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Float.parseFloat(localObject[2]), Float.parseFloat(localObject[3]));
          this.h.e.put(1, localObject);
        }
        localObject = paramArrayOfString[3].split(",");
        if (localObject.length >= 4)
        {
          localObject = new ClearMemoryConfig.MemoryLevelInfo(Integer.parseInt(localObject[0]), Integer.parseInt(localObject[1]), Float.parseFloat(localObject[2]), Float.parseFloat(localObject[3]));
          this.h.e.put(2, localObject);
        }
        paramArrayOfString = paramArrayOfString[4].split(",");
        if (paramArrayOfString.length >= 4)
        {
          paramArrayOfString = new ClearMemoryConfig.MemoryLevelInfo(Integer.parseInt(paramArrayOfString[0]), Integer.parseInt(paramArrayOfString[1]), Float.parseFloat(paramArrayOfString[2]), Float.parseFloat(paramArrayOfString[3]));
          this.h.e.put(3, paramArrayOfString);
        }
        if (QLog.isColorLevel())
        {
          paramArrayOfString = new StringBuilder();
          paramArrayOfString.append("mClearMemoryConfig= ");
          paramArrayOfString.append(this.h);
          QLog.d("Q.Memory.MemoryConfigs", 2, paramArrayOfString.toString());
          return;
        }
      }
    }
    catch (Exception paramArrayOfString)
    {
      paramArrayOfString.printStackTrace();
    }
  }
  
  private void b(String[] paramArrayOfString)
  {
    if (paramArrayOfString.length >= 12)
    {
      if ("1".equalsIgnoreCase(paramArrayOfString[11]))
      {
        this.k = true;
        return;
      }
      this.k = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqperf.opt.clearmemory.MemoryConfigs
 * JD-Core Version:    0.7.0.1
 */