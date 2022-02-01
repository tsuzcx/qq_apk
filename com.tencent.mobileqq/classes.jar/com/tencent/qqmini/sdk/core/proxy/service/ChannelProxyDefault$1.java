package com.tencent.qqmini.sdk.core.proxy.service;

import NS_MINI_INTERFACE.INTERFACE.StGetAuthListRsp;
import NS_MINI_INTERFACE.INTERFACE.StUserAuthInfo;
import NS_MINI_INTERFACE.INTERFACE.StUserSettingInfo;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.qqmini.sdk.launcher.core.auth.UserAuthInfo;
import com.tencent.qqmini.sdk.launcher.core.auth.UserSettingInfo;
import com.tencent.qqmini.sdk.launcher.core.proxy.AsyncResult;
import com.tencent.qqmini.sdk.launcher.core.proxy.ChannelProxy.AuthListResult;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

class ChannelProxyDefault$1
  implements AsyncResult
{
  ChannelProxyDefault$1(ChannelProxyDefault paramChannelProxyDefault, ChannelProxy.AuthListResult paramAuthListResult) {}
  
  public void onReceiveResult(boolean paramBoolean, JSONObject paramJSONObject)
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    if ((paramBoolean) && (paramJSONObject != null))
    {
      Object localObject1 = paramJSONObject.opt("authList");
      if ((localObject1 instanceof byte[]))
      {
        paramJSONObject = new INTERFACE.StGetAuthListRsp();
        try
        {
          paramJSONObject.mergeFrom((byte[])localObject1);
          localObject1 = paramJSONObject.auths.get().iterator();
          Object localObject2;
          while (((Iterator)localObject1).hasNext())
          {
            localObject2 = (INTERFACE.StUserAuthInfo)((Iterator)localObject1).next();
            UserAuthInfo localUserAuthInfo = new UserAuthInfo();
            localUserAuthInfo.scope = ((INTERFACE.StUserAuthInfo)localObject2).scope.get();
            localUserAuthInfo.desc = ((INTERFACE.StUserAuthInfo)localObject2).desc.get();
            localUserAuthInfo.authState = ((INTERFACE.StUserAuthInfo)localObject2).authState.get();
            localArrayList1.add(localUserAuthInfo);
          }
          paramJSONObject = paramJSONObject.settings.get().iterator();
          while (paramJSONObject.hasNext())
          {
            localObject1 = (INTERFACE.StUserSettingInfo)paramJSONObject.next();
            localObject2 = new UserSettingInfo();
            ((UserSettingInfo)localObject2).settingItem = ((INTERFACE.StUserSettingInfo)localObject1).settingItem.get();
            ((UserSettingInfo)localObject2).authState = ((INTERFACE.StUserSettingInfo)localObject1).authState.get();
            ((UserSettingInfo)localObject2).desc = ((INTERFACE.StUserSettingInfo)localObject1).desc.get();
          }
          if (this.val$result != null) {
            this.val$result.onReceiveResult(true, localArrayList1, localArrayList2);
          }
          return;
        }
        catch (InvalidProtocolBufferMicroException paramJSONObject)
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append("getSetting, InvalidProtocolBufferMicroException:");
          ((StringBuilder)localObject1).append(paramJSONObject);
          QMLog.e("ChannelProxyDefault", ((StringBuilder)localObject1).toString());
          paramJSONObject.printStackTrace();
        }
      }
    }
    paramJSONObject = this.val$result;
    if (paramJSONObject != null) {
      paramJSONObject.onReceiveResult(false, localArrayList1, localArrayList2);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.proxy.service.ChannelProxyDefault.1
 * JD-Core Version:    0.7.0.1
 */