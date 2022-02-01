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
  private String b;
  
  public GameMsgAddFriendRules(AppInterface paramAppInterface, String paramString1, String paramString2, int paramInt)
  {
    super(paramAppInterface, paramString1, paramInt);
    this.b = paramString2;
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
      String str2 = this.e.getString(this.g, "");
      if (TextUtils.isEmpty(str2))
      {
        this.j = 0;
        this.i = 0L;
        return;
      }
      int i = str2.indexOf("_");
      if (i < 0) {
        break label147;
      }
      String str1 = str2.substring(0, i);
      str2 = str2.substring(i + 1, str2.length());
      this.a = str1;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("[init], friUinStr:");
      localStringBuilder.append(str1);
      localStringBuilder.append(",momentStr:");
      localStringBuilder.append(str2);
      QLog.i("GameMsgRules.Stranger", 1, localStringBuilder.toString());
      this.j = a(str1);
      this.i = Long.parseLong(str2);
      return;
    }
    catch (Throwable localThrowable)
    {
      label137:
      label147:
      break label137;
    }
    this.j = 0;
    this.i = 0L;
  }
  
  public boolean b()
  {
    try
    {
      if (!GameMsgUtil.a(this.i)) {
        return true;
      }
      if ((this.a != null) && (this.a.contains(this.b))) {
        return true;
      }
      int i = this.j;
      int j = this.f;
      return i < j;
    }
    catch (Throwable localThrowable) {}
    return true;
  }
  
  public void c()
  {
    int j = this.j;
    int i;
    if (!GameMsgUtil.a(this.i))
    {
      this.a = "";
      i = 0;
    }
    else
    {
      localObject = this.a;
      i = j;
      if (localObject != null)
      {
        i = j;
        if (((String)localObject).contains(this.b)) {
          return;
        }
      }
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append(this.b);
    ((StringBuilder)localObject).append("|");
    this.a = ((StringBuilder)localObject).toString();
    this.j = (i + 1);
    long l = System.currentTimeMillis();
    this.i = l;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.a);
    ((StringBuilder)localObject).append("_");
    ((StringBuilder)localObject).append(l);
    localObject = ((StringBuilder)localObject).toString();
    this.e.edit().putString(this.g, (String)localObject).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.gamecenter.utils.GameMsgAddFriendRules
 * JD-Core Version:    0.7.0.1
 */