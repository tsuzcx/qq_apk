package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONException;
import org.json.JSONObject;

public class PhotoListPanelBean
{
  public int a = -1;
  
  public static PhotoListPanelBean a(QConfItem[] paramArrayOfQConfItem)
  {
    PhotoListPanelBean localPhotoListPanelBean = new PhotoListPanelBean();
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
            a(new JSONObject((String)localObject), localPhotoListPanelBean);
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
            localStringBuilder.append(localPhotoListPanelBean);
            QLog.i("PhotoListPanelBean", 2, localStringBuilder.toString());
          }
        }
        i += 1;
      }
    }
    return localPhotoListPanelBean;
  }
  
  private static void a(JSONObject paramJSONObject, PhotoListPanelBean paramPhotoListPanelBean)
  {
    if (paramJSONObject.has("dragMode")) {
      paramPhotoListPanelBean.a = paramJSONObject.optInt("dragMode");
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("PhotoListPanelBean{dragMode=");
    localStringBuilder.append(this.a);
    localStringBuilder.append('}');
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PhotoListPanelBean
 * JD-Core Version:    0.7.0.1
 */