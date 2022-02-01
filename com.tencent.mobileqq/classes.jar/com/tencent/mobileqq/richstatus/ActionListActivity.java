package com.tencent.mobileqq.richstatus;

import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.os.Bundle;
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
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.IphoneTitleBarActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.StatableBitmapDrawable;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.ArrayList;

public class ActionListActivity
  extends IphoneTitleBarActivity
  implements View.OnClickListener, TabHost.OnTabChangeListener, ViewPager.OnPageChangeListener, IActionListener, IIconListener
{
  static final boolean jdField_a_of_type_Boolean = AppSetting.d;
  private int jdField_a_of_type_Int;
  private Intent jdField_a_of_type_AndroidContentIntent;
  TabHost jdField_a_of_type_AndroidWidgetTabHost;
  TabWidget jdField_a_of_type_AndroidWidgetTabWidget;
  ViewPager jdField_a_of_type_AndroidxViewpagerWidgetViewPager;
  private StatusManager jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager;
  ArrayList<StateTag> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  
  private void a()
  {
    int i = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this.jdField_a_of_type_JavaUtilArrayList);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ActionListActivity.initData(), state tag size: ");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaUtilArrayList.size());
      ((StringBuilder)localObject).append(" result: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("Q.richstatus.", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 100)
    {
      this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(i);
      if ((this.jdField_a_of_type_Int == -1) && ((i == 102) || (NetworkUtil.isNetSupport(this)))) {
        startTitleProgress();
      }
    }
    i = getResources().getDisplayMetrics().widthPixels;
    Object localObject = this.jdField_a_of_type_JavaUtilArrayList;
    int j = 0;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.jdField_a_of_type_AndroidWidgetTabWidget.removeAllViews();
      localObject = getLayoutInflater();
      k = this.jdField_a_of_type_JavaUtilArrayList.size();
      int m = i / k;
      i = 0;
      while (i < k)
      {
        StateTag localStateTag = (StateTag)this.jdField_a_of_type_JavaUtilArrayList.get(i);
        TextView localTextView = (TextView)((LayoutInflater)localObject).inflate(2131561117, this.jdField_a_of_type_AndroidWidgetTabWidget, false);
        localTextView.setText(localStateTag.a);
        localTextView.setWidth(m);
        localTextView.setGravity(17);
        TabHost localTabHost = this.jdField_a_of_type_AndroidWidgetTabHost;
        localTabHost.addTab(localTabHost.newTabSpec(localStateTag.a).setIndicator(localTextView).setContent(2131361815));
        i += 1;
      }
    }
    ((ActionListActivity.ViewPagerAdapter)this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getAdapter()).a();
    int k = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getChildCount();
    i = j;
    while (i < k)
    {
      ((ActionListActivity.GridAdapter)((GridView)this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getChildAt(i)).getAdapter()).notifyDataSetChanged();
      i += 1;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("ActionListActivity.onGetActions(), result: ");
      localStringBuilder.append(paramInt1);
      localStringBuilder.append(" message: ");
      localStringBuilder.append(paramInt2);
      QLog.d("Q.richstatus.", 2, localStringBuilder.toString());
    }
    if (paramInt1 == 102) {
      a();
    }
    stopTitleProgress();
  }
  
  void a(int paramInt, Bitmap paramBitmap)
  {
    int k = this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getChildCount();
    int i = 0;
    while (i < k)
    {
      GridView localGridView = (GridView)this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.getChildAt(i);
      int m = localGridView.getChildCount();
      int j = 0;
      while (j < m)
      {
        ActionListActivity.ActionViewHolder localActionViewHolder = (ActionListActivity.ActionViewHolder)localGridView.getChildAt(j).getTag();
        if ((localActionViewHolder != null) && (localActionViewHolder.jdField_a_of_type_Int == paramInt)) {
          localActionViewHolder.jdField_a_of_type_AndroidWidgetImageView.setImageDrawable(new StatableBitmapDrawable(getResources(), paramBitmap, false, false));
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
  
  protected void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    if ((paramInt1 == 0) && (paramInt2 == -1))
    {
      Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
      if (localIntent == null) {
        this.jdField_a_of_type_AndroidContentIntent = paramIntent;
      } else {
        localIntent.putExtras(paramIntent);
      }
      setResult(-1, this.jdField_a_of_type_AndroidContentIntent);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131558464);
    this.jdField_a_of_type_AndroidWidgetTabHost = ((TabHost)findViewById(2131378228));
    this.jdField_a_of_type_AndroidWidgetTabHost.setup();
    this.jdField_a_of_type_AndroidWidgetTabHost.setOnTabChangedListener(this);
    this.jdField_a_of_type_AndroidWidgetTabWidget = this.jdField_a_of_type_AndroidWidgetTabHost.getTabWidget();
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager = ((MyViewPager)findViewById(2131380851));
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setOnPageChangeListener(this);
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setAdapter(new ActionListActivity.ViewPagerAdapter(this, null));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager = ((StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(this);
    this.jdField_a_of_type_Int = getIntent().getIntExtra("k_action_id", -1);
    int i = this.jdField_a_of_type_Int;
    Object localObject;
    if (i == -1)
    {
      setTitle(HardCodeUtil.a(2131699983));
      this.leftView.setVisibility(8);
      setRightButton(2131690874, this);
    }
    else
    {
      localObject = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(i);
      if (localObject != null) {
        setTitle(((ActionInfo)localObject).c);
      } else {
        setTitle(HardCodeUtil.a(2131699980));
      }
    }
    if (jdField_a_of_type_Boolean)
    {
      localObject = this.leftView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.leftView.getText());
      localStringBuilder.append(HardCodeUtil.a(2131699982));
      ((TextView)localObject).setContentDescription(localStringBuilder.toString());
      localObject = this.rightViewText;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131690874));
      localStringBuilder.append(HardCodeUtil.a(2131699981));
      ((TextView)localObject).setContentDescription(localStringBuilder.toString());
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
  }
  
  protected void doOnDestroy()
  {
    this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.b(this);
    super.doOnDestroy();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    Intent localIntent = this.jdField_a_of_type_AndroidContentIntent;
    if (localIntent != null)
    {
      paramBundle.putLong("k_action_id", localIntent.getLongExtra("k_action_id", 0L));
      paramBundle.putString("k_action_text", this.jdField_a_of_type_AndroidContentIntent.getStringExtra("k_action_text"));
    }
    super.doOnSaveInstanceState(paramBundle);
  }
  
  public void finish()
  {
    super.finish();
    if (this.jdField_a_of_type_Int == -1) {
      overridePendingTransition(0, 2130771992);
    }
  }
  
  protected boolean isWrapContent()
  {
    return false;
  }
  
  public void onClick(View paramView)
  {
    if (paramView == this.rightViewText)
    {
      finish();
    }
    else
    {
      Object localObject1 = paramView.getTag();
      if ((localObject1 != null) && ((localObject1 instanceof ActionListActivity.ActionViewHolder)))
      {
        localObject1 = (ActionListActivity.ActionViewHolder)localObject1;
        ActionInfo localActionInfo = this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(((ActionListActivity.ActionViewHolder)localObject1).jdField_a_of_type_Int);
        if (localActionInfo != null)
        {
          Intent localIntent2 = new Intent();
          localIntent2.putExtra("k_action_id", localActionInfo.jdField_a_of_type_Int);
          localIntent2.putExtra("k_action_text", localActionInfo.d);
          if (localActionInfo.b == 1)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8006988", "0X8006988", 0, 0, Integer.toString(localActionInfo.jdField_a_of_type_Int), "", "", "");
            setResult(-1, localIntent2);
            finish();
          }
          else if (localActionInfo.b != 0)
          {
            try
            {
              int i = localActionInfo.b;
              Object localObject2;
              if (i != 2)
              {
                Intent localIntent1;
                if (i != 3) {
                  if (i != 4)
                  {
                    if (i != 5) {
                      break label374;
                    }
                    localIntent1 = new Intent(this, Class.forName(localActionInfo.h));
                    localObject2 = localIntent1;
                  }
                }
                try
                {
                  localIntent1.putExtra("param_plugin_gesturelock", true);
                  localObject2 = localIntent1;
                  localObject1 = localIntent1;
                  if (localActionInfo.i == null) {
                    break label394;
                  }
                  localObject2 = localIntent1;
                  localIntent1.putExtra("key_params_qq", this.jdField_a_of_type_ComTencentMobileqqRichstatusStatusManager.a(localActionInfo.i, localActionInfo.jdField_a_of_type_Int, 0, ""));
                  localObject1 = localIntent1;
                }
                catch (Exception localException2)
                {
                  localObject1 = localObject2;
                  break label383;
                }
                localObject2 = localActionInfo.e.replace("$A", this.app.getCurrentAccountUin());
                localObject1 = new Intent(this, ActionUrlActivity.class);
                try
                {
                  ((Intent)localObject1).putExtra("key_params_qq", (String)localObject2);
                }
                catch (Exception localException1)
                {
                  break label383;
                }
                localObject1 = new Intent(this, ActionListActivity.class);
                localObject2 = localObject1;
                ((Intent)localObject1).putExtra("k_action_id", localActionInfo.jdField_a_of_type_Int);
                break label394;
              }
              label374:
              localObject1 = null;
            }
            catch (Exception localException3)
            {
              localObject1 = null;
              label383:
              QLog.e("Q.richstatus.", 1, "", localException3);
            }
            label394:
            if (localObject1 != null)
            {
              this.jdField_a_of_type_AndroidContentIntent = localIntent2;
              startActivityForResult((Intent)localObject1, 0);
            }
          }
        }
      }
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public void onGetIcon(int paramInt1, int paramInt2, Bitmap paramBitmap)
  {
    if ((paramBitmap != null) && (paramInt2 == 201)) {
      a(paramInt1, paramBitmap);
    }
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
    while ((i < this.jdField_a_of_type_JavaUtilArrayList.size()) && (!paramString.equals(((StateTag)this.jdField_a_of_type_JavaUtilArrayList.get(i)).a))) {
      i += 1;
    }
    this.jdField_a_of_type_AndroidxViewpagerWidgetViewPager.setCurrentItem(i, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionListActivity
 * JD-Core Version:    0.7.0.1
 */