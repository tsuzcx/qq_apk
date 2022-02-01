package com.tencent.mobileqq.troop.activity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.FriendListObserver;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.avatar.observer.AvatarObserver;
import com.tencent.mobileqq.utils.ContactUtils;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class TroopAdminList
  extends IphoneTitleBarActivity
{
  protected final String a = "TroopAdminList";
  protected LinearLayout b;
  protected XListView c;
  TroopAdminList.AdminListAdapter d;
  protected String[] e;
  protected List<Map<String, String>> f = new ArrayList();
  protected String g;
  protected FriendListHandler h;
  protected String i;
  protected String j;
  AvatarObserver k = new TroopAdminList.1(this);
  FriendListObserver l = new TroopAdminList.2(this);
  public View.OnClickListener m = new TroopAdminList.6(this);
  
  protected boolean a()
  {
    this.g = getIntent().getStringExtra("uin");
    if (TextUtils.isEmpty(this.g)) {
      return false;
    }
    ArrayList localArrayList = getIntent().getStringArrayListExtra("troop_info_memo");
    if (localArrayList != null)
    {
      if (localArrayList.size() < 1) {
        return false;
      }
      this.e = new String[localArrayList.size()];
      this.e[0] = this.g;
      int i2 = localArrayList.size();
      int i1 = 1;
      int n = 0;
      while (i1 < i2)
      {
        if (!((String)localArrayList.get(n)).equals(this.g))
        {
          this.e[i1] = ((String)localArrayList.get(n));
          i1 += 1;
        }
        n += 1;
      }
      this.i = getIntent().getStringExtra("troop_uin");
      this.j = getIntent().getStringExtra("troop_code");
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    this.f = new ArrayList();
    ThreadManager.post(new TroopAdminList.3(this), 8, null, true);
  }
  
  protected void c()
  {
    View localView = View.inflate(this, 2131626649, null);
    this.c = ((XListView)localView.findViewById(2131431170));
    this.c.setVerticalScrollBarEnabled(false);
    this.c.setDivider(null);
    this.b = new LinearLayout(this);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.b.setLayoutParams(localLayoutParams);
    this.b.setOrientation(1);
    setContentView(localView);
    setTitle(getString(2131891487));
  }
  
  protected void d()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.post(new TroopAdminList.4(this), 8, null, true);
      return;
    }
    int n = 0;
    int i1 = this.f.size();
    while (n < i1)
    {
      String str = (String)((Map)this.f.get(n)).get("uin");
      ((Map)this.f.get(n)).put("nick", ContactUtils.d(this.app, str));
      n += 1;
    }
    runOnUiThread(new TroopAdminList.5(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    if (a())
    {
      c();
      b();
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("TroopAdminList", 2, "onCreate, illegal param, troopuin = ");
      }
      finish();
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    removeObserver(this.l);
    removeObserver(this.k);
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList
 * JD-Core Version:    0.7.0.1
 */