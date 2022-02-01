package com.tencent.mobileqq.kandian.glue.viola;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.LoadAsyBack;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.IOException;

final class ViolaAccessHelper$7
  implements Runnable
{
  ViolaAccessHelper$7(String paramString, ViolaBaseView.LoadAsyBack paramLoadAsyBack) {}
  
  public void run()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH_READINJOY_VIOLA_JS_SOURCE_PATH);
    ((StringBuilder)localObject).append(MD5.b(this.a));
    ((StringBuilder)localObject).append(".js");
    localObject = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadJSFromNet [url:");
        ((StringBuilder)localObject).append(this.a);
        ((StringBuilder)localObject).append("] get localPath error, download cancel");
        QLog.e("ViolaAccessHelper", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadJSFromNet [ url:");
      localStringBuilder.append(this.a);
      localStringBuilder.append("] Download to ");
      localStringBuilder.append((String)localObject);
      QLog.d("ViolaAccessHelper", 2, localStringBuilder.toString());
    }
    if (new File((String)localObject).exists()) {
      FileUtils.deleteFile((String)localObject);
    }
    boolean bool = HttpDownloadUtil.download(null, this.a, new File((String)localObject));
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("loadJSFromNet download isSucc");
      localStringBuilder.append(bool);
      QLog.d("ViolaAccessHelper", 2, localStringBuilder.toString());
    }
    if (bool) {}
    try
    {
      localObject = FileUtils.readFileToString(new File((String)localObject));
      if (this.b != null) {
        new Handler(Looper.getMainLooper()).post(new ViolaAccessHelper.7.1(this, (String)localObject));
      }
      if (TextUtils.isEmpty((CharSequence)localObject))
      {
        if (QLog.isColorLevel()) {
          QLog.d("ViolaAccessHelper", 2, "loadJSFromNet download isSucc but readFileToString is null");
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("ViolaAccessHelper", 2, "loadJSFromNet download isSucc and readFileToString succ");
        return;
        if (this.b != null) {
          new Handler(Looper.getMainLooper()).postDelayed(new ViolaAccessHelper.7.2(this), 0L);
        }
      }
      return;
    }
    catch (IOException localIOException) {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaAccessHelper.7
 * JD-Core Version:    0.7.0.1
 */