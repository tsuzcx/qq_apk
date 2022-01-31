package com.tencent.mobileqq.filemanager.core;

import acwp;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileDescriptor;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class HttpThumbDownloader
  implements IHttpCommunicatorListener
{
  private final int jdField_a_of_type_Int = 3;
  private long jdField_a_of_type_Long = -1L;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private HttpThumbDownloader.ThumbEventCallback jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int;
  private long jdField_c_of_type_Long;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int;
  private long jdField_d_of_type_Long;
  private String jdField_d_of_type_JavaLangString;
  private long e;
  
  public HttpThumbDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      QLog.i("ZipThumbDownloader", 1, "[downloadThumb]  ID[" + this.jdField_a_of_type_Long + "] runDownload...tmpname[" + String.valueOf(this.jdField_d_of_type_JavaLangString) + "]");
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
      HttpMsg localHttpMsg = new HttpMsg(this.jdField_a_of_type_JavaLangString, null, this, true);
      String str = "gprs";
      if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
        str = "wifi";
      }
      localHttpMsg.a("Net-type", str);
      localHttpMsg.a("Range", "bytes=0-");
      localHttpMsg.b(5);
      localHttpMsg.a(true);
      localHttpMsg.jdField_b_of_type_Int = 0;
      localHttpMsg.jdField_c_of_type_Int = 0;
      localHttpMsg.jdField_a_of_type_JavaLangString = String.valueOf(this.jdField_a_of_type_Long);
      QLog.d("ZipThumbDownloader", 1, "[downloadThumb]  ID[" + this.jdField_a_of_type_Long + "] start runDownload... , url[" + this.jdField_a_of_type_JavaLangString + "] data RANGE[" + String.valueOf("bytes=0-") + "], peerType[" + String.valueOf(localHttpMsg.jdField_c_of_type_Int) + "]");
      localHttpMsg.a("Accept-Encoding", "identity");
      if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
        localHttpMsg.a("Cookie", this.jdField_b_of_type_JavaLangString);
      }
      if (QLog.isColorLevel()) {
        QLog.i("ZipThumbDownloader", 1, "cookie:" + this.jdField_b_of_type_JavaLangString);
      }
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
      return;
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      do
      {
        a(true);
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback == null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback.a(this.jdField_a_of_type_JavaLangString, false, -2, null, this.jdField_a_of_type_Long);
    }
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Long = 0L;
    try
    {
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        QLog.i("ZipThumbDownloader", 1, "stopDownload : [thumbtaskId] = " + this.jdField_a_of_type_Long + " closeFileStream");
      }
      for (;;)
      {
        if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null) {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
        }
        if (paramBoolean) {
          FileUtil.c(this.jdField_d_of_type_JavaLangString);
        }
        return;
        QLog.w("ZipThumbDownloader", 1, "stopDownload : [thumbtaskId] = " + this.jdField_a_of_type_Long + " closeFileStream had closed: stream = null");
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        QLog.e("ZipThumbDownloader", 1, "stopDownload : [thumbtaskId] = " + this.jdField_a_of_type_Long + " closeFileStream");
        localIOException.printStackTrace();
      }
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, HttpThumbDownloader.ThumbEventCallback paramThumbEventCallback)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
    this.jdField_d_of_type_JavaLangString = (paramString1 + ".tmp");
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback = paramThumbEventCallback;
    QLog.i("ZipThumbDownloader", 1, "[downloadThumb]  ID[" + this.jdField_a_of_type_Long + "] add WaitDowloadTask waiting...");
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    ThreadManager.post(new acwp(this), 8, null, false);
  }
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    boolean bool = false;
    long l1 = -1L;
    if (paramHttpMsg2 != null) {
      l1 = Long.parseLong(paramHttpMsg2.jdField_a_of_type_JavaLangString);
    }
    if (l1 != this.jdField_a_of_type_Long) {
      QLog.e("ZipThumbDownloader", 1, "decode : [thumbId] = " + l1 + " but [currentTaskId] = " + this.jdField_a_of_type_Long);
    }
    do
    {
      do
      {
        do
        {
          return;
          if (paramHttpMsg2 != null) {
            break;
          }
          QLog.e("ZipThumbDownloader", 1, "decode : [thumbId] = " + l1 + "] decode resp = null ");
          a(true);
        } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback == null);
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback.a(this.jdField_a_of_type_JavaLangString, false, -7, null, this.jdField_a_of_type_Long);
        return;
      } while ((paramHttpMsg2.c() != 206) && (paramHttpMsg2.c() != 200));
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null) {
        break;
      }
      a(true);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback.a(this.jdField_a_of_type_JavaLangString, false, -8, null, this.jdField_a_of_type_Long);
    return;
    for (;;)
    {
      try
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.write(paramHttpMsg2.a());
        if (0L == this.jdField_b_of_type_Long)
        {
          long l2 = paramHttpMsg2.a();
          QLog.i("ZipThumbDownloader", 1, "decode : [thumbId] = " + l1 + "]  [thumb Size] = " + String.valueOf(l2));
          this.jdField_b_of_type_Long = l2;
        }
        this.e = paramHttpMsg2.a().length;
        this.jdField_c_of_type_Long += this.e;
        QLog.d("ZipThumbDownloader", 4, "decode : recv packeg[" + this.e + "],total[" + String.valueOf(this.jdField_c_of_type_Long) + "] thumb Size[" + String.valueOf(this.jdField_b_of_type_Long) + "]");
        if (this.jdField_c_of_type_Long < this.jdField_b_of_type_Long) {
          break label576;
        }
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
      }
      catch (Exception paramHttpMsg1)
      {
        try
        {
          this.jdField_a_of_type_JavaIoFileOutputStream.flush();
          this.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(false);
          if (FileUtils.b(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_c_of_type_JavaLangString))) {
            break label615;
          }
          i = -9;
          QLog.e("ZipThumbDownloader", 1, "decode : [downloadThumb] = " + this.jdField_a_of_type_Long + " renameFile failed");
          if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback == null) {
            break;
          }
          this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback.a(this.jdField_a_of_type_JavaLangString, bool, i, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Long);
          return;
        }
        catch (IOException paramHttpMsg1)
        {
          paramHttpMsg1.printStackTrace();
          a(true);
        }
        paramHttpMsg1 = paramHttpMsg1;
        paramHttpMsg1.printStackTrace();
        a(true);
      }
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback.a(this.jdField_a_of_type_JavaLangString, false, -8, null, this.jdField_a_of_type_Long);
      return;
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback.a(this.jdField_a_of_type_JavaLangString, false, -8, null, this.jdField_a_of_type_Long);
      return;
      label576:
      int i = (int)((float)this.jdField_c_of_type_Long / (float)this.jdField_b_of_type_Long * 10000.0F);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback.a(this.jdField_a_of_type_JavaLangString, i);
      return;
      label615:
      i = 0;
      bool = true;
    }
  }
  
  public void a(String paramString) {}
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    int i = -1;
    long l = -1L;
    if (paramHttpMsg1 != null) {
      l = Long.parseLong(paramHttpMsg1.jdField_a_of_type_JavaLangString);
    }
    if (l != this.jdField_a_of_type_Long) {
      QLog.e("ZipThumbDownloader", 1, "handleError : [thumbId] = " + l + " but [currentTaskId] = " + this.jdField_a_of_type_Long);
    }
    int j;
    do
    {
      do
      {
        return;
        if (paramHttpMsg2 != null) {
          break;
        }
        QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " response is null");
        a(true);
      } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback == null);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback.a(this.jdField_a_of_type_JavaLangString, false, -1, null, this.jdField_a_of_type_Long);
      return;
      String str2 = paramHttpMsg2.d();
      String str1 = str2;
      if (str2 == null) {
        str1 = "null";
      }
      j = paramHttpMsg2.f;
      QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " handleError retCode [errCode] = " + j + ", [retMsg] = " + str1);
      if (NetworkUtil.d(BaseApplication.getContext())) {
        break;
      }
      QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " net is broken");
      a(true);
    } while (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback == null);
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback.a(this.jdField_a_of_type_JavaLangString, false, -3, null, this.jdField_a_of_type_Long);
    return;
    if (paramHttpMsg1 == null)
    {
      i = -6;
      QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " request = null. over");
    }
    for (;;)
    {
      a(true);
      if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback == null) {
        break;
      }
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback.a(this.jdField_a_of_type_JavaLangString, false, i, null, this.jdField_a_of_type_Long);
      return;
      if (!paramHttpMsg2.d())
      {
        i = -4;
        QLog.e("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " response.permitRetry = false. over");
      }
      else
      {
        if (this.jdField_b_of_type_Int < 3)
        {
          QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " try it. [retryTimes] = " + this.jdField_b_of_type_Int + " [eofRetry] = " + this.jdField_d_of_type_Int);
          this.jdField_b_of_type_Int += 1;
          if ((j == 9056) && (this.jdField_d_of_type_Int < 3))
          {
            QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " [Error_Exp_Eof retryTimes] = " + this.jdField_b_of_type_Int + " [eofRetry] = " + this.jdField_d_of_type_Int);
            this.jdField_b_of_type_Int -= 1;
          }
          for (this.jdField_d_of_type_Int += 1;; this.jdField_d_of_type_Int = 0)
          {
            a(true);
            if (this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback != null) {
              this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback.a(this.jdField_a_of_type_JavaLangString);
            }
            this.jdField_c_of_type_Int += 1;
            a();
            return;
          }
        }
        QLog.w("ZipThumbDownloader", 1, "[downloadThumb] = " + this.jdField_a_of_type_Long + " try it. retryTimes > " + 3 + " download over....");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.HttpThumbDownloader
 * JD-Core Version:    0.7.0.1
 */