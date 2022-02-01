package com.tencent.mobileqq.vas;

import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.BusinessHandlerFactory;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQManagerFactory;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.vas.svip.api.ISVIPHandler;
import com.tencent.mobileqq.vas.vipav.api.VipFunCallUtil;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.mobileqq.vip.DownloaderFactory;
import com.tencent.mobileqq.vip.DownloaderInterface;
import com.tencent.mobileqq.vip.IPCDownloadListener;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppRuntime;
import mqq.manager.Manager;
import org.json.JSONObject;

public class ColorRingManager
  implements Manager
{
  public IPCDownloadListener a = null;
  QQAppInterface b;
  DownloadListener c = new ColorRingManager.1(this, "param_WIFIColorRingDownloadFlow", "param_XGColorRingDownloadFlow");
  private DownloaderFactory d = null;
  
  public ColorRingManager(QQAppInterface paramQQAppInterface)
  {
    this.b = paramQQAppInterface;
    this.d = ((DownloaderFactory)paramQQAppInterface.getManager(QQManagerFactory.DOWNLOADER_FACTORY));
  }
  
  public static String a(long paramLong, int paramInt)
  {
    Object localObject = "";
    if (paramLong == 0L) {
      return "";
    }
    if (paramInt == 2)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ColorRingConstants.a);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("config.txt");
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt == 1)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ColorRingConstants.a);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("cover.jpg");
      return ((StringBuilder)localObject).toString();
    }
    if (paramInt == 3)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(ColorRingConstants.a);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append(File.separator);
      ((StringBuilder)localObject).append("ring.mp3");
      localObject = ((StringBuilder)localObject).toString();
    }
    return localObject;
  }
  
  public static String a(AppRuntime paramAppRuntime, int paramInt1, int paramInt2)
  {
    if (paramInt2 == 3)
    {
      paramAppRuntime = VipFunCallUtil.a(paramAppRuntime, 0, null);
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("_3_");
      ((StringBuilder)localObject).append(paramInt1);
      localObject = paramAppRuntime.getString(((StringBuilder)localObject).toString(), null);
      paramAppRuntime = (AppRuntime)localObject;
      if (TextUtils.isEmpty((CharSequence)localObject)) {
        paramAppRuntime = IndividuationUrlHelper.a("colorringAudio");
      }
    }
    else if (paramInt2 == 2)
    {
      paramAppRuntime = IndividuationUrlHelper.a("colorringConfig");
    }
    else if (paramInt2 == 1)
    {
      paramAppRuntime = IndividuationUrlHelper.a("colorringCover");
    }
    else
    {
      paramAppRuntime = "";
    }
    Object localObject = paramAppRuntime;
    if (paramAppRuntime != null) {
      localObject = paramAppRuntime.replace("[id]", String.valueOf(paramInt1));
    }
    return localObject;
  }
  
  public static JSONObject a(long paramLong)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(ColorRingConstants.a);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append(File.separator);
    ((StringBuilder)localObject).append("config.txt");
    localObject = new File(((StringBuilder)localObject).toString());
    try
    {
      localObject = FileUtils.readFileContent((File)localObject);
      if (localObject != null)
      {
        localObject = new JSONObject((String)localObject);
        return localObject;
      }
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
    return null;
  }
  
  private void a(Bundle paramBundle, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    if (paramInt2 == 3)
    {
      Object localObject1 = (ISVIPHandler)this.b.getBusinessHandler(BusinessHandlerFactory.SVIP_HANDLER);
      int i = ((ISVIPHandler)localObject1).j();
      if (i == 2)
      {
        paramInt2 = 0;
      }
      else
      {
        paramInt2 = i;
        if (i == 3) {
          paramInt2 = 2;
        }
      }
      if ("colorring".equals(paramBundle.getString("colorType")))
      {
        QQAppInterface localQQAppInterface = this.b;
        Object localObject2 = new StringBuilder();
        ((StringBuilder)localObject2).append("");
        ((StringBuilder)localObject2).append(paramInt2);
        localObject2 = ((StringBuilder)localObject2).toString();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(paramInt1);
        localStringBuilder.append("");
        ReportController.b(localQQAppInterface, "CliOper", "", "", "0X8004A22", "0X8004A22", 0, paramBoolean ^ true, (String)localObject2, localStringBuilder.toString(), "", "");
      }
      if ("comering".equals(paramBundle.getString("colorType")))
      {
        paramBundle = new StringBuilder();
        paramBundle.append("");
        paramBundle.append(((ISVIPHandler)localObject1).j());
        paramBundle = paramBundle.toString();
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append(paramInt1);
        ((StringBuilder)localObject1).append("");
        ReportController.b(null, "CliOper", "", "", "0X8005002", "0X8005002", 0, paramBoolean ^ true, paramBundle, ((StringBuilder)localObject1).toString(), "", "");
      }
    }
  }
  
  public static void a(String paramString1, int paramInt, String paramString2) {}
  
  public static Bitmap b(long paramLong)
  {
    Object localObject;
    if (paramLong != 0L)
    {
      localObject = a(paramLong, 1);
      if (!new File((String)localObject).exists()) {}
    }
    try
    {
      localObject = BitmapFactory.decodeFile((String)localObject);
      return localObject;
    }
    catch (OutOfMemoryError localOutOfMemoryError)
    {
      label36:
      break label36;
    }
    if (QLog.isColorLevel()) {
      QLog.d("ColorRingManager", 2, "getCoverBitmap OOM.");
    }
    return null;
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    this.d.a(1).cancelTask(true, a(this.b, paramInt1, paramInt2));
  }
  
  public void a(int paramInt1, int paramInt2, boolean paramBoolean, int paramInt3, String paramString)
  {
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(">>startDownload, id=");
      ((StringBuilder)localObject1).append(paramInt1);
      QLog.d("ColorRingManager", 2, ((StringBuilder)localObject1).toString());
    }
    if (paramInt1 == 0) {
      return;
    }
    String str = a(paramInt1, paramInt2);
    Object localObject2 = new File(str);
    boolean bool;
    if ((((File)localObject2).exists()) && (((File)localObject2).isFile())) {
      bool = true;
    } else {
      bool = false;
    }
    if (QLog.isColorLevel())
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("startDownload exists(), id=");
      ((StringBuilder)localObject1).append(paramInt1);
      ((StringBuilder)localObject1).append(", resType=ring3,, isIPC=");
      ((StringBuilder)localObject1).append(paramBoolean);
      ((StringBuilder)localObject1).append(", srcType=");
      ((StringBuilder)localObject1).append(paramInt3);
      ((StringBuilder)localObject1).append(", fileExist=");
      ((StringBuilder)localObject1).append(bool);
      QLog.d("ColorRingManager", 2, ((StringBuilder)localObject1).toString());
    }
    if ((bool) && (!paramBoolean)) {
      return;
    }
    Object localObject1 = new Bundle();
    ((Bundle)localObject1).putInt("callId", paramInt1);
    ((Bundle)localObject1).putString("path", str);
    ((Bundle)localObject1).putBoolean("isIPC", paramBoolean);
    ((Bundle)localObject1).putInt("resourceType", paramInt2);
    ((Bundle)localObject1).putInt("srcType", paramInt3);
    ((Bundle)localObject1).putString("path", str);
    ((Bundle)localObject1).putString("colorType", paramString);
    paramString = a(this.b, paramInt1, paramInt2);
    if (bool)
    {
      ((Bundle)localObject1).putBoolean("isExists", true);
      paramString = new DownloadTask(paramString, (File)localObject2);
      paramString.a(3);
      paramString.c = 0;
      paramString.a((Bundle)localObject1);
      this.c.onDone(paramString);
      return;
    }
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append(str);
    ((StringBuilder)localObject2).append(".tmp");
    paramString = new DownloadTask(paramString, new File(((StringBuilder)localObject2).toString()));
    paramString.y = 3145728L;
    paramString.m = true;
    this.d.a(1).startDownload(paramString, this.c, (Bundle)localObject1);
    if (QLog.isColorLevel())
    {
      paramString = new StringBuilder();
      paramString.append("<<startDownload, id=");
      paramString.append(paramInt1);
      QLog.d("ColorRingManager", 2, paramString.toString());
    }
  }
  
  public void onDestroy()
  {
    this.a = null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.vas.ColorRingManager
 * JD-Core Version:    0.7.0.1
 */