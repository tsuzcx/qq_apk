package com.tencent.mobileqq.ptt.preop;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.audiopanel.ListenChangeVoicePanel;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
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
  public int e;
  public int f;
  int g = 0;
  private int h;
  
  static
  {
    jdField_a_of_type_Int = ListenChangeVoicePanel.jdField_a_of_type_ArrayOfInt.length;
  }
  
  public PreSendTypeStrategy(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
    this.jdField_a_of_type_Float = 0.75F;
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences("PttPreSendSp_" + paramQQAppInterface.getCurrentAccountUin(), 0);
    try
    {
      paramQQAppInterface = paramQQAppInterface.getString("PttVoiceChangePreSender", "[]");
      JSONArray localJSONArray = new JSONArray(paramQQAppInterface);
      if (localJSONArray.length() == jdField_a_of_type_Int + 2)
      {
        int i = 0;
        while (i < jdField_a_of_type_Int)
        {
          this.jdField_a_of_type_ArrayOfInt[i] = localJSONArray.getInt(i);
          i += 1;
        }
        this.e = localJSONArray.getInt(jdField_a_of_type_Int);
        this.f = localJSONArray.getInt(jdField_a_of_type_Int + 1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, "init : get send record " + paramQQAppInterface);
      }
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      this.jdField_a_of_type_ArrayOfInt = new int[jdField_a_of_type_Int];
      this.e = 0;
      this.f = 0;
      paramQQAppInterface.printStackTrace();
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
      k = j;
      if (j < this.jdField_a_of_type_ArrayOfInt[i])
      {
        k = this.jdField_a_of_type_ArrayOfInt[i];
        m = i;
      }
      i += 1;
    }
    return m;
  }
  
  public int a()
  {
    if ((this.e < 5) || (this.c < 0))
    {
      this.d = -1;
      return -1;
    }
    if (this.jdField_b_of_type_Int >= 2)
    {
      this.d = this.c;
      this.g = 1;
    }
    for (;;)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PttPreSendManager", 2, "guess type, result : " + this.d + " case : " + this.g + ", datas : " + a());
      }
      return this.d;
      int i = b();
      if (a(i) >= this.jdField_a_of_type_Float)
      {
        this.d = i;
        this.g = 2;
      }
      else if ((this.c >= 0) && (this.f / this.e > 0.8D))
      {
        this.d = this.c;
        this.g = 3;
      }
      else
      {
        this.d = -1;
        this.g = -1;
      }
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    String str = a();
    paramQQAppInterface = BaseApplicationImpl.sApplication.getSharedPreferences("PttPreSendSp_" + paramQQAppInterface.getCurrentAccountUin(), 0).edit();
    paramQQAppInterface.putString("PttVoiceChangePreSender", str);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.d("PttInfoCollector", 2, "save send record " + str);
    }
  }
  
  public void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    float f1 = 0.55F;
    if ((this.d != -1) && (this.g == 2))
    {
      if (this.d != paramInt) {
        break label88;
      }
      this.jdField_a_of_type_Float -= this.jdField_a_of_type_Float * this.jdField_b_of_type_Float;
      if (this.jdField_a_of_type_Float >= 0.55F) {
        break label111;
      }
      label55:
      this.jdField_a_of_type_Float = f1;
      if (this.jdField_a_of_type_Float <= 0.9F) {
        break label119;
      }
    }
    label88:
    label111:
    label119:
    for (f1 = 0.9F;; f1 = this.jdField_a_of_type_Float)
    {
      this.jdField_a_of_type_Float = f1;
      if (paramInt >= 0) {
        break label127;
      }
      this.c = paramInt;
      return;
      this.jdField_a_of_type_Float += (1.0F - this.jdField_a_of_type_Float) * this.jdField_b_of_type_Float;
      break;
      f1 = this.jdField_a_of_type_Float;
      break label55;
    }
    label127:
    if (paramInt == this.c)
    {
      this.jdField_b_of_type_Int += 1;
      this.f += 1;
    }
    for (;;)
    {
      this.c = paramInt;
      int[] arrayOfInt = this.jdField_a_of_type_ArrayOfInt;
      arrayOfInt[paramInt] += 1;
      this.e += 1;
      this.h += 1;
      if (this.h % 5 == 0) {
        a(paramQQAppInterface);
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("PttInfoCollector", 2, "real send type " + paramInt);
      return;
      this.jdField_b_of_type_Int = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\a.jar
 * Qualified Name:     com.tencent.mobileqq.ptt.preop.PreSendTypeStrategy
 * JD-Core Version:    0.7.0.1
 */