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
  private final Map<String, PluginTabHost.TabSpecPluginInfo> mPluginInfos = new HashMap();
  private final List<PluginTabHost.TabSpecWrapper> mTabSpecs = new ArrayList();
  
  public PluginTabHost(Context paramContext)
  {
    super(paramContext);
  }
  
  public PluginTabHost(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  void addPluginInfo(String paramString1, String paramString2, Intent paramIntent)
  {
    paramString2 = new PluginTabHost.TabSpecPluginInfo(paramString1, paramString2, paramIntent);
    this.mPluginInfos.put(paramString1, paramString2);
  }
  
  public void addTab(TabHost.TabSpec paramTabSpec)
  {
    super.addTab(paramTabSpec);
    if (paramTabSpec != null) {
      this.mTabSpecs.add(new PluginTabHost.TabSpecWrapper(paramTabSpec.getTag(), paramTabSpec));
    }
  }
  
  public void clearAllTabs()
  {
    super.clearAllTabs();
    this.mTabSpecs.clear();
    this.mPluginInfos.clear();
  }
  
  public PluginTabHost.TabSpecPluginInfo getPluginInfo(String paramString)
  {
    return (PluginTabHost.TabSpecPluginInfo)this.mPluginInfos.get(paramString);
  }
  
  public TabHost.TabSpec getTabAt(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.mTabSpecs.size())) {
      return ((PluginTabHost.TabSpecWrapper)this.mTabSpecs.get(paramInt)).mTabSpec;
    }
    return null;
  }
  
  public int getTabCount()
  {
    return this.mTabSpecs.size();
  }
  
  public void setup(LocalActivityManager paramLocalActivityManager) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.pluginsdk.PluginTabHost
 * JD-Core Version:    0.7.0.1
 */