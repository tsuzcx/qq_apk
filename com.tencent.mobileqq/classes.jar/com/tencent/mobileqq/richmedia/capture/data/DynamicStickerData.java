package com.tencent.mobileqq.richmedia.capture.data;

import android.graphics.PointF;
import android.text.TextUtils;
import com.tencent.sveffects.SLog;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DynamicStickerData
{
  public float a;
  public int a;
  public PointF a;
  public GifDecoder a;
  public SegmentKeeper a;
  public String a;
  public Map a;
  public float b;
  public int b;
  public String b;
  public float c;
  public int c;
  public float d = 0.0F;
  public float e;
  public float f;
  
  public DynamicStickerData()
  {
    this.jdField_a_of_type_Float = 1.0F;
    this.jdField_b_of_type_Float = 0.0F;
    this.jdField_c_of_type_Float = 0.0F;
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper = new SegmentKeeper();
    this.jdField_a_of_type_JavaUtilMap = new HashMap();
  }
  
  public void a(List paramList)
  {
    this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(paramList);
  }
  
  public boolean a(long paramLong)
  {
    SLog.d("DynamicSticker", "isshow:" + paramLong);
    return this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.a(paramLong);
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("DynamicStickerData{");
    localStringBuilder.append("centerP=").append(this.jdField_a_of_type_AndroidGraphicsPointF);
    localStringBuilder.append(", scale=").append(this.jdField_a_of_type_Float);
    localStringBuilder.append(", rotate=").append(this.jdField_b_of_type_Float);
    localStringBuilder.append(", translateX=").append(this.jdField_c_of_type_Float);
    localStringBuilder.append(", translateY=").append(this.d);
    localStringBuilder.append(", width=").append(this.e);
    localStringBuilder.append(", height=").append(this.f);
    localStringBuilder.append(", layerWidth=").append(this.jdField_b_of_type_Int);
    localStringBuilder.append(", layerHeight=").append(this.jdField_c_of_type_Int);
    localStringBuilder.append(", type=").append(this.jdField_a_of_type_Int);
    localStringBuilder.append(", path='").append(this.jdField_a_of_type_JavaLangString).append('\'');
    localStringBuilder.append(", data=").append(this.jdField_b_of_type_JavaLangString);
    localStringBuilder.append(", mGifDecoder=").append(this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataGifDecoder);
    String str = this.jdField_a_of_type_ComTencentMobileqqRichmediaCaptureDataSegmentKeeper.toString();
    if (!TextUtils.isEmpty(str))
    {
      localStringBuilder.append(",");
      localStringBuilder.append(str);
    }
    for (;;)
    {
      localStringBuilder.append('}');
      return localStringBuilder.toString();
      localStringBuilder.append(",segments=null");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.data.DynamicStickerData
 * JD-Core Version:    0.7.0.1
 */