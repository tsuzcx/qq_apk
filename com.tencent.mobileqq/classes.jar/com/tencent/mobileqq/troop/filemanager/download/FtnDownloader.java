package com.tencent.mobileqq.troop.filemanager.download;

import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.filemanager.TroopFileTransferUtil.Log;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.utils.httputils.HttpCommunicator;
import com.tencent.mobileqq.utils.httputils.HttpMsg;
import com.tencent.mobileqq.utils.httputils.IHttpCommunicatorListener;
import com.tencent.qphone.base.util.BaseApplication;

public class FtnDownloader
  implements IHttpCommunicatorListener
{
  private final int jdField_a_of_type_Int;
  private final long jdField_a_of_type_Long;
  private final QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  private FtnDownloader.IHttpDownloadSink jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink;
  private HttpMsg jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg;
  private boolean jdField_a_of_type_Boolean = true;
  private final int jdField_b_of_type_Int;
  private long jdField_b_of_type_Long;
  
  public FtnDownloader(QQAppInterface paramQQAppInterface, long paramLong1, int paramInt1, int paramInt2, long paramLong2)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    this.jdField_a_of_type_Long = paramLong1;
    this.jdField_a_of_type_Int = paramInt1;
    this.jdField_b_of_type_Int = paramInt2;
    this.jdField_b_of_type_Long = paramLong2;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg != null)
    {
      TroopFileTransferUtil.Log.c("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] cancel ftn download");
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg);
      this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = null;
    }
  }
  
  protected void a(int paramInt, String paramString1, String paramString2)
  {
    TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download err. errCode:" + paramInt + " errMsg:" + paramString1 + " rspHeader:" + paramString2);
    this.jdField_a_of_type_Boolean = true;
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink.a(paramInt, paramString1, paramString2);
    }
  }
  
  public void a(FtnDownloader.IHttpDownloadSink paramIHttpDownloadSink)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink = paramIHttpDownloadSink;
  }
  
  public void a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
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
          TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(paramHttpMsg1.a()) + "], curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a()) + "]");
          return;
        }
        if (paramHttpMsg1 != null)
        {
          TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],Req Serial[" + String.valueOf(paramHttpMsg1.a()) + "]");
          return;
        }
      } while (this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg == null);
      TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "],curRequest Serial[" + String.valueOf(this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg.a()) + "]");
      return;
      if ((paramHttpMsg2.c() != 206) && (paramHttpMsg2.c() != 200)) {
        break;
      }
      paramHttpMsg1 = paramHttpMsg2.a();
      l = paramHttpMsg2.a();
      if (this.jdField_b_of_type_Long == 0L) {
        this.jdField_b_of_type_Long = l;
      }
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink.a(paramHttpMsg1, l, paramHttpMsg2.jdField_c_of_type_JavaLangString);
    return;
    TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download decode resp code no 200|206");
  }
  
  public void a(String paramString)
  {
    if (this.jdField_a_of_type_Boolean) {}
    do
    {
      return;
      TroopFileTransferUtil.Log.a("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download Redirect. " + paramString);
    } while (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink == null);
    this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink.a(paramString);
  }
  
  public boolean a(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2, int paramInt)
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
  
  public boolean a(String paramString, long paramLong)
  {
    TroopFileTransferUtil.Log.c("FtnDownloader", TroopFileTransferUtil.Log.jdField_a_of_type_Int, "[" + this.jdField_a_of_type_Long + "] ftn download url:" + paramString + " pos:" + paramLong);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    this.jdField_a_of_type_Boolean = false;
    String str = "bytes=" + paramLong + "-";
    HttpMsg localHttpMsg = new HttpMsg(paramString, null, this, true);
    localHttpMsg.b(false);
    paramString = "gprs";
    if (NetworkUtil.b(BaseApplication.getContext()) == 1) {
      paramString = "wifi";
    }
    localHttpMsg.a("Net-type", paramString);
    localHttpMsg.a("cache-control", "no-cache");
    if (paramLong != 0L) {
      localHttpMsg.a("Range", str);
    }
    localHttpMsg.b(5);
    localHttpMsg.a(true);
    localHttpMsg.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localHttpMsg.jdField_c_of_type_Int = this.jdField_a_of_type_Int;
    localHttpMsg.a = String.valueOf(this.jdField_a_of_type_Long);
    localHttpMsg.a("Accept-Encoding", "identity");
    if (this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink != null) {
      this.jdField_a_of_type_ComTencentMobileqqTroopFilemanagerDownloadFtnDownloader$IHttpDownloadSink.b(localHttpMsg);
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getHttpCommunicatort().a(localHttpMsg);
    this.jdField_a_of_type_ComTencentMobileqqUtilsHttputilsHttpMsg = localHttpMsg;
    return true;
  }
  
  public void b(HttpMsg paramHttpMsg1, HttpMsg paramHttpMsg2)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    if (paramHttpMsg2 != null)
    {
      a(paramHttpMsg2.f, paramHttpMsg2.d(), paramHttpMsg2.d);
      return;
    }
    a(9001, "err no response", "");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\a2.jar
 * Qualified Name:     com.tencent.mobileqq.troop.filemanager.download.FtnDownloader
 * JD-Core Version:    0.7.0.1
 */