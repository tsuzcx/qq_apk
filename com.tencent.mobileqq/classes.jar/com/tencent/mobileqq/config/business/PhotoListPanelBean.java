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
      if (i < j)
      {
        Object localObject = paramArrayOfQConfItem[i];
        if (localObject == null) {}
        for (;;)
        {
          i += 1;
          break;
          localObject = ((QConfItem)localObject).a;
          try
          {
            a(new JSONObject((String)localObject), localPhotoListPanelBean);
            if (QLog.isColorLevel()) {
              QLog.i("PhotoListPanelBean", 2, "parse: " + (String)localObject + " bean:" + localPhotoListPanelBean);
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
        }
      }
    }
    return localPhotoListPanelBean;
  }
  
  private static void a(JSONObject paramJSONObject, PhotoListPanelBean paramPhotoListPanelBean)
  {
    if (paramJSONObject.has("showMode")) {
      paramPhotoListPanelBean.a = paramJSONObject.optInt("showMode");
    }
  }
  
  public String toString()
  {
    return "PhotoListPanelBean{showMode=" + this.a + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.PhotoListPanelBean
 * JD-Core Version:    0.7.0.1
 */