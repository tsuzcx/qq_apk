package com.tencent.mtt.hippy.modules;

import android.text.TextUtils;
import com.tencent.mtt.hippy.HippyEngineContext;
import com.tencent.mtt.hippy.bridge.a;
import com.tencent.mtt.hippy.common.HippyMap;

public class PromiseImpl
  implements Promise
{
  private static final String CALL_ID_NO_CALLBACK = "-1";
  public static final int PROMISE_CODE_NORMAN_ERROR = 1;
  public static final int PROMISE_CODE_OTHER_ERROR = 2;
  public static final int PROMISE_CODE_SUCCESS = 0;
  private final String mCallId;
  private final HippyEngineContext mContext;
  private final String mModuleFunc;
  private final String mModuleName;
  private boolean mNeedResolveBySelf = true;
  
  public PromiseImpl(HippyEngineContext paramHippyEngineContext, String paramString1, String paramString2, String paramString3)
  {
    this.mContext = paramHippyEngineContext;
    this.mModuleName = paramString1;
    this.mModuleFunc = paramString2;
    this.mCallId = paramString3;
  }
  
  public void doCallback(int paramInt, Object paramObject)
  {
    if (TextUtils.equals("-1", this.mCallId)) {
      return;
    }
    HippyMap localHippyMap = new HippyMap();
    localHippyMap.pushInt("result", paramInt);
    localHippyMap.pushString("moduleName", this.mModuleName);
    localHippyMap.pushString("moduleFunc", this.mModuleFunc);
    localHippyMap.pushString("callId", this.mCallId);
    localHippyMap.pushObject("params", paramObject);
    this.mContext.getBridgeManager().a(localHippyMap);
  }
  
  public String getCallId()
  {
    return this.mCallId;
  }
  
  public boolean isCallback()
  {
    return TextUtils.equals(this.mCallId, "-1") ^ true;
  }
  
  public boolean needResolveBySelf()
  {
    return this.mNeedResolveBySelf;
  }
  
  public void reject(Object paramObject)
  {
    doCallback(2, paramObject);
  }
  
  public void resolve(Object paramObject)
  {
    doCallback(0, paramObject);
  }
  
  public void setNeedResolveBySelf(boolean paramBoolean)
  {
    this.mNeedResolveBySelf = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mtt.hippy.modules.PromiseImpl
 * JD-Core Version:    0.7.0.1
 */