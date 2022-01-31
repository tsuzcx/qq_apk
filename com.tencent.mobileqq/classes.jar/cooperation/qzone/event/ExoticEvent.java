package cooperation.qzone.event;

import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bjjh;
import bjji;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.component.app.common.ParcelableWrapper;
import com.tencent.component.app.common.SmartParcelable;
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
  implements Parcelable
{
  public static final Parcelable.Creator<ExoticEvent> CREATOR = new bjjh();
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
    String str = "";
    this.mTypes = new LinkedList();
    int i = paramParcel.readInt();
    if (i == 1) {}
    for (;;)
    {
      try
      {
        i = paramParcel.readInt();
        str = paramParcel.readString();
        paramParcel = foreachReadFromParcel(paramParcel, this.mTypes, getLoader());
        localParcel = paramParcel;
        paramParcel = str;
      }
      catch (Throwable paramParcel)
      {
        QZLog.w("ExoticEvent", "ExoticEvent: failed to parse event", paramParcel);
        paramParcel = "";
        this.mTypes.clear();
        this.mTypes.add(Integer.valueOf(0));
        i = -1;
        continue;
      }
      this.what = i;
      this.sourceName = paramParcel;
      this.param = localParcel;
      return;
      QZLog.w("ExoticEvent", "ExoticEvent: wrong version " + i, new Throwable());
      this.mTypes.add(Integer.valueOf(0));
      i = -1;
      paramParcel = str;
    }
  }
  
  private ExoticEvent(bjji parambjji, int paramInt, String paramString)
  {
    this.mTypes = bjji.a(parambjji);
    this.what = paramInt;
    this.sourceName = paramString;
    this.param = bjji.a(parambjji);
  }
  
  private static Object foreachReadFromParcel(Parcel paramParcel, List<Integer> paramList, ClassLoader paramClassLoader)
  {
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
    int i6 = paramParcel.readInt();
    paramList.add(Integer.valueOf(i6));
    Object localObject1;
    switch (i6)
    {
    case 0: 
    default: 
      localObject1 = null;
      return localObject1;
    case 1: 
      return paramParcel.readString();
    case 2: 
      return paramParcel.readParcelable(paramClassLoader);
    case 3: 
      return ParcelableWrapper.createDataFromParcel(paramParcel);
    case 4: 
      return paramParcel.readValue(paramClassLoader);
    case 5: 
      j = paramParcel.readInt();
      paramList = new byte[j];
      for (;;)
      {
        localObject1 = paramList;
        if (i >= j) {
          break;
        }
        paramList[i] = paramParcel.readByte();
        i += 1;
      }
    case 6: 
      paramParcel = paramParcel.readString();
      if (paramParcel == null) {
        return new char[0];
      }
      return paramParcel.toCharArray();
    case 7: 
      k = paramParcel.readInt();
      paramList = new short[k];
      i = j;
      for (;;)
      {
        localObject1 = paramList;
        if (i >= k) {
          break;
        }
        paramList[i] = ((short)paramParcel.readInt());
        i += 1;
      }
    case 8: 
      j = paramParcel.readInt();
      paramList = new int[j];
      i = k;
      for (;;)
      {
        localObject1 = paramList;
        if (i >= j) {
          break;
        }
        paramList[i] = paramParcel.readInt();
        i += 1;
      }
    case 9: 
      j = paramParcel.readInt();
      paramList = new float[j];
      i = m;
      for (;;)
      {
        localObject1 = paramList;
        if (i >= j) {
          break;
        }
        paramList[i] = paramParcel.readFloat();
        i += 1;
      }
    case 10: 
      j = paramParcel.readInt();
      paramList = new long[j];
      i = n;
      for (;;)
      {
        localObject1 = paramList;
        if (i >= j) {
          break;
        }
        paramList[i] = paramParcel.readLong();
        i += 1;
      }
    case 11: 
      j = paramParcel.readInt();
      paramList = new double[j];
      i = i1;
      for (;;)
      {
        localObject1 = paramList;
        if (i >= j) {
          break;
        }
        paramList[i] = paramParcel.readDouble();
        i += 1;
      }
    case 12: 
      j = paramParcel.readInt();
      paramList = new String[j];
      i = i2;
      for (;;)
      {
        localObject1 = paramList;
        if (i >= j) {
          break;
        }
        paramList[i] = paramParcel.readString();
        i += 1;
      }
    case 13: 
      j = paramParcel.readInt();
      localObject2 = new ArrayList(j);
      i = i3;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        ((List)localObject2).add(foreachReadFromParcel(paramParcel, paramList, paramClassLoader));
        i += 1;
      }
    case 14: 
      j = paramParcel.readInt();
      localObject2 = new LinkedHashSet();
      i = i4;
      for (;;)
      {
        localObject1 = localObject2;
        if (i >= j) {
          break;
        }
        ((Set)localObject2).add(foreachReadFromParcel(paramParcel, paramList, paramClassLoader));
        i += 1;
      }
    case 15: 
      j = paramParcel.readInt();
      localObject1 = new LinkedHashMap();
      i = 0;
      while (i < j)
      {
        Object localObject3 = foreachReadFromParcel(paramParcel, paramList, paramClassLoader);
        localObject2 = foreachReadFromParcel(paramParcel, paramList, paramClassLoader);
        if ((localObject3 != null) && (localObject2 != null))
        {
          ((Map)localObject1).put(localObject3, localObject2);
          i += 1;
        }
        else
        {
          StringBuilder localStringBuilder = new StringBuilder().append("foreachReadFromParcel: null key or value in parsing map ");
          if (localObject3 == null)
          {
            bool = true;
            label626:
            localObject3 = localStringBuilder.append(bool).append(" ");
            if (localObject2 != null) {
              break label679;
            }
          }
          label679:
          for (boolean bool = true;; bool = false)
          {
            QZLog.w("ExoticEvent", bool, new Throwable());
            break;
            bool = false;
            break label626;
          }
        }
      }
      return localObject1;
    }
    j = paramParcel.readInt();
    Object localObject2 = new Object[j];
    i = i5;
    for (;;)
    {
      localObject1 = localObject2;
      if (i >= j) {
        break;
      }
      localObject2[i] = foreachReadFromParcel(paramParcel, paramList, paramClassLoader);
      i += 1;
    }
  }
  
  private static boolean foreachType(bjji parambjji)
  {
    int i = getType(bjji.b(parambjji));
    bjji.a(parambjji).add(Integer.valueOf(i));
    switch (i)
    {
    }
    for (;;)
    {
      return bjji.a(parambjji);
      Object localObject1 = (Object[])bjji.b(parambjji);
      Object localObject2 = new Object[localObject1.length];
      i = 0;
      Object localObject3;
      for (;;)
      {
        if (i >= localObject1.length) {
          break label147;
        }
        localObject3 = new bjji(parambjji, localObject1[i]);
        if (!foreachType((bjji)localObject3))
        {
          bjji.a(parambjji, false);
          break;
        }
        localObject2[i] = bjji.a((bjji)localObject3);
        i += 1;
      }
      label147:
      bjji.a(parambjji, localObject2);
      continue;
      localObject2 = (List)bjji.b(parambjji);
      localObject1 = new ArrayList(((List)localObject2).size());
      localObject2 = ((List)localObject2).iterator();
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label242;
        }
        localObject3 = new bjji(parambjji, ((Iterator)localObject2).next());
        if (!foreachType((bjji)localObject3))
        {
          bjji.a(parambjji, false);
          break;
        }
        ((List)localObject1).add(bjji.a((bjji)localObject3));
      }
      label242:
      bjji.a(parambjji, localObject1);
      continue;
      localObject2 = (Set)bjji.b(parambjji);
      localObject1 = new LinkedHashSet();
      localObject2 = ((Set)localObject2).iterator();
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label331;
        }
        localObject3 = new bjji(parambjji, ((Iterator)localObject2).next());
        if (!foreachType((bjji)localObject3))
        {
          bjji.a(parambjji, false);
          break;
        }
        ((Set)localObject1).add(bjji.a((bjji)localObject3));
      }
      label331:
      bjji.a(parambjji, localObject1);
      continue;
      localObject2 = (Map)bjji.b(parambjji);
      localObject1 = new LinkedHashMap();
      localObject2 = ((Map)localObject2).entrySet().iterator();
      for (;;)
      {
        if (!((Iterator)localObject2).hasNext()) {
          break label485;
        }
        Object localObject4 = (Map.Entry)((Iterator)localObject2).next();
        localObject3 = ((Map.Entry)localObject4).getKey();
        localObject4 = ((Map.Entry)localObject4).getValue();
        if ((localObject3 != null) && (localObject4 != null))
        {
          localObject3 = new bjji(parambjji, localObject3);
          localObject4 = new bjji(parambjji, localObject4);
          if ((!foreachType((bjji)localObject3)) || (!foreachType((bjji)localObject4)))
          {
            bjji.a(parambjji, false);
            break;
          }
          ((Map)localObject1).put(bjji.a((bjji)localObject3), bjji.a((bjji)localObject4));
        }
      }
      label485:
      bjji.a(parambjji, localObject1);
      continue;
      bjji.a(parambjji, false);
    }
  }
  
  private static void foreachWriteToParcel(Parcel paramParcel, int paramInt, Iterator<Integer> paramIterator, Object paramObject)
  {
    int j = 0;
    int k = 0;
    int m = 0;
    int n = 0;
    int i1 = 0;
    int i2 = 0;
    int i = 0;
    if (!paramIterator.hasNext()) {}
    for (;;)
    {
      return;
      int i3 = ((Integer)paramIterator.next()).intValue();
      paramParcel.writeInt(i3);
      switch (i3)
      {
      case 0: 
      default: 
        return;
      case -1: 
        paramObject = (Object[])paramObject;
        paramParcel.writeInt(paramObject.length);
        j = paramObject.length;
        i = 0;
        while (i < j)
        {
          foreachWriteToParcel(paramParcel, paramInt, paramIterator, paramObject[i]);
          i += 1;
        }
      case 1: 
        paramParcel.writeString((String)paramObject);
        return;
      case 2: 
        paramParcel.writeParcelable((Parcelable)paramObject, paramInt);
        return;
      case 3: 
        ParcelableWrapper.writeDataToParcel(paramParcel, paramInt, (SmartParcelable)paramObject);
        return;
      case 4: 
        paramParcel.writeValue(paramObject);
        return;
      case 5: 
        paramIterator = (byte[])paramObject;
        paramParcel.writeInt(paramIterator.length);
        j = paramIterator.length;
        paramInt = i;
        while (paramInt < j)
        {
          paramParcel.writeByte(paramIterator[paramInt]);
          paramInt += 1;
        }
      case 6: 
        paramParcel.writeString(String.valueOf((char[])paramObject));
        return;
      case 7: 
        paramIterator = (short[])paramObject;
        paramParcel.writeInt(paramIterator.length);
        i = paramIterator.length;
        paramInt = j;
        while (paramInt < i)
        {
          paramParcel.writeInt(paramIterator[paramInt]);
          paramInt += 1;
        }
      case 8: 
        paramIterator = (int[])paramObject;
        paramParcel.writeInt(paramIterator.length);
        i = paramIterator.length;
        paramInt = k;
        while (paramInt < i)
        {
          paramParcel.writeInt(paramIterator[paramInt]);
          paramInt += 1;
        }
      case 9: 
        paramIterator = (float[])paramObject;
        paramParcel.writeInt(paramIterator.length);
        i = paramIterator.length;
        paramInt = m;
        while (paramInt < i)
        {
          paramParcel.writeFloat(paramIterator[paramInt]);
          paramInt += 1;
        }
      case 10: 
        paramIterator = (long[])paramObject;
        paramParcel.writeInt(paramIterator.length);
        i = paramIterator.length;
        paramInt = n;
        while (paramInt < i)
        {
          paramParcel.writeLong(paramIterator[paramInt]);
          paramInt += 1;
        }
      case 11: 
        paramIterator = (double[])paramObject;
        paramParcel.writeInt(paramIterator.length);
        i = paramIterator.length;
        paramInt = i1;
        while (paramInt < i)
        {
          paramParcel.writeDouble(paramIterator[paramInt]);
          paramInt += 1;
        }
      case 12: 
        paramIterator = (String[])paramObject;
        paramParcel.writeInt(paramIterator.length);
        i = paramIterator.length;
        paramInt = i2;
        while (paramInt < i)
        {
          paramParcel.writeString(paramIterator[paramInt]);
          paramInt += 1;
        }
      case 13: 
        paramObject = (List)paramObject;
        paramParcel.writeInt(paramObject.size());
        paramObject = paramObject.iterator();
        while (paramObject.hasNext()) {
          foreachWriteToParcel(paramParcel, paramInt, paramIterator, paramObject.next());
        }
      case 14: 
        paramObject = (Set)paramObject;
        paramParcel.writeInt(paramObject.size());
        paramObject = paramObject.iterator();
        while (paramObject.hasNext()) {
          foreachWriteToParcel(paramParcel, paramInt, paramIterator, paramObject.next());
        }
      }
      paramObject = (Map)paramObject;
      paramParcel.writeInt(paramObject.size());
      paramObject = paramObject.entrySet().iterator();
      while (paramObject.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramObject.next();
        foreachWriteToParcel(paramParcel, paramInt, paramIterator, localEntry.getKey());
        foreachWriteToParcel(paramParcel, paramInt, paramIterator, localEntry.getValue());
      }
    }
  }
  
  public static ClassLoader getLoader()
  {
    try
    {
      ClassLoader localClassLoader1 = QzonePluginProxyActivity.a(BaseApplicationImpl.getApplication());
      ClassLoader localClassLoader2 = localClassLoader1;
      if (localClassLoader1 == null) {
        localClassLoader2 = ExoticEvent.class.getClassLoader();
      }
      return localClassLoader2;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QZLog.w("ExoticEvent", "getLoader: failed to get plugin class loader", localThrowable);
        Object localObject = null;
      }
    }
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
    if (TextUtils.isEmpty(paramString)) {}
    for (;;)
    {
      return null;
      paramObject = new bjji(paramObject, null);
      try
      {
        bool = foreachType(paramObject);
        if (!bool) {
          continue;
        }
        return new ExoticEvent(paramObject, paramInt, paramString);
      }
      catch (Throwable localThrowable)
      {
        for (;;)
        {
          QZLog.w("ExoticEvent", "obtain: failed to foreach type " + paramInt + " " + paramString, localThrowable);
          boolean bool = false;
        }
      }
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(1);
    paramParcel.writeInt(this.what);
    paramParcel.writeString(this.sourceName);
    foreachWriteToParcel(paramParcel, paramInt, this.mTypes.iterator(), this.param);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.event.ExoticEvent
 * JD-Core Version:    0.7.0.1
 */