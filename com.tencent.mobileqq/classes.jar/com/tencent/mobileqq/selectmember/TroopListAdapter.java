package com.tencent.mobileqq.selectmember;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.tencent.biz.ProtoUtils;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.common.app.AppInterface;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.app.proxy.RecentUserProxy;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.troop.CommonlyUsedTroop;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.proxy.api.IRecentUserProxyService;
import com.tencent.mobileqq.search.util.SearchUtils;
import com.tencent.mobileqq.selectmember.adapter.FacePreloadBaseAdapter;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.troop.adapter.contact.TroopCompator;
import com.tencent.mobileqq.troop.adapter.contact.TroopListItemWithMask;
import com.tencent.mobileqq.troop.api.IDiscussionService;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopAvatarObserver;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.XListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqBody;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.ReqGroupInfo;

public class TroopListAdapter
  extends FacePreloadBaseAdapter
{
  protected List<TroopListAdapter.TroopListItem> a = new ArrayList();
  public int b;
  public int c;
  public int d;
  public int e;
  public int f;
  protected LayoutInflater g;
  protected Context h;
  AppInterface i;
  protected XListView j;
  protected View.OnClickListener k;
  TroopAvatarObserver l = new TroopListAdapter.2(this);
  private int n;
  private int o;
  private int p;
  private ProtoUtils.TroopProtocolObserver q = new TroopListAdapter.1(this);
  
  public TroopListAdapter(Context paramContext, AppInterface paramAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramAppInterface, paramXListView, paramInt, paramBoolean);
    this.h = paramContext;
    this.i = paramAppInterface;
    this.g = LayoutInflater.from(paramContext);
    this.j = paramXListView;
    this.k = paramOnClickListener;
    this.o = paramContext.getResources().getColor(2131167993);
    this.p = Color.parseColor("#808080");
    paramAppInterface.addObserver(this.l);
  }
  
  public static void a(AppInterface paramAppInterface, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, ArrayList<String> paramArrayList)
  {
    oidb_0x88d.ReqBody localReqBody = new oidb_0x88d.ReqBody();
    localReqBody.uint32_appid.set(AppSetting.d());
    Object localObject = paramArrayList.iterator();
    int m = 0;
    int i1;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      String str = (String)((Iterator)localObject).next();
      i1 = m + 1;
      oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
      localGroupInfo.uint32_app_privilege_flag.set(0);
      oidb_0x88d.ReqGroupInfo localReqGroupInfo = new oidb_0x88d.ReqGroupInfo();
      localReqGroupInfo.uint64_group_code.set(Long.parseLong(str));
      localReqGroupInfo.stgroupinfo.set(localGroupInfo);
      localReqBody.stzreqgroupinfo.add(localReqGroupInfo);
      m = i1;
    } while (i1 != 49);
    localObject = new Bundle();
    if (paramArrayList.size() > 50)
    {
      m = 0;
      while (m < 50)
      {
        paramArrayList.remove(0);
        m += 1;
      }
      ((Bundle)localObject).putStringArrayList("TroopList", paramArrayList);
    }
    ProtoUtils.b(paramAppInterface, paramTroopProtocolObserver, localReqBody.toByteArray(), "OidbSvc.0x88d_0", 2189, 0, (Bundle)localObject);
  }
  
  public int a(int paramInt)
  {
    if (paramInt != 1)
    {
      if (paramInt != 2)
      {
        if (paramInt != 3)
        {
          if (paramInt != 4) {
            return 1;
          }
          return 2;
        }
        return 4;
      }
      return 3;
    }
    return 1;
  }
  
  public void a()
  {
    this.i.removeObserver(this.l);
    super.a();
  }
  
  public void a(AppInterface paramAppInterface, ArrayList<Entity> paramArrayList)
  {
    this.a.clear();
    Object localObject1 = (ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "");
    Object localObject4 = new ArrayList();
    localObject1 = ((ITroopInfoService)localObject1).getCommonlyUsedTroopList();
    if (localObject1 != null)
    {
      Collections.sort((List)localObject1, new TroopListAdapter.CommonlyUsedTroopCompator(this));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = CommonUtils.d(paramAppInterface, ((CommonlyUsedTroop)((Iterator)localObject1).next()).troopUin);
        if ((localObject2 != null) && (!((TroopInfo)localObject2).isQidianPrivateTroop())) {
          ((List)localObject4).add(localObject2);
        }
      }
      this.e = ((List)localObject4).size();
    }
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject5 = new ArrayList();
    Object localObject6 = paramArrayList.iterator();
    int m;
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = (TroopInfo)((Iterator)localObject6).next();
      if (!((TroopInfo)localObject7).isQidianPrivateTroop())
      {
        m = a(SearchUtils.h(paramAppInterface, ((TroopInfo)localObject7).troopuin));
        if ((((TroopInfo)localObject7).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject3).add(new TroopListItemWithMask(m, (Entity)localObject7));
        } else if ((((TroopInfo)localObject7).dwCmdUinUinFlag & 1L) == 1L) {
          ((List)localObject2).add(new TroopListItemWithMask(m, (Entity)localObject7));
        } else {
          ((List)localObject1).add(new TroopListItemWithMask(m, (Entity)localObject7));
        }
        if (!((TroopInfo)localObject7).hasSetTroopName()) {
          ((List)localObject5).add(new TroopListItemWithMask(m, (Entity)localObject7));
        }
      }
    }
    localObject6 = ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    Object localObject7 = ((ArrayList)((IDiscussionService)paramAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussList()).iterator();
    while (((Iterator)localObject7).hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject7).next();
      RecentUser localRecentUser = ((RecentUserProxy)localObject6).b(localDiscussionInfo.uin, 3000);
      localDiscussionInfo.lastMsgTime = localRecentUser.lastmsgtime;
      if (localRecentUser.showUpTime != 0L) {
        ((List)localObject4).add(localDiscussionInfo);
      }
      if (paramAppInterface.getCurrentUin().equals(localDiscussionInfo.ownerUin)) {
        ((List)localObject3).add(new TroopListItemWithMask(1, localDiscussionInfo));
      } else {
        ((List)localObject1).add(new TroopListItemWithMask(1, localDiscussionInfo));
      }
      if (!localDiscussionInfo.hasRenamed()) {
        ((List)localObject5).add(new TroopListItemWithMask(1, localDiscussionInfo));
      }
    }
    this.e = ((List)localObject4).size();
    this.b = ((List)localObject3).size();
    this.d = ((List)localObject1).size();
    this.f = ((List)localObject5).size();
    localObject6 = new TroopCompator();
    Collections.sort((List)localObject3, (Comparator)localObject6);
    Collections.sort((List)localObject2, (Comparator)localObject6);
    Collections.sort((List)localObject1, (Comparator)localObject6);
    Collections.sort((List)localObject5, (Comparator)localObject6);
    if (this.e > 0)
    {
      this.a.add(new TroopListAdapter.TroopListItem(this, 0, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (Entity)((Iterator)localObject4).next();
        if ((localObject6 instanceof TroopInfo))
        {
          this.a.add(new TroopListAdapter.TroopListItem(this, 1, (Entity)localObject6));
        }
        else if ((localObject6 instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)localObject6;
          m = ((IDiscussionService)paramAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject6).uin);
          this.a.add(new TroopListAdapter.TroopListItem(this, 1, (DiscussionInfo)localObject6, m));
        }
      }
    }
    if (this.f > 0)
    {
      this.a.add(new TroopListAdapter.TroopListItem(this, 8, null));
      localObject4 = ((List)localObject5).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (TroopListItemWithMask)((Iterator)localObject4).next();
        if ((((TroopListItemWithMask)localObject5).b instanceof TroopInfo))
        {
          this.a.add(new TroopListAdapter.TroopListItem(this, 3, ((TroopListItemWithMask)localObject5).b));
        }
        else if ((((TroopListItemWithMask)localObject5).b instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((TroopListItemWithMask)localObject5).b;
          m = ((IDiscussionService)paramAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject5).uin);
          this.a.add(new TroopListAdapter.TroopListItem(this, 3, (DiscussionInfo)localObject5, m));
        }
      }
    }
    if (this.b > 0)
    {
      this.a.add(new TroopListAdapter.TroopListItem(this, 4, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (TroopListItemWithMask)((Iterator)localObject3).next();
        if ((((TroopListItemWithMask)localObject4).b instanceof TroopInfo))
        {
          this.a.add(new TroopListAdapter.TroopListItem(this, 5, ((TroopListItemWithMask)localObject4).b));
        }
        else if ((((TroopListItemWithMask)localObject4).b instanceof DiscussionInfo))
        {
          localObject4 = (DiscussionInfo)((TroopListItemWithMask)localObject4).b;
          m = ((IDiscussionService)paramAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject4).uin);
          this.a.add(new TroopListAdapter.TroopListItem(this, 5, (DiscussionInfo)localObject4, m));
        }
      }
    }
    this.c = ((List)localObject2).size();
    if (this.c > 0)
    {
      this.a.add(new TroopListAdapter.TroopListItem(this, 6, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopListItemWithMask)((Iterator)localObject2).next();
        this.a.add(new TroopListAdapter.TroopListItem(this, 7, ((TroopListItemWithMask)localObject3).b));
      }
    }
    if (this.d > 0)
    {
      this.a.add(new TroopListAdapter.TroopListItem(this, 2, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopListItemWithMask)((Iterator)localObject1).next();
        if ((((TroopListItemWithMask)localObject2).b instanceof TroopInfo))
        {
          this.a.add(new TroopListAdapter.TroopListItem(this, 3, ((TroopListItemWithMask)localObject2).b));
        }
        else if ((((TroopListItemWithMask)localObject2).b instanceof DiscussionInfo))
        {
          localObject2 = (DiscussionInfo)((TroopListItemWithMask)localObject2).b;
          m = ((IDiscussionService)paramAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject2).uin);
          this.a.add(new TroopListAdapter.TroopListItem(this, 3, (DiscussionInfo)localObject2, m));
        }
      }
    }
    localObject1 = this.h;
    if ((localObject1 instanceof SelectMemberActivity))
    {
      this.n = ((SelectMemberActivity)localObject1).getType();
      if (this.n == 3000)
      {
        localObject1 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((ArrayList)localObject1).add(((TroopInfo)paramArrayList.next()).troopuin);
        }
        a(paramAppInterface, this.q, (ArrayList)localObject1);
      }
    }
  }
  
  public int getCount()
  {
    List localList = this.a;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.a;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return this.a.get(paramInt);
    }
    return null;
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  @TargetApi(16)
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    TroopListAdapter.TroopListItem localTroopListItem = (TroopListAdapter.TroopListItem)getItem(paramInt);
    Object localObject1;
    if (localTroopListItem == null)
    {
      localObject1 = paramView;
    }
    else
    {
      TroopListAdapter.TroopViewHolder localTroopViewHolder;
      if ((paramView != null) && (paramView.getTag() != null))
      {
        localTroopViewHolder = (TroopListAdapter.TroopViewHolder)paramView.getTag();
      }
      else
      {
        paramView = this.g.inflate(2131629273, this.j, false);
        localTroopViewHolder = new TroopListAdapter.TroopViewHolder(this);
        localTroopViewHolder.k = ((ImageView)paramView.findViewById(2131432714));
        localTroopViewHolder.f = ((ImageView)paramView.findViewById(2131432739));
        localTroopViewHolder.a = ((TextView)paramView.findViewById(2131448053));
        localTroopViewHolder.b = ((TextView)paramView.findViewById(2131448039));
        localTroopViewHolder.g = ((ImageView)paramView.findViewById(2131428774));
        paramView.setTag(localTroopViewHolder);
      }
      View localView = paramView.findViewById(2131448016);
      Object localObject2 = (TextView)paramView.findViewById(2131448101);
      if (localTroopListItem.a == 0)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.h.getString(2131893964, new Object[] { String.valueOf(this.e) }));
        localObject1 = paramView;
      }
      else if (localTroopListItem.a == 2)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.h.getString(2131893984, new Object[] { String.valueOf(this.d) }));
        localObject1 = paramView;
      }
      else if (localTroopListItem.a == 4)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.h.getString(2131893894, new Object[] { String.valueOf(this.b) }));
        localObject1 = paramView;
      }
      else if (localTroopListItem.a == 6)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.h.getString(2131893934, new Object[] { String.valueOf(this.c) }));
        localObject1 = paramView;
      }
      else if (localTroopListItem.a == 8)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.h.getString(2131894079, new Object[] { String.valueOf(this.f) }));
        localObject1 = paramView;
      }
      else if (localTroopListItem.b != null)
      {
        localView.setVisibility(0);
        ((TextView)localObject2).setVisibility(8);
        localObject2 = localTroopListItem.b;
        localTroopViewHolder.i = ((TroopInfo)localObject2).troopuin;
        TextView localTextView = localTroopViewHolder.a;
        if (((TroopInfo)localObject2).getTroopDisplayName() != null) {
          localObject1 = ((TroopInfo)localObject2).getTroopDisplayName();
        } else {
          localObject1 = ((TroopInfo)localObject2).troopcode;
        }
        localTextView.setText((CharSequence)localObject1);
        localTroopViewHolder.k.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
        localTroopViewHolder.c = ((TroopInfo)localObject2);
        localTroopViewHolder.d = null;
        localTroopViewHolder.e = localTroopListItem.a;
        if ((!((TroopInfo)localObject2).hasSetTroopName()) && (((TroopInfo)localObject2).wMemberNumClient > 0))
        {
          localTroopViewHolder.b.setVisibility(0);
          localTroopViewHolder.b.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject2).wMemberNumClient) }));
        }
        else
        {
          localTroopViewHolder.b.setVisibility(8);
        }
        if ((!((TroopInfo)localObject2).isAllowCreateDiscuss()) && (!((TroopInfo)localObject2).isTroopOwner(this.i.getCurrentAccountUin())) && (!((TroopInfo)localObject2).isTroopAdmin(this.i.getCurrentAccountUin())))
        {
          localView.setEnabled(false);
          localTroopViewHolder.f.setVisibility(0);
          localTroopViewHolder.g.setVisibility(8);
          localTroopViewHolder.a.setTextColor(this.p);
        }
        else
        {
          localTroopViewHolder.f.setVisibility(8);
          localTroopViewHolder.g.setVisibility(0);
          localTroopViewHolder.a.setTextColor(this.o);
        }
        paramView.setOnClickListener(this.k);
        localObject1 = paramView;
      }
      else
      {
        localObject1 = paramView;
        if (localTroopListItem.c != null)
        {
          localView.setVisibility(0);
          ((TextView)localObject2).setVisibility(8);
          localObject1 = localTroopListItem.c;
          localTroopViewHolder.i = ((DiscussionInfo)localObject1).uin;
          localTroopViewHolder.a.setText(CommonUtils.a(this.h, (DiscussionInfo)localObject1));
          localTroopViewHolder.k.setImageBitmap(a(101, ((DiscussionInfo)localObject1).uin));
          if (!((DiscussionInfo)localObject1).hasRenamed())
          {
            localTroopViewHolder.b.setVisibility(0);
            localTroopViewHolder.b.setText(String.format("(%d)", new Object[] { Integer.valueOf(((IDiscussionService)this.i.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject1).uin)) }));
          }
          localTroopViewHolder.d = ((DiscussionInfo)localObject1);
          localTroopViewHolder.c = null;
          localTroopViewHolder.e = localTroopListItem.a;
          localTroopViewHolder.f.setVisibility(8);
          localTroopViewHolder.g.setVisibility(0);
          localTroopViewHolder.a.setTextColor(this.o);
          paramView.setOnClickListener(this.k);
          localObject1 = paramView;
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListAdapter
 * JD-Core Version:    0.7.0.1
 */