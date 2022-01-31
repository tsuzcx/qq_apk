package com.tencent.weiyun.transmission;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.text.TextUtils;
import android.util.SparseArray;
import android.util.SparseIntArray;
import com.tencent.weiyun.transmission.utils.TsLog;
import com.tencent.weiyun.utils.NetworkUtils;
import com.tencent.weiyun.utils.Singleton;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

public final class WeiyunTransmissionStatus
{
  private static final SparseIntArray DEFAULT_VALUE;
  private static final SparseArray<String> KEY_MAP_4_GLOBAL = new SparseArray();
  private static final SparseArray<String> KEY_MAP_4_USER;
  private static final String SP_NAME = "com.tencent.weiyun.pref.transmission_status";
  private static final String TAG = "WeiyunTransmissionStatus";
  public static final int TYPE_BACKGROUND_MODE = 6;
  public static final int TYPE_LOGIN_STATUS = 4;
  public static final int TYPE_NETWORK_STATUS = 5;
  public static final int TYPE_SERVER_IP = 1;
  public static final int TYPE_TRAN_ONLY_WIFI = 3;
  public static final int TYPE_UPLOAD_SERVER_IP = 2;
  public static final int VALUE_INVALID = -1;
  public static final int VALUE_NO = 1;
  public static final int VALUE_SERVER_IP_DEV = 2;
  public static final int VALUE_SERVER_IP_EXP = 4;
  public static final int VALUE_SERVER_IP_RELEASE = 1;
  public static final int VALUE_SERVER_IP_TEST = 3;
  public static final int VALUE_UPLOAD_SERVER_IP_RELEASE = 0;
  public static final int VALUE_UPLOAD_SERVER_IP_TEST = 5;
  public static final int VALUE_YES = 0;
  private static Singleton<WeiyunTransmissionStatus, Void> sInstance = new WeiyunTransmissionStatus.1();
  private final SparseArray<HashSet<WeiyunTransmissionStatus.StatusChangeListener>> mListeners = new SparseArray();
  private final SparseIntArray mValues = new SparseIntArray();
  
  static
  {
    KEY_MAP_4_GLOBAL.put(1, "key_server_ip");
    KEY_MAP_4_GLOBAL.put(2, "key_upload_server_ip");
    KEY_MAP_4_USER = new SparseArray();
    KEY_MAP_4_USER.put(3, "key_tran_only_wifi");
    DEFAULT_VALUE = new SparseIntArray();
    DEFAULT_VALUE.put(1, 1);
    DEFAULT_VALUE.put(2, 0);
    DEFAULT_VALUE.put(3, 1);
    DEFAULT_VALUE.put(4, 1);
    DEFAULT_VALUE.put(5, -1);
    DEFAULT_VALUE.put(6, 1);
  }
  
  public static WeiyunTransmissionStatus getInstance()
  {
    return (WeiyunTransmissionStatus)sInstance.get(null);
  }
  
  private static int getInt4All(String paramString, int paramInt)
  {
    return WeiyunTransmissionGlobal.getInstance().getHostInterface().getSharedPreferences("com.tencent.weiyun.pref.transmission_status", 4).getInt(paramString, paramInt);
  }
  
  private static int getInt4Single(String paramString1, String paramString2, int paramInt)
  {
    return WeiyunTransmissionGlobal.getInstance().getHostInterface().getSharedPreferences("com.tencent.weiyun.pref.transmission_status", 4).getInt(paramString2 + paramString1, paramInt);
  }
  
  private int getValue(int paramInt)
  {
    synchronized (this.mValues)
    {
      paramInt = this.mValues.get(paramInt, DEFAULT_VALUE.get(paramInt));
      return paramInt;
    }
  }
  
  private void initUserStatus(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    SparseIntArray localSparseIntArray = this.mValues;
    int i = 0;
    try
    {
      while (i < KEY_MAP_4_USER.size())
      {
        int j = KEY_MAP_4_USER.keyAt(i);
        int k = getInt4Single(paramString, (String)KEY_MAP_4_USER.valueAt(i), DEFAULT_VALUE.get(j));
        this.mValues.put(j, k);
        i += 1;
      }
      return;
    }
    finally {}
  }
  
  private boolean isValueValid(int paramInt1, int paramInt2)
  {
    boolean bool2 = false;
    boolean bool3 = false;
    boolean bool1 = false;
    switch (paramInt1)
    {
    case 5: 
    default: 
    case 1: 
      do
      {
        return true;
      } while ((paramInt2 >= 1) && (paramInt2 <= 4));
      return false;
    case 2: 
      if ((paramInt2 == 0) || (paramInt2 == 5)) {
        bool1 = true;
      }
      return bool1;
    case 4: 
      if (paramInt2 != 0)
      {
        bool1 = bool2;
        if (paramInt2 != 1) {}
      }
      else
      {
        bool1 = true;
      }
      return bool1;
    }
    if (paramInt2 != 0)
    {
      bool1 = bool3;
      if (paramInt2 != 1) {}
    }
    else
    {
      bool1 = true;
    }
    return bool1;
  }
  
  private void notifyObservers(int paramInt1, int paramInt2, int paramInt3)
  {
    ArrayList localArrayList = new ArrayList();
    synchronized (this.mListeners)
    {
      HashSet localHashSet = (HashSet)this.mListeners.get(paramInt1);
      if (localHashSet != null) {
        localArrayList.addAll(localHashSet);
      }
      ??? = localArrayList.iterator();
      if (((Iterator)???).hasNext()) {
        ((WeiyunTransmissionStatus.StatusChangeListener)((Iterator)???).next()).onStatusChanged(paramInt1, paramInt2, paramInt3);
      }
    }
  }
  
