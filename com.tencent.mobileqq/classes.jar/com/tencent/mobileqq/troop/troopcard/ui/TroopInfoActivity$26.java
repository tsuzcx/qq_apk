package com.tencent.mobileqq.troop.troopcard.ui;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.troop.TroopInfo;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.ITroopHandlerNameApi;
import com.tencent.mobileqq.troop.api.handler.ITroopInfoHandler;
import com.tencent.mobileqq.troop.data.TroopInfoData;
import com.tencent.mobileqq.troop.observer.TroopAuditObserver;
import com.tencent.mobileqq.troop.troopaudit.api.ITroopAuditHandler;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogBean;
import com.tencent.mobileqq.troop.troopcatalog.GroupCatalogTool;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import mqq.app.MobileQQ;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupGeoInfo;
import tencent.im.oidb.cmd0x88d.oidb_0x88d.GroupInfo;

class TroopInfoActivity$26
  extends TroopAuditObserver
{
  TroopInfoActivity$26(TroopInfoActivity paramTroopInfoActivity) {}
  
  protected void a(boolean paramBoolean, int paramInt, String paramString)
  {
    Object localObject;
    if (paramBoolean)
    {
      paramString = (ITroopInfoHandler)this.c.H.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopInfoHandlerName());
      localObject = (ITroopAuditHandler)this.c.H.getBusinessHandler(((ITroopHandlerNameApi)QRoute.api(ITroopHandlerNameApi.class)).getTroopAuditHandlerName());
      if ((paramString != null) && (localObject != null))
      {
        paramString.d(this.c.f.troopUin);
        ((ITroopAuditHandler)localObject).a(this.c.f.troopUin);
      }
    }
    else
    {
      BaseApplication localBaseApplication = BaseApplication.getContext();
      localObject = paramString;
      if (TextUtils.isEmpty(paramString)) {
        localObject = this.c.getString(2131890939);
      }
      QQToast.makeText(localBaseApplication, 1, (CharSequence)localObject, 0).show(this.c.getTitleBarHeight());
    }
  }
  
  protected void a(boolean paramBoolean, String paramString, int paramInt1, int paramInt2, int paramInt3, oidb_0x88d.GroupInfo paramGroupInfo)
  {
    if (paramBoolean)
    {
      if (!Utils.a(paramString, this.c.f.troopUin)) {
        return;
      }
      paramString = this.c;
      paramString.w = paramInt1;
      paramString.x = paramInt2;
      paramString.y = paramInt3;
      if ((paramString.w == 1) || (this.c.w == 2)) {
        this.c.H.getApplication().getSharedPreferences("auth_troop_info_filename", 4).edit().remove("has_shown_tips").commit();
      }
      if (this.c.w == 2)
      {
        paramString = paramGroupInfo.string_group_name.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramString))
        {
          this.c.f.troopName = paramString;
          this.c.a(10, paramString, true);
        }
        paramString = paramGroupInfo.group_geo_info.bytes_geocontent.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramString)) {
          this.c.a(5, paramString, true);
        }
        paramString = GroupCatalogTool.a(BaseApplication.getContext()).a(this.c, Long.toString(paramGroupInfo.uint32_group_class_ext.get()));
        if (paramString != null)
        {
          this.c.f.dwGroupClassExt = paramGroupInfo.uint32_group_class_ext.get();
          this.c.a(4, paramString.a(), true);
        }
        paramString = TroopInfo.setTags(paramGroupInfo.rpt_tag_record.get());
        if (!TextUtils.isEmpty(paramString))
        {
          this.c.f.troopTags = TroopInfo.getTags(paramString);
          paramString = this.c;
          paramString = TroopInfoActivity.a(paramString, paramString.f);
          this.c.a(8, paramString, true, 2, true);
        }
        paramString = paramGroupInfo.string_group_rich_finger_memo.get().toStringUtf8();
        if (!TextUtils.isEmpty(paramString))
        {
          this.c.f.mRichFingerMemo = paramString;
          this.c.a(6, paramString, true);
        }
      }
      TroopInfoActivity.e(this.c);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopcard.ui.TroopInfoActivity.26
 * JD-Core Version:    0.7.0.1
 */