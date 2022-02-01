package com.tencent.mobileqq.config.business;

import com.tencent.mobileqq.config.QConfItem;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class TroopMemRecommendConfBean
{
  public int a;
  public List<Long> a;
  public int b;
  public int c = 0;
  
  public TroopMemRecommendConfBean()
  {
    this.jdField_a_of_type_JavaUtilList = new ArrayList();
  }
  
  public static TroopMemRecommendConfBean a(QConfItem[] paramArrayOfQConfItem)
  {
    TroopMemRecommendConfBean localTroopMemRecommendConfBean = new TroopMemRecommendConfBean();
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
            localObject = new JSONObject((String)localObject);
            if (((JSONObject)localObject).has("gtcSwitch")) {
              localTroopMemRecommendConfBean.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("gtcSwitch");
            }
            if (((JSONObject)localObject).has("groupMemberCount")) {
              localTroopMemRecommendConfBean.b = ((JSONObject)localObject).optInt("groupMemberCount");
            }
            if (((JSONObject)localObject).has("allGroupTypesEnable")) {
              localTroopMemRecommendConfBean.c = ((JSONObject)localObject).optInt("allGroupTypesEnable");
            }
            if (((JSONObject)localObject).has("enabledGroupTypes"))
            {
              localObject = ((JSONObject)localObject).optJSONArray("enabledGroupTypes");
              localTroopMemRecommendConfBean.jdField_a_of_type_JavaUtilList.addAll(a((JSONArray)localObject));
            }
          }
          catch (JSONException localJSONException)
          {
            for (;;)
            {
              localJSONException.printStackTrace();
            }
          }
          if (QLog.isColorLevel()) {
            QLog.d("TroopMemberRecommend.ConfBean", 2, "parse: " + localTroopMemRecommendConfBean.toString());
          }
        }
      }
    }
    return localTroopMemRecommendConfBean;
  }
  
  private static List<Long> a(JSONArray paramJSONArray)
  {
    ArrayList localArrayList = new ArrayList();
    if (paramJSONArray != null)
    {
      int j = paramJSONArray.length();
      int i = 0;
      for (;;)
      {
        if (i < j) {
          try
          {
            localArrayList.add(Long.valueOf(paramJSONArray.getLong(i)));
            i += 1;
          }
          catch (Exception localException)
          {
            for (;;)
            {
              QLog.e("TroopMemberRecommend.ConfBean", 2, "TroopMemRecommendConfBean processJsonArray error", localException);
            }
          }
        }
      }
    }
    return localArrayList;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    localStringBuilder.append("TroopMemRecommendConfBean [gtcSwitch: ").append(this.jdField_a_of_type_Int).append(", groupMemberCount: ").append(this.b).append(", allGroupTypesEnable: ").append(this.c).append(", enabledGroupTypes: ").append(this.jdField_a_of_type_JavaUtilList.toString()).append("]");
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.business.TroopMemRecommendConfBean
 * JD-Core Version:    0.7.0.1
 */