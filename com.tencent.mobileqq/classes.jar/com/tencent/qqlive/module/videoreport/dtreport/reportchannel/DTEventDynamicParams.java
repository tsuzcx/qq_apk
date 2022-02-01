package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.dtreport.verifydata.VerifyDataHelper;
import com.tencent.qqlive.module.videoreport.inner.VideoReportInner;
import java.util.Map;

public class DTEventDynamicParams
  implements IEventDynamicParams
{
  private IDTParamProvider mDtParamProvider;
  private final ThreadLocal<Map<String, Object>> mEventParams = new DTEventDynamicParams.ThreadLocalMap(null);
  private final ThreadLocal<Map<String, Object>> mNonRealTimeParams = new DTEventDynamicParams.ThreadLocalMap(null);
  private final ThreadLocal<Map<String, Object>> mRealTimeParams = new DTEventDynamicParams.ThreadLocalMap(null);
  
  private void addDTParams(Map<String, Object> paramMap)
  {
    IDTParamProvider localIDTParamProvider = this.mDtParamProvider;
    if (localIDTParamProvider != null)
    {
      if (paramMap == null) {
        return;
      }
      paramMap.putAll(DTCommonParams.getCommParams(localIDTParamProvider));
    }
  }
  
  private void checkParams(@NonNull Map<String, Object> paramMap)
  {
    if (VideoReportInner.getInstance().isDebugMode()) {
      VerifyDataHelper.checkMap(paramMap);
    }
  }
  
  public static DTEventDynamicParams getInstance()
  {
    return DTEventDynamicParams.InstanceHolder.access$200();
  }
  
  public IDTParamProvider getDTParamProvider()
  {
    return this.mDtParamProvider;
  }
  
  public void setDTCommonParams(@NonNull IDTParamProvider paramIDTParamProvider)
  {
    this.mDtParamProvider = paramIDTParamProvider;
  }
  
  public void setEventDynamicParams(String paramString, Map<String, Object> paramMap)
  {
    Map localMap = (Map)this.mEventParams.get();
    localMap.clear();
    IDTParamProvider localIDTParamProvider = this.mDtParamProvider;
    if (localIDTParamProvider != null) {
      localIDTParamProvider.setEventDynamicParams(paramString, localMap);
    }
    checkParams(localMap);
    if (paramMap != null) {
      paramMap.putAll(localMap);
    }
    localMap.clear();
  }
  
  public void setNonRealtimePublicDynamicParams(Map<String, Object> paramMap)
  {
    Map localMap = (Map)this.mNonRealTimeParams.get();
    localMap.clear();
    IDTParamProvider localIDTParamProvider = this.mDtParamProvider;
    if (localIDTParamProvider != null) {
      localIDTParamProvider.setNonRealtimePublicDynamicParams(localMap);
    }
    checkParams(localMap);
    if (paramMap != null) {
      paramMap.putAll(localMap);
    }
    addDTParams(paramMap);
    localMap.clear();
  }
  
  public void setRealtimePublicDynamicParams(Map<String, Object> paramMap)
  {
    Map localMap = (Map)this.mRealTimeParams.get();
    localMap.clear();
    IDTParamProvider localIDTParamProvider = this.mDtParamProvider;
    if (localIDTParamProvider != null) {
      localIDTParamProvider.setRealtimePublicDynamicParams(localMap);
    }
    checkParams(localMap);
    if (paramMap != null) {
      paramMap.putAll(localMap);
    }
    localMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTEventDynamicParams
 * JD-Core Version:    0.7.0.1
 */