package com.tencent.qqmini.proxyimpl;

import android.app.Activity;
import android.app.Application;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.WorkerThread;
import android.text.TextUtils;
import android.webkit.URLUtil;
import androidx.annotation.MainThread;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.mini.appbrand.utils.AppBrandTask;
import com.tencent.mobileqq.mini.launch.AppBrandProxy;
import com.tencent.mobileqq.mini.reuse.MiniAppCmdUtil;
import com.tencent.mobileqq.mini.share.MiniArkShareModel;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils;
import com.tencent.mobileqq.mini.share.MiniProgramShareUtils.OnShareListener;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.StringUtil;
import com.tencent.mobileqq.widget.QQProgressDialog;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.util.concurrent.TimeUnit;
import mqq.app.MobileQQ;
import org.json.JSONObject;

public class ShareQQArkHelper
{
  private static int a(MiniArkShareModel paramMiniArkShareModel)
  {
    int i;
    if ((!StringUtil.a(paramMiniArkShareModel.getTemplateId())) && (!StringUtil.a(paramMiniArkShareModel.getTemplateData()))) {
      i = 2;
    } else {
      i = 0;
    }
    if (!TextUtils.isEmpty(paramMiniArkShareModel.getRcvOpenId())) {
      i = 5;
    }
    return i;
  }
  
  private static QQProgressDialog a(Activity paramActivity)
  {
    paramActivity = new QQProgressDialog(paramActivity, paramActivity.getResources().getDimensionPixelSize(2131299168));
    paramActivity.c(2131708458);
    paramActivity.show();
    return paramActivity;
  }
  
  @WorkerThread
  private static String a(String paramString1, String paramString2)
  {
    File localFile = new File(paramString1);
    boolean bool = localFile.exists();
    Object localObject = null;
    if (!bool) {
      return null;
    }
    FileUtils.deleteFilesInDirectory(paramString2);
    String str = paramString1.substring(paramString1.lastIndexOf(File.separator));
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramString2);
    localStringBuilder.append(str);
    paramString1 = localObject;
    if (FileUtils.copyFile(localFile, new File(localStringBuilder.toString()), true))
    {
      paramString1 = new StringBuilder();
      paramString1.append(paramString2);
      paramString1.append(str);
      paramString1 = paramString1.toString();
    }
    return paramString1;
  }
  
  public static void a()
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      QQToast.a(MobileQQ.sMobileQQ, 1, 2131719012, 0).a();
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ShareQQArkHelper.6());
  }
  
  public static void a(Activity paramActivity, MiniArkShareModel paramMiniArkShareModel, MiniProgramShareUtils.OnShareListener paramOnShareListener)
  {
    if (Looper.myLooper() == Looper.getMainLooper())
    {
      d(paramActivity, paramMiniArkShareModel, paramOnShareListener);
      return;
    }
    ThreadManagerV2.getUIHandlerV2().post(new ShareQQArkHelper.1(paramActivity, paramMiniArkShareModel, paramOnShareListener));
  }
  
  private static void b(Activity paramActivity, MiniArkShareModel paramMiniArkShareModel, JSONObject paramJSONObject, int paramInt)
  {
    if (MiniProgramShareUtils.performShareAsArkMessage(paramActivity, MiniProgramShareUtils.getArkPrompt(paramMiniArkShareModel, paramJSONObject), paramMiniArkShareModel, paramJSONObject, paramInt))
    {
      paramActivity = new StringBuilder();
      paramActivity.append("onCmdListener: share successful ");
      paramActivity.append(paramJSONObject.toString());
      QLog.d("ShareQQArkHelper", 1, paramActivity.toString());
    }
  }
  
  @WorkerThread
  private static void b(Activity paramActivity, QQProgressDialog paramQQProgressDialog, MiniArkShareModel paramMiniArkShareModel, MiniProgramShareUtils.OnShareListener paramOnShareListener)
  {
    Object localObject1 = paramMiniArkShareModel.getPicUrl();
    int i;
    if ((!URLUtil.isHttpsUrl((String)localObject1)) && (!URLUtil.isHttpUrl((String)localObject1))) {
      i = 0;
    } else {
      i = 1;
    }
    if (i == 0)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramActivity.getApplication().getFilesDir().getPath());
      ((StringBuilder)localObject1).append("/mini_app/image");
      localObject1 = ((StringBuilder)localObject1).toString();
      localObject2 = a(paramMiniArkShareModel.getPicUrl(), (String)localObject1);
      localObject1 = localObject2;
      if (TextUtils.isEmpty((CharSequence)localObject2))
      {
        b(paramQQProgressDialog);
        a();
        QLog.e("ShareQQArkHelper", 1, "dealWithShareImage copy image failed!");
        return;
      }
    }
    Object localObject2 = new Bundle();
    ((Bundle)localObject2).putString("key_uri", (String)localObject1);
    if (i != 0) {
      localObject1 = "cmd_change_ark_share_url";
    } else {
      localObject1 = "cmd_upload_ark_share_image";
    }
    AppBrandProxy.g().sendCmd((String)localObject1, (Bundle)localObject2, new ShareQQArkHelper.3(paramMiniArkShareModel, paramActivity, paramOnShareListener, paramQQProgressDialog));
  }
  
  private static void b(Activity paramActivity, boolean paramBoolean, JSONObject paramJSONObject, MiniProgramShareUtils.OnShareListener paramOnShareListener)
  {
    long l;
    boolean bool;
    if (paramJSONObject != null)
    {
      l = paramJSONObject.optLong("retCode");
      String str = paramJSONObject.optString("errMsg");
      bool = paramJSONObject.optBoolean("needShareCallBack");
      paramJSONObject = str;
    }
    else
    {
      l = -1L;
      paramJSONObject = null;
      bool = false;
    }
    AppBrandTask.runTaskOnUiThread(new ShareQQArkHelper.5(paramBoolean, paramOnShareListener, Boolean.valueOf(bool), l, paramActivity, paramJSONObject));
  }
  
  private static void b(QQProgressDialog paramQQProgressDialog)
  {
    ThreadManagerV2.getUIHandlerV2().post(new ShareQQArkHelper.7(paramQQProgressDialog));
  }
  
  @MainThread
  private static void d(Activity paramActivity, MiniArkShareModel paramMiniArkShareModel, MiniProgramShareUtils.OnShareListener paramOnShareListener)
  {
    ThreadManagerV2.executeOnFileThread(new ShareQQArkHelper.2(paramActivity, a(paramActivity), paramMiniArkShareModel, paramOnShareListener));
  }
  
  private static void e(Activity paramActivity, MiniArkShareModel paramMiniArkShareModel, MiniProgramShareUtils.OnShareListener paramOnShareListener)
  {
    int i = a(paramMiniArkShareModel);
    MiniAppCmdUtil.getInstance().getShareInfo(MiniProgramShareUtils.newShareInfoRequest(paramMiniArkShareModel, (int)TimeUnit.MILLISECONDS.toSeconds(System.currentTimeMillis()), i), new ShareQQArkHelper.4(i, paramActivity, paramMiniArkShareModel, paramOnShareListener));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.ShareQQArkHelper
 * JD-Core Version:    0.7.0.1
 */