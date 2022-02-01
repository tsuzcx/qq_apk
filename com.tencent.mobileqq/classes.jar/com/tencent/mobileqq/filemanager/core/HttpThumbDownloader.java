package com.tencent.mobileqq.filemanager.core;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.filemanager.util.FileUtil;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.utils.NetworkUtil;
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
  private FileOutputStream jdField_a_of_type_JavaIoFileOutputStream = null;
  private String jdField_a_of_type_JavaLangString;
  private int jdField_b_of_type_Int = 0;
  private long jdField_b_of_type_Long = 0L;
  private String jdField_b_of_type_JavaLangString;
  private int jdField_c_of_type_Int = 0;
  private long jdField_c_of_type_Long = 0L;
  private String jdField_c_of_type_JavaLangString;
  private int jdField_d_of_type_Int = 0;
  private long jdField_d_of_type_Long = 0L;
  private String jdField_d_of_type_JavaLangString;
  private long e = 0L;
  
  public HttpThumbDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
  }
  
  private void a()
  {
    if (this.jdField_a_of_type_JavaIoFileOutputStream == null) {}
    try
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[downloadThumb]  ID[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] runDownload...tmpname[");
      ((StringBuilder)localObject).append(String.valueOf(this.jdField_d_of_type_JavaLangString));
      ((StringBuilder)localObject).append("]");
      QLog.i("ZipThumbDownloader", 1, ((StringBuilder)localObject).toString());
      this.jdField_a_of_type_JavaIoFileOutputStream = new FileOutputStream(this.jdField_d_of_type_JavaLangString, true);
    }
    catch (FileNotFoundException localFileNotFoundException)
    {
      Object localObject;
      label86:
      HttpMsg localHttpMsg;
      break label86;
    }
    a(true);
    localObject = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
    if (localObject != null) {
      ((HttpThumbDownloader.ThumbEventCallback)localObject).a(this.jdField_a_of_type_JavaLangString, false, -2, null, this.jdField_a_of_type_Long);
    }
    return;
    localHttpMsg = new HttpMsg(this.jdField_a_of_type_JavaLangString, null, this, true);
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      localObject = "wifi";
    } else {
      localObject = "gprs";
    }
    localHttpMsg.setRequestProperty("Net-type", (String)localObject);
    localHttpMsg.setRequestProperty("Range", "bytes=0-");
    localHttpMsg.setPriority(5);
    localHttpMsg.setDataSlice(true);
    localHttpMsg.fileType = 0;
    localHttpMsg.busiType = 0;
    localHttpMsg.msgId = String.valueOf(this.jdField_a_of_type_Long);
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[downloadThumb]  ID[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("] start runDownload... , url[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject).append("] data RANGE[");
    ((StringBuilder)localObject).append("bytes=0-");
    ((StringBuilder)localObject).append("], peerType[");
    ((StringBuilder)localObject).append(String.valueOf(localHttpMsg.busiType));
    ((StringBuilder)localObject).append("]");
    QLog.d("ZipThumbDownloader", 1, ((StringBuilder)localObject).toString());
    localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
    if (!TextUtils.isEmpty(this.jdField_b_of_type_JavaLangString)) {
      localHttpMsg.setRequestProperty("Cookie", this.jdField_b_of_type_JavaLangString);
    }
    if (QLog.isColorLevel())
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("cookie:");
      ((StringBuilder)localObject).append(this.jdField_b_of_type_JavaLangString);
      QLog.i("ZipThumbDownloader", 1, ((StringBuilder)localObject).toString());
    }
    ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).sendMsg(localHttpMsg);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
  }
  
  private void a(boolean paramBoolean)
  {
    this.jdField_c_of_type_Long = 0L;
    try
    {
      StringBuilder localStringBuilder1;
      if (this.jdField_a_of_type_JavaIoFileOutputStream != null)
      {
        this.jdField_a_of_type_JavaIoFileOutputStream.close();
        this.jdField_a_of_type_JavaIoFileOutputStream = null;
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("stopDownload : [thumbtaskId] = ");
        localStringBuilder1.append(this.jdField_a_of_type_Long);
        localStringBuilder1.append(" closeFileStream");
        QLog.i("ZipThumbDownloader", 1, localStringBuilder1.toString());
      }
      else
      {
        localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("stopDownload : [thumbtaskId] = ");
        localStringBuilder1.append(this.jdField_a_of_type_Long);
        localStringBuilder1.append(" closeFileStream had closed: stream = null");
        QLog.w("ZipThumbDownloader", 1, localStringBuilder1.toString());
      }
    }
    catch (IOException localIOException)
    {
      this.jdField_a_of_type_JavaIoFileOutputStream = null;
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("stopDownload : [thumbtaskId] = ");
      localStringBuilder2.append(this.jdField_a_of_type_Long);
      localStringBuilder2.append(" closeFileStream");
      QLog.e("ZipThumbDownloader", 1, localStringBuilder2.toString());
      localIOException.printStackTrace();
    }
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null) {
      ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).cancelMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    }
    if (paramBoolean) {
      FileUtil.c(this.jdField_d_of_type_JavaLangString);
    }
  }
  
  public void a(long paramLong, String paramString1, String paramString2, HttpThumbDownloader.ThumbEventCallback paramThumbEventCallback)
  {
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_JavaLangString = paramString2;
    this.jdField_c_of_type_JavaLangString = paramString1;
    paramString2 = new StringBuilder();
    paramString2.append(paramString1);
    paramString2.append(".tmp");
    this.jdField_d_of_type_JavaLangString = paramString2.toString();
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback = paramThumbEventCallback;
    paramString1 = new StringBuilder();
    paramString1.append("[downloadThumb]  ID[");
    paramString1.append(this.jdField_a_of_type_Long);
    paramString1.append("] add WaitDowloadTask waiting...");
    QLog.i("ZipThumbDownloader", 1, paramString1.toString());
    this.jdField_d_of_type_Long = System.currentTimeMillis();
    ThreadManager.post(new HttpThumbDownloader.1(this), 8, null, false);
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    long l1;
    if (paramHttpMsg2 != null) {
      l1 = Long.parseLong(paramHttpMsg2.msgId);
    } else {
      l1 = -1L;
    }
    if (l1 != this.jdField_a_of_type_Long)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("decode : [thumbId] = ");
      paramHttpMsg1.append(l1);
      paramHttpMsg1.append(" but [currentTaskId] = ");
      paramHttpMsg1.append(this.jdField_a_of_type_Long);
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      return;
    }
    if (paramHttpMsg2 == null)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("decode : [thumbId] = ");
      paramHttpMsg1.append(l1);
      paramHttpMsg1.append("] decode resp = null ");
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      a(true);
      paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(this.jdField_a_of_type_JavaLangString, false, -7, null, this.jdField_a_of_type_Long);
      }
      return;
    }
    if ((paramHttpMsg2.getResponseCode() == 206) || (paramHttpMsg2.getResponseCode() == 200))
    {
      paramHttpMsg1 = this.jdField_a_of_type_JavaIoFileOutputStream;
      if (paramHttpMsg1 == null)
      {
        a(true);
        paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
        if (paramHttpMsg1 != null) {
          paramHttpMsg1.a(this.jdField_a_of_type_JavaLangString, false, -8, null, this.jdField_a_of_type_Long);
        }
        return;
      }
    }
    try
    {
      paramHttpMsg1.write(paramHttpMsg2.getRecvData());
      if (0L == this.jdField_b_of_type_Long)
      {
        l2 = paramHttpMsg2.getTotalLen();
        paramHttpMsg1 = new StringBuilder();
        paramHttpMsg1.append("decode : [thumbId] = ");
        paramHttpMsg1.append(l1);
        paramHttpMsg1.append("]  [thumb Size] = ");
        paramHttpMsg1.append(String.valueOf(l2));
        QLog.i("ZipThumbDownloader", 1, paramHttpMsg1.toString());
        this.jdField_b_of_type_Long = l2;
      }
      this.e = paramHttpMsg2.getRecvData().length;
      this.jdField_c_of_type_Long += this.e;
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("decode : recv packeg[");
      paramHttpMsg1.append(this.e);
      paramHttpMsg1.append("],total[");
      paramHttpMsg1.append(String.valueOf(this.jdField_c_of_type_Long));
      paramHttpMsg1.append("] thumb Size[");
      paramHttpMsg1.append(String.valueOf(this.jdField_b_of_type_Long));
      paramHttpMsg1.append("]");
      QLog.d("ZipThumbDownloader", 4, paramHttpMsg1.toString());
      l1 = this.jdField_c_of_type_Long;
      long l2 = this.jdField_b_of_type_Long;
      int i;
      if (l1 >= l2)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
        try
        {
          this.jdField_a_of_type_JavaIoFileOutputStream.flush();
          this.jdField_a_of_type_JavaIoFileOutputStream.getFD().sync();
          a(false);
          boolean bool;
          if (!FileUtils.renameFile(new File(this.jdField_d_of_type_JavaLangString), new File(this.jdField_c_of_type_JavaLangString)))
          {
            paramHttpMsg1 = new StringBuilder();
            paramHttpMsg1.append("decode : [downloadThumb] = ");
            paramHttpMsg1.append(this.jdField_a_of_type_Long);
            paramHttpMsg1.append(" renameFile failed");
            QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
            bool = false;
            i = -9;
          }
          else
          {
            bool = true;
            i = 0;
          }
          paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
          if (paramHttpMsg1 == null) {
            break label641;
          }
          paramHttpMsg1.a(this.jdField_a_of_type_JavaLangString, bool, i, this.jdField_c_of_type_JavaLangString, this.jdField_a_of_type_Long);
          return;
        }
        catch (IOException paramHttpMsg1)
        {
          paramHttpMsg1.printStackTrace();
          a(true);
          paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
          if (paramHttpMsg1 != null) {
            paramHttpMsg1.a(this.jdField_a_of_type_JavaLangString, false, -8, null, this.jdField_a_of_type_Long);
          }
          return;
        }
      }
      else
      {
        i = (int)((float)l1 / (float)l2 * 10000.0F);
        paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
        if (paramHttpMsg1 != null) {
          paramHttpMsg1.a(this.jdField_a_of_type_JavaLangString, i);
        }
      }
      label641:
      return;
    }
    catch (Exception paramHttpMsg1)
    {
      paramHttpMsg1.printStackTrace();
      a(true);
      paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(this.jdField_a_of_type_JavaLangString, false, -8, null, this.jdField_a_of_type_Long);
      }
    }
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    long l;
    if (paramHttpMsg1 != null) {
      l = Long.parseLong(paramHttpMsg1.msgId);
    } else {
      l = -1L;
    }
    if (l != this.jdField_a_of_type_Long)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("handleError : [thumbId] = ");
      paramHttpMsg1.append(l);
      paramHttpMsg1.append(" but [currentTaskId] = ");
      paramHttpMsg1.append(this.jdField_a_of_type_Long);
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      return;
    }
    if (paramHttpMsg2 == null)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] = ");
      paramHttpMsg1.append(this.jdField_a_of_type_Long);
      paramHttpMsg1.append(" response is null");
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      a(true);
      paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(this.jdField_a_of_type_JavaLangString, false, -1, null, this.jdField_a_of_type_Long);
      }
      return;
    }
    Object localObject2 = paramHttpMsg2.getErrorString();
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "null";
    }
    int i = paramHttpMsg2.errCode;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("[downloadThumb] = ");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject2).append(" handleError retCode [errCode] = ");
    ((StringBuilder)localObject2).append(i);
    ((StringBuilder)localObject2).append(", [retMsg] = ");
    ((StringBuilder)localObject2).append((String)localObject1);
    QLog.e("ZipThumbDownloader", 1, ((StringBuilder)localObject2).toString());
    if (!NetworkUtil.isNetSupport(BaseApplication.getContext()))
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] = ");
      paramHttpMsg1.append(this.jdField_a_of_type_Long);
      paramHttpMsg1.append(" net is broken");
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      a(true);
      paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(this.jdField_a_of_type_JavaLangString, false, -3, null, this.jdField_a_of_type_Long);
      }
      return;
    }
    if (paramHttpMsg1 == null)
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] = ");
      paramHttpMsg1.append(this.jdField_a_of_type_Long);
      paramHttpMsg1.append(" request = null. over");
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      i = -6;
    }
    else if (!paramHttpMsg2.permitRetry())
    {
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] = ");
      paramHttpMsg1.append(this.jdField_a_of_type_Long);
      paramHttpMsg1.append(" response.permitRetry = false. over");
      QLog.e("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      i = -4;
    }
    else
    {
      if (this.jdField_b_of_type_Int < 3)
      {
        paramHttpMsg1 = new StringBuilder();
        paramHttpMsg1.append("[downloadThumb] = ");
        paramHttpMsg1.append(this.jdField_a_of_type_Long);
        paramHttpMsg1.append(" try it. [retryTimes] = ");
        paramHttpMsg1.append(this.jdField_b_of_type_Int);
        paramHttpMsg1.append(" [eofRetry] = ");
        paramHttpMsg1.append(this.jdField_d_of_type_Int);
        QLog.w("ZipThumbDownloader", 1, paramHttpMsg1.toString());
        this.jdField_b_of_type_Int += 1;
        if ((i == 9056) && (this.jdField_d_of_type_Int < 3))
        {
          paramHttpMsg1 = new StringBuilder();
          paramHttpMsg1.append("[downloadThumb] = ");
          paramHttpMsg1.append(this.jdField_a_of_type_Long);
          paramHttpMsg1.append(" [Error_Exp_Eof retryTimes] = ");
          paramHttpMsg1.append(this.jdField_b_of_type_Int);
          paramHttpMsg1.append(" [eofRetry] = ");
          paramHttpMsg1.append(this.jdField_d_of_type_Int);
          QLog.w("ZipThumbDownloader", 1, paramHttpMsg1.toString());
          this.jdField_b_of_type_Int -= 1;
          this.jdField_d_of_type_Int += 1;
        }
        else
        {
          this.jdField_d_of_type_Int = 0;
        }
        a(true);
        paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
        if (paramHttpMsg1 != null) {
          paramHttpMsg1.a(this.jdField_a_of_type_JavaLangString);
        }
        this.jdField_c_of_type_Int += 1;
        a();
        return;
      }
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[downloadThumb] = ");
      paramHttpMsg1.append(this.jdField_a_of_type_Long);
      paramHttpMsg1.append(" try it. retryTimes > ");
      paramHttpMsg1.append(3);
      paramHttpMsg1.append(" download over....");
      QLog.w("ZipThumbDownloader", 1, paramHttpMsg1.toString());
      i = -1;
    }
    a(true);
    paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreHttpThumbDownloader$ThumbEventCallback;
    if (paramHttpMsg1 != null) {
      paramHttpMsg1.a(this.jdField_a_of_type_JavaLangString, false, i, null, this.jdField_a_of_type_Long);
    }
  }
  
  public void handleRedirect(String paramString) {}
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.HttpThumbDownloader
 * JD-Core Version:    0.7.0.1
 */