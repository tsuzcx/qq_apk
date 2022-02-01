package de.robv.android.xposed;

public final class XposedBridge$ToolEntryPoint
{
  protected static void main(String[] paramArrayOfString)
  {
    XposedBridge.isZygote = false;
    XposedBridge.main(paramArrayOfString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XposedBridge.ToolEntryPoint
 * JD-Core Version:    0.7.0.1
 */