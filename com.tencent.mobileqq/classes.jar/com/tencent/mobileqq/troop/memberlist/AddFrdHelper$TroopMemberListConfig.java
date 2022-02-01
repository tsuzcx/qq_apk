package com.tencent.mobileqq.troop.memberlist;

import android.text.TextUtils;
import com.tencent.mobileqq.qroute.QRoute;
import com.tencent.mobileqq.troop.api.troopmemberlist.ITroopMemberListActivityApi;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONObject;

public class AddFrdHelper$TroopMemberListConfig
{
  int jdField_a_of_type_Int = 0;
  final List<Long> jdField_a_of_type_JavaUtilList = new ArrayList(5);
  
  public AddFrdHelper$TroopMemberListConfig(String paramString)
  {
    try
    {
      paramString = ((ITroopMemberListActivityApi)QRoute.api(ITroopMemberListActivityApi.class)).getConfigContentForTag(paramString, "troop_member_list_config");
      if (paramString != null)
      {
        Object localObject = new JSONObject(paramString);
        this.jdField_a_of_type_Int = ((JSONObject)localObject).optInt("maxTroopMemberSize");
        localObject = ((JSONObject)localObject).optJSONArray("troopClassIdList");
        int i = 0;
        while ((localObject != null) && (i < ((JSONArray)localObject).length()))
        {
          this.jdField_a_of_type_JavaUtilList.add(Long.valueOf(((JSONArray)localObject).optLong(i)));
          i += 1;
        }
      }
      if (QLog.isColorLevel())
      {
        QLog.i("AddFrdHelper", 2, String.format("TroopMemberListConfig max: %s, idList: %s, config: %s", new Object[] { Integer.valueOf(this.jdField_a_of_type_Int), TextUtils.join(",", this.jdField_a_of_type_JavaUtilList), paramString }));
        return;
      }
    }
    catch (Throwable paramString)
    {
      paramString.printStackTrace();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.memberlist.AddFrdHelper.TroopMemberListConfig
 * JD-Core Version:    0.7.0.1
 */