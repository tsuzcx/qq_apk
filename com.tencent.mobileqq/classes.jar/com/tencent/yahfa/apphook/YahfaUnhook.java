package com.tencent.yahfa.apphook;

import com.taobao.android.dexposed.callbacks.IXUnhook;
import com.tencent.qa.apphook.util.GalileoHookHelper;
import java.lang.reflect.Member;

public class YahfaUnhook
  implements IXUnhook
{
  private Member backupMethod;
  private Member hookMethod;
  
  public YahfaUnhook(Member paramMember1, Member paramMember2)
  {
    this.hookMethod = paramMember1;
    this.backupMethod = paramMember2;
  }
  
  public void unhook()
  {
    if ((this.hookMethod != null) && (this.backupMethod != null)) {
      YahfaLog.d("unhook method name is " + this.hookMethod.getName() + ",hookMethod is " + this.hookMethod + ",backupMethod is " + this.backupMethod);
    }
    YahfaHookManager.unhookMethod(GalileoHookHelper.getSignName(this.hookMethod));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.yahfa.apphook.YahfaUnhook
 * JD-Core Version:    0.7.0.1
 */