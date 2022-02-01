package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.Gson;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.mobileqq.qqexpand.utils.ILog;
import com.tencent.mobileqq.qqexpand.utils.LogUtils;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig$Companion;", "", "()V", "KEY_EXPAND_PLUGIN", "", "KEY_EXPAND_PLUGIN_PRE_INSTALL", "TAG", "currentResConfig", "Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "gson", "Lcom/google/gson/Gson;", "getGson", "()Lcom/google/gson/Gson;", "gson$delegate", "Lkotlin/Lazy;", "from", "items", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "json", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QFlutterResConfig$Companion
{
  private final QFlutterResConfig a(String paramString)
  {
    try
    {
      QFlutterResConfig localQFlutterResConfig = (QFlutterResConfig)((Companion)this).a().fromJson(paramString, QFlutterResConfig.class);
      return localQFlutterResConfig;
    }
    catch (Exception localException)
    {
      ILog localILog = LogUtils.a.a();
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("QFlutterResConfig Parse json error: ");
      localStringBuilder.append(paramString);
      localILog.a("QFlutterResConfig", 1, localStringBuilder.toString(), (Throwable)localException);
    }
    return null;
  }
  
  @NotNull
  public final Gson a()
  {
    Lazy localLazy = QFlutterResConfig.a();
    Companion localCompanion = QFlutterResConfig.a;
    return (Gson)localLazy.getValue();
  }
  
  @NotNull
  public final QFlutterResConfig a(@NotNull QConfItem[] paramArrayOfQConfItem)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfQConfItem, "items");
    Object localObject2 = (Collection)new ArrayList(paramArrayOfQConfItem.length);
    int k = paramArrayOfQConfItem.length;
    int j = 0;
    int i = 0;
    Object localObject3;
    while (j < k)
    {
      localObject3 = paramArrayOfQConfItem[j];
      localObject1 = LogUtils.a;
      if (QLog.isColorLevel())
      {
        localObject1 = ((LogUtils)localObject1).a();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append('[');
        localStringBuilder.append(i);
        localStringBuilder.append("][");
        localStringBuilder.append(((QConfItem)localObject3).jdField_a_of_type_Int);
        localStringBuilder.append("] Parse json: ");
        localStringBuilder.append(((QConfItem)localObject3).jdField_a_of_type_JavaLangString);
        ((ILog)localObject1).a("QFlutterResConfig", 2, localStringBuilder.toString());
      }
      localObject1 = QFlutterResConfig.a.a(((QConfItem)localObject3).jdField_a_of_type_JavaLangString);
      if (localObject1 != null) {
        ((QFlutterResConfig)localObject1).a(((QConfItem)localObject3).jdField_a_of_type_Int);
      } else {
        localObject1 = null;
      }
      ((Collection)localObject2).add(localObject1);
      j += 1;
      i += 1;
    }
    Object localObject1 = (Iterable)CollectionsKt.filterNotNull((Iterable)localObject2);
    paramArrayOfQConfItem = (Collection)new ArrayList();
    localObject1 = ((Iterable)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = ((Iterator)localObject1).next();
      localObject3 = (QFlutterResConfig)localObject2;
      i = ((CharSequence)((QFlutterResConfig)localObject3).a()).length();
      k = 1;
      if (i == 0) {
        i = 1;
      } else {
        i = 0;
      }
      j = k;
      if (i == 0) {
        if (Intrinsics.areEqual(((QFlutterResConfig)localObject3).a(), "feature/_8.4.17_ExtendFriend")) {
          j = k;
        } else {
          j = 0;
        }
      }
      if (j != 0) {
        paramArrayOfQConfItem.add(localObject2);
      }
    }
    paramArrayOfQConfItem = CollectionsKt.sortedWith((Iterable)paramArrayOfQConfItem, (Comparator)new QFlutterResConfig.Companion.from..inlined.thenByDescending.1((Comparator)new QFlutterResConfig.Companion.from..inlined.compareByDescending.1()));
    localObject1 = LogUtils.a;
    if (QLog.isColorLevel())
    {
      localObject1 = ((LogUtils)localObject1).a();
      localObject2 = new StringBuilder();
      ((StringBuilder)localObject2).append("configs = ");
      ((StringBuilder)localObject2).append(paramArrayOfQConfItem);
      ((ILog)localObject1).a("QFlutterResConfig", 2, ((StringBuilder)localObject2).toString());
    }
    paramArrayOfQConfItem = (QFlutterResConfig)CollectionsKt.firstOrNull(paramArrayOfQConfItem);
    if (paramArrayOfQConfItem != null) {
      return paramArrayOfQConfItem;
    }
    return new QFlutterResConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig.Companion
 * JD-Core Version:    0.7.0.1
 */