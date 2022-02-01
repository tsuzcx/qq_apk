package com.tencent.mobileqq.troop.api.troopgame.handler;

import android.os.Bundle;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.app.BusinessHandler;
import com.tencent.mobileqq.app.BusinessObserver;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.troop.troopgame.api.ITroopGameHandler;
import com.tencent.mobileqq.troop.troopgame.api.TroopGameObserver;
import com.tencent.mobileqq.troop.troopgame.data.TroopGameActivityInfo;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Set;
import tencent.im.oidb.cmd0xf3c.oidb_0xf3c.ReqBody;
import tencent.im.oidb.cmd0xf3c.oidb_0xf3c.RspBody;

public class TroopGameHandler
  extends BusinessHandler
  implements ITroopGameHandler
{
  protected Set<String> a;
  
  public TroopGameHandler(AppInterface paramAppInterface)
  {
    super(paramAppInterface);
  }
  
  private void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramToServiceMsg == null) || (paramFromServiceMsg == null)) {
      return;
    }
    String str = paramToServiceMsg.extraData.getString("troopUin");
    long l = paramToServiceMsg.extraData.getInt("appid");
    paramToServiceMsg = new oidb_0xf3c.RspBody();
    int i = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
    if (i == 0)
    {
      paramFromServiceMsg = new TroopGameActivityInfo();
      paramFromServiceMsg.activityValue = paramToServiceMsg.active_num.get();
      paramFromServiceMsg.rankNum = paramToServiceMsg.rank_num.get();
      paramFromServiceMsg.rankEntrance = paramToServiceMsg.rank_entrance.get().toStringUtf8();
      paramFromServiceMsg.iconUrl = paramToServiceMsg.icon.get().toStringUtf8();
      paramFromServiceMsg.rankText = paramToServiceMsg.rank_text.get().toStringUtf8();
      if (QLog.isColorLevel()) {
        QLog.i("TroopGameHandler", 1, "handleGetTroopGameActivityInfo succ, info = " + paramFromServiceMsg.toString());
      }
      notifyUI(TroopGameObserver.a, true, new Object[] { str, Long.valueOf(l), paramFromServiceMsg });
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopGameHandler", 1, "handleGetTroopGameActivityInfo failed, result = " + i);
    }
    notifyUI(TroopGameObserver.a, false, new Object[] { str, Long.valueOf(l), null });
  }
  
  public void a(String paramString, int paramInt)
  {
    Object localObject = new oidb_0xf3c.ReqBody();
    long l1 = 0L;
    try
    {
      long l2 = Long.valueOf(paramString).longValue();
      l1 = l2;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        localException.printStackTrace();
      }
    }
    ((oidb_0xf3c.ReqBody)localObject).group_code.set(l1);
    ((oidb_0xf3c.ReqBody)localObject).appid.set(paramInt);
    localObject = makeOIDBPkg("OidbSvcTcp.0xf3c_1", 3900, 1, ((oidb_0xf3c.ReqBody)localObject).toByteArray());
    ((ToServiceMsg)localObject).extraData.putString("troopUin", paramString);
    ((ToServiceMsg)localObject).extraData.putInt("appid", paramInt);
    sendPbReq((ToServiceMsg)localObject);
  }
  
  public Set<String> getCommandList()
  {
    if (this.a == null)
    {
      this.a = new HashSet();
      this.a.add("OidbSvcTcp.0xf3c_1");
    }
    return this.a;
  }
  
  public Class<? extends BusinessObserver> observerClass()
  {
    return TroopGameObserver.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if (paramFromServiceMsg == null) {
      if (QLog.isColorLevel()) {
        QLog.d("TroopGameHandler", 2, "onReceive,resp == null");
      }
    }
    do
    {
      String str;
      do
      {
        return;
        str = paramFromServiceMsg.getServiceCmd();
        if (!msgCmdFilter(str)) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("TroopGameHandler", 2, "cmdfilter error=" + str);
      return;
    } while (!"OidbSvcTcp.0xf3c_1".equals(paramFromServiceMsg.getServiceCmd()));
    a(paramToServiceMsg, paramFromServiceMsg, paramObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.api.troopgame.handler.TroopGameHandler
 * JD-Core Version:    0.7.0.1
 */