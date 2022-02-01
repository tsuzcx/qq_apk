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
  public static final String SVAF_EVENT_INIT_BLOCK = "svaf_init_block";
  public static final String SVAF_EVENT_INIT_COST3S = "svaf_init_cost3s";
  public static final String SVAF_EVENT_INIT_ERROR = "svaf_init_error";
  public static final String SVAF_EVENT_NOSUPPORT_OCL = "svaf_nosupport_ocl";
  public static final String SVAF_EVENT_RECORD_INFO = "svaf_record_info";
  public static final String SVAF_PARAM_BUSI_TYPE = "svaf_busiType";
  public static final String SVAF_PARAM_CAMERA_TYPE = "svaf_cameraType";
  public static final String SVAF_PARAM_COST = "svaf_cost";
  public static final String SVAF_PARAM_ENTRANCE_STATE = "qmcf_entrState";
  public static final String SVAF_PARAM_FRAMETYPE = "qmcf_frameType";
  public static final String SVAF_PARAM_FRAME_COST = "svaf_frameCost";
  public static final String SVAF_PARAM_GPUINFO = "svaf_gpuinfo";
  public static final String SVAF_PARAM_HAS_ENTRANCE = "qmcf_hasEntrance";
  public static final String SVAF_PARAM_PROCESS_COST = "qmcf_processCost";
  public static final String SVAF_PARAM_QMCF_MODE = "svaf_qmcf_mode";
  public static final String SVAF_PARAM_RESULT = "svaf_result";
  public static final String SVAF_PARAM_TEMPLATE_ID = "svaf_templateID";
  public static final String SVAF_PARAM_WHICH_COMPONENT = "svaf_which_component";
  private static final String TAG = "GMCF_REPORTER";
  public float avgFrameConsume = -1.0F;
  public float avgProcessConsume = -1.0F;
  public int processCount = 0;
  public int updateCount = 0;
  
  public static void report(String paramString, HashMap paramHashMap, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap.put("manufacture", Build.MANUFACTURER);
      paramHashMap.put("model", Build.MODEL);
      paramHashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    }
    SdkContext.getInstance().getReporter().reportToBeacon(paramString, true, 0L, 0L, paramHashMap);
  }
  
  public static void reportTime(String paramString, HashMap paramHashMap, int paramInt, boolean paramBoolean)
  {
    if ((paramBoolean) && (paramHashMap != null))
    {
      paramHashMap.put("manufacture", Build.MANUFACTURER);
      paramHashMap.put("model", Build.MODEL);
      paramHashMap.put("sdk", String.valueOf(Build.VERSION.SDK_INT));
    }
    SdkContext.getInstance().getReporter().reportToBeacon(paramString, true, paramInt, 0L, paramHashMap);
  }
  
  public void clearReporter()
  {
    this.avgFrameConsume = -1.0F;
    this.updateCount = 0;
    this.avgProcessConsume = -1.0F;
    this.processCount = 0;
  }
  
  public void reportMtaFrameCost(int paramInt1, int paramInt2, String paramString, int paramInt3, int paramInt4)
  {
    if ((QmcfManager.getInstance().isQmcfWork()) && (this.avgFrameConsume != -1.0F))
    {
      HashMap localHashMap = new HashMap();
      localHashMap.put("svaf_frameCost", String.valueOf(this.avgFrameConsume));
      localHashMap.put("qmcf_processCost", String.valueOf(this.avgProcessConsume));
      localHashMap.put("svaf_cameraType", String.valueOf(paramInt1));
      localHashMap.put("svaf_busiType", String.valueOf(paramInt2));
      localHashMap.put("svaf_which_component", "qmcf");
      localHashMap.put("svaf_qmcf_mode", String.valueOf(paramInt3));
      localHashMap.put("qmcf_frameType", String.valueOf(paramInt4));
      if (!TextUtils.isEmpty(paramString)) {
        localHashMap.put("svaf_templateID", String.valueOf(paramInt2));
      } else {
        paramString = "non";
      }
      reportTime("svaf_record_info", localHashMap, (int)this.avgFrameConsume, true);
      if (SLog.isEnable()) {
        SLog.d("GMCF_REPORTER", String.format("reportMtaQmcf, frameCost[%s], proCost[%s], cameraType[%s], busiType[%s], templateId[%s], qmcfmode[%s], frameTpye[%s]", new Object[] { Float.valueOf(this.avgFrameConsume), Float.valueOf(this.avgProcessConsume), Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString, Integer.valueOf(paramInt3), Integer.valueOf(paramInt4) }));
      }
    }
    clearReporter();
  }
  
  public void updateFrameConsume(long paramLong)
  {
    if (paramLong > 0L)
    {
      float f = this.avgFrameConsume;
      int i = this.updateCount;
      this.avgFrameConsume = ((f * i + (float)paramLong) / (i + 1));
      this.updateCount = (i + 1);
    }
  }
  
  public void updateProcessConsume(long paramLong)
  {
    if (paramLong > 0L)
    {
      float f = this.avgProcessConsume;
      int i = this.processCount;
      this.avgProcessConsume = ((f * i + (float)paramLong) / (i + 1));
      this.processCount = (i + 1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.qmcf.QmcfReporter
 * JD-Core Version:    0.7.0.1
 */