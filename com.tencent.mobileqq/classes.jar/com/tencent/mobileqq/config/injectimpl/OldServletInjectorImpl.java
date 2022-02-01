package com.tencent.mobileqq.config.injectimpl;

import android.content.Intent;
import com.tencent.mobileqq.config.IOldServletInjector;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;
import mqq.app.AppRuntime;

public class OldServletInjectorImpl
  implements IOldServletInjector
{
  private final ConfigServlet a = new ConfigServlet();
  
  public void a(ConfigurationService.RespGetConfig paramRespGetConfig)
  {
    this.a.a(paramRespGetConfig);
  }
  
  public void a(AppRuntime paramAppRuntime, Intent paramIntent, ConfigurationService.ReqGetConfig paramReqGetConfig, int[] paramArrayOfInt, List<ConfigurationService.ConfigSeq> paramList, List<Integer> paramList1, String paramString)
  {
    this.a.a(paramAppRuntime, paramIntent, paramReqGetConfig, paramArrayOfInt, paramList, paramList1, paramString);
  }
  
  public void a(AppRuntime paramAppRuntime, ConfigurationService.RespGetConfig paramRespGetConfig, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.a.a(paramAppRuntime, paramRespGetConfig, paramIntent, paramArrayOfInt, paramBoolean);
  }
  
  public void a(AppRuntime paramAppRuntime, ConfigurationService.RespGetConfig paramRespGetConfig, List<Integer> paramList, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean)
  {
    this.a.a(paramAppRuntime, paramRespGetConfig, paramIntent, paramList, paramArrayOfInt, paramBoolean);
  }
  
  public void a(AppRuntime paramAppRuntime, List<Integer> paramList)
  {
    this.a.a(paramAppRuntime, paramList);
  }
  
  public void a(int[] paramArrayOfInt, FromServiceMsg paramFromServiceMsg)
  {
    this.a.a(paramArrayOfInt, paramFromServiceMsg);
  }
  
  public boolean a(AppRuntime paramAppRuntime, int[] paramArrayOfInt)
  {
    return this.a.a(paramAppRuntime, paramArrayOfInt);
  }
  
  public int[] a()
  {
    return ConfigServlet.a;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.injectimpl.OldServletInjectorImpl
 * JD-Core Version:    0.7.0.1
 */