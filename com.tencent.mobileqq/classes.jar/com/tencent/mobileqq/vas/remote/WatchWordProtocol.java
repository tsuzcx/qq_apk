package com.tencent.mobileqq.vas.remote;

import QC.GetItemWatchWordReq;
import QC.GetItemWatchWordRsp;
import QC.GetWatchWordShareReq;
import QC.GetWatchWordShareRsp;
import QC.UniBusinessItem;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.SVIPHandler;
import com.tencent.mobileqq.config.business.qvip.QVipWatchWordConfig;
import com.tencent.mobileqq.config.business.qvip.QVipWatchWordProcessor;
import com.tencent.mobileqq.vip.JceProtocol;
import com.tencent.qphone.base.util.QLog;
import eipc.EIPCModule;
import eipc.EIPCResultCallback;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class WatchWordProtocol
  implements IWatchWordProtocol
{
  public String a(String paramString1, String paramString2)
  {
    paramString1 = Pattern.compile(paramString2).matcher(paramString1);
    if (!paramString1.find()) {}
    do
    {
      return null;
      paramString1 = paramString1.group(1);
    } while (TextUtils.isEmpty(paramString1));
    return paramString1;
  }
  
  public String a(String paramString, ArrayList<String> paramArrayList)
  {
    int i = 0;
    if (i < paramArrayList.size())
    {
      String str = (String)paramArrayList.get(i);
      if (TextUtils.isEmpty(str)) {}
      do
      {
        i += 1;
        break;
        str = a(paramString, str);
      } while (TextUtils.isEmpty(str));
      return str;
    }
    return null;
  }
  
  public void a(String paramString, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    try
    {
      paramEIPCResultCallback = QVipWatchWordProcessor.a();
      if (paramEIPCResultCallback == null) {
        break label237;
      }
      if (!paramEIPCResultCallback.isEnable()) {
        return;
      }
    }
    catch (Exception paramEIPCResultCallback)
    {
      label237:
      do
      {
        for (;;)
        {
          paramEIPCResultCallback.fillInStackTrace();
          paramEIPCResultCallback = a(paramString, "复制❤️\\$(\\S*)\\$打开QQ");
        }
      } while (paramEIPCResultCallback != null);
    }
    if (QLog.isColorLevel()) {
      QLog.d("WatchWordProtocol", 2, "loadConfig:" + paramEIPCResultCallback.getPattern() + " watchWord:" + paramString + " url:" + paramEIPCResultCallback.getWatchUrl());
    }
    if (paramEIPCResultCallback.getPattern().size() == 0) {}
    for (paramEIPCResultCallback = a(paramString, "复制❤️\\$(\\S*)\\$打开QQ");; paramEIPCResultCallback = a(paramString, paramEIPCResultCallback.getPattern()))
    {
      boolean bool = TextUtils.isEmpty(paramEIPCResultCallback);
      if (bool) {
        break;
      }
      if (QLog.isColorLevel()) {
        QLog.d("WatchWordProtocol", 2, "word:" + paramEIPCResultCallback);
      }
      new JceProtocol("QC.UniBusinessLoginServer.UniBusinessLoginObj", "QCUniBusinessLogin.watchword", "stReq", "stRsp").a("GetWatchWordShare", new GetWatchWordShareReq(SVIPHandler.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()), paramEIPCResultCallback), new GetWatchWordShareRsp(), new WatchWordProtocol.2(this, paramEIPCModule, paramInt), true);
      return;
    }
  }
  
  public void a(String paramString1, String paramString2, EIPCModule paramEIPCModule, int paramInt, EIPCResultCallback paramEIPCResultCallback)
  {
    paramEIPCResultCallback = new JceProtocol("QC.UniBusinessLoginServer.UniBusinessLoginObj", "QCUniBusinessLogin.watchword", "stReq", "stRsp");
    UniBusinessItem localUniBusinessItem = new UniBusinessItem();
    localUniBusinessItem.appid = Integer.parseInt(paramString1);
    localUniBusinessItem.itemid = Integer.parseInt(paramString2);
    paramEIPCResultCallback.a("GetItemWatchWord", new GetItemWatchWordReq(SVIPHandler.a((QQAppInterface)BaseApplicationImpl.getApplication().getRuntime()), localUniBusinessItem), new GetItemWatchWordRsp(), new WatchWordProtocol.1(this, paramEIPCModule, paramInt), true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.vas.remote.WatchWordProtocol
 * JD-Core Version:    0.7.0.1
 */