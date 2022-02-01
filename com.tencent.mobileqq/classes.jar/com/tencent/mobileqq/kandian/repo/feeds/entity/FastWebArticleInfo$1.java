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
    localFastWebArticleInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localFastWebArticleInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localFastWebArticleInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_e_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.f = paramParcel.readString();
    localFastWebArticleInfo.h = paramParcel.readString();
    localFastWebArticleInfo.g = paramParcel.readString();
    localFastWebArticleInfo.j = paramParcel.readString();
    localFastWebArticleInfo.i = paramParcel.readString();
    localFastWebArticleInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localFastWebArticleInfo.l = paramParcel.readString();
    int i = paramParcel.readInt();
    int j = 0;
    boolean bool2 = true;
    boolean bool1;
    if (i == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localFastWebArticleInfo.jdField_b_of_type_Boolean = bool1;
    localFastWebArticleInfo.o = paramParcel.readString();
    localFastWebArticleInfo.jdField_e_of_type_Long = paramParcel.readLong();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localFastWebArticleInfo.jdField_c_of_type_Boolean = bool1;
    localFastWebArticleInfo.q = paramParcel.readString();
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
        localArticleTopicInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
        localArticleTopicInfo.jdField_a_of_type_Long = paramParcel.readLong();
        localArticleTopicInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
        localArrayList.add(localArticleTopicInfo);
        i += 1;
      }
      localFastWebArticleInfo.jdField_a_of_type_JavaUtilList = localArrayList;
    }
    else
    {
      localFastWebArticleInfo.jdField_a_of_type_JavaUtilList = null;
    }
    localFastWebArticleInfo.jdField_c_of_type_Int = paramParcel.readInt();
    localFastWebArticleInfo.p = paramParcel.readString();
    localFastWebArticleInfo.q = paramParcel.readString();
    localFastWebArticleInfo.r = paramParcel.readString();
    localFastWebArticleInfo.s = paramParcel.readString();
    localFastWebArticleInfo.jdField_d_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = true;
    } else {
      bool1 = false;
    }
    localFastWebArticleInfo.jdField_d_of_type_Boolean = bool1;
    localFastWebArticleInfo.t = paramParcel.readString();
    localFastWebArticleInfo.jdField_e_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {
      bool1 = bool2;
    } else {
      bool1 = false;
    }
    localFastWebArticleInfo.jdField_e_of_type_Boolean = bool1;
    k = paramParcel.readInt();
    if (k > 0)
    {
      localArrayList = new ArrayList();
      i = j;
      while (i < k)
      {
        localArticleTopicInfo = new ArticleTopicInfo();
        localArticleTopicInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
        localArticleTopicInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
        localArticleTopicInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
        localArrayList.add(localArticleTopicInfo);
        i += 1;
      }
      localFastWebArticleInfo.jdField_b_of_type_JavaUtilList = localArrayList;
      return localFastWebArticleInfo;
    }
    localFastWebArticleInfo.jdField_b_of_type_JavaUtilList = null;
    return localFastWebArticleInfo;
  }
  
  public FastWebArticleInfo[] a(int paramInt)
  {
    return new FastWebArticleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.repo.feeds.entity.FastWebArticleInfo.1
 * JD-Core Version:    0.7.0.1
 */