package com.tencent.mobileqq.richmedia.capture.view;

import com.tencent.mobileqq.richmedia.capture.data.CapturePtvTemplateManager;
import dov.com.qq.im.QIMEffectCameraCaptureUnit;
import dov.com.qq.im.capture.QIMManager;
import dov.com.tencent.mobileqq.shortvideo.QIMPtvTemplateManager;

public class CommonPatternInfo
{
  int jdField_a_of_type_Int;
  String jdField_a_of_type_JavaLangString;
  boolean jdField_a_of_type_Boolean;
  public int b;
  public String b;
  public boolean b;
  public String c;
  public boolean c;
  public String d;
  public String e;
  public String f;
  public String g;
  
  public static CommonPatternInfo a(EffectsCameraCaptureView.EffectListener paramEffectListener)
  {
    CommonPatternInfo localCommonPatternInfo;
    if ((paramEffectListener instanceof QIMEffectCameraCaptureUnit))
    {
      paramEffectListener = (QIMPtvTemplateManager)QIMManager.a(3);
      if (paramEffectListener != null)
      {
        paramEffectListener = paramEffectListener.a();
        if (paramEffectListener != null)
        {
          localCommonPatternInfo = new CommonPatternInfo();
          localCommonPatternInfo.e = QIMPtvTemplateManager.jdField_a_of_type_JavaLangString;
          localCommonPatternInfo.jdField_a_of_type_Boolean = paramEffectListener.usable;
          localCommonPatternInfo.jdField_a_of_type_Int = paramEffectListener.kind;
          localCommonPatternInfo.jdField_a_of_type_JavaLangString = paramEffectListener.id;
          localCommonPatternInfo.jdField_b_of_type_JavaLangString = paramEffectListener.name;
          localCommonPatternInfo.jdField_c_of_type_JavaLangString = paramEffectListener.dgStageName;
          localCommonPatternInfo.d = paramEffectListener.dgModelName;
          localCommonPatternInfo.jdField_b_of_type_Boolean = paramEffectListener.hasFace();
          localCommonPatternInfo.jdField_c_of_type_Boolean = paramEffectListener.hasGesture();
          localCommonPatternInfo.jdField_b_of_type_Int = paramEffectListener.category;
          localCommonPatternInfo.f = paramEffectListener.gestureType;
          localCommonPatternInfo.g = paramEffectListener.gestureWording;
          return localCommonPatternInfo;
        }
      }
    }
    else
    {
      paramEffectListener = CapturePtvTemplateManager.a().a();
      if (paramEffectListener != null)
      {
        localCommonPatternInfo = new CommonPatternInfo();
        localCommonPatternInfo.e = CapturePtvTemplateManager.jdField_a_of_type_JavaLangString;
        localCommonPatternInfo.jdField_a_of_type_Boolean = paramEffectListener.usable;
        localCommonPatternInfo.jdField_a_of_type_Int = paramEffectListener.kind;
        localCommonPatternInfo.jdField_a_of_type_JavaLangString = paramEffectListener.id;
        localCommonPatternInfo.jdField_b_of_type_JavaLangString = paramEffectListener.name;
        localCommonPatternInfo.jdField_c_of_type_JavaLangString = paramEffectListener.dgStageName;
        localCommonPatternInfo.d = paramEffectListener.dgModelName;
        localCommonPatternInfo.jdField_b_of_type_Boolean = paramEffectListener.hasFace();
        localCommonPatternInfo.jdField_c_of_type_Boolean = paramEffectListener.hasGesture();
        localCommonPatternInfo.jdField_b_of_type_Int = paramEffectListener.category;
        localCommonPatternInfo.f = paramEffectListener.gestureType;
        localCommonPatternInfo.g = paramEffectListener.gestureWording;
        return localCommonPatternInfo;
      }
      return null;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes3.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.view.CommonPatternInfo
 * JD-Core Version:    0.7.0.1
 */