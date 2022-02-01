package com.tencent.qqlive.module.videoreport.dtreport.reportchannel;

import android.support.annotation.NonNull;
import com.tencent.qqlive.module.videoreport.IEventDynamicParams;
import com.tencent.qqlive.module.videoreport.dtreport.api.IDTParamProvider;
import com.tencent.qqlive.module.videoreport.dtreport.verifydata.VerifyDataHelper;
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
    if ((this.mDtParamProvider == null) || (paramMap == null)) {
      return;
    }
    paramMap.putAll(DTCommonParams.getCommParams(this.mDtParamProvider));
  }
  
  private void checkParams(@NonNull Map<String, Object> paramMap)
  {
    VerifyDataHelper.checkMap(paramMap);
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
    this.mDtParamProvider.setEventDynamicParams(paramString, localMap);
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
    this.mDtParamProvider.setNonRealtimePublicDynamicParams(localMap);
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
    this.mDtParamProvider.setRealtimePublicDynamicParams(localMap);
    checkParams(localMap);
    if (paramMap != null) {
      paramMap.putAll(localMap);
    }
    localMap.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.dtreport.reportchannel.DTEventDynamicParams
 * JD-Core Version:    0.7.0.1
 */