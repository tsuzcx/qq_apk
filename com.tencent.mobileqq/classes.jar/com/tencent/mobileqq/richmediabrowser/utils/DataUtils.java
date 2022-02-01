package com.tencent.mobileqq.richmediabrowser.utils;

import com.tencent.mobileqq.activity.aio.photo.AIOFilePicData;
import com.tencent.mobileqq.activity.aio.photo.AIOImageData;
import com.tencent.mobileqq.activity.aio.photo.AIORichMediaData;
import com.tencent.mobileqq.activity.aio.photo.AIOShortVideoData;
import com.tencent.mobileqq.richmediabrowser.AIOBrowserBaseData;
import com.tencent.mobileqq.richmediabrowser.model.AIOFilePictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOPictureData;
import com.tencent.mobileqq.richmediabrowser.model.AIOVideoData;
import java.util.ArrayList;
import java.util.List;

public class DataUtils
{
  public static AIOFilePicData a(AIOFilePictureData paramAIOFilePictureData)
  {
    AIOFilePicData localAIOFilePicData = new AIOFilePicData();
    localAIOFilePicData.jdField_f_of_type_Long = paramAIOFilePictureData.jdField_a_of_type_Long;
    localAIOFilePicData.jdField_f_of_type_Int = paramAIOFilePictureData.jdField_a_of_type_Int;
    localAIOFilePicData.jdField_g_of_type_Long = paramAIOFilePictureData.jdField_b_of_type_Long;
    localAIOFilePicData.jdField_h_of_type_Long = paramAIOFilePictureData.jdField_c_of_type_Long;
    localAIOFilePicData.jdField_i_of_type_Long = paramAIOFilePictureData.jdField_d_of_type_Long;
    localAIOFilePicData.jdField_g_of_type_Int = paramAIOFilePictureData.jdField_b_of_type_Int;
    localAIOFilePicData.jdField_k_of_type_Boolean = paramAIOFilePictureData.jdField_a_of_type_Boolean;
    localAIOFilePicData.jdField_a_of_type_JavaLangString = paramAIOFilePictureData.jdField_a_of_type_JavaLangString;
    localAIOFilePicData.jdField_a_of_type_Int = paramAIOFilePictureData.jdField_c_of_type_Int;
    localAIOFilePicData.jdField_b_of_type_JavaLangString = paramAIOFilePictureData.jdField_b_of_type_JavaLangString;
    localAIOFilePicData.jdField_c_of_type_JavaLangString = paramAIOFilePictureData.jdField_c_of_type_JavaLangString;
    localAIOFilePicData.jdField_d_of_type_JavaLangString = paramAIOFilePictureData.jdField_d_of_type_JavaLangString;
    localAIOFilePicData.jdField_e_of_type_JavaLangString = paramAIOFilePictureData.jdField_e_of_type_JavaLangString;
    localAIOFilePicData.jdField_f_of_type_JavaLangString = paramAIOFilePictureData.jdField_f_of_type_JavaLangString;
    localAIOFilePicData.jdField_b_of_type_Int = paramAIOFilePictureData.jdField_d_of_type_Int;
    localAIOFilePicData.jdField_g_of_type_JavaLangString = paramAIOFilePictureData.jdField_g_of_type_JavaLangString;
    localAIOFilePicData.jdField_d_of_type_Boolean = paramAIOFilePictureData.jdField_g_of_type_Boolean;
    localAIOFilePicData.jdField_a_of_type_Long = paramAIOFilePictureData.jdField_e_of_type_Long;
    localAIOFilePicData.jdField_b_of_type_Long = paramAIOFilePictureData.jdField_f_of_type_Long;
    localAIOFilePicData.jdField_e_of_type_Boolean = paramAIOFilePictureData.jdField_h_of_type_Boolean;
    localAIOFilePicData.jdField_h_of_type_JavaLangString = paramAIOFilePictureData.jdField_h_of_type_JavaLangString;
    localAIOFilePicData.jdField_i_of_type_JavaLangString = paramAIOFilePictureData.jdField_i_of_type_JavaLangString;
    return localAIOFilePicData;
  }
  
