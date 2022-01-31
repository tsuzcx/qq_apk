package com.tencent.mobileqq.qmcf.processor;

import android.util.Log;
import com.tencent.mobileqq.qmcf.QMCF;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfModelItem;

public class PoseDetectProcessor
  extends BaseQmcfProcessor
{
  protected String a;
  float[] a;
  String b = "";
  
  public PoseDetectProcessor(int paramInt1, int paramInt2)
  {
    this.jdField_a_of_type_JavaLangString = "PoseDetectProcessor";
    a(paramInt1, paramInt2);
  }
  
  protected String a(int paramInt1, int paramInt2)
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (QmcfManager.a().b() == 1)
      {
        long l = System.currentTimeMillis();
        jdField_a_of_type_ComTencentMobileqqQmcfQMCF.snpePoseProcess(paramInt1, b(), a());
        Log.d("poseInfo", "doProcess cost:" + (System.currentTimeMillis() - l));
        this.b = "success";
        return this.b;
      }
      this.b = jdField_a_of_type_ComTencentMobileqqQmcfQMCF.PoseProcess(paramInt1, paramInt2);
    }
  }
  
  protected String a(QmcfModelItem paramQmcfModelItem)
  {
    if (paramQmcfModelItem == null)
    {
      this.b = "init model is null";
      return this.b;
    }
    Object localObject = jdField_a_of_type_JavaLangObject;
    int i = 0;
    label155:
    label182:
    label233:
    for (;;)
    {
      try
      {
        if (!QmcfManager.jdField_a_of_type_Boolean) {
          break label233;
        }
        i = jdField_a_of_type_ComTencentMobileqqQmcfQMCF.snpeAvaliableType();
        if (i > 0)
        {
          QmcfManager.a().c(1);
          if (QmcfManager.a().b() != 1) {
            break label182;
          }
          if (!paramQmcfModelItem.jdField_a_of_type_Boolean) {
            break label155;
          }
          jdField_a_of_type_ComTencentMobileqqQmcfQMCF.snpePoseInitEnc(b(), a(), jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.c, paramQmcfModelItem.c, paramQmcfModelItem.jdField_a_of_type_Boolean);
          this.b = "success";
          Log.d("poseInfo", "doInit result:" + this.b + " ,availableType:" + i);
          break;
        }
      }
      finally {}
      QmcfManager.a().c(3);
      break label233;
      jdField_a_of_type_ComTencentMobileqqQmcfQMCF.snpePoseInit(b(), a(), jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.c, paramQmcfModelItem.c);
      continue;
      String str = a(paramQmcfModelItem.jdField_a_of_type_JavaLangString, b(), a());
      this.b = jdField_a_of_type_ComTencentMobileqqQmcfQMCF.PoseInit(b(), a(), str, jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.c, paramQmcfModelItem.b);
    }
  }
  
  public float[] a()
  {
    synchronized (jdField_a_of_type_JavaLangObject)
    {
      if (QmcfManager.a().b() == 1)
      {
        this.jdField_a_of_type_ArrayOfFloat = jdField_a_of_type_ComTencentMobileqqQmcfQMCF.snpePoseKeyPoints();
        return this.jdField_a_of_type_ArrayOfFloat;
      }
      this.jdField_a_of_type_ArrayOfFloat = jdField_a_of_type_ComTencentMobileqqQmcfQMCF.PoseKeyPoints();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.processor.PoseDetectProcessor
 * JD-Core Version:    0.7.0.1
 */