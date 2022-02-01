package com.tencent.mobileqq.kandian.biz.pts.util;

import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.kandian.biz.pts.loaders.PTSSoLoader;
import mqq.os.MqqHandler;

public class PTSLiteSwitchManager
{
  private static volatile PTSLiteSwitchManager a;
  private boolean b = false;
  private boolean c = true;
  
  public static PTSLiteSwitchManager a()
  {
    if (a == null) {
      try
      {
        if (a == null) {
          a = new PTSLiteSwitchManager();
        }
      }
      finally {}
    }
    return a;
  }
  
  private boolean e()
  {
    return this.b;
  }
  
  private boolean f()
  {
    return this.c;
  }
  
  private void g()
  {
    this.b = false;
    this.c = true;
    PTSHelper.c();
  }
  
  public boolean b()
  {
    return (f()) && (PTSSoLoader.a().b());
  }
  
  @Deprecated
  public boolean c()
  {
    return (e()) && (PTSSoLoader.a().b());
  }
  
  void d()
  {
    g();
    PTSLiteSwitchManager.1 local1 = new PTSLiteSwitchManager.1(this);
    ThreadManager.getFileThreadHandler().post(local1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes21.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.pts.util.PTSLiteSwitchManager
 * JD-Core Version:    0.7.0.1
 */