  public static com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData a(com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData paramAIOFileVideoData)
  {
    com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData localAIOFileVideoData = new com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData();
    localAIOFileVideoData.jdField_f_of_type_Long = paramAIOFileVideoData.jdField_a_of_type_Long;
    localAIOFileVideoData.jdField_f_of_type_Int = paramAIOFileVideoData.jdField_a_of_type_Int;
    localAIOFileVideoData.jdField_g_of_type_Long = paramAIOFileVideoData.jdField_b_of_type_Long;
    localAIOFileVideoData.jdField_h_of_type_Long = paramAIOFileVideoData.jdField_c_of_type_Long;
    localAIOFileVideoData.jdField_i_of_type_Long = paramAIOFileVideoData.jdField_d_of_type_Long;
    localAIOFileVideoData.jdField_g_of_type_Int = paramAIOFileVideoData.jdField_b_of_type_Int;
    localAIOFileVideoData.jdField_k_of_type_Boolean = paramAIOFileVideoData.jdField_a_of_type_Boolean;
    localAIOFileVideoData.jdField_b_of_type_JavaLangString = paramAIOFileVideoData.jdField_b_of_type_JavaLangString;
    localAIOFileVideoData.jdField_a_of_type_JavaLangString = paramAIOFileVideoData.jdField_a_of_type_JavaLangString;
    localAIOFileVideoData.jdField_c_of_type_JavaLangString = paramAIOFileVideoData.jdField_c_of_type_JavaLangString;
    localAIOFileVideoData.jdField_a_of_type_Long = paramAIOFileVideoData.jdField_e_of_type_Long;
    localAIOFileVideoData.jdField_a_of_type_Int = paramAIOFileVideoData.jdField_c_of_type_Int;
    localAIOFileVideoData.jdField_b_of_type_Int = paramAIOFileVideoData.jdField_d_of_type_Int;
    return localAIOFileVideoData;
  }
  
