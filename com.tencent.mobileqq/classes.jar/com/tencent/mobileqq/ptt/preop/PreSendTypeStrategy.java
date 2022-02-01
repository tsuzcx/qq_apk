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
  public static final int a;
  public float a;
  public int[] a;
  float jdField_b_of_type_Float = 0.05F;
  int jdField_b_of_type_Int = 1;
  int c = -1;
  int d = -1;
  public int e = 0;
  public int f = 0;
  int g = 0;
  private int h = 0;
  
  static
  {
    jdField_a_of_type_Int = IVoiceTuneUtil.VOICE_TYPES.length;
  }
  
  public PreSendTypeStrategy(AppRuntime paramAppRuntime)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
    this.jdField_a_of_type_Float = 0.75F;
    Object localObject = BaseApplication.getContext();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PttPreSendSp_");
    localStringBuilder.append(paramAppRuntime.getCurrentAccountUin());
    paramAppRuntime = ((BaseApplication)localObject).getSharedPreferences(localStringBuilder.toString(), 0);
    try
    {
      paramAppRuntime = paramAppRuntime.getString("PttVoiceChangePreSender", "[]");
      localObject = new JSONArray(paramAppRuntime);
      if (((JSONArray)localObject).length() == jdField_a_of_type_Int + 2)
      {
        int i = 0;
        while (i < jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_ArrayOfInt[i] = ((JSONArray)localObject).getInt(i);
          i += 1;
        }
        this.e = ((JSONArray)localObject).getInt(jdField_a_of_type_Int);
        this.f = ((JSONArray)localObject).getInt(jdField_a_of_type_Int + 1);
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
      this.jdField_a_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
      this.e = 0;
      this.f = 0;
      paramAppRuntime.printStackTrace();
    }
  }
  
  private float a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfInt[paramInt] / this.e;
  }
  
  private String a()
  {
    JSONArray localJSONArray = new JSONArray();
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    int j = arrayOfInt.length;
    int i = 0;
    while (i < j)
    {
      localJSONArray.put(arrayOfInt[i]);
      i += 1;
    }
    localJSONArray.put(this.e);
    localJSONArray.put(this.f);
    return localJSONArray.toString();
  }
  
  private int b()
  {
    int i = 0;
    int m = 0;
    int k;
    for (int j = 0; i < jdField_a_of_type_Int; j = k)
    {
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      k = j;
      if (j < arrayOfInt[i])
      {
        k = arrayOfInt[i];
        m = i;
      }
      i += 1;
    }
    return m;
  }
  
  public int a()
  {
    if (this.e >= 5)
    {
      int i = this.c;
      if (i >= 0)
      {
        if (this.jdField_b_of_type_Int >= 2)
        {
          this.d = i;
          this.g = 1;
        }
        else
        {
          i = b();
          if (a(i) >= this.jdField_a_of_type_Float)
          {
            this.d = i;
            this.g = 2;
          }
          else
          {
            i = this.c;
            if ((i >= 0) && (this.f / this.e > 0.8D))
            {
              this.d = i;
              this.g = 3;
            }
            else
            {
              this.d = -1;
              this.g = -1;
            }
          }
        }
        if (QLog.isColorLevel())
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("guess type, result : ");
          localStringBuilder.append(this.d);
          localStringBuilder.append(" case : ");
          localStringBuilder.append(this.g);
          localStringBuilder.append(", datas : ");
          localStringBuilder.append(a());
          QLog.d("PreSendTypeStrategy", 2, localStringBuilder.toString());
        }
        return this.d;
      }
    }
    this.d = -1;
    return -1;
  }
  
  public void a(AppRuntime paramAppRuntime)
  {
    String str = a();
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
    int i = this.d;
    if ((i != -1) && (this.g == 2))
    {
      if (i == paramInt)
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
    if (paramInt < 0)
    {
      this.c = paramInt;
      return;
    }
    if (paramInt == this.c)
    {
      this.jdField_b_of_type_Int += 1;
      this.f += 1;
    }
    else
    {
      this.jdField_b_of_type_Int = 1;
    }
    this.c = paramInt;
    int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
    arrayOfInt[paramInt] += 1;
    this.e += 1;
    this.h += 1;
    if (this.h % 5 == 0) {
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PreSendTypeStrategy
 * JD-Core Version:    0.7.0.1
 */