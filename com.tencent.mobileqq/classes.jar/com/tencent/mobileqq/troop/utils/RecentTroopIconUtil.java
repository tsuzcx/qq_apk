package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import com.tencent.mobileqq.activity.recent.data.RecentItemTroopMsgData;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.honor.api.ITroopHonorService;
import com.tencent.mobileqq.troop.honor.config.TroopHonor;
import com.tencent.widget.SingleLineTextView.IconDrawableInfo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class RecentTroopIconUtil
{
  public static ArrayList<SingleLineTextView.IconDrawableInfo> a(QQAppInterface paramQQAppInterface, RecentItemTroopMsgData paramRecentItemTroopMsgData)
  {
    if (paramRecentItemTroopMsgData == null) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if (!a(paramRecentItemTroopMsgData.troopLuckyCharacter, localArrayList)) {
      a(paramQQAppInterface, paramRecentItemTroopMsgData.troopHonorStr, paramRecentItemTroopMsgData.troopHonorRich, localArrayList);
    }
    if (localArrayList.size() > 2) {
      return new ArrayList(localArrayList.subList(0, 2));
    }
    return localArrayList;
  }
  
  private static void a(QQAppInterface paramQQAppInterface, String paramString, byte paramByte, ArrayList<SingleLineTextView.IconDrawableInfo> paramArrayList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayList == null)) {}
    for (;;)
    {
      return;
      paramQQAppInterface = ((ITroopHonorService)paramQQAppInterface.getRuntimeService(ITroopHonorService.class, "")).convertToHonorList(paramString, Byte.valueOf(paramByte));
      if ((paramQQAppInterface != null) && (!paramQQAppInterface.isEmpty()))
      {
        Collections.sort(paramQQAppInterface);
        paramQQAppInterface = paramQQAppInterface.iterator();
        while (paramQQAppInterface.hasNext())
        {
          paramString = (TroopHonor)paramQQAppInterface.next();
          SingleLineTextView.IconDrawableInfo localIconDrawableInfo = new SingleLineTextView.IconDrawableInfo();
          localIconDrawableInfo.icon_static_url = paramString.b;
          paramArrayList.add(localIconDrawableInfo);
        }
      }
    }
  }
  
  private static boolean a(String paramString, ArrayList<SingleLineTextView.IconDrawableInfo> paramArrayList)
  {
    if ((TextUtils.isEmpty(paramString)) || (paramArrayList == null)) {
      return false;
    }
    SingleLineTextView.IconDrawableInfo localIconDrawableInfo = new SingleLineTextView.IconDrawableInfo();
    localIconDrawableInfo.icon_static_url = paramString;
    paramArrayList.add(localIconDrawableInfo);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.RecentTroopIconUtil
 * JD-Core Version:    0.7.0.1
 */