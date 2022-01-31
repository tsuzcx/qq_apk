package com.tencent.mqq.shared_file_accessor;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.net.Uri;
import com.tencent.mqq.shared_file_accessor.a.a;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class ContentProviderImpl
  extends ContentProvider
{
  private static final String[] a = { "value" };
  
  private static String a(Uri paramUri, String paramString)
  {
    try
    {
      paramUri = paramUri.getQueryParameter(paramString);
      return paramUri;
    }
    catch (UnsupportedOperationException paramUri)
    {
      return null;
    }
    catch (NullPointerException paramUri)
    {
      label9:
      break label9;
    }
  }
  
  public int delete(Uri paramUri, String paramString, String[] paramArrayOfString)
  {
    paramUri = a(paramUri, "file");
    if ("*".equals(paramString))
    {
      SharedPreferencesProxyManager.getInstance().getProxy(paramUri, 0).edit().clear().commit();
      return 0;
    }
    SharedPreferencesProxyManager.getInstance().getProxy(paramUri, 0).edit().remove(paramString).commit();
    return 0;
  }
  
  public String getType(Uri paramUri)
  {
    return "N/A";
  }
  
  public Uri insert(Uri paramUri, ContentValues paramContentValues)
  {
    Object localObject1 = a(paramUri, "file");
    Object localObject2 = (Map.Entry)paramContentValues.valueSet().iterator().next();
    if (localObject2 == null) {
      return null;
    }
    paramContentValues = (String)((Map.Entry)localObject2).getKey();
    localObject2 = ((Map.Entry)localObject2).getValue();
    localObject1 = SharedPreferencesProxyManager.getInstance().getProxy((String)localObject1, 0).edit();
    if ((localObject2 instanceof Integer))
    {
      ((SharedPreferences.Editor)localObject1).putInt(paramContentValues, ((Integer)localObject2).intValue()).commit();
      return paramUri;
    }
    if ((localObject2 instanceof Long))
    {
      ((SharedPreferences.Editor)localObject1).putLong(paramContentValues, ((Long)localObject2).longValue()).commit();
      return paramUri;
    }
    if ((localObject2 instanceof Float))
    {
      ((SharedPreferences.Editor)localObject1).putFloat(paramContentValues, ((Float)localObject2).floatValue()).commit();
      return paramUri;
    }
    if ((localObject2 instanceof Boolean))
    {
      ((SharedPreferences.Editor)localObject1).putBoolean(paramContentValues, ((Boolean)localObject2).booleanValue()).commit();
      return paramUri;
    }
    if ((localObject2 instanceof String))
    {
      ((SharedPreferences.Editor)localObject1).putString(paramContentValues, (String)localObject2).commit();
      return paramUri;
    }
    return null;
  }
  
  public boolean onCreate()
  {
    getContext();
    j localj = LogUtil.timeLogBegin();
    SharedPreferencesProxyManager.getInstance().init(getContext());
    LogUtil.timeLogEnd("ContentProviderImpl's init", localj);
    return true;
  }
  
  public Cursor query(Uri paramUri, String[] paramArrayOfString1, String paramString1, String[] paramArrayOfString2, String paramString2)
  {
    String str = a(paramUri, "file");
    paramString1 = "NO_SUCH_KEY";
    int k = -1;
    paramUri = null;
    int j = 0;
    int n = paramArrayOfString1.length;
    if (j < n)
    {
      int m;
      if ("key".equals(paramArrayOfString1[j]))
      {
        j += 1;
        i = j;
        paramArrayOfString2 = paramUri;
        m = k;
        paramString2 = paramString1;
        if (j < n)
        {
          paramString2 = paramArrayOfString1[j];
          m = k;
          paramArrayOfString2 = paramUri;
          i = j;
        }
      }
      for (;;)
      {
        j = i + 1;
        paramUri = paramArrayOfString2;
        k = m;
        paramString1 = paramString2;
        break;
        if ("value_type".equals(paramArrayOfString1[j]))
        {
          j += 1;
          i = j;
          paramArrayOfString2 = paramUri;
          m = k;
          paramString2 = paramString1;
          if (j < n)
          {
            m = Integer.parseInt(paramArrayOfString1[j]);
            i = j;
            paramArrayOfString2 = paramUri;
            paramString2 = paramString1;
          }
        }
        else
        {
          i = j;
          paramArrayOfString2 = paramUri;
          m = k;
          paramString2 = paramString1;
          if ("default".equals(paramArrayOfString1[j]))
          {
            j += 1;
            i = j;
            paramArrayOfString2 = paramUri;
            m = k;
            paramString2 = paramString1;
            if (j < n)
            {
              paramArrayOfString2 = paramArrayOfString1[j];
              i = j;
              m = k;
              paramString2 = paramString1;
            }
          }
        }
      }
    }
    if (("NO_SUCH_KEY".equals(paramString1)) || (k == -1)) {
      return null;
    }
    paramArrayOfString2 = new MatrixCursor(a);
    paramArrayOfString1 = null;
    paramString2 = SharedPreferencesProxyManager.getInstance().getProxy(str, 0);
    switch (k)
    {
    default: 
      paramUri = paramArrayOfString1;
    case 1: 
    case 2: 
    case 5: 
      while (paramUri != null)
      {
        try
        {
          paramArrayOfString2.addRow(new Object[] { paramUri });
        }
        catch (Exception paramUri) {}
        paramUri = Integer.valueOf(paramString2.getInt(paramString1, Integer.parseInt(paramUri)));
        continue;
        paramUri = Long.valueOf(paramString2.getLong(paramString1, Long.parseLong(paramUri)));
        continue;
        if (!paramString2.getBoolean(paramString1, Boolean.parseBoolean(paramUri))) {
          break label480;
        }
      }
    }
    label480:
    for (int i = 1;; i = 0)
    {
      paramUri = Integer.valueOf(i);
      break;
      paramUri = Float.valueOf(paramString2.getFloat(paramString1, Float.parseFloat(paramUri)));
      break;
      paramArrayOfString1 = paramUri;
      if ("null".equals(paramUri)) {
        paramArrayOfString1 = null;
      }
      paramUri = paramString2.getString(paramString1, paramArrayOfString1);
      break;
      if (paramString2.contains(paramString1))
      {
        paramUri = Integer.valueOf(0);
        break;
      }
      paramUri = null;
      break;
      return paramArrayOfString2;
    }
  }
  
  public int update(Uri paramUri, ContentValues paramContentValues, String paramString, String[] paramArrayOfString)
  {
    paramUri = paramUri.getLastPathSegment();
    if (paramUri == null) {
      return -1;
    }
    if (paramUri.equals("log")) {
      a.a().a(paramArrayOfString);
    }
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mqq.shared_file_accessor.ContentProviderImpl
 * JD-Core Version:    0.7.0.1
 */