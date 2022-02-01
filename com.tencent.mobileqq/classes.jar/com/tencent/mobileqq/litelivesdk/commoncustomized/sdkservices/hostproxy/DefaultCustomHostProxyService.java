package com.tencent.mobileqq.litelivesdk.commoncustomized.sdkservices.hostproxy;

import android.content.Context;
import com.tencent.falco.base.libapi.hostproxy.AnchorTagInterface;
import com.tencent.falco.base.libapi.hostproxy.AuthInterface;
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
  protected String b;
  protected String c;
  
  public DefaultCustomHostProxyService()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(BaseApplication.getContext().getFilesDir().getAbsolutePath());
    localStringBuilder.append("/testEnv/");
    this.b = localStringBuilder.toString();
    this.c = "testserver";
  }
  
  public abstract boolean a();
  
  public String b()
  {
    return BusinessManager.a.f();
  }
  
  public void clearEventOutput() {}
  
  public AnchorTagInterface getAnchorTagInterface()
  {
    return null;
  }
  
  public AuthInterface getAuthInterface()
  {
    return null;
  }
  
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