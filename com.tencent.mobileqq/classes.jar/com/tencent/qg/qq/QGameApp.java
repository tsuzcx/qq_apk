package com.tencent.qg.qq;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.text.TextUtils;
import com.tencent.biz.qqstory.base.StoryDispatcher;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.miniapp.IApp;
import com.tencent.mobileqq.miniapp.IDownloader;
import com.tencent.mobileqq.miniapp.MiniAppEvent;
import com.tencent.mobileqq.miniapp.MiniAppInfo;
import com.tencent.mobileqq.miniapp.MiniAppManager;
import com.tencent.mobileqq.miniapp.ui.MiniAppActivity;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.io.File;
import org.json.JSONObject;

public class QGameApp
  extends IApp
  implements IEventReceiver
{
  public static volatile boolean a;
  private QGameApp.QGameLibsDownloadReceiver a;
  
  public QGameApp(MiniAppActivity paramMiniAppActivity, String paramString, int paramInt)
  {
    super(paramMiniAppActivity, paramString, paramInt);
  }
  
  public static String a(Context paramContext, String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramContext.getCacheDir().getAbsolutePath();
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getCacheDir().getAbsolutePath());
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString);
    return localStringBuilder.toString();
  }
  
  public static String a(Context paramContext, String paramString1, String paramString2)
  {
    if (TextUtils.isEmpty(paramString2)) {
      return a(paramContext, paramString1);
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(a(paramContext, paramString1));
    localStringBuilder.append(File.separator);
    localStringBuilder.append(paramString2);
    return localStringBuilder.toString();
  }
  
  private String a(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return "";
    }
    paramString = new File(paramString);
    if ((paramString.exists()) && (paramString.length() > 0L)) {
      try
      {
        paramString = new JSONObject(FileUtils.readFileToString(paramString)).optString("version");
        return paramString;
      }
      catch (Exception paramString)
      {
        paramString.printStackTrace();
      }
    }
    return "";
  }
  
  public static String a(String paramString1, String paramString2, String paramString3)
  {
    Object localObject = paramString1;
    if (!TextUtils.isEmpty(paramString2))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramString1);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramString2);
      localObject = ((StringBuilder)localObject).toString();
    }
    paramString1 = (String)localObject;
    if (!TextUtils.isEmpty(paramString3))
    {
      paramString1 = new StringBuilder();
      paramString1.append((String)localObject);
      paramString1.append(File.separator);
      paramString1.append(paramString3);
      paramString1 = paramString1.toString();
    }
    return paramString1;
  }
  
  private void a(int paramInt)
  {
    QLog.e("QGameApp", 1, new Object[] { "dispatchAppInitFailed. errorCode=", Integer.valueOf(paramInt) });
    MiniAppEvent localMiniAppEvent = new MiniAppEvent();
    localMiniAppEvent.jdField_a_of_type_Int = 4;
    localMiniAppEvent.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo = this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo;
    StoryDispatcher.a().dispatch("MiniAppManager", localMiniAppEvent);
  }
  
  private void a(boolean paramBoolean, String paramString)
  {
    ThreadManagerV2.excute(new QGameApp.3(this, paramBoolean, paramString), 64, null, true);
  }
  
  private boolean a(boolean paramBoolean, String paramString)
  {
    if (!paramBoolean)
    {
      str = a(a(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs", "libsconfig.json"));
      localObject = a(a(paramString, "", "libsconfig.json"));
      if ((!TextUtils.isEmpty((CharSequence)localObject)) && (((String)localObject).equals(str))) {
        return true;
      }
    }
    String str = a(paramString, "qgamelibs", "");
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(a(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs"));
    ((StringBuilder)localObject).append(File.separator);
    localObject = ((StringBuilder)localObject).toString();
    FileUtils.deleteFilesInDirectory((String)localObject);
    if (FileUtils.copyDirectory(str, (String)localObject, false) >= 0) {
      return FileUtils.copyFile(a(paramString, "", "libsconfig.json"), a(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs", "libsconfig.json"));
    }
    return false;
  }
  
  private String[] a()
  {
    String str1 = this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.a.getString("unzipped_path");
    String str2 = a(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs", "ejecta.js");
    if (!TextUtils.isEmpty(str1)) {
      str1 = a(str1, this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.h, "index.js");
    } else {
      str1 = null;
    }
    return new String[] { str2, str1 };
  }
  
  @SuppressLint({"UnsafeDynamicallyLoadedCode"})
  private boolean b()
  {
    if (!jdField_a_of_type_Boolean)
    {
      Object localObject = new File(a(this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity, "qgamelibs"));
      boolean bool = ((File)localObject).isDirectory();
      int i = 0;
      if (!bool) {
        return false;
      }
      localObject = ((File)localObject).listFiles(new QGameApp.2(this));
      if (localObject != null)
      {
        if (localObject.length == 0) {
          return false;
        }
        int j = localObject.length;
        while (i < j)
        {
          System.load(localObject[i].getAbsolutePath());
          i += 1;
        }
        jdField_a_of_type_Boolean = true;
        return true;
      }
      return false;
    }
    return true;
  }
  
  private void d()
  {
    ThreadManagerV2.getUIHandlerV2().postDelayed(new QGameApp.1(this), 1000L);
  }
  
  public void a()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity != null)
    {
      this.jdField_a_of_type_ComTencentQgQqQGameApp$QGameLibsDownloadReceiver = new QGameApp.QGameLibsDownloadReceiver(this);
      StoryDispatcher.a().registerSubscriber(this.jdField_a_of_type_ComTencentQgQqQGameApp$QGameLibsDownloadReceiver);
      IDownloader localIDownloader = MiniAppManager.a().a("ak:3214");
      if (localIDownloader != null) {
        localIDownloader.a("ak:3214", "QGameApp", this.jdField_a_of_type_ComTencentMobileqqMiniappMiniAppInfo.h);
      }
    }
  }
  
  public boolean a()
  {
    return this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity != null;
  }
  
  public void b()
  {
    if (this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity != null) {
      this.jdField_a_of_type_ComTencentMobileqqMiniappUiMiniAppActivity.finish();
    }
  }
  
  public void c()
  {
    super.c();
    if (this.jdField_a_of_type_ComTencentQgQqQGameApp$QGameLibsDownloadReceiver != null) {
      StoryDispatcher.a().unRegisterSubscriber(this.jdField_a_of_type_ComTencentQgQqQGameApp$QGameLibsDownloadReceiver);
    }
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qg.qq.QGameApp
 * JD-Core Version:    0.7.0.1
 */