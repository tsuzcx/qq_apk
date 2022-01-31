package com.tencent.mobileqq.mini.tfs.mini;

import ajya;
import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.tencent.mobileqq.mini.apkg.BaseLibManager;
import com.tencent.mobileqq.mini.report.MiniProgramReportHelper;
import com.tencent.mobileqq.mini.report.MiniReportManager;
import com.tencent.mobileqq.mini.sdk.BaseLibInfo;
import com.tencent.mobileqq.mini.tfs.AsyncTask;
import com.tencent.mobileqq.mini.util.StorageUtil;
import com.tencent.mobileqq.mini.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

public class BaselibLoadAsyncTask
  extends AsyncTask
{
  private static BaseLibInfo mBaseLibInfo;
  private String miniappWebviewStr;
  private String pageFrameStr;
  private String waConsoleJsStr;
  private String waRemoteDebugStr;
  private String waServiceJsStr;
  private String waWebviewJsStr;
  private String waWorkerStr;
  
  public BaselibLoadAsyncTask(Context paramContext)
  {
    super(paramContext);
  }
  
  private void readJsFromFile(String paramString)
  {
    for (;;)
    {
      try
      {
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 10, null, null, null, 0);
        String str = StorageUtil.getPreference().getString("version", "1.13.0.00013");
        if (!BaseLibInfo.needUpdateVersion("1.13.0.00013", str)) {
          break label363;
        }
        QLog.e("miniapp-start", 1, "download baselib invalid! use assert baselib. download_version=" + str + " assert_version=" + "1.13.0.00013");
        i = 0;
        if ((!isBaseLibInit()) && (i != 0))
        {
          QLog.d("miniapp-start", 1, "readJsFromFile from download.");
          this.waWebviewJsStr = FileUtils.readFileToStr(new File(paramString, "QView.js"));
          this.waServiceJsStr = FileUtils.readFileToStr(new File(paramString, "QLogic.js"));
          this.waConsoleJsStr = FileUtils.readFileToStr(new File(paramString, "QVConsole.js"));
          this.waRemoteDebugStr = FileUtils.readFileToStr(new File(paramString, "QRemoteDebug.js"));
          this.miniappWebviewStr = FileUtils.readFileToStr(new File(paramString, "QWebview.js"));
          this.waWorkerStr = FileUtils.readFileToStr(new File(paramString, "QWorker.js"));
          this.pageFrameStr = FileUtils.readFileToStr(new File(paramString, "QPageFrame.html"));
        }
        if (!isBaseLibInit())
        {
          QLog.d("miniapp-start", 1, "readJsFromFile from Assets.");
          this.waWebviewJsStr = FileUtils.readFileFromAssets("mini/QView.js");
          this.waServiceJsStr = FileUtils.readFileFromAssets("mini/QLogic.js");
          this.waConsoleJsStr = FileUtils.readFileFromAssets("mini/QVConsole.js");
          this.waRemoteDebugStr = FileUtils.readFileFromAssets("mini/QRemoteDebug.js");
          this.miniappWebviewStr = FileUtils.readFileFromAssets("mini/QWebview.js");
          this.waWorkerStr = FileUtils.readFileFromAssets("mini/QWorker.js");
          this.pageFrameStr = FileUtils.readFileFromAssets("mini/QPageFrame.html");
        }
        MiniReportManager.reportEventType(MiniProgramReportHelper.miniAppConfigForPreload(), 11, null, null, null, 0);
        if (!isBaseLibInit()) {
          continue;
        }
        onTaskSucceed();
      }
      catch (Throwable paramString)
      {
        QLog.e("miniapp-start", 1, "readJsFromFile failed." + paramString);
        continue;
      }
      finally {}
      return;
      onTaskFailed(-3, ajya.a(2131701014));
      continue;
      label363:
      int i = 1;
    }
  }
  
  public void executeAsync()
  {
    QLog.d("miniapp-start", 1, "startLoadBaseLib.");
    if (isBaseLibInit())
    {
      onTaskSucceed();
      return;
    }
    String str1 = StorageUtil.getPreference().getString("downloadUrl", "");
    String str2 = StorageUtil.getPreference().getString("version", "1.13.0.00013");
    QLog.i("miniapp-start", 1, "execute baseLibLoad task. url=" + str1 + " version=" + str2);
    if ("1.13.0.00013".equals(str2))
    {
      QLog.e("miniapp-start", 1, "current is default version:" + str2);
      mBaseLibInfo = new BaseLibInfo();
      mBaseLibInfo.baseLibVersion = str2;
      mBaseLibInfo.baseLibUrl = str1;
    }
    for (;;)
    {
      readJsFromFile(BaseLibManager.g().getBaseLibDir(str1, str2));
      return;
      if ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)))
      {
        QLog.e("miniapp-start", 1, "baseLibUrl is null!");
        setStatus(1);
        return;
      }
      if ((!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty(str2)))
      {
        mBaseLibInfo = getBaseLibInfo();
        if (mBaseLibInfo != null)
        {
          mBaseLibInfo.baseLibVersion = str2;
          mBaseLibInfo.baseLibUrl = str1;
        }
      }
    }
  }
  
  public BaseLibInfo getBaseLibInfo()
  {
    String str1;
    String str2;
    if (mBaseLibInfo == null)
    {
      str1 = StorageUtil.getPreference().getString("downloadUrl", "");
      str2 = StorageUtil.getPreference().getString("version", "1.13.0.00013");
      if (!"1.13.0.00013".equals(str2)) {
        break label69;
      }
      mBaseLibInfo = new BaseLibInfo();
      mBaseLibInfo.baseLibVersion = str2;
    }
    for (mBaseLibInfo.baseLibUrl = str1;; mBaseLibInfo.baseLibUrl = str1)
    {
      label69:
      do
      {
        return mBaseLibInfo;
      } while ((TextUtils.isEmpty(str1)) || (TextUtils.isEmpty(str2)));
      mBaseLibInfo = new BaseLibInfo();
      mBaseLibInfo.baseLibVersion = str2;
    }
  }
  
  public String getBasePageFrameStr()
  {
    return this.pageFrameStr;
  }
  
  public String getMiniappWebviewStr()
  {
    return this.miniappWebviewStr;
  }
  
  public String getWaConsoleJs()
  {
    return this.waConsoleJsStr;
  }
  
  public String getWaServiceJs()
  {
    return this.waServiceJsStr;
  }
  
  public String getWaWebviewJs()
  {
    return this.waWebviewJsStr;
  }
  
  public String getWaWorkerStr()
  {
    return this.waWorkerStr;
  }
  
  public boolean isBaseLibInit()
  {
    return (!TextUtils.isEmpty(this.waServiceJsStr)) && (!TextUtils.isEmpty(this.waWebviewJsStr)) && (!TextUtils.isEmpty(this.waConsoleJsStr)) && (!TextUtils.isEmpty(this.waRemoteDebugStr)) && (!TextUtils.isEmpty(this.miniappWebviewStr));
  }
  
  public void onBaseLibUpdateFaild(int paramInt)
  {
    if (!isBaseLibInit()) {
      onTaskFailed(paramInt, "");
    }
  }
  
  public void reset()
  {
    super.reset();
    this.waWebviewJsStr = null;
    this.waServiceJsStr = null;
    this.waConsoleJsStr = null;
    this.waRemoteDebugStr = null;
    this.miniappWebviewStr = null;
    mBaseLibInfo = null;
    this.waWorkerStr = null;
  }
  
  public String waRemoteDebugJs()
  {
    return this.waRemoteDebugStr;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.mini.tfs.mini.BaselibLoadAsyncTask
 * JD-Core Version:    0.7.0.1
 */