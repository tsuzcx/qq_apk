package com.tencent.mobileqq.ocr.data;

import android.text.TextUtils;
import com.tencent.mobileqq.dpc.DPCObserver;
import com.tencent.mobileqq.dpc.api.IDPCApi;
import com.tencent.mobileqq.dpc.enumname.DPCNames;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.qphone.base.util.QLog;

public class OcrDpc
{
  public static OcrDpc a;
  public static DPCObserver l = new OcrDpc.1();
  private static final String m = DPCNames.ocrCfg.name();
  public String b;
  public int c = 1;
  public int d = 70;
  public int e = 800;
  public int f = 1080;
  public int g = 1920;
  public int h = 100;
  public int i = 6;
  public int j = 140;
  public int k = 100;
  
  public OcrDpc()
  {
    ((IDPCApi)QRoute.api(IDPCApi.class)).addObserver(l);
  }
  
  public static void a()
  {
    try
    {
      Object localObject1 = ((IDPCApi)QRoute.api(IDPCApi.class)).getFeatureValueWithoutAccountManager(m);
      a = new OcrDpc();
      a.b = ((String)localObject1);
      if (!TextUtils.isEmpty((CharSequence)localObject1))
      {
        localObject1 = ((String)localObject1).split("\\|");
        int n = localObject1.length;
        if (n >= 9) {
          try
          {
            a.c = Integer.valueOf(localObject1[0]).intValue();
            a.d = Integer.valueOf(localObject1[1]).intValue();
            a.e = Integer.valueOf(localObject1[2]).intValue();
            a.f = Integer.valueOf(localObject1[3]).intValue();
            a.g = Integer.valueOf(localObject1[4]).intValue();
            a.h = Integer.valueOf(localObject1[5]).intValue();
            a.i = Integer.valueOf(localObject1[6]).intValue();
            a.j = Integer.valueOf(localObject1[7]).intValue();
            a.k = Integer.valueOf(localObject1[8]).intValue();
          }
          catch (Exception localException)
          {
            StringBuilder localStringBuilder2 = new StringBuilder();
            localStringBuilder2.append("load exp:");
            localStringBuilder2.append(localException.getMessage());
            QLog.d("Q.ocr.dpc", 1, localStringBuilder2.toString());
            a.d = 70;
            a.e = 800;
            a.f = 1080;
            a.g = 1920;
            a.h = 100;
            a.i = 6;
            a.j = 140;
            a.k = 100;
          }
        }
      }
      if (QLog.isColorLevel())
      {
        StringBuilder localStringBuilder1 = new StringBuilder();
        localStringBuilder1.append("load ocrDpc:");
        localStringBuilder1.append(a);
        QLog.d("Q.ocr.dpc", 2, localStringBuilder1.toString());
      }
      return;
    }
    finally {}
  }
  
  public static OcrDpc b()
  {
    OcrDpc localOcrDpc = a;
    if (localOcrDpc != null) {
      return localOcrDpc;
    }
    if (QLog.isColorLevel()) {
      QLog.d("Q.ocr.dpc", 2, "get ocrDpc is null");
    }
    a();
    return a;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("ocrSwitch:");
    localStringBuilder.append(this.c);
    localStringBuilder.append(",picQuality:");
    localStringBuilder.append(this.d);
    localStringBuilder.append(",picShortestSide:");
    localStringBuilder.append(this.e);
    localStringBuilder.append(",maxPreviewWidth:");
    localStringBuilder.append(this.f);
    localStringBuilder.append(",maxPreviewHeight:");
    localStringBuilder.append(this.g);
    localStringBuilder.append(",");
    localStringBuilder.append(this.h);
    localStringBuilder.append(",");
    localStringBuilder.append(this.i);
    localStringBuilder.append(",");
    localStringBuilder.append(this.j);
    localStringBuilder.append(",");
    localStringBuilder.append(this.k);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.ocr.data.OcrDpc
 * JD-Core Version:    0.7.0.1
 */