package com.tencent.mobileqq.miniapp;

import java.util.Map;

class MiniAppManager$GetAppInfoCallback
  extends MiniAppInfoCallback<MiniAppManager>
{
  public MiniAppManager$GetAppInfoCallback(MiniAppManager paramMiniAppManager)
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
      MiniAppManager.a(paramMiniAppManager, (IApp)MiniAppManager.b(paramMiniAppManager).get(paramMiniAppInfo.p));
      return;
    }
    MiniAppManager.a(paramMiniAppManager, paramMiniAppInfo.a, paramMiniAppInfo.b, 1001);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.miniapp.MiniAppManager.GetAppInfoCallback
 * JD-Core Version:    0.7.0.1
 */