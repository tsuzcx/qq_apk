package com.tencent.mobileqq.mini.entry;

import NS_MINI_INTERFACE.INTERFACE.StSetUserSwitchRsp;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class MiniAppEntrySettingFragment$SettingListViewAdapter$1$1
  implements MiniAppCmdInterface
{
  MiniAppEntrySettingFragment$SettingListViewAdapter$1$1(MiniAppEntrySettingFragment.SettingListViewAdapter.1 param1, MiniAppSettingSwitchInfoEntity paramMiniAppSettingSwitchInfoEntity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("getRewardedVideoADInfo receive isSuc= ");
    ((StringBuilder)localObject).append(paramBoolean);
    ((StringBuilder)localObject).append(" ret=");
    ((StringBuilder)localObject).append(String.valueOf(paramJSONObject));
    QLog.d("MiniAppEntrySettingFragment", 1, ((StringBuilder)localObject).toString());
    if (paramJSONObject == null)
    {
      QLog.e("MiniAppEntrySettingFragment", 1, "getRewardedVideoADInfo receive ret == null");
      return;
    }
    if (paramBoolean) {
      try
      {
        localObject = (INTERFACE.StSetUserSwitchRsp)paramJSONObject.get("setUserSwitch");
        int i = paramJSONObject.getInt("retCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setUserSwitch receive retCode= ");
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(" errMsg=");
        ((StringBuilder)localObject).append(paramJSONObject);
        QLog.d("MiniAppEntrySettingFragment", 1, ((StringBuilder)localObject).toString());
        if (i == 0)
        {
          MiniAppEntrySettingFragment.access$600(this.this$2.this$1.this$0, this.val$entity);
          paramJSONObject = new Bundle();
          paramJSONObject.putInt(this.val$entity.key, this.val$entity.value);
          paramJSONObject.putBoolean("refreshUI", true);
          BaseApplicationImpl.getApplication().getRuntime().notifyObservers(MiniAppDesktop.class, 102, true, paramJSONObject);
          return;
        }
        QLog.e("MiniAppEntrySettingFragment", 1, new Object[] { "setUserSwitch receive retCode = ", Integer.valueOf(i) });
        paramJSONObject = ToastUtil.a();
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("setUserSwitch retCode:");
        ((StringBuilder)localObject).append(i);
        paramJSONObject.a(((StringBuilder)localObject).toString());
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("MiniAppEntrySettingFragment", 1, "setUserSwitch onCmdListener failed e:", paramJSONObject);
        ToastUtil.a().a("setUserSwitch fail checklog");
        return;
      }
    }
    QLog.e("MiniAppEntrySettingFragment", 1, new Object[] { "setUserSwitch receive isSuc = ", Boolean.valueOf(paramBoolean) });
    ToastUtil.a().a("setUserSwitch receive isSuc false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.SettingListViewAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */