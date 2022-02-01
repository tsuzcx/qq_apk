package com.tencent.mobileqq.miniapp;

class MiniAppManager$GetAppPkgUrlCallback
  extends MiniAppInfoCallback<MiniAppManager>
{
  public MiniAppManager$GetAppPkgUrlCallback(MiniAppManager paramMiniAppManager)
  {
    super(paramMiniAppManager);
  }
  
  public void a(MiniAppManager paramMiniAppManager, boolean paramBoolean, MiniAppInfo paramMiniAppInfo)
  {
    if (paramMiniAppManager == null) {
      return;
    }
    if (paramBoolean)
    {
      IDownloader localIDownloader = paramMiniAppManager.a(paramMiniAppInfo.j);
      if (localIDownloader != null)
      {
        MiniAppManager.a(paramMiniAppManager).a(paramMiniAppInfo, localIDownloader);
        return;
      }
    }
    MiniAppManager.a(paramMiniAppManager, paramMiniAppInfo.a, paramMiniAppInfo.b, 1002);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppManager.GetAppPkgUrlCallback
 * JD-Core Version:    0.7.0.1
 */