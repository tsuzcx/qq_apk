package cooperation.qzone.model;

import NS_MOBILE_FEEDS.stPhotoTag;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bheo;
import java.util.ArrayList;
import java.util.Iterator;

public class ImageTagInfo
  implements Parcelable
{
  public static final Parcelable.Creator<ImageTagInfo> CREATOR = new bheo();
  public int a;
  public String a;
  public int b;
  public String b;
  public int c;
  public String c;
  public int d;
  public String d;
  public int e;
  public int f;
  public int g = 2;
  
  public ImageTagInfo()
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
  }
  
  public ImageTagInfo(stPhotoTag paramstPhotoTag)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    if (paramstPhotoTag != null)
    {
      this.jdField_a_of_type_Int = paramstPhotoTag.type;
      this.jdField_a_of_type_JavaLangString = paramstPhotoTag.content;
      this.jdField_b_of_type_JavaLangString = paramstPhotoTag.tag_id;
      this.e = ((int)paramstPhotoTag.x_scale);
      this.f = ((int)paramstPhotoTag.y_scale);
      this.g = paramstPhotoTag.direction;
      this.jdField_c_of_type_JavaLangString = paramstPhotoTag.poiTagStreet;
    }
  }
  
  private ImageTagInfo(Parcel paramParcel)
  {
    this.jdField_a_of_type_Int = 0;
    this.jdField_b_of_type_JavaLangString = "";
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_Int = paramParcel.readInt();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.e = paramParcel.readInt();
    this.f = paramParcel.readInt();
    this.g = paramParcel.readInt();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
  }
  
  public static ArrayList<ImageTagInfo> a(ArrayList<stPhotoTag> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        ImageTagInfo localImageTagInfo = new ImageTagInfo((stPhotoTag)paramArrayList.next());
        if (localImageTagInfo != null) {
          localArrayList.add(localImageTagInfo);
        }
      }
    }
    return localArrayList;
  }
  
  public static ArrayList<stPhotoTag> b(ArrayList<ImageTagInfo> paramArrayList)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramArrayList != null)
    {
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        Object localObject = (ImageTagInfo)paramArrayList.next();
        if (localObject != null)
        {
          localObject = new stPhotoTag(((ImageTagInfo)localObject).jdField_a_of_type_Int, ((ImageTagInfo)localObject).jdField_a_of_type_JavaLangString, ((ImageTagInfo)localObject).jdField_b_of_type_JavaLangString, ((ImageTagInfo)localObject).e, ((ImageTagInfo)localObject).f, ((ImageTagInfo)localObject).g, ((ImageTagInfo)localObject).jdField_c_of_type_JavaLangString);
          if (localObject != null) {
            localArrayList.add(localObject);
          }
        }
      }
    }
    return localArrayList;
  }
  
  public ImageTagInfo a()
  {
    ImageTagInfo localImageTagInfo = new ImageTagInfo();
    localImageTagInfo.jdField_a_of_type_Int = this.jdField_a_of_type_Int;
    localImageTagInfo.jdField_a_of_type_JavaLangString = this.jdField_a_of_type_JavaLangString;
    localImageTagInfo.jdField_b_of_type_JavaLangString = this.jdField_b_of_type_JavaLangString;
    localImageTagInfo.jdField_b_of_type_Int = this.jdField_b_of_type_Int;
    localImageTagInfo.jdField_c_of_type_Int = this.jdField_c_of_type_Int;
    localImageTagInfo.jdField_d_of_type_Int = this.jdField_d_of_type_Int;
    localImageTagInfo.e = this.e;
    localImageTagInfo.f = this.f;
    localImageTagInfo.g = this.g;
    localImageTagInfo.jdField_c_of_type_JavaLangString = this.jdField_c_of_type_JavaLangString;
    localImageTagInfo.jdField_d_of_type_JavaLangString = this.jdField_d_of_type_JavaLangString;
    return localImageTagInfo;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.e);
    paramParcel.writeInt(this.f);
    paramParcel.writeInt(this.g);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.ImageTagInfo
 * JD-Core Version:    0.7.0.1
 */