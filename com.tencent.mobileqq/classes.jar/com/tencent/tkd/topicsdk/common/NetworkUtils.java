package com.tencent.tkd.topicsdk.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/NetworkUtils;", "", "()V", "TAG", "", "getNetworkInfo", "Landroid/net/NetworkInfo;", "context", "Landroid/content/Context;", "hasInternet", "", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class NetworkUtils
{
  public static final NetworkUtils a = new NetworkUtils();
  
  private final NetworkInfo a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSystemService("connectivity");
      if (paramContext == null) {
        throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
      }
    }
    catch (Exception paramContext)
    {
      Log.w("NetworkUtils", (Throwable)paramContext);
      return null;
    }
    paramContext = ((ConnectivityManager)paramContext).getActiveNetworkInfo();
    return paramContext;
  }
  
  public final boolean a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = a(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */