package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.hostproxy;

import android.content.Context;
import com.tencent.falco.base.libapi.hostproxy.ClickEventInterface;
import com.tencent.falco.base.libapi.hostproxy.HostAppResInterface;
import com.tencent.falco.base.libapi.hostproxy.HostLoginInterface;
import com.tencent.falco.base.libapi.hostproxy.HostProxyInterface;
import com.tencent.falco.base.libapi.hostproxy.SdkInfoInterface;
import com.tencent.mobileqq.litelivesdk.framework.businessmgr.BusinessManager;
import com.tencent.qphone.base.util.BaseApplication;
import java.io.File;

public abstract class DefaultCustomHostProxyService
  implements HostProxyInterface
{
  public String a = BaseApplication.getContext().getFilesDir().getAbsolutePath() + "/testEnv/";
  public String b = "testserver";
  
  public String a()
  {
    return BusinessManager.a.a();
  }
  
  public abstract boolean a();
  
  public void clearEventOutput() {}
  
  public ClickEventInterface getClickEventInterface()
  {
    return null;
  }
  
  public HostAppResInterface getHostAppResInterface()
  {
    return null;
  }
  
  public HostLoginInterface getLoginInterface()
  {
    return new DefaultCustomHostProxyService.1(this);
  }
  
  public SdkInfoInterface getSdkInfoInterface()
  {
    return new DefaultCustomHostProxyService.2(this);
  }
  
  public String isUserHostBeacon()
  {
    return "1";
  }
  
  public void onCreate(Context paramContext) {}
  
  public void onDestroy() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.hostproxy.DefaultCustomHostProxyService
 * JD-Core Version:    0.7.0.1
 */