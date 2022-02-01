package dov.com.qq.im.capture.paster;

import android.annotation.TargetApi;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bool;
import bpim;

public class InteractPasterParcelData
  implements Parcelable
{
  public static final Parcelable.Creator<InteractPasterParcelData> CREATOR = new bool();
  public float a;
  public int a;
  public PointF a;
  public Rect[] a;
  public String[] a;
  public float b;
  public float c;
  public float d;
  
  public InteractPasterParcelData(Parcel paramParcel)
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = paramParcel.readInt();
    this.jdField_a_of_type_AndroidGraphicsPointF = ((PointF)paramParcel.readParcelable(PointF.class.getClassLoader()));
    this.jdField_a_of_type_Float = paramParcel.readFloat();
    this.b = paramParcel.readFloat();
    this.c = paramParcel.readFloat();
    this.d = paramParcel.readFloat();
    int i = paramParcel.readInt();
    if (i > 0)
    {
      this.jdField_a_of_type_ArrayOfJavaLangString = new String[i];
      paramParcel.readStringArray(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
    i = paramParcel.readInt();
    if (i > 0)
    {
      this.jdField_a_of_type_ArrayOfAndroidGraphicsRect = new Rect[i];
      paramParcel.readTypedArray(this.jdField_a_of_type_ArrayOfAndroidGraphicsRect, Rect.CREATOR);
    }
  }
  
  public InteractPasterParcelData(bpim parambpim)
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_a_of_type_Int = parambpim.jdField_a_of_type_Int;
    this.jdField_a_of_type_AndroidGraphicsPointF = parambpim.b;
    this.jdField_a_of_type_Float = parambpim.q;
    this.b = parambpim.r;
    this.c = parambpim.s;
    this.d = parambpim.t;
    this.jdField_a_of_type_ArrayOfJavaLangString = parambpim.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_ArrayOfAndroidGraphicsRect = parambpim.jdField_a_of_type_ArrayOfAndroidGraphicsRect;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  @TargetApi(13)
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_Int);
    paramParcel.writeParcelable(this.jdField_a_of_type_AndroidGraphicsPointF, 0);
    paramParcel.writeFloat(this.jdField_a_of_type_Float);
    paramParcel.writeFloat(this.b);
    paramParcel.writeFloat(this.c);
    paramParcel.writeFloat(this.d);
    if ((this.jdField_a_of_type_ArrayOfJavaLangString == null) || (this.jdField_a_of_type_ArrayOfJavaLangString.length == 0)) {
      paramParcel.writeInt(0);
    }
    while ((this.jdField_a_of_type_ArrayOfAndroidGraphicsRect == null) || (this.jdField_a_of_type_ArrayOfAndroidGraphicsRect.length == 0))
    {
      paramParcel.writeInt(0);
      return;
      paramParcel.writeInt(this.jdField_a_of_type_ArrayOfJavaLangString.length);
      paramParcel.writeStringArray(this.jdField_a_of_type_ArrayOfJavaLangString);
    }
    paramParcel.writeInt(this.jdField_a_of_type_ArrayOfAndroidGraphicsRect.length);
    paramParcel.writeTypedArray(this.jdField_a_of_type_ArrayOfAndroidGraphicsRect, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.paster.InteractPasterParcelData
 * JD-Core Version:    0.7.0.1
 */