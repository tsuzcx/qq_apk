package com.tencent.weui.base.preference;

import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.preference.Preference;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.AbsListView.LayoutParams;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.mm.ui.BaseActivity;
import com.tencent.mm.ui.f;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public abstract class WeUIPreference
  extends BaseActivity
{
  private c a;
  private ListView b;
  private SharedPreferences c;
  private boolean d = false;
  protected RelativeLayout e;
  protected TextView f;
  protected ImageView g;
  private boolean h = false;
  
  protected boolean a()
  {
    return true;
  }
  
  protected void b() {}
  
  public c createAdapter(SharedPreferences paramSharedPreferences)
  {
    return new c(this, paramSharedPreferences);
  }
  
  public void createUI()
  {
    this.b.setAdapter(this.a);
  }
  
  public boolean dirty()
  {
    return this.d;
  }
  
  @Override
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, false, true);
    boolean bool = super.dispatchTouchEvent(paramMotionEvent);
    EventCollector.getInstance().onActivityDispatchTouchEvent(this, paramMotionEvent, bool, false);
    return bool;
  }
  
  public View getBottomView()
  {
    return null;
  }
  
  public SharedPreferences getDefaultSharedPreferences()
  {
    return this.c;
  }
  
  public int getFooterResourceId()
  {
    return -1;
  }
  
  public View getFooterView()
  {
    return null;
  }
  
  public int getHeaderResourceId()
  {
    return -1;
  }
  
  public View getHeaderView()
  {
    return null;
  }
  
  protected int getLayoutId()
  {
    return 2131625456;
  }
  
  public ListView getListView()
  {
    return this.b;
  }
  
  public IPreferenceScreen getPreferenceScreen()
  {
    return this.a;
  }
  
  public abstract int getResourceId();
  
  @Override
  public void onConfigurationChanged(Configuration paramConfiguration)
  {
    super.onConfigurationChanged(paramConfiguration);
    EventCollector.getInstance().onActivityConfigurationChanged(this, paramConfiguration);
  }
  
  public boolean onContextItemSelected(MenuItem paramMenuItem)
  {
    return super.onContextItemSelected(paramMenuItem);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    paramBundle = new StringBuilder();
    paramBundle.append(getPackageName());
    paramBundle.append("_preferences");
    this.c = getSharedPreferences(paramBundle.toString(), 0);
    this.a = createAdapter(this.c);
    this.b = ((ListView)findViewById(16908298));
    this.e = ((RelativeLayout)findViewById(2131440593));
    this.f = ((TextView)findViewById(2131440592));
    this.g = ((ImageView)findViewById(2131440591));
    b();
    int i = getHeaderResourceId();
    paramBundle = getHeaderView();
    if (i != -1)
    {
      paramBundle = getLayoutInflater().inflate(i, null);
      this.b.addHeaderView(paramBundle);
    }
    else if (paramBundle != null)
    {
      if (paramBundle.getLayoutParams() != null) {
        paramBundle.setLayoutParams(new AbsListView.LayoutParams(paramBundle.getLayoutParams()));
      } else {
        f.e("MicroMsg.mmui.WeUIPreference", "[arthurdan.mmpreference] Notice!!! header.getLayoutParams() is null!!!\n", new Object[0]);
      }
      this.b.addHeaderView(paramBundle);
    }
    i = getFooterResourceId();
    paramBundle = getFooterView();
    if (i != -1)
    {
      paramBundle = getLayoutInflater().inflate(i, null);
      this.b.addFooterView(paramBundle);
    }
    else if (paramBundle != null)
    {
      if (paramBundle.getLayoutParams() != null) {
        paramBundle.setLayoutParams(new AbsListView.LayoutParams(paramBundle.getLayoutParams()));
      } else {
        f.e("MicroMsg.mmui.WeUIPreference", "[arthurdan.mmpreference] Notice!!! footer.getLayoutParams() is null!!!\n", new Object[0]);
      }
      this.b.addFooterView(paramBundle);
    }
    paramBundle = getBottomView();
    if (paramBundle != null)
    {
      FrameLayout localFrameLayout = (FrameLayout)findViewById(2131440587);
      localFrameLayout.addView(paramBundle);
      localFrameLayout.setVisibility(0);
    }
    this.a.a(new WeUIPreference.1(this));
    i = getResourceId();
    if (i != -1) {
      this.a.addPreferencesFromResource(i);
    }
    this.b.setAdapter(this.a);
    this.b.setOnItemClickListener(new WeUIPreference.2(this));
    this.b.setOnItemLongClickListener(new WeUIPreference.3(this));
    this.b.setOnScrollListener(new WeUIPreference.4(this));
  }
  
  public abstract boolean onPreferenceTreeClick(IPreferenceScreen paramIPreferenceScreen, Preference paramPreference);
  
  public boolean onPreferenceTreeLongClick(IPreferenceScreen paramIPreferenceScreen, Preference paramPreference, View paramView)
  {
    return false;
  }
  
  protected void onResume()
  {
    if (a()) {
      this.a.notifyDataSetChanged();
    }
    super.onResume();
  }
  
  public boolean onSetToTop()
  {
    return true;
  }
  
  public void releaseUI()
  {
    this.b.setAdapter(null);
  }
  
  public void setSelection(int paramInt)
  {
    this.b.setSelection(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.weui.base.preference.WeUIPreference
 * JD-Core Version:    0.7.0.1
 */