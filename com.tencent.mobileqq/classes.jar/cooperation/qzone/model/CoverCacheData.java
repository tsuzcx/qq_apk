package cooperation.qzone.model;

import NS_MOBILE_COVER_DATE.CoverPackageInfo;
import NS_MOBILE_COVER_DATE.GameCoverInfo;
import NS_MOBILE_COVER_DATE.feeds_cover;
import NS_MOBILE_MAIN_PAGE.mobile_sub_get_cover_rsp;
import amef;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.ArrayList;
import java.util.HashMap;

public class CoverCacheData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new amef();
  public int a;
  public long a;
  public CoverCacheData.GameCoverInfo a;
  public CoverCacheData.PackageInfo a;
  public String a;
  public ArrayList a;
  public HashMap a;
  public int b;
  public String b;
  public HashMap b;
  public String c;
  public HashMap c;
  
  public CoverCacheData()
  {
    this.jdField_a_of_type_JavaLangString = "";
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_c_of_type_JavaLangString = "";
    this.jdField_a_of_type_JavaUtilHashMap = new HashMap();
    this.jdField_a_of_type_JavaUtilArrayList = new ArrayList();
    this.jdField_b_of_type_JavaUtilHashMap = new HashMap();
  }
  
  public static CoverCacheData a(long paramLong, feeds_cover paramfeeds_cover)
  {
    Object localObject;
    if (paramfeeds_cover == null) {
      localObject = null;
    }
    CoverCacheData localCoverCacheData;
    do
    {
      return localObject;
      localCoverCacheData = new CoverCacheData();
      localCoverCacheData.jdField_a_of_type_Long = paramLong;
      localCoverCacheData.jdField_a_of_type_JavaLangString = paramfeeds_cover.id;
      localCoverCacheData.jdField_b_of_type_JavaLangString = paramfeeds_cover.type;
      localCoverCacheData.jdField_a_of_type_Int = paramfeeds_cover.photoWallCombinePic;
      if (paramfeeds_cover.MulRelsotionUrl != null) {
        localCoverCacheData.jdField_a_of_type_JavaUtilHashMap.putAll(paramfeeds_cover.MulRelsotionUrl);
      }
      if (paramfeeds_cover.packageInfo != null)
      {
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo = new CoverCacheData.PackageInfo();
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_a_of_type_JavaLangString = paramfeeds_cover.packageInfo.prePic;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_b_of_type_JavaLangString = paramfeeds_cover.packageInfo.PackageUrl;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_c_of_type_JavaLangString = paramfeeds_cover.packageInfo.md5;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_a_of_type_Int = paramfeeds_cover.packageInfo.weather;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_b_of_type_Int = paramfeeds_cover.packageInfo.daytime;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_c_of_type_Int = paramfeeds_cover.packageInfo.coverStyle;
      }
      if (paramfeeds_cover.gameCoverInfo != null)
      {
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo = new CoverCacheData.GameCoverInfo();
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.jdField_a_of_type_Double = paramfeeds_cover.gameCoverInfo.xCoordLU;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.jdField_b_of_type_Double = paramfeeds_cover.gameCoverInfo.yCoordLU;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.c = paramfeeds_cover.gameCoverInfo.xCoordRD;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.d = paramfeeds_cover.gameCoverInfo.yCoordRD;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.jdField_a_of_type_JavaLangString = paramfeeds_cover.gameCoverInfo.jmpUrl;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.jdField_b_of_type_JavaLangString = paramfeeds_cover.gameCoverInfo.schema;
        localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo.jdField_a_of_type_Int = paramfeeds_cover.gameCoverInfo.jmpType;
      }
      if ((paramfeeds_cover.vecUrls != null) && (paramfeeds_cover.vecUrls.size() > 0)) {
        localCoverCacheData.jdField_a_of_type_JavaUtilArrayList.addAll(paramfeeds_cover.vecUrls);
      }
      localObject = localCoverCacheData;
    } while (paramfeeds_cover.mapExtInfo == null);
    localCoverCacheData.jdField_b_of_type_JavaUtilHashMap.putAll(paramfeeds_cover.mapExtInfo);
    return localCoverCacheData;
  }
  
  public static CoverCacheData a(long paramLong, mobile_sub_get_cover_rsp parammobile_sub_get_cover_rsp)
  {
    Object localObject;
    if (parammobile_sub_get_cover_rsp == null) {
      localObject = null;
    }
    CoverCacheData localCoverCacheData;
    do
    {
      do
      {
        return localObject;
        localCoverCacheData = new CoverCacheData();
        localCoverCacheData.jdField_a_of_type_Long = paramLong;
        localCoverCacheData.jdField_b_of_type_JavaLangString = parammobile_sub_get_cover_rsp.type;
        localCoverCacheData.jdField_a_of_type_Int = parammobile_sub_get_cover_rsp.photoWallCombinePic;
        if (parammobile_sub_get_cover_rsp.MulRelsotionUrl != null) {
          localCoverCacheData.jdField_a_of_type_JavaUtilHashMap.putAll(parammobile_sub_get_cover_rsp.MulRelsotionUrl);
        }
        if (parammobile_sub_get_cover_rsp.packageInfo != null)
        {
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo = new CoverCacheData.PackageInfo();
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_a_of_type_JavaLangString = parammobile_sub_get_cover_rsp.packageInfo.prePic;
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_b_of_type_JavaLangString = parammobile_sub_get_cover_rsp.packageInfo.PackageUrl;
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_c_of_type_JavaLangString = parammobile_sub_get_cover_rsp.packageInfo.md5;
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_a_of_type_Int = parammobile_sub_get_cover_rsp.packageInfo.weather;
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_b_of_type_Int = parammobile_sub_get_cover_rsp.packageInfo.daytime;
          localCoverCacheData.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo.jdField_c_of_type_Int = parammobile_sub_get_cover_rsp.packageInfo.coverStyle;
        }
        localObject = localCoverCacheData;
      } while (parammobile_sub_get_cover_rsp.vecUrls == null);
      localObject = localCoverCacheData;
    } while (parammobile_sub_get_cover_rsp.vecUrls.size() <= 0);
    localCoverCacheData.jdField_a_of_type_JavaUtilArrayList.addAll(parammobile_sub_get_cover_rsp.vecUrls);
    return localCoverCacheData;
  }
  
  public boolean a()
  {
    return ("CustomVideoCover".equals(this.jdField_b_of_type_JavaLangString)) || ("VideoCover".equals(this.jdField_b_of_type_JavaLangString));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeMap(this.jdField_a_of_type_JavaUtilHashMap);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelCoverCacheData$PackageInfo, paramInt);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelCoverCacheData$GameCoverInfo, paramInt);
    paramParcel.writeList(this.jdField_a_of_type_JavaUtilArrayList);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeMap(this.jdField_b_of_type_JavaUtilHashMap);
    paramParcel.writeMap(this.jdField_c_of_type_JavaUtilHashMap);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.CoverCacheData
 * JD-Core Version:    0.7.0.1
 */