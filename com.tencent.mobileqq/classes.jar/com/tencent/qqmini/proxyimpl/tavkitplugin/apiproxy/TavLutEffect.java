package com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy;

import android.graphics.Bitmap;
import com.tencent.tav.coremedia.CMTimeRange;

public class TavLutEffect
  extends BaseEffectNode
{
  private float jdField_a_of_type_Float = 1.0F;
  private Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private CMTimeRange jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  private String jdField_a_of_type_JavaLangString;
  
  public float a()
  {
    return this.jdField_a_of_type_Float;
  }
  
  public BaseEffectNode.Filter a()
  {
    return new TavLutEffect.LutEffectFilter(this);
  }
  
  public CMTimeRange a()
  {
    return this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange;
  }
  
  public String a()
  {
    return this.jdField_a_of_type_JavaLangString;
  }
  
  public void a(float paramFloat)
  {
    this.jdField_a_of_type_Float = paramFloat;
  }
  
  public void a(CMTimeRange paramCMTimeRange)
  {
    this.jdField_a_of_type_ComTencentTavCoremediaCMTimeRange = paramCMTimeRange;
  }
  
  public void a(String paramString)
  {
    this.jdField_a_of_type_JavaLangString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.qqmini.proxyimpl.tavkitplugin.apiproxy.TavLutEffect
 * JD-Core Version:    0.7.0.1
 */