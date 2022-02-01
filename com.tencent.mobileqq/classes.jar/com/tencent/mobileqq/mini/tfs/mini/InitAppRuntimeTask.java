package com.tencent.mobileqq.mini.tfs.mini;

import android.content.Context;
import com.tencent.mobileqq.mini.apkg.ApkgInfo;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;
import com.tencent.mobileqq.mini.apkg.MiniAppInfo;
import com.tencent.mobileqq.mini.app.MiniAppStateManager;
import com.tencent.mobileqq.mini.app.MiniAppStateManager.MiniAppStateMsg;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntime;
import com.tencent.mobileqq.mini.appbrand.AppBrandRuntimeContainer;
import com.tencent.mobileqq.mini.appbrand.utils.WebviewPool;
import com.tencent.mobileqq.mini.tfs.BaseTask;
import com.tencent.mobileqq.mini.tfs.MainThreadTask;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class InitAppRuntimeTask
  extends MainThreadTask
{
  public InitAppRuntimeTask(Context paramContext)
  {
    super(paramContext);
  }
  
  public void executeInMainThread()
  {
    Object localObject1 = getDependTasks();
    Object localObject2;
    if (localObject1 != null)
    {
      localObject1 = ((List)localObject1).iterator();
      do
      {
        if (!((Iterator)localObject1).hasNext()) {
          break;
        }
        localObject2 = (BaseTask)((Iterator)localObject1).next();
      } while (!(localObject2 instanceof ApkgLoadAsyncTask));
    }
    for (localObject1 = ((ApkgLoadAsyncTask)localObject2).getApkgInfo();; localObject1 = null)
    {
      if (localObject1 != null)
      {
        localObject2 = AppBrandRuntimeContainer.g().getEmptyAppRuntime();
        if (localObject2 != null) {
          ((AppBrandRuntime)localObject2).webviewPool.initWebviewEnv(this.mContext, (ApkgInfo)localObject1);
        }
        localObject1 = new MiniAppStateManager.MiniAppStateMsg(1, ((ApkgInfo)localObject1).appId, ((ApkgInfo)localObject1).appConfig.config.verType, (ApkgInfo)localObject1);
        MiniAppStateManager.getInstance().notifyChange(localObject1);
        onTaskSucceed();
        return;
      }
      QLog.i("miniapp-start", 1, "InitAppRuntimeTask apkgInfo is null!");
      onTaskFailed();
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.InitAppRuntimeTask
 * JD-Core Version:    0.7.0.1
 */