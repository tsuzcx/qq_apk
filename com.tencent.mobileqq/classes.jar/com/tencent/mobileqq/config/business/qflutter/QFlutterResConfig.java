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
  public static final QFlutterResConfig.Companion a;
  @JvmField
  @NotNull
  public static QFlutterResConfig a;
  @NotNull
  private static final Lazy jdField_a_of_type_KotlinLazy;
  private int jdField_a_of_type_Int;
  @SerializedName("time")
  private long jdField_a_of_type_Long;
  @SerializedName("name")
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  @SerializedName("res_list")
  @NotNull
  private List<ResDescription> jdField_a_of_type_JavaUtilList = CollectionsKt.emptyList();
  @SerializedName("preloads")
  @NotNull
  private Map<ExpandModuleKey, ? extends List<String>> jdField_a_of_type_JavaUtilMap = MapsKt.emptyMap();
  @SerializedName("version")
  @NotNull
  private String b = "";
  @SerializedName("branch")
  @NotNull
  private String c = "";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqConfigBusinessQflutterQFlutterResConfig$Companion = new QFlutterResConfig.Companion(null);
    jdField_a_of_type_KotlinLazy = LazyKt.lazy((Function0)QFlutterResConfig.Companion.gson.2.INSTANCE);
    jdField_a_of_type_ComTencentMobileqqConfigBusinessQflutterQFlutterResConfig = new QFlutterResConfig();
  }
  
  public final long a()
  {
    return this.jdField_a_of_type_Long;
  }
  
  @NotNull
  public final String a()
  {
    return this.c;
  }
  
  @NotNull
  public final String a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "originResName");
    Object localObject2 = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
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
      int i;
      if (((CharSequence)((ResDescription)localObject2).b()).length() == 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
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
    paramExpandModuleKey = (List)this.jdField_a_of_type_JavaUtilMap.get(paramExpandModuleKey);
    if (paramExpandModuleKey != null) {
      return paramExpandModuleKey;
    }
    return CollectionsKt.listOf(PreloadEngineOption.NEVER_PRELOAD.name());
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  @NotNull
  public String toString()
  {
    Object localObject2 = (Iterable)this.jdField_a_of_type_JavaUtilList;
    Object localObject1 = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    while (((Iterator)localObject2).hasNext())
    {
      Object localObject3 = ((Iterator)localObject2).next();
      int i;
      if (((CharSequence)((ResDescription)localObject3).b()).length() > 0) {
        i = 1;
      } else {
        i = 0;
      }
      if (i != 0) {
        ((Collection)localObject1).add(localObject3);
      }
    }
    localObject1 = (List)localObject1;
    localObject2 = new StringBuilder();
    ((StringBuilder)localObject2).append("QFlutterResConfig(name='");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaLangString);
    ((StringBuilder)localObject2).append("', time=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Long);
    ((StringBuilder)localObject2).append(", version='");
    ((StringBuilder)localObject2).append(this.b);
    ((StringBuilder)localObject2).append("', preloads=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_JavaUtilMap);
    ((StringBuilder)localObject2).append(", hotfixList=");
    ((StringBuilder)localObject2).append(localObject1);
    ((StringBuilder)localObject2).append(", branchIdentify='");
    ((StringBuilder)localObject2).append(this.c);
    ((StringBuilder)localObject2).append("', taskId=");
    ((StringBuilder)localObject2).append(this.jdField_a_of_type_Int);
    ((StringBuilder)localObject2).append(')');
    return ((StringBuilder)localObject2).toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig
 * JD-Core Version:    0.7.0.1
 */