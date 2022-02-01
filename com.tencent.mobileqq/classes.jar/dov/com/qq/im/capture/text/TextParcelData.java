package dov.com.qq.im.capture.text;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bolc;
import bomd;
import bomv;
import bowf;
import bowh;
import bowi;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;

public class TextParcelData
  implements Parcelable
{
  public static final Parcelable.Creator<TextParcelData> CREATOR = new bomv();
  private float jdField_a_of_type_Float;
  private bowh jdField_a_of_type_Bowh;
  public SegmentKeeper a;
  private DynamicTextItem jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
  private float b;
  private float c;
  private float d;
  private float e;
  private float f;
  private float g;
  private float h;
  private float i;
  
  public TextParcelData(Parcel paramParcel)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    Object localObject = new bolc();
    int j = paramParcel.readInt();
    DynamicTextItem.TextMap localTextMap = (DynamicTextItem.TextMap)paramParcel.readParcelable(DynamicTextItem.TextMap.class.getClassLoader());
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = ((bolc)localObject).a(j, localTextMap.a());
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null)
    {
      QLog.e("TextParcelData", 1, "read mDynamicTextItem from Parcel return null, use normal text instead");
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = new bomd(j, localTextMap.a());
    }
    localObject = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((DynamicTextItem)localObject).a(bool);
      this.jdField_a_of_type_Bowh = new bowh(paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat());
      this.jdField_a_of_type_Float = paramParcel.readFloat();
      this.b = paramParcel.readFloat();
      this.c = paramParcel.readFloat();
      this.d = paramParcel.readFloat();
      this.e = paramParcel.readFloat();
      this.f = paramParcel.readFloat();
      this.g = paramParcel.readFloat();
      this.h = paramParcel.readFloat();
      this.i = paramParcel.readFloat();
      this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = ((SegmentKeeper)paramParcel.readParcelable(SegmentKeeper.class.getClassLoader()));
      return;
    }
  }
  
  public bowi a(bowf parambowf)
  {
    parambowf.getClass();
    parambowf = new bowi(parambowf, this.jdField_a_of_type_Bowh);
    parambowf.q = this.jdField_a_of_type_Bowh.jdField_a_of_type_Float;
    parambowf.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    parambowf.u = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
    parambowf.v = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
    parambowf.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    parambowf.b = this.b;
    parambowf.c = this.c;
    parambowf.d = this.d;
    parambowf.e = this.e;
    parambowf.f = this.f;
    parambowf.g = this.g;
    parambowf.h = this.h;
    parambowf.i = this.i;
    return parambowf;
  }
  
  public int describeContents()
  {
    return 0;
  }
  
  public void writeToParcel(Parcel paramParcel, int paramInt)
  {
    paramParcel.writeInt(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c());
    paramParcel.writeParcelable(this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a(), 0);
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e()) {}
    for (paramInt = 1;; paramInt = 0)
    {
      paramParcel.writeInt(paramInt);
      paramParcel.writeFloat(this.jdField_a_of_type_Bowh.jdField_a_of_type_AndroidGraphicsPointF.x);
      paramParcel.writeFloat(this.jdField_a_of_type_Bowh.jdField_a_of_type_AndroidGraphicsPointF.y);
      paramParcel.writeFloat(this.jdField_a_of_type_Bowh.jdField_a_of_type_Float);
      paramParcel.writeFloat(this.jdField_a_of_type_Bowh.b);
      paramParcel.writeFloat(this.jdField_a_of_type_Bowh.c);
      paramParcel.writeFloat(this.jdField_a_of_type_Bowh.d);
      paramParcel.writeFloat(this.jdField_a_of_type_Bowh.e);
      paramParcel.writeFloat(this.jdField_a_of_type_Bowh.f);
      paramParcel.writeFloat(this.jdField_a_of_type_Float);
      paramParcel.writeFloat(this.b);
      paramParcel.writeFloat(this.c);
      paramParcel.writeFloat(this.d);
      paramParcel.writeFloat(this.e);
      paramParcel.writeFloat(this.f);
      paramParcel.writeFloat(this.g);
      paramParcel.writeFloat(this.h);
      paramParcel.writeFloat(this.i);
      paramParcel.writeParcelable(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper, 0);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     dov.com.qq.im.capture.text.TextParcelData
 * JD-Core Version:    0.7.0.1
 */