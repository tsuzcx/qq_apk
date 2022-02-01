package com.tencent.qqmini.miniapp.core.worker;

import android.text.TextUtils;
import com.tencent.qqmini.miniapp.action.WorkerAction;
import com.tencent.qqmini.sdk.core.BaseRuntimeImpl.BaselibProvider;
import com.tencent.qqmini.sdk.launcher.core.IMiniAppContext;
import com.tencent.qqmini.sdk.launcher.core.model.ApkgInfo;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.model.ApkgBaseInfo;
import com.tencent.qqmini.sdk.launcher.model.MiniAppInfo;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import java.util.ArrayList;

public class MiniAppWorkerManager
{
  public static final int MODE_JSCORE = 1;
  public static final int MODE_WEBVIEW = 0;
  public static final String OBJ_WEIXINWORKER = "WeixinWorker";
  public static final String TAG = "minisdk-worker";
  private static volatile MiniAppWorker mWorker;
  private IMiniAppContext mMiniAppContext;
  private String mWAWorkerJsStr;
  private String mWorkerRunnableStr;
  private ArrayList<String> messagePendingList = new ArrayList();
  private int workerVmMode;
  
  public MiniAppWorkerManager(IMiniAppContext paramIMiniAppContext)
  {
    this.mMiniAppContext = paramIMiniAppContext;
    paramIMiniAppContext = ((BaseRuntimeImpl.BaselibProvider)paramIMiniAppContext.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBaselibContent();
    if (paramIMiniAppContext != null) {
      this.mWAWorkerJsStr = paramIMiniAppContext.waWorkerStr;
    }
  }
  
  private void handlePendingMsgList()
  {
    try
    {
      if ((mWorker != null) && (mWorker.isJSContextValid())) {
        mWorker.postMessageListToWorker(this.messagePendingList);
      } else {
        QMLog.e("minisdk-worker", "[handlePendingMsgList] failed : worker null/jsctx failed !");
      }
      return;
    }
    finally {}
  }
  
  public MiniAppWorker createRelWorker()
  {
    QMLog.i("minisdk-worker", "[createWorker]");
    try
    {
      if ((mWorker != null) && (!mWorker.isTerminated())) {
        throw new Exception("Worker already created and running!");
      }
      mWorker = new MiniAppWorker(this.mMiniAppContext, this);
      MiniAppWorker localMiniAppWorker = mWorker;
      return localMiniAppWorker;
    }
    finally {}
  }
  
  public int createWorker(String paramString)
  {
    QMLog.i("minisdk-worker", "[handleCreateWorker]");
    setWorkerVmMode(WorkerAction.obtain(this.mMiniAppContext).getWorkerMode());
    Object localObject;
    if (TextUtils.isEmpty(this.mWAWorkerJsStr))
    {
      localObject = ((BaseRuntimeImpl.BaselibProvider)this.mMiniAppContext.getManager(BaseRuntimeImpl.BaselibProvider.class)).getBaselibContent();
      if (localObject != null) {
        this.mWAWorkerJsStr = ((BaselibLoader.BaselibContent)localObject).waWorkerStr;
      }
    }
    if (TextUtils.isEmpty(this.mWAWorkerJsStr))
    {
      QMLog.e("minisdk-worker", "[handleCreateWorker] error : waWorker.js is missing");
      return 0;
    }
    if ((this.mMiniAppContext.getMiniAppInfo() != null) && (this.mMiniAppContext.getMiniAppInfo().apkgInfo != null))
    {
      if (TextUtils.isEmpty(this.mMiniAppContext.getMiniAppInfo().apkgInfo.getWorkerPath(null, paramString)))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[handleCreateWorker] error : 001 executed js file ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" is missing");
        QMLog.e("minisdk-worker", ((StringBuilder)localObject).toString());
        return -1;
      }
      localObject = ((ApkgInfo)this.mMiniAppContext.getMiniAppInfo().apkgInfo).getWorkerJsContent(null, paramString);
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("[handleCreateWorker] error : 002 executed js file ");
        ((StringBuilder)localObject).append(paramString);
        ((StringBuilder)localObject).append(" is missing");
        QMLog.e("minisdk-worker", ((StringBuilder)localObject).toString());
        return -1;
      }
      this.mWorkerRunnableStr = ((String)localObject);
      try
      {
        createRelWorker().initJSContext();
        return 1;
      }
      catch (Exception paramString)
      {
        QMLog.e("minisdk-worker", "[handleCreateWorker] failed : ", paramString);
        return 0;
      }
    }
    QMLog.e("minisdk-worker", "[handleCreateWorker] error : apkgInfo is missing");
    return 0;
  }
  
  public int getWorkerVmMode()
  {
    return this.workerVmMode;
  }
  
  public void handlePostMsgToWorker(String paramString)
  {
    try
    {
      if ((mWorker != null) && (mWorker.isJSContextValid()))
      {
        mWorker.postMessageToWorker(paramString);
      }
      else
      {
        if (this.messagePendingList == null) {
          this.messagePendingList = new ArrayList();
        }
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("[handlePostMsgToWorker] messagePendingList.add:");
        localStringBuilder.append(paramString);
        QMLog.i("minisdk-worker", localStringBuilder.toString());
        this.messagePendingList.add(paramString);
      }
      return;
    }
    finally {}
  }
  
  public boolean isJsCoreMode()
  {
    return this.workerVmMode == 1;
  }
  
  public void onWorkerJSContextInitFinished()
  {
    QMLog.i("minisdk-worker", "[onWorkerJSContextInitFinished]");
    try
    {
      if (mWorker == null)
      {
        QMLog.e("minisdk-worker", "[onWorkerJSContextInitFinished] failed : worker null!");
        return;
      }
      if (!mWorker.loadExecutedAppConfig()) {
        return;
      }
      if (!mWorker.loadWorkerJs(this.mWAWorkerJsStr)) {
        return;
      }
      if (!mWorker.loadWorkerJs(this.mWorkerRunnableStr)) {
        return;
      }
      mWorker.ctxValid();
      handlePendingMsgList();
      return;
    }
    finally {}
  }
  
  public void setWorkerVmMode(int paramInt)
  {
    this.workerVmMode = paramInt;
  }
  
  public void stopWorker()
  {
    try
    {
      if (mWorker == null) {
        return;
      }
      mWorker.clearUp();
      mWorker = null;
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.worker.MiniAppWorkerManager
 * JD-Core Version:    0.7.0.1
 */