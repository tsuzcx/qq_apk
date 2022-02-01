package com.tencent.mobileqq.troop.shortcutbar;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import tencent.im.oidb.cmd0xe82.cmd0xe82.App;

public class TroopShortcutBarApp
  extends ShortcutBarInfo
{
  private String a;
  private int b = 0;
  private long c = 0L;
  private boolean d = false;
  private boolean e = false;
  
  public TroopShortcutBarApp(long paramLong, String paramString1, String paramString2, int paramInt)
  {
    super(paramLong, paramString1, paramString2, paramInt);
  }
  
  public static TroopShortcutBarApp a(String paramString1, String paramString2)
  {
    paramString1 = new TroopShortcutBarApp(999L, paramString1, paramString2, 0);
    paramString1.a = "local";
    return paramString1;
  }
  
  public static TroopShortcutBarApp a(cmd0xe82.App paramApp)
  {
    if (paramApp != null)
    {
      TroopShortcutBarApp localTroopShortcutBarApp = new TroopShortcutBarApp(paramApp.appid.get(), paramApp.name.get(), paramApp.icon.get(), paramApp.show_frame.get());
      localTroopShortcutBarApp.a = paramApp.url.get();
      localTroopShortcutBarApp.b = paramApp.redpoint.get();
      localTroopShortcutBarApp.c = paramApp.add_ts.get();
      return localTroopShortcutBarApp;
    }
    return null;
  }
  
  public void b(int paramInt)
  {
    this.b = paramInt;
  }
  
  public void b(boolean paramBoolean)
  {
    this.d = paramBoolean;
  }
  
  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
  
  public String h()
  {
    return this.a;
  }
  
  public int i()
  {
    return this.b;
  }
  
  public long j()
  {
    return this.c;
  }
  
  public boolean k()
  {
    return this.d;
  }
  
  public boolean l()
  {
    return this.e;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.troop.shortcutbar.TroopShortcutBarApp
 * JD-Core Version:    0.7.0.1
 */