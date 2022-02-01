package com.tencent.mobileqq.troop.troopcreate.ui;

import android.content.Context;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.HardCodeUtil;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.Groups;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.selectmember.ResultRecord;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.api.troopcreate.IFacePreloadBaseAdapterHelper;
import com.tencent.mobileqq.troop.api.troopcreate.IRelationFriendsSearchHelper;
import com.tencent.mobileqq.troop.troopcreate.RelationTroopEntity;
import com.tencent.mobileqq.troop.troopcreate.api.IRelationFriendsTroopViewHelper.CallBack;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopCreateService;
import com.tencent.mobileqq.troop.troopcreate.api.ITroopSearchService;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.PinnedFooterExpandableListView;
import java.util.ArrayList;
import java.util.HashMap;
import mqq.os.MqqHandler;

public class RelationFriendsTroopViewHelper
{
  IRelationFriendsSearchHelper a;
  AppInterface b;
  PinnedFooterExpandableListView c;
  private ArrayList<Entity> d = new ArrayList();
  private ArrayList<Entity> e = new ArrayList();
  private String f = "";
  private HashMap<String, Long> g = new HashMap();
  private IRelationFriendsTroopViewHelper.CallBack h;
  private int i = -1;
  
  public RelationFriendsTroopViewHelper(AppInterface paramAppInterface, PinnedFooterExpandableListView paramPinnedFooterExpandableListView, IRelationFriendsTroopViewHelper.CallBack paramCallBack)
  {
    this.b = paramAppInterface;
    this.c = paramPinnedFooterExpandableListView;
    this.h = paramCallBack;
    this.a = ((IRelationFriendsSearchHelper)QRoute.api(IRelationFriendsSearchHelper.class));
  }
  
