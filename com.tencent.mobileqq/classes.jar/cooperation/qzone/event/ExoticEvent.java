package cooperation.qzone.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
import com.tencent.qzonehub.api.IQzoneEventApi.ExoticEventInterface;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.qzone.util.QZLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class ExoticEvent
  implements IQzoneEventApi.ExoticEventInterface
{
  public static final Parcelable.Creator<ExoticEvent> CREATOR = new ExoticEvent.1();
  private static final String TAG = "ExoticEvent";
  private static final int TYPE_BYTE_ARRAY = 5;
  private static final int TYPE_CHAR_ARRAY = 6;
  private static final int TYPE_DOUBLE_ARRAY = 11;
  private static final int TYPE_FLOAT_ARRAY = 9;
  private static final int TYPE_INT_ARRAY = 8;
  private static final int TYPE_LIST = 13;
  private static final int TYPE_LONG_ARRAY = 10;
  private static final int TYPE_MAP = 15;
  private static final int TYPE_NULL = 0;
  private static final int TYPE_OBJECT_ARRAY = -1;
  private static final int TYPE_PARCELABLE = 2;
  private static final int TYPE_SERIALIZABLE = 4;
  private static final int TYPE_SET = 14;
  private static final int TYPE_SHORT_ARRAY = 7;
  private static final int TYPE_SMART_PARCELABLE = 3;
  private static final int TYPE_STRING = 1;
  private static final int TYPE_STRING_ARRAY = 12;
  private static final int TYPE_UNKNOWN = -2;
  private static final int VERSION = 1;
  private final List<Integer> mTypes;
  public final Object param;
  public final String sourceName;
  public final int what;
  
  private ExoticEvent(Parcel paramParcel)
  {
    this.mTypes = new LinkedList();
    int j = paramParcel.readInt();
    Integer localInteger = Integer.valueOf(0);
    Object localObject2 = null;
    Object localObject1 = "";
    int i = -1;
    if (j == 1)
    {
      try
      {
        j = paramParcel.readInt();
        String str = paramParcel.readString();
        paramParcel = foreachReadFromParcel(paramParcel, this.mTypes, getLoader());
        i = j;
        localObject1 = str;
      }
      catch (Throwable paramParcel)
      {
        QZLog.w("ExoticEvent", "ExoticEvent: failed to parse event", paramParcel);
        this.mTypes.clear();
        this.mTypes.add(localInteger);
        paramParcel = localObject2;
      }
    }
    else
    {
      paramParcel = new StringBuilder();
      paramParcel.append("ExoticEvent: wrong version ");
      paramParcel.append(j);
      QZLog.w("ExoticEvent", paramParcel.toString(), new Throwable());
      this.mTypes.add(localInteger);
      paramParcel = localObject2;
    }
    this.what = i;
    this.sourceName = ((String)localObject1);
    this.param = paramParcel;
  }
  
  private ExoticEvent(ExoticEvent.TypeCheckDoc paramTypeCheckDoc, int paramInt, String paramString)
  {
    this.mTypes = ExoticEvent.TypeCheckDoc.access$000(paramTypeCheckDoc);
    this.what = paramInt;
    this.sourceName = paramString;
    this.param = ExoticEvent.TypeCheckDoc.access$100(paramTypeCheckDoc);
  }
  
  private static Object foreachReadFromParcel(Parcel paramParcel, List<Integer> paramList, ClassLoader paramClassLoader)
  {
    int i6 = paramParcel.readInt();
    paramList.add(Integer.valueOf(i6));
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i4 = 0;
    int i5 = 0;
    int i = 0;
    Object localObject2;
    switch (i6)
    {
    case 0: 
    default: 
      return null;
    case 15: 
      j = paramParcel.readInt();
      localObject1 = new LinkedHashMap();
      i = 0;
      while (i < j)
      {
        localObject2 = foreachReadFromParcel(paramParcel, paramList, paramClassLoader);
        Object localObject3 = foreachReadFromParcel(paramParcel, paramList, paramClassLoader);
        if ((localObject2 != null) && (localObject3 != null))
        {
          ((Map)localObject1).put(localObject2, localObject3);
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append("foreachReadFromParcel: null key or value in parsing map ");
          boolean bool2 = true;
          boolean bool1;
          if (localObject2 == null) {
            bool1 = true;
          } else {
            bool1 = false;
          }
          localStringBuilder.append(bool1);
          localStringBuilder.append(" ");
          if (localObject3 == null) {
            bool1 = bool2;
          } else {
            bool1 = false;
          }
          localStringBuilder.append(bool1);
          QZLog.w("ExoticEvent", localStringBuilder.toString(), new Throwable());
        }
        i += 1;
      }
      return localObject1;
    case 14: 
      j = paramParcel.readInt();
      localObject1 = new LinkedHashSet();
      while (i < j)
      {
        ((Set)localObject1).add(foreachReadFromParcel(paramParcel, paramList, paramClassLoader));
        i += 1;
      }
      return localObject1;
    case 13: 
      k = paramParcel.readInt();
      localObject1 = new ArrayList(k);
      i = j;
      while (i < k)
      {
        ((List)localObject1).add(foreachReadFromParcel(paramParcel, paramList, paramClassLoader));
        i += 1;
      }
      return localObject1;
    case 12: 
      j = paramParcel.readInt();
      paramList = new String[j];
      i = k;
      while (i < j)
      {
        paramList[i] = paramParcel.readString();
        i += 1;
      }
      return paramList;
    case 11: 
      j = paramParcel.readInt();
      paramList = new double[j];
      i = m;
      while (i < j)
      {
        paramList[i] = paramParcel.readDouble();
        i += 1;
      }
      return paramList;
    case 10: 
      j = paramParcel.readInt();
      paramList = new long[j];
      i = n;
      while (i < j)
      {
        paramList[i] = paramParcel.readLong();
        i += 1;
      }
      return paramList;
    case 9: 
      j = paramParcel.readInt();
      paramList = new float[j];
      i = i1;
      while (i < j)
      {
        paramList[i] = paramParcel.readFloat();
        i += 1;
      }
      return paramList;
    case 8: 
      j = paramParcel.readInt();
      paramList = new int[j];
      i = i2;
      while (i < j)
      {
        paramList[i] = paramParcel.readInt();
        i += 1;
      }
      return paramList;
    case 7: 
      j = paramParcel.readInt();
      paramList = new short[j];
      i = i3;
      while (i < j)
      {
        paramList[i] = ((short)paramParcel.readInt());
        i += 1;
      }
      return paramList;
    case 6: 
      paramParcel = paramParcel.readString();
      if (paramParcel == null) {
        return new char[0];
      }
      return paramParcel.toCharArray();
    case 5: 
      j = paramParcel.readInt();
      paramList = new byte[j];
      i = i4;
      while (i < j)
      {
        paramList[i] = paramParcel.readByte();
        i += 1;
      }
      return paramList;
    case 4: 
      return paramParcel.readValue(paramClassLoader);
    case 3: 
      return ParcelableWrapper.createDataFromParcel(paramParcel);
    case 2: 
      return paramParcel.readParcelable(paramClassLoader);
    case 1: 
      return paramParcel.readString();
    }
    j = paramParcel.readInt();
    Object localObject1 = new Object[j];
    i = i5;
    for (;;)
    {
      if (i < j) {}
      try
      {
        localObject2 = foreachReadFromParcel(paramParcel, paramList, paramClassLoader);
        localObject1[i] = localObject2;
        i += 1;
      }
      catch (Throwable paramParcel)
      {
        break label739;
      }
    }
    return localObject1;
    label739:
    for (;;)
    {
      throw paramParcel;
    }
  }
  
  private static boolean foreachType(ExoticEvent.TypeCheckDoc paramTypeCheckDoc)
  {
    int i = getType(ExoticEvent.TypeCheckDoc.access$300(paramTypeCheckDoc));
    ExoticEvent.TypeCheckDoc.access$000(paramTypeCheckDoc).add(Integer.valueOf(i));
    Object localObject2;
    Object localObject1;
    Object localObject3;
    if (i != -2)
    {
      if (i != -1) {
        switch (i)
        {
        default: 
          break;
        case 15: 
          localObject2 = (Map)ExoticEvent.TypeCheckDoc.access$300(paramTypeCheckDoc);
          localObject1 = new LinkedHashMap();
          localObject2 = ((Map)localObject2).entrySet().iterator();
          while (((Iterator)localObject2).hasNext())
          {
            Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
            localObject3 = ((Map.Entry)localObject4).getKey();
            localObject4 = ((Map.Entry)localObject4).getValue();
            if ((localObject3 != null) && (localObject4 != null))
            {
              localObject3 = new ExoticEvent.TypeCheckDoc(paramTypeCheckDoc, localObject3);
              localObject4 = new ExoticEvent.TypeCheckDoc(paramTypeCheckDoc, localObject4);
              if ((foreachType((ExoticEvent.TypeCheckDoc)localObject3)) && (foreachType((ExoticEvent.TypeCheckDoc)localObject4)))
              {
                ((Map)localObject1).put(ExoticEvent.TypeCheckDoc.access$100((ExoticEvent.TypeCheckDoc)localObject3), ExoticEvent.TypeCheckDoc.access$100((ExoticEvent.TypeCheckDoc)localObject4));
              }
              else
              {
                ExoticEvent.TypeCheckDoc.access$402(paramTypeCheckDoc, false);
                break label513;
              }
            }
          }
          ExoticEvent.TypeCheckDoc.access$102(paramTypeCheckDoc, localObject1);
          break;
        case 14: 
          localObject2 = (Set)ExoticEvent.TypeCheckDoc.access$300(paramTypeCheckDoc);
          localObject1 = new LinkedHashSet();
          localObject2 = ((Set)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = new ExoticEvent.TypeCheckDoc(paramTypeCheckDoc, ((Iterator)localObject2).next());
            if (!foreachType((ExoticEvent.TypeCheckDoc)localObject3))
            {
              ExoticEvent.TypeCheckDoc.access$402(paramTypeCheckDoc, false);
              break label513;
            }
            ((Set)localObject1).add(ExoticEvent.TypeCheckDoc.access$100((ExoticEvent.TypeCheckDoc)localObject3));
          }
          ExoticEvent.TypeCheckDoc.access$102(paramTypeCheckDoc, localObject1);
          break;
        case 13: 
          localObject2 = (List)ExoticEvent.TypeCheckDoc.access$300(paramTypeCheckDoc);
          localObject1 = new ArrayList(((List)localObject2).size());
          localObject2 = ((List)localObject2).iterator();
          while (((Iterator)localObject2).hasNext())
          {
            localObject3 = new ExoticEvent.TypeCheckDoc(paramTypeCheckDoc, ((Iterator)localObject2).next());
            if (!foreachType((ExoticEvent.TypeCheckDoc)localObject3))
            {
              ExoticEvent.TypeCheckDoc.access$402(paramTypeCheckDoc, false);
              break label513;
            }
            ((List)localObject1).add(ExoticEvent.TypeCheckDoc.access$100((ExoticEvent.TypeCheckDoc)localObject3));
          }
          ExoticEvent.TypeCheckDoc.access$102(paramTypeCheckDoc, localObject1);
          break;
        }
      }
      localObject1 = (Object[])ExoticEvent.TypeCheckDoc.access$300(paramTypeCheckDoc);
      localObject2 = new Object[localObject1.length];
      i = 0;
    }
    for (;;)
    {
      if (i < localObject1.length) {
        localObject3 = new ExoticEvent.TypeCheckDoc(paramTypeCheckDoc, localObject1[i]);
      }
      try
      {
        boolean bool = foreachType((ExoticEvent.TypeCheckDoc)localObject3);
        if (!bool)
        {
          ExoticEvent.TypeCheckDoc.access$402(paramTypeCheckDoc, false);
        }
        else
        {
          localObject2[i] = ExoticEvent.TypeCheckDoc.access$100((ExoticEvent.TypeCheckDoc)localObject3);
          i += 1;
          continue;
          ExoticEvent.TypeCheckDoc.access$102(paramTypeCheckDoc, localObject2);
          break label513;
          ExoticEvent.TypeCheckDoc.access$402(paramTypeCheckDoc, false);
        }
        label513:
        return ExoticEvent.TypeCheckDoc.access$400(paramTypeCheckDoc);
      }
      catch (Throwable paramTypeCheckDoc) {}
    }
    for (;;)
    {
      throw paramTypeCheckDoc;
    }
  }
  
  private static void foreachWriteToParcel(Parcel paramParcel, int paramInt, Iterator<Integer> paramIterator, Object paramObject)
  {
    if (!paramIterator.hasNext()) {
      return;
    }
    int i4 = ((Integer)paramIterator.next()).intValue();
    paramParcel.writeInt(i4);
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i3 = 0;
    int i = 0;
    Map.Entry localEntry;
    switch (i4)
    {
    default: 
      return;
    case 15: 
      paramObject = (Map)paramObject;
      paramParcel.writeInt(paramObject.size());
      paramObject = paramObject.entrySet().iterator();
    case 14: 
    case 13: 
    case 12: 
    case 11: 
    case 10: 
    case 9: 
    case 8: 
    case 7: 
    case 6: 
    case 5: 
    case 4: 
    case 3: 
    case 2: 
    case 1: 
    case -1: 
      while (paramObject.hasNext())
      {
        localEntry = (Map.Entry)paramObject.next();
        foreachWriteToParcel(paramParcel, paramInt, paramIterator, localEntry.getKey());
        foreachWriteToParcel(paramParcel, paramInt, paramIterator, localEntry.getValue());
        continue;
        paramObject = (Set)paramObject;
        paramParcel.writeInt(paramObject.size());
        paramObject = paramObject.iterator();
        while (paramObject.hasNext())
        {
          foreachWriteToParcel(paramParcel, paramInt, paramIterator, paramObject.next());
          continue;
          paramObject = (List)paramObject;
          paramParcel.writeInt(paramObject.size());
          paramObject = paramObject.iterator();
          while (paramObject.hasNext())
          {
            foreachWriteToParcel(paramParcel, paramInt, paramIterator, paramObject.next());
            continue;
            paramIterator = (String[])paramObject;
            paramParcel.writeInt(paramIterator.length);
            j = paramIterator.length;
            paramInt = i;
            while (paramInt < j)
            {
              paramParcel.writeString(paramIterator[paramInt]);
              paramInt += 1;
              continue;
              paramIterator = (double[])paramObject;
              paramParcel.writeInt(paramIterator.length);
              i = paramIterator.length;
              paramInt = j;
              while (paramInt < i)
              {
                paramParcel.writeDouble(paramIterator[paramInt]);
                paramInt += 1;
                continue;
                paramIterator = (long[])paramObject;
                paramParcel.writeInt(paramIterator.length);
                i = paramIterator.length;
                paramInt = k;
                while (paramInt < i)
                {
                  paramParcel.writeLong(paramIterator[paramInt]);
                  paramInt += 1;
                  continue;
                  paramIterator = (float[])paramObject;
                  paramParcel.writeInt(paramIterator.length);
                  i = paramIterator.length;
                  paramInt = m;
                  while (paramInt < i)
                  {
                    paramParcel.writeFloat(paramIterator[paramInt]);
                    paramInt += 1;
                    continue;
                    paramIterator = (int[])paramObject;
                    paramParcel.writeInt(paramIterator.length);
                    i = paramIterator.length;
                    paramInt = n;
                    while (paramInt < i)
                    {
                      paramParcel.writeInt(paramIterator[paramInt]);
                      paramInt += 1;
                      continue;
                      paramIterator = (short[])paramObject;
                      paramParcel.writeInt(paramIterator.length);
                      i = paramIterator.length;
                      paramInt = i1;
                      while (paramInt < i)
                      {
                        paramParcel.writeInt(paramIterator[paramInt]);
                        paramInt += 1;
                        continue;
                        paramParcel.writeString(String.valueOf((char[])paramObject));
                        return;
                        paramIterator = (byte[])paramObject;
                        paramParcel.writeInt(paramIterator.length);
                        i = paramIterator.length;
                        paramInt = i2;
                        while (paramInt < i)
                        {
                          paramParcel.writeByte(paramIterator[paramInt]);
                          paramInt += 1;
                          continue;
                          paramParcel.writeValue(paramObject);
                          return;
                          ParcelableWrapper.writeDataToParcel(paramParcel, paramInt, (SmartParcelable)paramObject);
                          return;
                          paramParcel.writeParcelable((Parcelable)paramObject, paramInt);
                          return;
                          paramParcel.writeString((String)paramObject);
                          return;
                          paramObject = (Object[])paramObject;
                          paramParcel.writeInt(paramObject.length);
                          j = paramObject.length;
                          i = i3;
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
    for (;;)
    {
      if (i < j) {
        localEntry = paramObject[i];
      }
      try
      {
        foreachWriteToParcel(paramParcel, paramInt, paramIterator, localEntry);
        i += 1;
      }
      catch (Throwable paramParcel)
      {
        break label705;
      }
    }
    return;
    label705:
    for (;;)
    {
      throw paramParcel;
    }
  }
  
  public static ClassLoader getLoader()
  {
    Object localObject1;
    try
    {
      ClassLoader localClassLoader = QzonePluginProxyActivity.getQZonePluginClassLoader(BaseApplicationImpl.getApplication());
    }
    catch (Throwable localThrowable)
    {
      QZLog.w("ExoticEvent", "getLoader: failed to get plugin class loader", localThrowable);
      localObject1 = null;
    }
    Object localObject2 = localObject1;
    if (localObject1 == null) {
      localObject2 = ExoticEvent.class.getClassLoader();
    }
    return localObject2;
  }
  
  private static int getType(Object paramObject)
  {
    if (paramObject == null) {
      return 0;
    }
    if ((paramObject instanceof String)) {
      return 1;
    }
    if ((paramObject instanceof byte[])) {
      return 5;
    }
    if ((paramObject instanceof char[])) {
      return 6;
    }
    if ((paramObject instanceof short[])) {
      return 7;
    }
    if ((paramObject instanceof int[])) {
      return 8;
    }
    if ((paramObject instanceof float[])) {
      return 9;
    }
    if ((paramObject instanceof long[])) {
      return 10;
    }
    if ((paramObject instanceof double[])) {
      return 11;
    }
    if ((paramObject instanceof String[])) {
      return 12;
    }
    if ((paramObject instanceof Object[])) {
      return -1;
    }
    if ((paramObject instanceof List)) {
      return 13;
    }
    if ((paramObject instanceof Set)) {
      return 14;
    }
    if ((paramObject instanceof Map)) {
      return 15;
    }
    if ((paramObject instanceof Parcelable)) {
      return 2;
    }
    if ((paramObject instanceof SmartParcelable)) {
      return 3;
    }
    if ((paramObject instanceof Serializable)) {
      return 4;
    }
    return -2;
  }
  
  public static ExoticEvent obtain(int paramInt, String paramString, Object paramObject)
  {
    boolean bool = TextUtils.isEmpty(paramString);
    Object localObject = null;
    if (bool) {
      return null;
    }
    ExoticEvent.TypeCheckDoc localTypeCheckDoc = new ExoticEvent.TypeCheckDoc(paramObject, null);
    try
    {
      bool = foreachType(localTypeCheckDoc);
    }
    catch (Throwable paramObject)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("obtain: failed to foreach type ");
      localStringBuilder.append(paramInt);
      localStringBuilder.append(" ");
      localStringBuilder.append(paramString);
      QZLog.w("ExoticEvent", localStringBuilder.toString(), paramObject);
      bool = false;
    }
    paramObject = localObject;
    if (bool) {
      paramObject = new ExoticEvent(localTypeCheckDoc, paramInt, paramString);
    }
    return paramObject;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public Object getParam()
  {
    return this.param;
  }
  
  public String getSourceName()
  {
    return this.sourceName;
  }
  
  public int getWhat()
  {
    return this.what;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(1);
    paramParcel.writeInt(this.what);
    paramParcel.writeString(this.sourceName);
    foreachWriteToParcel(paramParcel, paramInt, this.mTypes.iterator(), this.param);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     cooperation.qzone.event.ExoticEvent
 * JD-Core Version:    0.7.0.1
 */