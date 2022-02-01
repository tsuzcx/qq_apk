package com.tencent.mobileqq.troop.troopapps;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public abstract class AppsBaseBuilder
{
  protected long b = 0L;
  protected long c = 0L;
  protected SessionInfo d;
  protected TroopAppShortcutContainer e;
  protected Context f;
  protected QQAppInterface g;
  protected BaseActivity h;
  protected boolean i = false;
  protected boolean j = false;
  protected int k = 0;
  
  public AppsBaseBuilder(Context paramContext, QQAppInterface paramQQAppInterface, BaseActivity paramBaseActivity, TroopAppShortcutContainer paramTroopAppShortcutContainer, Bundle paramBundle)
  {
    this.f = paramContext;
    this.g = paramQQAppInterface;
    this.h = paramBaseActivity;
    this.e = paramTroopAppShortcutContainer;
    if (paramBundle != null)
    {
      this.d = ((SessionInfo)paramBundle.getParcelable("sessionInfo"));
      this.b = paramBundle.getLong("troopUin", 0L);
      this.c = paramBundle.getLong("troopClassExt", 0L);
      this.i = paramBundle.getBoolean("isNight", false);
      this.j = paramBundle.getBoolean("isAdminOrOwner", false);
      this.k = paramBundle.getInt("reportFrom");
    }
  }
  
  public abstract int a();
  
  public abstract View a(int paramInt, View paramView, ViewGroup paramViewGroup);
  
  public abstract void a_(Object paramObject);
  
  public abstract Object b();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.AppsBaseBuilder
 * JD-Core Version:    0.7.0.1
 */