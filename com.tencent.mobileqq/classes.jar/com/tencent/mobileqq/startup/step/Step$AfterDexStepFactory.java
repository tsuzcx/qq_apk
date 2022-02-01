package com.tencent.mobileqq.startup.step;

import bdho;
import bdjz;

public class Step$AfterDexStepFactory
  implements bdjz
{
  public Step a(int paramInt, bdho parambdho, int[] paramArrayOfInt)
  {
    parambdho = null;
    switch (paramInt)
    {
    case 8: 
    case 9: 
    case 10: 
    case 13: 
    case 21: 
    default: 
      parambdho = new Step();
    case 31: 
      return parambdho;
    case 7: 
    case 19: 
      return new LoadData();
    case 5: 
      return new NewRuntime();
    case 6: 
      return new LoadModule();
    case 11: 
      return new InitSkin();
    case 12: 
      return new InitUrlDrawable();
    case 14: 
      return new Rdm();
    case 15: 
      return new ManageThread();
    case 17: 
      return new LoadUi();
    case 18: 
      return new LoadOtherStuff();
    case 20: 
      return new InitQzoneTracer();
    case 22: 
      return new StartServiceLiteCmp();
    case 23: 
      return new UpdateBubbleZip();
    case 24: 
      return new AVSoUtils();
    case 25: 
      return new UpdateArkSo();
    case 26: 
      return new UpdateRMSo();
    case 27: 
      return new SetPlugin();
    case 28: 
      return new UpdatePluginVersion();
    case 29: 
      return new WebP();
    case 32: 
      return new PreInitValues();
    case 16: 
      return new InitMagnifierSDK();
    case 30: 
      return new InitHook();
    case 33: 
      return new InjectBitmap();
    case 34: 
      return new MigrateSubscribeDB();
    case 35: 
      return new UpdatePatchConfig();
    case 36: 
      return new UpdateSecureFileStrategy();
    case 37: 
      return new InstallPlugins();
    case 38: 
      return new HuayangPluginContainer();
    case 48: 
      return new StudyRoomPluginContainer();
    case 39: 
      return new ThreadHookStep();
    case 40: 
      return new QzoneTracer();
    case 41: 
      return new OpenThreadCreateHook();
    case 42: 
    case 43: 
    case 44: 
      return new HackVm();
    case 45: 
      return new BroadcastReportRegister();
    case 46: 
      return RecordTracer.a();
    case 47: 
      return new NowliveContainer();
    }
    return new GdtInitializeOnToolProcessStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step.AfterDexStepFactory
 * JD-Core Version:    0.7.0.1
 */