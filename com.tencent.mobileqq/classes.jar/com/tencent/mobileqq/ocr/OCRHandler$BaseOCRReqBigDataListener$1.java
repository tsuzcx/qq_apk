package com.tencent.mobileqq.ocr;

import android.content.Intent;
import ayre;
import ayrf;
import com.tencent.mobileqq.transfile.FMTSrvAddrProvider;
import com.tencent.mobileqq.transfile.NetResp;
import com.tencent.qphone.base.util.QLog;

public class OCRHandler$BaseOCRReqBigDataListener$1
  implements Runnable
{
  public OCRHandler$BaseOCRReqBigDataListener$1(ayrf paramayrf, NetResp paramNetResp) {}
  
  public void run()
  {
    int i = 0;
    ayre localayre;
    Intent localIntent;
    if ((this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp == null) || (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.mResult != 0))
    {
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp == null)
      {
        if (QLog.isColorLevel()) {
          QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), resp is null");
        }
        FMTSrvAddrProvider.getInstance().onFailed(6, ayrf.a(this.jdField_a_of_type_Ayrf));
        i = -10;
      }
    }
    else
    {
      localayre = this.jdField_a_of_type_Ayrf.a;
      localIntent = ayrf.a(this.jdField_a_of_type_Ayrf);
      if (this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp == null) {
        break label191;
      }
    }
    label191:
    for (byte[] arrayOfByte = this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.mRespData;; arrayOfByte = null)
    {
      ayre.a(localayre, i, localIntent, arrayOfByte, ayrf.a(this.jdField_a_of_type_Ayrf));
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.ocr.OCRHandler", 2, "BaseOCRReqBigListener.onResp(), mResult=" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.mResult + ",mErrCode=" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.mErrCode + ",mHttpCode=" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.mHttpCode + ",mErrDesc=" + this.jdField_a_of_type_ComTencentMobileqqTransfileNetResp.mErrDesc);
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OCRHandler.BaseOCRReqBigDataListener.1
 * JD-Core Version:    0.7.0.1
 */