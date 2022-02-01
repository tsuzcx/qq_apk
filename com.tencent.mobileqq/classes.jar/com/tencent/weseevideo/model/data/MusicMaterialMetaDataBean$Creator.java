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
    String str7 = paramParcel.readString();
    String str8 = paramParcel.readString();
    String str9 = paramParcel.readString();
    List localList = (List)paramParcel.createStringArrayList();
    int m = paramParcel.readInt();
    String str10 = paramParcel.readString();
    int n = paramParcel.readInt();
    String str11 = paramParcel.readString();
    int i1 = paramParcel.readInt();
    int i2 = paramParcel.readInt();
    int i3 = paramParcel.readInt();
    int i4 = paramParcel.readInt();
    String str12 = paramParcel.readString();
    String str13 = paramParcel.readString();
    int i5 = paramParcel.readInt();
    int i6 = paramParcel.readInt();
    int i7 = paramParcel.readInt();
    int i8 = paramParcel.readInt();
    long l2 = paramParcel.readLong();
    int i9 = paramParcel.readInt();
    int i10 = paramParcel.readInt();
    byte b = paramParcel.readByte();
    int i11 = paramParcel.readInt();
    String str14 = paramParcel.readString();
    String str15 = paramParcel.readString();
    String str16 = paramParcel.readString();
    String str17 = paramParcel.readString();
    String str18 = paramParcel.readString();
    int i;
    if (paramParcel.readInt() != 0)
    {
      i = paramParcel.readInt();
      localObject2 = new LinkedHashMap(i);
      for (;;)
      {
        localObject1 = localObject2;
        if (i == 0) {
          break;
        }
        ((Map)localObject2).put(Integer.valueOf(paramParcel.readInt()), paramParcel.readString());
        i -= 1;
      }
    }
    Object localObject1 = null;
    if (paramParcel.readInt() != 0)
    {
      i = paramParcel.readInt();
      localObject3 = new ArrayList(i);
      for (;;)
      {
        localObject2 = localObject3;
        if (i == 0) {
          break;
        }
        ((ArrayList)localObject3).add((MusicMaterialMetaDataBean.HighlightIndex)MusicMaterialMetaDataBean.HighlightIndex.CREATOR.createFromParcel(paramParcel));
        i -= 1;
      }
    }
    Object localObject2 = null;
    if (paramParcel.readInt() != 0)
    {
      i = paramParcel.readInt();
      localObject4 = new ArrayList(i);
      for (;;)
      {
        localObject3 = localObject4;
        if (i == 0) {
          break;
        }
        ((ArrayList)localObject4).add((MusicMaterialMetaDataBean.HighlightIndex)MusicMaterialMetaDataBean.HighlightIndex.CREATOR.createFromParcel(paramParcel));
        i -= 1;
      }
    }
    Object localObject3 = null;
    int i12 = paramParcel.readInt();
    int i13 = paramParcel.readInt();
    int i14 = paramParcel.readInt();
    int i15 = paramParcel.readInt();
    int i16 = paramParcel.readInt();
    String str19 = paramParcel.readString();
    boolean bool1;
    int i17;
    int i18;
    String str20;
    String str21;
    boolean bool2;
    label500:
    String str22;
    boolean bool3;
    label516:
    long l3;
    long l4;
    long l5;
    long l6;
    if (paramParcel.readInt() != 0)
    {
      bool1 = true;
      i17 = paramParcel.readInt();
      i18 = paramParcel.readInt();
      str20 = paramParcel.readString();
      str21 = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label633;
      }
      bool2 = true;
      str22 = paramParcel.readString();
      if (paramParcel.readInt() == 0) {
        break label639;
      }
      bool3 = true;
      l3 = paramParcel.readLong();
      l4 = paramParcel.readLong();
      l5 = paramParcel.readLong();
      l6 = paramParcel.readLong();
      if (paramParcel.readInt() == 0) {
        break label645;
      }
    }
    long l7;
    float f;
    long l8;
    label645:
    for (boolean bool4 = true;; bool4 = false)
    {
      l7 = paramParcel.readLong();
      f = paramParcel.readFloat();
      l8 = paramParcel.readLong();
      if (paramParcel.readInt() == 0) {
        break label651;
      }
      i = paramParcel.readInt();
      ArrayList localArrayList = new ArrayList(i);
      for (;;)
      {
        localObject4 = localArrayList;
        if (i == 0) {
          break;
        }
        localArrayList.add((VolumeAutomaticEffect)VolumeAutomaticEffect.CREATOR.createFromParcel(paramParcel));
        i -= 1;
      }
      bool1 = false;
      break;
      label633:
      bool2 = false;
      break label500;
      label639:
      bool3 = false;
      break label516;
    }
    label651:
    Object localObject4 = null;
    return new MusicMaterialMetaDataBean(str1, l1, str2, str3, str4, str5, j, k, str6, str7, str8, str9, localList, m, str10, n, str11, i1, i2, i3, i4, str12, str13, i5, i6, i7, i8, l2, i9, i10, b, i11, str14, str15, str16, str17, str18, localObject1, (List)localObject2, (List)localObject3, i12, i13, i14, i15, i16, str19, bool1, i17, i18, str20, str21, bool2, str22, bool3, l3, l4, l5, l6, bool4, l7, f, l8, (List)localObject4);
  }
  
  @NotNull
  public final Object[] newArray(int paramInt)
  {
    return new MusicMaterialMetaDataBean[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     com.tencent.weseevideo.model.data.MusicMaterialMetaDataBean.Creator
 * JD-Core Version:    0.7.0.1
 */