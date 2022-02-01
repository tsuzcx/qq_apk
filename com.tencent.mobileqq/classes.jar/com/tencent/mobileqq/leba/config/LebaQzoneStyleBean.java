package com.tencent.mobileqq.leba.config;

import android.text.TextUtils;
import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import org.json.JSONObject;

public class LebaQzoneStyleBean
{
  public int a = 0;
  public int b = 0;
  
  public static LebaQzoneStyleBean a(QConfItem[] paramArrayOfQConfItem)
  {
    LebaQzoneStyleBean localLebaQzoneStyleBean = new LebaQzoneStyleBean();
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (paramArrayOfQConfItem != null) {
      localObject1 = localObject2;
    }
    try
    {
      if (paramArrayOfQConfItem.length > 0) {
        localObject1 = paramArrayOfQConfItem[0].b;
      }
      if (TextUtils.isEmpty((CharSequence)localObject1))
      {
        QLog.i("LebaQzoneStyleBean", 1, "content is empty");
        return localLebaQzoneStyleBean;
      }
      paramArrayOfQConfItem = new JSONObject((String)localObject1);
      localLebaQzoneStyleBean.a = paramArrayOfQConfItem.optInt("gridstyle", 0);
      localLebaQzoneStyleBean.b = paramArrayOfQConfItem.optInt("sequenceadjust", 0);
      paramArrayOfQConfItem = new StringBuilder("parse config=");
      paramArrayOfQConfItem.append((String)localObject1);
      paramArrayOfQConfItem.append(",style=");
      paramArrayOfQConfItem.append(localLebaQzoneStyleBean.a);
      paramArrayOfQConfItem.append(",sequenceAdjust=");
      paramArrayOfQConfItem.append(localLebaQzoneStyleBean.b);
      QLog.i("LebaQzoneStyleBean", 1, paramArrayOfQConfItem.toString());
      return localLebaQzoneStyleBean;
    }
    catch (Exception paramArrayOfQConfItem)
    {
      QLog.i("LebaQzoneStyleBean", 1, "handleLebaConfig parse", paramArrayOfQConfItem);
    }
    return localLebaQzoneStyleBean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.leba.config.LebaQzoneStyleBean
 * JD-Core Version:    0.7.0.1
 */