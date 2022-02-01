package com.tencent.mobileqq.gamecenter.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.QLog;

public class GameMsgAddFriendRules
  extends GameMsgStrangerRules
{
  private String a;
  private String c;
  
  public GameMsgAddFriendRules(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt)
  {
    super(paramAppInterface, paramString1, paramInt);
    this.jdField_c_of_type_JavaLangString = paramString2;
  }
  
  private int a(String paramString)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    int i = 0;
    if (bool) {
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
      String str2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.jdField_b_of_type_JavaLangString, "");
      if (TextUtils.isEmpty(str2))
      {
        this.jdField_c_of_type_Int = 0;
        this.jdField_a_of_type_Long = 0L;
        return;
      }
      int i = str2.indexOf("_");
      if (i < 0) {
        break label147;
      }
      String str1 = str2.substring(0, i);
      str2 = str2.substring(i + 1, str2.length());
      this.jdField_a_of_type_JavaLangString = str1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[init], friUinStr:");
      localStringBuilder.append(str1);
      localStringBuilder.append(",momentStr:");
      localStringBuilder.append(str2);
      QLog.i("GameMsgRules.Stranger", 1, localStringBuilder.toString());
      this.jdField_c_of_type_Int = a(str1);
      this.jdField_a_of_type_Long = Long.parseLong(str2);
      return;
    }
    catch (Throwable localThrowable)
    {
      label137:
      label147:
      break label137;
    }
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public boolean a()
  {
    try
    {
      if (!GameMsgUtil.a(this.jdField_a_of_type_Long)) {
        return true;
      }
      if ((this.jdField_a_of_type_JavaLangString != null) && (this.jdField_a_of_type_JavaLangString.contains(this.jdField_c_of_type_JavaLangString))) {
        return true;
      }
      int i = this.jdField_c_of_type_Int;
      int j = this.jdField_b_of_type_Int;
      return i < j;
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
    else
    {
      localObject = this.jdField_a_of_type_JavaLangString;
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((String)localObject).contains(this.jdField_c_of_type_JavaLangString)) {
          return;
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append(this.jdField_c_of_type_JavaLangString);
    ((StringBuilder)localObject).append("|");
    this.jdField_a_of_type_JavaLangString = ((StringBuilder)localObject).toString();
    this.jdField_c_of_type_Int = (i + 1);
    this.jdField_a_of_type_Long = l;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(l);
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.jdField_b_of_type_JavaLangString, (String)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgAddFriendRules
 * JD-Core Version:    0.7.0.1
 */