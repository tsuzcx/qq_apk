import android.os.Parcel;
import android.os.Parcelable.Creator;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.data.RelatedSearchData;
import com.tencent.biz.pubaccount.readinjoy.view.fastweb.util.FastWebArticleInfo;
import java.util.ArrayList;
import java.util.List;

public final class svo
  implements Parcelable.Creator<FastWebArticleInfo>
{
  public FastWebArticleInfo a(Parcel paramParcel)
  {
    boolean bool2 = true;
    int j = 0;
    FastWebArticleInfo localFastWebArticleInfo = new FastWebArticleInfo();
    localFastWebArticleInfo.jdField_a_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_a_of_type_Long = paramParcel.readLong();
    localFastWebArticleInfo.jdField_b_of_type_Long = paramParcel.readLong();
    localFastWebArticleInfo.jdField_b_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_c_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.jdField_d_of_type_JavaLangString = paramParcel.readString();
    localFastWebArticleInfo.e = paramParcel.readString();
    localFastWebArticleInfo.f = paramParcel.readString();
    localFastWebArticleInfo.h = paramParcel.readString();
    localFastWebArticleInfo.g = paramParcel.readString();
    localFastWebArticleInfo.j = paramParcel.readString();
    localFastWebArticleInfo.i = paramParcel.readString();
    localFastWebArticleInfo.jdField_b_of_type_Int = paramParcel.readInt();
    localFastWebArticleInfo.l = paramParcel.readString();
    if (paramParcel.readInt() == 1)
    {
      bool1 = true;
      localFastWebArticleInfo.jdField_b_of_type_Boolean = bool1;
      localFastWebArticleInfo.o = paramParcel.readString();
      localFastWebArticleInfo.jdField_d_of_type_Long = paramParcel.readLong();
      if (paramParcel.readInt() != 1) {
        break label291;
      }
    }
    int k;
    Object localObject;
    int i;
    label291:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      localFastWebArticleInfo.jdField_c_of_type_Boolean = bool1;
      localFastWebArticleInfo.q = paramParcel.readString();
      k = paramParcel.readInt();
      if (k < 0) {
        break label413;
      }
      localObject = new ArrayList();
      i = 0;
      while (i < k)
      {
        sst localsst = new sst();
        localsst.jdField_a_of_type_JavaLangString = paramParcel.readString();
        localsst.jdField_a_of_type_Long = paramParcel.readLong();
        localsst.jdField_b_of_type_JavaLangString = paramParcel.readString();
        ((List)localObject).add(localsst);
        i += 1;
      }
      bool1 = false;
      break;
    }
    label413:
    for (localFastWebArticleInfo.jdField_a_of_type_JavaUtilList = ((List)localObject);; localFastWebArticleInfo.jdField_a_of_type_JavaUtilList = null)
    {
      k = paramParcel.readInt();
      if (k <= 0) {
        break label455;
      }
      localFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData = new RelatedSearchData(localFastWebArticleInfo);
      localFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData.jdField_a_of_type_JavaUtilList = new ArrayList();
      i = j;
      while (i < k)
      {
        localObject = new ssy();
        ((ssy)localObject).jdField_a_of_type_JavaLangString = paramParcel.readString();
        ((ssy)localObject).jdField_b_of_type_JavaLangString = paramParcel.readString();
        ((ssy)localObject).jdField_a_of_type_Float = paramParcel.readFloat();
        ((ssy)localObject).jdField_c_of_type_JavaLangString = paramParcel.readString();
        ((ssy)localObject).jdField_a_of_type_Int = paramParcel.readInt();
        i += 1;
      }
    }
    localFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData.jdField_a_of_type_JavaLangString = paramParcel.readString();
    for (;;)
    {
      localFastWebArticleInfo.jdField_c_of_type_Int = paramParcel.readInt();
      localFastWebArticleInfo.p = paramParcel.readString();
      return localFastWebArticleInfo;
      label455:
      localFastWebArticleInfo.jdField_a_of_type_ComTencentBizPubaccountReadinjoyViewFastwebDataRelatedSearchData = null;
    }
  }
  
  public FastWebArticleInfo[] a(int paramInt)
  {
    return new FastWebArticleInfo[paramInt];
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     svo
 * JD-Core Version:    0.7.0.1
 */