  public static AIOImageData a(AIOPictureData paramAIOPictureData)
  {
    AIOImageData localAIOImageData = new AIOImageData();
    localAIOImageData.jdField_f_of_type_Long = paramAIOPictureData.jdField_a_of_type_Long;
    localAIOImageData.jdField_f_of_type_Int = paramAIOPictureData.jdField_a_of_type_Int;
    localAIOImageData.jdField_g_of_type_Long = paramAIOPictureData.jdField_b_of_type_Long;
    localAIOImageData.jdField_h_of_type_Long = paramAIOPictureData.jdField_c_of_type_Long;
    localAIOImageData.jdField_i_of_type_Long = paramAIOPictureData.jdField_d_of_type_Long;
    localAIOImageData.jdField_g_of_type_Int = paramAIOPictureData.jdField_b_of_type_Int;
    localAIOImageData.jdField_k_of_type_Boolean = paramAIOPictureData.jdField_a_of_type_Boolean;
    localAIOImageData.jdField_a_of_type_JavaLangString = paramAIOPictureData.jdField_a_of_type_JavaLangString;
    localAIOImageData.jdField_b_of_type_JavaLangString = paramAIOPictureData.jdField_b_of_type_JavaLangString;
    localAIOImageData.jdField_c_of_type_JavaLangString = paramAIOPictureData.jdField_c_of_type_JavaLangString;
    localAIOImageData.jdField_d_of_type_JavaLangString = paramAIOPictureData.jdField_d_of_type_JavaLangString;
    localAIOImageData.jdField_e_of_type_JavaLangString = paramAIOPictureData.jdField_e_of_type_JavaLangString;
    localAIOImageData.jdField_c_of_type_Long = paramAIOPictureData.jdField_g_of_type_Long;
    localAIOImageData.jdField_d_of_type_Long = paramAIOPictureData.jdField_h_of_type_Long;
    localAIOImageData.jdField_a_of_type_Long = paramAIOPictureData.jdField_e_of_type_Long;
    localAIOImageData.jdField_b_of_type_Long = paramAIOPictureData.jdField_f_of_type_Long;
    localAIOImageData.jdField_d_of_type_Boolean = paramAIOPictureData.jdField_g_of_type_Boolean;
    localAIOImageData.jdField_e_of_type_Boolean = paramAIOPictureData.jdField_h_of_type_Boolean;
    localAIOImageData.jdField_f_of_type_Boolean = paramAIOPictureData.jdField_i_of_type_Boolean;
    localAIOImageData.jdField_a_of_type_Int = paramAIOPictureData.jdField_c_of_type_Int;
    localAIOImageData.jdField_b_of_type_Int = paramAIOPictureData.jdField_d_of_type_Int;
    localAIOImageData.jdField_a_of_type_JavaLangObject = paramAIOPictureData.jdField_a_of_type_JavaLangObject;
    localAIOImageData.jdField_g_of_type_Boolean = paramAIOPictureData.jdField_j_of_type_Boolean;
    localAIOImageData.jdField_e_of_type_Long = paramAIOPictureData.jdField_i_of_type_Long;
    localAIOImageData.jdField_g_of_type_JavaLangString = paramAIOPictureData.jdField_g_of_type_JavaLangString;
    localAIOImageData.jdField_h_of_type_JavaLangString = paramAIOPictureData.jdField_h_of_type_JavaLangString;
    localAIOImageData.jdField_c_of_type_Int = paramAIOPictureData.jdField_e_of_type_Int;
    localAIOImageData.jdField_d_of_type_Int = paramAIOPictureData.jdField_f_of_type_Int;
    localAIOImageData.jdField_i_of_type_JavaLangString = paramAIOPictureData.jdField_i_of_type_JavaLangString;
    localAIOImageData.jdField_f_of_type_JavaLangString = paramAIOPictureData.jdField_f_of_type_JavaLangString;
    localAIOImageData.jdField_j_of_type_JavaLangString = paramAIOPictureData.jdField_j_of_type_JavaLangString;
    localAIOImageData.jdField_k_of_type_JavaLangString = paramAIOPictureData.jdField_k_of_type_JavaLangString;
    localAIOImageData.jdField_h_of_type_Boolean = paramAIOPictureData.jdField_k_of_type_Boolean;
    localAIOImageData.jdField_e_of_type_Int = paramAIOPictureData.jdField_g_of_type_Int;
    localAIOImageData.jdField_i_of_type_Boolean = paramAIOPictureData.jdField_l_of_type_Boolean;
    localAIOImageData.jdField_l_of_type_JavaLangString = paramAIOPictureData.jdField_l_of_type_JavaLangString;
    localAIOImageData.jdField_j_of_type_Boolean = paramAIOPictureData.jdField_m_of_type_Boolean;
    localAIOImageData.jdField_m_of_type_JavaLangString = paramAIOPictureData.jdField_m_of_type_JavaLangString;
    localAIOImageData.n = paramAIOPictureData.n;
    localAIOImageData.o = paramAIOPictureData.o;
    localAIOImageData.p = paramAIOPictureData.p;
    return localAIOImageData;
  }
  
  public static AIORichMediaData a(AIOBrowserBaseData paramAIOBrowserBaseData)
  {
    if (paramAIOBrowserBaseData == null) {}
    do
    {
      return null;
      if ((paramAIOBrowserBaseData instanceof AIOPictureData)) {
        return a((AIOPictureData)paramAIOBrowserBaseData);
      }
      if ((paramAIOBrowserBaseData instanceof AIOFilePictureData)) {
        return a((AIOFilePictureData)paramAIOBrowserBaseData);
      }
      if ((paramAIOBrowserBaseData instanceof AIOVideoData)) {
        return a((AIOVideoData)paramAIOBrowserBaseData);
      }
    } while (!(paramAIOBrowserBaseData instanceof com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData));
    return a((com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData)paramAIOBrowserBaseData);
  }
  
