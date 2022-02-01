package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.annotations.SerializedName;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "", "()V", "branchIdentify", "", "getBranchIdentify", "()Ljava/lang/String;", "setBranchIdentify", "(Ljava/lang/String;)V", "name", "getName", "setName", "resDescriptionList", "", "Lcom/tencent/mobileqq/config/business/qflutter/ResDescription;", "getResDescriptionList", "()Ljava/util/List;", "setResDescriptionList", "(Ljava/util/List;)V", "taskId", "", "getTaskId", "()I", "setTaskId", "(I)V", "time", "", "getTime", "()J", "setTime", "(J)V", "version", "getVersion", "setVersion", "getFlutterResPackageName", "originResName", "isResCanPreload", "", "toString", "Companion", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QFlutterResConfig
{
  public static final QFlutterResConfig.Companion a;
  @JvmField
  @NotNull
  public static QFlutterResConfig a;
  private int jdField_a_of_type_Int;
  @SerializedName("time")
  private long jdField_a_of_type_Long;
  @SerializedName("name")
  @NotNull
  private String jdField_a_of_type_JavaLangString = "";
  @SerializedName("res_list")
  @NotNull
  private List<ResDescription> jdField_a_of_type_JavaUtilList = CollectionsKt.emptyList();
  @SerializedName("version")
  @NotNull
  private String b = "";
  @SerializedName("branch")
  @NotNull
  private String c = "";
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqConfigBusinessQflutterQFlutterResConfig$Companion = new QFlutterResConfig.Companion(null);
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
    Iterator localIterator = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
    Object localObject;
    for (;;)
    {
      if (localIterator.hasNext())
      {
        localObject = localIterator.next();
        if (Intrinsics.areEqual(((ResDescription)localObject).a(), paramString))
        {
          localObject = (ResDescription)localObject;
          if (localObject != null) {
            if (((CharSequence)((ResDescription)localObject).b()).length() != 0) {
              break label89;
            }
          }
        }
      }
    }
    label89:
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label94;
      }
      return paramString;
      localObject = null;
      break;
    }
    label94:
    return paramString + "-" + ((ResDescription)localObject).b();
  }
  
  public final void a(int paramInt)
  {
    this.jdField_a_of_type_Int = paramInt;
  }
  
  public final boolean a(@NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramString, "originResName");
    Iterator localIterator = ((Iterable)this.jdField_a_of_type_JavaUtilList).iterator();
    Object localObject;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localObject = localIterator.next();
    } while (!Intrinsics.areEqual(((ResDescription)localObject).a(), paramString));
    for (paramString = localObject;; paramString = null)
    {
      paramString = (ResDescription)paramString;
      if (paramString == null) {
        break;
      }
      return paramString.a();
    }
    return false;
  }
  
  @NotNull
  public String toString()
  {
    return "QFlutterResConfig(name='" + this.jdField_a_of_type_JavaLangString + "', resDescriptionList=" + this.jdField_a_of_type_JavaUtilList + ", time=" + this.jdField_a_of_type_Long + ", version='" + this.b + "', branchIdentify='" + this.c + "', taskId=" + this.jdField_a_of_type_Int + ')';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig
 * JD-Core Version:    0.7.0.1
 */