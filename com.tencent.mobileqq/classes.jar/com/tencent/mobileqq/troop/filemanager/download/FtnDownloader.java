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
      int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      Object localObject = new StringBuilder();
      ((StringBuilder)localObject).append("[");
      ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
      ((StringBuilder)localObject).append("] cancel ftn download");
      TroopFileTransferUtil.Log.c("FtnDownloader", i, ((StringBuilder)localObject).toString());
      localObject = (IHttpEngineService)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getRuntimeService(IHttpEngineService.class, "all");
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
        return;
      }
      localObject = ((IHttpEngineService)localObject).getCommunicator();
      if (localObject == null)
      {
        this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
        return;
      }
      ((HttpCommunicator)localObject).cancelMsg(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2, HttpMsg paramHttpMsg)
  {
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("] ftn download err. errCode:");
    ((StringBuilder)localObject).append(paramInt);
    ((StringBuilder)localObject).append(" errMsg:");
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append(" rspHeader:");
    ((StringBuilder)localObject).append(paramString2);
    TroopFileTransferUtil.Log.a("FtnDownloader", i, ((StringBuilder)localObject).toString());
    this.jdField_a_of_type_Boolean = true;
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink;
    if (localObject != null) {
      ((FtnDownloader.IHttpDownloadSink)localObject).a(paramInt, paramString1, paramString2, paramHttpMsg);
    }
  }
  
  public void a(FtnDownloader.IHttpDownloadSink paramIHttpDownloadSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink = paramIHttpDownloadSink;
  }
  
  public boolean a(String paramString, long paramLong)
  {
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("] ftn download url:");
    ((StringBuilder)localObject).append(paramString);
    ((StringBuilder)localObject).append(" pos:");
    ((StringBuilder)localObject).append(paramLong);
    TroopFileTransferUtil.Log.c("FtnDownloader", i, ((StringBuilder)localObject).toString());
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("bytes=");
    ((StringBuilder)localObject).append(paramLong);
    ((StringBuilder)localObject).append("-");
    String str = ((StringBuilder)localObject).toString();
    HttpMsg localHttpMsg = new HttpMsg(paramString, null, this, true);
    localHttpMsg.setInstanceFollowRedirects(false);
    if (NetworkUtil.getNetworkType(BaseApplication.getContext()) == 1) {
      localObject = "wifi";
    } else {
      localObject = "gprs";
    }
    localHttpMsg.setRequestProperty("Net-type", (String)localObject);
    localHttpMsg.setRequestProperty("cache-control", "no-cache");
    if (paramLong != 0L) {
      localHttpMsg.setRequestProperty("Range", str);
    }
    localHttpMsg.setPriority(5);
    localHttpMsg.setDataSlice(true);
    localHttpMsg.fileType = this.jdField_b_of_type_Int;
    localHttpMsg.busiType = this.jdField_a_of_type_Int;
    localHttpMsg.msgId = String.valueOf(this.jdField_a_of_type_Long);
    localHttpMsg.setRequestProperty("Accept-Encoding", "identity");
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink;
    if (localObject != null) {
      ((FtnDownloader.IHttpDownloadSink)localObject).b(localHttpMsg);
    }
    if (paramString != null) {
      localObject = paramString.toLowerCase();
    } else {
      localObject = "";
    }
    if ((this.jdField_b_of_type_Boolean) && (((String)localObject).startsWith("https")))
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
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
    int i;
    if (paramHttpMsg1 != localObject)
    {
      if ((paramHttpMsg1 != null) && (localObject != null))
      {
        i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        paramHttpMsg2 = new StringBuilder();
        paramHttpMsg2.append("[");
        paramHttpMsg2.append(this.jdField_a_of_type_Long);
        paramHttpMsg2.append("],Req Serial[");
        paramHttpMsg2.append(String.valueOf(paramHttpMsg1.getSerial()));
        paramHttpMsg2.append("], curRequest Serial[");
        paramHttpMsg2.append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()));
        paramHttpMsg2.append("]");
        TroopFileTransferUtil.Log.a("FtnDownloader", i, paramHttpMsg2.toString());
        return;
      }
      if (paramHttpMsg1 != null)
      {
        i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        paramHttpMsg2 = new StringBuilder();
        paramHttpMsg2.append("[");
        paramHttpMsg2.append(this.jdField_a_of_type_Long);
        paramHttpMsg2.append("],Req Serial[");
        paramHttpMsg2.append(String.valueOf(paramHttpMsg1.getSerial()));
        paramHttpMsg2.append("]");
        TroopFileTransferUtil.Log.a("FtnDownloader", i, paramHttpMsg2.toString());
        return;
      }
      if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
      {
        i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
        paramHttpMsg1 = new StringBuilder();
        paramHttpMsg1.append("[");
        paramHttpMsg1.append(this.jdField_a_of_type_Long);
        paramHttpMsg1.append("],curRequest Serial[");
        paramHttpMsg1.append(String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.getSerial()));
        paramHttpMsg1.append("]");
        TroopFileTransferUtil.Log.a("FtnDownloader", i, paramHttpMsg1.toString());
      }
      return;
    }
    if ((paramHttpMsg2.getResponseCode() != 206) && (paramHttpMsg2.getResponseCode() != 200))
    {
      i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
      paramHttpMsg1 = new StringBuilder();
      paramHttpMsg1.append("[");
      paramHttpMsg1.append(this.jdField_a_of_type_Long);
      paramHttpMsg1.append("] ftn download decode resp code no 200|206");
      TroopFileTransferUtil.Log.a("FtnDownloader", i, paramHttpMsg1.toString());
      return;
    }
    paramHttpMsg1 = paramHttpMsg2.getRecvData();
    long l = paramHttpMsg2.getTotalLen();
    if (this.jdField_b_of_type_Long == 0L) {
      this.jdField_b_of_type_Long = l;
    }
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink;
    if (localObject != null) {
      ((FtnDownloader.IHttpDownloadSink)localObject).a(paramHttpMsg1, l, paramHttpMsg2.rawReqHeader);
    }
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
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    int i = TroopFileTransferUtil.Log.jdField_a_of_type_Int;
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("[");
    ((StringBuilder)localObject).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject).append("] ftn download Redirect. ");
    ((StringBuilder)localObject).append(paramString);
    TroopFileTransferUtil.Log.a("FtnDownloader", i, ((StringBuilder)localObject).toString());
    localObject = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink;
    if (localObject != null) {
      ((FtnDownloader.IHttpDownloadSink)localObject).b(paramString);
    }
  }
  
  public boolean statusChanged(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
  {
    if (5 == paramInt)
    {
      if (this.jdField_a_of_type_Boolean) {
        return true;
      }
      this.jdField_a_of_type_Boolean = true;
      paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink;
      if (paramHttpMsg1 != null)
      {
        paramHttpMsg1.a();
        return true;
      }
    }
    else if (3 == paramInt)
    {
      if (this.jdField_a_of_type_Boolean) {
        return true;
      }
      paramHttpMsg1 = this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink;
      if (paramHttpMsg1 != null) {
        paramHttpMsg1.a(paramHttpMsg2);
      }
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.FtnDownloader
 * JD-Core Version:    0.7.0.1
 */