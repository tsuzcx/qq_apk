package com.tencent.qqmini.sdk.core;

import android.content.Context;
import bdde;
import bdeo;
import bdfk;
import bdle;
import bdnm;
import bdnt;
import com.tencent.qqmini.sdk.core.proxy.MiniAppProxy;
import com.tencent.qqmini.sdk.core.proxy.ProxyManager;
import java.util.HashMap;
import java.util.Map;

public class MiniAppEnv
  implements bdnt
{
  private static final String TAG = "MiniAppEnv";
  private static MiniAppEnv sInstance;
  protected bdeo mApkgLoader = bdeo.a();
  private Map<String, bdde> mAuthStateMap = new HashMap();
  protected Context mContext;
  private String mMenuStyle = "light";
  protected bdnm sBaselibLoader = new bdfk();
  
  public static MiniAppEnv g()
  {
    return sInstance;
  }
  
  public bdeo getApkgLoader()
  {
    return this.mApkgLoader;
  }
  
  public bdde getAuthSate(String paramString)
  {
    if (this.mAuthStateMap.containsKey(paramString)) {
      return (bdde)this.mAuthStateMap.get(paramString);
    }
    synchronized (this.mAuthStateMap)
    {
      bdde localbdde = (bdde)this.mAuthStateMap.get(paramString);
      Object localObject = localbdde;
      if (localbdde == null)
      {
        localObject = ((MiniAppProxy)ProxyManager.get(MiniAppProxy.class)).getAccount();
        localObject = new bdde(getContext(), paramString, (String)localObject);
        this.mAuthStateMap.put(paramString, localObject);
      }
      return localObject;
    }
  }
  
  public bdnm getBaselibLoader()
  {
    if (bdle.a().a() != null) {
      return bdle.a().a();
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
  
  public String getMenuStyle()
  {
    return this.mMenuStyle;
  }
  
  public void init(Context paramContext)
  {
    this.mContext = paramContext;
  }
  
  public void setApkgLoader(bdeo parambdeo)
  {
    this.mApkgLoader = parambdeo;
  }
  
  @Deprecated
  public void setBaselibLoader(bdnm parambdnm)
  {
    this.sBaselibLoader = parambdnm;
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