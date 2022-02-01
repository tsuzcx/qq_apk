package com.tencent.mobileqq.filemanager.core;

import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.MD5;
import com.tencent.qphone.base.util.QLog;

public class Md5HttpUploader
  implements IHttpUploader, IHttpCommunicatorListener
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private IHttpUploadSink jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIHttpUploadSink;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private boolean jdField_a_of_type_Boolean = false;
  private final int b;
  
  private Md5HttpUploader(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_Int = paramInt1;
    this.b = paramInt2;
  }
  
  public static Md5HttpUploader a(QQAppInterface paramQQAppInterface, long paramLong, int paramInt1, int paramInt2)
  {
    return new Md5HttpUploader(paramQQAppInterface, paramLong, paramInt1, paramInt2);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).cancelMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
    }
  }
  
  public void a(IHttpUploadSink paramIHttpUploadSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIHttpUploadSink = paramIHttpUploadSink;
  }
  
  public boolean a(String paramString, long paramLong, byte[] paramArrayOfByte)
  {
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = new HttpMsg(paramString + "&bmd5=" + MD5.toMD5(paramArrayOfByte) + "&range=" + String.valueOf(paramLong), paramArrayOfByte, this);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setInstanceFollowRedirects(false);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("cache-control", "no-cache");
    paramString = "gprs";
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("Net-type", paramString);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestProperty("Range", "bytes=" + paramLong + "-");
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setRequestMethod("POST");
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.setPriority(1);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.fileType = this.b;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.busiType = this.jdField_a_of_type_Int;
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.msgId = String.valueOf(this.jdField_a_of_type_Long);
    ((HttpCommunicator)((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator()).sendMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    return true;
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      if (QLog.isColorLevel()) {
        QLog.e("##########", 2, "nSessionID[" + String.valueOf(this.jdField_a_of_type_Long) + "]已经结束,返回");
      }
    }
    do
    {
      return;
      if (paramHttpMsg1 == this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) {
        break;
      }
      if ((paramHttpMsg1 != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null))
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(paramHttpMsg1.getSerial()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
        return;
      }
      if (paramHttpMsg1 != null)
      {
        QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],Req Serial[" + String.valueOf(paramHttpMsg1.getSerial()) + "]");
        return;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null);
    QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
    return;
    if (paramHttpMsg2.getResponseCode() == 200) {
      if (paramHttpMsg2.getResponseProperty("User-ReturnCode") == null) {
        break label409;
      }
    }
    label409:
    for (long l = Long.parseLong(paramHttpMsg2.getResponseProperty("User-ReturnCode"));; l = 0L)
    {
      if (0L != l)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIHttpUploadSink.a(paramHttpMsg2.errCode, paramHttpMsg2.getErrorString(), paramHttpMsg2.rawRespHeader);
        return;
      }
      paramHttpMsg1 = paramHttpMsg2.getResponseProperty("Range");
      if (paramHttpMsg1 == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIHttpUploadSink.a(9001, "httpServer not has range");
        return;
      }
      l = Long.parseLong(paramHttpMsg1);
      this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIHttpUploadSink.a(l, paramHttpMsg2.rawRespHeader);
      return;
      QLog.e("FtnHttpUploader<FileAssistant>", 1, "id[" + String.valueOf(this.jdField_a_of_type_Long) + "],decode but response Code [" + paramHttpMsg2.getResponseCode() + "] is not 200");
      return;
    }
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIHttpUploadSink.a(paramHttpMsg2.errCode, paramHttpMsg2.getErrorString(), paramHttpMsg2.rawRespHeader);
  }
  
  public void handleRedirect(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqFilemanagerCoreIHttpUploadSink.a(paramString);
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.core.Md5HttpUploader
 * JD-Core Version:    0.7.0.1
 */