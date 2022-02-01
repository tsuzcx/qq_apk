package com.tencent.mobileqq.ptt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.voicechange.IVoiceTuneUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import mqq.util.WeakReference;
import org.json.JSONArray;

public class PttVoiceChangePreSender
  implements IPttVoiceChangePreSender
{
  public static final int a = IVoiceTuneUtil.VOICE_TYPES.length;
  public int[] b = new int[a];
  int c = 1;
  int d = -1;
  int e = -1;
  int f = -1;
  public int g = 0;
  public int h = 0;
  public float i = 0.75F;
  float j = 0.05F;
  int k = 0;
  int l = 0;
  private int m = 0;
  private WeakReference<AppRuntime> n;
  
  public PttVoiceChangePreSender(AppRuntime paramAppRuntime)
  {
    if (paramAppRuntime == null) {
      return;
    }
    this.n = new WeakReference(paramAppRuntime);
    paramAppRuntime = paramAppRuntime.getPreferences();
    try
    {
      paramAppRuntime = paramAppRuntime.getString("PttVoiceChangePreSender", "[]");
      Object localObject = new JSONArray(paramAppRuntime);
      if (((JSONArray)localObject).length() == a + 2)
      {
        int i1 = 0;
        while (i1 < a)
        {
          this.b[i1] = ((JSONArray)localObject).getInt(i1);
          i1 += 1;
        }
        this.g = ((JSONArray)localObject).getInt(a);
        this.h = ((JSONArray)localObject).getInt(a + 1);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("get send record ");
        ((StringBuilder)localObject).append(paramAppRuntime);
        QLog.d("PttVoiceChangePreSender", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      this.b = new int[a];
      this.g = 0;
      this.h = 0;
      paramAppRuntime.printStackTrace();
    }
  }
  
  private float a(int paramInt)
  {
    return this.b[paramInt] / this.g;
  }
  
  private void c()
  {
    Object localObject2 = (AppRuntime)this.n.get();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = new JSONArray();
    int[] arrayOfInt = this.b;
    int i2 = arrayOfInt.length;
    int i1 = 0;
    while (i1 < i2)
    {
      ((JSONArray)localObject1).put(arrayOfInt[i1]);
      i1 += 1;
    }
    ((JSONArray)localObject1).put(this.g);
    ((JSONArray)localObject1).put(this.h);
    localObject2 = ((AppRuntime)localObject2).getPreferences().edit();
    localObject1 = ((JSONArray)localObject1).toString();
    ((SharedPreferences.Editor)localObject2).putString("PttVoiceChangePreSender", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).commit();
    if (QLog.isColorLevel())
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("save send record ");
      ((StringBuilder)localObject2).append((String)localObject1);
      QLog.d("PttVoiceChangePreSender", 2, ((StringBuilder)localObject2).toString());
    }
  }
  
  private int d()
  {
    int i1 = 0;
    int i4 = 0;
    int i3;
    for (int i2 = 0; i1 < a; i2 = i3)
    {
      int[] arrayOfInt = this.b;
      i3 = i2;
      if (i2 < arrayOfInt[i1])
      {
        i3 = arrayOfInt[i1];
        i4 = i1;
      }
      i1 += 1;
    }
    return i4;
  }
  
  public int a()
  {
    if (this.g < 5)
    {
      this.e = -1;
      return -1;
    }
    if (this.c >= 2)
    {
      i1 = this.d;
      if (i1 >= 0)
      {
        this.e = i1;
        this.k = 1;
        break label127;
      }
    }
    int i1 = d();
    if (a(i1) >= this.i)
    {
      this.e = i1;
      this.k = 2;
    }
    else
    {
      i1 = this.d;
      if ((i1 >= 0) && (this.h / this.g > 0.8D))
      {
        this.e = i1;
        this.k = 3;
      }
      else
      {
        this.e = -1;
        this.k = -1;
      }
    }
    label127:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pre-send type ");
      localStringBuilder.append(this.e);
      QLog.d("PttVoiceChangePreSender", 2, localStringBuilder.toString());
    }
    return this.e;
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt)
  {
    a();
    int i1;
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.e != -1)
    {
      i1 = this.k;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      ReportController.b(paramAppRuntime, "CliOper", "", "", "0X800608D", "0X800608D", i1 + 10, 0, (String)localObject, localStringBuilder.toString(), "", "8.8.17");
      if (this.k == 2)
      {
        if (this.e == paramInt)
        {
          f1 = this.i;
          this.i = (f1 - this.j * f1);
        }
        else
        {
          f1 = this.i;
          this.i = (f1 + (1.0F - f1) * this.j);
        }
        float f2 = this.i;
        float f1 = f2;
        if (f2 < 0.55F) {
          f1 = 0.55F;
        }
        this.i = f1;
        f2 = this.i;
        f1 = f2;
        if (f2 > 0.9F) {
          f1 = 0.9F;
        }
        this.i = f1;
      }
    }
    b();
    if (this.f != -1)
    {
      i1 = this.l;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.f);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      ReportController.b(paramAppRuntime, "CliOper", "", "", "0X800608D", "0X800608D", i1 + 20, 0, (String)localObject, localStringBuilder.toString(), "", "8.8.17");
    }
    if (paramInt < 0) {
      return;
    }
    if (paramInt == this.d)
    {
      this.c += 1;
      this.h += 1;
    }
    else
    {
      this.c = 1;
    }
    this.d = paramInt;
    paramAppRuntime = this.b;
    paramAppRuntime[paramInt] += 1;
    this.g += 1;
    this.m += 1;
    if (this.m % 5 == 0) {
      c();
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("real send type ");
      paramAppRuntime.append(paramInt);
      QLog.d("PttVoiceChangePreSender", 2, paramAppRuntime.toString());
    }
  }
  
  public int b()
  {
    int i1 = this.d;
    if ((i1 != -1) && (this.g >= 5))
    {
      if (this.c >= 2)
      {
        this.f = i1;
        this.l = 1;
      }
      else
      {
        i1 = d();
        int i2 = this.d;
        if (i2 == i1)
        {
          this.f = i2;
          this.l = 2;
        }
        else if (this.h / this.g > 0.85D)
        {
          this.f = i2;
          this.l = 3;
        }
        else
        {
          this.f = -1;
          this.l = -1;
        }
      }
      return this.f;
    }
    this.f = -1;
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttVoiceChangePreSender
 * JD-Core Version:    0.7.0.1
 */