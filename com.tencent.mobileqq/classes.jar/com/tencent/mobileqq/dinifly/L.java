package com.tencent.mobileqq.dinifly;

import android.content.Context;
import android.util.Log;
import androidx.annotation.NonNull;
import androidx.annotation.RestrictTo;
import androidx.core.os.TraceCompat;
import com.tencent.mobileqq.dinifly.network.DefaultLottieNetworkFetcher;
import com.tencent.mobileqq.dinifly.network.LottieNetworkCacheProvider;
import com.tencent.mobileqq.dinifly.network.LottieNetworkFetcher;
import com.tencent.mobileqq.dinifly.network.NetworkCache;
import com.tencent.mobileqq.dinifly.network.NetworkFetcher;
import java.util.HashSet;
import java.util.Set;

@RestrictTo({androidx.annotation.RestrictTo.Scope.LIBRARY})
public class L
{
  public static boolean DBG = false;
  private static final int MAX_DEPTH = 20;
  public static final String TAG = "LOTTIE";
  private static LottieNetworkCacheProvider cacheProvider;
  private static int depthPastMaxDepth = 0;
  private static LottieNetworkFetcher fetcher;
  private static final Set<String> loggedMessages = new HashSet();
  private static volatile NetworkCache networkCache;
  private static volatile NetworkFetcher networkFetcher;
  private static String[] sections;
  private static long[] startTimeNs;
  private static int traceDepth;
  private static boolean traceEnabled = false;
  
  static
  {
    traceDepth = 0;
  }
  
  public static void beginSection(String paramString)
  {
    if (!traceEnabled) {
      return;
    }
    int i = traceDepth;
    if (i == 20)
    {
      depthPastMaxDepth += 1;
      return;
    }
    sections[i] = paramString;
    startTimeNs[i] = System.nanoTime();
    TraceCompat.beginSection(paramString);
    traceDepth += 1;
  }
  
  public static float endSection(String paramString)
  {
    int i = depthPastMaxDepth;
    if (i > 0)
    {
      depthPastMaxDepth = i - 1;
      return 0.0F;
    }
    if (!traceEnabled) {
      return 0.0F;
    }
    traceDepth -= 1;
    i = traceDepth;
    if (i != -1)
    {
      if (paramString.equals(sections[i]))
      {
        TraceCompat.endSection();
        return (float)(System.nanoTime() - startTimeNs[traceDepth]) / 1000000.0F;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("Unbalanced trace call ");
      localStringBuilder.append(paramString);
      localStringBuilder.append(". Expected ");
      localStringBuilder.append(sections[traceDepth]);
      localStringBuilder.append(".");
      throw new IllegalStateException(localStringBuilder.toString());
    }
    throw new IllegalStateException("Can't end trace section. There are none.");
  }
  
  @NonNull
  public static NetworkCache networkCache(@NonNull Context paramContext)
  {
    Object localObject = networkCache;
    if (localObject == null) {
      try
      {
        NetworkCache localNetworkCache = networkCache;
        localObject = localNetworkCache;
        if (localNetworkCache == null)
        {
          if (cacheProvider != null) {
            paramContext = cacheProvider;
          } else {
            paramContext = new L.1(paramContext);
          }
          localObject = new NetworkCache(paramContext);
          networkCache = (NetworkCache)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localObject;
  }
  
  @NonNull
  public static NetworkFetcher networkFetcher(@NonNull Context paramContext)
  {
    Object localObject = networkFetcher;
    if (localObject == null) {
      try
      {
        NetworkFetcher localNetworkFetcher = networkFetcher;
        localObject = localNetworkFetcher;
        if (localNetworkFetcher == null)
        {
          localObject = networkCache(paramContext);
          if (fetcher != null) {
            paramContext = fetcher;
          } else {
            paramContext = new DefaultLottieNetworkFetcher();
          }
          localObject = new NetworkFetcher((NetworkCache)localObject, paramContext);
          networkFetcher = (NetworkFetcher)localObject;
        }
        return localObject;
      }
      finally {}
    }
    return localObject;
  }
  
  public static void setCacheProvider(LottieNetworkCacheProvider paramLottieNetworkCacheProvider)
  {
    cacheProvider = paramLottieNetworkCacheProvider;
  }
  
  public static void setFetcher(LottieNetworkFetcher paramLottieNetworkFetcher)
  {
    fetcher = paramLottieNetworkFetcher;
  }
  
  public static void setTraceEnabled(boolean paramBoolean)
  {
    if (traceEnabled == paramBoolean) {
      return;
    }
    traceEnabled = paramBoolean;
    if (traceEnabled)
    {
      sections = new String[20];
      startTimeNs = new long[20];
    }
  }
  
  public static void warn(String paramString)
  {
    if (loggedMessages.contains(paramString)) {
      return;
    }
    Log.w("LOTTIE", paramString);
    loggedMessages.add(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dinifly.L
 * JD-Core Version:    0.7.0.1
 */