  private static void saveInt4All(String paramString, int paramInt)
  {
    WeiyunTransmissionGlobal.getInstance().getHostInterface().getSharedPreferences("com.tencent.weiyun.pref.transmission_status", 4).edit().putInt(paramString, paramInt).commit();
  }
  
  private static void saveInt4Single(String paramString1, String paramString2, int paramInt)
  {
    WeiyunTransmissionGlobal.getInstance().getHostInterface().getSharedPreferences("com.tencent.weiyun.pref.transmission_status", 4).edit().putInt(paramString2 + paramString1, paramInt).commit();
  }
  
  private boolean setValue(int paramInt1, int paramInt2, boolean paramBoolean1, boolean paramBoolean2, String paramString)
  {
    boolean bool2 = false;
    boolean bool1 = bool2;
    if (isValueValid(paramInt1, paramInt2)) {}
    for (;;)
    {
      synchronized (this.mValues)
      {
        int i = this.mValues.get(paramInt1, -1);
        if (i != paramInt2) {
          this.mValues.put(paramInt1, paramInt2);
        }
        if (i != paramInt2)
        {
          notifyObservers(paramInt1, i, paramInt2);
          if (paramBoolean1)
          {
            if (!paramBoolean2) {
              break label117;
            }
            paramString = (String)KEY_MAP_4_GLOBAL.get(paramInt1);
            if (!TextUtils.isEmpty(paramString)) {
              saveInt4All(paramString, paramInt2);
            }
          }
        }
        bool1 = true;
        return bool1;
      }
      label117:
      bool1 = bool2;
      if (!TextUtils.isEmpty(paramString))
      {
        ??? = (String)KEY_MAP_4_USER.get(paramInt1);
        if (!TextUtils.isEmpty((CharSequence)???)) {
          saveInt4Single(paramString, (String)???, paramInt2);
        }
      }
    }
  }
  
  public void addListener(int paramInt, WeiyunTransmissionStatus.StatusChangeListener paramStatusChangeListener)
  {
    if ((paramStatusChangeListener != null) && (paramInt > 0)) {
      synchronized (this.mListeners)
      {
        HashSet localHashSet2 = (HashSet)this.mListeners.get(paramInt);
        HashSet localHashSet1 = localHashSet2;
        if (localHashSet2 == null)
        {
          localHashSet1 = new HashSet();
          this.mListeners.put(paramInt, localHashSet1);
        }
        localHashSet1.add(paramStatusChangeListener);
        return;
      }
    }
  }
  
  public int getNetworkStatus()
  {
    return getValue(5);
  }
  
  public int getServerIp()
  {
    return getValue(1);
  }
  
  public int getUploadServerIp()
  {
    return getValue(2);
  }
  
  void initGlobalStatus(Context paramContext)
  {
    int j = NetworkUtils.getNetworkType(paramContext);
    paramContext = this.mValues;
    int i = 0;
    try
    {
      while (i < KEY_MAP_4_GLOBAL.size())
      {
        int k = KEY_MAP_4_GLOBAL.keyAt(i);
        int m = getInt4All((String)KEY_MAP_4_GLOBAL.valueAt(i), DEFAULT_VALUE.get(k));
        this.mValues.put(k, m);
        i += 1;
      }
      this.mValues.put(5, j);
      return;
    }
    finally {}
  }
  
  public boolean isBackgroundMode()
  {
    return getValue(6) == 0;
  }
  
  public boolean isLogin()
  {
    return getValue(4) == 0;
  }
  
  public boolean isTranOnlyWifi()
  {
    return getValue(3) == 0;
  }
  
  public void onReceiveNetChanged(boolean paramBoolean)
  {
    TsLog.i("WeiyunTransmissionStatus", "onReceiveNetChanged: isNetEffective=" + paramBoolean);
    setValue(5, NetworkUtils.getNetworkType(WeiyunTransmissionGlobal.getInstance().getContext()), false, false, null);
  }
  
  public void removeListener(int paramInt, WeiyunTransmissionStatus.StatusChangeListener paramStatusChangeListener)
  {
    if ((paramStatusChangeListener != null) && (paramInt > 0)) {
      synchronized (this.mListeners)
      {
        HashSet localHashSet = (HashSet)this.mListeners.get(paramInt);
        if (localHashSet != null) {
          localHashSet.remove(paramStatusChangeListener);
        }
        return;
      }
    }
  }
  
  public boolean setBackgroundMode(boolean paramBoolean)
  {
    if (paramBoolean) {}
    for (int i = 0;; i = 1) {
      return setValue(6, i, false, false, null);
    }
  }
  
  public boolean setLoginStatus(int paramInt, String paramString)
  {
    if (paramInt == 0) {
      initUserStatus(paramString);
    }
    for (;;)
    {
      return setValue(4, paramInt, false, false, null);
      paramString = this.mValues;
      int i = 0;
      try
      {
        while (i < KEY_MAP_4_USER.size())
        {
          int j = KEY_MAP_4_USER.keyAt(i);
          this.mValues.delete(j);
          i += 1;
        }
      }
      finally {}
    }
  }
  
  public boolean setServerIp(int paramInt, boolean paramBoolean)
  {
    return setValue(1, paramInt, paramBoolean, true, null);
  }
  
  public boolean setTranOnlyWifi(int paramInt, boolean paramBoolean, String paramString)
  {
    return setValue(3, paramInt, paramBoolean, false, paramString);
  }
  
  public boolean setUploadServerIp(int paramInt, boolean paramBoolean)
  {
    return setValue(2, paramInt, paramBoolean, true, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.weiyun.transmission.WeiyunTransmissionStatus
 * JD-Core Version:    0.7.0.1
 */