  private void b(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "updateRelationFriends");
    }
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    ThreadManager.getSubThreadHandler().post(new RelationFriendsTroopViewHelper.3(this, paramString));
  }
  
  private void e()
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "updateRelationTroops");
    }
    if ((ITroopCreateService)this.b.getRuntimeService(ITroopCreateService.class, "") != null)
    {
      ArrayList localArrayList = this.h.a();
      if (localArrayList != null)
      {
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("updateRelationTroops records size:");
          ((StringBuilder)localObject).append(localArrayList.size());
          QLog.i("RelationFriendsTroopViewHelper", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = new ArrayList(localArrayList.size());
        ((ArrayList)localObject).addAll(localArrayList);
        ((ITroopSearchService)this.b.getRuntimeService(ITroopSearchService.class, "")).search((ArrayList)localObject, true, new RelationFriendsTroopViewHelper.4(this));
      }
    }
  }
  
  private int f()
  {
    int j = this.i;
    if (j == 3) {
      return 3;
    }
    if (j == 2) {
      return 2;
    }
    if (j == 1) {
      return 1;
    }
    if (j == 4) {
      return 4;
    }
    return 0;
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, RelationTroopEntity paramRelationTroopEntity)
  {
    return ((IFacePreloadBaseAdapterHelper)this.b.getRuntimeService(IFacePreloadBaseAdapterHelper.class, "")).getContactListRelationTroopView(paramView, paramViewGroup, paramContext, paramOnClickListener, paramRelationTroopEntity);
  }
  
  public Long a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (Long)this.g.get(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "getRelationTroopChildId troopUin empty");
    }
    return Long.valueOf(-1L);
  }
  
  public void a()
  {
    ReportController.b(this.b, "dc00899", "Grp_create", "", "grptab", "friendlist_exp", f(), 0, "", "", "", "");
  }
  
  public void a(ResultRecord paramResultRecord)
  {
    this.i = 1;
    if (paramResultRecord != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSearchResult:,currentRelationUin:");
        localStringBuilder.append(this.f);
        localStringBuilder.append(",lastrecordUIN:");
        localStringBuilder.append(paramResultRecord.uin);
        QLog.i("RelationFriendsTroopViewHelper", 2, localStringBuilder.toString());
      }
      if (!this.f.equals(paramResultRecord.uin))
      {
        this.f = paramResultRecord.uin;
        if (!TextUtils.isEmpty(this.f))
        {
          b(this.f);
          e();
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult lastRecord null");
      }
      this.f = "";
      paramResultRecord = this.c;
      if (paramResultRecord != null) {
        paramResultRecord.post(new RelationFriendsTroopViewHelper.2(this));
      }
    }
  }
  
  public void a(ResultRecord paramResultRecord, int paramInt)
  {
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("onSearchResult:,param_entrance:");
      localStringBuilder.append(paramInt);
      QLog.i("RelationFriendsTroopViewHelper", 2, localStringBuilder.toString());
    }
    if ((paramInt == 38) || (paramInt == 29) || (paramInt == 39))
    {
      if (paramInt == 38) {
        this.i = 3;
      } else if (paramInt == 39) {
        this.i = 4;
      } else {
        this.i = 2;
      }
      if (paramResultRecord != null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onSearchResult:,currentRelationUin:");
          localStringBuilder.append(this.f);
          localStringBuilder.append(",lastrecordUIN:");
          localStringBuilder.append(paramResultRecord.uin);
          QLog.i("RelationFriendsTroopViewHelper", 2, localStringBuilder.toString());
        }
        if (!this.f.equals(paramResultRecord.uin))
        {
          this.f = paramResultRecord.uin;
          if (!TextUtils.isEmpty(this.f))
          {
            b(this.f);
            if ((paramInt == 29) || (paramInt == 39)) {
              e();
            }
          }
        }
      }
      else
      {
        paramResultRecord = this.c;
        if (paramResultRecord != null) {
          paramResultRecord.post(new RelationFriendsTroopViewHelper.1(this));
        }
      }
    }
  }
  
  public void a(ArrayList<Groups> paramArrayList, SparseArray<ArrayList<Entity>> paramSparseArray)
  {
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "loadData");
    }
    Object localObject1;
    int j;
    Object localObject2;
    if (!this.e.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "loadData relationtroop");
      }
      this.g.clear();
      localObject1 = new ArrayList();
      j = 0;
      while (j < this.e.size())
      {
        localObject2 = (RelationTroopEntity)this.e.get(j);
        ((ArrayList)localObject1).add(localObject2);
        this.g.put(((RelationTroopEntity)localObject2).troopInfo.troopuin, Long.valueOf(j + 1L));
        j += 1;
      }
      localObject2 = new Groups();
      ((Groups)localObject2).group_id = 1008;
      ((Groups)localObject2).group_name = HardCodeUtil.a(2131915664);
      ((Groups)localObject2).group_friend_count = ((ArrayList)localObject1).size();
      ((Groups)localObject2).seqid = 0;
      paramArrayList.add(localObject2);
      paramSparseArray.put(((Groups)localObject2).group_id, localObject1);
    }
    if (!this.d.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "loadData relationfriends");
      }
      localObject1 = new Groups();
      localObject2 = new ArrayList();
      j = 0;
      while (j < this.d.size())
      {
        ((ArrayList)localObject2).add(this.d.get(j));
        j += 1;
      }
      ((Groups)localObject1).group_id = 1007;
      ((Groups)localObject1).group_name = HardCodeUtil.a(2131915663);
      ((Groups)localObject1).group_friend_count = ((ArrayList)localObject2).size();
      ((Groups)localObject1).seqid = 0;
      paramArrayList.add(localObject1);
      paramSparseArray.put(((Groups)localObject1).group_id, localObject2);
    }
  }
  
  public View b(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, RelationTroopEntity paramRelationTroopEntity)
  {
    return ((IFacePreloadBaseAdapterHelper)this.b.getRuntimeService(IFacePreloadBaseAdapterHelper.class, "")).getBuddyListRelationTroopView(paramView, paramViewGroup, paramContext, paramOnClickListener, paramRelationTroopEntity);
  }
  
  public void b()
  {
    ReportController.b(this.b, "dc00899", "Grp_create", "", "grptab", "friendlist_clk", f(), 0, "", "", "", "");
  }
  
  public void c()
  {
    ReportController.b(this.b, "dc00899", "Grp_create", "", "grptab", "grplist_exp", f(), 0, "", "", "", "");
  }
  
  public void d()
  {
    ReportController.b(this.b, "dc00899", "Grp_create", "", "grptab", "grplist_clk", f(), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper
 * JD-Core Version:    0.7.0.1
 */