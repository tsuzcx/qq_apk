package de.robv.android.xposed;

import de.robv.android.xposed.callbacks.IXUnhook;
import java.lang.reflect.Member;

public class XC_MethodHook$Unhook
  implements IXUnhook<XC_MethodHook>
{
  private final Member hookMethod;
  
  XC_MethodHook$Unhook(XC_MethodHook paramXC_MethodHook, Member paramMember)
  {
    this.hookMethod = paramMember;
  }
  
  public XC_MethodHook getCallback()
  {
    return this.this$0;
  }
  
  public Member getHookedMethod()
  {
    return this.hookMethod;
  }
  
  public void unhook()
  {
    XposedBridge.unhookMethod(this.hookMethod, this.this$0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     de.robv.android.xposed.XC_MethodHook.Unhook
 * JD-Core Version:    0.7.0.1
 */