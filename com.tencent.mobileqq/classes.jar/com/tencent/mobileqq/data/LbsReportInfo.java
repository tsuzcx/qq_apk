package com.tencent.mobileqq.data;

import android.text.TextUtils;
import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.Iterator;

public class LbsReportInfo
  extends Entity
{
  public String content;
  
  public static ArrayList convert2StrList(ArrayList paramArrayList)
  {
    if ((paramArrayList == null) || (paramArrayList.isEmpty())) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      LbsReportInfo localLbsReportInfo = (LbsReportInfo)paramArrayList.next();
      if ((localLbsReportInfo != null) && (!TextUtils.isEmpty(localLbsReportInfo.content))) {
        localArrayList.add(localLbsReportInfo.content);
      }
    }
    return localArrayList;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     com.tencent.mobileqq.data.LbsReportInfo
 * JD-Core Version:    0.7.0.1
 */