  public static AIOShortVideoData a(AIOVideoData paramAIOVideoData)
  {
    AIOShortVideoData localAIOShortVideoData = new AIOShortVideoData();
    localAIOShortVideoData.jdField_f_of_type_Long = paramAIOVideoData.jdField_a_of_type_Long;
    localAIOShortVideoData.jdField_f_of_type_Int = paramAIOVideoData.jdField_a_of_type_Int;
    localAIOShortVideoData.jdField_g_of_type_Long = paramAIOVideoData.jdField_b_of_type_Long;
    localAIOShortVideoData.jdField_h_of_type_Long = paramAIOVideoData.jdField_c_of_type_Long;
    localAIOShortVideoData.jdField_i_of_type_Long = paramAIOVideoData.jdField_d_of_type_Long;
    localAIOShortVideoData.jdField_g_of_type_Int = paramAIOVideoData.jdField_b_of_type_Int;
    localAIOShortVideoData.jdField_k_of_type_Boolean = paramAIOVideoData.jdField_a_of_type_Boolean;
    localAIOShortVideoData.jdField_a_of_type_JavaLangString = paramAIOVideoData.jdField_a_of_type_JavaLangString;
    localAIOShortVideoData.jdField_b_of_type_JavaLangString = paramAIOVideoData.jdField_b_of_type_JavaLangString;
    localAIOShortVideoData.jdField_a_of_type_Int = paramAIOVideoData.jdField_c_of_type_Int;
    localAIOShortVideoData.jdField_b_of_type_Int = paramAIOVideoData.jdField_d_of_type_Int;
    localAIOShortVideoData.jdField_c_of_type_Int = paramAIOVideoData.jdField_e_of_type_Int;
    localAIOShortVideoData.jdField_d_of_type_Int = paramAIOVideoData.jdField_f_of_type_Int;
    localAIOShortVideoData.jdField_a_of_type_Long = paramAIOVideoData.jdField_e_of_type_Long;
    localAIOShortVideoData.jdField_e_of_type_Int = paramAIOVideoData.jdField_g_of_type_Int;
    localAIOShortVideoData.jdField_c_of_type_JavaLangString = paramAIOVideoData.jdField_c_of_type_JavaLangString;
    localAIOShortVideoData.jdField_d_of_type_JavaLangString = paramAIOVideoData.jdField_d_of_type_JavaLangString;
    localAIOShortVideoData.jdField_h_of_type_Int = paramAIOVideoData.jdField_h_of_type_Int;
    localAIOShortVideoData.jdField_e_of_type_JavaLangString = paramAIOVideoData.jdField_e_of_type_JavaLangString;
    localAIOShortVideoData.jdField_i_of_type_Int = paramAIOVideoData.jdField_i_of_type_Int;
    localAIOShortVideoData.jdField_k_of_type_Int = paramAIOVideoData.jdField_k_of_type_Int;
    localAIOShortVideoData.j = paramAIOVideoData.j;
    localAIOShortVideoData.jdField_f_of_type_JavaLangString = paramAIOVideoData.jdField_g_of_type_JavaLangString;
    localAIOShortVideoData.jdField_g_of_type_JavaLangString = paramAIOVideoData.jdField_h_of_type_JavaLangString;
    return localAIOShortVideoData;
  }
  
  public static AIOBrowserBaseData a(AIORichMediaData paramAIORichMediaData)
  {
    if (paramAIORichMediaData == null) {}
    do
    {
      return null;
      if ((paramAIORichMediaData instanceof AIOImageData)) {
        return a((AIOImageData)paramAIORichMediaData);
      }
      if ((paramAIORichMediaData instanceof AIOFilePicData)) {
        return a((AIOFilePicData)paramAIORichMediaData);
      }
      if ((paramAIORichMediaData instanceof AIOShortVideoData)) {
        return a((AIOShortVideoData)paramAIORichMediaData);
      }
    } while (!(paramAIORichMediaData instanceof com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData));
    return a((com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData)paramAIORichMediaData);
  }
  
