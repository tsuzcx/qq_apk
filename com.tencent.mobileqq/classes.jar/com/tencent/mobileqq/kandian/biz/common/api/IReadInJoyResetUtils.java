package com.tencent.mobileqq.kandian.biz.common.api;

import com.tencent.mobileqq.qroute.QRouteApi;
import com.tencent.mobileqq.qroute.annotation.QAPI;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@QAPI(process={"all"})
@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/biz/common/api/IReadInJoyResetUtils;", "Lcom/tencent/mobileqq/qroute/QRouteApi;", "clearReadInJoyDatabase", "", "clearReadInJoyLocalFiles", "clearReadInJoySharedPreferences", "getLocalFilesPathForDebug", "", "getLocalResetVersion", "", "resetKandianRelatedManageConfigVersions", "resetLocalResetConfigVersionForDebug", "Companion", "kandian-api_release"}, k=1, mv={1, 1, 16})
public abstract interface IReadInJoyResetUtils
  extends QRouteApi
{
  public static final IReadInJoyResetUtils.Companion Companion = IReadInJoyResetUtils.Companion.a;
  @NotNull
  public static final String SP_KEY_READINJOY_LOCAL_RESET_VERSION = "readinjoy_local_reset_config_version";
  @NotNull
  public static final String SP_KEY_READINJOY_REMOTE_RESET_VERSION = "readinjoy_remote_reset_config_version";
  
  public abstract void clearReadInJoyDatabase();
  
  public abstract void clearReadInJoyLocalFiles();
  
  public abstract void clearReadInJoySharedPreferences();
  
  @Nullable
  public abstract String getLocalFilesPathForDebug();
  
  public abstract int getLocalResetVersion();
  
  public abstract void resetKandianRelatedManageConfigVersions();
  
  public abstract void resetLocalResetConfigVersionForDebug();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.biz.common.api.IReadInJoyResetUtils
 * JD-Core Version:    0.7.0.1
 */