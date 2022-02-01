package com.tencent.mobileqq.ocr.data;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class OcrDpc
{
  public static DPCObserver a;
  public static OcrDpc a;
  private static final String b;
  public int a;
  public String a;
  public int b;
  public int c = 800;
  public int d = 1080;
  public int e = 1920;
  public int f = 100;
  public int g = 6;
  public int h = 140;
  public int i = 100;
  
  static
  {
    jdField_b_of_type_JavaLangString = DPCNames.ocrCfg.name();
    jdField_a_of_type_ComTencentMobileqqDpcDPCObserver = new OcrDpc.1();
  }
  
  public OcrDpc()
  {
    this.jdField_a_of_type_Int = 1;
    this.jdField_b_of_type_Int = 70;
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(jdField_a_of_type_ComTencentMobileqqDpcDPCObserver);
  }
  
  public static OcrDpc a()
  {
    OcrDpc localOcrDpc = jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc;
    if (localOcrDpc != null) {
      return localOcrDpc;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.dpc", 2, "get ocrDpc is null");
    }
    a();
    return jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc;
  }
  
  public static void a()
  {
    try
    {
      Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(jdField_b_of_type_JavaLangString);
      jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc = new OcrDpc();
      jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.jdField_a_of_type_JavaLangString = ((String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split("\\|");
        int j = localObject1.length;
        if (j >= 9) {
          try
          {
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.jdField_a_of_type_Int = Integer.valueOf(localObject1[0]).intValue();
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.jdField_b_of_type_Int = Integer.valueOf(localObject1[1]).intValue();
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.c = Integer.valueOf(localObject1[2]).intValue();
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.d = Integer.valueOf(localObject1[3]).intValue();
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.e = Integer.valueOf(localObject1[4]).intValue();
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.f = Integer.valueOf(localObject1[5]).intValue();
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.g = Integer.valueOf(localObject1[6]).intValue();
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.h = Integer.valueOf(localObject1[7]).intValue();
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.i = Integer.valueOf(localObject1[8]).intValue();
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("load exp:");
            localStringBuilder2.append(localException.getMessage());
            QLog.d("Q.ocr.dpc", 1, localStringBuilder2.toString());
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.jdField_b_of_type_Int = 70;
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.c = 800;
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.d = 1080;
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.e = 1920;
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.f = 100;
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.g = 6;
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.h = 140;
            jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc.i = 100;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("load ocrDpc:");
        localStringBuilder1.append(jdField_a_of_type_ComTencentMobileqqOcrDataOcrDpc);
        QLog.d("Q.ocr.dpc", 2, localStringBuilder1.toString());
      }
      return;
    }
    finally {}
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ocrSwitch:");
    localStringBuilder.append(this.jdField_a_of_type_Int);
    localStringBuilder.append(",picQuality:");
    localStringBuilder.append(this.jdField_b_of_type_Int);
    localStringBuilder.append(",picShortestSide:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",maxPreviewWidth:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",maxPreviewHeight:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",");
    localStringBuilder.append(this.i);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrDpc
 * JD-Core Version:    0.7.0.1
 */