package com.tencent.mobileqq.qmcf;

import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.sveffects.Reporter;
import com.tencent.sveffects.SLog;
import com.tencent.sveffects.SdkContext;
import java.util.HashMap;

public class QmcfReporter
{
  public float a;
  public int a;
  public float b;
  public int b;
  
  public QmcfReporter()
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_b_of_type_Int = 0;
  }
  
  public static void a(String paramString, HashMap paramHashMap, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap.put("manufacture", Build.MANUFACTURER);
      paramHashMap.put("model", Build.MODEL);
      paramHashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    }
    SdkContext.a().a().a(paramString, true, paramInt, 0L, paramHashMap);
  }
  
  public static void a(String paramString, HashMap paramHashMap, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap.put("manufacture", Build.MANUFACTURER);
      paramHashMap.put("model", Build.MODEL);
      paramHashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    }
    SdkContext.a().a().a(paramString, true, 0L, 0L, paramHashMap);
  }
  
  public void a()
  {
    this.jdField_a_of_type_Float = -1.0F;
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_Float = -1.0F;
    this.jdField_b_of_type_Int = 0;
  }
  
  public void a(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    HashMap localHashMap;
    if ((QmcfManager.a().a()) && (this.jdField_a_of_type_Float != -1.0F))
    {
      localHashMap = new HashMap();
      localHashMap.put("svaf_frameCost", String.valueOf(this.jdField_a_of_type_Float));
      localHashMap.put("qmcf_processCost", String.valueOf(this.jdField_b_of_type_Float));
      localHashMap.put("svaf_cameraType", String.valueOf(paramInt1));
      localHashMap.put("svaf_busiType", String.valueOf(paramInt2));
      localHashMap.put("svaf_which_component", "qmcf");
      localHashMap.put("svaf_qmcf_mode", String.valueOf(paramInt3));
      localHashMap.put("qmcf_frameType", String.valueOf(paramInt4));
      if (TextUtils.isEmpty(paramString)) {
        break label231;
      }
      localHashMap.put("svaf_templateID", String.valueOf(paramInt2));
    }
    for (;;)
    {
      a("svaf_record_info", localHashMap, (int)this.jdField_a_of_type_Float, true);
      if (SLog.a()) {
        SLog.d("GMCF_REPORTER", String.format("reportMtaQmcf, frameCost[%s], proCost[%s], cameraType[%s], busiType[%s], templateId[%s], qmcfmode[%s], frameTpye[%s]", new Object[] { Float.valueOf(this.jdField_a_of_type_Float), Float.valueOf(this.jdField_b_of_type_Float), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
      }
      a();
      return;
      label231:
      paramString = "non";
    }
  }
  
  public void a(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.jdField_a_of_type_Float = ((this.jdField_a_of_type_Float * this.jdField_a_of_type_Int + (float)paramLong) / (this.jdField_a_of_type_Int + 1));
      this.jdField_a_of_type_Int += 1;
    }
  }
  
  public void b(long paramLong)
  {
    if (paramLong > 0L)
    {
      this.jdField_b_of_type_Float = ((this.jdField_b_of_type_Float * this.jdField_b_of_type_Int + (float)paramLong) / (this.jdField_b_of_type_Int + 1));
      this.jdField_b_of_type_Int += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.QmcfReporter
 * JD-Core Version:    0.7.0.1
 */