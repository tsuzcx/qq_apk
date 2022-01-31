package dov.com.qq.im.capture.text;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import bhlz;
import bhna;
import bhns;
import bijo;
import bijq;
import bijr;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TextParcelData
  implements Parcelable
{
  public static final Parcelable.Creator<TextParcelData> CREATOR = new bhns();
  private float jdField_a_of_type_Float;
  private bijq jdField_a_of_type_Bijq;
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
    Object localObject = new bhlz();
    int j = paramParcel.readInt();
    DynamicTextItem.TextMap localTextMap = (DynamicTextItem.TextMap)paramParcel.readParcelable(DynamicTextItem.TextMap.class.getClassLoader());
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = ((bhlz)localObject).a(j, localTextMap.a());
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null)
    {
      QLog.e("TextParcelData", 1, "read mDynamicTextItem from Parcel return null, use normal text instead");
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = new bhna(j, localTextMap.a());
    }
    localObject = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((DynamicTextItem)localObject).a(bool);
      this.jdField_a_of_type_Bijq = new bijq(paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat());
      this.jdField_a_of_type_Float = paramParcel.readFloat();
      this.jdField_b_of_type_Float = paramParcel.readFloat();
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
  
  public TextParcelData(bijr parambijr)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = parambijr.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    this.jdField_a_of_type_Bijq = new bijq(parambijr.jdField_b_of_type_AndroidGraphicsPointF.x, parambijr.jdField_b_of_type_AndroidGraphicsPointF.y, parambijr.q, parambijr.r, parambijr.s, parambijr.t, parambijr.u, parambijr.v);
    this.jdField_a_of_type_Float = parambijr.jdField_a_of_type_Float;
    this.jdField_b_of_type_Float = parambijr.jdField_b_of_type_Float;
    this.c = parambijr.c;
    this.d = parambijr.d;
    this.e = parambijr.e;
    this.f = parambijr.f;
    this.g = parambijr.g;
    this.h = parambijr.h;
    this.i = parambijr.i;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(parambijr.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
  }
  
  public bijr a(bijo parambijo)
  {
    parambijo.getClass();
    parambijo = new bijr(parambijo, this.jdField_a_of_type_Bijq);
    parambijo.q = this.jdField_a_of_type_Bijq.jdField_a_of_type_Float;
    parambijo.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    parambijo.u = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
    parambijo.v = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
    parambijo.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    parambijo.jdField_b_of_type_Float = this.jdField_b_of_type_Float;
    parambijo.c = this.c;
    parambijo.d = this.d;
    parambijo.e = this.e;
    parambijo.f = this.f;
    parambijo.g = this.g;
    parambijo.h = this.h;
    parambijo.i = this.i;
    parambijo.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
    return parambijo;
  }
  
  public JSONObject a()
  {
    try
    {
      JSONObject localJSONObject = new JSONObject();
      localJSONObject.put("dynamicTextType", this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.c());
      DynamicTextItem.TextMap localTextMap = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
      if (localTextMap != null)
      {
        localJSONObject.put("dynamicText", localTextMap.a());
        localJSONObject.put("isFromCombo", this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.e());
      }
      localJSONObject.put("centerPx", this.jdField_a_of_type_Bijq.jdField_a_of_type_AndroidGraphicsPointF.x);
      localJSONObject.put("centerPy", this.jdField_a_of_type_Bijq.jdField_a_of_type_AndroidGraphicsPointF.y);
      localJSONObject.put("scale", this.jdField_a_of_type_Bijq.jdField_a_of_type_Float);
      localJSONObject.put("rotate", this.jdField_a_of_type_Bijq.jdField_b_of_type_Float);
      localJSONObject.put("translateX", this.jdField_a_of_type_Bijq.c);
      localJSONObject.put("translateY", this.jdField_a_of_type_Bijq.d);
      localJSONObject.put("width", this.jdField_a_of_type_Bijq.e);
      localJSONObject.put("height", this.jdField_a_of_type_Bijq.f);
      localJSONObject.put("textLeft", this.jdField_a_of_type_Float);
      localJSONObject.put("saveScaleValue", this.jdField_b_of_type_Float);
      localJSONObject.put("saveRotateValue", this.c);
      localJSONObject.put("saveTranslateX", this.d);
      localJSONObject.put("saveTranslateY", this.e);
      localJSONObject.put("distanceX", this.f);
      localJSONObject.put("distanceY", this.g);
      localJSONObject.put("dScale", this.h);
      localJSONObject.put("dRotate", this.i);
      return localJSONObject;
    }
    catch (Exception localException) {}
    return null;
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
      paramParcel.writeFloat(this.jdField_a_of_type_Bijq.jdField_a_of_type_AndroidGraphicsPointF.x);
      paramParcel.writeFloat(this.jdField_a_of_type_Bijq.jdField_a_of_type_AndroidGraphicsPointF.y);
      paramParcel.writeFloat(this.jdField_a_of_type_Bijq.jdField_a_of_type_Float);
      paramParcel.writeFloat(this.jdField_a_of_type_Bijq.jdField_b_of_type_Float);
      paramParcel.writeFloat(this.jdField_a_of_type_Bijq.c);
      paramParcel.writeFloat(this.jdField_a_of_type_Bijq.d);
      paramParcel.writeFloat(this.jdField_a_of_type_Bijq.e);
      paramParcel.writeFloat(this.jdField_a_of_type_Bijq.f);
      paramParcel.writeFloat(this.jdField_a_of_type_Float);
      paramParcel.writeFloat(this.jdField_b_of_type_Float);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.TextParcelData
 * JD-Core Version:    0.7.0.1
 */