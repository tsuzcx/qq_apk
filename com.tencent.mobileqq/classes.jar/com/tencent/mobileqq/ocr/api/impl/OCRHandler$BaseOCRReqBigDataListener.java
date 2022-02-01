package com.tencent.mobileqq.ocr.api.impl;

import android.content.Intent;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.transfile.INetEngineListener;
import com.tencent.mobileqq.transfile.NetReq;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

class OCRHandler$BaseOCRReqBigDataListener
  implements INetEngineListener
{
  private Intent jdField_a_of_type_AndroidContentIntent;
  private String jdField_a_of_type_JavaLangString;
  private byte[] jdField_a_of_type_ArrayOfByte;
  
  public OCRHandler$BaseOCRReqBigDataListener(OCRHandler paramOCRHandler, Intent paramIntent, byte[] paramArrayOfByte, String paramString)
  {
    this.jdField_a_of_type_AndroidContentIntent = paramIntent;
    this.jdField_a_of_type_ArrayOfByte = paramArrayOfByte;
    this.jdField_a_of_type_JavaLangString = paramString;
  }
  
  public void onResp(NetResp paramNetResp)
  {
    if (QLog.isColorLevel()) {
      QLog.i("Q.ocr.OCRHandlerImpl", 2, "BaseOCRReqBigListener.onResp()");
    }
    ThreadManager.post(new OCRHandler.BaseOCRReqBigDataListener.1(this, paramNetResp), 8, null, true);
  }
  
  public void onUpdateProgeress(NetReq paramNetReq, long paramLong1, long paramLong2) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.api.impl.OCRHandler.BaseOCRReqBigDataListener
 * JD-Core Version:    0.7.0.1
 */