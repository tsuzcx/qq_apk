package com.tencent.smtt.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.smtt.sdk.c.a;

final class q$1
  implements c.a
{
  q$1(Context paramContext) {}
  
  public void a(String paramString)
  {
    Object localObject = this.a.getSharedPreferences("sai", 0).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("scfh", true);
    ((SharedPreferences.Editor)localObject).commit();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("Execute command [1003](");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(")");
    TbsLog.e("TbsUtils", ((StringBuilder)localObject).toString());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.utils.q.1
 * JD-Core Version:    0.7.0.1
 */