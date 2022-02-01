package com.tencent.mobileqq.filemanager.fileassistant.aio;

import android.app.Activity;
import android.content.Context;
import com.tencent.mobileqq.activity.aio.core.BaseChatPie;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msgforward.AIOShareActionSheet;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder.ActionSheetItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.os.MqqHandler;

public class DatalineAIOShareActionSheet
  extends AIOShareActionSheet
{
  private static final int[] a = { 9, 25, 50, 26 };
  
  public DatalineAIOShareActionSheet(QQAppInterface paramQQAppInterface, Context paramContext, Activity paramActivity, BaseChatPie paramBaseChatPie, MqqHandler paramMqqHandler)
  {
    super(paramQQAppInterface, paramContext, paramActivity, paramBaseChatPie, paramMqqHandler);
  }
  
  private ArrayList<ShareActionSheetBuilder.ActionSheetItem> a(List<ShareActionSheetBuilder.ActionSheetItem> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      ShareActionSheetBuilder.ActionSheetItem localActionSheetItem = (ShareActionSheetBuilder.ActionSheetItem)paramList.next();
      if (!a(localActionSheetItem.action)) {
        localArrayList.add(localActionSheetItem);
      }
    }
    return localArrayList;
  }
  
  private boolean a(int paramInt)
  {
    boolean bool2 = false;
    int i = 0;
    for (;;)
    {
      boolean bool1 = bool2;
      if (i < a.length)
      {
        if (paramInt == a[i]) {
          bool1 = true;
        }
      }
      else {
        return bool1;
      }
      i += 1;
    }
  }
  
  public List<ShareActionSheetBuilder.ActionSheetItem>[] a(Context paramContext)
  {
    paramContext = super.a(paramContext);
    return (List[])new ArrayList[] { a(paramContext[0]), a(paramContext[1]) };
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.filemanager.fileassistant.aio.DatalineAIOShareActionSheet
 * JD-Core Version:    0.7.0.1
 */