package dov.com.qq.im.capture.text;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import blxf;
import blyg;
import blyy;
import bmqw;
import bmqy;
import bmqz;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class TextParcelData
  implements Parcelable
{
  public static final Parcelable.Creator<TextParcelData> CREATOR = new blyy();
  private float jdField_a_of_type_Float;
  private bmqy jdField_a_of_type_Bmqy;
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
    Object localObject = new blxf();
    int j = paramParcel.readInt();
    DynamicTextItem.TextMap localTextMap = (DynamicTextItem.TextMap)paramParcel.readParcelable(DynamicTextItem.TextMap.class.getClassLoader());
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = ((blxf)localObject).a(j, localTextMap.a());
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null)
    {
      QLog.e("TextParcelData", 1, "read mDynamicTextItem from Parcel return null, use normal text instead");
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = new blyg(j, localTextMap.a());
    }
    localObject = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((DynamicTextItem)localObject).a(bool);
      this.jdField_a_of_type_Bmqy = new bmqy(paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat());
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
  
  public TextParcelData(bmqz parambmqz)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = parambmqz.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    this.jdField_a_of_type_Bmqy = new bmqy(parambmqz.jdField_b_of_type_AndroidGraphicsPointF.x, parambmqz.jdField_b_of_type_AndroidGraphicsPointF.y, parambmqz.q, parambmqz.r, parambmqz.s, parambmqz.t, parambmqz.u, parambmqz.v);
    this.jdField_a_of_type_Float = parambmqz.jdField_a_of_type_Float;
    this.jdField_b_of_type_Float = parambmqz.jdField_b_of_type_Float;
    this.c = parambmqz.c;
    this.d = parambmqz.d;
    this.e = parambmqz.e;
    this.f = parambmqz.f;
    this.g = parambmqz.g;
    this.h = parambmqz.h;
    this.i = parambmqz.i;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(parambmqz.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
  }
  
  public bmqz a(bmqw parambmqw)
  {
    parambmqw.getClass();
    parambmqw = new bmqz(parambmqw, this.jdField_a_of_type_Bmqy);
    parambmqw.q = this.jdField_a_of_type_Bmqy.jdField_a_of_type_Float;
    parambmqw.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    parambmqw.u = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
    parambmqw.v = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
    parambmqw.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    parambmqw.jdField_b_of_type_Float = this.jdField_b_of_type_Float;
    parambmqw.c = this.c;
    parambmqw.d = this.d;
    parambmqw.e = this.e;
    parambmqw.f = this.f;
    parambmqw.g = this.g;
    parambmqw.h = this.h;
    parambmqw.i = this.i;
    parambmqw.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.set(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
    return parambmqw;
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
      localJSONObject.put("centerPx", this.jdField_a_of_type_Bmqy.jdField_a_of_type_AndroidGraphicsPointF.x);
      localJSONObject.put("centerPy", this.jdField_a_of_type_Bmqy.jdField_a_of_type_AndroidGraphicsPointF.y);
      localJSONObject.put("scale", this.jdField_a_of_type_Bmqy.jdField_a_of_type_Float);
      localJSONObject.put("rotate", this.jdField_a_of_type_Bmqy.jdField_b_of_type_Float);
      localJSONObject.put("translateX", this.jdField_a_of_type_Bmqy.c);
      localJSONObject.put("translateY", this.jdField_a_of_type_Bmqy.d);
      localJSONObject.put("width", this.jdField_a_of_type_Bmqy.e);
      localJSONObject.put("height", this.jdField_a_of_type_Bmqy.f);
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
      paramParcel.writeFloat(this.jdField_a_of_type_Bmqy.jdField_a_of_type_AndroidGraphicsPointF.x);
      paramParcel.writeFloat(this.jdField_a_of_type_Bmqy.jdField_a_of_type_AndroidGraphicsPointF.y);
      paramParcel.writeFloat(this.jdField_a_of_type_Bmqy.jdField_a_of_type_Float);
      paramParcel.writeFloat(this.jdField_a_of_type_Bmqy.jdField_b_of_type_Float);
      paramParcel.writeFloat(this.jdField_a_of_type_Bmqy.c);
      paramParcel.writeFloat(this.jdField_a_of_type_Bmqy.d);
      paramParcel.writeFloat(this.jdField_a_of_type_Bmqy.e);
      paramParcel.writeFloat(this.jdField_a_of_type_Bmqy.f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     dov.com.qq.im.capture.text.TextParcelData
 * JD-Core Version:    0.7.0.1
 */