package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.startup.director.StartupDirector;

public class Step$AfterDexStepFactory
  implements Step.IStepFactory
{
  public Step a(int paramInt, StartupDirector paramStartupDirector, int[] paramArrayOfInt)
  {
    paramStartupDirector = null;
    switch (paramInt)
    {
    case 6: 
    case 7: 
    case 8: 
    case 11: 
    case 19: 
    default: 
      paramStartupDirector = new Step();
    case 29: 
      return paramStartupDirector;
    case 5: 
    case 17: 
      return new LoadData();
    case 4: 
      return new NewRuntime();
    case 9: 
      return new InitSkin();
    case 10: 
      return new InitUrlDrawable();
    case 12: 
      return new Rdm();
    case 13: 
      return new ManageThread();
    case 15: 
      return new LoadUi();
    case 16: 
      return new LoadOtherStuff();
    case 18: 
      return new InitQzoneTracer();
    case 20: 
      return new StartServiceLiteCmp();
    case 21: 
      return new UpdateBubbleZip();
    case 22: 
      return new UpdateAvSo();
    case 23: 
      return new UpdateArkSo();
    case 24: 
      return new UpdateRMSo();
    case 25: 
      return new SetPlugin();
    case 26: 
      return new UpdatePluginVersion();
    case 27: 
      return new WebP();
    case 30: 
      return new PreInitValues();
    case 14: 
      return new InitMagnifierSDK();
    case 28: 
      return new InitHook();
    case 31: 
      return new InjectBitmap();
    case 32: 
      return new MigrateSubscribeDB();
    case 33: 
      return new UpdatePatchConfig();
    case 34: 
      return new InstallPlugins();
    case 35: 
      return new HuayangPluginContainer();
    case 36: 
      return new ThreadHookStep();
    case 37: 
      return new QzoneTracer();
    }
    return new OpenThreadCreateHook();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step.AfterDexStepFactory
 * JD-Core Version:    0.7.0.1
 */