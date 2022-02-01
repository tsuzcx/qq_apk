package com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js;

import android.content.Context;
import com.tencent.falco.utils.SPUtil;
import com.tencent.ilive.interfaces.IAudienceRoomPager;

public class App
{
  IAudienceRoomPager a;
  boolean b = false;
  private int c;
  private boolean d = false;
  private boolean e = false;
  private Context f;
  private boolean g;
  
  public App(Context paramContext, IAudienceRoomPager paramIAudienceRoomPager, int paramInt, boolean paramBoolean)
  {
    this.a = paramIAudienceRoomPager;
    this.c = paramInt;
    this.f = paramContext;
    this.g = paramBoolean;
  }
  
  public void a(boolean paramBoolean)
  {
    this.b = paramBoolean;
  }
  
  public boolean a()
  {
    Context localContext = this.f;
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (localContext != null)
    {
      bool1 = bool2;
      if (SPUtil.get(localContext, "nowlive_config").getBoolean("scrollForbidden", false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public void b()
  {
    this.a = null;
  }
  
  public void b(boolean paramBoolean) {}
  
  public void c(boolean paramBoolean)
  {
    this.e = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.litelivesdk.commoncustomized.roombizmodules.webmodule.js.App
 * JD-Core Version:    0.7.0.1
 */