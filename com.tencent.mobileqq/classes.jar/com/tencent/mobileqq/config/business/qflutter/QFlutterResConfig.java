package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.annotations.SerializedName;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "", "()V", "branchIdentify", "", "getBranchIdentify", "()Ljava/lang/String;", "setBranchIdentify", "(Ljava/lang/String;)V", "name", "getName", "setName", "preloads", "", "Lcom/tencent/mobileqq/config/business/qflutter/ExpandModuleKey;", "", "getPreloads", "()Ljava/util/Map;", "setPreloads", "(Ljava/util/Map;)V", "resDescriptionList", "Lcom/tencent/mobileqq/config/business/qflutter/ResDescription;", "getResDescriptionList", "()Ljava/util/List;", "setResDescriptionList", "(Ljava/util/List;)V", "taskId", "", "getTaskId", "()I", "setTaskId", "(I)V", "time", "", "getTime", "()J", "setTime", "(J)V", "version", "getVersion", "setVersion", "getFlutterResPackageName", "originResName", "getModulePreloadOption", "key", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QFlutterResConfig
{
  @JvmField
  @NotNull
  public static QFlutterResConfig a = new QFlutterResConfig();
  public static final QFlutterResConfig.Companion b = new QFlutterResConfig.Companion(null);
  @NotNull
  private static final Lazy j = LazyKt.lazy((Function0)QFlutterResConfig.Companion.gson.2.INSTANCE);
  @SerializedName("name")
  @NotNull
  private String c = "";
  @SerializedName("res_list")
  @NotNull
  private List<ResDescription> d = CollectionsKt.emptyList();
  @SerializedName("preloads")
  @NotNull
  private Map<ExpandModuleKey, ? extends List<String>> e = MapsKt.emptyMap();
  @SerializedName("time")
  private long f;
  @SerializedName("version")
  @NotNull
  private String g = "";
  @SerializedName("branch")
  @NotNull
  private String h = "";
  private int i;
  
  public final long a()
  {
    return this.f;
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "originResName");
    Object localObject2 = ((Iterable)this.d).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      localObject1 = ((Iterator)localObject2).next();
      if (Intrinsics.areEqual(((ResDescription)localObject1).a(), paramString)) {
        break label57;
      }
    }
    Object localObject1 = null;
    label57:
    localObject2 = (ResDescription)localObject1;
    localObject1 = paramString;
    if (localObject2 != null)
    {
      int k;
      if (((CharSequence)((ResDescription)localObject2).b()).length() == 0) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0) {
        return paramString;
      }
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramString);
      ((StringBuilder)localObject1).append("-");
      ((StringBuilder)localObject1).append(((ResDescription)localObject2).b());
      localObject1 = ((StringBuilder)localObject1).toString();
    }
    return localObject1;
  }
  
  @NotNull
  public final List<String> a(@NotNull ExpandModuleKey paramExpandModuleKey)
  {
    Intrinsics.checkParameterIsNotNull(paramExpandModuleKey, "key");
    paramExpandModuleKey = (List)this.e.get(paramExpandModuleKey);
    if (paramExpandModuleKey != null) {
      return paramExpandModuleKey;
    }
    return CollectionsKt.listOf(PreloadEngineOption.NEVER_PRELOAD.name());
  }
  
  public final void a(int paramInt)
  {
    this.i = paramInt;
  }
  
  @NotNull
  public final String b()
  {
    return this.h;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject2 = (Iterable)this.d;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      int k;
      if (((CharSequence)((ResDescription)localObject3).b()).length() > 0) {
        k = 1;
      } else {
        k = 0;
      }
      if (k != 0) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (List)localObject1;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("QFlutterResConfig(name='");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("', time=");
    ((StringBuilder)localObject2).append(this.f);
    ((StringBuilder)localObject2).append(", version='");
    ((StringBuilder)localObject2).append(this.g);
    ((StringBuilder)localObject2).append("', preloads=");
    ((StringBuilder)localObject2).append(this.e);
    ((StringBuilder)localObject2).append(", hotfixList=");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(", branchIdentify='");
    ((StringBuilder)localObject2).append(this.h);
    ((StringBuilder)localObject2).append("', taskId=");
    ((StringBuilder)localObject2).append(this.i);
    ((StringBuilder)localObject2).append(')');
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig
 * JD-Core Version:    0.7.0.1
 */