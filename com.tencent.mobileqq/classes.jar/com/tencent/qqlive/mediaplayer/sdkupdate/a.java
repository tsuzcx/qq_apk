package com.tencent.qqlive.mediaplayer.sdkupdate;

import android.content.Context;
import com.tencent.qqlive.mediaplayer.api.TVK_SDKMgr.InstallListener;

public class a
{
  private static a a;
  private static boolean f = false;
  private boolean b = false;
  private Thread c;
  private Context d = null;
  private b e = null;
  
  public static a a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new a();
        a locala = a;
        locala.d = paramContext;
        locala.e = new b(locala.d);
        boolean bool;
        if (locala.e.a())
        {
          d.a(3, "SDKUpdate.java", "MediaPlayerMgr", "SDKUpdateHelper.helperInit success!");
          bool = true;
        }
        else
        {
          d.a(5, "SDKUpdate.java", "MediaPlayerMgr", "SDKUpdateHelper.helperInit failure!");
          bool = false;
        }
        f = bool;
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public void a()
  {
    try
    {
      if ((!this.b) && (f))
      {
        this.c = new Thread(new a.2(this));
        if (this.c != null)
        {
          this.b = true;
          this.c.setName("TVK_SDKUpdate2");
          this.c.start();
        }
        d.a(2, "SDKUpdate.java", "MediaPlayerMgr", "update ");
        return;
      }
      return;
    }
    finally {}
  }
  
  public void a(TVK_SDKMgr.InstallListener paramInstallListener)
  {
    this.e.a(paramInstallListener);
  }
  
  public void a(boolean paramBoolean)
  {
    try
    {
      boolean bool = this.b;
      if (bool) {
        return;
      }
      if (!f) {
        this.e.f();
      }
      if ((paramBoolean) && (!d.a(this.d)))
      {
        d.a(3, "SDKUpdate.java", "MediaPlayerMgr", "startWithForceAndSilent, start no wifi, cancel");
        this.e.f();
        return;
      }
      this.c = new Thread(new a.1(this));
      if (this.c != null)
      {
        this.b = true;
        this.c.setName("TVK_SDKUpdate1");
        this.c.start();
      }
      return;
    }
    finally {}
  }
  
  public boolean b()
  {
    if (f) {
      return this.e.c();
    }
    return false;
  }
  
  public String c()
  {
    if (f) {
      return this.e.g();
    }
    return null;
  }
  
  public String d()
  {
    if (f) {
      return this.e.h();
    }
    d.a(5, "SDKUpdate.java", "MediaPlayerMgr", "getLibs, return null");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.mediaplayer.sdkupdate.a
 * JD-Core Version:    0.7.0.1
 */