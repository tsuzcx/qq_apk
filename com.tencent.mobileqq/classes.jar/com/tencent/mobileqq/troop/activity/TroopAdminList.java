package com.tencent.mobileqq.troop.activity;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.os.Looper;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import anyu;
import bfgl;
import bfgm;
import bfgn;
import bhlg;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.ThreadManager;
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
  anyu jdField_a_of_type_Anyu = new bfgl(this);
  bfgn jdField_a_of_type_Bfgn;
  protected FriendListHandler a;
  protected XListView a;
  protected final String a;
  public List<Map<String, String>> a;
  protected String[] a;
  public String b;
  public String c;
  public String d;
  
  public TroopAdminList()
  {
    this.jdField_a_of_type_JavaLangString = "TroopAdminList";
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidViewView$OnClickListener = new bfgm(this);
  }
  
  protected void a()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    ThreadManager.post(new TroopAdminList.2(this), 8, null, true);
  }
  
  protected boolean a()
  {
    this.b = getIntent().getStringExtra("uin");
    if (TextUtils.isEmpty(this.b)) {}
    ArrayList localArrayList;
    do
    {
      return false;
      localArrayList = getIntent().getStringArrayListExtra("troop_info_memo");
    } while ((localArrayList == null) || (localArrayList.size() < 1));
    this.jdField_a_of_type_ArrayOfJavaLangString = new String[localArrayList.size()];
    this.jdField_a_of_type_ArrayOfJavaLangString[0] = this.b;
    int k = localArrayList.size();
    int i = 1;
    int j = 0;
    if (i < k)
    {
      if (((String)localArrayList.get(j)).equals(this.b)) {}
      for (;;)
      {
        j += 1;
        break;
        this.jdField_a_of_type_ArrayOfJavaLangString[i] = ((String)localArrayList.get(j));
        i += 1;
      }
    }
    this.c = getIntent().getStringExtra("troop_uin");
    this.d = getIntent().getStringExtra("troop_code");
    return true;
  }
  
  protected void b()
  {
    View localView = View.inflate(this, 2131560564, null);
    this.jdField_a_of_type_ComTencentWidgetXListView = ((XListView)localView.findViewById(2131364907));
    this.jdField_a_of_type_ComTencentWidgetXListView.setVerticalScrollBarEnabled(false);
    this.jdField_a_of_type_ComTencentWidgetXListView.setDivider(null);
    this.jdField_a_of_type_AndroidWidgetLinearLayout = new LinearLayout(this);
    AbsListView.LayoutParams localLayoutParams = new AbsListView.LayoutParams(-1, -2);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setLayoutParams(localLayoutParams);
    this.jdField_a_of_type_AndroidWidgetLinearLayout.setOrientation(1);
    setContentView(localView);
    setTitle(getString(2131693476));
  }
  
  public void c()
  {
    if (Looper.getMainLooper().getThread() == Thread.currentThread())
    {
      ThreadManager.post(new TroopAdminList.3(this), 8, null, true);
      return;
    }
    int j = this.jdField_a_of_type_JavaUtilList.size();
    int i = 0;
    while (i < j)
    {
      String str = (String)((Map)this.jdField_a_of_type_JavaUtilList.get(i)).get("uin");
      ((Map)this.jdField_a_of_type_JavaUtilList.get(i)).put("nick", bhlg.j(this.app, str));
      i += 1;
    }
    runOnUiThread(new TroopAdminList.4(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool);
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
    for (;;)
    {
      return true;
      if (QLog.isColorLevel()) {
        QLog.i("TroopAdminList", 2, "onCreate, illegal param, troopuin = ");
      }
      finish();
    }
  }
  
  public void doOnDestroy()
  {
    removeObserver(this.jdField_a_of_type_Anyu);
    super.doOnDestroy();
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.TroopAdminList
 * JD-Core Version:    0.7.0.1
 */