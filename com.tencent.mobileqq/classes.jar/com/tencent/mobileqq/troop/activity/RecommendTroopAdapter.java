package com.tencent.mobileqq.troop.activity;

import NearbyGroup.GroupInfo;
import aigq;
import aigr;
import aigs;
import aigt;
import android.content.Context;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.biz.addContactTroopView.GroupViewAdapter;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.contact.troop.BaseTroopView.ITroopContext;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.RecommendTroopManagerImp;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.troop.data.NearbyTroops;
import com.tencent.mobileqq.troop.data.NearbyTroops.CustomViewHolder;
import com.tencent.mobileqq.troop.data.RecommendTroopItem;
import com.tencent.mobileqq.troop.utils.NonMainAppListViewFaceLoader;
import com.tencent.mobileqq.troop.utils.TroopUtils;
import com.tencent.mobileqq.util.FaceDrawable;
import com.tencent.util.MqqWeakReferenceHandler;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class RecommendTroopAdapter
  extends BaseAdapter
{
  Context jdField_a_of_type_AndroidContentContext;
  AppInterface jdField_a_of_type_ComTencentCommonAppAppInterface;
  protected BaseTroopView.ITroopContext a;
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  protected NonMainAppListViewFaceLoader a;
  List jdField_a_of_type_JavaUtilList;
  
  public RecommendTroopAdapter(QQAppInterface paramQQAppInterface, BaseTroopView.ITroopContext paramITroopContext, Context paramContext)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_ComTencentCommonAppAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext = paramITroopContext;
  }
  
  public RecommendTroopItem a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= getCount()) || (this.jdField_a_of_type_JavaUtilList == null) || (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      return null;
    }
    return (RecommendTroopItem)this.jdField_a_of_type_JavaUtilList.get(paramInt);
  }
  
  public void a(GroupInfo paramGroupInfo)
  {
    if (paramGroupInfo == null) {
      return;
    }
    Bundle localBundle = TroopUtils.a(17, paramGroupInfo, 14, false);
    TroopUtils.a(this.jdField_a_of_type_AndroidContentContext, localBundle, 2);
    ReportController.b(null, "CliOper", "", "", "Grp_recommend", "view_grpinfor", 0, 0, "0", "", "", "");
    ReportController.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_data", 0, 0, paramGroupInfo.lCode + "", "", "", "");
  }
  
  protected void a(View paramView, RecommendTroopItem paramRecommendTroopItem)
  {
    if (TextUtils.isEmpty(paramRecommendTroopItem.uin)) {
      return;
    }
    GroupInfo localGroupInfo = new GroupInfo();
    localGroupInfo.lCode = Long.valueOf(paramRecommendTroopItem.uin).longValue();
    localGroupInfo.strName = paramRecommendTroopItem.name;
    label59:
    Object localObject;
    if (TextUtils.isEmpty(paramRecommendTroopItem.recommendReason))
    {
      localGroupInfo.strIntro = paramRecommendTroopItem.intro;
      localGroupInfo.iMemberCnt = paramRecommendTroopItem.memberNum;
      localObject = GroupViewAdapter.a(paramRecommendTroopItem);
      if (localObject != null) {
        localGroupInfo.labels = ((ArrayList)localObject);
      }
      NearbyTroops.a(paramView, localGroupInfo, this.jdField_a_of_type_AndroidContentContext, true);
      localObject = (NearbyTroops.CustomViewHolder)paramView.getTag();
      if ((this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (!(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface instanceof QQAppInterface))) {
        break label216;
      }
      ((NearbyTroops.CustomViewHolder)localObject).c.setImageDrawable(FaceDrawable.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 4, paramRecommendTroopItem.uin));
    }
    for (;;)
    {
      paramView.setOnClickListener(new aigr(this, localGroupInfo));
      if (((NearbyTroops.CustomViewHolder)localObject).b == null) {
        break;
      }
      ((NearbyTroops.CustomViewHolder)localObject).b.setVisibility(0);
      paramView.setTag(-3, Integer.valueOf(((NearbyTroops.CustomViewHolder)localObject).b.getWidth()));
      ((NearbyTroops.CustomViewHolder)localObject).d.setOnClickListener(new aigs(this, paramRecommendTroopItem));
      return;
      localGroupInfo.strIntro = paramRecommendTroopItem.recommendReason;
      break label59;
      label216:
      if (this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader != null)
      {
        Bitmap localBitmap = this.jdField_a_of_type_ComTencentMobileqqTroopUtilsNonMainAppListViewFaceLoader.a(paramRecommendTroopItem.uin, true);
        ((NearbyTroops.CustomViewHolder)localObject).c.setImageBitmap(localBitmap);
      }
    }
  }
  
  public void a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    RecommendTroopItem localRecommendTroopItem;
    do
    {
      return;
      Iterator localIterator;
      while (!localIterator.hasNext()) {
        localIterator = this.jdField_a_of_type_JavaUtilList.iterator();
      }
      localRecommendTroopItem = (RecommendTroopItem)localIterator.next();
    } while (!paramString.equals(localRecommendTroopItem.uin));
    this.jdField_a_of_type_JavaUtilList.remove(localRecommendTroopItem);
    notifyDataSetChanged();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_JavaUtilList = paramList;
    notifyDataSetChanged();
  }
  
  public boolean a()
  {
    return (this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() > 0);
  }
  
  public void b(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    RecommendTroopManagerImp.a(this.jdField_a_of_type_ComTencentCommonAppAppInterface, 2, paramString, new aigt(this));
    a(paramString);
    if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
      this.jdField_a_of_type_ComTencentMobileqqActivityContactTroopBaseTroopView$ITroopContext.a().sendEmptyMessage(100);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null)
    {
      RecommendTroopManagerImp localRecommendTroopManagerImp = (RecommendTroopManagerImp)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(21);
      if ((this.jdField_a_of_type_JavaUtilList != null) && (this.jdField_a_of_type_JavaUtilList.size() == 0)) {
        localRecommendTroopManagerImp.a(1);
      }
      localRecommendTroopManagerImp.a(paramString);
    }
    ReportController.b(null, "P_CliOper", "Grp_recom", "", "msg_page", "Clk_unlike", 0, 0, paramString, "", "", "");
  }
  
  public int getCount()
  {
    if (this.jdField_a_of_type_JavaUtilList == null) {
      return 0;
    }
    return this.jdField_a_of_type_JavaUtilList.size();
  }
  
  public long getItemId(int paramInt)
  {
    return 0L;
  }
  
  public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
  {
    View localView = paramView;
    if (paramView == null) {
      localView = NearbyTroops.a(this.jdField_a_of_type_AndroidContentContext, paramViewGroup, 1);
    }
    paramView = a(paramInt);
    if (paramView == null) {
      return localView;
    }
    localView.setOnClickListener(new aigq(this));
    a(localView, paramView);
    return localView;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp2\com34.jar
 * Qualified Name:     com.tencent.mobileqq.troop.activity.RecommendTroopAdapter
 * JD-Core Version:    0.7.0.1
 */