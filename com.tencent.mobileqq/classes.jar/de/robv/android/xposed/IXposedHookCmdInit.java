package de.robv.android.xposed;

public abstract interface IXposedHookCmdInit
  extends IXposedMod
{
  public abstract void initCmdApp(IXposedHookCmdInit.StartupParam paramStartupParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.IXposedHookCmdInit
 * JD-Core Version:    0.7.0.1
 */