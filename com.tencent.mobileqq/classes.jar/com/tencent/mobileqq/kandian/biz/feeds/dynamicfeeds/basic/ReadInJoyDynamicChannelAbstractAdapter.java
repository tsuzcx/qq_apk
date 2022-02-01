package com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView.Adapter;
import com.tencent.biz.pubaccount.readinjoy.view.proteus.virtualview.core.VafContext;
import com.tencent.mobileqq.kandian.biz.pts.ReadInjoyContext;
import com.tencent.mobileqq.kandian.glue.pts.util.ProteusSupportUtil;
import com.tencent.widget.pull2refresh.BaseViewHolder;
import com.tencent.widget.pull2refresh.RecyclerViewWithHeaderFooter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class ReadInJoyDynamicChannelAbstractAdapter<K, D>
  extends RecyclerView.Adapter<BaseViewHolder>
{
  protected List<D> a = new ArrayList();
  protected VafContext b = new ReadInjoyContext();
  protected Context c;
  protected int d;
  protected Map<Integer, String> e = new HashMap();
  protected ConcurrentHashMap<K, D> f = new ConcurrentHashMap();
  protected RecyclerViewWithHeaderFooter g;
  
  public ReadInJoyDynamicChannelAbstractAdapter(Activity paramActivity, RecyclerViewWithHeaderFooter paramRecyclerViewWithHeaderFooter, int paramInt)
  {
    this.d = paramInt;
    this.b.setContext(paramActivity);
    this.b.setCurActivity(paramActivity);
    ProteusSupportUtil.a(this.b, b());
    this.c = paramActivity;
    this.g = paramRecyclerViewWithHeaderFooter;
  }
  
  public VafContext a()
  {
    return this.b;
  }
  
  protected D a(int paramInt)
  {
    if ((paramInt >= 0) && (paramInt < this.a.size())) {
      return this.a.get(paramInt);
    }
    return null;
  }
  
  public void a(K paramK, D paramD)
  {
    ConcurrentHashMap localConcurrentHashMap = this.f;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.put(paramK, paramD);
    }
  }
  
  public void a(List<D> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      this.a.clear();
      this.a.addAll(paramList);
      notifyDataSetChanged();
    }
  }
  
  protected String b()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("dynamic_feeds_");
    localStringBuilder.append(this.d);
    return localStringBuilder.toString();
  }
  
  public void b(List<D> paramList)
  {
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = this.a.size();
      this.a.addAll(paramList);
      notifyItemRangeInserted(i, paramList.size());
    }
  }
  
  public void c()
  {
    ConcurrentHashMap localConcurrentHashMap = this.f;
    if (localConcurrentHashMap != null) {
      localConcurrentHashMap.clear();
    }
  }
  
  public ConcurrentHashMap<K, D> d()
  {
    ConcurrentHashMap localConcurrentHashMap1 = new ConcurrentHashMap();
    ConcurrentHashMap localConcurrentHashMap2 = this.f;
    if ((localConcurrentHashMap2 != null) && (!localConcurrentHashMap2.isEmpty())) {
      localConcurrentHashMap1.putAll(this.f);
    }
    return localConcurrentHashMap1;
  }
  
  public int getItemCount()
  {
    List localList = this.a;
    if (localList != null) {
      return localList.size();
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.feeds.dynamicfeeds.basic.ReadInJoyDynamicChannelAbstractAdapter
 * JD-Core Version:    0.7.0.1
 */