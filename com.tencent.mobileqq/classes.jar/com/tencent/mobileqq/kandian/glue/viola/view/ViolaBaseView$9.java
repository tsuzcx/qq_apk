package com.tencent.mobileqq.kandian.glue.viola.view;

import android.text.TextUtils;
import com.tencent.mobileqq.app.AppConstants;
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
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append(AppConstants.SDCARD_PATH_READINJOY_VIOLA_JS_SOURCE_PATH);
    Object localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559&time=");
    ((StringBuilder)localObject2).append(System.currentTimeMillis());
    ((StringBuilder)localObject1).append(MD5.a(((StringBuilder)localObject2).toString()));
    ((StringBuilder)localObject1).append(".zip");
    localObject1 = VFSAssistantUtils.getSDKPrivatePath(((StringBuilder)localObject1).toString());
    if (TextUtils.isEmpty((CharSequence)localObject1))
    {
      if (QLog.isColorLevel()) {
        QLog.e(ViolaBaseView.b(), 2, "loadSOFromNet [url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559] get localPath error, download cancel");
      }
      return;
    }
    if (new File((String)localObject1).exists()) {
      FileUtils.deleteFile((String)localObject1);
    }
    boolean bool = HttpDownloadUtil.download(null, "https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559", new File((String)localObject1));
    localObject2 = ViolaBaseView.b();
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("loadSOFromNet [ url:https://sqimg.qq.com/qq_product_operations/kan/violaLibs/so_799.zip?v_bid=3559] Download to ");
    localStringBuilder.append((String)localObject1);
    localStringBuilder.append(",isSuss:");
    localStringBuilder.append(bool);
    QLog.d((String)localObject2, 2, localStringBuilder.toString());
    if ((bool) && (new File((String)localObject1).exists()))
    {
      ViolaBaseView.a(this.this$0, (String)localObject1);
      return;
    }
    ViolaBaseView.a(this.this$0, 6);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.view.ViolaBaseView.9
 * JD-Core Version:    0.7.0.1
 */