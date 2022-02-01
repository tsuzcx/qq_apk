package com.tencent.qqmini.miniapp.action;

import com.tencent.qqmini.miniapp.core.AppBrandRuntime;
import com.tencent.qqmini.sdk.launcher.core.BaseRuntime;
import com.tencent.qqmini.sdk.launcher.core.action.Action;

public class LoadSubPkgAppService
  implements Action<Boolean>
{
  private String url;
  
  public static LoadSubPkgAppService obtain(String paramString)
  {
    LoadSubPkgAppService localLoadSubPkgAppService = new LoadSubPkgAppService();
    localLoadSubPkgAppService.url = paramString;
    return localLoadSubPkgAppService;
  }
  
  public Boolean perform(BaseRuntime paramBaseRuntime)
  {
    if ((paramBaseRuntime instanceof AppBrandRuntime)) {
      ((AppBrandRuntime)paramBaseRuntime).loadSubPkgAppService(this.url);
    }
    return Boolean.valueOf(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.action.LoadSubPkgAppService
 * JD-Core Version:    0.7.0.1
 */