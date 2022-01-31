package com.tencent.mobileqq.pluginsdk;

import android.app.LocalActivityManager;
import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class PluginTabHost
  extends TabHost
{
  private final List a = new ArrayList();
  private final Map b = new HashMap();
  
  public PluginTabHost(Context paramContext)
  {
    super(paramContext);
  }
  
  public PluginTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  void a(String paramString1, String paramString2, Intent paramIntent)
  {
    paramString2 = new TabSpecPluginInfo(paramString1, paramString2, paramIntent);
    this.b.put(paramString1, paramString2);
  }
  
  public void addTab(TabHost.TabSpec paramTabSpec)
  {
    super.addTab(paramTabSpec);
    if (paramTabSpec != null) {
      this.a.add(new a(paramTabSpec.getTag(), paramTabSpec));
    }
  }
  
  public void clearAllTabs()
  {
    super.clearAllTabs();
    this.a.clear();
    this.b.clear();
  }
  
  public TabSpecPluginInfo getPluginInfo(String paramString)
  {
    return (TabSpecPluginInfo)this.b.get(paramString);
  }
  
  public TabHost.TabSpec getTabAt(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.a.size())) {
      return null;
    }
    return ((a)this.a.get(paramInt)).b;
  }
  
  public int getTabCount()
  {
    return this.a.size();
  }
  
  public void setup(LocalActivityManager paramLocalActivityManager) {}
  
  protected static class TabSpecPluginInfo
  {
    public IPluginActivity mActivity;
    public String mActivityName;
    public Intent mIntent;
    public String mTag;
    
    protected TabSpecPluginInfo(String paramString1, String paramString2, Intent paramIntent)
    {
      this.mTag = paramString1;
      this.mIntent = paramIntent;
      this.mActivityName = paramString2;
    }
  }
  
  static class a
  {
    public String a;
    public TabHost.TabSpec b;
    
    a(String paramString, TabHost.TabSpec paramTabSpec)
    {
      this.a = paramString;
      this.b = paramTabSpec;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginTabHost
 * JD-Core Version:    0.7.0.1
 */