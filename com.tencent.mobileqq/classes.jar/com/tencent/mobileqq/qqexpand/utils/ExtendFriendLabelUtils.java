package com.tencent.mobileqq.qqexpand.utils;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo;
import com.tencent.mobileqq.qqexpand.bean.feed.StrangerInfo.LabelInfo;
import com.tencent.mobileqq.qqexpand.feed.LabelInfo;
import java.util.ArrayList;
import java.util.List;

public class ExtendFriendLabelUtils
{
  public static LabelInfo a(StrangerInfo paramStrangerInfo, Context paramContext)
  {
    if (paramStrangerInfo == null) {
      return null;
    }
    if ((paramStrangerInfo.mGender != 1) && (paramStrangerInfo.mGender != 2) && (paramStrangerInfo.mAge == -1)) {
      return null;
    }
    LabelInfo localLabelInfo = new LabelInfo();
    int i;
    if (paramStrangerInfo.mGender == 2) {
      i = 0;
    } else {
      i = 1;
    }
    localLabelInfo.a = i;
    String str;
    if (paramStrangerInfo.mAge == -1) {
      str = "";
    } else {
      str = String.valueOf(paramStrangerInfo.mAge);
    }
    localLabelInfo.b = str;
    if ((paramStrangerInfo.mGender == 1) || (paramStrangerInfo.mGender == 2))
    {
      if (paramStrangerInfo.mGender == 2) {
        paramContext = paramContext.getResources().getDrawable(2130846579);
      } else {
        paramContext = paramContext.getResources().getDrawable(2130846580);
      }
      localLabelInfo.e = paramContext;
      if (paramStrangerInfo.mGender == 2) {
        paramContext = "#FF80BF";
      } else {
        paramContext = "#02B2DD";
      }
      localLabelInfo.c = paramContext;
      if (paramStrangerInfo.mGender == 2) {
        paramStrangerInfo = "#33FF80BF";
      } else {
        paramStrangerInfo = "#3300CAFC";
      }
      localLabelInfo.d = paramStrangerInfo;
    }
    return localLabelInfo;
  }
  
  public static LabelInfo b(StrangerInfo paramStrangerInfo, Context paramContext)
  {
    if (paramStrangerInfo == null) {
      return null;
    }
    LabelInfo localLabelInfo = new LabelInfo();
    localLabelInfo.a = 2;
    localLabelInfo.b = String.valueOf(paramStrangerInfo.mPopularity);
    localLabelInfo.c = "#8173FF";
    localLabelInfo.d = "#338173FF";
    localLabelInfo.e = paramContext.getResources().getDrawable(2130846581);
    return localLabelInfo;
  }
  
  public static List<LabelInfo> c(StrangerInfo paramStrangerInfo, Context paramContext)
  {
    if (paramStrangerInfo == null) {
      return null;
    }
    if (paramStrangerInfo.mLabelInfos != null)
    {
      if (paramStrangerInfo.mLabelInfos.size() <= 0) {
        return null;
      }
      ArrayList localArrayList = new ArrayList();
      String[] arrayOfString = paramContext.getResources().getStringArray(2130968662);
      paramContext = paramContext.getResources().getStringArray(2130968661);
      int i = 0;
      while (i < paramStrangerInfo.mLabelInfos.size())
      {
        LabelInfo localLabelInfo = new LabelInfo();
        localLabelInfo.e = null;
        localLabelInfo.a = 3;
        localLabelInfo.b = ((StrangerInfo.LabelInfo)paramStrangerInfo.mLabelInfos.get(i)).b;
        if (!TextUtils.isEmpty(localLabelInfo.b))
        {
          int j;
          if (TextUtils.isEmpty(localLabelInfo.b)) {
            j = 0;
          } else {
            j = localLabelInfo.b.charAt(0);
          }
          localLabelInfo.c = arrayOfString[(j % arrayOfString.length)];
          localLabelInfo.d = paramContext[(j % paramContext.length)];
          localArrayList.add(localLabelInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes22.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ExtendFriendLabelUtils
 * JD-Core Version:    0.7.0.1
 */