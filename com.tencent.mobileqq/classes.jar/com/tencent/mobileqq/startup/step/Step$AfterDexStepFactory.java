package com.tencent.mobileqq.startup.step;

import com.tencent.mobileqq.startup.director.StartupDirector;

public class Step$AfterDexStepFactory
  implements Step.IStepFactory
{
  public Step a(int paramInt, StartupDirector paramStartupDirector, int[] paramArrayOfInt)
  {
    switch (paramInt)
    {
    case 8: 
    case 9: 
    case 10: 
    case 13: 
    case 21: 
    case 49: 
    default: 
      return new Step();
    case 51: 
      return new QShadowPluginInitStep();
    case 50: 
      return new LiteLiveSDKOnToolProcessStep();
    case 48: 
      return new GdtInitializeOnToolProcessStep();
    case 47: 
      return new StudyRoomPluginContainer();
    case 46: 
      return new NowliveContainer();
    case 45: 
      return RecordTracer.a();
    case 44: 
      return new BroadcastReportRegister();
    case 41: 
    case 42: 
    case 43: 
      return new HackVm();
    case 40: 
      return new OpenThreadCreateHook();
    case 39: 
      return new QzoneTracer();
    case 38: 
      return new ThreadHookStep();
    case 37: 
      return new HuayangPluginContainer();
    case 36: 
      return new InstallPlugins();
    case 35: 
      return new UpdateSecureFileStrategy();
    case 34: 
      return new UpdatePatchConfig();
    case 33: 
      return new MigrateSubscribeDB();
    case 32: 
      return new InjectBitmap();
    case 31: 
      return new PreInitValues();
    case 30: 
      return null;
    case 29: 
      return new InitHook();
    case 28: 
      return new WebP();
    case 27: 
      return new UpdatePluginVersion();
    case 26: 
      return new SetPlugin();
    case 25: 
      return new UpdateArkSo();
    case 24: 
      return new AVSoUtils();
    case 23: 
      return new UpdateBubbleZip();
    case 22: 
      return new StartServiceLiteCmp();
    case 20: 
      return new InitQzoneTracer();
    case 18: 
      return new LoadOtherStuff();
    case 17: 
      return new LoadUi();
    case 16: 
      return new InitMagnifierSDK();
    case 15: 
      return new ManageThread();
    case 14: 
      return new Rdm();
    case 12: 
      return new InitUrlDrawable();
    case 11: 
      return new InitSkin();
    case 7: 
    case 19: 
      return new LoadData();
    case 6: 
      return new LoadModule();
    }
    return new NewRuntime();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Step.AfterDexStepFactory
 * JD-Core Version:    0.7.0.1
 */