package com.tencent.mobileqq.troop.filemanager.data;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.troop.api.handler.ITroopMemberListHandler;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;

public class TroopMemberListRefresher
{
  QQAppInterface a;
  String b = null;
  Context c = null;
  Handler d = null;
  private TroopObserver e = new TroopMemberListRefresher.1(this);
  
  public TroopMemberListRefresher(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, Handler paramHandler)
  {
    this.a = paramQQAppInterface;
    this.c = paramContext;
    this.b = paramString;
    this.d = paramHandler;
  }
  
  private String a(String paramString)
  {
    TroopManager localTroopManager = (TroopManager)this.a.getManager(QQManagerFactory.TROOP_MANAGER);
    if (localTroopManager != null)
    {
      paramString = localTroopManager.f(paramString);
      if (paramString != null) {
        return paramString.troopcode;
      }
    }
    return null;
  }
  
  public void a()
  {
    this.a.addObserver(this.e);
  }
  
  public void a(boolean paramBoolean)
  {
    QLog.e("RefreshMemberList", 4, "Prepare refreshMemberListFromServer");
    if (TextUtils.isEmpty(this.b)) {
      return;
    }
    String str = a(this.b);
    if (TextUtils.isEmpty(str)) {
      return;
    }
    SharedPreferences localSharedPreferences = this.c.getSharedPreferences("last_update_time", 4);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("key_last_update_time");
    localStringBuilder.append(str);
    long l1 = localSharedPreferences.getLong(localStringBuilder.toString(), 0L);
    long l2 = System.currentTimeMillis();
    if ((!paramBoolean) && (l1 != 0L) && ((l1 <= 0L) || (l2 - l1 <= 300000L)))
    {
      QLog.e("RefreshMemberList", 4, "< 5min, Will not refresh.");
      return;
    }
    ((ITroopMemberListHandler)this.a.getBusinessHandler(BusinessHandlerFactory.TROOP_MEMBER_LIST_HANDLER)).a(true, this.b, str, 5);
    if (l1 == 0L)
    {
      QLog.e("RefreshMemberList", 4, "Not refresh now, will refresh.");
      return;
    }
    QLog.e("RefreshMemberList", 4, "> 5min, will refresh.");
  }
  
  public void b()
  {
    this.d = null;
    this.a.removeObserver(this.e);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.data.TroopMemberListRefresher
 * JD-Core Version:    0.7.0.1
 */