package com.tencent.mobileqq.qqlive.data.anchor.sso;

import com.tencent.mobileqq.qqlive.data.common.QQLiveErrorMsg;
import java.util.ArrayList;
import java.util.Iterator;

public class QQLiveAnchorDataPullInfo
  extends QQLiveAnchorDataBase
{
  public int avType;
  public String defaultPlayUrl;
  public int isSwitch;
  public ArrayList<Integer> levelList;
  public int liveStat;
  public int pixelsX;
  public int pixelsY;
  public ArrayList<QQLiveAnchorDataStream> streams;
  public int sugLevel;
  
  public QQLiveAnchorDataPullInfo() {}
  
  public QQLiveAnchorDataPullInfo(QQLiveAnchorDataPullInfo paramQQLiveAnchorDataPullInfo)
  {
    super(paramQQLiveAnchorDataPullInfo);
    if (paramQQLiveAnchorDataPullInfo == null) {
      return;
    }
    this.isSwitch = paramQQLiveAnchorDataPullInfo.isSwitch;
    this.liveStat = paramQQLiveAnchorDataPullInfo.liveStat;
    this.sugLevel = paramQQLiveAnchorDataPullInfo.sugLevel;
    this.avType = paramQQLiveAnchorDataPullInfo.avType;
    this.pixelsX = paramQQLiveAnchorDataPullInfo.pixelsX;
    this.pixelsY = paramQQLiveAnchorDataPullInfo.pixelsY;
    Iterator localIterator;
    Object localObject;
    if (paramQQLiveAnchorDataPullInfo.streams != null)
    {
      this.streams = new ArrayList();
      localIterator = paramQQLiveAnchorDataPullInfo.streams.iterator();
      while (localIterator.hasNext())
      {
        localObject = (QQLiveAnchorDataStream)localIterator.next();
        this.streams.add(new QQLiveAnchorDataStream((QQLiveAnchorDataStream)localObject));
      }
    }
    if (paramQQLiveAnchorDataPullInfo.levelList != null)
    {
      this.levelList = new ArrayList();
      localIterator = paramQQLiveAnchorDataPullInfo.levelList.iterator();
      while (localIterator.hasNext())
      {
        localObject = (Integer)localIterator.next();
        this.levelList.add(new Integer(((Integer)localObject).intValue()));
      }
    }
    this.defaultPlayUrl = paramQQLiveAnchorDataPullInfo.defaultPlayUrl;
  }
  
  public QQLiveAnchorDataPullInfo(boolean paramBoolean, QQLiveErrorMsg paramQQLiveErrorMsg)
  {
    super(paramBoolean, paramQQLiveErrorMsg);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes11.jar
 * Qualified Name:     com.tencent.mobileqq.qqlive.data.anchor.sso.QQLiveAnchorDataPullInfo
 * JD-Core Version:    0.7.0.1
 */