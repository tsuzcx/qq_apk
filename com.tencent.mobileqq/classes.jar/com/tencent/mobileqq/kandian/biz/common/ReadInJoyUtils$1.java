package com.tencent.mobileqq.kandian.biz.common;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.biz.pubaccount.EncryptUinHandler.GetEncryptUinCallback;

final class ReadInJoyUtils$1
  implements EncryptUinHandler.GetEncryptUinCallback
{
  ReadInJoyUtils$1(SharedPreferences paramSharedPreferences, String paramString) {}
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SharedPreferences.Editor localEditor = this.jdField_a_of_type_AndroidContentSharedPreferences.edit();
    localEditor.putString("iid", this.jdField_a_of_type_JavaLangString);
    localEditor.putString(this.jdField_a_of_type_JavaLangString, paramString);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils.1
 * JD-Core Version:    0.7.0.1
 */