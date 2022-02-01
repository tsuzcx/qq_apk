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
  private int jdField_a_of_type_Int = -1;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  IRelationFriendsSearchHelper jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateIRelationFriendsSearchHelper;
  private IRelationFriendsTroopViewHelper.CallBack jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiIRelationFriendsTroopViewHelper$CallBack;
  PinnedFooterExpandableListView jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
  private String jdField_a_of_type_JavaLangString = "";
  private ArrayList<Entity> jdField_a_of_type_JavaUtilArrayList = new ArrayList();
  private HashMap<String, Long> jdField_a_of_type_JavaUtilHashMap = new HashMap();
  private ArrayList<Entity> b = new ArrayList();
  
  public RelationFriendsTroopViewHelper(AppInterface paramAppInterface, PinnedFooterExpandableListView paramPinnedFooterExpandableListView, IRelationFriendsTroopViewHelper.CallBack paramCallBack)
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramAppInterface;
    this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView = paramPinnedFooterExpandableListView;
    this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiIRelationFriendsTroopViewHelper$CallBack = paramCallBack;
    this.jdField_a_of_type_ComTencentMobileqqTroopApiTroopcreateIRelationFriendsSearchHelper = ((IRelationFriendsSearchHelper)QRoute.api(IRelationFriendsSearchHelper.class));
  }
  
  private int a()
  {
    int i = this.jdField_a_of_type_Int;
    if (i == 3) {
      return 3;
    }
    if (i == 2) {
      return 2;
    }
    if (i == 1) {
      return 1;
    }
    if (i == 4) {
      return 4;
    }
    return 0;
  }
  
  private void a(String paramString)
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
    if ((ITroopCreateService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopCreateService.class, "") != null)
    {
      ArrayList localArrayList = this.jdField_a_of_type_ComTencentMobileqqTroopTroopcreateApiIRelationFriendsTroopViewHelper$CallBack.a();
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
        ((ITroopSearchService)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(ITroopSearchService.class, "")).search((ArrayList)localObject, true, new RelationFriendsTroopViewHelper.4(this));
      }
    }
  }
  
  public View a(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, RelationTroopEntity paramRelationTroopEntity)
  {
    return ((IFacePreloadBaseAdapterHelper)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFacePreloadBaseAdapterHelper.class, "")).getContactListRelationTroopView(paramView, paramViewGroup, paramContext, paramOnClickListener, paramRelationTroopEntity);
  }
  
  public Long a(String paramString)
  {
    if (!TextUtils.isEmpty(paramString)) {
      return (Long)this.jdField_a_of_type_JavaUtilHashMap.get(paramString);
    }
    if (QLog.isColorLevel()) {
      QLog.i("RelationFriendsTroopViewHelper", 2, "getRelationTroopChildId troopUin empty");
    }
    return Long.valueOf(-1L);
  }
  
  public void a()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_create", "", "grptab", "friendlist_exp", a(), 0, "", "", "", "");
  }
  
  public void a(ResultRecord paramResultRecord)
  {
    this.jdField_a_of_type_Int = 1;
    if (paramResultRecord != null)
    {
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onSearchResult:,currentRelationUin:");
        localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
        localStringBuilder.append(",lastrecordUIN:");
        localStringBuilder.append(paramResultRecord.uin);
        QLog.i("RelationFriendsTroopViewHelper", 2, localStringBuilder.toString());
      }
      if (!this.jdField_a_of_type_JavaLangString.equals(paramResultRecord.uin))
      {
        this.jdField_a_of_type_JavaLangString = paramResultRecord.uin;
        if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
        {
          a(this.jdField_a_of_type_JavaLangString);
          e();
        }
      }
    }
    else
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "onSearchResult lastRecord null");
      }
      this.jdField_a_of_type_JavaLangString = "";
      paramResultRecord = this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
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
        this.jdField_a_of_type_Int = 3;
      } else if (paramInt == 39) {
        this.jdField_a_of_type_Int = 4;
      } else {
        this.jdField_a_of_type_Int = 2;
      }
      if (paramResultRecord != null)
      {
        if (QLog.isColorLevel())
        {
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("onSearchResult:,currentRelationUin:");
          localStringBuilder.append(this.jdField_a_of_type_JavaLangString);
          localStringBuilder.append(",lastrecordUIN:");
          localStringBuilder.append(paramResultRecord.uin);
          QLog.i("RelationFriendsTroopViewHelper", 2, localStringBuilder.toString());
        }
        if (!this.jdField_a_of_type_JavaLangString.equals(paramResultRecord.uin))
        {
          this.jdField_a_of_type_JavaLangString = paramResultRecord.uin;
          if (!TextUtils.isEmpty(this.jdField_a_of_type_JavaLangString))
          {
            a(this.jdField_a_of_type_JavaLangString);
            if ((paramInt == 29) || (paramInt == 39)) {
              e();
            }
          }
        }
      }
      else
      {
        paramResultRecord = this.jdField_a_of_type_ComTencentWidgetPinnedFooterExpandableListView;
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
    int i;
    Object localObject2;
    if (!this.b.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "loadData relationtroop");
      }
      this.jdField_a_of_type_JavaUtilHashMap.clear();
      localObject1 = new ArrayList();
      i = 0;
      while (i < this.b.size())
      {
        localObject2 = (RelationTroopEntity)this.b.get(i);
        ((ArrayList)localObject1).add(localObject2);
        this.jdField_a_of_type_JavaUtilHashMap.put(((RelationTroopEntity)localObject2).troopInfo.troopuin, Long.valueOf(i + 1L));
        i += 1;
      }
      localObject2 = new Groups();
      ((Groups)localObject2).group_id = 1008;
      ((Groups)localObject2).group_name = HardCodeUtil.a(2131718185);
      ((Groups)localObject2).group_friend_count = ((ArrayList)localObject1).size();
      ((Groups)localObject2).seqid = 0;
      paramArrayList.add(localObject2);
      paramSparseArray.put(((Groups)localObject2).group_id, localObject1);
    }
    if (!this.jdField_a_of_type_JavaUtilArrayList.isEmpty())
    {
      if (QLog.isColorLevel()) {
        QLog.i("RelationFriendsTroopViewHelper", 2, "loadData relationfriends");
      }
      localObject1 = new Groups();
      localObject2 = new ArrayList();
      i = 0;
      while (i < this.jdField_a_of_type_JavaUtilArrayList.size())
      {
        ((ArrayList)localObject2).add(this.jdField_a_of_type_JavaUtilArrayList.get(i));
        i += 1;
      }
      ((Groups)localObject1).group_id = 1007;
      ((Groups)localObject1).group_name = HardCodeUtil.a(2131718184);
      ((Groups)localObject1).group_friend_count = ((ArrayList)localObject2).size();
      ((Groups)localObject1).seqid = 0;
      paramArrayList.add(localObject1);
      paramSparseArray.put(((Groups)localObject1).group_id, localObject2);
    }
  }
  
  public View b(int paramInt1, int paramInt2, View paramView, ViewGroup paramViewGroup, Context paramContext, View.OnClickListener paramOnClickListener, RelationTroopEntity paramRelationTroopEntity)
  {
    return ((IFacePreloadBaseAdapterHelper)this.jdField_a_of_type_ComTencentCommonAppAppInterface.getRuntimeService(IFacePreloadBaseAdapterHelper.class, "")).getBuddyListRelationTroopView(paramView, paramViewGroup, paramContext, paramOnClickListener, paramRelationTroopEntity);
  }
  
  public void b()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_create", "", "grptab", "friendlist_clk", a(), 0, "", "", "", "");
  }
  
  public void c()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_create", "", "grptab", "grplist_exp", a(), 0, "", "", "", "");
  }
  
  public void d()
  {
    ReportController.b(this.jdField_a_of_type_ComTencentCommonAppAppInterface, "dc00899", "Grp_create", "", "grptab", "grplist_clk", a(), 0, "", "", "", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcreate.ui.RelationFriendsTroopViewHelper
 * JD-Core Version:    0.7.0.1
 */