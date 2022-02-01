package com.tencent.qqmini.sdk.core.manager.impl;

import android.content.Context;
import android.os.Environment;
import android.util.Log;
import com.tencent.qqmini.sdk.core.utils.FileUtils;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.BaselibContent;
import com.tencent.qqmini.sdk.launcher.shell.BaselibLoader.OnLoadBaselibListener;
import java.io.File;

public class InternalBaselibLoader
  extends BaselibLoader
{
  public static final String TAG = "InternalBaselibLoader";
  
  public void loadBaselib(Context paramContext, BaselibLoader.OnLoadBaselibListener paramOnLoadBaselibListener)
  {
    try
    {
      if (isBaseLibInit())
      {
        if (paramOnLoadBaselibListener != null) {
          paramOnLoadBaselibListener.onResult(0, "", this.mBaselibContent.clone());
        }
        return;
      }
      BaselibLoader.BaselibContent localBaselibContent = new BaselibLoader.BaselibContent();
      localBaselibContent.waWebviewJsStr = FileUtils.readFileFromAssets(paramContext, "mini/QView.js");
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append(Environment.getExternalStorageDirectory().getAbsolutePath());
      ((StringBuilder)localObject).append(File.separator);
      localObject = new File(((StringBuilder)localObject).toString(), "QLogic.js");
      if ((((File)localObject).exists()) && (((File)localObject).isFile()))
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("load ServiceJs from ");
        localStringBuilder.append(((File)localObject).getAbsolutePath());
        Log.i("InternalBaselibLoader", localStringBuilder.toString());
        localBaselibContent.waServiceJsStr = FileUtils.readFileToStr((File)localObject);
        localBaselibContent.waServicePath = ((File)localObject).getAbsolutePath();
      }
      else
      {
        Log.i("InternalBaselibLoader", "load ServiceJs from assets");
        localBaselibContent.waServiceJsStr = FileUtils.readFileFromAssets(paramContext, "mini/QLogic.js");
        localBaselibContent.waServicePath = "assets://mini/QLogic.js";
      }
      localBaselibContent.waConsoleJsStr = FileUtils.readFileFromAssets(paramContext, "mini/QVConsole.js");
      localBaselibContent.waRemoteDebugStr = FileUtils.readFileFromAssets(paramContext, "mini/QRemoteDebug.js");
      localBaselibContent.miniappWebviewStr = FileUtils.readFileFromAssets(paramContext, "mini/QWebview.js");
      localBaselibContent.waWorkerStr = FileUtils.readFileFromAssets(paramContext, "mini/QWorker.js");
      setBaselib(localBaselibContent);
      if (paramOnLoadBaselibListener != null) {
        if (isBaseLibInit()) {
          paramOnLoadBaselibListener.onResult(0, "", this.mBaselibContent.clone());
        } else {
          paramOnLoadBaselibListener.onResult(-1, "基础库加载失败", null);
        }
      }
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqmini.sdk.core.manager.impl.InternalBaselibLoader
 * JD-Core Version:    0.7.0.1
 */