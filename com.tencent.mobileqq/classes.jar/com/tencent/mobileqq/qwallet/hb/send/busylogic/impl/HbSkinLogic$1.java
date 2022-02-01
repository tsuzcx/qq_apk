package com.tencent.mobileqq.qwallet.hb.send.busylogic.impl;

import Wallet.GetSkinListRsp;
import Wallet.PopDialog;
import Wallet.SetSelectedSkinRsp;
import Wallet.SkinInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import cooperation.qwallet.plugin.QwAdapter;
import java.util.ArrayList;
import java.util.List;
import mqq.observer.BusinessObserver;

class HbSkinLogic$1
  implements BusinessObserver
{
  HbSkinLogic$1(HbSkinLogic paramHbSkinLogic) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    Object localObject1;
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("mObserver type = ");
      ((StringBuilder)localObject1).append(paramInt);
      ((StringBuilder)localObject1).append(" isSuccess = ");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(" bundle = ");
      ((StringBuilder)localObject1).append(paramBundle);
      QLog.d("HbSkinLogic", 2, ((StringBuilder)localObject1).toString());
    }
    HbSkinLogic.a(this.a, false);
    if (paramBundle != null) {
      if (paramInt != 14)
      {
        if (paramInt != 15) {
          return;
        }
        paramBundle = (SetSelectedSkinRsp)paramBundle.getSerializable("rsp");
        if (QLog.isColorLevel())
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("SetSelectedSkinRsp = ");
          ((StringBuilder)localObject1).append(paramBundle);
          QLog.d("HbSkinLogic", 2, ((StringBuilder)localObject1).toString());
        }
      }
      else
      {
        localObject1 = HbSkinLogic.a(this.a).getList();
        ((List)localObject1).clear();
        HbSkinLogic.a(this.a, (List)localObject1);
        GetSkinListRsp localGetSkinListRsp = (GetSkinListRsp)paramBundle.getSerializable("rsp");
        if (localGetSkinListRsp != null)
        {
          Object localObject2 = this.a;
          if (localGetSkinListRsp.is_hide_list) {
            paramInt = 8;
          } else {
            paramInt = 0;
          }
          ((HbSkinLogic)localObject2).b(paramInt);
          if (localGetSkinListRsp.is_hide_list)
          {
            if (HbSkinLogic.a(this.a) == -1)
            {
              HbSkinInfo.c = HbSkinLogic.a(this.a, -1);
              return;
            }
            HbSkinLogic.b(this.a, true);
            paramBundle = this.a;
            HbSkinInfo.c = HbSkinLogic.a(paramBundle, HbSkinLogic.a(paramBundle));
            return;
          }
          HbSkinInfo.jdField_a_of_type_Boolean = paramBundle.getBoolean("isCache");
          HbSkinLogic.a(this.a, localGetSkinListRsp.selected_id);
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("rsp size = ");
            paramBundle.append(localGetSkinListRsp.skin_list.size());
            paramBundle.append(" serverSkinID = ");
            paramBundle.append(HbSkinLogic.b(this.a));
            QLog.d("HbSkinLogic", 2, paramBundle.toString());
          }
          HbSkinInfo.c = localGetSkinListRsp.selected_id;
          if (QLog.isColorLevel())
          {
            paramBundle = new StringBuilder();
            paramBundle.append("select restor: ");
            paramBundle.append(HbSkinInfo.c);
            QLog.d("HbSkinLogic", 2, paramBundle.toString());
          }
          HbSkinLogic.a(this.a).clear();
          paramInt = 0;
          while (paramInt < localGetSkinListRsp.skin_list.size())
          {
            localObject2 = (SkinInfo)localGetSkinListRsp.skin_list.get(paramInt);
            if (QLog.isColorLevel())
            {
              if (((SkinInfo)localObject2).pop_dialog != null) {
                paramBundle = String.format("{%s, %s, %s, %s, %s, %s}", new Object[] { ((SkinInfo)localObject2).pop_dialog.dialog_tips, ((SkinInfo)localObject2).pop_dialog.dialog_title, ((SkinInfo)localObject2).pop_dialog.left_tips, ((SkinInfo)localObject2).pop_dialog.left_url, ((SkinInfo)localObject2).pop_dialog.right_tips, ((SkinInfo)localObject2).pop_dialog.right_url });
              } else {
                paramBundle = "{}";
              }
              StringBuilder localStringBuilder = new StringBuilder();
              localStringBuilder.append("skin_list ");
              localStringBuilder.append(paramInt);
              localStringBuilder.append(" skin_id: ");
              localStringBuilder.append(((SkinInfo)localObject2).skin_id);
              localStringBuilder.append(", skin_permission_state: ");
              localStringBuilder.append(((SkinInfo)localObject2).skin_permission_state);
              localStringBuilder.append(", skin_name: ");
              localStringBuilder.append(((SkinInfo)localObject2).skin_name);
              localStringBuilder.append(", PopDialog: ");
              localStringBuilder.append(paramBundle);
              localStringBuilder.append(",  is_hide_title: ");
              localStringBuilder.append(((SkinInfo)localObject2).is_hide_title);
              localStringBuilder.append(", blessing: ");
              localStringBuilder.append(((SkinInfo)localObject2).blessing);
              QLog.d("HbSkinLogic", 2, localStringBuilder.toString());
            }
            paramBundle = new HbSkinInfo((SkinInfo)localObject2);
            paramInt += 1;
            paramBundle.jdField_a_of_type_Int = paramInt;
            HbSkinLogic.a(this.a).add(paramBundle);
          }
          if (!TextUtils.isEmpty(localGetSkinListRsp.more_skin_url)) {
            ((List)localObject1).add(HbSkinInfo.HbSkinFactory.c(localGetSkinListRsp.more_skin_url));
          }
        }
        HbSkinInfo.a((List)localObject1);
        HbSkinLogic.a(this.a).notifyDataSetChanged();
        paramBundle = this.a;
        HbSkinLogic.b(paramBundle, HbSkinLogic.a(paramBundle));
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qwallet.hb.send.busylogic.impl.HbSkinLogic.1
 * JD-Core Version:    0.7.0.1
 */