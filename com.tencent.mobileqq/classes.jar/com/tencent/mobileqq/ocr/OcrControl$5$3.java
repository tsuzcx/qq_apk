package com.tencent.mobileqq.ocr;

import aubp;
import axrn;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class OcrControl$5$3
  implements Runnable
{
  public OcrControl$5$3(aubp paramaubp, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void run()
  {
    HashMap localHashMap = new HashMap();
    localHashMap.put("ocr_sso_code", String.valueOf(this.jdField_a_of_type_Int));
    localHashMap.put("ocr_code", String.valueOf(this.b));
    localHashMap.put("ret_code", String.valueOf(this.c));
    try
    {
      axrn.a(BaseApplicationImpl.getContext()).a("", "ocr_server_fail", true, 0L, 0L, localHashMap, "", false);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QLog.d("Q.ocr.control", 1, "collectPerformance exception: " + localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.OcrControl.5.3
 * JD-Core Version:    0.7.0.1
 */