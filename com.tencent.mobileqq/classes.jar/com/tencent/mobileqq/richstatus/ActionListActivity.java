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
  static final boolean e = AppSetting.e;
  TabHost a;
  TabWidget b;
  ViewPager c;
  ArrayList<StateTag> d = new ArrayList();
  private StatusManager f;
  private int g;
  private Intent h;
  
  private void a()
  {
    int i = this.f.a(this.d);
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("ActionListActivity.initData(), state tag size: ");
      ((StringBuilder)localObject).append(this.d.size());
      ((StringBuilder)localObject).append(" result: ");
      ((StringBuilder)localObject).append(i);
      QLog.d("Q.richstatus.", 2, ((StringBuilder)localObject).toString());
    }
    if (i != 100)
    {
      this.f.b(i);
      if ((this.g == -1) && ((i == 102) || (NetworkUtil.isNetSupport(this)))) {
        startTitleProgress();
      }
    }
    i = getResources().getDisplayMetrics().widthPixels;
    Object localObject = this.d;
    int j = 0;
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      this.b.removeAllViews();
      localObject = getLayoutInflater();
      k = this.d.size();
      int m = i / k;
      i = 0;
      while (i < k)
      {
        StateTag localStateTag = (StateTag)this.d.get(i);
        TextView localTextView = (TextView)((LayoutInflater)localObject).inflate(2131627467, this.b, false);
        localTextView.setText(localStateTag.a);
        localTextView.setWidth(m);
        localTextView.setGravity(17);
        TabHost localTabHost = this.a;
        localTabHost.addTab(localTabHost.newTabSpec(localStateTag.a).setIndicator(localTextView).setContent(2131427367));
        i += 1;
      }
    }
    ((ActionListActivity.ViewPagerAdapter)this.c.getAdapter()).a();
    int k = this.c.getChildCount();
    i = j;
    while (i < k)
    {
      ((ActionListActivity.GridAdapter)((GridView)this.c.getChildAt(i)).getAdapter()).notifyDataSetChanged();
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
    int k = this.c.getChildCount();
    int i = 0;
    while (i < k)
    {
      GridView localGridView = (GridView)this.c.getChildAt(i);
      int m = localGridView.getChildCount();
      int j = 0;
      while (j < m)
      {
        ActionListActivity.ActionViewHolder localActionViewHolder = (ActionListActivity.ActionViewHolder)localGridView.getChildAt(j).getTag();
        if ((localActionViewHolder != null) && (localActionViewHolder.c == paramInt)) {
          localActionViewHolder.a.setImageDrawable(new StatableBitmapDrawable(getResources(), paramBitmap, false, false));
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
      Intent localIntent = this.h;
      if (localIntent == null) {
        this.h = paramIntent;
      } else {
        localIntent.putExtras(paramIntent);
      }
      setResult(-1, this.h);
      finish();
    }
  }
  
  protected boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    setContentView(2131624001);
    this.a = ((TabHost)findViewById(2131446746));
    this.a.setup();
    this.a.setOnTabChangedListener(this);
    this.b = this.a.getTabWidget();
    this.c = ((MyViewPager)findViewById(2131449829));
    this.c.setOnPageChangeListener(this);
    this.c.setAdapter(new ActionListActivity.ViewPagerAdapter(this, null));
    this.f = ((StatusManager)this.app.getManager(QQManagerFactory.STATUS_MANAGER));
    this.f.a(this);
    this.g = getIntent().getIntExtra("k_action_id", -1);
    int i = this.g;
    Object localObject;
    if (i == -1)
    {
      setTitle(HardCodeUtil.a(2131898029));
      this.leftView.setVisibility(8);
      setRightButton(2131887812, this);
    }
    else
    {
      localObject = this.f.a(i);
      if (localObject != null) {
        setTitle(((ActionInfo)localObject).e);
      } else {
        setTitle(HardCodeUtil.a(2131898026));
      }
    }
    if (e)
    {
      localObject = this.leftView;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.leftView.getText());
      localStringBuilder.append(HardCodeUtil.a(2131898028));
      ((TextView)localObject).setContentDescription(localStringBuilder.toString());
      localObject = this.rightViewText;
      localStringBuilder = new StringBuilder();
      localStringBuilder.append(getResources().getString(2131887812));
      localStringBuilder.append(HardCodeUtil.a(2131898027));
      ((TextView)localObject).setContentDescription(localStringBuilder.toString());
    }
    a();
    if (this.b.getChildCount() > 0)
    {
      this.b.setCurrentTab(0);
      this.b.focusCurrentTab(0);
    }
    if (paramBundle != null)
    {
      this.h = new Intent();
      this.h.putExtra("k_action_id", paramBundle.getLong("k_action_id", 0L));
      this.h.putExtra("k_action_text", paramBundle.getString("k_action_text"));
    }
    return true;
  }
  
  protected void doOnDestroy()
  {
    this.f.b(this);
    super.doOnDestroy();
  }
  
  protected void doOnSaveInstanceState(Bundle paramBundle)
  {
    Intent localIntent = this.h;
    if (localIntent != null)
    {
      paramBundle.putLong("k_action_id", localIntent.getLongExtra("k_action_id", 0L));
      paramBundle.putString("k_action_text", this.h.getStringExtra("k_action_text"));
    }
    super.doOnSaveInstanceState(paramBundle);
  }
  
  public void finish()
  {
    super.finish();
    if (this.g == -1) {
      overridePendingTransition(0, 2130771995);
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
        ActionInfo localActionInfo = this.f.a(((ActionListActivity.ActionViewHolder)localObject1).c);
        if (localActionInfo != null)
        {
          Intent localIntent2 = new Intent();
          localIntent2.putExtra("k_action_id", localActionInfo.b);
          localIntent2.putExtra("k_action_text", localActionInfo.f);
          if (localActionInfo.g == 1)
          {
            ReportController.b(this.app, "CliOper", "", "", "0X8006988", "0X8006988", 0, 0, Integer.toString(localActionInfo.b), "", "", "");
            setResult(-1, localIntent2);
            finish();
          }
          else if (localActionInfo.g != 0)
          {
            try
            {
              int i = localActionInfo.g;
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
                    localIntent1 = new Intent(this, Class.forName(localActionInfo.l));
                    localObject2 = localIntent1;
                  }
                }
                try
                {
                  localIntent1.putExtra("param_plugin_gesturelock", true);
                  localObject2 = localIntent1;
                  localObject1 = localIntent1;
                  if (localActionInfo.m == null) {
                    break label394;
                  }
                  localObject2 = localIntent1;
                  localIntent1.putExtra("key_params_qq", this.f.a(localActionInfo.m, localActionInfo.b, 0, ""));
                  localObject1 = localIntent1;
                }
                catch (Exception localException2)
                {
                  localObject1 = localObject2;
                  break label383;
                }
                localObject2 = localActionInfo.h.replace("$A", this.app.getCurrentAccountUin());
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
                ((Intent)localObject1).putExtra("k_action_id", localActionInfo.b);
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
              this.h = localIntent2;
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
    this.a.setCurrentTab(paramInt);
  }
  
  public void onTabChanged(String paramString)
  {
    int i = 0;
    while ((i < this.d.size()) && (!paramString.equals(((StateTag)this.d.get(i)).a))) {
      i += 1;
    }
    this.c.setCurrentItem(i, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.ActionListActivity
 * JD-Core Version:    0.7.0.1
 */