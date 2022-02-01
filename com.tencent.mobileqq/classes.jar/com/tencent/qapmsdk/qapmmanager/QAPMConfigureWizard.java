package com.tencent.qapmsdk.qapmmanager;

import android.app.Application;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/qapmmanager/QAPMConfigureWizard;", "", "()V", "Companion", "qapmmanager_release"}, k=1, mv={1, 1, 15})
public final class QAPMConfigureWizard
{
  public static final QAPMConfigureWizard.Companion Companion = new QAPMConfigureWizard.Companion(null);
  private static final String TAG = "QAPM_manager_QAPMConfigureWizard";
  
  @JvmStatic
  public static final void setAPMHost(@NotNull String paramString)
  {
    Companion.setAPMHost(paramString);
  }
  
  @JvmStatic
  public static final void setAppId(int paramInt)
  {
    Companion.setAppId(paramInt);
  }
  
  @JvmStatic
  public static final void setAppKey(@NotNull String paramString)
  {
    Companion.setAppKey(paramString);
  }
  
  @JvmStatic
  public static final void setApplication(@NotNull Application paramApplication)
  {
    Companion.setApplication(paramApplication);
  }
  
  @JvmStatic
  public static final void setAthenaHost(@NotNull String paramString)
  {
    Companion.setAthenaHost(paramString);
  }
  
  @JvmStatic
  public static final void setDeviceId(@NotNull String paramString)
  {
    Companion.setDeviceId(paramString);
  }
  
  @JvmStatic
  public static final void setLogLevel(int paramInt)
  {
    Companion.setLogLevel(paramInt);
  }
  
  @JvmStatic
  public static final boolean setUin(@NotNull String paramString)
  {
    return Companion.setUin(paramString);
  }
  
  @JvmStatic
  public static final void setUuid(@NotNull String paramString)
  {
    Companion.setUuid(paramString);
  }
  
  @JvmStatic
  public static final void setVersion(@NotNull String paramString)
  {
    Companion.setVersion(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.qapmmanager.QAPMConfigureWizard
 * JD-Core Version:    0.7.0.1
 */