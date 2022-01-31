package com.tencent.mobileqq.config.operation;

import awbv;
import awdj;
import com.tencent.mobileqq.persistence.ConflictClause;
import com.tencent.mobileqq.persistence.uniqueConstraints;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@uniqueConstraints(clause=ConflictClause.REPLACE, columnNames="taskid")
public class QQOperationViopTipTask
  extends awbv
{
  public String adwords;
  public String begin;
  public String clickableWord;
  public String end;
  public int frequencyMessage;
  public int frequencyTime;
  public String keywordString;
  public int limitDayAIOCount;
  public int limitDayAIOShowCount;
  public int limitTotalAIOCount;
  public int limitTotalShowCount;
  public int linkOffset;
  @awdj
  public int taskid;
  public int tipType;
  public int uinType;
  public String url;
  
  public Date getBeginDate()
  {
    Object localObject = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    try
    {
      localObject = ((SimpleDateFormat)localObject).parse(this.begin);
      return localObject;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return null;
  }
  
  public Date getEndDate()
  {
    Object localObject = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    try
    {
      localObject = ((SimpleDateFormat)localObject).parse(this.end);
      return localObject;
    }
    catch (ParseException localParseException)
    {
      localParseException.printStackTrace();
    }
    return null;
  }
  
  public ArrayList<String> getKeywordList()
  {
    ArrayList localArrayList = new ArrayList();
    if ((this.keywordString != null) && (this.keywordString.length() > 0))
    {
      if (this.keywordString.contains("|")) {
        break label48;
      }
      localArrayList.add(this.keywordString);
    }
    for (;;)
    {
      return localArrayList;
      label48:
      String[] arrayOfString = this.keywordString.split("\\|");
      int i = 0;
      while (i < arrayOfString.length)
      {
        localArrayList.add(arrayOfString[i]);
        i += 1;
      }
    }
  }
  
  public boolean isBlueTipsTask()
  {
    return this.tipType == 1;
  }
  
  public boolean isGryTipsTask()
  {
    return this.tipType == 2;
  }
  
  public void setBeginTime(String paramString)
  {
    this.begin = paramString;
  }
  
  public void setEndTime(String paramString)
  {
    this.end = paramString;
  }
  
  public void setKeywordString(String paramString)
  {
    this.keywordString = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     com.tencent.mobileqq.config.operation.QQOperationViopTipTask
 * JD-Core Version:    0.7.0.1
 */