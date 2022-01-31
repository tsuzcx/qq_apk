package com.tencent.qqmini.proxyimpl;

import NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdInterface;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqmini.sdk.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.core.proxy.ChannelProxy.AuthListResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class ChannelProxyImpl$1
  implements MiniAppCmdInterface
{
  ChannelProxyImpl$1(ChannelProxyImpl paramChannelProxyImpl, ChannelProxy.AuthListResult paramAuthListResult) {}
  
  public void onCmdListener(boolean paramBoolean, JSONObject paramJSONObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Object localObject1;
    Object localObject2;
    if ((paramBoolean) && (paramJSONObject != null))
    {
      localObject1 = paramJSONObject.opt("authList");
      if ((localObject1 instanceof byte[]))
      {
        paramJSONObject = new INTERFACE.StGetAuthListRsp();
        try
        {
          paramJSONObject.mergeFrom((byte[])localObject1);
          localObject1 = paramJSONObject.auths.get().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (INTERFACE.StUserAuthInfo)((Iterator)localObject1).next();
            UserAuthInfo localUserAuthInfo = new UserAuthInfo();
            localUserAuthInfo.scope = ((INTERFACE.StUserAuthInfo)localObject2).scope.get();
            localUserAuthInfo.desc = ((INTERFACE.StUserAuthInfo)localObject2).desc.get();
            localUserAuthInfo.authState = ((INTERFACE.StUserAuthInfo)localObject2).authState.get();
            localArrayList1.add(localUserAuthInfo);
          }
          if (this.val$result == null) {
            break label208;
          }
        }
        catch (InvalidProtocolBufferMicroException paramJSONObject)
        {
          QLog.e("ChannelProxyImpl", 1, "getSetting, InvalidProtocolBufferMicroException:" + paramJSONObject);
          paramJSONObject.printStackTrace();
        }
      }
    }
    this.val$result.onReceiveResult(false, localArrayList1, localArrayList2);
    label208:
    do
    {
      return;
      paramJSONObject = paramJSONObject.settings.get().iterator();
      while (paramJSONObject.hasNext())
      {
        localObject1 = (INTERFACE.StUserSettingInfo)paramJSONObject.next();
        localObject2 = new UserSettingInfo();
        ((UserSettingInfo)localObject2).settingItem = ((INTERFACE.StUserSettingInfo)localObject1).settingItem.get();
        ((UserSettingInfo)localObject2).authState = ((INTERFACE.StUserSettingInfo)localObject1).authState.get();
        ((UserSettingInfo)localObject2).desc = ((INTERFACE.StUserSettingInfo)localObject1).desc.get();
      }
    } while (this.val$result == null);
    this.val$result.onReceiveResult(true, localArrayList1, localArrayList2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */