package com.tencent.mobileqq.troop.troopapps;

import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;
import mqq.manager.TicketManager;
import mqq.util.WeakReference;

public class AddTroopAppCgi
{
  private WeakReference<AddTroopAppCgi.CgiCallBack> a;
  private String b;
  private long c;
  private long d;
  private boolean e;
  private Object f;
  
  public AddTroopAppCgi(AddTroopAppCgi.CgiCallBack paramCgiCallBack, String paramString, long paramLong1, long paramLong2, boolean paramBoolean, Object paramObject)
  {
    this.b = paramString;
    this.c = paramLong1;
    this.d = paramLong2;
    this.e = paramBoolean;
    this.a = new WeakReference(paramCgiCallBack);
    this.f = paramObject;
  }
  
  public void a(QQAppInterface paramQQAppInterface)
  {
    if (paramQQAppInterface == null) {
      return;
    }
    String str2 = paramQQAppInterface.getCurrentUin();
    Object localObject = (TicketManager)paramQQAppInterface.getManager(2);
    String str1 = null;
    if (localObject != null)
    {
      str1 = ((TicketManager)localObject).getSkey(str2);
      localObject = ((TicketManager)localObject).getPskey(str2, "qun.qq.com");
    }
    else
    {
      localObject = null;
    }
    Bundle localBundle = new Bundle();
    HashMap localHashMap = new HashMap();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("");
    localStringBuilder.append(TroopUtils.a(str1));
    localBundle.putString("bkn", localStringBuilder.toString());
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("uin=o");
    localStringBuilder.append(str2);
    localStringBuilder.append(";skey=");
    localStringBuilder.append(str1);
    localStringBuilder.append(";p_uin=o");
    localStringBuilder.append(str2);
    localStringBuilder.append(";p_skey=");
    localStringBuilder.append((String)localObject);
    localBundle.putString("Cookie", localStringBuilder.toString());
    localBundle.putString("gc", String.valueOf(this.b));
    localBundle.putString("append_appid", String.valueOf(this.c));
    localObject = "1";
    localBundle.putString("add_type", "1");
    localBundle.putString("append_source", String.valueOf(this.d));
    localBundle.putString("qqver", "8.8.17.5770");
    localBundle.putString("platform", "2");
    if (!this.e) {
      localObject = "0";
    }
    localBundle.putString("open_shortcut", (String)localObject);
    localHashMap.put("BUNDLE", localBundle);
    localHashMap.put("CONTEXT", paramQQAppInterface.getApp().getApplicationContext());
    new HttpWebCgiAsyncTask2("https://app.qun.qq.com/cgi-bin/api/inner_setunifiedapp", "POST", new AddTroopAppCgi.1(this), 1000, null).a(localHashMap);
    if (QLog.isColorLevel())
    {
      paramQQAppInterface = new StringBuilder();
      paramQQAppInterface.append("AddTroopAppCgi mTroopUin:");
      paramQQAppInterface.append(this.b);
      paramQQAppInterface.append(" append_appid:");
      paramQQAppInterface.append(this.c);
      paramQQAppInterface.append(" mNeedOpenShortCut:");
      paramQQAppInterface.append(this.e);
      QLog.d("AddTroopAppCgi", 2, paramQQAppInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AddTroopAppCgi
 * JD-Core Version:    0.7.0.1
 */