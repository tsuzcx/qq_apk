package com.tencent.mobileqq.troop.troopapps;

import android.text.TextUtils;
import com.tencent.mobileqq.troop.data.TroopAIOAppInfo;
import java.util.Collection;
import java.util.Iterator;

public class LogUtil
{
  public static String a(Collection<TroopAIOAppInfo> paramCollection)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (GroupUtil.a(paramCollection))
    {
      localStringBuilder.append("empty apps");
    }
    else
    {
      localStringBuilder.append("[gray+ red*]");
      paramCollection = paramCollection.iterator();
      while (paramCollection.hasNext())
      {
        TroopAIOAppInfo localTroopAIOAppInfo = (TroopAIOAppInfo)paramCollection.next();
        if (localTroopAIOAppInfo.isGray) {
          localStringBuilder.append("+");
        }
        if (localTroopAIOAppInfo.redPoint) {
          localStringBuilder.append("*");
        }
        if (!TextUtils.isEmpty(localTroopAIOAppInfo.name))
        {
          localStringBuilder.append(localTroopAIOAppInfo.name);
        }
        else
        {
          localStringBuilder.append("id:");
          localStringBuilder.append(localTroopAIOAppInfo.appid);
        }
        localStringBuilder.append(" ");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.troopapps.LogUtil
 * JD-Core Version:    0.7.0.1
 */