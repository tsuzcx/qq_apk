package dov.com.qq.im.capture.paster;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anvl;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceAndTextItem;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.FaceLayer.FaceItem;

public class PasterParcelData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new anvl();
  public static int a;
  public static int b;
  public float a;
  public PointF a;
  public RectF a;
  public SegmentKeeper a;
  public String a;
  public float b;
  public String b;
  public float c;
  public int c;
  public String c;
  public float d;
  public int d;
  public String d;
  public float e;
  public int e;
  public String e;
  public float f;
  public int f;
  public String f;
  public int g;
  
  static
  {
    jdField_a_of_type_Int = 1;
    jdField_b_of_type_Int = 2;
  }
  
  public PasterParcelData(Parcel paramParcel)
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_c_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_AndroidGraphicsPointF = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.jdField_b_of_type_Float = paramParcel.readFloat();
    this.jdField_c_of_type_Float = paramParcel.readFloat();
    this.jdField_d_of_type_Float = paramParcel.readFloat();
    this.jdField_e_of_type_Float = paramParcel.readFloat();
    this.jdField_f_of_type_Float = paramParcel.readFloat();
    this.jdField_a_of_type_AndroidGraphicsRectF = ((RectF)paramParcel.readParcelable(RectF.class.getClassLoader()));
    this.jdField_a_of_type_JavaLangString = paramParcel.readString();
    this.jdField_b_of_type_JavaLangString = paramParcel.readString();
    this.jdField_c_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_Int = paramParcel.readInt();
    this.jdField_e_of_type_JavaLangString = paramParcel.readString();
    this.jdField_e_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_Int = paramParcel.readInt();
    this.jdField_g_of_type_Int = paramParcel.readInt();
    this.jdField_f_of_type_JavaLangString = paramParcel.readString();
    this.jdField_d_of_type_JavaLangString = paramParcel.readString();
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = ((SegmentKeeper)paramParcel.readParcelable(SegmentKeeper.class.getClassLoader()));
  }
  
  public PasterParcelData(FaceLayer.FaceItem paramFaceItem)
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_AndroidGraphicsPointF = paramFaceItem.jdField_a_of_type_AndroidGraphicsPointF;
    this.jdField_a_of_type_Float = paramFaceItem.q;
    this.jdField_b_of_type_Float = paramFaceItem.r;
    this.jdField_c_of_type_Float = paramFaceItem.s;
    this.jdField_d_of_type_Float = paramFaceItem.t;
    this.jdField_e_of_type_Float = paramFaceItem.u;
    this.jdField_f_of_type_Float = paramFaceItem.v;
    this.jdField_a_of_type_AndroidGraphicsRectF = paramFaceItem.jdField_a_of_type_AndroidGraphicsRectF;
    this.jdField_a_of_type_JavaLangString = paramFaceItem.jdField_d_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = paramFaceItem.jdField_e_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = paramFaceItem.jdField_f_of_type_JavaLangString;
    this.jdField_d_of_type_Int = paramFaceItem.h;
    this.jdField_e_of_type_JavaLangString = paramFaceItem.jdField_g_of_type_JavaLangString;
    this.jdField_e_of_type_Int = paramFaceItem.jdField_g_of_type_Int;
    if ((paramFaceItem instanceof FaceLayer.FaceAndTextItem))
    {
      this.jdField_c_of_type_Int = jdField_b_of_type_Int;
      FaceLayer.FaceAndTextItem localFaceAndTextItem = (FaceLayer.FaceAndTextItem)paramFaceItem;
      this.jdField_f_of_type_Int = localFaceAndTextItem.jdField_a_of_type_Int;
      this.jdField_g_of_type_Int = localFaceAndTextItem.jdField_b_of_type_Int;
      this.jdField_f_of_type_JavaLangString = localFaceAndTextItem.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_d_of_type_JavaLangString = paramFaceItem.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper(paramFaceItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
      return;
      this.jdField_c_of_type_Int = jdField_a_of_type_Int;
    }
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @TargetApi(13)
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_c_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsPointF, 0);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.jdField_b_of_type_Float);
    paramParcel.writeFloat(this.jdField_c_of_type_Float);
    paramParcel.writeFloat(this.jdField_d_of_type_Float);
    paramParcel.writeFloat(this.jdField_e_of_type_Float);
    paramParcel.writeFloat(this.jdField_f_of_type_Float);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsRectF, 0);
    paramParcel.writeString(this.jdField_a_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_b_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_c_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_d_of_type_Int);
    paramParcel.writeString(this.jdField_e_of_type_JavaLangString);
    paramParcel.writeInt(this.jdField_e_of_type_Int);
    paramParcel.writeInt(this.jdField_f_of_type_Int);
    paramParcel.writeInt(this.jdField_g_of_type_Int);
    paramParcel.writeString(this.jdField_f_of_type_JavaLangString);
    paramParcel.writeString(this.jdField_d_of_type_JavaLangString);
    paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.PasterParcelData
 * JD-Core Version:    0.7.0.1
 */