  public static AIOFilePictureData a(AIOFilePicData paramAIOFilePicData)
  {
    AIOFilePictureData localAIOFilePictureData = new AIOFilePictureData();
    localAIOFilePictureData.jdField_a_of_type_Long = paramAIOFilePicData.jdField_f_of_type_Long;
    localAIOFilePictureData.jdField_a_of_type_Int = paramAIOFilePicData.jdField_f_of_type_Int;
    localAIOFilePictureData.jdField_b_of_type_Long = paramAIOFilePicData.jdField_g_of_type_Long;
    localAIOFilePictureData.jdField_c_of_type_Long = paramAIOFilePicData.jdField_h_of_type_Long;
    localAIOFilePictureData.jdField_d_of_type_Long = paramAIOFilePicData.jdField_i_of_type_Long;
    localAIOFilePictureData.jdField_b_of_type_Int = paramAIOFilePicData.jdField_g_of_type_Int;
    localAIOFilePictureData.jdField_a_of_type_Boolean = paramAIOFilePicData.jdField_k_of_type_Boolean;
    localAIOFilePictureData.jdField_b_of_type_Boolean = paramAIOFilePicData.jdField_l_of_type_Boolean;
    localAIOFilePictureData.jdField_c_of_type_Boolean = paramAIOFilePicData.jdField_m_of_type_Boolean;
    localAIOFilePictureData.jdField_a_of_type_JavaLangString = paramAIOFilePicData.jdField_a_of_type_JavaLangString;
    localAIOFilePictureData.jdField_c_of_type_Int = paramAIOFilePicData.jdField_a_of_type_Int;
    localAIOFilePictureData.jdField_b_of_type_JavaLangString = paramAIOFilePicData.jdField_b_of_type_JavaLangString;
    localAIOFilePictureData.jdField_c_of_type_JavaLangString = paramAIOFilePicData.jdField_c_of_type_JavaLangString;
    localAIOFilePictureData.jdField_d_of_type_JavaLangString = paramAIOFilePicData.jdField_d_of_type_JavaLangString;
    localAIOFilePictureData.jdField_e_of_type_JavaLangString = paramAIOFilePicData.jdField_e_of_type_JavaLangString;
    localAIOFilePictureData.jdField_f_of_type_JavaLangString = paramAIOFilePicData.jdField_f_of_type_JavaLangString;
    localAIOFilePictureData.jdField_d_of_type_Int = paramAIOFilePicData.jdField_b_of_type_Int;
    localAIOFilePictureData.jdField_g_of_type_JavaLangString = paramAIOFilePicData.jdField_g_of_type_JavaLangString;
    localAIOFilePictureData.jdField_g_of_type_Boolean = paramAIOFilePicData.jdField_d_of_type_Boolean;
    localAIOFilePictureData.jdField_e_of_type_Long = paramAIOFilePicData.jdField_a_of_type_Long;
    localAIOFilePictureData.jdField_f_of_type_Long = paramAIOFilePicData.jdField_b_of_type_Long;
    localAIOFilePictureData.jdField_h_of_type_Boolean = paramAIOFilePicData.jdField_e_of_type_Boolean;
    localAIOFilePictureData.jdField_h_of_type_JavaLangString = paramAIOFilePicData.jdField_h_of_type_JavaLangString;
    localAIOFilePictureData.jdField_i_of_type_JavaLangString = paramAIOFilePicData.jdField_i_of_type_JavaLangString;
    localAIOFilePictureData.jdField_e_of_type_Int = paramAIOFilePicData.jdField_c_of_type_Int;
    localAIOFilePictureData.jdField_f_of_type_Int = paramAIOFilePicData.jdField_d_of_type_Int;
    localAIOFilePictureData.jdField_g_of_type_Int = paramAIOFilePicData.jdField_e_of_type_Int;
    return localAIOFilePictureData;
  }
  
