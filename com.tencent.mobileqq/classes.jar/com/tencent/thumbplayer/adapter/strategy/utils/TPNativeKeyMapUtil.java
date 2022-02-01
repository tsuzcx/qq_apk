package com.tencent.thumbplayer.adapter.strategy.utils;

import android.text.TextUtils;
import android.util.SparseArray;
import com.tencent.thumbplayer.adapter.player.thumbplayer.TPThumbPlayerUtils.OptionIdMapping;
import com.tencent.thumbplayer.api.TPCommonEnum.TPOptionalId;
import com.tencent.thumbplayer.api.TPOptionalID;
import com.tencent.thumbplayer.tplayer.TPOptionalIDInternal;
import com.tencent.thumbplayer.utils.TPLogUtil;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashSet;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class TPNativeKeyMapUtil
{
  private static final String REVERSE_MAP_NAME_SUFFIX = ".reverseMap";
  private static final String TAG = "TPNativeKeyMapUtil";
  private static final AtomicBoolean sHasOptionalIdMapInit = new AtomicBoolean(false);
  private static final Map<Class<?>, AtomicBoolean> sHasThisAnnotationInitMap;
  private static final Map<String, Map<Number, Number>> sNameToMap = new ConcurrentHashMap();
  private static final SparseArray<String> sOptionalIdKeyToNameMap;
  private static final SparseArray<TPThumbPlayerUtils.OptionIdMapping> sToNativeOptionalIdMap;
  
  static
  {
    sHasThisAnnotationInitMap = new ConcurrentHashMap();
    sToNativeOptionalIdMap = new SparseArray();
    sOptionalIdKeyToNameMap = new SparseArray();
  }
  
  private static <T extends Annotation> void buildBiDirectionMapForAnnotation(Class<T> paramClass)
  {
    Object localObject1 = new StringBuilder();
    ((StringBuilder)localObject1).append("buildBiDirectionMapForAnnotation, clazz=");
    ((StringBuilder)localObject1).append(paramClass);
    TPLogUtil.i("TPNativeKeyMapUtil", ((StringBuilder)localObject1).toString());
    synchronized (sHasThisAnnotationInitMap)
    {
      Object localObject2 = (AtomicBoolean)sHasThisAnnotationInitMap.get(paramClass);
      localObject1 = localObject2;
      if (localObject2 == null)
      {
        localObject1 = new AtomicBoolean(false);
        sHasThisAnnotationInitMap.put(paramClass, localObject1);
      }
      try
      {
        if (((AtomicBoolean)localObject1).get())
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append("className=");
          ((StringBuilder)localObject2).append(paramClass.getSimpleName());
          ((StringBuilder)localObject2).append(" already init");
          TPLogUtil.i("TPNativeKeyMapUtil", ((StringBuilder)localObject2).toString());
          return;
        }
        searchClassToFillMap(paramClass);
        ((AtomicBoolean)localObject1).set(true);
        return;
      }
      finally {}
    }
  }
  
  private static void buildNativeInitConfigMap()
  {
    try
    {
      Class localClass = Class.forName(TPOptionalID.class.getName());
      Field[] arrayOfField = localClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        if (localField.getType().toString().equals("int"))
        {
          TPNativeKeyMap.MapInitConfig localMapInitConfig = (TPNativeKeyMap.MapInitConfig)localField.getAnnotation(TPNativeKeyMap.MapInitConfig.class);
          if (localMapInitConfig != null)
          {
            int k = localField.getInt(localClass);
            sOptionalIdKeyToNameMap.put(k, localMapInitConfig.keyName());
            if (localMapInitConfig.value() == -1)
            {
              sToNativeOptionalIdMap.put(k, new TPThumbPlayerUtils.OptionIdMapping());
            }
            else
            {
              localField.setAccessible(true);
              sToNativeOptionalIdMap.put(k, new TPThumbPlayerUtils.OptionIdMapping(localMapInitConfig.type(), localMapInitConfig.value()));
            }
          }
        }
        i += 1;
      }
      return;
    }
    catch (IllegalAccessException localIllegalAccessException)
    {
      TPLogUtil.e("TPNativeKeyMapUtil", localIllegalAccessException);
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
    }
  }
  
  private static void buildNativeOptionalIdToMapInternal(Class<?> paramClass)
  {
    try
    {
      Field[] arrayOfField = paramClass.getDeclaredFields();
      int j = arrayOfField.length;
      int i = 0;
      while (i < j)
      {
        Field localField = arrayOfField[i];
        if (localField.getType().toString().equals("int"))
        {
          TPNativeKeyMap.MapOptionalId localMapOptionalId = (TPNativeKeyMap.MapOptionalId)localField.getAnnotation(TPNativeKeyMap.MapOptionalId.class);
          if (localMapOptionalId != null)
          {
            int k = localField.getInt(paramClass);
            sOptionalIdKeyToNameMap.put(k, localMapOptionalId.keyName());
            if (localMapOptionalId.value() == -1)
            {
              sToNativeOptionalIdMap.put(k, new TPThumbPlayerUtils.OptionIdMapping());
            }
            else
            {
              localField.setAccessible(true);
              sToNativeOptionalIdMap.put(k, new TPThumbPlayerUtils.OptionIdMapping(localMapOptionalId.type(), localMapOptionalId.value()));
            }
          }
        }
        i += 1;
      }
      return;
    }
    catch (IllegalAccessException paramClass)
    {
      TPLogUtil.e("TPNativeKeyMapUtil", paramClass);
    }
  }
  
  private static void buildOptionalIdMap()
  {
    synchronized (sHasOptionalIdMapInit)
    {
      if (sToNativeOptionalIdMap.size() != 0) {
        return;
      }
      if (!sHasOptionalIdMapInit.get())
      {
        buildNativeInitConfigMap();
        buildPublicToNativeOptionalIdMap();
        buildPrivateToNativeOptionalIdMap();
        sHasOptionalIdMapInit.set(true);
        return;
      }
      throw new IllegalStateException("构建Map错误，请查看【--keep class com.tencent.thumbplayer.api.** { *; }】是否加入反混淆");
    }
  }
  
  private static void buildPrivateToNativeOptionalIdMap()
  {
    try
    {
      buildNativeOptionalIdToMapInternal(Class.forName(TPOptionalIDInternal.class.getName()));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
    }
  }
  
  private static void buildPublicToNativeOptionalIdMap()
  {
    try
    {
      buildNativeOptionalIdToMapInternal(Class.forName(TPOptionalID.class.getName()));
      return;
    }
    catch (ClassNotFoundException localClassNotFoundException)
    {
      TPLogUtil.e("TPNativeKeyMapUtil", localClassNotFoundException);
    }
  }
  
  private static <T extends Annotation> void checkFillMapValidity(Class<T> paramClass, Map<Number, Number> paramMap1, Map<Number, Number> paramMap2, Class<?> paramClass1, Number paramNumber1, Number paramNumber2)
  {
    if (!paramMap1.containsKey(paramNumber2))
    {
      if (!paramMap2.containsKey(paramNumber1)) {
        return;
      }
      paramMap1 = new StringBuilder();
      paramMap1.append(paramClass1.getName());
      paramMap1.append(" 配置了重复的注解值，注解=");
      paramMap1.append(paramClass.getName());
      paramMap1.append(" 成员变量值=");
      paramMap1.append(paramNumber2);
      paramMap1.append(" 请查找一下@");
      paramMap1.append(paramClass.getName());
      paramMap1.append("(这个值)在哪里重复了");
      throw new IllegalStateException(paramMap1.toString());
    }
    paramMap1 = new StringBuilder();
    paramMap1.append(paramClass1.getName());
    paramMap1.append(" 配置了重复的成员变量，注解=");
    paramMap1.append(paramClass.getName());
    paramMap1.append(" 成员变量值=");
    paramMap1.append(paramNumber2);
    paramMap1.append(" 请查找一下使用这个注解@");
    paramMap1.append(paramClass.getName());
    paramMap1.append("的哪两个成员变量值相等");
    throw new IllegalStateException(paramMap1.toString());
  }
  
  public static TPThumbPlayerUtils.OptionIdMapping convertToNativeOptionalId(@TPCommonEnum.TPOptionalId int paramInt)
  {
    if (sToNativeOptionalIdMap.size() == 0) {
      buildOptionalIdMap();
    }
    return (TPThumbPlayerUtils.OptionIdMapping)sToNativeOptionalIdMap.get(paramInt, new TPThumbPlayerUtils.OptionIdMapping());
  }
  
  public static <T extends Annotation> Set<Map.Entry<Number, Number>> getEntrySetOfMap(Class<T> paramClass)
  {
    return new HashSet(getMapForAnnotation(paramClass).entrySet());
  }
  
  private static <T extends Annotation> Map<Number, Number> getMapForAnnotation(Class<T> paramClass)
  {
    String str = paramClass.getCanonicalName();
    Map localMap = (Map)sNameToMap.get(str);
    if (localMap != null)
    {
      localObject = localMap;
      if (localMap.size() != 0) {}
    }
    else
    {
      buildBiDirectionMapForAnnotation(paramClass);
      localObject = (Map)sNameToMap.get(str);
    }
    if ((TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class) != null)
    {
      if ((localObject != null) && (((Map)localObject).size() != 0)) {
        return localObject;
      }
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append(paramClass.getSimpleName());
      ((StringBuilder)localObject).append(" is null after buildBiDirectionMap");
      throw new IllegalStateException(((StringBuilder)localObject).toString());
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramClass.getSimpleName());
    ((StringBuilder)localObject).append("has not SearchConfig annotation");
    throw new IllegalArgumentException(((StringBuilder)localObject).toString());
  }
  
  public static String getOptionalIdName(int paramInt)
  {
    if (!sHasOptionalIdMapInit.get()) {
      buildOptionalIdMap();
    }
    return (String)sOptionalIdKeyToNameMap.get(paramInt, "");
  }
  
  public static void init()
  {
    long l1 = System.currentTimeMillis();
    Object localObject = TPNativeKeyMap.class.getDeclaredClasses();
    TPLogUtil.i("TPNativeKeyMapUtil", "init BiDirectionMap for tp&native value");
    int j = localObject.length;
    int i = 0;
    while (i < j)
    {
      Class localClass = localObject[i];
      if ((localClass.isAnnotation()) && (Modifier.isPublic(localClass.getModifiers())) && ((TPNativeKeyMap.SearchConfig)localClass.getAnnotation(TPNativeKeyMap.SearchConfig.class) != null)) {
        buildBiDirectionMapForAnnotation(localClass);
      }
      i += 1;
    }
    long l2 = System.currentTimeMillis();
    localObject = new StringBuilder();
    ((StringBuilder)localObject).append("init cost time=");
    ((StringBuilder)localObject).append(l2 - l1);
    TPLogUtil.i("TPNativeKeyMapUtil", ((StringBuilder)localObject).toString());
  }
  
  private static <T extends Annotation> void searchClassToFillMap(Class<T> paramClass)
  {
    Object localObject1 = paramClass.getCanonicalName();
    Object localObject2 = (Map)sNameToMap.get(localObject1);
    Object localObject3 = new StringBuilder();
    ((StringBuilder)localObject3).append((String)localObject1);
    ((StringBuilder)localObject3).append(".reverseMap");
    Object localObject4 = ((StringBuilder)localObject3).toString();
    localObject3 = (Map)sNameToMap.get(localObject4);
    if ((localObject2 != null) && (localObject3 != null))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append(paramClass);
      ((StringBuilder)localObject1).append(" toNativeMap.size=");
      ((StringBuilder)localObject1).append(((Map)localObject2).size());
      ((StringBuilder)localObject1).append(" toTPMap.size=");
      ((StringBuilder)localObject1).append(((Map)localObject3).size());
      TPLogUtil.e("TPNativeKeyMapUtil", ((StringBuilder)localObject1).toString());
    }
    else
    {
      localObject2 = new ConcurrentHashMap();
      sNameToMap.put(localObject1, localObject2);
      localObject3 = new ConcurrentHashMap();
      sNameToMap.put(localObject4, localObject3);
    }
    for (;;)
    {
      int i;
      try
      {
        TPNativeKeyMap.SearchConfig localSearchConfig = (TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class);
        if (localSearchConfig != null)
        {
          Class localClass = localSearchConfig.searchClass();
          Field[] arrayOfField = localClass.getDeclaredFields();
          int j = arrayOfField.length;
          i = 0;
          if (i < j)
          {
            localObject4 = arrayOfField[i];
            localObject1 = "";
            if (localSearchConfig.valueClass() == Integer.TYPE) {
              localObject1 = "int";
            } else if (localSearchConfig.valueClass() == Long.TYPE) {
              localObject1 = "long";
            }
            boolean bool = TextUtils.isEmpty((CharSequence)localObject1);
            if (!bool)
            {
              if (!((Field)localObject4).getType().toString().equals(localObject1)) {
                break label664;
              }
              localObject1 = ((Field)localObject4).getAnnotation(paramClass);
              if (localObject1 == null) {
                break label664;
              }
              ((Field)localObject4).setAccessible(true);
              Method localMethod = paramClass.getDeclaredMethod("value", new Class[0]);
              localMethod.setAccessible(true);
              if (localSearchConfig.valueClass() == Integer.TYPE)
              {
                localObject1 = (Integer)localMethod.invoke(localObject1, new Object[0]);
                localObject4 = Integer.valueOf(((Field)localObject4).getInt(localClass));
              }
              else
              {
                if (localSearchConfig.valueClass() != Long.TYPE) {
                  continue;
                }
                localObject1 = (Long)localMethod.invoke(localObject1, new Object[0]);
                localObject4 = Long.valueOf(((Field)localObject4).getLong(localClass));
              }
              checkFillMapValidity(paramClass, (Map)localObject2, (Map)localObject3, localClass, (Number)localObject1, (Number)localObject4);
              ((Map)localObject2).put(localObject4, localObject1);
              ((Map)localObject3).put(localObject1, localObject4);
              break label664;
              paramClass = new StringBuilder();
              paramClass.append("代码还没实现对");
              paramClass.append(localSearchConfig.valueClass().getName());
              paramClass.append("的支持");
              throw new IllegalArgumentException(paramClass.toString());
            }
            paramClass = new StringBuilder();
            paramClass.append("代码还没实现对");
            paramClass.append(localSearchConfig.valueClass().getName());
            paramClass.append("的支持");
            throw new IllegalArgumentException(paramClass.toString());
          }
        }
        else
        {
          localObject1 = new StringBuilder();
          ((StringBuilder)localObject1).append(paramClass.getCanonicalName());
          ((StringBuilder)localObject1).append("has not SearchConfig annotation");
          throw new IllegalArgumentException(((StringBuilder)localObject1).toString());
        }
      }
      catch (InvocationTargetException paramClass)
      {
        TPLogUtil.e("TPNativeKeyMapUtil", paramClass);
        return;
      }
      catch (NoSuchMethodException paramClass)
      {
        TPLogUtil.e("TPNativeKeyMapUtil", paramClass);
        throw new IllegalStateException("com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMap下所有元素需要加到混淆中, 并且每个MapXXX注解需要有value方法");
      }
      catch (IllegalAccessException paramClass)
      {
        TPLogUtil.e("TPNativeKeyMapUtil", paramClass);
      }
      return;
      label664:
      i += 1;
    }
  }
  
  public static <T extends Annotation> int toNativeIntValue(Class<T> paramClass, int paramInt)
  {
    Object localObject = getMapForAnnotation(paramClass);
    if (!((Map)localObject).containsKey(Integer.valueOf(paramInt)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toNativeValue, tpValue=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("return default value, clazz");
      ((StringBuilder)localObject).append(paramClass);
      TPLogUtil.e("TPNativeKeyMapUtil", ((StringBuilder)localObject).toString());
      return (int)((TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class)).nativeDefValue();
    }
    return ((Number)((Map)localObject).get(Integer.valueOf(paramInt))).intValue();
  }
  
  public static <T extends Annotation> long toNativeLongValue(Class<T> paramClass, long paramLong)
  {
    Object localObject = getMapForAnnotation(paramClass);
    if (!((Map)localObject).containsKey(Long.valueOf(paramLong)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toNativeValue, tpValue=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("return default value, clazz");
      ((StringBuilder)localObject).append(paramClass);
      TPLogUtil.e("TPNativeKeyMapUtil", ((StringBuilder)localObject).toString());
      return ((TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class)).nativeDefValue();
    }
    return ((Number)((Map)localObject).get(Long.valueOf(paramLong))).longValue();
  }
  
  public static <T extends Annotation> int toTPIntValue(Class<T> paramClass, int paramInt)
  {
    Object localObject = getMapForAnnotation(paramClass);
    if (!((Map)localObject).containsKey(Integer.valueOf(paramInt)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toTPValue, nativeValue=");
      ((StringBuilder)localObject).append(paramInt);
      ((StringBuilder)localObject).append("return default value, clazz");
      ((StringBuilder)localObject).append(paramClass);
      TPLogUtil.i("TPNativeKeyMapUtil", ((StringBuilder)localObject).toString());
      return (int)((TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class)).tpDefValue();
    }
    return ((Number)((Map)localObject).get(Integer.valueOf(paramInt))).intValue();
  }
  
  public static <T extends Annotation> long toTPLongValue(Class<T> paramClass, long paramLong)
  {
    Object localObject = getMapForAnnotation(paramClass);
    if (!((Map)localObject).containsKey(Long.valueOf(paramLong)))
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("toTPValue, nativeValue=");
      ((StringBuilder)localObject).append(paramLong);
      ((StringBuilder)localObject).append("return default value, clazz");
      ((StringBuilder)localObject).append(paramClass);
      TPLogUtil.i("TPNativeKeyMapUtil", ((StringBuilder)localObject).toString());
      return ((TPNativeKeyMap.SearchConfig)paramClass.getAnnotation(TPNativeKeyMap.SearchConfig.class)).tpDefValue();
    }
    return ((Number)((Map)localObject).get(Long.valueOf(paramLong))).longValue();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.thumbplayer.adapter.strategy.utils.TPNativeKeyMapUtil
 * JD-Core Version:    0.7.0.1
 */