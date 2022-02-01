package com.tencent.mqq.shared_file_accessor;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mqq.shared_file_accessor.test.AccessRecorder;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ContentProviderImpl
  extends ContentProvider
{
  private static final String LOG_TAG = "ContentProviderImpl";
  private static final String[] sMockColums = { "value" };
  
  private String getParam(Uri paramUri, String paramString)
  {
    try
    {
      paramUri = paramUri.getQueryParameter(paramString);
      return paramUri;
    }
    catch (UnsupportedOperationException|NullPointerException paramUri)
    {
      label8:
      break label8;
    }
    return null;
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    paramUri = getParam(paramUri, "file");
    if ("*".equals(paramString))
    {
      SharedPreferencesProxyManager.getInstance().getProxyInner(paramUri, 0, false).edit().clear();
      return 0;
    }
    SharedPreferencesProxyManager.getInstance().getProxyInner(paramUri, 0, false).edit().remove(paramString);
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return "N/A";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject1 = getParam(paramUri, "file");
    Object localObject2 = (Map.Entry)paramContentValues.valueSet().iterator().next();
    if (localObject2 == null) {
      return null;
    }
    paramContentValues = (String)((Map.Entry)localObject2).getKey();
    localObject2 = ((Map.Entry)localObject2).getValue();
    localObject1 = SharedPreferencesProxyManager.getInstance().getProxyInner((String)localObject1, 0, false).edit();
    if ((localObject2 instanceof Integer))
    {
      ((SharedPreferences.Editor)localObject1).putInt(paramContentValues, ((Integer)localObject2).intValue());
      return paramUri;
    }
    if ((localObject2 instanceof Long))
    {
      ((SharedPreferences.Editor)localObject1).putLong(paramContentValues, ((Long)localObject2).longValue());
      return paramUri;
    }
    if ((localObject2 instanceof Float))
    {
      ((SharedPreferences.Editor)localObject1).putFloat(paramContentValues, ((Float)localObject2).floatValue());
      return paramUri;
    }
    if ((localObject2 instanceof Boolean))
    {
      ((SharedPreferences.Editor)localObject1).putBoolean(paramContentValues, ((Boolean)localObject2).booleanValue());
      return paramUri;
    }
    if ((localObject2 instanceof String))
    {
      ((SharedPreferences.Editor)localObject1).putString(paramContentValues, (String)localObject2);
      return paramUri;
    }
    return null;
  }
  
  public boolean onCreate()
  {
    LogUtil.timeLogEnd("ContentProviderImpl's init", LogUtil.timeLogBegin());
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    String str = getParam(paramUri, "file");
    int k = paramArrayOfString1.length;
    int j = 0;
    for (int i = 0; i < k; i = i + 1 + 1) {
      if ("cmd".equals(paramArrayOfString1[i]))
      {
        paramUri = paramArrayOfString1[(i + 1)];
        break label62;
      }
    }
    paramUri = "0";
    label62:
    boolean bool = "5".equals(paramUri);
    Object localObject1 = null;
    Object localObject2 = null;
    if (bool)
    {
      ((SharedPreferencesProxy.EditorImpl)((SharedPreferencesProxy)SharedPreferencesProxyManager.getInstance().getProxyInner(str, 0, false)).edit()).commit(false);
      return null;
    }
    if ("101".equals(paramUri))
    {
      paramUri = null;
      paramString1 = paramUri;
      i = j;
      while (i < paramArrayOfString1.length)
      {
        if ("process".equals(paramArrayOfString1[i]))
        {
          j = i + 1;
          paramArrayOfString2 = paramArrayOfString1[j];
        }
        else
        {
          paramArrayOfString2 = paramUri;
          j = i;
          if ("log".equals(paramArrayOfString1[i]))
          {
            j = i + 1;
            paramString1 = paramArrayOfString1[j];
            paramArrayOfString2 = paramUri;
          }
        }
        i = j + 1;
        paramUri = paramArrayOfString2;
      }
      if ((!TextUtils.isEmpty(paramUri)) && (!TextUtils.isEmpty(paramString1))) {
        SharedPreferencesProxyManager.getInstance().onModifySp(str, paramUri, paramString1);
      }
      return null;
    }
    int n = paramArrayOfString1.length;
    paramUri = null;
    paramString1 = "NO_SUCH_KEY";
    j = 0;
    k = -1;
    while (j < n)
    {
      int m;
      if ("key".equals(paramArrayOfString1[j]))
      {
        j += 1;
        i = j;
        paramArrayOfString2 = paramString1;
        m = k;
        paramString2 = paramUri;
        if (j < n)
        {
          paramArrayOfString2 = paramArrayOfString1[j];
          i = j;
          m = k;
          paramString2 = paramUri;
        }
      }
      else if ("value_type".equals(paramArrayOfString1[j]))
      {
        j += 1;
        i = j;
        paramArrayOfString2 = paramString1;
        m = k;
        paramString2 = paramUri;
        if (j < n)
        {
          m = Integer.parseInt(paramArrayOfString1[j]);
          i = j;
          paramArrayOfString2 = paramString1;
          paramString2 = paramUri;
        }
      }
      else
      {
        i = j;
        paramArrayOfString2 = paramString1;
        m = k;
        paramString2 = paramUri;
        if ("default".equals(paramArrayOfString1[j]))
        {
          j += 1;
          i = j;
          paramArrayOfString2 = paramString1;
          m = k;
          paramString2 = paramUri;
          if (j < n)
          {
            paramString2 = paramArrayOfString1[j];
            m = k;
            paramArrayOfString2 = paramString1;
            i = j;
          }
        }
      }
      j = i + 1;
      paramString1 = paramArrayOfString2;
      k = m;
      paramUri = paramString2;
    }
    if (!"NO_SUCH_KEY".equals(paramString1))
    {
      if (k == -1) {
        return null;
      }
      paramArrayOfString2 = new MatrixCursor(sMockColums);
      paramArrayOfString1 = SharedPreferencesProxyManager.getInstance().getProxyInner(str, 0, false);
      switch (k)
      {
      default: 
        paramUri = localObject1;
        break;
      }
    }
    label790:
    label793:
    label799:
    for (;;)
    {
      try
      {
        paramArrayOfString1 = paramArrayOfString1.getStringSet(paramString1, null);
        paramUri = localObject1;
        if (paramArrayOfString1 != null)
        {
          paramUri = localObject1;
          if (!paramArrayOfString1.isEmpty())
          {
            paramUri = paramArrayOfString1;
            break label790;
            if (!paramArrayOfString1.getBoolean(paramString1, Boolean.parseBoolean(paramUri))) {
              break label793;
            }
            i = 1;
            paramUri = Integer.valueOf(i);
            continue;
            if (!"null".equals(paramUri)) {
              break label799;
            }
            paramUri = localObject2;
            paramUri = paramArrayOfString1.getString(paramString1, paramUri);
            continue;
            paramUri = Float.valueOf(paramArrayOfString1.getFloat(paramString1, Float.parseFloat(paramUri)));
            continue;
            paramUri = Long.valueOf(paramArrayOfString1.getLong(paramString1, Long.parseLong(paramUri)));
            continue;
            paramUri = Integer.valueOf(paramArrayOfString1.getInt(paramString1, Integer.parseInt(paramUri)));
            continue;
            paramUri = localObject1;
            if (paramArrayOfString1.contains(paramString1))
            {
              paramUri = Integer.valueOf(0);
              break label790;
            }
          }
        }
        if (paramUri != null) {
          if (k == 6)
          {
            paramUri = ((Set)paramUri).iterator();
            if (paramUri.hasNext())
            {
              paramArrayOfString2.addRow(new Object[] { (String)paramUri.next() });
              continue;
            }
          }
          else
          {
            paramArrayOfString2.addRow(new Object[] { paramUri });
          }
        }
        return paramArrayOfString2;
      }
      catch (Exception paramUri)
      {
        return paramArrayOfString2;
      }
      return null;
      continue;
      i = 0;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    paramUri = paramUri.getLastPathSegment();
    if (paramUri == null) {
      return -1;
    }
    if (paramUri.equals("log")) {
      AccessRecorder.getInstance().log(paramArrayOfString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.ContentProviderImpl
 * JD-Core Version:    0.7.0.1
 */