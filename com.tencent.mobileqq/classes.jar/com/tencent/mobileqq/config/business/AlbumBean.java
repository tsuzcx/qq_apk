package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class AlbumBean
{
  public int a = -1;
  public int b = -1;
  
  public static AlbumBean a(QConfItem[] paramArrayOfQConfItem)
  {
    AlbumBean localAlbumBean = new AlbumBean();
    if ((paramArrayOfQConfItem != null) && (paramArrayOfQConfItem.length > 0))
    {
      int j = paramArrayOfQConfItem.length;
      int i = 0;
      while (i < j)
      {
        Object localObject = paramArrayOfQConfItem[i];
        if (localObject != null)
        {
          localObject = ((QConfItem)localObject).b;
          try
          {
            a(new JSONObject((String)localObject), localAlbumBean);
          }
          catch (JSONException localJSONException)
          {
            localJSONException.printStackTrace();
          }
          if (QLog.isColorLevel())
          {
            StringBuilder localStringBuilder = new StringBuilder();
            localStringBuilder.append("parse: ");
            localStringBuilder.append((String)localObject);
            localStringBuilder.append(" bean:");
            localStringBuilder.append(localAlbumBean);
            QLog.i("AlbumBean", 2, localStringBuilder.toString());
          }
        }
        i += 1;
      }
    }
    return localAlbumBean;
  }
  
  private static void a(JSONObject paramJSONObject, AlbumBean paramAlbumBean)
  {
    if (paramJSONObject.has("troopFlashPicEnter")) {
      paramAlbumBean.a = paramJSONObject.optInt("troopFlashPicEnter");
    }
    if (paramJSONObject.has("c2cFlashPicEnter")) {
      paramAlbumBean.b = paramJSONObject.optInt("c2cFlashPicEnter");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("AlbumBean{troopFlashPicEnter=");
    localStringBuilder.append(this.a);
    localStringBuilder.append("c2cFlashPicEnter=");
    localStringBuilder.append(this.b);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.AlbumBean
 * JD-Core Version:    0.7.0.1
 */