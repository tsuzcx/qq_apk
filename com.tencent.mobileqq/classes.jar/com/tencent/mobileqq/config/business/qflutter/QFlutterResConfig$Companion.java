package com.tencent.mobileqq.config.business.qflutter;

import com.google.gson.Gson;
import com.tencent.biz.expand.utils.LogUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig$Companion;", "", "()V", "TAG", "", "currentResConfig", "Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "from", "items", "", "Lcom/tencent/mobileqq/config/QConfItem;", "([Lcom/tencent/mobileqq/config/QConfItem;)Lcom/tencent/mobileqq/config/business/qflutter/QFlutterResConfig;", "AQQLiteApp_release"}, k=1, mv={1, 1, 16})
public final class QFlutterResConfig$Companion
{
  @NotNull
  public final QFlutterResConfig a(@NotNull QConfItem[] paramArrayOfQConfItem)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfQConfItem, "items");
    Object localObject3 = new Gson();
    Object localObject4 = (Collection)new ArrayList(paramArrayOfQConfItem.length);
    int k = paramArrayOfQConfItem.length;
    int j = 0;
    int i = 0;
    for (;;)
    {
      if (j < k)
      {
        QConfItem localQConfItem = paramArrayOfQConfItem[j];
        Object localObject1 = LogUtils.a;
        if (QLog.isColorLevel()) {
          QLog.d("QFlutterResConfig", 2, '[' + i + "][" + localQConfItem.jdField_a_of_type_Int + "] Parse json: " + localQConfItem.jdField_a_of_type_JavaLangString);
        }
        try
        {
          localObject1 = ((Gson)localObject3).fromJson(localQConfItem.jdField_a_of_type_JavaLangString, QFlutterResConfig.class);
          ((QFlutterResConfig)localObject1).a(localQConfItem.jdField_a_of_type_Int);
          localObject1 = (QFlutterResConfig)localObject1;
          ((Collection)localObject4).add(localObject1);
          j += 1;
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            LogUtils localLogUtils = LogUtils.a;
            QLog.e("QFlutterResConfig", 1, '[' + i + "] Parse json: " + localQConfItem.jdField_a_of_type_JavaLangString + ", with errors", (Throwable)localException);
            localObject2 = null;
          }
        }
      }
    }
    Object localObject2 = (Iterable)CollectionsKt.filterNotNull((Iterable)localObject4);
    paramArrayOfQConfItem = (Collection)new ArrayList();
    localObject2 = ((Iterable)localObject2).iterator();
    label306:
    label346:
    label349:
    while (((Iterator)localObject2).hasNext())
    {
      localObject3 = ((Iterator)localObject2).next();
      localObject4 = (QFlutterResConfig)localObject3;
      if (((CharSequence)((QFlutterResConfig)localObject4).a()).length() == 0)
      {
        i = 1;
        if ((i == 0) && (!Intrinsics.areEqual(((QFlutterResConfig)localObject4).a(), "feature/_8.4.17_ExtendFriend"))) {
          break label346;
        }
      }
      for (i = 1;; i = 0)
      {
        if (i == 0) {
          break label349;
        }
        paramArrayOfQConfItem.add(localObject3);
        break;
        i = 0;
        break label306;
      }
    }
    paramArrayOfQConfItem = CollectionsKt.sortedWith((Iterable)paramArrayOfQConfItem, (Comparator)new QFlutterResConfig.Companion.from..inlined.thenByDescending.1((Comparator)new QFlutterResConfig.Companion.from..inlined.compareByDescending.1()));
    localObject2 = LogUtils.a;
    if (QLog.isColorLevel()) {
      QLog.d("QFlutterResConfig", 2, "configs = " + paramArrayOfQConfItem);
    }
    paramArrayOfQConfItem = (QFlutterResConfig)CollectionsKt.firstOrNull(paramArrayOfQConfItem);
    if (paramArrayOfQConfItem != null) {
      return paramArrayOfQConfItem;
    }
    return new QFlutterResConfig();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.qflutter.QFlutterResConfig.Companion
 * JD-Core Version:    0.7.0.1
 */