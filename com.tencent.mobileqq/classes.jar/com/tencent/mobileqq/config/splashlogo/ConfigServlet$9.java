package com.tencent.mobileqq.config.splashlogo;

import anog;
import arcj;
import bgsg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.config.struct.splashproto.ConfigurationService.Config;
import com.tencent.mobileqq.pb.PBInt32Field;

public class ConfigServlet$9
  implements Runnable
{
  public ConfigServlet$9(arcj paramarcj, ConfigurationService.Config paramConfig) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)this.this$0.getAppRuntime();
    boolean bool = ((anog)localQQAppInterface.getManager(123)).a(this.a);
    bgsg.a(localQQAppInterface.getApp(), this.a.version.get(), bool);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.splashlogo.ConfigServlet.9
 * JD-Core Version:    0.7.0.1
 */