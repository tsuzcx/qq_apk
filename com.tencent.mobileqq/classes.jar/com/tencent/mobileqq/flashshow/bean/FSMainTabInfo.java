package com.tencent.mobileqq.flashshow.bean;

import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBStringField;
import qqcircle.QQCircleFeedBase.StTabInfo;

public class FSMainTabInfo
{
  public QQCircleFeedBase.StTabInfo a;
  
  public FSMainTabInfo(QQCircleFeedBase.StTabInfo paramStTabInfo)
  {
    this.a = paramStTabInfo;
  }
  
  public static FSMainTabInfo a(QQCircleFeedBase.StTabInfo paramStTabInfo)
  {
    return new FSMainTabInfo(paramStTabInfo);
  }
  
  public String a()
  {
    return this.a.tabName.get();
  }
  
  public int b()
  {
    return this.a.sourceType.get();
  }
  
  public String c()
  {
    return this.a.attachInfo.get();
  }
  
  public String d()
  {
    return this.a.serverCallee.get();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.flashshow.bean.FSMainTabInfo
 * JD-Core Version:    0.7.0.1
 */