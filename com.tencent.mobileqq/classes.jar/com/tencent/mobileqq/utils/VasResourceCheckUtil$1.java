package com.tencent.mobileqq.utils;

import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vip.DownloadListener;
import com.tencent.mobileqq.vip.DownloadTask;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.security.Key;
import javax.crypto.Cipher;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import org.json.JSONObject;

final class VasResourceCheckUtil$1
  extends DownloadListener
{
  VasResourceCheckUtil$1(QQAppInterface paramQQAppInterface) {}
  
  public void onDone(DownloadTask paramDownloadTask)
  {
    super.onDone(paramDownloadTask);
    paramDownloadTask = new File(VasResourceCheckUtil.a);
    if (paramDownloadTask.exists())
    {
      paramDownloadTask = FileUtils.readFileToStringEx(paramDownloadTask, -1);
      if (TextUtils.isEmpty(paramDownloadTask)) {
        return;
      }
      try
      {
        paramDownloadTask = Base64.decode(paramDownloadTask, 0);
        localObject = new SecretKeySpec("xydata3456789012xydata3456789012".getBytes(), "AES");
        IvParameterSpec localIvParameterSpec = new IvParameterSpec("xydata3456789012".getBytes());
        Cipher localCipher = Cipher.getInstance("AES/CBC/PKCS7Padding");
        localCipher.init(2, (Key)localObject, localIvParameterSpec);
        paramDownloadTask = new JSONObject(new String(localCipher.doFinal(paramDownloadTask)));
        if (QLog.isColorLevel())
        {
          localObject = new StringBuilder();
          ((StringBuilder)localObject).append("decode json success, content = ");
          ((StringBuilder)localObject).append(paramDownloadTask.toString());
          QLog.d("VasResourceCheckUtil", 2, ((StringBuilder)localObject).toString());
        }
        VasResourceCheckUtil.a(this.a);
        VasResourceCheckUtil.b.sendMessage(VasResourceCheckUtil.b.obtainMessage(257));
        return;
      }
      catch (Exception paramDownloadTask)
      {
        Object localObject = new StringBuilder();
        ((StringBuilder)localObject).append("decode json fail: ");
        ((StringBuilder)localObject).append(paramDownloadTask.getMessage());
        QLog.e("VasResourceCheckUtil", 1, ((StringBuilder)localObject).toString());
        VasResourceCheckUtil.b.sendMessage(VasResourceCheckUtil.b.obtainMessage(259));
        return;
      }
    }
    VasResourceCheckUtil.b.sendMessage(VasResourceCheckUtil.b.obtainMessage(258));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.VasResourceCheckUtil.1
 * JD-Core Version:    0.7.0.1
 */