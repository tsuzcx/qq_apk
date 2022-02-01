package com.tencent.qa.apphook;

import com.taobao.android.dexposed.callbacks.IXUnhook;

public class GalileoUnhook
  implements IXUnhook
{
  private GalileoBackupMethod backMethod;
  
  public GalileoUnhook(GalileoBackupMethod paramGalileoBackupMethod)
  {
    this.backMethod = paramGalileoBackupMethod;
  }
  
  public void unhook()
  {
    if (this.backMethod != null)
    {
      this.backMethod.setCallback(null);
      GalileoHookManager.unhookBackMethod(this.backMethod);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qa.apphook.GalileoUnhook
 * JD-Core Version:    0.7.0.1
 */