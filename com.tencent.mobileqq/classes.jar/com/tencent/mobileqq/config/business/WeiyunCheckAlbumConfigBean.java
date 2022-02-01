package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiyunCheckAlbumConfigBean
{
  private int jdField_a_of_type_Int = -1;
  private String jdField_a_of_type_JavaLangString = "";
  private boolean jdField_a_of_type_Boolean = false;
  private int jdField_b_of_type_Int = -1;
  private String jdField_b_of_type_JavaLangString = "";
  private int jdField_c_of_type_Int = -1;
  private String jdField_c_of_type_JavaLangString = "";
  private int jdField_d_of_type_Int = -1;
  private String jdField_d_of_type_JavaLangString = "";
  private String e = "";
  
  public static WeiyunCheckAlbumConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      WeiyunCheckAlbumConfigBean localWeiyunCheckAlbumConfigBean = new WeiyunCheckAlbumConfigBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].jdField_a_of_type_JavaLangString);
        localWeiyunCheckAlbumConfigBean.jdField_a_of_type_Int = paramArrayOfQConfItem.getInt("check_day");
        localWeiyunCheckAlbumConfigBean.jdField_b_of_type_Int = paramArrayOfQConfItem.getInt("check_time");
        localWeiyunCheckAlbumConfigBean.jdField_c_of_type_Int = paramArrayOfQConfItem.getInt("album_days");
        localWeiyunCheckAlbumConfigBean.jdField_d_of_type_Int = paramArrayOfQConfItem.getInt("photos_limit");
        localWeiyunCheckAlbumConfigBean.jdField_a_of_type_JavaLangString = paramArrayOfQConfItem.getString("tips");
        localWeiyunCheckAlbumConfigBean.jdField_b_of_type_JavaLangString = paramArrayOfQConfItem.getString("jump_text");
        localWeiyunCheckAlbumConfigBean.jdField_c_of_type_JavaLangString = paramArrayOfQConfItem.getString("t_show");
        localWeiyunCheckAlbumConfigBean.jdField_d_of_type_JavaLangString = paramArrayOfQConfItem.getString("t_click");
        localWeiyunCheckAlbumConfigBean.e = paramArrayOfQConfItem.getString("t_close");
        localWeiyunCheckAlbumConfigBean.jdField_a_of_type_Boolean = true;
        return localWeiyunCheckAlbumConfigBean;
      }
      catch (JSONException paramArrayOfQConfItem)
      {
        QLog.e("WeiyunCheckAlbumConfigBean", 1, "wy check album config parse failed", paramArrayOfQConfItem);
        return localWeiyunCheckAlbumConfigBean;
      }
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WeiyunCheckAlbumConfigBean
 * JD-Core Version:    0.7.0.1
 */