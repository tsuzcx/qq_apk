package com.tencent.videocut.utils;

import android.net.Uri;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/videocut/utils/NetworkUtils;", "", "()V", "APN_COLUMN_NAME", "", "APN_NAME_WIFI", "APN_URI", "Landroid/net/Uri;", "kotlin.jvm.PlatformType", "HTTP_URL", "NETWORK_TYPE_2G", "", "NETWORK_TYPE_3G", "NETWORK_TYPE_4G", "NETWORK_TYPE_NONE", "NETWORK_TYPE_UNKNOWN", "NETWORK_TYPE_UNKNOWN_MOBILE", "NETWORK_TYPE_WIFI", "PROPERTY_DNS_PRIMARY", "PROPERTY_DNS_SECONDARY", "TAG", "getActiveNetworkInfo", "Landroid/net/NetworkInfo;", "context", "Landroid/content/Context;", "getActiveNetworkType", "getNetworkType", "info", "isHttpUrl", "", "url", "isMobileConnected", "isNetworkConnected", "isWifiConnected", "lib_utils_release"}, k=1, mv={1, 4, 2})
public final class NetworkUtils
{
  @NotNull
  public static final NetworkUtils a = new NetworkUtils();
  private static final Uri b = Uri.parse("content://telephony/carriers/preferapn");
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.videocut.utils.NetworkUtils
 * JD-Core Version:    0.7.0.1
 */