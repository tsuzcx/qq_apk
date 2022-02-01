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
  public static final int a;
  public float a;
  private WeakReference<AppRuntime> a;
  public int[] a;
  float jdField_b_of_type_Float = 0.05F;
  int jdField_b_of_type_Int = 1;
  int c = -1;
  int d = -1;
  int e = -1;
  public int f = 0;
  public int g = 0;
  int h = 0;
  int i = 0;
  private int j = 0;
  
  static
  {
    jdField_a_of_type_Int = IVoiceTuneUtil.VOICE_TYPES.length;
  }
  
  public PttVoiceChangePreSender(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
    this.jdField_a_of_type_Float = 0.75F;
    if (paramAppRuntime == null) {
      return;
    }
    this.jdField_a_of_type_MqqUtilWeakReference = new WeakReference(paramAppRuntime);
    paramAppRuntime = paramAppRuntime.getPreferences();
    try
    {
      paramAppRuntime = paramAppRuntime.getString("PttVoiceChangePreSender", "[]");
      Object localObject = new JSONArray(paramAppRuntime);
      if (((JSONArray)localObject).length() == jdField_a_of_type_Int + 2)
      {
        int k = 0;
        while (k < jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_ArrayOfInt[k] = ((JSONArray)localObject).getInt(k);
          k += 1;
        }
        this.f = ((JSONArray)localObject).getInt(jdField_a_of_type_Int);
        this.g = ((JSONArray)localObject).getInt(jdField_a_of_type_Int + 1);
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
      this.jdField_a_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
      this.f = 0;
      this.g = 0;
      paramAppRuntime.printStackTrace();
    }
  }
  
  private float a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfInt[paramInt] / this.f;
  }
  
  private void a()
  {
    Object localObject2 = (AppRuntime)this.jdField_a_of_type_MqqUtilWeakReference.get();
    if (localObject2 == null) {
      return;
    }
    Object localObject1 = new JSONArray();
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int m = arrayOfInt.length;
    int k = 0;
    while (k < m)
    {
      ((JSONArray)localObject1).put(arrayOfInt[k]);
      k += 1;
    }
    ((JSONArray)localObject1).put(this.f);
    ((JSONArray)localObject1).put(this.g);
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
  
  private int c()
  {
    int k = 0;
    int i1 = 0;
    int n;
    for (int m = 0; k < jdField_a_of_type_Int; m = n)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      n = m;
      if (m < arrayOfInt[k])
      {
        n = arrayOfInt[k];
        i1 = k;
      }
      k += 1;
    }
    return i1;
  }
  
  public int a()
  {
    if (this.f < 5)
    {
      this.d = -1;
      return -1;
    }
    if (this.jdField_b_of_type_Int >= 2)
    {
      k = this.c;
      if (k >= 0)
      {
        this.d = k;
        this.h = 1;
        break label127;
      }
    }
    int k = c();
    if (a(k) >= this.jdField_a_of_type_Float)
    {
      this.d = k;
      this.h = 2;
    }
    else
    {
      k = this.c;
      if ((k >= 0) && (this.g / this.f > 0.8D))
      {
        this.d = k;
        this.h = 3;
      }
      else
      {
        this.d = -1;
        this.h = -1;
      }
    }
    label127:
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("pre-send type ");
      localStringBuilder.append(this.d);
      QLog.d("PttVoiceChangePreSender", 2, localStringBuilder.toString());
    }
    return this.d;
  }
  
  public void a(AppRuntime paramAppRuntime, int paramInt)
  {
    a();
    int k;
    Object localObject;
    StringBuilder localStringBuilder;
    if (this.d != -1)
    {
      k = this.h;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.d);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      ReportController.b(paramAppRuntime, "CliOper", "", "", "0X800608D", "0X800608D", k + 10, 0, (String)localObject, localStringBuilder.toString(), "", "8.7.0");
      if (this.h == 2)
      {
        if (this.d == paramInt)
        {
          f1 = this.jdField_a_of_type_Float;
          this.jdField_a_of_type_Float = (f1 - this.jdField_b_of_type_Float * f1);
        }
        else
        {
          f1 = this.jdField_a_of_type_Float;
          this.jdField_a_of_type_Float = (f1 + (1.0F - f1) * this.jdField_b_of_type_Float);
        }
        float f2 = this.jdField_a_of_type_Float;
        float f1 = f2;
        if (f2 < 0.55F) {
          f1 = 0.55F;
        }
        this.jdField_a_of_type_Float = f1;
        f2 = this.jdField_a_of_type_Float;
        f1 = f2;
        if (f2 > 0.9F) {
          f1 = 0.9F;
        }
        this.jdField_a_of_type_Float = f1;
      }
    }
    b();
    if (this.e != -1)
    {
      k = this.i;
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append("");
      localObject = ((StringBuilder)localObject).toString();
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(paramInt);
      localStringBuilder.append("");
      ReportController.b(paramAppRuntime, "CliOper", "", "", "0X800608D", "0X800608D", k + 20, 0, (String)localObject, localStringBuilder.toString(), "", "8.7.0");
    }
    if (paramInt < 0) {
      return;
    }
    if (paramInt == this.c)
    {
      this.jdField_b_of_type_Int += 1;
      this.g += 1;
    }
    else
    {
      this.jdField_b_of_type_Int = 1;
    }
    this.c = paramInt;
    paramAppRuntime = this.jdField_a_of_type_ArrayOfInt;
    paramAppRuntime[paramInt] += 1;
    this.f += 1;
    this.j += 1;
    if (this.j % 5 == 0) {
      a();
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
    int k = this.c;
    if ((k != -1) && (this.f >= 5))
    {
      if (this.jdField_b_of_type_Int >= 2)
      {
        this.e = k;
        this.i = 1;
      }
      else
      {
        k = c();
        int m = this.c;
        if (m == k)
        {
          this.e = m;
          this.i = 2;
        }
        else if (this.g / this.f > 0.85D)
        {
          this.e = m;
          this.i = 3;
        }
        else
        {
          this.e = -1;
          this.i = -1;
        }
      }
      return this.e;
    }
    this.e = -1;
    return -1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttVoiceChangePreSender
 * JD-Core Version:    0.7.0.1
 */