package com.tencent.tkd.topicsdk.common;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import android.os.Build.VERSION;
import android.util.Log;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/common/NetworkUtils;", "", "()V", "TAG", "", "getNetworkInfo", "Landroid/net/NetworkInfo;", "context", "Landroid/content/Context;", "hasInternet", "", "isWifi", "topicsdk-common_release"}, k=1, mv={1, 1, 16})
public final class NetworkUtils
{
  public static final NetworkUtils a = new NetworkUtils();
  
  private final NetworkInfo a(Context paramContext)
  {
    try
    {
      paramContext = paramContext.getSystemService("connectivity");
      if (paramContext != null) {
        return ((ConnectivityManager)paramContext).getActiveNetworkInfo();
      }
      throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
    }
    catch (Exception paramContext)
    {
      Log.w("NetworkUtils", (Throwable)paramContext);
    }
    return null;
  }
  
  public final boolean a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    paramContext = a(paramContext);
    return (paramContext != null) && (paramContext.isConnected());
  }
  
  public final boolean b(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    Object localObject = paramContext.getSystemService("connectivity");
    if (localObject != null)
    {
      localObject = (ConnectivityManager)localObject;
      int i = Build.VERSION.SDK_INT;
      boolean bool2 = false;
      if (i >= 23)
      {
        paramContext = ((ConnectivityManager)localObject).getNetworkCapabilities(((ConnectivityManager)localObject).getActiveNetwork());
        bool1 = bool2;
        if (paramContext == null) {
          break label119;
        }
        bool1 = bool2;
        if (!paramContext.hasCapability(12)) {
          break label119;
        }
        bool1 = bool2;
        if (!paramContext.hasTransport(1)) {
          break label119;
        }
      }
      else
      {
        paramContext = a(paramContext);
        bool1 = bool2;
        if (paramContext == null) {
          break label119;
        }
        bool1 = bool2;
        if (!paramContext.isConnected()) {
          break label119;
        }
        bool1 = bool2;
        if (paramContext.getType() != 1) {
          break label119;
        }
      }
      boolean bool1 = true;
      label119:
      return bool1;
    }
    throw new TypeCastException("null cannot be cast to non-null type android.net.ConnectivityManager");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.common.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */