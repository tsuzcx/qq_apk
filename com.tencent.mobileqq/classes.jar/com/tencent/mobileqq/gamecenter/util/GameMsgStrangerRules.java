package com.tencent.mobileqq.gamecenter.util;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.aio.rebuild.GameMsgChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.gamecenter.message.GameMsgUtil;
import com.tencent.qphone.base.util.QLog;

public class GameMsgStrangerRules
{
  public static final String b;
  protected long a;
  protected SharedPreferences a;
  protected QQAppInterface a;
  protected boolean a;
  protected int b;
  protected int c;
  protected String c;
  
  static
  {
    jdField_b_of_type_JavaLangString = GameMsgChatPie.g + ".rules";
  }
  
  public GameMsgStrangerRules(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_c_of_type_Int = 0;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplicationImpl.getApplication().getSharedPreferences("game_center_sp", 0);
    this.jdField_b_of_type_Int = paramInt;
    String str = paramQQAppInterface.getCurrentAccountUin();
    this.jdField_c_of_type_JavaLangString = (paramString + str);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    a();
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
        QLog.i(jdField_b_of_type_JavaLangString, 1, "[init], times:" + str1 + ",momentStr:" + str2);
        this.jdField_c_of_type_Int = Integer.parseInt(str1);
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
    if (!GameMsgUtil.a(this.jdField_a_of_type_Long)) {}
    while (this.jdField_c_of_type_Int < this.jdField_b_of_type_Int) {
      return true;
    }
    QLog.i(jdField_b_of_type_JavaLangString, 1, "Fail to action!");
    return false;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    int i = this.jdField_c_of_type_Int;
    if (!GameMsgUtil.a(this.jdField_a_of_type_Long)) {
      i = 0;
    }
    i += 1;
    this.jdField_c_of_type_Int = i;
    this.jdField_a_of_type_Long = l;
    String str = i + "_" + l;
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.jdField_c_of_type_JavaLangString, str).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.util.GameMsgStrangerRules
 * JD-Core Version:    0.7.0.1
 */