package com.tencent.mobileqq.mini.entry;

import NS_MINI_INTERFACE.INTERFACE.StGetSwitchListRsp;
import NS_MINI_INTERFACE.INTERFACE.StSwitchInfo;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.open.base.ToastUtil;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class MiniAppEntrySettingFragment$2
  implements MiniAppCmdInterface
{
  MiniAppEntrySettingFragment$2(MiniAppEntrySettingFragment paramMiniAppEntrySettingFragment) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("getSwitchList receive isSuc= ");
    ((StringBuilder)localObject1).append(paramBoolean);
    ((StringBuilder)localObject1).append(" ret=");
    ((StringBuilder)localObject1).append(String.valueOf(paramJSONObject));
    QLog.d("MiniAppEntrySettingFragment", 1, ((StringBuilder)localObject1).toString());
    if (paramJSONObject == null)
    {
      QLog.e("MiniAppEntrySettingFragment", 1, "getSwitchList receive ret == null");
      return;
    }
    if (paramBoolean)
    {
      try
      {
        localObject1 = (INTERFACE.StGetSwitchListRsp)paramJSONObject.get("getSwitchList");
        int i = paramJSONObject.getInt("retCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("getSwitchList receive retCode= ");
        ((StringBuilder)localObject2).append(i);
        ((StringBuilder)localObject2).append(" errMsg=");
        ((StringBuilder)localObject2).append(paramJSONObject);
        QLog.d("MiniAppEntrySettingFragment", 1, ((StringBuilder)localObject2).toString());
        if ((i == 0) && (localObject1 != null))
        {
          paramJSONObject = ((INTERFACE.StGetSwitchListRsp)localObject1).switchs.get();
          if ((paramJSONObject == null) || (paramJSONObject.size() <= 0)) {
            return;
          }
          paramJSONObject = paramJSONObject.iterator();
          while (paramJSONObject.hasNext())
          {
            localObject1 = (INTERFACE.StSwitchInfo)paramJSONObject.next();
            if (localObject1 != null)
            {
              localObject2 = new MiniAppSettingSwitchInfoEntity();
              ((MiniAppSettingSwitchInfoEntity)localObject2).key = ((INTERFACE.StSwitchInfo)localObject1).key.get();
              ((MiniAppSettingSwitchInfoEntity)localObject2).title = ((INTERFACE.StSwitchInfo)localObject1).title.get();
              ((MiniAppSettingSwitchInfoEntity)localObject2).subTitle = ((INTERFACE.StSwitchInfo)localObject1).desc.get();
              ((MiniAppSettingSwitchInfoEntity)localObject2).value = ((INTERFACE.StSwitchInfo)localObject1).value.get();
              if (MiniAppEntrySettingFragment.access$000(this.this$0) == null) {
                MiniAppEntrySettingFragment.access$002(this.this$0, new ArrayList());
              }
              MiniAppEntrySettingFragment.access$000(this.this$0).add(localObject2);
            }
          }
          if (MiniAppEntrySettingFragment.access$200(this.this$0) != null) {
            MiniAppEntrySettingFragment.access$200(this.this$0).runOnUiThread(new MiniAppEntrySettingFragment.2.1(this));
          }
          MiniAppEntrySettingFragment.access$300(this.this$0, MiniAppEntrySettingFragment.access$000(this.this$0));
          return;
        }
        QLog.e("MiniAppEntrySettingFragment", 1, new Object[] { "getSwitchList receive retCode =", Integer.valueOf(i) });
        paramJSONObject = ToastUtil.a();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("retCode:");
        ((StringBuilder)localObject1).append(i);
        paramJSONObject.a(((StringBuilder)localObject1).toString());
        return;
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("MiniAppEntrySettingFragment", 1, "onCmdListener failed e:", paramJSONObject);
        ToastUtil.a().a("exception check log");
        return;
      }
    }
    else
    {
      QLog.e("MiniAppEntrySettingFragment", 1, new Object[] { "getSwitchList receive isSuc =", Boolean.valueOf(paramBoolean) });
      ToastUtil.a().a("getSwitchList receive isSuc false");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.mini.entry.MiniAppEntrySettingFragment.2
 * JD-Core Version:    0.7.0.1
 */