package com.tencent.qqmini.sdk.core;

import android.content.Context;
import behf;
import beio;
import bejk;
import bepk;
import besb;
import besh;
import beuc;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import java.util.HashMap;
import java.util.Map;

public class MiniAppEnv
  implements besh
{
  private static final String TAG = "MiniAppEnv";
  private static MiniAppEnv sInstance;
  protected beio mApkgLoader = beio.a();
  private Map<String, behf> mAuthStateMap = new HashMap();
  protected Context mContext;
  private LoginInfo mLoginInfo = new LoginInfo();
  private String mMenuStyle = "light";
  protected besb sBaselibLoader = new bejk();
  
  public static MiniAppEnv g()
  {
    return sInstance;
  }
  
  public beio getApkgLoader()
  {
    return this.mApkgLoader;
  }
  
  public behf getAuthSate(String paramString)
  {
    if (this.mAuthStateMap.containsKey(paramString)) {
      return (behf)this.mAuthStateMap.get(paramString);
    }
    synchronized (this.mAuthStateMap)
    {
      behf localbehf = (behf)this.mAuthStateMap.get(paramString);
      Object localObject = localbehf;
      if (localbehf == null)
      {
        localObject = beuc.a().a();
        localObject = new behf(getContext(), paramString, (String)localObject);
        this.mAuthStateMap.put(paramString, localObject);
      }
      return localObject;
    }
  }
  
  public besb getBaselibLoader()
  {
    if (bepk.a().a() != null) {
      return bepk.a().a();
    }
    return this.sBaselibLoader;
  }
  
  public Context getContext()
  {
    if (this.mContext == null) {
      throw new RuntimeException("Should call init() first!");
    }
    return this.mContext;
  }
  
  public LoginInfo getLoginInfo()
  {
    return this.mLoginInfo;
  }
  
  public String getMenuStyle()
  {
    return this.mMenuStyle;
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void setApkgLoader(beio parambeio)
  {
    this.mApkgLoader = parambeio;
  }
  
  @Deprecated
  public void setBaselibLoader(besb parambesb)
  {
    this.sBaselibLoader = parambesb;
  }
  
  public void setLoginInfo(LoginInfo paramLoginInfo)
  {
    this.mLoginInfo = paramLoginInfo;
  }
  
  public void setMenuStyle(String paramString)
  {
    this.mMenuStyle = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.MiniAppEnv
 * JD-Core Version:    0.7.0.1
 */