package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class WeiyunCheckAlbumConfigBean
{
  private boolean a = false;
  private int b = -1;
  private int c = -1;
  private int d = -1;
  private int e = -1;
  private String f = "";
  private String g = "";
  private String h = "";
  private String i = "";
  private String j = "";
  
  public static WeiyunCheckAlbumConfigBean a(QConfItem[] paramArrayOfQConfItem)
  {
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      WeiyunCheckAlbumConfigBean localWeiyunCheckAlbumConfigBean = new WeiyunCheckAlbumConfigBean();
      try
      {
        paramArrayOfQConfItem = new JSONObject(paramArrayOfQConfItem[0].b);
        localWeiyunCheckAlbumConfigBean.b = paramArrayOfQConfItem.getInt("check_day");
        localWeiyunCheckAlbumConfigBean.c = paramArrayOfQConfItem.getInt("check_time");
        localWeiyunCheckAlbumConfigBean.d = paramArrayOfQConfItem.getInt("album_days");
        localWeiyunCheckAlbumConfigBean.e = paramArrayOfQConfItem.getInt("photos_limit");
        localWeiyunCheckAlbumConfigBean.f = paramArrayOfQConfItem.getString("tips");
        localWeiyunCheckAlbumConfigBean.g = paramArrayOfQConfItem.getString("jump_text");
        localWeiyunCheckAlbumConfigBean.h = paramArrayOfQConfItem.getString("t_show");
        localWeiyunCheckAlbumConfigBean.i = paramArrayOfQConfItem.getString("t_click");
        localWeiyunCheckAlbumConfigBean.j = paramArrayOfQConfItem.getString("t_close");
        localWeiyunCheckAlbumConfigBean.a = true;
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.WeiyunCheckAlbumConfigBean
 * JD-Core Version:    0.7.0.1
 */