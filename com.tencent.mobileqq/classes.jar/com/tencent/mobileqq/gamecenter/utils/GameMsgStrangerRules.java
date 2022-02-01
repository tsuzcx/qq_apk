package com.tencent.mobileqq.gamecenter.utils;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class GameMsgStrangerRules
{
  protected boolean d = true;
  protected SharedPreferences e = BaseApplication.getContext().getSharedPreferences("game_center_sp", 0);
  protected int f;
  protected String g;
  protected AppInterface h;
  protected long i = 0L;
  protected int j = 0;
  
  public GameMsgStrangerRules(AppInterface paramAppInterface, String paramString, int paramInt)
  {
    this.f = paramInt;
    String str = paramAppInterface.getCurrentAccountUin();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append(str);
    this.g = localStringBuilder.toString();
    this.h = paramAppInterface;
    a();
  }
  
  protected void a()
  {
    try
    {
      String str2 = this.e.getString(this.g, "");
      if (TextUtils.isEmpty(str2))
      {
        this.j = 0;
        this.i = 0L;
        return;
      }
      int k = str2.indexOf("_");
      if (k < 0) {
        break label141;
      }
      String str1 = str2.substring(0, k);
      str2 = str2.substring(k + 1, str2.length());
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[init], times:");
      localStringBuilder.append(str1);
      localStringBuilder.append(",momentStr:");
      localStringBuilder.append(str2);
      QLog.i("GameMsgRules.Stranger", 1, localStringBuilder.toString());
      this.j = Integer.parseInt(str1);
      this.i = Long.parseLong(str2);
      return;
    }
    catch (Throwable localThrowable)
    {
      label131:
      label141:
      break label131;
    }
    this.j = 0;
    this.i = 0L;
  }
  
  public boolean b()
  {
    if (!GameMsgUtil.a(this.i)) {
      return true;
    }
    if (this.j < this.f) {
      return true;
    }
    QLog.i("GameMsgRules.Stranger", 1, "Fail to action!");
    return false;
  }
  
  public void c()
  {
    int k = this.j;
    if (!GameMsgUtil.a(this.i)) {
      k = 0;
    }
    k += 1;
    this.j = k;
    long l = System.currentTimeMillis();
    this.i = l;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(k);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(l);
    localObject = ((StringBuilder)localObject).toString();
    this.e.edit().putString(this.g, (String)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgStrangerRules
 * JD-Core Version:    0.7.0.1
 */