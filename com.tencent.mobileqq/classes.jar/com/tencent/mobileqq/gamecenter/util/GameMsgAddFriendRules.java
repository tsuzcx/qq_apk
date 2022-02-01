package com.tencent.mobileqq.gamecenter.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.qphone.base.util.QLog;

public class GameMsgAddFriendRules
  extends GameMsgStrangerRules
{
  private String a;
  private String d;
  
  public GameMsgAddFriendRules(QQAppInterface paramQQAppInterface, String paramString1, String paramString2, int paramInt)
  {
    super(paramQQAppInterface, paramString1, paramInt);
    this.d = paramString2;
  }
  
  private int a(String paramString)
  {
    int i = 0;
    if (TextUtils.isEmpty(paramString)) {
      return 0;
    }
    int k;
    for (int j = 0; i < paramString.length(); j = k)
    {
      k = j;
      if (paramString.charAt(i) == '|') {
        k = j + 1;
      }
      i += 1;
    }
    return j;
  }
  
  protected void a()
  {
    try
    {
      String str2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.jdField_c_of_type_JavaLangString, "");
      if (TextUtils.isEmpty(str2))
      {
        this.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Long = 0L;
        return;
      }
      int i = str2.indexOf("_");
      if (i >= 0)
      {
        String str1 = str2.substring(0, i);
        str2 = str2.substring(i + 1, str2.length());
        this.jdField_a_of_type_JavaLangString = str1;
        QLog.i(jdField_b_of_type_JavaLangString, 1, "[init], friUinStr:" + str1 + ",momentStr:" + str2);
        this.jdField_c_of_type_Int = a(str1);
        this.jdField_a_of_type_Long = Long.parseLong(str2);
        return;
      }
    }
    catch (Throwable localThrowable)
    {
      this.jdField_c_of_type_Int = 0;
      this.jdField_a_of_type_Long = 0L;
    }
  }
  
  public boolean a()
  {
    try
    {
      if (!GameMsgUtil.a(this.jdField_a_of_type_Long)) {
        return true;
      }
      if ((this.jdField_a_of_type_JavaLangString == null) || (!this.jdField_a_of_type_JavaLangString.contains(this.d)))
      {
        int i = this.jdField_c_of_type_Int;
        int j = this.jdField_b_of_type_Int;
        if (i >= j) {
          return false;
        }
      }
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    int j = this.jdField_c_of_type_Int;
    int i;
    if (!GameMsgUtil.a(this.jdField_a_of_type_Long))
    {
      this.jdField_a_of_type_JavaLangString = "";
      i = 0;
    }
    do
    {
      do
      {
        this.jdField_a_of_type_JavaLangString = (this.jdField_a_of_type_JavaLangString + this.d + "|");
        this.jdField_c_of_type_Int = (i + 1);
        this.jdField_a_of_type_Long = l;
        String str = this.jdField_a_of_type_JavaLangString + "_" + l;
        this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.jdField_c_of_type_JavaLangString, str).commit();
        return;
        i = j;
      } while (this.jdField_a_of_type_JavaLangString == null);
      i = j;
    } while (!this.jdField_a_of_type_JavaLangString.contains(this.d));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.GameMsgAddFriendRules
 * JD-Core Version:    0.7.0.1
 */