package org.xwalk.core.extension;

import java.util.HashMap;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xwalk.core.Log;

public class EventTarget
  extends BindingObject
{
  private String TAG = "EventTarget";
  private Map<String, MessageInfo> mEvents = new HashMap();
  
  public EventTarget()
  {
    this.mHandler.register("addEventListener", this);
    this.mHandler.register("removeEventListener", this);
  }
  
  public void dispatchEvent(String paramString)
  {
    dispatchEvent(paramString, null);
  }
  
  public void dispatchEvent(String paramString, JSONObject paramJSONObject)
  {
    try
    {
      if (!this.mEvents.containsKey(paramString))
      {
        paramJSONObject = this.TAG;
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("Attempt to dispatch to non-existing event :");
        ((StringBuilder)localObject).append(paramString);
        Log.w(paramJSONObject, ((StringBuilder)localObject).toString());
        return;
      }
      paramString = (MessageInfo)this.mEvents.get(paramString);
      Object localObject = new JSONArray();
      if (paramJSONObject != null) {
        ((JSONArray)localObject).put(0, paramJSONObject);
      }
      paramString.postResult((JSONArray)localObject);
      return;
    }
    catch (JSONException paramString)
    {
      Log.e(this.TAG, paramString.toString());
    }
  }
  
  public boolean isEventActive(String paramString)
  {
    return this.mEvents.containsKey(paramString);
  }
  
  public void onAddEventListener(MessageInfo paramMessageInfo)
  {
    try
    {
      String str = paramMessageInfo.getArgs().getString(0);
      if (this.mEvents.containsKey(str))
      {
        paramMessageInfo = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Trying to re-add the event :");
        localStringBuilder.append(str);
        Log.w(paramMessageInfo, localStringBuilder.toString());
        return;
      }
      this.mEvents.put(str, paramMessageInfo);
      startEvent(str);
      return;
    }
    catch (JSONException paramMessageInfo)
    {
      Log.e(this.TAG, paramMessageInfo.toString());
    }
  }
  
  public void onRemoveEventListener(MessageInfo paramMessageInfo)
  {
    try
    {
      paramMessageInfo = paramMessageInfo.getArgs().getString(0);
      if (!this.mEvents.containsKey(paramMessageInfo))
      {
        String str = this.TAG;
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("Attempt to remove non-existing event :");
        localStringBuilder.append(paramMessageInfo);
        Log.w(str, localStringBuilder.toString());
        return;
      }
      stopEvent(paramMessageInfo);
      this.mEvents.remove(paramMessageInfo);
      return;
    }
    catch (JSONException paramMessageInfo)
    {
      Log.e(this.TAG, paramMessageInfo.toString());
    }
  }
  
  public void startEvent(String paramString) {}
  
  public void stopEvent(String paramString) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.extension.EventTarget
 * JD-Core Version:    0.7.0.1
 */