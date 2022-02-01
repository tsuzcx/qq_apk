package com.tencent.mobileqq.gamecenter.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GameMsgStrangerRules
{
  protected long a;
  protected SharedPreferences a;
  protected AppInterface a;
  protected boolean a;
  protected int b;
  protected String b;
  protected int c = 0;
  
  public GameMsgStrangerRules(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    this.jdField_a_of_type_Boolean = true;
    this.jdField_a_of_type_Long = 0L;
    this.jdField_a_of_type_AndroidContentSharedPreferences = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
    this.jdField_b_of_type_Int = paramInt;
    String str = paramAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(str);
    this.jdField_b_of_type_JavaLangString = localStringBuilder.toString();
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    a();
  }
  
  protected void a()
  {
    try
    {
      String str2 = this.jdField_a_of_type_AndroidContentSharedPreferences.getString(this.jdField_b_of_type_JavaLangString, "");
      if (TextUtils.isEmpty(str2))
      {
        this.c = 0;
        this.jdField_a_of_type_Long = 0L;
        return;
      }
      int i = str2.indexOf("_");
      if (i < 0) {
        break label141;
      }
      String str1 = str2.substring(0, i);
      str2 = str2.substring(i + 1, str2.length());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[init], times:");
      localStringBuilder.append(str1);
      localStringBuilder.append(",momentStr:");
      localStringBuilder.append(str2);
      QLog.i("GameMsgRules.Stranger", 1, localStringBuilder.toString());
      this.c = Integer.parseInt(str1);
      this.jdField_a_of_type_Long = Long.parseLong(str2);
      return;
    }
    catch (Throwable localThrowable)
    {
      label131:
      label141:
      break label131;
    }
    this.c = 0;
    this.jdField_a_of_type_Long = 0L;
  }
  
  public boolean a()
  {
    if (!GameMsgUtil.a(this.jdField_a_of_type_Long)) {
      return true;
    }
    if (this.c < this.jdField_b_of_type_Int) {
      return true;
    }
    QLog.i("GameMsgRules.Stranger", 1, "Fail to action!");
    return false;
  }
  
  public void b()
  {
    long l = System.currentTimeMillis();
    int i = this.c;
    if (!GameMsgUtil.a(this.jdField_a_of_type_Long)) {
      i = 0;
    }
    i += 1;
    this.c = i;
    this.jdField_a_of_type_Long = l;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(i);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(l);
    localObject = ((StringBuilder)localObject).toString();
    this.jdField_a_of_type_AndroidContentSharedPreferences.edit().putString(this.jdField_b_of_type_JavaLangString, (String)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgStrangerRules
 * JD-Core Version:    0.7.0.1
 */