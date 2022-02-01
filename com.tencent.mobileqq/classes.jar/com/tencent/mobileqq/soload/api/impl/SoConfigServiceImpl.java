package com.tencent.mobileqq.soload.api.impl;

import android.os.Bundle;
import com.tencent.mobileqq.config.IQConfigProcessor;
import com.tencent.mobileqq.config.QConfigManager;
import com.tencent.mobileqq.qipc.QIPCClientHelper;
import com.tencent.mobileqq.soload.api.ISoConfigService;
import com.tencent.mobileqq.soload.biz.OnGetSoLoadInfoListener;
import com.tencent.mobileqq.soload.biz.entity.SoInfo;
import com.tencent.mobileqq.soload.config.SoConfigManager;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCClient;
import eipc.EIPCResult;
import java.util.Map;

public class SoConfigServiceImpl
  implements ISoConfigService
{
  private static final String TAG = "SoLoadWidget.SoConfigServiceImpl";
  
  public int getConfigId()
  {
    return 526;
  }
  
  public Map<String, SoInfo> getSoInfos()
  {
    return SoConfigManager.a().b();
  }
  
  public void getSoLoadInfoAsync(Bundle paramBundle, OnGetSoLoadInfoListener paramOnGetSoLoadInfoListener)
  {
    QIPCClientHelper.getInstance().callServer("SoLoadIPCModule", "ComIPCUtils", paramBundle, new SoConfigServiceImpl.1(this, paramOnGetSoLoadInfoListener));
  }
  
  public EIPCResult getSoLoadInfoSync(Bundle paramBundle)
  {
    return QIPCClientHelper.getInstance().getClient().callServer("SoLoadIPCModule", "ComIPCUtils", paramBundle);
  }
  
  public void notifyNetFailed(int[] paramArrayOfInt, FromServiceMsg paramFromServiceMsg)
  {
    int m = paramArrayOfInt.length;
    int i = 0;
    while (i < m)
    {
      if (paramArrayOfInt[i] == 526)
      {
        int j;
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("[notifyNetFailed] isSucc=");
          boolean bool;
          if ((paramFromServiceMsg != null) && (paramFromServiceMsg.isSuccess())) {
            bool = true;
          } else {
            bool = false;
          }
          ((StringBuilder)localObject).append(bool);
          ((StringBuilder)localObject).append(", resultCode=");
          if (paramFromServiceMsg != null) {
            j = paramFromServiceMsg.getResultCode();
          } else {
            j = -1;
          }
          ((StringBuilder)localObject).append(j);
          QLog.d("SoLoadWidget.SoConfigServiceImpl", 2, ((StringBuilder)localObject).toString());
        }
        Object localObject = QConfigManager.b().a(526);
        if (localObject != null)
        {
          int k = -2;
          j = k;
          if (paramFromServiceMsg != null)
          {
            j = k;
            if (paramFromServiceMsg.getResultCode() == 1002) {
              j = -1;
            }
          }
          ((IQConfigProcessor)localObject).onReqFailed(j);
        }
      }
      i += 1;
    }
  }
  
  public void removeSoInfo(String paramString)
  {
    if (!StringUtil.isEmpty(paramString))
    {
      Map localMap = getSoInfos();
      if (localMap != null) {
        localMap.remove(paramString);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.soload.api.impl.SoConfigServiceImpl
 * JD-Core Version:    0.7.0.1
 */