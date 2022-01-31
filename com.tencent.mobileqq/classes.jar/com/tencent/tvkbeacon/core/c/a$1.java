package com.tencent.tvkbeacon.core.c;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.tvkbeacon.core.a.c;

final class a$1
  implements Runnable
{
  a$1(Context paramContext, String paramString, long paramLong) {}
  
  public final void run()
  {
    SharedPreferences localSharedPreferences = c.a(this.a).c();
    if (localSharedPreferences != null) {
      localSharedPreferences.edit().putLong(this.b, this.c).apply();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.tvkbeacon.core.c.a.1
 * JD-Core Version:    0.7.0.1
 */