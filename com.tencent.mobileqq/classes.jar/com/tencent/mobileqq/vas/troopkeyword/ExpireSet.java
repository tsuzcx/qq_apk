package com.tencent.mobileqq.vas.troopkeyword;

import com.tencent.qphone.base.util.QLog;
import java.util.HashSet;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;

public class ExpireSet
  extends HashSet<Long>
{
  public static ExpireSet fromJson(String paramString)
  {
    localExpireSet = new ExpireSet();
    if (paramString != null) {
      try
      {
        paramString = new JSONArray(paramString);
        int i = 0;
        while (i < paramString.length())
        {
          localExpireSet.add(Long.valueOf(paramString.getLong(i)));
          i += 1;
        }
        return localExpireSet;
      }
      catch (JSONException paramString)
      {
        QLog.e("TroopKeywordManager.troop.special_msg.keyword", 1, "fromJson: ", paramString);
      }
    }
  }
  
  public String toJson()
  {
    JSONArray localJSONArray = new JSONArray();
    Iterator localIterator = iterator();
    while (localIterator.hasNext()) {
      localJSONArray.put((Long)localIterator.next());
    }
    return localJSONArray.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.vas.troopkeyword.ExpireSet
 * JD-Core Version:    0.7.0.1
 */