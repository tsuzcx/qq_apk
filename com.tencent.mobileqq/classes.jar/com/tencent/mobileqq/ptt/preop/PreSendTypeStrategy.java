package com.tencent.mobileqq.ptt.preop;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.voicechange.IVoiceTuneUtil;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class PreSendTypeStrategy
{
  public static final int a = IVoiceTuneUtil.VOICE_TYPES.length;
  public int[] b = new int[a];
  int c = 1;
  int d = -1;
  int e = -1;
  public int f = 0;
  public int g = 0;
  public float h = 0.75F;
  float i = 0.05F;
  int j = 0;
  private int k = 0;
  
  public PreSendTypeStrategy(AppRuntime paramAppRuntime)
  {
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PttPreSendSp_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    try
    {
      paramAppRuntime = paramAppRuntime.getString("PttVoiceChangePreSender", "[]");
      localObject = new JSONArray(paramAppRuntime);
      if (((JSONArray)localObject).length() == a + 2)
      {
        int m = 0;
        while (m < a)
        {
          this.b[m] = ((JSONArray)localObject).getInt(m);
          m += 1;
        }
        this.f = ((JSONArray)localObject).getInt(a);
        this.g = ((JSONArray)localObject).getInt(a + 1);
      }
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("init : get send record ");
        ((StringBuilder)localObject).append(paramAppRuntime);
        QLog.d("PreSendTypeStrategy", 2, ((StringBuilder)localObject).toString());
        return;
      }
    }
    catch (Exception paramAppRuntime)
    {
      this.b = new int[a];
      this.f = 0;
      this.g = 0;
      paramAppRuntime.printStackTrace();
    }
  }
  
  private float a(int paramInt)
  {
    return this.b[paramInt] / this.f;
  }
  
  private String b()
  {
    JSONArray localJSONArray = new JSONArray();
    int[] arrayOfInt = this.b;
    int n = arrayOfInt.length;
    int m = 0;
    while (m < n)
    {
      localJSONArray.put(arrayOfInt[m]);
      m += 1;
    }
    localJSONArray.put(this.f);
    localJSONArray.put(this.g);
    return localJSONArray.toString();
  }
  
  private int c()
  {
    int m = 0;
    int i2 = 0;
    int i1;
    for (int n = 0; m < a; n = i1)
    {
      int[] arrayOfInt = this.b;
      i1 = n;
      if (n < arrayOfInt[m])
      {
        i1 = arrayOfInt[m];
        i2 = m;
      }
      m += 1;
    }
    return i2;
  }
  
  public int a()
  {
    if (this.f >= 5)
    {
      int m = this.d;
      if (m >= 0)
      {
        if (this.c >= 2)
        {
          this.e = m;
          this.j = 1;
        }
        else
        {
          m = c();
          if (a(m) >= this.h)
          {
            this.e = m;
            this.j = 2;
          }
          else
          {
            m = this.d;
            if ((m >= 0) && (this.g / this.f > 0.8D))
            {
              this.e = m;
              this.j = 3;
            }
            else
            {
              this.e = -1;
              this.j = -1;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("guess type, result : ");
          localStringBuilder.append(this.e);
          localStringBuilder.append(" case : ");
          localStringBuilder.append(this.j);
          localStringBuilder.append(", datas : ");
          localStringBuilder.append(b());
          QLog.d("PreSendTypeStrategy", 2, localStringBuilder.toString());
        }
        return this.e;
      }
    }
    this.e = -1;
    return -1;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    String str = b();
    BaseApplication localBaseApplication = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PttPreSendSp_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = localBaseApplication.getSharedPreferences(localStringBuilder.toString(), 0).edit();
    paramAppRuntime.putString("PttVoiceChangePreSender", str);
    paramAppRuntime.commit();
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("save send record ");
      paramAppRuntime.append(str);
      QLog.d("PreSendTypeStrategy", 2, paramAppRuntime.toString());
    }
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt)
  {
    int m = this.e;
    if ((m != -1) && (this.j == 2))
    {
      if (m == paramInt)
      {
        f1 = this.h;
        this.h = (f1 - this.i * f1);
      }
      else
      {
        f1 = this.h;
        this.h = (f1 + (1.0F - f1) * this.i);
      }
      float f2 = this.h;
      float f1 = f2;
      if (f2 < 0.55F) {
        f1 = 0.55F;
      }
      this.h = f1;
      f2 = this.h;
      f1 = f2;
      if (f2 > 0.9F) {
        f1 = 0.9F;
      }
      this.h = f1;
    }
    if (paramInt < 0)
    {
      this.d = paramInt;
      return;
    }
    if (paramInt == this.d)
    {
      this.c += 1;
      this.g += 1;
    }
    else
    {
      this.c = 1;
    }
    this.d = paramInt;
    int[] arrayOfInt = this.b;
    arrayOfInt[paramInt] += 1;
    this.f += 1;
    this.k += 1;
    if (this.k % 5 == 0) {
      a(paramAppRuntime);
    }
    if (QLog.isColorLevel())
    {
      paramAppRuntime = new StringBuilder();
      paramAppRuntime.append("real send type ");
      paramAppRuntime.append(paramInt);
      QLog.d("PreSendTypeStrategy", 2, paramAppRuntime.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PreSendTypeStrategy
 * JD-Core Version:    0.7.0.1
 */