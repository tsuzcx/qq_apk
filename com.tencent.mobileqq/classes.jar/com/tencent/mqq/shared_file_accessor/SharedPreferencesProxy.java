package com.tencent.mqq.shared_file_accessor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class SharedPreferencesProxy
  implements SharedPreferences
{
  private static final String LOG_TAG = "SharedPreferencesProxy";
  private static String sPkgSpName;
  private WeakReference<Context> mContext = null;
  private SharedPreferencesProxy.EditorImpl mEditor = null;
  private String mFileName = null;
  private Set<SharedPreferences.OnSharedPreferenceChangeListener> mListeners = null;
  private Monitor mMonitor = null;
  private ContentProviderClient mProviderPref = null;
  private boolean mRequestPrivate = false;
  private SharedPreferences.Editor mSystemEditor = null;
  private SharedPreferences mSystemPref = null;
  
  public SharedPreferencesProxy(WeakReference<Context> paramWeakReference, String paramString, int paramInt, boolean paramBoolean)
  {
    this.mContext = paramWeakReference;
    boolean bool;
    if (paramInt != 4) {
      bool = true;
    } else {
      bool = false;
    }
    this.mRequestPrivate = bool;
    if (sPkgSpName == null)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(((Context)paramWeakReference.get()).getPackageName());
      localStringBuilder.append("_preferences");
      sPkgSpName = localStringBuilder.toString();
    }
    int i = paramInt;
    if (sPkgSpName.equals(paramString))
    {
      i = paramInt;
      if (paramInt != 4)
      {
        i = paramInt;
        if (paramBoolean) {
          i = 4;
        }
      }
    }
    if (((i & 0x4) == 4) && (!Utils.sIsSameProcessAsCP))
    {
      this.mProviderPref = new ContentProviderClient(paramWeakReference, paramString);
    }
    else
    {
      this.mSystemPref = Utils.getSystemSp((Context)paramWeakReference.get(), paramString, 0);
      this.mSystemEditor = this.mSystemPref.edit();
    }
    this.mFileName = paramString;
    this.mEditor = new SharedPreferencesProxy.EditorImpl(this);
  }
  
  public boolean contains(String paramString)
  {
    Object localObject = this.mProviderPref;
    if (localObject != null) {
      return ((Boolean)((ContentProviderClient)localObject).read(paramString, CommonConstants.VALUE_TYPE_ANY, Boolean.valueOf(false))).booleanValue();
    }
    if (paramString != null) {
      localObject = this.mEditor.mModifiedCaches.get(paramString);
    } else {
      localObject = null;
    }
    if (localObject != null) {
      return localObject.equals(this.mEditor) ^ true;
    }
    return this.mSystemPref.contains(paramString);
  }
  
  public SharedPreferences.Editor edit()
  {
    return this.mEditor;
  }
  
  public Map<String, ?> getAll()
  {
    Object localObject = this.mProviderPref;
    if (localObject != null) {
      return ((ContentProviderClient)localObject).readAll();
    }
    localObject = this.mSystemPref.getAll();
    if (localObject != null)
    {
      localObject = new HashMap((Map)localObject);
      ((Map)localObject).putAll(this.mEditor.mModifiedCaches);
    }
    else
    {
      localObject = new HashMap(this.mEditor.mModifiedCaches);
    }
    Iterator localIterator = this.mEditor.mModifiedCaches.entrySet().iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (this.mEditor.equals(localEntry.getValue())) {
        ((Map)localObject).remove(localEntry.getKey());
      }
    }
    return localObject;
  }
  
  public boolean getBoolean(String paramString, boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        boolean bool;
        if (this.mProviderPref != null)
        {
          bool = ((Boolean)this.mProviderPref.read(paramString, CommonConstants.VALUE_TYPE_BOOLEAN, Boolean.valueOf(paramBoolean))).booleanValue();
          paramBoolean = bool;
        }
        else
        {
          if (paramString == null) {
            break label127;
          }
          localObject = this.mEditor.mModifiedCaches.get(paramString);
          if (localObject != null)
          {
            if (localObject.equals(this.mEditor)) {
              return paramBoolean;
            }
            bool = ((Boolean)localObject).booleanValue();
            paramBoolean = bool;
          }
          else
          {
            bool = this.mSystemPref.getBoolean(paramString, paramBoolean);
            paramBoolean = bool;
          }
        }
        return paramBoolean;
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (!SharedPreferencesProxyManager.sIsDebugVersion) {
          return paramBoolean;
        }
        throw new RuntimeException(paramString);
      }
      label127:
      Object localObject = null;
    }
  }
  
  public float getFloat(String paramString, float paramFloat)
  {
    for (;;)
    {
      try
      {
        float f;
        if (this.mProviderPref != null)
        {
          f = ((Float)this.mProviderPref.read(paramString, CommonConstants.VALUE_TYPE_FLOAT, Float.valueOf(paramFloat))).floatValue();
          paramFloat = f;
        }
        else
        {
          if (paramString == null) {
            break label127;
          }
          localObject = this.mEditor.mModifiedCaches.get(paramString);
          if (localObject != null)
          {
            if (localObject.equals(this.mEditor)) {
              return paramFloat;
            }
            f = ((Float)localObject).floatValue();
            paramFloat = f;
          }
          else
          {
            f = this.mSystemPref.getFloat(paramString, paramFloat);
            paramFloat = f;
          }
        }
        return paramFloat;
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (!SharedPreferencesProxyManager.sIsDebugVersion) {
          return paramFloat;
        }
        throw new RuntimeException(paramString);
      }
      label127:
      Object localObject = null;
    }
  }
  
  public int getInt(String paramString, int paramInt)
  {
    for (;;)
    {
      try
      {
        int i;
        if (this.mProviderPref != null)
        {
          i = ((Integer)this.mProviderPref.read(paramString, CommonConstants.VALUE_TYPE_INT, Integer.valueOf(paramInt))).intValue();
          paramInt = i;
        }
        else
        {
          if (paramString == null) {
            break label127;
          }
          localObject = this.mEditor.mModifiedCaches.get(paramString);
          if (localObject != null)
          {
            if (localObject.equals(this.mEditor)) {
              return paramInt;
            }
            i = ((Integer)localObject).intValue();
            paramInt = i;
          }
          else
          {
            i = this.mSystemPref.getInt(paramString, paramInt);
            paramInt = i;
          }
        }
        return paramInt;
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (!SharedPreferencesProxyManager.sIsDebugVersion) {
          return paramInt;
        }
        throw new RuntimeException(paramString);
      }
      label127:
      Object localObject = null;
    }
  }
  
  public long getLong(String paramString, long paramLong)
  {
    for (;;)
    {
      try
      {
        long l;
        if (this.mProviderPref != null)
        {
          l = ((Long)this.mProviderPref.read(paramString, CommonConstants.VALUE_TYPE_LONG, Long.valueOf(paramLong))).longValue();
          paramLong = l;
        }
        else
        {
          if (paramString == null) {
            break label133;
          }
          localObject = this.mEditor.mModifiedCaches.get(paramString);
          if (localObject != null)
          {
            if (localObject.equals(this.mEditor)) {
              return paramLong;
            }
            l = ((Long)localObject).longValue();
            paramLong = l;
          }
          else
          {
            l = this.mSystemPref.getLong(paramString, paramLong);
            paramLong = l;
          }
        }
        return paramLong;
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (!SharedPreferencesProxyManager.sIsDebugVersion) {
          return paramLong;
        }
        throw new RuntimeException(paramString);
      }
      label133:
      Object localObject = null;
    }
  }
  
  public String getString(String paramString1, String paramString2)
  {
    for (;;)
    {
      try
      {
        if (this.mProviderPref != null)
        {
          paramString1 = (String)this.mProviderPref.read(paramString1, CommonConstants.VALUE_TYPE_STRING, paramString2);
        }
        else
        {
          if (paramString1 == null) {
            break label116;
          }
          localObject = this.mEditor.mModifiedCaches.get(paramString1);
          if (localObject != null)
          {
            if (localObject.equals(this.mEditor)) {
              return paramString2;
            }
            return (String)localObject;
          }
          paramString1 = this.mSystemPref.getString(paramString1, paramString2);
        }
      }
      catch (ClassCastException paramString1)
      {
        paramString1.printStackTrace();
        if (!SharedPreferencesProxyManager.sIsDebugVersion) {
          return paramString2;
        }
        paramString1 = new RuntimeException(paramString1);
      }
      for (;;)
      {
        throw paramString1;
      }
      return paramString1;
      label116:
      Object localObject = null;
    }
  }
  
  public Set<String> getStringSet(String paramString, Set<String> paramSet)
  {
    for (;;)
    {
      try
      {
        if (this.mProviderPref != null)
        {
          localObject = this.mProviderPref.read(paramString, CommonConstants.VALUE_TYPE_STRSET, null);
          paramString = localObject;
          if (localObject != null) {
            break label139;
          }
        }
        else
        {
          if (paramString == null) {
            break label144;
          }
          localObject = this.mEditor.mModifiedCaches.get(paramString);
          if (localObject != null)
          {
            if (!localObject.equals(this.mEditor))
            {
              paramString = (Set)localObject;
              paramSet = paramString;
            }
          }
          else {
            paramString = this.mSystemPref.getStringSet(paramString, paramSet);
          }
        }
      }
      catch (ClassCastException paramString)
      {
        paramString.printStackTrace();
        if (SharedPreferencesProxyManager.sIsDebugVersion) {}
      }
      for (;;)
      {
        if ((paramSet != null) && ((paramSet instanceof Set))) {
          return (Set)paramSet;
        }
        return null;
        paramString = new RuntimeException(paramString);
        for (;;)
        {
          throw paramString;
        }
        label139:
        paramSet = paramString;
      }
      label144:
      Object localObject = null;
    }
  }
  
  public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      if (this.mListeners == null) {
        this.mListeners = new HashSet(2);
      }
      this.mListeners.add(paramOnSharedPreferenceChangeListener);
      return;
    }
    finally {}
  }
  
  public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener paramOnSharedPreferenceChangeListener)
  {
    try
    {
      if (this.mListeners != null) {
        this.mListeners.remove(paramOnSharedPreferenceChangeListener);
      }
      return;
    }
    finally
    {
      paramOnSharedPreferenceChangeListener = finally;
      throw paramOnSharedPreferenceChangeListener;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.SharedPreferencesProxy
 * JD-Core Version:    0.7.0.1
 */