package com.tencent.mobileqq.config;

import android.content.Intent;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ConfigSeq;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.ReqGetConfig;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.RespGetConfig;
import com.tencent.qphone.base.remote.FromServiceMsg;
import java.util.List;
import mqq.app.AppRuntime;

public class BaseOldServletInjector
  implements IOldServletInjector
{
  public void a(ConfigurationService.RespGetConfig paramRespGetConfig) {}
  
  public void a(AppRuntime paramAppRuntime, Intent paramIntent, ConfigurationService.ReqGetConfig paramReqGetConfig, int[] paramArrayOfInt, List<ConfigurationService.ConfigSeq> paramList, List<Integer> paramList1, String paramString) {}
  
  public void a(AppRuntime paramAppRuntime, ConfigurationService.RespGetConfig paramRespGetConfig, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean) {}
  
  public void a(AppRuntime paramAppRuntime, ConfigurationService.RespGetConfig paramRespGetConfig, List<Integer> paramList, Intent paramIntent, int[] paramArrayOfInt, boolean paramBoolean) {}
  
  public void a(AppRuntime paramAppRuntime, List<Integer> paramList) {}
  
  public void a(int[] paramArrayOfInt, FromServiceMsg paramFromServiceMsg) {}
  
  public boolean a(AppRuntime paramAppRuntime, int[] paramArrayOfInt)
  {
    return false;
  }
  
  public int[] a()
  {
    return new int[0];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.BaseOldServletInjector
 * JD-Core Version:    0.7.0.1
 */