  public static com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData a(com.tencent.mobileqq.activity.aio.photo.AIOFileVideoData paramAIOFileVideoData)
  {
    com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData localAIOFileVideoData = new com.tencent.mobileqq.richmediabrowser.model.AIOFileVideoData();
    localAIOFileVideoData.jdField_a_of_type_Long = paramAIOFileVideoData.jdField_f_of_type_Long;
    localAIOFileVideoData.jdField_a_of_type_Int = paramAIOFileVideoData.jdField_f_of_type_Int;
    localAIOFileVideoData.jdField_b_of_type_Long = paramAIOFileVideoData.jdField_g_of_type_Long;
    localAIOFileVideoData.jdField_c_of_type_Long = paramAIOFileVideoData.jdField_h_of_type_Long;
    localAIOFileVideoData.jdField_d_of_type_Long = paramAIOFileVideoData.jdField_i_of_type_Long;
    localAIOFileVideoData.jdField_b_of_type_Int = paramAIOFileVideoData.jdField_g_of_type_Int;
    localAIOFileVideoData.jdField_a_of_type_Boolean = paramAIOFileVideoData.jdField_k_of_type_Boolean;
    localAIOFileVideoData.jdField_b_of_type_Boolean = paramAIOFileVideoData.jdField_l_of_type_Boolean;
    localAIOFileVideoData.jdField_c_of_type_Boolean = paramAIOFileVideoData.jdField_m_of_type_Boolean;
    localAIOFileVideoData.jdField_b_of_type_JavaLangString = paramAIOFileVideoData.jdField_b_of_type_JavaLangString;
    localAIOFileVideoData.jdField_a_of_type_JavaLangString = paramAIOFileVideoData.jdField_a_of_type_JavaLangString;
    localAIOFileVideoData.jdField_c_of_type_JavaLangString = paramAIOFileVideoData.jdField_c_of_type_JavaLangString;
    localAIOFileVideoData.jdField_e_of_type_Long = paramAIOFileVideoData.jdField_a_of_type_Long;
    localAIOFileVideoData.jdField_c_of_type_Int = paramAIOFileVideoData.jdField_a_of_type_Int;
    localAIOFileVideoData.jdField_d_of_type_Int = paramAIOFileVideoData.jdField_b_of_type_Int;
    localAIOFileVideoData.jdField_f_of_type_Boolean = paramAIOFileVideoData.jdField_c_of_type_Boolean;
    localAIOFileVideoData.jdField_g_of_type_JavaLangString = paramAIOFileVideoData.jdField_h_of_type_JavaLangString;
    localAIOFileVideoData.jdField_e_of_type_Int = paramAIOFileVideoData.jdField_c_of_type_Int;
    localAIOFileVideoData.jdField_f_of_type_Int = paramAIOFileVideoData.jdField_d_of_type_Int;
    localAIOFileVideoData.jdField_h_of_type_JavaLangString = paramAIOFileVideoData.jdField_i_of_type_JavaLangString;
    localAIOFileVideoData.jdField_i_of_type_JavaLangString = paramAIOFileVideoData.jdField_j_of_type_JavaLangString;
    return localAIOFileVideoData;
  }
  
