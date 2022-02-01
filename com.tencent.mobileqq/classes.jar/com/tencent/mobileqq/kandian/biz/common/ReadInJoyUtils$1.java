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
    SharedPreferences.Editor localEditor = this.a.edit();
    localEditor.putString("iid", this.b);
    localEditor.putString(this.b, paramString);
    localEditor.commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils.1
 * JD-Core Version:    0.7.0.1
 */