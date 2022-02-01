package com.tencent.qqlive.module.videoreport.storage.preference;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.support.v4.content.SharedPreferencesCompat.EditorCompat;
import android.text.TextUtils;
import android.util.Pair;
import com.tencent.qqlive.module.videoreport.Log;
import com.tencent.qqlive.module.videoreport.storage.annotation.AnnotationProcessor;
import com.tencent.qqlive.module.videoreport.storage.util.Coder;
import com.tencent.qqlive.module.videoreport.storage.util.Condition;
import com.tencent.qqlive.module.videoreport.storage.util.GsonObjectCoder;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

class SpService
  implements ISpOperation
{
  private static final String TAG = "SpService";
  private AnnotationProcessor mAnnotationProcessor;
  private Coder mCoder;
  private Context mContext;
  
  public SpService(Context paramContext)
  {
    this.mContext = paramContext;
    this.mCoder = new GsonObjectCoder();
    this.mAnnotationProcessor = AnnotationProcessor.getInstance();
  }
  
  private void clear()
  {
    SharedPreferences.Editor localEditor = initSp(this.mContext).edit();
    localEditor.clear();
    SharedPreferencesCompat.EditorCompat.getInstance().apply(localEditor);
  }
  
  private String getString(String paramString1, String paramString2)
  {
    return initSp(this.mContext).getString(paramString1, paramString2);
  }
  
  private SharedPreferences initSp(Context paramContext)
  {
    return paramContext.getSharedPreferences("datong_storage", 0);
  }
  
  private void removeString(String paramString)
  {
    SharedPreferences.Editor localEditor = initSp(this.mContext).edit();
    localEditor.remove(paramString);
    SharedPreferencesCompat.EditorCompat.getInstance().apply(localEditor);
  }
  
  private void saveString(String paramString1, String paramString2)
  {
    SharedPreferences.Editor localEditor = initSp(this.mContext).edit();
    localEditor.putString(paramString1, paramString2);
    SharedPreferencesCompat.EditorCompat.getInstance().apply(localEditor);
  }
  
  public void clearSp()
  {
    clear();
  }
  
  public <T> boolean containsObject(Class<T> paramClass, String paramString)
  {
    paramClass = getString(this.mAnnotationProcessor.getClassId(paramClass), null);
    if (TextUtils.isEmpty(paramClass)) {
      return false;
    }
    try
    {
      boolean bool = new JSONObject(paramClass).has(paramString);
      return bool;
    }
    catch (JSONException paramClass)
    {
      paramString = new StringBuilder();
      paramString.append("json parse failure, error: ");
      paramString.append(paramClass.getLocalizedMessage());
      Log.e("SpService", paramString.toString());
    }
    return false;
  }
  
  public <T> void deleteAllObjects(Class<T> paramClass)
  {
    removeString(this.mAnnotationProcessor.getClassId(paramClass));
  }
  
  public <T> void deleteObject(Class<T> paramClass, String paramString)
  {
    paramClass = this.mAnnotationProcessor.getClassId(paramClass);
    Object localObject = getString(paramClass, null);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      ((JSONObject)localObject).remove(paramString);
      saveString(paramClass, ((JSONObject)localObject).toString());
      return;
    }
    catch (JSONException paramClass)
    {
      paramString = new StringBuilder();
      paramString.append("json parse failure, error: ");
      paramString.append(paramClass.getLocalizedMessage());
      Log.e("SpService", paramString.toString());
    }
  }
  
  public <T> void deleteObjects(Class<T> paramClass, List<String> paramList)
  {
    paramClass = this.mAnnotationProcessor.getClassId(paramClass);
    Object localObject = getString(paramClass, null);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return;
    }
    try
    {
      localObject = new JSONObject((String)localObject);
      int j = paramList.size();
      int i = 0;
      while (i < j)
      {
        ((JSONObject)localObject).remove((String)paramList.get(i));
        i += 1;
      }
      saveString(paramClass, ((JSONObject)localObject).toString());
      return;
    }
    catch (JSONException paramClass)
    {
      paramList = new StringBuilder();
      paramList.append("json parse failure, error: ");
      paramList.append(paramClass.getLocalizedMessage());
      Log.e("SpService", paramList.toString());
    }
  }
  
  public <T> List<Pair<String, T>> getAllObjects(Class<T> paramClass)
  {
    localLinkedList = new LinkedList();
    Object localObject1 = getString(this.mAnnotationProcessor.getClassId(paramClass), null);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return localLinkedList;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      Iterator localIterator = ((JSONObject)localObject1).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject2 = ((JSONObject)localObject1).getString(str);
        localObject2 = this.mCoder.decode((String)localObject2, paramClass);
        if (localObject2 != null) {
          localLinkedList.add(new Pair(str, localObject2));
        }
      }
      return localLinkedList;
    }
    catch (JSONException paramClass)
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("json parse failure, error: ");
      ((StringBuilder)localObject1).append(paramClass.getLocalizedMessage());
      Log.e("SpService", ((StringBuilder)localObject1).toString());
    }
  }
  
  public <T> T getObject(Class<T> paramClass, String paramString)
  {
    Object localObject2 = this.mAnnotationProcessor.getClassId(paramClass);
    Object localObject1 = null;
    localObject2 = getString((String)localObject2, null);
    if (TextUtils.isEmpty((CharSequence)localObject2)) {
      return null;
    }
    try
    {
      paramString = new JSONObject((String)localObject2).getString(paramString);
    }
    catch (JSONException paramString)
    {
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("json parse failure, error: ");
      ((StringBuilder)localObject2).append(paramString.getLocalizedMessage());
      Log.e("SpService", ((StringBuilder)localObject2).toString());
      paramString = localObject1;
    }
    return this.mCoder.decode(paramString, paramClass);
  }
  
  public <T> List<Pair<String, T>> getObjects(Class<T> paramClass, Condition<T> paramCondition)
  {
    localLinkedList = new LinkedList();
    Object localObject1 = getString(this.mAnnotationProcessor.getClassId(paramClass), null);
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return localLinkedList;
    }
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      Iterator localIterator = ((JSONObject)localObject1).keys();
      while (localIterator.hasNext())
      {
        String str = (String)localIterator.next();
        Object localObject2 = ((JSONObject)localObject1).getString(str);
        localObject2 = this.mCoder.decode((String)localObject2, paramClass);
        if ((paramCondition == null) || (paramCondition.satisfy(localObject2))) {
          localLinkedList.add(new Pair(str, localObject2));
        }
      }
      return localLinkedList;
    }
    catch (JSONException paramClass)
    {
      paramCondition = new StringBuilder();
      paramCondition.append("json parse failure, error: ");
      paramCondition.append(paramClass.getLocalizedMessage());
      Log.e("SpService", paramCondition.toString());
    }
  }
  
  public <T> void insertObject(T paramT, String paramString)
  {
    String str = this.mAnnotationProcessor.getClassId(paramT.getClass());
    Object localObject = getString(str, null);
    if (localObject != null) {}
    try
    {
      localObject = new JSONObject((String)localObject);
      break label45;
      localObject = new JSONObject();
      label45:
      ((JSONObject)localObject).put(paramString, this.mCoder.encode(paramT));
      saveString(str, ((JSONObject)localObject).toString());
      return;
    }
    catch (JSONException paramT)
    {
      paramString = new StringBuilder();
      paramString.append("json parse failure, error: ");
      paramString.append(paramT.getLocalizedMessage());
      Log.e("SpService", paramString.toString());
    }
  }
  
  public <T> void insertObjects(List<T> paramList, List<String> paramList1)
  {
    if (paramList.isEmpty()) {
      return;
    }
    Object localObject1 = this.mAnnotationProcessor;
    int i = 0;
    String str = ((AnnotationProcessor)localObject1).getClassId(paramList.get(0).getClass());
    localObject1 = getString(str, null);
    if (localObject1 != null) {}
    try
    {
      localObject1 = new JSONObject((String)localObject1);
      break label72;
      localObject1 = new JSONObject();
      label72:
      int j = paramList.size();
      while (i < j)
      {
        Object localObject2 = paramList.get(i);
        ((JSONObject)localObject1).put((String)paramList1.get(i), this.mCoder.encode(localObject2));
        i += 1;
      }
      saveString(str, ((JSONObject)localObject1).toString());
      return;
    }
    catch (JSONException paramList)
    {
      paramList1 = new StringBuilder();
      paramList1.append("json parse failure, error: ");
      paramList1.append(paramList.getLocalizedMessage());
      Log.e("SpService", paramList1.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     com.tencent.qqlive.module.videoreport.storage.preference.SpService
 * JD-Core Version:    0.7.0.1
 */