package dov.com.qq.im.capture.paster;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bpqm;
import bqji;
import bqjl;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import org.json.JSONObject;

public class PasterParcelData
  implements Parcelable
{
  public static final Parcelable.Creator<PasterParcelData> CREATOR = new bpqm();
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
  
  public PasterParcelData(bqjl parambqjl)
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_AndroidGraphicsPointF = parambqjl.b;
    this.jdField_a_of_type_Float = parambqjl.q;
    this.jdField_b_of_type_Float = parambqjl.r;
    this.jdField_c_of_type_Float = parambqjl.s;
    this.jdField_d_of_type_Float = parambqjl.t;
    this.jdField_e_of_type_Float = parambqjl.u;
    this.jdField_f_of_type_Float = parambqjl.v;
    this.jdField_a_of_type_AndroidGraphicsRectF = parambqjl.jdField_a_of_type_AndroidGraphicsRectF;
    this.jdField_a_of_type_JavaLangString = parambqjl.jdField_d_of_type_JavaLangString;
    this.jdField_b_of_type_JavaLangString = parambqjl.jdField_e_of_type_JavaLangString;
    this.jdField_c_of_type_JavaLangString = parambqjl.jdField_f_of_type_JavaLangString;
    this.jdField_d_of_type_Int = parambqjl.h;
    this.jdField_e_of_type_JavaLangString = parambqjl.jdField_g_of_type_JavaLangString;
    this.jdField_e_of_type_Int = parambqjl.jdField_g_of_type_Int;
    if ((parambqjl instanceof bqji))
    {
      this.jdField_c_of_type_Int = jdField_b_of_type_Int;
      bqji localbqji = (bqji)parambqjl;
      this.jdField_f_of_type_Int = localbqji.jdField_a_of_type_Int;
      this.jdField_g_of_type_Int = localbqji.jdField_b_of_type_Int;
      this.jdField_f_of_type_JavaLangString = localbqji.jdField_b_of_type_JavaLangString;
    }
    for (;;)
    {
      this.jdField_d_of_type_JavaLangString = parambqjl.a();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper(parambqjl.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
      return;
      this.jdField_c_of_type_Int = jdField_a_of_type_Int;
    }
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("centerPx", this.jdField_a_of_type_AndroidGraphicsPointF.x);
      localJSONObject.put("centerPy", this.jdField_a_of_type_AndroidGraphicsPointF.y);
      localJSONObject.put("scale", this.jdField_a_of_type_Float);
      localJSONObject.put("rotate", this.jdField_b_of_type_Float);
      localJSONObject.put("translateX", this.jdField_c_of_type_Float);
      localJSONObject.put("translateY", this.jdField_d_of_type_Float);
      localJSONObject.put("width", this.jdField_e_of_type_Float);
      localJSONObject.put("height", this.jdField_f_of_type_Float);
      localJSONObject.put("imageRbottom", this.jdField_a_of_type_AndroidGraphicsRectF.bottom);
      localJSONObject.put("imageRleft", this.jdField_a_of_type_AndroidGraphicsRectF.left);
      localJSONObject.put("imageRtop", this.jdField_a_of_type_AndroidGraphicsRectF.top);
      localJSONObject.put("imageRright", this.jdField_a_of_type_AndroidGraphicsRectF.right);
      localJSONObject.put("category", this.jdField_a_of_type_JavaLangString);
      localJSONObject.put("name", this.jdField_b_of_type_JavaLangString);
      localJSONObject.put("path", this.jdField_c_of_type_JavaLangString);
      localJSONObject.put("dynamicType", this.jdField_d_of_type_Int);
      if (this.jdField_e_of_type_JavaLangString != null) {
        localJSONObject.put("data", this.jdField_e_of_type_JavaLangString);
      }
      localJSONObject.put("autoAdded", this.jdField_e_of_type_Int);
      if (this.jdField_f_of_type_JavaLangString != null)
      {
        localJSONObject.put("textSize", this.jdField_f_of_type_Int);
        localJSONObject.put("textColor", this.jdField_g_of_type_Int);
        localJSONObject.put("text", this.jdField_f_of_type_JavaLangString);
      }
      localJSONObject.put("location", this.jdField_d_of_type_JavaLangString);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.PasterParcelData
 * JD-Core Version:    0.7.0.1
 */