  public static AIOPictureData a(AIOImageData paramAIOImageData)
  {
    AIOPictureData localAIOPictureData = new AIOPictureData();
    localAIOPictureData.jdField_a_of_type_Long = paramAIOImageData.jdField_f_of_type_Long;
    localAIOPictureData.jdField_a_of_type_Int = paramAIOImageData.jdField_f_of_type_Int;
    localAIOPictureData.jdField_b_of_type_Long = paramAIOImageData.jdField_g_of_type_Long;
    localAIOPictureData.jdField_c_of_type_Long = paramAIOImageData.jdField_h_of_type_Long;
    localAIOPictureData.jdField_d_of_type_Long = paramAIOImageData.jdField_i_of_type_Long;
    localAIOPictureData.jdField_b_of_type_Int = paramAIOImageData.jdField_g_of_type_Int;
    localAIOPictureData.jdField_a_of_type_Boolean = paramAIOImageData.jdField_k_of_type_Boolean;
    localAIOPictureData.jdField_b_of_type_Boolean = paramAIOImageData.jdField_l_of_type_Boolean;
    localAIOPictureData.jdField_c_of_type_Boolean = paramAIOImageData.jdField_m_of_type_Boolean;
    localAIOPictureData.jdField_a_of_type_JavaLangString = paramAIOImageData.jdField_a_of_type_JavaLangString;
    localAIOPictureData.jdField_b_of_type_JavaLangString = paramAIOImageData.jdField_b_of_type_JavaLangString;
    localAIOPictureData.jdField_c_of_type_JavaLangString = paramAIOImageData.jdField_c_of_type_JavaLangString;
    localAIOPictureData.jdField_d_of_type_JavaLangString = paramAIOImageData.jdField_d_of_type_JavaLangString;
    localAIOPictureData.jdField_e_of_type_JavaLangString = paramAIOImageData.jdField_e_of_type_JavaLangString;
    localAIOPictureData.jdField_g_of_type_Long = paramAIOImageData.jdField_c_of_type_Long;
    localAIOPictureData.jdField_h_of_type_Long = paramAIOImageData.jdField_d_of_type_Long;
    localAIOPictureData.jdField_e_of_type_Long = paramAIOImageData.jdField_a_of_type_Long;
    localAIOPictureData.jdField_f_of_type_Long = paramAIOImageData.jdField_b_of_type_Long;
    localAIOPictureData.jdField_g_of_type_Boolean = paramAIOImageData.jdField_d_of_type_Boolean;
    localAIOPictureData.jdField_h_of_type_Boolean = paramAIOImageData.jdField_e_of_type_Boolean;
    localAIOPictureData.jdField_i_of_type_Boolean = paramAIOImageData.jdField_f_of_type_Boolean;
    localAIOPictureData.jdField_c_of_type_Int = paramAIOImageData.jdField_a_of_type_Int;
    localAIOPictureData.jdField_d_of_type_Int = paramAIOImageData.jdField_b_of_type_Int;
    localAIOPictureData.jdField_a_of_type_JavaLangObject = paramAIOImageData.jdField_a_of_type_JavaLangObject;
    localAIOPictureData.jdField_j_of_type_Boolean = paramAIOImageData.jdField_g_of_type_Boolean;
    localAIOPictureData.jdField_i_of_type_Long = paramAIOImageData.jdField_e_of_type_Long;
    localAIOPictureData.jdField_g_of_type_JavaLangString = paramAIOImageData.jdField_g_of_type_JavaLangString;
    localAIOPictureData.jdField_h_of_type_JavaLangString = paramAIOImageData.jdField_h_of_type_JavaLangString;
    localAIOPictureData.jdField_e_of_type_Int = paramAIOImageData.jdField_c_of_type_Int;
    localAIOPictureData.jdField_f_of_type_Int = paramAIOImageData.jdField_d_of_type_Int;
    localAIOPictureData.jdField_i_of_type_JavaLangString = paramAIOImageData.jdField_i_of_type_JavaLangString;
    localAIOPictureData.jdField_f_of_type_JavaLangString = paramAIOImageData.jdField_f_of_type_JavaLangString;
    localAIOPictureData.jdField_j_of_type_JavaLangString = paramAIOImageData.jdField_j_of_type_JavaLangString;
    localAIOPictureData.jdField_k_of_type_JavaLangString = paramAIOImageData.jdField_k_of_type_JavaLangString;
    localAIOPictureData.jdField_k_of_type_Boolean = paramAIOImageData.jdField_h_of_type_Boolean;
    localAIOPictureData.jdField_g_of_type_Int = paramAIOImageData.jdField_e_of_type_Int;
    localAIOPictureData.jdField_l_of_type_Boolean = paramAIOImageData.jdField_i_of_type_Boolean;
    localAIOPictureData.jdField_l_of_type_JavaLangString = paramAIOImageData.jdField_l_of_type_JavaLangString;
    localAIOPictureData.jdField_m_of_type_Boolean = paramAIOImageData.jdField_j_of_type_Boolean;
    localAIOPictureData.jdField_m_of_type_JavaLangString = paramAIOImageData.jdField_m_of_type_JavaLangString;
    localAIOPictureData.n = paramAIOImageData.n;
    localAIOPictureData.o = paramAIOImageData.o;
    localAIOPictureData.p = paramAIOImageData.p;
    return localAIOPictureData;
  }
  
