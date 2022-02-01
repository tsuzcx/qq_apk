package com.tencent.mobileqq.kandian.biz.feeds.controller;

import android.app.Activity;
import android.content.Intent;
import android.view.ViewGroup;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyHelper;
import com.tencent.mobileqq.kandian.biz.framework.CallHotwordChange;
import com.tencent.mobileqq.kandian.glue.video.VideoPlayManager;
import com.tencent.mobileqq.kandian.glue.video.VideoRecommendManager;
import com.tencent.mobileqq.kandian.repo.report.BaseReportData;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ReadInJoyBaseViewController
{
  protected Activity b;
  protected Map<Integer, Set<Long>> c = new HashMap();
  protected Map<Integer, Boolean> d = new HashMap();
  protected Map<Integer, Map<Long, BaseReportData>> e = new HashMap();
  protected Map<Integer, BaseReportData> f = new HashMap();
  CallHotwordChange g;
  int h;
  
  protected ReadInJoyBaseViewController() {}
  
  protected ReadInJoyBaseViewController(Activity paramActivity)
  {
    this.b = paramActivity;
  }
  
  public Map<Long, BaseReportData> a(Integer paramInteger)
  {
    ConcurrentHashMap localConcurrentHashMap = new ConcurrentHashMap();
    paramInteger = (Map)this.e.get(paramInteger);
    if ((paramInteger != null) && (!paramInteger.isEmpty())) {
      localConcurrentHashMap.putAll(paramInteger);
    }
    return localConcurrentHashMap;
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public void a(ViewGroup paramViewGroup) {}
  
  public void a(CallHotwordChange paramCallHotwordChange, int paramInt)
  {
    this.g = paramCallHotwordChange;
    this.h = paramInt;
  }
  
  public void a(boolean paramBoolean) {}
  
  public void a(boolean paramBoolean, int paramInt) {}
  
  public void b() {}
  
  public boolean b(Integer paramInteger)
  {
    paramInteger = (Boolean)this.d.get(paramInteger);
    if (paramInteger != null) {
      return paramInteger.booleanValue();
    }
    return false;
  }
  
  public Set<Long> c(Integer paramInteger)
  {
    Set localSet = (Set)this.c.get(paramInteger);
    Object localObject = localSet;
    if (localSet == null)
    {
      localObject = new HashSet();
      this.c.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void c() {}
  
  public Activity cQ_()
  {
    return this.b;
  }
  
  public void cR_() {}
  
  public void cT_()
  {
    ReadInJoyHelper.d(true);
  }
  
  public Map<Long, BaseReportData> d(Integer paramInteger)
  {
    Map localMap = (Map)this.e.get(paramInteger);
    Object localObject = localMap;
    if (localMap == null)
    {
      localObject = new ConcurrentHashMap();
      this.e.put(paramInteger, localObject);
    }
    return localObject;
  }
  
  public void e()
  {
    ReadInJoyHelper.d(false);
  }
  
  public void f() {}
  
  public void g() {}
  
  public void h() {}
  
  public void i() {}
  
  public VideoPlayManager j()
  {
    return null;
  }
  
  public ViewGroup l()
  {
    return null;
  }
  
  public VideoRecommendManager s()
  {
    return null;
  }
  
  public void t() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.controller.ReadInJoyBaseViewController
 * JD-Core Version:    0.7.0.1
 */