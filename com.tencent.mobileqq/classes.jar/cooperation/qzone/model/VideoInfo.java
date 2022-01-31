package cooperation.qzone.model;

import amuw;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import java.util.Map;

public class VideoInfo
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new amuw();
  public byte a;
  public int a;
  public long a;
  public PictureUrl a;
  public VideoInfo.VideoRemark a;
  public VideoUrl a;
  public String a;
  public Map a;
  public boolean a;
  public int b;
  public long b;
  public PictureUrl b;
  public VideoUrl b;
  public String b;
  public boolean b;
  public int c;
  public long c;
  public PictureUrl c;
  public VideoUrl c;
  public String c;
  public boolean c;
  public int d;
  public long d;
  public PictureUrl d;
  public VideoUrl d;
  public String d;
  public boolean d;
  public int e;
  public long e;
  public VideoUrl e;
  public String e;
  public boolean e;
  public int f;
  public long f;
  public String f;
  public boolean f;
  public int g;
  public String g;
  public boolean g;
  public int h;
  public boolean h;
  public int i;
  public boolean i;
  public int j;
  public boolean j;
  public int k;
  public boolean k;
  public int l;
  public boolean l;
  
  public VideoInfo()
  {
    this.jdField_e_of_type_Int = 0;
    this.jdField_c_of_type_Boolean = true;
    this.jdField_d_of_type_Boolean = true;
    this.jdField_d_of_type_Long = -1L;
  }
  
  public boolean a()
  {
    return ((this.jdField_a_of_type_Byte & 0x1) != 0) || (this.jdField_d_of_type_Int == 1);
  }
  
  public boolean b()
  {
    return ((this.jdField_a_of_type_Byte & 0x2) != 0) && ((this.jdField_d_of_type_Long <= 0L) || (this.jdField_d_of_type_Long >= this.jdField_b_of_type_Long));
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public String toString()
  {
    return "VideoInfo [videoId=" + this.jdField_a_of_type_JavaLangString + ", videoUrl=" + this.jdField_a_of_type_CooperationQzoneModelVideoUrl + ", bigUrl=" + this.jdField_b_of_type_CooperationQzoneModelPictureUrl + ", actionType=" + this.jdField_a_of_type_Int + ", actionUrl=" + this.jdField_b_of_type_JavaLangString + ", highBrUrl=" + this.jdField_b_of_type_CooperationQzoneModelVideoUrl + ", lowBrUrl=" + this.jdField_c_of_type_CooperationQzoneModelVideoUrl + ", fileType=" + this.jdField_b_of_type_Int + ", videoType=" + this.jdField_c_of_type_Int + ",videoShowType=" + this.jdField_d_of_type_Int + ", videoTime=" + this.jdField_b_of_type_Long + ", videoStatus=" + this.jdField_e_of_type_Int + ", originVideoUrl=" + this.jdField_d_of_type_CooperationQzoneModelVideoUrl + ", originVideoSize=" + this.jdField_a_of_type_Long + "]";
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    int n = 1;
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelVideoUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelPictureUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_b_of_type_CooperationQzoneModelPictureUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_c_of_type_CooperationQzoneModelPictureUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_d_of_type_CooperationQzoneModelPictureUrl, paramInt);
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeParcelable(this.jdField_b_of_type_CooperationQzoneModelVideoUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_c_of_type_CooperationQzoneModelVideoUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_d_of_type_CooperationQzoneModelVideoUrl, paramInt);
    paramParcel.writeParcelable(this.jdField_e_of_type_CooperationQzoneModelVideoUrl, paramInt);
    paramParcel.writeLong(this.jdField_a_of_type_Long);
    paramParcel.writeInt(this.jdField_b_of_type_Int);
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeLong(this.jdField_b_of_type_Long);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeByte(this.jdField_a_of_type_Byte);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeLong(this.jdField_c_of_type_Long);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    int m;
    if (this.jdField_b_of_type_Boolean)
    {
      m = 1;
      paramParcel.writeInt(m);
      paramParcel.writeParcelable(this.jdField_a_of_type_CooperationQzoneModelVideoInfo$VideoRemark, paramInt);
      paramParcel.writeLong(this.jdField_d_of_type_Long);
      paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
      if (!this.jdField_i_of_type_Boolean) {
        break label370;
      }
      paramInt = 1;
      label252:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_j_of_type_Boolean) {
        break label375;
      }
      paramInt = 1;
      label266:
      paramParcel.writeInt(paramInt);
      paramParcel.writeInt(this.h);
      paramParcel.writeString(this.jdField_g_of_type_JavaLangString);
      paramParcel.writeInt(this.jdField_i_of_type_Int);
      paramParcel.writeInt(this.jdField_j_of_type_Int);
      paramParcel.writeInt(this.jdField_k_of_type_Int);
      paramParcel.writeLong(this.jdField_e_of_type_Long);
      paramParcel.writeInt(this.jdField_l_of_type_Int);
      if (!this.jdField_k_of_type_Boolean) {
        break label380;
      }
      paramInt = 1;
      label336:
      paramParcel.writeInt(paramInt);
      if (!this.jdField_l_of_type_Boolean) {
        break label385;
      }
    }
    label385:
    for (paramInt = n;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeLong(this.jdField_f_of_type_Long);
      return;
      m = 0;
      break;
      label370:
      paramInt = 0;
      break label252;
      label375:
      paramInt = 0;
      break label266;
      label380:
      paramInt = 0;
      break label336;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     cooperation.qzone.model.VideoInfo
 * JD-Core Version:    0.7.0.1
 */