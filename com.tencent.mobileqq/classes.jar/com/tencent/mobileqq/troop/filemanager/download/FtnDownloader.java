package com.tencent.mobileqq.troop.filemanager.download;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.filemanager.core.HttpUrlProcessor;
import com.tencent.mobileqq.filemanager.util.FileManagerUtil;
import com.tencent.mobileqq.transfile.HttpCommunicator;
import com.tencent.mobileqq.transfile.api.IHttpEngineService;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class FtnDownloader
  implements IHttpCommunicatorListener
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FtnDownloader.IHttpDownloadSink jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private String jdField_a_of_type_JavaLangString;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  private boolean jdField_b_of_type_Boolean = false;
  
  public FtnDownloader(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2, boolean paramBoolean, String paramString)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_Long = paramLong2;
    this.jdField_b_of_type_Boolean = paramBoolean;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      TroopFileTransferUtil.Log.c("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancel ftn download");
      localObject = (IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all");
      if (localObject == null) {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
      }
    }
    else
    {
      return;
    }
    Object localObject = ((IHttpEngineService)localObject).getCommunicator();
    if (localObject == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
      return;
    }
    ((HttpCommunicator)localObject).cancelMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, HttpMsg paramHttpMsg)
  {
    TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download err. errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink.a(paramInt, paramString1, paramString2, paramHttpMsg);
    }
  }
  
  public void a(FtnDownloader.IHttpDownloadSink paramIHttpDownloadSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink = paramIHttpDownloadSink;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    TroopFileTransferUtil.Log.c("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download url:" + paramString + " pos:" + paramLong);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    String str2 = "bytes=" + paramLong + "-";
    HttpMsg localHttpMsg = new HttpMsg(paramString, null, this, true);
    localHttpMsg.setInstanceFollowRedirects(false);
    String str1 = "gprs";
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
      str1 = "wifi";
    }
    localHttpMsg.setRequestProperty("Net-type", str1);
    localHttpMsg.setRequestProperty("cache-control", "no-cache");
    if (paramLong != 0L) {
      localHttpMsg.setRequestProperty("Range", str2);
    }
    localHttpMsg.setPriority(5);
    localHttpMsg.setDataSlice(true);
    localHttpMsg.fileType = this.jdField_b_of_type_Int;
    localHttpMsg.busiType = this.jdField_a_of_type_Int;
    localHttpMsg.msgId = String.valueOf(this.jdField_a_of_type_Long);
    localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink.b(localHttpMsg);
    }
    str1 = "";
    if (paramString != null) {
      str1 = paramString.toLowerCase();
    }
    if ((this.jdField_b_of_type_Boolean) && (str1.startsWith("https")))
    {
      localHttpMsg.mIsHttps = true;
      localHttpMsg.mIsHostIP = HttpUrlProcessor.a(paramString);
      localHttpMsg.mReqHost = this.jdField_a_of_type_JavaLangString;
    }
    localHttpMsg.timeoutParam = FileManagerUtil.a();
    paramString = ((IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all")).getCommunicator();
    if (paramString == null)
    {
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
      QLog.e("FtnDownloader", 1, "----IHttpEngineService getCommunicator return null!");
      return false;
    }
    ((HttpCommunicator)paramString).sendMsg(localHttpMsg);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
    return true;
  }
  
  public void decode(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_Boolean) {}
    long l;
    do
    {
      do
      {
        return;
        if (paramHttpMsg1 == this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg) {
          break;
        }
        if ((paramHttpMsg1 != null) && (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null))
        {
          TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(paramHttpMsg1.getSerial()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
          return;
        }
        if (paramHttpMsg1 != null)
        {
          TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(paramHttpMsg1.getSerial()) + "]");
          return;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null);
      TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()) + "]");
      return;
      if ((paramHttpMsg2.getResponseCode() != 206) && (paramHttpMsg2.getResponseCode() != 200)) {
        break;
      }
      paramHttpMsg1 = paramHttpMsg2.getRecvData();
      l = paramHttpMsg2.getTotalLen();
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink.a(paramHttpMsg1, l, paramHttpMsg2.rawReqHeader);
    return;
    TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download decode resp code no 200|206");
  }
  
  public void handleError(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramHttpMsg2 != null)
    {
      a(paramHttpMsg2.errCode, paramHttpMsg2.getErrorString(), paramHttpMsg2.rawRespHeader, paramHttpMsg2);
      return;
    }
    a(9001, "err no response", "", null);
  }
  
  public void handleRedirect(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download Redirect. " + paramString);
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink.a(paramString);
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (5 == paramInt) {
      if (!this.jdField_a_of_type_Boolean) {}
    }
    while ((3 != paramInt) || (this.jdField_a_of_type_Boolean) || (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink == null))
    {
      do
      {
        return true;
        this.jdField_a_of_type_Boolean = true;
      } while (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink == null);
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink.a();
      return true;
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink.a(paramHttpMsg2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.FtnDownloader
 * JD-Core Version:    0.7.0.1
 */