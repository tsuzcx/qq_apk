package com.vivo.push;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.vivo.push.util.o;
import java.io.Serializable;
import java.util.ArrayList;

public final class a
{
  private Bundle a;
  private String b;
  private String c;
  
  public a(String paramString1, String paramString2, Bundle paramBundle)
  {
    this.b = paramString1;
    this.c = paramString2;
    this.a = paramBundle;
  }
  
  public static a a(Intent paramIntent)
  {
    Object localObject2 = null;
    if (paramIntent == null)
    {
      o.a("BundleWapper", "create error : intent is null");
      return null;
    }
    Bundle localBundle = paramIntent.getExtras();
    String str1;
    if (localBundle != null)
    {
      str1 = localBundle.getString("client_pkgname");
      if (!TextUtils.isEmpty(str1)) {}
    }
    else
    {
      str1 = null;
    }
    if (TextUtils.isEmpty(str1)) {
      o.b("BundleWapper", "create warning: pkgName is null");
    }
    String str2 = paramIntent.getPackage();
    Object localObject1 = str2;
    if (TextUtils.isEmpty(str2))
    {
      if (paramIntent.getComponent() == null) {
        paramIntent = localObject2;
      } else {
        paramIntent = paramIntent.getComponent().getPackageName();
      }
      localObject1 = paramIntent;
      if (TextUtils.isEmpty(paramIntent))
      {
        o.b("BundleWapper", "create warning: targetPkgName is null");
        localObject1 = paramIntent;
      }
    }
    return new a(str1, (String)localObject1, localBundle);
  }
  
  public final String a()
  {
    return this.b;
  }
  
  public final String a(String paramString)
  {
    Bundle localBundle = this.a;
    if (localBundle == null) {
      return null;
    }
    return localBundle.getString(paramString);
  }
  
  public final void a(String paramString, int paramInt)
  {
    if (this.a == null) {
      this.a = new Bundle();
    }
    this.a.putInt(paramString, paramInt);
  }
  
  public final void a(String paramString, long paramLong)
  {
    if (this.a == null) {
      this.a = new Bundle();
    }
    this.a.putLong(paramString, paramLong);
  }
  
  public final void a(String paramString, Serializable paramSerializable)
  {
    if (this.a == null) {
      this.a = new Bundle();
    }
    this.a.putSerializable(paramString, paramSerializable);
  }
  
  public final void a(String paramString1, String paramString2)
  {
    if (this.a == null) {
      this.a = new Bundle();
    }
    this.a.putString(paramString1, paramString2);
  }
  
  public final void a(String paramString, ArrayList<String> paramArrayList)
  {
    if (this.a == null) {
      this.a = new Bundle();
    }
    this.a.putStringArrayList(paramString, paramArrayList);
  }
  
  public final void a(String paramString, boolean paramBoolean)
  {
    if (this.a == null) {
      this.a = new Bundle();
    }
    this.a.putBoolean(paramString, paramBoolean);
  }
  
  public final void a(String paramString, byte[] paramArrayOfByte)
  {
    if (this.a == null) {
      this.a = new Bundle();
    }
    this.a.putByteArray(paramString, paramArrayOfByte);
  }
  
  public final int b(String paramString, int paramInt)
  {
    Bundle localBundle = this.a;
    if (localBundle == null) {
      return paramInt;
    }
    return localBundle.getInt(paramString, paramInt);
  }
  
  public final long b(String paramString, long paramLong)
  {
    Bundle localBundle = this.a;
    if (localBundle == null) {
      return paramLong;
    }
    return localBundle.getLong(paramString, paramLong);
  }
  
  public final Bundle b()
  {
    return this.a;
  }
  
  public final byte[] b(String paramString)
  {
    Bundle localBundle = this.a;
    if (localBundle == null) {
      return null;
    }
    return localBundle.getByteArray(paramString);
  }
  
  public final ArrayList<String> c(String paramString)
  {
    Bundle localBundle = this.a;
    if (localBundle == null) {
      return null;
    }
    return localBundle.getStringArrayList(paramString);
  }
  
  public final Serializable d(String paramString)
  {
    Bundle localBundle = this.a;
    if (localBundle == null) {
      return null;
    }
    return localBundle.getSerializable(paramString);
  }
  
  public final boolean e(String paramString)
  {
    Bundle localBundle = this.a;
    if (localBundle == null) {
      return false;
    }
    return localBundle.getBoolean(paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     com.vivo.push.a
 * JD-Core Version:    0.7.0.1
 */