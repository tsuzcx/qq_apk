package com.tencent.viola.vinstance;

import com.tencent.viola.core.ViolaInstance;
import com.tencent.viola.utils.ViolaLogUtils;
import java.util.concurrent.atomic.AtomicInteger;
import org.json.JSONObject;

public class NoBlockVInstanceAction
  extends VInstanceAction
{
  public NoBlockVInstanceAction(Preconditor paramPreconditor, ViolaInstance paramViolaInstance, JSONObject paramJSONObject)
  {
    super(paramPreconditor, paramViolaInstance, paramJSONObject);
  }
  
  public void createVInstance(String paramString1, String paramString2)
  {
    updateInstance(paramString1, paramString2);
  }
  
  public void doInit(boolean paramBoolean)
  {
    this.preconditor.process(paramBoolean);
  }
  
  public void updateInstance(String paramString1, String paramString2)
  {
    int i = this.state.get();
    if (i == 2)
    {
      retryInit();
      addFailQueue(paramString1, paramString2);
      ViolaLogUtils.d("Wormhole", "precondition fail, retry again, id: " + paramString1 + ", data: " + paramString2);
      return;
    }
    if (i == 3)
    {
      this.violaInstance.updateInstance(paramString2);
      addPendingUpdateQueue(paramString1, paramString2);
      return;
    }
    addFailQueue(paramString1, paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.viola.vinstance.NoBlockVInstanceAction
 * JD-Core Version:    0.7.0.1
 */