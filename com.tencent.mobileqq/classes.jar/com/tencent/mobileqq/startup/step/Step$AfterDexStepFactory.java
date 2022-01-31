package com.tencent.mobileqq.startup.step;

import azjg;
import azkx;

public class Step$AfterDexStepFactory
  implements azkx
{
  public Step a(int paramInt, azjg paramazjg, int[] paramArrayOfInt)
  {
    paramazjg = null;
    switch (paramInt)
    {
    case 7: 
    case 8: 
    case 9: 
    case 12: 
    case 20: 
    default: 
      paramazjg = new Step();
    case 30: 
      return paramazjg;
    case 6: 
    case 18: 
      return new LoadData();
    case 5: 
      return new NewRuntime();
    case 10: 
      return new InitSkin();
    case 11: 
      return new InitUrlDrawable();
    case 13: 
      return new Rdm();
    case 14: 
      return new ManageThread();
    case 16: 
      return new LoadUi();
    case 17: 
      return new LoadOtherStuff();
    case 19: 
      return new InitQzoneTracer();
    case 21: 
      return new StartServiceLiteCmp();
    case 22: 
      return new UpdateBubbleZip();
    case 23: 
      return new UpdateAvSo();
    case 24: 
      return new UpdateArkSo();
    case 25: 
      return new UpdateRMSo();
    case 26: 
      return new SetPlugin();
    case 27: 
      return new UpdatePluginVersion();
    case 28: 
      return new WebP();
    case 31: 
      return new PreInitValues();
    case 15: 
      return new InitMagnifierSDK();
    case 29: 
      return new InitHook();
    case 32: 
      return new InjectBitmap();
    case 33: 
      return new MigrateSubscribeDB();
    case 34: 
      return new UpdatePatchConfig();
    case 35: 
      return new UpdateSecureFileStrategy();
    case 36: 
      return new InstallPlugins();
    case 37: 
      return new HuayangPluginContainer();
    case 47: 
      return new StudyRoomPluginContainer();
    case 38: 
      return new ThreadHookStep();
    case 39: 
      return new QzoneTracer();
    case 40: 
      return new OpenThreadCreateHook();
    case 41: 
    case 42: 
    case 43: 
      return new HackVm();
    case 44: 
      return new BroadcastReportRegister();
    case 45: 
      return RecordTracer.a();
    case 46: 
      return new NowliveContainer();
    }
    return new GdtInitializeOnToolProcessStep();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step.AfterDexStepFactory
 * JD-Core Version:    0.7.0.1
 */