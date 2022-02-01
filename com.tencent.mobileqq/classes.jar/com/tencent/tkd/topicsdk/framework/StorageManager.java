package com.tencent.tkd.topicsdk.framework;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.util.Base64;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/tkd/topicsdk/framework/StorageManager;", "", "()V", "SP_NAME", "", "mContext", "Landroid/content/Context;", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "contains", "", "key", "getBoolean", "defaultValue", "getBytes", "", "getInt", "", "getString", "init", "", "context", "saveBoolean", "value", "saveBytes", "values", "saveInt", "saveString", "topicsdk-framework_release"}, k=1, mv={1, 1, 16})
@SuppressLint({"StaticFieldLeak"})
public final class StorageManager
{
  @NotNull
  public static Context a;
  public static final StorageManager b = new StorageManager();
  
  public final void a(@NotNull Context paramContext)
  {
    Intrinsics.checkParameterIsNotNull(paramContext, "context");
    a = paramContext;
  }
  
  public final void a(@NotNull String paramString, int paramInt)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Context localContext = a;
    if (localContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    localContext.getSharedPreferences("com_tencent_tkd_topicsdk_sp", 0).edit().putInt(paramString, paramInt).apply();
  }
  
  public final void a(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "value");
    Context localContext = a;
    if (localContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    localContext.getSharedPreferences("com_tencent_tkd_topicsdk_sp", 0).edit().putString(paramString1, paramString2).apply();
  }
  
  public final void a(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Context localContext = a;
    if (localContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    localContext.getSharedPreferences("com_tencent_tkd_topicsdk_sp", 0).edit().putBoolean(paramString, paramBoolean).apply();
  }
  
  public final void a(@NotNull String paramString, @Nullable byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    if (paramArrayOfByte == null)
    {
      a(paramString, "");
      return;
    }
    paramArrayOfByte = Base64.encodeToString(paramArrayOfByte, 0);
    Intrinsics.checkExpressionValueIsNotNull(paramArrayOfByte, "Base64.encodeToString(values, Base64.DEFAULT)");
    a(paramString, paramArrayOfByte);
  }
  
  @Nullable
  public final byte[] a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    return Base64.decode(b(paramString, ""), 0);
  }
  
  @Nullable
  public final String b(@NotNull String paramString1, @NotNull String paramString2)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "key");
    Intrinsics.checkParameterIsNotNull(paramString2, "defaultValue");
    Context localContext = a;
    if (localContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    return localContext.getSharedPreferences("com_tencent_tkd_topicsdk_sp", 0).getString(paramString1, paramString2);
  }
  
  public final boolean b(@NotNull String paramString, boolean paramBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "key");
    Context localContext = a;
    if (localContext == null) {
      Intrinsics.throwUninitializedPropertyAccessException("mContext");
    }
    return localContext.getSharedPreferences("com_tencent_tkd_topicsdk_sp", 0).getBoolean(paramString, paramBoolean);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.tkd.topicsdk.framework.StorageManager
 * JD-Core Version:    0.7.0.1
 */