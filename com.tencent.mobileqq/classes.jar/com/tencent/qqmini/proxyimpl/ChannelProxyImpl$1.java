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
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult;
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
    if ((paramBoolean) && (paramJSONObject != null))
    {
      Object localObject = paramJSONObject.opt("authList");
      if ((localObject instanceof byte[]))
      {
        paramJSONObject = new INTERFACE.StGetAuthListRsp();
        try
        {
          paramJSONObject.mergeFrom((byte[])localObject);
          localObject = paramJSONObject.auths.get().iterator();
          while (((Iterator)localObject).hasNext())
          {
            INTERFACE.StUserAuthInfo localStUserAuthInfo = (INTERFACE.StUserAuthInfo)((Iterator)localObject).next();
            UserAuthInfo localUserAuthInfo = new UserAuthInfo();
            localUserAuthInfo.scope = localStUserAuthInfo.scope.get();
            localUserAuthInfo.desc = localStUserAuthInfo.desc.get();
            localUserAuthInfo.authState = localStUserAuthInfo.authState.get();
            localArrayList1.add(localUserAuthInfo);
          }
          paramJSONObject = paramJSONObject.settings.get().iterator();
          while (paramJSONObject.hasNext())
          {
            localObject = (INTERFACE.StUserSettingInfo)paramJSONObject.next();
            localArrayList2.add(ChannelProxyImpl.a(this.b, (INTERFACE.StUserSettingInfo)localObject));
          }
          if (this.a != null) {
            this.a.onReceiveResult(true, localArrayList1, localArrayList2);
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramJSONObject)
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("getSetting, InvalidProtocolBufferMicroException:");
          ((StringBuilder)localObject).append(paramJSONObject);
          QLog.e("ChannelProxyImpl", 1, ((StringBuilder)localObject).toString());
          paramJSONObject.printStackTrace();
        }
      }
    }
    paramJSONObject = this.a;
    if (paramJSONObject != null) {
      paramJSONObject.onReceiveResult(false, localArrayList1, localArrayList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ChannelProxyImpl.1
 * JD-Core Version:    0.7.0.1
 */