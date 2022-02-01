package com.tencent.mobileqq.profilecard.base.utils;

import com.tencent.mobileqq.utils.dialogutils.QQCustomMenu;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

public class LongClickCopyData
{
  public List<LongClickCopyData.CopyItem> mDataList = new ArrayList(1);
  
  public void addCopyItem(String paramString1, String paramString2)
  {
    this.mDataList.add(new LongClickCopyData.CopyItem(paramString1, paramString2));
  }
  
  public void attachToMenu(QQCustomMenu paramQQCustomMenu)
  {
    if (paramQQCustomMenu != null)
    {
      paramQQCustomMenu.a();
      Iterator localIterator = this.mDataList.iterator();
      while (localIterator.hasNext()) {
        paramQQCustomMenu.a(2131365448, ((LongClickCopyData.CopyItem)localIterator.next()).mMenuTitle, 0);
      }
    }
  }
  
  public String getCopyContent(String paramString)
  {
    Iterator localIterator = this.mDataList.iterator();
    while (localIterator.hasNext())
    {
      LongClickCopyData.CopyItem localCopyItem = (LongClickCopyData.CopyItem)localIterator.next();
      if ((paramString != null) && (paramString.equals(localCopyItem.mMenuTitle))) {
        return localCopyItem.mCopyContent;
      }
    }
    return null;
  }
  
  public String toString()
  {
    return Arrays.toString(this.mDataList.toArray());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.profilecard.base.utils.LongClickCopyData
 * JD-Core Version:    0.7.0.1
 */