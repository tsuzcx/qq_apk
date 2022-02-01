package com.tencent.mobileqq.selectmember;

import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.TextView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.InnerFrameManager;
import com.tencent.mobileqq.app.AutomatorObserver;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.selectmember.util.CommonUtils;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView;
import com.tencent.widget.AbsListView.OnScrollListener;
import com.tencent.widget.SwipPinnedHeaderExpandableListView;
import mqq.app.AppRuntime;

public class TroopDiscussionTroop
  extends TroopDiscussionBaseV
  implements View.OnClickListener, AbsListView.OnScrollListener
{
  int jdField_a_of_type_Int = getResources().getDimensionPixelSize(2131299223);
  TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private AutomatorObserver jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver = new TroopDiscussionTroop.2(this);
  private TroopDiscussionMemSelectAdapter jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionMemSelectAdapter;
  private TroopDiscussionTroop.MyAvatarObserver jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyAvatarObserver;
  private TroopDiscussionTroop.MyMessageObserver jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyMessageObserver;
  private TroopDiscussionTroop.MyRoamSettingObserver jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyRoamSettingObserver;
  private TroopDiscussionTroop.MyTroopMngObserver jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopMngObserver;
  private TroopDiscussionTroop.MyTroopModifyObserver jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopModifyObserver;
  private TroopDiscussionTroop.MyTroopObserver jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopObserver;
  private SwipPinnedHeaderExpandableListView jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView;
  
  public TroopDiscussionTroop(SelectMemberActivity paramSelectMemberActivity)
  {
    super(paramSelectMemberActivity);
  }
  
  private void d()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyRoamSettingObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyRoamSettingObserver = new TroopDiscussionTroop.MyRoamSettingObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyAvatarObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyAvatarObserver = new TroopDiscussionTroop.MyAvatarObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopModifyObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopModifyObserver = new TroopDiscussionTroop.MyTroopModifyObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopMngObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopMngObserver = new TroopDiscussionTroop.MyTroopMngObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopObserver = new TroopDiscussionTroop.MyTroopObserver(this);
    }
    if (this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyMessageObserver == null) {
      this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyMessageObserver = new TroopDiscussionTroop.MyMessageObserver(this);
    }
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyRoamSettingObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopModifyObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyMessageObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.addObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
  }
  
  private void g()
  {
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyRoamSettingObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyAvatarObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopModifyObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopMngObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyTroopObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionTroop$MyMessageObserver);
    this.jdField_a_of_type_ComTencentCommonAppAppInterface.removeObserver(this.jdField_a_of_type_ComTencentMobileqqAppAutomatorObserver);
  }
  
  protected void a()
  {
    super.a();
  }
  
  public void a(Bundle paramBundle)
  {
    a(2131560460);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView = ((SwipPinnedHeaderExpandableListView)findViewById(2131381293));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131379364));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setSelector(2131167333);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setNeedCheckSpringback(true);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setGroupIndicator(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setPadding(0, 0, 0, CommonUtils.a(54.0F, getResources()));
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setChildDivider(null);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setClipToPadding(false);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setScrollBarStyle(33554432);
    this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionMemSelectAdapter = new TroopDiscussionMemSelectAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, this.jdField_a_of_type_ComTencentCommonAppAppInterface, this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView, this);
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionMemSelectAdapter);
  }
  
  public void b()
  {
    super.b();
    if (QLog.isColorLevel()) {
      QLog.d("TroopDiscussionTroop", 2, "doOnDestroy");
    }
    TroopDiscussionMemSelectAdapter localTroopDiscussionMemSelectAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionMemSelectAdapter;
    if (localTroopDiscussionMemSelectAdapter != null) {
      localTroopDiscussionMemSelectAdapter.b();
    }
    g();
    super.b();
  }
  
  public void b(Bundle paramBundle)
  {
    d();
    this.jdField_a_of_type_ComTencentWidgetSwipPinnedHeaderExpandableListView.postDelayed(new TroopDiscussionTroop.1(this), 200L);
  }
  
  void c()
  {
    TroopDiscussionMemSelectAdapter localTroopDiscussionMemSelectAdapter = this.jdField_a_of_type_ComTencentMobileqqSelectmemberTroopDiscussionMemSelectAdapter;
    if (localTroopDiscussionMemSelectAdapter != null) {
      localTroopDiscussionMemSelectAdapter.notifyDataSetChanged();
    }
  }
  
  protected void e()
  {
    super.e();
  }
  
  public void onClick(View paramView)
  {
    Object localObject2 = (TroopDiscussionMemSelectAdapter.TroopViewHolder)paramView.getTag();
    Object localObject1;
    if ((localObject2 != null) && (((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo != null))
    {
      localObject1 = ((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataTroopTroopInfo;
      boolean bool = this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity instanceof SelectMemberActivity;
      int j = 0;
      if ((bool) && (!((TroopInfo)localObject1).isAllowCreateDiscuss()) && (!((TroopInfo)localObject1).isTroopOwner(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())) && (!((TroopInfo)localObject1).isTroopAdmin(this.jdField_a_of_type_ComTencentCommonAppAppInterface.getCurrentAccountUin())))
      {
        if (TextUtils.isEmpty(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.mGroupCode)) {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, 0, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131697624), 0).b(getResources().getDimensionPixelSize(2131299168));
        } else {
          QQToast.a(this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity, 0, this.jdField_a_of_type_ComTencentMobileqqSelectmemberSelectMemberActivity.getString(2131697626), 0).b(getResources().getDimensionPixelSize(2131299168));
        }
      }
      else
      {
        Object localObject3 = new Bundle();
        ((Bundle)localObject3).putString("group_uin", ((TroopInfo)localObject1).troopuin);
        ((Bundle)localObject3).putString("group_name", ((TroopInfo)localObject1).getTroopDisplayName());
        this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(6, (Bundle)localObject3);
        int k = ((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject2).jdField_a_of_type_Int;
        int i = j;
        if (k != 1) {
          if (k != 3)
          {
            if (k != 5)
            {
              if (k != 7) {
                i = j;
              } else {
                i = 2;
              }
            }
            else {
              i = 1;
            }
          }
          else {
            i = 3;
          }
        }
        localObject2 = this.jdField_a_of_type_ComTencentCommonAppAppInterface;
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((TroopInfo)localObject1).troopuin);
        ((StringBuilder)localObject3).append("");
        ReportController.b((AppRuntime)localObject2, "P_CliOper", "Grp_contacts", "", "choose_grp", "create_discuss", 0, 0, ((StringBuilder)localObject3).toString(), String.valueOf(i), "", "");
      }
    }
    else if ((localObject2 != null) && (((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo != null))
    {
      localObject1 = ((TroopDiscussionMemSelectAdapter.TroopViewHolder)localObject2).jdField_a_of_type_ComTencentMobileqqDataDiscussionInfo;
      localObject2 = new Bundle();
      ((Bundle)localObject2).putString("group_uin", ((DiscussionInfo)localObject1).uin);
      ((Bundle)localObject2).putString("group_name", ((DiscussionInfo)localObject1).discussionName);
      this.jdField_a_of_type_ComTencentCommonAppInnerFrameManager.a(7, (Bundle)localObject2);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
  
  public void onScroll(AbsListView paramAbsListView, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onScrollStateChanged(AbsListView paramAbsListView, int paramInt) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.selectmember.TroopDiscussionTroop
 * JD-Core Version:    0.7.0.1
 */