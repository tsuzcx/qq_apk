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
  public int a;
  protected Context a;
  protected LayoutInflater a;
  protected View.OnClickListener a;
  private ProtoUtils.TroopProtocolObserver jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver = new TroopListAdapter.1(this);
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  TroopAvatarObserver jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver = new TroopListAdapter.2(this);
  protected XListView a;
  protected List<TroopListAdapter.TroopListItem> a;
  public int b;
  public int c;
  public int d;
  public int e;
  private int f;
  private int g;
  private int h;
  
  public TroopListAdapter(Context paramContext, AppInterface paramAppInterface, XListView paramXListView, int paramInt, boolean paramBoolean, View.OnClickListener paramOnClickListener)
  {
    super(paramContext, paramAppInterface, paramXListView, paramInt, paramBoolean);
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_AndroidViewLayoutInflater = LayoutInflater.from(paramContext);
    this.jdField_a_of_type_ComTencentWidgetXListView = paramXListView;
    this.jdField_a_of_type_AndroidViewView$OnClickListener = paramOnClickListener;
    this.g = paramContext.getResources().getColor(2131167056);
    this.h = Color.parseColor("#808080");
    paramAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver);
  }
  
  public static void a(AppInterface paramAppInterface, ProtoUtils.TroopProtocolObserver paramTroopProtocolObserver, ArrayList<String> paramArrayList)
  {
    oidb_0x88d.ReqBody localReqBody = new oidb_0x88d.ReqBody();
    localReqBody.uint32_appid.set(AppSetting.a());
    Object localObject = paramArrayList.iterator();
    int i = 0;
    int j;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      String str = (String)((Iterator)localObject).next();
      j = i + 1;
      oidb_0x88d.GroupInfo localGroupInfo = new oidb_0x88d.GroupInfo();
      localGroupInfo.uint32_app_privilege_flag.set(0);
      oidb_0x88d.ReqGroupInfo localReqGroupInfo = new oidb_0x88d.ReqGroupInfo();
      localReqGroupInfo.uint64_group_code.set(Long.parseLong(str));
      localReqGroupInfo.stgroupinfo.set(localGroupInfo);
      localReqBody.stzreqgroupinfo.add(localReqGroupInfo);
      i = j;
    } while (j != 49);
    localObject = new Bundle();
    if (paramArrayList.size() > 50)
    {
      i = 0;
      while (i < 50)
      {
        paramArrayList.remove(0);
        i += 1;
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
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqTroopApiObserverTroopAvatarObserver);
    super.a();
  }
  
  public void a(AppInterface paramAppInterface, ArrayList<Entity> paramArrayList)
  {
    this.jdField_a_of_type_JavaUtilList.clear();
    Object localObject1 = (ITroopInfoService)paramAppInterface.getRuntimeService(ITroopInfoService.class, "");
    Object localObject4 = new ArrayList();
    localObject1 = ((ITroopInfoService)localObject1).getCommonlyUsedTroopList();
    if (localObject1 != null)
    {
      Collections.sort((List)localObject1, new TroopListAdapter.CommonlyUsedTroopCompator(this));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = CommonUtils.a(paramAppInterface, ((CommonlyUsedTroop)((Iterator)localObject1).next()).troopUin);
        if ((localObject2 != null) && (!((TroopInfo)localObject2).isQidianPrivateTroop())) {
          ((List)localObject4).add(localObject2);
        }
      }
      this.d = ((List)localObject4).size();
    }
    Object localObject3 = new ArrayList();
    Object localObject2 = new ArrayList();
    localObject1 = new ArrayList();
    Object localObject5 = new ArrayList();
    Object localObject6 = paramArrayList.iterator();
    int i;
    while (((Iterator)localObject6).hasNext())
    {
      localObject7 = (TroopInfo)((Iterator)localObject6).next();
      if (!((TroopInfo)localObject7).isQidianPrivateTroop())
      {
        i = a(SearchUtils.a(paramAppInterface, ((TroopInfo)localObject7).troopuin));
        if ((((TroopInfo)localObject7).dwAdditionalFlag & 1L) == 1L) {
          ((List)localObject3).add(new TroopListItemWithMask(i, (Entity)localObject7));
        } else if ((((TroopInfo)localObject7).dwCmdUinUinFlag & 1L) == 1L) {
          ((List)localObject2).add(new TroopListItemWithMask(i, (Entity)localObject7));
        } else {
          ((List)localObject1).add(new TroopListItemWithMask(i, (Entity)localObject7));
        }
        if (!((TroopInfo)localObject7).hasSetTroopName()) {
          ((List)localObject5).add(new TroopListItemWithMask(i, (Entity)localObject7));
        }
      }
    }
    localObject6 = ((IRecentUserProxyService)paramAppInterface.getRuntimeService(IRecentUserProxyService.class, "")).getRecentUserCache();
    Object localObject7 = ((ArrayList)((IDiscussionService)paramAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussList()).iterator();
    while (((Iterator)localObject7).hasNext())
    {
      DiscussionInfo localDiscussionInfo = (DiscussionInfo)((Iterator)localObject7).next();
      RecentUser localRecentUser = ((RecentUserProxy)localObject6).a(localDiscussionInfo.uin, 3000);
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
    this.d = ((List)localObject4).size();
    this.jdField_a_of_type_Int = ((List)localObject3).size();
    this.c = ((List)localObject1).size();
    this.e = ((List)localObject5).size();
    localObject6 = new TroopCompator();
    Collections.sort((List)localObject3, (Comparator)localObject6);
    Collections.sort((List)localObject2, (Comparator)localObject6);
    Collections.sort((List)localObject1, (Comparator)localObject6);
    Collections.sort((List)localObject5, (Comparator)localObject6);
    if (this.d > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 0, null));
      localObject4 = ((List)localObject4).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject6 = (Entity)((Iterator)localObject4).next();
        if ((localObject6 instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 1, (Entity)localObject6));
        }
        else if ((localObject6 instanceof DiscussionInfo))
        {
          localObject6 = (DiscussionInfo)localObject6;
          i = ((IDiscussionService)paramAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject6).uin);
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 1, (DiscussionInfo)localObject6, i));
        }
      }
    }
    if (this.e > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 8, null));
      localObject4 = ((List)localObject5).iterator();
      while (((Iterator)localObject4).hasNext())
      {
        localObject5 = (TroopListItemWithMask)((Iterator)localObject4).next();
        if ((((TroopListItemWithMask)localObject5).a instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 3, ((TroopListItemWithMask)localObject5).a));
        }
        else if ((((TroopListItemWithMask)localObject5).a instanceof DiscussionInfo))
        {
          localObject5 = (DiscussionInfo)((TroopListItemWithMask)localObject5).a;
          i = ((IDiscussionService)paramAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject5).uin);
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 3, (DiscussionInfo)localObject5, i));
        }
      }
    }
    if (this.jdField_a_of_type_Int > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 4, null));
      localObject3 = ((List)localObject3).iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (TroopListItemWithMask)((Iterator)localObject3).next();
        if ((((TroopListItemWithMask)localObject4).a instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 5, ((TroopListItemWithMask)localObject4).a));
        }
        else if ((((TroopListItemWithMask)localObject4).a instanceof DiscussionInfo))
        {
          localObject4 = (DiscussionInfo)((TroopListItemWithMask)localObject4).a;
          i = ((IDiscussionService)paramAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject4).uin);
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 5, (DiscussionInfo)localObject4, i));
        }
      }
    }
    this.b = ((List)localObject2).size();
    if (this.b > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 6, null));
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (TroopListItemWithMask)((Iterator)localObject2).next();
        this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 7, ((TroopListItemWithMask)localObject3).a));
      }
    }
    if (this.c > 0)
    {
      this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 2, null));
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (TroopListItemWithMask)((Iterator)localObject1).next();
        if ((((TroopListItemWithMask)localObject2).a instanceof TroopInfo))
        {
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 3, ((TroopListItemWithMask)localObject2).a));
        }
        else if ((((TroopListItemWithMask)localObject2).a instanceof DiscussionInfo))
        {
          localObject2 = (DiscussionInfo)((TroopListItemWithMask)localObject2).a;
          i = ((IDiscussionService)paramAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject2).uin);
          this.jdField_a_of_type_JavaUtilList.add(new TroopListAdapter.TroopListItem(this, 3, (DiscussionInfo)localObject2, i));
        }
      }
    }
    localObject1 = this.jdField_a_of_type_AndroidContentContext;
    if ((localObject1 instanceof SelectMemberActivity))
    {
      this.f = ((SelectMemberActivity)localObject1).getType();
      if (this.f == 3000)
      {
        localObject1 = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext()) {
          ((ArrayList)localObject1).add(((TroopInfo)paramArrayList.next()).troopuin);
        }
        a(paramAppInterface, this.jdField_a_of_type_ComTencentBizProtoUtils$TroopProtocolObserver, (ArrayList)localObject1);
      }
    }
  }
  
  public int getCount()
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if (localList == null) {
      return 0;
    }
    return localList.size();
  }
  
  public Object getItem(int paramInt)
  {
    List localList = this.jdField_a_of_type_JavaUtilList;
    if ((localList != null) && (paramInt >= 0) && (paramInt < localList.size())) {
      return this.jdField_a_of_type_JavaUtilList.get(paramInt);
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
        paramView = this.jdField_a_of_type_AndroidViewLayoutInflater.inflate(2131562828, this.jdField_a_of_type_ComTencentWidgetXListView, false);
        localTroopViewHolder = new TroopListAdapter.TroopViewHolder(this);
        localTroopViewHolder.c = ((ImageView)paramView.findViewById(2131366401));
        localTroopViewHolder.jdField_a_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131366423));
        localTroopViewHolder.jdField_a_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379316));
        localTroopViewHolder.jdField_b_of_type_AndroidWidgetTextView = ((TextView)paramView.findViewById(2131379302));
        localTroopViewHolder.jdField_b_of_type_AndroidWidgetImageView = ((ImageView)paramView.findViewById(2131362975));
        paramView.setTag(localTroopViewHolder);
      }
      View localView = paramView.findViewById(2131379279);
      Object localObject2 = (TextView)paramView.findViewById(2131379364);
      if (localTroopListItem.jdField_a_of_type_Int == 0)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696198, new Object[] { String.valueOf(this.d) }));
        localObject1 = paramView;
      }
      else if (localTroopListItem.jdField_a_of_type_Int == 2)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696218, new Object[] { String.valueOf(this.c) }));
        localObject1 = paramView;
      }
      else if (localTroopListItem.jdField_a_of_type_Int == 4)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696129, new Object[] { String.valueOf(this.jdField_a_of_type_Int) }));
        localObject1 = paramView;
      }
      else if (localTroopListItem.jdField_a_of_type_Int == 6)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696168, new Object[] { String.valueOf(this.b) }));
        localObject1 = paramView;
      }
      else if (localTroopListItem.jdField_a_of_type_Int == 8)
      {
        localView.setVisibility(8);
        ((TextView)localObject2).setVisibility(0);
        ((TextView)localObject2).setText(this.jdField_a_of_type_AndroidContentContext.getString(2131696313, new Object[] { String.valueOf(this.e) }));
        localObject1 = paramView;
      }
      else if (localTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null)
      {
        localView.setVisibility(0);
        ((TextView)localObject2).setVisibility(8);
        localObject2 = localTroopListItem.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
        localTroopViewHolder.jdField_a_of_type_JavaLangString = ((TroopInfo)localObject2).troopuin;
        TextView localTextView = localTroopViewHolder.jdField_a_of_type_AndroidWidgetTextView;
        if (((TroopInfo)localObject2).getTroopDisplayName() != null) {
          localObject1 = ((TroopInfo)localObject2).getTroopDisplayName();
        } else {
          localObject1 = ((TroopInfo)localObject2).troopcode;
        }
        localTextView.setText((CharSequence)localObject1);
        localTroopViewHolder.c.setImageBitmap(a(4, ((TroopInfo)localObject2).troopuin));
        localTroopViewHolder.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = ((TroopInfo)localObject2);
        localTroopViewHolder.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = null;
        localTroopViewHolder.jdField_a_of_type_Int = localTroopListItem.jdField_a_of_type_Int;
        if ((!((TroopInfo)localObject2).hasSetTroopName()) && (((TroopInfo)localObject2).wMemberNumClient > 0))
        {
          localTroopViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
          localTroopViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((TroopInfo)localObject2).wMemberNumClient) }));
        }
        else
        {
          localTroopViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(8);
        }
        if ((!((TroopInfo)localObject2).isAllowCreateDiscuss()) && (!((TroopInfo)localObject2).isTroopOwner(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())) && (!((TroopInfo)localObject2).isTroopAdmin(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
        {
          localView.setEnabled(false);
          localTroopViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(0);
          localTroopViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(8);
          localTroopViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.h);
        }
        else
        {
          localTroopViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          localTroopViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localTroopViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.g);
        }
        paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
        localObject1 = paramView;
      }
      else
      {
        localObject1 = paramView;
        if (localTroopListItem.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null)
        {
          localView.setVisibility(0);
          ((TextView)localObject2).setVisibility(8);
          localObject1 = localTroopListItem.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
          localTroopViewHolder.jdField_a_of_type_JavaLangString = ((DiscussionInfo)localObject1).uin;
          localTroopViewHolder.jdField_a_of_type_AndroidWidgetTextView.setText(CommonUtils.a(this.jdField_a_of_type_AndroidContentContext, (DiscussionInfo)localObject1));
          localTroopViewHolder.c.setImageBitmap(a(101, ((DiscussionInfo)localObject1).uin));
          if (!((DiscussionInfo)localObject1).hasRenamed())
          {
            localTroopViewHolder.jdField_b_of_type_AndroidWidgetTextView.setVisibility(0);
            localTroopViewHolder.jdField_b_of_type_AndroidWidgetTextView.setText(String.format("(%d)", new Object[] { Integer.valueOf(((IDiscussionService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IDiscussionService.class, "")).getDiscussionMemberNum(((DiscussionInfo)localObject1).uin)) }));
          }
          localTroopViewHolder.jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo = ((DiscussionInfo)localObject1);
          localTroopViewHolder.jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo = null;
          localTroopViewHolder.jdField_a_of_type_Int = localTroopListItem.jdField_a_of_type_Int;
          localTroopViewHolder.jdField_a_of_type_AndroidWidgetImageView.setVisibility(8);
          localTroopViewHolder.jdField_b_of_type_AndroidWidgetImageView.setVisibility(0);
          localTroopViewHolder.jdField_a_of_type_AndroidWidgetTextView.setTextColor(this.g);
          paramView.setOnClickListener(this.jdField_a_of_type_AndroidViewView$OnClickListener);
          localObject1 = paramView;
        }
      }
    }
    EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
    return localObject1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopListAdapter
 * JD-Core Version:    0.7.0.1
 */