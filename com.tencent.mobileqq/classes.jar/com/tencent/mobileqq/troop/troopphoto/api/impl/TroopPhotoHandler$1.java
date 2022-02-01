package com.tencent.mobileqq.troop.troopphoto.api.impl;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.api.ITroopInfoService;
import com.tencent.mobileqq.troop.api.observer.TroopObserver;
import com.tencent.mobileqq.troop.troopphoto.api.TroopPhotoObserver;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopPhotoHandler$1
  extends TroopObserver
{
  TroopPhotoHandler$1(TroopPhotoHandler paramTroopPhotoHandler, String paramString, boolean paramBoolean) {}
  
  public void onGet0x88d_Result(boolean paramBoolean, String paramString1, String paramString2, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if ((paramString1.equals(this.a)) && (paramString2.equals("SUBCMD_GET_PRIVILEGE")))
    {
      if ((paramBoolean) && (paramGroupInfo != null))
      {
        if (paramGroupInfo.uint32_app_privilege_flag.has())
        {
          int i = paramGroupInfo.uint32_app_privilege_flag.get();
          boolean bool1;
          if ((i & 0x1) != 1) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          boolean bool2;
          if ((i & 0x2) != 2) {
            bool2 = true;
          } else {
            bool2 = false;
          }
          paramGroupInfo = (ITroopInfoService)TroopPhotoHandler.a(this.c).getRuntimeService(ITroopInfoService.class, "");
          paramString2 = paramGroupInfo.findTroopInfo(this.a);
          paramString1 = paramString2;
          if (paramString2 == null)
          {
            paramString1 = new TroopInfo();
            paramString1.troopuin = this.a;
          }
          paramString1.troopPrivilegeFlag = i;
          paramGroupInfo.saveTroopInfo(paramString1);
          if (this.b) {
            this.c.b(this.a);
          }
          this.c.notifyUI(TroopPhotoObserver.c, paramBoolean, new Object[] { Boolean.valueOf(paramString1.isAdmin()), Boolean.valueOf(bool1), Boolean.valueOf(bool2), this.a });
        }
      }
      else {
        this.c.notifyUI(TroopPhotoObserver.c, paramBoolean, new Object[] { Boolean.valueOf(true), Boolean.valueOf(true), Boolean.valueOf(true), this.a });
      }
      TroopPhotoHandler.b(this.c).removeObserver(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopphoto.api.impl.TroopPhotoHandler.1
 * JD-Core Version:    0.7.0.1
 */