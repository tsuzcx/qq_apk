import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.ArticleTopicData.TopicInfo;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import java.util.ArrayList;
import java.util.List;

public final class mnt
  implements Parcelable.Creator
{
  public FastWebArticleInfo a(Parcel paramParcel)
  {
    int i = 0;
    boolean bool2 = true;
    FastWebArticleInfo localFastWebArticleInfo = new FastWebArticleInfo();
    localFastWebArticleInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localFastWebArticleInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localFastWebArticleInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.d = paramParcel.readString();
    localFastWebArticleInfo.e = paramParcel.readString();
    localFastWebArticleInfo.f = paramParcel.readString();
    localFastWebArticleInfo.h = paramParcel.readString();
    localFastWebArticleInfo.g = paramParcel.readString();
    localFastWebArticleInfo.j = paramParcel.readString();
    localFastWebArticleInfo.i = paramParcel.readString();
    localFastWebArticleInfo.jdField_a_of_type_Int = paramParcel.readInt();
    localFastWebArticleInfo.k = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localFastWebArticleInfo.jdField_a_of_type_Boolean = bool1;
      localFastWebArticleInfo.l = paramParcel.readString();
      localFastWebArticleInfo.jdField_c_of_type_Long = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label277;
      }
    }
    ArrayList localArrayList;
    label277:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localFastWebArticleInfo.jdField_b_of_type_Boolean = bool1;
      int j = paramParcel.readInt();
      if (j < 0) {
        break label293;
      }
      localArrayList = new ArrayList();
      while (i < j)
      {
        ArticleTopicData.TopicInfo localTopicInfo = new ArticleTopicData.TopicInfo();
        localTopicInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
        localTopicInfo.jdField_a_of_type_Long = paramParcel.readLong();
        localTopicInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
        localArrayList.add(localTopicInfo);
        i += 1;
      }
      bool1 = false;
      break;
    }
    localFastWebArticleInfo.jdField_a_of_type_JavaUtilList = localArrayList;
    return localFastWebArticleInfo;
    label293:
    localFastWebArticleInfo.jdField_a_of_type_JavaUtilList = null;
    return localFastWebArticleInfo;
  }
  
  public FastWebArticleInfo[] a(int paramInt)
  {
    return new FastWebArticleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     mnt
 * JD-Core Version:    0.7.0.1
 */