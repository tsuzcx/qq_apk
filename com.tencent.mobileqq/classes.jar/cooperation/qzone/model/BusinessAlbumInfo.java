package cooperation.qzone.model;

import NS_MOBILE_MATERIAL.MaterialFile;
import NS_MOBILE_MATERIAL.MaterialItem;
import NS_MOBILE_PHOTO.Album;
import android.content.res.Resources;
import android.os.Parcel;
import android.os.Parcelable.Creator;
import android.text.TextUtils;
import bjgh;
import bjgi;
import com.tencent.qphone.base.util.BaseApplication;

public class BusinessAlbumInfo
  extends BaseBusinessAlbumInfo
{
  public static final Parcelable.Creator<BusinessAlbumInfo> CREATOR = new bjgh();
  
  private BusinessAlbumInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Long = paramParcel.readLong();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Long = paramParcel.readLong();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Long = paramParcel.readLong();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    if (paramParcel.readInt() == 1) {}
    for (;;)
    {
      this.jdField_a_of_type_Boolean = bool;
      this.e = paramParcel.readInt();
      this.f = paramParcel.readInt();
      this.jdField_d_of_type_JavaLangString = paramParcel.readString();
      this.g = paramParcel.readInt();
      this.h = paramParcel.readInt();
      this.i = paramParcel.readInt();
      return;
      bool = false;
    }
  }
  
  public BusinessAlbumInfo(String paramString)
  {
    super(paramString);
  }
  
  public static int a(int paramInt)
  {
    int i = 8;
    if (paramInt == 8) {
      i = 5;
    }
    do
    {
      return i;
      if (paramInt == 9) {
        return 6;
      }
    } while (paramInt == 11);
    return 1;
  }
  
  public static BusinessAlbumInfo a(Album paramAlbum)
  {
    boolean bool = true;
    if (paramAlbum == null) {
      return null;
    }
    BusinessAlbumInfo localBusinessAlbumInfo = new BusinessAlbumInfo(paramAlbum.albumid);
    localBusinessAlbumInfo.jdField_b_of_type_Int = paramAlbum.priv;
    localBusinessAlbumInfo.jdField_b_of_type_JavaLangString = paramAlbum.name;
    localBusinessAlbumInfo.jdField_a_of_type_Int = paramAlbum.total;
    localBusinessAlbumInfo.jdField_a_of_type_Long = paramAlbum.uin;
    localBusinessAlbumInfo.jdField_c_of_type_Int = paramAlbum.type;
    localBusinessAlbumInfo.jdField_c_of_type_Long = paramAlbum.svrtime;
    localBusinessAlbumInfo.jdField_c_of_type_JavaLangString = paramAlbum.coverurl;
    if ((a(paramAlbum.type) == 1) && (paramAlbum.material != null) && (paramAlbum.individual != 0L)) {}
    for (;;)
    {
      localBusinessAlbumInfo.jdField_a_of_type_Boolean = bool;
      localBusinessAlbumInfo.e = paramAlbum.opmask;
      localBusinessAlbumInfo.f = paramAlbum.allow_share;
      localBusinessAlbumInfo.jdField_d_of_type_JavaLangString = a(paramAlbum);
      localBusinessAlbumInfo.g = paramAlbum.is_share;
      localBusinessAlbumInfo.i = paramAlbum.sort_type;
      return localBusinessAlbumInfo;
      bool = false;
    }
  }
  
  public static BusinessAlbumInfo a(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    return new BusinessAlbumInfo(paramString);
  }
  
  public static BusinessAlbumInfo a(String paramString1, int paramInt1, String paramString2, String paramString3, int paramInt2, int paramInt3, int paramInt4, long paramLong, int paramInt5, int paramInt6, boolean paramBoolean1, String paramString4, boolean paramBoolean2)
  {
    paramString1 = new BusinessAlbumInfo(paramString1);
    paramString1.jdField_c_of_type_Int = paramInt1;
    paramString1.jdField_b_of_type_JavaLangString = paramString2;
    paramString1.jdField_c_of_type_JavaLangString = paramString3;
    paramString1.jdField_b_of_type_Int = paramInt2;
    paramString1.jdField_a_of_type_Int = paramInt3;
    paramString1.jdField_d_of_type_Int = paramInt4;
    boolean bool;
    if (paramLong == 1L)
    {
      bool = true;
      paramString1.jdField_a_of_type_Boolean = bool;
      paramString1.e = paramInt5;
      paramString1.f = paramInt6;
      if (!paramBoolean1) {
        break label115;
      }
      paramInt1 = 1;
      label77:
      paramString1.g = paramInt1;
      if (paramLong == 1L) {
        paramString1.jdField_d_of_type_JavaLangString = paramString4;
      }
      if (!paramBoolean2) {
        break label120;
      }
    }
    label115:
    label120:
    for (paramInt1 = 1;; paramInt1 = 0)
    {
      paramString1.h = paramInt1;
      return paramString1;
      bool = false;
      break;
      paramInt1 = 0;
      break label77;
    }
  }
  
  public static String a(int paramInt)
  {
    int j = 0;
    int i = j;
    switch (paramInt)
    {
    default: 
      i = j;
    }
    while (i == 0)
    {
      return null;
      i = 2131718324;
      continue;
      i = 2131718325;
      continue;
      i = 2131718071;
      continue;
      i = 2131718069;
      continue;
      i = 2131718074;
      continue;
      i = 2131718070;
    }
    return BaseApplication.getContext().getResources().getString(i);
  }
  
  public static String a(Album paramAlbum)
  {
    if ((paramAlbum == null) || (paramAlbum.individual != 1L) || (paramAlbum.material == null)) {}
    while ((paramAlbum.material.stBanner == null) || (TextUtils.isEmpty(paramAlbum.material.stBanner.strUrl))) {
      return null;
    }
    return paramAlbum.material.stBanner.strUrl;
  }
  
  public boolean a()
  {
    return this.g == 1;
  }
  
  public String c()
  {
    return bjgi.a(this.jdField_b_of_type_Int);
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public boolean equals(Object paramObject)
  {
    if (this == paramObject) {}
    do
    {
      do
      {
        return true;
        if (paramObject == null) {
          return false;
        }
        if (getClass() != paramObject.getClass()) {
          return false;
        }
        paramObject = (BusinessAlbumInfo)paramObject;
        if (this.jdField_a_of_type_JavaLangString != null) {
          break;
        }
      } while (paramObject.jdField_a_of_type_JavaLangString == null);
      return false;
    } while (this.jdField_a_of_type_JavaLangString.equals(paramObject.jdField_a_of_type_JavaLangString));
    return false;
  }
  
  public int hashCode()
  {
    if (this.jdField_a_of_type_JavaLangString == null) {}
    for (int i = 0;; i = this.jdField_a_of_type_JavaLangString.hashCode()) {
      return i + 31;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     cooperation.qzone.model.BusinessAlbumInfo
 * JD-Core Version:    0.7.0.1
 */