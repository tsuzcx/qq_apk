package com.tencent.mobileqq.qmcf.processor;

import android.util.Log;
import com.tencent.mobileqq.qmcf.QMCF;
import com.tencent.mobileqq.qmcf.QmcfManager;
import com.tencent.mobileqq.qmcf.QmcfModelItem;

public class PoseDetectProcessor
  extends BaseQmcfProcessor
{
  final int jdField_a_of_type_Int = 18;
  protected String a;
  float[] jdField_a_of_type_ArrayOfFloat = new float[109];
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
        this.b = jdField_a_of_type_ComTencentMobileqqQmcfQMCF.snpePoseProcess(paramInt1, paramInt2);
        Log.d("poseInfo", "doProcess cost:" + (System.currentTimeMillis() - l));
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
    label148:
    label199:
    for (;;)
    {
      try
      {
        if (!QmcfManager.a) {
          break label199;
        }
        i = jdField_a_of_type_ComTencentMobileqqQmcfQMCF.snpeAvaliableType();
        if (i > 0)
        {
          QmcfManager.a().c(1);
          if (QmcfManager.a().b() != 1) {
            break label148;
          }
          this.b = jdField_a_of_type_ComTencentMobileqqQmcfQMCF.snpePoseInit(b(), a(), jdField_a_of_type_ComTencentMobileqqQmcfQmcfManager.c, paramQmcfModelItem.c, 18, paramQmcfModelItem.jdField_a_of_type_Int);
          Log.d("poseInfo", "doInit result:" + this.b + " ,availableType:" + i);
          break;
        }
      }
      finally {}
      QmcfManager.a().c(3);
      break label199;
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
        jdField_a_of_type_ComTencentMobileqqQmcfQMCF.snpeSkeletonPose(this.jdField_a_of_type_ArrayOfFloat);
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