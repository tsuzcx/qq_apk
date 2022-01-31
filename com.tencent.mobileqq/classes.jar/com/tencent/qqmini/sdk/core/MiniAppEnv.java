package com.tencent.qqmini.sdk.core;

import android.content.Context;
import behw;
import bejf;
import bekb;
import beqb;
import bess;
import besy;
import beut;
import com.tencent.qqmini.sdk.launcher.model.LoginInfo;
import java.util.HashMap;
import java.util.Map;

public class MiniAppEnv
  implements besy
{
  private static final String TAG = "MiniAppEnv";
  private static MiniAppEnv sInstance;
  protected bejf mApkgLoader = bejf.a();
  private Map<String, behw> mAuthStateMap = new HashMap();
  protected Context mContext;
  private LoginInfo mLoginInfo = new LoginInfo();
  private String mMenuStyle = "light";
  protected bess sBaselibLoader = new bekb();
  
  public static MiniAppEnv g()
  {
    return sInstance;
  }
  
  public bejf getApkgLoader()
  {
    return this.mApkgLoader;
  }
  
  public behw getAuthSate(String paramString)
  {
    if (this.mAuthStateMap.containsKey(paramString)) {
      return (behw)this.mAuthStateMap.get(paramString);
    }
    synchronized (this.mAuthStateMap)
    {
      behw localbehw = (behw)this.mAuthStateMap.get(paramString);
      Object localObject = localbehw;
      if (localbehw == null)
      {
        localObject = beut.a().a();
        localObject = new behw(getContext(), paramString, (String)localObject);
        this.mAuthStateMap.put(paramString, localObject);
      }
      return localObject;
    }
  }
  
  public bess getBaselibLoader()
  {
    if (beqb.a().a() != null) {
      return beqb.a().a();
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
  
  public void setApkgLoader(bejf parambejf)
  {
    this.mApkgLoader = parambejf;
  }
  
  @Deprecated
  public void setBaselibLoader(bess parambess)
  {
    this.sBaselibLoader = parambess;
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