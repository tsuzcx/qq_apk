package com.tencent.mobileqq.selectmember;

import android.content.Context;
import android.view.View;
import com.tencent.common.app.AppInterface;
import com.tencent.imcore.message.Message;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.msg.api.IMessageFacade;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.adapter.BaseFacePreloadExpandableListAdapter;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItemWithMask;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import mqq.os.MqqHandler;

public class TroopListBaseAdapter
  extends BaseFacePreloadExpandableListAdapter
{
  protected AppInterface a;
  protected Context b;
  protected Set<String> c = new HashSet();
  protected List<Integer> d = new ArrayList(6);
  protected List<Entity> e = new ArrayList();
  protected List<TroopListItemWithMask> f = new ArrayList();
  protected List<TroopListItemWithMask> g = new ArrayList();
  protected List<TroopListItemWithMask> h = new ArrayList();
  protected List<TroopListItemWithMask> i = new ArrayList();
  protected List<TroopListItemWithMask> j = new ArrayList();
  protected HashSet<Integer> k = new HashSet(6);
  protected int l = 0;
  protected TroopAvatarObserver m = new TroopListBaseAdapter.4(this);
  private boolean o = true;
  
  public TroopListBaseAdapter(Context paramContext, AppInterface paramAppInterface, ExpandableListView paramExpandableListView)
  {
    super(paramContext, paramAppInterface, paramExpandableListView);
    this.a = paramAppInterface;
    this.b = paramContext;
    this.l = CommonUtils.a(44.0F, paramContext.getResources());
    this.a.addObserver(this.m);
  }
  
  private boolean a(String paramString, int paramInt)
  {
    Set localSet = this.c;
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localSet.contains(localStringBuilder.toString());
  }
  
  private void d()
  {
    ThreadManager.post(new TroopListBaseAdapter.3(this, ((IRecentUserProxyService)this.a.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache()), 8, null, true);
  }
  
  public TroopListBaseAdapter.ItemInfo a(int paramInt1, int paramInt2)
  {
    paramInt1 = ((Integer)this.d.get(paramInt1)).intValue();
    if (paramInt1 != 0)
    {
      if (paramInt1 != 2)
      {
        if (paramInt1 != 4)
        {
          if (paramInt1 != 6)
          {
            if (paramInt1 != 8)
            {
              if (paramInt1 != 13) {
                return null;
              }
              localEntity = ((TroopListItemWithMask)this.j.get(paramInt2)).b;
              localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
              localItemInfo.a = localEntity;
              localItemInfo.b = 13;
              return localItemInfo;
            }
            localEntity = ((TroopListItemWithMask)this.i.get(paramInt2)).b;
            localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
            localItemInfo.a = localEntity;
            localItemInfo.b = 8;
            return localItemInfo;
          }
          localEntity = ((TroopListItemWithMask)this.g.get(paramInt2)).b;
          localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
          localItemInfo.a = localEntity;
          localItemInfo.b = 6;
          return localItemInfo;
        }
        localEntity = ((TroopListItemWithMask)this.f.get(paramInt2)).b;
        localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
        localItemInfo.a = localEntity;
        localItemInfo.b = 4;
        return localItemInfo;
      }
      localEntity = ((TroopListItemWithMask)this.h.get(paramInt2)).b;
      localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
      localItemInfo.a = localEntity;
      localItemInfo.b = 2;
      return localItemInfo;
    }
    Entity localEntity = (Entity)this.e.get(paramInt2);
    TroopListBaseAdapter.ItemInfo localItemInfo = new TroopListBaseAdapter.ItemInfo(this);
    localItemInfo.a = localEntity;
    localItemInfo.b = 0;
    return localItemInfo;
  }
  
  public void a()
  {
    ThreadManager.getUIHandler().post(new TroopListBaseAdapter.2(this));
  }
  
  public void a(TroopInfo paramTroopInfo, RecentUserProxy paramRecentUserProxy)
  {
    if (SearchUtils.h(this.a, paramTroopInfo.troopuin) == 2)
    {
      paramTroopInfo.lastMsgTime = ((IMessageFacade)this.a.getRuntimeService(IMessageFacade.class, "")).getLastMessage(paramTroopInfo.troopuin, 1).time;
      return;
    }
    paramTroopInfo.lastMsgTime = paramRecentUserProxy.b(paramTroopInfo.troopuin, 1).lastmsgtime;
  }
  
  public void b()
  {
    super.b();
    this.a.removeObserver(this.m);
    if (this.n != null)
    {
      int i1 = this.n.getChildCount();
      int n = 0;
      while (n < i1)
      {
        View localView = this.n.getChildAt(n);
        if (localView != null) {
          localView.setOnClickListener(null);
        }
        n += 1;
      }
    }
  }
  
  public void c()
  {
    this.o = true;
    this.k.clear();
    notifyDataSetChanged();
  }
  
  public Object getChild(int paramInt1, int paramInt2)
  {
    return Integer.valueOf(paramInt2);
  }
  
  public long getChildId(int paramInt1, int paramInt2)
  {
    return paramInt2;
  }
  
  public int getChildrenCount(int paramInt)
  {
    int i1 = 0;
    int n = 0;
    if (paramInt >= 0)
    {
      if (paramInt >= this.d.size()) {
        return 0;
      }
      i1 = ((Integer)this.d.get(paramInt)).intValue();
      if (i1 != 0)
      {
        if (i1 != 2)
        {
          if (i1 != 4)
          {
            if (i1 != 6)
            {
              if (i1 != 8)
              {
                if (i1 == 13) {
                  n = this.j.size();
                }
              }
              else {
                n = this.i.size();
              }
            }
            else {
              n = this.g.size();
            }
          }
          else {
            n = this.f.size();
          }
        }
        else {
          n = this.h.size();
        }
      }
      else {
        n = this.e.size();
      }
      i1 = n;
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("getChildrenCount count:");
        localStringBuilder.append(n);
        localStringBuilder.append("  groupPosition:");
        localStringBuilder.append(paramInt);
        QLog.d("TroopListBaseAdapter", 2, localStringBuilder.toString());
        i1 = n;
      }
    }
    return i1;
  }
  
  public Object getGroup(int paramInt)
  {
    return Integer.valueOf(paramInt);
  }
  
  public int getGroupCount()
  {
    if (QLog.isColorLevel())
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getChildrenCount mGroups.size():");
      localStringBuilder.append(this.d.size());
      QLog.d("TroopListBaseAdapter", 2, localStringBuilder.toString());
    }
    return this.d.size();
  }
  
  public long getGroupId(int paramInt)
  {
    return paramInt;
  }
  
  public boolean hasStableIds()
  {
    return false;
  }
  
  public boolean isChildSelectable(int paramInt1, int paramInt2)
  {
    return false;
  }
  
  public void notifyDataSetChanged()
  {
    if (((ITroopInfoService)this.a.getRuntimeService(ITroopInfoService.class, "")).getCommonlyUsedTroopCache() == null)
    {
      ThreadManager.postImmediately(new TroopListBaseAdapter.1(this), null, false);
      return;
    }
    d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListBaseAdapter
 * JD-Core Version:    0.7.0.1
 */