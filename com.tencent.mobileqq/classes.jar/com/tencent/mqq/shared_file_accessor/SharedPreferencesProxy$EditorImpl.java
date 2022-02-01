package com.tencent.mqq.shared_file_accessor;

import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Looper;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

class SharedPreferencesProxy$EditorImpl
  implements SharedPreferences.Editor, Runnable
{
  protected final Map<String, Object> mModifiedCaches = new ConcurrentHashMap();
  
  SharedPreferencesProxy$EditorImpl(SharedPreferencesProxy paramSharedPreferencesProxy) {}
  
  private void monitor()
  {
    if (SharedPreferencesProxyManager.getInstance().isMonitored())
    {
      Object localObject1 = Utils.getMiniStackInfo();
      Object localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append(((Utils.StackInfo)localObject1).clazz);
      ((StringBuilder)localObject2).append('|');
      ((StringBuilder)localObject2).append(((Utils.StackInfo)localObject1).method);
      ((StringBuilder)localObject2).append('|');
      ((StringBuilder)localObject2).append(((Utils.StackInfo)localObject1).stack);
      localObject1 = ((StringBuilder)localObject2).toString();
      if (Utils.sIsSameProcessAsCP)
      {
        SharedPreferencesProxyManager.getInstance().onModifySp(SharedPreferencesProxy.access$400(this.this$0), Utils.sCurrentProcessName, localObject1);
        return;
      }
      if (SharedPreferencesProxy.access$500(this.this$0) == null)
      {
        localObject2 = this.this$0;
        SharedPreferencesProxy.access$502((SharedPreferencesProxy)localObject2, new Monitor(SharedPreferencesProxy.access$600((SharedPreferencesProxy)localObject2), SharedPreferencesProxy.access$400(this.this$0)));
      }
      SharedPreferencesProxy.access$500(this.this$0).log((String)localObject1);
    }
  }
  
  private void notifyListeners(String paramString)
  {
    synchronized (this.this$0)
    {
      if (SharedPreferencesProxy.access$200(this.this$0) != null)
      {
        Iterator localIterator = SharedPreferencesProxy.access$200(this.this$0).iterator();
        while (localIterator.hasNext()) {
          ((SharedPreferences.OnSharedPreferenceChangeListener)localIterator.next()).onSharedPreferenceChanged(this.this$0, paramString);
        }
      }
      return;
    }
    for (;;)
    {
      throw paramString;
    }
  }
  
  public void apply()
  {
    commit(true);
  }
  
  public SharedPreferences.Editor clear()
  {
    if (SharedPreferencesProxy.access$000(this.this$0) != null)
    {
      SharedPreferencesProxy.access$000(this.this$0).clear(null);
      return this;
    }
    this.mModifiedCaches.clear();
    SharedPreferencesProxy.access$100(this.this$0).clear();
    return this;
  }
  
  void commit(boolean paramBoolean)
  {
    if (SharedPreferencesProxy.access$000(this.this$0) != null)
    {
      SharedPreferencesProxy.access$000(this.this$0).commit();
      if ((SharedPreferencesProxy.access$300(this.this$0)) && (paramBoolean)) {
        monitor();
      }
    }
    else
    {
      if ((Looper.getMainLooper() == Looper.myLooper()) && (!SharedPreferencesProxyManager.sIsCrashing)) {
        PrefEditQueueWork.getInstance().queue(this);
      } else {
        SharedPreferencesProxy.access$100(this.this$0).commit();
      }
      if (paramBoolean) {
        monitor();
      }
    }
  }
  
  public boolean commit()
  {
    commit(true);
    return true;
  }
  
  public SharedPreferences.Editor putBoolean(String paramString, boolean paramBoolean)
  {
    if (SharedPreferencesProxy.access$000(this.this$0) != null)
    {
      SharedPreferencesProxy.access$000(this.this$0).write(paramString, Boolean.valueOf(paramBoolean), CommonConstants.VALUE_TYPE_BOOLEAN);
    }
    else
    {
      if (paramString != null) {
        this.mModifiedCaches.put(paramString, Boolean.valueOf(paramBoolean));
      }
      SharedPreferencesProxy.access$100(this.this$0).putBoolean(paramString, paramBoolean);
    }
    notifyListeners(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putFloat(String paramString, float paramFloat)
  {
    if (SharedPreferencesProxy.access$000(this.this$0) != null)
    {
      SharedPreferencesProxy.access$000(this.this$0).write(paramString, Float.valueOf(paramFloat), CommonConstants.VALUE_TYPE_FLOAT);
    }
    else
    {
      if (paramString != null) {
        this.mModifiedCaches.put(paramString, Float.valueOf(paramFloat));
      }
      SharedPreferencesProxy.access$100(this.this$0).putFloat(paramString, paramFloat);
    }
    notifyListeners(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putInt(String paramString, int paramInt)
  {
    if (SharedPreferencesProxy.access$000(this.this$0) != null)
    {
      SharedPreferencesProxy.access$000(this.this$0).write(paramString, Integer.valueOf(paramInt), CommonConstants.VALUE_TYPE_INT);
    }
    else
    {
      if (paramString != null) {
        this.mModifiedCaches.put(paramString, Integer.valueOf(paramInt));
      }
      SharedPreferencesProxy.access$100(this.this$0).putInt(paramString, paramInt);
    }
    notifyListeners(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putLong(String paramString, long paramLong)
  {
    if (SharedPreferencesProxy.access$000(this.this$0) != null)
    {
      SharedPreferencesProxy.access$000(this.this$0).write(paramString, Long.valueOf(paramLong), CommonConstants.VALUE_TYPE_LONG);
    }
    else
    {
      if (paramString != null) {
        this.mModifiedCaches.put(paramString, Long.valueOf(paramLong));
      }
      SharedPreferencesProxy.access$100(this.this$0).putLong(paramString, paramLong);
    }
    notifyListeners(paramString);
    return this;
  }
  
  public SharedPreferences.Editor putString(String paramString1, String paramString2)
  {
    if (SharedPreferencesProxy.access$000(this.this$0) != null)
    {
      SharedPreferencesProxy.access$000(this.this$0).write(paramString1, paramString2, CommonConstants.VALUE_TYPE_STRING);
    }
    else
    {
      if (paramString1 != null) {
        if (paramString2 == null) {
          this.mModifiedCaches.put(paramString1, this);
        } else {
          this.mModifiedCaches.put(paramString1, paramString2);
        }
      }
      SharedPreferencesProxy.access$100(this.this$0).putString(paramString1, paramString2);
    }
    notifyListeners(paramString1);
    return this;
  }
  
  public SharedPreferences.Editor putStringSet(String paramString, Set<String> paramSet)
  {
    if (SharedPreferencesProxy.access$000(this.this$0) != null)
    {
      SharedPreferencesProxy.access$000(this.this$0).write(paramString, paramSet, CommonConstants.VALUE_TYPE_STRSET);
    }
    else
    {
      if (paramString != null) {
        if (paramSet == null) {
          this.mModifiedCaches.put(paramString, this);
        } else {
          this.mModifiedCaches.put(paramString, new HashSet(paramSet));
        }
      }
      SharedPreferencesProxy.access$100(this.this$0).putStringSet(paramString, paramSet);
    }
    notifyListeners(paramString);
    return this;
  }
  
  public SharedPreferences.Editor remove(String paramString)
  {
    if (SharedPreferencesProxy.access$000(this.this$0) != null)
    {
      SharedPreferencesProxy.access$000(this.this$0).delete(paramString);
    }
    else
    {
      if (paramString != null) {
        this.mModifiedCaches.put(paramString, this);
      }
      SharedPreferencesProxy.access$100(this.this$0).remove(paramString);
    }
    notifyListeners(paramString);
    return this;
  }
  
  public void run()
  {
    SharedPreferencesProxy.access$100(this.this$0).commit();
    this.mModifiedCaches.clear();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.SharedPreferencesProxy.EditorImpl
 * JD-Core Version:    0.7.0.1
 */