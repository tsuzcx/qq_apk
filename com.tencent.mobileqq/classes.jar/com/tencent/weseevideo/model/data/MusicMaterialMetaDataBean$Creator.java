package com.tencent.weseevideo.model.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.weishi.module.publisher.data.VolumeAutomaticEffect;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, k=3, mv={1, 1, 16})
public final class MusicMaterialMetaDataBean$Creator
  implements Parcelable.Creator
{
  @NotNull
  public final Object createFromParcel(@NotNull Parcel paramParcel)
  {
    Intrinsics.checkParameterIsNotNull(paramParcel, "in");
    String str1 = paramParcel.readString();
    long l1 = paramParcel.readLong();
    String str2 = paramParcel.readString();
    String str3 = paramParcel.readString();
    String str4 = paramParcel.readString();
    String str5 = paramParcel.readString();
    int j = paramParcel.readInt();
    int k = paramParcel.readInt();
    String str6 = paramParcel.readString();
    Object localObject2 = paramParcel.readString();
    Object localObject3 = paramParcel.readString();
    String str7 = paramParcel.readString();
    List localList = (List)paramParcel.createStringArrayList();
    int m = paramParcel.readInt();
    String str8 = paramParcel.readString();
    int n = paramParcel.readInt();
    String str9 = paramParcel.readString();
    int i1 = paramParcel.readInt();
    int i2 = paramParcel.readInt();
    int i3 = paramParcel.readInt();
    int i4 = paramParcel.readInt();
    String str10 = paramParcel.readString();
    String str11 = paramParcel.readString();
    int i5 = paramParcel.readInt();
    int i6 = paramParcel.readInt();
    int i7 = paramParcel.readInt();
    int i8 = paramParcel.readInt();
    long l2 = paramParcel.readLong();
    int i9 = paramParcel.readInt();
    int i10 = paramParcel.readInt();
    byte b = paramParcel.readByte();
    int i11 = paramParcel.readInt();
    String str12 = paramParcel.readString();
    String str13 = paramParcel.readString();
    String str14 = paramParcel.readString();
    String str15 = paramParcel.readString();
    String str16 = paramParcel.readString();
    int i;
    Object localObject4;
    Object localObject1;
    if (paramParcel.readInt() != 0)
    {
      i = paramParcel.readInt();
      localObject4 = new LinkedHashMap(i);
      localObject1 = localObject3;
      while (i != 0)
      {
        ((Map)localObject4).put(Integer.valueOf(paramParcel.readInt()), paramParcel.readString());
        i -= 1;
      }
      localObject3 = localObject1;
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = localObject4;
    }
    else
    {
      localObject1 = localObject2;
      localObject2 = localObject3;
      localObject3 = null;
    }
    if (paramParcel.readInt() != 0)
    {
      i = paramParcel.readInt();
      localObject4 = new ArrayList(i);
      while (i != 0)
      {
        ((ArrayList)localObject4).add((MusicMaterialMetaDataBean.HighlightIndex)MusicMaterialMetaDataBean.HighlightIndex.CREATOR.createFromParcel(paramParcel));
        i -= 1;
      }
    }
    else
    {
      localObject4 = null;
    }
    ArrayList localArrayList1;
    if (paramParcel.readInt() != 0)
    {
      i = paramParcel.readInt();
      localArrayList1 = new ArrayList(i);
      while (i != 0)
      {
        localArrayList1.add((MusicMaterialMetaDataBean.HighlightIndex)MusicMaterialMetaDataBean.HighlightIndex.CREATOR.createFromParcel(paramParcel));
        i -= 1;
      }
    }
    else
    {
      localArrayList1 = null;
    }
    int i12 = paramParcel.readInt();
    int i13 = paramParcel.readInt();
    int i14 = paramParcel.readInt();
    int i15 = paramParcel.readInt();
    int i16 = paramParcel.readInt();
    String str17 = paramParcel.readString();
    boolean bool1;
    if (paramParcel.readInt() != 0) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    int i17 = paramParcel.readInt();
    int i18 = paramParcel.readInt();
    String str18 = paramParcel.readString();
    String str19 = paramParcel.readString();
    boolean bool2;
    if (paramParcel.readInt() != 0) {
      bool2 = true;
    } else {
      bool2 = false;
    }
    String str20 = paramParcel.readString();
    boolean bool3;
    if (paramParcel.readInt() != 0) {
      bool3 = true;
    } else {
      bool3 = false;
    }
    long l3 = paramParcel.readLong();
    long l4 = paramParcel.readLong();
    long l5 = paramParcel.readLong();
    long l6 = paramParcel.readLong();
    boolean bool4;
    if (paramParcel.readInt() != 0) {
      bool4 = true;
    } else {
      bool4 = false;
    }
    long l7 = paramParcel.readLong();
    float f = paramParcel.readFloat();
    long l8 = paramParcel.readLong();
    if (paramParcel.readInt() != 0)
    {
      i = paramParcel.readInt();
      ArrayList localArrayList2 = new ArrayList(i);
      while (i != 0)
      {
        localArrayList2.add((VolumeAutomaticEffect)VolumeAutomaticEffect.CREATOR.createFromParcel(paramParcel));
        i -= 1;
      }
      paramParcel = localArrayList2;
    }
    else
    {
      paramParcel = null;
    }
    return new MusicMaterialMetaDataBean(str1, l1, str2, str3, str4, str5, j, k, str6, localObject1, (String)localObject2, str7, localList, m, str8, n, str9, i1, i2, i3, i4, str10, str11, i5, i6, i7, i8, l2, i9, i10, b, i11, str12, str13, str14, str15, str16, (Map)localObject3, (List)localObject4, localArrayList1, i12, i13, i14, i15, i16, str17, bool1, i17, i18, str18, str19, bool2, str20, bool3, l3, l4, l5, l6, bool4, l7, f, l8, paramParcel);
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new MusicMaterialMetaDataBean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean.Creator
 * JD-Core Version:    0.7.0.1
 */