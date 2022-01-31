package com.tencent.mobileqq.intervideo.od;

import android.os.Bundle;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.transfile.HttpNetReq;
import com.tencent.mobileqq.transfile.INetEngine;
import com.tencent.mobileqq.transfile.INetEngine.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.txproxy.HostEventListener;

public class ODDownloader
  implements INetEngine.INetEngineListener
{
  QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  public INetEngine a;
  HostEventListener jdField_a_of_type_ComTencentTxproxyHostEventListener;
  
  public ODDownloader(QQAppInterface paramQQAppInterface)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = paramQQAppInterface;
    if (paramQQAppInterface != null) {
      this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getNetEngine(0);
    }
  }
  
  private void a()
  {
    new Bundle().putBoolean("issuccess", true);
    if (this.jdField_a_of_type_ComTencentTxproxyHostEventListener != null) {
      this.jdField_a_of_type_ComTencentTxproxyHostEventListener.onDownloadResult(0, 200, "");
    }
  }
  
  private void b(NetResp paramNetResp)
  {
    int i = paramNetResp.jdField_c_of_type_Int;
    int j = paramNetResp.b;
    paramNetResp = paramNetResp.jdField_a_of_type_JavaLangString;
    if (this.jdField_a_of_type_ComTencentTxproxyHostEventListener != null) {
      this.jdField_a_of_type_ComTencentTxproxyHostEventListener.onDownloadResult(j, i, paramNetResp);
    }
  }
  
  public void a(NetReq paramNetReq, long paramLong1, long paramLong2)
  {
    paramNetReq = new Bundle();
    paramNetReq.putLong("offset", paramLong1);
    paramNetReq.putLong("totallen", paramLong2);
    if (this.jdField_a_of_type_ComTencentTxproxyHostEventListener != null) {
      this.jdField_a_of_type_ComTencentTxproxyHostEventListener.onDownloadProgress(paramLong1, paramLong2);
    }
  }
  
  public void a(NetResp paramNetResp)
  {
    if (paramNetResp.jdField_a_of_type_Int == 0)
    {
      a();
      return;
    }
    b(paramNetResp);
  }
  
  public boolean a(String paramString1, String paramString2, HostEventListener paramHostEventListener)
  {
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine == null) || (TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2))) {
      return false;
    }
    HttpNetReq localHttpNetReq = new HttpNetReq();
    localHttpNetReq.jdField_a_of_type_JavaLangString = paramString1;
    localHttpNetReq.jdField_a_of_type_Int = 0;
    localHttpNetReq.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine$INetEngineListener = this;
    localHttpNetReq.jdField_c_of_type_JavaLangString = paramString2;
    localHttpNetReq.k = false;
    localHttpNetReq.jdField_c_of_type_Int = 3;
    this.jdField_a_of_type_ComTencentTxproxyHostEventListener = paramHostEventListener;
    this.jdField_a_of_type_ComTencentMobileqqTransfileINetEngine.a(localHttpNetReq);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\tmp\com33.jar
 * Qualified Name:     com.tencent.mobileqq.intervideo.od.ODDownloader
 * JD-Core Version:    0.7.0.1
 */