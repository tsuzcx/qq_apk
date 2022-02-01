package com.tencent.mobileqq.kandian.biz.xtab;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.VisibleForTesting;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.base.view.widget.ReadInJoyStaticGridView;
import com.tencent.mobileqq.kandian.biz.common.ReadInJoyUtils;
import com.tencent.mobileqq.kandian.biz.feeds.RIJStaticChannelGridViewAdapter;
import com.tencent.mobileqq.kandian.biz.feeds.fragment.RIJBaseChannelPanelFragment;
import com.tencent.mobileqq.kandian.biz.xtab.api.impl.RIJXTabFrameUtils;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicEngine;
import com.tencent.mobileqq.kandian.glue.businesshandler.engine.ReadInJoyLogicManager;
import com.tencent.mobileqq.kandian.repo.db.struct.ChannelSection;
import com.tencent.mobileqq.kandian.repo.feeds.RIJChannelHelper;
import com.tencent.mobileqq.kandian.repo.feeds.entity.TabChannelCoverInfo;
import com.tencent.mobileqq.widget.SlideDownFrameLayout;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import mqq.app.AppRuntime;

public class RIJXTabChannelPanelFragment
  extends RIJBaseChannelPanelFragment
{
  private ReadInJoyStaticGridView d;
  private RIJStaticChannelGridViewAdapter e;
  private Map<Integer, TabChannelCoverInfo> f;
  private ReadInJoyLogicEngine g;
  private List<TabChannelCoverInfo> h;
  
  private boolean a(TabChannelCoverInfo paramTabChannelCoverInfo, List<TabChannelCoverInfo> paramList)
  {
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)paramList.next();
      if ((localTabChannelCoverInfo.mChannelCoverId == paramTabChannelCoverInfo.mChannelCoverId) || ((paramTabChannelCoverInfo.mChannelCoverName != null) && (paramTabChannelCoverInfo.mChannelCoverName.equals(localTabChannelCoverInfo.mChannelCoverName)))) {
        return true;
      }
    }
    return false;
  }
  
  private void f()
  {
    this.h = a(this.g.H());
    this.f = new HashMap();
  }
  
  private void g()
  {
    ThreadManager.executeOnSubThread(new RIJXTabChannelPanelFragment.1(this));
  }
  
  @SuppressLint({"ClickableViewAccessibility"})
  private void h()
  {
    this.c.setVisibility(8);
    this.d = ((ReadInJoyStaticGridView)this.b.findViewById(2131444427));
    this.e = new RIJStaticChannelGridViewAdapter(getBaseActivity(), 4, this.a, new RIJXTabChannelPanelFragment.RecommendChannelAdapterCallback(this, null));
    this.e.c(this.h);
    this.d.setExpendable(true);
    this.d.setAdapter(this.e);
  }
  
  private void i()
  {
    this.g = ((ReadInJoyLogicManager)ReadInJoyUtils.b().getManager(QQManagerFactory.READINJOY_LOGIC_MANAGER)).getReadInJoyLogicEngine();
  }
  
  private void j()
  {
    this.d.setOnItemClickListener(this.e);
  }
  
  private void k()
  {
    Object localObject = this.f;
    if (localObject == null) {
      return;
    }
    localObject = ((Map)localObject).values().iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      if (RIJChannelHelper.a(localTabChannelCoverInfo) == 1)
      {
        localTabChannelCoverInfo.redPoint.a = false;
        this.g.a(localTabChannelCoverInfo);
      }
    }
    this.g.c(false);
  }
  
  public int a()
  {
    return 2131629150;
  }
  
  @VisibleForTesting
  public List<TabChannelCoverInfo> a(List<ChannelSection> paramList)
  {
    Object localObject = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      int i = 0;
      while (i < paramList.size())
      {
        ((List)localObject).addAll(this.g.d(i));
        i += 1;
      }
    }
    paramList = RIJXTabFrameUtils.getChannelCoverList();
    ArrayList localArrayList = new ArrayList();
    localObject = ((List)localObject).iterator();
    while (((Iterator)localObject).hasNext())
    {
      TabChannelCoverInfo localTabChannelCoverInfo = (TabChannelCoverInfo)((Iterator)localObject).next();
      if (!a(localTabChannelCoverInfo, paramList)) {
        localArrayList.add(localTabChannelCoverInfo);
      }
    }
    return localArrayList;
  }
  
  public String b()
  {
    return getString(2131915485);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(paramBundle);
    i();
    g();
  }
  
  public View onCreateView(LayoutInflater paramLayoutInflater, ViewGroup paramViewGroup, Bundle paramBundle)
  {
    super.onCreateView(paramLayoutInflater, paramViewGroup, paramBundle);
    f();
    h();
    j();
    return this.b;
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    k();
    this.g = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.xtab.RIJXTabChannelPanelFragment
 * JD-Core Version:    0.7.0.1
 */