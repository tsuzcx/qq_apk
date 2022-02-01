package com.tencent.mobileqq.kandian.repo.feeds.entity;

import android.os.Parcel;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.List;

final class FastWebArticleInfo$1
  implements Parcelable.Creator<FastWebArticleInfo>
{
  public FastWebArticleInfo a(Parcel paramParcel)
  {
    FastWebArticleInfo localFastWebArticleInfo = new FastWebArticleInfo();
    localFastWebArticleInfo.b = paramParcel.readString();
    localFastWebArticleInfo.c = paramParcel.readLong();
    localFastWebArticleInfo.d = paramParcel.readLong();
    localFastWebArticleInfo.i = paramParcel.readString();
    localFastWebArticleInfo.j = paramParcel.readString();
    localFastWebArticleInfo.k = paramParcel.readString();
    localFastWebArticleInfo.l = paramParcel.readString();
    localFastWebArticleInfo.m = paramParcel.readString();
    localFastWebArticleInfo.o = paramParcel.readString();
    localFastWebArticleInfo.n = paramParcel.readString();
    localFastWebArticleInfo.q = paramParcel.readString();
    localFastWebArticleInfo.p = paramParcel.readString();
    localFastWebArticleInfo.s = paramParcel.readInt();
    localFastWebArticleInfo.t = paramParcel.readString();
    int i = paramParcel.readInt();
    int j = 0;
    boolean bool2 = true;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localFastWebArticleInfo.w = bool1;
    localFastWebArticleInfo.x = paramParcel.readString();
    localFastWebArticleInfo.y = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localFastWebArticleInfo.z = bool1;
    localFastWebArticleInfo.D = paramParcel.readString();
    int k = paramParcel.readInt();
    ArrayList localArrayList;
    ArticleTopicInfo localArticleTopicInfo;
    if (k >= 0)
    {
      localArrayList = new ArrayList();
      i = 0;
      while (i < k)
      {
        localArticleTopicInfo = new ArticleTopicInfo();
        localArticleTopicInfo.a = paramParcel.readString();
        localArticleTopicInfo.c = paramParcel.readLong();
        localArticleTopicInfo.b = paramParcel.readString();
        localArrayList.add(localArticleTopicInfo);
        i += 1;
      }
      localFastWebArticleInfo.A = localArrayList;
    }
    else
    {
      localFastWebArticleInfo.A = null;
    }
    localFastWebArticleInfo.B = paramParcel.readInt();
    localFastWebArticleInfo.C = paramParcel.readString();
    localFastWebArticleInfo.D = paramParcel.readString();
    localFastWebArticleInfo.E = paramParcel.readString();
    localFastWebArticleInfo.G = paramParcel.readString();
    localFastWebArticleInfo.H = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localFastWebArticleInfo.K = bool1;
    localFastWebArticleInfo.L = paramParcel.readString();
    localFastWebArticleInfo.M = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localFastWebArticleInfo.N = bool1;
    k = paramParcel.readInt();
    if (k > 0)
    {
      localArrayList = new ArrayList();
      i = j;
      while (i < k)
      {
        localArticleTopicInfo = new ArticleTopicInfo();
        localArticleTopicInfo.d = paramParcel.readString();
        localArticleTopicInfo.a = paramParcel.readString();
        localArticleTopicInfo.b = paramParcel.readString();
        localArrayList.add(localArticleTopicInfo);
        i += 1;
      }
      localFastWebArticleInfo.I = localArrayList;
      return localFastWebArticleInfo;
    }
    localFastWebArticleInfo.I = null;
    return localFastWebArticleInfo;
  }
  
  public FastWebArticleInfo[] a(int paramInt)
  {
    return new FastWebArticleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo.1
 * JD-Core Version:    0.7.0.1
 */