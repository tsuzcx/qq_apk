package com.tencent.mobileqq.troop.aioapp;

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
      return localStringBuilder.toString();
    }
    localStringBuilder.append("[gray+ red*]");
    paramCollection = paramCollection.iterator();
    label41:
    TroopAIOAppInfo localTroopAIOAppInfo;
    if (paramCollection.hasNext())
    {
      localTroopAIOAppInfo = (TroopAIOAppInfo)paramCollection.next();
      if (localTroopAIOAppInfo.isGray) {
        localStringBuilder.append("+");
      }
      if (localTroopAIOAppInfo.redPoint) {
        localStringBuilder.append("*");
      }
      if (TextUtils.isEmpty(localTroopAIOAppInfo.name)) {
        break label117;
      }
      localStringBuilder.append(localTroopAIOAppInfo.name);
    }
    for (;;)
    {
      localStringBuilder.append(" ");
      break label41;
      break;
      label117:
      localStringBuilder.append("id:");
      localStringBuilder.append(localTroopAIOAppInfo.appid);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.aioapp.LogUtil
 * JD-Core Version:    0.7.0.1
 */