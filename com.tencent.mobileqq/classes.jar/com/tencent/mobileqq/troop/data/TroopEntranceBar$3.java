package com.tencent.mobileqq.troop.data;

import android.os.Bundle;
import com.tencent.biz.ProtoUtils.TroopProtocolObserver;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.troop.utils.HttpWebCgiAsyncTask2;
import com.tencent.mobileqq.troop.utils.TroopBindPublicAccountMgr;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import mqq.manager.TicketManager;
import tencent.im.oidb.cmd0x487.oidb_0x487.RspBody;

class TroopEntranceBar$3
  extends ProtoUtils.TroopProtocolObserver
{
  TroopEntranceBar$3(TroopEntranceBar paramTroopEntranceBar, long paramLong) {}
  
  public void onResult(int paramInt, byte[] paramArrayOfByte, Bundle paramBundle)
  {
    if (QLog.isColorLevel())
    {
      paramBundle = new StringBuilder();
      paramBundle.append("TroopEntranceBar fetchBindTroopInfo onResult, errorCode=");
      paramBundle.append(paramInt);
      QLog.d(".troop.troop_pubaccount", 2, paramBundle.toString());
    }
    if ((paramInt == 0) && (paramArrayOfByte != null)) {}
    for (;;)
    {
      try
      {
        Object localObject1 = new oidb_0x487.RspBody();
        ((oidb_0x487.RspBody)localObject1).mergeFrom(paramArrayOfByte);
        paramInt = ((oidb_0x487.RspBody)localObject1).uint32_result.get();
        boolean bool = QLog.isColorLevel();
        if (bool)
        {
          if (!((oidb_0x487.RspBody)localObject1).bytes_errmsg.has()) {
            break label624;
          }
          paramArrayOfByte = ((oidb_0x487.RspBody)localObject1).bytes_errmsg.get().toStringUtf8();
          paramBundle = new StringBuilder();
          paramBundle.append("fetchBindTroopInfo onResult, ret=");
          paramBundle.append(paramInt);
          paramBundle.append(",");
          paramBundle.append(paramArrayOfByte);
          QLog.d(".troop.troop_pubaccount", 2, paramBundle.toString());
        }
        if ((paramInt == 0) && (((oidb_0x487.RspBody)localObject1).uint32_groups_flag.has()))
        {
          this.b.n = ((oidb_0x487.RspBody)localObject1).uint32_groups_flag.get();
          TroopEntranceBar.a(this.b);
          this.b.notifyObservers(Integer.valueOf(0));
          return;
        }
        if ((paramInt != 0) || (!((oidb_0x487.RspBody)localObject1).uint32_follow_state.has())) {
          break label609;
        }
        paramBundle = (TroopBindPublicAccountMgr)this.b.a.getManager(QQManagerFactory.TROOP_BIND_PUBACCOUNT_MANAGER);
        paramInt = ((oidb_0x487.RspBody)localObject1).uint32_follow_state.get();
        int i = ((oidb_0x487.RspBody)localObject1).uint32_remind_flag.get();
        if (i == 1)
        {
          localObject1 = (QQAppInterface)this.mApp.get();
          if (localObject1 == null) {
            return;
          }
          String str = ((QQAppInterface)localObject1).getCurrentUin();
          Object localObject2 = (TicketManager)((QQAppInterface)localObject1).getManager(2);
          paramArrayOfByte = null;
          if (localObject2 != null) {
            paramArrayOfByte = ((TicketManager)localObject2).getSkey(str);
          }
          localObject2 = new HashMap();
          Bundle localBundle = new Bundle();
          localBundle.putString("op", "0");
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("");
          localStringBuilder.append(this.a);
          localBundle.putString("puin", localStringBuilder.toString());
          localStringBuilder = new StringBuilder();
          localStringBuilder.append("uin=");
          localStringBuilder.append(str);
          localStringBuilder.append(";skey=");
          localStringBuilder.append(paramArrayOfByte);
          localBundle.putString("Cookie", localStringBuilder.toString());
          localBundle.putString("Referer", "https://buluo.qq.com");
          ((HashMap)localObject2).put("BUNDLE", localBundle);
          ((HashMap)localObject2).put("CONTEXT", ((QQAppInterface)localObject1).getApp().getApplicationContext());
          new HttpWebCgiAsyncTask2("https://buluo.qq.com/cgi-bin/bar/extra/clean_temp_follow_state", "", new TroopEntranceBar.3.1(this, paramBundle, i), 1000, null).a((HashMap)localObject2);
        }
        paramBundle.a(this.b.c.b, paramInt, i);
        if (paramInt != 1) {
          break label609;
        }
        TroopEntranceBar.b(this.b);
        this.b.notifyObservers(Integer.valueOf(1));
        return;
      }
      catch (Exception paramArrayOfByte)
      {
        if (!QLog.isColorLevel()) {
          break label609;
        }
      }
      paramBundle = new StringBuilder();
      paramBundle.append("fetchBindTroopInfo, exception=");
      paramBundle.append(paramArrayOfByte.toString());
      QLog.d(".troop.troop_pubaccount", 2, paramBundle.toString());
      break label609;
      paramArrayOfByte = new StringBuilder();
      paramArrayOfByte.append("fetchBindTroopInfo error. errorCode=");
      paramArrayOfByte.append(paramInt);
      QLog.d(".troop.troop_pubaccount", 2, paramArrayOfByte.toString());
      label609:
      TroopEntranceBar.c(this.b);
      this.b.notifyObservers();
      return;
      label624:
      paramArrayOfByte = "";
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.data.TroopEntranceBar.3
 * JD-Core Version:    0.7.0.1
 */