package com.tencent.mobileqq.qcircle.api.db.util;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

public class ParcelableWrapper
  implements Parcelable
{
  private static final int ARRAY_LIST_TYPE = 10;
  private static final int BOOL_TYPE = 3;
  private static final int BYTEARRAY_TYPE = 14;
  private static final int BYTE_TYPE = 9;
  public static final Parcelable.Creator<ParcelableWrapper> CREATOR;
  private static final int DOUBLE_TYPE = 7;
  private static final int FLOAT_TYPE = 8;
  private static final int INT_TYPE = 1;
  private static final Set<ClassLoader> LOADERS = Collections.newSetFromMap(new ConcurrentHashMap());
  private static final int LONG_TYPE = 2;
  private static final int MAP_TYPE = 11;
  private static final int PARCABLE_TYPE = 4;
  public static final int POOL_SIZE = 6;
  private static final int SERIALIZABLE_TYPE = 12;
  private static final int SMART_PARCEL_TYPE = 6;
  private static final int STRINGARRAY_TYPE = 13;
  private static final int STRING_TYPE = 5;
  private static final int TYPE_UNDEFINE = 0;
  private static ClassLoader sClassLoader;
  private static ParcelableWrapper[] sOwnedPool;
  private static ConcurrentHashMap<String, ParcelableWrapper.ParcableInfo> sParcableCache = new ConcurrentHashMap(32, 0.75F, 4);
  private SmartParcelable obj;
  
  static
  {
    CREATOR = new ParcelableWrapper.1();
    sOwnedPool = new ParcelableWrapper[6];
  }
  
  private ParcelableWrapper() {}
  
  protected ParcelableWrapper(SmartParcelable paramSmartParcelable)
  {
    this.obj = paramSmartParcelable;
  }
  
  public static <T extends SmartParcelable> ArrayList<T> createArrayListFromParcel(Parcel paramParcel)
  {
    paramParcel = (ParcelableListWrapper)ParcelableListWrapper.CREATOR.createFromParcel(paramParcel);
    if (paramParcel == null) {
      return null;
    }
    return paramParcel.getParcelableList();
  }
  
  public static <T extends SmartParcelable> T createDataFromParcel(Parcel paramParcel)
  {
    return ((ParcelableWrapper)CREATOR.createFromParcel(paramParcel)).getData();
  }
  
  public static <T extends SmartParcelable> ArrayList<T> getArrayListFromBundle(Bundle paramBundle, String paramString)
  {
    paramBundle = (ParcelableListWrapper)paramBundle.getParcelable(paramString);
    if (paramBundle != null) {
      return paramBundle.getParcelableList();
    }
    return null;
  }
  
  public static <T extends SmartParcelable> ArrayList<T> getArrayListFromIntent(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    paramIntent = (ParcelableListWrapper)paramIntent.getParcelableExtra(paramString);
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getParcelableList();
  }
  
  private static ClassLoader getClassLoader()
  {
    ClassLoader localClassLoader = sClassLoader;
    if (localClassLoader != null) {
      return localClassLoader;
    }
    if (localClassLoader == null) {
      sClassLoader = ParcelableWrapper.class.getClassLoader();
    }
    return sClassLoader;
  }
  
  public static <T extends SmartParcelable> T getDataFromBudle(Bundle paramBundle, String paramString)
  {
    paramBundle = (ParcelableWrapper)paramBundle.getParcelable(paramString);
    if (paramBundle == null) {
      return null;
    }
    return paramBundle.getData();
  }
  
  public static <T extends SmartParcelable> T getDataFromeIntent(Intent paramIntent, String paramString)
  {
    if (paramIntent == null) {
      return null;
    }
    paramIntent = (ParcelableWrapper)paramIntent.getParcelableExtra(paramString);
    if (paramIntent == null) {
      return null;
    }
    return paramIntent.getData();
  }
  
  private static ParcelableWrapper.ParcableInfo getParcableInfo(String paramString, Class paramClass)
  {
    if (paramString != null)
    {
      ParcelableWrapper.ParcableInfo localParcableInfo = (ParcelableWrapper.ParcableInfo)sParcableCache.get(paramString);
      if (localParcableInfo == null)
      {
        Object localObject = paramClass;
        if (paramClass == null) {
          try
          {
            localObject = load(getClassLoader(), paramString);
          }
          catch (ClassNotFoundException paramClass)
          {
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("getParcableInfo.forName:");
            ((StringBuilder)localObject).append(paramString);
            QLog.e("ParcelableWrapper", 1, ((StringBuilder)localObject).toString(), paramClass);
            paramClass = new StringBuilder();
            paramClass.append("class forname:");
            paramClass.append(paramString);
            throw new RuntimeException(paramClass.toString());
          }
        }
        if (localObject != null) {
          try
          {
            localParcableInfo = (ParcelableWrapper.ParcableInfo)sParcableCache.get(paramString);
            paramClass = localParcableInfo;
            if (localParcableInfo == null)
            {
              paramClass = parseParcableInfo((Class)localObject);
              sParcableCache.put(paramString, paramClass);
            }
            return paramClass;
          }
          finally {}
        }
      }
      return localParcableInfo;
    }
    throw new NullPointerException("getParcableInfo.clsName can not be null!");
  }
  
  public static Class<?> load(ClassLoader paramClassLoader, String paramString)
  {
    try
    {
      paramClassLoader = paramClassLoader.loadClass(paramString);
    }
    catch (ClassNotFoundException paramClassLoader)
    {
      if (LOADERS.isEmpty()) {
        break label80;
      }
    }
    paramClassLoader = null;
    if (paramClassLoader != null) {
      return paramClassLoader;
    }
    Iterator localIterator = LOADERS.iterator();
    while (localIterator.hasNext())
    {
      try
      {
        Class localClass = ((ClassLoader)localIterator.next()).loadClass(paramString);
        return localClass;
      }
      catch (ClassNotFoundException localClassNotFoundException) {}
      if (!localIterator.hasNext()) {
        throw localClassNotFoundException;
      }
    }
    return paramClassLoader;
    for (;;)
    {
      label80:
      throw paramClassLoader;
    }
  }
  
  public static ParcelableWrapper obtain(SmartParcelable paramSmartParcelable)
  {
    ParcelableWrapper[] arrayOfParcelableWrapper = sOwnedPool;
    int i = 0;
    for (;;)
    {
      ParcelableWrapper localParcelableWrapper;
      if (i < 6)
      {
        localParcelableWrapper = arrayOfParcelableWrapper[i];
        if (localParcelableWrapper != null) {
          arrayOfParcelableWrapper[i] = null;
        }
      }
      else
      {
        try
        {
          localParcelableWrapper.obj = paramSmartParcelable;
          return localParcelableWrapper;
        }
        finally
        {
          break label54;
        }
        return new ParcelableWrapper(paramSmartParcelable);
        label54:
        for (;;)
        {
          throw paramSmartParcelable;
        }
      }
      i += 1;
    }
  }
  
  private static ParcelableWrapper.ParcableInfo parseParcableInfo(Class paramClass)
  {
    Object localObject1 = paramClass.getDeclaredFields();
    ParcelableWrapper.ParcableInfo localParcableInfo = new ParcelableWrapper.ParcableInfo();
    ParcelableWrapper.ParcableInfo.access$002(localParcableInfo, paramClass);
    List localList1 = ParcelableWrapper.ParcableInfo.access$100(localParcableInfo);
    List localList2 = ParcelableWrapper.ParcableInfo.access$200(localParcableInfo);
    Object localObject2 = paramClass.getSuperclass();
    if (SmartParcelable.class.isAssignableFrom((Class)localObject2))
    {
      localObject2 = getParcableInfo(((Class)localObject2).getName(), (Class)localObject2);
      localList1.addAll(ParcelableWrapper.ParcableInfo.access$100((ParcelableWrapper.ParcableInfo)localObject2));
      localList2.addAll(ParcelableWrapper.ParcableInfo.access$200((ParcelableWrapper.ParcableInfo)localObject2));
    }
    if (((localObject1 == null) || (localObject1.length <= 0)) && (localList2.size() <= 0))
    {
      localObject1 = new StringBuilder();
      ((StringBuilder)localObject1).append("SmartParcelable must have filed to Parcel:");
      ((StringBuilder)localObject1).append(paramClass);
      QLog.e("ParcelableWrapper", 1, ((StringBuilder)localObject1).toString());
      return localParcableInfo;
    }
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      paramClass = localObject1[i];
      if (paramClass.getAnnotation(NeedParcel.class) != null)
      {
        paramClass.setAccessible(true);
        localList1.add(paramClass);
        paramClass = paramClass.getType();
        if (paramClass == Integer.TYPE) {
          localList2.add(Integer.valueOf(1));
        } else if (paramClass == String.class) {
          localList2.add(Integer.valueOf(5));
        } else if (paramClass == Long.TYPE) {
          localList2.add(Integer.valueOf(2));
        } else if (paramClass == Double.TYPE) {
          localList2.add(Integer.valueOf(7));
        } else if (paramClass == Float.TYPE) {
          localList2.add(Integer.valueOf(8));
        } else if (paramClass == Boolean.TYPE) {
          localList2.add(Integer.valueOf(3));
        } else if (paramClass == Byte.TYPE) {
          localList2.add(Integer.valueOf(9));
        } else if (SmartParcelable.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(6));
        } else if (Parcelable.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(4));
        } else if (List.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(10));
        } else if (Map.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(11));
        } else if (Serializable.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(12));
        } else if ([Ljava.lang.String.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(13));
        } else if ([B.class.isAssignableFrom(paramClass)) {
          localList2.add(Integer.valueOf(14));
        } else {
          localList2.add(Integer.valueOf(0));
        }
      }
      i += 1;
    }
    return localParcableInfo;
  }
  
  public static void putArrayListToBundle(Bundle paramBundle, String paramString, ArrayList<? extends SmartParcelable> paramArrayList)
  {
    if (paramArrayList == null)
    {
      paramBundle.putParcelable(paramString, null);
      return;
    }
    paramBundle.putParcelable(paramString, new ParcelableListWrapper(paramArrayList));
  }
  
  public static Intent putArrayListToIntent(Intent paramIntent, String paramString, ArrayList<? extends SmartParcelable> paramArrayList)
  {
    if (paramIntent == null) {
      return null;
    }
    if (paramArrayList == null)
    {
      paramIntent.putExtra(paramString, (Parcelable)null);
      return paramIntent;
    }
    paramIntent.putExtra(paramString, new ParcelableListWrapper(paramArrayList));
    return paramIntent;
  }
  
  public static void putDataToBundle(Bundle paramBundle, String paramString, SmartParcelable paramSmartParcelable)
  {
    paramBundle.putParcelable(paramString, new ParcelableWrapper(paramSmartParcelable));
  }
  
  public static void putDataToIntent(Intent paramIntent, String paramString, SmartParcelable paramSmartParcelable)
  {
    paramIntent.putExtra(paramString, new ParcelableWrapper(paramSmartParcelable));
  }
  
  protected static ArrayList readArrayList(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    int i = paramParcel.readInt();
    if (i < 0) {
      return null;
    }
    ArrayList localArrayList = new ArrayList(i);
    readListInternal(paramParcel, localArrayList, i, paramClassLoader);
    return localArrayList;
  }
  
  public static HashMap readHashMap(Parcel paramParcel, ClassLoader paramClassLoader)
  {
    int i = paramParcel.readInt();
    if (i < 0) {
      return null;
    }
    HashMap localHashMap = new HashMap(i);
    readMapInternal(paramParcel, localHashMap, i, paramClassLoader);
    return localHashMap;
  }
  
  private static void readListInternal(Parcel paramParcel, List paramList, int paramInt, ClassLoader paramClassLoader)
  {
    while (paramInt > 0)
    {
      Object localObject = paramParcel.readValue(paramClassLoader);
      if ((localObject instanceof ParcelableWrapper)) {
        paramList.add(((ParcelableWrapper)localObject).getData());
      } else {
        paramList.add(localObject);
      }
      paramInt -= 1;
    }
  }
  
  static void readMapInternal(Parcel paramParcel, Map paramMap, int paramInt, ClassLoader paramClassLoader)
  {
    while (paramInt > 0)
    {
      Object localObject1 = paramParcel.readValue(paramClassLoader);
      Object localObject2 = paramParcel.readValue(paramClassLoader);
      if ((localObject2 instanceof ParcelableWrapper)) {
        paramMap.put(localObject1, ((ParcelableWrapper)localObject2).getData());
      } else {
        paramMap.put(localObject1, localObject2);
      }
      paramInt -= 1;
    }
  }
  
  /* Error */
  public static void recycle(ParcelableWrapper paramParcelableWrapper)
  {
    // Byte code:
    //   0: getstatic 72	com/tencent/mobileqq/qcircle/api/db/util/ParcelableWrapper:sOwnedPool	[Lcom/tencent/mobileqq/qcircle/api/db/util/ParcelableWrapper;
    //   3: astore_2
    //   4: aload_2
    //   5: monitorenter
    //   6: iconst_0
    //   7: istore_1
    //   8: iload_1
    //   9: bipush 6
    //   11: if_icmpge +16 -> 27
    //   14: aload_2
    //   15: iload_1
    //   16: aaload
    //   17: ifnonnull +24 -> 41
    //   20: aload_2
    //   21: iload_1
    //   22: aload_0
    //   23: aastore
    //   24: aload_2
    //   25: monitorexit
    //   26: return
    //   27: aload_2
    //   28: monitorexit
    //   29: return
    //   30: astore_0
    //   31: aload_2
    //   32: monitorexit
    //   33: goto +5 -> 38
    //   36: aload_0
    //   37: athrow
    //   38: goto -2 -> 36
    //   41: iload_1
    //   42: iconst_1
    //   43: iadd
    //   44: istore_1
    //   45: goto -37 -> 8
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	48	0	paramParcelableWrapper	ParcelableWrapper
    //   7	38	1	i	int
    //   3	29	2	arrayOfParcelableWrapper	ParcelableWrapper[]
    // Exception table:
    //   from	to	target	type
    //   24	26	30	finally
    //   27	29	30	finally
    //   31	33	30	finally
  }
  
  public static void writeArrayListToParcel(Parcel paramParcel, int paramInt, ArrayList<? extends SmartParcelable> paramArrayList)
  {
    if (paramArrayList == null)
    {
      paramParcel.writeString(null);
      return;
    }
    paramArrayList = ParcelableListWrapper.obtain(paramArrayList);
    paramArrayList.writeToParcel(paramParcel, paramInt);
    ParcelableListWrapper.recycle(paramArrayList);
  }
  
  public static void writeDataToParcel(Parcel paramParcel, int paramInt, SmartParcelable paramSmartParcelable)
  {
    if (paramSmartParcelable == null)
    {
      paramParcel.writeString(null);
      return;
    }
    paramSmartParcelable = obtain(paramSmartParcelable);
    paramSmartParcelable.writeToParcel(paramParcel, paramInt);
    recycle(paramSmartParcelable);
  }
  
  public static void writeList(Parcel paramParcel, List paramList)
  {
    if (paramList == null)
    {
      paramParcel.writeInt(-1);
      return;
    }
    int j = paramList.size();
    int i = 0;
    paramParcel.writeInt(j);
    while (i < j)
    {
      Object localObject = paramList.get(i);
      if ((localObject instanceof SmartParcelable))
      {
        localObject = obtain((SmartParcelable)localObject);
        paramParcel.writeValue(localObject);
        recycle((ParcelableWrapper)localObject);
      }
      else
      {
        paramParcel.writeValue(localObject);
      }
      i += 1;
    }
  }
  
  public static void writeMap(Parcel paramParcel, Map<String, Object> paramMap)
  {
    if (paramMap == null)
    {
      paramParcel.writeInt(-1);
      return;
    }
    paramMap = paramMap.entrySet();
    paramParcel.writeInt(paramMap.size());
    paramMap = paramMap.iterator();
    while (paramMap.hasNext())
    {
      Object localObject = (Map.Entry)paramMap.next();
      paramParcel.writeValue(((Map.Entry)localObject).getKey());
      localObject = ((Map.Entry)localObject).getValue();
      if ((localObject instanceof SmartParcelable))
      {
        localObject = obtain((SmartParcelable)localObject);
        paramParcel.writeValue(localObject);
        recycle((ParcelableWrapper)localObject);
      }
      else
      {
        paramParcel.writeValue(localObject);
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public SmartParcelable getData()
  {
    return this.obj;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    Object localObject1 = this.obj;
    if (localObject1 == null)
    {
      paramParcel.writeString(null);
      return;
    }
    Object localObject2 = localObject1.getClass();
    localObject1 = getParcableInfo(((Class)localObject2).getName(), (Class)localObject2);
    Object localObject3 = ParcelableWrapper.ParcableInfo.access$100((ParcelableWrapper.ParcableInfo)localObject1);
    localObject1 = ParcelableWrapper.ParcableInfo.access$200((ParcelableWrapper.ParcableInfo)localObject1);
    for (;;)
    {
      try
      {
        paramParcel.writeString(((Class)localObject2).getName());
        localObject2 = ((List)localObject3).iterator();
        int i = 0;
        if (((Iterator)localObject2).hasNext()) {
          localObject3 = (Field)((Iterator)localObject2).next();
        }
        switch (((Integer)((List)localObject1).get(i)).intValue())
        {
        case 14: 
          paramParcel.writeByteArray((byte[])((Field)localObject3).get(this.obj));
          break;
        case 13: 
          paramParcel.writeStringArray((String[])((Field)localObject3).get(this.obj));
          break;
        case 12: 
          paramParcel.writeSerializable((Serializable)((Field)localObject3).get(this.obj));
          break;
        case 11: 
          writeMap(paramParcel, (Map)((Field)localObject3).get(this.obj));
          break;
        case 10: 
          writeList(paramParcel, (List)((Field)localObject3).get(this.obj));
          break;
        case 9: 
          paramParcel.writeByte(((Field)localObject3).getByte(this.obj));
          break;
        case 8: 
          paramParcel.writeFloat(((Field)localObject3).getFloat(this.obj));
          break;
        case 7: 
          paramParcel.writeDouble(((Field)localObject3).getDouble(this.obj));
          break;
        case 6: 
          localObject3 = obtain((SmartParcelable)((Field)localObject3).get(this.obj));
          paramParcel.writeParcelable((Parcelable)localObject3, paramInt);
          recycle((ParcelableWrapper)localObject3);
          break;
        case 5: 
          paramParcel.writeString((String)((Field)localObject3).get(this.obj));
          break;
        case 4: 
          paramParcel.writeParcelable((Parcelable)((Field)localObject3).get(this.obj), paramInt);
          break;
        case 3: 
          if (!((Field)localObject3).getBoolean(this.obj)) {
            break label501;
          }
          b = 1;
          paramParcel.writeByte(b);
          break;
        case 2: 
          paramParcel.writeLong(((Field)localObject3).getLong(this.obj));
          break;
        case 1: 
          paramParcel.writeInt(((Field)localObject3).getInt(this.obj));
          break;
        case 0: 
          paramParcel.writeValue(((Field)localObject3).get(this.obj));
          i += 1;
          continue;
          return;
        }
      }
      catch (Throwable paramParcel)
      {
        QLog.e("ParcelableWrapper", 1, "ParcelableWrapper.writeToParcel:", paramParcel);
      }
      continue;
      label501:
      byte b = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.util.ParcelableWrapper
 * JD-Core Version:    0.7.0.1
 */