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
      if (this.a.h == null)
      {
        l = paramLong;
      }
      else
      {
        this.a.o.dismiss();
        int i = ((ShareActionSheetBuilder.ActionSheetItemViewHolder)localObject).c.action;
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
        ((TroopShareUtility)localObject).a = ((int)paramLong);
        if (paramLong == 7L)
        {
          localObject = new Intent(((TroopShareUtility)localObject).h, Face2FaceAddFriendActivity.class);
          ((Intent)localObject).putExtra("activity_from_type", 1);
          ((Intent)localObject).putExtra("activity_troop_uin", this.a.i.troopUin);
          this.a.h.startActivity((Intent)localObject);
          l = paramLong;
        }
        else
        {
          int j = 0;
          if ((paramLong == 2L) || (paramLong == 3L))
          {
            if (!WXShareHelper.a().b()) {
              i = 2131918154;
            } else if (!WXShareHelper.a().c()) {
              i = 2131918155;
            } else {
              i = -1;
            }
            if (i != -1)
            {
              this.a.b(false);
              QQToast.makeText(this.a.h, this.a.h.getString(i), 0).show(this.a.h.getTitleBarHeight());
              localObject = this.a;
              ((TroopShareUtility)localObject).a = -1;
              ((TroopShareUtility)localObject).b = -1;
              l = paramLong;
              if (!(((TroopShareUtility)localObject).h instanceof TroopCreateLogicActivity)) {
                break label759;
              }
              ((TroopCreateLogicActivity)this.a.h).finish();
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
          if ((this.a.a == 5) && (this.a.i.isMember))
          {
            this.a.f();
            l = paramLong;
            if ((this.a.h instanceof TroopCreateLogicActivity))
            {
              ((TroopCreateLogicActivity)this.a.h).finish();
              l = paramLong;
            }
          }
          else
          {
            localObject = (TroopManager)((QQAppInterface)this.a.h.getAppRuntime()).getManager(QQManagerFactory.TROOP_MANAGER);
            if ((this.a.i.isOwnerOrAdim()) && (!((TroopManager)localObject).Z(this.a.i.troopUin)))
            {
              if ((this.a.h instanceof TroopCreateLogicActivity)) {
                this.a.k = true;
              }
              if ((TroopInfo.hasPayPrivilege(this.a.i.mTroopPrivilegeFlag, 128)) && (TroopInfo.hasPayPrivilege(this.a.i.mTroopPrivilegeFlag, 512))) {
                i = 1;
              } else {
                i = 0;
              }
              if (this.a.i.cGroupOption == 1) {
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
              if ((this.a.h instanceof TroopCreateLogicActivity)) {
                this.a.k = false;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troopshare.TroopShareUtility.1
 * JD-Core Version:    0.7.0.1
 */