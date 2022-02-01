package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class QQGameTeamConfBean
{
  public List<String> a = new ArrayList();
  
  public static QQGameTeamConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    localQQGameTeamConfBean = new QQGameTeamConfBean();
    try
    {
      int k = paramArrayOfQConfItem.length;
      int i = 0;
      while (i < k)
      {
        Object localObject = new JSONObject(paramArrayOfQConfItem[i].a);
        if (((JSONObject)localObject).has("teamAppKeys"))
        {
          localQQGameTeamConfBean.a.clear();
          localObject = ((JSONObject)localObject).optJSONArray("teamAppKeys");
          if ((localObject != null) && (((JSONArray)localObject).length() > 0))
          {
            int j = 0;
            while (j < ((JSONArray)localObject).length())
            {
              localQQGameTeamConfBean.a.add(((JSONArray)localObject).optString(j));
              j += 1;
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("QQGameTeamConfBean", 2, "onParsed teamKeys=" + localObject);
          }
        }
        i += 1;
      }
      return localQQGameTeamConfBean;
    }
    catch (Throwable paramArrayOfQConfItem)
    {
      QLog.e("QQGameTeamConfBean", 1, "parse error e=" + paramArrayOfQConfItem);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.QQGameTeamConfBean
 * JD-Core Version:    0.7.0.1
 */