package com.tencent.sonic.sdk;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.text.TextUtils;
import java.io.File;
import java.io.InputStream;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

public abstract class SonicRuntime
{
  private static final String TAG = "SonicSdk_SonicRuntime";
  protected static volatile HandlerThread fileHandlerThread;
  protected final Context context;
  
  public SonicRuntime(Context paramContext)
  {
    if (paramContext != null)
    {
      this.context = paramContext;
      return;
    }
    throw new NullPointerException("SonicRuntime context con not be null!");
  }
  
  public abstract Object createWebResourceResponse(String paramString1, String paramString2, InputStream paramInputStream, Map<String, String> paramMap);
  
  public Context getContext()
  {
    return this.context;
  }
  
  public abstract String getCookie(String paramString);
  
  public abstract String getCurrentUserAccount();
  
  public Looper getFileThreadLooper()
  {
    if (fileHandlerThread == null)
    {
      fileHandlerThread = new HandlerThread("SonicSdk_FileThread");
      fileHandlerThread.start();
    }
    return fileHandlerThread.getLooper();
  }
  
  public String getHostDirectAddress(String paramString)
  {
    return null;
  }
  
  public Set<String> getQueryParameterNames(Uri paramUri)
  {
    if (paramUri == null) {
      return Collections.emptySet();
    }
    if (!paramUri.isOpaque())
    {
      paramUri = paramUri.getEncodedQuery();
      if (paramUri == null) {
        return Collections.emptySet();
      }
      LinkedHashSet localLinkedHashSet = new LinkedHashSet();
      int j = 0;
      int i;
      do
      {
        int k = paramUri.indexOf('&', j);
        i = k;
        if (k == -1) {
          i = paramUri.length();
        }
        int m = paramUri.indexOf('=', j);
        if (m <= i)
        {
          k = m;
          if (m != -1) {}
        }
        else
        {
          k = i;
        }
        localLinkedHashSet.add(Uri.decode(paramUri.substring(j, k)));
        i += 1;
        j = i;
      } while (i < paramUri.length());
      return Collections.unmodifiableSet(localLinkedHashSet);
    }
    paramUri = new UnsupportedOperationException("This isn't a hierarchical URI.");
    for (;;)
    {
      throw paramUri;
    }
  }
  
  public File getSonicCacheDir()
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(this.context.getFilesDir());
    ((StringBuilder)localObject).append("/Sonic/");
    localObject = ((StringBuilder)localObject).toString();
    File localFile = new File(((String)localObject).trim());
    if ((!localFile.exists()) && (!localFile.mkdir()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSonicCacheDir error:make dir(");
      localStringBuilder.append(localFile.getAbsolutePath());
      localStringBuilder.append(") fail!");
      log("SonicSdk_SonicRuntime", 6, localStringBuilder.toString());
      notifyError(null, (String)localObject, -1003);
    }
    return localFile;
  }
  
  public File getSonicResourceCacheDir()
  {
    File localFile = new File(Environment.getExternalStorageDirectory(), "/SonicResource/");
    if ((!localFile.exists()) && (!localFile.mkdir()))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("getSonicResourceCacheDir error:make dir(");
      localStringBuilder.append(localFile.getAbsolutePath());
      localStringBuilder.append(") fail!");
      log("SonicSdk_SonicRuntime", 6, localStringBuilder.toString());
      notifyError(null, localFile.getAbsolutePath(), -1003);
    }
    return localFile;
  }
  
  public SharedPreferences getSonicSharedPreferences()
  {
    return this.context.getSharedPreferences("sonic", 0);
  }
  
  public abstract String getUserAgent();
  
  public abstract boolean isNetworkValid();
  
  public abstract boolean isSonicUrl(String paramString);
  
  public abstract void log(String paramString1, int paramInt, String paramString2);
  
  public String makeSessionId(String paramString, boolean paramBoolean)
  {
    if (isSonicUrl(paramString))
    {
      StringBuilder localStringBuilder = new StringBuilder();
      try
      {
        Uri localUri = Uri.parse(paramString);
        localStringBuilder.append(localUri.getAuthority());
        localStringBuilder.append(localUri.getPath());
        Object localObject1;
        if (localUri.isHierarchical())
        {
          Object localObject2 = localUri.getQueryParameter("sonic_remain_params");
          localObject1 = new TreeSet();
          if (!TextUtils.isEmpty((CharSequence)localObject2)) {
            Collections.addAll((Collection)localObject1, ((String)localObject2).split(";"));
          }
          localObject2 = new TreeSet(getQueryParameterNames(localUri));
          if (!((TreeSet)localObject1).isEmpty()) {
            ((TreeSet)localObject2).remove("sonic_remain_params");
          }
          localObject2 = ((TreeSet)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            String str = (String)((Iterator)localObject2).next();
            if ((!TextUtils.isEmpty(str)) && ((str.startsWith("sonic_")) || (((TreeSet)localObject1).contains(str))))
            {
              localStringBuilder.append(str);
              localStringBuilder.append(localUri.getQueryParameter(str));
            }
          }
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("makeSessionId error:");
        ((StringBuilder)localObject1).append(localThrowable.getMessage());
        ((StringBuilder)localObject1).append(", url=");
        ((StringBuilder)localObject1).append(paramString);
        log("SonicSdk_SonicRuntime", 6, ((StringBuilder)localObject1).toString());
        localStringBuilder.setLength(0);
        localStringBuilder.append(paramString);
        if (paramBoolean)
        {
          paramString = new StringBuilder();
          paramString.append(getCurrentUserAccount());
          paramString.append("_");
          paramString.append(SonicUtils.getMD5(localStringBuilder.toString()));
          return paramString.toString();
        }
        return SonicUtils.getMD5(localStringBuilder.toString());
      }
    }
  }
  
  public abstract void notifyError(SonicSessionClient paramSonicSessionClient, String paramString, int paramInt);
  
  public void postTaskToMainThread(Runnable paramRunnable, long paramLong)
  {
    new Handler(Looper.getMainLooper()).postDelayed(paramRunnable, paramLong);
  }
  
  public void postTaskToSessionThread(Runnable paramRunnable)
  {
    SonicSessionThreadPool.postTask(paramRunnable);
  }
  
  public abstract void postTaskToThread(Runnable paramRunnable, long paramLong);
  
  public abstract boolean setCookie(String paramString, List<String> paramList);
  
  public boolean shouldLog(int paramInt)
  {
    return true;
  }
  
  public abstract void showToast(CharSequence paramCharSequence, int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicRuntime
 * JD-Core Version:    0.7.0.1
 */