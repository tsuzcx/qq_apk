package org.xwalk.core.extension;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.xwalk.core.Log;

public class BindingObjectStore
{
  private String TAG = "BindingObjectStore";
  private Map<String, BindingObject> mBindingObjects = new HashMap();
  private ExtensionInstanceHelper mInstance;
  
  public BindingObjectStore(MessageHandler paramMessageHandler, ExtensionInstanceHelper paramExtensionInstanceHelper)
  {
    this.mInstance = paramExtensionInstanceHelper;
    paramMessageHandler.register("JSObjectCollected", "onJSObjectCollected", this);
    paramMessageHandler.register("postMessageToObject", "onPostMessageToObject", this);
    paramMessageHandler.register("postMessageToClass", "onPostMessageToClass", this);
  }
  
  public boolean addBindingObject(String paramString, BindingObject paramBindingObject)
  {
    if (this.mBindingObjects.containsKey(paramString))
    {
      paramBindingObject = this.TAG;
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Existing binding object:\n");
      localStringBuilder.append(paramString);
      Log.w(paramBindingObject, localStringBuilder.toString());
      return false;
    }
    paramBindingObject.initBindingInfo(paramString, this.mInstance);
    this.mBindingObjects.put(paramString, paramBindingObject);
    paramBindingObject.onJsBound();
    return true;
  }
  
  public BindingObject getBindingObject(String paramString)
  {
    return (BindingObject)this.mBindingObjects.get(paramString);
  }
  
  public void onDestroy()
  {
    Iterator localIterator = this.mBindingObjects.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BindingObject)((Map.Entry)localIterator.next()).getValue()).onDestroy();
    }
  }
  
  public void onJSObjectCollected(MessageInfo paramMessageInfo)
  {
    removeBindingObject(paramMessageInfo.getObjectId());
  }
  
  public void onPause()
  {
    Iterator localIterator = this.mBindingObjects.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BindingObject)((Map.Entry)localIterator.next()).getValue()).onPause();
    }
  }
  
  public Object onPostMessageToClass(MessageInfo paramMessageInfo)
  {
    Object localObject = paramMessageInfo.getArgs();
    try
    {
      MessageInfo localMessageInfo = new MessageInfo(paramMessageInfo);
      String str = ((JSONArray)localObject).getString(0);
      JSONArray localJSONArray = ((JSONArray)localObject).getJSONArray(1);
      localObject = localJSONArray.getString(0);
      localJSONArray = localJSONArray.getJSONArray(1);
      localMessageInfo.setJsName(str);
      localMessageInfo.setArgs(localJSONArray);
      paramMessageInfo = paramMessageInfo.getExtension().getTargetReflect((String)localObject).handleMessage(localMessageInfo, null);
      return paramMessageInfo;
    }
    catch (Exception paramMessageInfo)
    {
      Log.e(this.TAG, paramMessageInfo.toString());
      return null;
    }
    catch (JSONException paramMessageInfo)
    {
      Log.e(this.TAG, paramMessageInfo.toString());
    }
    return null;
  }
  
  public Object onPostMessageToObject(MessageInfo paramMessageInfo)
  {
    try
    {
      BindingObject localBindingObject = getBindingObject(paramMessageInfo.getObjectId());
      MessageInfo localMessageInfo = new MessageInfo(paramMessageInfo);
      Object localObject;
      if (paramMessageInfo.getArgs() != null)
      {
        localObject = paramMessageInfo.getArgs();
        paramMessageInfo = ((JSONArray)localObject).getString(0);
        localObject = ((JSONArray)localObject).getJSONArray(1);
        localMessageInfo.setJsName(paramMessageInfo);
        localMessageInfo.setArgs((JSONArray)localObject);
      }
      else
      {
        localObject = paramMessageInfo.getBinaryArgs();
        ((ByteBuffer)localObject).order(ByteOrder.LITTLE_ENDIAN);
        int j = ((ByteBuffer)localObject).position();
        int i = ((ByteBuffer)localObject).getInt(j);
        j += 4;
        paramMessageInfo = new String(((ByteBuffer)localObject).array(), j, i);
        i = j + (4 - i % 4 + i);
        j = ((ByteBuffer)localObject).array().length;
        localObject = ByteBuffer.wrap(((ByteBuffer)localObject).array(), i, j - i);
        localMessageInfo.setJsName(paramMessageInfo);
        localMessageInfo.setBinaryArgs((ByteBuffer)localObject);
      }
      if (localBindingObject == null) {
        break label190;
      }
      paramMessageInfo = localBindingObject.handleMessage(localMessageInfo);
      return paramMessageInfo;
    }
    catch (NullPointerException paramMessageInfo) {}catch (IndexOutOfBoundsException paramMessageInfo) {}catch (JSONException paramMessageInfo) {}
    Log.e(this.TAG, paramMessageInfo.toString());
    label190:
    return null;
  }
  
  public void onResume()
  {
    Iterator localIterator = this.mBindingObjects.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BindingObject)((Map.Entry)localIterator.next()).getValue()).onResume();
    }
  }
  
  public void onStart()
  {
    Iterator localIterator = this.mBindingObjects.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BindingObject)((Map.Entry)localIterator.next()).getValue()).onStart();
    }
  }
  
  public void onStop()
  {
    Iterator localIterator = this.mBindingObjects.entrySet().iterator();
    while (localIterator.hasNext()) {
      ((BindingObject)((Map.Entry)localIterator.next()).getValue()).onStop();
    }
  }
  
  public BindingObject removeBindingObject(String paramString)
  {
    paramString = (BindingObject)this.mBindingObjects.remove(paramString);
    if (paramString != null) {
      paramString.onJsDestroyed();
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes16.jar
 * Qualified Name:     org.xwalk.core.extension.BindingObjectStore
 * JD-Core Version:    0.7.0.1
 */