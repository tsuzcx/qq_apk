package com.tencent.mobileqq.mini.activity;

import NS_MINI_INTERFACE.INTERFACE.StGetSwitchListRsp;
import NS_MINI_INTERFACE.INTERFACE.StSwitchInfo;
import android.support.v4.app.FragmentActivity;
import bdis;
import com.tencent.mobileqq.mini.entry.MiniAppSettingSwitchInfoEntity;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
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
    QLog.d("MiniAppEntrySettingFragment", 1, "getSwitchList receive isSuc= " + paramBoolean + " ret=" + String.valueOf(paramJSONObject));
    if (paramJSONObject == null) {
      QLog.e("MiniAppEntrySettingFragment", 1, "getSwitchList receive ret == null");
    }
    int i;
    for (;;)
    {
      return;
      if (!paramBoolean) {
        break label388;
      }
      try
      {
        Object localObject = (INTERFACE.StGetSwitchListRsp)paramJSONObject.get("getSwitchList");
        i = paramJSONObject.getInt("retCode");
        paramJSONObject = paramJSONObject.getString("errMsg");
        QLog.d("MiniAppEntrySettingFragment", 1, "getSwitchList receive retCode= " + i + " errMsg=" + paramJSONObject);
        if ((i != 0) || (localObject == null)) {
          break label340;
        }
        paramJSONObject = ((INTERFACE.StGetSwitchListRsp)localObject).switchs.get();
        if ((paramJSONObject != null) && (paramJSONObject.size() > 0))
        {
          paramJSONObject = paramJSONObject.iterator();
          while (paramJSONObject.hasNext())
          {
            localObject = (INTERFACE.StSwitchInfo)paramJSONObject.next();
            if (localObject != null)
            {
              MiniAppSettingSwitchInfoEntity localMiniAppSettingSwitchInfoEntity = new MiniAppSettingSwitchInfoEntity();
              localMiniAppSettingSwitchInfoEntity.key = ((INTERFACE.StSwitchInfo)localObject).key.get();
              localMiniAppSettingSwitchInfoEntity.title = ((INTERFACE.StSwitchInfo)localObject).title.get();
              localMiniAppSettingSwitchInfoEntity.subTitle = ((INTERFACE.StSwitchInfo)localObject).desc.get();
              localMiniAppSettingSwitchInfoEntity.value = ((INTERFACE.StSwitchInfo)localObject).value.get();
              if (MiniAppEntrySettingFragment.access$000(this.this$0) == null) {
                MiniAppEntrySettingFragment.access$002(this.this$0, new ArrayList());
              }
              MiniAppEntrySettingFragment.access$000(this.this$0).add(localMiniAppSettingSwitchInfoEntity);
            }
          }
          if (MiniAppEntrySettingFragment.access$200(this.this$0) == null) {
            break label325;
          }
        }
      }
      catch (Exception paramJSONObject)
      {
        QLog.e("MiniAppEntrySettingFragment", 1, "onCmdListener failed e:", paramJSONObject);
        bdis.a().a("exception check log");
        return;
      }
    }
    MiniAppEntrySettingFragment.access$200(this.this$0).runOnUiThread(new MiniAppEntrySettingFragment.2.1(this));
    label325:
    MiniAppEntrySettingFragment.access$300(this.this$0, MiniAppEntrySettingFragment.access$000(this.this$0));
    return;
    label340:
    QLog.e("MiniAppEntrySettingFragment", 1, new Object[] { "getSwitchList receive retCode =", Integer.valueOf(i) });
    bdis.a().a("retCode:" + i);
    return;
    label388:
    QLog.e("MiniAppEntrySettingFragment", 1, new Object[] { "getSwitchList receive isSuc =", Boolean.valueOf(paramBoolean) });
    bdis.a().a("getSwitchList receive isSuc false");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.activity.MiniAppEntrySettingFragment.2
 * JD-Core Version:    0.7.0.1
 */