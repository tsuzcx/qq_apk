package com.tencent.mobileqq.kandian.glue.viola.view;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager;
import com.tencent.mobileqq.kandian.glue.viola.so.ViolaSoLoaderManager.Companion;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.HttpDownloadUtil;
import com.tencent.mobileqq.vfs.VFSAssistantUtils;
import com.tencent.open.base.MD5;
import com.tencent.qphone.base.util.QLog;
import java.io.File;

class ViolaBaseView$9
  implements Runnable
{
  ViolaBaseView$9(ViolaBaseView paramViolaBaseView) {}
  
  public void run()
  {
    String str = ViolaSoLoaderManager.a.a().j();
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(AppConstants.SDCARD_PATH_READINJOY_VIOLA_JS_SOURCE_PATH);
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(str);
    localStringBuilder.append("&time=");
    localStringBuilder.append(System.currentTimeMillis());
    ((StringBuilder)localObject).append(MD5.b(localStringBuilder.toString()));
    ((StringBuilder)localObject).append(".zip");
    localObject = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty((CharSequence)localObject))
    {
      if (QLog.isColorLevel())
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("loadSOFromNet [url:");
        ((StringBuilder)localObject).append(str);
        ((StringBuilder)localObject).append("] get localPath error, download cancel");
        QLog.e("ViolaBaseView", 2, ((StringBuilder)localObject).toString());
      }
      return;
    }
    if (new File((String)localObject).exists()) {
      FileUtils.deleteFile((String)localObject);
    }
    boolean bool = HttpDownloadUtil.download(null, str, new File((String)localObject));
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadSOFromNet [ url:");
    localStringBuilder.append(str);
    localStringBuilder.append("] Download to ");
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(",isSuss:");
    localStringBuilder.append(bool);
    QLog.d("ViolaBaseView", 2, localStringBuilder.toString());
    if ((bool) && (new File((String)localObject).exists()))
    {
      ViolaBaseView.b(this.this$0, (String)localObject);
      return;
    }
    ViolaBaseView.a(this.this$0, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.9
 * JD-Core Version:    0.7.0.1
 */