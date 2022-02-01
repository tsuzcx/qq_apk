package com.tencent.mobileqq.kandian.base.report;

import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class AppConfigInfoList
  implements Serializable
{
  public String actionName = "actKandianReportManyApps";
  public List<AppConfigInfo> list = new ArrayList();
  
  public String toString()
  {
    localStringBuilder = new StringBuilder();
    localStringBuilder.append("actionName = ");
    localStringBuilder.append(this.actionName);
    localStringBuilder.append("\nappConfigInfoList size = ");
    List localList = this.list;
    int j = 0;
    int i;
    if (localList != null) {
      i = localList.size();
    } else {
      i = 0;
    }
    localStringBuilder.append(i);
    localStringBuilder.append("\n");
    localStringBuilder = new StringBuilder(localStringBuilder.toString());
    try
    {
      if (this.list != null)
      {
        i = j;
        while (i < this.list.size())
        {
          localStringBuilder.append("appConfigInfo [ ");
          localStringBuilder.append(i);
          localStringBuilder.append(" ]: \n");
          localStringBuilder.append(((AppConfigInfo)this.list.get(i)).toString());
          i += 1;
        }
      }
      return localStringBuilder.toString();
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
      QLog.d("ReadInJoyDoingSomething", 1, "AppConfigInfoList toString failed.");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.kandian.base.report.AppConfigInfoList
 * JD-Core Version:    0.7.0.1
 */