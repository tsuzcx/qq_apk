package com.tencent.mobileqq.kandian.glue.baseconfig;

import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/baseconfig/BaseConfig;", "Lcom/tencent/mobileqq/kandian/glue/baseconfig/IConfig;", "()V", "hasInit", "", "initConfig", "", "updateConfig", "updateOrInitConfig", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class BaseConfig
  implements IConfig
{
  public static final BaseConfig a = new BaseConfig();
  private static boolean b;
  
  public final void a()
  {
    try
    {
      if (!b)
      {
        b = true;
        b();
      }
      c();
      return;
    }
    finally {}
  }
  
  public void b()
  {
    VideoConfig.a.a();
    ReadInJoyVideoReportDataConfig.a.a();
  }
  
  public void c()
  {
    VideoConfig.a.b();
    ReadInJoyVideoReportDataConfig.a.b();
    RIJImageAladdinConfig.a.a();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.baseconfig.BaseConfig
 * JD-Core Version:    0.7.0.1
 */