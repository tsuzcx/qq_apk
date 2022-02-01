package com.tencent.smtt.sdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.tbs.video.interfaces.IUserStateChangedListener;
import com.tencent.tbs.video.interfaces.a;

class s
{
  private static s e;
  u a = null;
  Context b;
  a c;
  IUserStateChangedListener d;
  
  private s(Context paramContext)
  {
    this.b = paramContext.getApplicationContext();
    this.a = new u(this.b);
  }
  
  public static s a(Context paramContext)
  {
    try
    {
      if (e == null) {
        e = new s(paramContext);
      }
      paramContext = e;
      return paramContext;
    }
    finally {}
  }
  
  public void a(int paramInt1, int paramInt2, Intent paramIntent)
  {
    a locala = this.c;
    if (locala != null) {
      locala.a(paramInt1, paramInt2, paramIntent);
    }
  }
  
  void a(Activity paramActivity, int paramInt)
  {
    this.a.a(paramActivity, paramInt);
  }
  
  public boolean a()
  {
    this.a.a();
    return this.a.b();
  }
  
  public boolean a(String paramString, Bundle paramBundle, a parama)
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {
      localBundle = new Bundle();
    }
    if (!TextUtils.isEmpty(paramString)) {
      localBundle.putString("videoUrl", paramString);
    }
    if (parama != null)
    {
      this.a.a();
      if (!this.a.b()) {
        return false;
      }
      this.c = parama;
      this.d = new s.1(this);
      this.c.a(this.d);
      localBundle.putInt("callMode", 3);
    }
    else
    {
      localBundle.putInt("callMode", 1);
    }
    paramBundle = this.a;
    if (parama == null) {
      paramString = null;
    } else {
      paramString = this;
    }
    paramBundle.a(localBundle, paramString);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.smtt.sdk.s
 * JD-Core Version:    0.7.0.1
 */