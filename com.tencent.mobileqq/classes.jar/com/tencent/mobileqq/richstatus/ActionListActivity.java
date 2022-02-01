package com.tencent.mobileqq.richstatus;

import Override;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import anvx;
import bbsk;
import bbsm;
import bbsn;
import bbso;
import bbtb;
import bbtd;
import bbvk;
import bbvn;
import bdla;
import bisl;
import bity;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import cooperation.qqreader.QRBridgeActivity;
import java.util.ArrayList;

public class ActionListActivity
  extends IphoneTitleBarActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, TabHost.OnTabChangeListener, bbtb, bbtd
{
  static final boolean jdField_a_of_type_Boolean = AppSetting.c;
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  TabHost jdField_a_of_type_AndroidWidgetTabHost;
  TabWidget jdField_a_of_type_AndroidWidgetTabWidget;
  private bbvn jdField_a_of_type_Bbvn;
  public ArrayList<bbvk> a;
  
  public ActionListActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Bbvn.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "ActionListActivity.initData(), state tag size: " + this.jdField_a_of_type_JavaUtilArrayList.size() + " result: " + i);
    }
    if (i != 100)
    {
      this.jdField_a_of_type_Bbvn.a(i);
      if ((this.jdField_a_of_type_Int == -1) && ((i == 102) || (NetworkUtil.isNetSupport(this)))) {
        startTitleProgress();
      }
    }
    i = getResources().getDisplayMetrics().widthPixels;
    if ((this.jdField_a_of_type_JavaUtilArrayList != null) && (this.jdField_a_of_type_JavaUtilArrayList.size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetTabWidget.removeAllViews();
      LayoutInflater localLayoutInflater = getLayoutInflater();
      j = this.jdField_a_of_type_JavaUtilArrayList.size();
      int k = i / j;
      i = 0;
      while (i < j)
      {
        bbvk localbbvk = (bbvk)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131561173, this.jdField_a_of_type_AndroidWidgetTabWidget, false);
        localTextView.setText(localbbvk.a);
        localTextView.setWidth(k);
        localTextView.setGravity(17);
        this.jdField_a_of_type_AndroidWidgetTabHost.addTab(this.jdField_a_of_type_AndroidWidgetTabHost.newTabSpec(localbbvk.a).setIndicator(localTextView).setContent(2131361810));
        i += 1;
      }
    }
    ((bbso)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a();
    int j = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount();
    i = 0;
    while (i < j)
    {
      ((bbsn)((GridView)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(i)).getAdapter()).notifyDataSetChanged();
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "ActionListActivity.onGetActions(), result: " + paramInt1 + " message: " + paramInt2);
    }
    if (paramInt1 == 102) {
      a();
    }
    stopTitleProgress();
  }
  
  public void a(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramInt2 == 201)) {
      a(paramInt1, paramBitmap);
    }
  }
  
  void a(int paramInt, Bitmap paramBitmap)
  {
    int k = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount();
    int i = 0;
    while (i < k)
    {
      GridView localGridView = (GridView)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(i);
      int m = localGridView.getChildCount();
      int j = 0;
      while (j < m)
      {
        bbsm localbbsm = (bbsm)localGridView.getChildAt(j).getTag();
        if ((localbbsm != null) && (localbbsm.jdField_a_of_type_Int == paramInt)) {
          localbbsm.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new bity(getResources(), paramBitmap, false, false));
        }
        j += 1;
      }
      i += 1;
    }
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      if (this.jdField_a_of_type_AndroidContentIntent != null) {
        break label35;
      }
      this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    }
    for (;;)
    {
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
      return;
      label35:
      this.jdField_a_of_type_AndroidContentIntent.putExtras(paramIntent);
    }
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558436);
    this.jdField_a_of_type_AndroidWidgetTabHost = ((TabHost)findViewById(2131378411));
    this.jdField_a_of_type_AndroidWidgetTabHost.setup();
    this.jdField_a_of_type_AndroidWidgetTabHost.setOnTabChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTabWidget = this.jdField_a_of_type_AndroidWidgetTabHost.getTabWidget();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((MyViewPager)findViewById(2131381152));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(new bbso(this, null));
    this.jdField_a_of_type_Bbvn = ((bbvn)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_Bbvn.a(this);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("k_action_id", -1);
    if (this.jdField_a_of_type_Int == -1)
    {
      setTitle(anvx.a(2131699264));
      this.leftView.setVisibility(8);
      setRightButton(2131690845, this);
    }
    for (;;)
    {
      if (jdField_a_of_type_Boolean)
      {
        this.leftView.setContentDescription(this.leftView.getText() + anvx.a(2131699263));
        this.rightViewText.setContentDescription(getResources().getString(2131690845) + anvx.a(2131699262));
      }
      a();
      if (this.jdField_a_of_type_AndroidWidgetTabWidget.getChildCount() > 0)
      {
        this.jdField_a_of_type_AndroidWidgetTabWidget.setCurrentTab(0);
        this.jdField_a_of_type_AndroidWidgetTabWidget.focusCurrentTab(0);
      }
      if (paramBundle != null)
      {
        this.jdField_a_of_type_AndroidContentIntent = new Intent();
        this.jdField_a_of_type_AndroidContentIntent.putExtra("k_action_id", paramBundle.getLong("k_action_id", 0L));
        this.jdField_a_of_type_AndroidContentIntent.putExtra("k_action_text", paramBundle.getString("k_action_text"));
      }
      return true;
      bbsk localbbsk = this.jdField_a_of_type_Bbvn.a(this.jdField_a_of_type_Int);
      if (localbbsk != null) {
        setTitle(localbbsk.c);
      } else {
        setTitle(anvx.a(2131699261));
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Bbvn.b(this);
    super.doOnDestroy();
  }
  
  public void doOnSaveInstanceState(Bundle paramBundle)
  {
    if (this.jdField_a_of_type_AndroidContentIntent != null)
    {
      paramBundle.putLong("k_action_id", this.jdField_a_of_type_AndroidContentIntent.getLongExtra("k_action_id", 0L));
      paramBundle.putString("k_action_text", this.jdField_a_of_type_AndroidContentIntent.getStringExtra("k_action_text"));
    }
    super.doOnSaveInstanceState(paramBundle);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Int == -1) {
      overridePendingTransition(0, 2130771978);
    }
  }
  
  public boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText) {
      finish();
    }
    bbsk localbbsk;
    Intent localIntent;
    do
    {
      for (;;)
      {
        EventCollector.getInstance().onViewClicked(paramView);
        return;
        localObject = paramView.getTag();
        if ((localObject == null) || ((localObject instanceof bbsm)))
        {
          localObject = (bbsm)localObject;
          localbbsk = this.jdField_a_of_type_Bbvn.a(((bbsm)localObject).jdField_a_of_type_Int);
          if (localbbsk != null)
          {
            localIntent = new Intent();
            localIntent.putExtra("k_action_id", localbbsk.jdField_a_of_type_Int);
            localIntent.putExtra("k_action_text", localbbsk.d);
            if (localbbsk.b != 1) {
              break;
            }
            bdla.b(this.app, "CliOper", "", "", "0X8006988", "0X8006988", 0, 0, Integer.toString(localbbsk.jdField_a_of_type_Int), "", "", "");
            setResult(-1, localIntent);
            finish();
          }
        }
      }
    } while (localbbsk.b == 0);
    for (;;)
    {
      try
      {
        int i = localbbsk.b;
        switch (i)
        {
        default: 
          localObject = null;
        }
      }
      catch (Exception localException3)
      {
        try
        {
          ((Intent)localObject).putExtra("param_plugin_gesturelock", true);
          if (localException2.i != null) {
            ((Intent)localObject).putExtra("key_params_qq", this.jdField_a_of_type_Bbvn.a(localException2.i, localException2.jdField_a_of_type_Int, 0, ""));
          }
          if (!QRBridgeActivity.jdField_a_of_type_Boolean) {
            continue;
          }
          if (!QRBridgeActivity.b)
          {
            bisl localbisl = new bisl(this, getTitleBarHeight());
            localbisl.a(anvx.a(2131699260));
            new SplashDialogWrapper(this, localbisl, anvx.a(2131699259), "qqreaderplugin.apk", true, 10000).show();
            QRBridgeActivity.b = true;
          }
        }
        catch (Exception localException4) {}
        localException3 = localException3;
        localObject = null;
        continue;
        continue;
      }
      if (localObject == null) {
        break;
      }
      this.jdField_a_of_type_AndroidContentIntent = localIntent;
      startActivityForResult((Intent)localObject, 0);
      break;
      localObject = new Intent(this, ActionListActivity.class);
      try
      {
        ((Intent)localObject).putExtra("k_action_id", localbbsk.jdField_a_of_type_Int);
      }
      catch (Exception localException1) {}
    }
    for (;;)
    {
      for (;;)
      {
        QLog.e("Q.richstatus.", 1, "", localException1);
        break;
        localObject = null;
        break;
        String str = localException1.e.replace("$A", this.app.getCurrentAccountUin());
        localObject = new Intent(this, ActionUrlActivity.class);
        try
        {
          ((Intent)localObject).putExtra("key_params_qq", str);
        }
        catch (Exception localException2) {}
      }
    }
    localException2.h = localException2.h.replace("com.qqreader.QRBridgeActivity", "cooperation.qqreader.QRBridgeActivity");
    localObject = new Intent(this, Class.forName(localException2.h));
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onPageScrollStateChanged(int paramInt) {}
  
  public void onPageScrolled(int paramInt1, float paramFloat, int paramInt2) {}
  
  public void onPageSelected(int paramInt)
  {
    this.jdField_a_of_type_AndroidWidgetTabHost.setCurrentTab(paramInt);
  }
  
  public void onTabChanged(String paramString)
  {
    int i = 0;
    for (;;)
    {
      if ((i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (paramString.equals(((bbvk)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a)))
      {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i, false);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionListActivity
 * JD-Core Version:    0.7.0.1
 */