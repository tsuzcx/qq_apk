package com.tencent.mobileqq.richstatus;

import alud;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;
import android.widget.TabHost.TabSpec;
import android.widget.TabWidget;
import android.widget.TextView;
import ayay;
import ayba;
import aybb;
import aybc;
import aybp;
import aybr;
import aydz;
import ayec;
import azqs;
import bdin;
import bety;
import bevq;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.SplashDialogWrapper;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqreader.QRBridgeActivity;
import java.util.ArrayList;

public class ActionListActivity
  extends IphoneTitleBarActivity
  implements ViewPager.OnPageChangeListener, View.OnClickListener, TabHost.OnTabChangeListener, aybp, aybr
{
  static final boolean jdField_a_of_type_Boolean = AppSetting.c;
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  ViewPager jdField_a_of_type_AndroidSupportV4ViewViewPager;
  TabHost jdField_a_of_type_AndroidWidgetTabHost;
  TabWidget jdField_a_of_type_AndroidWidgetTabWidget;
  private ayec jdField_a_of_type_Ayec;
  public ArrayList<aydz> a;
  
  public ActionListActivity()
  {
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  }
  
  private void a()
  {
    int i = this.jdField_a_of_type_Ayec.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.", 2, "ActionListActivity.initData(), state tag size: " + this.jdField_a_of_type_JavaUtilArrayList.size() + " result: " + i);
    }
    if (i != 100)
    {
      this.jdField_a_of_type_Ayec.a(i);
      if ((this.jdField_a_of_type_Int == -1) && ((i == 102) || (bdin.d(this)))) {
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
        aydz localaydz = (aydz)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        TextView localTextView = (TextView)localLayoutInflater.inflate(2131560992, this.jdField_a_of_type_AndroidWidgetTabWidget, false);
        localTextView.setText(localaydz.a);
        localTextView.setWidth(k);
        localTextView.setGravity(17);
        this.jdField_a_of_type_AndroidWidgetTabHost.addTab(this.jdField_a_of_type_AndroidWidgetTabHost.newTabSpec(localaydz.a).setIndicator(localTextView).setContent(2131361807));
        i += 1;
      }
    }
    ((aybc)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getAdapter()).a();
    int j = this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildCount();
    i = 0;
    while (i < j)
    {
      ((aybb)((GridView)this.jdField_a_of_type_AndroidSupportV4ViewViewPager.getChildAt(i)).getAdapter()).notifyDataSetChanged();
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
        ayba localayba = (ayba)localGridView.getChildAt(j).getTag();
        if ((localayba != null) && (localayba.jdField_a_of_type_Int == paramInt)) {
          localayba.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new bevq(getResources(), paramBitmap, false, false));
        }
        j += 1;
      }
      i += 1;
    }
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
    setContentView(2131558430);
    this.jdField_a_of_type_AndroidWidgetTabHost = ((TabHost)findViewById(2131377374));
    this.jdField_a_of_type_AndroidWidgetTabHost.setup();
    this.jdField_a_of_type_AndroidWidgetTabHost.setOnTabChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTabWidget = this.jdField_a_of_type_AndroidWidgetTabHost.getTabWidget();
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager = ((MyViewPager)findViewById(2131379940));
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setAdapter(new aybc(this, null));
    this.jdField_a_of_type_Ayec = ((ayec)this.app.getManager(15));
    this.jdField_a_of_type_Ayec.a(this);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("k_action_id", -1);
    if (this.jdField_a_of_type_Int == -1)
    {
      setTitle(alud.a(2131700145));
      this.leftView.setVisibility(8);
      setRightButton(2131690885, this);
    }
    for (;;)
    {
      if (jdField_a_of_type_Boolean)
      {
        this.leftView.setContentDescription(this.leftView.getText() + alud.a(2131700144));
        this.rightViewText.setContentDescription(getResources().getString(2131690885) + alud.a(2131700143));
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
      ayay localayay = this.jdField_a_of_type_Ayec.a(this.jdField_a_of_type_Int);
      if (localayay != null) {
        setTitle(localayay.c);
      } else {
        setTitle(alud.a(2131700142));
      }
    }
  }
  
  public void doOnDestroy()
  {
    this.jdField_a_of_type_Ayec.b(this);
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
    ayay localayay;
    Intent localIntent;
    do
    {
      do
      {
        do
        {
          return;
          paramView = paramView.getTag();
        } while ((paramView == null) || (!(paramView instanceof ayba)));
        paramView = (ayba)paramView;
        localayay = this.jdField_a_of_type_Ayec.a(paramView.jdField_a_of_type_Int);
      } while (localayay == null);
      localIntent = new Intent();
      localIntent.putExtra("k_action_id", localayay.jdField_a_of_type_Int);
      localIntent.putExtra("k_action_text", localayay.d);
      if (localayay.b == 1)
      {
        azqs.b(this.app, "CliOper", "", "", "0X8006988", "0X8006988", 0, 0, Integer.toString(localayay.jdField_a_of_type_Int), "", "", "");
        setResult(-1, localIntent);
        finish();
        return;
      }
    } while (localayay.b == 0);
    for (;;)
    {
      try
      {
        int i = localayay.b;
        switch (i)
        {
        default: 
          paramView = null;
        }
      }
      catch (Exception localException3)
      {
        try
        {
          paramView.putExtra("param_plugin_gesturelock", true);
          if (localException2.i != null) {
            paramView.putExtra("key_params_qq", this.jdField_a_of_type_Ayec.a(localException2.i, localException2.jdField_a_of_type_Int, 0, ""));
          }
          if (!QRBridgeActivity.jdField_a_of_type_Boolean) {
            continue;
          }
          if (!QRBridgeActivity.b)
          {
            bety localbety = new bety(this, getTitleBarHeight());
            localbety.a(alud.a(2131700141));
            new SplashDialogWrapper(this, localbety, alud.a(2131700140), "qqreaderplugin.apk", true, 10000).show();
            QRBridgeActivity.b = true;
          }
        }
        catch (Exception localException4) {}
        localException3 = localException3;
        paramView = null;
        continue;
        continue;
      }
      if (paramView == null) {
        break;
      }
      this.jdField_a_of_type_AndroidContentIntent = localIntent;
      startActivityForResult(paramView, 0);
      return;
      paramView = new Intent(this, ActionListActivity.class);
      try
      {
        paramView.putExtra("k_action_id", localayay.jdField_a_of_type_Int);
      }
      catch (Exception localException1) {}
    }
    for (;;)
    {
      for (;;)
      {
        QLog.e("Q.richstatus.", 1, "", localException1);
        break;
        paramView = null;
        break;
        String str = localException1.e.replace("$A", this.app.getCurrentAccountUin());
        paramView = new Intent(this, ActionUrlActivity.class);
        try
        {
          paramView.putExtra("key_params_qq", str);
        }
        catch (Exception localException2) {}
      }
    }
    localException2.h = localException2.h.replace("com.qqreader.QRBridgeActivity", "cooperation.qqreader.QRBridgeActivity");
    paramView = new Intent(this, Class.forName(localException2.h));
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
      if ((i >= this.jdField_a_of_type_JavaUtilArrayList.size()) || (paramString.equals(((aydz)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a)))
      {
        this.jdField_a_of_type_AndroidSupportV4ViewViewPager.setCurrentItem(i, false);
        return;
      }
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionListActivity
 * JD-Core Version:    0.7.0.1
 */