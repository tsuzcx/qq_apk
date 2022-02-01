package com.tencent.mobileqq.kandian.glue.viola.adapter;

import com.tencent.aladdin.config.Aladdin;
import com.tencent.aladdin.config.AladdinConfig;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.viola.experiment.IExperimentConfigManager;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/adapter/ExperimentConfigManager;", "Lcom/tencent/viola/experiment/IExperimentConfigManager;", "()V", "bindDataOpm", "", "layoutOpm", "triggerGcWhenDestroy", "getRuntimeMode", "", "isBindDataOpmOpen", "isLayoutOpmOpen", "triggerV8GcWhenDestroy", "useV8Engine", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ExperimentConfigManager
  implements IExperimentConfigManager
{
  private boolean a;
  private boolean b;
  private boolean c;
  
  public ExperimentConfigManager()
  {
    AladdinConfig localAladdinConfig = Aladdin.getConfig(478);
    boolean bool2 = false;
    if (localAladdinConfig.getIntegerFromString("bind_data_opm_open", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.a = bool1;
    if (Aladdin.getConfig(478).getIntegerFromString("layout_opm_open", 0) == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    this.b = bool1;
    boolean bool1 = bool2;
    if (Aladdin.getConfig(506).getIntegerFromString("viola_trigger_gc_when_destroy", 0) == 1) {
      bool1 = true;
    }
    this.c = bool1;
  }
  
  public int getRuntimeMode()
  {
    return ViolaSoLoaderManager.a.a().i();
  }
  
  public boolean isBindDataOpmOpen()
  {
    return this.a;
  }
  
  public boolean isLayoutOpmOpen()
  {
    return this.b;
  }
  
  public boolean triggerV8GcWhenDestroy()
  {
    return this.c;
  }
  
  public boolean useV8Engine()
  {
    return ViolaSoLoaderManager.a.a().c();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.adapter.ExperimentConfigManager
 * JD-Core Version:    0.7.0.1
 */