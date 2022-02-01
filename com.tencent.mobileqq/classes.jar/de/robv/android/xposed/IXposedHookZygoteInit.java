package de.robv.android.xposed;

public abstract interface IXposedHookZygoteInit
  extends IXposedMod
{
  public abstract void initZygote(IXposedHookZygoteInit.StartupParam paramStartupParam);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.IXposedHookZygoteInit
 * JD-Core Version:    0.7.0.1
 */