  public static AIOVideoData a(AIOShortVideoData paramAIOShortVideoData)
  {
    AIOVideoData localAIOVideoData = new AIOVideoData();
    localAIOVideoData.jdField_a_of_type_Long = paramAIOShortVideoData.jdField_f_of_type_Long;
    localAIOVideoData.jdField_a_of_type_Int = paramAIOShortVideoData.jdField_f_of_type_Int;
    localAIOVideoData.jdField_b_of_type_Long = paramAIOShortVideoData.jdField_g_of_type_Long;
    localAIOVideoData.jdField_c_of_type_Long = paramAIOShortVideoData.jdField_h_of_type_Long;
    localAIOVideoData.jdField_d_of_type_Long = paramAIOShortVideoData.jdField_i_of_type_Long;
    localAIOVideoData.jdField_b_of_type_Int = paramAIOShortVideoData.jdField_g_of_type_Int;
    localAIOVideoData.jdField_a_of_type_Boolean = paramAIOShortVideoData.jdField_k_of_type_Boolean;
    localAIOVideoData.jdField_b_of_type_Boolean = paramAIOShortVideoData.jdField_l_of_type_Boolean;
    localAIOVideoData.jdField_c_of_type_Boolean = paramAIOShortVideoData.jdField_m_of_type_Boolean;
    localAIOVideoData.jdField_a_of_type_JavaLangString = paramAIOShortVideoData.jdField_a_of_type_JavaLangString;
    localAIOVideoData.jdField_b_of_type_JavaLangString = paramAIOShortVideoData.jdField_b_of_type_JavaLangString;
    localAIOVideoData.jdField_c_of_type_Int = paramAIOShortVideoData.jdField_a_of_type_Int;
    localAIOVideoData.jdField_d_of_type_Int = paramAIOShortVideoData.jdField_b_of_type_Int;
    localAIOVideoData.jdField_e_of_type_Int = paramAIOShortVideoData.jdField_c_of_type_Int;
    localAIOVideoData.jdField_f_of_type_Int = paramAIOShortVideoData.jdField_d_of_type_Int;
    localAIOVideoData.jdField_e_of_type_Long = paramAIOShortVideoData.jdField_a_of_type_Long;
    localAIOVideoData.jdField_g_of_type_Int = paramAIOShortVideoData.jdField_e_of_type_Int;
    localAIOVideoData.jdField_c_of_type_JavaLangString = paramAIOShortVideoData.jdField_c_of_type_JavaLangString;
    localAIOVideoData.jdField_d_of_type_JavaLangString = paramAIOShortVideoData.jdField_d_of_type_JavaLangString;
    localAIOVideoData.jdField_h_of_type_Int = paramAIOShortVideoData.jdField_h_of_type_Int;
    localAIOVideoData.jdField_e_of_type_JavaLangString = paramAIOShortVideoData.jdField_e_of_type_JavaLangString;
    localAIOVideoData.jdField_i_of_type_Int = paramAIOShortVideoData.jdField_i_of_type_Int;
    localAIOVideoData.jdField_k_of_type_Int = paramAIOShortVideoData.jdField_k_of_type_Int;
    localAIOVideoData.j = paramAIOShortVideoData.j;
    localAIOVideoData.jdField_g_of_type_JavaLangString = paramAIOShortVideoData.jdField_f_of_type_JavaLangString;
    localAIOVideoData.jdField_h_of_type_JavaLangString = paramAIOShortVideoData.jdField_g_of_type_JavaLangString;
    return localAIOVideoData;
  }
  
  public static AIOBrowserBaseData[] a(AIORichMediaData[] paramArrayOfAIORichMediaData)
  {
    if (paramArrayOfAIORichMediaData == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfAIORichMediaData.length)
    {
      AIOBrowserBaseData localAIOBrowserBaseData = a(paramArrayOfAIORichMediaData[i]);
      if (localAIOBrowserBaseData != null) {
        localArrayList.add(localAIOBrowserBaseData);
      }
      i += 1;
    }
    if (localArrayList.size() > 0) {
      return (AIOBrowserBaseData[])localArrayList.toArray(new AIOBrowserBaseData[localArrayList.size()]);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.richmediabrowser.utils.DataUtils
 * JD-Core Version:    0.7.0.1
 */