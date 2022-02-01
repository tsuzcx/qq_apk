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
    localLabelInfo.jdField_a_of_type_Int = i;
    String str;
    if (paramStrangerInfo.mAge == -1) {
      str = "";
    } else {
      str = String.valueOf(paramStrangerInfo.mAge);
    }
    localLabelInfo.jdField_a_of_type_JavaLangString = str;
    if ((paramStrangerInfo.mGender == 1) || (paramStrangerInfo.mGender == 2))
    {
      if (paramStrangerInfo.mGender == 2) {
        paramContext = paramContext.getResources().getDrawable(2130845139);
      } else {
        paramContext = paramContext.getResources().getDrawable(2130845140);
      }
      localLabelInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext;
      if (paramStrangerInfo.mGender == 2) {
        paramContext = "#FF80BF";
      } else {
        paramContext = "#02B2DD";
      }
      localLabelInfo.b = paramContext;
      if (paramStrangerInfo.mGender == 2) {
        paramStrangerInfo = "#33FF80BF";
      } else {
        paramStrangerInfo = "#3300CAFC";
      }
      localLabelInfo.c = paramStrangerInfo;
    }
    return localLabelInfo;
  }
  
  public static List<LabelInfo> a(StrangerInfo paramStrangerInfo, Context paramContext)
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
      String[] arrayOfString = paramContext.getResources().getStringArray(2130968660);
      paramContext = paramContext.getResources().getStringArray(2130968659);
      int i = 0;
      while (i < paramStrangerInfo.mLabelInfos.size())
      {
        LabelInfo localLabelInfo = new LabelInfo();
        localLabelInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = null;
        localLabelInfo.jdField_a_of_type_Int = 3;
        localLabelInfo.jdField_a_of_type_JavaLangString = ((StrangerInfo.LabelInfo)paramStrangerInfo.mLabelInfos.get(i)).jdField_a_of_type_JavaLangString;
        if (!TextUtils.isEmpty(localLabelInfo.jdField_a_of_type_JavaLangString))
        {
          int j;
          if (TextUtils.isEmpty(localLabelInfo.jdField_a_of_type_JavaLangString)) {
            j = 0;
          } else {
            j = localLabelInfo.jdField_a_of_type_JavaLangString.charAt(0);
          }
          localLabelInfo.b = arrayOfString[(j % arrayOfString.length)];
          localLabelInfo.c = paramContext[(j % paramContext.length)];
          localArrayList.add(localLabelInfo);
        }
        i += 1;
      }
      return localArrayList;
    }
    return null;
  }
  
  public static LabelInfo b(StrangerInfo paramStrangerInfo, Context paramContext)
  {
    if (paramStrangerInfo == null) {
      return null;
    }
    LabelInfo localLabelInfo = new LabelInfo();
    localLabelInfo.jdField_a_of_type_Int = 2;
    localLabelInfo.jdField_a_of_type_JavaLangString = String.valueOf(paramStrangerInfo.mPopularity);
    localLabelInfo.b = "#8173FF";
    localLabelInfo.c = "#338173FF";
    localLabelInfo.jdField_a_of_type_AndroidGraphicsDrawableDrawable = paramContext.getResources().getDrawable(2130845141);
    return localLabelInfo;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes15.jar
 * Qualified Name:     com.tencent.mobileqq.qqexpand.utils.ExtendFriendLabelUtils
 * JD-Core Version:    0.7.0.1
 */