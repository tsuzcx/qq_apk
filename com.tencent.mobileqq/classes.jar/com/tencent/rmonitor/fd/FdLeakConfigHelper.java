package com.tencent.rmonitor.fd;

import com.tencent.rmonitor.base.config.ConfigCenter;
import com.tencent.rmonitor.base.config.ConfigProxy;
import com.tencent.rmonitor.base.config.DefaultPluginConfig;
import com.tencent.rmonitor.base.config.data.FdLeakPluginConfig;
import com.tencent.rmonitor.base.plugin.monitor.PluginController;
import com.tencent.rmonitor.common.util.AndroidVersion;
import com.tencent.rmonitor.common.util.FileUtil;
import java.io.File;

public class FdLeakConfigHelper
{
  public static File a = new File(FileUtil.e(), "fd_leak");
  private static boolean b = true;
  
  public static boolean a()
  {
    return (g().b & 0x1) != 0;
  }
  
  public static boolean b()
  {
    if (PluginController.b.a()) {
      return b;
    }
    return (g().a & 0x1) != 0;
  }
  
  public static boolean c()
  {
    if (PluginController.b.a()) {
      return true;
    }
    return (AndroidVersion.e()) && ((g().a & 0x2) != 0);
  }
  
  public static boolean d()
  {
    if (PluginController.b.a()) {
      return true;
    }
    return (g().a & 0x4) != 0;
  }
  
  public static int e()
  {
    if (PluginController.b.a()) {
      return 400;
    }
    return g().f;
  }
  
  public static DefaultPluginConfig f()
  {
    return ConfigProxy.INSTANCE.getConfig().b(151);
  }
  
  public static FdLeakPluginConfig g()
  {
    return (FdLeakPluginConfig)f().f;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.rmonitor.fd.FdLeakConfigHelper
 * JD-Core Version:    0.7.0.1
 */