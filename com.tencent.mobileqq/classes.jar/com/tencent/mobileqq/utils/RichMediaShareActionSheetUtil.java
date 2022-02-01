package com.tencent.mobileqq.utils;

import androidx.annotation.NonNull;
import java.util.ArrayList;

public class RichMediaShareActionSheetUtil
{
  public static ShareActionSheetBuilder.ActionSheetItem a(int paramInt, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = ShareActionSheetBuilder.ActionSheetItem.build(paramInt);
    paramArrayList.add(localActionSheetItem);
    return localActionSheetItem;
  }
  
  public static ShareActionSheetBuilder.ActionSheetItem a(int paramInt1, ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList, String paramString, int paramInt2)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = a(paramInt1, paramArrayList);
    paramArrayList = paramString;
    if (paramString == null) {
      paramArrayList = "";
    }
    localActionSheetItem.argus = paramArrayList;
    localActionSheetItem.firstLineCount = paramInt2;
    return localActionSheetItem;
  }
  
  public static void a(int paramInt1, int paramInt2, @NonNull ArrayList<ShareActionSheetBuilder.ActionSheetItem> paramArrayList)
  {
    ShareActionSheetBuilder.ActionSheetItem localActionSheetItem1 = ShareActionSheetBuilder.ActionSheetItem.build(paramInt1);
    paramInt1 = 0;
    while (paramInt1 < paramArrayList.size())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem2 = (ShareActionSheetBuilder.ActionSheetItem)paramArrayList.get(paramInt1);
      if ((localActionSheetItem2 != null) && (localActionSheetItem2.action == paramInt2))
      {
        paramArrayList.add(paramInt1, localActionSheetItem1);
        return;
      }
      paramInt1 += 1;
    }
    paramArrayList.add(localActionSheetItem1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     com.tencent.mobileqq.utils.RichMediaShareActionSheetUtil
 * JD-Core Version:    0.7.0.1
 */