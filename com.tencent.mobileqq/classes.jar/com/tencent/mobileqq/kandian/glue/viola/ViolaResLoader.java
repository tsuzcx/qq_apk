package com.tencent.mobileqq.kandian.glue.viola;

import android.net.Uri;
import android.text.TextUtils;
import com.tencent.biz.common.offline.OfflineEnvHelper;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/kandian/glue/viola/ViolaResLoader;", "", "()V", "getResPath", "", "bid", "path", "preDownload", "", "tryGetResPath", "url", "Companion", "kandian_feature_impl_release"}, k=1, mv={1, 1, 16})
public final class ViolaResLoader
{
  public static final ViolaResLoader.Companion a = new ViolaResLoader.Companion(null);
  @NotNull
  private static final Lazy b = LazyKt.lazy(LazyThreadSafetyMode.SYNCHRONIZED, (Function0)ViolaResLoader.Companion.instance.2.INSTANCE);
  
  private final String a(String paramString1, String paramString2)
  {
    Object localObject = OfflineEnvHelper.b(paramString1);
    if (TextUtils.isEmpty((CharSequence)localObject)) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append((String)localObject);
    localStringBuilder.append(paramString1);
    paramString1 = localStringBuilder.toString();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramString1);
    ((StringBuilder)localObject).append('/');
    ((StringBuilder)localObject).append(paramString2);
    return ((StringBuilder)localObject).toString();
  }
  
  @Nullable
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "url");
    paramString = Uri.parse(paramString).getQueryParameter("v_local_path");
    if (paramString != null) {
      return a("4737", paramString);
    }
    return "";
  }
  
  public final void a()
  {
    ViolaAccessHelper.a("4737", null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.glue.viola.ViolaResLoader
 * JD-Core Version:    0.7.0.1
 */