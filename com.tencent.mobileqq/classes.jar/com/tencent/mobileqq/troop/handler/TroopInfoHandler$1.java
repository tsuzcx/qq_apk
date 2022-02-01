package com.tencent.mobileqq.troop.handler;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.qphone.base.util.QLog;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopInfoHandler$1
  extends TroopObserver
{
  TroopInfoHandler$1(TroopInfoHandler paramTroopInfoHandler, String paramString) {}
  
  public void onGet0x88d_Result(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((paramString1.equals(this.a)) && (paramString2.equals("SUBCMD_GET_TROOP_TAG")))
    {
      paramString2 = null;
      Object localObject = null;
      String str = paramString2;
      if (paramBoolean)
      {
        str = paramString2;
        if (paramGroupInfo != null)
        {
          ITroopInfoService localITroopInfoService = (ITroopInfoService)TroopInfoHandler.a(this.b).getRuntimeService(ITroopInfoService.class, "");
          TroopInfo localTroopInfo = localITroopInfoService.findTroopInfo(paramString1);
          paramString2 = localObject;
          if (paramGroupInfo.rpt_tag_record.has())
          {
            paramString2 = localObject;
            if (paramGroupInfo.rpt_tag_record.size() > 0) {
              paramString2 = TroopInfo.setTags(paramGroupInfo.rpt_tag_record.get());
            }
          }
          str = paramString2;
          if (localTroopInfo != null)
          {
            str = paramString2;
            if (!TextUtils.isEmpty(paramString2))
            {
              localTroopInfo.mTags = paramString2;
              localITroopInfoService.saveTroopInfo(localTroopInfo);
              str = paramString2;
            }
          }
        }
      }
      this.b.notifyUI(TYPE_GET_TROOP_TAG, paramBoolean, new Object[] { paramString1, str });
      TroopInfoHandler.b(this.b).removeObserver(this);
      if (QLog.isColorLevel())
      {
        paramString2 = new StringBuilder(150);
        paramString2.append("handle_oidb_0x88d_0");
        paramString2.append("|isSuccess = ");
        paramString2.append(paramBoolean);
        paramString2.append("|troopuin = ");
        paramString2.append(paramString1);
        QLog.i("TroopInfoHandler", 2, paramString2.toString());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.handler.TroopInfoHandler.1
 * JD-Core Version:    0.7.0.1
 */