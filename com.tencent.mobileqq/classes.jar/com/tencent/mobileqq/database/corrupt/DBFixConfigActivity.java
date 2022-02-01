package com.tencent.mobileqq.database.corrupt;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.app.AppActivity;
import mqq.app.AppRuntime;
import mqq.app.MobileQQ;

public class DBFixConfigActivity
  extends AppActivity
{
  public static String a = "DBFix";
  public static int f = 2;
  RadioGroup b;
  RadioButton c;
  RadioButton d;
  Button e;
  CheckBox g;
  CheckBox h;
  Button i;
  Runnable j = new DBFixConfigActivity.11(this);
  
  private void a()
  {
    EditText localEditText = (EditText)super.findViewById(2131432619);
    super.findViewById(2131430674).setOnClickListener(new DBFixConfigActivity.7(this, localEditText));
  }
  
  private void b()
  {
    super.findViewById(2131429851).setOnClickListener(new DBFixConfigActivity.8(this));
  }
  
  private void c()
  {
    EditText localEditText = (EditText)super.findViewById(2131432619);
    super.findViewById(2131442921).setOnClickListener(new DBFixConfigActivity.9(this, localEditText));
  }
  
  private void d()
  {
    super.findViewById(2131445894).setOnClickListener(new DBFixConfigActivity.10(this));
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    super.setContentView(2131625294);
    paramBundle = getAppRuntime();
    String str = paramBundle.getAccount();
    this.b = ((RadioGroup)super.findViewById(2131430688));
    this.b.setOnCheckedChangeListener(new DBFixConfigActivity.1(this, paramBundle, str));
    this.c = ((RadioButton)super.findViewById(2131432266));
    this.d = ((RadioButton)super.findViewById(2131431642));
    SharedPreferences localSharedPreferences = paramBundle.getApplication().getSharedPreferences(DBFixManager.d, 0);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append(DBFixManager.e);
    f = localSharedPreferences.getInt(localStringBuilder.toString(), 2);
    if (f == 2)
    {
      this.c.setChecked(false);
      this.d.setChecked(true);
    }
    else
    {
      this.c.setChecked(true);
      this.d.setChecked(false);
    }
    this.e = ((Button)super.findViewById(2131450250));
    this.e.setOnClickListener(new DBFixConfigActivity.2(this));
    ((Button)super.findViewById(2131431419)).setOnClickListener(new DBFixConfigActivity.3(this, str));
    this.g = ((CheckBox)super.findViewById(2131437772));
    this.g.setChecked(true);
    this.g.setOnCheckedChangeListener(new DBFixConfigActivity.4(this, paramBundle));
    this.h = ((CheckBox)super.findViewById(2131430233));
    this.h.setChecked(true);
    this.h.setOnCheckedChangeListener(new DBFixConfigActivity.5(this, paramBundle));
    this.i = ((Button)super.findViewById(2131440636));
    this.i.setOnClickListener(new DBFixConfigActivity.6(this));
    d();
    b();
    c();
    a();
    return true;
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.database.corrupt.DBFixConfigActivity
 * JD-Core Version:    0.7.0.1
 */