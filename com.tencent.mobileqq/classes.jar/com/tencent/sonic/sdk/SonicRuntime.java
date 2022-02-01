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
    if (paramContext == null) {
      throw new NullPointerException("SonicRuntime context con not be null!");
    }
    this.context = paramContext;
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
    if (paramUri.isOpaque()) {
      throw new UnsupportedOperationException("This isn't a hierarchical URI.");
    }
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
  
  public File getSonicCacheDir()
  {
    String str = this.context.getFilesDir() + "/Sonic/";
    File localFile = new File(str.trim());
    if ((!localFile.exists()) && (!localFile.mkdir()))
    {
      log("SonicSdk_SonicRuntime", 6, "getSonicCacheDir error:make dir(" + localFile.getAbsolutePath() + ") fail!");
      notifyError(null, str, -1003);
    }
    return localFile;
  }
  
  public File getSonicResourceCacheDir()
  {
    File localFile = new File(Environment.getExternalStorageDirectory(), "/SonicResource/");
    if ((!localFile.exists()) && (!localFile.mkdir()))
    {
      log("SonicSdk_SonicRuntime", 6, "getSonicResourceCacheDir error:make dir(" + localFile.getAbsolutePath() + ") fail!");
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
        localStringBuilder.append(localUri.getAuthority()).append(localUri.getPath());
        if (localUri.isHierarchical())
        {
          Object localObject = localUri.getQueryParameter("sonic_remain_params");
          TreeSet localTreeSet = new TreeSet();
          if (!TextUtils.isEmpty((CharSequence)localObject)) {
            Collections.addAll(localTreeSet, ((String)localObject).split(";"));
          }
          localObject = new TreeSet(getQueryParameterNames(localUri));
          if (!localTreeSet.isEmpty()) {
            ((TreeSet)localObject).remove("sonic_remain_params");
          }
          localObject = ((TreeSet)localObject).iterator();
          while (((Iterator)localObject).hasNext())
          {
            String str = (String)((Iterator)localObject).next();
            if ((!TextUtils.isEmpty(str)) && ((str.startsWith("sonic_")) || (localTreeSet.contains(str)))) {
              localStringBuilder.append(str).append(localUri.getQueryParameter(str));
            }
          }
        }
        return null;
      }
      catch (Throwable localThrowable)
      {
        log("SonicSdk_SonicRuntime", 6, "makeSessionId error:" + localThrowable.getMessage() + ", url=" + paramString);
        localStringBuilder.setLength(0);
        localStringBuilder.append(paramString);
        if (paramBoolean) {
          return getCurrentUserAccount() + "_" + SonicUtils.getMD5(localStringBuilder.toString());
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.sonic.sdk.SonicRuntime
 * JD-Core Version:    0.7.0.1
 */