package com.tencent.mobileqq.newnearby.hippy.impl;

import android.text.TextUtils;
import com.tencent.common.app.AppInterface;
import com.tencent.hippy.qq.utils.HippyUtils;
import com.tencent.mobileqq.newnearby.hippy.INearbyHippyApi;
import com.tencent.mobileqq.newnearby.hippy.NearbyHippyApiProvider;
import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.tianshu.api.IRedTouchManager;
import com.tencent.mobileqq.tianshu.pb.BusinessInfoCheckUpdate.AppInfo;
import com.tencent.mtt.hippy.HippyAPIProvider;
import mqq.app.MobileQQ;

public class NearbyHippyApiImpl
  implements INearbyHippyApi
{
  public HippyAPIProvider getNearbyHippyAPIProvider()
  {
    return new NearbyHippyApiProvider();
  }
  
  public boolean hasNewMessage()
  {
    if (MobileQQ.sProcessId != 1) {
      return false;
    }
    Object localObject1 = HippyUtils.getAppInterface();
    if (localObject1 == null) {
      return false;
    }
    Object localObject2 = (IRedTouchManager)((AppInterface)localObject1).getRuntimeService(IRedTouchManager.class, "");
    localObject1 = ((IRedTouchManager)localObject2).getAppInfoByPath(String.valueOf(7719));
    BusinessInfoCheckUpdate.AppInfo localAppInfo1 = ((IRedTouchManager)localObject2).getAppInfoByPath(String.valueOf(771901));
    BusinessInfoCheckUpdate.AppInfo localAppInfo2 = ((IRedTouchManager)localObject2).getAppInfoByPath(String.valueOf(771902));
    BusinessInfoCheckUpdate.AppInfo localAppInfo3 = ((IRedTouchManager)localObject2).getAppInfoByPath(String.valueOf(771903));
    localObject2 = ((IRedTouchManager)localObject2).getAppInfoByPath(String.valueOf(771904));
    return ((localObject1 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.has()) && (((BusinessInfoCheckUpdate.AppInfo)localObject1).iNewFlag.get() == 1)) || ((localAppInfo1 != null) && (localAppInfo1.iNewFlag.has()) && (localAppInfo1.iNewFlag.get() == 1)) || ((localAppInfo2 != null) && (localAppInfo2.iNewFlag.has()) && (localAppInfo2.iNewFlag.get() == 1)) || ((localAppInfo3 != null) && (localAppInfo3.iNewFlag.has()) && (localAppInfo3.iNewFlag.get() == 1)) || ((localObject2 != null) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.has()) && (((BusinessInfoCheckUpdate.AppInfo)localObject2).iNewFlag.get() == 1));
  }
  
  public boolean isCanPreload()
  {
    return true;
  }
  
  public boolean isNearbyModule(String paramString)
  {
    return TextUtils.equals(paramString, "QQNearby");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.newnearby.hippy.impl.NearbyHippyApiImpl
 * JD-Core Version:    0.7.0.1
 */