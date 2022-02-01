package com.tencent.mobileqq.troopshare;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import com.tencent.mobileqq.app.QBaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.facetoface.Face2FaceAddFriendActivity;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.troopcreate.ui.TroopCreateLogicActivity;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItemViewHolder;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class TroopShareUtility$1
  implements AdapterView.OnItemClickListener
{
  TroopShareUtility$1(TroopShareUtility paramTroopShareUtility) {}
  
  public void onItemClick(AdapterView<?> paramAdapterView, View paramView, int paramInt, long paramLong)
  {
    Object localObject = paramView.getTag();
    long l = paramLong;
    if (localObject != null) {
      if (this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity == null)
      {
        l = paramLong;
      }
      else
      {
        this.a.jdField_a_of_type_ComTencentMobileqqUtilsShareActionSheetBuilder.dismiss();
        int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).a.action;
        if (i != 1)
        {
          if (i != 2)
          {
            if (i != 3)
            {
              if (i != 9)
              {
                if (i != 10)
                {
                  if (i != 23)
                  {
                    if (i == 24) {
                      paramLong = 7L;
                    }
                  }
                  else {
                    paramLong = 5L;
                  }
                }
                else {
                  paramLong = 3L;
                }
              }
              else {
                paramLong = 2L;
              }
            }
            else {
              paramLong = 1L;
            }
          }
          else {
            paramLong = 0L;
          }
        }
        else {
          paramLong = 4L;
        }
        localObject = this.a;
        ((TroopShareUtility)localObject).jdField_a_of_type_Int = ((int)paramLong);
        if (paramLong == 7L)
        {
          localObject = new Intent(((TroopShareUtility)localObject).jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, Face2FaceAddFriendActivity.class);
          ((Intent)localObject).putExtra("activity_from_type", 1);
          ((Intent)localObject).putExtra("activity_troop_uin", this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin);
          this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.startActivity((Intent)localObject);
          l = paramLong;
        }
        else
        {
          int j = 0;
          if ((paramLong == 2L) || (paramLong == 3L))
          {
            if (!WXShareHelper.a().a()) {
              i = 2131720478;
            } else if (!WXShareHelper.a().b()) {
              i = 2131720479;
            } else {
              i = -1;
            }
            if (i != -1)
            {
              this.a.b(false);
              QQToast.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity, this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getString(i), 0).b(this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getTitleBarHeight());
              localObject = this.a;
              ((TroopShareUtility)localObject).jdField_a_of_type_Int = -1;
              ((TroopShareUtility)localObject).b = -1;
              l = paramLong;
              if (!(((TroopShareUtility)localObject).jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity)) {
                break label759;
              }
              ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).finish();
              l = paramLong;
              break label759;
            }
          }
          if (QLog.isColorLevel())
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("onItemClick.chooseChannel: ");
            ((StringBuilder)localObject).append(paramInt);
            ((StringBuilder)localObject).append(",");
            ((StringBuilder)localObject).append(paramLong);
            QLog.i("TroopShareUtility", 2, ((StringBuilder)localObject).toString());
          }
          if ((this.a.jdField_a_of_type_Int == 5) && (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isMember))
          {
            this.a.f();
            l = paramLong;
            if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity))
            {
              ((TroopCreateLogicActivity)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity).finish();
              l = paramLong;
            }
          }
          else
          {
            localObject = (TroopManager)((QQAppInterface)this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity.getAppRuntime()).getManager(QQManagerFactory.TROOP_MANAGER);
            if ((this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.isOwnerOrAdim()) && (!((TroopManager)localObject).m(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.troopUin)))
            {
              if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity)) {
                this.a.jdField_a_of_type_Boolean = true;
              }
              if ((TroopInfo.hasPayPrivilege(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.mTroopPrivilegeFlag, 512))) {
                i = 1;
              } else {
                i = 0;
              }
              if (this.a.jdField_a_of_type_ComTencentMobileqqTroopDataTroopInfoData.cGroupOption == 1) {
                j = 1;
              }
              if ((j | i) != 0)
              {
                this.a.b(true);
                this.a.c();
                l = paramLong;
              }
              else
              {
                TroopShareUtility.a(this.a);
                l = paramLong;
              }
            }
            else
            {
              this.a.b(true);
              if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQBaseActivity instanceof TroopCreateLogicActivity)) {
                this.a.jdField_a_of_type_Boolean = false;
              }
              localObject = this.a;
              ((TroopShareUtility)localObject).b = 0;
              TroopShareUtility.b((TroopShareUtility)localObject);
              l = paramLong;
            }
          }
        }
      }
    }
    label759:
    EventCollector.getInstance().onItemClick(paramAdapterView, paramView, paramInt, l);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.1
 * JD-Core Version:    0.7.0.1
 */