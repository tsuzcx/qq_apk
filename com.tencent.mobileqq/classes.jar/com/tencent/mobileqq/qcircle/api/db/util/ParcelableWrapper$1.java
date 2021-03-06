package com.tencent.mobileqq.qcircle.api.db.util;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.Iterator;
import java.util.List;

final class ParcelableWrapper$1
  implements Parcelable.Creator<ParcelableWrapper>
{
  public ParcelableWrapper createFromParcel(Parcel paramParcel)
  {
    ParcelableWrapper localParcelableWrapper = new ParcelableWrapper(null);
    Object localObject1 = paramParcel.readString();
    if (TextUtils.isEmpty((CharSequence)localObject1)) {
      return localParcelableWrapper;
    }
    Object localObject3 = ParcelableWrapper.access$400((String)localObject1, null);
    Object localObject2 = ParcelableWrapper.ParcableInfo.access$100((ParcelableWrapper.ParcableInfo)localObject3);
    localObject1 = ParcelableWrapper.ParcableInfo.access$200((ParcelableWrapper.ParcableInfo)localObject3);
    localObject3 = ParcelableWrapper.ParcableInfo.access$000((ParcelableWrapper.ParcableInfo)localObject3);
    for (;;)
    {
      try
      {
        localObject3 = (SmartParcelable)((Class)localObject3).newInstance();
        ParcelableWrapper.access$502(localParcelableWrapper, (SmartParcelable)localObject3);
        localObject2 = ((List)localObject2).iterator();
        int i = 0;
        Field localField;
        if (((Iterator)localObject2).hasNext()) {
          localField = (Field)((Iterator)localObject2).next();
        }
        switch (((Integer)((List)localObject1).get(i)).intValue())
        {
        case 14: 
          localField.set(localObject3, paramParcel.createByteArray());
          break;
        case 13: 
          localField.set(localObject3, paramParcel.createStringArray());
          break;
        case 12: 
          localField.set(localObject3, paramParcel.readSerializable());
          break;
        case 11: 
          localField.set(localObject3, ParcelableWrapper.readHashMap(paramParcel, ParcelableWrapper.access$600()));
          break;
        case 10: 
          localField.set(localObject3, ParcelableWrapper.readArrayList(paramParcel, ParcelableWrapper.access$600()));
          break;
        case 9: 
          localField.setByte(localObject3, paramParcel.readByte());
          break;
        case 8: 
          localField.setFloat(localObject3, paramParcel.readFloat());
          break;
        case 7: 
          localField.setDouble(localObject3, paramParcel.readDouble());
          break;
        case 6: 
          localField.set(localObject3, ParcelableWrapper.access$500((ParcelableWrapper)paramParcel.readParcelable(ParcelableWrapper.access$600())));
          break;
        case 5: 
          localField.set(localObject3, paramParcel.readString());
          break;
        case 4: 
          localField.set(localObject3, paramParcel.readParcelable(ParcelableWrapper.access$600()));
          break;
        case 3: 
          if (paramParcel.readByte() <= 0) {
            break label456;
          }
          bool = true;
          localField.setBoolean(localObject3, bool);
          break;
        case 2: 
          localField.setLong(localObject3, paramParcel.readLong());
          break;
        case 1: 
          localField.setInt(localObject3, paramParcel.readInt());
          break;
        case 0: 
          localField.set(localObject3, paramParcel.readValue(ParcelableWrapper.access$600()));
          i += 1;
          continue;
          return localParcelableWrapper;
        }
      }
      catch (Exception paramParcel)
      {
        QLog.e("ParcelableWrapper", 1, "ParcelableWrapper.createFromParcel:", paramParcel);
      }
      continue;
      label456:
      boolean bool = false;
    }
  }
  
  public ParcelableWrapper[] newArray(int paramInt)
  {
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qcircle.api.db.util.ParcelableWrapper.1
 * JD-Core Version:    0.7.0.1
 */