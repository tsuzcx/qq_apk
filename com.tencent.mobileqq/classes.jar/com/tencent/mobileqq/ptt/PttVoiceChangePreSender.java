package com.tencent.mobileqq.ptt;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONArray;

public class PttVoiceChangePreSender
{
  public static final int a;
  public float a;
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
    jdField_a_of_type_Int = ListenChangeVoicePanel.jdField_a_of_type_ArrayOfInt.length;
  }
  
  public PttVoiceChangePreSender()
  {
    this.jdField_a_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
    this.jdField_a_of_type_Float = 0.75F;
    Object localObject = BaseApplicationImpl.getApplication().getRuntime().getPreferences();
    try
    {
      localObject = ((SharedPreferences)localObject).getString("PttVoiceChangePreSender", "[]");
      JSONArray localJSONArray = new JSONArray((String)localObject);
      if (localJSONArray.length() == jdField_a_of_type_Int + 2)
      {
        int k = 0;
        while (k < jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_ArrayOfInt[k] = localJSONArray.getInt(k);
          k += 1;
        }
        this.f = localJSONArray.getInt(jdField_a_of_type_Int);
        this.g = localJSONArray.getInt(jdField_a_of_type_Int + 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttInfoCollector", 2, "get send record " + (String)localObject);
      }
      return;
    }
    catch (Exception localException)
    {
      this.jdField_a_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
      this.f = 0;
      this.g = 0;
      localException.printStackTrace();
    }
  }
  
  private float a(int paramInt)
  {
    return this.jdField_a_of_type_ArrayOfInt[paramInt] / this.f;
  }
  
  private void a()
  {
    Object localObject1 = new JSONArray();
    Object localObject2 = this.jdField_a_of_type_ArrayOfInt;
    int m = localObject2.length;
    int k = 0;
    while (k < m)
    {
      ((JSONArray)localObject1).put(localObject2[k]);
      k += 1;
    }
    ((JSONArray)localObject1).put(this.f);
    ((JSONArray)localObject1).put(this.g);
    localObject2 = BaseApplicationImpl.getApplication().getRuntime().getPreferences().edit();
    localObject1 = ((JSONArray)localObject1).toString();
    ((SharedPreferences.Editor)localObject2).putString("PttVoiceChangePreSender", (String)localObject1);
    ((SharedPreferences.Editor)localObject2).commit();
    if (QLog.isColorLevel()) {
      QLog.d("PttInfoCollector", 2, "save send record " + (String)localObject1);
    }
  }
  
  private int c()
  {
    int k = 0;
    int i1 = 0;
    int n;
    for (int m = 0; k < jdField_a_of_type_Int; m = n)
    {
      n = m;
      if (m < this.jdField_a_of_type_ArrayOfInt[k])
      {
        n = this.jdField_a_of_type_ArrayOfInt[k];
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
    if ((this.jdField_b_of_type_Int >= 2) && (this.c >= 0))
    {
      this.d = this.c;
      this.h = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttInfoCollector", 2, "pre-send type " + this.d);
      }
      return this.d;
      int k = c();
      if (a(k) >= this.jdField_a_of_type_Float)
      {
        this.d = k;
        this.h = 2;
      }
      else if ((this.c >= 0) && (this.g / this.f > 0.8D))
      {
        this.d = this.c;
        this.h = 3;
      }
      else
      {
        this.d = -1;
        this.h = -1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    a();
    if (this.d != -1)
    {
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800608D", "0X800608D", this.h + 10, 0, this.d + "", paramInt + "", "", "8.5.5");
      if (this.h == 2)
      {
        if (this.d != paramInt) {
          break label235;
        }
        this.jdField_a_of_type_Float -= this.jdField_a_of_type_Float * this.jdField_b_of_type_Float;
        if (this.jdField_a_of_type_Float >= 0.55F) {
          break label258;
        }
        f1 = 0.55F;
        label127:
        this.jdField_a_of_type_Float = f1;
        if (this.jdField_a_of_type_Float <= 0.9F) {
          break label266;
        }
      }
    }
    label258:
    label266:
    for (float f1 = 0.9F;; f1 = this.jdField_a_of_type_Float)
    {
      this.jdField_a_of_type_Float = f1;
      b();
      if (this.e != -1) {
        ReportController.b(paramQQAppInterface, "CliOper", "", "", "0X800608D", "0X800608D", this.i + 20, 0, this.e + "", paramInt + "", "", "8.5.5");
      }
      if (paramInt >= 0) {
        break label274;
      }
      return;
      label235:
      this.jdField_a_of_type_Float += (1.0F - this.jdField_a_of_type_Float) * this.jdField_b_of_type_Float;
      break;
      f1 = this.jdField_a_of_type_Float;
      break label127;
    }
    label274:
    if (paramInt == this.c)
    {
      this.jdField_b_of_type_Int += 1;
      this.g += 1;
    }
    for (;;)
    {
      this.c = paramInt;
      paramQQAppInterface = this.jdField_a_of_type_ArrayOfInt;
      paramQQAppInterface[paramInt] += 1;
      this.f += 1;
      this.j += 1;
      if (this.j % 5 == 0) {
        a();
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttInfoCollector", 2, "real send type " + paramInt);
      return;
      this.jdField_b_of_type_Int = 1;
    }
  }
  
  public int b()
  {
    if ((this.c == -1) || (this.f < 5))
    {
      this.e = -1;
      return -1;
    }
    if (this.jdField_b_of_type_Int >= 2)
    {
      this.e = this.c;
      this.i = 1;
    }
    for (;;)
    {
      return this.e;
      int k = c();
      if (this.c == k)
      {
        this.e = this.c;
        this.i = 2;
      }
      else if (this.g / this.f > 0.85D)
      {
        this.e = this.c;
        this.i = 3;
      }
      else
      {
        this.e = -1;
        this.i = -1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.PttVoiceChangePreSender
 * JD-Core Version:    0.7.0.1
 */