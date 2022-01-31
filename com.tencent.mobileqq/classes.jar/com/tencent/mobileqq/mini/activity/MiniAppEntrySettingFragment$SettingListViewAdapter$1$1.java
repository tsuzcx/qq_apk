package com.tencent.mobileqq.mini.activity;

import NS_MINI_INTERFACE.INTERFACE.StSetUserSwitchRsp;
import android.os.Bundle;
import bdid;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.mini.entry.MiniAppDesktop;
import com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;
import org.json.JSONObject;

class MiniAppEntrySettingFragment$SettingListViewAdapter$1$1
  implements MiniAppCmdInterface
{
  MiniAppEntrySettingFragment$SettingListViewAdapter$1$1(MiniAppEntrySettingFragment.SettingListViewAdapter.1 param1, MiniAppSettingSwitchInfoEntity paramMiniAppSettingSwitchInfoEntity) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    QLog.d("MiniAppEntrySettingFragment", 1, "getRewardedVideoADInfo receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null)
    {
      QLog.e("MiniAppEntrySettingFragment", 1, "getRewardedVideoADInfo receive ret == null");
      return;
    }
    if (paramBoolean)
    {
      int i;
      try
      {
        INTERFACE.StSetUserSwitchRsp localStSetUserSwitchRsp = (INTERFACE.StSetUserSwitchRsp)paramJSONObject.get("setUserSwitch");
        i = paramJSONObject.getInt("retCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        QLog.d("MiniAppEntrySettingFragment", 1, "setUserSwitch receive retCode= " + i + " errMsg=" + paramJSONObject);
        if (i == 0)
        {
          MiniAppEntrySettingFragment.access$600(this.this$2.this$1.this$0, this.val$entity);
          paramJSONObject = new Bundle();
          paramJSONObject.putInt(this.val$entity.key, this.val$entity.value);
          paramJSONObject.putBoolean("refreshUI", true);
          BaseApplicationImpl.getApplication().getRuntime().notifyObservers(MiniAppDesktop.class, 102, true, paramJSONObject);
          return;
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("MiniAppEntrySettingFragment", 1, "setUserSwitch onCmdListener failed e:", paramJSONObject);
        bdid.a().a("setUserSwitch fail checklog");
        return;
      }
      QLog.e("MiniAppEntrySettingFragment", 1, new Object[] { "setUserSwitch receive retCode = ", Integer.valueOf(i) });
      bdid.a().a("setUserSwitch retCode:" + i);
      return;
    }
    QLog.e("MiniAppEntrySettingFragment", 1, new Object[] { "setUserSwitch receive isSuc = ", Boolean.valueOf(paramBoolean) });
    bdid.a().a("setUserSwitch receive isSuc false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment.SettingListViewAdapter.1.1
 * JD-Core Version:    0.7.0.1
 */