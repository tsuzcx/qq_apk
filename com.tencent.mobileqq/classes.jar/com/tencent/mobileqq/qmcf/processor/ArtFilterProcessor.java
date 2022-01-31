package com.tencent.mobileqq.qmcf.processor;

import com.tencent.mobileqq.qmcf.QMCF;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfModelItem;
import com.tencent.sveffects.SLog;

public class ArtFilterProcessor
  extends BaseQmcfProcessor
{
  protected String a;
  String b = "";
  
  public ArtFilterProcessor(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = "ArtFilterProcessor";
    a(paramInt1, paramInt2);
  }
  
  protected String a(int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      this.b = jdField_a_of_type_ComTencentMobileqqQmcfQMCF.ArtProcess(paramInt1, paramInt2);
      return this.b;
    }
  }
  
  protected String a(QmcfModelItem paramQmcfModelItem)
  {
    if (paramQmcfModelItem == null) {
      this.b = "init model is null";
    }
    for (;;)
    {
      return this.b;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        String str = a(paramQmcfModelItem.jdField_a_of_type_JavaLangString, a(), b());
        this.b = jdField_a_of_type_ComTencentMobileqqQmcfQMCF.ArtInit(str, jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.c, paramQmcfModelItem.b);
      }
    }
  }
  
  protected boolean a(QmcfModelItem paramQmcfModelItem)
  {
    if (paramQmcfModelItem == null) {
      this.b = "switch model is null";
    }
    for (;;)
    {
      boolean bool = "success".equals(this.b);
      if ((!bool) && (SLog.a())) {
        SLog.d(this.jdField_a_of_type_JavaLangString, "modelSwitch error:" + this.b);
      }
      return bool;
      synchronized (jdField_a_of_type_JavaLangObject)
      {
        String str = a(paramQmcfModelItem.jdField_a_of_type_JavaLangString, a(), b());
        this.b = jdField_a_of_type_ComTencentMobileqqQmcfQMCF.ArtSwitchModel(str, jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.c, paramQmcfModelItem.b);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.processor.ArtFilterProcessor
 * JD-Core Version:    0.7.0.1
 */