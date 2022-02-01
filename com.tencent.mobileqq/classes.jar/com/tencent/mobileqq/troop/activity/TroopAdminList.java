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
  public View.OnClickListener a;
  protected LinearLayout a;
  protected FriendListHandler a;
  FriendListObserver jdField_a_of_type_ComTencentMobileqqAppFriendListObserver = new TroopAdminList.2(this);
  AvatarObserver jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver = new TroopAdminList.1(this);
  TroopAdminList.AdminListAdapter jdField_a_of_type_ComTencentMobileqqTroopActivityTroopAdminList$AdminListAdapter;
  protected XListView a;
  protected final String a;
  protected List<Map<String, String>> a;
  protected String[] a;
  protected String b;
  protected String c;
  protected String d;
  
  public TroopAdminList()
  {
    this.jdField_a_of_type_JavaLangString = "TroopAdminList";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new TroopAdminList.6(this);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    ThreadManager.post(new TroopAdminList.3(this), 8, null, true);
  }
  
  protected boolean a()
  {
    this.b = getIntent().getStringExtra("uin");
    if (TextUtils.isEmpty(this.b)) {
      return false;
    }
    ArrayList localArrayList = getIntent().getStringArrayListExtra("troop_info_memo");
    if (localArrayList != null)
    {
      if (localArrayList.size() < 1) {
        return false;
      }
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[localArrayList.size()];
      this.jdField_a_of_type_ArrayOfJavaLangString[0] = this.b;
      int k = localArrayList.size();
      int j = 1;
      int i = 0;
      while (j < k)
      {
        if (!((String)localArrayList.get(i)).equals(this.b))
        {
          this.jdField_a_of_type_ArrayOfJavaLangString[j] = ((String)localArrayList.get(i));
          j += 1;
        }
        i += 1;
      }
      this.c = getIntent().getStringExtra("troop_uin");
      this.d = getIntent().getStringExtra("troop_code");
      return true;
    }
    return false;
  }
  
  protected void b()
  {
    View localView = View.inflate(this, 2131560604, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131365037));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    setContentView(localView);
    setTitle(getString(2131693882));
  }
  
  protected void c()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.post(new TroopAdminList.4(this), 8, null, true);
      return;
    }
    int i = 0;
    int j = this.jdField_a_of_type_JavaUtilList.size();
    while (i < j)
    {
      String str = (String)((Map)this.jdField_a_of_type_JavaUtilList.get(i)).get("uin");
      ((Map)this.jdField_a_of_type_JavaUtilList.get(i)).put("nick", ContactUtils.d(this.app, str));
      i += 1;
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
      b();
      a();
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
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppFriendListObserver);
    removeObserver(this.jdField_a_of_type_ComTencentMobileqqAvatarObserverAvatarObserver);
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList
 * JD-Core Version:    0.7.0.1
 */