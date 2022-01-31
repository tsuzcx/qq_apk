package dov.com.qq.im.capture.text;

import android.graphics.PointF;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import anxa;
import com.tencent.mobileqq.richmedia.capture.data.SegmentKeeper;
import com.tencent.qphone.base.util.QLog;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.LayerParams;
import dov.com.tencent.biz.qqstory.takevideo.doodle.layer.TextLayer.TextItem;

public class TextParcelData
  implements Parcelable
{
  public static final Parcelable.Creator CREATOR = new anxa();
  private float jdField_a_of_type_Float;
  public SegmentKeeper a;
  private DynamicTextItem jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
  private TextLayer.LayerParams jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams;
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
    Object localObject = new DynamicTextBuilder();
    int j = paramParcel.readInt();
    DynamicTextItem.TextMap localTextMap = (DynamicTextItem.TextMap)paramParcel.readParcelable(DynamicTextItem.TextMap.class.getClassLoader());
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = ((DynamicTextBuilder)localObject).a(j, localTextMap.a());
    if (this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem == null)
    {
      QLog.e("TextParcelData", 1, "read mDynamicTextItem from Parcel return null, use normal text instead");
      this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = new NormalTextItem(j, localTextMap.a());
    }
    localObject = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    if (paramParcel.readInt() == 1) {}
    for (boolean bool = true;; bool = false)
    {
      ((DynamicTextItem)localObject).a(bool);
      this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams = new TextLayer.LayerParams(paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat(), paramParcel.readFloat());
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
  
  public TextParcelData(TextLayer.TextItem paramTextItem)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = paramTextItem.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams = new TextLayer.LayerParams(paramTextItem.jdField_a_of_type_AndroidGraphicsPointF.x, paramTextItem.jdField_a_of_type_AndroidGraphicsPointF.y, paramTextItem.q, paramTextItem.r, paramTextItem.s, paramTextItem.t, paramTextItem.u, paramTextItem.v);
    this.jdField_a_of_type_Float = paramTextItem.jdField_a_of_type_Float;
    this.b = paramTextItem.b;
    this.c = paramTextItem.c;
    this.d = paramTextItem.d;
    this.e = paramTextItem.e;
    this.f = paramTextItem.f;
    this.g = paramTextItem.g;
    this.h = paramTextItem.h;
    this.i = paramTextItem.i;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(paramTextItem.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
  }
  
  public TextLayer.TextItem a(TextLayer paramTextLayer)
  {
    paramTextLayer.getClass();
    paramTextLayer = new TextLayer.TextItem(paramTextLayer, this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams);
    paramTextLayer.q = this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams.jdField_a_of_type_Float;
    paramTextLayer.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem;
    paramTextLayer.u = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.a();
    paramTextLayer.v = this.jdField_a_of_type_DovComQqImCaptureTextDynamicTextItem.b();
    paramTextLayer.jdField_a_of_type_Float = this.jdField_a_of_type_Float;
    paramTextLayer.b = this.b;
    paramTextLayer.c = this.c;
    paramTextLayer.d = this.d;
    paramTextLayer.e = this.e;
    paramTextLayer.f = this.f;
    paramTextLayer.g = this.g;
    paramTextLayer.h = this.h;
    paramTextLayer.i = this.i;
    paramTextLayer.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper);
    return paramTextLayer;
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
      paramParcel.writeFloat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams.jdField_a_of_type_AndroidGraphicsPointF.x);
      paramParcel.writeFloat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams.jdField_a_of_type_AndroidGraphicsPointF.y);
      paramParcel.writeFloat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams.jdField_a_of_type_Float);
      paramParcel.writeFloat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams.b);
      paramParcel.writeFloat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams.c);
      paramParcel.writeFloat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams.d);
      paramParcel.writeFloat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams.e);
      paramParcel.writeFloat(this.jdField_a_of_type_DovComTencentBizQqstoryTakevideoDoodleLayerTextLayer$LayerParams.f);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes7.jar
 * Qualified Name:     dov.com.qq.im.capture.text.TextParcelData
 * JD-Core Version:    0.7.0.1
 */