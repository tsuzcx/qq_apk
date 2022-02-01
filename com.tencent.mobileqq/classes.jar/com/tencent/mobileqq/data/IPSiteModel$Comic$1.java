package com.tencent.mobileqq.data;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

final class IPSiteModel$Comic$1
  implements Parcelable.Creator
{
  public IPSiteModel.Comic a(Parcel paramParcel)
  {
    IPSiteModel.Comic localComic = new IPSiteModel.Comic();
    localComic.comicType = paramParcel.readInt();
    localComic.cover = paramParcel.readString();
    localComic.desc = paramParcel.readString();
    localComic.id = paramParcel.readString();
    localComic.jumpUrl = paramParcel.readString();
    localComic.name = paramParcel.readString();
    localComic.recommDesc = paramParcel.readString();
    localComic.typeName = paramParcel.readString();
    if (localComic.comicRiches == null) {
      localComic.comicRiches = new ArrayList();
    }
    localComic.comicRiches.clear();
    paramParcel.readList(localComic.comicRiches, IPSiteModel.ComicRich.class.getClassLoader());
    return localComic;
  }
  
  public IPSiteModel.Comic[] a(int paramInt)
  {
    return new IPSiteModel.Comic[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.data.IPSiteModel.Comic.1
 * JD-Core Version:    0.7.0.1
 */